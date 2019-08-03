package com.yzx.im_demo.userdata;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.util.Log;
import com.yzx.db.UserInfoDBManager;
import com.yzx.db.domain.UserInfo;
import com.yzx.im_demo.IMChatActivity;
import com.yzx.im_demo.IMLoginV2Activity;
import com.yzx.mydefineview.MyToast;
import com.yzx.tools.RestTools;
import com.yzxtcp.UCSManager;
import com.yzxtcp.data.UcsErrorCode;
import com.yzxtcp.data.UcsReason;
import com.yzxtcp.listener.ILoginListener;
import com.yzxtcp.tools.CustomLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class LoginHandler extends Handler implements ILoginListener {
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Timer mTimer;
    private String mAccount;
    private static List<Handler> handlers = new ArrayList<Handler>();
    private String token;

    public LoginHandler(Context context) {
        mContext = context;
        handlers.add(this);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Bundle data = null;

        switch (msg.what) {
            case RestTools.LOGIN_STATUS_INPROCESS:

                break;
            case RestTools.LOGIN_STATUS_SUCCESS:
                CustomLog.v("登陆成功   finish activity");
                closeProgressDialog();
                stopLoginTimer();
                sendFinishMsg();
//			((Activity) mContext).finish();
                break;
            case RestTools.LOGIN_STATUS_FAIL:
                stopLoginTimer();
                if (msg.arg1 != 0) {
                    MyToast.showLoginToast(mContext, "登录失败：" + IMLoginV2Activity.loginErrorCode.get(msg.arg1));
                } else {
                    MyToast.showLoginToast(mContext, "登录失败");
                }
                break;
            case RestTools.LOGIN_STATUS_TIMEOUT:
                MyToast.showLoginToast(mContext, "登录超时");
                break;
            case RestTools.LOGIN_REST_TOKEN_FAIL:
                stopLoginTimer();
                MyToast.showLoginToast(mContext, "获取Token失败");
                break;

            case RestTools.LOGIN_REST_TOKEN_OK:
//			showProgressDialog();
                data = msg.getData();
                token = data.getString("imtoken");
                Log.e("123","token="+token);
//                CustomLog.d("save Token:" + token);
//                CustomLog.e("LOGIN_REST_TOKEN_OK begin connect");
			UCSManager.connect(token, this);
//                UCSManager.connect("eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiMzc2MDE3YTZjZjkwMWUxMTg5MDlmMWFmMmFkMGViZTYiLCJBcHBpZCI6ImQ0MjU1MmY0NmJmZjQwOTU5OTNiODU5NWMwOTJiNjQwIiwiVXNlcmlkIjoid2NkMDAwMSJ9.TEMIUmNWgAxCx+AiO+EP4KNu0ybW+vS2dggQzJ0uXNY=", this);
                sendEmptyMessage(RestTools.LOGIN_STATUS_INPROCESS);
                break;
            case RestTools.LOGIN_REST_HAS_REGISTER:
                break;
            case RestTools.LOGIN_REST_REGISTER_FAIL:
                stopLoginTimer();
                MyToast.showLoginToast(mContext, "注册失败");
                break;
        }
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
        }

        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("登录中...");
        mProgressDialog.show();
    }

    public void startLoginTimer() {
        if (mTimer == null) {
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("登录超时");
                mProgressDialog.dismiss();
                mTimer = null;
                sendEmptyMessage(RestTools.LOGIN_STATUS_TIMEOUT);
            }
        }, 40000);
    }

    public void stopLoginTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public void closeProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    private void sendFinishMsg() {
        for (Handler h : handlers) {
            h.sendEmptyMessage(RestTools.LOGIN_REST_FINISH);
        }
    }

    @Override
    public void onLogin(UcsReason reason) {
        if (null != mProgressDialog) {
            mProgressDialog.dismiss();
        }
        Log.e("123",reason.getMsg()+"=="+reason.getReason());

        if (reason.getReason() == UcsErrorCode.NET_ERROR_CONNECTOK) {
            UserInfo user = new UserInfo(RestTools.mPhoneNum, RestTools.mNickName, 1, 1);
            //保存到数据库
            UserInfoDBManager.getInstance().insert(user, token);
            RestTools.queryGroupInfo(mContext, user.getAccount(), null);
            sendEmptyMessageDelayed(RestTools.LOGIN_STATUS_SUCCESS, 1000);
//			Intent intent = new Intent(mContext, IMChatActivity.class);
//			intent.putExtra("mLocalUser", user.getAccount());
//			intent.putExtra("connectTcp", false);
//			mContext.startActivity(intent);
            IMChatActivity.actionStart(mContext, false);

            //移出登录监听回调
            UCSManager.removeLoginListener(this);
        } else {
            sendEmptyMessage(RestTools.LOGIN_STATUS_FAIL);
        }
    }
}
