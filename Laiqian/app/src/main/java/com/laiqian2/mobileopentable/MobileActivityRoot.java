package com.laiqian.mobileopentable;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

public class MobileActivityRoot extends AppCompatActivity {
  public MobileActivityRoot Uq() { return this; }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setRequestedOrientation();
    t.aL(this);
  }
  
  protected void onResume() { super.onResume(); }
  
  protected void setContentViewSetNoTitle(@LayoutRes int paramInt) {
    requestWindowFeature(1);
    setContentView(paramInt);
  }
  
  public void setRequestedOrientation() {
    if (Build.VERSION.SDK_INT >= 9) {
      setRequestedOrientation(7);
      return;
    } 
    setRequestedOrientation(1);
  }
  
  public void setRequestedOrientation(int paramInt) { super.setRequestedOrientation(paramInt); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\MobileActivityRoot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */