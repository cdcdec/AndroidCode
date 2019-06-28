package com.laiqian;

import android.view.View;

class z implements View.OnClickListener {
  z(o paramo) {}
  
  public void onClick(View paramView) {
    if (this.aBa.aAD != null)
      this.aBa.aAD.stop(); 
    this.aBa.aAD.xw();
    if (this.aBa.onlinePayEntity.Fo() == 5L || this.aBa.onlinePayEntity.Fo() == 1L) {
      if (!this.aBa.wW()) {
        this.aBa.xk();
        return;
      } 
      this.aBa.bt(true);
      this.aBa.xk();
      if (this.aBa.aAQ != null)
        this.aBa.aAQ.show(); 
      return;
    } 
    if (this.aBa.onlinePayEntity.Fo() == 8L || this.aBa.onlinePayEntity.Fo() == 0L) {
      this.aBa.xk();
      if (this.aBa.aAO != null) {
        this.aBa.bt(true);
        if (this.aBa.aAQ != null) {
          this.aBa.aAQ.show();
          return;
        } 
      } 
      return;
    } 
    this.aBa.xk();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */