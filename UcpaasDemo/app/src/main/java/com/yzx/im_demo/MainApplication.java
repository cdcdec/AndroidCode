package com.yzx.im_demo;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.yzx.crash.CrashHandler;
import com.yzx.service.ConnectionService;
import com.yzx.tools.ImgCache;
import com.yzx.tools.YZXContents;
import com.yzxIM.IMApplication;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuqian
 */
public class MainApplication extends IMApplication {

	private static final String TAG = "MainApplication";
	public static MainApplication mInstance;
	public static NotificationManager nm;

	//当前显示的Activity
	private Activity resumeActivity;

	private Map<String, Thread> downLoadThreads;

	public String targetId = "";


	//存放下载线程
	public synchronized void putThread(String msgId, Thread t){
		if(downLoadThreads == null){
			downLoadThreads = Collections.synchronizedMap(new HashMap<String, Thread>());
		}
		downLoadThreads.put(msgId, t);
		Log.i(TAG, "putThread msgId = "+msgId);
	}
	//获取下载线程
	public synchronized Thread getThread(String msgId){
		if(msgId != null && downLoadThreads != null){
			Log.i(TAG, "getThread msgId = "+msgId);
			return downLoadThreads.get(msgId);
		}
		return null;
	}
	public synchronized Thread removeThread(String msgId){
		if(msgId != null && downLoadThreads != null && downLoadThreads.containsKey(msgId)){
			Log.i(TAG, "removeThread msgId = "+msgId);
			return downLoadThreads.remove(msgId);
		}
		return null;
	}

	public Activity getResumeActivity() {
		return resumeActivity;
	}

	public void setResumeActivity(Activity resumeActivity) {
		this.resumeActivity = resumeActivity;
	}

	public void onCreate() {
		startService(new Intent(this, ConnectionService.class));
		super.onCreate();
		//崩溃日志保存
		CrashHandler crashHandler = CrashHandler.getInstance();
		crashHandler.init(getApplicationContext());
		mInstance =this;
		nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		ImgCache.getInstance().init(this);

        //保存一些系统常量
        YZXContents.setContext(this);

	}

	public static MainApplication getInstance() {
		return mInstance;
	}

	public static NotificationManager getNotificationManager() {
		return nm;
	}
}
