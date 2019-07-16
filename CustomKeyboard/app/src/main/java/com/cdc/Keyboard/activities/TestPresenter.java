package com.cdc.keyboard.activities;

import android.util.Log;
import com.cdc.keyboard.basic.api.Api;
import com.cdc.keyboard.basic.api.BasePresenter;
import com.cdc.keyboard.basic.api.RxSchedulers;
import com.cdc.keyboard.beans.WeatherResultBean;
import io.reactivex.observers.DisposableObserver;

public class TestPresenter extends BasePresenter<TestActivity> {

    public void request(){
        Api.getInstance().getApiService().getWeatherInfo("101010100")
                .compose(RxSchedulers.compose())
                .subscribe(new DisposableObserver<WeatherResultBean>() {
                    @Override
                    public void onNext(WeatherResultBean weatherResultBean) {
                        Log.e("1213","onNext");
                        Log.e("1213",weatherResultBean.getMessage());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("1213","onError"+e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("1213","onComplete");
                    }
                });
    }


}
