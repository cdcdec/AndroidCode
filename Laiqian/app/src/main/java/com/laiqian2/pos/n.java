package com.laiqian.pos;

import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.a;

class n implements View.OnClickListener {
  n(e parame) {}
  
  public void onClick(View paramView) {
    a a = new a(e.d(this.cfk), RootApplication.zv().getResources().getString(R.string.pos_pos_SimpleDF_Day));
    a.a(new o(this));
    a.g(e.g(this.cfk));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */