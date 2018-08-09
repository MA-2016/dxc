package com.mobileai.dxc.service;

public interface PictureService {

    /**
     * 说明：对主页图片的操作，主页图片有默认图片，商家可以选择默认图片，也可以自己上传图片
     * */
    public  void updateIndexPicture(int sellerId,String picpath);
    public  String[] provideDefaultIndexPicture();

    /**
     * 说明：每项服务都可以展示0-10张照片
     * */
    public  void InitServicePicture(int serviceId,int sellerId,String[] pictures);
    public  void deleteServicePicture(int serviceId,int sellerId,String picture);
    public  void updateServicePicture(int serviceId,int sellerId,String prepicture,String nowpicture);
    public  void addServicePicture(int serviceId,int sellerId,String picture);
}
