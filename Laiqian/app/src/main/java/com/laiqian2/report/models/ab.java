package com.laiqian.report.models;

import com.google.a.a.a.a.a.a;
import com.laiqian.util.by;
import org.json.JSONException;
import org.json.JSONObject;

public class ab {
  public String nt(String paramString) {
    if (!by.isNull(paramString))
      try {
        JSONObject jSONObject = new JSONObject(paramString);
        if ("weixin_eat_in".equals(jSONObject.optString("sTakeawayType")))
          return jSONObject.optString("sAddress"); 
      } catch (JSONException paramString) {
        a.e(paramString);
      }  
    return "";
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */