package com.laiqian.report.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.format.Time;
import com.google.a.a.a.a.a.a;
import com.laiqian.auth.bc;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.v;
import com.laiqian.models.an;
import com.laiqian.print.b.c;
import com.laiqian.print.j;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.g;
import com.laiqian.print.util.e;
import com.laiqian.util.av;
import com.laiqian.util.n;
import com.laiqian.util.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class q extends u implements i, j {
  public static final String bzY;
  
  public static final String dbi = CrashApplication.zv().getString(2131627933);
  
  public static final String dbj = CrashApplication.zv().getString(2131627932);
  
  public static final String dbk = CrashApplication.zv().getString(2131627938);
  
  public static final String dbl = CrashApplication.zv().getString(2131627455);
  
  public static final String dbm = CrashApplication.zv().getString(2131627934);
  
  public static final String dbn = CrashApplication.zv().getString(2131627935);
  
  public static final String dbo;
  
  private long bSc;
  
  private int cZR = 0;
  
  private SQLiteDatabase cZS;
  
  ConcurrentHashMap<String, String> daQ;
  
  private long dbp;
  
  private t dbq;
  
  private long mStartTime;
  
  static  {
    bzY = CrashApplication.zv().getString(2131627930);
    dbo = CrashApplication.zv().getString(2131627931);
  }
  
  public q(Context paramContext) { super(paramContext); }
  
  private String a(t paramt, Map.Entry<String, String> paramEntry) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    if (this.cZR == 0 || this.cZR == 3) {
      stringBuilder2.append("select t_product._id id,t_product.sProductName name,t_product.sText as stext,ifnull(qtys,0) qty, ifnull(amounts,0) amount  from t_product left join(");
      stringBuilder2.append(a(paramEntry, "nProductID", "", paramt.ane(), paramt.anf(), paramt.ang()));
      stringBuilder2.append(" ) productdoc");
      stringBuilder2.append(" on t_product._id = productdoc.id where ");
      stringBuilder2.append(" (t_product.nProductStatus=600002 or t_product.nProductStatus=600001 ");
      stringBuilder2.append(" or qtys>0.000001 or qtys<0.0000001 or amounts>0.000001 or amounts<0.0000001)");
      if (this.cZR == 0) {
        stringBuilder2.append(" and t_product.nFoodCategory=0");
      } else {
        stringBuilder2.append(" and t_product.nFoodCategory=2");
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" and t_product.nShopID=");
      stringBuilder1.append(VC());
      stringBuilder2.append(stringBuilder1.toString());
      return stringBuilder2.toString();
    } 
    if (this.cZR == 1) {
      stringBuilder2.append("select t._id id,t.sFieldName name,ifnull(qtys,0) qty,ifnull(amounts,0) amount ");
      stringBuilder2.append(" from t_string t ");
      stringBuilder2.append(" left join(");
      stringBuilder2.append(a(paramEntry, "t_product.nProductType", " inner join t_product on t_product._id = t_productdoc.nProductID", stringBuilder1.ane(), stringBuilder1.anf(), stringBuilder1.ang()));
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(") productdoc on t._id = productdoc.id where t.nShopID=");
      stringBuilder1.append(VC());
      stringBuilder2.append(stringBuilder1.toString());
      stringBuilder2.append(" and t.nFieldType=5");
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" and t._id!=");
      stringBuilder1.append(VE());
      stringBuilder2.append(stringBuilder1.toString());
      stringBuilder2.append(" and (t.sIsActive is null or t.sIsActive='Y' ");
      stringBuilder2.append(" or qtys>0.000001 or qtys<0.0000001 or amounts>0.000001 or amounts<0.0000001)");
    } else {
      stringBuilder2.append("select t._id id,t.sFieldName name,ifnull(qtys,0) qty,ifnull(amounts,0) amount ");
      stringBuilder2.append(" from t_string t ");
      stringBuilder2.append(" left join(");
      stringBuilder2.append(a(paramEntry, "t_productdoc.nProductID", "", stringBuilder1.ane(), stringBuilder1.anf(), stringBuilder1.ang()));
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(") productdoc on t._id = productdoc.id where t.nShopID=");
      stringBuilder1.append(VC());
      stringBuilder2.append(stringBuilder1.toString());
      stringBuilder2.append(" and t.nFieldType=44");
      stringBuilder2.append(" and (t.sIsActive is null or t.sIsActive='Y'");
      stringBuilder2.append(" or qtys>0.000001 or qtys<0.0000001 or amounts>0.000001 or amounts<0.0000001)");
    } 
    return stringBuilder2.toString();
  }
  
  private String a(Map.Entry<String, String> paramEntry, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3) {
    String str2;
    String str1;
    StringBuilder stringBuilder3 = new StringBuilder("select ");
    stringBuilder3.append(paramString1);
    stringBuilder3.append(" id,");
    if (this.cZR == 2) {
      str2 = " nStcokDirection=300002 ";
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((String)paramEntry.getValue());
      stringBuilder.append(".t_productdoc.nProductTransacType =100044 ");
      str1 = stringBuilder.toString();
    } else {
      str2 = " nProductTransacType=100001 ";
      null = new StringBuilder();
      null.append((String)paramEntry.getValue());
      null.append(".t_productdoc.nProductTransacType in(100001,100015) ");
      str1 = null.toString();
    } 
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("sum(case when ");
    stringBuilder4.append(str2);
    stringBuilder4.append(" then nProductQty else -nProductQty end) qtys,");
    stringBuilder3.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("sum(case when ");
    stringBuilder4.append(str2);
    stringBuilder4.append(" then fAmount else -fAmount end) amounts ");
    stringBuilder3.append(stringBuilder4.toString());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("from ");
    stringBuilder2.append((String)paramEntry.getValue());
    stringBuilder2.append(".t_productdoc ");
    stringBuilder3.append(stringBuilder2.toString());
    stringBuilder3.append(paramString2);
    stringBuilder3.append(" where ");
    if (paramLong1 > 0L || paramLong2 > 0L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((String)paramEntry.getValue());
      stringBuilder.append(".t_productdoc.nDatetime>=");
      stringBuilder.append(paramLong1);
      stringBuilder.append(" and ");
      stringBuilder.append((String)paramEntry.getValue());
      stringBuilder.append(".t_productdoc.nDatetime<=");
      stringBuilder.append(paramLong2);
      stringBuilder.append(" and ");
      stringBuilder3.append(stringBuilder.toString());
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str1);
    stringBuilder1.append(" and ");
    stringBuilder1.append((String)paramEntry.getValue());
    stringBuilder1.append(".t_productdoc.nShopId=");
    stringBuilder1.append(VC());
    stringBuilder1.append(" and (");
    stringBuilder1.append((String)paramEntry.getValue());
    stringBuilder1.append(".t_productdoc.nDeletionFlag is null or ");
    stringBuilder1.append((String)paramEntry.getValue());
    stringBuilder1.append(".t_productdoc.nDeletionFlag<>1) ");
    stringBuilder3.append(stringBuilder1.toString());
    if (paramLong3 > 1L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" and ");
      stringBuilder.append((String)paramEntry.getValue());
      stringBuilder.append(".t_productdoc.nUserID = ");
      stringBuilder.append(paramLong3);
      stringBuilder3.append(stringBuilder.toString());
    } 
    stringBuilder3.append(" group by id");
    return stringBuilder3.toString();
  }
  
  private String b(double paramDouble1, double paramDouble2) {
    if (paramDouble1 == 0.0D || paramDouble2 == 0.0D) {
      String str1 = "0";
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append("%");
      return stringBuilder1.toString();
    } 
    String str = n.d(Double.valueOf(paramDouble1 * 100.0D / paramDouble2));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("%");
    return stringBuilder.toString();
  }
  
  private String getTypeName() { return (this.cZR == 0) ? dbi : ((this.cZR == 3) ? dbj : ((this.cZR == 1) ? dbk : dbl)); }
  
  private String yC() { return (this.cZR == 0) ? this.mContext.getString(2131627944) : ((this.cZR == 3) ? this.mContext.getString(2131627942) : ((this.cZR == 1) ? this.mContext.getString(2131627945) : this.mContext.getString(2131627943))); }
  
  protected double[] AW() {
    double[] arrayOfDouble = new double[4];
    try {
      stringBuilder = b.l(b.S(this.mStartTime), b.U(this.mStartTime), b.S(this.bSc), b.U(this.bSc));
    } catch (Exception exception) {
      a.e(exception);
      stringBuilder = null;
    } 
    Iterator iterator = stringBuilder.entrySet().iterator();
    null = "select sum(qty),sum(amount),sum(abs(qty)),sum(abs(amount)) from (";
    byte b = 0;
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      if (++b != stringBuilder.size()) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(null);
        stringBuilder2.append(a(this.dbq, entry));
        stringBuilder2.append(" union all ");
        null = stringBuilder2.toString();
        continue;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(null);
      stringBuilder1.append(a(this.dbq, entry));
      null = stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(null);
    stringBuilder.append(")");
    null = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("商品销售排行-1-》");
    stringBuilder.append(null);
    b.ct(stringBuilder.toString());
    Cursor cursor = this.cZS.rawQuery(null, null);
    if (cursor.moveToFirst()) {
      arrayOfDouble[0] = cursor.getDouble(0);
      arrayOfDouble[1] = cursor.getDouble(1);
      arrayOfDouble[2] = cursor.getDouble(2);
      arrayOfDouble[3] = cursor.getDouble(3);
    } 
    cursor.close();
    return arrayOfDouble;
  }
  
  @NonNull
  public String AX() { return (this.cZR == 0) ? this.mContext.getString(2131627857) : ((this.cZR == 3) ? this.mContext.getString(2131627855) : ((this.cZR == 1) ? this.mContext.getString(2131627858) : this.mContext.getString(2131627856))); }
  
  public PrintContent.a a(long paramLong1, long paramLong2, ArrayList<HashMap<String, String>> paramArrayList) {
    int k = p.asB();
    String str1 = n.ls(k);
    int[] arrayOfInt1 = new Time();
    arrayOfInt1.set(paramLong1);
    String str2 = arrayOfInt1.format(ann());
    arrayOfInt1.set(paramLong2);
    String str3 = arrayOfInt1.format(ann());
    String str4 = yC();
    String str5 = this.mContext.getString(2131627946);
    String str6 = this.mContext.getString(2131627941);
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
    an an = new an(this.mContext);
    c.lk((an.Vu()).aVs);
    an.close();
    c.lk(CrashApplication.zv().getString(2131627953));
    a.ln(str1);
    e.b(a, arrayOfInt4, arrayOfInt3, new String[] { CrashApplication.zv().getString(2131627434), str2 }, 0);
    e.b(a, arrayOfInt4, arrayOfInt3, new String[] { CrashApplication.zv().getString(2131627435), str3 }, 0);
    a.ln(str1);
    e.b(a, arrayOfInt1, arrayOfInt2, new String[] { str4, str5, str6 }, 0);
    a.ln(str1);
    for (HashMap hashMap : paramArrayList) {
      str3 = (String)hashMap.get(bzY);
      str4 = (String)hashMap.get(dbm);
      if (n.pl(str3) && n.pl(str4))
        continue; 
      e.b(a, arrayOfInt1, arrayOfInt2, new String[] { (String)hashMap.get("name"), str4, str3 }, 0);
    } 
    a.ln(str1);
    return a;
  }
  
  public String a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, v paramv, String paramString1, String paramString2) {
    try {
      String str1;
      ArrayList arrayList2 = new ArrayList();
      if (this.cZR == 0) {
        b(paramLong1, paramLong2, this.mContext.getString(2131627839));
        str1 = this.mContext.getString(2131627950);
      } else if (this.cZR == 3) {
        b(paramLong1, paramLong2, this.mContext.getString(2131627837));
        str1 = this.mContext.getString(2131627948);
      } else if (this.cZR == 1) {
        b(paramLong1, paramLong2, this.mContext.getString(2131627840));
        str1 = this.mContext.getString(2131627951);
      } else {
        b(paramLong1, paramLong2, this.mContext.getString(2131627838));
        str1 = this.mContext.getString(2131627949);
      } 
      arrayList2.add(new s.a(this.mContext.getString(2131627865), str1));
      arrayList2.add(new s.a(this.mContext.getString(2131627862), y(paramLong1, paramLong2)));
      ArrayList arrayList1 = new ArrayList();
      paramString1 = getTypeName();
      paramString2 = dbm;
      String str2 = dbn;
      String str3 = bzY;
      String str4 = dbo;
      String str5 = dbm;
      String str6 = bzY;
      return a(new s(this.mContext.getString(2131627871), this.mContext.getString(2131627871), arrayList2, arrayList1, paramArrayList, null, new String[] { paramString1, paramString2, str2, str3, str4 }, new String[] { str5, str6 }));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public void a(t paramt) {
    this.daq = null;
    this.dby = 0;
    this.mStartTime = paramt.ane();
    this.bSc = paramt.anf();
    this.dbp = paramt.ang();
    try {
      this.cZS = m(b.S(this.mStartTime), b.U(this.mStartTime), b.S(this.bSc), b.U(this.bSc));
      this.dbq = paramt;
      this.daQ = b.l(b.S(this.mStartTime), b.U(this.mStartTime), b.S(this.bSc), b.U(this.bSc));
      return;
    } catch (Exception paramt) {
      a.e(paramt);
      return;
    } 
  }
  
  public void amZ() {
    null = CrashApplication.getLaiqianPreferenceManager();
    long l1 = n.parseLong(null.atm());
    long l2 = null.atP();
    long l3 = System.currentTimeMillis();
    a((new t.a(l2, l3)).dh(l1).anl());
    nm(" order by amount desc ");
    null = new ArrayList();
    for (HashMap hashMap : anq()) {
      String str1 = (String)hashMap.get(bzY);
      String str2 = (String)hashMap.get(dbm);
      if (n.pl(str1) && n.pl(str2))
        continue; 
      null.add(new bc.a((String)hashMap.get("name"), str2, str1));
    } 
    bc = new bc(l2, l3, null);
    try {
      List list = j.cCx.a(bc, new String[] { "shift" });
      g.cGS.o(list);
      return;
    } catch (Exception bc) {
      a.e(bc);
      return;
    } 
  }
  
  public void jI(int paramInt) {
    super.jI(paramInt);
    this.cZR = paramInt;
  }
  
  public ArrayList<HashMap<String, String>> zJ() {
    String str1;
    ArrayList arrayList = new ArrayList();
    String str2 = ant();
    if (str2.length() == 0) {
      k = 1;
    } else {
      int k;
      k = 0;
    } 
    if (this.cZR == 0 || this.cZR == 3) {
      str1 = "select name,sum(qty) qty,sum(amount) amount,stext from (";
    } else {
      String str;
      str1 = "select name,sum(qty) qty,sum(amount) amount from (";
    } 
    Iterator iterator = this.daQ.entrySet().iterator();
    int m = 0;
    while (iterator.hasNext()) {
      null = (Map.Entry)iterator.next();
      m++;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append(a(this.dbq, null));
      String str = stringBuilder2.toString();
      str1 = str;
      if (k) {
        str1 = str;
        if (!ans()) {
          null = new StringBuilder();
          null.append(str);
          null.append(" and (qty!=0 or amount!=0)");
          str1 = null.toString();
        } 
      } 
      if (m != this.daQ.size()) {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str1);
        stringBuilder3.append(" union all ");
        str1 = stringBuilder3.toString();
        continue;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append("");
      str1 = stringBuilder1.toString();
    } 
    if (akB().contains("t_product.sText")) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append(") as T group by name order by stext");
      stringBuilder1.append(str2);
      str1 = stringBuilder1.toString();
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append(") as T group by name");
      stringBuilder1.append(akB());
      stringBuilder1.append(str2);
      str1 = stringBuilder1.toString();
    } 
    null = new StringBuilder();
    null.append("商品销售排行-2-》");
    null.append(str1);
    b.ct(null.toString());
    Cursor cursor = this.cZS.rawQuery(str1, null);
    long l1 = System.currentTimeMillis();
    m = cursor.getCount();
    long l2 = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("查询数据耗时：");
    stringBuilder.append(l2 - l1);
    n.println(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("查询的SQL语句：");
    stringBuilder.append(str1);
    n.println(stringBuilder.toString());
    if (!k) {
      boolean bool;
      if (m >= getPageSize()) {
        bool = true;
      } else {
        bool = false;
      } 
      gC(bool);
    } 
    double[] arrayOfDouble = amw();
    double d1 = arrayOfDouble[2];
    double d2 = arrayOfDouble[3];
    int k;
    for (k = 1; cursor.moveToNext(); k = m) {
      HashMap hashMap = new HashMap();
      m = k;
      if (k != 0)
        m = 0; 
      String str = cursor.getString(0);
      double d3 = cursor.getDouble(1);
      double d4 = cursor.getDouble(2);
      hashMap.put("name", str);
      hashMap.put(getTypeName(), str);
      str = dbm;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(d3);
      stringBuilder1.append("");
      hashMap.put(str, stringBuilder1.toString());
      hashMap.put(dbn, b(d3, d1));
      str = bzY;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(CrashApplication.zA());
      stringBuilder1.append(n.d(Double.valueOf(d4)));
      hashMap.put(str, stringBuilder1.toString());
      hashMap.put(dbo, b(d4, d2));
      arrayList.add(hashMap);
    } 
    cursor.close();
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */