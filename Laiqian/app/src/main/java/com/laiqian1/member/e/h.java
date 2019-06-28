package com.laiqian.member.e;

import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.pos.do;

class h implements View.OnClickListener {
  h(e parame) {}
  
  public void onClick(View paramView) {
    if (!RootApplication.getLaiqianPreferenceManager().avM()) {
      (new do(e.d(this.byp), new i(this))).show();
      return;
    } 
    (new a(e.e(this.byp))).a((e.a(this.byp)).aWH, (e.a(this.byp)).aSW, (e.a(this.byp)).aWn, (e.a(this.byp)).aTp, (e.a(this.byp)).aWC, new k(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */