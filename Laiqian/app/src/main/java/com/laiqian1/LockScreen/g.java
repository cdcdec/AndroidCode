package com.laiqian.LockScreen;

import android.view.View;

class g implements View.OnClickListener {
  g(LockScreenService paramLockScreenService) {}
  
  public void onClick(View paramView) {
    int i = this.aAp.azW.getSelectionStart();
    this.aAp.azW.getText().insert(i, paramView.getTag().toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\LockScreen\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */