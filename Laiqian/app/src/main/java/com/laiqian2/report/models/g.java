package com.laiqian.report.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.format.Time;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.v;
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
import com.laiqian.util.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class g extends u implements i, j {
  public static final String bzT = CrashApplication.zv().getString(2131627903);
  
  public static final String dae = CrashApplication.zv().getString(2131627825);
  
  public static final String daf = CrashApplication.zv().getString(2131627898);
  
  public static final String dag = CrashApplication.zv().getString(2131627906);
  
  public static final String dah = CrashApplication.zv().getString(2131628041);
  
  public static final String dai = CrashApplication.zv().getString(2131627907);
  
  public static final String daj = CrashApplication.zv().getString(2131627904);
  
  public static final String dak = CrashApplication.zv().getString(2131627905);
  
  public static final String dal = CrashApplication.zv().getString(2131628018);
  
  ArrayList<HashMap<String, String>> dar = new ArrayList();
  
  private String dat;
  
  public long dau = 5L;
  
  public final long dav = -1L;
  
  public long daw = -1L;
  
  t dax;
  
  StringBuilder daz;
  
  public g(Context paramContext) { super(paramContext); }
  
  @NonNull
  private StringBuilder b(t paramt) {
    StringBuilder stringBuilder = new StringBuilder("select ");
    stringBuilder.append(" u.sUserName,u.sUserPhone,ifnull(count(distinct p.sOrderNo),0) orderNoCount");
    stringBuilder.append(",ifnull(sum(case when p.nStcokDirection=300002 then fReceived else -fReceived end),0) received,u._id, ");
    stringBuilder.append(" p.sOrderNo,p.nDateTime,p.nSpareField2");
    stringBuilder.append(" from (select distinct u._id,u.sUserName,u.sUserPhone,u.nDateTime from t_user u where u._id=");
    stringBuilder.append(this.daw);
    stringBuilder.append(") u");
    stringBuilder.append(" left join  t_productdoc p  on u._id=p.sSpareField4 ");
    stringBuilder.append("and case when p.sSpareField4 is not null then ( ");
    if (paramt.ane() > 0L || paramt.anf() > 0L) {
      stringBuilder.append(" p.nDatetime>=");
      stringBuilder.append(paramt.ane());
      stringBuilder.append(" and p.nDatetime<=");
      stringBuilder.append(paramt.anf());
      stringBuilder.append(" and ");
    } 
    stringBuilder.append(" p.nProductTransacType in(100001,100015,100045,100060) and ");
    stringBuilder.append(" p.nShopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" and (p.nDeletionFlag is null or p.nDeletionFlag<>1)");
    if (this.dau != -1L) {
      stringBuilder.append(" and p.nSpareField2=");
      stringBuilder.append(this.dau);
    } 
    stringBuilder.append(") else 1>0 end ");
    stringBuilder.append(" group by u._id ");
    stringBuilder.append(" order by received desc,orderNoCount desc,u.nDateTime asc ");
    return stringBuilder;
  }
  
  @NonNull
  private StringBuilder c(t paramt) {
    StringBuilder stringBuilder = new StringBuilder("select ");
    stringBuilder.append(" u.sUserName,u.sUserPhone,ifnull(count(distinct p.sOrderNo),0) orderNoCount");
    stringBuilder.append(",ifnull(sum(case when p.nStcokDirection=300002 then fReceived else -fReceived end),0) received,u._id, ");
    stringBuilder.append(" p.sOrderNo,p.nDateTime,p.nSpareField2");
    stringBuilder.append(" from (select distinct u._id,u.sUserName,u.sUserPhone,u.nDateTime from t_user u left join t_role r on u._id=r.nUserid where u.nShopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" and (u.nUserRole==150001 or (u.nDeletionFlag = 170002 and r.sRoleName=90022 and r.sIsActive='Y'))) u ");
    stringBuilder.append(" left join  t_productdoc p  on u._id=p.sSpareField4 ");
    stringBuilder.append("and case when p.sSpareField4 is not null then ( ");
    if (paramt.ane() > 0L || paramt.anf() > 0L) {
      stringBuilder.append(" p.nDatetime>=");
      stringBuilder.append(paramt.ane());
      stringBuilder.append(" and p.nDatetime<=");
      stringBuilder.append(paramt.anf());
      stringBuilder.append(" and ");
    } 
    stringBuilder.append(" p.nProductTransacType in(100001,100015,100045,100060) and ");
    stringBuilder.append(" p.nShopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" and (p.nDeletionFlag is null or p.nDeletionFlag<>1)");
    if (this.dau > -1L) {
      stringBuilder.append(" and p.nSpareField2=");
      stringBuilder.append(this.dau);
    } 
    stringBuilder.append(") else 1>0 end ");
    stringBuilder.append(" group by u._id ");
    stringBuilder.append(" order by received desc,orderNoCount desc,u.nDateTime asc ");
    return stringBuilder;
  }
  
  protected double[] AW() { return this.daq; }
  
  @NonNull
  public String AX() { return this.mContext.getString(2131627853); }
  
  public PrintContent.a a(long paramLong1, long paramLong2, ArrayList<HashMap<String, String>> paramArrayList) {
    int k = p.asB();
    String str3 = n.ls(k);
    int[] arrayOfInt1 = new Time();
    arrayOfInt1.set(paramLong1);
    String str1 = arrayOfInt1.format(ann());
    arrayOfInt1.set(paramLong2);
    String str2 = arrayOfInt1.format(ann());
    int[] arrayOfInt2 = new int[3];
    arrayOfInt2[0] = 0;
    arrayOfInt2[1] = 2;
    arrayOfInt2[2] = 2;
    arrayOfInt2;
    int[] arrayOfInt3 = new int[2];
    arrayOfInt3[0] = 0;
    arrayOfInt3[1] = 2;
    arrayOfInt3;
    if (k == 32) {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = 14;
      arrayOfInt[1] = 8;
      arrayOfInt[2] = 10;
      arrayOfInt;
    } else if (k == 48) {
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
    arrayOfInt4[1] = k - 12;
    PrintContent.a a = new PrintContent.a();
    c c = new c(a);
    g g1 = new g(a);
    g1.setWidth(c.bp(RootApplication.zv()).aiL().getWidth());
    c.lk((new h(this.mContext)).kn(VC()));
    g1.f(CrashApplication.zv().getString(2131627867), 0, 1);
    a.ln(str3);
    e.b(a, arrayOfInt4, arrayOfInt3, new String[] { CrashApplication.zv().getString(2131627434), str1 }, 0);
    e.b(a, arrayOfInt4, arrayOfInt3, new String[] { CrashApplication.zv().getString(2131627435), str2 }, 0);
    a.ln(str3);
    if (this.dar != null && this.dar.size() != 0) {
      null = (Map)this.dar.get(0);
      str2 = (String)null.get(bzT);
      String str = (String)null.get("longDate");
      Time time = new Time();
      time.set(Long.valueOf(str).longValue());
      e.b(a, arrayOfInt4, arrayOfInt3, new String[] { str2, jL(time.weekDay) }, 0);
      a.ln(str3);
      e.b(a, arrayOfInt1, arrayOfInt2, new String[] { dae, this.mContext.getString(2131627946), this.mContext.getString(2131627941) }, 0);
      a.ln(str3);
      Iterator iterator = this.dar.iterator();
      k = 0;
      while (iterator.hasNext()) {
        HashMap hashMap = (HashMap)iterator.next();
        str = str2;
        if (k != 0) {
          String str5 = (String)hashMap.get(bzT);
          str = str2;
          if (!str2.equals(str5)) {
            str = (String)hashMap.get("longDate");
            Time time1 = new Time();
            time1.set(Long.valueOf(str).longValue());
            e.b(a, arrayOfInt4, arrayOfInt3, new String[] { str5, jL(time1.weekDay) }, 0);
            str = str5;
          } 
        } 
        str2 = n.pm((String)hashMap.get(dah));
        String str4 = n.pm((String)hashMap.get(dag));
        e.b(a, arrayOfInt1, arrayOfInt2, new String[] { (String)hashMap.get(dae), str4, str2 }, 0);
        k++;
        str2 = str;
      } 
      a.ln(str3);
      double d = this.daq[1];
      str = dal;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.daq[0]);
      stringBuilder.append("");
      e.b(a, arrayOfInt1, arrayOfInt2, new String[] { str, (new String[3][1] = stringBuilder.toString()).valueOf(d) }, 0);
      a.ln(str3);
      return a;
    } 
    return new PrintContent.a();
  }
  
  public String a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, v paramv, String paramString1, String paramString2) {
    try {
      b(paramLong1, paramLong2, this.mContext.getString(2131627867));
      paramArrayList = new ArrayList<HashMap<String, String>>();
      String str1 = dah;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.daq[1]);
      stringBuilder.append("");
      paramArrayList.add(new s.a(str1, stringBuilder.toString()));
      str1 = dag;
      String str2 = dah;
      paramString1 = bzT;
      paramString2 = dae;
      String str3 = daj;
      String str4 = dak;
      String str5 = dah;
      return a(new s(this.mContext.getString(2131627867), this.mContext.getString(2131627867), null, paramArrayList, this.dar, null, new String[] { paramString1, paramString2, str3, str4, str5 }, new String[] { str1, str2 }));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public void a(t paramt) {
    StringBuilder stringBuilder;
    this.daq = new double[2];
    this.dby = 0;
    this.daz = new StringBuilder();
    this.dax = paramt;
    if (this.daw != -1L) {
      stringBuilder = b(paramt);
    } else {
      stringBuilder = c(stringBuilder);
    } 
    this.dat = stringBuilder.toString();
  }
  
  public ArrayList<HashMap<String, String>> zJ() {
    ArrayList arrayList = new ArrayList();
    this.dar.clear();
    try {
      boolean bool;
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
      this.daq = new double[2];
      while (cursor.moveToNext()) {
        HashMap hashMap = new HashMap();
        hashMap.put(dae, cursor.getString(0));
        hashMap.put(daf, cursor.getString(1));
        String str1 = n.b(this.mContext, Integer.valueOf(cursor.getInt(2)), false, true);
        double[] arrayOfDouble = this.daq;
        arrayOfDouble[0] = arrayOfDouble[0] + by.parseDouble(str1);
        this.daq[0] = Double.parseDouble(n.a(Double.valueOf(this.daq[0]), true, false, RootApplication.aIS));
        hashMap.put(dag, str1);
        double d = cursor.getDouble(3);
        String str2 = n.b(this.mContext, Double.valueOf(d), true, true);
        d = Double.valueOf(str2).doubleValue();
        null = new StringBuilder();
        null.append("getData customerPrice==");
        null.append(str2);
        null.append(" money=");
        null.append(d);
        n.println(null.toString());
        null = this.daq;
        null[1] = null[1] + d;
        this.daq[1] = Double.parseDouble(n.a(Double.valueOf(this.daq[1]), true, false, RootApplication.aIS));
        null = new StringBuilder();
        null.append("getData dTopSumValue==");
        null.append(this.daq[1]);
        n.println(null.toString());
        hashMap.put(dah, str2);
        hashMap.put("userID", cursor.getString(4));
        arrayList.add(hashMap);
        hashMap = new HashMap();
        long l = cursor.getLong(6);
        null = z.b(l, "dd-MM-yyyy");
        String str4 = bzT;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(null);
        stringBuilder1.append("");
        hashMap.put(str4, stringBuilder1.toString());
        null = new StringBuilder();
        null.append(l);
        null.append("");
        hashMap.put("longDate", null.toString());
        hashMap.put(dae, cursor.getString(0));
        hashMap.put(daj, str1);
        String str3 = a.dg(cursor.getLong(7));
        if (this.dau != -1L) {
          hashMap.put(dak, str3);
        } else {
          hashMap.put(dak, "All");
        } 
        if (this.daw != -1L)
          hashMap.put(dai, cursor.getString(5)); 
        hashMap.put(dah, str2);
        hashMap.put(dag, str1);
        if (!"0".equals(str1))
          this.dar.add(hashMap); 
      } 
      cursor.close();
      return arrayList;
    } catch (Exception exception) {
      a.e(exception);
      return arrayList;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */