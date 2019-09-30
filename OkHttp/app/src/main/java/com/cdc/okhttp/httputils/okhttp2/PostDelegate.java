package com.cdc.okhttp.httputils.okhttp2;

import android.text.TextUtils;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

public class PostDelegate{

    private HttpUtil httpUtil;
    private DeliveryResult deliveryResult;
    public PostDelegate(HttpUtil httpUtil, DeliveryResult deliveryResult){
        this.httpUtil=httpUtil;
        this.deliveryResult=deliveryResult;
    }
    private Request buildPostFormRequest(String url, String token, Param[] params, Object tag) {
        if (params == null) {
            params = new Param[0];
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Param param : params) {
            builder.add(param.key, param.value);
        }
        RequestBody requestBody = builder.build();
        Request.Builder reqBuilder = new Request.Builder();
        // TODO: 2017/8/2 做了修改,主要就是在http header里面增加关闭连接，不让它保持连接。
        //todo 解决unexpected end of stream on okhttp3.Address@40cb7906这个异常
        reqBuilder.url(url)
                .header("Connection", "close")
                .post(requestBody);
        if (tag != null) {
            reqBuilder.tag(tag);
        }
        if (!TextUtils.isEmpty(token)) {
            reqBuilder.header("Token", token);
        }
        return reqBuilder.build();
    }

    //异步的post请求
    public void postAsync(String url, Param[] params, final ResultCallback callback, Object tag) {
        Request request = buildPostFormRequest(url, null, params, tag);
        deliveryResult.deliveryResult(callback, request);
    }

    public void postAsync(String url, String token, Param[] params, final ResultCallback callback, Object tag) {
        Request request = buildPostFormRequest(url, token, params, tag);
        deliveryResult.deliveryResult(callback, request);
    }

    public void postAsync(String url, Map<String, String> params, final ResultCallback callback, Object tag) {
        Param[] paramsArr = httpUtil.mapToParams(params);
        postAsync(url, paramsArr, callback, tag);
    }


    public void postAsync(String url, String token, Map<String, String> params, final ResultCallback callback, Object tag) {
        Param[] paramsArr = httpUtil.mapToParams(params);
        postAsync(url, token, paramsArr, callback, tag);
    }
}
