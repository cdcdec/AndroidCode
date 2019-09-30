package com.cdc.okhttp.httputils.okhttp1;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

public class UploadDelegate{
    private HttpUtil httpUtil;
    private Map map;
    private DeliveryResult deliveryResult;
    public UploadDelegate(HttpUtil httpUtil,Map map,DeliveryResult deliveryResult){
        this.httpUtil=httpUtil;
        this.map=map;
        this.deliveryResult=deliveryResult;
    }
    private Request buildMultipartFormRequest(String url, File[] files, String[] fileKeys, Param[] params, Object tag) {
        //检查参数是否为空
        params = validateParam(params);
        /* form的分割线,自己定义 */
        String boundary = "xx--------------------------------------------------------------xx";
        MultipartBody.Builder mBody = new MultipartBody.Builder(boundary).setType(MultipartBody.FORM);
        for (Param param : params) {
            mBody.addFormDataPart(param.key, param.value);
        }
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), files[i]);
                mBody.addFormDataPart(fileKeys[i], files[i].getName(), fileBody);
            }
        }
        RequestBody requestBody = mBody.build();
        return new Request.Builder().url(url).post(requestBody).tag(tag).build();
    }

    private Param[] validateParam(Param[] params) {
        if (params == null)
            return new Param[0];
        else
            return params;
    }

    //异步基于post的文件上传，单文件且携带其他form参数上传
    public void postAsync(String url, String fileKey, File file, Map<String, String> params, ResultCallback callback) {
        postAsync(url, new String[]{fileKey}, new File[]{file}, params, callback, null);
    }

    public void postAsync(String url, String fileKey, File file, Param[] params, ResultCallback callback) {
        postAsync(url, new String[]{fileKey}, new File[]{file}, params, callback, null);
    }

    public void postAsync(String url, String fileKey, File file, Param[] params, ResultCallback callback, Object tag) {
        postAsync(url, new String[]{fileKey}, new File[]{file}, params, callback, tag);
    }

    //多文件上传（一个文件名对应一个文件）
    public void postAsync(String url, String[] fileKeys, File[] files, Map<String, String> params, ResultCallback callback) {
        // TODO: 2017/8/1 添加
        long time = System.currentTimeMillis();//获取系统时间的10位的时间戳
        String str = String.valueOf(time);
        String info = httpUtil.encrypt(params, str);
        //MLog.e(TAG,"系统时间-->" + str,"需要加密传给后台的参数info=" + info);
        map.clear();
        map.put("key", str);
        map.put("info", info);
        Param[] paramsArr = httpUtil.mapToParams(map);
        postAsync(url, fileKeys, files, paramsArr, callback, null);
    }

    public void postAsync(String url, String[] fileKeys, File[] files, Map<String, String> params, ResultCallback callback, Object tag) {
        Param[] paramsArr = httpUtil.mapToParams(params);
        postAsync(url, fileKeys, files, paramsArr, callback, tag);
    }

    public void postAsync(String url, String[] fileKeys, File[] files, Param[] params, ResultCallback callback) {
        postAsync(url, fileKeys, files, params, callback, null);
    }

    public void postAsync(String url, String[] fileKeys, File[] files, Param[] params, ResultCallback callback, Object tag) {
        Request request = buildMultipartFormRequest(url, files, fileKeys, params, tag);
        deliveryResult.deliveryResult(callback, request);
    }


}
