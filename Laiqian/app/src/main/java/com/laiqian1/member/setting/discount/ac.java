package com.laiqian.member.setting.discount;

import android.view.View;
import android.widget.CheckBox;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class ac implements View.OnClickListener {
  ac(VipSettingFragment paramVipSettingFragment) {}
  
  public void onClick(View paramView) {
    if (((CheckBox)this.bDZ.bDX.bEc.dwV.getView()).isChecked()) {
      n.eP(R.string.member_online_switch_close_prompt);
      return;
    } 
    VipSettingFragment.e(this.bDZ).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */