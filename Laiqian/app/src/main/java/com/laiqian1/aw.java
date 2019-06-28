package com.laiqian;

import android.view.View;

class aw implements View.OnClickListener {
  aw(ag paramag) {}
  
  public void onClick(View paramView) {
    if (ag.d(this.aBv) != null)
      ag.d(this.aBv).stop(); 
    ag.d(this.aBv).xw();
    if (ag.b(this.aBv).Fo() == 5L || ag.b(this.aBv).Fo() == 1L) {
      if (!this.aBv.wW()) {
        this.aBv.xk();
        return;
      } 
      this.aBv.bt(true);
      this.aBv.xk();
      if (ag.g(this.aBv) != null)
        ag.g(this.aBv).show(); 
      return;
    } 
    if (ag.b(this.aBv).Fo() == 8L || ag.b(this.aBv).Fo() == 0L) {
      this.aBv.xk();
      if (this.aBv.aAO != null) {
        this.aBv.bt(true);
        if (ag.g(this.aBv) != null) {
          ag.g(this.aBv).show();
          return;
        } 
      } 
      return;
    } 
    this.aBv.xk();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */