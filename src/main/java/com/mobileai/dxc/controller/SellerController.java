package com.mobileai.dxc.controller;

import com.mobileai.dxc.db.pojo.Seller;
import com.mobileai.dxc.service.SellerService;
import com.mobileai.dxc.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    /**
     * 更新商家
     * @param seller Seller实体类
     * @return 更新后的数据
     *
     */
    @PutMapping("/updateseller")
    Result updateseller(@RequestBody Seller seller) {
        return sellerService.updateSeller(seller);
    }

    /**
     * 获取商家信息
     *
     * @param sellerId 商家编号
     * @return 商家数据
     */
    @GetMapping("/getsellerInfo")
    Result getSellerInfo(@RequestParam int sellerId) {
        return sellerService.getSeller(sellerId);
    }

}
