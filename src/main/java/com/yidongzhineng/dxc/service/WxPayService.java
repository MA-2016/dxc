
package com.yidongzhineng.dxc.service;

import com.github.wxpay.sdk.WXPay;
import com.yidongzhineng.dxc.config.MyWxPayConfig;

import java.util.HashMap;
import java.util.Map;

public class WxPayService extends WXPay {


    private static MyWxPayConfig config;

    static {
        try {
            config = new MyWxPayConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //nonce_str和key 在wxplay中已经实现

    //终端IP
    private String spbill_create_ip;
    //xia下单结果通知接口
    private String notif_url;
    //交易类型(JSAPI 公众号支付
    //
    //NATIVE 扫码支付
    //
    //APP APP支付)
    private String trade_type = "NATIVE";
    private Map<String, String> data;

    public WxPayService() {
        super(config);
    }

    /**
     * 进行下单请求
     *
     * @param product_id   订单ID
     * @param body         订单描述
     * @param total_fee    总费用，单位为分
     * @param out_trade_no 内部订单记录ID
     * @return 用于生成二维码的链接，如发生错误，返回空
     * @throws Exception
     */
    public String ss(String product_id, String body, int total_fee, String out_trade_no) throws Exception {
        String fee = String.valueOf(total_fee);
        data = new HashMap<>();
        data.put("out_trade_no", out_trade_no);
        data.put("spbill_create_ip", spbill_create_ip);

        data.put("body", body);
        data.put("notify_url", notif_url);
        data.put("total_fee", fee);
        data.put("trade_type", trade_type);  // 此处指定为扫码支付
        data.put("product_id", product_id);

        Map<String, String> res = super.unifiedOrder(data);
        if (res.get("return_code").equals("SUCCESS") & res.get("result_code").equals("SUCCESS")) {
            return res.get("code_url");

        }
        res.get("return_msg");
        return null;
    }

    /**
     * 取消订单支付
     *
     * @param out_trade_no 订单支付记录号
     * @return 成功 true 失败 false
     * @throws Exception
     */
    public boolean cancelPay(String out_trade_no) throws Exception {
        data = new HashMap<>();
        data.put("out_trade_no", out_trade_no);
        data.put("spbill_create_ip", spbill_create_ip);
        Map<String, String> res = super.closeOrder(data);
        if (res.get("return_code").equals("SUCCESS") & res.get("result_code").equals("SUCCESS")) {
            return true;
        }
        return false;
    }
    // 申请退款

}

