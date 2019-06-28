package com.laiqian.main;

import android.view.View;
import com.laiqian.util.n;

class cz implements View.OnClickListener {
  cz(cs paramcs) {}
  
  public void onClick(View paramView) {
    cs.d d = (cs.d)cs.b(this.bde).getTag();
    int i = n.parseInt(cs.c(this.bde).getText().toString());
    if (i > cs.d.a(d))
      cs.c(this.bde).setText(String.valueOf(i - 1)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */