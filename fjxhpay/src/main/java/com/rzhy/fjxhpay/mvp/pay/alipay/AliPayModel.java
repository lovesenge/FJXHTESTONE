package com.rzhy.fjxhpay.mvp.pay.alipay;

import com.rzhy.fjxhpay.retrofit.BaseResult;

/**
 * Created by SenGe on 2020-06-16.
 */

public class AliPayModel extends BaseResult {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String sign;
        private String orderId;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }
    }

}
