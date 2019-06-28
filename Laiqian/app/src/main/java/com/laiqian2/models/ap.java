package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;

public class ap extends ao {
  public ap(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  protected void init() {
    hX("t_stock");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,nWarehouseID,nProductID,sProductName,nQuantity,nProductUnit,fStockPrice,fStockAmount,sText,nDateTime,sIsActive,sField1,sField2,sField3,nUpdateFlag,nUserID,nShopID,nIsUpdated,nOperationTime,sPlatform");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */