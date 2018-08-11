package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.IndentMapper;
import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.mapper.UserMapper;
import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.service.SellerService;
import com.mobileai.dxc.util.Result;
import com.mobileai.dxc.util.SendMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mobileai.dxc.util.StatusCode.SUCCESS;
import static com.mobileai.dxc.util.StatusUtils.getOrderAcceptStatus;
import static com.mobileai.dxc.util.StatusUtils.getOrderRefuseStatus;

@Service
public class SellerServiceImple implements SellerService {

    @Autowired
     private UserMapper userMapper;
    @Autowired
    private IndentMapper indentMapper;
    @Autowired
    private SellerMapper sellerMapper;




    @Override
    public void notifyNewOrder(Order order) {
        String sellerPhone;
        System.out.println(" in notifyNewOrder SellerId"+order.getSellerId());
        sellerPhone =sellerMapper.selectPhoneById(order.getSellerId());


        System.out.println("sellerPhone"+sellerPhone);
        SendMsgUtils.sendMsgTo(sellerPhone,2);

    }

    @Override
    public Result acceptOrder(int oid) {
        String userPhone;
        int Statuscode;

        Statuscode=indentMapper.selectStatusByOrderid(oid);
        Statuscode=getOrderAcceptStatus(Statuscode);
        indentMapper.updateOrderStatus(oid,Statuscode);

        int uid=indentMapper.selectUseridByOrderid(oid);
        userPhone=userMapper.selectPhoneById(uid);
        System.out.println("userPhone"+userPhone);
        SendMsgUtils.sendMsgTo(userPhone,3);
        return new Result(SUCCESS);
    }

    @Override
    public Result refuseOrder(int oid, String reason) {
        String userPhone;
        int Statuscode;

        Statuscode=indentMapper.selectStatusByOrderid(oid);
        Statuscode=getOrderRefuseStatus(Statuscode);
        indentMapper.updateOrderStatus(oid,Statuscode);

        indentMapper.updateRefuseReasonByOrderid(reason,oid);

        int uid=indentMapper.selectUseridByOrderid(oid);
        userPhone=userMapper.selectPhoneById(uid);
        System.out.println("userPhone"+userPhone);
        SendMsgUtils.sendMsgTo(userPhone,4);


        return new Result(SUCCESS);
    }
}
