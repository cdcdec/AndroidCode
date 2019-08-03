package com.yzx.tools;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.yzx.im_demo.userdata.GroupBean;
import com.yzx.im_demo.userdata.RestBean;
import com.yzxtcp.tools.CustomLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RestTools {
    public static final int LOGIN_STATUS_FAIL = -1;
    public static final int LOGIN_STATUS_SUCCESS = 0;
    public static final int LOGIN_STATUS_INPROCESS = 1;
    public static final int LOGIN_STATUS_TIMEOUT = 2;
    public static final int LOGIN_REST_TOKEN_OK = 3;
    public static final int LOGIN_REST_REGISTER_OK = 4;
    public static final int LOGIN_REST_HAS_REGISTER = 5;
    public static final int LOGIN_REST_UNREGISTER = 6;
    public static final int LOGIN_REST_REGISTER_FAIL = 7;
    public static final int LOGIN_REST_STARTGETTOKEN = 8;
    public static final int LOGIN_REST_STARTREGISTER = 9;
    public static final int LOGIN_REST_FINISH = 10;
    public static final int LOGIN_REST_GETTOKENFAIL = 11;
    public static final int LOGIN_REST_TOKEN_FAIL = 12;

    public static final int OBTAIN_VERI_CODE = 13;
    public static final int OBTAIN_VERI_BALANCE = 14;

    private static final String REST_REGISTER_SUCCESS = "0";
    private static final String REST_TOKEN_SUCCESS = "0";
    private static final String REST_HAS_REGISTER = "-1";
    private static final String REST_UNREGISTER = "-2";
    private static final String REST_REGISTER_FAIL = "-3";
    private static final String REST_NOTFINDGROUP_FAIL = "-4";
    private static final String REST_JOINGROUP_FAIL = "-5";
    private static final String TAG = RestTools.class.getSimpleName();
    //http://imas.ucpaas.com/


    //http://imactivity.ucpaas.com/
    private static String LOGIN_URL_PRE = "http://imactivity.ucpaas.com/"
            + "user/login.do?phone=";
    private static String REG_URL_PRE = "http://imactivity.ucpaas.com/"
            + "user/reg.do?";
    private static String GROUP_URL_PRE = "http://imactivity.ucpaas.com/user"
            + "/queryGroup.do?userid=";

    //验证码方式的URL
    //private static String VERI_ADDR = "http://202.105.136.106:18085/";
    private static String VERI_ADDR = "http://202.105.136.109:9098/";
    private static String VERI_URL_OBTAIN = VERI_ADDR + "ottdemoapi/getAuthcode.do";
    private static String VERI_URL_LOGIN = VERI_ADDR + "ottdemoapi/login.do";
    private static String VERI_URL_NICKNAME = VERI_ADDR + "ottdemoapi/updateNickname.do";
    private static String VERI_URL_BALANCE = VERI_ADDR + "ottdemoapi/getBalance.do";
    public static String mPhoneNum;
    public static String mToken;
    public static String mNickName;
    public static List<GroupBean> groupBeans;

    public static void initUrl(Context context) {
        String asAddressAndPort = context.getSharedPreferences("YZX_DEMO_DEFAULT", 0).getString("YZX_ASADDRESS", "");
        Log.i(TAG, "asAddressAndPort : " + asAddressAndPort);
        if (!TextUtils.isEmpty(asAddressAndPort)) {
            LOGIN_URL_PRE = "http://" + asAddressAndPort + "/user/login.do?phone=";
            REG_URL_PRE = "http://" + asAddressAndPort + "/user/reg.do?";
            GROUP_URL_PRE = "http://" + asAddressAndPort + "/ottdemoapi/queryGroup.do";
            VERI_ADDR = "http://" + asAddressAndPort + "/";
            VERI_URL_OBTAIN = VERI_ADDR + "ottdemoapi/getAuthcode.do";
            VERI_URL_OBTAIN = VERI_ADDR + "ottdemoapi/getAuthcode.do";
            VERI_URL_LOGIN = VERI_ADDR + "ottdemoapi/login.do";
            VERI_URL_NICKNAME = VERI_ADDR + "ottdemoapi/updateNickname.do";
            VERI_URL_BALANCE = VERI_ADDR + "ottdemoapi/getBalance.do";
        } else {
            //调测地址
            //VERI_ADDR = "http://"+"113.31.130.137:9098"+"/";
            //正式环境
            VERI_ADDR = "http://" + "imactivity.ucpaas.com" + "/";

            LOGIN_URL_PRE = VERI_ADDR + "user/login.do?phone=";
            REG_URL_PRE = VERI_ADDR + "user/reg.do?";
            GROUP_URL_PRE = VERI_ADDR + "ottdemoapi/queryGroup.do";

            VERI_URL_OBTAIN = VERI_ADDR + "ottdemoapi/getAuthcode.do";
            VERI_URL_OBTAIN = VERI_ADDR + "ottdemoapi/getAuthcode.do";
            VERI_URL_LOGIN = VERI_ADDR + "ottdemoapi/login.do";
            VERI_URL_NICKNAME = VERI_ADDR + "ottdemoapi/updateNickname.do";
            VERI_URL_BALANCE = VERI_ADDR + "ottdemoapi/getBalance.do";

        }
        /*
        String csAddressAndPort = context.getSharedPreferences("YZX_DEMO_DEFAULT", 0).getString("YZX_CSADDRESS", "");
		if(TextUtils.isEmpty(csAddressAndPort)){
		    //调测地址
		    context.getSharedPreferences("YZX_DEMO_DEFAULT", 0).edit().putString("YZX_CSADDRESS", "113.31.130.125:81").commit();
		}
		*/
    }

    /**
     * @param context
     * @param phoneNum 手机号(账号)
     * @param nickName 要注册的昵称
     * @param handler  回调
     * @return void    返回类型
     * @Description 注册昵称
     * @date 2015年12月17日 上午11:03:04
     * @author zhj
     */
    public static void accountRegister(final Context context, final String phoneNum,
                                       final String nickName, final Handler handler) {
        if (StringUtils.isEmpty(phoneNum) || StringUtils.isEmpty(nickName)
                || handler == null) {
            CustomLog.e("accountRegister 参数错误");
        }
        mPhoneNum = phoneNum;
        mNickName = nickName;
        CustomLog.e("accountRegister 注册昵称");

        new Thread(new Runnable() {
            Message msg = null;

            @Override
            public void run() {
                JSONObject json = new JSONObject();
                try {
                    json.put("phone", phoneNum);
                    json.put("nickname", nickName);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String param = json.toString();
                //进行base64加密
                param = Base64.encode(param.getBytes());
                String result = HttpUtils.doPost(VERI_URL_NICKNAME, param);
                if (result != null) {
                    String resultRet = "";
                    String token = null;
                    try {
                        JSONObject jsonResult = new JSONObject(result);
                        if (jsonResult.has("result")) {
                            resultRet = jsonResult.getString("result");
                            if (jsonResult.has("nickname"))
                                mNickName = jsonResult.getString("nickname");
                            if (jsonResult.has("token"))
                                mToken = jsonResult.getString("token");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if (resultRet.equals(REST_REGISTER_SUCCESS)) {
                        CustomLog.e("注册昵称成功");
                        msg = handler.obtainMessage(LOGIN_REST_TOKEN_OK);
                        //msg = handler.obtainMessage(LOGIN_REST_REGISTER_OK);
                        Bundle data = new Bundle();
                        data.putString("imtoken", mToken);
                        msg.setData(data);
                        handler.sendMessage(msg);
                    } else {
                        CustomLog.e("accountRegister fail result:" + resultRet);
                        msg = handler.obtainMessage(RestTools.LOGIN_STATUS_FAIL);
                        msg.arg1 = Integer.valueOf(resultRet);
                        handler.sendMessage(msg);
                    }
                }
            }
        }).start();
    }


    /**
     * @param context
     * @param phoneNum 手机号(账号)
     * @param veriCode 验证码
     * @param handler  回调handler
     * @return void    返回类型
     * @Description 使用账号和验证码登录认证
     * @date 2015年12月15日 下午9:02:18
     * @author zhj
     */
    public static void getToken(final Context context, final String phoneNum, final String veriCode, final Handler handler) {
        if (StringUtils.isEmpty(phoneNum) || handler == null) {
            CustomLog.e("getToken 参数错误");
            return;
        }
        mPhoneNum = phoneNum;

        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject json = new JSONObject();
                try {
                    json.put("phone", phoneNum);
                    json.put("auth_code", veriCode);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String param = json.toString();
                //进行base64加密
                param = Base64.encode(param.getBytes());
                String result = HttpUtils.doPost(VERI_URL_LOGIN, param);
                String resultRet = "-1";
                String token = null;
                String nikeName = null;
                Message msg = null;
                if (result != null) {
                    if (result != null && result.length() > 0) {
                        try {
                            JSONObject jsonResult = new JSONObject(result);
                            if (jsonResult.has("result")) {
                                resultRet = jsonResult.getString("result");
                                token = jsonResult.getString("token");
                                nikeName = jsonResult.getString("nickname");
                                mNickName = nikeName;
                                CustomLog.e("getToken nikeName:" + nikeName);
                                CustomLog.e("getToken token:" + token);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (resultRet.equals("0") && nikeName != null && nikeName.length() > 0) {
                        CustomLog.e("获取token成功");
                        mToken = token;
                        msg = handler.obtainMessage(LOGIN_REST_TOKEN_OK);
                        Bundle data = new Bundle();
                        data.putString("imtoken", token);
                        msg.setData(data);
                        handler.sendMessage(msg);
                    } else if (resultRet.equals("0") && (nikeName == null || nikeName.length() == 0)) {
                        CustomLog.e("获取token成功,昵称为空");
                        mToken = token;
                        msg = handler.obtainMessage(LOGIN_REST_UNREGISTER);
                        Bundle data = new Bundle();
                        data.putString("phoneNum", phoneNum);
                        data.putString("imtoken", token);
                        msg.setData(data);
                        handler.sendMessage(msg);
                    } else {
                        CustomLog.e("parseGetTokenJson unknow result:" + result);
                        msg = handler.obtainMessage(RestTools.LOGIN_STATUS_FAIL);
                        msg.arg1 = Integer.valueOf(resultRet);
                        handler.sendMessage(msg);
                    }
                } else {
                    CustomLog.e("parseGetTokenJson unknow result is null");
                    msg = handler.obtainMessage(RestTools.LOGIN_STATUS_FAIL);
                    msg.arg1 = Integer.valueOf(resultRet);
                    handler.sendMessage(msg);
                }
            }

        }).start();
    }

    /**
     * 使用固定已知token登录
     *
     * @param phoneNum
     * @param handler
     */
    public static void loginByToken(String phoneNum, Handler handler, String token) {
        mPhoneNum = "13631563280";
        mToken = token;
        mNickName =phoneNum;
        handler.sendEmptyMessage(RestTools.LOGIN_REST_STARTGETTOKEN);
        Message msg = handler.obtainMessage(RestTools.LOGIN_REST_TOKEN_OK);
        //msg = handler.obtainMessage(LOGIN_REST_REGISTER_OK);
        Bundle data = new Bundle();
        data.putString("imtoken", token);
        msg.setData(data);
        handler.sendMessage(msg);
    }

    /**
     * @param context  上下文
     * @param phoneNum 手机号码(账号)
     * @param handler  回掉handler
     * @return void    返回类型
     * @Description TODO(获取验证码)
     * @date 2015年12月15日 下午4:54:26
     * @author zhj
     */
    public static void getVeriCode(final Context context, final String phoneNum, final Handler handler) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject json = new JSONObject();
                try {
                    json.put("phone", phoneNum);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String param = json.toString();
                //进行base64加密
                param = Base64.encode(param.getBytes());
                String result = HttpUtils.doPost(VERI_URL_OBTAIN, param);
                String resultRet = "-1";
                String expireTime = "";
                if (result != null && result.length() > 0) {
                    try {
                        JSONObject jsonResult = new JSONObject(result);
                        if (jsonResult.has("result")) {
                            resultRet = jsonResult.getString("result");
                            expireTime = jsonResult.getString("expired");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                //获取结果上报
                Message msg = handler.obtainMessage(OBTAIN_VERI_CODE);
                msg.arg1 = Integer.valueOf(resultRet);
                Bundle data = new Bundle();
                data.putString("expireTime", expireTime);
                msg.setData(data);
                handler.sendMessage(msg);
            }

        }).start();


    }

    /**
     * @param context  上下文
     * @param phoneNum 手机号码
     * @param handler  回掉handler
     * @return void    返回类型
     * @Description 查询余额
     * @date 2015年12月19日 下午7:54:50
     * @author zhj
     */
    public static void queryBalance(final Context context, final String phoneNum, final Handler handler) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject json = new JSONObject();
                try {
                    json.put("phone", phoneNum);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String param = json.toString();
                //进行base64加密
                param = Base64.encode(param.getBytes());
                String result = HttpUtils.doPost(VERI_URL_BALANCE, param);
                String resultRet = "-1";
                String balance = "";
                if (result != null && result.length() > 0) {
                    try {
                        JSONObject jsonResult = new JSONObject(result);
                        if (jsonResult.has("result")) {
                            resultRet = jsonResult.getString("result");
                            balance = jsonResult.getString("balance");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                //获取结果上报
                Message msg = handler.obtainMessage(OBTAIN_VERI_BALANCE);
                msg.arg1 = Integer.valueOf(resultRet);
                Bundle data = new Bundle();
                data.putString("balance", balance);
                msg.setData(data);
                handler.sendMessage(msg);
            }

        }).start();
    }

    public static void queryGroupInfo(final Context context, final String phoneNum,
                                      final IGroupInfoCallBack callBack) {
        if (StringUtils.isEmpty(phoneNum)) {
            CustomLog.e("getGroupInfo 参数错误");
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                initUrl(context);
                JSONObject json = new JSONObject();
                try {
                    json.put("phone", phoneNum);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String param = json.toString();
                //进行base64加密
                param = Base64.encode(param.getBytes());
                String result = HttpUtils.doPost(GROUP_URL_PRE, param);
                if (result != null) {
                    groupBeans = parseGroupInfo(result);
                    if (callBack != null) {
                        callBack.onGroupInfo(groupBeans);
                    }
                } else {
                    CustomLog.e("获取群组信息失败");
                }
            }
        }).start();

    }

    public static List<GroupBean> getGroupInfo() {
        return groupBeans;
    }

    private static List<GroupBean> parseGroupInfo(String jsonData) {
        List<GroupBean> groupBeans = new ArrayList<GroupBean>();
        try {
            JSONArray arr = new JSONArray(jsonData);
            for (int i = 0; i < arr.length(); i++) {
                GroupBean groupBean = new GroupBean();
                JSONObject jsonGroup = (JSONObject) arr.get(i);
                groupBean.setGroupID(jsonGroup.getString("groupid"));
                groupBean.setGroupName(jsonGroup.getString("groupname"));
                groupBeans.add(groupBean);
                Log.i(TAG, "groupBean = " + groupBean);
            }
        } catch (Exception e) {
            CustomLog.e("解析群组信息JSON失败!!!!");
        }
        return groupBeans;
    }

    private static RestBean parseGetTokenJson(String json) {
        RestBean restBean = new RestBean();
        try {
            JSONObject tokens = new JSONObject(json);
            String result = "";
            if (tokens.has("result")) {
                result = tokens.getString("result");
            }
            restBean.setResult(result);
            if (result.equals(REST_REGISTER_SUCCESS)) {
                if (tokens.has("imtoken")) {
                    restBean.setImtoken(tokens.getString("imtoken"));
                }
                if (tokens.has("nickname")) {
                    restBean.setNickname(tokens.getString("nickname"));
                }
                if (tokens.has("portraituri")) {
                    restBean.setPortraituri(tokens.getString("portraituri"));
                }
                if (tokens.has("phone")) {
                    restBean.setPhone(tokens.getString("phone"));
                }
            } else if (result.equals(REST_UNREGISTER)) {
                CustomLog.e("parseGetTokenJson REST_UNREGISTER result:"
                        + result);
            } else if (result.equals(REST_HAS_REGISTER)) {
                CustomLog.e("parseGetTokenJson REST_HAS_REGISTER result:"
                        + result);
                restBean.setImtoken(tokens.getString("imtoken"));
                restBean.setNickname(tokens.getString("nickname"));
            } else if (result.equals(REST_REGISTER_FAIL)) {
                CustomLog.e("parseGetTokenJson REST_REGISTER_FAIL result:"
                        + result);
            } else {
                CustomLog.e("parseGetTokenJson unknow result:" + result);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return restBean;
    }
}

interface IGroupInfoCallBack {
    void onGroupInfo(List<GroupBean> groupBeans);
}
