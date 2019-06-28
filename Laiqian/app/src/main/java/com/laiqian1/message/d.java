package com.laiqian.message;

import android.content.Context;
import android.text.TextUtils;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.network.k;
import com.laiqian.pos.hardware.RootUrlParameter;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
  private Context mContext;
  
  public d(Context paramContext) { this.mContext = paramContext; }
  
  public String Tm() throws Exception {
    null = new k();
    int i = a.zR().Ao();
    null = new StringBuilder();
    null.append(RootUrlParameter.cmz);
    null.append("/0/0.html");
    String str2 = null.iJ(null.toString());
    null = new StringBuilder();
    null.append(RootUrlParameter.cmz);
    null.append("/");
    null.append(i);
    null.append("/0.html");
    String str3 = null.iJ(null.toString());
    String str1 = str2;
    if (!str3.contains("NoSuchKey")) {
      str1 = str2;
      if (!str2.contains("NoSuchKey")) {
        JSONObject jSONObject = new JSONObject(str2);
        long l = (new JSONObject(str3)).optLong("id");
        if (Long.valueOf(jSONObject.optLong("id")).longValue() > Long.valueOf(l).longValue()) {
          String str = str2;
        } else {
          str1 = str3;
        } 
      } 
    } 
    str3 = RootApplication.getLaiqianPreferenceManager().atk();
    str2 = "";
    if (!TextUtils.isEmpty(str3)) {
      null = new StringBuilder();
      null.append(RootUrlParameter.cmz);
      null.append("/");
      null.append(i);
      null.append("/");
      null.append(str3);
      null.append(".html");
      str2 = null.iJ(null.toString());
    } 
    JSONArray jSONArray = new JSONArray();
    if (!TextUtils.isEmpty(str1) && !str1.contains("NoSuchKey"))
      jSONArray.put(0, new JSONObject(str1)); 
    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !str2.contains("NoSuchKey"))
      jSONArray.put(1, new JSONObject(str2)); 
    return jSONArray.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */