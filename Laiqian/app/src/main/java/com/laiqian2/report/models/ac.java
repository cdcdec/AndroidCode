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
import com.laiqian.print.b.d;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.print.util.e;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ac extends u implements i, j {
  public static final String bHV = CrashApplication.zv().getString(2131627983);
  
  public static final String dcs = CrashApplication.zv().getString(2131627981);
  
  public static final String dct = CrashApplication.zv().getString(2131627982);
  
  private ConcurrentHashMap<String, String> bNh;
  
  private long bSc;
  
  private SQLiteDatabase cZS;
  
  private String dat;
  
  t dax;
  
  private long mStartTime;
  
  public ac(Context paramContext) {
    super(paramContext);
    gC(false);
    this.daq = new double[2];
  }
  
  private String c(t paramt, Map.Entry<String, String> paramEntry) {
    StringBuilder stringBuilder1 = new StringBuilder("select ");
    stringBuilder1.append("t_tax.sName  as taxName ,t_tax.fValue as taxValue,amountOfProduct as productAmount,amountOfTax  as taxAmount");
    stringBuilder1.append(" from t_tax ");
    stringBuilder1.append(" left join (select nProductID");
    stringBuilder1.append(",sum(case when nStcokDirection=300002 then fSpareField4 else -fSpareField4 end) amountOfProduct");
    stringBuilder1.append(",sum(case when nStcokDirection=300002 then fAmount else -fAmount end) amountOfTax ");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(" from ");
    stringBuilder2.append((String)paramEntry.getValue());
    stringBuilder2.append(".t_productdoc where nProductTransacType=100060 ");
    stringBuilder1.append(stringBuilder2.toString());
    if (paramt.ane() > 0L || paramt.anf() > 0L) {
      stringBuilder1.append(" and nDatetime>=");
      stringBuilder1.append(paramt.ane());
      stringBuilder1.append(" and nDatetime<=");
      stringBuilder1.append(paramt.anf());
    } 
    if (paramt.ang() > 1L) {
      stringBuilder1.append(" and nUserID=");
      stringBuilder1.append(paramt.ang());
    } 
    stringBuilder1.append(" and (nDeletionFlag is null or nDeletionFlag<>1)");
    stringBuilder1.append(" and nShopID=");
    stringBuilder1.append(VC());
    stringBuilder1.append(" group by nProductID) doc on doc.nProductID=t_tax._id");
    stringBuilder1.append(" where nSHopID=");
    stringBuilder1.append(VC());
    stringBuilder1.append(" and (sIsActive='Y' or amountOfTax<-0.000001 or amountOfTax>0.000001 or amountOfProduct<-0.000001 or amountOfProduct>0.000001) ");
    String str = stringBuilder1.toString();
    this.dat = str;
    return str;
  }
  
  protected double[] AW() { return new double[2]; }
  
  @NonNull
  public String AX() { return this.mContext.getString(2131627980); }
  
  public PrintContent.a a(long paramLong1, long paramLong2, ArrayList<HashMap<String, String>> paramArrayList) {
    PrintContent.a a = new PrintContent.a();
    d d = new d(a);
    d.lk(this.mContext.getString(2131627980));
    d.l('-');
    d.setWidth(a.bo(CrashApplication.zv()).aiL().getWidth());
    int m = e.jg(d.getWidth());
    int k = (int)(m * 0.35D);
    m -= k;
    d.n(new int[] { k, m });
    d.n(new int[] { k, k, m - k });
    Time time = new Time();
    time.set(paramLong1);
    String str1 = time.format(ann());
    time.set(paramLong2);
    String str2 = time.format(ann());
    d.x(new String[] { this.mContext.getString(2131627434), str1 });
    d.x(new String[] { this.mContext.getString(2131627435), str2 });
    d.l('-');
    d.x(new String[] { this.mContext.getString(2131627983), this.mContext.getString(2131627981), this.mContext.getString(2131627982) });
    for (HashMap hashMap : paramArrayList) {
      d.x(new String[] { (String)hashMap.get(bHV), n.pm((String)hashMap.get(dcs)), n.pm((String)hashMap.get(dct)) });
    } 
    d.l('-');
    d.setSize(0);
    d.x(new String[] { this.mContext.getString(2131627984), n.ba(this.daq[1]) });
    return a;
  }
  
  public String a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, v paramv, String paramString1, String paramString2) {
    try {
      ArrayList arrayList1 = new ArrayList();
      b(paramLong1, paramLong2, this.mContext.getString(2131627980));
      arrayList1.add(new s.a(this.mContext.getString(2131627862), y(paramLong1, paramLong2)));
      arrayList1.add(new s.a(this.mContext.getString(2131627864), paramString1));
      ArrayList arrayList2 = new ArrayList();
      arrayList2.add(new s.a(this.mContext.getString(2131627829), n.a(this.mContext, Double.valueOf(this.daq[1]), true, true)));
      paramString1 = bHV;
      paramString2 = dcs;
      String str1 = dct;
      String str2 = dcs;
      String str3 = dct;
      return a(new s(this.mContext.getString(2131627980), this.mContext.getString(2131627980), arrayList1, arrayList2, paramArrayList, null, new String[] { paramString1, paramString2, str1 }, new String[] { str2, str3 }));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public void a(t paramt) {
    this.mStartTime = paramt.ane();
    this.bSc = paramt.anf();
    try {
      this.cZS = r(this.mStartTime, this.bSc);
      this.bNh = b.f(this.mStartTime, this.bSc);
    } catch (Exception exception) {
      a.e(exception);
    } 
    this.dax = paramt;
  }
  
  public ArrayList<HashMap<String, String>> zJ() {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = this.bNh.entrySet().iterator();
    str2 = "select  taxName,  taxValue,  sum(productAmount),  sum(taxAmount) taxAmount from(";
    byte b = 0;
    while (iterator.hasNext()) {
      null = (Map.Entry)iterator.next();
      byte b1 = b + true;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append(c(this.dax, null));
      String str1 = stringBuilder.toString();
      b = b1;
      str2 = str1;
      if (b1 != this.bNh.size()) {
        String str2;
        null = new StringBuilder();
        null.append(str1);
        null.append(" union all ");
        str2 = null.toString();
        b = b1;
      } 
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str2);
    stringBuilder1.append(") as T  group by taxName order by taxAmount desc");
    String str = stringBuilder1.toString();
    Cursor cursor = Vq().rawQuery(str, null);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("查询的SQL：");
    stringBuilder2.append(str);
    n.println(stringBuilder2.toString());
    double d = 0.0D;
    while (cursor.moveToNext()) {
      HashMap hashMap = new HashMap();
      String str1 = bHV;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(cursor.getString(0));
      stringBuilder.append("=");
      stringBuilder.append(cursor.getDouble(1));
      stringBuilder.append("%");
      hashMap.put(str1, stringBuilder.toString());
      hashMap.put(dcs, n.a(Double.valueOf(cursor.getDouble(2)), true, true));
      double d1 = cursor.getDouble(3);
      d += d1;
      hashMap.put(dct, n.a(Double.valueOf(d1), true, true));
      arrayList.add(hashMap);
    } 
    cursor.close();
    this.daq[0] = 0.0D;
    this.daq[1] = d;
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */