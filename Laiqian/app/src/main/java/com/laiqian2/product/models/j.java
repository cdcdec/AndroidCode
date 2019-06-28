package com.laiqian.product.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.z;

public class j extends z {
  public j(Context paramContext) { super(paramContext); }
  
  private boolean mJ(String paramString) {
    String str = null;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select * from T_PRODUCT_EXT1 where nShopID=");
      stringBuilder.append(VC());
      stringBuilder.append(" and _id=");
      stringBuilder.append(paramString);
      paramString = stringBuilder.toString();
      SQLiteDatabase sQLiteDatabase = Vq();
      bool = false;
      cursor = sQLiteDatabase.rawQuery(paramString, new String[0]);
      return bool;
    } finally {
      paramString = str;
      if (paramString != null)
        paramString.close(); 
    } 
  }
  
  private boolean mL(String paramString) {
    try {
      if (!UB())
        return false; 
      hG(paramString);
      return update();
    } catch (Exception paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  public boolean aO(String paramString1, String paramString2) {
    hX("T_PRODUCT_EXT1");
    am("_id", paramString1);
    am("nExtendType", "1");
    am("nSpareField3", paramString2);
    am("nUserID", getUserID());
    am("nShopID", VC());
    am("nIsUpdated", "1");
    stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    am("nOperationTime", stringBuilder.toString());
    am("sPlatform", "android");
    try {
      beginTransaction();
      boolean bool = QL();
      if (!bool) {
        endTransaction();
        return false;
      } 
      setTransactionSuccessful();
      endTransaction();
      return true;
    } catch (Exception stringBuilder) {
      a.e(stringBuilder);
      endTransaction();
      return false;
    } finally {}
    endTransaction();
    throw stringBuilder;
  }
  
  public boolean aP(String paramString1, String paramString2) {
    if (mJ(paramString1)) {
      am("nSpareField3", paramString2);
      return mK(paramString1);
    } 
    return aO(paramString1, paramString2);
  }
  
  public boolean mK(String paramString) {
    beginTransaction();
    boolean bool = mL(paramString);
    if (bool)
      setTransactionSuccessful(); 
    endTransaction();
    return bool;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\models\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */