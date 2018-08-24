package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.PictureMapper;
import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.mapper.ServiceMapper;
import com.mobileai.dxc.db.pojo.Picture;
import com.mobileai.dxc.db.pojo.Provision;
import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.service.ProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

import static com.mobileai.dxc.util.DeleteDirectory.deleteDirectory;
import static com.mobileai.dxc.util.ImageUtil.generateThumbnail;
import static com.mobileai.dxc.util.IntStringUtils.addSubString;
import static com.mobileai.dxc.util.IntStringUtils.deleteSubString;
import static com.mobileai.dxc.util.PathUtil.getImgBasePath;

@Service
public class ProvisionServiceImple implements ProvisionService {

    @Autowired
    SellerMapper sellerMapper;
    @Autowired
    ServiceMapper serviceMapper;
    @Autowired
    PictureMapper pictureMapper;




    @Override
    public int addSerive(int sellerId,String  name,String description,float price,float prePrice) {
        Provision provision = new Provision();
        provision.setSellerId(sellerId);
        provision.setName(name);
        provision.setDescription(description);
        provision.setPrice(price);
        provision.setPrePrice(prePrice);
        provision.setStatus(0);
        provision.setOrderNum(0);

        String sellerService=sellerMapper.selectServiceById(sellerId);
        provision.setSellerId(sellerId);
        //在service表更新该服务信息

        serviceMapper.addService(provision);

        int serviceId = provision.getServiceId();
        sellerService=addSubString(serviceId+"",sellerService);
        Seller s=new Seller();
        s.setSellerId(sellerId);
        s.setService(sellerService);
        sellerMapper.updateSellerById(s);

        return serviceId;

    }

    @Override
    @Transactional
    public boolean deleteService(int sellerId, int serviceId) {

        int status =serviceMapper.selectStatusById(serviceId);
        if(status ==0)
        {throw  new RuntimeException("该商品正在审核,商品不能下架");}
        if(status ==2)
        {throw  new RuntimeException("该商品已经下架");}
        if(status ==1)
        {
            Provision provision =new Provision();
            provision.setServiceId(serviceId);
            provision.setStatus(2);
            serviceMapper.updateServiceById(provision);
            int orderNum;
            orderNum=serviceMapper.selectOrderNumById(serviceId);
            if(orderNum ==0)//todo:每次服务后，odernum-1后检查状态是下架，就删除服务
            {
                String  pictureDirPath =serviceMapper.selectPictureById(serviceId);
                System.out.println("pictureFilePath"+pictureDirPath);
                deleteDirectory(pictureDirPath);

                int effcetNum= serviceMapper.deleteById(serviceId);
                if(effcetNum<1) throw new RuntimeException("删除服务失败");

                String sellerService =sellerMapper.selectServiceById(sellerId);
                sellerService =deleteSubString(serviceId+"",sellerService);
                Seller seller =new Seller();
                seller.setSellerId(sellerId);
                seller.setService(sellerService);
                sellerMapper.updateSellerById(seller);

            }
        }
        return  false;
    }

    @Override
        public boolean updateService(int serviceId, Provision provision) {

        provision.setServiceId(serviceId);
        serviceMapper.updateServiceById(provision);

        return false;
    }


    @Override
    public boolean deleteServicePicture(int serviceId, int pictureId) {
        //确认id一致
        Picture picture=pictureMapper.selectById(pictureId);
        if(serviceId != picture.getServiceId())
        {
            throw  new RuntimeException("该服务无此照片！");
        }
        //删除照片
        File pictureFile =new File(picture.getPicturePath());
        pictureFile.delete();

       int effetNum = pictureMapper.deletePictureByid(pictureId);
        if(effetNum < 1)
        {
            throw  new RuntimeException("删除照片失败！");
        }
        return false;
    }

    @Override
    public String addServicePicture(int serviceId, MultipartFile thumbnai) {
        //把照片存储到合适的位置
        Provision provision =serviceMapper.getServiceById(serviceId);
        //用服务编号作为照片的目录名
        String relativeStorePath=generateThumbnail(thumbnai,provision.getServiceId()+"");

        //把照片id仿照照片表
        Picture picture =new Picture();
        picture.setPicturePath(relativeStorePath);
        picture.setServiceId(serviceId);
        int picId =pictureMapper.addPicture(picture);

        //把照片目录更新到service表
        provision.setPicture(getImgBasePath()+provision.getServiceId()+"");
        serviceMapper.updateServiceById(provision);

        return relativeStorePath;
    }

    @Override
    public List<Picture>  selectAllServicePicture(int serviceId)
    {
        return pictureMapper.selectPictureByServiceId(serviceId);
    }

    @Override
    public List<Provision> showAllService(int sellerId) {
        return serviceMapper.selectServiceBySellerId(sellerId);
    }

    @Override
    public List<Provision> findPreferService() {
        return null;
    }
}
