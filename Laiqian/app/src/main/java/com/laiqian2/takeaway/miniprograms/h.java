package com.laiqian.takeaway.miniprograms;

import android.widget.Toast;
import com.laiqian.takeaway.R;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.util.n;

class h implements w.a {
  h(g paramg) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    WechatMiniProgramsActivity wechatMiniProgramsActivity;
    switch (paramInt) {
      default:
        return;
      case 1:
        wechatMiniProgramsActivity = this.duh.duf;
        n = this.duh.duf.due;
        WechatMiniProgramsActivity.b(wechatMiniProgramsActivity, n.duv);
        return;
      case 0:
        break;
    } 
    ActivityRoot activityRoot = this.duh.duf.getActivity();
    paramInt = 1;
    if (n.a(activityRoot, true).size() == 0)
      paramInt = 0; 
    if (paramInt == 0) {
      Toast.makeText(this.duh.duf.getActivity(), this.duh.duf.getString(R.string.pos_no_udisk_tip), 0).show();
      return;
    } 
    activityRoot = this.duh.duf;
    n n = this.duh.duf.due;
    if (WechatMiniProgramsActivity.a(activityRoot, n.duv)) {
      Toast.makeText(this.duh.duf.getActivity(), this.duh.duf.getString(R.string.pos_report_export_u_suc), 0).show();
    } else {
      Toast.makeText(this.duh.duf.getActivity(), this.duh.duf.getString(R.string.pos_export_fail), 0).show();
    } 
    this.duh.duf.cjN.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\miniprograms\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */