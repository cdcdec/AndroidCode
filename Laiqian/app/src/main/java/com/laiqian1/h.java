package com.laiqian;

import android.text.TextUtils;
import b.aj;
import b.f;
import b.g;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import java.io.IOException;
import org.json.JSONObject;

final class h implements g {
  h(f.a parama) {}
  
  public void a(f paramf, aj paramaj) throws IOException {
    try {
      String str = paramaj.aTc().aTk();
      if (!TextUtils.isEmpty(str)) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.optInt("ret") != 200) {
          n.o(jSONObject.getString("msg"));
          return;
        } 
        jSONObject = jSONObject.optJSONObject("data");
        String str1 = jSONObject.optString("branch_id", "");
        String str2 = jSONObject.optString("token", "");
        boolean bool1 = jSONObject.optBoolean("can_refund", true);
        RootApplication.getLaiqianPreferenceManager().hY(bool1);
        bool1 = RootApplication.getLaiqianPreferenceManager().rK(str1);
        boolean bool2 = RootApplication.getLaiqianPreferenceManager().rJ(str2);
        if (bool1 && bool2 && !TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */