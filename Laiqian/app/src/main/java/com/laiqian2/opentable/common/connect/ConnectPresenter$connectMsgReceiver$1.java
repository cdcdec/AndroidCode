package com.laiqian.opentable.common.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.a.b;
import kotlin.jvm.a.c;
import kotlin.jvm.b.f;
import kotlin.k;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class ConnectPresenter$connectMsgReceiver$1 extends BroadcastReceiver {
  @NotNull
  private final c<Integer, Intent, k> bZx;
  
  @NotNull
  private final b<Integer, k> bZy;
  
  public void onReceive(@NotNull Context paramContext, @NotNull Intent paramIntent) {
    f.m(paramContext, "context");
    f.m(paramIntent, "intent");
    int i = paramIntent.getIntExtra("method", 1004);
    int j = paramIntent.getIntExtra("result", 0);
    switch (i) {
      default:
        return;
      case 1005:
        this.bZx.j(Integer.valueOf(j), paramIntent);
        return;
      case 1004:
        break;
    } 
    this.bZy.aw(Integer.valueOf(j));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\connect\ConnectPresenter$connectMsgReceiver$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */