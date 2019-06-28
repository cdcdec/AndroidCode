package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.db.multidatabase.d.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

public class w extends ao {
  public w(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return true; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  public Cursor a(long paramLong, String paramString, int paramInt1, int paramInt2) throws Exception {
    long l = System.currentTimeMillis();
    SQLiteDatabase sQLiteDatabase = r(paramLong, l);
    ConcurrentHashMap concurrentHashMap = b.f(paramLong, l);
    null = new StringBuilder();
    null.append("--dbAlias.size()---");
    null.append(concurrentHashMap.size());
    b.ct(null.toString());
    ArrayList arrayList = new ArrayList();
    Iterator iterator = concurrentHashMap.entrySet().iterator();
    byte b = 0;
    String str2 = "select actualPerson,orderType,openTableName,openTableNumber,sHeaderText,sProductNames,_id,sTime,sum(orderAmount),nProductTransacType,nTime,sTableName,sUserPhone,nUserID,fSpareField5  from(";
    String str1 = paramString;
    for (paramString = str2; iterator.hasNext(); paramString = stringBuffer.toString()) {
      null = (Map.Entry)iterator.next();
      b++;
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append("select * from (");
      null = new StringBuilder();
      null.append("SELECT ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.sSpareField2 as actualPerson, ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.nSpareField2 as orderType,");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.sSpareField3 as openTableName,");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.nSpareField5 as openTableNumber, (CASE WHEN ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.nSpareField2 = 7 THEN ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.sSpareField3  ELSE ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.nPhysicalInventoryID END) as sHeaderText, group_concat(sProductName,' / ') as sProductNames,sOrderNo as _id, strftime('%H:%M:%S',datetime(nDatetime/1000,'unixepoch','localtime')) as sTime, sum(CASE WHEN ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.nStcokDirection = 300002 THEN ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.fAmount  WHEN ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.[nStcokDirection] = 300001 THEN -");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.[fAmount] END) as orderAmount, min(");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.[nProductTransacType]) as nProductTransacType, nDateTime as nTime, 'T_PRODUCTDOC' as sTableName, '' as sUserPhone, nUserID ,fSpareField5  from  ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC  where ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.nShopID=");
      null.append(VC());
      null.append(" and (nDeletionFlag!=1 )  and (nSpareField2 in (0,7,9,15)) and (");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.nProductTransacType in (100001, 100015, 100045, 100060, 100068,100047))and ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.nDateTime between ");
      null.append(paramLong);
      null.append(" and ");
      null.append(l);
      null.append(" group by ");
      null.append((String)null.getValue());
      null.append(".T_PRODUCTDOC.sOrderNo ");
      String str4 = null.toString();
      null = new StringBuilder();
      null.append("%");
      null.append(str1);
      null.append("%");
      String str6 = null.toString();
      if (!TextUtils.isEmpty(str1)) {
        null = new StringBuilder();
        null.append("%");
        null.append(str1);
        null.append("%");
        str1 = null.toString();
        null = new StringBuilder();
        null.append("select *  from (");
        null.append(str4);
        null.append(") as t1  where  (t1.sProductNames like ? or t1.sHeaderText like ? ) ");
        str4 = null.toString();
        arrayList.add(str6);
        arrayList.add(str6);
      } 
      stringBuffer.append(str4);
      stringBuffer.append(" union  all ");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("select sSpareField2 as actualPerson,nOrderType as orderType,nSpareField2 as openTableName,nSpareField5 as openTableNumber,nPhysicalInventoryID as sHeaderText,group_concat(sProductName,' / ') as sProductNames, sOrderNo as _id,strftime('%H:%M:%S',datetime(nOperationTime/1000,'unixepoch','localtime')) as sTime, sum(fAmount) as orderAmount,'100001' as nProductTransacType,nOperationTime as nTime, 't_order' as sTableName, sSpareField1 as sUserPhone,nUserID,2 as fSpareField5  from t_order where nShopID=");
      stringBuilder1.append(VC());
      stringBuilder1.append(" and sIsActive='Y' and nOperationTime between ");
      stringBuilder1.append(paramLong);
      stringBuilder1.append(" and ");
      stringBuilder1.append(l);
      stringBuilder1.append(" and nProductTransacType in (100001, 100015, 100045, 100060, 100068,100047)  group by sOrderNo  ");
      String str5 = stringBuilder1.toString();
      String str3 = str5;
      if (!TextUtils.isEmpty(str1)) {
        null = new StringBuilder();
        null.append(" select * from (");
        null.append(str5);
        null.append(") as t_temp where (t_temp.sHeaderText like ? or t_temp.sProductNames like ?) ");
        str3 = null.toString();
        arrayList.add(str6);
        arrayList.add(str6);
      } 
      stringBuffer.append(str3);
      if (b != concurrentHashMap.size()) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramString);
        stringBuilder2.append(stringBuffer.toString());
        stringBuilder2.append(" union all ");
        paramString = stringBuilder2.toString();
        continue;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(") order by nTime desc  limit ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(",");
    stringBuilder.append(paramInt2);
    paramString = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("--重打小票--");
    stringBuilder.append(paramString);
    b.ct(stringBuilder.toString());
    return sQLiteDatabase.rawQuery(paramString, (String[])arrayList.toArray(new String[arrayList.size()]));
  }
  
  protected void init() {
    hX("T_PRODUCTDOC");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,nShopID,nProductTransacType,nStcokDirection,nBPartnerID,nProductID,sProductName,nProductQty,nProductType,nStockQty,nProductUnit,fPrice,fAmount,fStockAmount,fReceived,nPhysicalInventoryID,nUserID,sText,nDateTime,nDeletionFlag,nUpdateFlag,sBPartnerContact,sBPartnerMobile,nWarehouseID,sOrderNo,sItemNo,fDiscount,sRefNo,sHeaderText,fStockPrice,sItemText,fFee,nIsUpdated,nOperationTime,sPlatform,sSpareField1,sSpareField2,sSpareField3,sSpareField4,sSpareField5,fSpareField1,fSpareField2,fSpareField3,fSpareField4,fSpareField5,nSpareField1,nSpareField2,nSpareField3,nSpareField4,nSpareField5");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */