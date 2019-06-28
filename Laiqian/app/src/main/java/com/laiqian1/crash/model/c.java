package com.laiqian.crash.model;

import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.message.k;
import com.laiqian.takeaway.aq;
import org.json.JSONException;
import org.json.JSONObject;

class c implements k.b {
  c(CrashApplication paramCrashApplication) {}
  
  public boolean ci(String paramString) { return "TAKEAWAY_ORDER".equals(paramString); }
  
  public void cj(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      (new aq(RootApplication.zv())).a(jSONObject, RootApplication.zv(), true, true);
      return;
    } catch (JSONException paramString) {
      a.e(paramString);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\model\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */