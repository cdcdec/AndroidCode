package com.cdc.keyboard.basic;

import android.os.Bundle;
import com.cdc.keyboard.basic.api.BasePresenter;

public abstract class  BaseActivity<P extends BasePresenter> extends RootActivity{
    protected P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initCreate(savedInstanceState);
        mPresenter = setPresenter();
        mPresenter.attachView(this);
        mPresenter.setContext(this);
        initView();
        initData();
    }
    protected abstract void initCreate(Bundle savedInstanceState);
    protected abstract void initView();
    protected abstract void initData();
    protected abstract P setPresenter();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
