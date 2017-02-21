package com.gaigai.firstcode.commonlib.okhttp.request;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * 生成Request对象
 * Created by ga on 2017/2/15.
 */

public class CommonRequest {

    /**
     * 封装Post请求
     * @param url
     * @param params
     * @return
     */
    public  static Request createPostRequest(String url, RequestParams params){
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null){
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()){
                //将请求参数遍历添加到我们的请求构建类中
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        //通过FormBody.Builder获取请求体对象
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        return request;
    }

    /**
     * 构造Get请求的Request对象
     * @param url
     * @param params
     * @return
     */
    public static Request createGetRequest(String url, RequestParams params){
        StringBuilder builder = new StringBuilder(url).append("?");
        if (params != null){
            for (Map.Entry entry : params.urlParams.entrySet()){
                builder.append(entry.getKey())
                        .append("=")
                        .append(entry.getKey())
                        .append("&");
                //此处参数封装多了一个&字符 最后需要截取一下
            }
        }
        Request request = new Request.Builder()
                .url(builder.substring(0, builder.length() - 1))
                .get().build();
        return request;
    }

}
