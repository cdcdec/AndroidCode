package com.laiqian.print.dualscreen;

import android.widget.TextView;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.util.by;

class i implements w.a {
  i(DualScreenSettingsActivity paramDualScreenSettingsActivity, String[] paramArrayOfString) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    String str = this.cFu[paramInt].replace("s", "");
    this.cFt.cFo.mb(by.parseInt(str));
    ((TextView)(DualScreenSettingsActivity.d(this.cFt)).cFA.cAP.getView()).setText(this.cFu[paramInt]);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\dualscreen\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */