package com.cdc.keyboard.basic.api;

import com.cdc.keyboard.basic.RootApplication;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class CookieSaveInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Response response=chain.proceed(request);
        HashSet<String> cookies=new HashSet<>();
        if (!response.headers("Set-Cookie").isEmpty()) {
            List<String> lists=response.headers("Set-Cookie");
            for (String string:lists) {
                cookies.add(string);
                RootApplication.getPreferenceManager().setttpCookie(cookies);
            }

        }
        return response;

    }
}
