package com.laiqian.member.setting.discount;

import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.models.ab;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.vip.R;

class u implements w.a {
  u(VipDiscountFragment paramVipDiscountFragment) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    if (paramInt == 0) {
      ((ViewGroup)this.bDQ.bDJ.bDR.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
      VipDiscountFragment.b(this.bDQ, true);
      ((TextView)this.bDQ.bDJ.bDR.cAP.getView()).setText(this.bDQ.getString(R.string.pos_vip_dicount_title));
      a.AZ().bP(true);
      this.bDQ.bDL.gn(0);
    } else {
      ((ViewGroup)this.bDQ.bDJ.bDR.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
      VipDiscountFragment.b(this.bDQ, false);
      ((TextView)this.bDQ.bDJ.bDR.cAP.getView()).setText(this.bDQ.getString(R.string.pos_vip_price));
      a.AZ().bP(false);
      ab ab = new ab(this.bDQ.getActivity());
      ab.Vh();
      ab.close();
      this.bDQ.bDL.gn(1);
    } 
    this.bDQ.bDK.dT(false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discoun\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */