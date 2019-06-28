package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;

public class bj extends ao {
  public bj(Context paramContext) { super(paramContext); }
  
  public boolean QL() { return true; }
  
  protected boolean UA() { return true; }
  
  protected boolean UB() { return true; }
  
  protected boolean UC() { return true; }
  
  protected boolean UD() { return true; }
  
  protected boolean UE() { return true; }
  
  public String WM() { return " nShopID=? and nSelectedUserID=?   and sIsActive='Y'"; }
  
  protected void init() {
    hX("t_warehouse_user_access");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "[_id,nShopID,nUserID,nDateTime,nUpdateFlag,nWarehouseID,nWarehouseTypeID,nGeneralManagerID,nManagerID,nSalesID,nPromotionStaffID,nDistributorID,sIsActive,sText,sField1,sField2,sField3,nSelectedUserID,nSelectedWarehouseID,sSelectedUserPhone,nPermission,sSelectedWarehouseName,sGeneralManagerName,sManagerName,sSalesName,sPromotionStaffName,sDistributorName");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */