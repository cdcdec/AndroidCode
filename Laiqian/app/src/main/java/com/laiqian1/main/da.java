package com.laiqian.main;

import android.view.View;
import com.laiqian.util.n;

class da implements View.OnClickListener {
  da(cs paramcs) {}
  
  public void onClick(View paramView) {
    cs.d d = (cs.d)cs.b(this.bde).getTag();
    int i = n.parseInt(cs.c(this.bde).getText().toString());
    if (i < cs.d.b(d))
      cs.c(this.bde).setText(String.valueOf(i + 1)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */