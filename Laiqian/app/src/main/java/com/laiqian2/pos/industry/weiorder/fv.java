package com.laiqian.pos.industry.weiorder;

import android.widget.EditText;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class fv implements w.a {
  fv(fu paramfu, String[] paramArrayOfString) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    String str = this.cwD[paramInt];
    ((EditText)this.cwE.cwC.cwv.cwT.dwQ.getView()).setText(str);
    this.cwE.cwC.cww.hi(Integer.parseInt(str));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\fv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */