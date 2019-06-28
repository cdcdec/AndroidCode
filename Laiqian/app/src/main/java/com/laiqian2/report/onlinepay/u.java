package com.laiqian.report.onlinepay;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.google.gson.k;
import com.google.gson.q;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.p;
import com.laiqian.entity.q;
import com.laiqian.main.bb;
import com.laiqian.milestone.h;
import com.laiqian.models.o;
import com.laiqian.models.x;
import com.laiqian.network.k;
import com.laiqian.pos.industry.a;
import com.laiqian.report.models.z;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class u {
  private int ddA = 0;
  
  private Pair<ArrayList<q>, ArrayList<q>> ddB;
  
  private int ddz = 0;
  
  private Context mContext;
  
  public u(Context paramContext) { this.mContext = paramContext; }
  
  private void anH() {
    try {
      Pair pair = e(this.ddB);
      boolean bool = by.isNull((String)pair.second);
      if (bool) {
        if (this.ddA * 10 < ((ArrayList)this.ddB.second).size())
          anH(); 
        return;
      } 
      Log.d("微信请求的订单号", (String)pair.second);
      null = q((String)pair.second, 5L);
      bool = by.isNull(null);
      if (bool) {
        if (this.ddA * 10 < ((ArrayList)this.ddB.second).size())
          anH(); 
        return;
      } 
      JSONObject jSONObject = new JSONObject(null);
      Iterator iterator = jSONObject.keys();
      while (iterator.hasNext()) {
        null = (String)iterator.next();
        String str = jSONObject.getString(null);
        if ("".equals(str) || "-1".equals(str) || ((HashMap)pair.first).isEmpty() || !((HashMap)pair.first).containsKey(null))
          continue; 
        q q = (q)((HashMap)pair.first).get(null);
        if (q.Fo() != 5L && q.Fo() != 8L)
          continue; 
        HashMap hashMap = au.qB(str);
        if (hashMap != null && hashMap.get("result_code") != null && "SUCCESS".equals(String.valueOf(hashMap.get("result_code"))) && "SUCCESS".equals(String.valueOf(hashMap.get("trade_state"))))
          b(q); 
      } 
      if (this.ddA * 10 < ((ArrayList)this.ddB.second).size()) {
        anH();
        return;
      } 
    } catch (Exception exception) {
      a.e(exception);
      if (this.ddA * 10 < ((ArrayList)this.ddB.second).size()) {
        anH();
        return;
      } 
    } finally {
      ArrayList arrayList;
    } 
  }
  
  private void anI() {
    try {
      Pair pair = f(this.ddB);
      boolean bool = by.isNull((String)pair.second);
      if (bool) {
        if (this.ddz * 10 < ((ArrayList)this.ddB.first).size())
          anI(); 
        return;
      } 
      Log.d("支付宝请求的订单号", (String)pair.second);
      null = q((String)pair.second, 1L);
      bool = by.isNull(null);
      if (bool) {
        if (this.ddz * 10 < ((ArrayList)this.ddB.first).size())
          anI(); 
        return;
      } 
      JSONObject jSONObject = new JSONObject(null);
      Iterator iterator = jSONObject.keys();
      while (iterator.hasNext()) {
        null = (String)iterator.next();
        String str = jSONObject.getString(null);
        if ("".equals(str) || "-1".equals(str) || ((HashMap)pair.first).isEmpty() || !((HashMap)pair.first).containsKey(null))
          continue; 
        q q = (q)((HashMap)pair.first).get(null);
        if (q.Fo() != 1L && q.Fo() != 0L)
          continue; 
        HashMap hashMap = au.qB(str);
        if (hashMap != null && hashMap.get("code") != null && "10000".equals(String.valueOf(hashMap.get("code"))) && "TRADE_SUCCESS".equals(String.valueOf(hashMap.get("trade_status"))))
          b(q); 
      } 
      if (this.ddz * 10 < ((ArrayList)this.ddB.first).size()) {
        anI();
        return;
      } 
    } catch (Exception exception) {
      a.e(exception);
      if (this.ddz * 10 < ((ArrayList)this.ddB.first).size()) {
        anI();
        return;
      } 
    } finally {
      ArrayList arrayList;
    } 
  }
  
  private Pair<ArrayList<q>, ArrayList<q>> anJ() throws Exception {
    z = (new o()).c(anK(), "0");
    h h = new h(this.mContext);
    Cursor cursor = h.b(z.bsx, z.dcl.split(","));
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    k k = (new q()).vE().vF();
    while (true) {
      if (cursor != null) {
        try {
          if (cursor.moveToNext()) {
            boolean bool = by.isNull(cursor.getString(cursor.getColumnIndex("sText")));
            if (!bool)
              continue; 
            z = null;
            try {
              bb bb2 = (bb)k.b(cursor.getString(cursor.getColumnIndex("sOrder")), bb.class);
              bb bb1 = bb2;
            } catch (Exception exception) {
              a.e(exception);
            } 
          } else {
            cursor.close();
            h.close();
            return new Pair(arrayList1, arrayList2);
          } 
        } catch (Exception z) {
          a.e(z);
          cursor.close();
          h.close();
          return new Pair(arrayList1, arrayList2);
        } finally {}
      } else {
        cursor.close();
        h.close();
        return new Pair(arrayList1, arrayList2);
      } 
      if (z == null)
        continue; 
      q q = (new q.a()).ak(cursor.getLong(cursor.getColumnIndex("nDateTime"))).df(cursor.getString(cursor.getColumnIndex("sOrderNo"))).dg(cursor.getString(cursor.getColumnIndex("fAmount"))).aj(n.parseInt(cursor.getString(cursor.getColumnIndex("nPayType")))).b(z).Fy();
      long l = q.Fo();
      if (l == 1L || l == 0L) {
        arrayList1.add(q);
        continue;
      } 
      if (l == 5L || l == 8L)
        arrayList2.add(q); 
    } 
  }
  
  @NonNull
  private p anK() {
    p p = new p();
    p.b(new Integer[] { null, null, (new Integer[3][1] = (new Integer[3][0] = Integer.valueOf(0)).valueOf(-4)).valueOf(-2) });
    long l = System.currentTimeMillis();
    p.g(new String[] { null, (new String[2][0] = String.valueOf(l - 86400000L - 10000L)).valueOf(l - 10000L) });
    return p;
  }
  
  private void b(q paramq) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual Fp : ()Lcom/laiqian/main/bb;
    //   6: astore #5
    //   8: aload #5
    //   10: ifnonnull -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new com/laiqian/main/PosActivitySettlementModel
    //   19: dup
    //   20: aload_0
    //   21: getfield mContext : Landroid/content/Context;
    //   24: invokespecial <init> : (Landroid/content/Context;)V
    //   27: astore_3
    //   28: new com/laiqian/models/be
    //   31: dup
    //   32: aload_0
    //   33: getfield mContext : Landroid/content/Context;
    //   36: invokespecial <init> : (Landroid/content/Context;)V
    //   39: astore #4
    //   41: aload_3
    //   42: invokevirtual beginTransaction : ()V
    //   45: aload #5
    //   47: aload_1
    //   48: invokevirtual getTime : ()J
    //   51: invokevirtual az : (J)V
    //   54: aload_3
    //   55: aload #5
    //   57: invokevirtual f : (Lcom/laiqian/main/bb;)Ljava/lang/String;
    //   60: astore #6
    //   62: aload #6
    //   64: ifnull -> 83
    //   67: aload_3
    //   68: invokevirtual endTransaction : ()V
    //   71: aload_3
    //   72: invokevirtual close : ()V
    //   75: aload #4
    //   77: invokevirtual close : ()V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: aload_0
    //   84: aload #5
    //   86: getfield orderNo : Ljava/lang/String;
    //   89: invokespecial nw : (Ljava/lang/String;)Z
    //   92: istore_2
    //   93: iload_2
    //   94: ifeq -> 113
    //   97: aload_3
    //   98: invokevirtual endTransaction : ()V
    //   101: aload_3
    //   102: invokevirtual close : ()V
    //   105: aload #4
    //   107: invokevirtual close : ()V
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: aload #4
    //   115: aload_1
    //   116: iconst_1
    //   117: aload_0
    //   118: getfield mContext : Landroid/content/Context;
    //   121: ldc_w 2131626181
    //   124: invokevirtual getString : (I)Ljava/lang/String;
    //   127: invokevirtual a : (Lcom/laiqian/entity/q;ILjava/lang/String;)V
    //   130: aload #5
    //   132: getfield bcf : J
    //   135: ldc2_w 7
    //   138: lcmp
    //   139: ifne -> 182
    //   142: aload #5
    //   144: getfield bcq : Ljava/lang/String;
    //   147: invokestatic isNull : (Ljava/lang/String;)Z
    //   150: ifne -> 182
    //   153: new com/laiqian/pos/model/a
    //   156: dup
    //   157: aload_0
    //   158: getfield mContext : Landroid/content/Context;
    //   161: invokespecial <init> : (Landroid/content/Context;)V
    //   164: astore #6
    //   166: aload #6
    //   168: aload #5
    //   170: getfield bcq : Ljava/lang/String;
    //   173: invokevirtual kj : (Ljava/lang/String;)Z
    //   176: pop
    //   177: aload #6
    //   179: invokevirtual close : ()V
    //   182: aload_0
    //   183: aload #5
    //   185: invokespecial m : (Lcom/laiqian/main/bb;)Z
    //   188: ifne -> 202
    //   191: aload_1
    //   192: invokevirtual xq : ()Ljava/lang/String;
    //   195: invokestatic eQ : (Ljava/lang/String;)Lcom/laiqian/online/h;
    //   198: pop
    //   199: goto -> 225
    //   202: aload #5
    //   204: getfield orderNo : Ljava/lang/String;
    //   207: invokestatic eQ : (Ljava/lang/String;)Lcom/laiqian/online/h;
    //   210: astore_1
    //   211: aload_1
    //   212: ifnull -> 266
    //   215: aload_1
    //   216: getfield bXV : Z
    //   219: ifne -> 225
    //   222: goto -> 266
    //   225: aload_3
    //   226: invokevirtual setTransactionSuccessful : ()V
    //   229: aload #5
    //   231: getfield bbS : Ljava/util/ArrayList;
    //   234: aload #5
    //   236: getfield bbY : D
    //   239: aload #5
    //   241: getfield bcf : J
    //   244: ldc_w 'pos_sale_click'
    //   247: invokestatic a : (Ljava/util/ArrayList;DJLjava/lang/String;)V
    //   250: aload_3
    //   251: invokevirtual endTransaction : ()V
    //   254: aload_3
    //   255: invokevirtual close : ()V
    //   258: aload #4
    //   260: invokevirtual close : ()V
    //   263: aload_0
    //   264: monitorexit
    //   265: return
    //   266: aload #5
    //   268: invokevirtual LB : ()V
    //   271: aload_3
    //   272: invokevirtual endTransaction : ()V
    //   275: aload_3
    //   276: invokevirtual close : ()V
    //   279: aload #4
    //   281: invokevirtual close : ()V
    //   284: aload_0
    //   285: monitorexit
    //   286: return
    //   287: astore_1
    //   288: aload_3
    //   289: invokevirtual endTransaction : ()V
    //   292: aload_3
    //   293: invokevirtual close : ()V
    //   296: aload #4
    //   298: invokevirtual close : ()V
    //   301: aload_1
    //   302: athrow
    //   303: astore_1
    //   304: aload_0
    //   305: monitorexit
    //   306: aload_1
    //   307: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	303	finally
    //   16	41	303	finally
    //   41	62	287	finally
    //   67	80	303	finally
    //   83	93	287	finally
    //   97	110	303	finally
    //   113	182	287	finally
    //   182	199	287	finally
    //   202	211	287	finally
    //   215	222	287	finally
    //   225	250	287	finally
    //   250	263	303	finally
    //   266	271	287	finally
    //   271	284	303	finally
    //   288	303	303	finally }
  
  private Pair<HashMap<String, q>, String> e(Pair<ArrayList<q>, ArrayList<q>> paramPair) {
    int i = this.ddA * 10;
    int j = (this.ddA + 1) * 10;
    int k = ((ArrayList)paramPair.second).size();
    StringBuilder stringBuilder = new StringBuilder();
    HashMap hashMap = new HashMap();
    while (true) {
      int m;
      if (k > j) {
        m = j;
      } else {
        m = k;
      } 
      if (i < m) {
        q q = (q)((ArrayList)paramPair.second).get(i);
        hashMap.put(q.xq(), q);
        if (i % 10 != 0)
          stringBuilder.append(","); 
        stringBuilder.append(q.xq());
        i++;
        continue;
      } 
      break;
    } 
    this.ddA++;
    return new Pair(hashMap, stringBuilder.toString());
  }
  
  private Pair<HashMap<String, q>, String> f(Pair<ArrayList<q>, ArrayList<q>> paramPair) {
    int i = this.ddz * 10;
    int j = (this.ddz + 1) * 10;
    int k = ((ArrayList)paramPair.first).size();
    StringBuilder stringBuilder = new StringBuilder();
    HashMap hashMap = new HashMap();
    while (true) {
      int m;
      if (k > j) {
        m = j;
      } else {
        m = k;
      } 
      if (i < m) {
        q q = (q)((ArrayList)paramPair.first).get(i);
        hashMap.put(q.xq(), q);
        if (i % 10 != 0)
          stringBuilder.append(","); 
        stringBuilder.append(q.xq());
        i++;
        continue;
      } 
      break;
    } 
    this.ddz++;
    return new Pair(hashMap, stringBuilder.toString());
  }
  
  private boolean m(bb parambb) { return (RootApplication.getLaiqianPreferenceManager().Wq() && parambb.vipEntity != null); }
  
  private boolean nw(String paramString) {
    x x = new x(CrashApplication.zv());
    ArrayList arrayList = x.gV(paramString);
    x.close();
    return (arrayList == null || arrayList.isEmpty());
  }
  
  public String Tm() throws Exception {
    this.ddB = anJ();
    anI();
    anH();
    return "执行成功";
  }
  
  public String q(String paramString, long paramLong) {
    str2 = "";
    hashMap = new HashMap();
    hashMap.put("out_trade_no", paramString);
    null = new av(RootApplication.zv());
    hashMap.put("shop_id", null.Tx());
    hashMap.put("pay_type", "bar_code");
    null.close();
    hashMap.put("business_type", "reception");
    str1 = "";
    if (paramLong == 1L || paramLong == 0L) {
      str1 = a.cqK;
    } else if (paramLong == 5L || paramLong == 8L) {
      str1 = a.cqO;
    } 
    k k = new k();
    str3 = str2;
    try {
      str1 = k.b(hashMap, str1, 1);
    } catch (Exception hashMap) {
      str1 = str2;
      str3 = str1;
      return str1;
    } finally {
      str1 = null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepa\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */