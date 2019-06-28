package com.laiqian.pos.industry.weiorder.auth;

import com.laiqian.util.bb;
import org.json.JSONObject;

public class a implements Cloneable {
  public String accountType = "";
  
  public String cxT = "";
  
  public String cxU = "";
  
  public Boolean cxV;
  
  public Boolean cxW;
  
  public Boolean cxX;
  
  public Boolean cxY;
  
  public int cxZ = Integer.MIN_VALUE;
  
  public static a l(JSONObject paramJSONObject) {
    bb.e("json", paramJSONObject.toString());
    a a1 = new a();
    a1.cxT = paramJSONObject.optString("nick_name", "");
    a1.accountType = paramJSONObject.optString("type_name", "");
    a1.cxU = paramJSONObject.optString("qrcode_url", "");
    boolean bool1 = false;
    if (paramJSONObject.optInt("bIsManage", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    a1.cxY = Boolean.valueOf(bool);
    if (paramJSONObject.optInt("bMenuTakeaway", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    a1.cxV = Boolean.valueOf(bool);
    if (paramJSONObject.optInt("bMenuVip", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    a1.cxW = Boolean.valueOf(bool);
    boolean bool = bool1;
    if (paramJSONObject.optInt("bMenuShops", 0) == 1)
      bool = true; 
    a1.cxX = Boolean.valueOf(bool);
    a1.cxZ = paramJSONObject.optInt("verify_type", -2147483648);
    bb.e("url", a1.cxU);
    return a1;
  }
  
  public a acM() throws CloneNotSupportedException { return (a)super.clone(); }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof a))
      return false; 
    paramObject = (a)paramObject;
    return (this.cxY != paramObject.cxY) ? false : ((this.cxV != paramObject.cxV) ? false : ((this.cxW != paramObject.cxW) ? false : ((this.cxX != paramObject.cxX) ? false : (!(this.cxZ != paramObject.cxZ)))));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\auth\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */