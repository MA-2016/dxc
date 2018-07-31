package com.mobileai.dxc.component;


import com.mobileai.dxc.db.pojo.Record;
import com.mobileai.dxc.service.RecordSevice;
import com.mobileai.dxc.service.imple.WxPayService;

import org.springframework.beans.factory.annotation.Autowired;
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

    //请求支付发起，返回支付链接 用此生成二维码

    @GetMapping("/test")
    public String test(){
        return "success111";
    }

    /**
     * 请求支付发起
     *
     * @param recordId 订单记录号
     * @return 返回支付链接 用此生成二维码
     */

    @GetMapping("/applyOrder")
    public String applyOrder(@RequestParam int recordId) {
        Record record = recordSevice.getById(recordId);
        String orderId = record.getOrderId() + "";
        int fee = record.getFee() * 100;
        String out_trade_no = recordId + "";
        String url = wxPayService.applyOrder(orderId, fee, out_trade_no);

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
        // TODO: 2018/7/25  退款成功就把订单的状态设为结束

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
        // TODO: 2018/7/25 gai改变订单的状态
        if ("SUCCESS".equals(map.get("return_code"))) {
            //调用通知前端的接口
        } else {

        }
        return map;

    }

}
