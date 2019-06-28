package com.laiqian.pos.settings;

import android.view.View;
import com.laiqian.util.bb;

class w implements View.OnClickListener {
  w(KitchenPrintSetting paramKitchenPrintSetting) {}
  
  public void onClick(View paramView) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("listNotPrint=");
    stringBuilder.append(KitchenPrintSetting.a(this.czU));
    bb.ao(stringBuilder.toString());
    this.czU.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */