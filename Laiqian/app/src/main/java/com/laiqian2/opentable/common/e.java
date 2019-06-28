package com.laiqian.opentable.common;

import android.content.Intent;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.network.i;
import com.laiqian.opentable.common.entity.TableEntity;
import java.util.ArrayList;
import org.json.JSONObject;

final class e implements t.a {
  e(int paramInt, t.h paramh) {}
  
  public void d(i parami) {
    if (parami.bUi) {
      ArrayList arrayList;
      if (this.bYU == -1) {
        arrayList = b.iW(parami.message);
      } else {
        arrayList = new ArrayList();
        arrayList.add(b.iX(parami.message));
      } 
      this.bYV.a(arrayList, parami.message, -1);
      return;
    } 
    if (parami.bUj == -6)
      try {
        n.k(new TableEntity((new JSONObject(parami.message)).getLong("table_id"), false, false, 0L));
        RootApplication.zv().sendBroadcast(new Intent("pos_activity_change_data_area"));
      } catch (Exception parami) {
        a.e(parami);
      }  
    this.bYV.a(null, null, -2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */