package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.EvaluateMapper;
import com.mobileai.dxc.db.mapper.IndentMapper;
import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.service.EvaluateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//周恩华负责
@Service
public class EvaluateServiceImple implements EvaluateService{
    @Autowired
    IndentMapper indentMapper;

    @Autowired
    EvaluateMapper evaluateMapper;

    @Autowired
    SellerMapper sellerMapper;

    @Override
    public boolean submitEvaluation(int sellerId,int userId,int orderId,int starLevel,String content){
        Seller seller = sellerMapper.selectById(sellerId);
        int newEvaluate = seller.getEvaluateNum()+1;
        double newscore = (seller.getScore()*seller.getEvaluateNum()+starLevel)/newEvaluate;

        seller.setEvaluateNum(newEvaluate);
        seller.setScore(newscore);

        sellerMapper.updateSellerById(seller);
        evaluateMapper.addEvaluate(sellerId, userId, orderId, starLevel,content);

        return true;
    }
}