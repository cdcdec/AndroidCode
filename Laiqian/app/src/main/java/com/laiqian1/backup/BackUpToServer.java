package com.laiqian.backup;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import io.reactivex.g.a;

public class BackUpToServer extends Activity {
  private ProgressDialog aIw = null;
  
  private boolean aIx = false;
  
  Handler aIy = new af(this);
  
  private void xb() {}
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131427862);
    xb();
    this.aIw = ProgressDialog.show(this, getString(2131626230), getString(2131627375));
    this.aIw.setCancelable(true);
    ae ae = new ae(this);
    a.aKh().r(ae);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\BackUpToServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */