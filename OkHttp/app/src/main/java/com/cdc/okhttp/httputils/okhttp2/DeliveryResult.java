package com.cdc.okhttp.httputils.okhttp2;

import okhttp3.Request;

public interface DeliveryResult {
    void deliveryResult(ResultCallback callback, final Request request);
}
