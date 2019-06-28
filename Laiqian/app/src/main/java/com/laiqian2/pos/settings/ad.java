package com.laiqian.pos.settings;

import android.view.View;

class ad implements View.OnClickListener {
  ad(ab paramab) {}
  
  public void onClick(View paramView) {
    boolean bool = this.cAa.save();
    if (ab.a(this.cAa) != null) {
      String str = ab.b(this.cAa).getText().toString();
      if (ab.c(this.cAa) == 0L) {
        ab.a(this.cAa).d(bool, ab.c(this.cAa), str);
        return;
      } 
      ab.a(this.cAa).e(bool, ab.c(this.cAa), str);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */