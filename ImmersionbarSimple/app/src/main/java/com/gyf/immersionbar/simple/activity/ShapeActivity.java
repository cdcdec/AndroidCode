package com.gyf.immersionbar.simple.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.simple.R;

/**
 * @author geyifeng
 * @date 2017/6/6
 */
public class ShapeActivity extends AppCompatActivity{

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        ImmersionBar.with(this).titleBar(R.id.toolbar)
               .navigationBarColor(R.color.shape1)
               .init();

    }

//    @Override
//    protected int getLayoutId() {
//        return R.layout.activity_shape;
//    }
//
//    @Override
//    protected void initImmersionBar() {
//        //super.initImmersionBar();
//        ImmersionBar.with(this).titleBar(R.id.toolbar)
//                .navigationBarColor(R.color.shape1)
//                .init();
//    }
}
