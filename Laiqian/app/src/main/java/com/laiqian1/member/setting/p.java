package com.laiqian.member.setting;

import com.laiqian.models.ab;
import com.laiqian.ui.container.LayoutLeftTextRightTextWithDialog;
import com.laiqian.vip.R;

class p implements LayoutLeftTextRightTextWithDialog.b {
  p(VipBasicInfoFragment.a parama) {}
  
  public void h(int paramInt, String paramString) {
    if (paramInt == 0) {
      this.bBV.dS(true);
      this.bBV.bBQ.oX(this.bBV.bBT.getString(R.string.pos_vip_dicount_title));
      VipBasicInfoFragment.a(this.bBV.bBT).dN(true);
      return;
    } 
    this.bBV.dS(false);
    this.bBV.bBQ.oX(this.bBV.bBT.getString(R.string.pos_vip_price));
    VipBasicInfoFragment.a(this.bBV.bBT).dN(false);
    ab ab = new ab(this.bBV.bBT.getActivity());
    ab.Vh();
    ab.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */