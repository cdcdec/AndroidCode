package com.laiqian.meituan;

import android.view.View;
import com.google.a.a.a.a.a.a;
import com.laiqian.takeaway.bc;
import com.laiqian.util.n;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

class y implements View.OnClickListener {
  y(w paramw, Map paramMap) {}
  
  public void onClick(View paramView) {
    jSONArray = new JSONArray();
    null = ((String)this.bqU.get("sOrderIds")).split(",");
    String[] arrayOfString = ((String)this.bqU.get("sRealPhoneNumbers")).split(",");
    for (byte b = 0; b < null.length; b++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null[b]);
      stringBuilder.append("/");
      stringBuilder.append(arrayOfString[b]);
      jSONArray.put(stringBuilder.toString());
    } 
    bc bc = new bc(this.bqV.bqT);
    try {
      bc.z(jSONArray.toString(), true);
      return;
    } catch (JSONException jSONArray) {
      n.o("打印出错");
      a.e(jSONArray);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */