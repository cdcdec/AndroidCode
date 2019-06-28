package com.laiqian.pos.industry.setting;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.util.bb;
import java.io.File;

class g extends Handler {
  g(a parama) {}
  
  public void handleMessage(Message paramMessage) {
    File file;
    switch (paramMessage.what) {
      case 8:
        a.g(this.csb);
        break;
      case 7:
        a.k(this.csb);
        break;
      case 6:
        bb.e("backup", Integer.valueOf(2131624366));
        Toast.makeText(a.f(this.csb), a.f(this.csb).getString(2131624829), 0).show();
        a.g(this.csb);
        break;
      case 5:
        bb.e("backup", "本地备份成功");
        a.j(this.csb);
        break;
      case 4:
        file = new File(a.i(this.csb));
        if (file.exists() && file.isDirectory()) {
          if (!file.canWrite())
            return; 
          Toast.makeText(a.f(this.csb), a.f(this.csb).getString(2131624346), 0).show();
          a.g(this.csb);
          break;
        } 
        return;
      case 3:
        a.h(this.csb);
        break;
      case 2:
        if (((Boolean)paramMessage.obj).booleanValue()) {
          bb.e("sync", "同步数据成功");
          a.e(this.csb);
          break;
        } 
        Toast.makeText(a.f(this.csb), a.f(this.csb).getString(2131624829), 0).show();
        bb.e("sync", "同步数据错误");
        a.g(this.csb);
        break;
      case 1:
        a.a(this.csb).setVisibility(0);
        a.a(this.csb).setText(a.b(this.csb));
        a.c(this.csb).setVisibility(8);
        a.d(this.csb).setVisibility(8);
        break;
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */