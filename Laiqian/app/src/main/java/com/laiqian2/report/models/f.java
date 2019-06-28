package com.laiqian.report.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.print.b.c;
import com.laiqian.print.b.g;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.c;
import com.laiqian.print.util.e;
import com.laiqian.report.b.a;
import com.laiqian.sales.h;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.util.p;
import com.orhanobut.logger.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class f {
  public static final String bzT = CrashApplication.zv().getString(2131628022);
  
  public static final String bzY;
  
  public static final String dae = CrashApplication.zv().getString(2131627825);
  
  public static final String daf = CrashApplication.zv().getString(2131627898);
  
  public static final String dag = CrashApplication.zv().getString(2131627906);
  
  public static final String dah = CrashApplication.zv().getString(2131627824);
  
  public static final String dai = CrashApplication.zv().getString(2131627907);
  
  public static final String daj;
  
  public static final String dak;
  
  public static final String dal;
  
  public static final String dam;
  
  public static final String dan;
  
  s dao;
  
  public String dap = "";
  
  double[] daq = new double[2];
  
  ArrayList<HashMap<String, String>> dar = new ArrayList();
  
  Context mContext;
  
  static  {
    bzY = CrashApplication.zv().getString(2131628020);
    daj = CrashApplication.zv().getString(2131627904);
    dak = CrashApplication.zv().getString(2131627905);
    dal = CrashApplication.zv().getString(2131628018);
    dam = CrashApplication.zv().getString(2131628037);
    dan = CrashApplication.zv().getString(2131628033);
  }
  
  public f(Context paramContext) { this.mContext = paramContext; }
  
  public PrintContent.a I(String paramString1, String paramString2, String paramString3) {
    int[] arrayOfInt1;
    int i = p.asB();
    String str = n.ls(i);
    int[] arrayOfInt2 = new int[3];
    arrayOfInt2[0] = 0;
    arrayOfInt2[1] = 2;
    arrayOfInt2[2] = 2;
    arrayOfInt2;
    int[] arrayOfInt3 = new int[2];
    arrayOfInt3[0] = 0;
    arrayOfInt3[1] = 2;
    arrayOfInt3;
    if (i == 32) {
      arrayOfInt1 = new int[3];
      arrayOfInt1[0] = 14;
      arrayOfInt1[1] = 8;
      arrayOfInt1[2] = 10;
      arrayOfInt1;
    } else if (i == 48) {
      arrayOfInt1 = new int[3];
      arrayOfInt1[0] = 21;
      arrayOfInt1[1] = 12;
      arrayOfInt1[2] = 15;
      arrayOfInt1;
    } else {
      return null;
    } 
    int[] arrayOfInt4 = new int[2];
    arrayOfInt4[0] = 12;
    arrayOfInt4[1] = i - 12;
    PrintContent.a a = new PrintContent.a();
    c c = new c(a);
    g g = new g(a);
    g.setWidth(c.bp(RootApplication.zv()).aiL().getWidth());
    c.lk((new h(this.mContext)).kn(paramString3));
    g.f(CrashApplication.zv().getString(2131627867), 0, 1);
    a.ln(str);
    e.b(a, arrayOfInt4, arrayOfInt3, new String[] { CrashApplication.zv().getString(2131627434), paramString1 }, 0);
    e.b(a, arrayOfInt4, arrayOfInt3, new String[] { CrashApplication.zv().getString(2131627435), paramString2 }, 0);
    a.ln(str);
    g.f((String)((Map)this.dar.get(0)).get(dae), 0, 1);
    a.ln(str);
    e.b(a, arrayOfInt1, arrayOfInt2, new String[] { bzT, this.mContext.getString(2131627946), this.mContext.getString(2131627941) }, 0);
    a.ln(str);
    for (HashMap hashMap : this.dar) {
      paramString3 = n.pm((String)hashMap.get(dah));
      String str1 = n.pm((String)hashMap.get(dag));
      e.b(a, arrayOfInt1, arrayOfInt2, new String[] { (String)hashMap.get(bzT), str1, paramString3 }, 0);
    } 
    a.ln(str);
    paramString1 = n.b(this.mContext, Double.valueOf(this.daq[1]), true, true);
    paramString2 = dal;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.daq[0]);
    stringBuilder.append("");
    e.b(a, arrayOfInt1, arrayOfInt2, new String[] { paramString2, stringBuilder.toString(), paramString1 }, 0);
    a.ln(str);
    return a;
  }
  
  public void a(a parama, SQLiteDatabase paramSQLiteDatabase) {
    this.dar.clear();
    StringBuilder stringBuilder = new StringBuilder("select ");
    stringBuilder.append(" u.sUserName,u.sUserPhone,ifnull(count(distinct p.sOrderNo),0) orderNoCount");
    stringBuilder.append(",ifnull(sum(case when p.nStcokDirection=300002 then fReceived else -fReceived end),0) received,u._id, ");
    stringBuilder.append(" p.sOrderNo,strftime('%Y-%m-%d',date(p.nDatetime/1000,'unixepoch','localtime')) date,p.nSpareField2");
    stringBuilder.append(" from (select distinct u._id,u.sUserName,u.sUserPhone,u.nDateTime from t_user u where u._id=");
    stringBuilder.append(parama.das);
    stringBuilder.append(") u");
    stringBuilder.append(" left join  t_productdoc p  on u._id=p.sSpareField4 ");
    stringBuilder.append("and case when p.sSpareField4 is not null then ( ");
    if (parama.start > 0L || parama.end > 0L) {
      stringBuilder.append(" p.nDatetime>=");
      stringBuilder.append(parama.start);
      stringBuilder.append(" and p.nDatetime<=");
      stringBuilder.append(parama.end);
      stringBuilder.append(" and ");
    } 
    stringBuilder.append(" p.nProductTransacType in(100001,100015,100045,100060) and ");
    stringBuilder.append(" p.nShopID=");
    stringBuilder.append(parama.aSI);
    stringBuilder.append(" and (p.nDeletionFlag is null or p.nDeletionFlag<>1)");
    if (parama.aST != -1L) {
      stringBuilder.append(" and p.nSpareField2=");
      stringBuilder.append(parama.aST);
    } 
    stringBuilder.append(") else 1>0 end ");
    stringBuilder.append(" group by date ");
    stringBuilder.append(" order by date desc");
    null = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("queryPrintData SQL is:");
    stringBuilder.append(null);
    d.b(stringBuilder.toString(), new Object[0]);
    Cursor cursor = paramSQLiteDatabase.rawQuery(null, null);
    while (cursor.moveToNext()) {
      String str1 = cursor.getString(6);
      HashMap hashMap = new HashMap();
      hashMap.put(dae, cursor.getString(0));
      hashMap.put(daf, cursor.getString(1));
      String str2 = n.b(this.mContext, Integer.valueOf(cursor.getInt(2)), false, true);
      double[] arrayOfDouble1 = this.daq;
      arrayOfDouble1[0] = arrayOfDouble1[0] + by.parseDouble(str2);
      hashMap.put(dag, str2);
      double d = cursor.getDouble(3);
      String str3 = n.b(this.mContext, Double.valueOf(d), true, true);
      d = Double.valueOf(str3).doubleValue();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("getData customerPrice==");
      stringBuilder1.append(str3);
      stringBuilder1.append(" money=");
      stringBuilder1.append(d);
      n.println(stringBuilder1.toString());
      double[] arrayOfDouble2 = this.daq;
      arrayOfDouble2[1] = arrayOfDouble2[1] + d;
      hashMap.put(dah, str3);
      String str4 = bzT;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append("");
      hashMap.put(str4, stringBuilder2.toString());
      hashMap.put(dae, cursor.getString(0));
      hashMap.put(daj, str2);
      hashMap.put(dah, str3);
      hashMap.put(dag, str2);
      if (!"0".equals(str2))
        this.dar.add(hashMap); 
    } 
    cursor.close();
  }
  
  public void b(a parama, SQLiteDatabase paramSQLiteDatabase) {
    this.dar.clear();
    StringBuilder stringBuilder = new StringBuilder("select ");
    stringBuilder.append(" u.sUserName,u.sUserPhone,ifnull(count(distinct p.sOrderNo),0) orderNoCount");
    stringBuilder.append(",ifnull(sum(case when p.nStcokDirection=300002 then fReceived else -fReceived end),0) received,u._id, ");
    stringBuilder.append(" p.sOrderNo,strftime('%Y-%m-%d %H:%M:%S',datetime(p.nDatetime/1000,'unixepoch','localtime')) date,p.nSpareField2");
    stringBuilder.append(" from (select distinct u._id,u.sUserName,u.sUserPhone,u.nDateTime from t_user u where u._id=");
    stringBuilder.append(parama.das);
    stringBuilder.append(") u");
    stringBuilder.append(" left join  t_productdoc p  on u._id=p.sSpareField4 ");
    stringBuilder.append("and case when p.sSpareField4 is not null then ( ");
    if (parama.start > 0L || parama.end > 0L) {
      stringBuilder.append(" p.nDatetime>=");
      stringBuilder.append(parama.start);
      stringBuilder.append(" and p.nDatetime<=");
      stringBuilder.append(parama.end);
      stringBuilder.append(" and ");
    } 
    stringBuilder.append(" p.nProductTransacType in(100001,100015,100045,100060) and ");
    stringBuilder.append(" p.nShopID=");
    stringBuilder.append(parama.aSI);
    stringBuilder.append(" and (p.nDeletionFlag is null or p.nDeletionFlag<>1)");
    if (parama.aST != -1L) {
      stringBuilder.append(" and p.nSpareField2=");
      stringBuilder.append(parama.aST);
    } 
    stringBuilder.append(") else 1>0 end ");
    stringBuilder.append(" group by date ");
    stringBuilder.append(" order by date desc");
    null = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("queryExportData SQL is:");
    stringBuilder.append(null);
    d.b(stringBuilder.toString(), new Object[0]);
    Cursor cursor = paramSQLiteDatabase.rawQuery(null, null);
    while (cursor.moveToNext()) {
      HashMap hashMap = new HashMap();
      String str1 = cursor.getString(0);
      hashMap.put(dae, str1);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("getData body==");
      stringBuilder1.append(str1);
      n.println(stringBuilder1.toString());
      hashMap.put(daf, cursor.getString(1));
      str1 = n.b(this.mContext, Integer.valueOf(cursor.getInt(2)), false, true);
      double[] arrayOfDouble1 = this.daq;
      arrayOfDouble1[0] = arrayOfDouble1[0] + by.parseDouble(str1);
      hashMap.put(dag, str1);
      double d = cursor.getDouble(3);
      String str2 = n.b(this.mContext, Double.valueOf(d), true, true);
      d = Double.valueOf(str2).doubleValue();
      double[] arrayOfDouble2 = this.daq;
      arrayOfDouble2[1] = arrayOfDouble2[1] + d;
      hashMap.put(dah, str2);
      str2 = cursor.getString(6);
      String str3 = bzT;
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(str2);
      stringBuilder3.append("");
      hashMap.put(str3, stringBuilder3.toString());
      str2 = a.dg(cursor.getLong(7));
      hashMap.put(dak, str2);
      hashMap.put(daj, str1);
      str1 = cursor.getString(5);
      str2 = dai;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("");
      stringBuilder2.append(str1);
      hashMap.put(str2, stringBuilder2.toString());
      this.dar.add(hashMap);
    } 
    cursor.close();
  }
  
  public s r(Context paramContext, String paramString) {
    this.mContext = paramContext;
    ArrayList arrayList = new ArrayList();
    paramString = n.b(this.mContext, paramString, true, true);
    arrayList.add(new s.a(dah, paramString));
    paramString = dag;
    String str1 = dah;
    String str2 = bzT;
    String str3 = dae;
    String str4 = dak;
    String str5 = dai;
    String str6 = dah;
    this.dao = new s(this.mContext.getString(2131627867), this.mContext.getString(2131627867), null, arrayList, this.dar, null, new String[] { str2, str3, str4, str5, str6 }, new String[] { paramString, str1 });
    return this.dao;
  }
  
  static class a {
    public String aSI;
    
    public long aST;
    
    public String das;
    
    public long end;
    
    public long start;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */