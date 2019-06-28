package com.laiqian.takeaway.miniprograms;

import android.view.View;
import com.laiqian.takeaway.R;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.w;

class g implements View.OnClickListener {
  g(WechatMiniProgramsActivity paramWechatMiniProgramsActivity) {}
  
  public void onClick(View paramView) {
    WechatMiniProgramsActivity wechatMiniProgramsActivity = this.duf;
    ActivityRoot activityRoot = this.duf.getActivity();
    String str1 = this.duf.getString(R.string.pos_report_export_to_u);
    String str2 = this.duf.getString(R.string.pos_report_export_to_mail);
    h h = new h(this);
    wechatMiniProgramsActivity.cjN = new w(activityRoot, new String[] { str1, str2 }, h, false);
    this.duf.cjN.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\miniprograms\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */