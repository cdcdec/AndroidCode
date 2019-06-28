package com.laiqian.version.view;

import android.content.Intent;
import android.os.Message;
import android.view.View;

class g implements View.OnClickListener {
  g(LegacyUpgradeAndEvaluate paramLegacyUpgradeAndEvaluate) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent();
    intent.setAction("android.intent.action.CloseDownloadService");
    intent.putExtra("bCloseService", true);
    this.dKa.sendBroadcast(intent);
    Message message = new Message();
    message.what = 1;
    this.dKa.dIl.sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */