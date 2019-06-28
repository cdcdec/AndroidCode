package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;

public class q extends ao {
  public q(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return true; }
  
  protected boolean UB() { return true; }
  
  protected boolean UC() { return true; }
  
  protected boolean UD() { return true; }
  
  protected boolean UE() { return true; }
  
  protected void init() {
    hX("T_ORDER_MESSAGE");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,nOrderID,sDeviceName,sMessage,sBrand,nMessageType,nUserPhone,nDeviceType,sIsActive,nShopID,nUserID,nDataTime,nUpdateFlag,nIsUpdated,nOperationTime,sPlatform,sSpareFiled1,sSpareFiled2,sSpareFiled3,sSpareFiled4,sSpareFiled5,nSpareFiled1,nSpareFiled2,nSpareFiled3,nSpareFiled4,nSpareFiled5,fSpareFiled1,fSpareFiled2,fSpareFiled3,fSpareFiled4,fSpareFiled5");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */