package com.gaigai.firstcode.commonlib.okhttp;

import com.gaigai.firstcode.commonlib.okhttp.https.HttpsUtils;
import com.gaigai.firstcode.commonlib.okhttp.listener.DataHandler;
import com.gaigai.firstcode.commonlib.okhttp.listener.HttpCallBack;
import com.gaigai.firstcode.commonlib.okhttp.response.CommonJsonCallBack;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;


/**
 * Created by ga on 2017/2/15.
 */

public class CommonOkHttpClient {

    private static final int TIME_OUT = 30;//超时参数
    private static final int CONNECT_OUT = 80;//连接时间
    private static final int READ_TIME_OUT = 80;//连接时间
    private static final int WRITE_TIME_OUT = 80;//连接时间
    private static OkHttpClient mOkHttpClient;

    //设置请求的配置参数
    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_OUT, TimeUnit.SECONDS);
        builder.readTimeout(READ_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS);
        builder.followRedirects(true);

        //https支持
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
/*                if (hostname.equals("https://www.baidu.com/")){
                    return true;
                }else{
                    return false;
                }*/
                return true;
            }
        });
        builder.sslSocketFactory(HttpsUtils.initSSLSocketFactory());
        mOkHttpClient = builder.build();

    }

    public static OkHttpClient getOkHttpClient(){
        return mOkHttpClient;
    }

    public static Call sendRequest(Request request, DataHandler handler){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallBack(handler));
        return call;
    }

    public static Call get(Request request, DataHandler handler){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallBack(handler));
        return call;
    }

    public static Call post(Request request, DataHandler handler){
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonJsonCallBack(handler));
        return call;
    }





}
