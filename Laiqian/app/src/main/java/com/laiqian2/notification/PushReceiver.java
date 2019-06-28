package com.laiqian.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.laiqian.backup.ag;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import io.reactivex.g.a;
import java.text.DecimalFormat;

public class PushReceiver extends BroadcastReceiver {
  private long bXw = -1L;
  
  private String bXx = null;
  
  private DecimalFormat bXy = new DecimalFormat("0.00");
  
  int[] bXz = null;
  
  private Context context;
  
  private void Xc() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("正在自动备份");
    stringBuilder.append(System.currentTimeMillis());
    bb.e("自动备份", stringBuilder.toString());
    a.aKh().r(new a(this));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    this.context = paramContext;
    boolean bool = paramIntent.getBooleanExtra("auto_backup", false);
    av av = new av(paramContext);
    if (bool && av.atw())
      Xc(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\notification\PushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */