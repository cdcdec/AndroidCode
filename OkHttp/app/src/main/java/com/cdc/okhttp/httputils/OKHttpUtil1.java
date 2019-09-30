package com.cdc.okhttp.httputils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.cdc.okhttp.MLog;
import com.cdc.okhttp.httputils.okhttp1.Data;
import com.cdc.okhttp.httputils.okhttp1.HttpUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpUtil1 {
    private final static String TAG="OKHttpUtil";
    private static OKHttpUtil1 mInstance; //当前实例
    private final HttpUtil httpUtil;
    private OkHttpClient mOkHttpClient;
    private Handler mDelivery;
    private Gson mGson;
    private final Map map;
    //get请求
    private GetDelegate getDelegate = new GetDelegate();

    public GetDelegate getGetDelegate() {
        return getDelegate;
    }


    private PostDelegate postDelegate=new PostDelegate();

    public PostDelegate getPostDelegate(){
        return postDelegate;
    }

    private OKHttpUtil1() {
        httpUtil=new HttpUtil();
        map = new HashMap();
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

    public static OKHttpUtil1 getInstance() {
        if (mInstance == null) {
            synchronized (OKHttpUtil1.class) {
                if (mInstance == null) {
                    mInstance = new OKHttpUtil1();
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


    /**
     * 将Map集合转到Param数组中
     * @param params
     * @return
     */
    private Param[] mapToParams(Map<String, String> params) {
        if (params == null)
            return new Param[0];
        int size = params.size();
        Param[] res = new Param[size];
        Set<Map.Entry<String, String>> entries = params.entrySet();
        int i = 0;
        for (Map.Entry<String, String> entry : entries) {
            res[i++] = new Param(entry.getKey(), entry.getValue());
        }
        return res;
    }

    //*******************回调函数*****************************************************
    public static abstract class ResultCallback {
        public void onBefore(Request request) {
        }

        public void onAfter() {
        }

        public abstract void onError(Request request, Exception e);

        public abstract void onResponse(Data response, Request request);
    }
    //*******************回调函数*****************************************************

    //*******************参数*****************************************************
    public static class Param {
        public Param(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String key;
        String value;
    }
    //*******************参数*****************************************************

    //*******************GET请求模块结束********************************************
    public class GetDelegate {
        private Request buildGetRequest(String url, String token, Object tag) {
            Request.Builder builder = new Request.Builder()
                    .header("Connection", "close")
                    .url(url);
            if (tag != null) {
                builder.tag(tag);
            }
            if (!TextUtils.isEmpty(token)) {
                builder.header("Token", token);
            }
            return builder.build();
        }

        //异步的get请求
        public void getAsync(String url, final ResultCallback callback) {
            getAsync(url, null, callback, null);
        }

        public void getAsync(String url, String token, final ResultCallback callback, Object tag) {
            final Request request = buildGetRequest(url, token, tag);
            getAsync(request, callback);
        }

        public void getAsync(Request request, ResultCallback callback) {
            deliveryResult(callback, request);
        }
    }

    //*******************GET请求模块结束********************************************
    //*******************POST请求模块开始********************************************

    public class PostDelegate {
        private Request buildPostFormRequest(String url, String token, Param[] params, Object tag) {
            if (params == null) {
                params = new Param[0];
            }
            FormBody.Builder builder = new FormBody.Builder();
            for (Param param : params) {
                builder.add(param.key, param.value);
            }
            RequestBody requestBody = builder.build();
            Request.Builder reqBuilder = new Request.Builder();
            // TODO: 2017/8/2 做了修改,主要就是在http header里面增加关闭连接，不让它保持连接。
            //todo 解决unexpected end of stream on okhttp3.Address@40cb7906这个异常
            reqBuilder.url(url)
                    .header("Connection", "close")
                    .post(requestBody);
            if (tag != null) {
                reqBuilder.tag(tag);
            }
            if (!TextUtils.isEmpty(token)) {
                reqBuilder.header("Token", token);
            }
            return reqBuilder.build();
        }

        //异步的post请求
        private void postAsync(String url, Param[] params, final ResultCallback callback, Object tag) {
            Request request = buildPostFormRequest(url, null, params, tag);
            deliveryResult(callback, request);
        }

        public void postAsync(String url, String token, Param[] params, final ResultCallback callback, Object tag) {
            Request request = buildPostFormRequest(url, token, params, tag);
            deliveryResult(callback, request);
        }

        public void postAsync(String url, Map<String, String> params, final ResultCallback callback, Object tag) {
            long time = System.currentTimeMillis();//获取系统时间的10位的时间戳
            String str = String.valueOf(time);
            String info = httpUtil.encrypt(params, str);
            map.clear();
            map.put("key", str);
            map.put("info", info);
            Param[] paramsArr = mapToParams(map);
            postAsync(url, paramsArr, callback, tag);
        }


        public void postAsync(String url, String token, Map<String, String> params, final ResultCallback callback, Object tag) {
            Param[] paramsArr = mapToParams(params);
            postAsync(url, token, paramsArr, callback, tag);
        }
    }
    //*******************POST请求模块结束********************************************


    //*******************上传文件请求模块开始********************************************
    //*******************上传文件请求模块结束********************************************

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
    private void sendSuccessResultCallback(final Data object, final ResultCallback callback,Request request) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                callback.onResponse(object,request);
                callback.onAfter();
            }
        });
    }

    //通用的异步请求回掉
    private void deliveryResult(ResultCallback callback, final Request request) {
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
                    Data baseData = mGson.fromJson(string.trim(), Data.class);
                    //服务端 加密后的数据
                    String data = baseData.getData();
                    MLog.e(TAG,"服务端加密后的数据data",data);
                    //解密需要用的key
                    String key = baseData.getKey();
                    HttpUtil httpUtils = new HttpUtil();
                    String decrypt = null;
                    try {
                        decrypt = httpUtils.decrypt(data, key);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MLog.e(TAG,TAG,"解密后的数据",decrypt.trim());
                    baseData.setInfoData(decrypt.trim());
                    sendSuccessResultCallback(baseData, resCallBack,call.request());
                    call.cancel();
                } catch (IOException e) {
                    sendFailedStringCallback(response.request(), e, resCallBack);
                } catch (com.google.gson.JsonParseException e){//Json解析的错误
                    sendFailedStringCallback(response.request(), e, resCallBack);
                }
            }
        });
    }


}
