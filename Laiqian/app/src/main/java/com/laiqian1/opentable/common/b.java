package com.laiqian.opentable.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.dcb.api.a.b;
import com.laiqian.dcb.api.b.a.b;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.dcb.api.server.a.c;
import com.laiqian.entity.s;
import com.laiqian.f.b;
import com.laiqian.i;
import com.laiqian.message.m;
import com.laiqian.models.at;
import com.laiqian.models.ba;
import com.laiqian.models.bh;
import com.laiqian.models.p;
import com.laiqian.network.LqkRequest;
import com.laiqian.network.i;
import com.laiqian.opentable.a.a;
import com.laiqian.opentable.b.q;
import com.laiqian.opentable.common.a.ac;
import com.laiqian.opentable.common.b.b;
import com.laiqian.opentable.common.connect.a;
import com.laiqian.opentable.common.connect.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.ordertool.a;
import com.laiqian.ordertool.c.a;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.pos.model.orders.b;
import com.laiqian.product.models.g;
import com.laiqian.product.models.h;
import com.laiqian.product.models.o;
import com.laiqian.product.models.p;
import com.laiqian.util.av;
import com.laiqian.util.b;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import com.laiqian.util.logger.AliLog;
import com.laiqian.util.n;
import io.netty.channel.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.a.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  public static String B(HashMap<Long, p> paramHashMap) {
    JSONArray jSONArray = new JSONArray();
    new JSONObject();
    for (Map.Entry entry : paramHashMap.entrySet()) {
      jSONObject = new JSONObject();
      Long long = (Long)entry.getKey();
      try {
        jSONObject.put("taxId", long);
        p p = (p)entry.getValue();
        jSONObject.put("taxID", p.alf());
        jSONObject.put("taxName", p.IT());
        jSONObject.put("taxValue", p.alg());
        jSONObject.put("amountOfTax", p.alh());
        jSONObject.put("amountOfProductList", p.ali());
        jSONObject.put("spareField1", p.alj());
        jSONArray.put(jSONObject);
      } catch (JSONException jSONObject) {
        a.e(jSONObject);
      } 
    } 
    return jSONArray.toString();
  }
  
  @NonNull
  private static JSONArray P(ArrayList<o> paramArrayList) throws JSONException {
    JSONArray jSONArray = new JSONArray();
    for (o o : paramArrayList) {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("taxId", o.getId());
      jSONArray.put(jSONObject);
    } 
    return jSONArray;
  }
  
  public static String Q(ArrayList<c> paramArrayList) { return h(paramArrayList, null); }
  
  public static int R(ArrayList<c> paramArrayList) {
    if (paramArrayList == null)
      return 0; 
    Iterator iterator = paramArrayList.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += j) {
      int j;
      c c = (c)iterator.next();
      if (c == null) {
        j = 0;
      } else {
        j = c.Ym();
      } 
    } 
    return i;
  }
  
  public static void XA() {
    try {
      RootApplication.zv().unregisterReceiver(NetWorkChangeBroadcastReceiver.XN());
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      return;
    } 
  }
  
  public static boolean XB() { return (a.AZ().Ca() == 0); }
  
  public static boolean XC() { return (a.AZ().Ca() != 0); }
  
  public static boolean XD() { return (RootApplication.getLaiqianPreferenceManager().avL() == 0); }
  
  public static boolean XE() { return (RootApplication.getLaiqianPreferenceManager().avL() == 1); }
  
  public static boolean XF() { return (RootApplication.getLaiqianPreferenceManager().avL() == 2); }
  
  public static boolean XG() {
    p p = new p(RootApplication.zv());
    boolean bool = p.Vb();
    p.close();
    return bool;
  }
  
  public static boolean XH() { return (!XD() || (XD() && XB())); }
  
  public static HashMap<String, Object> Xu() {
    HashMap hashMap = new HashMap();
    hashMap.put("is_test", Boolean.valueOf(false));
    return hashMap;
  }
  
  public static JSONObject Xv() throws JSONException {
    av av = new av(RootApplication.zv());
    String str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("user_name", str1);
    jSONObject.put("password", str2);
    jSONObject.put("version", "1.0");
    jSONObject.put("shop_id", str3);
    return jSONObject;
  }
  
  public static void Xw() {
    av av = RootApplication.getLaiqianPreferenceManager();
    String str = av.auU();
    av.close();
    HashMap hashMap = Xu();
    hashMap.put("getui_device_id", str);
    hashMap.put("device_id", m.Tw());
    hashMap.put("device_type", Integer.valueOf(m.getDeviceType()));
    n.a(hashMap, RootUrlParameter.cmc, new f());
  }
  
  public static boolean Xx() {
    try {
      exception = new at(RootApplication.zv());
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    boolean bool = exception.em(false);
    exception.close();
    return bool;
  }
  
  public static int Xy() {
    boolean bool1 = a.AZ().Bk();
    boolean bool2 = Xx();
    byte b2 = 0;
    byte b1 = b2;
    if (bool1) {
      b1 = b2;
      if (!bool2)
        b1 = 2; 
    } 
    return b1;
  }
  
  public static void Xz() {
    Xw();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    RootApplication.zv().registerReceiver(NetWorkChangeBroadcastReceiver.XN(), intentFilter);
  }
  
  public static long a(int paramInt, TableEntity paramTableEntity, Object paramObject, HashMap<String, Object> paramHashMap) throws JSONException {
    long l = i.e(paramInt, paramObject);
    b.a(RootApplication.zv(), z(paramHashMap), paramInt, paramTableEntity.getID(), l);
    return l;
  }
  
  public static a a(Context paramContext, String paramString, Long paramLong, boolean paramBoolean) { return a(paramContext, paramString, paramLong, paramBoolean, 0); }
  
  public static a a(Context paramContext, String paramString, Long paramLong, boolean paramBoolean, int paramInt) {
    boolean bool;
    TableEntity tableEntity;
    if ((bd.bH(RootApplication.zv().getApplicationContext()) && XB()) || (XC() && !XD())) {
      bool = true;
    } else {
      bool = false;
    } 
    Long long = paramLong;
    if (paramLong == null)
      long = Long.valueOf(0L); 
    a a = new a();
    if (bool) {
      tableEntity = n.ce(long.longValue());
    } else {
      try {
        q q = new q(paramContext);
      } catch (Exception paramLong) {
        a.e(paramLong);
        paramLong = null;
      } 
      TableEntity tableEntity1 = paramLong.ck(long.longValue());
      paramLong.close();
      tableEntity = tableEntity1;
    } 
    if (tableEntity != null) {
      a a1;
      a.bTe = tableEntity.Vz();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      a.bZd = stringBuilder.toString();
      if (bool) {
        a1 = n.cd(tableEntity.XY());
      } else {
        try {
          a a2 = new a(paramContext);
        } catch (Exception stringBuilder) {
          a.e(stringBuilder);
          stringBuilder = null;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(a1.XY());
        stringBuilder1.append("");
        a1 = stringBuilder.iR(stringBuilder1.toString());
        stringBuilder.close();
      } 
      if (a1 != null)
        a.bZc = a1.XX(); 
    } 
    if (!by.isNull(paramString)) {
      try {
        bh bh = new bh(paramContext);
      } catch (Exception paramContext) {
        a.e(paramContext);
        paramContext = null;
      } 
      a.bfo = paramContext.iD(paramString);
      paramContext.close();
    } 
    return a;
  }
  
  public static b a(long paramLong, c paramc) { return a(paramLong, paramc, false); }
  
  public static b a(long paramLong, c paramc, boolean paramBoolean) {
    String str;
    if (paramc == null)
      return new b(false, "", 2); 
    if (paramBoolean) {
      str = "";
    } else {
      str = cb(paramLong);
    } 
    if (!by.isNull(str)) {
      if (!j(paramc.Yl(), str))
        return new b(true, a(paramc, str), false); 
      int i = ca(paramLong);
      paramc.gx(i);
      return new b(false, a(paramc, str), i);
    } 
    return new b(true, b(paramc).toString(), false);
  }
  
  public static TableEntity a(long paramLong, Context paramContext) {
    try {
      q q = new q(paramContext);
    } catch (Exception paramContext) {
      a.e(paramContext);
      paramContext = null;
    } 
    TableEntity tableEntity = paramContext.ck(paramLong);
    paramContext.close();
    return tableEntity;
  }
  
  public static PendingFullOrderDetail a(PendingFullOrderDetail.c paramc, PendingFullOrderDetail paramPendingFullOrderDetail) {
    if (paramPendingFullOrderDetail.coy.isEmpty()) {
      paramPendingFullOrderDetail.coy.addAll(paramc.cpg);
      return paramPendingFullOrderDetail;
    } 
    for (byte b1 = 0; b1 < paramc.cpg.size(); b1++) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)paramc.cpg.get(b1);
      if (d.cpo < 0.0D)
        for (byte b2 = 0; b2 < paramPendingFullOrderDetail.coy.size(); b2++) {
          PendingFullOrderDetail.d d1 = (PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b2);
          if (d.bbX == d1.bbX) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d.cpl);
            stringBuilder.append("");
            long l = by.parseLong(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(d1.cpl);
            stringBuilder.append("");
            if (l < by.parseLong(stringBuilder.toString())) {
              paramPendingFullOrderDetail.coy.add(b2, d);
              break;
            } 
            if (d.cpl == d1.cpl) {
              paramPendingFullOrderDetail.coy.add(b2 + 1, d);
              break;
            } 
          } else {
            if (d.bbX < d1.bbX) {
              paramPendingFullOrderDetail.coy.add(b2, d);
              break;
            } 
            if (d1.bbX == 0L) {
              paramPendingFullOrderDetail.coy.add(b2, d);
              break;
            } 
          } 
          if (b2 == paramPendingFullOrderDetail.coy.size() - 1) {
            paramPendingFullOrderDetail.coy.add(b2 + 1, d);
            break;
          } 
        }  
    } 
    return paramPendingFullOrderDetail;
  }
  
  public static b a(b paramb, String paramString) {
    if (!by.isNull(paramString))
      try {
        JSONObject jSONObject = new JSONObject(paramString);
        paramb.cyU = jSONObject.optString("actual_person");
        paramb.coU = jb(jSONObject.optString("drawerID"));
        paramb.coV = jb(jSONObject.optString("settlementID"));
        return paramb;
      } catch (JSONException paramString) {
        a.e(paramString);
      }  
    return paramb;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, long paramLong) {
    try {
      return (new JSONObject()).put("actual_person", paramInt).put("drawerID", paramString1).put("settlementID", paramString2).put("createTime", paramLong).toString();
    } catch (JSONException paramString1) {
      a.e(paramString1);
      return "";
    } 
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    try {
      JSONObject jSONObject = Xv();
      jSONObject.put("type", "table");
      jSONObject.put("sub_type", "update_table");
      jSONObject.put("shop_id", RootApplication.getLaiqianPreferenceManager().Tx());
      jSONObject.put("table_status", paramInt4);
      jSONObject.put("table_id", paramLong);
      jSONObject.put("number_id", paramInt1);
      jSONObject.put("number_actual_person", paramInt2);
      jSONObject.put("actual_person", paramInt3);
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return null;
    } 
  }
  
  public static String a(Context paramContext, String paramString, double paramDouble) {
    Context context = null;
    try {
      exception = new a(paramContext);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    PendingFullOrderDetail pendingFullOrderDetail = exception.kz(paramString);
    if (pendingFullOrderDetail != null) {
      try {
        q q = new q(paramContext);
      } catch (Exception paramContext) {
        a.e(paramContext);
        paramContext = context;
      } 
      TableEntity tableEntity = paramContext.ck(Long.parseLong(pendingFullOrderDetail.bXb.coJ));
      for (c c : tableEntity.Yh()) {
        if (c.xq().equals(paramString)) {
          pendingFullOrderDetail.bXb.coM = c.Yl();
          pendingFullOrderDetail.bXb.bZM = c.Ym();
          tableEntity.c(c);
          break;
        } 
      } 
      paramContext.close();
      exception.close();
      if (paramDouble > 0.0D || (pendingFullOrderDetail.bXb.coM == 0 && tableEntity.Yh().size() == 1))
        return a(tableEntity, pendingFullOrderDetail, "0"); 
    } 
    return "";
  }
  
  public static String a(TableEntity paramTableEntity, int paramInt, PendingFullOrderDetail paramPendingFullOrderDetail, String paramString) throws JSONException {
    long l = System.currentTimeMillis();
    JSONObject jSONObject1 = new JSONObject();
    jSONObject1.put("type", "order");
    JSONObject jSONObject2 = new JSONObject();
    jSONObject2.put("order_type", paramPendingFullOrderDetail.bXb.bZF);
    jSONObject2.put("order_no", paramPendingFullOrderDetail.bXb.orderNo);
    jSONObject2.put("discount", 0);
    jSONObject2.put("user_id", paramPendingFullOrderDetail.bXb.aEI);
    jSONObject2.put("shop_id", paramPendingFullOrderDetail.bXb.bJc);
    jSONObject2.put("table_id", paramTableEntity.getID());
    jSONObject2.put("table_no", paramTableEntity.Vz());
    jSONObject2.put("area_name", paramTableEntity.XX());
    jSONObject2.put("number_id", paramInt);
    jSONObject2.put("releated_id", paramTableEntity.Yg().Yj());
    jSONObject2.put("total_amount", paramPendingFullOrderDetail.bXb.cpc);
    jSONObject2.put("pay_type", paramPendingFullOrderDetail.bXb.btX);
    jSONObject2.put("table_cost", paramTableEntity.Yg().Yk());
    if (paramPendingFullOrderDetail.bXb.coE != null) {
      long l1 = paramPendingFullOrderDetail.bXb.coE.getTime();
      if (l1 <= 0L)
        l1 = l; 
      jSONObject2.put("create_time", l1);
    } else {
      jSONObject2.put("create_time", l);
    } 
    jSONObject2.put("actual_person", paramTableEntity.Yg().Ym());
    jSONObject2.put("table_status", paramTableEntity.getState());
    jSONObject2.put("order_status", paramString);
    jSONObject2.put("serviceCharge", paramPendingFullOrderDetail.bXb.cpa);
    if (!by.isNull(paramPendingFullOrderDetail.bXb.cpe)) {
      str = new JSONArray(paramPendingFullOrderDetail.bXb.cpe);
    } else {
      String str;
      str = "";
    } 
    jSONObject2.put("serviceChargeTax", str);
    jSONObject2.put("machine_type", RootApplication.getLaiqianPreferenceManager().avL());
    jSONObject2.put("drawerName", paramPendingFullOrderDetail.bXb.coU);
    jSONObject1.put("header", jSONObject2);
    JSONArray jSONArray = new JSONArray();
    Iterator iterator = paramPendingFullOrderDetail.coy.iterator();
    while (iterator.hasNext())
      jSONArray = a(jSONArray, (PendingFullOrderDetail.d)iterator.next(), l); 
    iterator = paramPendingFullOrderDetail.coz.iterator();
    PendingFullOrderDetail.d d = jSONArray;
    label34: while (iterator.hasNext()) {
      PendingFullOrderDetail.c c = (PendingFullOrderDetail.c)iterator.next();
      Iterator iterator1 = c.cpg.iterator();
      jSONArray = d;
      while (true) {
        d = jSONArray;
        if (iterator1.hasNext()) {
          d = (PendingFullOrderDetail.d)iterator1.next();
          if (c.cpi.getTime() > 0L) {
            jSONArray = a(jSONArray, d, c.cpi.getTime());
            continue;
          } 
          jSONArray = a(jSONArray, d, l);
          continue;
        } 
        continue label34;
      } 
    } 
    jSONObject1.put("item", d);
    jSONObject1.put("should_print_receipt", RootApplication.getLaiqianPreferenceManager().avR());
    return jSONObject1.toString();
  }
  
  public static String a(TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt) {
    try {
      JSONObject jSONObject = Xv();
      jSONObject.put("type", "table");
      jSONObject.put("sub_type", "move_table");
      jSONObject.put("from_table_id", paramTableEntity1.getID());
      jSONObject.put("to_table_id", paramTableEntity2.getID());
      jSONObject.put("number_id", paramInt);
      jSONObject.put("update_time", (new Date()).getTime());
      jSONObject.put("from_table_status", paramTableEntity1.getState());
      jSONObject.put("to_table_status", paramTableEntity2.getState());
      jSONObject.put("actual_person", paramTableEntity2.Yb());
      return jSONObject.toString();
    } catch (JSONException paramTableEntity1) {
      a.e(paramTableEntity1);
      return null;
    } 
  }
  
  public static String a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, PendingFullOrderDetail.c paramc, String paramString) throws JSONException {
    long l = System.currentTimeMillis();
    JSONObject jSONObject = new JSONObject(a(paramTableEntity, paramTableEntity.Yg().Yl(), paramPendingFullOrderDetail, paramString));
    JSONArray jSONArray1 = new JSONArray();
    JSONArray jSONArray2 = jSONArray1;
    if (paramc != null) {
      Iterator iterator = paramc.cpg.iterator();
      while (true) {
        jSONArray2 = jSONArray1;
        if (iterator.hasNext()) {
          jSONArray1 = a(jSONArray1, (PendingFullOrderDetail.d)iterator.next(), l);
          continue;
        } 
        break;
      } 
    } 
    jSONObject.put("changed_item", jSONArray2);
    return jSONObject.toString();
  }
  
  public static String a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(a(paramTableEntity, paramTableEntity.Yg().Yl(), paramPendingFullOrderDetail, paramString));
      try {
        jSONObject.put("changed_item", "");
      } catch (JSONException paramPendingFullOrderDetail) {}
    } catch (JSONException paramPendingFullOrderDetail) {
      paramTableEntity = null;
    } 
    a.e(paramPendingFullOrderDetail);
  }
  
  public static String a(c paramc, String paramString) {
    ArrayList arrayList = new ArrayList();
    arrayList.add(paramc);
    return h(arrayList, paramString);
  }
  
  public static JSONArray a(JSONArray paramJSONArray, PendingFullOrderDetail.d paramd, long paramLong) throws JSONException {
    int i = paramd.name.indexOf("[");
    null = paramd.name;
    String str2 = "";
    String str1 = null;
    if (null.contains("[")) {
      str2 = null.substring(i).replace("[", "").replace("]", "");
      str1 = null.substring(0, i);
    } 
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("id", paramd.id);
    jSONObject.put("product_name", str1);
    jSONObject.put("status", "600001");
    jSONObject.put("type_id", paramd.cpq);
    jSONObject.put("category", paramd.cpx);
    jSONObject.put("quantity", paramd.cpo);
    jSONObject.put("taste", str2);
    jSONObject.put("sale_price", paramd.cpn);
    jSONObject.put("item_id", paramd.cpz);
    jSONObject.put("order_status", paramd.aTU);
    jSONObject.put("member_price", paramd.cpu);
    if (paramd.bbX > 0L) {
      jSONObject.put("create_time", paramd.bbX);
    } else {
      jSONObject.put("create_time", paramLong);
    } 
    if (paramd.cpx == 2L) {
      jSONObject.put("mealsetList", paramd.cpj);
      jSONObject.put("mealsetNames", paramd.cpk);
    } 
    jSONObject.put("item_no", "0");
    if (paramd.aTR.size() > 0)
      try {
        jSONObject.put("tax", P(paramd.aTR));
        jSONObject.put("amountOfNoTax", n.a(Double.valueOf(paramd.aTF), true, false, 5));
        jSONObject.put("amountOfAddPrice", n.a(Double.valueOf(paramd.aTG), true, false, 5));
      } catch (JSONException paramd) {
        a.e(paramd);
      }  
    paramJSONArray.put(jSONObject);
    return paramJSONArray;
  }
  
  public static JSONObject a(String paramString, long paramLong, JSONObject paramJSONObject) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("message_type", paramString);
      jSONObject.put("device_type", RootApplication.getLaiqianPreferenceManager().avL());
      jSONObject.put("create_time", paramLong);
      jSONObject.put("version", 1.0D);
      paramJSONObject.put("more_info", jSONObject);
      return paramJSONObject;
    } catch (JSONException paramString) {
      a.e(paramString);
      return paramJSONObject;
    } 
  }
  
  public static void a(long paramLong, int paramInt, t.h paramh) {
    HashMap hashMap = Xu();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    hashMap.put("table_id", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    hashMap.put("number_id", stringBuilder.toString());
    n.a(hashMap, RootUrlParameter.clW, new e(paramInt, paramh));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt) { // Byte code:
    //   0: ldc com/laiqian/opentable/common/b
    //   2: monitorenter
    //   3: invokestatic aKh : ()Lio/reactivex/m;
    //   6: new com/laiqian/opentable/common/c
    //   9: dup
    //   10: iload_3
    //   11: aload_1
    //   12: invokespecial <init> : (ILjava/lang/String;)V
    //   15: invokevirtual r : (Ljava/lang/Runnable;)Lio/reactivex/a/b;
    //   18: pop
    //   19: ldc com/laiqian/opentable/common/b
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/laiqian/opentable/common/b
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	23	finally }
  
  public static void a(s params, t.f paramf) {
    boolean bool;
    if (bd.bH(RootApplication.zv().getApplicationContext()) && XB()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      b(params, paramf);
      return;
    } 
    a.a(params.aSH, new j(paramf));
  }
  
  private static void a(i parami, t.e parame, s params) throws m {
    PendingFullOrderDetail pendingFullOrderDetail = iY(parami.message);
    byte b1 = 0;
    int j = b1;
    if (pendingFullOrderDetail != null) {
      j = b1;
      if (parami.bUi) {
        j = pendingFullOrderDetail.bXb.coM;
        TableEntity tableEntity = bY(by.parseLong(pendingFullOrderDetail.bXb.coJ));
        if (tableEntity != null && b(tableEntity.Yh(), pendingFullOrderDetail.bXb.coM) == null) {
          if (tableEntity.Yh().size() == 0) {
            tableEntity.cf(pendingFullOrderDetail.bXb.coE.getTime());
            tableEntity.setState(2);
          } 
          c c = new c(pendingFullOrderDetail.bXb.coM, pendingFullOrderDetail.bXb.orderNo, pendingFullOrderDetail.bXb.coE.getTime(), pendingFullOrderDetail.bXb.bZM, 2, tableEntity.getID());
          tableEntity.Yh().add(c);
          Collections.sort(tableEntity.Yh());
          tableEntity.c((c)tableEntity.Yh().get(0));
          j(tableEntity);
        } 
      } 
    } 
    boolean bool = parami.bUi;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(j);
    stringBuilder.append("");
    parame.d(bool, stringBuilder.toString());
    f(params.aSF, 2002);
  }
  
  private static void a(i parami, t.f paramf, s params) throws m {
    TableEntity tableEntity = n.ce(params.aSG);
    if (parami.bUi && tableEntity != null) {
      c c = b(tableEntity.Yh(), tableEntity.Yg().Yl());
      if (c != null) {
        tableEntity.Yh().remove(c);
        if (tableEntity.Yh().size() == 0) {
          tableEntity.Yc();
        } else {
          Collections.sort(tableEntity.Yh());
          tableEntity.c((c)tableEntity.Yh().get(0));
        } 
      } 
      n.k(tableEntity);
    } 
    paramf.dp(parami.bUi);
    f(params.aSF, 3004);
  }
  
  private static void a(i parami, Object paramObject, s params) throws m {
    PendingFullOrderDetail.c c;
    StringBuilder stringBuilder;
    PendingFullOrderDetail pendingFullOrderDetail = iX(parami.message);
    if (pendingFullOrderDetail.bXb.bZF == 2) {
      c = bY(by.parseLong(pendingFullOrderDetail.bXb.coJ));
      if (c != null) {
        c c1 = b(c.Yh(), pendingFullOrderDetail.bXb.coM);
        if (c1 != null) {
          c1.gy(pendingFullOrderDetail.bXb.bZM);
          if (a(c.Yh(), pendingFullOrderDetail.bXb.coM, c1))
            n.k(c); 
        } 
      } 
    } 
    if (pendingFullOrderDetail != null && pendingFullOrderDetail.coz.size() > 0) {
      c = (PendingFullOrderDetail.c)pendingFullOrderDetail.coz.get(pendingFullOrderDetail.coz.size() - 1);
    } else {
      c = new PendingFullOrderDetail.c();
    } 
    if (XF()) {
      paramObject = (t.e)paramObject;
      boolean bool = parami.bUi;
      stringBuilder = new StringBuilder();
      stringBuilder.append(pendingFullOrderDetail.bXb.coM);
      stringBuilder.append("");
      paramObject.d(bool, stringBuilder.toString());
    } else {
      ((t.b)paramObject).a(c, stringBuilder.bUi);
    } 
    f(params.aSF, 2007);
  }
  
  public static void a(TableEntity paramTableEntity, int paramInt, t.c paramc, boolean paramBoolean, a<Void> parama) { a(paramTableEntity.getID(), paramInt, new g(paramTableEntity, paramInt, paramBoolean, parama, paramc)); }
  
  private static void a(PendingFullOrderDetail paramPendingFullOrderDetail, JSONObject paramJSONObject) {
    try {
      exception = new a(RootApplication.zv());
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    paramPendingFullOrderDetail.bXb.coO = paramJSONObject.optLong("partner_id");
    paramPendingFullOrderDetail.bXb.ceX = Double.valueOf(paramJSONObject.optDouble("discount"));
    paramPendingFullOrderDetail.bXb.coQ = paramJSONObject.optString("partner_mobile");
    paramPendingFullOrderDetail.bXb.coP = paramJSONObject.optString("partner_name");
    paramPendingFullOrderDetail.bXb.headerText = paramJSONObject.optString("header_text");
    paramPendingFullOrderDetail.bXb.coS = paramJSONObject.optString("todayOrderNo");
    paramPendingFullOrderDetail.bXb.coT = paramJSONObject.optString("todayOrderNo");
    paramPendingFullOrderDetail.bXb.aVS = paramJSONObject.optLong("firstPayType");
    paramPendingFullOrderDetail.bXb.coW = paramJSONObject.optString("firstPayTypeName");
    paramPendingFullOrderDetail.bXb.bfj = paramJSONObject.optDouble("firstPayValue");
    paramPendingFullOrderDetail.bXb.coX = paramJSONObject.optLong("firstSubTypeId");
    paramPendingFullOrderDetail.bXb.aVU = paramJSONObject.optLong("secondPayType");
    paramPendingFullOrderDetail.bXb.coY = paramJSONObject.optString("secondPayTypeName");
    paramPendingFullOrderDetail.bXb.bfk = paramJSONObject.optDouble("secondPayValue");
    paramPendingFullOrderDetail.bXb.coZ = paramJSONObject.optLong("secondSubTypeId");
    exception.close();
  }
  
  public static void a(String paramString, int paramInt, t.g paramg) {
    HashMap hashMap = Xu();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append("");
    hashMap.put("table_id", stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    hashMap.put("number_id", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("请求获取订单,");
    stringBuilder1.append(hashMap.toString());
    je(stringBuilder1.toString());
    n.a(hashMap, RootUrlParameter.clW, new d(hashMap, paramg));
  }
  
  public static boolean a(TableEntity paramTableEntity1, TableEntity paramTableEntity2, Context paramContext, a parama, String paramString1, String paramString2, int paramInt) { // Byte code:
    //   0: new com/laiqian/opentable/b/q
    //   3: dup
    //   4: aload_2
    //   5: invokespecial <init> : (Landroid/content/Context;)V
    //   8: astore #11
    //   10: goto -> 23
    //   13: astore #11
    //   15: aload #11
    //   17: invokestatic e : (Ljava/lang/Throwable;)V
    //   20: aconst_null
    //   21: astore #11
    //   23: iconst_0
    //   24: istore #10
    //   26: iconst_0
    //   27: istore #9
    //   29: iload #10
    //   31: istore #7
    //   33: aload #11
    //   35: invokevirtual beginTransaction : ()V
    //   38: iload #9
    //   40: istore #8
    //   42: iload #10
    //   44: istore #7
    //   46: aload #11
    //   48: aload_0
    //   49: invokevirtual getID : ()J
    //   52: invokevirtual ck : (J)Lcom/laiqian/opentable/common/entity/TableEntity;
    //   55: invokevirtual getState : ()I
    //   58: ifeq -> 256
    //   61: iload #10
    //   63: istore #7
    //   65: aload #11
    //   67: aload_0
    //   68: iconst_3
    //   69: aload #4
    //   71: invokevirtual a : (Lcom/laiqian/opentable/common/entity/TableEntity;ILjava/lang/String;)Z
    //   74: istore #10
    //   76: iload #10
    //   78: ifeq -> 384
    //   81: iload #9
    //   83: istore #8
    //   85: aload #11
    //   87: aload_1
    //   88: invokevirtual getID : ()J
    //   91: invokevirtual ck : (J)Lcom/laiqian/opentable/common/entity/TableEntity;
    //   94: invokevirtual getState : ()I
    //   97: ifne -> 256
    //   100: aload #11
    //   102: aload_1
    //   103: iconst_3
    //   104: aload #5
    //   106: invokevirtual a : (Lcom/laiqian/opentable/common/entity/TableEntity;ILjava/lang/String;)Z
    //   109: istore #9
    //   111: iload #9
    //   113: istore #8
    //   115: iload #9
    //   117: ifeq -> 256
    //   120: iload #9
    //   122: istore #7
    //   124: new com/laiqian/pos/model/a
    //   127: dup
    //   128: aload_2
    //   129: invokespecial <init> : (Landroid/content/Context;)V
    //   132: astore #4
    //   134: iload #6
    //   136: iconst_m1
    //   137: if_icmpeq -> 171
    //   140: iload #9
    //   142: istore #7
    //   144: aload #4
    //   146: aload_1
    //   147: invokevirtual Yg : ()Lcom/laiqian/opentable/common/entity/c;
    //   150: invokevirtual xq : ()Ljava/lang/String;
    //   153: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   156: aload_1
    //   157: invokevirtual getID : ()J
    //   160: invokestatic valueOf : (J)Ljava/lang/String;
    //   163: invokevirtual az : (Ljava/lang/String;Ljava/lang/String;)Z
    //   166: istore #8
    //   168: goto -> 244
    //   171: iload #9
    //   173: istore #7
    //   175: aload_1
    //   176: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   179: invokevirtual iterator : ()Ljava/util/Iterator;
    //   182: astore #5
    //   184: iload #9
    //   186: istore #8
    //   188: iload #9
    //   190: istore #7
    //   192: aload #5
    //   194: invokeinterface hasNext : ()Z
    //   199: ifeq -> 244
    //   202: iload #9
    //   204: istore #7
    //   206: aload #4
    //   208: aload #5
    //   210: invokeinterface next : ()Ljava/lang/Object;
    //   215: checkcast com/laiqian/opentable/common/entity/c
    //   218: invokevirtual xq : ()Ljava/lang/String;
    //   221: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   224: aload_1
    //   225: invokevirtual getID : ()J
    //   228: invokestatic valueOf : (J)Ljava/lang/String;
    //   231: invokevirtual az : (Ljava/lang/String;Ljava/lang/String;)Z
    //   234: istore #8
    //   236: iload #8
    //   238: ifne -> 368
    //   241: goto -> 244
    //   244: iload #8
    //   246: istore #7
    //   248: aload #4
    //   250: invokevirtual close : ()V
    //   253: goto -> 256
    //   256: iload #8
    //   258: istore #7
    //   260: iload #8
    //   262: ifeq -> 292
    //   265: iload #8
    //   267: istore #7
    //   269: aload #11
    //   271: invokevirtual setTransactionSuccessful : ()V
    //   274: iload #8
    //   276: istore #7
    //   278: goto -> 292
    //   281: astore_0
    //   282: goto -> 356
    //   285: astore #4
    //   287: aload #4
    //   289: invokestatic e : (Ljava/lang/Throwable;)V
    //   292: aload #11
    //   294: invokevirtual endTransaction : ()V
    //   297: aload #11
    //   299: invokevirtual close : ()V
    //   302: iload #7
    //   304: ifeq -> 353
    //   307: invokestatic XC : ()Z
    //   310: ifeq -> 353
    //   313: new com/laiqian/opentable/common/a/ac
    //   316: dup
    //   317: aload_2
    //   318: aload_3
    //   319: invokespecial <init> : (Landroid/content/Context;Lcom/laiqian/ordertool/c/a;)V
    //   322: aload_0
    //   323: aload_1
    //   324: iload #6
    //   326: invokevirtual d : (Lcom/laiqian/opentable/common/entity/TableEntity;Lcom/laiqian/opentable/common/entity/TableEntity;I)V
    //   329: iload #6
    //   331: iconst_m1
    //   332: if_icmpeq -> 353
    //   335: aload_0
    //   336: invokevirtual getState : ()I
    //   339: iconst_2
    //   340: if_icmpne -> 353
    //   343: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   346: invokevirtual Ca : ()I
    //   349: iconst_1
    //   350: invokestatic bb : (II)V
    //   353: iload #7
    //   355: ireturn
    //   356: aload #11
    //   358: invokevirtual endTransaction : ()V
    //   361: aload #11
    //   363: invokevirtual close : ()V
    //   366: aload_0
    //   367: athrow
    //   368: iload #8
    //   370: istore #9
    //   372: goto -> 184
    //   375: astore #4
    //   377: iload #10
    //   379: istore #7
    //   381: goto -> 287
    //   384: iload #10
    //   386: istore #8
    //   388: goto -> 256
    // Exception table:
    //   from	to	target	type
    //   0	10	13	java/lang/Exception
    //   33	38	285	java/lang/Exception
    //   33	38	281	finally
    //   46	61	285	java/lang/Exception
    //   46	61	281	finally
    //   65	76	285	java/lang/Exception
    //   65	76	281	finally
    //   85	111	375	java/lang/Exception
    //   85	111	281	finally
    //   124	134	285	java/lang/Exception
    //   124	134	281	finally
    //   144	168	285	java/lang/Exception
    //   144	168	281	finally
    //   175	184	285	java/lang/Exception
    //   175	184	281	finally
    //   192	202	285	java/lang/Exception
    //   192	202	281	finally
    //   206	236	285	java/lang/Exception
    //   206	236	281	finally
    //   248	253	285	java/lang/Exception
    //   248	253	281	finally
    //   269	274	285	java/lang/Exception
    //   269	274	281	finally
    //   287	292	281	finally }
  
  public static boolean a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, long paramLong, ac paramac) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{com/laiqian/opentable/common/b}} */
    q q = null;
    try {
      exception = new a(RootApplication.zv());
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } finally {}
    try {
      q q1 = new q(RootApplication.zv());
      q = q1;
    } catch (Exception exception1) {
      a.e(exception1);
    } 
    boolean bool1 = false;
    boolean bool2 = bool1;
    try {
      exception.beginTransaction();
      bool2 = bool1;
      if (q.ck(paramTableEntity.getID()).getState() == 0) {
        bool2 = bool1;
        paramTableEntity.setState(2);
      } 
      bool2 = bool1;
      String str = a(paramTableEntity.getID(), paramTableEntity.Yg());
      bool2 = bool1;
      if (str.bUi) {
        bool2 = bool1;
        str = str.message;
      } else {
        bool2 = bool1;
        if (!str.bUi) {
          bool2 = bool1;
          if (str.cay > 0) {
            bool2 = bool1;
            str = str.message;
          } else {
            exception.endTransaction();
            q.close();
            exception.close();
            /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/laiqian/opentable/common/b}} */
            return false;
          } 
        } else {
          exception.endTransaction();
          q.close();
          exception.close();
          /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/laiqian/opentable/common/b}} */
          return false;
        } 
      } 
      bool2 = bool1;
      boolean bool = q.a(paramTableEntity, 3, str);
      if (bool)
        try {
          boolean bool3 = exception.a(paramPendingFullOrderDetail, paramLong);
          bool = bool3;
        } catch (Exception paramTableEntity) {
          boolean bool3 = bool;
        }  
      if (bool) {
        bool2 = bool;
        exception.setTransactionSuccessful();
        bool2 = bool;
        if (XC() && paramac != null) {
          bool2 = bool;
          paramac.jo(a(paramTableEntity, paramPendingFullOrderDetail, "0"));
        } 
      } 
      exception.endTransaction();
      q.close();
      exception.close();
    } catch (Exception paramTableEntity) {
      a.e(paramTableEntity);
      exception.endTransaction();
      q.close();
      bool1 = bool2;
      exception.close();
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{com/laiqian/opentable/common/b}} */
    return bool1;
  }
  
  public static boolean a(ArrayList<c> paramArrayList, int paramInt, c paramc) {
    for (byte b1 = 0; b1 < paramArrayList.size(); b1++) {
      if (((c)paramArrayList.get(b1)).Yl() == paramInt) {
        paramArrayList.remove(b1);
        paramArrayList.add(b1, paramc);
        return true;
      } 
    } 
    return false;
  }
  
  public static String aN(Context paramContext) {
    try {
      exception = new a(paramContext);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    ArrayList arrayList = exception.Xo();
    exception.close();
    if (arrayList != null)
      try {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (a a : arrayList) {
          JSONObject jSONObject1 = new JSONObject();
          jSONObject1.put("id", a.getId());
          jSONObject1.put("name", a.XX());
          JSONArray jSONArray1 = new JSONArray();
          null = new q(paramContext);
          ArrayList arrayList1 = null.x(a.getId(), 0L);
          null.close();
          for (TableEntity tableEntity : arrayList1) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", tableEntity.getID());
            jSONObject2.put("areaID", tableEntity.XY());
            jSONObject2.put("name", tableEntity.Vz());
            jSONObject2.put("max_person", tableEntity.XZ());
            jSONObject2.put("status", tableEntity.getState());
            jSONObject2.put("order_no", tableEntity.Yg().xq());
            jSONObject2.put("create_time", tableEntity.DP());
            jSONObject2.put("actual_person", tableEntity.Yb());
            jSONObject2.put("table_numbers", Q(tableEntity.Yh()));
            jSONArray1.put(jSONObject2);
          } 
          jSONObject1.put("tables", jSONArray1);
          jSONArray.put(jSONObject1);
        } 
        jSONObject.put("areas", jSONArray);
        return jSONObject.toString();
      } catch (Exception paramContext) {
        a.e(paramContext);
      }  
    return null;
  }
  
  public static ArrayList<TableEntity> aO(Context paramContext) {
    try {
      q q = new q(paramContext);
    } catch (Exception paramContext) {
      a.e(paramContext);
      paramContext = null;
    } 
    ArrayList arrayList = paramContext.YD();
    paramContext.close();
    return arrayList;
  }
  
  public static void au(String paramString1, String paramString2) { c(paramString1, XB(), paramString2); }
  
  public static c b(ArrayList<c> paramArrayList, int paramInt) {
    for (c c : paramArrayList) {
      if (c.Yl() == paramInt)
        return c; 
    } 
    return null;
  }
  
  public static PendingFullOrderDetail b(PendingFullOrderDetail paramPendingFullOrderDetail, String paramString) {
    PendingFullOrderDetail.a a = paramPendingFullOrderDetail.bXb;
    if (by.isNull(paramPendingFullOrderDetail.bXb.coK)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramPendingFullOrderDetail.bXb.aEI);
      stringBuilder.append("");
      str = stringBuilder.toString();
    } else {
      str = paramPendingFullOrderDetail.bXb.coK;
    } 
    a.coU = jb(str);
    a = paramPendingFullOrderDetail.bXb;
    String str = paramString;
    if (by.isNull(paramString))
      str = getUserID(); 
    a.coV = jb(str);
    return paramPendingFullOrderDetail;
  }
  
  public static String b(c paramc) {
    ArrayList arrayList = new ArrayList();
    arrayList.add(paramc);
    return h(arrayList, null);
  }
  
  private static void b(s params, t.f paramf) {
    String str;
    a a = new a(new k(params, paramf));
    int i = by.parseInt(params.aPq);
    if (i != 2002) {
      if (i != 2007) {
        if (i != 3004) {
          str = "";
        } else {
          str = RootUrlParameter.cma;
        } 
      } else {
        str = RootUrlParameter.clX;
      } 
    } else {
      str = RootUrlParameter.clX;
    } 
    if (!by.isNull(str) && !by.isNull(params.aSH))
      try {
        JSONObject jSONObject = new JSONObject(params.aSH);
        jSONObject.put("resend", 1);
        a.execute(new String[] { jSONObject.toString(), str });
        return;
      } catch (Exception params) {
        a.e(params);
      }  
  }
  
  public static void b(TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt) {
    try {
      paramTableEntity2.Yh().clear();
      if (paramInt == -1) {
        for (c c : paramTableEntity1.Yh()) {
          if (XB())
            c.da(String.valueOf(paramTableEntity2.getID())); 
          c.ch(paramTableEntity2.getID());
          paramTableEntity2.Yh().add(c);
        } 
        Collections.sort(paramTableEntity2.Yh());
        if (paramTableEntity2.Yh().size() > 0)
          paramTableEntity2.c((c)paramTableEntity2.Yh().get(0)); 
        paramTableEntity2.Yg().da(paramTableEntity1.Yg().xq());
        paramTableEntity2.setState(paramTableEntity1.getState());
        paramTableEntity2.cf(paramTableEntity1.DP());
        paramTableEntity1.Yc();
      } else {
        c c = b(paramTableEntity1.Yh(), paramInt);
        if (c != null) {
          c(paramTableEntity1.Yh(), paramInt);
          c.gx(0);
          c.ch(paramTableEntity2.getID());
          paramTableEntity2.c(c);
          paramTableEntity2.Yh().add(c);
          paramTableEntity2.setState(c.Yn());
          paramTableEntity2.cf(c.DP());
        } 
        if (paramTableEntity1.Yh().size() == 0) {
          paramTableEntity1.Yc();
        } else {
          Collections.sort(paramTableEntity1.Yh());
          paramTableEntity1.c((c)paramTableEntity1.Yh().get(0));
        } 
      } 
      n.k(paramTableEntity1);
      n.k(paramTableEntity2);
      q q = new q(RootApplication.zv());
      q.q(paramTableEntity1);
      q.q(paramTableEntity2);
      q.close();
      return;
    } catch (Exception paramTableEntity1) {
      a.e(paramTableEntity1);
      return;
    } 
  }
  
  public static TableEntity bY(long paramLong) {
    boolean bool;
    if (bd.bH(RootApplication.zv().getApplicationContext()) && (XB() || !XD())) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool ? n.ce(paramLong) : a(paramLong, RootApplication.zv().getApplicationContext());
  }
  
  public static void bZ(long paramLong) {
    av av = new av(RootApplication.zv());
    av.bZ(paramLong);
    av.close();
  }
  
  public static void bb(int paramInt1, int paramInt2) {
    hashMap = Xu();
    try {
      hashMap.put("order_info", b.encode(bc(paramInt1, paramInt2)));
      hashMap.put("device_id", m.Tw());
      hashMap.put("device_type", Integer.valueOf(m.getDeviceType()));
      n.a(hashMap, RootUrlParameter.cmf, new l());
      return;
    } catch (Exception hashMap) {
      a.e(hashMap);
      return;
    } 
  }
  
  private static String bc(int paramInt1, int paramInt2) {
    JSONObject jSONObject = new JSONObject();
    try {
      av av = new av(RootApplication.zv());
      String str = av.Tx();
      av.close();
      jSONObject.put("type", "table");
      jSONObject.put("sub_type", "update_open_table_state");
      jSONObject.put("is_open_table_enable", a.AZ().Bk());
      jSONObject.put("open_table_select_method", paramInt1);
      jSONObject.put("shop_id", str);
      jSONObject.put("refreshTableStatus", paramInt2);
    } catch (JSONException jSONException) {
      a.e(jSONException);
    } 
    return jSONObject.toString();
  }
  
  public static void c(String paramString1, boolean paramBoolean, String paramString2) {
    AliLog.b b1 = AliLog.b.dHc;
    b.a a = b.a.dEG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(",模式:");
    if (paramBoolean) {
      paramString1 = "在线模式";
    } else {
      paramString1 = "局域网模式";
    } 
    stringBuilder.append(paramString1);
    stringBuilder.append(",设备类型:");
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avL());
    b.a(b1, a, stringBuilder.toString(), paramString2);
  }
  
  public static boolean c(s params) {
    p p = new p(RootApplication.zv());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(params.aSF);
    stringBuilder.append("");
    boolean bool = p.hu(stringBuilder.toString());
    p.close();
    if (bool)
      RootApplication.zv().sendBroadcast(new Intent("pos_activity_change_data_area")); 
    return bool;
  }
  
  public static boolean c(ArrayList<c> paramArrayList, int paramInt) {
    for (c c : paramArrayList) {
      if (c.Yl() == paramInt)
        return paramArrayList.remove(c); 
    } 
    return false;
  }
  
  public static int ca(long paramLong) {
    byte b1;
    if (bd.bH(RootApplication.zv().getApplicationContext()) && (XB() || !XD())) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    if (b1) {
      str = Q(n.ce(paramLong).Yh());
    } else {
      str = cb(paramLong);
    } 
    if (!by.isNull(str))
      try {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = (new JSONObject(str)).keys();
        while (iterator.hasNext())
          arrayList.add(Integer.valueOf(by.parseInt((String)iterator.next()))); 
        if (arrayList.size() > 0) {
          Collections.sort(arrayList);
          int i = ((Integer)arrayList.get(arrayList.size() - 1)).intValue();
          b1 = 0;
          for (byte b2 = 0; b1 <= i + 1; b2 = b3) {
            byte b3;
            if (b1 == ((Integer)arrayList.get(b2)).intValue()) {
              int j = arrayList.size();
              b3 = b2;
              if (b2 < j - 1)
                b3 = b2 + 1; 
            } else if (!b1) {
              b3 = b2;
            } else {
              return b1;
            } 
            b1++;
          } 
        } 
      } catch (Exception str) {
        a.e(str);
      }  
    return 0;
  }
  
  private static String cb(long paramLong) {
    TableEntity tableEntity = bY(paramLong);
    return (tableEntity == null) ? "" : Q(tableEntity.Yh());
  }
  
  public static s cc(long paramLong) {
    p p = new p(RootApplication.zv());
    s s = p.bn(paramLong);
    p.close();
    return s;
  }
  
  @SuppressLint({"NewApi"})
  public static String d(long paramLong, int paramInt) {
    String str = cb(paramLong);
    if (!by.isNull(str))
      try {
        JSONObject jSONObject = new JSONObject(str);
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
          String str1 = (String)iterator.next();
          if (by.parseInt(str1) == paramInt) {
            jSONObject.remove(str1);
            return (jSONObject.length() > 0) ? jSONObject.toString() : "";
          } 
        } 
      } catch (Exception exception) {
        a.e(exception);
      }  
    return str;
  }
  
  public static String e(TableEntity paramTableEntity, int paramInt) {
    try {
      JSONObject jSONObject = Xv();
      jSONObject.put("type", "table");
      jSONObject.put("sub_type", "update_status");
      jSONObject.put("table_id", paramTableEntity.getID());
      jSONObject.put("update_time", (new Date()).getTime());
      jSONObject.put("table_status", paramTableEntity.getState());
      jSONObject.put("number_id", paramInt);
      return jSONObject.toString();
    } catch (JSONException paramTableEntity) {
      a.e(paramTableEntity);
      return null;
    } 
  }
  
  public static boolean e(long paramLong, int paramInt) { return j(paramInt, cb(paramLong)); }
  
  public static void eA(boolean paramBoolean) {
    try {
      exception = new at(RootApplication.zv());
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    exception.en(paramBoolean);
    exception.close();
  }
  
  public static void f(long paramLong, int paramInt) {
    i.wU().f(paramInt, paramLong);
    a.d(RootApplication.zv(), paramLong);
  }
  
  public static String getUserID() {
    av av = new av(RootApplication.zv());
    String str = av.atm();
    av.close();
    return str;
  }
  
  public static void gv(int paramInt) { bb(paramInt, 0); }
  
  public static String h(ArrayList<c> paramArrayList, String paramString) {
    if (paramArrayList != null)
      try {
        JSONObject jSONObject;
        if (by.isNull(paramString)) {
          jSONObject = new JSONObject();
        } else {
          jSONObject = new JSONObject(jSONObject);
        } 
        for (c c : paramArrayList) {
          JSONObject jSONObject1 = new JSONObject();
          jSONObject1.put("order_no", c.xq());
          jSONObject1.put("create_time", c.DP());
          jSONObject1.put("real_people", c.Ym());
          jSONObject1.put("table_state", c.Yn());
          jSONObject1.put("table_id", c.Yo());
          jSONObject1.put("table_cost", c.Yk());
          jSONObject1.put("releated_id", c.Yj());
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(c.Yl());
          stringBuilder.append("");
          jSONObject.put(stringBuilder.toString(), jSONObject1);
        } 
        return jSONObject.toString();
      } catch (Exception paramArrayList) {
        a.e(paramArrayList);
      }  
    return "";
  }
  
  public static boolean i(TableEntity paramTableEntity) {
    q q = new q(RootApplication.zv());
    boolean bool = q.a(paramTableEntity, 3, Q(paramTableEntity.Yh()));
    q.close();
    return bool;
  }
  
  public static boolean iV(String paramString) {
    try {
      JSONArray jSONArray = (new JSONObject(paramString)).getJSONArray("areas");
      ArrayList arrayList = new ArrayList();
      HashMap hashMap = new HashMap();
      byte b1 = 0;
      label64: while (true) {
        if (b1 < jSONArray.length()) {
          JSONObject jSONObject = jSONArray.getJSONObject(b1);
          long l = jSONObject.getLong("id");
          arrayList.add(new a(by.parseLong(jSONObject.getString("id")), jSONObject.getString("name")));
          JSONArray jSONArray1 = jSONObject.getJSONArray("tables");
          ArrayList arrayList1 = new ArrayList();
          byte b2 = 0;
          while (true) {
            if (b2 < jSONArray1.length()) {
              boolean bool;
              long l1;
              JSONObject jSONObject1 = jSONArray1.getJSONObject(b2);
              int i = by.parseInt(jSONObject1.getString("status"));
              if (jSONObject1.has("order_no")) {
                c = "order_no";
              } else {
                String str;
                c = "id";
              } 
              c = jSONObject1.getString(c);
              long l3 = jSONObject1.getLong("id");
              ArrayList arrayList2 = new ArrayList();
              if (jSONObject1.has("table_numbers") && i != 0) {
                String str = jSONObject1.getString("table_numbers");
                if (jSONObject1.has("order_no")) {
                  l1 = 0L;
                } else {
                  long l4;
                  l1 = by.parseLong(jSONObject1.getString("id"));
                } 
                arrayList2.addAll(m(str, l1));
              } 
              long l2 = by.parseLong(jSONObject1.getString("create_time"));
              if (i > 0 && !TextUtils.isEmpty(c)) {
                if (arrayList2.size() == 0) {
                  c c = new c(false, c, by.parseLong(jSONObject1.getString("create_time")), by.parseInt(jSONObject1.getString("actual_person")), by.parseInt(jSONObject1.getString("status")), by.parseLong(jSONObject1.getString("id")));
                  l1 = l2;
                  if (l2 == 0L)
                    l1 = c.DP(); 
                  c.cg(jSONObject1.optLong("releated_id"));
                  arrayList2.add(c);
                } else {
                  c c = (c)arrayList2.get(0);
                  l1 = c.DP();
                } 
              } else {
                c c;
                c = new c();
                l1 = l2;
              } 
              Iterator iterator = arrayList2.iterator();
              while (iterator.hasNext())
                ((c)iterator.next()).ch(l3); 
              TableEntity tableEntity = new TableEntity(by.parseLong(jSONObject1.getString("id")), by.parseLong(jSONObject1.getString("areaID")), jSONObject1.getString("name"), by.parseInt(jSONObject1.getString("max_person")), by.parseInt(jSONObject1.getString("status")), l1, c, arrayList2);
              if (XH()) {
                if (cc(tableEntity.getID()) != null) {
                  bool = true;
                } else {
                  boolean bool1;
                  bool = false;
                } 
                tableEntity.eG(bool);
              } 
              arrayList1.add(tableEntity);
              tableEntity.gw(jSONObject1.optInt("order_type"));
              if (XD()) {
                bool = false;
              } else {
                bool = XC();
              } 
              tableEntity.eF(bool);
              b2++;
              continue;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(l);
            stringBuilder.append("");
            hashMap.put(stringBuilder.toString(), arrayList1);
            b1++;
            continue label64;
          } 
          break;
        } 
        n.S(arrayList);
        n.C(hashMap);
        return true;
      } 
    } catch (JSONException paramString) {
      n.S(new ArrayList());
      n.C(new HashMap());
      a.e(paramString);
      return false;
    } 
  }
  
  public static ArrayList<PendingFullOrderDetail> iW(String paramString) {
    arrayList = new ArrayList();
    try {
      return arrayList;
    } catch (Exception paramString) {
      return arrayList;
    } finally {
      paramString = null;
    } 
  }
  
  public static PendingFullOrderDetail iX(String paramString) {
    try {
      exception = new g(RootApplication.zv());
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    PendingFullOrderDetail pendingFullOrderDetail = new PendingFullOrderDetail();
    PendingFullOrderDetail.c c = new PendingFullOrderDetail.c();
    try {
      null = new JSONObject(paramString);
      null.optString("type");
      null = new JSONObject(null.optString("header").replace("\\", ""));
      pendingFullOrderDetail.bXb.orderNo = null.optString("order_no");
      pendingFullOrderDetail.bXb.bJc = null.optLong("shop_id");
      pendingFullOrderDetail.bXb.aEI = null.optLong("user_id");
      pendingFullOrderDetail.bXb.bZF = null.optInt("order_type");
      pendingFullOrderDetail.bXb.coE = new Date(null.optLong("create_time"));
      pendingFullOrderDetail.bXb.coF = new Date(null.optLong("operation_time"));
      pendingFullOrderDetail.bXb.coJ = null.optString("table_id");
      pendingFullOrderDetail.bXb.coO = null.optLong("partner_id");
      pendingFullOrderDetail.bXb.ceX = Double.valueOf(null.optDouble("discount"));
      pendingFullOrderDetail.bXb.coM = null.optInt("number_id");
      if (pendingFullOrderDetail.bXb.bZF == 1)
        a(pendingFullOrderDetail, null); 
      pendingFullOrderDetail.bXb.aTU = null.optInt("order_status", -1);
      pendingFullOrderDetail.bXb.cpd = null.optInt("table_status", -1);
      pendingFullOrderDetail.bXb.bZP = null.optLong("releated_id", -1L);
      null = pendingFullOrderDetail.bXb;
      byte b1 = 0;
      null.bZM = null.optInt("actual_person", 0);
      pendingFullOrderDetail.bXb.btX = null.optInt("pay_type", 0);
      pendingFullOrderDetail.bXb.cpc = Double.valueOf(null.optDouble("total_amount", 0.0D));
      pendingFullOrderDetail.bXb.aVS = null.optInt("first_paytype", 0);
      pendingFullOrderDetail.bXb.bfj = null.optDouble("first_paytype_amount", 0.0D);
      pendingFullOrderDetail.bXb.aVU = null.optInt("second_paytype", 0);
      pendingFullOrderDetail.bXb.bfk = null.optDouble("second_paytype_amount", 0.0D);
      JSONArray jSONArray = null.getJSONArray("item");
      HashSet hashSet = new HashSet();
      long l = 0L;
      PendingFullOrderDetail.c c1 = c;
      while (true) {
        if (b1 < jSONArray.length()) {
          int i;
          JSONObject jSONObject = jSONArray.getJSONObject(b1);
          PendingFullOrderDetail.d d = new PendingFullOrderDetail.d();
          d.id = by.parseLong(jSONObject.getString("id"));
          if (d.id != 0L) {
            h h = exception.mE(String.valueOf(d.id));
          } else {
            c = null;
          } 
          byte b2 = b1 + 1;
          d.aTO = b2;
          if (by.isNull(jSONObject.optString("taste"))) {
            d.name = jSONObject.optString("product_name");
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(jSONObject.optString("product_name"));
            stringBuilder.append("[");
            stringBuilder.append(jSONObject.optString("taste"));
            stringBuilder.append("]");
            d.name = stringBuilder.toString();
          } 
          d.cpx = by.parseLong(jSONObject.getString("category"));
          if (d.cpx != 3L && c != null) {
            double d1;
            if (c != null) {
              d1 = c.akK();
            } else {
              d1 = by.parseDouble(jSONObject.getString("sale_price"));
            } 
            d.cpu = d1;
          } 
          if (c != null) {
            i = c.status;
          } else {
            i = 600001;
          } 
          d.cpy = i;
          d.aTU = jSONObject.optInt("order_status", -1);
          d.cpz = jSONObject.optLong("item_id");
          d.cpq = by.parseLong(jSONObject.optString("type_id"));
          d.cpo = by.parseDouble(jSONObject.optString("quantity"));
          d.cpn = by.parseDouble(jSONObject.optString("sale_price"));
          d.cpu = by.parseDouble(jSONObject.optString("member_price"));
          d.cpk = jSONObject.optString("mealsetNames");
          if (c != null)
            if (d.cpx == 3L) {
              d.cpu = 0.0D;
            } else if (c.akI() != d.cpn) {
              d.cpu = d.cpn - c.akI() + c.akK();
            } else {
              d.cpu = c.akK();
            }  
          if (d.cpu < 0.0D)
            d.cpu = 0.0D; 
          d.bbX = by.parseLong(jSONObject.optString("create_time"));
          d.aTR.addAll(ja(jSONObject.optString("tax").replace("\\\\", "")));
          d.aTF = jSONObject.optDouble("amountOfNoTax");
          d.aTG = jSONObject.optDouble("amountOfAddPrice");
          boolean bool = hashSet.add(Long.valueOf(d.bbX));
          if (bool)
            l = 0L; 
          d.cpl = Long.valueOf(l);
          if (hashSet.size() == 1) {
            pendingFullOrderDetail.coy.add(d);
            c = c1;
          } else if ((hashSet.size() == 2 && bool) || (hashSet.size() > 1 && !bool)) {
            c1.cpg.add(d);
            c1.cpi = new Date(d.bbX);
            c = c1;
          } else {
            c = c1;
            if (hashSet.size() > 2) {
              c = c1;
              if (bool) {
                pendingFullOrderDetail.coz.add(c1);
                c = new PendingFullOrderDetail.c();
                c.cpg.add(d);
                c.cpi = new Date(d.bbX);
              } 
            } 
          } 
          if (hashSet.size() > 1 && b1 == jSONArray.length() - 1)
            pendingFullOrderDetail.coz.add(c); 
          b1 = b2;
          l++;
          c1 = c;
          continue;
        } 
        exception.close();
        return pendingFullOrderDetail;
      } 
    } catch (JSONException paramString) {
      a.e(paramString);
      exception.close();
      return null;
    } finally {}
    exception.close();
    throw paramString;
  }
  
  public static PendingFullOrderDetail iY(String paramString) {
    PendingFullOrderDetail pendingFullOrderDetail = new PendingFullOrderDetail();
    PendingFullOrderDetail.c c = new PendingFullOrderDetail.c();
    try {
      if (by.isNull(paramString))
        return null; 
      JSONArray jSONArray = new JSONObject(paramString);
      JSONObject jSONObject = new JSONObject(jSONArray.getString("header").replace("\\", ""));
      pendingFullOrderDetail.bXb.orderNo = jSONObject.optString("order_no");
      pendingFullOrderDetail.bXb.bJc = jSONObject.optLong("shop_id");
      pendingFullOrderDetail.bXb.aEI = jSONObject.optLong("user_id");
      pendingFullOrderDetail.bXb.bZF = jSONObject.optInt("order_type");
      pendingFullOrderDetail.bXb.coE = new Date(jSONObject.getLong("create_time"));
      pendingFullOrderDetail.bXb.coJ = jSONObject.optString("table_id");
      pendingFullOrderDetail.bXb.coF = new Date(jSONObject.optLong("operation_time"));
      if (!by.isNull(jSONArray.optString("changed_item")) && !"[]".equals(jSONArray.optString("changed_item"))) {
        jSONArray = jSONArray.getJSONArray("changed_item");
      } else if (!by.isNull(jSONArray.optString("print_changed_item")) && !"[]".equals(jSONArray.optString("print_changed_item"))) {
        jSONArray = jSONArray.getJSONArray("print_changed_item");
      } else {
        jSONArray = jSONArray.getJSONArray("item");
      } 
      HashSet hashSet = new HashSet();
      ba ba = new ba(RootApplication.zv());
      byte b1 = 0;
      while (true) {
        PendingFullOrderDetail.c c1;
        byte b2;
        if (b1 < jSONArray.length()) {
          int i;
          g g = new g(RootApplication.zv());
          JSONObject jSONObject1 = jSONArray.getJSONObject(b1);
          PendingFullOrderDetail.d d = new PendingFullOrderDetail.d();
          d.id = jSONObject1.getLong("id");
          b2 = b1 + 1;
          d.aTO = b2;
          if (by.isNull(jSONObject1.getString("taste"))) {
            d.name = jSONObject1.optString("product_name");
          } else {
            c1 = new StringBuilder();
            c1.append(jSONObject1.optString("product_name"));
            c1.append("[");
            c1.append(jSONObject1.optString("taste"));
            c1.append("]");
            d.name = c1.toString();
          } 
          if (d.cpx != 4L) {
            c1 = g.mE(String.valueOf(d.id));
          } else {
            c1 = null;
          } 
          if (c1 != null) {
            i = c1.status;
          } else {
            i = 600001;
          } 
          d.cpy = i;
          d.aTU = jSONObject1.optInt("order_status", -1);
          d.cpq = by.parseLong(jSONObject1.optString("type_id"));
          d.cpx = by.parseLong(jSONObject1.optString("category"));
          d.cpo = by.parseDouble(jSONObject1.optString("quantity"));
          if (jSONObject1.has("tax"))
            d.aTR.addAll(ja(jSONObject1.optString("tax").replace("\\\\", ""))); 
          if (jSONObject1.has("amountOfNoTax"))
            d.aTF = jSONObject1.optDouble("amountOfNoTax"); 
          if (jSONObject1.has("amountOfAddPrice"))
            d.aTG = jSONObject1.optDouble("amountOfAddPrice"); 
          if (d.cpo < 0.0D && jSONObject.optInt("order_status") == 2) {
            d.cpn = by.parseDouble("0");
          } else {
            d.cpn = by.parseDouble(jSONObject1.optString("sale_price"));
          } 
          d.bbX = by.parseLong(jSONObject1.optString("create_time"));
          if (c1 != null && d.cpx != 4L)
            if (d.cpx == 3L) {
              d.cpu = 0.0D;
            } else if (c1.akI() != d.cpn) {
              d.cpu = d.cpn - c1.akI() + c1.akK();
            } else {
              d.cpu = c1.akK();
            }  
          if (d.cpu < 0.0D)
            d.cpu = 0.0D; 
          g.close();
          boolean bool = hashSet.add(Long.valueOf(d.bbX));
          if (hashSet.size() == 1) {
            pendingFullOrderDetail.coy.add(d);
            c1 = c;
          } else if ((hashSet.size() == 2 && bool) || (hashSet.size() > 1 && !bool)) {
            c.cpg.add(d);
            c.cpi = new Date(d.bbX);
            c1 = c;
          } else {
            c1 = c;
            if (hashSet.size() > 2) {
              c1 = c;
              if (bool) {
                pendingFullOrderDetail.coz.add(c);
                c1 = new PendingFullOrderDetail.c();
                c1.cpg.add(d);
                c1.cpi = new Date(d.bbX);
              } 
            } 
          } 
          if (hashSet.size() > 1 && b1 == jSONArray.length() - 1)
            pendingFullOrderDetail.coz.add(c1); 
        } else {
          if (pendingFullOrderDetail.bXb.bZF == 2 || pendingFullOrderDetail.bXb.bZF == 3) {
            pendingFullOrderDetail.bXb.bZM = jSONObject.optInt("actual_person");
            pendingFullOrderDetail.bXb.cpd = jSONObject.optInt("table_status");
            pendingFullOrderDetail.bXb.coM = jSONObject.optInt("number_id");
            ba.close();
            return pendingFullOrderDetail;
          } 
          if (pendingFullOrderDetail.bXb.bZF == 1)
            a(pendingFullOrderDetail, jSONObject); 
          ba.close();
          return pendingFullOrderDetail;
        } 
        b1 = b2;
        c = c1;
      } 
    } catch (JSONException paramString) {
      a.e(paramString);
      return null;
    } 
  }
  
  public static PendingFullOrderDetail iZ(String paramString) {
    PendingFullOrderDetail pendingFullOrderDetail = new PendingFullOrderDetail();
    PendingFullOrderDetail.c c = new PendingFullOrderDetail.c();
    try {
      if (by.isNull(paramString))
        return null; 
      JSONArray jSONArray = new JSONObject(paramString);
      JSONObject jSONObject = new JSONObject(jSONArray.getString("header").replace("\\", ""));
      pendingFullOrderDetail.bXb.orderNo = jSONObject.optString("order_no");
      pendingFullOrderDetail.bXb.bJc = jSONObject.optLong("shop_id");
      pendingFullOrderDetail.bXb.aEI = jSONObject.optLong("user_id");
      pendingFullOrderDetail.bXb.bZF = jSONObject.optInt("order_type");
      pendingFullOrderDetail.bXb.coE = new Date(jSONObject.getLong("create_time"));
      pendingFullOrderDetail.bXb.coJ = jSONObject.optString("table_id");
      pendingFullOrderDetail.bXb.coF = new Date(jSONObject.optLong("operation_time"));
      if (!by.isNull(jSONArray.optString("print_changed_item")) && !"[]".equals(jSONArray.optString("print_changed_item"))) {
        JSONArray jSONArray1 = jSONArray.getJSONArray("print_changed_item");
      } else {
        jSONArray = new JSONArray();
      } 
      HashSet hashSet = new HashSet();
      ba ba = new ba(RootApplication.zv());
      byte b1 = 0;
      while (true) {
        PendingFullOrderDetail.c c1;
        byte b2;
        if (b1 < jSONArray.length()) {
          int i;
          g g = new g(RootApplication.zv());
          JSONObject jSONObject1 = jSONArray.getJSONObject(b1);
          PendingFullOrderDetail.d d = new PendingFullOrderDetail.d();
          d.id = jSONObject1.getLong("id");
          b2 = b1 + 1;
          d.aTO = b2;
          if (by.isNull(jSONObject1.getString("taste"))) {
            d.name = jSONObject1.optString("product_name");
          } else {
            c1 = new StringBuilder();
            c1.append(jSONObject1.optString("product_name"));
            c1.append("[");
            c1.append(jSONObject1.optString("taste"));
            c1.append("]");
            d.name = c1.toString();
          } 
          if (d.cpx != 4L) {
            c1 = g.mE(String.valueOf(d.id));
          } else {
            c1 = null;
          } 
          if (c1 != null) {
            i = c1.status;
          } else {
            i = 600001;
          } 
          d.cpy = i;
          d.aTU = jSONObject1.optInt("order_status", -1);
          d.cpq = by.parseLong(jSONObject1.optString("type_id"));
          d.cpx = by.parseLong(jSONObject1.optString("category"));
          d.cpo = by.parseDouble(jSONObject1.optString("quantity"));
          if (jSONObject1.has("tax"))
            d.aTR.addAll(ja(jSONObject1.optString("tax").replace("\\\\", ""))); 
          if (jSONObject1.has("amountOfNoTax"))
            d.aTF = jSONObject1.optDouble("amountOfNoTax"); 
          if (jSONObject1.has("amountOfAddPrice"))
            d.aTG = jSONObject1.optDouble("amountOfAddPrice"); 
          if (d.cpo < 0.0D && jSONObject.optInt("order_status") == 2) {
            d.cpn = by.parseDouble("0");
          } else {
            d.cpn = by.parseDouble(jSONObject1.optString("sale_price"));
          } 
          d.bbX = by.parseLong(jSONObject1.optString("create_time"));
          if (c1 != null && d.cpx != 4L)
            if (d.cpx == 3L) {
              d.cpu = 0.0D;
            } else if (c1.akI() != d.cpn) {
              d.cpu = d.cpn - c1.akI() + c1.akK();
            } else {
              d.cpu = c1.akK();
            }  
          if (d.cpu < 0.0D)
            d.cpu = 0.0D; 
          g.close();
          boolean bool = hashSet.add(Long.valueOf(d.bbX));
          if (hashSet.size() == 1) {
            pendingFullOrderDetail.coy.add(d);
            c1 = c;
          } else if ((hashSet.size() == 2 && bool) || (hashSet.size() > 1 && !bool)) {
            c.cpg.add(d);
            c.cpi = new Date(d.bbX);
            c1 = c;
          } else {
            c1 = c;
            if (hashSet.size() > 2) {
              c1 = c;
              if (bool) {
                pendingFullOrderDetail.coz.add(c);
                c1 = new PendingFullOrderDetail.c();
                c1.cpg.add(d);
                c1.cpi = new Date(d.bbX);
              } 
            } 
          } 
          if (hashSet.size() > 1 && b1 == jSONArray.length() - 1)
            pendingFullOrderDetail.coz.add(c1); 
        } else {
          if (pendingFullOrderDetail.bXb.bZF == 2 || pendingFullOrderDetail.bXb.bZF == 3) {
            pendingFullOrderDetail.bXb.bZM = jSONObject.optInt("actual_person");
            pendingFullOrderDetail.bXb.cpd = jSONObject.optInt("table_status");
            pendingFullOrderDetail.bXb.coM = jSONObject.optInt("number_id");
            ba.close();
            return pendingFullOrderDetail;
          } 
          if (pendingFullOrderDetail.bXb.bZF == 1)
            a(pendingFullOrderDetail, jSONObject); 
          ba.close();
          return pendingFullOrderDetail;
        } 
        b1 = b2;
        c = c1;
      } 
    } catch (JSONException paramString) {
      a.e(paramString);
      return null;
    } catch (Exception paramString) {
      a.e(paramString);
      return pendingFullOrderDetail;
    } 
  }
  
  public static void j(TableEntity paramTableEntity) {
    boolean bool;
    if (paramTableEntity == null)
      return; 
    if (bd.bH(RootApplication.zv().getApplicationContext()) && (XB() || !XD())) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      n.k(paramTableEntity); 
    String str = Q(paramTableEntity.Yh());
    q q = new q(RootApplication.zv());
    q.a(paramTableEntity, 3, str);
    q.close();
  }
  
  public static boolean j(int paramInt, String paramString) {
    if (!by.isNull(paramString))
      try {
        Iterator iterator = (new JSONObject(paramString)).keys();
        while (iterator.hasNext()) {
          int i = by.parseInt((String)iterator.next());
          if (i == paramInt)
            return true; 
        } 
      } catch (Exception paramString) {
        a.e(paramString);
      }  
    return false;
  }
  
  public static ArrayList<o> ja(String paramString) {
    ArrayList arrayList = new ArrayList();
    try {
      if (!TextUtils.isEmpty(paramString) && !paramString.equals("[]")) {
        JSONArray jSONArray = new JSONArray(paramString);
        ArrayList arrayList1 = new ArrayList();
        for (byte b1 = 0; b1 < jSONArray.length(); b1++)
          arrayList1.add(Long.valueOf(jSONArray.getJSONObject(b1).getLong("taxId"))); 
        arrayList.addAll((new ba(RootApplication.zv())).j(arrayList1));
        return arrayList;
      } 
    } catch (Exception paramString) {
      a.e(paramString);
    } 
    return arrayList;
  }
  
  public static String jb(String paramString) {
    if (by.isNull(paramString))
      return ""; 
    bh bh = null;
    try {
      bh bh1 = new bh(RootApplication.zv());
      bh = bh1;
    } catch (Exception exception) {
      a.e(exception);
    } 
    String str2 = bh.iB(paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = bh.iD(paramString); 
    bh.close();
    return str1;
  }
  
  public static b jc(@NonNull String paramString) {
    b b1 = new b();
    try {
      paramString = (new JSONObject(paramString)).optString("more_info");
      boolean bool = by.isNull(paramString);
      if (!bool)
        try {
          JSONObject jSONObject = new JSONObject(paramString);
          b1.W(jSONObject.optLong("create_time")).ek(jSONObject.optInt("device_type")).cB(jSONObject.optString("message_type")).h(jSONObject.optDouble("version"));
          return b1;
        } catch (JSONException paramString) {
          a.e(paramString);
          return b1;
        }  
    } catch (JSONException paramString) {
      a.e(paramString);
    } 
    return b1;
  }
  
  public static ArrayList<c> jd(String paramString) {
    ArrayList arrayList = new ArrayList();
    if (!by.isNull(paramString))
      try {
        JSONObject jSONObject = new JSONObject(paramString);
        Iterator iterator = jSONObject.keys();
        while (true) {
          if (iterator.hasNext()) {
            String str1 = (String)iterator.next();
            JSONObject jSONObject1 = jSONObject.optJSONObject(str1);
            Object object = jSONObject1.get("order_no");
            if (object instanceof Number) {
              object = object.toString();
            } else if (object instanceof String) {
              object = (String)object;
            } else {
              object = "0";
            } 
            long l1 = jSONObject1.optLong("create_time");
            int i = jSONObject1.optInt("real_people");
            int j = jSONObject1.optInt("table_state");
            String str2 = jSONObject1.optString("table_cost");
            long l2 = jSONObject1.optLong("table_id");
            long l3 = jSONObject1.optLong("releated_id");
            object = new c(str2, by.parseInt(str1), object, l1, i, j, l2);
            object.cg(l3);
            arrayList.add(object);
            continue;
          } 
          Collections.sort(arrayList);
          return arrayList;
        } 
      } catch (Exception paramString) {
        a.e(paramString);
      }  
    return arrayList;
  }
  
  public static void je(String paramString) { o(paramString, XB()); }
  
  public static PendingFullOrderDetail jf(String paramString) {
    if (!by.isNull(paramString))
      try {
        String str = new JSONObject(paramString);
        if (XB()) {
          str = str.getString("order_info");
          return by.isNull(str) ? null : iX(str);
        } 
        str = b.decode(str.getString("data"));
        return by.isNull(str) ? null : iX(str);
      } catch (JSONException paramString) {
        a.e(paramString);
      }  
    return null;
  }
  
  public static ArrayList<c> m(String paramString, long paramLong) {
    ArrayList arrayList = new ArrayList();
    if (!by.isNull(paramString) || "{}".equals(paramString))
      try {
        JSONObject jSONObject = new JSONObject(paramString);
        Iterator iterator = jSONObject.keys();
        while (true) {
          if (iterator.hasNext()) {
            String str1 = (String)iterator.next();
            JSONObject jSONObject1 = jSONObject.optJSONObject(str1);
            paramLong = jSONObject1.optLong("create_time");
            int i = jSONObject1.optInt("real_people");
            int j = jSONObject1.optInt("table_state");
            String str2 = jSONObject1.optString("table_cost");
            long l = jSONObject1.optLong("table_id");
            Object object = jSONObject1.get("order_no");
            if (object instanceof Number) {
              object = object.toString();
            } else if (object instanceof String) {
              object = (String)object;
            } else {
              object = "0";
            } 
            object = new c(str2, by.parseInt(str1), object, paramLong, i, j, l);
            object.cg(jSONObject1.optLong("releated_id"));
            arrayList.add(object);
            continue;
          } 
          Collections.sort(arrayList);
          return arrayList;
        } 
      } catch (Exception paramString) {
        a.e(paramString);
      }  
    return arrayList;
  }
  
  public static boolean n(PendingFullOrderDetail paramPendingFullOrderDetail) {
    TableEntity tableEntity = null;
    try {
      c c;
      if (!e(Long.parseLong(paramPendingFullOrderDetail.bXb.coJ), paramPendingFullOrderDetail.bXb.coM)) {
        if (paramPendingFullOrderDetail.bXb.cpd == 2) {
          TableEntity tableEntity1 = bY(Long.parseLong(paramPendingFullOrderDetail.bXb.coJ));
          tableEntity = tableEntity1;
          if (tableEntity1 != null) {
            c = new c(paramPendingFullOrderDetail.bXb.coM, paramPendingFullOrderDetail.bXb.orderNo, paramPendingFullOrderDetail.bXb.coE.getTime(), paramPendingFullOrderDetail.bXb.bZM, paramPendingFullOrderDetail.bXb.cpd, Long.parseLong(paramPendingFullOrderDetail.bXb.coJ));
            tableEntity1.W(jd((a(c.Yo(), c)).message));
            Collections.sort(tableEntity1.Yh());
            tableEntity1.c((c)tableEntity1.Yh().get(0));
            tableEntity = tableEntity1;
            if (tableEntity1.getState() == 0) {
              tableEntity1.cf(c.DP());
              tableEntity1.setState(2);
              tableEntity = tableEntity1;
            } 
          } 
        } 
      } else {
        TableEntity tableEntity1 = bY(Long.parseLong(c.bXb.coJ));
        tableEntity = tableEntity1;
        if (c.bXb.cpd == 2) {
          c c1 = b(tableEntity1.Yh(), c.bXb.coM);
          c1.gy(c.bXb.bZM);
          tableEntity = tableEntity1;
          if (c1 != null) {
            a(tableEntity1.Yh(), c.bXb.coM, c1);
            tableEntity1.c((c)tableEntity1.Yh().get(0));
            tableEntity = tableEntity1;
          } 
        } 
      } 
      j(tableEntity);
      return true;
    } catch (Exception paramPendingFullOrderDetail) {
      a.e(paramPendingFullOrderDetail);
      return false;
    } 
  }
  
  public static a o(Context paramContext, String paramString) {
    if (bd.bH(paramContext) && XB())
      return n.cd(by.parseLong(paramString)); 
    Context context = null;
    try {
      a a1 = new a(paramContext);
    } catch (Exception paramContext) {
      a.e(paramContext);
      paramContext = context;
    } 
    a a = paramContext.iR(paramString);
    paramContext.close();
    return a;
  }
  
  public static void o(String paramString, boolean paramBoolean) { c(paramString, XB(), ""); }
  
  public static String z(HashMap<String, Object> paramHashMap) throws JSONException {
    av av = new av(RootApplication.zv());
    String str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    return (new LqkRequest.a()).iG(str1).iH(str2).bU(by.parseLong(str3)).A(paramHashMap).WO().IX();
  }
  
  class b {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\opentable\common\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */