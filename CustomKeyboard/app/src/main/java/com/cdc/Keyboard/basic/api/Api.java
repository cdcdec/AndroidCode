package com.cdc.keyboard.basic.api;

import com.cdc.keyboard.log.HttpLogger;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 单例模式
 * https://www.jianshu.com/p/829a523c32aa
 */
public class Api {
    private String baseUrl="http://t.weather.itboy.net/api/weather/";
    private volatile static Api api = null;
    private Api () {}

    public static Api getInstance() {
        if (api == null) {
            synchronized (Api.class) {
                if (api == null) {
                    api = new Api();
                }
            }
        }
        return api;
    }

    private HttpLoggingInterceptor getLoggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor(new HttpLogger());
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


    private OkHttpClient okHttpClient=new OkHttpClient.Builder()
            .addNetworkInterceptor(getLoggingInterceptor())
            .addInterceptor(new LoginInterceptor())
            .addInterceptor(new CookieSaveInterceptor())
            .build();


    public Retrofit retrofit=new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build();


    public ApiService getApiService(){
        ApiService apiService=retrofit.create(ApiService.class);
        return apiService;
    }








}



