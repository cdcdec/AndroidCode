package com.laiqian.news;

import android.view.View;

class p implements View.OnClickListener {
  p(o paramo, int paramInt) {}
  
  public void onClick(View paramView) {
    o.a(this.bWJ).w(paramView, this.qI);
    if (!o.b(this.bWJ).kn()) {
      this.bWJ.bK(o.c(this.bWJ));
      if (o.c(this.bWJ) != this.qI)
        this.bWJ.bK(this.qI); 
    } 
    this.bWJ.setPosition(this.qI);
    if (!o.b(this.bWJ).kn()) {
      this.bWJ.bK(o.c(this.bWJ));
      if (o.c(this.bWJ) != this.qI)
        this.bWJ.bK(this.qI); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */