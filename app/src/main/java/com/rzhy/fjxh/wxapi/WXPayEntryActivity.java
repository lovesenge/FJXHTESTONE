package com.rzhy.fjxh.wxapi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.rzhy.fjxhpay.common.AppConfig;
import com.rzhy.fjxhpay.ui.pay.PayActivity;
import com.rzhy.fjxhpay.utils.L;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";

    private IWXAPI api;
    private static final String APP_ID = "your app id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这里可以不填写
//        setContentView(R.layout.home_activity_pay_status);
        api = WXAPIFactory.createWXAPI(this, APP_ID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    /**
     * 得到支付结果回调
     */
    @SuppressLint("LongLogTag")
    @Override
    public void onResp(BaseResp resp) {
        Log.d(TAG, "onPayFinish, errCode = " + resp.errCode);
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {

            switch (resp.errCode) {
                case 0://支付成功
                    Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onResp: resp.errCode = 0   支付成功");
                    AppConfig.getInstatce(getApplicationContext()).setValue(PayActivity.WX_FJXH_STATUS,true);
                    break;
                case -1://错误，可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等
                    Toast.makeText(this, "支付错误", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onResp: resp.errCode = -1  支付错误");
                    AppConfig.getInstatce(getApplicationContext()).setValue(PayActivity.WX_FJXH_STATUS,false);
                    break;
                case -2://用户取消，无需处理。发生场景：用户不支付了，点击取消，返回APP。
                    Log.d(TAG, "onResp: resp.errCode = -2  用户取消");
                    Toast.makeText(this, "支付取消", Toast.LENGTH_SHORT).show();
                    AppConfig.getInstatce(getApplicationContext()).setValue(PayActivity.WX_FJXH_STATUS,false);
                    break;

            }

            finish();//这里需要关闭该页面
        }


    }
}