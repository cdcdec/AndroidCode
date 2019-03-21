package com.cdc.androidcode.ui.notifications
import android.app.NotificationChannel
import android.os.Bundle
import android.view.View
import com.cdc.androidcode.BaseActivity
import com.cdc.androidcode.R
import kotlinx.android.synthetic.main.activity_notification_main.*
import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.core.app.NotificationCompat
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationManagerCompat
class NotificationMainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("通知")
        setContentView(R.layout.activity_notification_main)
        init()
    }

    private fun init(){
        notification1.setOnClickListener(this)
        notification2.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        when(view!!.id){
            R.id.notification1->{
                createNotification1()
            }
            R.id.notification2->{
                createNotification2()
            }
        }
    }

    private val notificationId1 = 1
    private val channelId1="channel_id1"
    private fun createNotification1(){
        //点击通知栏后 调转到浏览器  并打开网址
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://github.com/cdcdec")
        )
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        var builder:NotificationCompat.Builder?=null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder=NotificationCompat.Builder(this,channelId1)
        }else{
            builder = NotificationCompat.Builder(this)
        }
        builder.setSmallIcon(R.mipmap.ic_launcher)
        // Set the intent that will fire when the user taps the notification.
        builder.setContentIntent(pendingIntent)
        // Set the notification to auto-cancel. This means that the notification will disappear
        // after the user taps it, rather than remaining until it's explicitly dismissed.
        builder.setAutoCancel(true)
        /**
         *Build the notification's appearance.
         * Set the large icon, which appears on the left of the notification. In this
         * sample we'll set the large icon to be the same as our app icon. The app icon is a
         * reasonable default if you don't have anything more compelling to use as an icon.
         */
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))

        /**
         * Set the text of the notification. This sample sets the three most commononly used
         * text areas:
         * 1. The content title, which appears in large type at the top of the notification
         * 2. The content text, which appears in smaller text below the title
         * 3. The subtext, which appears under the text on newer devices. Devices running
         *    versions of Android prior to 4.2 will ignore this field, so don't use it for
         *    anything vital!
         */
        builder.setContentTitle("BasicNotifications Sample")
        builder.setContentText("Time to learn about notifications!")
        builder.setSubText("Tap to view documentation about notifications.")
        //小于等于7.1
        if(android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.N_MR1){
            //NotificationCompat.PRIORITY_DEFAULT
            //NotificationCompat.PRIORITY_MIN  NotificationCompat.PRIORITY_MAX
            builder.priority = NotificationCompat.PRIORITY_MAX
        }

        // END_INCLUDE (build_notification)

        // BEGIN_INCLUDE(send_notification)
        /**
         * Send the notification. This will immediately display the notification icon in the
         * notification bar.
         */
        val notificationManager: NotificationManager = getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(channelId1, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            notificationManager.createNotificationChannel(channel)
            //NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            //
            //// notificationId is a unique int for each notification that you must define
            //notificationManager.notify(notificationId, builder.build());
            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(notificationId1, builder.build())
            }
        }else{
            notificationManager.notify(notificationId1, builder.build())
            // END_INCLUDE(send_notification)
        }
    }

    private val notificationId2 = 2
    private val channelId2="channel_id2"
    private fun createNotification2(){
        val intent = Intent(
            this@NotificationMainActivity,
            NotificationMainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        var builder:NotificationCompat.Builder?=null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder=NotificationCompat.Builder(this,channelId2)
        }else{
            builder = NotificationCompat.Builder(this)
        }
        builder.setSmallIcon(R.mipmap.ic_launcher)
        builder.setContentIntent(pendingIntent)
        builder.setAutoCancel(false)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
        builder.setContentTitle("AndroidCode")
        builder.setContentText("通知栏内容!")
        builder.setSubText("通知栏下标内容!")
        //小于等于7.1
        if(android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.N_MR1){
            //NotificationCompat.PRIORITY_DEFAULT
            //NotificationCompat.PRIORITY_MIN  NotificationCompat.PRIORITY_MAX
            builder.priority = NotificationCompat.PRIORITY_MAX
        }
        val notificationManager: NotificationManager = getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(channelId2, name, importance).apply {
                description = descriptionText
            }
            notificationManager.createNotificationChannel(channel)
            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(notificationId2, builder.build())
            }
        }else{
            notificationManager.notify(notificationId2, builder.build())
        }
    }
}
