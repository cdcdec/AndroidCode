package com.laiqian.pos.industry.weiorder;

import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.util.n;

class dr implements w.a {
  dr(WeshopBindingFragment paramWeshopBindingFragment) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        WeshopBindingFragment.c(this.cvz);
        return;
      case 0:
        break;
    } 
    FragmentActivity fragmentActivity = this.cvz.getActivity();
    paramInt = 1;
    if (n.a(fragmentActivity, true).size() == 0)
      paramInt = 0; 
    if (paramInt == 0) {
      Toast.makeText(this.cvz.getActivity(), this.cvz.getString(2131627158), 0).show();
      return;
    } 
    if (WeshopBindingFragment.b(this.cvz)) {
      Toast.makeText(this.cvz.getActivity(), this.cvz.getString(2131627880), 0).show();
    } else {
      Toast.makeText(this.cvz.getActivity(), this.cvz.getString(2131626749), 0).show();
    } 
    this.cvz.cjN.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\dr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */