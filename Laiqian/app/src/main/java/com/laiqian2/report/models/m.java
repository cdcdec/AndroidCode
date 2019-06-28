package com.laiqian.report.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.format.Time;
import com.google.a.a.a.a.a.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.v;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class m extends u implements i {
  public static final String daN = getApplication().getString(2131627926);
  
  private SQLiteDatabase aNE;
  
  private ConcurrentHashMap<String, String> bNh;
  
  private Time daC = new Time();
  
  private int daK;
  
  private int daL;
  
  private String[] daM;
  
  private String daO;
  
  private String dat = "";
  
  public m(Context paramContext) {
    super(paramContext);
    this.daC.setToNow();
    this.daO = paramContext.getString(2131627925);
  }
  
  private void e(StringBuilder paramStringBuilder) {
    int n = this.daK;
    int j = this.daL;
    int k = j;
    if (n >= j)
      k = j + 24; 
    byte b = 0;
    for (j = n; b < k - n; j++) {
      int i1;
      if (j >= 24) {
        i1 = j - 24;
      } else {
        i1 = j;
      } 
      paramStringBuilder.append(",sum((h=");
      paramStringBuilder.append(i1);
      paramStringBuilder.append(")*qty) hour");
      paramStringBuilder.append(i1);
      b++;
    } 
  }
  
  protected double[] AW() { return new double[0]; }
  
  @NonNull
  public String AX() { return this.mContext.getString(2131627923); }
  
  public String a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, v paramv, String paramString1, String paramString2) {
    try {
      b(paramLong1, paramLong2, this.mContext.getString(2131627923));
      ArrayList arrayList = new ArrayList();
      arrayList.add(new s.a(this.mContext.getString(2131627862), y(paramLong1, paramLong2)));
      StringBuilder stringBuilder = new StringBuilder();
      if (this.daK < 10)
        stringBuilder.append("0"); 
      stringBuilder.append(this.daK);
      stringBuilder.append(":00-");
      if (this.daL < 10)
        stringBuilder.append("0"); 
      stringBuilder.append(this.daL);
      stringBuilder.append(":00");
      arrayList.add(new s.a(this.mContext.getString(2131627924), stringBuilder.toString()));
      int j = this.daM.length + 1;
      String[] arrayOfString = new String[j];
      arrayOfString[0] = daN;
      System.arraycopy(this.daM, 0, arrayOfString, 1, j - 1);
      return a(new s(this.mContext.getString(2131627923), this.mContext.getString(2131627923), arrayList, null, paramArrayList, null, arrayOfString, this.daM));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public void a(t paramt) {
    int i1 = 0;
    this.dby = 0;
    long l1 = paramt.ane();
    long l2 = paramt.anf();
    try {
      this.bNh = b.f(l1, l2);
      this.aNE = r(l1, l2);
    } catch (Exception exception) {
      a.e(exception);
    } 
    this.dat = "";
    null = new StringBuilder();
    int k = this.daK;
    int n = this.daL;
    int j = n;
    if (k >= n)
      j = n + 24; 
    int i2 = j - k;
    this.daM = new String[i2];
    j = k;
    k = 0;
    while (k < i2) {
      if (j >= 24) {
        n = j - 24;
      } else {
        n = j;
      } 
      null.append(",sum(hour");
      null.append(n);
      null.append(") hour");
      null.append(n);
      String[] arrayOfString = this.daM;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(n);
      stringBuilder.append(this.daO);
      arrayOfString[k] = stringBuilder.toString();
      k++;
      j++;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.dat);
    stringBuilder2.append("select productName,nProductID,sum(sum_qty) sum_qty ");
    stringBuilder2.append(null.toString());
    stringBuilder2.append(" from(");
    this.dat = stringBuilder2.toString();
    Iterator iterator = this.bNh.entrySet().iterator();
    j = i1;
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      k = j + 1;
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("select t_product.sProductName productName,doc.* from t_product ");
      stringBuilder2.append("left join (");
      stringBuilder2.append("select nProductID,sum(qty) sum_qty");
      e(stringBuilder2);
      stringBuilder2.append(" from (select nProductID,");
      stringBuilder2.append("case when nProductTransacType=100001 then nProductQty else -nProductQty end qty,");
      stringBuilder2.append("(nDateTime+");
      stringBuilder2.append(this.daC.gmtoff * 1000L);
      stringBuilder2.append(")/3600000%24 h ");
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append("from ");
      stringBuilder4.append((String)entry.getValue());
      stringBuilder4.append(".t_productdoc ");
      stringBuilder2.append(stringBuilder4.toString());
      stringBuilder2.append("where nDateTime>=");
      stringBuilder2.append(paramt.ane());
      stringBuilder2.append(" and nDateTime<");
      stringBuilder2.append(paramt.anf());
      stringBuilder2.append(" and nShopID=");
      stringBuilder2.append(VC());
      stringBuilder2.append(" and (nDeletionFlag is null or nDeletionFlag!=1) and nSpareField3 in(0,3)) ");
      if (this.daK != this.daL) {
        stringBuilder2.append("where (h>=");
        stringBuilder2.append(this.daK);
        if (this.daK < this.daL) {
          stringBuilder2.append(" and ");
        } else {
          stringBuilder2.append(" or ");
        } 
        stringBuilder2.append("h<");
        stringBuilder2.append(this.daL);
        stringBuilder2.append(") ");
      } 
      stringBuilder2.append("group by nProductID) doc on doc.nProductID=t_product._id ");
      stringBuilder2.append("where t_product.nFoodCategory=0 ");
      stringBuilder2.append("and (doc.sum_qty>0.000001 or doc.sum_qty<-0.000001)");
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(this.dat);
      stringBuilder3.append(stringBuilder2.toString());
      this.dat = stringBuilder3.toString();
      j = k;
      if (k != this.bNh.size()) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.dat);
        stringBuilder2.append(" union all ");
        this.dat = stringBuilder2.toString();
        j = k;
      } 
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.dat);
    stringBuilder1.append(") T group by nProductID order by T.sum_qty desc ");
    this.dat = stringBuilder1.toString();
  }
  
  public String[] amJ() { return this.daM; }
  
  public void bx(int paramInt1, int paramInt2) {
    this.daK = paramInt1;
    this.daL = paramInt2;
  }
  
  public ArrayList<HashMap<String, String>> zJ() {
    byte b;
    ArrayList arrayList = new ArrayList();
    String str = ant();
    if (str.length() == 0) {
      b = 1;
    } else {
      b = 0;
    } 
    null = this.aNE;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.dat);
    stringBuilder.append(str);
    Cursor cursor = null.rawQuery(stringBuilder.toString(), null);
    stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("查询的SQL：");
    stringBuilder.append(this.dat);
    stringBuilder.append(str);
    n.println(stringBuilder.toString());
    if (!b) {
      boolean bool;
      if (cursor.getCount() >= getPageSize()) {
        bool = true;
      } else {
        bool = false;
      } 
      gC(bool);
    } 
    while (cursor.moveToNext()) {
      HashMap hashMap = new HashMap();
      hashMap.put(daN, cursor.getString(0));
      for (b = 0; b < this.daM.length; b++) {
        double d = cursor.getDouble(b + 3);
        hashMap.put(this.daM[b], n.a(Double.valueOf(d), false, true));
      } 
      arrayList.add(hashMap);
    } 
    cursor.close();
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */