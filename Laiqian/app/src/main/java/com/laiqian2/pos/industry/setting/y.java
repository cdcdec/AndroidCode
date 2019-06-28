package com.laiqian.pos.industry.setting;

import android.view.View;
import android.widget.Toast;
import com.laiqian.sync.model.SyncProgessMessage;

class y implements View.OnClickListener {
  y(n paramn) {}
  
  public void onClick(View paramView) {
    if (n.a(this.csf) < n.b(this.csf)) {
      Toast.makeText(n.c(this.csf), "开始日期不能大于结束日期！", 0).show();
      n.d(this.csf).setVisibility(0);
      return;
    } 
    MainSetting.setDownloadStatus(true);
    n.e(this.csf).apy().init();
    n.a(this.csf, SyncProgessMessage.START);
    this.csf.Zo();
    n.d(this.csf).setVisibility(4);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */