package com.yzx.model;

import com.yzx.im_demo.IMChatActivity;

import android.content.Context;
import android.util.Log;


/**
 * 登录状态
 * 
 * @author zhuqian
 */
public class LoginState implements State{

	@Override
	public void action(Context context, String token) {
		//登录状态，暂不做任何处理
		Log.i(IMChatActivity.TAG, "LoginState，不处理...");
	}
}
