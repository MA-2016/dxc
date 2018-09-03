package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.PictureMapper;
import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.mapper.ServiceMapper;
import com.mobileai.dxc.db.pojo.Picture;
import com.mobileai.dxc.db.pojo.Provision;
import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.service.ProvisionService;
import com.mobileai.dxc.util.Result;
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
import static com.mobileai.dxc.util.IntStringUtils.replaceString;
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
    @Transactional
    public int addService(int sellerId, String  name, String description, float price, float prePrice) {
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
    public Result deleteService(int sellerId, int serviceId) {

        int status =serviceMapper.selectStatusById(serviceId);

        //商品已经下架
        if(status ==2)
        {
            return new Result(100,"商品已经下架",null);
        }

        //商品状态正常1 商品在审核中0
        if(status ==1||status ==0)
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
                if(pictureDirPath != null)
                {
                    deleteDirectory(pictureDirPath);
                }

                try{
                    int effectNum= serviceMapper.deleteById(serviceId);
                    if(effectNum < 1)
                    {
                        throw  new Exception("服务删除失败");
                    }
                }catch(Exception e)
                {
                    return  new Result(100,"删除服务失败，可联系维护人员进行咨询",null);
                }

                String sellerService =sellerMapper.selectServiceById(sellerId);
                sellerService =deleteSubString(serviceId+"",sellerService);
                Seller seller =new Seller();
                seller.setSellerId(sellerId);
                seller.setService(sellerService);
                sellerMapper.updateSellerById(seller);
                return  new Result(200,"服务删除成功",null);
            }
            return  new Result(100,"该商品有订单未处理","未处理商品数为"+serviceMapper.selectOrderNumById(serviceId));
        }
        else return  new Result(100,"商品状态异常，请联系维护人员进行咨询");
    }

    @Override
    @Transactional
    public Result updateService(int sellerId, int serviceId, Provision provision) {

        provision.setServiceId(serviceId);
        if(sellerId != serviceMapper.selectSellerIdByserviceId(serviceId) )
        {
            return new Result(100,"更新服务，参数传输错误",null);
        }

       int effectNum = serviceMapper.updateServiceById(provision);
        //test :是影响行数 还是id
        System.out.println("effectNum"+effectNum);

        if(effectNum < 1){ return  new Result(100,"更新服务失败",null);}
        else{return new Result(200,"更新服务成功",serviceMapper.getServiceById(serviceId));}
    }


    @Override
    @Transactional
    public Result deleteServicePicture(int serviceId, int pictureId) {
        //确认id一致
        Picture picture=pictureMapper.selectById(pictureId);
        if(serviceId != picture.getServiceId())
        {
            return new Result(100,"传入数据错误",null);
        }
        //删除照片
        String dirPath =serviceMapper.selectPictureById(serviceId);
        File pictureFile =new File(dirPath+System.getProperty("file.separator")+picture.getPicturePath());

        System.out.println("file"+dirPath+System.getProperty("file.separator")+picture.getPicturePath());
        pictureFile.delete();

       int effectNum = pictureMapper.deletePictureByid(pictureId);
        if(effectNum < 1)
        {
            return new Result(100,"删除照片失败",null);
        }
        else{
            System.out.println("goes here");
            return  new Result(200,"删除照片成功",null); }
    }

    @Override
    @Transactional
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
    @Transactional
    public List<Picture>  selectAllServicePicture(int serviceId)
    {
        return pictureMapper.selectPictureByServiceId(serviceId);
    }

    @Override
    @Transactional
    public List<Provision> showAllService(int sellerId) {
        return serviceMapper.selectServiceBySellerId(sellerId);
    }

    @Override
    @Transactional
    public List<Provision> findPreferService() {
        return null;
    }
}
