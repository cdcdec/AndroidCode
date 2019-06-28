package com.laiqian.ordertool.c;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.db.b;
import com.laiqian.dcb.api.a.b;
import com.laiqian.dcb.api.b.c;
import com.laiqian.dcb.api.b.e;
import com.laiqian.dcb.api.b.j;
import com.laiqian.dcb.api.b.k;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.dcb.api.server.a;
import com.laiqian.dcb.api.server.a.c;
import com.laiqian.f.e;
import com.laiqian.ordertool.a.a;
import com.laiqian.pos.model.a;
import com.orhanobut.logger.d;
import io.netty.channel.n;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class d implements a {
  private JSONObject ac(ArrayList<HashMap<String, Object>> paramArrayList) { // Byte code:
    //   0: new org/json/JSONArray
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #12
    //   9: aload_1
    //   10: invokevirtual iterator : ()Ljava/util/Iterator;
    //   13: astore #13
    //   15: dconst_0
    //   16: dstore #4
    //   18: dconst_0
    //   19: dstore_2
    //   20: aload #13
    //   22: invokeinterface hasNext : ()Z
    //   27: ifeq -> 290
    //   30: aload #13
    //   32: invokeinterface next : ()Ljava/lang/Object;
    //   37: checkcast java/util/HashMap
    //   40: astore_1
    //   41: new org/json/JSONObject
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: astore #14
    //   50: aload #14
    //   52: ldc '_id'
    //   54: aload_1
    //   55: ldc 'nProductID'
    //   57: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   60: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   63: pop
    //   64: aload #14
    //   66: ldc 'sProductName'
    //   68: aload_1
    //   69: ldc 'sProductName'
    //   71: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   74: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   77: pop
    //   78: aload_1
    //   79: ldc 'nProductQty'
    //   81: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   84: checkcast java/lang/String
    //   87: invokestatic parseDouble : (Ljava/lang/String;)D
    //   90: dstore #10
    //   92: dload #10
    //   94: iconst_2
    //   95: invokestatic c : (DI)Ljava/lang/String;
    //   98: astore #15
    //   100: aload_1
    //   101: ldc 'fAmount'
    //   103: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast java/lang/String
    //   109: astore #16
    //   111: aload #14
    //   113: ldc 'nBuyNumber'
    //   115: aload #15
    //   117: invokestatic parseDouble : (Ljava/lang/String;)D
    //   120: invokevirtual put : (Ljava/lang/String;D)Lorg/json/JSONObject;
    //   123: pop
    //   124: aload #14
    //   126: ldc 'nProductType'
    //   128: aload_1
    //   129: ldc 'nProductType'
    //   131: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   134: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   137: pop
    //   138: aload #14
    //   140: ldc 'nFoodCategory'
    //   142: aload_1
    //   143: ldc 'nFoodCategory'
    //   145: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   148: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload #14
    //   154: ldc 'nPrice'
    //   156: aload_1
    //   157: ldc 'nPrice'
    //   159: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   162: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload #14
    //   168: ldc 'itemNo'
    //   170: aload_1
    //   171: ldc 'itemNo'
    //   173: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   176: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   179: pop
    //   180: aload #14
    //   182: ldc 'oid'
    //   184: aload_1
    //   185: ldc 'oid'
    //   187: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   190: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload #14
    //   196: ldc 'dateTime'
    //   198: aload_1
    //   199: ldc 'dateTime'
    //   201: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   204: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: dload #4
    //   210: dstore #6
    //   212: dload_2
    //   213: dstore #8
    //   215: dload #10
    //   217: dconst_0
    //   218: dcmpl
    //   219: ifle -> 248
    //   222: dload #4
    //   224: dload #10
    //   226: dadd
    //   227: dstore #6
    //   229: dload #6
    //   231: dstore #10
    //   233: dload_2
    //   234: dstore #4
    //   236: dload_2
    //   237: aload #16
    //   239: invokestatic parseDouble : (Ljava/lang/String;)D
    //   242: dadd
    //   243: dstore #8
    //   245: goto -> 248
    //   248: dload #6
    //   250: dstore #10
    //   252: dload #8
    //   254: dstore #4
    //   256: aload #12
    //   258: aload #14
    //   260: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   263: pop
    //   264: dload #6
    //   266: dstore #4
    //   268: dload #8
    //   270: dstore_2
    //   271: goto -> 20
    //   274: astore_1
    //   275: dload #4
    //   277: dstore #10
    //   279: aload_1
    //   280: invokestatic e : (Ljava/lang/Throwable;)V
    //   283: dload #10
    //   285: dstore #4
    //   287: goto -> 20
    //   290: new org/json/JSONObject
    //   293: dup
    //   294: invokespecial <init> : ()V
    //   297: astore_1
    //   298: aload_1
    //   299: ldc 'sSumQty'
    //   301: dload #4
    //   303: invokestatic ax : (D)Ljava/lang/String;
    //   306: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload_1
    //   311: ldc 'sSumAmount'
    //   313: dload_2
    //   314: invokestatic ax : (D)Ljava/lang/String;
    //   317: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   320: pop
    //   321: aload_1
    //   322: ldc 'data'
    //   324: aload #12
    //   326: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   329: pop
    //   330: aload_1
    //   331: areturn
    //   332: astore #12
    //   334: aload #12
    //   336: invokestatic e : (Ljava/lang/Throwable;)V
    //   339: aload_1
    //   340: areturn
    //   341: astore_1
    //   342: dload #4
    //   344: dstore_2
    //   345: goto -> 279
    // Exception table:
    //   from	to	target	type
    //   50	208	274	org/json/JSONException
    //   236	245	341	org/json/JSONException
    //   256	264	341	org/json/JSONException
    //   298	330	332	org/json/JSONException }
  
  public void a(Context paramContext, String paramString, n paramn, int paramInt, b paramb) {
    try {
      a a1 = new a(paramContext);
      Cursor cursor = a1.kp("0");
      JSONArray jSONArray = new JSONArray();
      while (cursor.moveToNext()) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_id", cursor.getString(0));
        jSONObject.put("sTableNO", cursor.getString(1));
        String str = cursor.getString(cursor.getColumnIndex("sSpareField5"));
        if (!TextUtils.isEmpty(str))
          jSONObject.put("sTableNO", str); 
        jSONObject.put("sProductNames", cursor.getString(2));
        jSONObject.put("time", cursor.getLong(3));
        jSONArray.put(jSONObject);
      } 
      cursor.close();
      a1.close();
      d.sQ(jSONArray.toString());
      c.a(paramn, paramInt, 1, "", jSONArray.toString(), "0");
      return;
    } catch (Exception paramContext) {
      c.a(paramn, paramInt, 0, "", "this is from server", "0");
      a.e(paramContext);
      return;
    } 
  }
  
  public void a(Context paramContext, String paramString1, n paramn, int paramInt, String paramString2, b paramb) {}
  
  public void a(Context paramContext, String paramString1, String paramString2, b paramb, n paramn) { a.aKh().r(new e(this, paramString1)); }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, n paramn, int paramInt, long paramLong, b paramb) {
    try {
      null = new b();
      null = new StringBuilder();
      null.append("/data/data/");
      null.append(paramContext.getPackageName());
      null.append("/laiqian.db");
      null = null.toString();
      null = new StringBuilder();
      null.append("download_");
      null.append(paramString1);
      null.append(".lq");
      String str2 = null.toString();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(a.DS());
      stringBuilder1.append(str2);
      stringBuilder1.append("copy");
      String str3 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(a.DS());
      stringBuilder2.append(str2);
      stringBuilder2.append("final");
      String str4 = stringBuilder2.toString();
      c.B(null, str3);
      null = SQLiteDatabase.openDatabase(str3, null, 16);
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(a.DS());
      stringBuilder3.append(str2);
      stringBuilder3.append("final");
      c.cE(stringBuilder3.toString());
      String str7 = a.DS();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(str2);
      stringBuilder4.append("final");
      null.a(null, str7, stringBuilder4.toString(), "T_STRING", "all", false);
      str7 = a.DS();
      stringBuilder4 = new StringBuilder();
      stringBuilder4.append(str2);
      stringBuilder4.append("final");
      null.a(null, str7, stringBuilder4.toString(), false);
      null.close();
      null = new StringBuilder();
      null.append(a.DS());
      null.append(str2);
      String str5 = null.toString();
      null = new StringBuilder();
      null.append(a.DR());
      null.append(str2);
      String str6 = null.toString();
      boolean bool2 = (new k(paramContext, str4, str5, "", k.aQg)).aQh;
      null = new StringBuilder();
      null.append(paramString2);
      null.append(paramString3);
      null.append(paramString1);
      str1 = null.toString();
      boolean bool1 = bool2;
      if (bool2)
        bool1 = e.n(str5, str6, str1); 
      c.cE(str5);
      c.cE(str3);
      c.cE(str4);
      try {
        byte b1;
        f f = new f(this);
        if (bool1) {
          b1 = 1;
        } else {
          b1 = 0;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://");
        stringBuilder.append(e.cs(true));
        stringBuilder.append(":");
        stringBuilder.append(j.Z(paramLong));
        stringBuilder.append("/");
        stringBuilder.append(str2);
        c.a(paramn, paramInt, b1, "", stringBuilder.toString(), "", f);
        return;
      } catch (Exception str1) {}
    } catch (Exception paramContext) {}
    c.a(paramn, paramInt, 0, "", "", "");
  }
  
  public void a(StringBuffer paramStringBuffer, Context paramContext, boolean paramBoolean, String paramString, n paramn, int paramInt, a parama, b paramb) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("data parsed result is: ");
    stringBuilder.append(paramString);
    stringBuilder.append("\n");
    paramStringBuffer.append(stringBuilder.toString());
    int i = parama.jw(paramString);
    if (!paramBoolean)
      c.a(paramn, paramInt, i, "", "this is from server", "0"); 
    stringBuilder = new StringBuilder();
    stringBuilder.append("OrderEdit result is: ");
    stringBuilder.append(i);
    stringBuilder.append("\n");
    paramStringBuffer.append(stringBuilder.toString());
  }
  
  public void a(StringBuffer paramStringBuffer, boolean paramBoolean, String paramString, Context paramContext, n paramn, int paramInt, a parama, b paramb) {
    Intent intent = new Intent();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("data parsed result is: ");
    stringBuilder2.append(paramString);
    stringBuilder2.append("\n");
    paramStringBuffer.append(stringBuilder2.toString());
    int i = parama.jv(paramString);
    if (!paramBoolean)
      c.a(paramn, paramInt, i, "", "this is from server", "0"); 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("OrderSubmit result is: ");
    stringBuilder1.append(i);
    stringBuilder1.append("\n");
    paramStringBuffer.append(stringBuilder1.toString());
    if (i == -1) {
      intent.setFlags(268435456);
      intent.setClass(paramContext, com.laiqian.main.PosActivity.class);
      intent.putExtra("method", paramInt);
      paramContext.startActivity(intent);
    } 
  }
  
  public void b(Context paramContext, String paramString, n paramn, int paramInt, b paramb) {
    try {
      a a1 = new a(paramContext);
      ArrayList arrayList = a1.kx(paramString);
      a.b b1 = a1.kv(paramString);
      a1.close();
      if (arrayList == null || arrayList.size() == 0) {
        c.a(paramn, paramInt, 2, "", "this is from server", "0");
        return;
      } 
      JSONObject jSONObject = ac(arrayList);
      jSONObject.put("sOrderID", paramString);
      jSONObject.put("sTableNO", b1.cyC);
      jSONObject.put("sPack", b1.cyD);
      c.a(paramn, paramInt, 1, "", jSONObject.toString(), "0");
      return;
    } catch (Exception paramContext) {
      c.a(paramn, paramInt, 0, "", "this is from server", "0");
      a.e(paramContext);
      return;
    } 
  }
  
  public void b(StringBuffer paramStringBuffer, boolean paramBoolean, String paramString, Context paramContext, n paramn, int paramInt, a parama, b paramb) {
    Intent intent = new Intent();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("data parsed result is: ");
    stringBuilder2.append(paramString);
    stringBuilder2.append("\n");
    paramStringBuffer.append(stringBuilder2.toString());
    int i = parama.jv(paramString);
    if (!paramBoolean)
      c.a(paramn, paramInt, i, "", "this is from server", "0"); 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("OrderSubmit result is: ");
    stringBuilder1.append(i);
    stringBuilder1.append("\n");
    paramStringBuffer.append(stringBuilder1.toString());
    if (i == -1) {
      intent.setFlags(268435456);
      intent.setClass(paramContext, com.laiqian.main.PosActivity.class);
      intent.putExtra("method", paramInt);
      paramContext.startActivity(intent);
    } 
  }
  
  public void c(Context paramContext, String paramString, n paramn, int paramInt, b paramb) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */