package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;

public class az extends ao {
  public az(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  protected void init() {
    hX("t_tax");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,sName,fValue,nType,nUpdateFlag,nIsClosed,sIsActive,nShopID,nUserID,nDateTime,nIsUpdated,nOperationTime,sPlatform");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
  
  public Cursor r(long paramLong, String paramString) {
    null = new StringBuilder();
    null.append("select t1._id as id, t1.sName as sName,t1.fValue as fValue,t1.nIsClosed as nIsClosed,t1.nType as nType, t2.num as applicatable from  t_tax t1 left join (select  t_tax_product.nTaxID,count(t_product._id)  as num ,t_tax_product.sIsActive  from t_tax_product left join t_product on t_product._id=t_tax_product.nProductID and t_product.nProductStatus<>600003 where t_tax_product.nTaxID=");
    null.append(paramLong);
    null.append(") t2  on t1._id=t2.nTaxID  and t2.sIsActive='Y' where t1._id = ? and t1.nShopID=? ");
    String str = null.toString();
    try {
      SQLiteDatabase sQLiteDatabase = Vq();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong);
      stringBuilder.append("");
      return sQLiteDatabase.rawQuery(str, new String[] { stringBuilder.toString(), paramString });
    } catch (Exception paramString) {
      a.e(paramString);
      return null;
    } 
  }
  
  protected boolean update() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    am("nOperationTime", stringBuilder.toString());
    return super.update();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */