package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.av;
import org.json.JSONException;

public class as extends ao {
  protected String[] bTp = { "sFieldName", "sFieldValue", "_id" };
  
  protected String[] bTq = { "sFieldValue", "sDefaultValue", "_id" };
  
  private String bTr = "26";
  
  protected int bTs = 0;
  
  public as() throws Exception { this(null); }
  
  public as(Context paramContext) { super(paramContext); }
  
  protected boolean UA() { return true; }
  
  protected boolean UB() { return true; }
  
  protected boolean UC() { return true; }
  
  protected boolean UD() { return true; }
  
  protected boolean UE() { return true; }
  
  protected String VZ() { return hQ("sFieldName"); }
  
  protected void Vd() throws Exception {
    av av = new av(this.mContext);
    if (this.bTs == 5)
      av.hq(true); 
    if (this.bTs == 44)
      av.hs(true); 
    av.close();
  }
  
  protected String Wa() { return hQ("sFieldName"); }
  
  public String Wb() {
    av av = new av(this.mContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" ([T_STRING].[nShopID]=");
    stringBuilder.append(av.Tx());
    stringBuilder.append(" and [T_STRING].[_id]=?)  or ([T_STRING].[nShopID] is null and [T_STRING].[_id]=?  and [T_STRING].[sText]='");
    stringBuilder.append(av.att());
    stringBuilder.append("') ");
    String str = stringBuilder.toString();
    av.close();
    return str;
  }
  
  protected boolean Wc() {
    boolean bool = QL();
    if (bool)
      Vd(); 
    return bool;
  }
  
  public Cursor Wd() {
    try {
      return Vq().rawQuery("SELECT * from  T_STRING  WHERE nShopID = ? and nFieldType = ?", new String[] { VC(), "66" });
    } catch (Exception exception) {
      a.e(exception);
      return null;
    } 
  }
  
  public Cursor We() {
    try {
      return Vq().rawQuery("SELECT * FROM  T_STRING  WHERE nShopID = ? AND nFieldType = ?", new String[] { VC(), "67" });
    } catch (Exception exception) {
      a.e(exception);
      return null;
    } 
  }
  
  protected boolean bE(long paramLong) { return q(paramLong, VC()); }
  
  protected boolean bF(long paramLong) {
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    return d(" nShopID=? and _id=? ", new String[] { str, stringBuilder.toString() });
  }
  
  protected boolean delete() {
    am(this.bSR, this.bSU);
    boolean bool = update();
    if (bool)
      Vd(); 
    return bool;
  }
  
  public boolean e(String paramString1, String paramString2, String paramString3, String paramString4) {
    if (paramString2 != null && paramString3 != null) {
      boolean bool;
      if (paramString4 == null)
        return false; 
      Cursor cursor = Wd();
      if (cursor != null && cursor.getCount() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      cursor.close();
      am("sSpareField1", paramString2);
      am("sSpareField2", paramString3);
      am("sSpareField3", paramString4);
      if (bool) {
        d("nFieldType = ? and nShopID = ?", new String[] { "66", VC() });
        return update();
      } 
      if (paramString1 != null)
        am("sText", paramString1); 
      am("nFieldType", "66");
      am("nShopID", VC());
      return QL();
    } 
    return false;
  }
  
  protected void gk(int paramInt) { this.bTs = paramInt; }
  
  protected boolean i(String paramString, long paramLong) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" ([T_STRING].[nFieldType] in (5,91,92)  or length([T_STRING].[nFieldType])=13) and [T_STRING].[nShopID]=");
    stringBuilder1.append(VC());
    stringBuilder1.append("  and [T_STRING].[sFieldName] = ? and _id<>? and sIsActive='Y' ");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong);
    stringBuilder2.append("");
    return c(str, new String[] { paramString, stringBuilder2.toString() });
  }
  
  protected boolean ii(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" ([T_STRING].[nFieldType]=82 or length([T_STRING].[nFieldType])=13) and [T_STRING].[nShopID]=");
    stringBuilder.append(VC());
    stringBuilder.append("  and [T_STRING].[sFieldName] = ? and sIsActive = 'Y' ");
    return c(stringBuilder.toString(), new String[] { paramString });
  }
  
  protected boolean ij(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" ([T_STRING].[nFieldType]=86 or length([T_STRING].[nFieldType])=13) and [T_STRING].[nShopID]=");
    stringBuilder.append(VC());
    stringBuilder.append("  and [T_STRING].[sFieldName] = ? and sIsActive = 'Y' ");
    return c(stringBuilder.toString(), new String[] { paramString });
  }
  
  protected boolean ik(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" ([T_STRING].[nFieldType] in (5,91,92) or length([T_STRING].[nFieldType])=13) and [T_STRING].[nShopID]=");
    stringBuilder.append(VC());
    stringBuilder.append("  and [T_STRING].[sFieldName] = ? and sIsActive = 'Y' ");
    return c(stringBuilder.toString(), new String[] { paramString });
  }
  
  protected boolean il(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" ([T_STRING].[nFieldType]=87 or length([T_STRING].[nFieldType])=13) and [T_STRING].[nShopID]=");
    stringBuilder.append(VC());
    stringBuilder.append("  and [T_STRING].[sFieldName] = ? and sIsActive = 'Y' ");
    return c(stringBuilder.toString(), new String[] { paramString });
  }
  
  protected void init() throws Exception {
    hX("t_string");
    hV("_id");
    hW("sFieldName");
    try {
      this.bRX.put("LAIQIAN_FIELD_NAMES", "_id,nFieldType,sFieldName,sFieldValue,sText,nUpdateFlag,nShopID,nUserID,nStringID,sIsActive,sDefaultValue,nIsUpdated,nOperationTime,sPlatform,sSpareField1,sSpareField2,sSpareField3,sSpareField4,sSpareField5,nSpareField1,nSpareField2,nSpareField3,nSpareField4,nSpareField5,fSpareField1,fSpareField2,fSpareField3,fSpareField4,fSpareField5,nWarehouseID,nSpareField1");
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
  
  protected boolean j(String paramString, long paramLong) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" ([T_STRING].[nFieldType]=82 or length([T_STRING].[nFieldType])=13) and [T_STRING].[nShopID]=");
    stringBuilder1.append(VC());
    stringBuilder1.append("  and [T_STRING].[sFieldName] = ? and _id<>? and sIsActive='Y' ");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong);
    stringBuilder2.append("");
    return c(str, new String[] { paramString, stringBuilder2.toString() });
  }
  
  protected boolean k(String paramString, long paramLong) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" ([T_STRING].[nFieldType]=86 or length([T_STRING].[nFieldType])=13) and [T_STRING].[nShopID]=");
    stringBuilder1.append(VC());
    stringBuilder1.append("  and [T_STRING].[sFieldName] = ? and _id<>? and sIsActive='Y' ");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong);
    stringBuilder2.append("");
    return c(str, new String[] { paramString, stringBuilder2.toString() });
  }
  
  protected boolean l(String paramString, long paramLong) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" ([T_STRING].[nFieldType]=87 or length([T_STRING].[nFieldType])=13) and [T_STRING].[nShopID]=");
    stringBuilder1.append(VC());
    stringBuilder1.append("  and [T_STRING].[_id] = ? and _id<>? and sIsActive='Y' ");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong);
    stringBuilder2.append("");
    return c(str, new String[] { paramString, stringBuilder2.toString() });
  }
  
  protected boolean m(String paramString, boolean paramBoolean) {
    av av = new av(this.mContext);
    null = new StringBuilder();
    null.append(" ([T_STRING].[nFieldType]=? and [T_STRING].[nShopID]=");
    null.append(av.Tx());
    null.append(" and sIsActive='Y' ) ");
    String str = null.toString();
    if (paramBoolean) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(" or ([T_STRING].[nFieldType]=? and [T_STRING].[nShopID] is null  and [T_STRING].[sText]='");
      stringBuilder.append(av.att());
      stringBuilder.append("') ");
      paramBoolean = c(stringBuilder.toString(), new String[] { paramString, paramString });
    } else {
      paramBoolean = c(str, new String[] { paramString });
    } 
    av.close();
    return paramBoolean;
  }
  
  protected boolean q(long paramLong, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    String str = stringBuilder.toString();
    if (TextUtils.isEmpty(paramString)) {
      paramString = " _id =? ";
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("(nShopID=");
      stringBuilder1.append(paramString);
      stringBuilder1.append(") and  _id =? ");
      paramString = stringBuilder1.toString();
    } 
    return d(paramString, new String[] { str });
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\models\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */