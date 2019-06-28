package com.laiqian.version;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.util.bb;

class i extends Handler {
  i(UpgradeAndEvaluate paramUpgradeAndEvaluate) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    Intent intent = (String)paramMessage.obj;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" BackUp result is ");
    stringBuilder.append(intent);
    bb.e("_Sync", stringBuilder.toString());
    if (intent.equals("1")) {
      intent = new Intent(this.dIp, com.laiqian.network.service.DownloadApkService.class);
      intent.putExtra("sApkFileName", this.dIp.aXP);
      intent.putExtra("sApkDir", this.dIp.aXQ);
      intent.putExtra("bCloseService", false);
      this.dIp.startService(intent);
      return;
    } 
    if (intent.equals("0"))
      return; 
    if (intent.equals("2"))
      Toast.makeText(this.dIp, this.dIp.getString(R.string.pos_upgrade_sdcard_size_lack), 1000).show(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */