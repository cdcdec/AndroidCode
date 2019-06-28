package com.laiqian.auth;

import android.view.View;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.c;
import com.laiqian.network.t;
import com.laiqian.util.av;
import io.reactivex.g.a;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

class w implements View.OnClickListener {
  w(CreateEmployeeDialog paramCreateEmployeeDialog) {}
  
  public void onClick(View paramView) {
    if (!CreateEmployeeDialog.c(this.aDT))
      return; 
    CreateEmployeeDialog.d(this.aDT).setText("");
    if (CreateEmployeeDialog.e(this.aDT)) {
      String str2 = CreateEmployeeDialog.f(this.aDT).getText().toString().trim();
      str1 = CreateEmployeeDialog.a(this.aDT).getText().toString().trim();
      try {
        String str = c.cI(str1);
        str1 = str;
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        a.e(noSuchAlgorithmException);
      } 
      CreateEmployeeDialog.g(this.aDT).show();
      JSONObject jSONObject = new JSONObject();
      try {
        av av = new av(CreateEmployeeDialog.b(this.aDT));
        jSONObject.put("BOSS_SUSERPHONE", av.Ea());
        jSONObject.put("BOSS_SPASSWORD", av.atr());
        av.close();
        jSONObject.put(t.bVd, str2);
        jSONObject.put(t.bUz, str2);
        jSONObject.put(t.bUY, str1);
      } catch (JSONException str1) {
        a.e(str1);
      } 
      x x = new x(this, jSONObject);
      a.aKh().r(x);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */