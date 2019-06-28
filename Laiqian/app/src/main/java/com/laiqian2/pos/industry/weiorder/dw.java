package com.laiqian.pos.industry.weiorder;

import android.widget.CompoundButton;
import android.widget.Toast;

class dw implements CompoundButton.OnCheckedChangeListener {
  dw(WeshopBindingFragment paramWeshopBindingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (paramBoolean) {
      if (this.cvz.cuc) {
        if (this.cvz.cue.cxZ == -1) {
          Toast.makeText(this.cvz.getContext(), "未认证订阅号无法新建菜单", 0).show();
          this.cvz.cvy.cuB.setChecked(false);
          return;
        } 
        (new h(this.cvz.getActivity(), new dx(this))).show();
        return;
      } 
      WeshopBindingFragment.a(this.cvz, true);
      return;
    } 
    WeshopBindingFragment.a(this.cvz, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */