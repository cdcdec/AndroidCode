package com.laiqian.pos;

import android.view.View;
import android.widget.Toast;
import com.laiqian.sync.model.SyncProgessMessage;

class m implements View.OnClickListener {
  m(e parame) {}
  
  public void onClick(View paramView) {
    if (e.b(this.cfk) < e.c(this.cfk)) {
      Toast.makeText(e.d(this.cfk), "开始日期不能大于结束日期！", 0).show();
      e.e(this.cfk).setVisibility(0);
      return;
    } 
    e.f(this.cfk).apy().init();
    e.a(this.cfk, SyncProgessMessage.START);
    this.cfk.Zo();
    e.e(this.cfk).setVisibility(4);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */