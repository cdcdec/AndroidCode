package com.laiqian.print.type;

import android.content.Intent;

class an implements Runnable {
  an(PrinterEditActivity paramPrinterEditActivity) {}
  
  public void run() {
    Intent intent = new Intent();
    intent.putExtra("selection", PrinterEditActivity.f(this.cKo));
    this.cKo.setResult(-1, intent);
    this.cKo.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */