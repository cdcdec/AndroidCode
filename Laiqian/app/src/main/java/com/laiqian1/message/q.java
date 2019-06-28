package com.laiqian.message;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.laiqian.basic.RootApplication;
import java.util.ArrayList;

public class q {
  protected static void A(Class<?> paramClass) {
    AlarmManager alarmManager = (AlarmManager)RootApplication.zv().getSystemService("alarm");
    Intent intent = new Intent(RootApplication.zv(), paramClass);
    alarmManager.cancel(PendingIntent.getService(RootApplication.zv(), 0, intent, 134217728));
    RootApplication.zv().stopService(intent);
  }
  
  public static boolean gE(String paramString) {
    ArrayList arrayList = (ArrayList)((ActivityManager)RootApplication.zv().getSystemService("activity")).getRunningServices(30);
    for (byte b = 0; b < arrayList.size(); b++) {
      if (((ActivityManager.RunningServiceInfo)arrayList.get(b)).service.getClassName().toString().equals(paramString))
        return true; 
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */