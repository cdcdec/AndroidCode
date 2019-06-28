package com.laiqian.member.setting.discount;

import android.content.Intent;
import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class p implements View.OnClickListener {
  p(VipDiscountFragment paramVipDiscountFragment) {}
  
  public void onClick(View paramView) {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.o(this.bDQ.getString(R.string.vip_setting_can_not_edit));
      return;
    } 
    Intent intent = new Intent();
    intent.setClass(this.bDQ.context, RechargePrivilegeActivity.class);
    this.bDQ.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */