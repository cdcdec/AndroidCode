package com.laiqian.wallet;

import com.laiqian.ui.webview.SimpleWebViewActivity;

public class WalletRecord extends SimpleWebViewActivity {
  public void onBackPressed() { super.onBackPressed(); }
  
  protected String zG() {
    if (getIntent().getBooleanExtra("isTransaction", true)) {
      int j = R.string.pos_wallet_detailed;
      return getString(j);
    } 
    int i = R.string.pos_wallet_reflect_record;
    return getString(i);
  }
  
  protected String zH() { return k.ia(getIntent().getBooleanExtra("isTransaction", true)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\WalletRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */