package com.laiqian.version.view;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.network.service.a;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.util.ch;
import com.umeng.analytics.MobclickAgent;

class f implements View.OnClickListener {
  f(LegacyUpgradeAndEvaluate paramLegacyUpgradeAndEvaluate) {}
  
  public void onClick(View paramView) {
    MobclickAgent.onEvent(this.dKa, "update_app", "in_setting");
    if (!bd.bH(this.dKa)) {
      Toast.makeText(this.dKa, R.string.pos_upgrade_network_err, 0).show();
      return;
    } 
    if (!ch.L(this.dKa, "com.laiqian.network.service.DownloadApkService")) {
      bb.ao("服务已经停止了");
      a.close();
      ch.a(this.dKa, this.dKa.aIy);
    } else {
      Intent intent = new Intent();
      intent.setAction("android.intent.action.CloseDownloadService");
      intent.putExtra("bCloseService", false);
      this.dKa.sendBroadcast(intent);
    } 
    this.dKa.progress = 0;
    Message message = new Message();
    message.what = 3;
    this.dKa.dIl.sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */