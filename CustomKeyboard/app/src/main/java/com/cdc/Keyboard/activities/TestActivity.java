package com.cdc.keyboard.activities;

import android.os.Bundle;
import com.cdc.keyboard.R;
import com.cdc.keyboard.basic.BaseActivity;
import com.cdc.keyboard.basic.api.BaseView;

public class TestActivity extends BaseActivity<TestPresenter> implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    protected void initCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test);
    }


    @Override
    protected TestPresenter setPresenter() {
        return new TestPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mPresenter.request();
    }
}
