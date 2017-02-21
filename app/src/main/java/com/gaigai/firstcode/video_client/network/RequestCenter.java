package com.gaigai.firstcode.video_client.network;

import com.gaigai.firstcode.commonlib.okhttp.CommonOkHttpClient;
import com.gaigai.firstcode.commonlib.okhttp.listener.DataHandler;
import com.gaigai.firstcode.commonlib.okhttp.listener.HttpCallBack;
import com.gaigai.firstcode.commonlib.okhttp.request.CommonRequest;
import com.gaigai.firstcode.commonlib.okhttp.request.RequestParams;
import com.gaigai.firstcode.video_client.module.recommand.BaseRecommandModel;

import okhttp3.Request;

/**
 * Created by ga on 2017/2/16.
 */

public class RequestCenter {

    /**
     * 发送Post请求
     * @param url
     * @param params
     * @param callBack
     * @param clazz
     */
    public static void postRequest(String url, RequestParams params, HttpCallBack callBack,
                                   Class<?> clazz){
        CommonOkHttpClient.get(CommonRequest.createGetRequest(url, params)
        , new DataHandler(callBack, clazz));
    }

    public static void requestRecommandData(HttpCallBack callBack){
        RequestCenter.postRequest(HttpConstants.HOME_RECOMMAND, null, callBack, BaseRecommandModel.class);
    }
}
