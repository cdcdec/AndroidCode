package com.cdc.okhttp.httputils.okhttp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.cdc.DialogUtils;
import com.cdc.okhttp.LoadingUtil;
import com.cdc.okhttp.MLog;
import com.cdc.okhttp.R;
import com.shape.SuperButton;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

public class OKHttp1Activity extends AppCompatActivity implements View.OnClickListener{


    private SuperButton btnGet;
    private SuperButton btnPost;
    private SuperButton btnFile1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp1);
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

    private String url1 = "http://app.taoyitaoshop.com/ymapi/Public/yimei/?service=Other.GetAppStartImage";

    private String url2 = "http://app.taoyitaoshop.com/ymapi/Public/yimei/?service=Index.GetIndexInfo";
    private void requestGet() {

        LoadingUtil.createLoadingDialog(this, "正在加载...");

        OKHttpUtil.getAsync(url1, new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                LoadingUtil.closeDialog();
            }

            @Override
            public void onResponse(Data response,Request request) {
                LoadingUtil.closeDialog();
                DialogUtils.longMessageDialog(OKHttp1Activity.this,response.string());
                /*MLog.e(response.string());
                MLog.e(request.url());*/
            }
        });
    }


    private void requestPost(){
        Map map=new HashMap();
        map.clear();
        map.put("city", "漯河");
        map.put("industry_id", 0);//先传默认的行业值
        map.put("sort_type", 0);//先传默认的行业值
        map.put("pageno", 1);//当前页数
        map.put("pagesize", 6);
        LoadingUtil.createLoadingDialog(this, "正在加载...");
        OKHttpUtil.postAsync(url2, map, new ResultCallback(){
            @Override
            public void onError(Request request, Exception e) {
                LoadingUtil.closeDialog();
            }

            @Override
            public void onResponse(Data response, Request request) {
                LoadingUtil.closeDialog();
                DialogUtils.longMessageDialog(OKHttp1Activity.this,response.getInfoData());
                /*MLog.e(response.string());
                MLog.e(request.url());*/
            }
        });
    }
}
