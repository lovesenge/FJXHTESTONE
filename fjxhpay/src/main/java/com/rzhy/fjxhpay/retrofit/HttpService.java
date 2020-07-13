package com.rzhy.fjxhpay.retrofit;

import com.rzhy.fjxhpay.mvp.patient.PatientListModel;
import com.rzhy.fjxhpay.mvp.pay.alipay.AliPayModel;
import com.rzhy.fjxhpay.mvp.pay.BalanceModel;
import com.rzhy.fjxhpay.mvp.pay.alipay.PayStatusModel;
import com.rzhy.fjxhpay.mvp.pay.weixin.WeiXinPayModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by SenGe on 2020-06-12.
 */

public interface HttpService {

    /**
     * 门诊余额
     */
    @FormUrlEncoded
    @POST("user/mzye")
    Observable<BalanceModel> getMzye(
            @Field("id") String id
    );

    /**
     * 住院余额
     */
    @FormUrlEncoded
    @POST("user/zyye")
    Observable<BalanceModel> getZyye(
            @Field("id") String id
    );

    /**
     * 获取绑定就诊人列表
     *
     * @return
     */
    @POST("user/getBrdaList")
    Observable<PatientListModel> getPatientList();

    /**
     * 支付宝订单获取--门诊
     */
    @FormUrlEncoded
    @POST("user/getAliPay2")
    Observable<AliPayModel> getAliPay(
            @Field("amt") String amt,
            @Field("id") String jzrid,
            @Field("type") Integer type
    );

    /**
     * 支付宝订单状态
     */
    @FormUrlEncoded
    @POST("user/getAliPayStatus2")
    Observable<PayStatusModel> getAliPayStatus(
            @Field("id") String id,
            @Field("isAndroid") String isAndroid

    );

    /**
     * 支付宝订单获取
     */
    @FormUrlEncoded
    @POST("user/getAliPayStatusZY2")
    Observable<PayStatusModel> getAliPayStatusZY(
            @Field("id") String id,
            @Field("isAndroid") String isAndroid

    );

    /**
     * 支付宝订单获取--住院
     */
    @FormUrlEncoded
    @POST("user/getAliPayZY2")
    Observable<AliPayModel> getAliPayZY(
            @Field("amt") String amt,
            @Field("id") String jzrid,
            @Field("type") Integer type
    );

    /**
     * 微信订单获取--门诊
     */
    @FormUrlEncoded
    @POST("user/getWeiXinPay2")
    Observable<WeiXinPayModel> getWeiXinPay(
            @Field("amt") String amt,
            @Field("id") String jzrid,
            @Field("type") Integer type
    );

    /**
     * 微信订单获取--住院
     */
    @FormUrlEncoded
    @POST("user/getWeiXinPayZY2")
    Observable<WeiXinPayModel> getWeiXinPayZY(
            @Field("amt") String amt,
            @Field("id") String jzrid,
            @Field("type") Integer type
    );

    /**
     * 微信订单状态
     */
    @FormUrlEncoded
    @POST("user/getWeiXinPayStatus2")
    Observable<PayStatusModel> getWeiXinPayStatus(
            @Field("id") String  id,
            @Field("isAndroid") String isAndroid
    );
    /**
     * 微信订单状态获取
     */
    @FormUrlEncoded
    @POST("user/getWeiXinPayStatusZY2")
    Observable<PayStatusModel> getWeiXinPayStatusZY(
            @Field("id") String id,
            @Field("isAndroid") String isAndroid
    );
}
