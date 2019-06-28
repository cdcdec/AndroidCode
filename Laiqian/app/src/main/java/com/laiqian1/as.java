package com.laiqian;

import android.content.Intent;
import android.view.View;

class as implements View.OnClickListener {
  as(ag paramag) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.aBv.getContext(), com.laiqian.barcode.BarcodeScannerActivity.class);
    this.aBv.getContext().startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */