package com.gaigai.firstcode.commonlib.okhttp.listener;

/**
 * 请求结果数据封装处理
 * Created by ga on 2017/2/16.
 */

public class DataHandler {

    public HttpCallBack mHttpCallBack;
    public Class<?> mClass= null;
    public String mSource;

    public DataHandler(HttpCallBack httpCallBack) {
        mHttpCallBack = httpCallBack;
    }

    public DataHandler(HttpCallBack httpCallBack, Class<?> aClass) {
        mClass = aClass;
        mHttpCallBack = httpCallBack;
    }

    public DataHandler(HttpCallBack httpCallBack, String source) {
        mHttpCallBack = httpCallBack;
        mSource = source;
    }
}
