package com.laiqian.print.a;

import android.view.View;

class e implements View.OnClickListener {
  e(d paramd) {}
  
  public void onClick(View paramView) {
    if (this.cFe.cFd.getVisibility() == 0) {
      this.cFe.afz();
      return;
    } 
    if (d.a(this.cFe) != null)
      this.cFe.b(d.a(this.cFe).aft()); 
    this.cFe.afy();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */