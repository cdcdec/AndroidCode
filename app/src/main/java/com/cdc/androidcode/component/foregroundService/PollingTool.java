package com.cdc.androidcode.component.foregroundService;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
public class PollingTool {
    private static volatile PollingTool instance = null;
    private PollingTool() {

    }

    public static PollingTool newInstance() {
        PollingTool inst = instance;
        if (inst == null) {
            synchronized (PollingTool.class) {
                inst = instance;
                if (inst == null) {
                    inst = new PollingTool();
                    instance = inst;
                }
            }
        }
        return inst;
    }


    AlarmManager manager =null;
    public static int seconds=60;
    PendingIntent pendingIntent=null;
    /**
     * 开启轮询服务
     * @param context
     * @param cls
     * @param action
     */
    public  void startPollingService(Context context, Class<?> cls, String action) {
        //获取AlarmManager系统服务
       manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        //包装需要执行Service的Intent
        Intent intent = new Intent(context, cls);
        intent.setAction(action);
        pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intent1Temp=new Intent(context,AlarmReceiver.class);
        PendingIntent pendingIntentTemp=PendingIntent.getBroadcast(context,0,intent1Temp,0);
        //触发服务的起始时间
        long triggerAtTime =System.currentTimeMillis();
        //使用AlarmManger的setRepeating方法设置定期执行的时间间隔（seconds秒）和需要执行的Service
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAtTime, pendingIntentTemp);
        }
        //19
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            manager.setExact(AlarmManager.RTC_WAKEUP, triggerAtTime,pendingIntentTemp);
        }
        manager.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtTime, seconds * 1000, pendingIntent);
    }

    /**
     * 停止轮询服务
     * @param context
     * @param cls
     * @param action
     */
    public  void stopPollingService(Context context, Class<?> cls, String action) {
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, cls);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //取消正在执行的服务
        manager.cancel(pendingIntent);
    }


}
