package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;

public class af extends ao {
  private String bRm;
  
  private String[] bRn;
  
  public af(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  public boolean Vl() {
    c(this.bRm, this.bRn);
    Cursor cursor = VM();
    if (cursor != null) {
      boolean bool = cursor.moveToNext();
      cursor.close();
      return bool;
    } 
    return false;
  }
  
  public void hO(String paramString) { this.bRm = paramString; }
  
  protected void init() {
    hX("t_promotion_with_condition");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,sPromotionNo,nStartTime,nEndTime,sPromotionItemNo,nProductID,nProductUnit,sProductUnitName,sProductName,sProductNumber,sProductSpec,nProductType,fSalePrice,fPromotionPrice,sPromotionDiscount,sText,nUpdateFlag,sIsActive,nUserID,nShopID,nPromotionType,sActiveConditionType,sActiveConditionLogic,sActiveCondition,sSecondCondition,sSecondConditionLogic,sFilterField,sFilterValue,nPromotionResultType,nPromotionResultSubType,sPromotionResultDetail,fPromotionResultQty,nWarehouseID,sWarehouseName,nIsUpdated,nDateTime,nOperationTime,sPlatform,sPromotionName,sDateDay,nDateType,nFitPeople,fBuyAmount,fGiftAmountfGiftTotalNumfDeductionAmountfAddPaidAmountfRechargeAmountfBuyQty,nDeletionFlag,nExpireTime,nSort,fSpareField1,fSpareField2,fSpareField3,fSpareField4,fSpareField5,nSpareField1,nSpareField2,nSpareField3,nSpareField4,nSpareField5,sSpareField1,sSpareField2,sSpareField3,sSpareField4,sSpareField5");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
  
  protected boolean update() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    am("nOperationTime", stringBuilder.toString());
    return super.update();
  }
  
  public void v(String[] paramArrayOfString) { this.bRn = paramArrayOfString; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */