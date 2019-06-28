package com.laiqian.opentable.common.a;

import com.laiqian.message.m;
import com.laiqian.network.i;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.t;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import java.util.HashMap;
import org.json.JSONException;

class x implements t.a {
  x(l paraml, HashMap paramHashMap, TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt, t.k paramk) {}
  
  public void d(i parami) throws JSONException, m {
    String str1;
    String str2 = this.car.toString();
    if (parami.bUi) {
      str1 = "移桌成功：";
    } else {
      str1 = "移桌失败";
    } 
    b.au(str2, str1);
    if (parami.bUi) {
      PendingFullOrderDetail pendingFullOrderDetail = b.iX(parami.message);
      HashMap hashMap = b.Xu();
      this.bZw.Yh().clear();
      hashMap.put("order_info", b.a(this.bZw, pendingFullOrderDetail, "1"));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.bZw.getID());
      stringBuilder.append("");
      hashMap.put("table_id", stringBuilder.toString());
      hashMap.put("from_table_id", Long.valueOf(this.bZv.getID()));
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.bZv.DP());
      stringBuilder.append("");
      hashMap.put("create_time", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.bZv.Yb());
      stringBuilder.append("");
      hashMap.put("actual_person", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.bYU);
      stringBuilder.append("");
      hashMap.put("number_id", stringBuilder.toString());
      hashMap.put("to_number_id", Integer.valueOf(0));
      hashMap.put("device_id", m.Tw());
      hashMap.put("device_type", Integer.valueOf(m.getDeviceType()));
      n.a(hashMap, RootUrlParameter.clX, new y(this, hashMap));
      return;
    } 
    this.bZu.a(false, this.bZv, this.bZw, this.bYU);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */