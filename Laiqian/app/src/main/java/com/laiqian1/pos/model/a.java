package com.laiqian.pos.model;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.entity.aa;
import com.laiqian.entity.ao;
import com.laiqian.entity.ap;
import com.laiqian.entity.aq;
import com.laiqian.entity.x;
import com.laiqian.models.ba;
import com.laiqian.models.t;
import com.laiqian.pos.bm;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.product.a.a;
import com.laiqian.product.a.d;
import com.laiqian.product.models.a;
import com.laiqian.product.models.g;
import com.laiqian.product.models.h;
import com.laiqian.product.models.o;
import com.laiqian.product.models.p;
import com.laiqian.report.models.o;
import com.laiqian.util.ab;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.k;
import com.laiqian.util.n;
import com.orhanobut.logger.d;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends t {
  private String TAG = "OrderBusinessModel";
  
  private Comparator<PendingFullOrderDetail.d> coC = new b(this);
  
  private HashMap<Long, p> taxOfSettement;
  
  public a(Context paramContext) { super(paramContext); }
  
  private long E(HashMap<String, Object> paramHashMap) {
    Object object = paramHashMap.get("nSpareField3");
    return (object == null) ? 0L : ((object instanceof Long) ? ((Long)object).longValue() : by.parseLong(by.sd(object.toString())));
  }
  
  @NonNull
  private Map<String, Object> F(String paramString1, String paramString2, String paramString3) {
    null = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Query Total Order data. orderType is:");
    stringBuilder.append(paramString1);
    stringBuilder.append(".shopId is:");
    stringBuilder.append(paramString2);
    stringBuilder.append(".distributor is:");
    stringBuilder.append(paramString3);
    null.println(stringBuilder.toString());
    HashMap hashMap = new HashMap();
    boolean bool = TextUtils.isEmpty(paramString3);
    double d1 = 0.0D;
    byte b2 = 0;
    byte b1 = 0;
    if (bool) {
      cursor = aNE.query(Vz(), new String[] { "sum(fAmount-(fDiscount/100)*fAmount) as fAmount,sSpareField4 as payItem" }, "nShopID = ? and sIsActive = ? and nOrderType=? and  ifnull(nProductQty,0)>0  ", new String[] { paramString2, "Y", paramString1 }, "sOrderNo", null, null);
      double d5 = 0.0D;
      double d4 = d1;
      d1 = d5;
      while (cursor.moveToNext()) {
        paramString2 = cursor.getString(cursor.getColumnIndex("payItem"));
        d4 += kl(paramString2);
        d1 += km(paramString2);
        b1++;
      } 
      hashMap.put("fAmount", Double.valueOf(d4));
      hashMap.put("orderNum", Integer.valueOf(b1));
      hashMap.put("fCashAmount", Double.valueOf(d1));
      return hashMap;
    } 
    Cursor cursor = aNE.query(Vz(), new String[] { "sum(fAmount-(fDiscount/100)*fAmount) as fAmount,sSpareField4 as payItem" }, "nShopID = ? and sIsActive = ? and nOrderType=? and ifnull(nProductQty,0)>0 and nSpareField5=?", new String[] { paramString2, "Y", cursor, paramString3 }, "sOrderNo", null, null);
    double d3 = 0.0D;
    b1 = b2;
    double d2 = d1;
    d1 = d3;
    while (cursor.moveToNext()) {
      paramString2 = cursor.getString(cursor.getColumnIndex("payItem"));
      d2 += kl(paramString2);
      d1 += km(paramString2);
      b1++;
    } 
    hashMap.put("fAmount", Double.valueOf(d2));
    hashMap.put("orderNum", Integer.valueOf(b1));
    hashMap.put("fCashAmount", Double.valueOf(d1));
    return hashMap;
  }
  
  private double a(PendingFullOrderDetail.d paramd, PendingFullOrderDetail paramPendingFullOrderDetail) {
    for (PendingFullOrderDetail.d d1 : paramPendingFullOrderDetail.coy) {
      if (paramd.aTO == d1.aTO)
        return d1.cpo; 
    } 
    Iterator iterator = paramPendingFullOrderDetail.coz.iterator();
    while (iterator.hasNext()) {
      for (PendingFullOrderDetail.d d1 : ((PendingFullOrderDetail.c)iterator.next()).cpg) {
        if (paramd.aTO == d1.aTO)
          return d1.cpo; 
      } 
    } 
    return 0.0D;
  }
  
  private double a(ArrayList<aa> paramArrayList, String paramString1, h paramh, StringBuffer paramStringBuffer, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3) {
    a a1;
    ao ao;
    ArrayList arrayList = new ArrayList();
    StringBuilder stringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString2)) {
      try {
        null = new ArrayList();
        null = new JSONArray(paramString2);
        byte b;
        for (b = 0; b < null.length(); b++)
          null.add(Long.valueOf(null.getJSONObject(b).getLong("taxId"))); 
        a1 = new ba(this.mContext);
        null = a1.j(null);
        arrayList.addAll(null);
        a1.close();
        Iterator iterator = null.iterator();
        while (true) {
          double d1 = paramDouble3;
          try {
            if (iterator.hasNext()) {
              o o = (o)iterator.next();
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(o.akZ());
              if (o.alc() == 1) {
                str = "*";
              } else {
                str = "";
              } 
              stringBuilder1.append(str);
              String str = stringBuilder1.toString();
              if (!by.isNull(stringBuilder.toString())) {
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append("/");
                stringBuilder1.append(str);
                str = stringBuilder1.toString();
              } 
              stringBuilder.append(str);
              if (o.alc() == 0) {
                d1 = o.ala() * paramDouble2 / 100.0D * paramDouble1 / 100.0D;
              } else {
                d1 = 0.0D;
              } 
              double d3 = o.ala() * paramDouble2 / 100.0D * paramDouble1 / 100.0D;
              double d2 = paramDouble3;
              if (paramh.akF() > 0.0D) {
                a(o.getId(), o.akZ(), o.ala(), d3, paramDouble2 * paramDouble1 / 100.0D, d1);
                d2 = paramDouble3 + d3;
              } 
              paramDouble3 = d2;
              continue;
            } 
          } catch (JSONException null) {
            a.e(a1);
            d1 = paramDouble3;
          } catch (Exception null) {}
          a a2 = (new d()).a(new d.a()).akm();
          ao = new ao(paramh, "", "", paramStringBuffer.toString(), 0L, paramString1, a2);
          ao.dx(stringBuilder.toString());
          ao.o(arrayList);
          paramArrayList.add(ao);
          return d1;
        } 
      } catch (JSONException paramString2) {
      
      } catch (Exception paramString2) {
        a.e(paramString2);
        double d1 = paramDouble3;
      } 
    } else {
      double d1 = paramDouble3;
      a1 = (new d()).a(new d.a()).akm();
      ao = new ao(paramh, "", "", paramStringBuffer.toString(), 0L, ao, a1);
      ao.dx(stringBuilder.toString());
      ao.o(arrayList);
      paramArrayList.add(ao);
      return d1;
    } 
    a.e(a1);
    double d = paramDouble3;
  }
  
  @NonNull
  private ContentValues a(Cursor paramCursor, String[] paramArrayOfString, long paramLong1, long paramLong2) {
    ContentValues contentValues = new ContentValues();
    byte b;
    for (b = 0; b < paramCursor.getColumnCount(); b++) {
      String str = paramCursor.getColumnName(b).toLowerCase();
      if (n.a(str, paramArrayOfString)) {
        if (paramCursor.getType(b) == 1) {
          contentValues.put(str, Long.valueOf(-paramCursor.getLong(b)));
        } else {
          contentValues.put(str, Double.valueOf(-paramCursor.getDouble(b)));
        } 
      } else {
        switch (paramCursor.getType(b)) {
          default:
            contentValues.put(str, paramCursor.getString(b));
            break;
          case 2:
            contentValues.put(str, Double.valueOf(paramCursor.getDouble(b)));
            break;
          case 1:
            contentValues.put(str, Long.valueOf(paramCursor.getLong(b)));
            break;
        } 
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong2);
    stringBuilder.append("");
    contentValues.put("_id", stringBuilder.toString());
    contentValues.put("nuserid", getUserID());
    contentValues.put("noperationtime", Long.valueOf(paramLong1));
    contentValues.put("ndatetime", Long.valueOf(paramLong1));
    return contentValues;
  }
  
  private Cursor a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString3) {
    String str1;
    if (paramBoolean) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("nOperationTime limit ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" offset ");
      stringBuilder.append(paramInt1 * (paramInt2 - 1));
      str1 = stringBuilder.toString();
    } else {
      str1 = "nOperationTime DESC ";
    } 
    if (TextUtils.isEmpty(paramString1))
      return aNE.query(Vz(), new String[] { 
            "sOrderNo", "nPhysicalInventoryID", "sSpareField1", "min(nDateTime)", "min(nOperationTime)", "nBPartnerID", "sBPartnerName", "sHeaderText", "sBPartnerMobile", "nSpareField4", 
            "nSpareField5", "sOrderStatus", "sSpareField5" }, "nShopID = ? and sIsActive = ? and nOrderType=? and nOperationTime between ? and ?", new String[] { paramString3, "Y", (new String[5][3] = (new String[5][2] = paramString2).valueOf(paramLong1)).valueOf(paramLong2) }, "sOrderNo", null, str1); 
    String str2 = SQLiteQueryBuilder.buildQueryString(false, Vz(), new String[] { 
          "sOrderNO", "nPhysicalInventoryID", "sSpareField1", "min(nDateTime) as nDateTime", "min(nOperationTime) as nOperationTime", "nBPartnerID", "sBPartnerName", "sHeaderText", "sBPartnerMobile", "nSpareField4", 
          "nSpareField5", "sOrderStatus", "GROUP_CONCAT(sProductName) as sProductNames", "sSpareField5" }, "nShopID = ? and sIsActive = ? and  nOrderType=? ", "sOrderNo", null, null, null);
    SQLiteDatabase sQLiteDatabase = aNE;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(");
    stringBuilder1.append(str2);
    stringBuilder1.append(")");
    str2 = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("nOperationTime between ");
    stringBuilder1.append(paramLong1);
    stringBuilder1.append(" and ");
    stringBuilder1.append(paramLong2);
    stringBuilder1.append(" and (nPhysicalInventoryID like ? or sProductNames like ?)");
    String str3 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("%");
    stringBuilder2.append(paramString1);
    stringBuilder2.append("%");
    String str4 = stringBuilder2.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("%");
    stringBuilder3.append(paramString1);
    stringBuilder3.append("%");
    paramString1 = stringBuilder3.toString();
    return sQLiteDatabase.query(str2, new String[] { 
          "sOrderNo", "nPhysicalInventoryID", "sSpareField1", "nDateTime", "nOperationTime", "nBPartnerID", "sBPartnerName", "sHeaderText", "sBPartnerMobile", "nSpareField4", 
          "nSpareField5", "sOrderStatus", "sSpareField5" }, str3, new String[] { paramString3, "Y", paramString2, str4, paramString1 }, null, null, str1);
  }
  
  @NonNull
  private TakeOrderEntity a(String paramString1, ArrayList<aa> paramArrayList, String paramString2, String paramString3, String paramString4, String paramString5, Date paramDate, long paramLong1, long paramLong2, long paramLong3, double paramDouble1, long paramLong4, double paramDouble2, double paramDouble3, Double paramDouble, double paramDouble4, double paramDouble5, double paramDouble6, String paramString6, String[] paramArrayOfString, double paramDouble7, String paramString7) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    paramDouble6 = by.parseDouble(n.a(Double.valueOf(paramDouble6), true, false));
    paramDouble3 = (paramDouble3 + paramDouble5) * paramDouble.doubleValue() / 100.0D + paramDouble7;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("getTakeOrderEntity recevied=");
    stringBuilder1.append(paramDouble3);
    stringBuilder1.append(" discount=");
    stringBuilder1.append(paramDouble);
    stringBuilder1.append(" tax=");
    stringBuilder1.append(paramDouble5);
    stringBuilder1.append(" point=");
    stringBuilder1.append(paramDouble7);
    Log.d("getTakeOrderEntity", stringBuilder1.toString());
    if (by.isNull(paramString3))
      paramString3 = ""; 
    if (by.isNull(paramString4))
      paramString4 = ""; 
    if (by.isNull(paramString5))
      paramString5 = ""; 
    String str3 = simpleDateFormat.format(Long.valueOf(by.parseLong(paramString1)));
    long l = by.parseLong(paramString1) / 1000L;
    String str4 = kn(paramString2);
    String str5 = simpleDateFormat.format(Long.valueOf(by.parseLong(paramString1)));
    String str1 = simpleDateFormat.format(Long.valueOf(by.parseLong(paramString1) + 900000L));
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramDouble);
    stringBuilder2.append("");
    String str2 = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramDouble6);
    stringBuilder2.append("");
    TakeOrderEntity takeOrderEntity = new TakeOrderEntity("phone_order", paramString2, paramString1, paramString1, paramString3, paramString4, paramString5, paramArrayList, str3, l, paramString1, str4, str5, str1, paramString7, paramString6, "phone_order", "delivery", paramDouble3, "COD", paramDouble3, paramDouble4, str2, stringBuilder2.toString(), paramLong1, paramArrayOfString[0], paramLong3, paramDouble1, paramLong4, paramDouble2, paramLong2, new aq(), paramString1);
    takeOrderEntity.l(this.taxOfSettement);
    takeOrderEntity.dt(paramArrayOfString[1]);
    takeOrderEntity.V(paramDouble6);
    return takeOrderEntity;
  }
  
  @NonNull
  private h a(int paramInt, HashMap<String, Object> paramHashMap, String paramString) {
    String str = new StringBuilder();
    str.append(paramHashMap.get("nProductID"));
    str.append("");
    long l = by.parseLong(by.sd(str.toString()));
    if (paramHashMap.containsKey("sProductName2")) {
      String str1 = (String)paramHashMap.get("sProductName2");
    } else {
      str = "";
    } 
    double d = ((Double)paramHashMap.get("fPrice")).doubleValue();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramHashMap.get("nSpareField1"));
    stringBuilder.append("");
    a a1 = new a(l, paramString, str, d, false, by.parseLong(by.sd(stringBuilder.toString())), 0.0D, null);
    a1.jv(paramInt);
    a1.aO(((Double)paramHashMap.get("nProductQty")).doubleValue());
    return a1;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, StringBuilder paramStringBuilder, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5) {
    paramStringBuilder.setLength(0);
    paramStringBuilder.append("update ");
    String str = paramString3;
    if (paramString3.toUpperCase().contains("DOC")) {
      null = new StringBuilder();
      null.append(b.aU(b.S(paramLong), b.U(paramLong)));
      null.append(".");
      null.append(paramString3);
      str = null.toString();
    } 
    paramStringBuilder.append(str);
    paramStringBuilder.append(" set nIsUpdated = 0,");
    if (paramBoolean) {
      paramStringBuilder.append(paramString4);
      paramStringBuilder.append("= 1,nUpdateFlag= case when nUpdateFlag is null then 10000 else nUpdateFlag+10000 end");
    } else {
      paramStringBuilder.append("nUpdateFlag= case when nUpdateFlag is null then 100 else nUpdateFlag+100 end");
    } 
    paramStringBuilder.append(",nOperationTime=");
    paramStringBuilder.append(paramLong);
    paramStringBuilder.append(" where ");
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append("= '");
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append("' ");
    if (paramString5 != null && paramString5.length() > 0)
      paramStringBuilder.append(paramString5); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("/executeDeleteSQL执行删除订单SQL语句：");
    stringBuilder.append(paramStringBuilder);
    n.println(stringBuilder.toString());
    paramSQLiteDatabase.execSQL(paramStringBuilder.toString());
  }
  
  private void a(@NonNull PendingFullOrderDetail.d paramd, HashMap<String, Object> paramHashMap) {
    paramd.id = ((Long)paramHashMap.get("nProductID")).longValue();
    paramd.aTO = ((Long)paramHashMap.get("_id")).longValue();
    String str = (String)paramHashMap.get("sItemNo");
    if (!TextUtils.isEmpty(str))
      paramd.cpl = Long.valueOf(Long.parseLong(str)); 
    paramd.name = (String)paramHashMap.get("sProductName");
    if (paramHashMap.containsKey("sProductName2"))
      paramd.cpm = (String)paramHashMap.get("sProductName2"); 
    paramd.cpn = ((Double)paramHashMap.get("fPrice")).doubleValue();
    paramd.bbX = ((Long)paramHashMap.get("nDateTime")).longValue();
    paramd.cpo = ((Double)paramHashMap.get("nProductQty")).doubleValue();
    if (paramHashMap.containsKey("fSpareField2"))
      paramd.cpt = (Double)paramHashMap.get("fSpareField2"); 
    if (paramHashMap.containsKey("fSpareField1"))
      paramd.cps = (Double)paramHashMap.get("fSpareField1"); 
    paramd.cpp = "Y".equals(paramHashMap.get("sItemText"));
    paramd.cpq = ((Long)paramHashMap.get("nSpareField1")).longValue();
    if (paramHashMap.containsKey("fSpareField3") && paramHashMap.get("fSpareField3") != null)
      paramd.cpu = ((Double)paramHashMap.get("fSpareField3")).doubleValue(); 
    paramd.cpx = E(paramHashMap);
    paramd.aTU = 1;
    if (paramHashMap.containsKey("sSpareField3") && !TextUtils.isEmpty(paramHashMap.get("sSpareField3").toString()))
      try {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject(paramHashMap.get("sSpareField3").toString());
        if (!by.isNull(jSONObject.getString("tax"))) {
          JSONArray jSONArray = jSONObject.getJSONArray("tax");
          for (byte b = 0; b < jSONArray.length(); b++)
            arrayList.add(Long.valueOf(jSONArray.getJSONObject(b).getLong("taxId"))); 
        } 
        paramd.aTG = jSONObject.optDouble("amountOfAddPrice");
        paramd.aTF = jSONObject.optDouble("amountOfNoTax");
        if (arrayList.size() > 0) {
          ba ba = new ba(this.mContext);
          paramd.aTR.addAll(ba.j(arrayList));
          ba.close();
          return;
        } 
      } catch (JSONException paramd) {
        a.e(paramd);
      } catch (Exception paramd) {
        a.e(paramd);
        return;
      }  
  }
  
  private void a(ArrayList<HashMap<String, Object>> paramArrayList, PendingFullOrderDetail.d paramd) {
    HashMap hashMap = new HashMap();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramd.id);
    stringBuilder.append("");
    hashMap.put("nProductID", stringBuilder.toString());
    hashMap.put("sProductName", paramd.name);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramd.cpo);
    stringBuilder.append("");
    hashMap.put("nProductQty", stringBuilder.toString());
    hashMap.put("tvPosProductQtyValue", bm.c(paramd.cpo, RootApplication.aIQ));
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramd.cpq);
    stringBuilder.append("");
    hashMap.put("nProductType", stringBuilder.toString());
    hashMap.put("nPrice", Double.valueOf(paramd.cpn));
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramd.cpo * paramd.cpn);
    stringBuilder.append("");
    hashMap.put("fAmount", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramd.cpx);
    stringBuilder.append("");
    hashMap.put("nFoodCategory", stringBuilder.toString());
    if (paramd.cpl != null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramd.cpl);
      stringBuilder.append("");
      hashMap.put("itemNo", stringBuilder.toString());
    } else {
      hashMap.put("itemNo", "0");
    } 
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramd.aTO);
    stringBuilder.append("");
    hashMap.put("oid", stringBuilder.toString());
    hashMap.put("dateTime", Long.valueOf(paramd.bbX));
    paramArrayList.add(hashMap);
  }
  
  private long b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    Calendar calendar = Calendar.getInstance();
    if (paramBoolean)
      calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0); 
    calendar.add(1, paramInt1);
    calendar.add(2, paramInt2);
    calendar.add(5, paramInt3);
    return calendar.getTimeInMillis();
  }
  
  @NonNull
  private h b(int paramInt, HashMap<String, Object> paramHashMap, String paramString) {
    String str = new StringBuilder();
    str.append(paramHashMap.get("nProductID"));
    str.append("");
    long l = by.parseLong(by.sd(str.toString()));
    if (paramHashMap.containsKey("sProductName2")) {
      String str1 = (String)paramHashMap.get("sProductName2");
    } else {
      str = "";
    } 
    double d1 = ((Double)paramHashMap.get("fPrice")).doubleValue();
    double d2 = ((Double)paramHashMap.get("nProductQty")).doubleValue();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramHashMap.get("nSpareField1"));
    stringBuilder.append("");
    h h = new h(l, paramString, str, d1, d2, false, by.parseLong(by.sd(stringBuilder.toString())), "", 0.0D, "", false, 0.0D);
    h.jv(paramInt);
    return h;
  }
  
  private Cursor c(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2, String paramString3) {
    String str;
    if (paramBoolean) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("nOperationTime desc limit ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" offset ");
      stringBuilder.append(paramInt1 * (paramInt2 - 1));
      str = stringBuilder.toString();
    } else {
      str = " nOperationTime DESC ";
    } 
    return TextUtils.isEmpty(paramString1) ? aNE.query(Vz(), new String[] { 
          "sOrderNo", "nPhysicalInventoryID", "sSpareField1", "min(nDateTime)", "min(nOperationTime)", "nBPartnerID", "sBPartnerName", "sHeaderText", "sBPartnerMobile", "nSpareField4", 
          "nSpareField5", "sOrderStatus", "sSpareField5", "sSpareField4", "fDiscount" }, "nShopID = ? and sIsActive = ? and nOrderType=? ", new String[] { paramString3, "Y", paramString2 }, "sOrderNo", null, str) : aNE.query(Vz(), new String[] { 
          "sOrderNo", "nPhysicalInventoryID", "sSpareField1", "min(nDateTime)", "min(nOperationTime)", "nBPartnerID", "sBPartnerName", "sHeaderText", "sBPartnerMobile", "nSpareField4", 
          "nSpareField5", "sOrderStatus", "sSpareField5", "sSpareField4", "fDiscount" }, "nShopID = ? and sIsActive = ? and nOrderType=? and nSpareField5=? ", new String[] { paramString3, "Y", paramString2, paramString1 }, "sOrderNo", null, str);
  }
  
  private long i(Date paramDate) {
    Time time = new Time();
    time.setToNow();
    time.set(paramDate.getTime());
    time.set(0, 0, 0, time.monthDay, time.month, time.year);
    return time.normalize(false);
  }
  
  private double kl(String paramString) {
    double d = 0.0D;
    try {
      jSONObject = new JSONObject(paramString);
      double d1 = jSONObject.getDouble("firstPayValue");
      try {
        double d2 = jSONObject.getDouble("secondPayValue");
        d = d2;
      } catch (JSONException jSONObject) {}
    } catch (JSONException paramString) {
      double d1 = 0.0D;
    } 
    a.e(paramString);
  }
  
  private double km(String paramString) {
    double d2 = 0.0D;
    double d1 = d2;
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      double d = d2;
      d1 = d2;
      if (jSONObject.getLong("firstPayType") == 10001L) {
        d1 = d2;
        d = jSONObject.getDouble("firstPayValue");
      } 
      d1 = d;
      d2 = d;
      if (jSONObject.getLong("secondPayType") == 10001L) {
        d1 = d;
        return jSONObject.getDouble("secondPayValue");
      } 
    } catch (JSONException paramString) {
      a.e(paramString);
      d2 = d1;
    } 
    return d2;
  }
  
  public static boolean kr(String paramString) {
    byte b = 0;
    boolean bool = false;
    while (b < paramString.length()) {
      if (!Character.isDigit(paramString.charAt(b)))
        bool = true; 
      b++;
    } 
    return bool;
  }
  
  @TargetApi(19)
  @Nullable
  public double a(PendingFullOrderDetail.d paramd) {
    double d1 = 0.0D;
    double d2 = d1;
    try {
      sQLiteDatabase = Vq();
      d2 = d1;
      null = new StringBuilder();
      d2 = d1;
      null.append(paramd.aTO);
      d2 = d1;
      null.append("");
      d2 = d1;
      String str = null.toString();
      d2 = d1;
      cursor = sQLiteDatabase.query("T_ORDER", new String[] { "nProductQty" }, "_id=?", new String[] { str }, null, null, null);
      sQLiteDatabase = null;
      while (true) {
        SQLiteDatabase sQLiteDatabase1 = sQLiteDatabase;
        try {
          if (cursor.moveToNext()) {
            sQLiteDatabase1 = sQLiteDatabase;
            d2 = cursor.getDouble(0);
            d1 = d2;
            continue;
          } 
          sQLiteDatabase1 = sQLiteDatabase;
          cursor.close();
          d2 = d1;
          if (cursor != null) {
            d2 = d1;
            cursor.close();
            return d1;
          } 
          break;
        } catch (Throwable sQLiteDatabase) {
          sQLiteDatabase1 = sQLiteDatabase;
          throw sQLiteDatabase;
        } finally {}
        if (cursor != null)
          if (sQLiteDatabase1 != null) {
            d2 = d1;
            try {
              cursor.close();
            } catch (Throwable cursor) {
              d2 = d1;
              a.a(sQLiteDatabase1, cursor);
            } 
          } else {
            d2 = d1;
            cursor.close();
          }  
        d2 = d1;
        throw sQLiteDatabase;
      } 
    } catch (Exception paramd) {
      a.e(paramd);
    } 
    return d2;
  }
  
  public Cursor a(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3) { return aNE.query(Vz(), new String[] { 
          "sOrderNo", "nPhysicalInventoryID", "sSpareField1", "min(nDateTime)", "min(nOperationTime)", "nBPartnerID", "sBPartnerName", "sHeaderText", "sBPartnerMobile", "nSpareField4", 
          "nSpareField5", "sOrderStatus", "sSpareField5" }, "nShopID = ? and sIsActive = ? and nOrderType=? and nSpareField5=? and nOperationTime between ? and ?", new String[] { paramString3, "Y", paramString2, (new String[6][4] = (new String[6][3] = paramString1).valueOf(paramLong1)).valueOf(paramLong2) }, "sOrderNo", null, "nOperationTime DESC "); }
  
  public PendingFullOrderDetail.c a(PendingFullOrderDetail.c paramc) {
    byte b;
    for (b = 0; b < paramc.cpg.size(); b = b1 + 1) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)paramc.cpg.get(b);
      byte b1 = b;
      if (d.aTO > 0L) {
        double d1 = a(d);
        if (d1 > 0.0D) {
          double d2 = d.cpo + d1;
          if (d2 < 0.0D) {
            d.aTP = true;
            d.cpo = -d1;
            b1 = b;
          } else if (d2 == 0.0D) {
            d.aTP = true;
            b1 = b;
          } else {
            d.aTP = false;
            b1 = b;
          } 
        } else {
          b1 = b;
          if (d1 < 0.0D) {
            paramc.cpg.remove(b);
            b1 = b - 1;
          } 
        } 
      } 
    } 
    return paramc;
  }
  
  public PendingFullOrderDetail.c a(PendingFullOrderDetail paramPendingFullOrderDetail1, PendingFullOrderDetail paramPendingFullOrderDetail2) {
    PendingFullOrderDetail.c c = new PendingFullOrderDetail.c();
    c.cpi = paramPendingFullOrderDetail1.bXb.coE;
    for (PendingFullOrderDetail.d d : paramPendingFullOrderDetail2.coy)
      c.cpg.add(d); 
    for (byte b = 0; b < paramPendingFullOrderDetail1.coy.size(); b = b1 + 1) {
      byte b1 = b;
      if (((PendingFullOrderDetail.d)paramPendingFullOrderDetail1.coy.get(b)).aTO > 0L) {
        paramPendingFullOrderDetail1.coy.remove(b);
        b1 = b - 1;
      } 
    } 
    for (PendingFullOrderDetail.d d : (paramPendingFullOrderDetail1.aaE()).cpg)
      c.cpg.add(d); 
    return c;
  }
  
  @Nullable
  public PendingFullOrderDetail a(String paramString, PendingFullOrderDetail paramPendingFullOrderDetail, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramPendingFullOrderDetail == null)
      paramPendingFullOrderDetail = new PendingFullOrderDetail(); 
    if (by.isNull(paramString))
      return null; 
    av = new av(this.mContext);
    null = av.Tx();
    paramPendingFullOrderDetail.bXb.ceV = av.Ea();
    av.close();
    boolean bool = true;
    try {
      Cursor cursor = Vq().rawQuery("SELECT T_ORDER.*, T_PRODUCT.sSpareField5 as sProductName2 FROM T_ORDER LEFT JOIN T_PRODUCT ON T_ORDER.nProductID = T_PRODUCT._id WHERE T_ORDER.sOrderNo like ? and T_ORDER.nShopID = ? ORDER BY T_ORDER.nDateTime ASC,CAST(ifnull(T_ORDER.sItemNo,'0') AS SIGNED integer) ASC", new String[] { paramString, null });
    } catch (Exception av) {
      a.e(av);
      av = null;
    } 
    LinkedHashMap linkedHashMap = k.a(ab.d(av), new d(this));
    if (linkedHashMap.size() == 0) {
      if (av != null)
        av.close(); 
      return null;
    } 
    for (HashMap hashMap1 : linkedHashMap.entrySet()) {
      if (bool) {
        HashMap hashMap = (HashMap)((ArrayList)hashMap1.getValue()).get(0);
        paramPendingFullOrderDetail.bXb.coE = new Date(((Long)hashMap1.getKey()).longValue());
        try {
          String str;
          PendingFullOrderDetail.a a1 = paramPendingFullOrderDetail.bXb;
          if (hashMap.get("nPhysicalInventoryID") == null) {
            str = "0";
          } else {
            str = hashMap.get("nPhysicalInventoryID").toString();
          } 
          a1.coJ = str;
          if (hashMap.containsKey("sSpareField5")) {
            str = (String)hashMap.get("sSpareField5");
            if (!TextUtils.isEmpty(str))
              paramPendingFullOrderDetail.bXb.coJ = str; 
          } 
        } catch (Exception exception) {
          a.e(exception);
        } 
        paramPendingFullOrderDetail.bXb.coK = (String)hashMap.get("sSpareField1");
        if (hashMap.get("fDiscount") != null)
          paramPendingFullOrderDetail.bXb.ceX = Double.valueOf(by.parseDouble(hashMap.get("fDiscount").toString())); 
        paramPendingFullOrderDetail.bXb.orderNo = paramString;
        paramPendingFullOrderDetail.bXb.bJc = ((Long)hashMap.get("nShopID")).longValue();
        paramPendingFullOrderDetail.bXb.aEI = ((Long)hashMap.get("nUserID")).longValue();
        paramPendingFullOrderDetail.bXb.coH = ((Long)hashMap.get("nProductTransacType")).longValue();
        paramPendingFullOrderDetail.bXb.coI = ((Long)hashMap.get("nStcokDirection")).longValue();
        null = paramPendingFullOrderDetail.bXb;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Long)hashMap.get("nBPartnerID"));
        stringBuilder.append("");
        null.coO = by.parseLong(stringBuilder.toString());
        paramPendingFullOrderDetail.bXb.coP = (String)hashMap.get("sBPartnerName");
        paramPendingFullOrderDetail.bXb.coQ = (String)hashMap.get("sBPartnerMobile");
        paramPendingFullOrderDetail.bXb.headerText = (String)hashMap.get("sHeaderText");
        null = paramPendingFullOrderDetail.bXb;
        stringBuilder = new StringBuilder();
        stringBuilder.append((Long)hashMap.get("nSpareField4"));
        stringBuilder.append("");
        null.aVN = by.parseLong(stringBuilder.toString());
        paramPendingFullOrderDetail.bXb.cpc = (Double)hashMap.get("fSpareField1");
        null = paramPendingFullOrderDetail.bXb;
        stringBuilder = new StringBuilder();
        stringBuilder.append((Integer)hashMap.get("nOrderType"));
        stringBuilder.append("");
        null.bZF = by.parseInt(stringBuilder.toString());
        null = paramPendingFullOrderDetail.bXb;
        stringBuilder = new StringBuilder();
        stringBuilder.append((Long)hashMap.get("nSpareField5"));
        stringBuilder.append("");
        null.coR = by.parseLong(stringBuilder.toString());
        null = (String)hashMap.get("sSpareField4");
        if (!TextUtils.isEmpty(null))
          try {
            JSONObject jSONObject = new JSONObject(null);
            paramPendingFullOrderDetail.bXb.aVS = jSONObject.optLong("firstPayType");
            paramPendingFullOrderDetail.bXb.bfj = jSONObject.optDouble("firstPayValue");
            paramPendingFullOrderDetail.bXb.aVU = jSONObject.optLong("secondPayType");
            paramPendingFullOrderDetail.bXb.bfk = jSONObject.optDouble("secondPayValue");
          } catch (JSONException null) {
            a.e(null);
          }  
        for (HashMap hashMap1 : (ArrayList)hashMap1.getValue()) {
          PendingFullOrderDetail.d d = new PendingFullOrderDetail.d();
          if (paramBoolean1 && d.cpo < 0.0D)
            d.cpn = 0.0D; 
          a(d, hashMap1);
          paramPendingFullOrderDetail.coy.add(d);
        } 
        bool = false;
        continue;
      } 
      PendingFullOrderDetail.c c = new PendingFullOrderDetail.c();
      c.cpi = new Date(((Long)hashMap1.getKey()).longValue());
      for (HashMap hashMap : (ArrayList)hashMap1.getValue()) {
        PendingFullOrderDetail.d d = new PendingFullOrderDetail.d();
        if (paramBoolean1 && d.cpo < 0.0D)
          d.cpn = 0.0D; 
        a(d, hashMap);
        c.cpg.add(d);
      } 
      paramPendingFullOrderDetail.coz.add(c);
    } 
    if (av != null)
      av.close(); 
    if (linkedHashMap != null)
      linkedHashMap.clear(); 
    return paramPendingFullOrderDetail;
  }
  
  @NonNull
  public a a(String paramString, long paramLong, boolean paramBoolean1, @Nullable Double paramDouble, boolean paramBoolean2, boolean paramBoolean3) {
    a a1;
    try {
      SQLiteDatabase sQLiteDatabase = r(paramLong, paramLong);
      String str = b.aU(b.S(paramLong), b.U(paramLong));
      g g = new g(this.mContext);
      long l2 = System.currentTimeMillis();
      StringBuilder stringBuilder = new StringBuilder();
      a(sQLiteDatabase, stringBuilder, paramBoolean2, "sOrderNo", paramString, "t_productdoc", "nDeletionFlag", paramLong, null);
      a1 = new StringBuilder();
      a1.append("select * from ");
      a1.append(b.aU(b.S(paramLong), b.U(paramLong)));
      a1.append(".t_productdoc where sOrderNo = '");
      a1.append(paramString);
      a1.append("'");
      Cursor cursor = sQLiteDatabase.rawQuery(a1.toString(), null);
      if (paramBoolean2) {
        String[] arrayOfString = { "nproductqty", "fstockamount", "famount", "fstockamount", "freceived" };
      } else {
        a1 = null;
      } 
      long l1 = l2;
      while (true) {
        boolean bool = cursor.moveToNext();
        if (bool) {
          ContentValues contentValues;
          try {
            contentValues = a(cursor, a1, l2, l1);
          } catch (Throwable paramString) {
            a a4 = this;
            break;
          } 
          if (!paramBoolean2) {
            if (contentValues.getAsLong("nproducttransactype").longValue() == 100001L)
              contentValues.put("nproducttransactype", Integer.valueOf(100015)); 
            if (contentValues.getAsLong("nstcokdirection").longValue() == 300002L) {
              contentValues.put("nstcokdirection", Integer.valueOf(300001));
            } else {
              contentValues.put("nstcokdirection", Integer.valueOf(300002));
            } 
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str);
          stringBuilder1.append(".t_productdoc");
          long l = sQLiteDatabase.insert(stringBuilder1.toString(), null, contentValues);
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("生成商品交易表时插入数据的返回值：");
          stringBuilder1.append(l);
          n.println(stringBuilder1.toString());
          if (l < 0L)
            return new a(this, "生成商品交易表回冲记录失败", null); 
          l = contentValues.getAsLong("nproductid").longValue();
          if (l > 0L) {
            double d = contentValues.getAsDouble("nproductqty").doubleValue();
            if (d != 0.0D) {
              double d1 = d;
              if (300002L == contentValues.getAsLong("nstcokdirection").longValue())
                d1 = d * -1.0D; 
              if (!g.c(l, d1))
                return new a(this, "修改商品库存失败", null); 
            } 
          } 
          l1++;
          continue;
        } 
        cursor.close();
        g.close();
        try {
          a(sQLiteDatabase, stringBuilder, paramBoolean2, "sText", paramString, "t_accountdoc", "nDeletionFlag", paramLong, null);
          if (!paramBoolean2 && paramBoolean3)
            try {
              a1 = new StringBuilder();
              a1.append("select * from ");
              a1.append(str);
              a1.append(".T_ACCOUNTDOC where sText = '");
              a1.append(paramString);
              a1.append("'");
              cursor = sQLiteDatabase.rawQuery(a1.toString(), null);
              while (true) {
                bool = cursor.moveToNext();
                if (bool) {
                  a a5 = this;
                  a a4 = a5;
                  try {
                    ContentValues contentValues = a(cursor, new String[] { "nmoneydirection" }, l2, l1);
                    a4 = a5;
                    if (contentValues.getAsLong("naccounttransactype").longValue() == 800001L) {
                      a4 = a5;
                      contentValues.put("naccounttransactype", Integer.valueOf(800002));
                    } else {
                      a4 = a5;
                      contentValues.put("naccounttransactype", Integer.valueOf(800001));
                    } 
                    a4 = a5;
                    StringBuilder stringBuilder1 = new StringBuilder();
                    a4 = a5;
                    stringBuilder1.append(str);
                    a4 = a5;
                    stringBuilder1.append(".t_accountdoc");
                    a4 = a5;
                    if (sQLiteDatabase.insert(stringBuilder1.toString(), null, contentValues) < 0L) {
                      a4 = a5;
                      return new a(a5, "生成支付表回冲记录失败", null);
                    } 
                  } catch (Throwable paramString) {
                    while (true) {
                      a.e(paramString);
                      return new a(a4, "删除订单时，未知错误", null);
                    } 
                    break;
                  } 
                } else {
                  a a4 = this;
                  cursor.close();
                  break;
                } 
                l1++;
              } 
            } catch (Throwable paramString) {
              a a4 = this;
              while (true) {
                a.e(paramString);
                return new a(a4, "删除订单时，未知错误", null);
              } 
              break;
            }  
        } catch (Throwable paramString) {
          a a4 = this;
          while (true) {
            a.e(paramString);
            return new a(a4, "删除订单时，未知错误", null);
          } 
          break;
        } 
        a a3 = this;
        if (paramDouble != null) {
          String str1;
          if (!paramBoolean2 && !paramBoolean3) {
            str1 = " and nChargeType!=370005";
          } else {
            str1 = "";
          } 
          cursor = null;
          a3.a(sQLiteDatabase, stringBuilder, paramBoolean2, "sText", paramString, "t_bpartner_chargedoc", "sSpareField1", paramLong, str1);
          null = new StringBuilder();
          null.append("select * from ");
          null.append(str);
          null.append(".t_bpartner_chargedoc where sText = '");
          null.append(paramString);
          null.append("' ");
          null.append(str1);
          Cursor cursor1 = sQLiteDatabase.rawQuery(null.toString(), cursor);
          if (cursor1.getCount() > 0) {
            double d2 = 0.0D;
            double d1 = d2;
            long l3 = 0L;
            int i = 0;
            cursor2 = cursor;
            while (true) {
              if (cursor1.moveToNext()) {
                double d4;
                double d3;
                ContentValues contentValues = a(cursor1, new String[] { "fchargeamount", "freceived", "nsparefield1" }, l2, l1);
                if (paramDouble != null) {
                  d3 = paramDouble.doubleValue();
                  d4 = paramDouble.doubleValue() + contentValues.getAsDouble("fchargeamount").doubleValue();
                } else {
                  n.println("回冲会员支付方式的时候，没有会员信息。理论上不会进来");
                  d3 = contentValues.getAsDouble("fnewamount").doubleValue();
                  d4 = contentValues.getAsDouble("foldamount").doubleValue();
                } 
                contentValues.put("foldamount", Double.valueOf(d3));
                contentValues.put("fnewamount", Double.valueOf(d4));
                contentValues.put("ssparefield2", Integer.valueOf(1));
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(str);
                stringBuilder1.append(".t_bpartner_chargedoc");
                if (sQLiteDatabase.insert(stringBuilder1.toString(), cursor2, contentValues) < 0L) {
                  try {
                    return new a(this, "生成会员交易表回冲记录失败", cursor2);
                  } catch (Throwable cursor2) {
                    a3 = this;
                  } 
                } else {
                  d3 = -contentValues.getAsDouble("fchargeamount").doubleValue();
                  if (d3 == 0.0D) {
                    d1 += contentValues.getAsDouble("freceived").doubleValue();
                  } else {
                    d1 += d3;
                  } 
                  i = (int)(i + contentValues.getAsLong("nsparefield1").longValue());
                  if (l3 == 0L && contentValues.getAsLong("nbpartnerid").longValue() > 0L)
                    l3 = contentValues.getAsLong("nbpartnerid").longValue(); 
                  l1++;
                  d2 -= d3;
                  cursor2 = null;
                  continue;
                } 
              } else {
                long l4 = l1;
                if (l3 != 0L) {
                  l4 = l1;
                  if (!paramBoolean1) {
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("update T_BPARTNER set [fAmount]=[fAmount]+ ");
                    stringBuilder1.append(d2);
                    stringBuilder1.append(",nSpareField2=nSpareField2-1,fSpareField1=fSpareField1+");
                    stringBuilder1.append(d1);
                    stringBuilder1.append(",fPoints = fPoints+");
                    stringBuilder1.append(i);
                    stringBuilder1.append(",");
                    stringBuilder1.append(VW());
                    stringBuilder1.append(" where _id = ");
                    stringBuilder1.append(l3);
                    String str2 = stringBuilder1.toString();
                    sQLiteDatabase.execSQL(str2);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("修改会员信息的SQL语句：");
                    stringBuilder2.append(str2);
                    n.println(stringBuilder2.toString());
                    l4 = l1;
                  } 
                } 
                a a4 = this;
                a3.close();
                l1 = l4;
                a3 = a4;
                return new a(a4, l2, paramLong, l1, null);
              } 
              while (true) {
                a.e(cursor2);
                return new a(a3, "删除订单时，未知错误", null);
              } 
              break;
            } 
          } 
          long l = l1;
          continue;
        } 
        a a2 = a3;
        continue;
      } 
    } catch (Throwable paramString) {
      a1 = this;
    } 
    while (true) {
      a.e(paramString);
      return new a(a1, "删除订单时，未知错误", null);
    } 
    break;
  }
  
  public String a(String paramString1, String paramString2, Date paramDate) {
    long l2;
    long l1;
    byte b1;
    String str1;
    ArrayList arrayList = new ArrayList();
    av av = new av(this.mContext);
    byte b2 = 0;
    if (paramDate == null) {
      l1 = b(0, 0, -1, true);
      l2 = b(0, 0, 0, false);
      null = new StringBuilder();
      null.append((new Date()).getDate());
      null.append("-");
      str1 = null.toString();
    } else {
      l1 = i(str1);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1.getDate());
      stringBuilder1.append("-");
      str1 = stringBuilder1.toString();
      l2 = l1 + 86400000L;
    } 
    av.close();
    SQLiteDatabase sQLiteDatabase = aNE;
    String str3 = Vz();
    String str2 = av.Tx();
    Cursor cursor = sQLiteDatabase.query(str3, new String[] { "sOrderNo", "min(nOperationTime)" }, "nShopID = ?  and nOrderType=? and nOperationTime between ? and ?   and nDateTime between nDateTime/(86400000)*(86400000) and (nDateTime/(86400000)+1)*(86400000)", new String[] { str2, (new String[4][2] = (new String[4][1] = paramString1).valueOf(l1)).valueOf(l2) }, "sOrderNo", null, "nOperationTime ASC");
    while (cursor.moveToNext())
      arrayList.add(cursor.getString(0)); 
    if ("today".equals(paramString2)) {
      b1 = arrayList.size() + 1;
    } else {
      byte b = 0;
      b1 = -1;
      while (b < arrayList.size()) {
        if (((String)arrayList.get(b)).equals(paramString2))
          b1 = b + 1; 
        b++;
      } 
      if (b1 < 0)
        b1 = b2; 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(b1);
    return stringBuilder.toString();
  }
  
  public ArrayList<PendingFullOrderDetail.a> a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2) { return a("", paramString2, paramBoolean, paramInt1, paramInt2, paramString1); }
  
  public ArrayList<PendingFullOrderDetail.a> a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2, String paramString3) {
    Cursor cursor;
    av av = new av(this.mContext);
    String str1 = av.Ea();
    String str2 = av.Tx();
    if (!by.isNull(paramString3) && paramString2.equals("1")) {
      cursor = c(paramString3, paramString2, paramBoolean, paramInt1, paramInt2, str2);
    } else {
      cursor = c(cursor, paramString2, paramBoolean, paramInt1, paramInt2, str2);
    } 
    av.close();
    ArrayList arrayList = new ArrayList();
    while (cursor.moveToNext()) {
      PendingFullOrderDetail.a a1 = new PendingFullOrderDetail.a();
      a1.orderNo = cursor.getString(0);
      a1.coJ = cursor.getString(1);
      a1.coK = cursor.getString(2);
      a1.coE = new Date(cursor.getLong(4));
      a1.coO = cursor.getLong(5);
      a1.coP = cursor.getString(6);
      a1.headerText = cursor.getString(7);
      a1.coQ = cursor.getString(8);
      a1.aVN = cursor.getLong(9);
      a1.coR = cursor.getLong(10);
      a1.aVQ = by.parseInt(cursor.getString(11));
      a1.ceV = str1;
      a1.ceX = Double.valueOf(cursor.getDouble(cursor.getColumnIndex("fDiscount")));
      if (!TextUtils.isEmpty(cursor.getString(cursor.getColumnIndex("sSpareField5"))))
        a1.coJ = cursor.getString(cursor.getColumnIndex("sSpareField5")); 
      str = cursor.getString(cursor.getColumnIndex("sSpareField4"));
      if (!TextUtils.isEmpty(str))
        try {
          JSONObject jSONObject = new JSONObject(str);
          a1.aVS = jSONObject.getLong("firstPayType");
          a1.bfj = jSONObject.getDouble("firstPayValue");
          a1.aVU = jSONObject.getLong("secondPayType");
          a1.bfk = jSONObject.getDouble("secondPayValue");
        } catch (JSONException str) {
          a.e(str);
        }  
      arrayList.add(a1);
    } 
    cursor.close();
    return arrayList;
  }
  
  public void a(long paramLong, String paramString, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    if (this.taxOfSettement == null)
      this.taxOfSettement = new HashMap(); 
    p p = (p)this.taxOfSettement.get(Long.valueOf(paramLong));
    if (p == null) {
      this.taxOfSettement.put(Long.valueOf(paramLong), new p(paramLong, paramString, paramDouble1, paramDouble2, paramDouble3, paramDouble4));
      return;
    } 
    p.a(paramDouble2, paramDouble3, paramDouble4);
  }
  
  public boolean a(PendingFullOrderDetail.d paramd, long paramLong1, long paramLong2, PendingFullOrderDetail.a parama, long paramLong3) {
    ArrayList arrayList = new ArrayList();
    t.a a1 = new t.a();
    a1.a(bNi).setValue(Long.valueOf(paramLong1));
    paramd.cs(paramLong2);
    parama.a(a1);
    a1.a(bNr).setValue(Long.valueOf(paramLong3));
    paramd.a(a1);
    arrayList.add(a1);
    try {
      return M(arrayList);
    } catch (Exception paramd) {
      a.e(paramd);
      return false;
    } 
  }
  
  public boolean a(PendingFullOrderDetail paramPendingFullOrderDetail, long paramLong) {
    try {
      beginTransaction();
      if (paramPendingFullOrderDetail.bXb.orderNo != null) {
        boolean bool1 = kj(paramPendingFullOrderDetail.bXb.orderNo);
        if (!bool1) {
          endTransaction();
          return false;
        } 
      } else {
        PendingFullOrderDetail.a a1 = paramPendingFullOrderDetail.bXb;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("");
        a1.orderNo = stringBuilder.toString();
      } 
      boolean bool = b(paramPendingFullOrderDetail, paramLong);
      if (!bool) {
        endTransaction();
        return false;
      } 
      setTransactionSuccessful();
      endTransaction();
      Intent intent = new Intent("pos_activity_change_data_takeorderscount");
      intent.putExtra("sOrderNo", paramPendingFullOrderDetail.bXb.orderNo);
      this.mContext.sendBroadcast(intent);
      return true;
    } catch (Exception paramPendingFullOrderDetail) {
      a.e(paramPendingFullOrderDetail);
      endTransaction();
      return false;
    } finally {}
    endTransaction();
    throw paramPendingFullOrderDetail;
  }
  
  public boolean a(String paramString, double paramDouble) {
    am("fSpareField1", String.valueOf(paramDouble));
    d(" nShopID=?  and sIsActive='Y' and sOrderNo=?", new String[] { VC(), paramString });
    return update();
  }
  
  public boolean a(String paramString1, long paramLong, String paramString2) {
    am("fPrice", paramString2);
    return ah(paramString1, String.valueOf(paramLong));
  }
  
  @Nullable
  public boolean a(String paramString1, String paramString2, double paramDouble) {
    av av = new av(this.mContext);
    String str = av.Tx();
    av.close();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update T_ORDER set nUpdateFlag = CASE WHEN nUpdateFlag is null then 10000 ELSE nUpdateFlag + 10000 END,sSpareField4='");
    stringBuilder.append(paramString1);
    stringBuilder.append("',fDiscount=");
    stringBuilder.append(paramDouble);
    stringBuilder.append(" where sOrderNo=");
    stringBuilder.append(paramString2);
    stringBuilder.append(" and T_ORDER.nShopID = ");
    stringBuilder.append(str);
    paramString1 = stringBuilder.toString();
    try {
      aNE.execSQL(paramString1);
      return true;
    } catch (Exception paramString1) {
      a.e(paramString1);
      return false;
    } 
  }
  
  @Deprecated
  public boolean a(ArrayList<HashMap<String, Object>> paramArrayList, String paramString1, long paramLong, String paramString2) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong);
      stringBuilder.append("");
      boolean bool = a(paramArrayList, paramString1, stringBuilder.toString(), paramString2);
      if (!bool)
        return false; 
      this.mContext.sendBroadcast(new Intent("pos_activity_change_data_takeorderscount"));
      return true;
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return false;
    } 
  }
  
  @Deprecated
  public boolean a(ArrayList<HashMap<String, Object>> paramArrayList, String paramString1, String paramString2, String paramString3) {
    long l = System.currentTimeMillis();
    Iterator iterator = paramArrayList.iterator();
    byte b;
    for (b = 0; iterator.hasNext(); b++) {
      HashMap hashMap = (HashMap)iterator.next();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(l + b);
      stringBuilder2.append("");
      am("_id", stringBuilder2.toString());
      am("sOrderNo", paramString2);
      am("nProductTransacType", (String)hashMap.get("nProductTransacType"));
      am("nStcokDirection", (String)hashMap.get("nStcokDirection"));
      am("fDiscount", (String)hashMap.get("fDiscount"));
      am("nDateTime", (String)hashMap.get("nDateTime"));
      am("sText", (String)hashMap.get("sText"));
      am("nPhysicalInventoryID", paramString1);
      am("sItemNo", (String)hashMap.get("sItemNo"));
      am("nProductID", (String)hashMap.get("nProductID"));
      am("nSpareField1", (String)hashMap.get("nProductType"));
      am("nWarehouseID", (String)hashMap.get("nWarehouseID"));
      String str3 = (String)hashMap.get("taste");
      String str2 = (String)hashMap.get("sProductName");
      String str1 = str2;
      if (str3 != null) {
        str1 = str2;
        if (!"".equals(str3.trim()))
          str1 = aA(str2, str3); 
      } 
      am("sProductName", str1);
      am("nProductQty", (String)hashMap.get("nProductQty"));
      am("nProductUnit", (String)hashMap.get("nProductUnit"));
      am("fPrice", (String)hashMap.get("fPrice"));
      am("fSpareField1", (String)hashMap.get("fDBOriginalPrice"));
      Boolean bool2 = (Boolean)hashMap.get("bModifyPrice");
      Boolean bool1 = bool2;
      if (bool2 == null)
        bool1 = Boolean.valueOf(false); 
      if (bool1.booleanValue()) {
        am("fSpareField2", (String)hashMap.get("fOriginalPrice"));
        am("sItemText", "Y");
      } 
      am("fAmount", (String)hashMap.get("fAmount"));
      am("fReceived", (String)hashMap.get("fReceived"));
      am("sSpareField1", paramString3);
      am("sSpareField2", (String)hashMap.get("sGUIID"));
      am("nSpareField1", (String)hashMap.get("nProductType"));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(l);
      stringBuilder1.append("");
      am("nOperationTime", stringBuilder1.toString());
      am(bOe.getName(), this.bSU);
      if (!QL())
        return false; 
    } 
    return true;
  }
  
  public String aA(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("[");
    stringBuilder.append(paramString2);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public ArrayList<PendingFullOrderDetail.a> aB(String paramString1, String paramString2) { return a("", paramString1, false, 0, 0, paramString2); }
  
  public Map<String, Object> aC(String paramString1, String paramString2) { return F(paramString1, (new av(this.mContext)).Tx(), paramString2); }
  
  public String[] aD(String paramString1, String paramString2) {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (Long.valueOf(paramString2).longValue() > 0L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append("");
      paramString1 = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append("");
      paramString2 = stringBuilder.toString();
      Cursor cursor = aNE.rawQuery("select sUserName,sUserPhone from t_user where nShopID=? and _id=? and nDeletionFlag = 170002", new String[] { paramString1, paramString2 });
      if (cursor.moveToFirst()) {
        arrayOfString[0] = cursor.getString(0);
        arrayOfString[1] = cursor.getString(1);
      } 
      cursor.close();
    } 
    return arrayOfString;
  }
  
  public ArrayList<ap> aE(String paramString1, String paramString2) {
    String[] arrayOfString;
    ArrayList arrayList = new ArrayList();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select distinct u._id,u.sUserName,u.sUserPhone from t_user u left join t_role r on u._id=r.nUserid where  u.nShopID=? ");
    if (by.isNull(paramString2)) {
      str = "";
    } else {
      str = "and  u._id=? ";
    } 
    stringBuilder.append(str);
    stringBuilder.append("and (u.nUserRole==150001 or (u.nDeletionFlag = 170002 and r.sRoleName=90022 and r.sIsActive='Y'))");
    String str = stringBuilder.toString();
    if (by.isNull(paramString2)) {
      String[] arrayOfString1;
      arrayOfString = new String[1];
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append("");
      arrayOfString[0] = stringBuilder.toString();
      arrayOfString1 = arrayOfString;
    } else {
      arrayOfString1 = new String[] { arrayOfString1, arrayOfString };
    } 
    Cursor cursor = aNE.rawQuery(str, arrayOfString1);
    while (cursor.moveToNext())
      arrayList.add(new ap(cursor.getLong(0), cursor.getString(1), cursor.getString(2))); 
    cursor.close();
    return arrayList;
  }
  
  public boolean aF(String paramString1, String paramString2) {
    String str1 = Calendar.getInstance();
    str1.set(str1.get(1), str1.get(2), str1.get(5), 0, 0, 0);
    long l1 = str1.getTimeInMillis() - 86400000L;
    long l2 = System.currentTimeMillis();
    if (kr(paramString1)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select * from t_order  where nShopID=? and sIsActive='Y' and sSpareField5 = ?  and sOrderNo not like ? and nOperationTime between ");
      stringBuilder.append(l1);
      stringBuilder.append(" and ");
      stringBuilder.append(l2);
      String str = stringBuilder.toString();
    } else {
      null = new StringBuilder();
      null.append("select * from t_order  where nShopID=? and sIsActive='Y' and nPhysicalInventoryID = ?  and sOrderNo not like ? and nOperationTime between ");
      null.append(l1);
      null.append(" and ");
      null.append(l2);
      str1 = null.toString();
    } 
    av av = new av(this.mContext);
    String str2 = av.Tx();
    av.close();
    Cursor cursor = aNE.rawQuery(str1, new String[] { str2, paramString1, paramString2 });
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool;
  }
  
  public LinkedHashMap<Long, ArrayList<HashMap<String, Object>>> aG(String paramString1, String paramString2) {
    new LinkedHashMap();
    try {
      Cursor cursor = Vq().rawQuery("SELECT T_ORDER.*, T_PRODUCT.sSpareField5 as sProductName2 FROM T_ORDER JOIN T_PRODUCT ON T_ORDER.nProductID = T_PRODUCT._id WHERE T_ORDER.sOrderNo like ? and T_ORDER.nShopID = ? ORDER BY T_ORDER.nDateTime ASC,CAST(ifnull(T_ORDER.sItemNo,'0') AS SIGNED integer) ASC", new String[] { paramString1, paramString2 });
    } catch (Exception paramString2) {
      a.e(paramString2);
      paramString2 = null;
    } 
    ArrayList arrayList = ab.d(paramString2);
    for (HashMap hashMap : arrayList)
      hashMap.put("serialNumber", a("1", paramString1, new Date(((Long)hashMap.get("nDateTime")).longValue()))); 
    LinkedHashMap linkedHashMap = k.a(arrayList, new e(this));
    if (paramString2 != null)
      paramString2.close(); 
    if (arrayList != null)
      arrayList.clear(); 
    return linkedHashMap;
  }
  
  public a aH(String paramString1, String paramString2) {
    try {
      SQLiteDatabase sQLiteDatabase = r(Long.parseLong(paramString2), Long.parseLong(paramString2));
    } catch (Exception paramString2) {
      a.e(paramString2);
      paramString2 = null;
    } 
    try {
      long l = System.currentTimeMillis();
      StringBuilder stringBuilder = new StringBuilder();
      a(paramString2, stringBuilder, true, "sOrderNo", paramString1, "t_productdoc", "nDeletionFlag", l, null);
      a(paramString2, stringBuilder, true, "sText", paramString1, "t_accountdoc", "nDeletionFlag", l, null);
      a(paramString2, stringBuilder, true, "sText", paramString1, "t_bpartner_chargedoc", "sSpareField1", l, null);
      return new a(this, l, l, 0L, null);
    } catch (Throwable paramString1) {
      a.e(paramString1);
      return new a(this, "删除订单时，未知错误", null);
    } 
  }
  
  public boolean ay(String paramString1, String paramString2) {
    am("nSpareField5", paramString1);
    d(" nShopID=?  and sIsActive='Y' and sOrderNo=?", new String[] { VC(), paramString2 });
    return update();
  }
  
  public boolean az(String paramString1, String paramString2) {
    am("nPhysicalInventoryID", paramString2);
    am("sSpareField5", paramString2);
    d(" nShopID=?  and sIsActive='Y' and sOrderNo=?", new String[] { VC(), paramString1 });
    return update();
  }
  
  public ArrayList<PendingFullOrderDetail.a> b(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2) { return b(paramString1, paramString2, paramBoolean, paramInt1, paramInt2, ""); }
  
  public ArrayList<PendingFullOrderDetail.a> b(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2, String paramString3) { // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: iconst_0
    //   3: iconst_m1
    //   4: iconst_1
    //   5: invokespecial b : (IIIZ)J
    //   8: lstore #7
    //   10: aload_0
    //   11: iconst_0
    //   12: iconst_0
    //   13: iconst_0
    //   14: iconst_0
    //   15: invokespecial b : (IIIZ)J
    //   18: lstore #9
    //   20: new com/laiqian/util/av
    //   23: dup
    //   24: aload_0
    //   25: getfield mContext : Landroid/content/Context;
    //   28: invokespecial <init> : (Landroid/content/Context;)V
    //   31: astore #13
    //   33: aload #13
    //   35: invokevirtual Ea : ()Ljava/lang/String;
    //   38: astore #12
    //   40: aload #13
    //   42: invokevirtual Tx : ()Ljava/lang/String;
    //   45: astore #14
    //   47: aload #6
    //   49: invokestatic isNull : (Ljava/lang/String;)Z
    //   52: ifne -> 87
    //   55: aload_2
    //   56: astore #11
    //   58: aload #11
    //   60: ldc_w '1'
    //   63: invokevirtual equals : (Ljava/lang/Object;)Z
    //   66: ifeq -> 87
    //   69: aload_0
    //   70: aload #6
    //   72: aload #11
    //   74: lload #7
    //   76: lload #9
    //   78: aload #14
    //   80: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)Landroid/database/Cursor;
    //   83: astore_1
    //   84: goto -> 105
    //   87: aload_0
    //   88: aload_1
    //   89: aload_2
    //   90: iload_3
    //   91: iload #4
    //   93: iload #5
    //   95: lload #7
    //   97: lload #9
    //   99: aload #14
    //   101: invokespecial a : (Ljava/lang/String;Ljava/lang/String;ZIIJJLjava/lang/String;)Landroid/database/Cursor;
    //   104: astore_1
    //   105: aload #13
    //   107: invokevirtual close : ()V
    //   110: new java/util/ArrayList
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: astore_2
    //   118: aload_1
    //   119: invokeinterface moveToNext : ()Z
    //   124: ifeq -> 342
    //   127: new com/laiqian/pos/hold/PendingFullOrderDetail$a
    //   130: dup
    //   131: invokespecial <init> : ()V
    //   134: astore #6
    //   136: aload #6
    //   138: aload_1
    //   139: iconst_0
    //   140: invokeinterface getString : (I)Ljava/lang/String;
    //   145: putfield orderNo : Ljava/lang/String;
    //   148: aload #6
    //   150: aload_1
    //   151: iconst_1
    //   152: invokeinterface getString : (I)Ljava/lang/String;
    //   157: putfield coJ : Ljava/lang/String;
    //   160: aload #6
    //   162: aload_1
    //   163: iconst_2
    //   164: invokeinterface getString : (I)Ljava/lang/String;
    //   169: putfield coK : Ljava/lang/String;
    //   172: aload #6
    //   174: new java/util/Date
    //   177: dup
    //   178: aload_1
    //   179: iconst_4
    //   180: invokeinterface getLong : (I)J
    //   185: invokespecial <init> : (J)V
    //   188: putfield coE : Ljava/util/Date;
    //   191: aload #6
    //   193: aload_1
    //   194: iconst_5
    //   195: invokeinterface getLong : (I)J
    //   200: putfield coO : J
    //   203: aload #6
    //   205: aload_1
    //   206: bipush #6
    //   208: invokeinterface getString : (I)Ljava/lang/String;
    //   213: putfield coP : Ljava/lang/String;
    //   216: aload #6
    //   218: aload_1
    //   219: bipush #7
    //   221: invokeinterface getString : (I)Ljava/lang/String;
    //   226: putfield headerText : Ljava/lang/String;
    //   229: aload #6
    //   231: aload_1
    //   232: bipush #8
    //   234: invokeinterface getString : (I)Ljava/lang/String;
    //   239: putfield coQ : Ljava/lang/String;
    //   242: aload #6
    //   244: aload_1
    //   245: bipush #9
    //   247: invokeinterface getLong : (I)J
    //   252: putfield aVN : J
    //   255: aload #6
    //   257: aload_1
    //   258: bipush #10
    //   260: invokeinterface getLong : (I)J
    //   265: putfield coR : J
    //   268: aload #6
    //   270: aload_1
    //   271: bipush #11
    //   273: invokeinterface getString : (I)Ljava/lang/String;
    //   278: invokestatic parseInt : (Ljava/lang/String;)I
    //   281: putfield aVQ : I
    //   284: aload #6
    //   286: aload #12
    //   288: putfield ceV : Ljava/lang/String;
    //   291: aload_1
    //   292: aload_1
    //   293: ldc_w 'sSpareField5'
    //   296: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   301: invokeinterface getString : (I)Ljava/lang/String;
    //   306: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   309: ifne -> 332
    //   312: aload #6
    //   314: aload_1
    //   315: aload_1
    //   316: ldc_w 'sSpareField5'
    //   319: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   324: invokeinterface getString : (I)Ljava/lang/String;
    //   329: putfield coJ : Ljava/lang/String;
    //   332: aload_2
    //   333: aload #6
    //   335: invokevirtual add : (Ljava/lang/Object;)Z
    //   338: pop
    //   339: goto -> 118
    //   342: aload_1
    //   343: invokeinterface close : ()V
    //   348: aload_2
    //   349: areturn }
  
  public boolean b(PendingFullOrderDetail.c paramc, PendingFullOrderDetail.a parama) {
    boolean bool;
    try {
      beginTransaction();
      byte b1;
      for (b1 = 0; b1 < paramc.cpg.size(); b1++) {
        PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)paramc.cpg.get(b1);
        if (d.aTO > 0L && !b(d)) {
          endTransaction();
          endTransaction();
          return false;
        } 
      } 
      if (parama.aVS > 0L) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("firstPayType", parama.aVS);
        jSONObject.put("firstPayValue", parama.bfj);
        jSONObject.put("secondPayType", parama.aVU);
        jSONObject.put("secondPayValue", parama.bfk);
        a(jSONObject.toString(), parama.orderNo, parama.ceX.doubleValue());
      } 
      long l = System.currentTimeMillis();
      ArrayList arrayList = new ArrayList();
      Iterator iterator = paramc.cpg.iterator();
      b1 = 0;
      byte b2;
      for (b2 = 1; iterator.hasNext(); b2 = b) {
        byte b;
        PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator.next();
        if (d.aTP)
          continue; 
        t.a a1 = new t.a();
        a1.a(bNi).setValue(Long.valueOf(l + b1));
        if (d.aTO == 0L && d.cpx != 3L) {
          d.cs(b2);
          b = b2 + true;
        } else {
          b = b2;
          if (d.aTO == 0L) {
            b = b2;
            if (d.cpx == 3L) {
              d.cs((b2 - 1));
              b = b2;
            } 
          } 
        } 
        parama.a(a1);
        if (d.aTO == 0L) {
          a1.a(bNr).setValue(Long.valueOf(paramc.cpi.getTime()));
        } else {
          a1.a(bNr).setValue(Long.valueOf(d.bbX));
        } 
        d.a(a1);
        arrayList.add(a1);
        b1++;
      } 
      bool = M(arrayList);
      setTransactionSuccessful();
      endTransaction();
    } catch (Exception paramc) {
      a.e(paramc);
      endTransaction();
      bool = false;
    } finally {}
    if (bool) {
      Intent intent = new Intent("pos_activity_change_data_takeorderscount");
      intent.putExtra("sOrderNo", parama.orderNo);
      this.mContext.sendBroadcast(intent);
    } 
    return bool;
  }
  
  @Nullable
  public boolean b(PendingFullOrderDetail.d paramd) {
    String str2;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update T_ORDER set nUpdateFlag = CASE WHEN nUpdateFlag is null then 10000 ELSE nUpdateFlag + 10000 END,nProductQty=");
    if (paramd.aTP) {
      str2 = "";
    } else {
      str2 = "nProductQty+";
    } 
    stringBuilder.append(str2);
    stringBuilder.append(paramd.cpo);
    stringBuilder.append(" where _id=");
    stringBuilder.append(paramd.aTO);
    stringBuilder.append("");
    str1 = stringBuilder.toString();
    try {
      aNE.execSQL(str1);
      return true;
    } catch (Exception str1) {
      a.e(str1);
      return false;
    } 
  }
  
  public boolean b(PendingFullOrderDetail paramPendingFullOrderDetail, long paramLong) {
    arrayList = paramPendingFullOrderDetail.aaG();
    Iterator iterator = arrayList.iterator();
    byte b;
    for (b = 0; iterator.hasNext(); b++)
      ((t.a)iterator.next()).a(bNi).setValue(Long.valueOf(paramLong + b)); 
    try {
      return M(arrayList);
    } catch (Exception arrayList) {
      a.e(arrayList);
      return false;
    } 
  }
  
  public PendingFullOrderDetail.c c(PendingFullOrderDetail.c paramc, PendingFullOrderDetail paramPendingFullOrderDetail) {
    byte b;
    for (b = 0; b < paramc.cpg.size(); b = b1 + 1) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)paramc.cpg.get(b);
      byte b1 = b;
      if (d.aTO > 0L) {
        double d1 = a(d, paramPendingFullOrderDetail);
        if (d1 > 0.0D) {
          double d2 = d.cpo + d1;
          if (d2 < 0.0D) {
            d.aTP = true;
            d.cpo = -d1;
            b1 = b;
          } else {
            b1 = b;
            if (d2 == 0.0D) {
              d.aTP = true;
              b1 = b;
            } 
          } 
        } else {
          b1 = b;
          if (d1 < 0.0D) {
            paramc.cpg.remove(b);
            b1 = b - 1;
          } 
        } 
      } 
    } 
    return paramc;
  }
  
  public boolean c(String paramString1, String paramString2, long paramLong) {
    am("nPhysicalInventoryID", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    am("nSpareField4", stringBuilder.toString());
    am("sSpareField5", paramString2);
    return hx(paramString1);
  }
  
  @Nullable
  public String cu(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    char c = 'A';
    stringBuilder.append('A');
    String str = stringBuilder.toString();
    while (ku(str)) {
      null = new StringBuilder();
      null.append(paramLong);
      null.append("");
      char c1 = (char)(c + 1);
      null.append(c1);
      str = null.toString();
      c = c1;
      if (c1 > 'Z')
        return null; 
    } 
    return str;
  }
  
  @Nullable
  public TakeOrderEntity d(LinkedHashMap<Long, ArrayList<HashMap<String, Object>>> paramLinkedHashMap) { // Byte code:
    //   0: new com/laiqian/util/av
    //   3: dup
    //   4: aload_0
    //   5: getfield mContext : Landroid/content/Context;
    //   8: invokespecial <init> : (Landroid/content/Context;)V
    //   11: astore #43
    //   13: aload #43
    //   15: invokevirtual Tx : ()Ljava/lang/String;
    //   18: astore #46
    //   20: aload #43
    //   22: invokevirtual close : ()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield taxOfSettement : Ljava/util/HashMap;
    //   30: new java/util/ArrayList
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: astore #47
    //   39: aload_1
    //   40: invokevirtual size : ()I
    //   43: ifne -> 48
    //   46: aconst_null
    //   47: areturn
    //   48: aload_1
    //   49: invokevirtual entrySet : ()Ljava/util/Set;
    //   52: invokeinterface iterator : ()Ljava/util/Iterator;
    //   57: astore #54
    //   59: ldc_w ''
    //   62: astore #53
    //   64: ldc_w ''
    //   67: astore #52
    //   69: aconst_null
    //   70: astore #51
    //   72: aload #51
    //   74: astore #43
    //   76: aload #43
    //   78: astore #44
    //   80: aload #44
    //   82: astore #45
    //   84: aload #45
    //   86: astore #50
    //   88: lconst_0
    //   89: lstore #38
    //   91: lload #38
    //   93: lstore #34
    //   95: lload #34
    //   97: lstore #36
    //   99: lload #36
    //   101: lstore #32
    //   103: lload #32
    //   105: lstore #30
    //   107: dconst_0
    //   108: dstore #14
    //   110: dload #14
    //   112: dstore #8
    //   114: dload #8
    //   116: dstore #4
    //   118: dload #4
    //   120: dstore #6
    //   122: dload #6
    //   124: dstore #10
    //   126: dload #10
    //   128: dstore #12
    //   130: dload #12
    //   132: dstore_2
    //   133: dload_2
    //   134: dstore #18
    //   136: dload #12
    //   138: dstore #24
    //   140: dload #10
    //   142: dstore #22
    //   144: dload #6
    //   146: dstore #20
    //   148: aload #45
    //   150: astore #49
    //   152: aload #44
    //   154: astore #48
    //   156: aload #54
    //   158: astore #45
    //   160: dload #14
    //   162: dstore #10
    //   164: aload #43
    //   166: astore #44
    //   168: aload #51
    //   170: astore #43
    //   172: aload #53
    //   174: astore #51
    //   176: aconst_null
    //   177: astore #53
    //   179: aload #45
    //   181: invokeinterface hasNext : ()Z
    //   186: istore #42
    //   188: iload #42
    //   190: ifeq -> 1797
    //   193: aload #45
    //   195: invokeinterface next : ()Ljava/lang/Object;
    //   200: checkcast java/util/Map$Entry
    //   203: astore #50
    //   205: aload #50
    //   207: invokeinterface getValue : ()Ljava/lang/Object;
    //   212: checkcast java/util/ArrayList
    //   215: iconst_0
    //   216: invokevirtual get : (I)Ljava/lang/Object;
    //   219: checkcast java/util/HashMap
    //   222: astore #49
    //   224: new java/util/Date
    //   227: dup
    //   228: aload #50
    //   230: invokeinterface getKey : ()Ljava/lang/Object;
    //   235: checkcast java/lang/Long
    //   238: invokevirtual longValue : ()J
    //   241: invokespecial <init> : (J)V
    //   244: astore #48
    //   246: new java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial <init> : ()V
    //   253: astore #43
    //   255: aload #43
    //   257: aload #49
    //   259: ldc_w 'nSpareField4'
    //   262: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   265: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload #43
    //   271: ldc_w ''
    //   274: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload #43
    //   280: invokevirtual toString : ()Ljava/lang/String;
    //   283: invokestatic sd : (Ljava/lang/String;)Ljava/lang/String;
    //   286: invokestatic parseLong : (Ljava/lang/String;)J
    //   289: lstore #40
    //   291: new java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial <init> : ()V
    //   298: astore #43
    //   300: aload #43
    //   302: aload #49
    //   304: ldc_w 'nSpareField5'
    //   307: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   310: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload #43
    //   316: ldc_w ''
    //   319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload #43
    //   325: invokevirtual toString : ()Ljava/lang/String;
    //   328: invokestatic sd : (Ljava/lang/String;)Ljava/lang/String;
    //   331: invokestatic parseLong : (Ljava/lang/String;)J
    //   334: lstore #38
    //   336: new java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial <init> : ()V
    //   343: astore #43
    //   345: aload #43
    //   347: aload #49
    //   349: ldc_w 'nBPartnerID'
    //   352: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   355: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload #43
    //   361: ldc_w ''
    //   364: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload #43
    //   370: invokevirtual toString : ()Ljava/lang/String;
    //   373: invokestatic sd : (Ljava/lang/String;)Ljava/lang/String;
    //   376: invokestatic parseLong : (Ljava/lang/String;)J
    //   379: lstore #36
    //   381: aload #49
    //   383: ldc_w 'sSpareField4'
    //   386: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   389: checkcast java/lang/String
    //   392: astore #44
    //   394: aload #49
    //   396: ldc_w 'serialNumber'
    //   399: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   402: checkcast java/lang/String
    //   405: astore #57
    //   407: aload_0
    //   408: getfield mContext : Landroid/content/Context;
    //   411: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   414: getstatic com/laiqian/infrastructure/R$bool.is_DiscountConvertion : I
    //   417: invokevirtual getBoolean : (I)Z
    //   420: istore #42
    //   422: iload #42
    //   424: ifeq -> 496
    //   427: aload #53
    //   429: astore #43
    //   431: new java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial <init> : ()V
    //   438: astore #52
    //   440: aload #53
    //   442: astore #43
    //   444: aload #52
    //   446: aload #49
    //   448: ldc_w 'fDiscount'
    //   451: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   454: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload #53
    //   460: astore #43
    //   462: aload #52
    //   464: ldc_w ''
    //   467: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload #53
    //   473: astore #43
    //   475: aload #52
    //   477: invokevirtual toString : ()Ljava/lang/String;
    //   480: invokestatic parseDouble : (Ljava/lang/String;)D
    //   483: dstore #6
    //   485: ldc2_w 100.0
    //   488: dload #6
    //   490: dsub
    //   491: dstore #6
    //   493: goto -> 538
    //   496: new java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial <init> : ()V
    //   503: astore #43
    //   505: aload #43
    //   507: aload #49
    //   509: ldc_w 'fDiscount'
    //   512: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   515: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload #43
    //   521: ldc_w ''
    //   524: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload #43
    //   530: invokevirtual toString : ()Ljava/lang/String;
    //   533: invokestatic parseDouble : (Ljava/lang/String;)D
    //   536: dstore #6
    //   538: dload #6
    //   540: invokestatic valueOf : (D)Ljava/lang/Double;
    //   543: astore #52
    //   545: aload #44
    //   547: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   550: istore #42
    //   552: iload #42
    //   554: ifne -> 763
    //   557: aload #53
    //   559: astore #43
    //   561: new org/json/JSONObject
    //   564: dup
    //   565: aload #44
    //   567: invokespecial <init> : (Ljava/lang/String;)V
    //   570: astore #44
    //   572: aload #53
    //   574: astore #43
    //   576: aload #44
    //   578: ldc_w 'firstPayType'
    //   581: invokevirtual optLong : (Ljava/lang/String;)J
    //   584: lstore #34
    //   586: aload #53
    //   588: astore #43
    //   590: aload #44
    //   592: ldc_w 'firstPayValue'
    //   595: invokevirtual optDouble : (Ljava/lang/String;)D
    //   598: dstore #6
    //   600: aload #53
    //   602: astore #43
    //   604: aload #44
    //   606: ldc_w 'secondPayType'
    //   609: invokevirtual optLong : (Ljava/lang/String;)J
    //   612: lstore #32
    //   614: aload #53
    //   616: astore #43
    //   618: aload #44
    //   620: ldc_w 'secondPayValue'
    //   623: invokevirtual optDouble : (Ljava/lang/String;)D
    //   626: dstore #8
    //   628: aload #53
    //   630: astore #43
    //   632: aload #44
    //   634: ldc_w 'pointsDeductionAmount'
    //   637: invokevirtual optDouble : (Ljava/lang/String;)D
    //   640: dstore #4
    //   642: aload #53
    //   644: astore #43
    //   646: dload #4
    //   648: invokestatic isNaN : (D)Z
    //   651: istore #42
    //   653: iload #42
    //   655: ifeq -> 664
    //   658: dconst_0
    //   659: dstore #16
    //   661: goto -> 668
    //   664: dload #4
    //   666: dstore #16
    //   668: lload #32
    //   670: lstore #30
    //   672: lload #34
    //   674: lstore #32
    //   676: dload #6
    //   678: dstore #12
    //   680: dload #8
    //   682: dstore #14
    //   684: goto -> 774
    //   687: astore #43
    //   689: dload #4
    //   691: dstore_2
    //   692: goto -> 700
    //   695: astore #43
    //   697: goto -> 700
    //   700: dload #8
    //   702: dstore #4
    //   704: goto -> 709
    //   707: astore #43
    //   709: lload #32
    //   711: lstore #30
    //   713: goto -> 718
    //   716: astore #43
    //   718: dload #6
    //   720: dstore #8
    //   722: goto -> 727
    //   725: astore #43
    //   727: lload #34
    //   729: lstore #32
    //   731: aload #43
    //   733: astore #44
    //   735: goto -> 740
    //   738: astore #44
    //   740: aload #53
    //   742: astore #43
    //   744: aload #44
    //   746: invokestatic e : (Ljava/lang/Throwable;)V
    //   749: dload #8
    //   751: dstore #12
    //   753: dload #4
    //   755: dstore #14
    //   757: dload_2
    //   758: dstore #16
    //   760: goto -> 774
    //   763: dload_2
    //   764: dstore #16
    //   766: dload #4
    //   768: dstore #14
    //   770: dload #8
    //   772: dstore #12
    //   774: aload #49
    //   776: astore #53
    //   778: new java/lang/StringBuffer
    //   781: dup
    //   782: invokespecial <init> : ()V
    //   785: astore #49
    //   787: aload #50
    //   789: invokeinterface getValue : ()Ljava/lang/Object;
    //   794: checkcast java/util/ArrayList
    //   797: astore #50
    //   799: dload #10
    //   801: dstore #4
    //   803: aconst_null
    //   804: astore #44
    //   806: iconst_0
    //   807: istore #28
    //   809: dload #18
    //   811: dstore #6
    //   813: dload #24
    //   815: dstore_2
    //   816: dload #20
    //   818: dstore #18
    //   820: aload #52
    //   822: astore #43
    //   824: iload #28
    //   826: aload #50
    //   828: invokevirtual size : ()I
    //   831: if_icmpge -> 1698
    //   834: aload #50
    //   836: iload #28
    //   838: invokevirtual get : (I)Ljava/lang/Object;
    //   841: checkcast java/util/HashMap
    //   844: astore #61
    //   846: aload_0
    //   847: aload #61
    //   849: invokespecial E : (Ljava/util/HashMap;)J
    //   852: lstore #34
    //   854: aload #61
    //   856: ldc_w 'sProductName'
    //   859: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   862: checkcast java/lang/String
    //   865: ldc_w '['
    //   868: invokevirtual indexOf : (Ljava/lang/String;)I
    //   871: istore #29
    //   873: aload #61
    //   875: ldc_w 'sProductName'
    //   878: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   881: checkcast java/lang/String
    //   884: astore #56
    //   886: ldc_w ''
    //   889: astore #55
    //   891: aload #56
    //   893: ldc_w '['
    //   896: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   899: ifeq -> 2061
    //   902: aload #56
    //   904: iload #29
    //   906: invokevirtual substring : (I)Ljava/lang/String;
    //   909: ldc_w '['
    //   912: ldc_w ''
    //   915: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   918: ldc_w ']'
    //   921: ldc_w ''
    //   924: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   927: astore #55
    //   929: aload #56
    //   931: iconst_0
    //   932: iload #29
    //   934: invokevirtual substring : (II)Ljava/lang/String;
    //   937: astore #56
    //   939: goto -> 942
    //   942: aload #45
    //   944: astore #54
    //   946: aload #53
    //   948: ldc 'sOrderNo'
    //   950: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   953: checkcast java/lang/String
    //   956: astore #58
    //   958: aload #61
    //   960: ldc_w 'sSpareField3'
    //   963: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   966: checkcast java/lang/String
    //   969: astore #45
    //   971: new java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial <init> : ()V
    //   978: astore #51
    //   980: aload #51
    //   982: aload #61
    //   984: ldc_w 'nProductQty'
    //   987: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   990: checkcast java/lang/Double
    //   993: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload #51
    //   999: ldc_w ''
    //   1002: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload #51
    //   1008: invokevirtual toString : ()Ljava/lang/String;
    //   1011: invokestatic parseDouble : (Ljava/lang/String;)D
    //   1014: dconst_0
    //   1015: dcmpl
    //   1016: ifle -> 2064
    //   1019: iconst_1
    //   1020: istore #29
    //   1022: goto -> 1025
    //   1025: aload #45
    //   1027: invokestatic isNull : (Ljava/lang/String;)Z
    //   1030: istore #42
    //   1032: iload #42
    //   1034: ifne -> 2076
    //   1037: new org/json/JSONObject
    //   1040: dup
    //   1041: aload #45
    //   1043: invokespecial <init> : (Ljava/lang/String;)V
    //   1046: astore #52
    //   1048: aload #52
    //   1050: ldc_w 'tax'
    //   1053: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1056: astore #45
    //   1058: aload #45
    //   1060: invokestatic isNull : (Ljava/lang/String;)Z
    //   1063: istore #42
    //   1065: iload #42
    //   1067: ifne -> 1137
    //   1070: aload #45
    //   1072: astore #51
    //   1074: aload #52
    //   1076: ldc_w 'amountOfNoTax'
    //   1079: invokevirtual optDouble : (Ljava/lang/String;)D
    //   1082: dstore #10
    //   1084: aload #52
    //   1086: ldc_w 'amountOfAddPrice'
    //   1089: invokevirtual optDouble : (Ljava/lang/String;)D
    //   1092: dstore #20
    //   1094: dload #10
    //   1096: dstore #8
    //   1098: dload #10
    //   1100: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1103: astore #45
    //   1105: dload #8
    //   1107: dstore #10
    //   1109: dload #20
    //   1111: dstore #8
    //   1113: goto -> 1191
    //   1116: astore_1
    //   1117: goto -> 1179
    //   1120: astore #52
    //   1122: dconst_0
    //   1123: dstore #8
    //   1125: aload #51
    //   1127: astore #45
    //   1129: goto -> 1179
    //   1132: astore #51
    //   1134: goto -> 1153
    //   1137: dconst_0
    //   1138: dstore #10
    //   1140: dload #10
    //   1142: dstore #8
    //   1144: aload #45
    //   1146: astore #51
    //   1148: goto -> 2070
    //   1151: astore #51
    //   1153: dconst_0
    //   1154: dstore #10
    //   1156: dload #10
    //   1158: dstore #8
    //   1160: aload #51
    //   1162: astore #52
    //   1164: goto -> 1179
    //   1167: astore #52
    //   1169: dconst_0
    //   1170: dstore #10
    //   1172: dload #10
    //   1174: dstore #8
    //   1176: aconst_null
    //   1177: astore #45
    //   1179: aload #52
    //   1181: invokestatic e : (Ljava/lang/Throwable;)V
    //   1184: aload #45
    //   1186: astore #51
    //   1188: goto -> 2070
    //   1191: aload #45
    //   1193: ifnonnull -> 2098
    //   1196: aload #61
    //   1198: ldc_w 'fPrice'
    //   1201: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1204: checkcast java/lang/Double
    //   1207: invokevirtual doubleValue : ()D
    //   1210: dstore #24
    //   1212: iload #29
    //   1214: ifeq -> 2092
    //   1217: aload #61
    //   1219: ldc_w 'nProductQty'
    //   1222: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1225: checkcast java/lang/Double
    //   1228: invokevirtual doubleValue : ()D
    //   1231: dstore #20
    //   1233: goto -> 1236
    //   1236: dload #24
    //   1238: dload #20
    //   1240: dmul
    //   1241: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1244: astore #45
    //   1246: goto -> 1249
    //   1249: dload #10
    //   1251: dstore #26
    //   1253: dload #4
    //   1255: dstore #10
    //   1257: dload #18
    //   1259: dstore #20
    //   1261: dload #22
    //   1263: dstore #24
    //   1265: lload #34
    //   1267: ldc2_w 3
    //   1270: lcmp
    //   1271: ifeq -> 1412
    //   1274: dload #18
    //   1276: dstore #20
    //   1278: aload #43
    //   1280: ifnull -> 1316
    //   1283: dload #18
    //   1285: dstore #20
    //   1287: iload #29
    //   1289: ifeq -> 1316
    //   1292: dload #18
    //   1294: ldc2_w 100.0
    //   1297: aload #43
    //   1299: invokevirtual doubleValue : ()D
    //   1302: dsub
    //   1303: aload #45
    //   1305: invokevirtual doubleValue : ()D
    //   1308: dmul
    //   1309: ldc2_w 100.0
    //   1312: ddiv
    //   1313: dadd
    //   1314: dstore #20
    //   1316: aload #61
    //   1318: ldc_w 'fPrice'
    //   1321: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1324: checkcast java/lang/Double
    //   1327: invokevirtual doubleValue : ()D
    //   1330: dstore #18
    //   1332: iload #29
    //   1334: ifeq -> 2101
    //   1337: aload #61
    //   1339: ldc_w 'nProductQty'
    //   1342: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1345: checkcast java/lang/Double
    //   1348: invokevirtual doubleValue : ()D
    //   1351: dstore #10
    //   1353: goto -> 1356
    //   1356: dload #4
    //   1358: dload #18
    //   1360: dload #10
    //   1362: dmul
    //   1363: dadd
    //   1364: dstore #10
    //   1366: new java/lang/StringBuilder
    //   1369: dup
    //   1370: invokespecial <init> : ()V
    //   1373: astore #45
    //   1375: aload #45
    //   1377: ldc_w 'getTakeOrderEntity product sum recevied '
    //   1380: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: pop
    //   1384: aload #45
    //   1386: dload #10
    //   1388: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1391: pop
    //   1392: ldc_w 'getTakeOrderEntity'
    //   1395: aload #45
    //   1397: invokevirtual toString : ()Ljava/lang/String;
    //   1400: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   1403: pop
    //   1404: iload #29
    //   1406: ifeq -> 2107
    //   1409: goto -> 2110
    //   1412: lconst_0
    //   1413: lload #34
    //   1415: lcmp
    //   1416: ifne -> 1463
    //   1419: aload_0
    //   1420: lload #34
    //   1422: l2i
    //   1423: aload #61
    //   1425: aload #56
    //   1427: invokespecial b : (ILjava/util/HashMap;Ljava/lang/String;)Lcom/laiqian/product/models/h;
    //   1430: astore #45
    //   1432: aload_0
    //   1433: aload #47
    //   1435: aload #55
    //   1437: aload #45
    //   1439: aload #49
    //   1441: aload #51
    //   1443: aload #43
    //   1445: invokevirtual doubleValue : ()D
    //   1448: dload #26
    //   1450: dload_2
    //   1451: invokespecial a : (Ljava/util/ArrayList;Ljava/lang/String;Lcom/laiqian/product/models/h;Ljava/lang/StringBuffer;Ljava/lang/String;DDD)D
    //   1454: dstore #4
    //   1456: dload #6
    //   1458: dstore #8
    //   1460: goto -> 2120
    //   1463: aload #43
    //   1465: astore #52
    //   1467: iload #28
    //   1469: istore #29
    //   1471: aload #50
    //   1473: astore #60
    //   1475: aload #49
    //   1477: astore #59
    //   1479: lload #34
    //   1481: ldc2_w 2
    //   1484: lcmp
    //   1485: ifne -> 1511
    //   1488: aload_0
    //   1489: lload #34
    //   1491: l2i
    //   1492: aload #61
    //   1494: aload #56
    //   1496: invokespecial a : (ILjava/util/HashMap;Ljava/lang/String;)Lcom/laiqian/product/models/h;
    //   1499: astore #45
    //   1501: dload #26
    //   1503: dstore #8
    //   1505: dload_2
    //   1506: dstore #4
    //   1508: goto -> 2120
    //   1511: aload #44
    //   1513: astore #45
    //   1515: dload_2
    //   1516: dstore #4
    //   1518: dload #6
    //   1520: dstore #8
    //   1522: lload #34
    //   1524: ldc2_w 3
    //   1527: lcmp
    //   1528: ifne -> 2120
    //   1531: new java/lang/StringBuilder
    //   1534: dup
    //   1535: invokespecial <init> : ()V
    //   1538: astore #56
    //   1540: aload #59
    //   1542: invokevirtual toString : ()Ljava/lang/String;
    //   1545: invokestatic isNull : (Ljava/lang/String;)Z
    //   1548: ifeq -> 2134
    //   1551: ldc_w ''
    //   1554: astore #45
    //   1556: goto -> 1559
    //   1559: aload #56
    //   1561: aload #45
    //   1563: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: pop
    //   1567: aload #56
    //   1569: aload #61
    //   1571: ldc_w 'sProductName'
    //   1574: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1577: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1580: pop
    //   1581: aload #59
    //   1583: aload #56
    //   1585: invokevirtual toString : ()Ljava/lang/String;
    //   1588: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1591: pop
    //   1592: aload #60
    //   1594: invokevirtual size : ()I
    //   1597: iconst_1
    //   1598: isub
    //   1599: iload #29
    //   1601: if_icmpeq -> 1642
    //   1604: aload #60
    //   1606: invokevirtual size : ()I
    //   1609: iconst_1
    //   1610: isub
    //   1611: iload #29
    //   1613: if_icmple -> 2142
    //   1616: aload_0
    //   1617: aload #60
    //   1619: iload #29
    //   1621: iconst_1
    //   1622: iadd
    //   1623: invokevirtual get : (I)Ljava/lang/Object;
    //   1626: checkcast java/util/HashMap
    //   1629: invokespecial E : (Ljava/util/HashMap;)J
    //   1632: ldc2_w 3
    //   1635: lcmp
    //   1636: ifeq -> 2142
    //   1639: goto -> 1642
    //   1642: aload #52
    //   1644: invokevirtual doubleValue : ()D
    //   1647: dstore #4
    //   1649: aload #52
    //   1651: astore #43
    //   1653: aload_0
    //   1654: aload #47
    //   1656: aload #55
    //   1658: aload #44
    //   1660: aload #59
    //   1662: aload #51
    //   1664: dload #4
    //   1666: dload #6
    //   1668: dload_2
    //   1669: invokespecial a : (Ljava/util/ArrayList;Ljava/lang/String;Lcom/laiqian/product/models/h;Ljava/lang/StringBuffer;Ljava/lang/String;DDD)D
    //   1672: dstore_2
    //   1673: aload #59
    //   1675: iconst_0
    //   1676: aload #59
    //   1678: invokevirtual toString : ()Ljava/lang/String;
    //   1681: invokevirtual length : ()I
    //   1684: invokevirtual delete : (II)Ljava/lang/StringBuffer;
    //   1687: pop
    //   1688: dconst_0
    //   1689: dstore #6
    //   1691: iload #29
    //   1693: istore #28
    //   1695: goto -> 2149
    //   1698: aload #53
    //   1700: ldc_w 'sHeaderText'
    //   1703: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1706: checkcast java/lang/String
    //   1709: astore #52
    //   1711: aload #53
    //   1713: ldc_w 'sBPartnerName'
    //   1716: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1719: checkcast java/lang/String
    //   1722: astore #44
    //   1724: aload #53
    //   1726: ldc_w 'sBPartnerMobile'
    //   1729: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1732: checkcast java/lang/String
    //   1735: astore #53
    //   1737: lload #40
    //   1739: lstore #34
    //   1741: aload #43
    //   1743: astore #50
    //   1745: aload #48
    //   1747: astore #49
    //   1749: aload #53
    //   1751: astore #48
    //   1753: aload #52
    //   1755: astore #43
    //   1757: dload #4
    //   1759: dstore #10
    //   1761: dload #12
    //   1763: dstore #8
    //   1765: dload #14
    //   1767: dstore #4
    //   1769: dload #18
    //   1771: dstore #20
    //   1773: dload_2
    //   1774: dstore #24
    //   1776: dload #16
    //   1778: dstore_2
    //   1779: aload #57
    //   1781: astore #52
    //   1783: dload #6
    //   1785: dstore #18
    //   1787: goto -> 176
    //   1790: astore #43
    //   1792: aconst_null
    //   1793: astore_1
    //   1794: goto -> 2050
    //   1797: ldc_w 'confirmed'
    //   1800: astore #53
    //   1802: aload #53
    //   1804: astore #45
    //   1806: lload #34
    //   1808: lconst_0
    //   1809: lcmp
    //   1810: ifne -> 1829
    //   1813: aload #53
    //   1815: astore #45
    //   1817: lload #38
    //   1819: lconst_0
    //   1820: lcmp
    //   1821: ifle -> 1829
    //   1824: ldc_w 'delivered'
    //   1827: astore #45
    //   1829: new java/lang/StringBuilder
    //   1832: dup
    //   1833: invokespecial <init> : ()V
    //   1836: astore #53
    //   1838: aload #53
    //   1840: ldc_w 'getTakeOrderEntity 111 recevied='
    //   1843: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1846: pop
    //   1847: aload #53
    //   1849: dload #10
    //   1851: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1854: pop
    //   1855: ldc_w 'getTakeOrderEntity'
    //   1858: aload #53
    //   1860: invokevirtual toString : ()Ljava/lang/String;
    //   1863: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   1866: pop
    //   1867: new java/lang/StringBuilder
    //   1870: dup
    //   1871: invokespecial <init> : ()V
    //   1874: astore #53
    //   1876: aload #53
    //   1878: aload #46
    //   1880: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1883: pop
    //   1884: aload #53
    //   1886: ldc_w ''
    //   1889: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1892: pop
    //   1893: aload #53
    //   1895: invokevirtual toString : ()Ljava/lang/String;
    //   1898: astore #53
    //   1900: new java/lang/StringBuilder
    //   1903: dup
    //   1904: invokespecial <init> : ()V
    //   1907: astore #54
    //   1909: aload #54
    //   1911: lload #38
    //   1913: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1916: pop
    //   1917: aload #54
    //   1919: ldc_w ''
    //   1922: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1925: pop
    //   1926: aload_0
    //   1927: aload #53
    //   1929: aload #54
    //   1931: invokevirtual toString : ()Ljava/lang/String;
    //   1934: invokevirtual aD : (Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   1937: astore #53
    //   1939: aload_0
    //   1940: aload #51
    //   1942: aload #47
    //   1944: aload #46
    //   1946: aload #43
    //   1948: aload #44
    //   1950: aload #48
    //   1952: aload #49
    //   1954: lload #34
    //   1956: lload #36
    //   1958: lload #32
    //   1960: dload #8
    //   1962: lload #30
    //   1964: dload #4
    //   1966: dload #10
    //   1968: aload #50
    //   1970: dload #20
    //   1972: dload #22
    //   1974: dload #24
    //   1976: aload #45
    //   1978: aload #53
    //   1980: dload_2
    //   1981: aload #52
    //   1983: invokespecial a : (Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;JJJDJDDLjava/lang/Double;DDDLjava/lang/String;[Ljava/lang/String;DLjava/lang/String;)Lcom/laiqian/entity/TakeOrderEntity;
    //   1986: astore #44
    //   1988: aload #44
    //   1990: astore #43
    //   1992: aload #44
    //   1994: dload_2
    //   1995: putfield bca : D
    //   1998: aload #44
    //   2000: astore #43
    //   2002: aload_1
    //   2003: ifnull -> 2058
    //   2006: aload #44
    //   2008: astore #43
    //   2010: aload_1
    //   2011: invokevirtual clear : ()V
    //   2014: aload #44
    //   2016: areturn
    //   2017: astore #44
    //   2019: aload #43
    //   2021: astore_1
    //   2022: goto -> 2046
    //   2025: astore_1
    //   2026: goto -> 2030
    //   2029: astore_1
    //   2030: aconst_null
    //   2031: astore #44
    //   2033: aload_1
    //   2034: astore #43
    //   2036: aload #44
    //   2038: astore_1
    //   2039: goto -> 2050
    //   2042: aconst_null
    //   2043: astore_1
    //   2044: astore #44
    //   2046: aload #44
    //   2048: astore #43
    //   2050: aload #43
    //   2052: invokestatic e : (Ljava/lang/Throwable;)V
    //   2055: aload_1
    //   2056: astore #43
    //   2058: aload #43
    //   2060: areturn
    //   2061: goto -> 942
    //   2064: iconst_0
    //   2065: istore #29
    //   2067: goto -> 1025
    //   2070: aconst_null
    //   2071: astore #45
    //   2073: goto -> 1191
    //   2076: dconst_0
    //   2077: dstore #10
    //   2079: dload #10
    //   2081: dstore #8
    //   2083: aconst_null
    //   2084: astore #45
    //   2086: aconst_null
    //   2087: astore #51
    //   2089: goto -> 1191
    //   2092: dconst_0
    //   2093: dstore #20
    //   2095: goto -> 1236
    //   2098: goto -> 1249
    //   2101: dconst_0
    //   2102: dstore #10
    //   2104: goto -> 1356
    //   2107: dconst_0
    //   2108: dstore #8
    //   2110: dload #22
    //   2112: dload #8
    //   2114: dadd
    //   2115: dstore #24
    //   2117: goto -> 1412
    //   2120: dload #8
    //   2122: dstore #6
    //   2124: dload #4
    //   2126: dstore_2
    //   2127: aload #45
    //   2129: astore #44
    //   2131: goto -> 2149
    //   2134: ldc_w ','
    //   2137: astore #45
    //   2139: goto -> 1559
    //   2142: iload #29
    //   2144: istore #28
    //   2146: goto -> 2131
    //   2149: iload #28
    //   2151: iconst_1
    //   2152: iadd
    //   2153: istore #28
    //   2155: aload #54
    //   2157: astore #45
    //   2159: aload #58
    //   2161: astore #51
    //   2163: dload #10
    //   2165: dstore #4
    //   2167: dload #20
    //   2169: dstore #18
    //   2171: dload #24
    //   2173: dstore #22
    //   2175: goto -> 824
    // Exception table:
    //   from	to	target	type
    //   30	46	2042	java/lang/Exception
    //   48	59	2042	java/lang/Exception
    //   179	188	2042	java/lang/Exception
    //   193	422	1790	java/lang/Exception
    //   431	440	2017	java/lang/Exception
    //   444	458	2017	java/lang/Exception
    //   462	471	2017	java/lang/Exception
    //   475	485	2017	java/lang/Exception
    //   496	538	1790	java/lang/Exception
    //   538	552	1790	java/lang/Exception
    //   561	572	738	org/json/JSONException
    //   561	572	2017	java/lang/Exception
    //   576	586	738	org/json/JSONException
    //   576	586	2017	java/lang/Exception
    //   590	600	725	org/json/JSONException
    //   590	600	2017	java/lang/Exception
    //   604	614	716	org/json/JSONException
    //   604	614	2017	java/lang/Exception
    //   618	628	707	org/json/JSONException
    //   618	628	2017	java/lang/Exception
    //   632	642	695	org/json/JSONException
    //   632	642	2017	java/lang/Exception
    //   646	653	687	org/json/JSONException
    //   646	653	2017	java/lang/Exception
    //   744	749	2017	java/lang/Exception
    //   778	799	1790	java/lang/Exception
    //   824	886	1790	java/lang/Exception
    //   891	939	1790	java/lang/Exception
    //   946	1019	1790	java/lang/Exception
    //   1025	1032	1790	java/lang/Exception
    //   1037	1058	1167	org/json/JSONException
    //   1037	1058	1790	java/lang/Exception
    //   1058	1065	1151	org/json/JSONException
    //   1058	1065	1790	java/lang/Exception
    //   1074	1084	1132	org/json/JSONException
    //   1074	1084	1790	java/lang/Exception
    //   1084	1094	1120	org/json/JSONException
    //   1084	1094	1790	java/lang/Exception
    //   1179	1184	1790	java/lang/Exception
    //   1196	1212	1790	java/lang/Exception
    //   1217	1233	1790	java/lang/Exception
    //   1236	1246	1790	java/lang/Exception
    //   1292	1316	1790	java/lang/Exception
    //   1316	1332	1790	java/lang/Exception
    //   1337	1353	1790	java/lang/Exception
    //   1366	1404	1790	java/lang/Exception
    //   1419	1456	1790	java/lang/Exception
    //   1488	1501	1790	java/lang/Exception
    //   1531	1551	1790	java/lang/Exception
    //   1559	1639	1790	java/lang/Exception
    //   1642	1649	1790	java/lang/Exception
    //   1653	1688	1790	java/lang/Exception
    //   1698	1737	1790	java/lang/Exception
    //   1829	1939	2029	java/lang/Exception
    //   1939	1988	2025	java/lang/Exception
    //   1992	1998	2017	java/lang/Exception
    //   2010	2014	2017	java/lang/Exception }
  
  public o d(String paramString1, boolean paramBoolean, String paramString2) throws Exception {
    o o;
    null = r(Long.parseLong(paramString2), Long.parseLong(paramString2));
    null = b.f(Long.parseLong(paramString2), Long.parseLong(paramString2)).entrySet();
    paramString2 = "";
    for (Map.Entry entry : null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString2);
      stringBuilder1.append("select ");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nProductTransacType,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.sProductName ,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nProductQty,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.fSpareField1,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.fAmount ,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nDateTime,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nSpareField2,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.sHeaderText,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.fSpareField4,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.sItemNo,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nProductID,t_product.sSpareField5,t_product.nProductType,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nSpareField3,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nPhysicalInventoryID,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nStcokDirection,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.fReceived ,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.sSpareField1 ,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.sSpareField2 ,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nSpareField5 ,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.sSpareField3 ,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.sSpareField5,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.sSpareField5,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.fDiscount ,");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.fSpareField5  from ");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc  left join t_product on t_product._id=");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nProductID  where ");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.sOrderNo='");
      stringBuilder1.append(paramString1);
      stringBuilder1.append("' and ");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nShopID=");
      stringBuilder1.append(VC());
      stringBuilder1.append(" and ");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nProductTransacType in(100001,100015,100045,100060,100066,100068)");
      if (paramBoolean) {
        paramString2 = " and nStcokDirection=300001";
      } else {
        paramString2 = "";
      } 
      stringBuilder1.append(paramString2);
      stringBuilder1.append("\n-- and ");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nProductID not in (7) \n order by ");
      stringBuilder1.append((String)entry.getValue());
      stringBuilder1.append(".t_productdoc.nProductTransacType");
      paramString2 = stringBuilder1.toString();
    } 
    Cursor cursor = null.rawQuery(paramString2, null);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("order business model sql==");
    stringBuilder.append(paramString2);
    d.b(stringBuilder.toString(), new Object[0]);
    paramString2 = null;
    int i;
    for (i = 1; cursor.moveToNext(); i = j) {
      boolean bool;
      int k = cursor.getInt(0);
      int j = i;
      if (i) {
        if (cursor.getInt(6) == 7) {
          paramString2 = cursor.getString(19);
        } else {
          paramString2 = cursor.getString(14);
        } 
        if (paramBoolean) {
          i = 100001;
        } else {
          i = k;
        } 
        o = new o(paramString1, i, cursor.getLong(5), cursor.getInt(6), cursor.getString(7), paramString2, cursor.getString(17), cursor.getString(20));
        j = 0;
      } 
      o.nl(cursor.getString(18));
      String str = cursor.getString(1);
      double d1 = cursor.getDouble(2);
      double d2 = cursor.getDouble(3);
      double d3 = cursor.getDouble(4);
      if (cursor.getInt(15) == 300002) {
        bool = true;
      } else {
        bool = false;
      } 
      o.a(k, bool, cursor.getLong(10), str, cursor.getString(11), d1, d2, d3, cursor.getDouble(8), cursor.getInt(9), cursor.getLong(12), cursor.getInt(13), cursor.getDouble(16), cursor.getDouble(23), cursor.getInt(cursor.getColumnIndex("fSpareField5")));
    } 
    cursor.close();
    return o;
  }
  
  public x e(String paramString1, String paramString2, boolean paramBoolean) {
    x x = new x();
    if (by.isNull(paramString1)) {
      String[] arrayOfString;
      arrayOfString = new String[1];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append("");
      arrayOfString[0] = stringBuilder.toString();
    } else {
      arrayOfString = new String[] { paramString2, arrayOfString };
    } 
    Cursor cursor = aNE.rawQuery("select distinct u._id,u.sUserName,u.sUserPhone,r.sRoleName,r.sIsActive from t_user u left join t_role r on u._id=r.nUserid where u.nShopID=? and u._id=? and r.sRoleName in(90022,90023,90024)", arrayOfString);
    while (cursor.moveToNext()) {
      paramString2 = cursor.getString(cursor.getColumnIndex("sRoleName"));
      String str = cursor.getString(cursor.getColumnIndex("sIsActive"));
      if (("Y".equals(str) && "90022".equals(paramString2)) || paramBoolean)
        x.cP(true); 
      if (("Y".equals(str) && "90023".equals(paramString2)) || paramBoolean)
        x.cN(true); 
      if (("Y".equals(str) && "90024".equals(paramString2)) || paramBoolean)
        x.cO(true); 
    } 
    return x;
  }
  
  @Nullable
  public PendingFullOrderDetail f(boolean paramBoolean, String paramString) { return a(paramString, null, false, paramBoolean); }
  
  public String kA(String paramString) {
    String str = null;
    try {
      Cursor cursor = Vq().rawQuery("SELECT distinct T_ORDER.sSpareField1 from T_ORDER where T_ORDER.sOrderNo like ? and T_ORDER.nShopID = ?  and T_ORDER.sIsActive='Y'", new String[] { paramString, VC() });
    } catch (Exception paramString) {
      a.e(paramString);
      paramString = null;
    } 
    if (paramString.moveToNext())
      str = paramString.getString(0); 
    return str;
  }
  
  public TakeOrderEntity kB(String paramString) {
    av av = new av(this.mContext);
    String str = av.Tx();
    av.close();
    return d(aG(paramString, str));
  }
  
  public boolean kj(String paramString) {
    av av = new av(this.mContext);
    String str = av.Tx();
    av.close();
    SQLiteDatabase sQLiteDatabase = aNE;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    sQLiteDatabase.execSQL("UPDATE T_ORDER SET nOperationTime = ?, nUpdateFlag = CASE WHEN nUpdateFlag is null then 10000 ELSE nUpdateFlag + 10000 END, sIsActive = ?, nIsUpdated = 0 WHERE sOrderNo = ? and nShopID = ?", new String[] { stringBuilder.toString(), "N", paramString, str });
    this.mContext.sendBroadcast(new Intent("pos_activity_change_data_takeorderscount"));
    return true;
  }
  
  public void kk(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("delete from t_order where nPhysicalInventoryID in ");
    stringBuilder.append(paramString);
    stringBuilder.append("");
    paramString = stringBuilder.toString();
    aNE.execSQL(paramString);
  }
  
  public String kn(String paramString) {
    String str = "";
    null = new StringBuilder();
    null.append(paramString);
    null.append("");
    paramString = null.toString();
    Cursor cursor = aNE.rawQuery("select sShopName from T_SHOP where _id=? ", new String[] { paramString });
    paramString = str;
    if (cursor.moveToFirst())
      paramString = cursor.getString(0); 
    cursor.close();
    return paramString;
  }
  
  public ArrayList<ap> ko(String paramString) { return aE(paramString, null); }
  
  public Cursor kp(String paramString) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
    long l1 = calendar.getTimeInMillis();
    long l2 = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select sOrderNo,nPhysicalInventoryID, group_concat(sProductName) as sProductNames,nOperationTime,sSpareField5 from t_order where nShopID=? and nProductQty>0 and sIsActive='Y'  and nOrderType=");
    stringBuilder.append(paramString);
    stringBuilder.append("  and nOperationTime between ");
    stringBuilder.append(l1 - 86400000L);
    stringBuilder.append(" and ");
    stringBuilder.append(l2);
    stringBuilder.append("  group by sOrderNo order by nOperationTime desc; ");
    paramString = stringBuilder.toString();
    av av = new av(this.mContext);
    String str = av.Tx();
    av.close();
    return aNE.rawQuery(paramString, new String[] { str });
  }
  
  public Cursor kq(String paramString) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
    long l1 = calendar.getTimeInMillis() - 86400000L;
    long l2 = System.currentTimeMillis();
    byte b = 0;
    boolean bool = false;
    while (b < paramString.length()) {
      if (!Character.isDigit(paramString.charAt(b)))
        bool = true; 
      b++;
    } 
    if (bool) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select * from t_order where nShopID=? and sIsActive='Y' and nOperationTime between ");
      stringBuilder.append(l1);
      stringBuilder.append(" and ");
      stringBuilder.append(l2);
      stringBuilder.append(" and sSpareField5 in (");
      stringBuilder.append(paramString);
      stringBuilder.append(") order by nOperationTime desc; ");
      paramString = stringBuilder.toString();
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select * from t_order where nShopID=? and sIsActive='Y' and nOperationTime between ");
      stringBuilder.append(l1);
      stringBuilder.append(" and ");
      stringBuilder.append(l2);
      stringBuilder.append(" and nPhysicalInventoryID in (");
      stringBuilder.append(paramString);
      stringBuilder.append(") order by nOperationTime desc; ");
      paramString = stringBuilder.toString();
    } 
    av av = new av(this.mContext);
    String str = av.Tx();
    av.close();
    return aNE.rawQuery(paramString, new String[] { str });
  }
  
  @Nullable
  public PendingFullOrderDetail ks(@NonNull String paramString) {
    bool = true;
    l1 = b(0, 0, -1, true);
    l2 = b(0, 0, 0, false);
    pendingFullOrderDetail = new PendingFullOrderDetail();
    av2 = new av(this.mContext);
    str = av2.Tx();
    pendingFullOrderDetail.bXb.ceV = av2.Ea();
    av2.close();
    entry = null;
    av3 = null;
    av2 = av3;
    try {
    
    } catch (Exception av3) {
    
    } finally {
      paramString = null;
      av3 = av2;
      String str1 = paramString;
    } 
    av2 = av1;
    a.e(av3);
    if (av1 != null)
      av1.close(); 
    return pendingFullOrderDetail;
  }
  
  public int kt(String paramString) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
    long l1 = calendar.getTimeInMillis();
    long l2 = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select count(distinct sOrderNo) from t_order where nShopID=? and sIsActive='Y' and  nOrderType=?  and nOperationTime between ");
    stringBuilder.append(l1 - 86400000L);
    stringBuilder.append(" and ");
    stringBuilder.append(l2);
    stringBuilder.append(" order by nOperationTime desc; ");
    String str1 = stringBuilder.toString();
    av av = new av(this.mContext);
    String str2 = av.Tx();
    int i = 0;
    av.close();
    Cursor cursor = aNE.rawQuery(str1, new String[] { str2, paramString });
    if (cursor.moveToFirst())
      i = cursor.getInt(0); 
    cursor.close();
    return i;
  }
  
  public boolean ku(String paramString) {
    String str1 = Calendar.getInstance();
    str1.set(str1.get(1), str1.get(2), str1.get(5), 0, 0, 0);
    long l1 = str1.getTimeInMillis() - 86400000L;
    long l2 = System.currentTimeMillis();
    if (kr(paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select * from t_order  where nShopID=? and sIsActive='Y' and sSpareField5 = ? and nOperationTime between ");
      stringBuilder.append(l1);
      stringBuilder.append(" and ");
      stringBuilder.append(l2);
      String str = stringBuilder.toString();
    } else {
      null = new StringBuilder();
      null.append("select * from t_order  where nShopID=? and sIsActive='Y' and nPhysicalInventoryID = ? and nOperationTime between ");
      null.append(l1);
      null.append(" and ");
      null.append(l2);
      str1 = null.toString();
    } 
    av av = new av(this.mContext);
    String str2 = av.Tx();
    av.close();
    Cursor cursor = aNE.rawQuery(str1, new String[] { str2, paramString });
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool;
  }
  
  public b kv(String paramString) {
    b b = new b(this);
    av av = new av(this.mContext);
    String str = av.Tx();
    av.close();
    Cursor cursor = aNE.rawQuery("select nPhysicalInventoryID,nSpareField4,sSpareField5 from t_order  where nShopID=?  and sIsActive='Y'   and sOrderNo like ? ", new String[] { str, paramString });
    if (cursor.moveToFirst()) {
      b.cyC = cursor.getString(0);
      b.cyD = cursor.getLong(1);
      if (!TextUtils.isEmpty(cursor.getString(2)))
        b.cyC = cursor.getString(2); 
    } 
    cursor.close();
    return b;
  }
  
  @Deprecated
  public ArrayList<HashMap<String, Object>> kw(String paramString) {
    ArrayList arrayList = new ArrayList();
    av av = new av(this.mContext);
    String str = av.Tx();
    av.close();
    Cursor cursor = aNE.rawQuery("select * from t_order  where nShopID=?  and sIsActive='Y' and sOrderNo like ? ", new String[] { str, paramString });
    while (cursor.moveToNext()) {
      HashMap hashMap = new HashMap();
      hashMap.put("_id", "0");
      hashMap.put("nProductTransacType", "100001");
      hashMap.put("nStcokDirection", "300002");
      hashMap.put("nDateTime", cursor.getString(cursor.getColumnIndex("nDateTime")));
      hashMap.put("sText", null);
      hashMap.put("nProductID", cursor.getString(cursor.getColumnIndex("nProductID")));
      hashMap.put("nWarehouseID", cursor.getString(cursor.getColumnIndex("nWarehouseID")));
      hashMap.put("sWarehouseName", "总库");
      str = cursor.getString(cursor.getColumnIndex("sProductName"));
      hashMap.put("sProductName", str);
      hashMap.put("tvPosProductNameValue", new SpannableString(str));
      double d2 = cursor.getDouble(cursor.getColumnIndex("nProductQty"));
      str = bm.c(d2, RootApplication.aIQ);
      hashMap.put("nProductQty", str);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("x");
      stringBuilder2.append(str);
      hashMap.put("tvPosProductQtyValue", stringBuilder2.toString());
      hashMap.put("nProductType", cursor.getString(cursor.getColumnIndex("nSpareField1")));
      double d1 = cursor.getDouble(cursor.getColumnIndex("fPrice"));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(cursor.getDouble(cursor.getColumnIndex("fSpareField1")));
      stringBuilder1.append("");
      hashMap.put("fDBOriginalPrice", stringBuilder1.toString());
      d2 *= d1;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(d1);
      stringBuilder1.append("");
      hashMap.put("fPrice", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(cursor.getColumnIndex("nSpareField1"));
      stringBuilder1.append("");
      hashMap.put("sPack", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(d2);
      stringBuilder1.append("");
      hashMap.put("fAmount", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(RootApplication.zA());
      stringBuilder1.append(by.sb(bm.c(d2, RootApplication.aIQ)));
      hashMap.put("tvPosAmountValue", stringBuilder1.toString());
      if ("Y".equals(cursor.getString(cursor.getColumnIndex("sItemText")))) {
        hashMap.put("bModifyPrice", Boolean.valueOf(true));
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(cursor.getDouble(cursor.getColumnIndex("fSpareField2")));
        stringBuilder1.append("");
        hashMap.put("fOriginalPrice", stringBuilder1.toString());
      } else {
        hashMap.put("bModifyPrice", Boolean.valueOf(false));
      } 
      hashMap.put("nPhysicalInventoryID", cursor.getString(cursor.getColumnIndex("nPhysicalInventoryID")));
      arrayList.add(hashMap);
    } 
    cursor.close();
    return arrayList;
  }
  
  public ArrayList<HashMap<String, Object>> kx(String paramString) {
    ArrayList arrayList = new ArrayList();
    PendingFullOrderDetail pendingFullOrderDetail = ky(paramString);
    if (pendingFullOrderDetail != null) {
      Iterator iterator2 = pendingFullOrderDetail.coy.iterator();
      while (iterator2.hasNext())
        a(arrayList, (PendingFullOrderDetail.d)iterator2.next()); 
      Iterator iterator1 = pendingFullOrderDetail.coz.iterator();
      while (iterator1.hasNext()) {
        iterator2 = ((PendingFullOrderDetail.c)iterator1.next()).cpg.iterator();
        while (iterator2.hasNext())
          a(arrayList, (PendingFullOrderDetail.d)iterator2.next()); 
      } 
    } 
    return arrayList;
  }
  
  @Nullable
  public PendingFullOrderDetail ky(String paramString) { return a(paramString, null, false, false); }
  
  @Nullable
  public PendingFullOrderDetail kz(String paramString) { return a(paramString, null, false, true); }
  
  public o t(String paramString, boolean paramBoolean) {
    null = new StringBuilder();
    null.append("select ");
    null.append(b.Dm());
    null.append(".t_productdoc.nProductTransacType nProductTransacType,");
    null.append(b.Dm());
    null.append(".t_productdoc.sProductName ,");
    null.append(b.Dm());
    null.append(".t_productdoc.nProductQty,");
    null.append(b.Dm());
    null.append(".t_productdoc.fSpareField1,");
    null.append(b.Dm());
    null.append(".t_productdoc.fAmount ,");
    null.append(b.Dm());
    null.append(".t_productdoc.nDateTime,");
    null.append(b.Dm());
    null.append(".t_productdoc.nSpareField2,");
    null.append(b.Dm());
    null.append(".t_productdoc.sHeaderText,");
    null.append(b.Dm());
    null.append(".t_productdoc.fSpareField4,");
    null.append(b.Dm());
    null.append(".t_productdoc.sItemNo,");
    null.append(b.Dm());
    null.append(".t_productdoc.nProductID,t_product.sSpareField5,t_product.nProductType,");
    null.append(b.Dm());
    null.append(".t_productdoc.nSpareField3,");
    null.append(b.Dm());
    null.append(".t_productdoc.nPhysicalInventoryID,");
    null.append(b.Dm());
    null.append(".t_productdoc.nStcokDirection,");
    null.append(b.Dm());
    null.append(".t_productdoc.fReceived ,");
    null.append(b.Dm());
    null.append(".t_productdoc.sSpareField1 ,");
    null.append(b.Dm());
    null.append(".t_productdoc.sSpareField2 ,");
    null.append(b.Dm());
    null.append(".t_productdoc.nSpareField5 ,");
    null.append(b.Dm());
    null.append(".t_productdoc.sSpareField3 ,");
    null.append(b.Dm());
    null.append(".t_productdoc.sSpareField5,");
    null.append(b.Dm());
    null.append(".t_productdoc.sSpareField5,");
    null.append(b.Dm());
    null.append(".t_productdoc.fDiscount ,");
    null.append(b.Dm());
    null.append(".t_productdoc.fSpareField5  from ");
    null.append(b.Dm());
    null.append(".t_productdoc  left join t_product on t_product._id=");
    null.append(b.Dm());
    null.append(".t_productdoc.nProductID  where ");
    null.append(b.Dm());
    null.append(".t_productdoc.sOrderNo='");
    null.append(paramString);
    null.append("' and ");
    null.append(b.Dm());
    null.append(".t_productdoc.nShopID=");
    null.append(VC());
    null.append(" and ");
    null.append(b.Dm());
    null.append(".t_productdoc.nProductTransacType in(100001,100015,100045,100060,100066,100068)");
    if (paramBoolean) {
      o = " and nStcokDirection=300001";
    } else {
      String str;
      o = "";
    } 
    null.append(o);
    null.append(" order by nProductTransacType");
    null = null.toString();
    SQLiteDatabase sQLiteDatabase = Vq();
    o o = null;
    Cursor cursor = sQLiteDatabase.rawQuery(null, null);
    int i;
    for (i = 1; cursor.moveToNext(); i = j) {
      boolean bool;
      int k = cursor.getInt(0);
      int j = i;
      if (i) {
        if (cursor.getInt(6) == 7) {
          o = cursor.getString(19);
        } else {
          o = cursor.getString(14);
        } 
        if (paramBoolean) {
          i = 100001;
        } else {
          i = k;
        } 
        o = new o(paramString, i, cursor.getLong(5), cursor.getInt(6), cursor.getString(7), o, cursor.getString(17), cursor.getString(20));
        j = 0;
      } 
      o.nl(cursor.getString(18));
      String str = cursor.getString(1);
      double d1 = cursor.getDouble(2);
      double d2 = cursor.getDouble(3);
      double d3 = cursor.getDouble(4);
      if (cursor.getInt(15) == 300002) {
        bool = true;
      } else {
        bool = false;
      } 
      o.a(k, bool, cursor.getLong(10), str, cursor.getString(11), d1, d2, d3, cursor.getDouble(8), cursor.getInt(9), cursor.getLong(12), cursor.getInt(13), cursor.getDouble(16), cursor.getDouble(23), cursor.getInt(cursor.getColumnIndex("fSpareField5")));
    } 
    cursor.close();
    return o;
  }
  
  class a {}
  
  class a {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */