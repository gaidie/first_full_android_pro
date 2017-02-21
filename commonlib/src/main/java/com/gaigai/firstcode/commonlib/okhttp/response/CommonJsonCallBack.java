package com.gaigai.firstcode.commonlib.okhttp.response;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.gaigai.firstcode.commonlib.okhttp.exception.HttpException;
import com.gaigai.firstcode.commonlib.okhttp.listener.DataHandler;
import com.gaigai.firstcode.commonlib.okhttp.listener.HttpCallBack;
import com.gaigai.firstcode.commonlib.util.ResponseEntityToModule;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by ga on 2017/2/16.
 */

public class CommonJsonCallBack implements Callback{

    public static final String RESULT_CODE_KEY = "result_code";
    public static final int RESULT_CODE_VALUE = 0;
    public static final String ERROR_MSG_KEY = "msg";
    public final String EMPTY_MSG = "";
    public final String COOKIE_STORE = "Set-Cookie";

    /**
     * 定义请求错误常量
     */
    public static final int JSON_ERROR =  -1;
    public static final int NET_ERROR = -2;
    public static final int UNKONW_ERROR = -3;

    /**
     * 将请求结果用Handler传递到UI线程
     */
    private Handler mPostUiHandler;
    private HttpCallBack mHttpCallBack;
    private Class<?> mClass;

    public CommonJsonCallBack(DataHandler handler){
        this.mHttpCallBack = handler.mHttpCallBack;
        this.mClass = handler.mClass;
        this.mPostUiHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onFailure(Call call, final IOException e) {
        mPostUiHandler.post(new Runnable() {
            @Override
            public void run() {
                mHttpCallBack.onError(new HttpException(NET_ERROR, e));
            }
        });

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result = response.body().string();//获取返回结果
        ArrayList<String> cookieLists = handleCookie(response.headers());
        mPostUiHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
                // // TODO: 2017/2/16  cookie待处理 
            }
        });
    }

    private void handleResponse(Object result) {
        if (result == null || result.toString().equals("")){
            mHttpCallBack.onError(new HttpException(NET_ERROR, EMPTY_MSG));//返回空
            return;
        }
        try {
            JSONObject jsonObject = new JSONObject(result.toString());
            if (mClass == null){
                mHttpCallBack.onError(jsonObject);
            }else {
                Object obj = ResponseEntityToModule.parseJsonObjectToModule(jsonObject, mClass);//转化为对应的class bean
                if (obj != null){
                    mHttpCallBack.onSuccess(obj);
                }else {
                    mHttpCallBack.onError(new HttpException(JSON_ERROR, EMPTY_MSG));
                }
            }
        }catch (Exception e){
            mHttpCallBack.onError(new HttpException(UNKONW_ERROR, e.getMessage()));
            Log.e(TAG, "handleResponse: "+  e.getMessage());
        }

    }

    /**
     * 这是Cookie相关信息
     * @param headers
     * @return
     */
    private ArrayList<String> handleCookie(Headers headers) {
        ArrayList<String> tempList = new ArrayList<String>();
        for (int i = 0, size = tempList.size(); i < size; i++){
            if (headers.name(i).equalsIgnoreCase(COOKIE_STORE)){
                tempList.add(headers.value(i));
            }
        }
        return tempList;
    }
}
