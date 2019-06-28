package com.laiqian.LockScreen;

import android.view.View;

class h implements View.OnClickListener {
  h(LockScreenService paramLockScreenService) {}
  
  public void onClick(View paramView) {
    int i = this.aAp.azW.getSelectionStart();
    if (i > 0)
      this.aAp.azW.getText().delete(i - 1, i); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\LockScreen\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */