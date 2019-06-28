package com.laiqian.member.setting.discount;

import android.view.View;
import com.laiqian.entity.h;

class b implements View.OnClickListener {
  b(RechargePrivilegeActivity.b paramb) {}
  
  public void onClick(View paramView) {
    h h = (h)((RechargePrivilegeActivity.b.a)paramView.getTag()).bDs.getTag();
    RechargePrivilegeActivity.d(this.bDq.bDm).b(h);
    if (this.bDq.bDm.context != null && !this.bDq.bDm.isFinishing())
      RechargePrivilegeActivity.d(this.bDq.bDm).show(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */