package com.laiqian.repair;

import android.os.Handler;
import android.os.Message;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.models.at;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.n;

class i extends Handler {
  i(f paramf) {}
  
  public void handleMessage(Message paramMessage) {
    StringBuilder stringBuilder;
    ActivityRoot activityRoot;
    f.d(this.cYd).cancel();
    f.b(this.cYd).cancel();
    f.a(this.cYd, false);
    switch (paramMessage.what) {
      default:
        return;
      case 1:
        if (paramMessage.arg1 == 119007) {
          at at = new at(RootApplication.zv());
          at.ep(false);
          at.close();
        } 
        if (paramMessage.obj == null) {
          n.w(this.cYd.mActivity, R.string.pos_repair_self_repairing_suc);
          this.cYd.a(f.a(this.cYd), true);
          return;
        } 
        activityRoot = this.cYd.mActivity;
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramMessage.obj);
        stringBuilder.append("");
        n.a(activityRoot, stringBuilder.toString());
        this.cYd.a(f.a(this.cYd), false);
        break;
      case 0:
        break;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repair\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */