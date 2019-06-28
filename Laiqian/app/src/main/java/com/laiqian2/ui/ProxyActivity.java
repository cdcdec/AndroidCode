package com.laiqian.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ProxyActivity extends Activity {
  private static final Class<? extends Activity> dwC = com.laiqian.milestone.StartScreen.class;
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if ((getIntent().getFlags() & 0x400000) != 0) {
      finish();
      return;
    } 
    startActivity(new Intent(this, dwC));
    finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\ProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */