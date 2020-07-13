package com.rzhy.fjxhpay.rxjava;


import com.rzhy.fjxhpay.retrofit.BaseResult;


/**
 * Created by Senge on 2019/08/09.
 */

public abstract class BaseMyApiCallBack<M extends BaseResult> implements MyApiCallBack<M>{

    /**
     * 初步处理数据，200代表正确的code，通过onSuccess返回正确数据，错误则调用onFailure
     * @param model
     */
    @Override
    public void getResult(M model) {
        if ("1".equals(model.getRet())) {
            onSuccess(model);
        } else {
            onFailure(Integer.valueOf(model.getRet()),model.getMsg());
        }
    }

    /**
     * 请求错误发出广播
     * @param code
     * @param msg
     */
    @Override
    public void onFailure(int code, String msg) {
//        Intent intent = new Intent(AppApplication.ACTION);
//        intent.putExtra("ret", code);
//        intent.putExtra("msg", msg);
//        AppApplication.getmContext().sendBroadcast(intent);
    }
}
