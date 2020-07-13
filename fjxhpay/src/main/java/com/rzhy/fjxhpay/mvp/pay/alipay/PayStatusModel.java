package com.rzhy.fjxhpay.mvp.pay.alipay;

import com.rzhy.fjxhpay.retrofit.BaseResult;

/**
 * Created by SenGe on 2020-06-16.
 */

public class PayStatusModel extends BaseResult {
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String ye;
        private Integer code;
        private String msg;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getYe() {
            return ye;
        }

        public void setYe(String ye) {
            this.ye = ye;
        }
    }
}
