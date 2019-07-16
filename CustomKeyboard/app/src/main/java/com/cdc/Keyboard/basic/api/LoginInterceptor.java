package com.cdc.keyboard.basic.api;

import com.cdc.keyboard.basic.RootApplication;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashSet;

public class LoginInterceptor implements Interceptor {
    /**
     * 添加公共Header
     */
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request origin = chain.request();
        Request.Builder builder = origin.newBuilder()
                .addHeader("token", "")
                .addHeader("account", "");
        HashSet<String> hashSet= RootApplication.getPreferenceManager().getHttpCookie();
        for (String in: hashSet) {
            builder.addHeader("Cookie", in);
        }
        return chain.proceed(builder.build());
    }
}
