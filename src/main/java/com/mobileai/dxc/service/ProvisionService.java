package com.mobileai.dxc.service;

import com.mobileai.dxc.db.pojo.Picture;
import com.mobileai.dxc.db.pojo.Provision;
import com.mobileai.dxc.util.Result;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;


public interface ProvisionService {

   /**
    * 添加一项商品（service）
    * @return :返回添加的service的id
    * @param sellerId 商家编号
    * @param  name 商品名
    * @param  description  商品描述
    * @param price 商品现价
    * @param prePrice 商品原价，可以和现价相同
    * */
   int addService(int sellerId, String  name, String description, float price, float prePrice);

   /**当服务有人预定成功时，服务信息不会立即删除，
    * 服务状态会变成下架，不接受任何预定。
    * 当服务人数为0时，服务信息被删除。
    *
    * @return 操作状态
    * @param  serllerId 商家编号
    * @param  serviceId 商品名称*/
   Result deleteService(int serllerId, int serviceId);

   //**更新服务信息,照片信息更新另外的接口处理*/
   /**
    * @return 操作状态
    * @param sellerId 商家编号
    * @param  serviceId 商品编号
    * @param  provision 一个商品实体类，设定要改变的部分既可以了
    * */
   Result  updateService(int sellerId,int serviceId,Provision provision);

   /**
    * @return  操作状态
    * @param serviceId 商品编号
    * @param  pictureId 照片编号
    * */
   Result deleteServicePicture(int serviceId, int pictureId);

   /**
    * @return 返回添加照片的路径
    * @param  serviceId 商品编号
    * @param thumbnai 传输上来的商品图片文件
    * */
   String addServicePicture(int serviceId, MultipartFile thumbnai);

   /**显示一个商品的所有照片
    * @return 一个商品所有的照片
    * @param serviceId 商品编号
    * */
   List<Picture> selectAllServicePicture(int serviceId);

   /**显示一个商家的所有商品
    * @return  一个商家的所有商品
    * @param sellerId 商家编号
    * */
   List<Provision> showAllService(int sellerId);

   /**按照关键字找出最合适的服务**/
   List<Provision> findPreferService();
}
