package com.laiqian.models;

import com.google.a.a.a.a.a.a;
import org.json.JSONException;

public class ah extends ao {
  public static long bRU = 150001L;
  
  public static long bRV = 150002L;
  
  public static long bRW = 150003L;
  
  static  {
  
  }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  protected void init() {
    hX("t_user");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,nShopID,nUserID,nUpdateFlag,sText,sRoleName,sIsActive,nIsUpdated,nOperationTime,sPlatform");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */