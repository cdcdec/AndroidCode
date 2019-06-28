package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.util.av;
import org.json.JSONException;

public class bi extends ao {
  protected String[] bOM = { "sName", "sNumber", "sAddress", "_id" };
  
  public bi(Context paramContext) { super(paramContext); }
  
  private boolean WK() {
    String str = hQ("sIsDefaultMoveIn");
    if (str == null)
      return true; 
    if (str.equals(""))
      return true; 
    if (str.equals("Y")) {
      am("sIsDefaultMoveIn", "N");
      d(" nShopID=? and sIsDefaultMoveIn =? and sIsActive=? ", new String[] { VC(), "Y", "Y" });
      return update();
    } 
    return false;
  }
  
  private boolean WL() {
    String str = hQ("sIsDefaultMoveOut");
    if (str == null)
      return true; 
    if (str.equals(""))
      return true; 
    if (str.equals("Y")) {
      am("sIsDefaultMoveOut", "N");
      d(" nShopID=? and sIsDefaultMoveOut =? and sIsActive=? ", new String[] { VC(), "Y", "Y" });
      return update();
    } 
    return false;
  }
  
  public boolean QL() {
    av av = new av(this.mContext);
    Vo();
    am("nUserID", av.atm());
    am("nShopID", av.Tx());
    am("nUpdateFlag", "");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Vp());
    stringBuilder.append("");
    am("nDateTime", stringBuilder.toString());
    am("sIsActive", "Y");
    am("nIsUpdated", this.bKl);
    stringBuilder = new StringBuilder();
    stringBuilder.append(Vp());
    stringBuilder.append("");
    am("nOperationTime", stringBuilder.toString());
    am("sPlatform", this.bKn);
    av.close();
    super.QL();
    return true;
  }
  
  protected boolean UA() { return (WK() && WL()); }
  
  protected boolean UB() { return (WK() && WL()); }
  
  protected boolean UC() { return true; }
  
  protected boolean UD() { return true; }
  
  protected boolean UE() { return true; }
  
  protected String WF() { return " nShopID=?   and sIsActive='Y'"; }
  
  protected boolean WG() { return c(" nShopID=? and _id=? and sIsActive='Y'", new String[] { VC(), VC() }); }
  
  protected String WH() { return hQ("sName"); }
  
  public String[] WI() { return this.bOM; }
  
  public boolean WJ() {
    av av = new av(this.mContext);
    am("_id", av.Tx());
    am("sName", this.mContext.getString(R.string.wh_defaultWarehouseName));
    am("sDescription", "");
    am("sNumber", this.mContext.getString(R.string.wh_defaultWarehouseNumber));
    am("sAddress", "");
    am("sText", this.mContext.getString(R.string.wh_defaultWarehouseNotice));
    am("sIsDefaultMoveIn", "Y");
    am("sIsDefaultMoveOut", "Y");
    am("nUserID", av.atm());
    am("nShopID", av.Tx());
    am("nUpdateFlag", "");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Vp());
    stringBuilder.append("");
    am("nDateTime", stringBuilder.toString());
    am("sIsActive", "Y");
    am("nIsUpdated", this.bKl);
    stringBuilder = new StringBuilder();
    stringBuilder.append(Vp());
    stringBuilder.append("");
    am("nOperationTime", stringBuilder.toString());
    am("sPlatform", this.bKn);
    av.close();
    super.QL();
    return true;
  }
  
  protected boolean aq(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nShopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" and _id in (");
    stringBuilder.append(paramString2);
    stringBuilder.append(")");
    c(stringBuilder.toString(), null);
    return true;
  }
  
  protected boolean bS(long paramLong) {
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    return c(" nShopID=? and _id=? ", new String[] { str, stringBuilder.toString() });
  }
  
  protected boolean bT(long paramLong) {
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    return d(" nShopID=? and _id=? ", new String[] { str, stringBuilder.toString() });
  }
  
  protected boolean iF(String paramString) {
    String str1 = paramString;
    if (paramString == null)
      str1 = ""; 
    paramString = VC();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("%");
    stringBuilder1.append(str1);
    stringBuilder1.append("%");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("%");
    stringBuilder2.append(str1);
    stringBuilder2.append("%");
    String str3 = stringBuilder2.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("%");
    stringBuilder3.append(str1);
    stringBuilder3.append("%");
    c(" nShopID=?  and sIsActive='Y'  and (sName like ?  or sNumber like ?  or sAddress like ?)", new String[] { paramString, str2, str3, stringBuilder3.toString() });
    return true;
  }
  
  protected void init() {
    hX("t_warehouse");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,sName,sDescription,sNumber,sAddress,sText,nUserID,nShopID,nUpdateFlag,nDateTime,sField1,sField2,sField3,sIsActive,sIsDefaultMoveIn,sIsDefaultMoveOut,nIsUpdated,nOperationTime,sPlatform");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */