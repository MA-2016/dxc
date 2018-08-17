package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.service.SearchService;
import com.mobileai.dxc.util.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImple implements SearchService{

    @Autowired
    SellerMapper sellerMapper;

    public Result dynamicRecommend(String location, String topic) {
        return new Result(200, "动态商家列表", sellerMapper.selectFuzzy(location, topic));
    }

}