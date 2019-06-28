package com.laiqian.pos;

import android.view.View;
import com.laiqian.entity.v;

class au implements View.OnClickListener {
  au(PayTypeSettingActivity.a parama) {}
  
  public void onClick(View paramView) {
    v v = ((PayTypeSettingActivity.a.a)paramView.getTag()).cfS;
    PayTypeSettingActivity.g(this.cfQ.cfN).a(v.aSW, v.name, PayTypeSettingActivity.a.b(this.cfQ));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */