package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.IndentMapper;
import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.mapper.UserMapper;
import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.service.SellerService;
import com.mobileai.dxc.util.Result;
import com.mobileai.dxc.util.SendMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mobileai.dxc.util.StatusCode.SUCCESS;

@Service
public class SellerServiceImple implements SellerService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    IndentMapper indentMapper;
    @Autowired
    SellerMapper sellerMapper;



    @Override
    public void notifyNewOrder(Order order) {
        String sellerPhone;
        sellerPhone =sellerMapper.selectPhoneById(order.getSellerId());
        SendMsgUtils.sendMsgTo(sellerPhone,2);
    }

    @Override
    public Result acceptOrder(int oid) {
        String userPhone;

        int uid=indentMapper.selectUseridByOrderid(oid);
        userPhone=userMapper.selectPhoneById(uid);
        SendMsgUtils.sendMsgTo(userPhone,3);
        return new Result(SUCCESS);
    }

    @Override
    public Result refuseOrder(int oid, String reason) {
        String userPhone;

        indentMapper.updateRefuseReasonByOrderid(reason,oid);

        int uid=indentMapper.selectUseridByOrderid(oid);
        userPhone=userMapper.selectPhoneById(uid);
        SendMsgUtils.sendMsgTo(userPhone,4);


        return new Result(SUCCESS);
    }

    @Override
    public Result updateSeller(Seller seller) {
        sellerMapper.updateSellerById(seller);
        return new Result(200,"商家信息",sellerMapper.selectById(seller.getSellerId()));

    }

    @Override
    public Result getSeller(int sellerId) {
        return new Result(200,"更新成功",sellerMapper.selectById(sellerId));
    }
}
