# AlarmManager定时任务

```
alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), TIME_INTERVAL, pendingIntent);
或者
alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), TIME_INTERVAL, pendingIntent);
1.第一个参数表示闹钟类型：一般为 AlarmManager.ELAPSED_REALTIME_WAKEUP 或者 AlarmManager.RTC_WAKEUP 。它们之间的区别就是前者是从手机开机后的时间，包含了手机睡眠时间；而后者使用的就是手机系统设置中的时间。所以如果设置为 AlarmManager.RTC_WAKEUP ，那么可以通过修改手机系统的时间来提前触发定时事件。另外，对于相似的 AlarmManager.ELAPSED_REALTIME 和 AlarmManager.RTC 来说，它们不会唤醒 CPU 。所以使用的频率较少；

2.第二个参数表示任务首次执行时间：与第一个参数密切相关。第一个参数若为 AlarmManager.ELAPSED_REALTIME_WAKEUP ，那么当前时间就为 SystemClock.elapsedRealtime() ；若为 AlarmManager.RTC_WAKEUP ，那么当前时间就为 System.currentTimeMillis() ；

3.第三个参数表示两次执行的间隔时间：一般为常量；
4.第四个参数表示对应的响应动作：一般都是去发送广播，然后在广播接收 onReceive(Context context, Intent intent) 中做相关操作。也可以是Service
```



