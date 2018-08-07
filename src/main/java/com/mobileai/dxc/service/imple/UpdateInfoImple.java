package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.mapper.UserMapper;
import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.db.pojo.User;
import com.mobileai.dxc.service.UpdateInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UpdateInfoImple implements UpdateInfo{
    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean updateSeller(Seller seller){
        sellerMapper.updateSellerById(seller);
        return true;
    }


	@Override
	public boolean updateUser(User user) {
        userMapper.updateSellerById(user);
		return true;
	}
}