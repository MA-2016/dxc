package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.mapper.ServiceMapper;
import com.mobileai.dxc.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mobileai.dxc.util.IntStringUtils.addSubString;
import static com.mobileai.dxc.util.IntStringUtils.deleteSubString;
import static com.mobileai.dxc.util.IntStringUtils.mergeStringArray;
import static com.mobileai.dxc.util.ProvideDefaultPicture.provideDefaultIndexPictureUrls;


@Service
public class PictureServiceImple implements PictureService {

    @Autowired
    SellerMapper sellerMapper;
    @Autowired
    ServiceMapper serviceMapper;


    @Override
    public void updateIndexPicture(int sellerId, String picPath) {
        sellerMapper.updatePictureById(sellerId,picPath);
    }

    @Override
    public  String[] provideDefaultIndexPicture() {
        return provideDefaultIndexPictureUrls();
    }

    @Override
    public void InitServicePicture(int serviceId, int sellerId, String[] picture) {

        String pictures=mergeStringArray(picture);
        serviceMapper.updatePictureById(serviceId,sellerId,pictures);

    }

    @Override
    public void deleteServicePicture(int serviceId, int sellerId, String picture) {
        //从数据库取得所有picture字符串
        String allPicture=serviceMapper.selectPictureById(serviceId,sellerId);
        //删除子字符串
        allPicture=deleteSubString(picture,allPicture);
        //更新数据库picture字段
        serviceMapper.updatePictureById(serviceId,sellerId,allPicture);

    }

    @Override
    public void addServicePicture(int serviceId, int sellerId, String picture) {
        //从数据库取出所有的picture；
        String allPicture=serviceMapper.selectPictureById(serviceId,sellerId);

        //加入picture
        allPicture=addSubString(picture,allPicture);
        //更新数据库picture字段
        serviceMapper.updatePictureById(serviceId,sellerId,allPicture);

    }
    @Override
    public void updateServicePicture(int serviceId, int sellerId, String prepicture,String nowpicture) {
        //从数据库取出所有的picture；
        String allPicture=serviceMapper.selectPictureById(serviceId,sellerId);

        //调用方法吧pre换成now
        allPicture=deleteSubString(prepicture,allPicture);
        allPicture=addSubString(nowpicture,allPicture);
        //更新数据库picture字段
        serviceMapper.updatePictureById(serviceId,sellerId,allPicture);

    }

}
