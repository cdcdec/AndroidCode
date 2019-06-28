package com.laiqian.pos.settings;

import android.view.View;
import android.widget.Toast;
import com.laiqian.util.av;

class x implements View.OnClickListener {
  x(KitchenPrintSetting paramKitchenPrintSetting) {}
  
  public void onClick(View paramView) {
    av av = new av(this.czU);
    av.h("NOT_PRINT", KitchenPrintSetting.a(this.czU));
    av.close();
    Toast.makeText(this.czU, this.czU.getString(2131629874), 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */