package com.laiqian.member.report;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.Size;
import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.db.multidatabase.d.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.at;
import com.laiqian.entity.v;
import com.laiqian.i.d;
import com.laiqian.member.ca;
import com.laiqian.models.f;
import com.laiqian.models.j;
import com.laiqian.models.l;
import com.laiqian.pos.industry.a;
import com.laiqian.sync.a.g;
import com.laiqian.util.au;
import com.laiqian.util.bh;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import com.orhanobut.logger.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ak {
  private static final String TAG = "ak";
  
  private static ak bzS;
  
  public ArrayList<v> bbS;
  
  public ArrayList<v> bzM;
  
  public ArrayList<v> bzN;
  
  public ArrayList<v> bzO;
  
  public ArrayList<v> bzP;
  
  public ArrayList<v> bzQ;
  
  public String[] bzR = new String[3];
  
  private Context context;
  
  static  {
  
  }
  
  public ak(Context paramContext) { this.context = paramContext; }
  
  private void Re() {
    String[] arrayOfString = this.bzR;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.context.getString(R.string.pos_vip_all_type_tltle));
    arrayOfString[0] = stringBuilder.toString();
    arrayOfString = this.bzR;
    stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.context.getString(R.string.mc_increment_point_txt));
    arrayOfString[1] = stringBuilder.toString();
    arrayOfString = this.bzR;
    stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.context.getString(R.string.mc_consume_point_txt));
    arrayOfString[2] = stringBuilder.toString();
  }
  
  private j.a a(j.a parama, double paramDouble) {
    j.a a1 = new j.a(parama);
    long l = System.currentTimeMillis();
    a1.a(j.bNi, Long.valueOf(l));
    a1.a(j.bNr, Long.valueOf(l));
    Double double;
    a1.a(j.bOB, (double = (Double)parama.b(j.bOB)).valueOf(-double.doubleValue()));
    a1.a(j.bOD, Double.valueOf(-((Double)parama.b(j.bOD)).doubleValue()));
    a1.a(j.bOA, Double.valueOf(paramDouble));
    a1.a(j.bOC, Double.valueOf(paramDouble - double.doubleValue()));
    a1.a(j.bOz, Long.valueOf(370010L));
    a1.a(j.bNp, ((Long)parama.b(j.bNi)).toString());
    a1.a(j.bNv, Long.valueOf(0L));
    a1.a(j.bNu, Long.valueOf(0L));
    a1.a(j.bNI, Long.valueOf(1L));
    return a1;
  }
  
  private ArrayList<HashMap<String, String>> a(String paramString, String[] paramArrayOfString) {
    try {
      exception = new j(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    Cursor cursor = exception.b(null, null, paramArrayOfString, paramString, " group by nSpareField2,case when nSpareField2 in (10009,10007) or nSpareField3 is null or nSpareField3='' then 0 else nSpareField3 end", null, null, null, false);
    ArrayList arrayList = new ArrayList();
    if (cursor != null)
      while (cursor.moveToNext()) {
        HashMap hashMap = new HashMap();
        String str = cursor.getString(cursor.getColumnIndex("nSpareField2"));
        if (str != null && !"".equals(str)) {
          hashMap.put("PAY_TYPE", cursor.getString(cursor.getColumnIndex("nSpareField2")));
          hashMap.put("PAY_CUSTOM_TYPE", cursor.getString(cursor.getColumnIndex("nSpareField3")));
          arrayList.add(hashMap);
        } 
      }  
    if (cursor != null)
      cursor.close(); 
    exception.close();
    return arrayList;
  }
  
  private ArrayList<v> a(ArrayList<v> paramArrayList, String paramString, String[] paramArrayOfString) {
    null = a(paramString, paramArrayOfString);
    ArrayList arrayList = new ArrayList();
    if (null.size() == 0)
      return arrayList; 
    for (HashMap hashMap : null) {
      for (v v : paramArrayList) {
        String str = (String)hashMap.get("PAY_TYPE");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(v.aSX);
        stringBuilder.append("");
        if (str.equals(stringBuilder.toString())) {
          if (v.aSX == 10013) {
            str = (String)hashMap.get("PAY_CUSTOM_TYPE");
            stringBuilder = new StringBuilder();
            stringBuilder.append(v.aSW);
            stringBuilder.append("");
            if (str.equals(stringBuilder.toString()))
              arrayList.add(v); 
            continue;
          } 
          arrayList.add(v);
        } 
      } 
    } 
    return arrayList;
  }
  
  public static ak aF(Context paramContext) {
    if (bzS == null)
      bzS = new ak(paramContext.getApplicationContext()); 
    return bzS;
  }
  
  @Size
  private double[] c(int paramInt1, int paramInt2, String paramString) {
    long[] arrayOfLong = b.aW(paramInt1, paramInt2);
    at at = new at();
    at.dI(paramString);
    at.g(new String[] { null, (new String[2][0] = String.valueOf(arrayOfLong[0])).valueOf(arrayOfLong[1]) });
    String[] arrayOfString = at.Fu();
    String str2 = at.getUserID();
    String str3 = at.Jf();
    String str4 = at.IY();
    String str5 = at.Jc();
    double d1 = a(false, new String[] { "370005" }, arrayOfString, str2, str3, str4, str5);
    arrayOfString = at.Fu();
    str2 = at.getUserID();
    str3 = at.Jf();
    str4 = at.IY();
    str5 = at.Jc();
    double d2 = a(true, new String[] { "370004", "370010" }, arrayOfString, str2, str3, str4, str5);
    arrayOfString = at.Fu();
    str2 = at.getUserID();
    str3 = at.Jf();
    str4 = at.IY();
    String str1 = at.Jc();
    return new double[] { d1, d2, a(false, new String[] { "370004", "370007", "370010" }, arrayOfString, str2, str3, str4, str1) };
  }
  
  public String[] D(ArrayList<v> paramArrayList) {
    int i = paramArrayList.size();
    byte b = 2;
    String[] arrayOfString = new String[i + 2];
    arrayOfString[0] = this.context.getString(R.string.pos_member_all_consume_type);
    arrayOfString[1] = this.context.getString(R.string.pos_member_combine_pay_type);
    while (b <= paramArrayList.size() + 1) {
      arrayOfString[b] = ((v)paramArrayList.get(b - 2)).name;
      b++;
    } 
    return arrayOfString;
  }
  
  public String[] E(ArrayList<v> paramArrayList) {
    String[] arrayOfString = new String[paramArrayList.size() + 3];
    null = new StringBuilder();
    null.append(this.context.getString(R.string.pos_charge));
    null.append("-");
    String str = null.toString();
    arrayOfString[0] = this.context.getString(R.string.pos_member_all_charge_type);
    arrayOfString[1] = this.context.getString(R.string.pos_vip_change_amount_title);
    arrayOfString[2] = this.context.getString(R.string.pos_charge_revoke);
    for (byte b = 3; b <= paramArrayList.size() + 3 - 1; b++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(((v)paramArrayList.get(b - 3)).name);
      arrayOfString[b] = stringBuilder.toString();
    } 
    return arrayOfString;
  }
  
  public String[] F(ArrayList<v> paramArrayList) {
    int i = paramArrayList.size();
    byte b = 1;
    String[] arrayOfString = new String[i + 1];
    null = new StringBuilder();
    null.append(this.context.getString(R.string.charge_cancel));
    null.append("-");
    String str = null.toString();
    arrayOfString[0] = this.context.getString(R.string.pos_member_all_charge_type);
    while (b <= paramArrayList.size()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(((v)paramArrayList.get(b - true)).name);
      arrayOfString[b] = stringBuilder.toString();
      b++;
    } 
    return arrayOfString;
  }
  
  public ak Rd() {
    this.bzQ = Rg();
    this.bbS = Rf();
    Re();
    return bzS;
  }
  
  public ArrayList<v> Rf() {
    ArrayList arrayList = Rg();
    arrayList.add(v.FY());
    arrayList.add(v.FS());
    arrayList.add(v.FT());
    arrayList.add(v.FU());
    arrayList.add(v.FV());
    arrayList.add(v.FX());
    arrayList.add(v.FW());
    return arrayList;
  }
  
  public ArrayList<v> Rg() {
    try {
      exception = new f(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    ArrayList arrayList = exception.o(false, true);
    exception.close();
    return arrayList;
  }
  
  public boolean Rh() {
    g g = new g(RootApplication.zv());
    g.apy().gW(true);
    g.apy().ow("download_transaction");
    long l1 = System.currentTimeMillis() - 604800000L;
    long l2 = System.currentTimeMillis();
    boolean bool1 = g.c(true, "t_bpartner", l1, l2);
    boolean bool2 = g.c(false, "t_bpartner_chargedoc", l1, l2);
    if (bool1 && bool2) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("downloadVIPdata success=");
    stringBuilder.append(bool1);
    Log.i(str, stringBuilder.toString());
    g.close();
    return !!bool1;
  }
  
  public double a(boolean paramBoolean, ArrayList<Map<String, String>> paramArrayList, String[] paramArrayOfString) { // Byte code:
    //   0: dconst_0
    //   1: dstore #6
    //   3: iconst_0
    //   4: istore #8
    //   6: iload #8
    //   8: aload_2
    //   9: invokevirtual size : ()I
    //   12: if_icmpge -> 407
    //   15: iload_1
    //   16: ifeq -> 148
    //   19: aload_2
    //   20: iload #8
    //   22: invokevirtual get : (I)Ljava/lang/Object;
    //   25: checkcast java/util/Map
    //   28: ldc_w 'nChargeType'
    //   31: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast java/lang/String
    //   39: invokestatic parseInt : (Ljava/lang/String;)I
    //   42: ldc_w 370004
    //   45: if_icmpeq -> 83
    //   48: dload #6
    //   50: dstore #4
    //   52: aload_2
    //   53: iload #8
    //   55: invokevirtual get : (I)Ljava/lang/Object;
    //   58: checkcast java/util/Map
    //   61: ldc_w 'nChargeType'
    //   64: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast java/lang/String
    //   72: invokestatic parseInt : (Ljava/lang/String;)I
    //   75: i2l
    //   76: ldc2_w 370010
    //   79: lcmp
    //   80: ifne -> 394
    //   83: aload_3
    //   84: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   87: ldc_w '370004'
    //   90: invokeinterface contains : (Ljava/lang/Object;)Z
    //   95: ifne -> 117
    //   98: dload #6
    //   100: dstore #4
    //   102: aload_3
    //   103: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   106: ldc_w '370010'
    //   109: invokeinterface contains : (Ljava/lang/Object;)Z
    //   114: ifeq -> 394
    //   117: dload #6
    //   119: aload_2
    //   120: iload #8
    //   122: invokevirtual get : (I)Ljava/lang/Object;
    //   125: checkcast java/util/Map
    //   128: ldc_w 'fIncrementAmount'
    //   131: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast java/lang/CharSequence
    //   139: invokestatic u : (Ljava/lang/CharSequence;)D
    //   142: dadd
    //   143: dstore #4
    //   145: goto -> 394
    //   148: aload_2
    //   149: iload #8
    //   151: invokevirtual get : (I)Ljava/lang/Object;
    //   154: checkcast java/util/Map
    //   157: ldc_w 'nChargeType'
    //   160: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   165: checkcast java/lang/String
    //   168: invokestatic parseInt : (Ljava/lang/String;)I
    //   171: ldc_w 370005
    //   174: if_icmpne -> 224
    //   177: aload_3
    //   178: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   181: ldc_w '370005'
    //   184: invokeinterface contains : (Ljava/lang/Object;)Z
    //   189: ifeq -> 224
    //   192: dload #6
    //   194: aload_2
    //   195: iload #8
    //   197: invokevirtual get : (I)Ljava/lang/Object;
    //   200: checkcast java/util/Map
    //   203: ldc_w 'fChargeAmount'
    //   206: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   211: checkcast java/lang/CharSequence
    //   214: invokestatic u : (Ljava/lang/CharSequence;)D
    //   217: dneg
    //   218: dadd
    //   219: dstore #4
    //   221: goto -> 394
    //   224: aload_2
    //   225: iload #8
    //   227: invokevirtual get : (I)Ljava/lang/Object;
    //   230: checkcast java/util/Map
    //   233: ldc_w 'nChargeType'
    //   236: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   241: checkcast java/lang/String
    //   244: invokestatic parseInt : (Ljava/lang/String;)I
    //   247: ldc_w 370004
    //   250: if_icmpeq -> 317
    //   253: aload_2
    //   254: iload #8
    //   256: invokevirtual get : (I)Ljava/lang/Object;
    //   259: checkcast java/util/Map
    //   262: ldc_w 'nChargeType'
    //   265: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   270: checkcast java/lang/String
    //   273: invokestatic parseInt : (Ljava/lang/String;)I
    //   276: ldc_w 370007
    //   279: if_icmpeq -> 317
    //   282: dload #6
    //   284: dstore #4
    //   286: aload_2
    //   287: iload #8
    //   289: invokevirtual get : (I)Ljava/lang/Object;
    //   292: checkcast java/util/Map
    //   295: ldc_w 'nChargeType'
    //   298: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   303: checkcast java/lang/String
    //   306: invokestatic parseInt : (Ljava/lang/String;)I
    //   309: i2l
    //   310: ldc2_w 370010
    //   313: lcmp
    //   314: ifne -> 394
    //   317: aload_3
    //   318: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   321: ldc_w '370004'
    //   324: invokeinterface contains : (Ljava/lang/Object;)Z
    //   329: ifne -> 366
    //   332: aload_3
    //   333: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   336: ldc_w '370007'
    //   339: invokeinterface contains : (Ljava/lang/Object;)Z
    //   344: ifne -> 366
    //   347: dload #6
    //   349: dstore #4
    //   351: aload_3
    //   352: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   355: ldc_w '370010'
    //   358: invokeinterface contains : (Ljava/lang/Object;)Z
    //   363: ifeq -> 394
    //   366: dload #6
    //   368: aload_2
    //   369: iload #8
    //   371: invokevirtual get : (I)Ljava/lang/Object;
    //   374: checkcast java/util/Map
    //   377: ldc_w 'fReceived'
    //   380: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   385: checkcast java/lang/CharSequence
    //   388: invokestatic u : (Ljava/lang/CharSequence;)D
    //   391: dadd
    //   392: dstore #4
    //   394: iload #8
    //   396: iconst_1
    //   397: iadd
    //   398: istore #8
    //   400: dload #4
    //   402: dstore #6
    //   404: goto -> 6
    //   407: dload #6
    //   409: dreturn }
  
  public double a(boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2, String paramString3, String paramString4) {
    try {
      exception = new j(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    Cursor cursor = exception.b(paramArrayOfString2, paramString1, paramArrayOfString1, paramString2, paramString3, paramString4);
    double d1 = 0.0D;
    double d2 = d1;
    if (cursor != null) {
      while (cursor.moveToNext()) {
        if (paramBoolean) {
          if (cursor.getInt(cursor.getColumnIndex("nChargeType")) == 370004 || cursor.getInt(cursor.getColumnIndex("nChargeType")) == 370010L)
            d1 += cursor.getDouble(cursor.getColumnIndex("fIncrementAmount")); 
          continue;
        } 
        if (cursor.getInt(cursor.getColumnIndex("nChargeType")) == 370005) {
          d1 += -cursor.getDouble(cursor.getColumnIndex("fChargeAmount"));
          continue;
        } 
        if (cursor.getInt(cursor.getColumnIndex("nChargeType")) == 370004 || cursor.getInt(cursor.getColumnIndex("nChargeType")) == 370007 || cursor.getInt(cursor.getColumnIndex("nChargeType")) == 370010L)
          d1 += cursor.getDouble(cursor.getColumnIndex("fReceived")); 
      } 
      cursor.close();
      d2 = d1;
    } 
    exception.close();
    return d2;
  }
  
  public long a(long paramLong1, double paramDouble, long paramLong2) {
    try {
      exception = new j(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    null = exception.hd(String.valueOf(paramLong1));
    if (null.size() == 0) {
      n.o(this.context.getString(R.string.please_download_transaction_data));
      throw new IllegalStateException("no such record");
    } 
    if (null.size() > 1)
      throw new RuntimeException("multiple records found, which is illegal"); 
    a1 = (j.a)null.get(0);
    j.a a2 = a(a1, paramDouble);
    exception.beginTransaction();
    try {
      if (!exception.b(a2))
        a1.a(j.bNi).setValue(Long.valueOf(0L)); 
      if (!exception.a(((Long)a1.b(j.bNi)).longValue(), paramLong2, true))
        a1.a(j.bNi).setValue(Long.valueOf(0L)); 
      if (((Long)a1.a(j.bNi).getValue()).longValue() != 0L) {
        exception.setTransactionSuccessful();
        paramLong1 = ((Long)a2.a(j.bNi).getValue()).longValue();
        exception.endTransaction();
        exception.close();
        return paramLong1;
      } 
    } catch (Exception a1) {
      a.e(a1);
    } finally {}
    exception.endTransaction();
    exception.close();
    return 0L;
  }
  
  public String a(long paramLong, Long paramLong1) {
    try {
      exception = new j(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    try {
      Cursor cursor = exception.q(paramLong, paramLong1.longValue());
    } catch (Exception paramLong1) {
      a.e(paramLong1);
      paramLong1 = null;
    } 
    if (paramLong1 != null && paramLong1.moveToFirst()) {
      String str = paramLong1.getString(paramLong1.getColumnIndex("sText"));
      paramLong1.close();
      exception.close();
      return str;
    } 
    exception.close();
    return null;
  }
  
  public String a(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2, String paramString3, String paramString4) {
    j j = new j(this.context);
    try {
      String str = j.d(paramArrayOfString2, paramString1, paramArrayOfString1, paramString2, paramString3, paramString4);
    } catch (Exception paramArrayOfString1) {
      a.e(paramArrayOfString1);
      paramArrayOfString1 = null;
    } 
    j.close();
    return paramArrayOfString1;
  }
  
  public HashMap<String, String> a(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean) {
    byte b2;
    byte b1;
    HashMap hashMap = new HashMap();
    ArrayList arrayList = new ArrayList();
    j j = new j(this.context);
    cursor = j.b(paramArrayOfString2, paramString1, paramArrayOfString1, paramString2, paramString3, paramString4, paramString5);
    boolean bool = false;
    if (cursor != null) {
      b2 = 0;
      b1 = 0;
      while (cursor.moveToNext()) {
        int m = cursor.getInt(cursor.getColumnIndex("points"));
        null = new StringBuilder();
        null.append("getTotalPoint points=");
        null.append(m);
        d.b(null.toString(), new Object[0]);
        String str = cursor.getString(cursor.getColumnIndex("nBPartnerID"));
        if (!a(arrayList, str))
          arrayList.add(str); 
        int k = b2;
        if (m > 0)
          k = b2 + m; 
        b2 = k;
        if (m < 0) {
          b1 += m;
          b2 = k;
        } 
      } 
      cursor.close();
    } else {
      b2 = 0;
      b1 = 0;
    } 
    j.close();
    StringBuilder stringBuilder = new StringBuilder();
    try {
      l l = new l(this.context);
    } catch (Exception cursor) {
      a.e(cursor);
      cursor = null;
    } 
    if (paramBoolean) {
      cursor = cursor.hi(paramString2);
    } else {
      if (arrayList != null && arrayList.size() > 0) {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
          stringBuilder.append((String)iterator.next());
          stringBuilder.append(",");
        } 
      } 
      int k = stringBuilder.lastIndexOf(",");
      if (stringBuilder.toString().length() > 1 && k > 0)
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(",")); 
      cursor = cursor.hi(stringBuilder.toString());
    } 
    int i = bool;
    if (cursor != null) {
      cursor.moveToNext();
      i = cursor.getInt(cursor.getColumnIndex("fPoints")) + 0;
      stringBuilder = new StringBuilder();
      stringBuilder.append("getTotalPoint fTotalPoint=");
      stringBuilder.append(i);
      d.b(stringBuilder.toString(), new Object[0]);
      cursor.close();
    } 
    hashMap.put("totalGiftPoint", n.d(Integer.valueOf(b2)));
    hashMap.put("totalConsumePoint", n.d(Integer.valueOf(b1)));
    hashMap.put("fTotalPoint", n.d(Integer.valueOf(i)));
    return hashMap;
  }
  
  public boolean a(List<String> paramList, String paramString) {
    if (paramList != null && paramList.size() > 0)
      for (String str : paramList) {
        if (!by.isNull(paramString) && paramString.equals(str))
          return true; 
      }  
    return false;
  }
  
  public HashMap<String, String> b(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean) {
    HashMap hashMap = new HashMap();
    ArrayList arrayList = new ArrayList();
    j j = new j(this.context);
    null = j.c(paramArrayOfString2, paramString1, paramArrayOfString1, paramString2, paramString3, paramString4, paramString5);
    new ArrayList();
    String str2 = RootApplication.getLaiqianPreferenceManager().Tx();
    paramString1 = RootApplication.getLaiqianPreferenceManager().Ea();
    paramString3 = RootApplication.getLaiqianPreferenceManager().atr();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avm());
    stringBuilder.append("");
    null = new ca(str2, paramString1, paramString3, "0", "1", stringBuilder.toString(), null, j.VJ());
    j.close();
    String str1 = d.ac(null);
    str1 = bh.bt(a.cqA, str1);
    boolean bool = TextUtils.isEmpty(str1);
    int i = 0;
    if (!bool) {
      HashMap hashMap1 = au.qB(str1);
      if (hashMap1.containsKey("result") && "TRUE".equals(String.valueOf(hashMap1.get("result")))) {
        ArrayList arrayList1 = au.aW(hashMap1.get("message"));
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(arrayList1.size());
        stringBuilder1.append("");
        Log.e("arrList", stringBuilder1.toString());
        if (arrayList1 != null && arrayList1.size() > 0) {
          int m = 0;
          i = 0;
          int k;
          for (k = 0; m < arrayList1.size(); k = i1) {
            int i2 = n.parseInt((String)((Map)arrayList1.get(m)).get("points"));
            String str = String.valueOf(((Map)arrayList1.get(m)).get("nBPartnerID"));
            if (!a(arrayList, str))
              arrayList.add(str); 
            int n = i;
            if (i2 > 0)
              n = i + i2; 
            int i1 = k;
            if (i2 < 0)
              i1 = k + i2; 
            m++;
            i = n;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          new l(this.context);
          if (paramBoolean) {
            m = fQ(paramString2) + 0;
          } else {
            if (arrayList != null && arrayList.size() > 0) {
              Iterator iterator = arrayList.iterator();
              while (iterator.hasNext()) {
                stringBuilder2.append((String)iterator.next());
                stringBuilder2.append(",");
              } 
            } 
            m = stringBuilder2.lastIndexOf(",");
            if (stringBuilder2.toString().length() > 1 && m > 0)
              stringBuilder2.deleteCharAt(stringBuilder2.lastIndexOf(",")); 
            m = fQ(stringBuilder2.toString()) + 0;
          } 
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("getTotalPoint fTotalPoint=");
          stringBuilder2.append(m);
          d.b(stringBuilder2.toString(), new Object[0]);
          hashMap.put("totalGiftPoint", n.d(Integer.valueOf(i)));
          hashMap.put("totalConsumePoint", n.d(Integer.valueOf(k)));
          hashMap.put("fTotalPoint", n.d(Integer.valueOf(m)));
          return hashMap;
        } 
      } 
    } 
    byte b2 = 0;
    byte b1 = 0;
    hashMap.put("totalGiftPoint", n.d(Integer.valueOf(i)));
    hashMap.put("totalConsumePoint", n.d(Integer.valueOf(b1)));
    hashMap.put("fTotalPoint", n.d(Integer.valueOf(b2)));
    return hashMap;
  }
  
  public String[] b(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2, String paramString3, String paramString4) {
    j j = new j(this.context);
    try {
      j.c(paramArrayOfString2, paramString1, paramArrayOfString1, paramString2, paramString3, paramString4);
    } catch (Exception paramArrayOfString1) {
      a.e(paramArrayOfString1);
    } 
    paramArrayOfString1 = j.VJ();
    j.close();
    return paramArrayOfString1;
  }
  
  public ArrayList<Map<String, String>> c(String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2, String paramString3, String paramString4) {
    String str2 = a(paramArrayOfString1, paramArrayOfString2, paramString1, paramString2, paramString3, paramString4);
    ArrayList arrayList = new ArrayList();
    String str3 = RootApplication.getLaiqianPreferenceManager().Tx();
    String str4 = RootApplication.getLaiqianPreferenceManager().Ea();
    String str5 = RootApplication.getLaiqianPreferenceManager().atr();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avm());
    stringBuilder.append("");
    String str1 = d.ac(new ca(str3, str4, str5, "0", "1", stringBuilder.toString(), str2, b(paramArrayOfString1, paramArrayOfString2, paramString1, paramString2, paramString3, paramString4)));
    str1 = bh.bt(a.cqA, str1);
    if (!TextUtils.isEmpty(str1)) {
      HashMap hashMap = au.qB(str1);
      if (hashMap.containsKey("result") && "TRUE".equals(String.valueOf(hashMap.get("result")))) {
        ArrayList arrayList1 = au.aW(hashMap.get("message"));
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(arrayList1.size());
        stringBuilder1.append("");
        Log.e("arrList", stringBuilder1.toString());
        return arrayList1;
      } 
      return arrayList;
    } 
    return arrayList;
  }
  
  public void fM(String paramString) { this.bzM = a(this.bbS, paramString, new String[] { "370005" }); }
  
  public void fN(String paramString) { this.bzN = a(this.bbS, paramString, new String[] { "370004", "370007", "370010" }); }
  
  public void fO(String paramString) { this.bzO = a(this.bbS, paramString, new String[] { "370010" }); }
  
  public void fP(String paramString) { this.bzP = a(this.bbS, paramString, new String[] { "370011" }); }
  
  public int fQ(String paramString) {
    l l = new l(this.context);
    try {
      paramString = l.hj(paramString);
    } catch (Exception paramString) {
      a.e(paramString);
      paramString = null;
    } 
    String str2 = RootApplication.getLaiqianPreferenceManager().Tx();
    String str3 = RootApplication.getLaiqianPreferenceManager().Ea();
    String str4 = RootApplication.getLaiqianPreferenceManager().atr();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avm());
    stringBuilder.append("");
    null = new ca(str2, str3, str4, "0", "1", stringBuilder.toString(), paramString, l.VJ());
    l.close();
    String str1 = d.ac(null);
    str1 = bh.bt(a.cqA, str1);
    boolean bool = TextUtils.isEmpty(str1);
    byte b = 0;
    int i = b;
    if (!bool) {
      HashMap hashMap = au.qB(str1);
      i = b;
      if (hashMap.containsKey("result")) {
        i = b;
        if ("TRUE".equals(String.valueOf(hashMap.get("result"))))
          i = 0 + n.parseInt((String)au.qB(String.valueOf(hashMap.get("message"))).get("fPoints")); 
      } 
    } 
    return i;
  }
  
  @Size
  public Double[] fR(String paramString) {
    List list = b.b(new File(a.aOz), new ArrayList());
    double d3 = 0.0D;
    double d1 = d3;
    double d2 = d1;
    byte b;
    for (b = 1; b <= list.size(); b++) {
      String str = (String)list.get(b - true);
      int i = b.cw(str);
      int j = b.cx(str);
      a.Dl().cr(str);
      double[] arrayOfDouble = c(j, i - 1, paramString);
      d3 += arrayOfDouble[0];
      d1 += arrayOfDouble[1];
      d2 += arrayOfDouble[2];
      if (b % 4 == 0)
        b.Dq(); 
    } 
    return new Double[] { null, null, (new Double[3][1] = (new Double[3][0] = Double.valueOf(d3)).valueOf(d1)).valueOf(d2) };
  }
  
  public String o(String paramString1, String paramString2, String paramString3) { // Byte code:
    //   0: ldc ''
    //   2: astore #7
    //   4: ldc_w '370004'
    //   7: aload_1
    //   8: invokevirtual equals : (Ljava/lang/Object;)Z
    //   11: ifne -> 43
    //   14: ldc_w '370010'
    //   17: aload_1
    //   18: invokevirtual equals : (Ljava/lang/Object;)Z
    //   21: ifne -> 43
    //   24: ldc_w '370011'
    //   27: aload_1
    //   28: invokevirtual equals : (Ljava/lang/Object;)Z
    //   31: ifeq -> 37
    //   34: goto -> 43
    //   37: iconst_0
    //   38: istore #4
    //   40: goto -> 46
    //   43: iconst_1
    //   44: istore #4
    //   46: new java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial <init> : ()V
    //   53: astore #8
    //   55: aload #8
    //   57: aload_0
    //   58: getfield context : Landroid/content/Context;
    //   61: getstatic com/laiqian/vip/R$string.pos_charge : I
    //   64: invokevirtual getString : (I)Ljava/lang/String;
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #8
    //   73: ldc_w '-'
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload #8
    //   82: invokevirtual toString : ()Ljava/lang/String;
    //   85: astore #10
    //   87: ldc_w '370010'
    //   90: aload_1
    //   91: invokevirtual equals : (Ljava/lang/Object;)Z
    //   94: ifeq -> 138
    //   97: new java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial <init> : ()V
    //   104: astore #8
    //   106: aload #8
    //   108: aload_0
    //   109: getfield context : Landroid/content/Context;
    //   112: getstatic com/laiqian/vip/R$string.charge_cancel_title : I
    //   115: invokevirtual getString : (I)Ljava/lang/String;
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload #8
    //   124: ldc_w '-'
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload #8
    //   133: invokevirtual toString : ()Ljava/lang/String;
    //   136: astore #10
    //   138: ldc_w '370011'
    //   141: aload_1
    //   142: invokevirtual equals : (Ljava/lang/Object;)Z
    //   145: ifeq -> 159
    //   148: aload_0
    //   149: getfield context : Landroid/content/Context;
    //   152: getstatic com/laiqian/vip/R$string.vip_initial_balance_lab : I
    //   155: invokevirtual getString : (I)Ljava/lang/String;
    //   158: areturn
    //   159: ldc_w '370009'
    //   162: aload_1
    //   163: invokevirtual equals : (Ljava/lang/Object;)Z
    //   166: ifeq -> 180
    //   169: aload_0
    //   170: getfield context : Landroid/content/Context;
    //   173: getstatic com/laiqian/vip/R$string.vip_point_balance_lab : I
    //   176: invokevirtual getString : (I)Ljava/lang/String;
    //   179: areturn
    //   180: ldc_w '370007'
    //   183: aload_1
    //   184: invokevirtual equals : (Ljava/lang/Object;)Z
    //   187: ifeq -> 205
    //   190: aload_0
    //   191: getfield context : Landroid/content/Context;
    //   194: getstatic com/laiqian/vip/R$string.pos_vip_change_amount_title : I
    //   197: invokevirtual getString : (I)Ljava/lang/String;
    //   200: astore #7
    //   202: goto -> 660
    //   205: ldc_w '370005'
    //   208: aload_1
    //   209: invokevirtual equals : (Ljava/lang/Object;)Z
    //   212: ifne -> 220
    //   215: iload #4
    //   217: ifeq -> 660
    //   220: ldc ''
    //   222: astore #7
    //   224: aload_2
    //   225: astore #8
    //   227: iconst_0
    //   228: istore #5
    //   230: aload #7
    //   232: astore_2
    //   233: iload #5
    //   235: aload_0
    //   236: getfield bbS : Ljava/util/ArrayList;
    //   239: invokevirtual size : ()I
    //   242: if_icmpge -> 657
    //   245: aload #8
    //   247: ifnull -> 400
    //   250: aload_0
    //   251: getfield bbS : Ljava/util/ArrayList;
    //   254: iload #5
    //   256: invokevirtual get : (I)Ljava/lang/Object;
    //   259: checkcast com/laiqian/entity/v
    //   262: getfield aSX : I
    //   265: aload #8
    //   267: invokestatic parseInt : (Ljava/lang/String;)I
    //   270: if_icmpne -> 400
    //   273: aload_3
    //   274: ifnull -> 373
    //   277: aload #8
    //   279: invokestatic parseInt : (Ljava/lang/String;)I
    //   282: sipush #10013
    //   285: if_icmpne -> 373
    //   288: iconst_0
    //   289: istore #6
    //   291: aload_2
    //   292: astore #7
    //   294: aload #8
    //   296: astore #11
    //   298: aload #7
    //   300: astore_2
    //   301: iload #6
    //   303: aload_0
    //   304: getfield bzQ : Ljava/util/ArrayList;
    //   307: invokevirtual size : ()I
    //   310: if_icmpge -> 367
    //   313: aload_0
    //   314: getfield bzQ : Ljava/util/ArrayList;
    //   317: iload #6
    //   319: invokevirtual get : (I)Ljava/lang/Object;
    //   322: checkcast com/laiqian/entity/v
    //   325: getfield aSW : J
    //   328: invokestatic valueOf : (J)Ljava/lang/String;
    //   331: aload_3
    //   332: invokevirtual equals : (Ljava/lang/Object;)Z
    //   335: ifeq -> 358
    //   338: aload_0
    //   339: getfield bzQ : Ljava/util/ArrayList;
    //   342: iload #6
    //   344: invokevirtual get : (I)Ljava/lang/Object;
    //   347: checkcast com/laiqian/entity/v
    //   350: getfield name : Ljava/lang/String;
    //   353: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   356: astore #7
    //   358: iload #6
    //   360: iconst_1
    //   361: iadd
    //   362: istore #6
    //   364: goto -> 294
    //   367: aload_2
    //   368: astore #7
    //   370: goto -> 641
    //   373: aload_0
    //   374: getfield bbS : Ljava/util/ArrayList;
    //   377: iload #5
    //   379: invokevirtual get : (I)Ljava/lang/Object;
    //   382: checkcast com/laiqian/entity/v
    //   385: getfield name : Ljava/lang/String;
    //   388: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   391: astore #7
    //   393: aload #8
    //   395: astore #11
    //   397: goto -> 641
    //   400: aload #8
    //   402: ifnull -> 426
    //   405: ldc ''
    //   407: aload #8
    //   409: invokevirtual equals : (Ljava/lang/Object;)Z
    //   412: ifne -> 426
    //   415: ldc_w '0'
    //   418: aload #8
    //   420: invokevirtual equals : (Ljava/lang/Object;)Z
    //   423: ifeq -> 455
    //   426: ldc_w '370005'
    //   429: aload_1
    //   430: invokevirtual equals : (Ljava/lang/Object;)Z
    //   433: ifeq -> 455
    //   436: aload_0
    //   437: getfield context : Landroid/content/Context;
    //   440: getstatic com/laiqian/vip/R$string.pos_report_transaction_pay_mode_vip : I
    //   443: invokevirtual getString : (I)Ljava/lang/String;
    //   446: astore #7
    //   448: aload #8
    //   450: astore #11
    //   452: goto -> 641
    //   455: aload #8
    //   457: astore #11
    //   459: aload_2
    //   460: astore #7
    //   462: iload #4
    //   464: ifeq -> 641
    //   467: aload #8
    //   469: ifnull -> 492
    //   472: aload #8
    //   474: invokevirtual length : ()I
    //   477: ifeq -> 492
    //   480: aload #8
    //   482: astore #9
    //   484: aload #8
    //   486: invokestatic pl : (Ljava/lang/String;)Z
    //   489: ifeq -> 497
    //   492: ldc_w '10001'
    //   495: astore #9
    //   497: aload #9
    //   499: astore #11
    //   501: aload_2
    //   502: astore #7
    //   504: aload_0
    //   505: getfield bbS : Ljava/util/ArrayList;
    //   508: iload #5
    //   510: invokevirtual get : (I)Ljava/lang/Object;
    //   513: checkcast com/laiqian/entity/v
    //   516: getfield aSX : I
    //   519: aload #9
    //   521: invokestatic parseInt : (Ljava/lang/String;)I
    //   524: if_icmpne -> 641
    //   527: aload #9
    //   529: invokestatic parseInt : (Ljava/lang/String;)I
    //   532: sipush #10013
    //   535: if_icmpne -> 617
    //   538: iconst_0
    //   539: istore #6
    //   541: aload_2
    //   542: astore #7
    //   544: aload #9
    //   546: astore #11
    //   548: aload #7
    //   550: astore_2
    //   551: iload #6
    //   553: aload_0
    //   554: getfield bzQ : Ljava/util/ArrayList;
    //   557: invokevirtual size : ()I
    //   560: if_icmpge -> 367
    //   563: aload_0
    //   564: getfield bzQ : Ljava/util/ArrayList;
    //   567: iload #6
    //   569: invokevirtual get : (I)Ljava/lang/Object;
    //   572: checkcast com/laiqian/entity/v
    //   575: getfield aSW : J
    //   578: invokestatic valueOf : (J)Ljava/lang/String;
    //   581: aload_3
    //   582: invokevirtual equals : (Ljava/lang/Object;)Z
    //   585: ifeq -> 608
    //   588: aload_0
    //   589: getfield bzQ : Ljava/util/ArrayList;
    //   592: iload #6
    //   594: invokevirtual get : (I)Ljava/lang/Object;
    //   597: checkcast com/laiqian/entity/v
    //   600: getfield name : Ljava/lang/String;
    //   603: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   606: astore #7
    //   608: iload #6
    //   610: iconst_1
    //   611: iadd
    //   612: istore #6
    //   614: goto -> 544
    //   617: aload_0
    //   618: getfield bbS : Ljava/util/ArrayList;
    //   621: iload #5
    //   623: invokevirtual get : (I)Ljava/lang/Object;
    //   626: checkcast com/laiqian/entity/v
    //   629: getfield name : Ljava/lang/String;
    //   632: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   635: astore #7
    //   637: aload #9
    //   639: astore #11
    //   641: iload #5
    //   643: iconst_1
    //   644: iadd
    //   645: istore #5
    //   647: aload #11
    //   649: astore #8
    //   651: aload #7
    //   653: astore_2
    //   654: goto -> 233
    //   657: aload_2
    //   658: astore #7
    //   660: ldc_w '370014'
    //   663: aload_3
    //   664: invokevirtual equals : (Ljava/lang/Object;)Z
    //   667: ifeq -> 685
    //   670: aload_0
    //   671: getfield context : Landroid/content/Context;
    //   674: getstatic com/laiqian/vip/R$string.pos_report_transaction_pay_mode_wechat_accounting : I
    //   677: invokevirtual getString : (I)Ljava/lang/String;
    //   680: astore #7
    //   682: goto -> 707
    //   685: ldc_w '370015'
    //   688: aload_3
    //   689: invokevirtual equals : (Ljava/lang/Object;)Z
    //   692: ifeq -> 707
    //   695: aload_0
    //   696: getfield context : Landroid/content/Context;
    //   699: getstatic com/laiqian/vip/R$string.pos_report_transaction_pay_mode_wechat_scan_code : I
    //   702: invokevirtual getString : (I)Ljava/lang/String;
    //   705: astore #7
    //   707: ldc_w '370012'
    //   710: aload_3
    //   711: invokevirtual equals : (Ljava/lang/Object;)Z
    //   714: ifeq -> 732
    //   717: aload_0
    //   718: getfield context : Landroid/content/Context;
    //   721: getstatic com/laiqian/vip/R$string.report_transaction_pay_mode_alipay_accounting : I
    //   724: invokevirtual getString : (I)Ljava/lang/String;
    //   727: astore #7
    //   729: goto -> 754
    //   732: ldc_w '370013'
    //   735: aload_3
    //   736: invokevirtual equals : (Ljava/lang/Object;)Z
    //   739: ifeq -> 754
    //   742: aload_0
    //   743: getfield context : Landroid/content/Context;
    //   746: getstatic com/laiqian/vip/R$string.pos_report_transaction_pay_alipay_scan : I
    //   749: invokevirtual getString : (I)Ljava/lang/String;
    //   752: astore #7
    //   754: new java/lang/StringBuilder
    //   757: dup
    //   758: invokespecial <init> : ()V
    //   761: astore_1
    //   762: iload #4
    //   764: ifeq -> 770
    //   767: goto -> 774
    //   770: ldc ''
    //   772: astore #10
    //   774: aload_1
    //   775: aload #10
    //   777: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload_1
    //   782: aload #7
    //   784: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload_1
    //   789: invokevirtual toString : ()Ljava/lang/String;
    //   792: areturn }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */