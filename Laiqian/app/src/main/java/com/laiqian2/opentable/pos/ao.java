package com.laiqian.opentable.pos;

import android.view.View;
import com.laiqian.opentable.common.entity.a;

class ao implements View.OnClickListener {
  ao(ai paramai) {}
  
  public void onClick(View paramView) {
    a a = (a)paramView.getTag();
    if (a == null) {
      ai.g(this.cbO).at(null, null);
      return;
    } 
    ai.a(this.cbO, a);
    ai.d(this.cbO);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */