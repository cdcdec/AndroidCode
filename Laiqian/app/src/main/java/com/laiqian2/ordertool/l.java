package com.laiqian.ordertool;

import android.content.Intent;
import android.view.View;

class l implements View.OnClickListener {
  l(ServerTest paramServerTest) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent();
    intent.setClass(this.cdO, com.laiqian.main.PosActivity.class);
    this.cdO.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */