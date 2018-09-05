package com.mobileai.dxc.controller;

/**
 * 支付时，前端所做流程如下：
 * 通过applyOrder发起请求
 * 同时使用WebSocket连接后端，链接为server
 * 创建socketJs var socket = new SockJS('/server'+name)。name为orderId
 * 等待后端支付结果通知。有结果后关闭连接
*/

import com.mobileai.dxc.db.pojo.Order;
import com.mobileai.dxc.db.pojo.Record;
import com.mobileai.dxc.service.OrderService;
import com.mobileai.dxc.service.RecordSevice;
import com.mobileai.dxc.service.imple.WxPayService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

@RestController

@RequestMapping("/pay")
public class PayController {
    @Autowired
    private WxPayService wxPayService;

    @Autowired
    private RecordSevice recordSevice;

    @Autowired
    private OrderService orderService;

    //请求支付发起，返回支付链接 用此生成二维码

    @GetMapping("/test")
    public String test(){
        return "success111";
    }

    /**
     * 请求支付发起
     *
     * @param orderId 订单号
     * @return 返回支付链接 用此生成二维码
     */

    @GetMapping("/applyOrder")
    public String applyOrder(@RequestParam int orderId) {
        Record record = recordSevice.getById(orderId);
        String out_trade_no = record.getRecordId() + "";
        int fee = record.getFee() * 100;
        String id= orderId + "";
        String url = wxPayService.applyOrder(id, fee, out_trade_no);

        return url;
    }


    /**
     * 请求退款
     *
     * @param recordId 支付记录id
     * @return 退款是否成功，分为2次查询，中间设有20s的时间间隔
     * @throws Exception
     */
    @GetMapping("/applyRefund")
    public boolean queryRefund(@RequestParam int recordId) throws Exception {
        wxPayService.applyRefund(recordId);
        boolean bool = wxPayService.queryRefund(recordId);
        int status = Record.StatusCode.APPLY_REFUND;
        if (bool) {
            status = Record.StatusCode.REFUND_SUCCESS;
        } else {
            status = Record.StatusCode.REFUND_FAILED;
        }
        recordSevice.updateStatusByRecord(0, recordId);

         orderService.confirmPayment(recordId, Order.Status.FINISHED);
        return bool;
    }

    //取消支付接口
    @GetMapping("/cancalPay")
    public boolean cancelPay(@RequestParam int recordId) throws Exception {
        String trade_no = recordId + "";
        return wxPayService.cancelPay(trade_no);

    }

    //支付情况反馈接口
    @GetMapping("/wxPayFeedBack")
    public Map<String, String> indentFeedBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> map = null;
        Map<String, String> res = null;
        res.put("return_code", "SUCCESS");
        res.put("return_msg","OK");
        map.put("return_code", "FALL");

        InputStream inStream = request.getInputStream();
        int _buffer_size = 1024;
        if (inStream != null) {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] tempBytes = new byte[_buffer_size];
            int count = -1;
            while ((count = inStream.read(tempBytes, 0, _buffer_size)) != -1) {
                outStream.write(tempBytes, 0, count);
            }
            tempBytes = null;
            outStream.flush();
            //将流转换成字符串
            String result = new String(outStream.toByteArray(), "UTF-8");

            map = wxPayService.queryPay(result);

        }

        String id=map.get("recordId");
        int recordId=Integer.parseInt(id);
        int orderId=recordSevice.getById(recordId).getOrderId();
        if ("SUCCESS".equals(map.get("return_code"))) {
            recordSevice.updateStatusByRecord(Record.StatusCode.PAY_SUCCESS, recordId);
            orderService.confirmPayment(orderId, Order.Status.INSERVICED);
            Endpoint.sendOne(id, map.get("return_msg"));
            //调用通知前端的接口
        } else {
            recordSevice.updateStatusByRecord(Record.StatusCode.PAY_FAILED, recordId);
            Endpoint.sendOne(id, map.get("return_msg"));
        }
        return res;

    }

}
