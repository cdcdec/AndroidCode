package com.laiqian.backup;

import android.view.View;
import com.laiqian.util.av;

class v implements View.OnClickListener {
  v(BackUpSetting paramBackUpSetting) {}
  
  public void onClick(View paramView) {
    av av = new av(this.aIb);
    if (av.atA()) {
      av.ho(false);
    } else {
      av.ho(true);
    } 
    BackUpSetting.h(this.aIb);
    av.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */