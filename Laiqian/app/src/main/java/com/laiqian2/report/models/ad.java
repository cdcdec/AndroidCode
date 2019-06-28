package com.laiqian.report.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.v;
import com.laiqian.print.b.d;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.print.util.e;
import com.laiqian.sales.h;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.orhanobut.logger.d;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ad extends u implements i, j {
  private static final String TAG = "ad";
  
  public static final String bzT = CrashApplication.zv().getString(2131628022);
  
  public static final String bzY;
  
  public static final String daB;
  
  public static final String dam = CrashApplication.zv().getString(2131628037);
  
  public static final String dan;
  
  public static final String dcG = CrashApplication.zv().getString(2131628021);
  
  public static final String dcH;
  
  public static final String dcI;
  
  public static final String dcJ;
  
  public static final String dcK;
  
  public static final String dcL;
  
  public static final String dcM;
  
  public static final String dcN;
  
  public static final String dcO;
  
  public static final String dcP;
  
  public static final String dcQ;
  
  public static final String dcR;
  
  public static final String dcS;
  
  public static final String dcT;
  
  public static final String dcU;
  
  public static final String dcV;
  
  public static final String dcW;
  
  public static final String dcf;
  
  private final String aIR = ",,";
  
  private String aJZ;
  
  private long aRC = 0L;
  
  private ConcurrentHashMap<String, String> bNh;
  
  private SQLiteDatabase cZS;
  
  private String daA;
  
  private t dax;
  
  private String dcA = CrashApplication.zv().getString(2131627210);
  
  private String dcB = CrashApplication.zv().getString(2131627209);
  
  private String dcC = CrashApplication.zv().getString(2131628360);
  
  private String dcD = CrashApplication.zv().getString(2131627194);
  
  private String dcE = CrashApplication.zv().getString(2131626527);
  
  private String dcF = CrashApplication.zv().getString(2131625572);
  
  private String dcX;
  
  private String dcY = "";
  
  f dcZ;
  
  private StringBuilder dcu;
  
  private String dcv;
  
  private long[] dcw;
  
  private String dcx;
  
  private boolean dcy;
  
  private String dcz = CrashApplication.zv().getString(2131627208);
  
  private String orderTypeID = "";
  
  private long startTime = 0L;
  
  static  {
    dan = CrashApplication.zv().getString(2131628033);
    daB = CrashApplication.zv().getString(2131628032);
    dcH = CrashApplication.zv().getString(2131628023);
    bzY = CrashApplication.zv().getString(2131628020);
    dcI = CrashApplication.zv().getString(2131628025);
    dcJ = CrashApplication.zv().getString(2131628030);
    dcK = CrashApplication.zv().getString(2131628040);
    dcL = CrashApplication.zv().getString(2131628039);
    dcM = CrashApplication.zv().getString(2131628024);
    dcN = CrashApplication.zv().getString(2131628031);
    dcO = CrashApplication.zv().getString(2131628029);
    dcP = CrashApplication.zv().getString(2131628027);
    dcQ = CrashApplication.zv().getString(2131628028);
    dcR = CrashApplication.zv().getString(2131627326);
    dcS = CrashApplication.zv().getString(2131628026);
    dcf = CrashApplication.zv().getString(2131628038);
    dcT = CrashApplication.zv().getString(2131628036);
    dcU = CrashApplication.zv().getString(2131627603);
    dcV = CrashApplication.zv().getString(2131628034);
    dcW = CrashApplication.zv().getString(2131628035);
  }
  
  public ad(Context paramContext) {
    super(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" deliveryManID=");
    stringBuilder.append(this.dcY);
    Log.d("TransactionReportModel", stringBuilder.toString());
    this.dcZ = new f(paramContext);
  }
  
  private StringBuilder a(t paramt, StringBuilder paramStringBuilder) {
    if (paramt.ang() > 1L) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" and t_productdoc.nUserID=");
      stringBuilder1.append(paramt.ang());
      paramStringBuilder.append(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" and t_productdoc.nShopID=");
    stringBuilder.append(VC());
    paramStringBuilder.append(stringBuilder.toString());
    paramStringBuilder.append(" and (t_productdoc.nDeletionFlag is null or t_productdoc.nDeletionFlag!=1) ");
    return paramStringBuilder;
  }
  
  private Cursor amH() {
    if (this.dcw.length > 1) {
      str = "select sOrderNum,productIDs,sum(serviceCharge),dateTime from(";
    } else {
      String str1;
      str = "select sOrderNum,sum(serviceCharge),dateTime from(";
    } 
    Set set = this.bNh.entrySet();
    byte b = 0;
    for (Map.Entry entry : set) {
      byte b1 = b + true;
      null = new StringBuilder();
      String str2 = g(this.dax, entry);
      if (this.dcw.length > 1) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("select sOrderNo sOrderNum, group_concat(nProductID) productIDs,sum(case when nProductTransacType=100068 then (case when nStcokDirection=300002 then fSpareField1 else -fSpareField1 end) else 0 end) serviceCharge ,nDateTime dateTime from ");
        stringBuilder2.append((String)entry.getValue());
        stringBuilder2.append(".t_productdoc where 1=1 and ");
        stringBuilder2.append(str2);
        null.append(stringBuilder2.toString());
        null.append(f(this.dax, entry));
        null.append(" group by sOrderNo having ");
        null.append(this.dcx);
      } else {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("select distinct ");
        stringBuilder2.append((String)entry.getValue());
        stringBuilder2.append(".t_productdoc.sOrderNo sOrderNum,sum(case when ");
        stringBuilder2.append((String)entry.getValue());
        stringBuilder2.append(".t_productdoc.nProductTransacType=100068 then (case when ");
        stringBuilder2.append((String)entry.getValue());
        stringBuilder2.append(".t_productdoc.nStcokDirection=300002 then ");
        stringBuilder2.append((String)entry.getValue());
        stringBuilder2.append(".t_productdoc.fSpareField1 else -");
        stringBuilder2.append((String)entry.getValue());
        stringBuilder2.append(".t_productdoc.fSpareField1 end) else 0 end) serviceCharge  ,");
        stringBuilder2.append((String)entry.getValue());
        stringBuilder2.append(".t_productdoc.nDateTime dateTime from ");
        stringBuilder2.append((String)entry.getValue());
        stringBuilder2.append(".t_productdoc where ");
        stringBuilder2.append(str2);
        null.append(stringBuilder2.toString());
        null.append(f(this.dax, entry));
        null.append("group by sOrderNo ");
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append(null.toString());
      String str1 = stringBuilder1.toString();
      str = str1;
      b = b1;
      if (b1 != this.bNh.size()) {
        null = new StringBuilder();
        null.append(str1);
        null.append(" union all ");
        str = null.toString();
        b = b1;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(") as T group by sOrderNum order by dateTime desc ");
    stringBuilder.append(ant());
    String str = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("返回满足条件的单据号getOrderCursor-sql->");
    stringBuilder.append(str);
    b.ct(stringBuilder.toString());
    return this.cZS.rawQuery(str, null);
  }
  
  private boolean anA() { return (!ans() || (ans() && this.dcy)); }
  
  private Cursor anB() {
    null = this.bNh.entrySet();
    if (this.dcw.length > 1) {
      str = "select sOrderNum,productIDs,sum(serviceCharge),dateTime from (";
    } else {
      str = "select sOrderNum,sum(serviceCharge),dateTime from (";
    } 
    byte b = 0;
    for (Map.Entry entry : null) {
      b++;
      StringBuilder stringBuilder1 = new StringBuilder();
      if (this.dcw.length > 1) {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("select sOrderNo sOrderNum, group_concat(nProductID) productIDs,sum(case when ");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.nProductTransacType=100068 then (case when ");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.nStcokDirection=300002 then ");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.fSpareField1 else -");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.fSpareField1 end) else 0 end) serviceCharge ,");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.nDateTime dateTime from ");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc where");
        stringBuilder3.append(g(this.dax, entry));
        stringBuilder3.append(" ");
        stringBuilder1.append(stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.nDateTime>=");
        stringBuilder3.append(this.startTime);
        stringBuilder3.append(" and ");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.nDateTime<=");
        stringBuilder3.append(this.aRC);
        stringBuilder3.append(" and ");
        stringBuilder3.append(f(this.dax, entry));
        stringBuilder1.append(stringBuilder3.toString());
        stringBuilder1.append(" group by sOrderNo having ");
        stringBuilder1.append(this.dcx);
      } else {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("select distinct sOrderNo sOrderNum,sum(case when ");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.nProductTransacType=100068 then (case when ");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.nStcokDirection=300002 then ");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.fSpareField1 else -");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.fSpareField1 end) else 0 end) serviceCharge ,");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.nDateTime dateTime  from ");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc where");
        stringBuilder3.append(g(this.dax, entry));
        stringBuilder3.append("");
        stringBuilder1.append(stringBuilder3.toString());
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.nDateTime>=");
        stringBuilder3.append(this.startTime);
        stringBuilder3.append(" and ");
        stringBuilder3.append((String)entry.getValue());
        stringBuilder3.append(".t_productdoc.nDateTime<=");
        stringBuilder3.append(this.aRC);
        stringBuilder3.append(" and ");
        stringBuilder3.append(f(this.dax, entry));
        stringBuilder1.append(stringBuilder3.toString());
        stringBuilder1.append("group by sOrderNo ");
      } 
      if (b != this.bNh.size()) {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append(stringBuilder1.toString());
        stringBuilder3.append(" union all ");
        str = stringBuilder3.toString();
        continue;
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str);
      stringBuilder2.append(stringBuilder1.toString());
      str = stringBuilder2.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(") as T group by sOrderNum order by dateTime desc ");
    String str = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("查询全部单据号的SQL语句：");
    stringBuilder.append(str);
    n.println(stringBuilder.toString());
    return this.cZS.rawQuery(str, null);
  }
  
  private String[] anC() {
    Iterator iterator = this.bNh.entrySet().iterator();
    String str2 = "select sum(sum0),sum(count1),sum(sum2) from(";
    byte b = 0;
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      byte b1 = b + true;
      String str8 = g(this.dax, entry);
      null = new StringBuilder();
      null.append(str2);
      null.append("select sum(case when nStcokDirection=300002 then fReceived else -fReceived end) sum0,count(distinct sOrderNo) count1,sum(case when nStcokDirection=300002 then ifnull(");
      null.append((String)entry.getValue());
      null.append(".t_productdoc.fSpareField2,0) else -ifnull(");
      null.append((String)entry.getValue());
      null.append(".t_productdoc.fSpareField2,0) end) sum2 from ");
      null.append((String)entry.getValue());
      null.append(".t_productdoc where ");
      null.append((String)entry.getValue());
      null.append(".t_productdoc.nDateTime>=");
      null.append(this.startTime);
      null.append(" and ");
      null.append((String)entry.getValue());
      null.append(".t_productdoc.nDateTime<=");
      null.append(this.aRC);
      null.append(" and ");
      null.append(e(this.dax, entry));
      if (!TextUtils.isEmpty(str8)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" and ");
        stringBuilder.append(str8);
        stringBuilder.append(" 1=1 ");
        String str = stringBuilder.toString();
      } else {
        str2 = "";
      } 
      null.append(str2);
      String str7 = null.toString();
      b = b1;
      str2 = str7;
      if (b1 != this.bNh.size()) {
        null = new StringBuilder();
        null.append(str7);
        null.append(" union all ");
        str2 = null.toString();
        b = b1;
      } 
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append(") as T");
    str2 = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("手动查询该天总金额的SQL语句:");
    stringBuilder2.append(str2);
    n.println(stringBuilder2.toString());
    Cursor cursor = this.cZS.rawQuery(str2, null);
    long l = System.currentTimeMillis();
    cursor.moveToFirst();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("手动查询该天总金额的SQL语句的时间:");
    stringBuilder1.append(System.currentTimeMillis() - l);
    n.println(stringBuilder1.toString());
    String str1 = aQ(Double.valueOf(cursor.getDouble(0)));
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(cursor.getInt(1));
    stringBuilder3.append("");
    String str4 = stringBuilder3.toString();
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(cursor.getDouble(0));
    stringBuilder4.append("");
    String str5 = stringBuilder4.toString();
    String str6 = aQ(Double.valueOf(cursor.getDouble(2)));
    cursor.close();
    String str3 = TAG;
    StringBuilder stringBuilder5 = new StringBuilder();
    stringBuilder5.append("queryAmountAll amout=");
    stringBuilder5.append(str1);
    stringBuilder5.append("--qty=");
    stringBuilder5.append(str4);
    stringBuilder5.append("--preferentialAmount=");
    stringBuilder5.append(str6);
    stringBuilder5.append("--preAmount=");
    stringBuilder5.append(str5);
    Log.i(str3, stringBuilder5.toString());
    return new String[] { str1, str4, str6, str5 };
  }
  
  @NonNull
  private StringBuilder d(t paramt, Map.Entry<String, String> paramEntry) {
    StringBuilder stringBuilder1 = new StringBuilder();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append((String)paramEntry.getValue());
    stringBuilder2.append(".t_productdoc.nProductTransacType in(");
    stringBuilder1.append(stringBuilder2.toString());
    if (paramt.ani() != null) {
      stringBuilder1.append(paramt.ani());
      stringBuilder1.append(")");
    } else {
      stringBuilder1.append("100001,100015,100045,100060,100066,100068)");
    } 
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("DeliverPersonID is:");
    stringBuilder2.append(paramt.anj());
    d.b(stringBuilder2.toString(), new Object[0]);
    if (!by.isNull(paramt.anj())) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(" and ");
      stringBuilder2.append((String)paramEntry.getValue());
      stringBuilder2.append(".t_productdoc.sSpareField4 =");
      stringBuilder2.append(paramt.anj());
      stringBuilder2.append("");
      stringBuilder1.append(stringBuilder2.toString());
    } 
    if (!TextUtils.isEmpty(paramt.anj())) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(" and ");
      stringBuilder2.append((String)paramEntry.getValue());
      stringBuilder2.append(".t_productdoc.sSpareField4 =");
      stringBuilder2.append(paramt.anj());
      stringBuilder2.append("");
      stringBuilder1.append(stringBuilder2.toString());
    } 
    if (!by.isNull(this.dcX)) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(" and ");
      stringBuilder2.append((String)paramEntry.getValue());
      stringBuilder2.append(".t_productdoc.nSpareField2 in(");
      stringBuilder2.append(this.dcX);
      stringBuilder2.append(")");
      stringBuilder1.append(stringBuilder2.toString());
    } 
    if (paramt.ane() > 0L || paramt.anf() > 0L) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(" and ");
      stringBuilder2.append((String)paramEntry.getValue());
      stringBuilder2.append(".t_productdoc.nDateTime >=");
      stringBuilder2.append(paramt.ane());
      stringBuilder2.append(" and ");
      stringBuilder2.append((String)paramEntry.getValue());
      stringBuilder2.append(".t_productdoc.nDateTime<=");
      stringBuilder2.append(paramt.anf());
      stringBuilder1.append(stringBuilder2.toString());
    } 
    return stringBuilder1;
  }
  
  private String e(t paramt, Map.Entry<String, String> paramEntry) {
    null = d(paramt, paramEntry);
    this.dcw = paramt.anh();
    this.dcu = new StringBuilder(null);
    String str = null.toString();
    this.dcu = a(paramt, this.dcu);
    if (this.dcw == null) {
      this.dcy = false;
    } else {
      boolean bool;
      int k = this.dcw.length;
      byte b = 1;
      if (k > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.dcy = bool;
      if (bool) {
        StringBuilder stringBuilder1 = this.dcu;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(" and sOrderNo in (select sOrderNo from (select  group_concat(nProductID) productIDs,sOrderNo from ");
        stringBuilder2.append((String)paramEntry.getValue());
        stringBuilder2.append(".t_productdoc where nShopID=");
        stringBuilder2.append(VC());
        stringBuilder2.append(" and ");
        stringBuilder2.append(str);
        stringBuilder2.append(" group by sOrderNo having productIDs like '%");
        stringBuilder2.append(this.dcw[0]);
        stringBuilder2.append("%'");
        stringBuilder1.append(stringBuilder2.toString());
        while (b < k) {
          stringBuilder1 = this.dcu;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(" and productIDs like '%");
          stringBuilder.append(this.dcw[b]);
          stringBuilder.append("%'");
          stringBuilder1.append(stringBuilder.toString());
          b++;
        } 
        this.dcu.append("))");
      } 
    } 
    return this.dcu.toString();
  }
  
  private String f(t paramt, Map.Entry<String, String> paramEntry) {
    StringBuilder stringBuilder = d(paramt, paramEntry);
    this.dcw = paramt.anh();
    if (this.dcw == null) {
      this.dcy = false;
    } else {
      boolean bool;
      int k = this.dcw.length;
      byte b = 1;
      if (k > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.dcy = bool;
      if (bool) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(" and (");
        stringBuilder1.append((String)paramEntry.getValue());
        stringBuilder1.append(".t_productdoc.nProductID=");
        stringBuilder1.append(this.dcw[0]);
        stringBuilder.append(stringBuilder1.toString());
        byte b1;
        for (b1 = 1; b1 < k; b1++) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(" or ");
          stringBuilder1.append((String)paramEntry.getValue());
          stringBuilder1.append(".t_productdoc.nProductID=");
          stringBuilder1.append(this.dcw[b1]);
          stringBuilder.append(stringBuilder1.toString());
        } 
        stringBuilder.append(")");
        if (k > 1) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(" productIDs like '%");
          stringBuilder2.append(this.dcw[0]);
          stringBuilder2.append("%'");
          stringBuilder2 = new StringBuilder(stringBuilder2.toString());
          for (b1 = b; b1 < k; b1++) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(" and productIDs like '%");
            stringBuilder1.append(this.dcw[b1]);
            stringBuilder1.append("%'");
            stringBuilder2.append(stringBuilder1.toString());
          } 
          this.dcx = stringBuilder2.toString();
        } 
      } 
    } 
    String str = a(paramt, stringBuilder).toString();
    this.aJZ = str;
    return str;
  }
  
  private String g(t paramt, Map.Entry<String, String> paramEntry) {
    String str;
    if (paramt.ank() == null || (paramt.ank()).aSX == 0) {
      this.dcv = " ";
      return this.dcv.toString();
    } 
    int k = (paramt.ank()).aSX;
    if (k == 10007) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("(");
      stringBuilder1.append((String)paramEntry.getValue());
      stringBuilder1.append(".t_accountdoc.nAccountID=");
      stringBuilder1.append(k);
      stringBuilder1.append(" or ");
      stringBuilder1.append((String)paramEntry.getValue());
      stringBuilder1.append(".t_accountdoc.nSpareField1=4)");
      str = stringBuilder1.toString();
    } else if (k == 10009) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("(");
      stringBuilder1.append((String)paramEntry.getValue());
      stringBuilder1.append(".t_accountdoc.nAccountID=");
      stringBuilder1.append(k);
      stringBuilder1.append(" or ");
      stringBuilder1.append((String)paramEntry.getValue());
      stringBuilder1.append(".t_accountdoc.nSpareField1=6)");
      str = stringBuilder1.toString();
    } else if (paramt.ank().FQ()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append((String)paramEntry.getValue());
      stringBuilder1.append(".t_accountdoc.nAccountID=");
      stringBuilder1.append(k);
      stringBuilder1.append(" and ");
      stringBuilder1.append((String)paramEntry.getValue());
      stringBuilder1.append(".t_accountdoc.nSpareField1=");
      stringBuilder1.append((paramt.ank()).aSW);
      str = stringBuilder1.toString();
    } else {
      null = new StringBuilder();
      null.append((String)paramEntry.getValue());
      null.append(".t_accountdoc.nAccountID=");
      null.append(k);
      str = null.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" sOrderNo in (\n  SELECT DISTINCT sText FROM ");
    stringBuilder.append((String)paramEntry.getValue());
    stringBuilder.append(".t_accountdoc\n  where ");
    stringBuilder.append((String)paramEntry.getValue());
    stringBuilder.append(".t_accountdoc.nDateTime >=");
    stringBuilder.append(paramt.ane());
    stringBuilder.append("\n        and ");
    stringBuilder.append((String)paramEntry.getValue());
    stringBuilder.append(".t_accountdoc.nDateTime<=");
    stringBuilder.append(paramt.anf());
    stringBuilder.append("\n        and ");
    stringBuilder.append(str);
    stringBuilder.append(")  and ");
    this.dcv = stringBuilder.toString();
    return this.dcv.toString();
  }
  
  private String[] nh(String paramString) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(anm());
    try {
      long l = simpleDateFormat.parse(paramString).getTime();
      Iterator iterator = this.bNh.entrySet().iterator();
      paramString = "select sum(sum0),sum(count1),sum(sum2) from(";
      byte b = 0;
      while (iterator.hasNext()) {
        null = (Map.Entry)iterator.next();
        byte b1 = b + true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append("select sum(case when nStcokDirection=300002 then fReceived else -fReceived end) sum0,count(distinct sOrderNo) count1,sum(case when nStcokDirection=300002 then ifnull(");
        stringBuilder.append((String)null.getValue());
        stringBuilder.append(".t_productdoc.fSpareField2,0) else -ifnull(");
        stringBuilder.append((String)null.getValue());
        stringBuilder.append(".t_productdoc.fSpareField2,0) end) sum2 from ");
        stringBuilder.append((String)null.getValue());
        stringBuilder.append(".t_productdoc  where ");
        stringBuilder.append((String)null.getValue());
        stringBuilder.append(".t_productdoc.nDateTime>=");
        stringBuilder.append(l);
        stringBuilder.append(" and ");
        stringBuilder.append((String)null.getValue());
        stringBuilder.append(".t_productdoc.nDateTime<=");
        stringBuilder.append(l + 86399999L);
        stringBuilder.append(" and ");
        stringBuilder.append(g(this.dax, null));
        stringBuilder.append("  ");
        stringBuilder.append(f(this.dax, null));
        String str = stringBuilder.toString();
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
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append(") as T");
      String str1 = stringBuilder1.toString();
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("手动查询该天总金额的SQL语句:");
      stringBuilder1.append(str1);
      n.println(stringBuilder1.toString());
      Cursor cursor = this.cZS.rawQuery(str1, null);
      l = System.currentTimeMillis();
      cursor.moveToFirst();
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("手动查询该天总金额的SQL语句的时间:");
      stringBuilder1.append(System.currentTimeMillis() - l);
      n.println(stringBuilder1.toString());
      String str2 = aQ(Double.valueOf(cursor.getDouble(0)));
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(cursor.getInt(1));
      stringBuilder2.append("");
      String str3 = stringBuilder2.toString();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(cursor.getDouble(0));
      stringBuilder3.append("");
      String str4 = stringBuilder3.toString();
      String str5 = aQ(Double.valueOf(cursor.getDouble(2)));
      cursor.close();
      return new String[] { str2, str3, str5, str4 };
    } catch (ParseException paramString) {
      a.e(paramString);
      return new String[] { "0", "0", "0", "" };
    } 
  }
  
  private Cursor ni(String paramString) {
    String str2;
    String str3 = VC();
    null = this.bNh.entrySet();
    if (ans()) {
      str2 = "select orderNo,productNames,qtys,sum(amounts) as amounts,dateTime,productTransacTypes,source,sum(preferentialAmount) as preferentialAmount,accountIDs,accountAmounts,bpartnerNewAmount,bpartnerNumber,userPhone,sum(amountRounding) as amountRounding,sum(serviceCharge) as serviceCharge,sum(tax) as tax,billNumber,sum(discount) as discount,name,sSpareField3,nPhysicalInventoryID,sHeaderText from (";
    } else {
      str2 = "select orderNo,productNames,qtys,sum(amounts) as amounts,dateTime,productTransacTypes,source,sum(preferentialAmount) as preferentialAmount ,sSpareField3,nPhysicalInventoryID,sHeaderText from (";
    } 
    Iterator iterator = null.iterator();
    byte b = 0;
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      b++;
      StringBuilder stringBuilder3 = new StringBuilder("select ");
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.sOrderNo orderNo,group_concat(ifnull(t_product.sProductName,");
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
      stringBuilder5.append(",sum(case when nStcokDirection=300002 then ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.fReceived else -");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.fReceived end) amounts");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(",min(");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nDateTime) dateTime");
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
      stringBuilder5.append(".t_productdoc.nSpareField2,0) source");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(",sum(ifnull(");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.fSpareField2,0)) preferentialAmount ");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(",");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nPhysicalInventoryID,");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.sSpareField3,");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.sHeaderText ");
      stringBuilder3.append(stringBuilder5.toString());
      if (ans()) {
        stringBuilder3.append(",account.accountIDs accountIDs,account.accountAmounts accountAmounts,case when min(nProductTransacType)=100001 then minNewAmount else maxNewAmount end bpartnerNewAmount,t_bpartner.sNumber bpartnerNumber,t_user.sUserPhone userPhone");
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(",sum((case when nStcokDirection=300002 then ");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.fAmount else -");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.fAmount end)*(");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.nProductTransacType=100045 and ");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.nProductID=101)) amountRounding");
        stringBuilder3.append(stringBuilder5.toString());
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(",sum((case when nStcokDirection=300002 then ");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.fAmount else -");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.fAmount end)*(");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.nProductTransacType=100068)) serviceCharge ");
        stringBuilder3.append(stringBuilder5.toString());
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(",sum((case when nStcokDirection=300002 then ");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.fAmount else -");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.fAmount end)*(");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.nProductTransacType=100060)) tax ");
        stringBuilder3.append(stringBuilder5.toString());
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(",");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.sSpareField1 billNumber");
        stringBuilder3.append(stringBuilder5.toString());
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(",sum(((case when nStcokDirection=300002 then ");
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
        stringBuilder5.append(".t_productdoc.fDiscount*100)) else 1 end)) )  discount ");
        stringBuilder3.append(stringBuilder5.toString());
        stringBuilder3.append(" ,t_user.sUserName name ");
      } 
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
      if (ans()) {
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(" left join (select sText,group_concat(nAccountID,',,') accountIDs,group_concat(fAccountAmount*nMoneyDirection,',,') accountAmounts from ");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_accountdoc where nShopID=");
        stringBuilder5.append(str3);
        stringBuilder5.append(" group by sText) account on account.sText=");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.sOrderNo left join (select nBpartnerID,min(fNewAmount) minNewAmount,max(fNewAmount) maxNewAmount,sText from t_bpartner_chargedoc group by sText) bc on bc.sText=");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.sOrderNo left join t_bpartner on t_bpartner.nShopID=");
        stringBuilder5.append(str3);
        stringBuilder5.append(" and t_bpartner._id=");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.nBpartnerID left join t_user on t_user.nShopID=");
        stringBuilder5.append(str3);
        stringBuilder5.append(" and t_user._id=");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".t_productdoc.nUserID");
        stringBuilder3.append(stringBuilder5.toString());
      } 
      if (!anA())
        stringBuilder3.append(g(this.dax, entry)); 
      if (paramString.startsWith("t_productdoc")) {
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(" where ");
        stringBuilder5.append((String)entry.getValue());
        stringBuilder5.append(".");
        stringBuilder5.append(paramString);
        stringBuilder3.append(stringBuilder5.toString());
      } else {
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(" where ");
        stringBuilder5.append(f(this.dax, entry));
        stringBuilder3.append(stringBuilder5.toString());
      } 
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" and ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nShopID=");
      stringBuilder5.append(str3);
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" and ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nProductTransacType in(100001,100015,100045,100060,100066,100068)");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" and ( ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nDeletionFlag is null or ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nDeletionFlag!=1) ");
      stringBuilder3.append(stringBuilder5.toString());
      stringBuilder3.append(" group by orderNo");
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
    stringBuilder1.append(") as T group by orderNo order by dateTime desc");
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("最终查询的SQL语句：");
    stringBuilder2.append(str1);
    n.println(stringBuilder2.toString());
    return this.cZS.rawQuery(str1, null);
  }
  
  private String nj(String paramString) {
    if (paramString.matches("1.0+"))
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" X");
    stringBuilder.append(n.b(this.mContext, paramString, false));
    return stringBuilder.toString();
  }
  
  private String nu(String paramString) { return "10001".equals(paramString) ? dcI : ("10006".equals(paramString) ? dcJ : ("10007".equals(paramString) ? dcM : ("10010".equals(paramString) ? dcO : ("10011".equals(paramString) ? dcP : ("10008".equals(paramString) ? dcQ : ("10009".equals(paramString) ? dcN : ("10014".equals(paramString) ? dcR : ("10013".equals(paramString) ? dcS : "未知")))))))); }
  
  @NonNull
  private PrintContent.a z(long paramLong1, long paramLong2) {
    PrintContent.a a = new PrintContent.a();
    d d = new d(a);
    d.setWidth(a.bo(CrashApplication.zv()).aiL().getWidth());
    d.lk("Order Report");
    d.l('-');
    int k = e.jg(d.getWidth());
    double d1 = k;
    int m = (int)(0.45D * d1);
    d.n(new int[] { m, k - m });
    null = new Time();
    null = ann();
    null.set(paramLong1);
    d.x(new String[] { this.mContext.getString(2131627434), null.format(null) });
    null.set(paramLong2);
    d.x(new String[] { this.mContext.getString(2131627435), null.format(null) });
    d.l('-');
    Set set = this.bNh.entrySet();
    null = set.iterator();
    null = "select sum(rounding) as rounding,sum(amount) as amount,sum(discount) as discount,sum(tax) as tax,sum(serviceCharge) as serviceCharge from(";
    m = 0;
    while (null.hasNext()) {
      Map.Entry entry = (Map.Entry)null.next();
      m++;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("select ");
      stringBuilder1.append("sum(case when nProductTransacType!=100045 or nProductID!=101 then 0 when nStcokDirection=300002 then fAmount else -fAmount end) rounding,");
      stringBuilder1.append("sum(case when nStcokDirection=300002 then fReceived else -fReceived end) amount,");
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("sum(case when nProductTransacType in(100001,100015,100045) then ((case when nStcokDirection=300002 then ");
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
      stringBuilder3.append(".t_productdoc.fDiscount*100)) else 1 end)) else 0 end) discount,");
      stringBuilder1.append(stringBuilder3.toString());
      stringBuilder1.append("sum(case when nProductTransacType!=100060 then 0 when nStcokDirection=300002 then fAmount else -fAmount end) tax,");
      stringBuilder1.append("sum(case when nProductTransacType!=100068 then 0 when nStcokDirection=300002 then fAmount else -fAmount end) serviceCharge ");
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append("from ");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc ");
      stringBuilder1.append(stringBuilder3.toString());
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append(" where ");
      stringBuilder3.append((String)entry.getValue());
      stringBuilder3.append(".t_productdoc.nDateTime >=");
      String str1 = stringBuilder3.toString();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(" and ");
      stringBuilder4.append((String)entry.getValue());
      stringBuilder4.append(".t_productdoc.nDateTime<=");
      String str2 = stringBuilder4.toString();
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append(" and ");
      stringBuilder5.append((String)entry.getValue());
      stringBuilder5.append(".t_productdoc.nShopID=");
      String str3 = stringBuilder5.toString();
      String str4 = VC();
      StringBuilder stringBuilder6 = new StringBuilder();
      stringBuilder6.append(" and (");
      stringBuilder6.append((String)entry.getValue());
      stringBuilder6.append(".t_productdoc.nDeletionFlag is null or ");
      stringBuilder6.append((String)entry.getValue());
      stringBuilder6.append(".t_productdoc.nDeletionFlag!=1) ");
      stringBuilder1.append(n.h(new Object[] { str1, Long.valueOf(paramLong1), str2, Long.valueOf(paramLong2), str3, str4, stringBuilder6.toString() }));
      stringBuilder1.append(" and nProductTransacType in(100001,100015,100045,100060,100068)");
      if (m != this.bNh.size()) {
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append(null);
        stringBuilder7.append(stringBuilder1.toString());
        stringBuilder7.append(" union all ");
        null = stringBuilder7.toString();
        continue;
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(null);
      stringBuilder2.append(stringBuilder1.toString());
      null = stringBuilder2.toString();
    } 
    null = new StringBuilder();
    null.append(null);
    null.append(")");
    null = null.toString();
    null = this.cZS.rawQuery(null, null);
    null.moveToNext();
    double d2 = null.getDouble(null.getColumnIndex("rounding"));
    double d3 = null.getDouble(null.getColumnIndex("amount"));
    double d4 = null.getDouble(null.getColumnIndex("tax"));
    double d5 = null.getDouble(null.getColumnIndex("serviceCharge"));
    double d6 = null.getDouble(null.getColumnIndex("discount")) + d2;
    null.close();
    d.x(new String[] { "Gross Sales", n.ba(d3 + d6 - d2) });
    d.x(new String[] { "Discount", n.ba(d6) });
    if (!n.bc(d2) || a.AZ().BK())
      d.x(new String[] { "Rounding", n.ba(d2) }); 
    d.setSize(3);
    d.x(new String[] { "Amount", n.ba(d3) });
    d.setSize(0);
    d.l('-');
    d.x(new String[] { "Tax", n.ba(d4) });
    d.x(new String[] { "Serv. Charge", n.ba(d5) });
    d.x(new String[] { "Sales Amount", n.ba(d3 - d4 - d2 - d5) });
    null = set.iterator();
    null = "select taxName,taxValue,sum(amountOfProduct),sum(amountOfTax) from(";
    m = 0;
    while (null.hasNext()) {
      Map.Entry entry = (Map.Entry)null.next();
      m++;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.setLength(0);
      stringBuilder1.append("select ");
      stringBuilder1.append("t_tax.sName taxName,t_tax.fValue taxValue");
      stringBuilder1.append(",sum(case when nStcokDirection=300002 then fSpareField4 else -fSpareField4 end) amountOfProduct");
      stringBuilder1.append(",sum(case when nStcokDirection=300002 then fAmount else -fAmount end) amountOfTax ");
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(" from ");
      stringBuilder2.append((String)entry.getValue());
      stringBuilder2.append(".t_productdoc ");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(" left join t_tax on ");
      stringBuilder2.append((String)entry.getValue());
      stringBuilder2.append(".t_productdoc.nProductID=t_tax._id ");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder1.append(16843035);
      stringBuilder1.append(" and nProductTransacType =100060");
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(" group by ");
      stringBuilder2.append((String)entry.getValue());
      stringBuilder2.append(".t_productdoc.nProductID");
      stringBuilder1.append(stringBuilder2.toString());
      if (m != this.bNh.size()) {
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(null);
        stringBuilder3.append(stringBuilder1.toString());
        stringBuilder3.append(" union all ");
        null = stringBuilder3.toString();
        continue;
      } 
      null = stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(null);
    stringBuilder.append(")");
    null = stringBuilder.toString();
    Cursor cursor = this.cZS.rawQuery(null, null);
    if (cursor.getCount() > 0) {
      m = (int)(0.4D * d1);
      int n = (int)(0.3D * d1);
      d.n(new int[] { m, n, k - m - n });
      d.ll("");
      d.x(new String[] { this.mContext.getString(2131627983), this.mContext.getString(2131627981), this.mContext.getString(2131627982) });
      d.l('-');
      while (cursor.moveToNext()) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(cursor.getString(0));
        stringBuilder.append("=");
        stringBuilder.append(cursor.getDouble(1));
        stringBuilder.append("%");
        d.x(new String[] { stringBuilder.toString(), n.a(Double.valueOf(cursor.getDouble(2)), true, false), n.a(Double.valueOf(cursor.getDouble(3)), true, false) });
      } 
    } 
    cursor.close();
    return a;
  }
  
  protected double[] AW() { return this.daq; }
  
  @NonNull
  public String AX() { return this.mContext.getString(2131627860); }
  
  public PrintContent.a a(long paramLong1, long paramLong2, ArrayList<HashMap<String, String>> paramArrayList) {
    null = new Time();
    null.set(paramLong1);
    String str1 = null.format(ann());
    null.set(paramLong2);
    String str2 = null.format(ann());
    if (!by.isNull(this.dcY)) {
      f.a a = new f.a();
      a.start = this.startTime;
      a.end = this.aRC;
      a.aSI = VC();
      a.das = this.dcY;
      if (!by.isNull(this.orderTypeID))
        a.aST = Long.valueOf(this.orderTypeID).longValue(); 
      this.dcZ.a(a, Vq());
      return this.dcZ.I(str1, str2, VC());
    } 
    return z(paramLong1, paramLong2);
  }
  
  public String a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, v paramv, String paramString1, String paramString2) {
    try {
      f f1;
      b(paramLong1, paramLong2, this.mContext.getString(2131627842));
      a((new t.a(paramLong1, paramLong2)).dh(paramLong3).k(paramArrayOfLong).d(paramv).no(this.dcY).np(this.orderTypeID).anl());
      paramArrayList = anr();
      if (!by.isNull(this.dcY)) {
        f.a a = new f.a();
        a.start = this.startTime;
        a.end = this.aRC;
        a.aSI = VC();
        a.das = this.dcY;
        (new h(this.mContext)).iB(this.dcY);
        if (!by.isNull(this.orderTypeID))
          a.aST = Long.valueOf(this.orderTypeID).longValue(); 
        this.dcZ.b(a, Vq());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" deliveryManID=");
      stringBuilder1.append(this.dcY);
      Log.d("exportToFile", stringBuilder1.toString());
      Context context = new ArrayList();
      context.add(new s.a(this.mContext.getString(2131627862), y(paramLong1, paramLong2)));
      context.add(new s.a(this.mContext.getString(2131627864), paramString1));
      context.add(new s.a(this.mContext.getString(2131627861), paramString2));
      StringBuilder stringBuilder2 = new ArrayList();
      stringBuilder2.add(new s.a(this.mContext.getString(2131627831), n.a(this.mContext, Double.valueOf(amw()[1]), true, true)));
      ArrayList arrayList2 = new ArrayList();
      ArrayList arrayList1 = new ArrayList();
      if (this.mContext.getResources().getBoolean(2131034117))
        arrayList2.add(dcG); 
      arrayList2.add(dam);
      arrayList2.add(dan);
      arrayList2.add(daB);
      arrayList2.add(dcH);
      arrayList2.add(bzY);
      if (this.mContext.getResources().getBoolean(2131034126))
        arrayList2.add(dcU); 
      if (this.mContext.getResources().getBoolean(2131034127)) {
        arrayList2.add(dcT);
        arrayList2.add(dcW);
      } 
      arrayList2.add(dcI);
      arrayList2.add(dcJ);
      arrayList2.add(dcK);
      arrayList2.add(dcL);
      arrayList1.add(dcH);
      arrayList1.add(bzY);
      if (this.mContext.getResources().getBoolean(2131034127)) {
        arrayList1.add(dcT);
        arrayList1.add(dcU);
        arrayList1.add(dcW);
      } 
      arrayList1.add(dcI);
      arrayList1.add(dcJ);
      arrayList1.add(dcL);
      if (this.mContext.getResources().getBoolean(2131034129)) {
        arrayList2.add(dcM);
        arrayList1.add(dcM);
      } 
      if (this.mContext.getResources().getBoolean(2131034136)) {
        arrayList2.add(dcN);
        arrayList1.add(dcN);
      } 
      if (this.mContext.getResources().getBoolean(2131034133)) {
        arrayList2.add(dcO);
        arrayList2.add(dcP);
        arrayList1.add(dcO);
        arrayList1.add(dcP);
      } 
      arrayList2.add(dcQ);
      arrayList1.add(dcQ);
      arrayList2.add(dcR);
      arrayList1.add(dcR);
      arrayList2.add(dcS);
      arrayList1.add(dcS);
      arrayList2.add(dcf);
      String[] arrayOfString1 = new String[arrayList2.size()];
      arrayList2.toArray(arrayOfString1);
      String[] arrayOfString2 = new String[arrayList1.size()];
      arrayList1.toArray(arrayOfString2);
      if (!by.isNull(this.dcY)) {
        f1 = this.dcZ;
        context = this.mContext;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(amw()[1]);
        stringBuilder2.append("");
        return a(f1.r(context, stringBuilder2.toString()));
      } 
      return a(new s(this.mContext.getString(2131627872), this.mContext.getString(2131627872), context, stringBuilder2, f1, bzT, arrayOfString1, arrayOfString2));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public void a(t paramt) {
    this.daq = null;
    this.daA = null;
    this.dby = 0;
    this.dax = paramt;
    this.dcY = paramt.anj();
    this.orderTypeID = paramt.yq();
    this.startTime = paramt.ane();
    this.aRC = paramt.anf();
    this.dcw = paramt.anh();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("deliverPersonID is:");
    stringBuilder.append(paramt.anj());
    d.b(stringBuilder.toString(), new Object[0]);
    stringBuilder = new StringBuilder();
    stringBuilder.append("orderTypeID is:");
    stringBuilder.append(paramt.yq());
    d.b(stringBuilder.toString(), new Object[0]);
    try {
      this.cZS = r(this.startTime, this.aRC);
      this.bNh = b.f(this.startTime, this.aRC);
      return;
    } catch (Exception paramt) {
      a.e(paramt);
      return;
    } 
  }
  
  public void nv(String paramString) { this.dcX = paramString; }
  
  public ArrayList<HashMap<String, String>> zJ() { // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: lstore #34
    //   5: new java/util/ArrayList
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore #40
    //   14: aload_0
    //   15: invokespecial anA : ()Z
    //   18: ifeq -> 326
    //   21: aload_0
    //   22: invokespecial amH : ()Landroid/database/Cursor;
    //   25: astore #41
    //   27: aload_0
    //   28: invokespecial anB : ()Landroid/database/Cursor;
    //   31: astore #42
    //   33: aload #41
    //   35: invokeinterface getCount : ()I
    //   40: istore #23
    //   42: aload #42
    //   44: invokeinterface getCount : ()I
    //   49: istore #24
    //   51: aload_0
    //   52: invokevirtual ans : ()Z
    //   55: ifne -> 82
    //   58: iload #23
    //   60: aload_0
    //   61: invokevirtual getPageSize : ()I
    //   64: if_icmplt -> 73
    //   67: iconst_1
    //   68: istore #38
    //   70: goto -> 76
    //   73: iconst_0
    //   74: istore #38
    //   76: aload_0
    //   77: iload #38
    //   79: invokevirtual gC : (Z)V
    //   82: new java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial <init> : ()V
    //   89: astore #39
    //   91: aload #41
    //   93: invokeinterface moveToFirst : ()Z
    //   98: ifeq -> 218
    //   101: new java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial <init> : ()V
    //   108: astore #43
    //   110: aload #43
    //   112: ldc_w '''
    //   115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload #43
    //   121: aload #41
    //   123: iconst_0
    //   124: invokeinterface getString : (I)Ljava/lang/String;
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload #43
    //   135: ldc_w '''
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload #39
    //   144: aload #43
    //   146: invokevirtual toString : ()Ljava/lang/String;
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload #41
    //   155: invokeinterface moveToNext : ()Z
    //   160: ifeq -> 218
    //   163: new java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial <init> : ()V
    //   170: astore #43
    //   172: aload #43
    //   174: ldc_w ',''
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload #43
    //   183: aload #41
    //   185: iconst_0
    //   186: invokeinterface getString : (I)Ljava/lang/String;
    //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload #43
    //   197: ldc_w '''
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload #39
    //   206: aload #43
    //   208: invokevirtual toString : ()Ljava/lang/String;
    //   211: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: goto -> 153
    //   218: aload #42
    //   220: invokeinterface moveToFirst : ()Z
    //   225: ifeq -> 263
    //   228: aload #42
    //   230: iconst_2
    //   231: invokeinterface getDouble : (I)D
    //   236: dstore_1
    //   237: dload_1
    //   238: dstore_3
    //   239: aload #42
    //   241: invokeinterface moveToNext : ()Z
    //   246: ifeq -> 265
    //   249: dload_1
    //   250: aload #42
    //   252: iconst_2
    //   253: invokeinterface getDouble : (I)D
    //   258: dadd
    //   259: dstore_1
    //   260: goto -> 237
    //   263: dconst_0
    //   264: dstore_3
    //   265: new java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial <init> : ()V
    //   272: astore #43
    //   274: aload #43
    //   276: ldc_w 't_productdoc.sOrderNo in('
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload #43
    //   285: aload #39
    //   287: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload #43
    //   293: ldc_w ')'
    //   296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload #43
    //   302: invokevirtual toString : ()Ljava/lang/String;
    //   305: astore #39
    //   307: aload #41
    //   309: invokeinterface close : ()V
    //   314: aload #42
    //   316: invokeinterface close : ()V
    //   321: dload_3
    //   322: dstore_1
    //   323: goto -> 352
    //   326: aload_0
    //   327: invokevirtual ans : ()Z
    //   330: ifne -> 338
    //   333: aload_0
    //   334: iconst_0
    //   335: invokevirtual gC : (Z)V
    //   338: aload_0
    //   339: getfield aJZ : Ljava/lang/String;
    //   342: astore #39
    //   344: iconst_1
    //   345: istore #23
    //   347: iconst_0
    //   348: istore #24
    //   350: dconst_0
    //   351: dstore_1
    //   352: iload #23
    //   354: ifle -> 2567
    //   357: aload_0
    //   358: aload #39
    //   360: invokespecial ni : (Ljava/lang/String;)Landroid/database/Cursor;
    //   363: astore #45
    //   365: new android/text/format/Time
    //   368: dup
    //   369: invokespecial <init> : ()V
    //   372: astore #39
    //   374: ldc ''
    //   376: astore #41
    //   378: aconst_null
    //   379: astore #43
    //   381: dconst_0
    //   382: dstore #7
    //   384: dconst_0
    //   385: dstore #9
    //   387: dconst_0
    //   388: dstore #11
    //   390: iconst_m1
    //   391: istore #26
    //   393: dconst_0
    //   394: dstore #15
    //   396: dconst_0
    //   397: dstore #13
    //   399: dconst_0
    //   400: dstore_3
    //   401: ldc ''
    //   403: astore #42
    //   405: iconst_0
    //   406: istore #25
    //   408: dload_1
    //   409: dstore #5
    //   411: aload #45
    //   413: invokeinterface moveToNext : ()Z
    //   418: ifeq -> 2391
    //   421: new java/util/HashMap
    //   424: dup
    //   425: invokespecial <init> : ()V
    //   428: astore #49
    //   430: aload #49
    //   432: ldc_w 'orderNo'
    //   435: aload #45
    //   437: aload #45
    //   439: ldc_w 'orderNo'
    //   442: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   447: invokeinterface getString : (I)Ljava/lang/String;
    //   452: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   455: pop
    //   456: aload #45
    //   458: aload #45
    //   460: ldc_w 'productNames'
    //   463: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   468: invokeinterface getString : (I)Ljava/lang/String;
    //   473: ldc ',,'
    //   475: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   478: astore #47
    //   480: aload #45
    //   482: aload #45
    //   484: ldc_w 'qtys'
    //   487: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   492: invokeinterface getString : (I)Ljava/lang/String;
    //   497: ldc ',,'
    //   499: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   502: astore #48
    //   504: aload #45
    //   506: aload #45
    //   508: ldc_w 'amounts'
    //   511: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   516: invokeinterface getDouble : (I)D
    //   521: dstore #19
    //   523: aload #45
    //   525: aload #45
    //   527: ldc_w 'dateTime'
    //   530: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   535: invokeinterface getLong : (I)J
    //   540: lstore #36
    //   542: new java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial <init> : ()V
    //   549: astore #44
    //   551: aload #44
    //   553: lload #36
    //   555: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload #44
    //   561: ldc ''
    //   563: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload #49
    //   569: ldc_w 'ORDERTIME'
    //   572: aload #44
    //   574: invokevirtual toString : ()Ljava/lang/String;
    //   577: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   580: pop
    //   581: aload #45
    //   583: aload #45
    //   585: ldc_w 'productTransacTypes'
    //   588: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   593: invokeinterface getString : (I)Ljava/lang/String;
    //   598: astore #44
    //   600: aload #45
    //   602: aload #45
    //   604: ldc_w 'source'
    //   607: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   612: invokeinterface getInt : (I)I
    //   617: istore #28
    //   619: aload #45
    //   621: aload #45
    //   623: ldc_w 'preferentialAmount'
    //   626: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   631: invokeinterface getDouble : (I)D
    //   636: dstore #17
    //   638: aload #45
    //   640: ldc_w 'sSpareField3'
    //   643: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   648: istore #31
    //   650: aload #45
    //   652: ldc_w 'nPhysicalInventoryID'
    //   655: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   660: istore #32
    //   662: iload #25
    //   664: istore #27
    //   666: aload #45
    //   668: ldc_w 'sHeaderText'
    //   671: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   676: istore #33
    //   678: aload_0
    //   679: invokevirtual ans : ()Z
    //   682: ifeq -> 964
    //   685: aload #45
    //   687: aload #45
    //   689: ldc_w 'accountIDs'
    //   692: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   697: invokeinterface getString : (I)Ljava/lang/String;
    //   702: astore #42
    //   704: aload #45
    //   706: aload #45
    //   708: ldc_w 'accountAmounts'
    //   711: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   716: invokeinterface getString : (I)Ljava/lang/String;
    //   721: astore #41
    //   723: aload #45
    //   725: ldc_w 'bpartnerNewAmount'
    //   728: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   733: istore #25
    //   735: aload #49
    //   737: getstatic com/laiqian/report/models/ad.dcL : Ljava/lang/String;
    //   740: aload #45
    //   742: iload #25
    //   744: invokeinterface getString : (I)Ljava/lang/String;
    //   749: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   752: pop
    //   753: aload #45
    //   755: ldc_w 'bpartnerNumber'
    //   758: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   763: istore #25
    //   765: aload #49
    //   767: getstatic com/laiqian/report/models/ad.dcK : Ljava/lang/String;
    //   770: aload #45
    //   772: iload #25
    //   774: invokeinterface getString : (I)Ljava/lang/String;
    //   779: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   782: pop
    //   783: aload #45
    //   785: ldc_w 'userPhone'
    //   788: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   793: istore #25
    //   795: aload #49
    //   797: getstatic com/laiqian/report/models/ad.dcf : Ljava/lang/String;
    //   800: aload #45
    //   802: iload #25
    //   804: invokeinterface getString : (I)Ljava/lang/String;
    //   809: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   812: pop
    //   813: aload #45
    //   815: aload #45
    //   817: ldc_w 'amountRounding'
    //   820: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   825: invokeinterface getDouble : (I)D
    //   830: dstore_1
    //   831: aload #45
    //   833: aload #45
    //   835: ldc_w 'tax'
    //   838: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   843: invokeinterface getDouble : (I)D
    //   848: dstore #13
    //   850: aload #45
    //   852: aload #45
    //   854: ldc_w 'serviceCharge'
    //   857: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   862: invokeinterface getDouble : (I)D
    //   867: dstore_3
    //   868: aload #45
    //   870: ldc_w 'billNumber'
    //   873: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   878: istore #25
    //   880: aload #49
    //   882: getstatic com/laiqian/report/models/ad.dcG : Ljava/lang/String;
    //   885: aload #45
    //   887: iload #25
    //   889: invokeinterface getString : (I)Ljava/lang/String;
    //   894: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   897: pop
    //   898: aload #45
    //   900: ldc_w 'discount'
    //   903: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   908: istore #25
    //   910: aload #49
    //   912: getstatic com/laiqian/report/models/ad.dcH : Ljava/lang/String;
    //   915: aload_0
    //   916: aload #45
    //   918: iload #25
    //   920: invokeinterface getDouble : (I)D
    //   925: invokestatic valueOf : (D)Ljava/lang/Double;
    //   928: invokevirtual aQ : (Ljava/lang/Object;)Ljava/lang/String;
    //   931: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   934: pop
    //   935: aload #49
    //   937: ldc_w 'name'
    //   940: aload #45
    //   942: aload #45
    //   944: ldc_w 'name'
    //   947: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   952: invokeinterface getString : (I)Ljava/lang/String;
    //   957: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   960: pop
    //   961: goto -> 971
    //   964: iload #26
    //   966: istore #25
    //   968: dload #15
    //   970: dstore_1
    //   971: aload #43
    //   973: astore #46
    //   975: aload #44
    //   977: ldc_w '100001'
    //   980: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   983: istore #38
    //   985: aload #44
    //   987: ldc ',,'
    //   989: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   992: astore #50
    //   994: new java/lang/StringBuilder
    //   997: dup
    //   998: invokespecial <init> : ()V
    //   1001: astore #51
    //   1003: aconst_null
    //   1004: astore #43
    //   1006: iconst_0
    //   1007: istore #30
    //   1009: iconst_0
    //   1010: istore #29
    //   1012: iload #28
    //   1014: istore #26
    //   1016: iload #30
    //   1018: istore #28
    //   1020: iload #28
    //   1022: aload #48
    //   1024: arraylength
    //   1025: if_icmpge -> 1248
    //   1028: ldc_w '100001'
    //   1031: aload #50
    //   1033: iload #28
    //   1035: aaload
    //   1036: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1039: ifne -> 1077
    //   1042: ldc_w '100066'
    //   1045: aload #50
    //   1047: iload #28
    //   1049: aaload
    //   1050: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1053: ifne -> 1077
    //   1056: ldc_w '100015'
    //   1059: aload #50
    //   1061: iload #28
    //   1063: aaload
    //   1064: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1067: ifne -> 1077
    //   1070: iload #29
    //   1072: istore #30
    //   1074: goto -> 1235
    //   1077: aload #43
    //   1079: astore #44
    //   1081: aload #43
    //   1083: ifnonnull -> 1093
    //   1086: aload #50
    //   1088: iload #28
    //   1090: aaload
    //   1091: astore #44
    //   1093: aload #44
    //   1095: astore #43
    //   1097: iload #29
    //   1099: istore #30
    //   1101: aload #48
    //   1103: iload #28
    //   1105: aaload
    //   1106: ldc_w '-'
    //   1109: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1112: ifne -> 1235
    //   1115: iload #29
    //   1117: ifle -> 1129
    //   1120: aload #51
    //   1122: ldc_w '/'
    //   1125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: pop
    //   1129: iload #29
    //   1131: iconst_1
    //   1132: iadd
    //   1133: istore #30
    //   1135: aload #51
    //   1137: aload #47
    //   1139: iload #28
    //   1141: aaload
    //   1142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: pop
    //   1146: iload #38
    //   1148: ifeq -> 1216
    //   1151: ldc_w '100015'
    //   1154: aload #50
    //   1156: iload #28
    //   1158: aaload
    //   1159: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1162: ifeq -> 1216
    //   1165: new java/lang/StringBuilder
    //   1168: dup
    //   1169: invokespecial <init> : ()V
    //   1172: astore #43
    //   1174: aload #43
    //   1176: ldc_w '-'
    //   1179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: pop
    //   1183: aload #43
    //   1185: aload #48
    //   1187: iload #28
    //   1189: aaload
    //   1190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: aload #51
    //   1196: aload_0
    //   1197: aload #43
    //   1199: invokevirtual toString : ()Ljava/lang/String;
    //   1202: invokespecial nj : (Ljava/lang/String;)Ljava/lang/String;
    //   1205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: pop
    //   1209: aload #44
    //   1211: astore #43
    //   1213: goto -> 1235
    //   1216: aload #51
    //   1218: aload_0
    //   1219: aload #48
    //   1221: iload #28
    //   1223: aaload
    //   1224: invokespecial nj : (Ljava/lang/String;)Ljava/lang/String;
    //   1227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: pop
    //   1231: aload #44
    //   1233: astore #43
    //   1235: iload #28
    //   1237: iconst_1
    //   1238: iadd
    //   1239: istore #28
    //   1241: iload #30
    //   1243: istore #29
    //   1245: goto -> 1020
    //   1248: aload #49
    //   1250: getstatic com/laiqian/report/models/ad.daB : Ljava/lang/String;
    //   1253: aload #51
    //   1255: invokevirtual toString : ()Ljava/lang/String;
    //   1258: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1261: pop
    //   1262: aload #49
    //   1264: getstatic com/laiqian/report/models/ad.bzY : Ljava/lang/String;
    //   1267: dload #19
    //   1269: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1272: invokestatic d : (Ljava/lang/Number;)Ljava/lang/String;
    //   1275: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1278: pop
    //   1279: dload #11
    //   1281: dload #19
    //   1283: dadd
    //   1284: dstore #21
    //   1286: getstatic com/laiqian/report/models/ad.TAG : Ljava/lang/String;
    //   1289: astore #44
    //   1291: new java/lang/StringBuilder
    //   1294: dup
    //   1295: invokespecial <init> : ()V
    //   1298: astore #47
    //   1300: aload #47
    //   1302: ldc_w 'getData sumAmout-->'
    //   1305: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: pop
    //   1309: aload #47
    //   1311: dload #21
    //   1313: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1316: pop
    //   1317: aload #47
    //   1319: ldc_w '-mAmount-->'
    //   1322: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: aload #47
    //   1328: dload #19
    //   1330: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1333: pop
    //   1334: aload #44
    //   1336: aload #47
    //   1338: invokevirtual toString : ()Ljava/lang/String;
    //   1341: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   1344: pop
    //   1345: aload #39
    //   1347: lload #36
    //   1349: invokevirtual set : (J)V
    //   1352: aload #39
    //   1354: invokestatic ann : ()Ljava/lang/String;
    //   1357: invokevirtual format : (Ljava/lang/String;)Ljava/lang/String;
    //   1360: ldc_w ' '
    //   1363: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1366: astore #44
    //   1368: aload #44
    //   1370: iconst_0
    //   1371: aaload
    //   1372: astore #50
    //   1374: aload #49
    //   1376: getstatic com/laiqian/report/models/ad.dam : Ljava/lang/String;
    //   1379: aload #44
    //   1381: iconst_1
    //   1382: aaload
    //   1383: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1386: pop
    //   1387: new java/lang/StringBuilder
    //   1390: dup
    //   1391: invokespecial <init> : ()V
    //   1394: astore #44
    //   1396: aload #44
    //   1398: iload #26
    //   1400: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: aload #44
    //   1406: ldc ''
    //   1408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: pop
    //   1412: aload #49
    //   1414: ldc_w 'sourceCode'
    //   1417: aload #44
    //   1419: invokevirtual toString : ()Ljava/lang/String;
    //   1422: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1425: pop
    //   1426: aload #45
    //   1428: iload #33
    //   1430: invokeinterface getString : (I)Ljava/lang/String;
    //   1435: astore #44
    //   1437: new com/laiqian/report/models/ab
    //   1440: dup
    //   1441: invokespecial <init> : ()V
    //   1444: aload #44
    //   1446: invokevirtual nt : (Ljava/lang/String;)Ljava/lang/String;
    //   1449: astore #44
    //   1451: aload #45
    //   1453: iload #31
    //   1455: invokeinterface getString : (I)Ljava/lang/String;
    //   1460: astore #47
    //   1462: aload #44
    //   1464: invokestatic isNull : (Ljava/lang/String;)Z
    //   1467: ifne -> 1473
    //   1470: goto -> 1477
    //   1473: aload #47
    //   1475: astore #44
    //   1477: aload #44
    //   1479: astore #47
    //   1481: aload #44
    //   1483: invokestatic isNull : (Ljava/lang/String;)Z
    //   1486: ifeq -> 1500
    //   1489: aload #45
    //   1491: iload #32
    //   1493: invokeinterface getString : (I)Ljava/lang/String;
    //   1498: astore #47
    //   1500: aload #47
    //   1502: invokestatic isNull : (Ljava/lang/String;)Z
    //   1505: ifeq -> 1515
    //   1508: ldc ''
    //   1510: astore #44
    //   1512: goto -> 1600
    //   1515: iload #26
    //   1517: bipush #7
    //   1519: if_icmpne -> 1545
    //   1522: aload_0
    //   1523: getfield mContext : Landroid/content/Context;
    //   1526: astore #44
    //   1528: ldc_w 2131628301
    //   1531: istore #28
    //   1533: aload #44
    //   1535: iload #28
    //   1537: invokevirtual getString : (I)Ljava/lang/String;
    //   1540: astore #44
    //   1542: goto -> 1559
    //   1545: aload_0
    //   1546: getfield mContext : Landroid/content/Context;
    //   1549: astore #44
    //   1551: ldc_w 2131629949
    //   1554: istore #28
    //   1556: goto -> 1533
    //   1559: new java/lang/StringBuilder
    //   1562: dup
    //   1563: invokespecial <init> : ()V
    //   1566: astore #48
    //   1568: aload #48
    //   1570: aload #44
    //   1572: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: pop
    //   1576: aload #48
    //   1578: ldc_w ' '
    //   1581: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: pop
    //   1585: aload #48
    //   1587: aload #47
    //   1589: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: pop
    //   1593: aload #48
    //   1595: invokevirtual toString : ()Ljava/lang/String;
    //   1598: astore #44
    //   1600: aload #49
    //   1602: getstatic com/laiqian/report/models/ad.dcV : Ljava/lang/String;
    //   1605: aload #44
    //   1607: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1610: pop
    //   1611: aload_0
    //   1612: invokevirtual ans : ()Z
    //   1615: ifeq -> 2047
    //   1618: aload #42
    //   1620: ifnull -> 1756
    //   1623: aload #41
    //   1625: ifnull -> 1756
    //   1628: aload #42
    //   1630: ldc ',,'
    //   1632: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1635: astore #47
    //   1637: aload #41
    //   1639: ldc ',,'
    //   1641: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   1644: astore #44
    //   1646: iconst_0
    //   1647: istore #28
    //   1649: iload #28
    //   1651: aload #47
    //   1653: arraylength
    //   1654: if_icmpge -> 1753
    //   1657: iload #28
    //   1659: aload #44
    //   1661: arraylength
    //   1662: if_icmpge -> 1753
    //   1665: aload_0
    //   1666: aload #47
    //   1668: iload #28
    //   1670: aaload
    //   1671: invokespecial nu : (Ljava/lang/String;)Ljava/lang/String;
    //   1674: astore #51
    //   1676: aload #44
    //   1678: iload #28
    //   1680: aaload
    //   1681: astore #48
    //   1683: iload #28
    //   1685: ifle -> 1730
    //   1688: aload #49
    //   1690: aload #51
    //   1692: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1695: checkcast java/lang/String
    //   1698: astore #52
    //   1700: aload #52
    //   1702: ifnull -> 1727
    //   1705: aload #48
    //   1707: invokestatic aU : (Ljava/lang/Object;)D
    //   1710: aload #52
    //   1712: invokestatic pm : (Ljava/lang/String;)Ljava/lang/String;
    //   1715: invokestatic aU : (Ljava/lang/Object;)D
    //   1718: dadd
    //   1719: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1722: astore #48
    //   1724: goto -> 1730
    //   1727: goto -> 1730
    //   1730: aload #49
    //   1732: aload #51
    //   1734: aload_0
    //   1735: aload #48
    //   1737: invokevirtual aQ : (Ljava/lang/Object;)Ljava/lang/String;
    //   1740: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1743: pop
    //   1744: iload #28
    //   1746: iconst_1
    //   1747: iadd
    //   1748: istore #28
    //   1750: goto -> 1649
    //   1753: goto -> 1756
    //   1756: dload_1
    //   1757: dstore #11
    //   1759: dload_3
    //   1760: dstore #15
    //   1762: ldc_w '100015'
    //   1765: aload #43
    //   1767: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1770: ifeq -> 1787
    //   1773: dload_1
    //   1774: ldc2_w -1.0
    //   1777: dmul
    //   1778: dstore #11
    //   1780: dload_3
    //   1781: ldc2_w -1.0
    //   1784: dmul
    //   1785: dstore #15
    //   1787: aload #49
    //   1789: getstatic com/laiqian/report/models/ad.dcT : Ljava/lang/String;
    //   1792: aload_0
    //   1793: dload #19
    //   1795: dload #13
    //   1797: dsub
    //   1798: dload #11
    //   1800: dsub
    //   1801: dload #15
    //   1803: dsub
    //   1804: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1807: invokevirtual aQ : (Ljava/lang/Object;)Ljava/lang/String;
    //   1810: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1813: pop
    //   1814: aload #49
    //   1816: getstatic com/laiqian/report/models/ad.dcU : Ljava/lang/String;
    //   1819: aload_0
    //   1820: dload #15
    //   1822: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1825: invokevirtual aQ : (Ljava/lang/Object;)Ljava/lang/String;
    //   1828: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1831: pop
    //   1832: aload #49
    //   1834: getstatic com/laiqian/report/models/ad.dcW : Ljava/lang/String;
    //   1837: aload_0
    //   1838: dload #13
    //   1840: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1843: invokevirtual aQ : (Ljava/lang/Object;)Ljava/lang/String;
    //   1846: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1849: pop
    //   1850: aload #49
    //   1852: getstatic com/laiqian/report/models/ad.dcH : Ljava/lang/String;
    //   1855: aload_0
    //   1856: aload #45
    //   1858: iload #25
    //   1860: invokeinterface getDouble : (I)D
    //   1865: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1868: invokevirtual aQ : (Ljava/lang/Object;)Ljava/lang/String;
    //   1871: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1874: pop
    //   1875: iload #26
    //   1877: ifne -> 1896
    //   1880: aload #49
    //   1882: getstatic com/laiqian/report/models/ad.dan : Ljava/lang/String;
    //   1885: aload_0
    //   1886: getfield dcz : Ljava/lang/String;
    //   1889: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1892: pop
    //   1893: goto -> 2038
    //   1896: iload #26
    //   1898: iconst_1
    //   1899: if_icmpne -> 1918
    //   1902: aload #49
    //   1904: getstatic com/laiqian/report/models/ad.dan : Ljava/lang/String;
    //   1907: aload_0
    //   1908: getfield dcA : Ljava/lang/String;
    //   1911: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1914: pop
    //   1915: goto -> 2038
    //   1918: iload #26
    //   1920: iconst_3
    //   1921: if_icmpne -> 1940
    //   1924: aload #49
    //   1926: getstatic com/laiqian/report/models/ad.dan : Ljava/lang/String;
    //   1929: aload_0
    //   1930: getfield dcB : Ljava/lang/String;
    //   1933: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1936: pop
    //   1937: goto -> 2038
    //   1940: iload #26
    //   1942: iconst_5
    //   1943: if_icmpeq -> 2025
    //   1946: iload #26
    //   1948: bipush #6
    //   1950: if_icmpne -> 1956
    //   1953: goto -> 2025
    //   1956: iload #26
    //   1958: bipush #7
    //   1960: if_icmpne -> 1979
    //   1963: aload #49
    //   1965: getstatic com/laiqian/report/models/ad.dan : Ljava/lang/String;
    //   1968: aload_0
    //   1969: getfield dcD : Ljava/lang/String;
    //   1972: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1975: pop
    //   1976: goto -> 2038
    //   1979: iload #26
    //   1981: bipush #8
    //   1983: if_icmpne -> 2002
    //   1986: aload #49
    //   1988: getstatic com/laiqian/report/models/ad.dan : Ljava/lang/String;
    //   1991: aload_0
    //   1992: getfield dcE : Ljava/lang/String;
    //   1995: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1998: pop
    //   1999: goto -> 2038
    //   2002: iload #26
    //   2004: bipush #9
    //   2006: if_icmpne -> 2038
    //   2009: aload #49
    //   2011: getstatic com/laiqian/report/models/ad.dan : Ljava/lang/String;
    //   2014: aload_0
    //   2015: getfield dcF : Ljava/lang/String;
    //   2018: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2021: pop
    //   2022: goto -> 2038
    //   2025: aload #49
    //   2027: getstatic com/laiqian/report/models/ad.dan : Ljava/lang/String;
    //   2030: aload_0
    //   2031: getfield dcC : Ljava/lang/String;
    //   2034: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2037: pop
    //   2038: dload #15
    //   2040: dstore_3
    //   2041: dload #11
    //   2043: dstore_1
    //   2044: goto -> 2047
    //   2047: aload #50
    //   2049: aload_0
    //   2050: getfield daA : Ljava/lang/String;
    //   2053: invokevirtual equals : (Ljava/lang/Object;)Z
    //   2056: ifeq -> 2098
    //   2059: aload #46
    //   2061: ifnull -> 2087
    //   2064: dload #7
    //   2066: dload #19
    //   2068: dadd
    //   2069: dstore #7
    //   2071: dload #9
    //   2073: dload #17
    //   2075: dadd
    //   2076: dstore #9
    //   2078: iload #27
    //   2080: iconst_1
    //   2081: iadd
    //   2082: istore #26
    //   2084: goto -> 2091
    //   2087: iload #27
    //   2089: istore #26
    //   2091: aload #46
    //   2093: astore #43
    //   2095: goto -> 2361
    //   2098: new java/util/HashMap
    //   2101: dup
    //   2102: invokespecial <init> : ()V
    //   2105: astore #43
    //   2107: aload #39
    //   2109: astore #44
    //   2111: aload #44
    //   2113: lload #36
    //   2115: invokevirtual set : (J)V
    //   2118: aload #43
    //   2120: getstatic com/laiqian/report/models/ad.bzT : Ljava/lang/String;
    //   2123: aload #50
    //   2125: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2128: pop
    //   2129: aload #43
    //   2131: getstatic com/laiqian/report/models/ad.dam : Ljava/lang/String;
    //   2134: aload_0
    //   2135: aload #50
    //   2137: invokevirtual nq : (Ljava/lang/String;)Ljava/lang/String;
    //   2140: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2143: pop
    //   2144: aload #43
    //   2146: getstatic com/laiqian/report/models/ad.daB : Ljava/lang/String;
    //   2149: aload_0
    //   2150: aload #44
    //   2152: getfield weekDay : I
    //   2155: invokevirtual jL : (I)Ljava/lang/String;
    //   2158: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2161: pop
    //   2162: aload #43
    //   2164: invokestatic W : (Ljava/util/HashMap;)V
    //   2167: aload #43
    //   2169: ldc_w 'hideLine'
    //   2172: ldc_w 'true'
    //   2175: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2178: pop
    //   2179: aload #49
    //   2181: ldc_w 'hideLine'
    //   2184: ldc_w 'true'
    //   2187: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2190: pop
    //   2191: aload #40
    //   2193: aload #43
    //   2195: invokevirtual add : (Ljava/lang/Object;)Z
    //   2198: pop
    //   2199: aload_0
    //   2200: aload #50
    //   2202: putfield daA : Ljava/lang/String;
    //   2205: aload #46
    //   2207: ifnull -> 2283
    //   2210: aload #46
    //   2212: getstatic com/laiqian/report/models/ad.bzY : Ljava/lang/String;
    //   2215: dload #7
    //   2217: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2220: invokestatic d : (Ljava/lang/Number;)Ljava/lang/String;
    //   2223: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2226: pop
    //   2227: aload #46
    //   2229: ldc_w 'preferentialAmount'
    //   2232: dload #9
    //   2234: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2237: invokestatic d : (Ljava/lang/Number;)Ljava/lang/String;
    //   2240: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2243: pop
    //   2244: new java/lang/StringBuilder
    //   2247: dup
    //   2248: invokespecial <init> : ()V
    //   2251: astore #44
    //   2253: aload #44
    //   2255: iload #27
    //   2257: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2260: pop
    //   2261: aload #44
    //   2263: ldc ''
    //   2265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2268: pop
    //   2269: aload #46
    //   2271: ldc_w 'childCount'
    //   2274: aload #44
    //   2276: invokevirtual toString : ()Ljava/lang/String;
    //   2279: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2282: pop
    //   2283: new java/lang/StringBuilder
    //   2286: dup
    //   2287: invokespecial <init> : ()V
    //   2290: astore #44
    //   2292: aload #44
    //   2294: ldc_w ' childCount='
    //   2297: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2300: pop
    //   2301: aload #44
    //   2303: iconst_1
    //   2304: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2307: pop
    //   2308: aload #44
    //   2310: ldc_w ' date'
    //   2313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2316: pop
    //   2317: aload #44
    //   2319: aload #50
    //   2321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2324: pop
    //   2325: aload #44
    //   2327: ldc_w ' amount='
    //   2330: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2333: pop
    //   2334: aload #44
    //   2336: dload #19
    //   2338: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   2341: pop
    //   2342: aload #44
    //   2344: invokevirtual toString : ()Ljava/lang/String;
    //   2347: invokestatic println : (Ljava/lang/Object;)V
    //   2350: dload #19
    //   2352: dstore #7
    //   2354: dload #17
    //   2356: dstore #9
    //   2358: iconst_1
    //   2359: istore #26
    //   2361: aload #40
    //   2363: aload #49
    //   2365: invokevirtual add : (Ljava/lang/Object;)Z
    //   2368: pop
    //   2369: iload #25
    //   2371: istore #27
    //   2373: iload #26
    //   2375: istore #25
    //   2377: dload #21
    //   2379: dstore #11
    //   2381: iload #27
    //   2383: istore #26
    //   2385: dload_1
    //   2386: dstore #15
    //   2388: goto -> 411
    //   2391: aload #45
    //   2393: invokeinterface close : ()V
    //   2398: aload #43
    //   2400: ifnull -> 2562
    //   2403: aload_0
    //   2404: invokevirtual ano : ()Z
    //   2407: ifeq -> 2469
    //   2410: aload_0
    //   2411: invokevirtual ans : ()Z
    //   2414: ifne -> 2469
    //   2417: aload_0
    //   2418: aload_0
    //   2419: getfield daA : Ljava/lang/String;
    //   2422: invokespecial nh : (Ljava/lang/String;)[Ljava/lang/String;
    //   2425: astore #39
    //   2427: aload #43
    //   2429: getstatic com/laiqian/report/models/ad.bzY : Ljava/lang/String;
    //   2432: aload #39
    //   2434: iconst_0
    //   2435: aaload
    //   2436: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2439: pop
    //   2440: aload #43
    //   2442: ldc_w 'childCount'
    //   2445: aload #39
    //   2447: iconst_1
    //   2448: aaload
    //   2449: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2452: pop
    //   2453: aload #43
    //   2455: ldc_w 'preferentialAmount'
    //   2458: aload #39
    //   2460: iconst_2
    //   2461: aaload
    //   2462: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2465: pop
    //   2466: goto -> 2542
    //   2469: aload #43
    //   2471: getstatic com/laiqian/report/models/ad.bzY : Ljava/lang/String;
    //   2474: dload #7
    //   2476: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2479: invokestatic d : (Ljava/lang/Number;)Ljava/lang/String;
    //   2482: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2485: pop
    //   2486: aload #43
    //   2488: ldc_w 'preferentialAmount'
    //   2491: dload #9
    //   2493: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2496: invokestatic d : (Ljava/lang/Number;)Ljava/lang/String;
    //   2499: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2502: pop
    //   2503: new java/lang/StringBuilder
    //   2506: dup
    //   2507: invokespecial <init> : ()V
    //   2510: astore #39
    //   2512: aload #39
    //   2514: iload #25
    //   2516: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2519: pop
    //   2520: aload #39
    //   2522: ldc ''
    //   2524: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2527: pop
    //   2528: aload #43
    //   2530: ldc_w 'childCount'
    //   2533: aload #39
    //   2535: invokevirtual toString : ()Ljava/lang/String;
    //   2538: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2541: pop
    //   2542: aload_0
    //   2543: invokevirtual ans : ()Z
    //   2546: ifne -> 2562
    //   2549: aload_0
    //   2550: invokespecial anC : ()[Ljava/lang/String;
    //   2553: iconst_3
    //   2554: aaload
    //   2555: invokestatic parseDouble : (Ljava/lang/String;)D
    //   2558: dstore_1
    //   2559: goto -> 2577
    //   2562: dconst_0
    //   2563: dstore_1
    //   2564: goto -> 2577
    //   2567: dconst_0
    //   2568: dstore_3
    //   2569: dconst_0
    //   2570: dstore #11
    //   2572: dload_1
    //   2573: dstore #5
    //   2575: dload_3
    //   2576: dstore_1
    //   2577: aload_0
    //   2578: iconst_3
    //   2579: newarray double
    //   2581: putfield daq : [D
    //   2584: aload_0
    //   2585: invokevirtual ans : ()Z
    //   2588: ifeq -> 2619
    //   2591: aload_0
    //   2592: getfield daq : [D
    //   2595: iconst_0
    //   2596: iload #23
    //   2598: i2d
    //   2599: dastore
    //   2600: aload_0
    //   2601: getfield daq : [D
    //   2604: iconst_1
    //   2605: dload #11
    //   2607: dastore
    //   2608: aload_0
    //   2609: getfield daq : [D
    //   2612: iconst_2
    //   2613: dload #5
    //   2615: dastore
    //   2616: goto -> 2643
    //   2619: aload_0
    //   2620: getfield daq : [D
    //   2623: iconst_0
    //   2624: iload #24
    //   2626: i2d
    //   2627: dastore
    //   2628: aload_0
    //   2629: getfield daq : [D
    //   2632: iconst_1
    //   2633: dload_1
    //   2634: dastore
    //   2635: aload_0
    //   2636: getfield daq : [D
    //   2639: iconst_2
    //   2640: dload #5
    //   2642: dastore
    //   2643: invokestatic currentTimeMillis : ()J
    //   2646: lstore #36
    //   2648: new java/lang/StringBuilder
    //   2651: dup
    //   2652: invokespecial <init> : ()V
    //   2655: astore #39
    //   2657: aload #39
    //   2659: ldc_w '获取数据一共耗时：'
    //   2662: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2665: pop
    //   2666: aload #39
    //   2668: lload #36
    //   2670: lload #34
    //   2672: lsub
    //   2673: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   2676: pop
    //   2677: aload #39
    //   2679: invokevirtual toString : ()Ljava/lang/String;
    //   2682: invokestatic println : (Ljava/lang/Object;)V
    //   2685: aload #40
    //   2687: areturn }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */