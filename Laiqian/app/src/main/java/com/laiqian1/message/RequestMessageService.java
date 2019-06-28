package com.laiqian.message;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.bd;
import hugo.weaving.DebugLog;

@DebugLog
public class RequestMessageService extends IntentService {
  public RequestMessageService() { super("RequestMessageService"); }
  
  public void Ty() {
    if (bd.bH(this)) {
      long l = RootApplication.getLaiqianPreferenceManager().avN() + 1L;
      RootApplication.getLaiqianPreferenceManager().dz(l);
      if (l % 5L == 0L) {
        null = new StringBuilder();
        null.append(l);
        null.append(" on thread: ");
        null.append(Thread.currentThread().getId());
        Log.e("AliyunOSSManager", null.toString());
        String[] arrayOfString = new String[5];
        String str = j.bIw.bIx;
        byte b = 0;
        arrayOfString[0] = str;
        arrayOfString[1] = j.bIw.bIB;
        arrayOfString[2] = j.bIw.bIC;
        arrayOfString[3] = j.bIw.bIy;
        arrayOfString[4] = j.bIw.bIz;
        int i = arrayOfString.length;
        while (b < i) {
          str = arrayOfString[b];
          a.aG(this).go(str);
          b++;
        } 
      } 
    } 
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent) { return super.onBind(paramIntent); }
  
  public void onCreate() { super.onCreate(); }
  
  @DebugLog
  public void onDestroy() {
    Log.d("messageService", "关闭服务");
    super.onDestroy();
  }
  
  protected void onHandleIntent(Intent paramIntent) { Ty(); }
  
  public boolean onUnbind(Intent paramIntent) { return super.onUnbind(paramIntent); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\RequestMessageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */