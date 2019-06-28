package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.av;
import org.json.JSONException;

public class aa extends ao {
  protected final int bKq = 0;
  
  protected final int bKr = 1;
  
  protected final int bKs = 2;
  
  protected final int bKt = 3;
  
  protected final int bQK = 0;
  
  protected final int bQL = 1;
  
  protected final int bQM = 2;
  
  protected String[] bQN = { "sProductName", "sBarcode", "nSpareField3" };
  
  protected String bQO = "nSpareField3";
  
  public aa(Context paramContext) { super(paramContext); }
  
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
  
  protected boolean ac(String paramString1, String paramString2) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" nShopID=? and ");
    stringBuilder1.append(this.bQN[0]);
    stringBuilder1.append("=? and _id<>? and nFoodCategory!=1 and ( nProductStatus=600001 or nProductStatus=600002 )");
    String str1 = stringBuilder1.toString();
    String str2 = VC();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString1);
    stringBuilder2.append("");
    return c(str1, new String[] { str2, stringBuilder2.toString(), paramString2 });
  }
  
  protected boolean aj(String paramString1, String paramString2) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" nShopID=? and ");
    stringBuilder1.append(this.bQO);
    stringBuilder1.append("=? and _id<>? and ( nProductStatus=600001 or nProductStatus=600002 )");
    String str1 = stringBuilder1.toString();
    String str2 = VC();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString1);
    stringBuilder2.append("");
    return c(str1, new String[] { str2, stringBuilder2.toString(), paramString2 });
  }
  
  protected boolean b(String[] paramArrayOfString, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nShopID=? and ");
    stringBuilder.append(this.bQN[0]);
    stringBuilder.append("=? and ");
    stringBuilder.append(this.bQN[1]);
    stringBuilder.append("=? and _id<>? and ( nProductStatus=600001 or nProductStatus=600002 )");
    return c(stringBuilder.toString(), new String[] { VC(), paramArrayOfString[0], paramArrayOfString[1], paramString });
  }
  
  protected boolean bo(long paramLong) {
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    return d(" nShopID=? and _id=? and ( nProductStatus=600001 or nProductStatus=600002 )", new String[] { str, stringBuilder.toString() });
  }
  
  @Deprecated
  protected boolean delete() {
    boolean bool = super.delete();
    if (bool)
      Vd(); 
    return bool;
  }
  
  protected boolean e(long paramLong, boolean paramBoolean) {
    String str1 = " nShopID=? and _id=? and ( nProductStatus=600001 or nProductStatus=600002 )";
    if (paramBoolean)
      str1 = " nShopID=? and _id=?"; 
    String str2 = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    return c(str1, new String[] { str2, stringBuilder.toString() });
  }
  
  protected boolean hG(String paramString) { return d(" nShopID=? and _id=? and ( nProductStatus=600001 or nProductStatus=600002 )", new String[] { VC(), paramString }); }
  
  protected boolean hI(String paramString) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" nShopID=? and ");
    stringBuilder1.append(this.bQN[0]);
    stringBuilder1.append("=? and ( nProductStatus=600001 or nProductStatus=600002 ) ");
    String str1 = stringBuilder1.toString();
    String str2 = VC();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append("");
    return c(str1, new String[] { str2, stringBuilder2.toString() });
  }
  
  protected boolean hJ(String paramString) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" nShopID=? and ");
    stringBuilder1.append(this.bQO);
    stringBuilder1.append("=? and ( nProductStatus=600001 or nProductStatus=600002 )");
    String str1 = stringBuilder1.toString();
    String str2 = VC();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append("");
    return c(str1, new String[] { str2, stringBuilder2.toString() });
  }
  
  protected void init() {
    hX("t_product");
    hV("_id");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,nShopID,sProductName,sProductDescription,nProductType,nProductStatus,fShowPrice,fBuyPrice,fStockPrice,fSalePrice,sBarcode,sImage,nProductUnit,nStockQty,nCurrency,nUserID,sText,nUpdateFlag,nIsUpdated,nOperationTime,sPlatform,sProductNumber,fDiscountSalePrice,sSupplier,sSpareField1,sSpareField2,sSpareField3,sSpareField4,sSpareField5,nSpareField1,nSpareField2,nSpareField3,nSpareField4,nSpareField5,nFoodCategory,nSpareField1");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
  
  protected boolean t(String[] paramArrayOfString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nShopID=? and ");
    stringBuilder.append(this.bQN[0]);
    stringBuilder.append("=? and ");
    stringBuilder.append(this.bQN[1]);
    stringBuilder.append("=? and ( nProductStatus=600001 or nProductStatus=600002 )");
    return c(stringBuilder.toString(), new String[] { VC(), paramArrayOfString[0], paramArrayOfString[1] });
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */