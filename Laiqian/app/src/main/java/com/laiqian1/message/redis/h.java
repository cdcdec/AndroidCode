package com.laiqian.message.redis;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class h extends JSONObject {
  h(a parama, String paramString1, String paramString2, List paramList) throws JSONException {
    super(paramString1);
    if (!isNull(this.bJn)) {
      put(this.bJn, a.a(this.bJp, getJSONArray(this.bJn), this.bJo));
      return;
    } 
    put(this.bJn, a.a(this.bJp, new JSONArray(), this.bJo));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\redis\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */