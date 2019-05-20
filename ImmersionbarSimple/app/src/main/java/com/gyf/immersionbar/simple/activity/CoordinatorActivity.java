package com.gyf.immersionbar.simple.activity;

import android.annotation.SuppressLint;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.simple.R;
import com.gyf.immersionbar.simple.utils.Utils;

import butterknife.BindView;

/**
 * @author geyifeng
 * @date 2017/5/30
 */
public class CoordinatorActivity extends BaseActivity {
    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.text)
    TextView textView;
    @BindView(R.id.mIv)
    ImageView mIv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_coordinator;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).titleBar(toolbar).init();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        super.initView();
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        textView.setText("关于Snackbar在4.4和emui3.1上高度显示不准确的问题是由于沉浸式使用了系统的" +
                "WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS或者WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION" +
                "属性造成的，目前尚不知有什么解决办法");
        Glide.with(this).asBitmap().load(Utils.getPic())
                .apply(new RequestOptions().placeholder(R.mipmap.test))
                .into(mIv);
    }

    @Override
    protected void setListener() {
        fab.setOnClickListener(view -> Snackbar.make(view, "我是Snackbar", Snackbar.LENGTH_LONG).show());
        //toolbar返回按钮监听
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}
