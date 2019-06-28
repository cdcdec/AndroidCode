package com.laiqian.member.setting.sms;

import com.google.a.a.a.a.a.a;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
  public boolean bGK;
  
  public boolean bGL;
  
  public boolean bGM;
  
  public boolean bGN = true;
  
  public int bGd;
  
  public static k b(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    k k1 = new k();
    k1.bGK = paramJSONObject1.optBoolean("isMemberConsumeNoticed", false);
    k1.bGL = paramJSONObject1.optBoolean("isMemberChargeNoticed", false);
    k1.bGM = paramJSONObject1.optBoolean("isWeixinVerifyNoticed", false);
    k1.bGN = true;
    k1.bGd = paramJSONObject2.optInt("nSMSQuantityLeft", 0);
    return k1;
  }
  
  public static String b(k paramk) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("isMemberConsumeNoticed", paramk.bGK);
      jSONObject.put("isMemberChargeNoticed", paramk.bGL);
      jSONObject.put("isWeixinVerifyNoticed", paramk.bGM);
      jSONObject.put("isOpenSMSNotice", true);
      return jSONObject.toString();
    } catch (JSONException paramk) {
      a.e(paramk);
      return null;
    } 
  }
  
  public k SS() {
    k k1 = new k();
    k1.bGK = this.bGK;
    k1.bGL = this.bGL;
    k1.bGM = this.bGM;
    k1.bGN = this.bGN;
    k1.bGd = this.bGd;
    return k1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */