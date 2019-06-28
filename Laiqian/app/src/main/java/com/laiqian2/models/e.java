package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import org.json.JSONException;

public class e extends ao {
  public e(Context paramContext) { super(paramContext); }
  
  private void gW(String paramString) { d("nShopID=? and _id=?", new String[] { VC(), paramString }); }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  protected Cursor UG() {
    c("nShopID=? and sIsActive='Y'", new String[] { VC() });
    return VM();
  }
  
  protected Cursor UH() {
    c("nShopID=? ", new String[] { VC() });
    return VM();
  }
  
  protected boolean a(long paramLong, int paramInt, String paramString) {
    if (i(paramLong, paramString))
      return false; 
    if (paramLong > 0L) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramLong);
      stringBuilder1.append("");
      am("_id", stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    am("nAccountID", stringBuilder.toString());
    am("sIsActive", "Y");
    am("nAccountType", "1");
    am("sAccountName", paramString);
    am("nSpareField1", "1");
    return QL();
  }
  
  protected boolean bg(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    gW(stringBuilder.toString());
    am("sIsActive", "N");
    VS();
    return update();
  }
  
  protected boolean c(long paramLong, boolean paramBoolean) {
    String str = new StringBuilder();
    str.append(paramLong);
    str.append("");
    gW(str.toString());
    if (paramBoolean) {
      String str1 = "1";
    } else {
      str = "0";
    } 
    am("nSpareField1", str);
    return update();
  }
  
  protected Cursor gX(String paramString) {
    c(" _id=? and nShopID=?", new String[] { paramString, VC() });
    return VM();
  }
  
  protected boolean i(long paramLong, String paramString) {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = VC();
    arrayOfString[1] = paramString;
    if (paramLong > 0L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("nShopID=? and sAccountName=? and sIsActive='Y' and _id!=");
      stringBuilder.append(paramLong);
      c(stringBuilder.toString(), arrayOfString);
    } else {
      c("nShopID=? and sAccountName=? and sIsActive='Y'", arrayOfString);
    } 
    Cursor cursor = VM();
    boolean bool = cursor.moveToFirst();
    cursor.close();
    if (bool)
      hP(this.mContext.getString(R.string.pos_already_exists)); 
    return bool;
  }
  
  protected void init() {
    hX("t_account");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,nShopID,nAccountID,nAccountType,sAccountName,fAccountValue,nDateTime,nUserID,sText,nUpdateFlag,nIsUpdated,nOperationTime,sPlatform,sIsActive,nSpareField1");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
  
  protected boolean j(long paramLong, String paramString) {
    if (i(paramLong, paramString))
      return false; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    gW(stringBuilder.toString());
    am("sAccountName", paramString);
    return update();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */