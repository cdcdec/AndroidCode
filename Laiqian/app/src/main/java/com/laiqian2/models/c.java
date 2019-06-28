package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;

public class c extends ao {
  public c(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  protected void init() {
    hX("t_accountdoc");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,nShopID,nAccountID,sAccountName,nAccountTransacType,nMoneyDirection,fAccountAmount,fSpareField1,sText,nUserID,nDateTime,nDeletionFlag,nProductdocID,nUpdateFlag,nIsUpdated,nOperationTime,sPlatform,nWarehouseID,sSpareField1,sSpareField2,nSpareField1,nSpareField2,nSpareField3");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */