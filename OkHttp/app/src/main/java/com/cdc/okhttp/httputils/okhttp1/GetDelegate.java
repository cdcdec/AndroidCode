package com.cdc.okhttp.httputils.okhttp1;

import android.text.TextUtils;
import okhttp3.Request;

public class GetDelegate{
    private DeliveryResult deliveryResult;
    public GetDelegate(DeliveryResult deliveryResult){
        this.deliveryResult=deliveryResult;
    }
    private Request buildGetRequest(String url, String token, Object tag) {
        Request.Builder builder = new Request.Builder()
                .header("Connection", "close")
                .url(url);
        if (tag != null) {
            builder.tag(tag);
        }
        if (!TextUtils.isEmpty(token)) {
            builder.header("Token", token);
        }
        return builder.build();
    }

    //异步的get请求
    public void getAsync(String url, final ResultCallback callback) {
        getAsync(url, null, callback, null);
    }

    public void getAsync(String url, String token, final ResultCallback callback, Object tag) {
        final Request request = buildGetRequest(url, token, tag);
        getAsync(request, callback);
    }

    public void getAsync(Request request, ResultCallback callback) {
        deliveryResult.deliveryResult(callback, request);
    }
}
