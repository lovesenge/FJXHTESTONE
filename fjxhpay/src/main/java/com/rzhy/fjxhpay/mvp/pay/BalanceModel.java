package com.rzhy.fjxhpay.mvp.pay;


import com.rzhy.fjxhpay.retrofit.BaseResult;

public class BalanceModel extends BaseResult {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String amt;

        public String getAmt() {
            return amt;
        }

        public void setAmt(String amt) {
            this.amt = amt;
        }
    }
}
