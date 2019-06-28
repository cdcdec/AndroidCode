package com.laiqian.news;

import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.network.i;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.by;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class z implements w.a {
  z(w.b paramb) {}
  
  private ArrayList<PendingFullOrderDetail> b(i parami) throws m {
    arrayList = new ArrayList();
    try {
      JSONObject jSONObject = new JSONObject(parami.message);
      Iterator iterator = jSONObject.keys();
      b.bZ(System.currentTimeMillis());
      byte b1 = 0;
      while (iterator.hasNext()) {
        String str = (String)iterator.next();
        PendingFullOrderDetail pendingFullOrderDetail = b.iX(jSONObject.get(str).toString());
        TableEntity tableEntity = n.ce(by.parseLong(str));
        pendingFullOrderDetail.bXb.bZc = tableEntity.XX();
        pendingFullOrderDetail.bXb.bTe = tableEntity.Vz();
        if (pendingFullOrderDetail != null)
          arrayList.add(pendingFullOrderDetail); 
        b1++;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("订单添加");
        stringBuilder1.append(b1);
        stringBuilder1.append("完成");
        Log.d("添加订单", stringBuilder1.toString());
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("订单总数");
      stringBuilder.append(b1);
      return arrayList;
    } catch (Exception parami) {
      a.e(parami);
      return arrayList;
    } finally {
      parami = null;
    } 
  }
  
  private ArrayList<PendingFullOrderDetail> c(i parami) throws m {
    arrayList = new ArrayList();
    try {
      jSONArray = new JSONArray(parami.message);
      b.bZ(System.currentTimeMillis());
      return arrayList;
    } catch (Exception parami) {
      a.e(parami);
      return arrayList;
    } finally {
      parami = null;
    } 
  }
  
  public void a(int paramInt, i parami) throws JSONException, m {
    Log.e("LqkResponse", parami.message);
    if (parami.bUi) {
      if (!by.isNull(parami.message) && !parami.message.equals("[]"))
        try {
          ArrayList arrayList;
          w.b b1 = this.bXk;
          if (paramInt == 0) {
            arrayList = b(parami);
          } else {
            arrayList = c(arrayList);
          } 
          b1.a(true, arrayList);
          return;
        } catch (m parami) {
          a.e(parami);
          try {
            this.bXk.a(false, null);
            return;
          } catch (m parami) {
            a.e(parami);
            return;
          } 
        }  
      this.bXk.a(true, null);
      return;
    } 
    this.bXk.a(false, null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */