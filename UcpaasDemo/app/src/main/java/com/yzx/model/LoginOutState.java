package com.yzx.model;

import com.yzx.im_demo.IMChatActivity;
import com.yzxtcp.UCSManager;
import com.yzxtcp.data.UcsErrorCode;
import com.yzxtcp.data.UcsReason;
import com.yzxtcp.listener.ILoginListener;

import android.content.Context;
import android.util.Log;
/**
 * 未登录状态
 * 
 * @author zhuqian
 */
public class LoginOutState implements State, ILoginListener{
	private IMChatActivity imChatActivity;

	@Override
	public void action(Context context, String token) {
		//未登录，调用登录接口
		Log.i(IMChatActivity.TAG, "LoginOutState，主动链接...");
		UCSManager.connect(token, this);
		
		if(context instanceof IMChatActivity){
			imChatActivity = (IMChatActivity) context;
		}
	}

	@Override
	public void onLogin(UcsReason reason) {
		if (reason.getReason() == UcsErrorCode.NET_ERROR_CONNECTOK){
			Log.i(IMChatActivity.TAG, "LoginOutState 登录成功...");
			imChatActivity.setState(new LoginState());
		}
	}
}
