package com.laiqian.opentable.common;

import android.content.Intent;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.network.i;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import java.util.HashMap;
import org.json.JSONObject;

final class d implements t.a {
  d(HashMap paramHashMap, t.g paramg) {}
  
  public void d(i parami) {
    String str1;
    String str2 = this.bYS.toString();
    if (parami.bUi) {
      str1 = "获取订单成功：";
    } else {
      str1 = "获取订单失败";
    } 
    b.au(str2, str1);
    if (parami.bUi) {
      PendingFullOrderDetail pendingFullOrderDetail = b.iX(parami.message);
      this.bYT.a(pendingFullOrderDetail, parami.message, -1);
      return;
    } 
    if (parami.bUj == -6)
      try {
        n.k(new TableEntity((new JSONObject(parami.message)).getLong("table_id"), false, false, 0L));
        RootApplication.zv().sendBroadcast(new Intent("pos_activity_change_data_area"));
      } catch (Exception parami) {
        a.e(parami);
      }  
    this.bYT.a(null, null, -2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */