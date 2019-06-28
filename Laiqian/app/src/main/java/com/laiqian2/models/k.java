package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;

public class k extends ao {
  private final int MEMBER = 2;
  
  private int bOE;
  
  private final int bOF = 1;
  
  private final int bOG = 0;
  
  private final int bOH = 3;
  
  private final int bOI = 4;
  
  private final int bOJ = 0;
  
  private final int bOK = 1;
  
  private final int bOL = 2;
  
  protected String[] bOM = { "sName", "sNumber", "sContactPerson", "sContactMobilePhone", "_id", "fAmount", "sBPartnerTypeName" };
  
  protected String bON = "sNumber";
  
  public k(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return true; }
  
  protected boolean UB() { return true; }
  
  protected boolean UC() { return true; }
  
  protected boolean UD() { return true; }
  
  protected boolean UE() { return true; }
  
  public String UQ() { return (this.bOE == 1) ? " nShopID=?  and bIsVendor='Y' and bIsActive='Y'  and (   sNumber like ?  or sContactMobilePhone like ? )" : ((this.bOE == 2) ? " nShopID=?  and sIsMember='Y' and bIsActive='Y'  and (   sNumber like ?    or sContactMobilePhone like ? )" : ((this.bOE == 3) ? " nShopID=?  and sIsMember='Y' and bIsActive='Y'  and sField1 = ? " : ((this.bOE == 4) ? " nShopID=?  and sIsMember='Y' and bIsActive='Y'  and sNumber like ? " : " nShopID=?  and (sIsMember='Y' or bIsCustomer='Y') and bIsActive='Y'  and (sName like ?  or sNumber like ?  or sAddress like ? or sContactPerson like ? or sContactMobilePhone like ? or sField1 like ? or sField2 like ? or sField3 like ?)"))); }
  
  protected boolean ac(String paramString1, String paramString2) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" nShopID=? and ");
    stringBuilder1.append(this.bON);
    stringBuilder1.append("=? and _id<>? and bIsActive = 'Y' and sIsMember='Y'");
    String str1 = stringBuilder1.toString();
    String str2 = VC();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString1);
    stringBuilder2.append("");
    return c(str1, new String[] { str2, stringBuilder2.toString(), paramString2 });
  }
  
  protected boolean bi(long paramLong) {
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    return c(" nShopID=? and _id=? and bIsActive='Y' ", new String[] { str, stringBuilder.toString() });
  }
  
  protected boolean bj(long paramLong) {
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    return d(" nShopID=? and _id=? ", new String[] { str, stringBuilder.toString() });
  }
  
  protected void gc(int paramInt) { this.bOE = paramInt; }
  
  protected String gd(int paramInt) {
    String str = "";
    if (paramInt == 0)
      str = " sName COLLATE LOCALIZED asc "; 
    if (paramInt == 1)
      str = " sNumber+0 asc "; 
    if (paramInt == 2)
      str = " sContactMobilePhone+0 asc "; 
    return str;
  }
  
  protected boolean hf(String paramString) { return c(" nShopID=? and sNumber=? and sIsMember='Y' and bIsActive='Y' ", new String[] { VC(), paramString }); }
  
  protected boolean hg(String paramString) { return am("bIsActive", paramString); }
  
  protected boolean hh(String paramString) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" nShopID=? and ");
    stringBuilder1.append(this.bON);
    stringBuilder1.append("=? and bIsActive = 'Y' and sIsMember='Y' ");
    String str1 = stringBuilder1.toString();
    String str2 = VC();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append("");
    return c(str1, new String[] { str2, stringBuilder2.toString() });
  }
  
  protected void init() {
    hX("t_bpartner");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,sNumber,sName,sName2,sAddress,bIsActive,bIsVendor,bIsCustomer,sContactPerson,sContactMobilePhone,sContactFAX,sContactFixedPhone,sContactEmail,sContactIM,sText,sField1,sField2,sField3,nDateTime,nUserID,nShopID,nUpdateFlag,nDeletionFlag,nIsUpdated,nOperationTime,sPlatform,nBPartnerType,sBPartnerTypeName,fDiscount,fAmount,sIsMember,fPoints,sSpareField1,sSpareField2,sSpareField3,fSpareField1,fSpareField3,nSpareField1,nSpareField2,nSpareField3");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
  
  public boolean update() { return UB() ? super.update() : 0; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */