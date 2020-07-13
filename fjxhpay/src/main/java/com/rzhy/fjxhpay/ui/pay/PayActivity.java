package com.rzhy.fjxhpay.ui.pay;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.rzhy.fjxhpay.R;
import com.rzhy.fjxhpay.common.AppConfig;
import com.rzhy.fjxhpay.mvp.MvpActivity;
import com.rzhy.fjxhpay.mvp.patient.PatientModel;
import com.rzhy.fjxhpay.mvp.pay.alipay.AliPayModel;
import com.rzhy.fjxhpay.mvp.pay.BalanceModel;
import com.rzhy.fjxhpay.mvp.pay.PayPresenter;
import com.rzhy.fjxhpay.mvp.pay.PayView;
import com.rzhy.fjxhpay.mvp.pay.alipay.PayResult;
import com.rzhy.fjxhpay.mvp.pay.alipay.PayStatusModel;
import com.rzhy.fjxhpay.mvp.pay.weixin.WeiXinPayModel;
import com.rzhy.fjxhpay.utils.L;
import com.rzhy.fjxhpay.utils.OtherUtils;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Map;

/**
 * Created by SenGe on 2020-06-12.
 */

public class PayActivity extends MvpActivity<PayPresenter> implements PayView,View.OnClickListener{

    private static final int SDK_PAY_FLAG = 1;

    TextView labelName;
    TextView tvName;
    TextView labelBindNumber;
    TextView tvBindNumber;
    TextView labelBalance;
    TextView tvBalance;
    TextView labelAmt;
    EditText etAmt;
    TextView pay;
    ImageView icon;
    RadioButton imgWechat;
    LinearLayout llWechat;
    RadioButton imgAlipay;
    LinearLayout llAlipay;
    Button btnNext;


    private PatientModel patient;

    private String orderId;
    public static final String WX_FJXH_STATUS = "WX_FJXH_STATUS";
    private  boolean status;

    private IWXAPI api;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(mActivity, "支付成功", Toast.LENGTH_SHORT).show();
//                        mvpPresenter.getAliPayStatus(orderId);
                        if (patient.getBindType() == 1) {
                            mvpPresenter.getAliPayStatus(orderId);
                        }else {
                            mvpPresenter.getAliPayStatusZY(orderId);
                        }
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(mActivity, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(mActivity, "支付失败", Toast.LENGTH_SHORT).show();
//                            displayOrderInfo("支付失败");
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        labelName = findViewById(R.id.label_name);
        tvName = findViewById(R.id.tv_name);
        labelBindNumber = findViewById(R.id.label_bind_number);
        tvBindNumber = findViewById(R.id.tv_bind_number);
        labelBalance = findViewById(R.id.label_balance);
        tvBalance = findViewById(R.id.tv_balance);
        labelAmt = findViewById(R.id.label_amt);
        etAmt = findViewById(R.id.et_amt);
        pay = findViewById(R.id.pay);
        icon = findViewById(R.id.icon);
        imgWechat = findViewById(R.id.img_wechat);
        llWechat = findViewById(R.id.ll_wechat);
        imgAlipay = findViewById(R.id.img_alipay);
        llAlipay = findViewById(R.id.ll_alipay);
        btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(this);
        llWechat.setOnClickListener(this);
        llAlipay.setOnClickListener(this);
        imgAlipay.setOnClickListener(this);
        imgWechat.setOnClickListener(this);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        status = AppConfig.getInstatce(mActivity).getBoolean(WX_FJXH_STATUS, false);
        L.i("status",status+","+orderId);
        if (status && !TextUtils.isEmpty(orderId)) {
            AppConfig.getInstatce(mActivity).setValue(WX_FJXH_STATUS, false);
            if (patient.getBindType() == 1) {
                mvpPresenter.getWeiXinPayStatus(orderId);
            }else {
                mvpPresenter.getWeiXinPayStatusZY(orderId);
            }
        }
    }

    private void init() {
        initTitle(getResources().getString(R.string.title_pay));
        patient = (PatientModel) getIntent().getExtras().get("patient");
        api = WXAPIFactory.createWXAPI(mActivity,    AppConfig.getInstatce(mActivity).getString("APP_ID",""));

        tvBindNumber.setText(patient.getBindNum());
        tvName.setText(patient.getName());
        initData();
    }

    private void initData() {
        imgWechat.setChecked(true);
        OtherUtils.setPricePoint(etAmt);
        if (patient != null) {
            if (patient.getBindType() == 1) {
                mvpPresenter.getMzyeFromServer(patient.getId()+"");
            }else {
                mvpPresenter.getZyyeFromServer(patient.getId()+"");

            }
        }
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_next) {
            if (TextUtils.isEmpty(etAmt.getText().toString().trim())) {
                Toast.makeText(mActivity, "请输入金额", Toast.LENGTH_SHORT).show();
            } else {
                if (patient.getBindType() == 1) {
                    if (imgAlipay.isChecked()) {    // 支付宝
                        mvpPresenter.getAliPay((((Double) (Double.parseDouble(etAmt.getText().toString()) * 100)).intValue()) + "", patient.getId() + "");
                    } else if (imgWechat.isChecked()) {// 微信
                        if (OtherUtils.isWeixinAvilible(mActivity) == true) {
                            mvpPresenter.getWeiXinPay((((Double) (Double.parseDouble(etAmt.getText().toString()) * 100)).intValue()) + "", patient.getId() + "");
                        } else {
                            Toast.makeText(this, "请先安装微信客户端！", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    if (imgAlipay.isChecked()) {   // 支付宝
                        mvpPresenter.getAliPayZY((((Double) (Double.parseDouble(etAmt.getText().toString()) * 100)).intValue()) + "", patient.getId() + "");
                    } else if (imgWechat.isChecked()) {// 微信
                        if (OtherUtils.isWeixinAvilible(mActivity) == true) {
                            mvpPresenter.getWeiXinPayZY((((Double) (Double.parseDouble(etAmt.getText().toString()) * 100)).intValue()) + "", patient.getId() + "");
                        } else {
                            Toast.makeText(this, "请先安装微信客户端！", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }

        } else if (i == R.id.ll_wechat) {
            imgWechat.setChecked(true);
            imgAlipay.setChecked(false);

        } else if (i == R.id.ll_alipay) {
            imgWechat.setChecked(false);
            imgAlipay.setChecked(true);

        } else if (i == R.id.img_wechat) {
            imgWechat.setChecked(true);
            imgAlipay.setChecked(false);

        } else if (i == R.id.img_alipay) {
            imgWechat.setChecked(false);
            imgAlipay.setChecked(true);

        }

    }

    @Override
    public void showLoading(String msg) {
        showProgress(msg);
    }

    @Override
    public void hideLoading() {
        hideProgress();
    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFailure(int code, String msg) {

    }

    @Override
    public void getBalanceSuccess(BalanceModel balance) {
        tvBalance.setText(balance.getData().getAmt());
    }

    @Override
    public void requestAliPay(final AliPayModel.DataBean alibean) {
        orderId = alibean.getOrderId();

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象

                PayTask alipay = new PayTask(mActivity);
                // 调用支付接口，获取支付结果
                String payInfo = alibean.getSign();
                Log.i("payInfo",payInfo);
                Map<String, String> result = alipay.payV2(payInfo, true);
                Log.i("msp", result.toString());
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    @Override
    public void requestWeiXinPay(WeiXinPayModel.DataBean wxpay) {
        PayReq request = new PayReq();
        request.appId = wxpay.getAppid();
        request.partnerId = wxpay.getPartnerid();
        request.prepayId = wxpay.getPrepayid();
        request.packageValue = wxpay.getPackage1();
        request.nonceStr = wxpay.getNoncestr();
        request.timeStamp = wxpay.getTimestamp();
        request.sign = wxpay.getSign();
        orderId = wxpay.getOrderId();
        api.sendReq(request);
    }

    /**
     *
     * @param bean
     * @param type  1 支付宝  2 微信
     */
    @Override
    public void onPayStatusSuccess(PayStatusModel.DataBean bean, final Integer type) {
        if (bean.getCode() == 1) {
            tvBalance.setText(bean.getYe());
            Toast.makeText(this,"支付成功",Toast.LENGTH_SHORT).show();
        }else if (bean.getCode() == 2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage(bean.getMsg());
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (type == 1) {
                        if (!TextUtils.isEmpty(orderId)) {
                            if (patient.getBindType() == 1) {
                                mvpPresenter.getAliPayStatus(orderId);
                            }else {
                                mvpPresenter.getAliPayStatusZY(orderId);
                            }
                        }
                    } else {
                        if (!TextUtils.isEmpty(orderId)) {
                            if (patient.getBindType() == 1) {
                                mvpPresenter.getWeiXinPayStatus(orderId);
                            }else {
                                mvpPresenter.getWeiXinPayStatusZY(orderId);
                            }
                        }
                    }
                    dialog.dismiss();
                }
            });
            builder.show();
        }
    }

    @Override
    protected PayPresenter createPresenter() {
        return new PayPresenter(this);
    }

}
