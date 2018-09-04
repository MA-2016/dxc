package com.mobileai.dxc.controller;

import com.mobileai.dxc.db.pojo.Provision;
import com.mobileai.dxc.service.ProvisionService;
import com.mobileai.dxc.util.Result;
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
    @PostMapping("/addservice")
    public int addService(@RequestParam int sellerId, @RequestParam String name, @RequestParam String description, @RequestParam float price, @RequestParam float prePrice) {
        return provisionService.addService(sellerId, name, description, price, prePrice);
    }

    /**
     * *
     * @Param sellerId:
     * @Param provision：
     * * @return 返回删除是否成功
     **/
    @DeleteMapping("/deleteservice")
    public String  deleteService(@RequestParam int sellerId, @RequestParam int serviceId) {
        return provisionService.deleteService(sellerId, serviceId).toString();
    }
    /**
     * *
     * @Param sellerId:
     * @Param provision：
     * * @return 返回添加是否成功
     **/
    @PutMapping("/updateservice")
    public String updateService(@RequestParam int sellerId,@RequestParam int serviceId,@RequestBody  Provision provision)
    {
        return  provisionService.updateService(sellerId,serviceId,provision).toString();
    }


    /**
     * *
     * @Param sellerId:
     * @Param pictureId：
     * * @return 返回删除是否成功
     **/
    @DeleteMapping("/picture/deletepicture")
    public String deleteServicePicture( @RequestParam int serviceId,@RequestParam  int pictureId)
    {return provisionService.deleteServicePicture(serviceId, pictureId).toString();}

    /**
     * *
     * @Param sellerId:
     * @Param thumbnai：传输上来图片文件
     * * @return 返回添加照片的存储路径
     **/
    @PostMapping("/picture/addpicture")
    public String addServicePicture(@RequestParam int serviceId,@RequestParam  MultipartFile thumbnai){
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
