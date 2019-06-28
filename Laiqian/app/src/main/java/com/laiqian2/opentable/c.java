package com.laiqian.opentable;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.entity.z;
import com.laiqian.main.PhoneOrders;
import com.laiqian.message.m;
import com.laiqian.network.i;
import com.laiqian.opentable.b.q;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.t;
import com.laiqian.opentable.common.u;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.sync.a.f;
import com.laiqian.util.av;
import com.laiqian.util.b;
import com.laiqian.util.by;
import com.laiqian.util.logger.h;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
  @SuppressLint({"StaticFieldLeak"})
  public static final c bYa = new c();
  
  public static void a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, t.f paramf) throws JSONException {
    HashMap hashMap = b.Xu();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.getID());
    stringBuilder.append("");
    hashMap.put("table_id", stringBuilder.toString());
    hashMap.put("order_info", b.a(paramTableEntity, paramPendingFullOrderDetail, null, "3"));
    hashMap.put("order_status", "3");
    hashMap.put("order_no", paramPendingFullOrderDetail.bXb.orderNo);
    hashMap.put("device_id", m.Tw());
    hashMap.put("releated_id", Long.valueOf(paramPendingFullOrderDetail.bXb.bZP));
    n.a(hashMap, RootUrlParameter.cmm, new g(paramTableEntity, paramf));
  }
  
  private void a(JSONObject paramJSONObject, long paramLong, String paramString, int paramInt, PendingFullOrderDetail paramPendingFullOrderDetail, a parama) throws JSONException {
    TableEntity tableEntity;
    JSONObject jSONObject = paramJSONObject.getJSONObject("pay");
    double d1 = by.parseDouble(jSONObject.getString("discount"));
    paramPendingFullOrderDetail.bXb.ceX = Double.valueOf(d1);
    paramPendingFullOrderDetail.bXb.coO = jSONObject.optLong("memberId");
    int i = jSONObject.optInt("id");
    String str = jSONObject.optString("name");
    double d2 = jSONObject.optDouble("amount");
    long l = jSONObject.optLong("sub_type_id");
    int j = jSONObject.optInt("belongId");
    ArrayList arrayList = new ArrayList();
    arrayList.add(new z(i, d2, str, l));
    d1 = d2;
    if (jSONObject.has("second_id")) {
      d1 = d2 + jSONObject.optDouble("second_amount");
      arrayList.add(new z(jSONObject.optInt("second_id"), jSONObject.optDouble("second_amount"), jSONObject.optString("second_name"), jSONObject.optLong("second_sub_type_id")));
    } 
    if (b.XC()) {
      tableEntity = b.a(paramLong, RootApplication.zv());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append((new Date()).getTime());
      stringBuilder1.append("");
      a(new i(true, false, stringBuilder1.toString()), paramPendingFullOrderDetail, arrayList, paramLong, paramInt, d1, parama, tableEntity, j);
      return;
    } 
    HashMap hashMap = b.Xu();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(tableEntity);
    stringBuilder.append("");
    hashMap.put("order_no", stringBuilder.toString());
    n.a(hashMap, RootUrlParameter.cme, new e(this, paramPendingFullOrderDetail, arrayList, paramLong, paramInt, d1, parama, j));
  }
  
  public static boolean a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString) {
    TableEntity tableEntity1 = n.ce(paramLong2);
    if (tableEntity1 != null && tableEntity1.getState() == paramInt1)
      return true; 
    TableEntity tableEntity2 = n.ce(paramLong1);
    if (tableEntity2 != null && tableEntity1 != null) {
      if (tableEntity1.getState() != 0)
        return true; 
      m.a(CrashApplication.zv(), tableEntity2, tableEntity1, paramString, paramInt2);
      b.b(tableEntity2, tableEntity1, paramInt2);
      return false;
    } 
    return true;
  }
  
  private boolean a(@NonNull String paramString1, a parama, JSONObject paramJSONObject, String paramString2) throws JSONException {
    Log.e("operationOrder", paramString1);
    null = paramJSONObject.getString("header").replace("\\", "");
    boolean bool = paramJSONObject.optBoolean("should_print_receipt", true);
    JSONObject jSONObject = new JSONObject(null);
    if (!jSONObject.getString("shop_id").equals(paramString2))
      return true; 
    PendingFullOrderDetail pendingFullOrderDetail = b.iY(paramString1);
    if (pendingFullOrderDetail != null && pendingFullOrderDetail.coy.size() > 0) {
      a a1;
      if (jSONObject.has("order_status") && (jSONObject.getInt("order_status") == 2 || jSONObject.getInt("order_status") == 3)) {
        long l = jSONObject.getLong("table_id");
        int i = jSONObject.getInt("actual_person");
        paramString1 = jSONObject.optString("order_no");
        if (pendingFullOrderDetail.bXb.bZF == 2 || pendingFullOrderDetail.bXb.bZF == 3) {
          if (b.bY(by.parseLong(pendingFullOrderDetail.bXb.coJ)) != null) {
            TableEntity tableEntity = b.bY(by.parseLong(pendingFullOrderDetail.bXb.coJ));
            if (b.c(tableEntity.Yh(), pendingFullOrderDetail.bXb.coM)) {
              ArrayList arrayList = tableEntity.Yh();
              if (arrayList.size() > 0) {
                c c1 = (c)arrayList.get(0);
                tableEntity.c(c1);
                tableEntity.W(arrayList);
                tableEntity.cf(c1.DP());
                tableEntity.setState(2);
                tableEntity.gw(jSONObject.getInt("order_type"));
              } else {
                tableEntity.Yc();
              } 
              b.j(tableEntity);
            } 
          } 
          if (jSONObject.getInt("order_status") == 3)
            return false; 
        } 
        if (b.XB()) {
          a(paramJSONObject, l, paramString1, i, pendingFullOrderDetail, parama);
        } else {
          a1 = new a(RootApplication.zv());
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramString1);
          stringBuilder.append("");
          if (a1.f(true, stringBuilder.toString()) != null) {
            a(paramJSONObject, l, paramString1, i, pendingFullOrderDetail, parama);
          } else {
            parama.ew(false);
            parama.a(b.a(l, RootApplication.zv()), pendingFullOrderDetail);
          } 
        } 
      } else {
        PendingFullOrderDetail.c c1;
        if (a1.has("order_type") && a1.getInt("order_type") == 3) {
          if (a1.getInt("order_status") == 0)
            return false; 
          null = b.bY(by.parseLong(pendingFullOrderDetail.bXb.coJ));
          if (null != null) {
            c c3 = b.b(null.Yh(), pendingFullOrderDetail.bXb.coM);
            null.cf(pendingFullOrderDetail.bXb.coE.getTime());
            null.setState(a1.getInt("table_status"));
            null.gw(a1.getInt("order_type"));
            if (c3 == null) {
              c3 = new c(pendingFullOrderDetail.bXb.coM, pendingFullOrderDetail.bXb.orderNo, pendingFullOrderDetail.bXb.coE.getTime(), pendingFullOrderDetail.bXb.bZM, a1.optInt("table_status"), null.getID());
              c3.cg(a1.optLong("releated_id"));
              null.Yh().add(c3);
              Collections.sort(null.Yh());
              null.c((c)null.Yh().get(0));
            } else {
              c3 = (c)null.Yh().get(0);
              c3.cf(pendingFullOrderDetail.bXb.coE.getTime());
              c3.gz(a1.optInt("table_status"));
              c3.da(pendingFullOrderDetail.bXb.orderNo);
              c3.gy(pendingFullOrderDetail.bXb.bZM);
              c3.cg(a1.optLong("releated_id"));
              null.c(c3);
            } 
            b.j(null);
            q q = new q(RootApplication.zv());
            q.a(null, 3, b.Q(null.Yh()));
            q.close();
          } 
          a a2 = new a(RootApplication.zv());
          PendingFullOrderDetail pendingFullOrderDetail1 = a2.kz(pendingFullOrderDetail.bXb.orderNo);
          if (pendingFullOrderDetail1 != null) {
            ArrayList arrayList = new ArrayList(pendingFullOrderDetail.coz);
            for (PendingFullOrderDetail.c c3 : pendingFullOrderDetail.coz) {
              for (PendingFullOrderDetail.c c4 : pendingFullOrderDetail1.coz) {
                if (c3.cpi.getTime() == c4.cpi.getTime())
                  arrayList.remove(c3); 
              } 
            } 
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext())
              a2.b((PendingFullOrderDetail.c)iterator.next(), pendingFullOrderDetail.bXb); 
          } else {
            a2.a(pendingFullOrderDetail, pendingFullOrderDetail.bXb.coE.getTime());
            Iterator iterator = pendingFullOrderDetail.coz.iterator();
            while (iterator.hasNext())
              a2.b((PendingFullOrderDetail.c)iterator.next(), pendingFullOrderDetail.bXb); 
          } 
          int i = a1.optInt("table_status");
          if (a.AZ().Cl() && i == 5)
            l(pendingFullOrderDetail); 
          i = a1.getInt("order_status");
          if (i != 1) {
            if (i == 4)
              a2.a(a1.getString("order_no"), a1.optDouble("total_amount")); 
          } else {
            c1 = b.iZ(paramString1);
            PendingFullOrderDetail.c c3 = new PendingFullOrderDetail.c();
            if (c1 != null && c1.coy.size() > 0) {
              c3.cpg.addAll(c1.coy);
              for (PendingFullOrderDetail.c c2 : c1.coz)
                c3.cpg.addAll(c2.cpg); 
              m.a(CrashApplication.zv(), c1, c3, true, bool);
            } 
          } 
          a2.close();
          return false;
        } 
        if (c2.getInt("order_status") == 1) {
          null = b.bY(by.parseLong(pendingFullOrderDetail.bXb.coJ));
          if (null != null) {
            c c3 = b.b(null.Yh(), pendingFullOrderDetail.bXb.coM);
            if (null.Yh().size() > 1) {
              null.setState(2);
              null.gw(c2.getInt("order_type"));
            } else {
              null.setState(2);
              null.cf(pendingFullOrderDetail.bXb.coE.getTime());
              null.gw(c2.getInt("order_type"));
            } 
            c3.gy(pendingFullOrderDetail.bXb.bZM);
            b.a(null.Yh(), pendingFullOrderDetail.bXb.coM, c3);
            b.j(null);
            a a2 = new a(RootApplication.zv());
            a2.b(pendingFullOrderDetail.coA, pendingFullOrderDetail.bXb);
            a2.close();
            q q = new q(RootApplication.zv());
            q.a(null, 3, b.Q(null.Yh()));
            q.close();
          } 
          c1 = new PendingFullOrderDetail.c();
          if (pendingFullOrderDetail != null && pendingFullOrderDetail.coy.size() > 0) {
            c1.cpg.addAll(pendingFullOrderDetail.coy);
            for (PendingFullOrderDetail.c c3 : pendingFullOrderDetail.coz)
              c1.cpg.addAll(c3.cpg); 
            m.a(CrashApplication.zv(), pendingFullOrderDetail, c1, true, bool);
            return false;
          } 
        } else {
          if (c2.has("order_type") && c2.getInt("order_type") == 3)
            return true; 
          if (c2.getInt("order_status") == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("智能点菜互联网下单，订单号：");
            stringBuilder.append(pendingFullOrderDetail.bXb.orderNo);
            stringBuilder.append("\n接收订单\ndata: ");
            stringBuilder.append(c1);
            h.bD(stringBuilder.toString(), b.a.dEC.value);
            TableEntity tableEntity = b.bY(by.parseLong(pendingFullOrderDetail.bXb.coJ));
            if (tableEntity != null) {
              c c3 = b.b(tableEntity.Yh(), pendingFullOrderDetail.bXb.coM);
              if (c3 == null || c3.xq().equals("0")) {
                if (c3 != null && c3.xq().equals("0"))
                  tableEntity.Yh().remove(c3); 
                if (tableEntity.Yh().size() == 0) {
                  tableEntity.cf(pendingFullOrderDetail.bXb.coE.getTime());
                  tableEntity.setState(2);
                  tableEntity.gw(c2.getInt("order_type"));
                } 
                c3 = new c(pendingFullOrderDetail.bXb.coM, pendingFullOrderDetail.bXb.orderNo, pendingFullOrderDetail.bXb.coE.getTime(), pendingFullOrderDetail.bXb.bZM, 2, tableEntity.getID());
                tableEntity.Yh().add(c3);
                Collections.sort(tableEntity.Yh());
                tableEntity.c((c)tableEntity.Yh().get(0));
                b.j(tableEntity);
              } 
            } 
            a a2 = new a(RootApplication.zv());
            a2.a(pendingFullOrderDetail, pendingFullOrderDetail.bXb.coE.getTime());
            a2.close();
            q q = new q(RootApplication.zv());
            q.a(tableEntity, 3, b.Q(tableEntity.Yh()));
            q.close();
            m.a(RootApplication.zv(), pendingFullOrderDetail, true, bool);
            return false;
          } 
        } 
      } 
    } 
    return false;
  }
  
  @DebugLog
  private void b(@NonNull String paramString, a parama) throws f {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      u.jh(paramString);
      if (jSONObject.has("type")) {
        null = new av(RootApplication.zv());
        String str1 = null.Tx();
        null.close();
        String str2 = jSONObject.getString("type");
        if (str2.equals("order")) {
          if (a(paramString, parama, jSONObject, str1))
            return; 
        } else if (str2.equals("table") && e(jSONObject, str1)) {
          return;
        } 
        u.ji(paramString);
        RootApplication.zv().sendBroadcast(new Intent("pos_activity_change_data_area"));
        return;
      } 
    } catch (Exception paramString) {
      a.e(paramString);
    } 
  }
  
  private static boolean e(JSONObject paramJSONObject, String paramString) throws JSONException {
    String str = paramJSONObject.getString("sub_type");
    if (!paramJSONObject.getString("shop_id").equals(paramString))
      return true; 
    if ("update_status".equals(str)) {
      h(paramJSONObject);
    } else if ("move_table".equals(str)) {
      if (i(paramJSONObject))
        return true; 
    } else {
      TableEntity tableEntity;
      if ("update_table".equals(str)) {
        long l = by.parseLong(paramJSONObject.getString("table_id"));
        int j = by.parseInt(paramJSONObject.getString("table_status"));
        int i = by.parseInt(paramJSONObject.optString("actual_person"));
        if (paramJSONObject.has("number_actual_person"))
          i = by.parseInt(paramJSONObject.optString("number_actual_person")); 
        int k = paramJSONObject.optInt("number_id");
        tableEntity = b.bY(l);
        c c1 = b.b(tableEntity.Yh(), k);
        c1.gy(i);
        c1.gz(j);
        if (tableEntity.Yg().Yl() == c1.Yl())
          tableEntity.c(c1); 
        b.a(tableEntity.Yh(), k, c1);
        b.j(tableEntity);
      } else if ("update_open_table_state".equals(str)) {
        boolean bool = tableEntity.optBoolean("is_open_table_enable", true);
        int i = tableEntity.optInt("open_table_select_method");
        int j = tableEntity.optInt("refreshTableStatus");
        if (bool && i >= 0 && j == 0) {
          a.AZ().bJ(true);
          a.AZ().dZ(i);
          RootApplication.zv().sendBroadcast(new Intent("pos_activity_open_table_method"));
        } 
        return true;
      } 
    } 
    return false;
  }
  
  private static void h(JSONObject paramJSONObject) throws JSONException {
    byte b;
    long l = by.parseLong(paramJSONObject.getString("table_id"));
    by.parseInt(paramJSONObject.getString("table_status"));
    TableEntity tableEntity = n.ce(l);
    if (paramJSONObject.has("number_id")) {
      b = paramJSONObject.optInt("number_id");
    } else {
      b = -1;
    } 
    if (b == -1) {
      tableEntity.Yc();
    } else if (b.c(tableEntity.Yh(), b)) {
      if (tableEntity.Yh().size() == 0) {
        tableEntity.Yc();
      } else {
        Collections.sort(tableEntity.Yh());
        tableEntity.c((c)tableEntity.Yh().get(0));
      } 
    } 
    n.k(tableEntity);
    q q = new q(RootApplication.zv());
    q.a(tableEntity, 3, b.Q(tableEntity.Yh()));
    q.close();
    RootApplication.zv().sendBroadcast(new Intent("pos_activity_change_data_area"));
  }
  
  private static boolean i(JSONObject paramJSONObject) throws JSONException {
    try {
      byte b;
      long l1 = by.parseLong(paramJSONObject.getString("from_table_id"));
      by.parseInt(paramJSONObject.getString("from_table_status"));
      long l2 = by.parseLong(paramJSONObject.getString("to_table_id"));
      int i = by.parseInt(paramJSONObject.getString("to_table_status"));
      String str = paramJSONObject.optString("user_id");
      if (paramJSONObject.has("number_id")) {
        b = paramJSONObject.optInt("number_id");
      } else {
        b = -1;
      } 
      boolean bool = a(l1, l2, i, b, str);
      return bool;
    } catch (Exception paramJSONObject) {
      a.e(paramJSONObject);
      return false;
    } 
  }
  
  public void a(i parami, PendingFullOrderDetail paramPendingFullOrderDetail, ArrayList<z> paramArrayList, long paramLong, int paramInt1, double paramDouble, a parama, int paramInt2) { a(parami, paramPendingFullOrderDetail, paramArrayList, paramLong, paramInt1, paramDouble, parama, null, paramInt2); }
  
  public void a(i parami, PendingFullOrderDetail paramPendingFullOrderDetail, ArrayList<z> paramArrayList, long paramLong, int paramInt1, double paramDouble, a parama, TableEntity paramTableEntity, int paramInt2) { (new PhoneOrders(RootApplication.zv(), paramPendingFullOrderDetail, true, paramArrayList, new f(this, parama, paramTableEntity, paramPendingFullOrderDetail))).setTableID(paramLong).setActualPerson(paramInt1).setTotalAmount(paramDouble).setOrderDateTime(by.parseLong(parami.message)).setBelongID(paramInt2).startOrderAsyncTask(); }
  
  @DebugLog
  public void a(String paramString, a parama) throws f { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifeq -> 22
    //   9: ldc_w 'empty content message'
    //   12: iconst_0
    //   13: anewarray java/lang/Object
    //   16: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_1
    //   23: invokestatic decode : (Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   31: ifeq -> 70
    //   34: new java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial <init> : ()V
    //   41: astore_2
    //   42: aload_2
    //   43: ldc_w 'decrypt content failed:'
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_2
    //   51: aload_1
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_2
    //   57: invokevirtual toString : ()Ljava/lang/String;
    //   60: iconst_0
    //   61: anewarray java/lang/Object
    //   64: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: aload_0
    //   71: aload_3
    //   72: aload_2
    //   73: invokespecial b : (Ljava/lang/String;Lcom/laiqian/opentable/c$a;)V
    //   76: goto -> 84
    //   79: astore_1
    //   80: aload_1
    //   81: invokestatic e : (Ljava/lang/Throwable;)V
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	87	finally
    //   22	67	87	finally
    //   70	76	79	com/laiqian/sync/a/f
    //   70	76	87	finally
    //   80	84	87	finally }
  
  public void l(PendingFullOrderDetail paramPendingFullOrderDetail) {
    null = n.ce(by.parseLong(paramPendingFullOrderDetail.bXb.coJ));
    paramPendingFullOrderDetail.bXb.bZc = null.XX();
    paramPendingFullOrderDetail.bXb.bTe = null.Vz();
    null = new StringBuilder();
    null.append(paramPendingFullOrderDetail.bXb.bZc);
    null.append(paramPendingFullOrderDetail.bXb.bTe);
    null.append("已结账，请及时确认");
    null = null.toString();
    a a = a.bo(RootApplication.zv());
    null = a.lZ(null);
    Log.e("operationOrder", "开始打印");
    ArrayList arrayList = a.al(null);
    for (e e : arrayList) {
      e.cx(0L);
      e.a(new d(this));
    } 
    g.cGS.o(arrayList);
  }
  
  public static interface a {
    void a(TableEntity param1TableEntity, PendingFullOrderDetail param1PendingFullOrderDetail);
    
    void ew(boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */