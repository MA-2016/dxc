package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.UserMapper;
import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.db.pojo.User;
import com.mobileai.dxc.service.OrderService;
import com.mobileai.dxc.service.UserService;


import com.mobileai.dxc.util.IntStringUtils;
import com.mobileai.dxc.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//周恩华负责
@Service
public class UserServiceImple implements UserService{

    @Autowired
    private OrderService createorder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public int submitOrder(int userId, int sellerId, int number, long serviceTime, int[] service){
        Order order = new Order();
        order.setUserId(userId);
        order.setSellerId(sellerId);
        order.setNumber(number);
        order.setServiceTime(serviceTime);
        order.setService(IntStringUtils.intArray2String(service));

        return createorder.submitOrder(order);
    }

	@Override
	public Result getUser(int userId) {
		return new Result(200,"用户信息",userMapper.selectById(userId));
	}

	@Override
    public Result updateUser(User user){

        userMapper.updateUserById(user);
        return new Result(200,"更新成功",userMapper.selectById(user.getUserId()));
    }
}