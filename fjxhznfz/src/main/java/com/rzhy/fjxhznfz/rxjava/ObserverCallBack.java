package com.rzhy.fjxhznfz.rxjava;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.rzhy.fjxhznfz.retrofit.BaseResult;
import com.rzhy.fjxhznfz.utils.L;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;
import retrofit2.HttpException;


/**
 * Created by Senge on 2019/8/12.
 */

public class ObserverCallBack<M extends BaseResult> extends DisposableObserver<M> {

    private ApiCallback<M> apiCallback;

    public ObserverCallBack(ApiCallback<M> apiCallback){ this.apiCallback = apiCallback; }

    @Override
    public void onNext(M m) {
        if(apiCallback instanceof MyApiCallBack){
            ((MyApiCallBack) apiCallback).getResult(m);
        }else{
            apiCallback.onSuccess(m);
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            L.i("HttpException","HttpException");
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()

            int code = httpException.code();
            String msg = httpException.getMessage();
            if (code == 504) {
                msg = "网络不给力";
                apiCallback.onFailure(code, msg);
            }else if(code == 403){
                ResponseBody responseBody = ((HttpException) e).response().errorBody();
                try {
                    if(responseBody != null){
                        msg = responseBody.string().toString();
                        L.i("msg",msg);
                    }
                }catch (IOException e1){
                    e1.printStackTrace();
                }
                apiCallback.onFailure(code, msg);
            } else if(code == 401){
                msg = "登录信息已失效，请重新登录";
                L.i("msg",msg);
            }else{
                apiCallback.onFailure(code, msg);
            }

        }else if (e instanceof SocketTimeoutException){
            apiCallback.onFailure(111, "连接超时");
        }else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException){
            apiCallback.onFailure(112, "解析错误");
        }else if(e instanceof ConnectException){
            apiCallback.onFailure(113, "连接服务器失败");
        } else if(e instanceof UnknownHostException) {
            apiCallback.onFailure(114, "网络未连接");
        }else {
            L.i("其他错误","其他错误");
            apiCallback.onFailure(115, "其他错误"+e.getMessage());
        }
        apiCallback.onFinish();
    }

    @Override
    public void onComplete() {
        apiCallback.onFinish();
    }
}
