package com.gaigai.firstcode.commonlib.okhttp.request;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 封装所有的请求参数到HashMap中
 * Created by ga on 2017/2/15.
 */

public class RequestParams {

    public ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Object> fileParams = new ConcurrentHashMap<>();

    public RequestParams(){
        this((Map<String,String>)null);
    }


    public RequestParams(Map<String, String> source) {
        if (source != null){
            for (Map.Entry<String, String> entry : source.entrySet()){
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void put(String key, String value){
        if (key != null && value != null){
            urlParams.put(key, value);
        }
    }

    public void put(String key, Object value){
        if (key != null && value != null){
            fileParams.put(key, value);
        }
    }

    /**
     * 是否需要传递参数
     * @return
     */
    public boolean hasParams(){
        if (urlParams.size() > 0 || fileParams.size() > 0){
            return true;
        }
        return false;
    }

}
