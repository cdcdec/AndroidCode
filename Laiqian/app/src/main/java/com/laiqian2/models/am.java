package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;

public class am extends ao {
  public am(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  public Cursor Vr() {
    try {
      return Vq().rawQuery("select t_shop._id as _id, t_shop.sShopName as sShopName, t_shop.sShopContact as sShopContact, t_shop.nShopIndustry as nShopIndustry, t_shop.nShopType as nShopType, t_shop.sShopDescription as sShopDescription, t_shop.nShopStatus as nShopStatus, t_shop.sText as sText, t_shop.sShopAddress as sShopAddress, t_shop.sSpareField1 as shopJson, t_string.sSpareField1 as sProvince, t_string.sSpareField2 as sCity, t_string.sSpareField3 as sDistrict  from t_shop left join t_string  on t_shop._id = t_string.nShopID and t_string.nFieldType = 66 where t_shop._id = ?", new String[] { VC() });
    } catch (Exception exception) {
      a.e(exception);
      return null;
    } 
  }
  
  public Cursor Vs() {
    try {
      return Vq().rawQuery("SELECT t_shop.sSpareField1 AS weshopJson  FROM t_shop where t_shop._id = ?", new String[] { VC() });
    } catch (Exception exception) {
      a.e(exception);
      return null;
    } 
  }
  
  public Cursor Vt() {
    try {
      return Vq().rawQuery("SELECT sShopName,sShopContact,sShopAddress,t_shop.sSpareField2 AS weshopInfoJson  FROM t_shop where t_shop._id = ?", new String[] { VC() });
    } catch (Exception exception) {
      a.e(exception);
      return null;
    } 
  }
  
  protected void init() {
    hX("t_shop");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,sShopName,sShopContact,sShopPassword,nShopIndustry,nShopCurrency,sShopAddress,nShopType,nShopStatus,sShopDescription,sText,nUpdateFlag,nShopID,nUserID,nDbTemplateID,nIsUpdated,nOperationTime,sPlatform,sSpareField1,sSpareField2,sSpareField3,sSpareField4,sSpareField5,nSpareField1,nSpareField2,nSpareField3,nSpareField4,nSpareField5,fSpareField1,fSpareField2,fSpareField3,fSpareField4,fSpareField5");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */