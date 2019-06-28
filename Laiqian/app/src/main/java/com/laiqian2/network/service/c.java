package com.laiqian.network.service;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.laiqian.backup.ag;
import com.laiqian.infrastructure.R;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import hugo.weaving.DebugLog;

class c extends Handler {
  c(DownloadApkService paramDownloadApkService) {}
  
  @DebugLog
  public void handleMessage(Message paramMessage) {
    bb.ao("收到oss发来的message");
    if (paramMessage.obj.toString().equals("download")) {
      String str;
      if (paramMessage.arg2 != 0)
        this.bVQ.progress = Double.valueOf((paramMessage.arg1 * 100 / paramMessage.arg2)).intValue(); 
      Intent intent = new Intent();
      intent.setAction("android.intent.action.DOWNLOAD_RECEIVER");
      if (this.bVQ.progress < 100)
        intent.putExtra("progress", this.bVQ.progress); 
      switch (paramMessage.what) {
        case 3:
          if (!DownloadApkService.b(this.bVQ)) {
            RemoteViews remoteViews = (DownloadApkService.d(this.bVQ)).contentView;
            int i = R.id.content_view_text1;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.bVQ.getString(R.string.version_title_comprehensive));
            stringBuilder2.append(": ");
            stringBuilder2.append(this.bVQ.progress);
            stringBuilder2.append("%");
            remoteViews.setTextViewText(i, stringBuilder2.toString());
            (DownloadApkService.d(this.bVQ)).contentView.setProgressBar(R.id.content_view_progress, 100, this.bVQ.progress, false);
            if (this.bVQ.progress == 100) {
              intent.putExtra("progress", 99);
              (DownloadApkService.d(this.bVQ)).contentView.setTextViewText(R.id.content_view_text2, "下载成功");
            } 
            DownloadApkService.a(this.bVQ).notify(0, DownloadApkService.d(this.bVQ));
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("当前进度:");
            stringBuilder1.append(this.bVQ.progress);
            stringBuilder1.append("%");
            bb.e("progress", stringBuilder1.toString());
            this.bVQ.sendBroadcast(intent);
            break;
          } 
          DownloadApkService.a(this.bVQ).cancel(0);
          break;
        case 2:
          DownloadApkService.a(this.bVQ).cancel(0);
          a.close();
          DownloadApkService.c(this.bVQ);
          intent.putExtra("sDownloadStatus", false);
          bb.e("error", "合并出错，尝试重新下载中");
          break;
        case 1:
          intent.putExtra("progress", 100);
          DownloadApkService.a(this.bVQ).cancel(0);
          if (TextUtils.isEmpty(ag.aIA))
            throw new IllegalStateException("encryptedFileName为空, 下载前的备份没有触发"); 
          str = ag.aIA.substring(ag.aIA.lastIndexOf("/") + 1);
          str = ag.i(this.bVQ.getApplicationContext(), str);
          if (this.bVQ.getString(R.string.backup_load_file_success).equals(str)) {
            intent.putExtra("unzip", true);
            av av = new av(this.bVQ.getApplicationContext());
            av.hw(false);
            av.close();
          } else {
            intent.putExtra("unzip", false);
          } 
          intent.putExtra("sDownloadStatus", true);
          if (!DownloadApkService.b(this.bVQ))
            this.bVQ.sendBroadcast(intent); 
          a.close();
          this.bVQ.stopSelf();
          break;
        case 0:
          if (!DownloadApkService.b(this.bVQ))
            if (!bd.bH(this.bVQ.getBaseContext())) {
              Toast.makeText(this.bVQ.getBaseContext(), this.bVQ.getString(R.string.pos_upgrade_network_err), 1000).show();
            } else {
              Toast.makeText(this.bVQ.getBaseContext(), this.bVQ.getString(R.string.pos_download_fails), 1000).show();
            }  
          DownloadApkService.a(this.bVQ).cancel(0);
          a.close();
          DownloadApkService.c(this.bVQ);
          intent.putExtra("sDownloadStatus", false);
          bb.e("error", "尝试重新下载中");
          break;
      } 
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */