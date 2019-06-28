package com.laiqian.report;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import java.util.HashMap;

class j implements w.a {
  j(FilterActivity20150320 paramFilterActivity20150320) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    FilterActivity20150320.jE(paramInt);
    if (!this.cYY.getString(2131626458).equals(((String)((HashMap)FilterActivity20150320.f(this.cYY).get(paramInt)).get("sUserName")).toString())) {
      this.cYY.cYy.setText(((String)((HashMap)FilterActivity20150320.f(this.cYY).get(paramInt)).get("sUserName")).toString());
    } else {
      this.cYY.cYy.setText("");
    } 
    FilterActivity20150320.bKe = Long.valueOf(((String)((HashMap)FilterActivity20150320.f(this.cYY).get(paramInt)).get("nUserID")).toString()).longValue();
    FilterActivity20150320.bLJ = ((String)((HashMap)FilterActivity20150320.f(this.cYY).get(paramInt)).get("sUserName")).toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */