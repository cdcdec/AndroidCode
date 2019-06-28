package com.laiqian.entity;

import com.laiqian.util.by;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class aw implements Serializable, Cloneable {
  private int aXa = 1;
  
  private boolean enabled = true;
  
  private String url = "";
  
  public static aw e(JSONObject paramJSONObject) {
    try {
      aw aw1 = new aw();
      aw1.enabled = paramJSONObject.getBoolean("enabled");
      aw1.aXa = paramJSONObject.getInt("bindingType");
      aw1.url = paramJSONObject.getString("url");
      return aw1;
    } catch (JSONException paramJSONObject) {
      return null;
    } 
  }
  
  public boolean Jq() { return true; }
  
  public int Jr() { return this.aXa; }
  
  public void eH(int paramInt) { this.aXa = paramInt; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof aw))
      return false; 
    paramObject = (aw)paramObject;
    return (this.enabled != paramObject.enabled) ? false : ((this.aXa != paramObject.aXa) ? false : (!!by.bw(this.url, paramObject.url)));
  }
  
  public String getUrl() { return this.url; }
  
  public void setEnabled(boolean paramBoolean) { this.enabled = paramBoolean; }
  
  public void setUrl(String paramString) { this.url = paramString; }
  
  public JSONObject xy() {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("enabled", this.enabled);
      jSONObject.put("bindingType", this.aXa);
      jSONObject.put("url", this.url);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */