package com.laiqian.entity;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class as {
  public boolean isOpen;
  
  public String password;
  
  public as() {}
  
  public as(String paramString) {
    try {
      if (TextUtils.isEmpty(paramString)) {
        this.isOpen = false;
        this.password = "";
        return;
      } 
      JSONObject jSONObject = new JSONObject(paramString);
      this.isOpen = jSONObject.optBoolean("isOpen", false);
      this.password = jSONObject.optString("password", "");
      return;
    } catch (JSONException paramString) {
      a.e(paramString);
      return;
    } 
  }
  
  public String IX() {
    jSONObject = new JSONObject();
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.isOpen);
      stringBuilder.append("");
      jSONObject.put("isOpen", stringBuilder.toString());
      jSONObject.put("password", this.password);
      return jSONObject.toString();
    } catch (JSONException jSONObject) {
      return "";
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */