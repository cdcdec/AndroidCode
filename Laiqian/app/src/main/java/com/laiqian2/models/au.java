package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.av;
import org.json.JSONException;

public class au extends ao {
  protected String bON = "sTableName";
  
  public au(Context paramContext) { super(paramContext); }
  
  private void Vd() {
    av av = new av(this.mContext);
    av.hr(true);
    av.close();
  }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  protected boolean ac(String paramString1, String paramString2) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" nShopID=? and ");
    stringBuilder1.append(this.bON);
    stringBuilder1.append("=? and nWarehouseID=? and sIsActive='Y'");
    String str1 = stringBuilder1.toString();
    String str2 = VC();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString1);
    stringBuilder2.append("");
    return c(str1, new String[] { str2, stringBuilder2.toString(), paramString2 });
  }
  
  protected boolean bL(long paramLong) {
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    return d(" nShopID=? and _id=? ", new String[] { str, stringBuilder.toString() });
  }
  
  @Deprecated
  protected boolean delete() {
    boolean bool = super.delete();
    if (bool)
      Vd(); 
    return bool;
  }
  
  protected void init() {
    hX("t_food_table");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,nWarehouseID,sTableName,nMaxPerson,sIsActive,nStatus,nUpdateFlag,nUserID,nShopID,nIsUpdated,nOperationTime,sPlatform");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
  
  protected boolean is(String paramString) { return false; }
  
  protected boolean it(String paramString) { return false; }
  
  protected boolean iu(String paramString) {
    boolean bool = QL();
    if (bool)
      Vd(); 
    return bool;
  }
  
  protected boolean update() {
    boolean bool = super.update();
    if (bool)
      Vd(); 
    return bool;
  }
  
  protected boolean z(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" nShopID=? and ");
    stringBuilder1.append(this.bON);
    stringBuilder1.append("=? and _id<>?  and nWarehouseID=? and sIsActive='Y' ");
    String str1 = stringBuilder1.toString();
    String str2 = VC();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString1);
    stringBuilder2.append("");
    return c(str1, new String[] { str2, stringBuilder2.toString(), paramString2, paramString3 });
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */