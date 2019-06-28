package com.laiqian.k;

import android.content.Context;
import android.util.Log;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.z;
import com.laiqian.util.bb;
import com.laiqian.util.by;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class a {
  public static long bJx;
  
  public static int dEo;
  
  public static int dEp;
  
  public static long dEq;
  
  public static long dEr;
  
  public static int dEs;
  
  public static HashMap<String, String> dEt;
  
  public static String dEu;
  
  static  {
  
  }
  
  public static void A(Context paramContext, String paramString) {
    HashMap hashMap = new HashMap();
    hashMap.put("product_save_area", paramString);
    MobclickAgent.onEventValue(paramContext, "product_save_area", hashMap, 0);
    bb.e("UmengConstants", paramString);
  }
  
  public static void B(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("key=");
    stringBuilder.append(paramString);
    Log.e("sendUM", stringBuilder.toString());
    if (dEt != null) {
      if (dEt.isEmpty())
        return; 
      Iterator iterator = dEt.entrySet().iterator();
      new JSONObject();
      while (iterator.hasNext()) {
        Map.Entry entry = (Map.Entry)iterator.next();
        String str1 = (String)entry.getKey();
        String str2 = (String)entry.getValue();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("key=");
        stringBuilder1.append(str1);
        stringBuilder1.append(",val=");
        stringBuilder1.append(str2);
        Log.e("sendUM", stringBuilder1.toString());
      } 
      MobclickAgent.onEvent(paramContext, paramString, dEt);
      dEt.clear();
      return;
    } 
  }
  
  public static void a(int paramInt, String paramString1, double paramDouble, String paramString2) {
    HashMap hashMap = new HashMap();
    if (paramInt == 10007) {
      if (by.isNull(RootApplication.getLaiqianPreferenceManager().FC())) {
        hashMap.put(String.format("%d-%s", new Object[] { Integer.valueOf(paramInt), paramString1 }), String.valueOf(paramDouble));
      } else {
        hashMap.put(String.format("%s-%d-%s", new Object[] { a.AZ().Bp(), Integer.valueOf(paramInt), paramString1 }), String.valueOf(paramDouble));
      } 
    } else if (paramInt == 10009) {
      if (by.isNull(RootApplication.getLaiqianPreferenceManager().FD())) {
        hashMap.put(String.format("%d-%s", new Object[] { Integer.valueOf(paramInt), paramString1 }), String.valueOf(paramDouble));
      } else {
        hashMap.put(String.format("%s-%d-%s", new Object[] { a.AZ().Br(), Integer.valueOf(paramInt), paramString1 }), String.valueOf(paramDouble));
      } 
    } else {
      hashMap.put(String.format("%d", new Object[] { Integer.valueOf(paramInt) }), String.valueOf(paramDouble));
    } 
    hashMap.put("recharge_amount", String.valueOf(paramDouble));
    hashMap.put("recharge_amount_section", aX(paramDouble));
    b(RootApplication.zv(), hashMap, paramString2);
  }
  
  public static void a(ArrayList<z> paramArrayList, double paramDouble, long paramLong, String paramString) {
    HashMap hashMap = new HashMap();
    hashMap.put("order_quantity", String.valueOf(1));
    hashMap.put("order_amount", String.valueOf(paramDouble));
    hashMap.put("order_source", String.valueOf(paramLong));
    for (z z : paramArrayList) {
      if (z.aTv == 10007) {
        if (by.isNull(RootApplication.getLaiqianPreferenceManager().FC())) {
          hashMap.put(String.format("%d-%d", new Object[] { Integer.valueOf(z.aTv), Long.valueOf(z.aTx) }), String.valueOf(z.aJW));
          continue;
        } 
        hashMap.put(String.format("%s-%d-%d", new Object[] { a.AZ().Bp(), Integer.valueOf(z.aTv), Long.valueOf(z.aTx) }), String.valueOf(z.aJW));
        continue;
      } 
      if (z.aTv == 10009) {
        if (by.isNull(RootApplication.getLaiqianPreferenceManager().FD())) {
          hashMap.put(String.format("%d-%d", new Object[] { Integer.valueOf(z.aTv), Long.valueOf(z.aTx) }), String.valueOf(z.aJW));
          continue;
        } 
        hashMap.put(String.format("%s-%d-%d", new Object[] { a.AZ().Br(), Integer.valueOf(z.aTv), Long.valueOf(z.aTx) }), String.valueOf(z.aJW));
        continue;
      } 
      hashMap.put(String.format("%d", new Object[] { Integer.valueOf(z.aTv) }), String.valueOf(z.aJW));
    } 
    hashMap.put("recharge_amount_section", aX(paramDouble));
    b(RootApplication.zv(), hashMap, paramString);
  }
  
  private static String aX(double paramDouble) { return (paramDouble > 300.0D) ? ">300" : ((paramDouble > 200.0D) ? ">200" : ((paramDouble > 100.0D) ? ">100" : ((paramDouble > 50.0D) ? ">50" : ((paramDouble >= 0.0D) ? ">=0" : "<0")))); }
  
  public static String asv() { return String.valueOf(System.currentTimeMillis() - bJx); }
  
  public static void asw() {
    dEq = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(dEq);
    stringBuilder.append("");
    bb.e("nShiftStartTime", stringBuilder.toString());
  }
  
  public static void asx() {
    dEr = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(dEr);
    stringBuilder.append("");
    bb.e("nShiftEndTime", stringBuilder.toString());
  }
  
  public static void asy() { // Byte code:
    //   0: ldc com/laiqian/k/a
    //   2: monitorenter
    //   3: new java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore_0
    //   11: aload_0
    //   12: ldc_w 'nShiftStartTime:'
    //   15: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_0
    //   20: getstatic com/laiqian/k/a.dEq : J
    //   23: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 'UmengConstants'
    //   29: aload_0
    //   30: invokevirtual toString : ()Ljava/lang/String;
    //   33: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore_0
    //   44: aload_0
    //   45: ldc_w 'nShiftEndTime:'
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_0
    //   53: getstatic com/laiqian/k/a.dEr : J
    //   56: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: ldc 'UmengConstants'
    //   62: aload_0
    //   63: invokevirtual toString : ()Ljava/lang/String;
    //   66: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   69: getstatic com/laiqian/k/a.dEq : J
    //   72: lconst_0
    //   73: lcmp
    //   74: ifeq -> 93
    //   77: getstatic com/laiqian/k/a.dEs : I
    //   80: i2l
    //   81: getstatic com/laiqian/k/a.dEr : J
    //   84: getstatic com/laiqian/k/a.dEq : J
    //   87: lsub
    //   88: ladd
    //   89: l2i
    //   90: putstatic com/laiqian/k/a.dEs : I
    //   93: new java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial <init> : ()V
    //   100: astore_0
    //   101: aload_0
    //   102: ldc_w 'nShiftOperateTime:'
    //   105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_0
    //   110: getstatic com/laiqian/k/a.dEs : I
    //   113: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: ldc 'UmengConstants'
    //   119: aload_0
    //   120: invokevirtual toString : ()Ljava/lang/String;
    //   123: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   126: ldc com/laiqian/k/a
    //   128: monitorexit
    //   129: return
    //   130: astore_0
    //   131: ldc com/laiqian/k/a
    //   133: monitorexit
    //   134: aload_0
    //   135: athrow
    // Exception table:
    //   from	to	target	type
    //   3	93	130	finally
    //   93	126	130	finally }
  
  public static void b(Context paramContext, String paramString, HashMap<String, String> paramHashMap) {
    MobclickAgent.onEvent(paramContext, paramString, paramHashMap);
    bb.e("UmengConstants", paramHashMap.toString());
  }
  
  public static void b(Context paramContext, HashMap<String, String> paramHashMap, String paramString) {
    MobclickAgent.onEventValue(paramContext, paramString, paramHashMap, 0);
    MobclickAgent.onEvent(paramContext, paramString, paramHashMap);
    bb.e("UmengConstants", paramHashMap.toString());
  }
  
  public static void bc(String paramString1, String paramString2) {
    if (dEt == null)
      dEt = new HashMap(); 
    dEt.put(paramString1, paramString2);
  }
  
  public static void start() { bJx = System.currentTimeMillis(); }
  
  public static void x(Context paramContext, String paramString) {
    HashMap hashMap = new HashMap();
    hashMap.put("operation_type", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(dEs / 1000);
    stringBuilder.append("");
    hashMap.put("shift_operation_time", stringBuilder.toString());
    MobclickAgent.onEventValue(paramContext, "shift_operation", hashMap, 0);
    bb.e("UmengConstants", paramString);
  }
  
  public static void y(Context paramContext, String paramString) {
    HashMap hashMap = new HashMap();
    hashMap.put("operation_type", paramString);
    MobclickAgent.onEventValue(paramContext, "cash_more", hashMap, 0);
    bb.e("UmengConstants", paramString);
  }
  
  public static void z(Context paramContext, String paramString) {
    HashMap hashMap = new HashMap();
    hashMap.put("product_save_type", paramString);
    MobclickAgent.onEventValue(paramContext, "product_save_type", hashMap, 0);
    bb.e("UmengConstants", paramString);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */