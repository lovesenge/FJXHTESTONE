package com.rzhy.fjxhpay.retrofit;

import com.rzhy.fjxhpay.BuildConfig;
import com.rzhy.fjxhpay.common.AppApplication;
import com.rzhy.fjxhpay.common.AppConfig;
import com.rzhy.fjxhpay.utils.L;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Senge on 2019-08-14.
 */

public class RetrofitManager {

//    public static final String API_BASE_URL = "https://app.yujiankang.com/XhApp/ws/";
    public static final String API_BASE_URL = "http://xhtest.yujiankang.com/XhApp/ws/";

    private static final int DEFAULT_TIME_OUT = 15;  //连接超时时间
    private static final int READ_TIME_OUT = 30;  //读取超时时间
    private static final int WRITE_TIME_OUT = 30;  //写入超时时间

    public static Retrofit mRetrofit;
    public static OkHttpClient okHttpClient;
    public static OkHttpClient.Builder builder;

    private RetrofitManager() {
        retrofit();
    }


    public static Retrofit retrofit() {
        if (mRetrofit == null) {
            okHttpClient = getHttpClient();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return mRetrofit;
    }

    public static OkHttpClient getHttpClient() {
        if (okHttpClient == null) {
            builder = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(true)
                    .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)//设置连接超时时间
                    .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)//设置读取超时时间
                    .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)//设置写入超时时间
                    .addNetworkInterceptor(new MyInterceptor());
//                    .addInterceptor(new TokenInterceptor2())
//                    .addInterceptor(new MyInterceptor())
            ;//添加日志拦截器
            initLog();

            try {
                // Create a trust manager that does not validate certificate chains
                final TrustManager[] trustAllCerts = new TrustManager[]{
                        new X509TrustManager() {
                            @Override
                            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                            }

                            @Override
                            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                            }

                            @Override
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return new java.security.cert.X509Certificate[]{};
                            }
                        }
                };

                // Install the all-trusting trust manager
                final SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
                // Create an ssl socket factory with our all-trusting manager
                final javax.net.ssl.SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

                builder.sslSocketFactory(sslSocketFactory);
                builder.hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });
                okHttpClient = builder.build();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            L.i("okHttpClient", "is not null");
        }
        return okHttpClient;
    }

    private static void initLog() {
        if (BuildConfig.DEBUG) {
            // Log信息拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLog());
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //设置 Debug Log 模式
            builder.addInterceptor(loggingInterceptor);
        }
    }

    private static class HttpLog implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            L.d(message);
        }
    }

    /**
     * 拦截器
     * 对每次请求进行拦截并将token 塞入 cookie
     */
    static class MyInterceptor implements Interceptor {


        @Override
        public Response intercept(Chain chain) throws IOException {

            Request originalRequest = chain.request();

            HttpUrl httpUrl = originalRequest.url();
            L.i("httpurl", httpUrl.toString());
            String headerStr = httpUrl.toString();
            headerStr = headerStr.replace(API_BASE_URL, "");

            Request authorised = originalRequest.newBuilder()
//                    .header("Cookie", "token=" + AppCfg.getInstatce(mContext).getString("token", "0"))
                    .header("Cookie", "token=" + AppConfig.getInstatce(AppApplication.getmContext()).getString("userId", "0"))
                    .build();
            return chain.proceed(authorised);
        }
    }


}


