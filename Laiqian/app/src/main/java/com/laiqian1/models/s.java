package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;

public class s extends ao {
  public s(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return true; }
  
  protected boolean UB() { return true; }
  
  protected boolean UC() { return true; }
  
  protected boolean UD() { return true; }
  
  protected boolean UE() { return true; }
  
  protected boolean ag(String paramString1, String paramString2) { return d(" nShopID=? and sOrderNo=? and nProductID=? ", new String[] { VC(), paramString1, paramString2 }); }
  
  protected boolean hw(String paramString) { return d(" nShopID=? and sOrderNo=? ", new String[] { VC(), paramString }); }
  
  protected void init() {
    hX("T_ORDER");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,sOrderNo,nDateTime,nBPartnerID,sBPartnerName,sOrderStatus,sText,sItemNo,nProductID,sProductNumber,sProductName,sProductSpc,nProductUnit,sProductUnitName,fQuantity,fPrice,fAmount,sIsActive,nUpdateFlag,nUserID,nShopID,nIsUpdated,nOperationTime,sPlatform,nWarehouseID,sWarehouseName,nDeliveryTime,nDepartmentID,sDepartmentName,nOrderType,sOrderTypeName,nProductTransacType,nStcokDirection,nProductQty,nStockQty,fStockAmount,fReceived,nPhysicalInventoryID,nDeletionFlag,sBPartnerContact,sBPartnerMobile,fDiscount,sProductTransacType,nDesWarehouseID,fStockPrice,sRefNo,sHeaderText,sItemText,fFee,fInstantReceived,fChange,nChargePersonID,fReserved,nSrcWarehouseID,sSrcWarehouseName,sChargePersonName,sSpareField1,sSpareField2,sSpareField3,sSpareField4,sSpareField5,nSpareField1,nSpareField2,nSpareField3,nSpareField4,nSpareField5,fSpareField1,fSpareField2,fSpareField3,fSpareField4,fSpareField5");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\models\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */