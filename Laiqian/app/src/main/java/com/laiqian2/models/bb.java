package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;

public class bb extends ao {
  public bb(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  protected void init() {
    hX("T_TEMP_PRODUCTDOC");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,sOrderNo,sOrder,nTransactionType,nPayType,fPayAmount,nStatus,nDateTime,nUserID,nShopID,nUpdateFlag,nIsUpdated,sPlatForm,sSpareField1,sSpareField2,sSpareField3,sSpareField4,sSpareField5,fSpareField1,fSpareField2,fSpareField3,fSpareField4,fSpareField5,nSpareField1,nSpareField2,nSpareField3,nSpareField4,nSpareField5");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
  
  protected boolean iy(String paramString) { return d(" nShopID=? and sOrderNo=? ", new String[] { VC(), paramString }); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */