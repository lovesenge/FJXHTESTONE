package com.rzhy.fjxhpay.mvp.pay;

import com.rzhy.fjxhpay.mvp.BaseView;
import com.rzhy.fjxhpay.mvp.pay.alipay.AliPayModel;
import com.rzhy.fjxhpay.mvp.pay.alipay.PayStatusModel;
import com.rzhy.fjxhpay.mvp.pay.weixin.WeiXinPayModel;

/**
 * Created by SenGe on 2020-06-12.
 */

public interface PayView  extends BaseView{
    void getBalanceSuccess(BalanceModel balance);

    void requestAliPay(AliPayModel.DataBean alipay);
    void requestWeiXinPay(WeiXinPayModel.DataBean wxpay);

    void onPayStatusSuccess(PayStatusModel.DataBean bean, Integer type);
}
