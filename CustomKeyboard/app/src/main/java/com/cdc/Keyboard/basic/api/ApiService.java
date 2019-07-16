package com.cdc.keyboard.basic.api;

import com.cdc.keyboard.beans.WeatherResultBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("city/{cityCode}")
    Observable<WeatherResultBean> getWeatherInfo(@Path("cityCode")String cityCode);


}
