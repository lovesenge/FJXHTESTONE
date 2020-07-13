package com.rzhy.fjxhpay.rxjava;


import com.rzhy.fjxhpay.retrofit.BaseResult;

/**
 * Created by Senge on 2019/05/09 0509.
 */

public interface MyApiCallBack<M extends BaseResult> extends ApiCallback<M> {

    void getResult(M model); //获取接口返回的数据
}
