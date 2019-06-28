package com.laiqian.version.view;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.util.ch;
import java.util.HashMap;

class j extends Handler {
  j(LegacyUpgradeAndEvaluate paramLegacyUpgradeAndEvaluate) {}
  
  public void handleMessage(Message paramMessage) {
    HashMap hashMap = (HashMap)paramMessage.obj;
    if (ch.F(this.dKa, LegacyUpgradeAndEvaluate.c(this.dKa))) {
      Toast.makeText(this.dKa.getBaseContext(), this.dKa.getString(R.string.pos_find_new_version_please_download), 0).show();
      LegacyUpgradeAndEvaluate.d(this.dKa);
      return;
    } 
    LegacyUpgradeAndEvaluate.e(this.dKa);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */