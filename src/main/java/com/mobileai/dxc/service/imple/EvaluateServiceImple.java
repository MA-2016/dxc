package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.EvaluateMapper;
import com.mobileai.dxc.db.mapper.IndentMapper;
import com.mobileai.dxc.db.mapper.SellerMapper;
import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.service.EvaluateService;

import org.springframework.beans.factory.annotation.Autowired;

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
        int newcontenNum = seller.getContentNum()+1;
        double newscore = (seller.getScore()*seller.getContentNum()+starLevel)/newcontenNum;

        seller.setContentNum(newcontenNum);
        seller.setScore(newscore);

        sellerMapper.updateSellerById(seller);
        evaluateMapper.addEvaluate(sellerId, userId, orderId, starLevel,content);

        return true;
    }
}