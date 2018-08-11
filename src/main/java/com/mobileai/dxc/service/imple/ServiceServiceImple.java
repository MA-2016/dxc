package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.mapper.ServiceMapper;
import com.mobileai.dxc.service.ServiceService;
import com.mobileai.dxc.db.pojo.Service ;
import org.springframework.beans.factory.annotation.Autowired;

import static com.mobileai.dxc.util.IntStringUtils.deleteIntFormString;
import static com.mobileai.dxc.util.IntStringUtils.intArray2String;
//todo :处理可能出现的exception后，改正返回值

@org.springframework.stereotype.Service
public class ServiceServiceImple implements ServiceService {

    @Autowired
    ServiceMapper serviceMapper;
    @Autowired
    SellerMapper sellerMapper;


    @Override
    public boolean  serviceInit(Service[] services, int sellerId) {

        int[] ServiceIntArray =new int[services.length];
        int i=0;

       //初始化service表
        for(Service service :services)
        {
         serviceMapper.addService(service.getServiceId(),sellerId,service.getDescription(),service.getPrice());
            ServiceIntArray[i]=service.getServiceId();
            i++;
        }

        //初始化seller表
        String serviceStr =intArray2String(ServiceIntArray);
        sellerMapper.updateServiceById(sellerId,serviceStr);

        return true;
    }

    @Override
    public boolean updateService(int serviceId, int sellerId, String description) {

        serviceMapper.updateDescriptionById(serviceId,sellerId,description);

        return true;
    }

    @Override
    public boolean updateService(int serviceId, int sellerId, double price) {

        serviceMapper.updatePriceById(serviceId,sellerId,price);
        return true;

    }

    public boolean updateService(int serviceId, int sellerId, double price, String description){

        serviceMapper.updateDescriptionById(serviceId,sellerId,description);
        serviceMapper.updatePriceById(serviceId,sellerId,price);
        return true;

    }

    @Override
    public boolean deleteService(int serviceId, int sellerId) {
        //取得原来的字符串
        String preServiceStr = sellerMapper.selectServiceById( sellerId );
        String ServiceStr = deleteIntFormString( serviceId , preServiceStr );

        // 修改数据库seller表
        sellerMapper.updateServiceById( sellerId , ServiceStr);

        //修改数据库service表
        serviceMapper.deleteServiceById(serviceId,sellerId);

        return true;

    }

    @Override
    public boolean addService(int serviceId, int sellerId, String description, double price) {

        serviceMapper.addService(serviceId,sellerId,description,price);

        return true;

    }
}
