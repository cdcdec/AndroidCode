package com.laiqian.pos.hardware;

import android.view.View;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.w;

class h implements View.OnClickListener {
  h(CustomerDisplaySettingActivity paramCustomerDisplaySettingActivity) {}
  
  public void onClick(View paramView) {
    ActivityRoot activityRoot = this.ckp.getActivity();
    String str1 = CustomerDisplaySettingActivity.a(this.ckp, 1);
    String str2 = CustomerDisplaySettingActivity.a(this.ckp, 2);
    i i = new i(this);
    (new w(activityRoot, new String[] { str1, str2 }, i)).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hardware\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */