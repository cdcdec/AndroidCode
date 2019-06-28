package com.laiqian.ui.b;

import android.view.KeyEvent;
import android.view.View;

class d implements View.OnKeyListener {
  d(a parama) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && a.d(this.dDv) != null) {
      a.d(this.dDv).dismiss();
      if (a.a(this.dDv).getVisibility() == 0)
        a.a(this.dDv).setVisibility(8); 
      a.a(this.dDv, null);
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */