package com.gyf.immersionbar.simple.myimmerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.gyf.immersionbar.simple.R;
import com.gyf.immersionbar.simple.activity.BaseActivity;

public class MyPicDemoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_pic_demo;
    }
}
