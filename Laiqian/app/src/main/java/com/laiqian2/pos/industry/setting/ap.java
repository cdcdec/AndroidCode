package com.laiqian.pos.industry.setting;

import android.view.View;
import com.laiqian.util.ae;

class ap implements View.OnClickListener {
  ap(MainSetting paramMainSetting) {}
  
  public void onClick(View paramView) {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    MainSetting.access$400(this.csj).showAtLocation(paramView, 8388661, ae.b(this.csj, 16.0F), arrayOfInt[1] + paramView.getHeight() + 1 - 3);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */