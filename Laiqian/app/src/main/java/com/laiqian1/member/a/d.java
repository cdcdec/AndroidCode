package com.laiqian.member.a;

import android.view.View;
import android.widget.EditText;

class d implements View.OnFocusChangeListener {
  d(a parama) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      a.a(this.bwR, (EditText)paramView);
      this.bwR.eP(true);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */