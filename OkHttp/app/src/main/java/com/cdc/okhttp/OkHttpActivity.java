package com.cdc.okhttp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.cdc.okhttp.httputils.okhttp2.OKHttpUtil;
import com.cdc.okhttp.httputils.okhttp2.ResultCallback;

import okhttp3.Request;

public class OkHttpActivity extends AppCompatActivity {
    private String url1 = "http://app.taoyitaoshop.com/ymapi/Public/yimei/?service=Other.GetAppStartImage";

    private String url2 = "http://app.taoyitaoshop.com/ymapi/Public/yimei/?service=Index.GetIndexInfo";


    private String url3 = "http://192.168.10.219:8080/sptapi_v2.0/person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        requestGetBy2();
    }

    private void requestGetBy2(){
        OKHttpUtil.getAsync(url3, new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response, Request request) {
                MLog.e(response);
            }
        });
    }

   /* private void requestPost(){
        Map map=new HashMap();
        map.clear();
        map.put("city", "漯河");
        map.put("industry_id", 0);//先传默认的行业值
        map.put("sort_type", 0);//先传默认的行业值
        map.put("pageno", 1);//当前页数
        map.put("pagesize", 6);
        OKHttpUtil.postAsync(url2, map, new ResultCallback(){
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(Data response, Request request) {
                MLog.e(response.string());
                MLog.e(request.url());
            }
        });
    }

    private void requestGet() {

        OKHttpUtil.getAsync(url1, new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(Data response,Request request) {
                MLog.e(response.string());
                MLog.e(request.url());
            }
        });


    }*/

}
