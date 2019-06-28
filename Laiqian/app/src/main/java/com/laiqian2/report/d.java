package com.laiqian.report;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.laiqian.member.bz;
import com.laiqian.print.cardreader.am;

class d implements View.OnFocusChangeListener {
  d(FilterActivity20150320 paramFilterActivity20150320) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      ((InputMethodManager)this.cYY.cYR.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
      int i = am.ba(this.cYY).afs().size();
      if (i == 0) {
        this.cYY.cYR.setHint(this.cYY.getString(2131628168));
      } else if (i > 0) {
        this.cYY.cYR.setHint(this.cYY.getString(2131627060));
      } 
      bz bz;
      if ((bz = this.cYY.aDP).aE(this.cYY)) {
        this.cYY.aDP = bz.Qw();
        this.cYY.aDP.a(this.cYY, 500L, this.cYY.aDQ);
        this.cYY.aDP.start();
        return;
      } 
      if (this.cYY.aDP != null) {
        this.cYY.aDP.stop();
        return;
      } 
    } else {
      paramView = this.cYY.getWindow().peekDecorView();
      if (paramView != null)
        ((InputMethodManager)this.cYY.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0); 
      if (this.cYY.aDP != null)
        this.cYY.aDP.stop(); 
      this.cYY.cYR.setHint("");
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */