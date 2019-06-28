package com.laiqian.report.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.text.format.Time;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class x extends u {
  private final String aIR = ",,";
  
  private ConcurrentHashMap<String, String> bNh;
  
  private long bSc;
  
  private SQLiteDatabase cZS;
  
  @Nullable
  private String coJ;
  
  private t dax;
  
  private String dbW;
  
  private String dbX;
  
  private String dbY;
  
  private String dbZ;
  
  String[] dca;
  
  private long dcb;
  
  private String dcc;
  
  private String dcd;
  
  private int dce;
  
  private long mStartTime;
  
  public x(Context paramContext) {
    super(paramContext);
    this.dcc = paramContext.getString(2131629949);
    this.dcd = paramContext.getString(2131629950);
  }
  
  private String any() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" order by nDateTime desc");
    String str = stringBuilder.toString();
    this.dbZ = str;
    return str;
  }
  
  private String b(t paramt, Map.Entry<String, String> paramEntry) {
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("nDateTime >=");
    if (paramt.ane() < this.dcb) {
      stringBuilder3.append(this.dcb);
    } else {
      stringBuilder3.append(paramt.ane());
    } 
    stringBuilder3.append(" and nDateTime<=");
    stringBuilder3.append(paramt.anf());
    StringBuilder stringBuilder2 = this.coJ;
    String str2 = null;
    byte b = 1;
    if (stringBuilder2 != null && this.coJ.length() > 0) {
      stringBuilder3.append(" and (nPhysicalInventoryID like ? or sSpareField3 like ?) ");
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append("%");
      stringBuilder4.append(this.coJ);
      stringBuilder4.append("%");
      String str = stringBuilder4.toString();
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append("%");
      stringBuilder5.append(this.coJ);
      stringBuilder5.append("%");
      this.dca = new String[] { str, stringBuilder5.toString() };
    } else {
      this.dca = null;
    } 
    stringBuilder3.append(" and (nProductTransacType =100001 or nProductTransacType =100015) ");
    stringBuilder2 = str2;
    if (paramt.anh() != null) {
      stringBuilder2 = str2;
      if (paramt.anh().length > 0) {
        int i = paramt.anh().length;
        stringBuilder3.append(" and (nProductID=");
        stringBuilder3.append(paramt.anh()[0]);
        byte b1;
        for (b1 = 1; b1 < i; b1++) {
          stringBuilder3.append(" or nProductID=");
          stringBuilder3.append(paramt.anh()[b1]);
        } 
        stringBuilder3.append(")");
        stringBuilder2 = str2;
        if (i > 1) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(" productIDs like '%");
          stringBuilder2.append(paramt.anh()[0]);
          stringBuilder2.append("%'");
          StringBuilder stringBuilder = new StringBuilder(stringBuilder2.toString());
          b1 = b;
          while (true) {
            stringBuilder2 = stringBuilder;
            if (b1 < i) {
              stringBuilder.append(" and productIDs like '%");
              stringBuilder.append(paramt.anh()[b1]);
              stringBuilder.append("%'");
              b1++;
              continue;
            } 
            break;
          } 
        } 
      } 
    } 
    stringBuilder3.append(" and nSpareField2 in (0,5,6,7,8,9,14,15)");
    if (paramt.ang() > 1L) {
      stringBuilder3.append(" and nUserID=");
      stringBuilder3.append(paramt.ang());
    } 
    stringBuilder3.append(" and nShopID=");
    stringBuilder3.append(VC());
    stringBuilder3.append(" and (nDeletionFlag is null or nDeletionFlag!=1) ");
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("select sOrderNo orderNo,group_concat(nProductTransacType) productTransacTypes");
    stringBuilder1.append(",sum(case when nProductTransacType =100001 then nProductQty else -nProductQty end) qty ");
    if (stringBuilder2 != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(",group_concat(nProductID) productIDs, nDateTime dateTime from ");
      stringBuilder.append((String)paramEntry.getValue());
      stringBuilder.append(".t_productdoc where ");
      stringBuilder1.append(stringBuilder.toString());
      stringBuilder1.append(stringBuilder3.toString());
      stringBuilder1.append(" group by sOrderNo having ");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder1.append(" and ");
    } else {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(" ,nDateTime dateTime ,fSpareField5 from ");
      stringBuilder2.append((String)paramEntry.getValue());
      stringBuilder2.append(".t_productdoc  where ");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder1.append(stringBuilder3);
      stringBuilder1.append(" group by sOrderNo having ");
    } 
    stringBuilder1.append(" productTransacTypes like '%100001%' and (qty>0.000001 or qty<-0.000001)");
    String str1 = stringBuilder1.toString();
    this.dbW = str1;
    return str1;
  }
  
  private String b(Map.Entry<String, String> paramEntry) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(") ");
    stringBuilder.append("and nProductQty>0 group by sOrderNo ");
    stringBuilder.append(") p ");
    String str = stringBuilder.toString();
    this.dbY = str;
    return str;
  }
  
  private String c(Map.Entry<String, String> paramEntry) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("select * from (select ");
    stringBuilder1.append("nDateTime,nPhysicalInventoryID,sOrderNo,nBPartnerID");
    stringBuilder1.append(",sum(case when nStcokDirection=300002 then fReceived else -fReceived end) amount");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(",group_concat(ifnull(t_product.sProductName,");
    stringBuilder2.append((String)paramEntry.getValue());
    stringBuilder2.append(".t_productdoc.sProductName),'");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder1.append(",,");
    stringBuilder1.append("') productNames");
    stringBuilder1.append(",group_concat(nProductQty,'");
    stringBuilder1.append(",,");
    stringBuilder1.append("') productQtys ");
    stringBuilder1.append(",group_concat(nProductTransacType,'");
    stringBuilder1.append(",,");
    stringBuilder1.append("') productTransacTypes ");
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(",");
    stringBuilder2.append((String)paramEntry.getValue());
    stringBuilder2.append(".t_productdoc.nSpareField2, ");
    stringBuilder2.append((String)paramEntry.getValue());
    stringBuilder2.append(".t_productdoc.sSpareField3 ,");
    stringBuilder2.append((String)paramEntry.getValue());
    stringBuilder2.append(".t_productdoc.fSpareField5 ");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("from ");
    stringBuilder2.append((String)paramEntry.getValue());
    stringBuilder2.append(".t_productdoc ");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("left join t_product on t_product._id=");
    stringBuilder2.append((String)paramEntry.getValue());
    stringBuilder2.append(".t_productdoc.nProductID ");
    stringBuilder1.append(stringBuilder2.toString());
    stringBuilder1.append("where sOrderNo in(");
    String str = stringBuilder1.toString();
    this.dbX = str;
    return str;
  }
  
  private String nj(String paramString) {
    if (paramString.matches("1.0+"))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" X");
    stringBuilder.append(n.pi(paramString));
    return stringBuilder.toString();
  }
  
  protected double[] AW() { return new double[0]; }
  
  public void a(t paramt) {
    this.dby = 0;
    this.dax = paramt;
    this.mStartTime = paramt.ane();
    this.bSc = paramt.anf();
    try {
      this.cZS = r(this.mStartTime, this.bSc);
      this.bNh = b.f(this.mStartTime, this.bSc);
    } catch (Exception exception) {
      a.e(exception);
    } 
    this.dce = paramt.anh().length;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("最终查询单据号的SQL语句：");
    stringBuilder.append(this.dbW);
    n.println(stringBuilder.toString());
  }
  
  public void anz() {
    Time time = new Time();
    time.setToNow();
    time.set(0, 0, 0, time.monthDay - 1, time.month, time.year);
    this.dcb = time.normalize(false);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("昨天：");
    stringBuilder.append(time.format2445());
    n.println(stringBuilder.toString());
  }
  
  public void nr(@Nullable String paramString) { this.coJ = paramString; }
  
  public ArrayList<HashMap<String, String>> zJ() {
    String str1;
    boolean bool;
    ArrayList arrayList = new ArrayList();
    null = this.bNh.entrySet();
    if (this.dce > 1) {
      str1 = "select orderNo,productTransacTypes,sum(qty),productIDs ,dateTime,fSpareField5 from(";
    } else {
      String str;
      str1 = "select orderNo,productTransacTypes,sum(qty),dateTime,fSpareField5 from(";
    } 
    Iterator iterator = null.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      null = (Map.Entry)iterator.next();
      byte b = i + true;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append(b(this.dax, null));
      String str = stringBuilder1.toString();
      i = b;
      str1 = str;
      if (b != this.bNh.size()) {
        null = new StringBuilder();
        null.append(str);
        null.append(" union all ");
        str1 = null.toString();
        i = b;
      } 
    } 
    null = new StringBuilder();
    null.append(str1);
    null.append(") as T group by orderNo  order by  dateTime desc ");
    null.append(ant());
    String str2 = null.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("-getData-sql--->");
    stringBuilder.append(str2);
    b.ct(stringBuilder.toString());
    Cursor cursor = this.cZS.rawQuery(str2, this.dca);
    i = cursor.getCount();
    if (i >= getPageSize()) {
      bool = true;
    } else {
      bool = false;
    } 
    gC(bool);
    if (i > 0) {
      null = new StringBuilder();
      while (cursor.moveToNext()) {
        null.append(",'");
        null.append(cursor.getString(0));
        null.append("'");
      } 
      null.deleteCharAt(0);
      Iterator iterator1 = this.bNh.entrySet().iterator();
      String str = "select * from (";
      i = 0;
      while (iterator1.hasNext()) {
        null = (Map.Entry)iterator1.next();
        int i7 = i + 1;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append(c(null));
        stringBuilder1.append(null.toString());
        stringBuilder1.append(b(null));
        String str3 = stringBuilder1.toString();
        i = i7;
        str = str3;
        if (i7 != this.bNh.size()) {
          null = new StringBuilder();
          null.append(str3);
          null.append(" union all ");
          str = null.toString();
          i = i7;
        } 
      } 
      null = new StringBuilder();
      null.append(str);
      null.append(") as T ");
      null.append(any());
      str = null.toString();
      null = new StringBuilder();
      null.append(getClass().getSimpleName());
      null.append("-getData-sql1--->");
      null.append(str);
      b.ct(null.toString());
      null = new StringBuilder();
      null.append("最终查询具体单据的SQL语句：");
      null.append(str2);
      n.println(null.toString());
      Cursor cursor2 = this.cZS.rawQuery(str, null);
      str2 = ann();
      Time time = new Time();
      i = RootApplication.aIQ;
      int i4 = 1;
      int m = -1;
      int j = -1;
      i = -1;
      int i5 = -1;
      int i6 = -1;
      int i3 = -1;
      int i2 = -1;
      int i1 = -1;
      int n = -1;
      int k = -1;
      Cursor cursor1 = cursor;
      while (cursor2.moveToNext()) {
        cursor2.getInt(cursor2.getColumnIndex("fSpareField5"));
        HashMap hashMap = new HashMap();
        if (i4) {
          m = cursor2.getColumnIndex("nDateTime");
          j = cursor2.getColumnIndex("nPhysicalInventoryID");
          i6 = cursor2.getColumnIndex("sOrderNo");
          i4 = cursor2.getColumnIndex("productNames");
          i3 = cursor2.getColumnIndex("productQtys");
          i5 = cursor2.getColumnIndex("sSpareField3");
          k = cursor2.getColumnIndex("productTransacTypes");
          i = cursor2.getColumnIndex("nSpareField2");
          i2 = cursor2.getColumnIndex("nBPartnerID");
          i1 = cursor2.getColumnIndex("amount");
          n = 0;
        } else {
          int i12 = i4;
          i4 = i3;
          i3 = i2;
          i2 = i1;
          i1 = n;
          int i11 = k;
          n = i12;
          k = i2;
          i2 = i11;
        } 
        long l = cursor2.getLong(m);
        time.set(l);
        null = new StringBuilder();
        null.append(l);
        null.append("");
        hashMap.put("ORDERTIME", null.toString());
        null = time.format(str2).split(" ");
        null = new StringBuilder();
        null.append(nq(null[0]));
        null.append(" ");
        null.append(null[1]);
        hashMap.put("dateTime", null.toString());
        null = cursor2.getString(j);
        if (cursor2.getLong(i) == 7L) {
          hashMap.put("tableNumber", cursor2.getString(i5));
        } else if (null == null || null.isEmpty()) {
          hashMap.put("tableNumber", this.dcd);
        } else {
          null = new StringBuilder();
          null.append(this.dcc);
          null.append(null);
          hashMap.put("tableNumber", null.toString());
        } 
        hashMap.put("orderNo", cursor2.getString(i6));
        int i7 = i4;
        String[] arrayOfString1 = cursor2.getString(i7).split(",,");
        int i8 = i3;
        String[] arrayOfString2 = cursor2.getString(i8).split(",,");
        String[] arrayOfString3 = cursor2.getString(k).split(",,");
        if (arrayOfString1.length == arrayOfString2.length) {
          StringBuilder stringBuilder1 = new StringBuilder();
          for (i3 = 0; i3 < arrayOfString1.length; i3++) {
            if (arrayOfString3[i3].equals("100001")) {
              stringBuilder1.append("/");
              stringBuilder1.append(arrayOfString1[i3]);
              stringBuilder1.append(nj(arrayOfString2[i3]));
            } else if (arrayOfString3[i3].equals("100015")) {
              stringBuilder1.append("/");
              stringBuilder1.append(arrayOfString1[i3]);
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("-");
              stringBuilder2.append(arrayOfString2[i3]);
              stringBuilder1.append(nj(stringBuilder2.toString()));
            } 
          } 
          if (stringBuilder1.length() > 0)
            stringBuilder1.deleteCharAt(0); 
          hashMap.put("products", stringBuilder1.toString());
          hashMap.put("partnerID", cursor2.getString(i2));
        } else {
          hashMap.put("products", "商品数据异常");
        } 
        hashMap.put("accounts", n.d(Double.valueOf(cursor2.getDouble(i1))));
        arrayList.add(hashMap);
        int i9 = i2;
        int i10 = i1;
        i4 = n;
        i3 = i7;
        i2 = i8;
        i1 = k;
        n = i10;
        k = i9;
      } 
      cursor2.close();
      cursor = cursor1;
    } 
    cursor.close();
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */