package com.laiqian.backup;

import android.view.View;

class w implements View.OnClickListener {
  w(BackUpSetting paramBackUpSetting) {}
  
  public void onClick(View paramView) { BackUpSetting.i(this.aIb).setChecked(BackUpSetting.i(this.aIb).isChecked() ^ true); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */