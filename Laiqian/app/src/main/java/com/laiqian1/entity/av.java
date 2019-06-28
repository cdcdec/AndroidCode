package com.laiqian.entity;

import com.laiqian.util.bb;
import com.laiqian.util.by;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class av implements Serializable {
  String aVs = "";
  
  String aWU = "";
  
  String aWV = "";
  
  boolean aWW = true;
  
  String aWX = "00:00-23:59";
  
  private String aWY = "";
  
  String aWZ = "";
  
  public static av b(JSONObject paramJSONObject, String paramString) {
    bb.e("json", paramJSONObject.toString());
    av av1 = new av();
    String str = paramJSONObject.optString("shop_status", null);
    if (!by.isNull(str) && str.equals("closed")) {
      av1.aWW = false;
    } else {
      av1.aWW = true;
    } 
    if (by.isNull(paramJSONObject.optString("business_hours", "00:00-23:59"))) {
      av1.aWX = "00:00-23:59";
    } else {
      av1.aWX = paramJSONObject.optString("business_hours", "00:00-23:59");
    } 
    av1.aWY = paramJSONObject.optString("cover_figure_url", "");
    av1.aWV = paramJSONObject.optString("address", "");
    av1.aWZ = paramJSONObject.optString("shop_description", "");
    av1.aVs = paramJSONObject.optString("shop_name", "");
    av1.aWU = paramJSONObject.optString("contact", "");
    return av1;
  }
  
  public static av d(JSONObject paramJSONObject) {
    bb.e("json", paramJSONObject.toString());
    av av1 = new av();
    av1.aWW = paramJSONObject.optBoolean("openShop", true);
    av1.aWX = paramJSONObject.optString("businessHours", "00:00-23:59");
    av1.aWY = paramJSONObject.optString("coverFigureUrl", "");
    av1.aWV = paramJSONObject.optString("shopAddress", "");
    av1.aVs = paramJSONObject.optString("shopName", "");
    av1.aWU = paramJSONObject.optString("shopContact", "");
    return av1;
  }
  
  public String Cc() { return this.aWX; }
  
  public String Ip() { return this.aVs; }
  
  public String Jj() { return this.aWU; }
  
  public String Jk() { return this.aWV; }
  
  public String Jl() { return this.aWZ; }
  
  public boolean Jm() { return this.aWW; }
  
  public String Jn() { return this.aWY; }
  
  public av Jo() {
    av av1 = new av();
    av1.aVs = this.aVs;
    av1.aWU = this.aWU;
    av1.aWV = this.aWV;
    av1.aWZ = this.aWZ;
    av1.aWW = this.aWW;
    av1.aWX = this.aWX;
    av1.aWY = this.aWY;
    return av1;
  }
  
  public JSONObject Jp() {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("shop_status", this.aWW);
      jSONObject.put("business_hours", this.aWX);
      jSONObject.put("cover_figure_url", this.aWY);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public void cZ(boolean paramBoolean) { this.aWW = paramBoolean; }
  
  public void cc(String paramString) { this.aWX = paramString; }
  
  public void dK(String paramString) { this.aVs = paramString; }
  
  public void dL(String paramString) { this.aWU = paramString; }
  
  public void dM(String paramString) { this.aWV = paramString; }
  
  public void dN(String paramString) { this.aWZ = paramString; }
  
  public void dO(String paramString) { this.aWY = paramString; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof av))
      return false; 
    paramObject = (av)paramObject;
    return (this.aVs != null) ? ((paramObject.aVs == null) ? false : (!this.aVs.equals(paramObject.aVs) ? false : ((this.aWU != null) ? ((paramObject.aWU == null) ? false : (!this.aWU.equals(paramObject.aWU) ? false : ((this.aWV != null) ? ((paramObject.aWV == null) ? false : (!this.aWV.equals(paramObject.aWV) ? false : ((this.aWZ != null) ? ((paramObject.aWZ == null) ? false : (!this.aWZ.equals(paramObject.aWZ) ? false : ((this.aWW != paramObject.aWW) ? false : (!this.aWX.equals(paramObject.aWX) ? false : ((this.aWY == null && paramObject.aWY != null) ? false : ((this.aWY != null && paramObject.aWY == null) ? false : (!(this.aWY != null && !this.aWY.equals(paramObject.aWY))))))))) : false))) : false))) : false))) : false;
  }
  
  public JSONObject xy() {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("openShop", this.aWW);
      jSONObject.put("businessHours", this.aWX);
      jSONObject.put("coverFigureUrl", this.aWY);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */