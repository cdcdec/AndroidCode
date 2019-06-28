package com.laiqian.main.module.pendingorder;

import android.arch.lifecycle.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.laiqian.main.dl;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;

class e extends BroadcastReceiver {
  e(PosActivityPendingOrderFragment paramPosActivityPendingOrderFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    String str = paramIntent.getStringExtra("sOrderNo");
    if (str != null) {
      PendingFullOrderDetail.a a = (PendingFullOrderDetail.a)(PosActivityPendingOrderFragment.a(this.biN)).bdQ.getValue();
      if (!a.equals(dl.ben) && a.orderNo != null && a.orderNo.equals(str)) {
        a a1 = new a(this.biN.getContext());
        PendingFullOrderDetail pendingFullOrderDetail = a1.ky(str);
        a1.close();
        if (pendingFullOrderDetail != null && pendingFullOrderDetail.bXb.bZF == 3)
          return; 
        PosActivityPendingOrderFragment.a(this.biN, pendingFullOrderDetail, false);
      } 
    } 
    if (this.biN.getLifecycle().L().a(g.b.bq))
      PosActivityPendingOrderFragment.b(this.biN); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\pendingorder\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */