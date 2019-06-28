package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.av;
import org.json.JSONException;

public class y extends ao {
  public y(Context paramContext) { super(paramContext); }
  
  protected boolean QL() {
    boolean bool = super.QL();
    if (bool)
      Vd(); 
    return bool;
  }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  public void Vd() {
    av av = new av(this.mContext);
    av.hr(true);
    av.close();
  }
  
  @Deprecated
  protected boolean delete() {
    boolean bool = super.delete();
    if (bool)
      Vd(); 
    return bool;
  }
  
  public boolean hG(String paramString) { return d(" nShopID=? and _id=? ", new String[] { VC(), paramString }); }
  
  protected void init() {
    hX("t_product_ext1");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,nExtendType,sSpareField1,sSpareField2,sSpareField3,sSpareField4,sSpareField5,sSpareField6,sSpareField7,sSpareField8,sSpareField9,sSpareField10,nSpareField1,nSpareField2,nSpareField3,nSpareField4,nSpareField5,nSpareField6,nSpareField7,nSpareField8,nSpareField9,nSpareField10,fSpareField1,fSpareField2,fSpareField3,fSpareField4,fSpareField5,nIsUpdated,nUpdateFlag,nUserID,nShopID,nOperationTime,sPlatform");
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
    boolean bool = super.update();
    if (bool)
      Vd(); 
    return bool;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */