package com.laiqian.opentable.common.connect;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.i;
import com.laiqian.models.p;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.t;
import com.laiqian.ordertool.a;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.av;
import org.json.JSONObject;

public class b {
  private static String a(String paramString1, TableEntity paramTableEntity, long paramLong, int paramInt, String paramString2) {
    try {
      JSONObject jSONObject1 = new JSONObject(paramString1);
      JSONObject jSONObject2 = new JSONObject();
      jSONObject2.put("create_time", paramTableEntity.DP());
      jSONObject2.put("table_id", paramTableEntity.getID());
      jSONObject2.put("actual_person", paramTableEntity.Yb());
      jSONObject2.put("number_id", paramInt);
      jSONObject2.put("from_table_id", paramLong);
      jSONObject2.put("machine_type", RootApplication.getLaiqianPreferenceManager().avL());
      jSONObject1.put("table_info", jSONObject2);
      jSONObject1.put("should_print_receipt", RootApplication.getLaiqianPreferenceManager().avR());
      return jSONObject1.toString();
    } catch (Exception paramString1) {
      a.e(paramString1);
      return paramString2;
    } 
  }
  
  public static void a(Context paramContext, TableEntity paramTableEntity, t.f paramf) {
    try {
      av av = RootApplication.getLaiqianPreferenceManager();
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("type", "table");
      jSONObject.put("sub_type", "update_table");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.getID());
      stringBuilder.append("");
      jSONObject.put("table_id", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.getState());
      stringBuilder.append("");
      jSONObject.put("table_status", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.Yg().Yl());
      stringBuilder.append("");
      jSONObject.put("number_id", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.Yb());
      stringBuilder.append("");
      jSONObject.put("actual_person", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.Yg().Ym());
      stringBuilder.append("");
      jSONObject.put("number_actual_person", stringBuilder.toString());
      jSONObject.put("user_id", av.atm());
      jSONObject.put("shop_id", av.Tx());
      a.a(a.a(paramContext, 4003, jSONObject.toString(), 2, i.e(4003, paramf)), new d(paramf));
      return;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return;
    } 
  }
  
  public static void a(Context paramContext, t.f paramf) { a.cz(a.a(paramContext, 3003, "", 2, i.e(3003, paramf))); }
  
  private static void a(Context paramContext, String paramString, int paramInt) { a(paramContext, paramString, paramInt, 0L); }
  
  private static void a(Context paramContext, String paramString, int paramInt, long paramLong) {
    try {
      p p = new p(paramContext);
    } catch (Exception paramContext) {
      a.e(paramContext);
      paramContext = null;
    } 
    paramContext.a(b.jc(paramString).DP(), paramString, paramInt, paramLong);
    paramContext.close();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, long paramLong1, long paramLong2) {
    p p = new p(paramContext);
    p.a(paramLong2, paramString, paramInt, paramLong1);
    p.close();
  }
  
  public static void a(Context paramContext, String paramString, TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt, t.k paramk) {
    paramString = a.a(paramContext, 2002, a(paramString, paramTableEntity1, paramTableEntity2.getID(), paramInt, ""), 2, i.e(2002, paramk));
    if (paramk == null)
      a(paramContext, paramString, 2002); 
    a.a(paramString, new e(paramk, paramTableEntity2, paramTableEntity1, paramInt));
  }
  
  public static void a(Context paramContext, String paramString, TableEntity paramTableEntity, @NonNull PendingFullOrderDetail paramPendingFullOrderDetail, t.f paramf) {
    try {
      new JSONObject();
      JSONObject jSONObject1 = new JSONObject(paramString);
      JSONObject jSONObject2 = new JSONObject();
      if (paramPendingFullOrderDetail.bXb.aVS > 0L) {
        jSONObject2.put("id", paramPendingFullOrderDetail.bXb.aVS);
        jSONObject2.put("name", paramPendingFullOrderDetail.bXb.coW);
        jSONObject2.put("amount", paramPendingFullOrderDetail.bXb.bfj);
        jSONObject2.put("sub_type_id", paramPendingFullOrderDetail.bXb.coX);
      } 
      if (paramPendingFullOrderDetail.bXb.aVU > 0L) {
        jSONObject2.put("second_id", paramPendingFullOrderDetail.bXb.aVU);
        jSONObject2.put("second_name", paramPendingFullOrderDetail.bXb.coY);
        jSONObject2.put("second_amount", paramPendingFullOrderDetail.bXb.bfk);
        jSONObject2.put("second_sub_type_id", paramPendingFullOrderDetail.bXb.coZ);
      } 
      jSONObject2.put("discount", paramPendingFullOrderDetail.bXb.ceX);
      jSONObject2.put("memberId", paramPendingFullOrderDetail.bXb.coO);
      jSONObject1.put("pay", jSONObject2);
      String str = a.a(paramContext, 3004, jSONObject1.toString(), 2, i.e(3004, paramf));
      a(paramContext, str, 3004, paramTableEntity.getID());
      a.a(str, new f(paramf));
      return;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return;
    } 
  }
  
  public static void a(Context paramContext, String paramString, t.g paramg) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("");
      a.a(a.a(paramContext, 2006, stringBuilder.toString(), 2, i.e(2006, paramg)), new c(paramg));
      return;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\connect\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */