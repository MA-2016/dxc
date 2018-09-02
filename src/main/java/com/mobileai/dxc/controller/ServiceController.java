package com.mobileai.dxc.controller;

import com.mobileai.dxc.db.pojo.Provision;
import com.mobileai.dxc.service.ProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ProvisionService provisionService;

    /**
     * @return 返回创建的serviceId
     * @Param sellerId:
     * @Param provision：
     **/
    @PostMapping("/adddservice")
    public int addServive(@RequestParam int sellerId, @RequestParam String name, @RequestParam String description, @RequestParam float price, @RequestParam float prePrice) {
        return provisionService.addSerive(sellerId, name, description, price, prePrice);
    }

    /**
     * *
     * @Param sellerId:
     * @Param provision：
     * * @return 返回删除是否成功
     **/
    @DeleteMapping("/deleteservice")
    public boolean deleteService(@RequestParam int serllerId, @RequestParam int serviceId) {
        return provisionService.deleteService(serllerId, serviceId);
    }
    /**
     * *
     * @Param sellerId:
     * @Param provision：
     * * @return 返回添加是否成功
     **/
    @PutMapping("/updateservice")
    public boolean updateService(@RequestParam int sellerId,@RequestParam  Provision provision)
    {
        return  provisionService.updateService(sellerId,provision);
    }


    /**
     * *
     * @Param sellerId:
     * @Param pictureId：
     * * @return 返回删除是否成功
     **/
    @DeleteMapping("/pictrue/deletepicture")
    public boolean deleteServicePicture( @RequestParam int serviceId,@RequestParam  int pictureId)
    {return provisionService.deleteServicePicture(serviceId, pictureId);}

    /**
     * *
     * @Param sellerId:
     * @Param thumbnai：传输上来图片文件
     * * @return 返回添加照片的存储路径
     **/
    @PostMapping("/pictrue/addpicture")
    String addServicePicture(@RequestParam int serviceId,@RequestParam  MultipartFile thumbnai){
        return provisionService.addServicePicture(serviceId, thumbnai);
    }
    /**
     * *
     * @Param sellerId:
     * * @return  返回一个商家的所有服务
     **/
    @GetMapping("/showallservice")
    public List<Provision> showAllServices(int sellerId)
    {
        return  provisionService.showAllService(sellerId);
    }
    /**
     * *
     * @Param sellerId:
     * * @return  返回一个按照选优的顺序存储的服务信息
     **/
    @GetMapping("/findpreferservice")
    List<Provision> findPreferService(){
        return provisionService.findPreferService();
    }
}
