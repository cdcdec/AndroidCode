package com.laiqian.login.a;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.util.bb;

class p extends Handler {
  p(b paramb) {}
  
  public void handleMessage(Message paramMessage) {
    byte b1;
    super.handleMessage(paramMessage);
    String str = (String)paramMessage.obj;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" BackUp result is ");
    stringBuilder.append(str);
    bb.e("_Sync", stringBuilder.toString());
    switch (str.hashCode()) {
      default:
        b1 = -1;
        break;
      case 50:
        if (str.equals("2")) {
          b1 = 1;
          break;
        } 
      case 49:
        if (str.equals("1")) {
          b1 = 0;
          break;
        } 
    } 
    switch (b1) {
      default:
        return;
      case 1:
        Toast.makeText(b.b(this.aXX), b.b(this.aXX).getString(2131628457), 0).show();
        return;
      case 0:
        break;
    } 
    Intent intent = new Intent(b.b(this.aXX), com.laiqian.network.service.DownloadApkService.class);
    intent.setPackage(b.b(this.aXX).getPackageName());
    intent.putExtra("sApkFileName", b.m(this.aXX));
    intent.putExtra("sApkDir", b.n(this.aXX));
    intent.putExtra("bCloseService", false);
    b.b(this.aXX).startService(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */