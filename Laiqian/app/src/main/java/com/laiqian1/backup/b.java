package com.laiqian.backup;

import android.content.Intent;
import android.view.View;

class b implements View.OnClickListener {
  b(BackUpRootActivity paramBackUpRootActivity) {}
  
  public void onClick(View paramView) {
    if (this.aHq.aGO == this.aHq.aGP) {
      Intent intent = new Intent();
      intent.setClass(this.aHq, BackUpSetting.class);
      this.aHq.startActivity(intent);
      return;
    } 
    BackUpRootActivity.f(this.aHq);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */