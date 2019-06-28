package com.laiqian.network.service;

import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.alipay.euler.andfix.patch.PatchManager;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.version.a;
import java.io.File;

class k extends Handler {
  k(DownloadPatchService paramDownloadPatchService) {}
  
  public void handleMessage(Message paramMessage) {
    bb.ao("收到oss发来的message");
    if (paramMessage.obj.toString().equals("download")) {
      if (paramMessage.arg2 != 0)
        this.bVZ.progress = Double.valueOf((paramMessage.arg1 * 100 / paramMessage.arg2)).intValue(); 
      if (this.bVZ.progress < 100)
        switch (paramMessage.what) {
          case 3:
            if (!DownloadPatchService.c(this.bVZ)) {
              int i = this.bVZ.progress;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("当前进度:");
              stringBuilder.append(this.bVZ.progress);
              stringBuilder.append("%");
              bb.e("progress", stringBuilder.toString());
            } 
            break;
          case 2:
            a.close();
            DownloadPatchService.d(this.bVZ);
            bb.e("error", "合并出错，尝试重新下载中");
            break;
          case 1:
            Log.d("euler", "apatch: added success.");
            try {
              RootApplication.getLaiqianPreferenceManager().rz(this.bVZ.bVU);
              DownloadPatchService.a(this.bVZ, new PatchManager(this.bVZ.getApplicationContext()));
              DownloadPatchService.a(this.bVZ, new a(this.bVZ.getApplicationContext()));
              DownloadPatchService.a(this.bVZ).removeAllPatch();
              null = this.bVZ.getPackageManager().getPackageInfo(this.bVZ.getPackageName(), 0);
              DownloadPatchService.b(this.bVZ).init(null.versionName);
              DownloadPatchService.b(this.bVZ).loadPatch();
              String str = this.bVZ.bVO;
              if ((new File(str)).exists())
                DownloadPatchService.b(this.bVZ).addPatch(str); 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("apatch:");
              stringBuilder.append(str);
              stringBuilder.append(" added.");
              Log.d("euler", stringBuilder.toString());
            } catch (Exception exception) {
              a.e(exception);
            } 
            a.close();
            this.bVZ.stopSelf();
            break;
          case 0:
            if (!DownloadPatchService.c(this.bVZ))
              if (!bd.bH(this.bVZ.getBaseContext())) {
                Toast.makeText(this.bVZ.getBaseContext(), this.bVZ.getString(R.string.pos_upgrade_network_err), 1000).show();
              } else {
                Toast.makeText(this.bVZ.getBaseContext(), this.bVZ.getString(R.string.pos_download_fails), 1000).show();
              }  
            a.close();
            DownloadPatchService.d(this.bVZ);
            bb.e("error", "尝试重新下载中");
            break;
        }  
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */