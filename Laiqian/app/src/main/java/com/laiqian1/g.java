package com.laiqian;

import android.text.TextUtils;
import b.aj;
import b.f;
import b.g;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import java.io.IOException;
import org.json.JSONObject;

final class g implements g {
  g(f.a parama) {}
  
  public void a(f paramf, aj paramaj) throws IOException {
    try {
      String str = paramaj.aTc().aTk();
      if (!TextUtils.isEmpty(str)) {
        JSONObject jSONObject = (new JSONObject(str)).optJSONObject("data");
        str = jSONObject.optString("merchantId", "");
        String str1 = jSONObject.optString("token", "");
        String str2 = jSONObject.optString("authRefund", "1");
        RootApplication.getLaiqianPreferenceManager().rH(str2);
        boolean bool1 = RootApplication.getLaiqianPreferenceManager().rK(str);
        boolean bool2 = RootApplication.getLaiqianPreferenceManager().rJ(str1);
        if (bool1 && bool2 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str1)) {
          if (this.azw != null) {
            this.azw.wS();
            return;
          } 
        } else if (this.azw != null) {
          this.azw.wT();
          return;
        } 
      } 
    } catch (Exception paramf) {
      a.e(paramf);
    } 
  }
  
  public void a(f paramf, IOException paramIOException) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */