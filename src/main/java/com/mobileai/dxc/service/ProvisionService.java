package com.mobileai.dxc.service;

import com.mobileai.dxc.db.pojo.Picture;
import com.mobileai.dxc.db.pojo.Provision;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;


public interface ProvisionService {


   int addSerive(int sellerId,String  name,String description,float price,float prePrice);

   /**当服务有人预定成功时，服务信息不会立即删除，
    * 服务状态会变成下架，不接受任何预定。
    * 当服务人数为0时，服务信息被删除。*/
   boolean deleteService(int serllerId,int serviceId);

   /**更新服务信息,照片信息更新另外的接口处理*/
   boolean  updateService(int sellerId,Provision provision);

   boolean deleteServicePicture(int serviceId, int pictureId);
   //返回添加照片的路径
   String addServicePicture(int serviceId, MultipartFile thumbnai);
   List<Picture> selectAllServicePicture(int ServiceId);

   /**显示一个商家的所有信息*/
   List<Provision> showAllService(int sellerId);

   /**按照关键字找出最合适的服务**/
   List<Provision> findPreferService();
}
