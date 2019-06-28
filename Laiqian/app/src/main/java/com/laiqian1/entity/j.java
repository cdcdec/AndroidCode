package com.laiqian.entity;

import com.google.a.a.a.a.a.a;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
  private Long aSi;
  
  private String aSj;
  
  private String acL;
  
  private String type;
  
  private String url;
  
  public static j cZ(String paramString) {
    j j1 = new j();
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      j1.c(Long.valueOf(jSONObject.optLong("id")));
      j1.setUrl(jSONObject.optString("url"));
      j1.cY(jSONObject.optString("header"));
      j1.V(jSONObject.optString("content"));
      j1.setType(jSONObject.optString("type", ""));
      return j1;
    } catch (JSONException paramString) {
      a.e(paramString);
      return j1;
    } 
  }
  
  public Integer EY() { return this.type.startsWith("0") ? Integer.valueOf(0) : Integer.valueOf(1); }
  
  public Long EZ() { return this.aSi; }
  
  public String Fa() { return this.aSj; }
  
  public void V(String paramString) { this.acL = paramString; }
  
  public void c(Long paramLong) { this.aSi = paramLong; }
  
  public void cY(String paramString) { this.aSj = paramString; }
  
  public String getUrl() { return this.url; }
  
  public String oV() { return this.acL.contains("<br>") ? this.acL.replace("<br>", "\n") : this.acL; }
  
  public void setType(String paramString) { this.type = paramString; }
  
  public void setUrl(String paramString) { this.url = paramString; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */