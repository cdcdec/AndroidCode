package com.laiqian.report.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Size;
import android.text.format.Time;
import com.google.a.a.a.a.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.print.b.d;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.print.util.e;
import com.laiqian.util.n;
import com.laiqian.util.t;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class h extends u implements j {
  public static final String bzT = CrashApplication.zv().getString(2131628022);
  
  public static final String bzY;
  
  public static final String daB;
  
  public static final String dam = CrashApplication.zv().getString(2131628037);
  
  public static final String dan = CrashApplication.zv().getString(2131628033);
  
  private final String aIR = ",,";
  
  private String aJZ;
  
  private ConcurrentHashMap<String, String> bNh;
  
  private long bSc;
  
  private SQLiteDatabase cZS;
  
  private String daA;
  
  private long mStartTime;
  
  static  {
    daB = CrashApplication.zv().getString(2131628032);
    bzY = CrashApplication.zv().getString(2131628020);
  }
  
  public h(Context paramContext) { super(paramContext); }
  
  private Cursor amH() {
    null = this.bNh.entrySet();
    String str = "select orderNo,sum(amount),dateTime from(";
    Iterator iterator = null.iterator();
    byte b = 0;
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      b++;
      StringBuilder stringBuilder1 = new StringBuilder();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("select sOrderNo orderNo,sum((case when nStcokDirection=300002 then ");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc.fSpareField3 else -");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc.fSpareField3 end)/(case when ");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc.nProductTransacType in(100001,100015) then ((case when ");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc.fSpareField1>0 then ");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc.fSpareField1 else 1 end)/((case when ");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc.fAmount>0 then ");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc.fAmount/");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc.nProductQty else 1 end)/");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc.fDiscount*100)) else 1 end)) amount ,");
      stringBuilder1.append(stringBuilder3.toString());
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append("nDateTime dateTime from ");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc where ");
      stringBuilder1.append(stringBuilder3.toString());
      stringBuilder1.append(this.aJZ);
      stringBuilder1.append(" group by sOrderNo having (amount > 0.000001 or amount < -0.000001)");
      if (b != this.bNh.size()) {
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(str);
        stringBuilder4.append(stringBuilder1.toString());
        stringBuilder4.append(" union all ");
        str = stringBuilder4.toString();
        continue;
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str);
      stringBuilder2.append(stringBuilder1.toString());
      str = stringBuilder2.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(")  as T group by orderNo order by dateTime desc ");
    stringBuilder.append(ant());
    str = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("getOrderCursor查询前50个单据号的SQL语句：");
    stringBuilder.append(str);
    n.println(stringBuilder.toString());
    return this.cZS.rawQuery(str, null);
  }
  
  private String d(t paramt) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(" nProductTransacType in(100001,100015,100045)");
    if (paramt.ane() > 0L || paramt.anf() > 0L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" and nDateTime >= ");
      stringBuilder.append(paramt.ane());
      stringBuilder.append(" and nDateTime <= ");
      stringBuilder.append(paramt.anf());
      stringBuilder2.append(stringBuilder.toString());
    } 
    if (paramt.ang() > 1L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" and nUserID = ");
      stringBuilder.append(paramt.ang());
      stringBuilder2.append(stringBuilder.toString());
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" and nSHopID = ");
    stringBuilder1.append(VC());
    stringBuilder2.append(stringBuilder1.toString());
    stringBuilder2.append(" and (nDeletionFlag is null or nDeletionFlag != 1) ");
    stringBuilder2.append(" and (fSpareField3 > 0.000001 or fSpareField3 < -0.000001) ");
    String str = stringBuilder2.toString();
    this.aJZ = str;
    return str;
  }
  
  private String[] nh(String paramString) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(anm());
    try {
      long l = simpleDateFormat.parse(paramString).getTime();
      Iterator iterator = this.bNh.entrySet().iterator();
      paramString = "select sum(amount) ,count(orderNo) from(";
      byte b = 0;
      while (iterator.hasNext()) {
        null = (Map.Entry)iterator.next();
        byte b1 = b + true;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append("select sum((case when nStcokDirection=300002 then ");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc.fSpareField3 else -");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc.fSpareField3 end)/(case when ");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc.nProductTransacType in(100001,100015) then ((case when ");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc.fSpareField1>0 then ");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc.fSpareField1 else 1 end)/((case when ");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc.fAmount>0 then ");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc.fAmount/");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc.nProductQty else 1 end)/");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc.fDiscount*100)) else 1 end)) amount ,count(distinct sOrderNo) orderNo from ");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc where ");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc.nDateTime>=");
        stringBuilder1.append(l);
        stringBuilder1.append(" and ");
        stringBuilder1.append((String)null.getValue());
        stringBuilder1.append(".t_productdoc.nDateTime<=");
        stringBuilder1.append(l + 86399999L);
        stringBuilder1.append(" and ");
        stringBuilder1.append(this.aJZ);
        String str = stringBuilder1.toString();
        b = b1;
        paramString = str;
        if (b1 != this.bNh.size()) {
          null = new StringBuilder();
          null.append(str);
          null.append(" union all ");
          str1 = null.toString();
          b = b1;
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(")");
      String str1 = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append("queryAmountByOneDay手动查询该天总金额的SQL语句:");
      stringBuilder.append(str1);
      n.println(stringBuilder.toString());
      Cursor cursor = this.cZS.rawQuery(str1, null);
      l = System.currentTimeMillis();
      cursor.moveToFirst();
      stringBuilder = new StringBuilder();
      stringBuilder.append("手动查询该天总金额的SQL语句的时间:");
      stringBuilder.append(System.currentTimeMillis() - l);
      n.println(stringBuilder.toString());
      String str2 = n.a(Double.valueOf(cursor.getDouble(0)), true, false, 2);
      String str3 = n.d(Integer.valueOf(cursor.getInt(1)));
      cursor.close();
      return new String[] { str2, str3 };
    } catch (ParseException paramString) {
      a.e(paramString);
      return new String[] { "0", "0" };
    } 
  }
  
  private Cursor ni(String paramString) {
    String str3 = VC();
    null = this.bNh.entrySet();
    String str2 = "select orderNo,productNames,qtys,sum(amount),dateTime,productTransacTypes,filed,sum(sumfiled),sum(sumreceived) from(";
    Iterator iterator = null.iterator();
    byte b = 0;
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      b++;
      StringBuilder stringBuilder3 = new StringBuilder();
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append("select ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.sOrderNo as orderNo");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(",group_concat(ifnull(t_product.sProductName,");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.sProductName),'");
      stringBuilder5.append(",,");
      stringBuilder5.append("') productNames");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(",group_concat(");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nProductQty,'");
      stringBuilder5.append(",,");
      stringBuilder5.append("') qtys");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(",sum((case when nStcokDirection=300002 then ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.fSpareField3 else -");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.fSpareField3 end)/(case when ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nProductTransacType in(100001,100015) then ((case when ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.fSpareField1>0 then ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.fSpareField1 else 1 end)/((case when ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.fAmount>0 then ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.fAmount/");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nProductQty else 1 end)/");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.fDiscount*100)) else 1 end)) amount ,");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nDateTime dateTime");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(",group_concat(");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nProductTransacType,'");
      stringBuilder5.append(",,");
      stringBuilder5.append("') productTransacTypes");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(",ifnull(");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nSpareField2,0) filed");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(", sum(ifnull(");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nSpareField4,0)) sumfiled");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(", sum(");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.fReceived) sumreceived");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" from ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc left join t_product on t_product.nShopID=");
      stringBuilder5.append(str3);
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" and ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nProductID=t_product._id ");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" where ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".");
      stringBuilder5.append(paramString);
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" and ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nShopID=");
      stringBuilder5.append(str3);
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" and ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nProductTransacType in(100001,100015,100045)");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" group by ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.sOrderNo");
      stringBuilder3.append(stringBuilder5.toString());
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
    stringBuilder1.append(") as T  group by orderNo order by dateTime desc");
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("getDataByOrders最终查询的SQL语句：");
    stringBuilder2.append(str1);
    n.println(stringBuilder2.toString());
    return this.cZS.rawQuery(str1, null);
  }
  
  private String nj(String paramString) {
    if (paramString.matches("1.0+"))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" X");
    stringBuilder.append(n.d(Double.valueOf(Double.parseDouble(paramString))));
    return stringBuilder.toString();
  }
  
  protected double[] AW() {
    this.daq = new double[2];
    if (this.bNh == null)
      return new double[] { 0.0D, 0.0D, 0.0D }; 
    Iterator iterator = this.bNh.entrySet().iterator();
    str1 = "select sum(count0),sum(amount) from(";
    byte b = 0;
    while (iterator.hasNext()) {
      null = (Map.Entry)iterator.next();
      byte b1 = b + true;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append("select count(distinct sOrderNo) count0,sum((case when nStcokDirection=300002 then ");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc.fSpareField3 else -t_productdoc.fSpareField3 end)/(case when ");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc.nProductTransacType in(100001,100015) then ((case when ");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc.fSpareField1>0 then ");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc.fSpareField1 else 1 end)/((case when ");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc.fAmount>0 then ");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc.fAmount/");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc.nProductQty else 1 end)/");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc.fDiscount*100)) else 1 end)) amount  from ");
      stringBuilder1.append((String)null.getValue());
      stringBuilder1.append(".t_productdoc where ");
      stringBuilder1.append(this.aJZ);
      String str = stringBuilder1.toString();
      b = b1;
      str1 = str;
      if (b1 != this.bNh.size()) {
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
    stringBuilder.append(") ");
    str1 = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("querySumValue查询订单数优惠总额的SQL语句:");
    stringBuilder.append(str1);
    n.println(stringBuilder.toString());
    Cursor cursor = this.cZS.rawQuery(str1, null);
    while (cursor.moveToNext()) {
      this.daq[0] = cursor.getDouble(0);
      this.daq[1] = cursor.getDouble(1);
    } 
    cursor.close();
    return this.daq;
  }
  
  public PrintContent.a a(long paramLong1, long paramLong2, ArrayList<HashMap<String, String>> paramArrayList) {
    PrintContent.a a = new PrintContent.a();
    d d1 = new d(a);
    d1.lk(this.mContext.getString(2131629304));
    d1.l('-');
    d1.setWidth(a.bo(CrashApplication.zv()).aiL().getWidth());
    int m = e.jg(d1.getWidth());
    double d = m;
    int i = (int)(0.35D * d);
    d1.n(new int[] { i, m - i });
    i = (int)(0.2D * d);
    int k = (int)(0.4D * d);
    d1.n(new int[] { i, k, m - i - k });
    Date date = new Date(paramLong1);
    d1.x(new String[] { this.mContext.getString(2131627434), t.k(date) });
    date.setTime(paramLong2);
    d1.x(new String[] { this.mContext.getString(2131627435), t.k(date) });
    d1.l('-');
    d1.x(new String[] { this.mContext.getString(2131629300), this.mContext.getString(2131629302), this.mContext.getString(2131629298) });
    i = 0;
    k = 1;
    while (i < paramArrayList.size()) {
      HashMap hashMap = (HashMap)paramArrayList.get(i);
      if (!x(hashMap)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k);
        stringBuilder.append("");
        d1.x(new String[] { stringBuilder.toString(), n.pm((String)hashMap.get("paid_amount")), n.pm((String)hashMap.get(bzY)) });
        k++;
      } 
      i++;
    } 
    d1.l('-');
    d1.setSize(3);
    i = (int)(d * 0.45D);
    d1.n(new int[] { i, m - i });
    d1.x(new String[] { this.mContext.getString(2131629299), n.d(Double.valueOf(this.daq[1])) });
    return a;
  }
  
  public void a(t paramt) {
    this.daq = null;
    this.daA = null;
    this.dby = 0;
    this.mStartTime = paramt.ane();
    this.bSc = paramt.anf();
    try {
      this.cZS = r(this.mStartTime, this.bSc);
      this.bNh = b.f(this.mStartTime, this.bSc);
    } catch (Exception exception) {
      a.e(exception);
    } 
    d(paramt);
  }
  
  @Size
  public double[] amI() { return AW(); }
  
  public ArrayList<HashMap<String, String>> zJ() {
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = amH();
    int i = arrayList2.getCount();
    if (!ans()) {
      boolean bool;
      if (i >= getPageSize()) {
        bool = true;
      } else {
        bool = false;
      } 
      gC(bool);
    } 
    null = new StringBuilder();
    if (arrayList2.moveToFirst()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("'");
      stringBuilder1.append(arrayList2.getString(0));
      stringBuilder1.append("'");
      null.append(stringBuilder1.toString());
      while (arrayList2.moveToNext()) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(",'");
        stringBuilder1.append(arrayList2.getString(0));
        stringBuilder1.append("'");
        null.append(stringBuilder1.toString());
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("t_productdoc.sOrderNo in(");
    stringBuilder.append(null);
    stringBuilder.append(")");
    String str = stringBuilder.toString();
    arrayList2.close();
    if (i > 0) {
      HashMap hashMap;
      Cursor cursor = ni(str);
      Time time = new Time();
      double d = 0.0D;
      stringBuilder = null;
      i = 0;
      while (cursor.moveToNext()) {
        HashMap hashMap1 = new HashMap();
        hashMap1.put("orderNo", cursor.getString(0));
        String[] arrayOfString2 = cursor.getString(1).split(",,");
        String[] arrayOfString3 = cursor.getString(2).split(",,");
        String[] arrayOfString4 = cursor.getString(5).split(",,");
        StringBuilder stringBuilder3 = new StringBuilder();
        int k = 0;
        for (str = null; k < arrayOfString3.length; str = str1) {
          String str1;
          if ("100045".equals(arrayOfString4[k])) {
            str1 = str;
          } else {
            str1 = str;
            if (str == null)
              str1 = arrayOfString4[k]; 
            if (k)
              stringBuilder3.append(" / "); 
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(arrayOfString2[k]);
            stringBuilder4.append(nj(arrayOfString3[k]));
            stringBuilder3.append(stringBuilder4.toString());
          } 
          k++;
        } 
        hashMap1.put(daB, stringBuilder3.toString());
        double d1 = cursor.getDouble(3);
        hashMap1.put(bzY, n.d(Double.valueOf(d1)));
        hashMap1.put("paid_amount", aQ(Double.valueOf(cursor.getDouble(8))));
        long l = cursor.getLong(4);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(l);
        stringBuilder2.append("");
        hashMap1.put("ORDERTIME", stringBuilder2.toString());
        time.set(l);
        String[] arrayOfString1 = time.format(ann()).split(" ");
        str = arrayOfString1[0];
        hashMap1.put(dam, arrayOfString1[1]);
        k = cursor.getInt(6);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(k);
        stringBuilder1.append("");
        hashMap1.put("sourceCode", stringBuilder1.toString());
        k = cursor.getInt(7);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(k);
        stringBuilder1.append("");
        hashMap1.put("tmp_change_price", stringBuilder1.toString());
        if (str.equals(this.daA)) {
          double d2 = d;
          k = i;
          if (stringBuilder != null) {
            d2 = d + d1;
            k = i + 1;
          } 
          d = d2;
          i = k;
        } else {
          HashMap hashMap2 = new HashMap();
          time.set(l);
          hashMap2.put(bzT, str);
          hashMap2.put(dam, nq(str));
          hashMap2.put(daB, jL(time.weekDay));
          W(hashMap2);
          hashMap2.put("hideLine", "true");
          hashMap2.put("tmp_change_price", "0");
          hashMap1.put("hideLine", "true");
          arrayList1.add(hashMap2);
          this.daA = str;
          if (stringBuilder != null) {
            stringBuilder.put(bzY, n.d(Double.valueOf(d)));
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(i);
            stringBuilder4.append("");
            stringBuilder.put("childCount", stringBuilder4.toString());
          } 
          hashMap = hashMap2;
          d = d1;
          i = 1;
        } 
        arrayList1.add(hashMap1);
      } 
      cursor.close();
      ArrayList arrayList = arrayList1;
      if (hashMap != null) {
        if (ano()) {
          String[] arrayOfString = nh(this.daA);
          hashMap.put(bzY, n.pi(arrayOfString[0]));
          hashMap.put("childCount", arrayOfString[1]);
          return arrayList1;
        } 
        hashMap.put(bzY, n.d(Double.valueOf(d)));
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(i);
        stringBuilder1.append("");
        hashMap.put("childCount", stringBuilder1.toString());
        return arrayList1;
      } 
    } else {
      arrayList2 = arrayList1;
    } 
    return arrayList2;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */