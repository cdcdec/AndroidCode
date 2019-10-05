package com.cdc.okhttp.httputils.okhttp2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.cdc.DialogUtils;
import com.cdc.okhttp.LoadingUtil;
import com.cdc.okhttp.R;
import com.shape.SuperButton;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

public class OKHttp2Activity extends AppCompatActivity implements View.OnClickListener{


    private SuperButton btnGet;
    private SuperButton btnPost;
    private SuperButton btnFile1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp2);
        initView();
    }
    private void initView(){
        btnGet=this.findViewById(R.id.btnGet);
        btnPost=this.findViewById(R.id.btnPost);
        btnFile1=this.findViewById(R.id.btnFile1);
        btnGet.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnFile1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnGet:

                requestGet();

                break;
            case R.id.btnPost:
                requestPost();
                break;
            case R.id.btnFile1:

                break;
        }
    }

    private String url3 = "http://192.168.10.219:8080/sptapi_v2.0/person";

    private String url2 = "http://192.168.10.219:8080/sptapi_v2.0/origin";
    private void requestGet() {

        LoadingUtil.createLoadingDialog(this, "正在加载...");

        OKHttpUtil.getAsync(url3, new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                LoadingUtil.closeDialog();
            }

            @Override
            public void onResponse(String response, Request request) {
                LoadingUtil.closeDialog();
                DialogUtils.longMessageDialog(OKHttp2Activity.this,response);
            }

        });
    }


    private void requestPost(){
        Map map=new HashMap();
        map.clear();
        map.put("id", "1");
        LoadingUtil.createLoadingDialog(this, "正在加载...");
        OKHttpUtil.postAsync(url2, map, new ResultCallback(){
            @Override
            public void onError(Request request, Exception e) {
                LoadingUtil.closeDialog();
            }

            @Override
            public void onResponse(String response, Request request) {
                LoadingUtil.closeDialog();
                DialogUtils.longMessageDialog(OKHttp2Activity.this,response);
            }
        });
    }
}
