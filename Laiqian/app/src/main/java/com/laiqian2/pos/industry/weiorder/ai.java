package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.view.View;

class ai implements View.OnClickListener {
  ai(TakeOutGuideActivity paramTakeOutGuideActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.ctg, WeshopSettingsActivity.class);
    this.ctg.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */