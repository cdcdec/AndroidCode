package com.cdc.okhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.cdc.okhttp.httputils.okhttp1.OKHttp1Activity;
import com.cdc.okhttp.httputils.okhttp2.OKHttp2Activity;
import com.shape.ShapeLinearLayout;
import com.shape.SuperButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private SuperButton btn1;
    private SuperButton btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DisplayMetrics mMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
        MLog.e("MLog", mMetrics.toString());

        initView();
    }

    private void initView() {
        btn1 = this.findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 = this.findViewById(R.id.btn2);
        btn2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn1:
                goToPage(OKHttp1Activity.class);
                break;

            case R.id.btn2:
                goToPage(OKHttp2Activity.class);
                break;
        }
    }

    private void goToPage(Class cl) {
        Intent intent = new Intent(this, cl);
        startActivity(intent);
    }
}
//https://github.com/cheng2016/AndroidUIAdapter