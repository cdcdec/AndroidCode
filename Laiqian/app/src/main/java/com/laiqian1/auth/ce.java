package com.laiqian.auth;

import android.widget.TextView;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class ce implements w.a {
  ce(cd paramcd) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    if (this.aGp.aGm.aGh != paramInt) {
      UserManagement.o(this.aGp.aGm).setText(UserManagement.p(this.aGp.aGm)[paramInt]);
      TextView textView = UserManagement.o(this.aGp.aGm);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(UserManagement.s(this.aGp.aGm).get(paramInt));
      stringBuilder.append("");
      textView.setTag(stringBuilder.toString());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */