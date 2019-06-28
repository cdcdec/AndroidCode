package com.laiqian.takeaway.miniprograms;

import android.widget.CompoundButton;
import com.laiqian.d.a;

class e implements CompoundButton.OnCheckedChangeListener {
  e(WechatMiniProgramsActivity paramWechatMiniProgramsActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    a.AZ().cq(paramBoolean);
    if (paramBoolean) {
      this.duf.due.aqF();
      this.duf.dud.dup.setVisibility(0);
      return;
    } 
    this.duf.dud.dup.setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\miniprograms\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */