package com.laiqian.main.module.misc;

import android.content.Intent;
import com.google.a.a.a.a.a.a;
import com.laiqian.ui.a.r;

class o implements r.a {
  o(PosActivityMoreSettingsFragment paramPosActivityMoreSettingsFragment) {}
  
  public void xD() {}
  
  public void xE() {
    try {
      Intent intent = new Intent();
      intent.setClass(this.bgP.getActivity(), com.laiqian.pos.PosDownloaderAfterLogin.class);
      intent.putExtra("SyncIntentExtraName", 3);
      this.bgP.startActivity(intent);
    } catch (Exception exception) {
      a.e(exception);
    } 
    this.bgP.getActivity().finish();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\misc\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */