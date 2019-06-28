package com.laiqian.sync.model;

import com.google.a.a.a.a.a.a;
import com.laiqian.f.b;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
  public String aDZ = "";
  
  public String aGA = "";
  
  public String aGB = "";
  
  public String dpg = "";
  
  public int dph = 0;
  
  public String dpi = "";
  
  private boolean dpj = true;
  
  public boolean dpk = true;
  
  public boolean dpl = false;
  
  public String VC() { return this.aGA; }
  
  public int apI() { return this.dph; }
  
  public boolean apM() { return this.dpl; }
  
  public String apN() { return this.dpg; }
  
  public boolean apO() { return this.dpj; }
  
  public void gY(boolean paramBoolean) { this.dpl = paramBoolean; }
  
  public String getMessage() { return this.dpi; }
  
  public String getUserID() { return this.aDZ; }
  
  public void init() {
    this.dpg = "";
    this.aGA = "";
    this.aDZ = "";
    this.aGB = "";
    this.dph = 0;
    this.dpi = "";
    this.dpl = false;
  }
  
  public boolean ox(String paramString) {
    if (paramString != null) {
      if ("".equals(paramString))
        return true; 
      paramString = paramString.trim();
      if (paramString.length() > 10) {
        paramString = b.decode(paramString.substring(0, paramString.length() - 1));
        try {
          JSONObject jSONObject = new JSONObject(paramString);
          if (jSONObject.has("success")) {
            this.dpg = jSONObject.getString("success");
            if (this.dpg.equals("TRUE")) {
              gY(true);
            } else {
              gY(false);
            } 
          } 
          if (jSONObject.has("nShopID"))
            this.aGA = jSONObject.getString("nShopID"); 
          if (jSONObject.has("nUserID"))
            this.aDZ = jSONObject.getString("nUserID"); 
          if (jSONObject.has("nUserRole"))
            this.aGB = jSONObject.getString("nUserRole"); 
          if (jSONObject.has("MsgNo"))
            this.dph = jSONObject.getInt("MsgNo"); 
          if (jSONObject.has("Msg"))
            this.dpi = jSONObject.getString("Msg"); 
          if (jSONObject.has("needDownload")) {
            String str = jSONObject.optString("needDownload");
            if ("TRUE".equals(str)) {
              this.dpj = true;
              return true;
            } 
            if ("FALSE".equals(str)) {
              this.dpj = false;
              return true;
            } 
          } 
        } catch (JSONException paramString) {
          a.e(paramString);
          return true;
        } catch (Exception paramString) {
          a.e(paramString);
          return true;
        } 
      } else {
        this.dpk = false;
        if (paramString.equals("1")) {
          gY(true);
          return true;
        } 
        gY(false);
      } 
      return true;
    } 
    return true;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.dpg);
    stringBuilder.append(",");
    stringBuilder.append(this.aGA);
    stringBuilder.append(",");
    stringBuilder.append(this.aDZ);
    stringBuilder.append(",");
    stringBuilder.append(this.dph);
    stringBuilder.append(",");
    stringBuilder.append(this.dpi);
    stringBuilder.append(",");
    stringBuilder.append(this.dpj);
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\model\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */