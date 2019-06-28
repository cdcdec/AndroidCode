package com.laiqian.pos;

import android.view.View;
import com.laiqian.entity.v;

class at implements View.OnClickListener {
  at(PayTypeSettingActivity.a parama) {}
  
  public void onClick(View paramView) {
    PayTypeSettingActivity.a.a a1 = (PayTypeSettingActivity.a.a)paramView.getTag();
    v v = a1.cfS;
    a1.cfR.setSelected(v.FR());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */