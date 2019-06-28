package com.laiqian.barcode;

import com.google.zxing.Result;
import com.laiqian.basic.RootApplication;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

class a implements ZXingScannerView.a {
  a(BarcodeScannerActivity paramBarcodeScannerActivity) {}
  
  public void a(Result paramResult) {
    BarcodeScannerActivity.b(this.aIO).b(BarcodeScannerActivity.a(this.aIO));
    RootApplication.getLaiqianPreferenceManager().rF(paramResult.getText());
    this.aIO.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\barcode\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */