package com.vector.appupdatedemo;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.zhy.http.okhttp.OkHttpUtils;

/**
 * Created by Vector
 * on 2017/7/17 0017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpUtils.getInstance()
               // .init(this)
                .debug( "okHttp",true);


        OkGo.getInstance().init(this);
    }
}
