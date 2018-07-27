package com.mobileai.dxc.db.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * 支付记录表
 */
@Data
public class Record {
    private int recordId;
    private int orderId;
    @Value("0")
    private int payStatus;

    private int fee;

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public static class StatusCode{
        // 支付状态  0:用户未支付  1.用户支付失败 2.用户支付成功 3.用户申请退款，尚未退款 4.退款成功 5：退款不成功
        public final static int NOT_PAY=0;
        public final static int PAY_FAILED=1;
        public final static int PAY_SUCCESS=2;
        public final static int APPLY_REFUND=3;
        public final static int REFUND_SUCCESS=4;
        public final static int REFUND_FAILED=5;
    }

}
