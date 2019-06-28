package com.laiqian.pos.industry.weiorder;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.laiqian.ui.a.w;

class cu implements View.OnClickListener {
  cu(WeiOrderSettingFragment paramWeiOrderSettingFragment) {}
  
  public void onClick(View paramView) {
    FragmentActivity fragmentActivity = this.cuP.getActivity();
    String str1 = this.cuP.getString(2131630488);
    String str2 = this.cuP.getString(2131630487);
    cv cv = new cv(this);
    (new w(fragmentActivity, new String[] { str1, str2 }, cv)).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */