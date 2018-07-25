
package com.mobileai.dxc.service.imple;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.mobileai.dxc.config.MyWxPayConfig;
import com.mobileai.dxc.db.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付模块虎哥负责
 */
@Service
public class WxPayService extends WXPay {

    @Autowired
    private RecordMapper recordMapper;

    private static MyWxPayConfig config;

    static {
        try {
            config = new MyWxPayConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //nonce_str和key 在wxplay中已经实现


    // TODO: 2018/7/25 设置下面2个字段 
    //终端IP
    private String spbill_create_ip;
    //xia下单结果通知接口
    private String notif_url;
    //交易类型
    //  JSAPI ：公众号支付
    //  NATIVE ：扫码支付
    //  APP ：APP支付
    private String trade_type = "NATIVE";
    private Map<String, String> data;

    public WxPayService() {
        super(config);
    }

    /**
     * 进行下单请求
     *
     * @param product_id   订单ID
     * @param total_fee    总费用，单位为分
     * @param out_trade_no 内部订单记录ID
     * @return 用于生成二维码的链接，如发生错误，返回空
     * @throws Exception
     */
    public String applyOrder(String product_id, int total_fee, String out_trade_no){
        String fee = String.valueOf(total_fee);
        String body =" ";


        data = new HashMap<>();
        data.put("out_trade_no", out_trade_no);
        data.put("spbill_create_ip", spbill_create_ip);

        data.put("body", body);
        data.put("notify_url", notif_url);
        data.put("total_fee", fee);
        data.put("trade_type", trade_type);  // 此处指定为扫码支付
        data.put("product_id", product_id);

        Map<String, String> res = null;
        try {
            res = super.unifiedOrder(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
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


    /**
     * 申请退款
     *
     * @param recordId 订单支付记录号
     * @return 返回是否申请退款请求成功
     * @throws Exception
     */
    public boolean applyRefund(int recordId) {

        int total_fee = recordMapper.selectFeeById(recordId);
        total_fee *= 100;
        String out_trade_no=recordId+"";
        String fee = total_fee + "";
        data = new HashMap<>();
        data.put("out_trade_no", out_trade_no);
        //guanfang官方文档给的金额是int的，有点坑
        data.put("total_fee", fee);
        data.put("refund_fee", fee);
        Map<String, String> res = null;
        try {
            res = super.refund(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (res.get("return_code").equals("SUCCESS") & res.get("result_code").equals("SUCCESS")) {
            return true;
        }

        return false;
    }


    /**
     * 退款查询接口
     *
     * @param recordId 订单支付记录号
     * @return 返回退款是否成功
     * @throws Exception
     */
    public boolean queryRefund(int recordId) throws Exception {
        boolean flag = false;
        data = new HashMap<>();
        String out_trade_no=recordId+"";
        data.put("out_trade_no", out_trade_no);
        while (true) {
            Map<String, String> res = super.refundQuery(data);
            if (res.get("return_code").equals("SUCCESS") & res.get("result_code").equals("SUCCESS")) {
                if ("SUCCESS".equals(res.get("refund_status"))) {
                    return true;
                } else if ("PROCESSING".equals(res.get("refund_status"))) {
                    flag = true;
                    //如果正在处理中，睡30s再查询
                    Thread.sleep(30);
                } else {
                    break;
                }
            }
        }

        return false;
    }

    /**
     * chau查询支付是否成功  需要核对签名和金额是否正确
     *
     * @param result 返回的XNL字符串
     * @return 返回给微信的map ，成功时return_code为SUCCESS
     * @throws Exception
     */
    public Map<String, String> queryPay(String result) throws Exception {
        Map<String, String> res = WXPayUtil.xmlToMap(result);
        Map<String, String> map = null;

        if (res.get("return_code").equals("SUCCESS") & res.get("result_code").equals("SUCCESS")) {
            if (super.isPayResultNotifySignatureValid(res)) {
                //huoqu 获取订单的费用
                int fee = recordMapper.selectFeeById(Integer.parseInt(res.get("out_trade_no")) * 100);
                if (Integer.parseInt(res.get("total_fee")) >= fee) {
                    map.put("return_code", "SUCCESS");
                } else {
                    map.put("return_code", "FALL");
                    map.put("return_msg", "金额不匹配");
                }
            } else {
                map.put("return_code", "FALL");
                map.put("return_msg", "签名失败");
            }

        } else {
            map.put("return_code", "FALL");
            map.put("return_msg", "支付失败");
        }


        return map;
    }


}

