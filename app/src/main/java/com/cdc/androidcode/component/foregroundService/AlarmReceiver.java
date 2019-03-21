package com.cdc.androidcode.component.foregroundService;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class AlarmReceiver extends BroadcastReceiver {




    @Override
    public void onReceive(Context context, Intent intent) {
            AlarmManager manager =(AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            //包装需要执行Service的Intent
            Intent intentS = new Intent(context, ForService2.class);
            intent.setAction(ForService2.ACTION);
            PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // 重复定时任务
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
           manager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, System.currentTimeMillis() + PollingTool.seconds * 1000, pendingIntent);
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            manager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + PollingTool.seconds * 1000, pendingIntent);
        }
    }
}
