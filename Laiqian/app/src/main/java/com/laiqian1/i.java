package com.laiqian;

import android.content.Intent;
import android.support.annotation.NonNull;
import com.laiqian.basic.RootApplication;
import com.laiqian.dcb.api.a.b;
import com.laiqian.j.a;
import com.laiqian.opentable.R;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.t;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.by;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
  private final HashMap<String, Object> azx = new HashMap();
  
  private i() {}
  
  public static long a(int paramInt, Object paramObject, long paramLong) {
    long l = paramLong;
    if (paramLong == 0L)
      l = System.currentTimeMillis(); 
    if (paramObject != null) {
      HashMap hashMap = (wU()).azx;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l);
      stringBuilder.append("-");
      stringBuilder.append(paramInt);
      hashMap.put(stringBuilder.toString(), paramObject);
    } 
    return l;
  }
  
  private void a(PendingFullOrderDetail paramPendingFullOrderDetail, boolean paramBoolean, String paramString, int paramInt) throws JSONException {
    PendingFullOrderDetail.c c = new PendingFullOrderDetail.c();
    if (paramPendingFullOrderDetail != null && paramPendingFullOrderDetail.coy.size() > 0) {
      c.cpg.addAll(paramPendingFullOrderDetail.coy);
      for (PendingFullOrderDetail.c c1 : paramPendingFullOrderDetail.coz)
        c.cpg.addAll(c1.cpg); 
      Object object = e(paramInt, paramString);
      if (object != null) {
        if (paramPendingFullOrderDetail.bXb.bZF == 2) {
          ((t.b)object).a(c, paramBoolean);
          return;
        } 
        ((a.b)object).a(paramBoolean, c, paramPendingFullOrderDetail);
      } 
    } 
  }
  
  private void a(JSONObject paramJSONObject, PendingFullOrderDetail paramPendingFullOrderDetail, boolean paramBoolean, String paramString, int paramInt) throws JSONException, m {
    if (paramJSONObject.getInt("order_status") == 0) {
      StringBuilder stringBuilder;
      if (paramPendingFullOrderDetail.bXb.bZF == 2) {
        null = n.ce(by.parseLong(paramPendingFullOrderDetail.bXb.coJ));
        null.Yg().da(paramPendingFullOrderDetail.bXb.orderNo);
        null.setState(2);
        null.cf(paramPendingFullOrderDetail.bXb.coE.getTime());
        Object object1 = e(paramInt, paramString);
        if (object1 != null) {
          object1 = (t.e)object1;
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramPendingFullOrderDetail.bXb.coM);
          stringBuilder.append("");
          object1.d(paramBoolean, stringBuilder.toString());
          return;
        } 
        RootApplication.zv().sendBroadcast(new Intent("pos_activity_change_data_area"));
        return;
      } 
      String str = (new JSONObject(stringBuilder)).optString("todayOrderNo");
      Object object = e(paramInt, stringBuilder);
      if (object != null)
        ((a.a)object).e(paramBoolean, str); 
    } 
  }
  
  private void a(JSONObject paramJSONObject, String paramString, boolean paramBoolean, int paramInt) throws JSONException, m {
    JSONObject jSONObject = new JSONObject(paramJSONObject.getString("header").replace("\\", ""));
    PendingFullOrderDetail pendingFullOrderDetail = b.iY(paramString);
    if (paramJSONObject.has("changed_item") && jSONObject.getInt("order_status") == 1) {
      if (pendingFullOrderDetail.bXb.bZF == 2 && paramBoolean) {
        TableEntity tableEntity = b.bY(by.parseLong(pendingFullOrderDetail.bXb.coJ));
        if (tableEntity != null) {
          c c = b.b(tableEntity.Yh(), pendingFullOrderDetail.bXb.coM);
          if (c != null) {
            c.gy(pendingFullOrderDetail.bXb.bZM);
            if (b.a(tableEntity.Yh(), pendingFullOrderDetail.bXb.coM, c))
              n.k(tableEntity); 
          } 
        } 
      } 
      a(pendingFullOrderDetail, paramBoolean, paramString, paramInt);
    } else if (jSONObject.getInt("order_status") == 0) {
      if (!by.isNull(pendingFullOrderDetail.bXb.coJ) && pendingFullOrderDetail.bXb.bZF == 2 && paramBoolean) {
        TableEntity tableEntity = null;
        if (!b.e(Long.parseLong(pendingFullOrderDetail.bXb.coJ), pendingFullOrderDetail.bXb.coM)) {
          if (pendingFullOrderDetail.bXb.cpd == 2) {
            tableEntity = b.bY(Long.parseLong(pendingFullOrderDetail.bXb.coJ));
            c c = new c(pendingFullOrderDetail.bXb.coM, pendingFullOrderDetail.bXb.orderNo, pendingFullOrderDetail.bXb.coE.getTime(), pendingFullOrderDetail.bXb.bZM, pendingFullOrderDetail.bXb.cpd, Long.parseLong(pendingFullOrderDetail.bXb.coJ));
            tableEntity.W(b.jd((b.a(c.Yo(), c)).message));
            Collections.sort(tableEntity.Yh());
            tableEntity.c((c)tableEntity.Yh().get(0));
            tableEntity.cf(c.DP());
            tableEntity.setState(2);
          } 
        } else {
          TableEntity tableEntity1 = b.bY(Long.parseLong(pendingFullOrderDetail.bXb.coJ));
          tableEntity = tableEntity1;
          if (pendingFullOrderDetail.bXb.cpd == 2) {
            c c = new c(pendingFullOrderDetail.bXb.coM, pendingFullOrderDetail.bXb.orderNo, R.id.createTime, pendingFullOrderDetail.bXb.bZM, pendingFullOrderDetail.bXb.cpd, Long.parseLong(pendingFullOrderDetail.bXb.coJ));
            tableEntity = tableEntity1;
            if (tableEntity1.Yh().size() > 0) {
              tableEntity1.c(c);
              b.a(tableEntity1.Yh(), pendingFullOrderDetail.bXb.coM, c);
              tableEntity1.setState(2);
              tableEntity = tableEntity1;
            } 
          } 
        } 
        if (tableEntity != null)
          b.j(tableEntity); 
      } 
      a(jSONObject, pendingFullOrderDetail, paramBoolean, paramString, paramInt);
    } 
    a(paramJSONObject, paramBoolean, paramString, paramInt);
  }
  
  private void a(JSONObject paramJSONObject, boolean paramBoolean, String paramString, int paramInt) throws JSONException {
    String str = paramJSONObject.optString("table_info");
    if (!by.isNull(str)) {
      JSONObject jSONObject = new JSONObject(str);
      long l = by.parseLong(jSONObject.optString("from_table_id"));
      if (l > 0L) {
        long l1 = by.parseLong(jSONObject.optString("table_id"));
        int j = jSONObject.optInt("number_id");
        TableEntity tableEntity1 = n.ce(l);
        TableEntity tableEntity2 = n.ce(l1);
        if (tableEntity2.getState() != 2 && paramBoolean) {
          if (j == -1) {
            for (c c : tableEntity1.Yh()) {
              if (b.XB())
                c.da(String.valueOf(tableEntity2.getID())); 
              c.ch(tableEntity2.getID());
              tableEntity2.Yh().add(c);
            } 
            Collections.sort(tableEntity2.Yh());
            if (tableEntity2.Yh().size() > 0)
              tableEntity2.c((c)tableEntity2.Yh().get(0)); 
            tableEntity2.Yg().da(tableEntity1.Yg().xq());
            tableEntity2.setState(tableEntity1.getState());
            tableEntity2.cf(tableEntity1.DP());
            tableEntity1.Yc();
          } else {
            c c = b.b(tableEntity1.Yh(), j);
            if (c != null) {
              b.c(tableEntity1.Yh(), j);
              c.gx(0);
              tableEntity2.c(c);
              tableEntity2.Yh().add(c);
              tableEntity2.setState(2);
              tableEntity2.cf(c.DP());
            } 
            if (tableEntity1.Yh().size() == 0) {
              tableEntity1.Yc();
            } else {
              Collections.sort(tableEntity1.Yh());
              tableEntity1.c((c)tableEntity1.Yh().get(0));
            } 
          } 
          n.k(tableEntity1);
          n.k(tableEntity2);
        } 
        Object object = e(paramInt, paramString);
        if (object != null)
          ((t.k)object).a(paramBoolean, tableEntity1, tableEntity2, j); 
      } 
    } 
  }
  
  public static long e(int paramInt, Object paramObject) { return a(paramInt, paramObject, 0L); }
  
  private Object e(int paramInt, @NonNull String paramString) throws JSONException {
    null = b.jc(paramString);
    if (null != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null.DP());
      stringBuilder.append("-");
      stringBuilder.append(paramInt);
      String str = stringBuilder.toString();
      if (this.azx.size() > 0) {
        Object object2 = this.azx.get(str);
        Object object1 = object2;
        if (object2 != null) {
          this.azx.remove(str);
          return object2;
        } 
        return object1;
      } 
    } 
    return null;
  }
  
  public static i wU() { return a.wV(); }
  
  public Object e(int paramInt, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("-");
    stringBuilder.append(paramInt);
    String str = stringBuilder.toString();
    if (this.azx.size() > 0) {
      Object object2 = this.azx.get(str);
      Object object1 = object2;
      if (object2 != null) {
        this.azx.remove(str);
        return object2;
      } 
    } else {
      stringBuilder = null;
    } 
    return stringBuilder;
  }
  
  public boolean f(int paramInt, long paramLong) {
    null = new StringBuilder();
    null.append(paramLong);
    null.append("-");
    null.append(paramInt);
    String str = null.toString();
    if (this.azx.size() > 0 && this.azx.get(str) != null) {
      this.azx.remove(str);
      return true;
    } 
    return false;
  }
  
  private static class a {
    private static final i azC = new i(null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */