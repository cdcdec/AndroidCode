package com.laiqian.main;

import android.arch.lifecycle.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.entity.j;
import com.laiqian.util.by;

class aa extends BroadcastReceiver {
  aa(PosActivity paramPosActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    str = paramIntent.getAction();
    if ("pos_activity_change_data_all".equals(str)) {
      (PosActivity.a(this.baU)).bef.accept(Boolean.valueOf(true));
      return;
    } 
    if ("pos_shut_down".equals(str)) {
      PosActivity.c(this.baU);
      return;
    } 
    if ("pos_activity_order_change".equals(str)) {
      (PosActivity.a(this.baU)).bee.accept(Boolean.valueOf(a.AZ().Bk()));
      (PosActivity.a(this.baU)).bed.accept(Integer.valueOf(a.AZ().Ca()));
      (PosActivity.a(this.baU)).bea.Mi();
      PosActivity.a(this.baU).a(dl.ben);
      return;
    } 
    if ("pos_activity_change_data_paytype".equals(str)) {
      if (this.baU.getLifecycle().L().a(g.b.bq))
        return; 
      PosActivity.b(this.baU, true);
      return;
    } 
    if ("pos_activity_change_data_order_type".equals(str)) {
      if (this.baU.getLifecycle().L().a(g.b.bq)) {
        this.baU.Lh();
        return;
      } 
      PosActivity.c(this.baU, true);
      return;
    } 
    if ("accept_customer_message_notification".equals(str)) {
      str = paramIntent.getStringExtra("notification_message");
      if (!by.isNull(str))
        try {
          PosActivity.a(this.baU, j.cZ(str));
          return;
        } catch (Exception str) {
          a.e(str);
        }  
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */