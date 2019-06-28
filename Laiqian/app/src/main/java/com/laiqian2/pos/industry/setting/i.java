package com.laiqian.pos.industry.setting;

import android.view.View;
import android.widget.Toast;
import com.laiqian.backup.ag;

class i implements View.OnClickListener {
  i(a parama) {}
  
  public void onClick(View paramView) {
    a.l(this.csb).setVisibility(0);
    a.m(this.csb).setVisibility(8);
    if (ag.za()) {
      a.a(this.csb, ag.yX());
    } else {
      Toast.makeText(a.f(this.csb), 2131624394, 1).show();
    } 
    a.n(this.csb);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */