package com.laiqian.barcode;

import android.os.Bundle;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.ActivityRoot;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class BarcodeScannerActivity extends ActivityRoot {
  private boolean aIL;
  
  private ZXingScannerView aIM;
  
  private ZXingScannerView.a aIN = new a(this);
  
  private void ze() {
    this.aIL ^= true;
    this.aIM.jc(this.aIL);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetNoTitle(R.layout.activity_barcode_scanner);
    this.aIM = (ZXingScannerView)findViewById(R.id.scannerView);
    this.aIM.a(this.aIN);
    findViewById(R.id.light).setOnClickListener(new b(this));
  }
  
  public void onPause() {
    super.onPause();
    this.aIM.aQU();
  }
  
  public void onResume() {
    super.onResume();
    this.aIM.a(this.aIN);
    this.aIM.aQT();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\barcode\BarcodeScannerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */