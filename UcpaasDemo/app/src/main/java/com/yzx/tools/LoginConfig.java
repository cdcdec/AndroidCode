package com.yzx.tools;


import android.content.Context;

public class LoginConfig {

	public static final String YUNZHIXUN_DEMO = "yunzhixun_demo";
	
	public static String getCurrentClientId(Context mContext){
		return mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).getString(YUNZHIXUN_DEMO+"_CLIENT_ID", "");
	}
	
	public static void saveCurrentClientId(Context mContext,String clientid){
		mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).edit().putString(YUNZHIXUN_DEMO+"_CLIENT_ID", clientid).commit();
	}
	
	public static void getCurrentClientMobile(){
		
	}
	
	public static void saveClientId(Context mContext,String cleintId){
		mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).edit().putString(YUNZHIXUN_DEMO+"INPUT_CLIENT_ID", cleintId).commit();
	}
	
	public static void saveClientPwd(Context mContext,String cleintPwd){
		mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).edit().putString(YUNZHIXUN_DEMO+"INPUT_CLIENT_PWD", cleintPwd).commit();
	}
	
	public static String getClientId(Context mContext){
		return mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).getString(YUNZHIXUN_DEMO+"INPUT_CLIENT_ID", "");
	}
	
	public static String getClientPwd(Context mContext){
		return mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).getString(YUNZHIXUN_DEMO+"INPUT_CLIENT_PWD", "");
	}
	
	public static void saveCurrentCall(Context mContext,int isCall){
		mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).edit().putInt(YUNZHIXUN_DEMO+"_CURRNET_CALL_INDEX", isCall).commit();
	}
	
	public static int getCurrentCall(Context mContext){
		return mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).getInt(YUNZHIXUN_DEMO+"_CURRNET_CALL_INDEX", 0);
	}
	
	public static String getCurrentUserId(Context mContext){
		return mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).getString(YUNZHIXUN_DEMO+"_USER_ID", "");
	}
	
	public static void saveCurrentUserId(Context mContext,String userId){
		mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).edit().putString(YUNZHIXUN_DEMO+"_USER_ID", userId).commit();
	}
	
	public static boolean isTokenLogin(Context mContext){
		return mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).getBoolean(YUNZHIXUN_DEMO+"_TOKEN_LOGIN", false);
	}
	public static void saveTokenLogin(Context mContext,boolean isTOkenLogin){
		mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).edit().putBoolean(YUNZHIXUN_DEMO+"_TOKEN_LOGIN", isTOkenLogin).commit();
	}
	
	public static void saveCurrentSidAndToken(Context mContext,String sid,String token){
		mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).edit().putString(YUNZHIXUN_DEMO+"_CURRNET_SID", sid+"="+token).commit();
	}
	public static String[] getCurrentSidAndToken(Context mContext){
		String sid = mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).getString(YUNZHIXUN_DEMO+"_CURRNET_SID", "");
		if(sid.contains("=")){
			return sid.split("=");
		}else{
			return null;
		}
	}
	
	public static void saveCurrentSid(Context mContext,String sid){
		mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).edit().putString(YUNZHIXUN_DEMO+"_CURRNET_LOGIN_SID", sid).commit();
	}
	
	public static String getCurrentSid(Context mContext){
		return mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).getString(YUNZHIXUN_DEMO+"_CURRNET_LOGIN_SID", "");
	}
	
	public static int getLoginIndex(Context mContext){
		return mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).getInt(YUNZHIXUN_DEMO+"_LOGIN_INDEX", 0);
	}
	public static void saveLoginIndex(Context mContext,int loginIndex){
		mContext.getSharedPreferences(YUNZHIXUN_DEMO, 0).edit().putInt(YUNZHIXUN_DEMO+"_LOGIN_INDEX", loginIndex).commit();
	}
}
