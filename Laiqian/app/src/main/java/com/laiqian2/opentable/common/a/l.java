package com.laiqian.opentable.common.a;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.s;
import com.laiqian.main.bb;
import com.laiqian.message.m;
import com.laiqian.network.i;
import com.laiqian.network.k;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.c.a;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.t;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.cg;
import io.reactivex.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import kotlin.f;
import org.json.JSONException;
import org.json.JSONObject;

public class l implements a {
  private g cad;
  
  private Context context;
  
  public l(Context paramContext, g paramg) {
    this.context = paramContext;
    this.cad = paramg;
  }
  
  private n<i> a(long paramLong, String paramString1, String paramString2) { return n.e(new s(paramString1, paramString2)).d(new t(paramLong)).g(new u(paramLong)); }
  
  private n<f<Boolean, PendingFullOrderDetail, TableEntity>> a(String paramString, long paramLong1, TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, long paramLong2) { return n.e(new n(paramString)).d(new o(paramString, paramLong1)).g(new p(this, paramPendingFullOrderDetail, paramString, paramTableEntity, paramLong2, paramLong1)); }
  
  private String a(String paramString, PendingFullOrderDetail paramPendingFullOrderDetail, bb parambb) {
    try {
      JSONObject jSONObject = new JSONObject();
      if (paramPendingFullOrderDetail.bXb.aVS > 0L) {
        jSONObject.put("id", paramPendingFullOrderDetail.bXb.aVS);
        jSONObject.put("name", paramPendingFullOrderDetail.bXb.coW);
        jSONObject.put("amount", paramPendingFullOrderDetail.bXb.bfj);
        jSONObject.put("sub_type_id", paramPendingFullOrderDetail.bXb.coX);
      } 
      if (paramPendingFullOrderDetail.bXb.aVU > 0L) {
        jSONObject.put("second_id", paramPendingFullOrderDetail.bXb.aVU);
        jSONObject.put("second_name", paramPendingFullOrderDetail.bXb.coY);
        jSONObject.put("second_amount", paramPendingFullOrderDetail.bXb.bfk);
        jSONObject.put("second_sub_type_id", paramPendingFullOrderDetail.bXb.coZ);
      } 
      jSONObject.put("discount", paramPendingFullOrderDetail.bXb.ceX);
      jSONObject.put("memberId", paramPendingFullOrderDetail.bXb.coO);
      if (parambb.vipEntity != null) {
        jSONObject.put("belongId", parambb.vipEntity.aWC);
      } else {
        av av = new av(this.context);
        jSONObject.put("belongId", av.Tx());
        av.close();
      } 
      return (new JSONObject(paramString)).put("pay", jSONObject).toString();
    } catch (Exception paramString) {
      a.e(paramString);
      return "";
    } 
  }
  
  public n<f<Boolean, PendingFullOrderDetail, TableEntity>> a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, long paramLong) { return n.e(new m(this, paramTableEntity, paramPendingFullOrderDetail, paramLong)); }
  
  public n<cg<Boolean, PendingFullOrderDetail, PendingFullOrderDetail.c, TableEntity>> a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail1, PendingFullOrderDetail paramPendingFullOrderDetail2, PendingFullOrderDetail paramPendingFullOrderDetail3) { return n.e(new r(this, paramPendingFullOrderDetail2, paramTableEntity, paramPendingFullOrderDetail1, paramPendingFullOrderDetail3)); }
  
  public void a(long paramLong1, long paramLong2, t.i parami) throws m { // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: aload #6
    //   11: lload_1
    //   12: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload #6
    //   18: ldc ''
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #6
    //   26: invokevirtual toString : ()Ljava/lang/String;
    //   29: invokestatic jg : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: invokevirtual iterator : ()Ljava/util/Iterator;
    //   35: astore #7
    //   37: aload #7
    //   39: invokeinterface hasNext : ()Z
    //   44: ifeq -> 72
    //   47: aload #7
    //   49: invokeinterface next : ()Ljava/lang/Object;
    //   54: checkcast com/laiqian/opentable/common/entity/TableEntity
    //   57: astore #6
    //   59: aload #6
    //   61: invokevirtual getID : ()J
    //   64: lload_3
    //   65: lcmp
    //   66: ifne -> 37
    //   69: goto -> 75
    //   72: aconst_null
    //   73: astore #6
    //   75: aload #5
    //   77: aload #6
    //   79: invokeinterface g : (Lcom/laiqian/opentable/common/entity/TableEntity;)V
    //   84: return }
  
  public void a(long paramLong1, long paramLong2, t.j paramj) {
    StringBuilder stringBuilder1;
    null = new StringBuilder();
    null.append(paramLong1);
    null.append("");
    StringBuilder stringBuilder2 = n.jg(null.toString());
    boolean bool = false;
    if (stringBuilder2 != null) {
      byte b;
      for (b = 0; b < stringBuilder2.size(); b++) {
        boolean bool1 = true;
        if (paramLong2 > 0L && ((TableEntity)stringBuilder2.get(b)).getID() == paramLong2) {
          ((TableEntity)stringBuilder2.get(b)).eE(true);
          break;
        } 
        TableEntity tableEntity = (TableEntity)stringBuilder2.get(b);
        if (b.cc(((TableEntity)stringBuilder2.get(b)).getID()) == null)
          bool1 = false; 
        tableEntity.eG(bool1);
      } 
    } 
    if (stringBuilder2 != null) {
      byte b = bool;
      while (true) {
        if (b < stringBuilder2.size())
          try {
            ((TableEntity)stringBuilder2.get(b)).jl(n.cd(((TableEntity)stringBuilder2.get(b)).XY()).XX());
            b++;
            continue;
          } catch (NullPointerException paramj) {
            stringBuilder1 = new StringBuilder();
            for (TableEntity tableEntity : stringBuilder2) {
              StringBuilder stringBuilder3 = new StringBuilder();
              stringBuilder3.append(tableEntity.Vz());
              stringBuilder3.append("-");
              stringBuilder3.append(tableEntity.getID());
              stringBuilder3.append("-");
              stringBuilder3.append(tableEntity.XY());
              stringBuilder3.append(" / ");
              stringBuilder1.append(stringBuilder3.toString());
            } 
            stringBuilder2 = new StringBuilder();
            for (a a1 : n.Xo()) {
              StringBuilder stringBuilder3 = new StringBuilder();
              stringBuilder3.append(a1.XX());
              stringBuilder3.append("-");
              stringBuilder3.append(a1.getId());
              stringBuilder3.append(" / ");
              stringBuilder2.append(stringBuilder3.toString());
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("areaID: ");
            stringBuilder.append(paramLong1);
            stringBuilder.append(", selectTableID: ");
            stringBuilder.append(paramLong2);
            stringBuilder.append(" \n areas: ");
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(" \n tables: ");
            stringBuilder.append(stringBuilder1.toString());
            throw new IllegalStateException(stringBuilder.toString());
          }  
        stringBuilder1.U(stringBuilder2);
        return;
      } 
    } 
    stringBuilder1.U(stringBuilder2);
  }
  
  public void a(long paramLong, t.f paramf) {}
  
  public void a(TableEntity paramTableEntity, int paramInt, t.f paramf) throws m {
    HashMap hashMap = b.Xu();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.getID());
    stringBuilder.append("");
    hashMap.put("table_id", stringBuilder.toString());
    hashMap.put("table_cost", paramTableEntity.Yg().Yk());
    hashMap.put("table_status", String.valueOf(paramTableEntity.getState()));
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.Yg().Yl());
    stringBuilder.append("");
    hashMap.put("number_id", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.Yb());
    stringBuilder.append("");
    hashMap.put("actual_person", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.Yg().Ym());
    stringBuilder.append("");
    hashMap.put("number_actual_person", stringBuilder.toString());
    hashMap.put("device_id", m.Tw());
    hashMap.put("device_type", Integer.valueOf(m.getDeviceType()));
    stringBuilder = new StringBuilder();
    stringBuilder.append("请求编辑人数,");
    stringBuilder.append(hashMap.toString());
    b.je(stringBuilder.toString());
    n.a(hashMap, RootUrlParameter.cmb, new w(this, hashMap, paramTableEntity, paramf));
  }
  
  public void a(TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt, t.k paramk) {
    HashMap hashMap = b.Xu();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity1.getID());
    stringBuilder.append("");
    hashMap.put("table_id", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity1.Yg().Yl());
    stringBuilder.append("");
    hashMap.put("number_id", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("请求移桌,");
    stringBuilder.append(hashMap.toString());
    b.je(stringBuilder.toString());
    n.a(hashMap, RootUrlParameter.clW, new x(this, hashMap, paramTableEntity2, paramTableEntity1, paramInt, paramk));
  }
  
  public void a(TableEntity paramTableEntity, t.f paramf) {}
  
  public void a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail, bb parambb, t.f paramf) throws JSONException {
    String str2;
    TableEntity tableEntity = new TableEntity(paramTableEntity);
    if (tableEntity.Yh().size() == 1 && paramPendingFullOrderDetail.bXb.bZF != 3)
      tableEntity.Yc(); 
    HashMap hashMap = b.Xu();
    String str1 = new StringBuilder();
    str1.append(paramTableEntity.getID());
    str1.append("");
    hashMap.put("table_id", str1.toString());
    if (b.XD()) {
      String str = "3";
      str2 = b.a(tableEntity, paramPendingFullOrderDetail, null, "3");
    } else {
      str1 = "2";
      str2 = a(b.a(tableEntity, paramPendingFullOrderDetail, "2"), paramPendingFullOrderDetail, parambb);
    } 
    hashMap.put("order_info", str2);
    hashMap.put("order_status", str1);
    hashMap.put("order_no", paramPendingFullOrderDetail.bXb.orderNo);
    hashMap.put("number_id", Integer.valueOf(paramTableEntity.Yg().Yl()));
    hashMap.put("device_id", m.Tw());
    hashMap.put("device_type", Integer.valueOf(m.getDeviceType()));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("请求结算订单,");
    stringBuilder.append(hashMap.toString());
    b.je(stringBuilder.toString());
    long l1 = b.a(3004, tableEntity, paramf, hashMap);
    n.a(hashMap, RootUrlParameter.cma, new aa(this, hashMap, l1, paramTableEntity, paramPendingFullOrderDetail, parambb, paramf));
  }
  
  public void a(TableEntity paramTableEntity, String paramString, int paramInt, t.c paramc) throws m { b.a(paramTableEntity, paramInt, paramc, true, new z(this, paramTableEntity, paramString, paramInt)); }
  
  public void a(a parama, t.f paramf) {}
  
  public void a(t.d paramd) { paramd.T(n.Xo()); }
  
  public void a(String paramString, t.e parame) {}
  
  public void b(long paramLong, t.f paramf) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    ArrayList arrayList = n.jg(stringBuilder.toString());
    if (arrayList != null && arrayList.size() > 0) {
      paramf.dp(true);
      return;
    } 
    paramf.dp(false);
  }
  
  public void b(TableEntity paramTableEntity, t.f paramf) {}
  
  public void b(String paramString, int paramInt, t.g paramg) { b.a(paramString, paramInt, paramg); }
  
  public void c(long paramLong, t.f paramf) {}
  
  public n<f<Boolean, PendingFullOrderDetail, TableEntity>> e(s params) { return n.e(new q(params)); }
  
  public n<cg<Boolean, PendingFullOrderDetail, PendingFullOrderDetail.c, TableEntity>> f(s params) { return n.e(new v(params)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */