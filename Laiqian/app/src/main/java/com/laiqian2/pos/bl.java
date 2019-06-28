package com.laiqian.pos;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.aq;
import com.laiqian.entity.as;
import com.laiqian.pos.model.a;
import com.laiqian.sales.a.b;
import com.laiqian.util.av;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class bl extends b {
  private final String cgJ = "54";
  
  private final int cgK = 3;
  
  private final String cgL = ",";
  
  public bl(Context paramContext) throws Exception { super(paramContext); }
  
  public static HashMap<String, String> a(Cursor paramCursor) {
    try {
      return a(paramCursor, "_id");
    } catch (Exception paramCursor) {
      a.e(paramCursor);
      return null;
    } 
  }
  
  public static HashMap<String, String> a(Cursor paramCursor, String paramString) {
    if (paramCursor.isBeforeFirst())
      paramCursor.moveToFirst(); 
    HashMap hashMap = new HashMap();
    hashMap.put("nBPartnerID", paramCursor.getString(paramCursor.getColumnIndex(paramString)));
    hashMap.put("sBPartnerContact", paramCursor.getString(paramCursor.getColumnIndex("sName")));
    hashMap.put("sBPartnerMobile", paramCursor.getString(paramCursor.getColumnIndex("sContactMobilePhone")));
    hashMap.put("fDiscount", paramCursor.getString(paramCursor.getColumnIndex("fDiscount")));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramCursor.getDouble(paramCursor.getColumnIndex("fAmount")));
    stringBuilder.append("");
    hashMap.put("fAmount", stringBuilder.toString());
    hashMap.put("sNumber", paramCursor.getString(paramCursor.getColumnIndex("sNumber")));
    hashMap.put("fPoints", paramCursor.getString(paramCursor.getColumnIndex("fPoints")));
    hashMap.put("passwordSetting", paramCursor.getString(paramCursor.getColumnIndex("sSpareField3")));
    hashMap.put("nBelongShopID", paramCursor.getString(paramCursor.getColumnIndex("nShopID")));
    String str = paramCursor.getString(paramCursor.getColumnIndex("nBPartnerType"));
    paramCursor.getString(paramCursor.getColumnIndex("nShopID"));
    hashMap.put("nBPartnerType", str);
    return hashMap;
  }
  
  public static aq b(Cursor paramCursor) {
    aq aq = new aq();
    if (paramCursor.isBeforeFirst())
      paramCursor.moveToFirst(); 
    aq.aSW = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    aq.name = paramCursor.getString(paramCursor.getColumnIndex("sName"));
    aq.aTp = paramCursor.getString(paramCursor.getColumnIndex("sContactMobilePhone"));
    aq.discount = paramCursor.getDouble(paramCursor.getColumnIndex("fDiscount"));
    aq.aWo = paramCursor.getDouble(paramCursor.getColumnIndex("fAmount"));
    aq.aWn = paramCursor.getString(paramCursor.getColumnIndex("sNumber"));
    aq.aWp = paramCursor.getInt(paramCursor.getColumnIndex("fPoints"));
    aq.aWH = new as(paramCursor.getString(paramCursor.getColumnIndex("sSpareField3")));
    aq.aWC = paramCursor.getInt(paramCursor.getColumnIndex("nShopID"));
    aq.aJX = paramCursor.getString(paramCursor.getColumnIndex("sField1"));
    aq.aWq = paramCursor.getString(paramCursor.getColumnIndex("fSpareField3"));
    new HashMap();
    String str2 = paramCursor.getString(paramCursor.getColumnIndex("nBPartnerType"));
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = "0"; 
    paramCursor.getString(paramCursor.getColumnIndex("nShopID"));
    aq.aWw = Long.parseLong(str1);
    return aq;
  }
  
  public Cursor ZO() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
    long l = calendar.getTimeInMillis() - 86400000L;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select _id,sFieldName,nOperationTime,sDefaultValue,nShopID from t_string  where nFieldType=? and sIsActive='Y'   and nOperationTime between ");
    stringBuilder.append(l);
    stringBuilder.append(" and ");
    stringBuilder.append(l + 172800000L);
    stringBuilder.append(" order by nOperationTime desc;");
    String str = stringBuilder.toString();
    (new av(this.mContext)).close();
    return aNE.rawQuery(str, new String[] { "54" });
  }
  
  public void ZP() {
    try {
      beginTransaction();
      Cursor cursor = ZO();
      av av = new av(this.mContext);
      while (cursor.moveToNext()) {
        av.qD(cursor.getString(4));
        a a = new a(this.mContext);
        a.a((ArrayList)av.qQ(cursor.getString(0)), cursor.getString(1), cursor.getLong(2), cursor.getString(3));
        a.close();
      } 
      cursor.close();
      Vq().setTransactionSuccessful();
    } catch (Exception exception) {
      a.e(exception);
    } finally {
      MotionEvent motionEvent;
    } 
    endTransaction();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */