package com.laiqian.pos;

import android.view.View;

class ad implements View.OnClickListener {
  ad(ab paramab) {}
  
  public void onClick(View paramView) {
    boolean bool = this.cfv.save();
    if (ab.a(this.cfv) != null) {
      String str = ab.b(this.cfv).getText().toString();
      if (ab.c(this.cfv) == 0L) {
        ab.a(this.cfv).d(bool, ab.c(this.cfv), str);
        return;
      } 
      ab.a(this.cfv).e(bool, ab.c(this.cfv), str);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */