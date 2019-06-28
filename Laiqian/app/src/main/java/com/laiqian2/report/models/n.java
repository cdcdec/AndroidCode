package com.laiqian.report.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.format.Time;
import com.google.a.a.a.a.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.v;
import com.laiqian.print.b.c;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.util.e;
import com.laiqian.util.n;
import com.laiqian.util.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class n extends u implements i, j {
  public static final String bzT = CrashApplication.zv().getString(2131627917);
  
  public static final String bzY;
  
  public static final String daD;
  
  public static final String daP;
  
  public static final String dag;
  
  public static final String dam = CrashApplication.zv().getString(2131627921);
  
  private String aJZ;
  
  private long bSc;
  
  private SQLiteDatabase cZS;
  
  private String daA;
  
  ConcurrentHashMap<String, String> daQ;
  
  private long mStartTime;
  
  static  {
    dag = CrashApplication.zv().getString(2131627918);
    daD = CrashApplication.zv().getString(2131627920);
    daP = CrashApplication.zv().getString(2131627919);
    bzY = CrashApplication.zv().getString(2131627916);
  }
  
  public n(Context paramContext) { super(paramContext); }
  
  private void a(HashMap<String, String> paramHashMap, double paramDouble) {
    if (paramHashMap != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.dbN);
      stringBuilder.append(n.d(Double.valueOf(paramDouble)));
      paramHashMap.put("amount", stringBuilder.toString());
    } 
  }
  
  private double nk(String paramString) {
    long l = n.a(null, paramString).normalize(false);
    Iterator iterator = this.daQ.entrySet().iterator();
    paramString = "select sum(sum0) from(";
    byte b = 0;
    while (iterator.hasNext()) {
      null = (Map.Entry)iterator.next();
      byte b1 = b + true;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("select sum(case when nStcokDirection=300002 then fReceived else -fReceived end) sum0 from ");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc where  nDateTime>=");
      stringBuilder1.append(l);
      stringBuilder1.append(" and nDateTime<=");
      stringBuilder1.append(l + 86399999L);
      stringBuilder1.append(" and ");
      stringBuilder1.append(this.aJZ);
      String str1 = stringBuilder1.toString();
      b = b1;
      paramString = str1;
      if (b1 != this.daQ.size()) {
        null = new StringBuilder();
        null.append(str1);
        null.append(" union all ");
        str = null.toString();
        b = b1;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(") as T");
    String str = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("手动查询该天总金额的SQL语句:");
    stringBuilder.append(str);
    n.println(stringBuilder.toString());
    Cursor cursor = Vq().rawQuery(str, null);
    l = System.currentTimeMillis();
    cursor.moveToFirst();
    stringBuilder = new StringBuilder();
    stringBuilder.append("手动查询该天总金额的SQL语句的时间:");
    stringBuilder.append(System.currentTimeMillis() - l);
    n.println(stringBuilder.toString());
    double d = cursor.getDouble(0);
    cursor.close();
    return d;
  }
  
  protected double[] AW() {
    this.daq = new double[3];
    Iterator iterator = this.daQ.entrySet().iterator();
    str1 = "select count(count0),sum(received),sum(sum2) from ( ";
    byte b = 0;
    while (iterator.hasNext()) {
      null = (Map.Entry)iterator.next();
      byte b1 = b + true;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append("select count(distinct sOrderNo) count0,sum(case when nStcokDirection=300002 then fReceived else -fReceived end) received,sum(case when nSpareField3=2 then 0 when nProductTransacType=100001 then nProductQty when nProductTransacType=100015 then -nProductQty else 0 end) sum2  from ");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc where ");
      stringBuilder1.append(this.aJZ);
      String str = stringBuilder1.toString();
      b = b1;
      str1 = str;
      if (b1 != this.daQ.size()) {
        String str1;
        null = new StringBuilder();
        null.append(str);
        null.append(" union all ");
        str1 = null.toString();
        b = b1;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(") as T ");
    str1 = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("查询总数量总金额的SQL语句:");
    stringBuilder.append(str1);
    n.println(stringBuilder.toString());
    Cursor cursor = this.cZS.rawQuery(str1, null);
    if (cursor.moveToFirst()) {
      this.daq[0] = cursor.getDouble(0);
      this.daq[1] = cursor.getDouble(1);
      this.daq[2] = cursor.getDouble(2);
    } 
    cursor.close();
    return this.daq;
  }
  
  @NonNull
  public String AX() { return this.mContext.getString(2131627854); }
  
  public PrintContent.a a(long paramLong1, long paramLong2, ArrayList<HashMap<String, String>> paramArrayList) {
    int k = p.asB();
    String str1 = n.ls(k);
    int[] arrayOfInt1 = new Time();
    arrayOfInt1.set(paramLong1);
    String str2 = arrayOfInt1.format(ann());
    arrayOfInt1.set(paramLong2);
    String str3 = arrayOfInt1.format(ann());
    PrintContent.a a = new PrintContent.a();
    null = new c(a);
    if (k == 32) {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = 8;
      arrayOfInt[1] = 12;
      arrayOfInt[2] = 12;
      arrayOfInt;
    } else if (k == 48) {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = 8;
      arrayOfInt[1] = 20;
      arrayOfInt[2] = 20;
      arrayOfInt;
    } else {
      arrayOfInt1 = new int[3];
      arrayOfInt1[0] = 8;
      arrayOfInt1[1] = 12;
      arrayOfInt1[2] = 12;
      arrayOfInt1;
    } 
    int[] arrayOfInt3 = new int[3];
    arrayOfInt3[0] = 0;
    arrayOfInt3[1] = 2;
    arrayOfInt3[2] = 2;
    arrayOfInt3;
    null.lk(this.mContext.getString(2131627927));
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = 14;
    arrayOfInt2[1] = k - 14;
    int[] arrayOfInt4 = new int[2];
    arrayOfInt4[0] = 0;
    arrayOfInt4[1] = 2;
    arrayOfInt4;
    e.b(a, arrayOfInt2, arrayOfInt4, new String[] { this.mContext.getString(2131627434), str2 }, 0);
    e.b(a, arrayOfInt2, arrayOfInt4, new String[] { this.mContext.getString(2131627435), str3 }, 0);
    byte b = 0;
    k = 1;
    while (b < paramArrayList.size()) {
      HashMap hashMap = (HashMap)paramArrayList.get(b);
      if (x(hashMap)) {
        a.ln(str1);
        e.b(a, arrayOfInt2, arrayOfInt4, new String[] { this.mContext.getString(2131627436), (String)hashMap.get(bzT) }, 0);
        k = 1;
      } else {
        if (k != 0)
          e.b(a, arrayOfInt1, arrayOfInt3, new String[] { dam, dag, daD }, 0); 
        e.b(a, arrayOfInt1, arrayOfInt3, new String[] { ((String)hashMap.get(dam)).split("-")[0], (String)hashMap.get(dag), (String)hashMap.get(daD) }, 0);
        if (k != 0) {
          e.b(a, arrayOfInt1, arrayOfInt3, new String[] { "", daP, bzY }, 0);
          k = 0;
        } 
        e.b(a, arrayOfInt1, arrayOfInt3, new String[] { "", (String)hashMap.get(daP), (String)hashMap.get(bzY) }, 0);
      } 
      b++;
    } 
    a.ln(str1);
    double[] arrayOfDouble = amw();
    e.b(a, arrayOfInt2, arrayOfInt4, new String[] { this.mContext.getString(2131627427), n.pm(n.d(Double.valueOf(arrayOfDouble[0]))) }, 3);
    e.b(a, arrayOfInt2, arrayOfInt4, new String[] { this.mContext.getString(2131627431), n.pm(n.d(Double.valueOf(arrayOfDouble[2]))) }, 3);
    e.b(a, arrayOfInt2, arrayOfInt4, new String[] { this.mContext.getString(2131627419), n.pm(n.d(Double.valueOf(arrayOfDouble[1]))) }, 3);
    return a;
  }
  
  public String a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, v paramv, String paramString1, String paramString2) {
    try {
      b(paramLong1, paramLong2, this.mContext.getString(2131627836));
      ArrayList arrayList1 = new ArrayList();
      arrayList1.add(new s.a(this.mContext.getString(2131627862), y(paramLong1, paramLong2)));
      arrayList1.add(new s.a(this.mContext.getString(2131627864), paramString1));
      ArrayList arrayList2 = new ArrayList();
      double[] arrayOfDouble = amw();
      arrayList2.add(new s.a(this.mContext.getString(2131627828), n.d(Double.valueOf(arrayOfDouble[0]))));
      arrayList2.add(new s.a(this.mContext.getString(2131627830), n.d(Double.valueOf(arrayOfDouble[2]))));
      arrayList2.add(new s.a(this.mContext.getString(2131627829), n.d(Double.valueOf(arrayOfDouble[1]))));
      String str1 = dam;
      paramString2 = dag;
      String str2 = daD;
      String str3 = daP;
      String str4 = bzY;
      String str5 = dag;
      String str6 = daD;
      String str7 = daP;
      String str8 = bzY;
      return a(new s(this.mContext.getString(2131627870), this.mContext.getString(2131627870), arrayList1, arrayList2, paramArrayList, bzT, new String[] { str1, paramString2, str2, str3, str4 }, new String[] { str5, str6, str7, str8 }));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public void a(t paramt) {
    this.daq = null;
    this.daA = null;
    this.dby = 0;
    this.mStartTime = paramt.ane();
    this.bSc = paramt.anf();
    try {
      this.cZS = r(this.mStartTime, this.bSc);
      this.daQ = b.f(this.mStartTime, this.bSc);
    } catch (Exception exception) {
      a.e(exception);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nProductTransacType in(100001,100015,100045,100060) ");
    if (paramt.ane() > 0L || paramt.anf() > 0L) {
      stringBuilder.append(" and nDateTime >=");
      stringBuilder.append(paramt.ane());
      stringBuilder.append(" and nDateTime<=");
      stringBuilder.append(paramt.anf());
    } 
    if (paramt.ang() > 1L) {
      stringBuilder.append(" and nUserID=");
      stringBuilder.append(paramt.ang());
    } 
    stringBuilder.append(" and nSHopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" and (nDeletionFlag is null or nDeletionFlag!=1) ");
    this.aJZ = stringBuilder.toString();
  }
  
  public double[] amw() { return super.amw(); }
  
  public ArrayList<HashMap<String, String>> zJ() {
    boolean bool;
    ArrayList arrayList2 = new ArrayList();
    String str = ant();
    if (str.length() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder = null;
    try {
      hashMap = b.f(this.mStartTime, this.bSc);
    } catch (Exception exception) {
      StringBuilder stringBuilder1;
      a.e(exception);
      hashMap = null;
    } 
    null = hashMap.entrySet().iterator();
    str2 = "select dateTime,orderCount,sum(received),sum(field) from(";
    int k = 0;
    while (null.hasNext()) {
      null = (Map.Entry)null.next();
      byte b = k + true;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append("select nDateTime dateTime,count(distinct sOrderNo) orderCount,sum(case when nStcokDirection=300002 then fReceived else -fReceived end) received,sum(case when nSpareField3=2 then 0 when nProductTransacType=100001 then nProductQty when nProductTransacType=100015 then -nProductQty else 0 end) field  from ");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc where ");
      stringBuilder1.append(this.aJZ);
      stringBuilder1.append(" group by nDateTime/3600000  ");
      String str1 = stringBuilder1.toString();
      k = b;
      str2 = str1;
      if (b != hashMap.size()) {
        String str2;
        null = new StringBuilder();
        null.append(str1);
        null.append(" union all ");
        str2 = null.toString();
        k = b;
      } 
    } 
    HashMap hashMap = new StringBuilder();
    hashMap.append(str2);
    hashMap.append(") as T group by dateTime/3600000 order by dateTime desc");
    hashMap.append(str);
    str2 = hashMap.toString();
    Cursor cursor = this.cZS.rawQuery(str2, null);
    hashMap = new StringBuilder();
    hashMap.append(getClass().getSimpleName());
    hashMap.append("查询的SQL：");
    hashMap.append(str2);
    n.println(hashMap.toString());
    if (!bool) {
      boolean bool2;
      if (cursor.getCount() >= getPageSize()) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      gC(bool2);
    } 
    boolean bool1 = anu();
    Time time = new Time();
    str = B(Time.class);
    double d2 = 0.0D;
    double d5 = 0.0D;
    double d1 = d5;
    double d3 = d1;
    double d4 = d1;
    d1 = d2;
    hashMap = stringBuilder;
    ArrayList arrayList1 = arrayList2;
    while (cursor.moveToNext()) {
      HashMap hashMap1 = new HashMap();
      time.set(cursor.getLong(0));
      String str1 = dam;
      null = new StringBuilder();
      null.append(time.hour);
      null.append(":00-");
      null.append(time.hour + 1);
      null.append(":00");
      hashMap1.put(str1, null.toString());
      k = cursor.getInt(1);
      hashMap1.put(dag, n.d(Integer.valueOf(k)));
      double d8 = cursor.getDouble(2);
      str1 = bzY;
      null = new StringBuilder();
      null.append(this.dbN);
      null.append(n.d(Double.valueOf(d8)));
      hashMap1.put(str1, null.toString());
      double d9 = cursor.getDouble(3);
      hashMap1.put(daD, n.d(Double.valueOf(d9)));
      if (k == 0) {
        str1 = daP;
        null = new StringBuilder();
        null.append(this.dbN);
        null.append(n.d(Double.valueOf(d8)));
        hashMap1.put(str1, null.toString());
      } else if (d8 > 1.0E-6D && d9 > 1.0E-6D) {
        str1 = daP;
        null = new StringBuilder();
        null.append(this.dbN);
        null.append(n.d(Double.valueOf(d8 / k)));
        hashMap1.put(str1, null.toString());
      } else {
        str1 = daP;
        null = new StringBuilder();
        null.append(this.dbN);
        null.append(n.d(Integer.valueOf(0)));
        hashMap1.put(str1, null.toString());
      } 
      double d7 = d5;
      double d6 = d4;
      d2 = d3;
      if (bool1) {
        d7 = d5 + k;
        d6 = d4 + d9;
        d2 = d3 + d8;
      } 
      String str2 = time.format(str);
      if (str2.equals(this.daA)) {
        if (hashMap != null)
          d1 += d8; 
      } else {
        HashMap hashMap2 = new HashMap();
        hashMap2.put(bzT, str2);
        hashMap2.put("day", nq(str2));
        hashMap2.put("week", jL(time.weekDay));
        W(hashMap2);
        arrayList1.add(hashMap2);
        this.daA = str2;
        a(hashMap, d1);
        d1 = d8;
        hashMap = hashMap2;
      } 
      arrayList1.add(hashMap1);
      d5 = d7;
      d4 = d6;
      d3 = d2;
    } 
    cursor.close();
    if (hashMap != null)
      if (ano() && !bool) {
        a(hashMap, nk(this.daA));
      } else {
        a(hashMap, d1);
      }  
    if (bool1) {
      this.daq = new double[3];
      this.daq[0] = d5;
      this.daq[1] = d3;
      this.daq[2] = d4;
    } 
    return arrayList1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */