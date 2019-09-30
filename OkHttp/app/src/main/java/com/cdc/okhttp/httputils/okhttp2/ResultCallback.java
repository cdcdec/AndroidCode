package com.cdc.okhttp.httputils.okhttp2;

import okhttp3.Request;

public abstract class ResultCallback {
    public void onBefore(Request request) {
    }

    public void onAfter() {
    }

    public abstract void onError(Request request, Exception e);

    public abstract void onResponse(String response, Request request);
}
