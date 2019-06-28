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
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class k extends u implements i {
  public static final String bzT = CrashApplication.zv().getString(2131627903);
  
  public static final String bzY = CrashApplication.zv().getString(2131627899);
  
  public static final String daD;
  
  public static final String daE;
  
  public static final String daF;
  
  public static final String dag = CrashApplication.zv().getString(2131627906);
  
  public static final String dah = CrashApplication.zv().getString(2131627902);
  
  private ConcurrentHashMap<String, String> bNh;
  
  private long bSc;
  
  private SQLiteDatabase cZS;
  
  private Time daC = new Time();
  
  private long daG;
  
  private String dat;
  
  private long mStartTime;
  
  static  {
    daD = CrashApplication.zv().getString(2131627908);
    daE = CrashApplication.zv().getString(2131627900);
    daF = CrashApplication.zv().getString(2131627901);
  }
  
  public k(Context paramContext) {
    super(paramContext);
    this.daC.setToNow();
  }
  
  protected double[] AW() {
    n.println("这里不会进来");
    return new double[] { 0.0D, 0.0D };
  }
  
  @NonNull
  public String AX() { return this.mContext.getString(2131627853); }
  
  public String a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, v paramv, String paramString1, String paramString2) {
    try {
      b(paramLong1, paramLong2, this.mContext.getString(2131627835));
      ArrayList arrayList1 = new ArrayList();
      arrayList1.add(new s.a(this.mContext.getString(2131627862), y(paramLong1, paramLong2)));
      arrayList1.add(new s.a(this.mContext.getString(2131627864), paramString1));
      ArrayList arrayList2 = new ArrayList();
      paramString1 = bzT;
      paramString2 = bzY;
      String str1 = dag;
      String str2 = dah;
      String str3 = daD;
      String str4 = daE;
      String str5 = daF;
      String str6 = bzY;
      String str7 = dag;
      String str8 = dah;
      String str9 = daD;
      String str10 = daE;
      String str11 = daF;
      return a(new s(this.mContext.getString(2131627869), this.mContext.getString(2131627869), arrayList1, arrayList2, paramArrayList, null, new String[] { paramString1, paramString2, str1, str2, str3, str4, str5 }, new String[] { str6, str7, str8, str9, str10, str11 }));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public void a(t paramt) {
    this.daq = null;
    byte b = 0;
    this.dby = 0;
    this.daG = paramt.ang();
    this.mStartTime = paramt.ane();
    this.bSc = paramt.anf();
    try {
      this.cZS = r(this.mStartTime, this.bSc);
      this.bNh = b.l(b.S(this.mStartTime), b.U(this.mStartTime), b.S(this.bSc), b.U(this.bSc));
    } catch (Exception exception) {
      a.e(exception);
    } 
    null = this.bNh.entrySet();
    null = new StringBuilder();
    null.append("");
    null.append("select dateTime,received,orderNoCount,productCount from(");
    String str2 = null.toString();
    for (Map.Entry entry : null) {
      b++;
      StringBuilder stringBuilder3 = new StringBuilder("select ");
      stringBuilder3.append(" nDateTime dateTime");
      stringBuilder3.append(",sum(case when nStcokDirection=300002 then fReceived else -fReceived end) received");
      stringBuilder3.append(",count(distinct sOrderNo) orderNoCount");
      stringBuilder3.append(",sum(case when nSpareField3=2 then 0 ");
      stringBuilder3.append(" when nProductTransacType=100001 then nProductQty ");
      stringBuilder3.append(" when nProductTransacType=100015 then -nProductQty else 0 end) productCount ");
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" from ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc where ");
      stringBuilder3.append(stringBuilder5.toString());
      if (paramt.ane() > 0L || paramt.anf() > 0L) {
        stringBuilder3.append(" nDatetime>=");
        stringBuilder3.append(paramt.ane());
        stringBuilder3.append(" and nDatetime<=");
        stringBuilder3.append(paramt.anf());
        stringBuilder3.append(" and ");
      } 
      if (paramt.ang() > 1L) {
        stringBuilder3.append(" nUserID=");
        stringBuilder3.append(paramt.ang());
        stringBuilder3.append(" and ");
      } 
      stringBuilder3.append(" nProductTransacType in(100001,100015,100045,100060) and ");
      stringBuilder3.append(" nShopID=");
      stringBuilder3.append(VC());
      stringBuilder3.append(" and (nDeletionFlag is null or nDeletionFlag<>1) ");
      stringBuilder3.append(" group by (nDateTime+");
      stringBuilder3.append(this.daC.gmtoff * 1000L);
      stringBuilder3.append(")/86400000 ");
      if (b != this.bNh.size()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(stringBuilder3.toString());
        stringBuilder.append(" union all ");
        str2 = stringBuilder.toString();
        continue;
      } 
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(str2);
      stringBuilder4.append(stringBuilder3.toString());
      str2 = stringBuilder4.toString();
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str2);
    stringBuilder1.append(") as T order by dateTime desc");
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(getClass().getSimpleName());
    stringBuilder2.append("-sql-initValue->");
    stringBuilder2.append(str1);
    b.ct(stringBuilder2.toString());
    this.dat = str1;
  }
  
  public ArrayList<HashMap<String, String>> zJ() {
    boolean bool;
    ArrayList arrayList = new ArrayList();
    null = ant();
    if (null.length() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    SQLiteDatabase sQLiteDatabase = Vq();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.dat);
    stringBuilder.append(null);
    Cursor cursor = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
    if (!bool) {
      boolean bool1;
      if (cursor.getCount() >= getPageSize()) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      gC(bool1);
    } 
    while (cursor.moveToNext()) {
      double d1;
      HashMap hashMap = new HashMap();
      this.daC.set(cursor.getLong(0));
      String str = this.daC.format(B(Time.class));
      hashMap.put(bzT, str);
      hashMap.put("day", nq(str));
      double d2 = cursor.getDouble(1);
      str = bzY;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.dbN);
      stringBuilder1.append(n.d(Double.valueOf(d2)));
      hashMap.put(str, stringBuilder1.toString());
      int m = cursor.getInt(2);
      hashMap.put(dag, n.d(Integer.valueOf(m)));
      int j = cursor.getInt(3);
      hashMap.put(daD, n.d(Integer.valueOf(j)));
      if (d2 > 1.0E-6D) {
        bool = true;
      } else {
        bool = false;
      } 
      double d3 = j;
      if (d3 > 1.0E-6D) {
        j = 1;
      } else {
        j = 0;
      } 
      if (bool && j != 0) {
        d1 = d2 / m;
      } else {
        d1 = 0.0D;
      } 
      str = dah;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.dbN);
      stringBuilder1.append(n.d(Double.valueOf(d1)));
      hashMap.put(str, stringBuilder1.toString());
      if (j != 0) {
        d1 = 1.0D * d3 / m;
      } else {
        d1 = 0.0D;
      } 
      hashMap.put(daE, n.d(Double.valueOf(d1)));
      if (bool && j != 0) {
        d1 = d2 / d3;
      } else {
        d1 = 0.0D;
      } 
      str = daF;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.dbN);
      stringBuilder1.append(n.d(Double.valueOf(d1)));
      hashMap.put(str, stringBuilder1.toString());
      arrayList.add(hashMap);
    } 
    cursor.close();
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */