package com.yzx.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @Title GrayInnerService   
 * @Description  进程灰色保活，提供进程的优先级,从服务进程提高到可见进程
 * @Company yunzhixun  
 * @author xhb
 * @date 2017-1-7 上午9:29:48
 */
public class GrayInnerService extends Service {
	private final static int GRAY_SERVICE_ID = 1001;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		startForeground(GRAY_SERVICE_ID, new Notification());
        stopForeground(true);
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
	}

}
  
