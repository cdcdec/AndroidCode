package com.cdc.androidcode.component.foregroundService;

import android.app.*;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.cdc.androidcode.R;
import com.cdc.androidcode.utils.LogUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ForService2 extends Service {

    public static final String ACTION = "com.android.code.ForService2";

    private static final String TAG = ForService1.class.getSimpleName();
    private final static int NOTIFICATION_ID=3;
    private final static String FOREGROUND_CHANNEL_ID = "foreground_channel_id_2";
    private NotificationManager mNotificationManager;
    private static int stateService = ForServivce2Constants.STATE_SERVICE.NOT_CONNECTED;
    public ForService2() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        stateService = ForServivce2Constants.STATE_SERVICE.NOT_CONNECTED;
    }

    @Override
    public void onDestroy() {
        stateService = ForServivce2Constants.STATE_SERVICE.NOT_CONNECTED;
        super.onDestroy();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            stopForeground(true);
            stopSelf();
            return START_NOT_STICKY;
        }

        // if user starts the service
//        switch (intent.getAction()) {
//            case ForService2.ACTION:
//                Log.d(TAG, "Received user starts foreground intent");
//                startForeground(ForServivce1Constants.NOTIFICATION_ID_FOREGROUND_SERVICE, prepareNotification());
//                break;
//            case ForServivce1Constants.ACTION.STOP_ACTION:
//                stopForeground(true);
//                stopSelf();
//                break;
//            default:
//                stopForeground(true);
//                stopSelf();
//        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                //SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年M月d日 HH点mm分ss秒");

                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-M-d HH:mm:ss");
                Log.e("code",simpleDateFormat.format(new Date()));
                LogUtils.file(simpleDateFormat.format(new Date()));
                //这是定时所执行的任务
            }
        }).start();


//        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        int five = 5000; // 这是5s
//        long triggerAtTime = SystemClock.elapsedRealtime() + five;
//        Intent i = new Intent(this, ForService2.class);
//        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
//        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        return START_NOT_STICKY;
    }


    private Notification prepareNotification() {
        Intent notificationIntent = new Intent(this, ForegroundServiceMainActivity.class);
        notificationIntent.setAction(ForServivce2Constants.ACTION.MAIN_ACTION);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // notification builder
        NotificationCompat.Builder notificationBuilder;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationBuilder = new NotificationCompat.Builder(this, FOREGROUND_CHANNEL_ID);
        } else {
            notificationBuilder = new NotificationCompat.Builder(this);
        }
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.setAutoCancel(false);
        notificationBuilder.setOnlyAlertOnce(true);
        notificationBuilder.setOngoing(true);
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        notificationBuilder.setContentTitle("AndroidCode");
        notificationBuilder.setContentText("通知栏内容!");
        notificationBuilder.setSubText("通知栏下标内容!");
        //小于等于7.1
        if(android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.N_MR1){
            //NotificationCompat.PRIORITY_DEFAULT
            //NotificationCompat.PRIORITY_MIN  NotificationCompat.PRIORITY_MAX
            notificationBuilder.setPriority(NotificationCompat.PRIORITY_MAX);
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.text_name_notification);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(FOREGROUND_CHANNEL_ID, name, importance);
            channel.enableVibration(false);
            mNotificationManager.createNotificationChannel(channel);
        }
        mNotificationManager.notify(NOTIFICATION_ID,notificationBuilder.build());
        return notificationBuilder.build();
    }






}
