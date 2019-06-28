package com.laiqian.member.setting.discount;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class q implements CompoundButton.OnCheckedChangeListener {
  q(VipDiscountFragment paramVipDiscountFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.o(this.bDQ.getString(R.string.vip_setting_can_not_edit));
      if (a.AZ().Bs() != paramBoolean)
        ((CheckBox)this.bDQ.bDJ.bDS.dwV.getView()).setChecked(a.AZ().Bs()); 
      return;
    } 
    VipDiscountFragment.a(this.bDQ, paramBoolean);
    a.AZ().bM(paramBoolean);
    this.bDQ.bDK.dT(false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */