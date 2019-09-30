package com.cdc.okhttp.httputils.okhttp1;

import okhttp3.Request;

public abstract class ResultCallback {
    public void onBefore(Request request) {
    }

    public void onAfter() {
    }

    public abstract void onError(Request request, Exception e);

    public abstract void onResponse(Data response,Request request);
}
