package com.laiqian.pos.settings;

import android.view.View;
import com.laiqian.entity.u;

class al implements View.OnClickListener {
  al(OrderTypeSettingActivity.a parama) {}
  
  public void onClick(View paramView) {
    u u = ((OrderTypeSettingActivity.a.a)paramView.getTag()).cAi;
    OrderTypeSettingActivity.e(this.cAg.cAf).w(u.FK(), u.FM());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */