package com.cdc.androidcode.component.foregroundService;

import android.annotation.SuppressLint;
import android.app.*;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.cdc.androidcode.R;

public class ForService1 extends Service {
    private static final String TAG = ForService1.class.getSimpleName();
    private final static String FOREGROUND_CHANNEL_ID = "foreground_channel_id";
    private NotificationManager mNotificationManager;
    private Handler handler;
    private int count = 0;
    private static int stateService = ForServivce1Constants.STATE_SERVICE.NOT_CONNECTED;

    public ForService1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        stateService = ForServivce1Constants.STATE_SERVICE.NOT_CONNECTED;
    }

    @Override
    public void onDestroy() {
        stateService = ForServivce1Constants.STATE_SERVICE.NOT_CONNECTED;
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
        switch (intent.getAction()) {
            case ForServivce1Constants.ACTION.START_ACTION:
                Log.d(TAG, "Received user starts foreground intent");
                startForeground(ForServivce1Constants.NOTIFICATION_ID_FOREGROUND_SERVICE, prepareNotification());
                connect();
                break;
            case ForServivce1Constants.ACTION.STOP_ACTION:
                stopForeground(true);
                stopSelf();
                break;
            default:
                stopForeground(true);
                stopSelf();
        }

        return START_NOT_STICKY;
    }

    // its connected, so change the notification text
    private void connect() {
        // after 10 seconds its connected
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Log.d(TAG, "Bluetooth Low Energy device is connected!!");
                        Toast.makeText(getApplicationContext(),"Connected!",Toast.LENGTH_SHORT).show();
                        stateService = ForServivce1Constants.STATE_SERVICE.CONNECTED;
                        startForeground(ForServivce1Constants.NOTIFICATION_ID_FOREGROUND_SERVICE, prepareNotification());
                    }
                }, 10000);

    }


    @SuppressLint("WrongConstant")
    private Notification prepareNotification() {
        // handle build version above android oreo   API28
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O &&
                mNotificationManager.getNotificationChannel(FOREGROUND_CHANNEL_ID) == null) {
            CharSequence name = getString(R.string.text_name_notification);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(FOREGROUND_CHANNEL_ID, name, importance);
            channel.enableVibration(false);
            mNotificationManager.createNotificationChannel(channel);
        }

        Intent notificationIntent = new Intent(this, ForegroundServiceMainActivity.class);
        notificationIntent.setAction(ForServivce1Constants.ACTION.MAIN_ACTION);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // if min sdk goes below honeycomb
        /*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        } else {
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }*/

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // make a stop intent
        Intent stopIntent = new Intent(this, ForService1.class);
        stopIntent.setAction(ForServivce1Constants.ACTION.STOP_ACTION);
        PendingIntent pendingStopIntent = PendingIntent.getService(this, 0, stopIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification);
        remoteViews.setOnClickPendingIntent(R.id.btn_stop, pendingStopIntent);

        // if it is connected
        switch(stateService) {
            case ForServivce1Constants.STATE_SERVICE.NOT_CONNECTED:
                remoteViews.setTextViewText(R.id.tv_state, "DISCONNECTED");
                break;
            case ForServivce1Constants.STATE_SERVICE.CONNECTED:
                remoteViews.setTextViewText(R.id.tv_state, "CONNECTED");
                break;
        }

        // notification builder
        NotificationCompat.Builder notificationBuilder;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationBuilder = new NotificationCompat.Builder(this, FOREGROUND_CHANNEL_ID);
        } else {
            notificationBuilder = new NotificationCompat.Builder(this);
        }
        notificationBuilder
                .setContent(remoteViews)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setCategory(NotificationCompat.CATEGORY_SERVICE)
                .setOnlyAlertOnce(true)
                .setOngoing(true)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
        //API21
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            notificationBuilder.setVisibility(Notification.VISIBILITY_PUBLIC);
        }

        return notificationBuilder.build();
    }
}
