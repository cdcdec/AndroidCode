package com.laiqian;

import android.content.Intent;
import android.view.View;

class w implements View.OnClickListener {
  w(o paramo) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.aBa.getContext(), com.laiqian.barcode.BarcodeScannerActivity.class);
    this.aBa.getContext().startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */