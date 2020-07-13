package com.rzhy.fjxhpay.mvp.pay;

import com.rzhy.fjxhpay.mvp.BasePresenter;
import com.rzhy.fjxhpay.mvp.pay.alipay.AliPayModel;
import com.rzhy.fjxhpay.mvp.pay.alipay.PayStatusModel;
import com.rzhy.fjxhpay.mvp.pay.weixin.WeiXinPayModel;
import com.rzhy.fjxhpay.rxjava.BaseMyApiCallBack;
import com.rzhy.fjxhpay.rxjava.ObserverCallBack;

/**
 * Created by SenGe on 2020-06-12.
 */

public class PayPresenter extends BasePresenter<PayView> {


    public PayPresenter(PayView view) {
        this.mvpView = view;
    }

    /**
     * 获取门诊余额
     * @param id
     */
    public void getMzyeFromServer(String id) {
        mvpView.showLoading("");
        addSubscription(httpService.getMzye(id), new ObserverCallBack<BalanceModel>(new BaseMyApiCallBack<BalanceModel>() {
            @Override
            public void onSuccess(BalanceModel model) {
                mvpView.getBalanceSuccess(model);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        }));
    }

    /**
     * 获取住院余额
     * @param id
     */
    public void getZyyeFromServer(String id) {
        mvpView.showLoading("");
        addSubscription(httpService.getZyye(id), new ObserverCallBack<BalanceModel>(new BaseMyApiCallBack<BalanceModel>() {
            @Override
            public void onSuccess(BalanceModel model) {
                mvpView.getBalanceSuccess(model);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        }));
    }

    // 支付宝支付订单获取 --门诊
    public void getAliPay(String amt,String id){
        mvpView.showLoading("加载中...");
        addSubscription(httpService.getAliPay(amt,id,1), new ObserverCallBack<AliPayModel>(new BaseMyApiCallBack<AliPayModel>() {

            @Override
            public void onSuccess(AliPayModel model) {
                // 本地请求支付宝客户端支付
                mvpView.requestAliPay(model.getData());
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }

    // 支付宝支付订单获取 --住院
    public void getAliPayZY(String amt,String id){
        mvpView.showLoading("加载中...");
        addSubscription(httpService.getAliPayZY(amt,id,3), new ObserverCallBack<AliPayModel>(new BaseMyApiCallBack<AliPayModel>() {

            @Override
            public void onSuccess(AliPayModel model) {
                // 本地请求支付宝客户端支付
                mvpView.requestAliPay(model.getData());
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }

    public void getAliPayStatus(String orderId){
        mvpView.showLoading("查询充值信息");
        addSubscription(httpService.getAliPayStatus(orderId,"cnm"), new ObserverCallBack<>(new BaseMyApiCallBack<PayStatusModel>() {

            @Override
            public void onSuccess(PayStatusModel model) {
                mvpView.onPayStatusSuccess(model.getData(),1);
            }
            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }

    public void getAliPayStatusZY(String orderId){
        mvpView.showLoading("查询充值信息");
        addSubscription(httpService.getAliPayStatusZY(orderId,"cnm"), new ObserverCallBack<>(new BaseMyApiCallBack<PayStatusModel>() {

            @Override
            public void onSuccess(PayStatusModel model) {
                mvpView.onPayStatusSuccess(model.getData(),1);
            }
            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }

    //微信支付订单获取 --门诊
    public void getWeiXinPay(String amt,String id){
        mvpView.showLoading("加载中...");
        addSubscription(httpService.getWeiXinPay(amt,id,1), new ObserverCallBack<>(new BaseMyApiCallBack<WeiXinPayModel>() {

            @Override
            public void onSuccess(WeiXinPayModel model) {

                // 本地请求微信客户端支付
                mvpView.requestWeiXinPay(model.getData());
            }
            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }

    public void getWeiXinPayZY(String amt,String id){
        mvpView.showLoading("加载中...");
        addSubscription(httpService.getWeiXinPayZY(amt,id,3), new ObserverCallBack<>(new BaseMyApiCallBack<WeiXinPayModel>() {

            @Override
            public void onSuccess(WeiXinPayModel model) {

                // 本地请求微信客户端支付
                mvpView.requestWeiXinPay(model.getData());
            }
            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }


    public void getWeiXinPayStatus(String orderId){
        mvpView.showLoading("查询充值信息");
        addSubscription(httpService.getWeiXinPayStatus(orderId,"cnm"), new ObserverCallBack<>(new BaseMyApiCallBack<PayStatusModel>() {

            @Override
            public void onSuccess(PayStatusModel model) {
                mvpView.onPayStatusSuccess(model.getData(),2);
            }
            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }

    public void getWeiXinPayStatusZY(String orderId){
        mvpView.showLoading("查询充值信息");
        addSubscription(httpService.getWeiXinPayStatusZY(orderId,"cnm"), new ObserverCallBack<>(new BaseMyApiCallBack<PayStatusModel>() {

            @Override
            public void onSuccess(PayStatusModel model) {
                mvpView.onPayStatusSuccess(model.getData(),2);
            }
            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        }));
    }
}
