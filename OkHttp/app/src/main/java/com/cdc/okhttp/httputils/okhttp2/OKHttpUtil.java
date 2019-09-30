package com.cdc.okhttp.httputils.okhttp2;

import android.os.Handler;
import android.os.Looper;

import com.cdc.okhttp.MLog;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpUtil implements DeliveryResult {
    private final static String TAG="OKHttpUtil";
    private static OKHttpUtil mInstance; //当前实例
    private final HttpUtil httpUtil;
    private OkHttpClient mOkHttpClient;
    private Handler mDelivery;
    private Gson mGson;
    private final Map map;
    //get请求
    private GetDelegate getDelegate = new GetDelegate(this);

    public GetDelegate getGetDelegate() {
        return getDelegate;
    }

    //上传文件的模块
    private UploadDelegate mUploadDelegate;


    public UploadDelegate getUploadDelegate() {
        return mUploadDelegate;
    }

    private PostDelegate postDelegate;

    public PostDelegate getPostDelegate(){
        return postDelegate;
    }

    private OKHttpUtil() {
        httpUtil=new HttpUtil();
        map = new HashMap();
        postDelegate=new PostDelegate(httpUtil,this);
        mUploadDelegate=new UploadDelegate(httpUtil,map,this);
        mOkHttpClient = new OkHttpClient.Builder()
                .callTimeout(1000, TimeUnit.SECONDS)
                .connectTimeout(1000, TimeUnit.SECONDS)
                .readTimeout(1000, TimeUnit.SECONDS)
                .build();
        //要刷新UI，handler要用到主线程的looper。那么在主线程 Handler handler = new Handler();
        //如果在其他线程，也要满足这个功能的话，要Handler handler = new Handler(Looper.getMainLooper());
        mDelivery = new Handler(Looper.getMainLooper());
        mGson = new Gson();
    }

    public static OKHttpUtil getInstance() {
        if (mInstance == null) {
            synchronized (OKHttpUtil.class) {
                if (mInstance == null) {
                    mInstance = new OKHttpUtil();
                }
            }
        }
        return mInstance;
    }


    //get请求接口
    public static void getAsync(String url, ResultCallback callback) {
        getInstance().getGetDelegate().getAsync(url, callback);
    }

    public static void getAsync(String url, String token, ResultCallback callback) {
        getInstance().getGetDelegate().getAsync(url, token, callback, null);
    }

    public static void getAsync(String url, ResultCallback callback, Object tag) {
        getInstance().getGetDelegate().getAsync(url, null, callback, tag);
    }


    //post请求
    public static void postAsync(String url, Param[] params, final ResultCallback callback, Object tag) {
        getInstance().getPostDelegate().postAsync(url, params, callback, tag);
    }

    public static void postAsync(String url, Map<String, String> params, final ResultCallback callback) {
        getInstance().getPostDelegate().postAsync(url, params, callback, null);
    }

    //添加了一个请求头
    public static void postAsync(String url, String token, Map<String, String> params, final ResultCallback callback) {
        getInstance().getPostDelegate().postAsync(url, token, params, callback, null);
    }

    public static void postAsync(String url, Map<String, String> params, final ResultCallback callback, Object tag) {
        getInstance().getPostDelegate().postAsync(url, params, callback, tag);
    }

    @Override
    public void deliveryResult(ResultCallback callback, final Request request) {
        final ResultCallback resCallBack = callback;
        //UI thread 主线程 开始请求数据
        callback.onBefore(request);

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                sendFailedStringCallback(request, e, resCallBack);
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    final String string = response.body().string();
                    sendSuccessResultCallback(string, resCallBack,call.request());
                    call.cancel();
                } catch (IOException e) {
                    sendFailedStringCallback(response.request(), e, resCallBack);
                } catch (com.google.gson.JsonParseException e){//Json解析的错误
                    sendFailedStringCallback(response.request(), e, resCallBack);
                }
            }
        });
    }






    //发送请求失败信息
    private void sendFailedStringCallback(final Request request, final Exception e, final ResultCallback callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(request, e);
                callback.onAfter();
            }
        });
    }


    //发送请求成功信息
    private void sendSuccessResultCallback(final String object, final ResultCallback callback, Request request) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                callback.onResponse(object,request);
                callback.onAfter();
            }
        });
    }




}
