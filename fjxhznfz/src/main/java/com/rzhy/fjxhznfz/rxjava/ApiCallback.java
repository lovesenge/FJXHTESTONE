package com.rzhy.fjxhznfz.rxjava;

/**
 * Created by SenGe on 2019/05/09 0509.
 */

public interface ApiCallback<M> {

    void onSuccess(M model);  //数据请求成功

    void onFailure(int code, String message);  //数据请求失败

    void onFinish();  //完成数据请求后执行的操作

}
