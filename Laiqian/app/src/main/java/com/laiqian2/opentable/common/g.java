package com.laiqian.opentable.common;

import com.laiqian.message.m;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.a.a;

final class g implements t.h {
  g(TableEntity paramTableEntity, int paramInt, boolean paramBoolean, a parama, t.c paramc) {}
  
  public void a(ArrayList<PendingFullOrderDetail> paramArrayList, String paramString, int paramInt) {
    if (paramArrayList != null)
      for (PendingFullOrderDetail pendingFullOrderDetail : paramArrayList) {
        if (b.b(this.bMz.Yh(), pendingFullOrderDetail.bXb.coM) != null)
          pendingFullOrderDetail.bXb.bZM = this.bMz.Yb(); 
      }  
    HashMap hashMap = b.Xu();
    hashMap.put("table_id", Long.valueOf(this.bMz.getID()));
    hashMap.put("device_id", m.Tw());
    hashMap.put("device_type", Integer.valueOf(m.getDeviceType()));
    hashMap.put("number_id", Integer.valueOf(this.bYU));
    n.a(hashMap, RootUrlParameter.clZ, new h(this, hashMap, paramArrayList));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */