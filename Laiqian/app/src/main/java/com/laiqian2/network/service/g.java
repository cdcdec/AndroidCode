package com.laiqian.network.service;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.bb;
import com.laiqian.util.bd;

class g extends Handler {
  g(DownloadOtaService paramDownloadOtaService) {}
  
  public void handleMessage(Message paramMessage) {
    bb.ao("收到oss发来的message");
    if (paramMessage.obj.toString().equals("download")) {
      Intent intent;
      if (paramMessage.arg2 != 0)
        this.bVV.progress = Double.valueOf((paramMessage.arg1 * 100 / paramMessage.arg2)).intValue(); 
      switch (paramMessage.what) {
        case 3:
          if (!DownloadOtaService.a(this.bVV)) {
            RemoteViews remoteViews = (DownloadOtaService.d(this.bVV)).contentView;
            int i = R.id.content_view_text1;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.bVV.getString(R.string.version_title_comprehensive));
            stringBuilder2.append(": ");
            stringBuilder2.append(this.bVV.progress);
            stringBuilder2.append("%");
            remoteViews.setTextViewText(i, stringBuilder2.toString());
            (DownloadOtaService.d(this.bVV)).contentView.setProgressBar(R.id.content_view_progress, 100, this.bVV.progress, false);
            if (this.bVV.progress == 100)
              (DownloadOtaService.d(this.bVV)).contentView.setTextViewText(R.id.content_view_text2, "下载成功"); 
            DownloadOtaService.b(this.bVV).notify(1, DownloadOtaService.d(this.bVV));
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("当前进度:");
            stringBuilder1.append(this.bVV.progress);
            stringBuilder1.append("%");
            bb.e("progress", stringBuilder1.toString());
            break;
          } 
          DownloadOtaService.b(this.bVV).cancel(0);
          break;
        case 2:
          DownloadOtaService.b(this.bVV).cancel(1);
          e.close();
          DownloadOtaService.c(this.bVV);
          bb.e("error", "合并出错，尝试重新下载中");
          break;
        case 1:
          null = new StringBuilder();
          null.append("sVersion=");
          null.append(this.bVV.bVU);
          Log.d("DownloadOtaService", null.toString());
          RootApplication.getLaiqianPreferenceManager().lX(Integer.parseInt(this.bVV.bVU));
          null = this.bVV.getPackageManager();
          new Intent();
          intent = null.getLaunchIntentForPackage("com.softwinner.update");
          if (intent != null) {
            Intent intent1 = new Intent("android.intent.action.VIEW");
            intent1.addFlags(268435456);
            intent1.setData(Uri.parse(RootUrlParameter.clB));
            this.bVV.startActivity(intent1);
            this.bVV.startActivity(intent);
          } 
          e.close();
          this.bVV.stopSelf();
          break;
        case 0:
          if (!DownloadOtaService.a(this.bVV))
            if (!bd.bH(this.bVV.getBaseContext())) {
              Toast.makeText(this.bVV.getBaseContext(), this.bVV.getString(R.string.pos_upgrade_network_err), 1000).show();
            } else {
              Toast.makeText(this.bVV.getBaseContext(), this.bVV.getString(R.string.pos_download_fails), 1000).show();
            }  
          DownloadOtaService.b(this.bVV).cancel(1);
          e.close();
          DownloadOtaService.c(this.bVV);
          bb.e("error", "尝试重新下载中");
          break;
      } 
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */