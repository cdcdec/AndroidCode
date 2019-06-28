package com.laiqian.pos.settings;

import android.view.View;
import com.laiqian.entity.u;

class ak implements View.OnClickListener {
  ak(OrderTypeSettingActivity.a parama) {}
  
  public void onClick(View paramView) {
    u u = ((OrderTypeSettingActivity.a.a)paramView.getTag()).cAi;
    OrderTypeSettingActivity.a(this.cAg.cAf, u.FK());
    this.cAg.notifyDataSetChanged();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */