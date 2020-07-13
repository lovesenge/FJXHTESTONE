package com.rzhy.fjxhpay.retrofit;


public class BaseResult {

    /**
     * msg :
     * ret : 1
     */

    protected String msg;
    protected String ret;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }
}
