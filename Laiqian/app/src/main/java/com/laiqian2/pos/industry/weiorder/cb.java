package com.laiqian.pos.industry.weiorder;

import android.widget.Toast;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.util.n;

class cb implements w.a {
  cb(WeChatWeshopBindingActivity paramWeChatWeshopBindingActivity) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        WeChatWeshopBindingActivity.d(this.cuf);
        return;
      case 0:
        break;
    } 
    ActivityRoot activityRoot = this.cuf.getActivity();
    paramInt = 1;
    if (n.a(activityRoot, true).size() == 0)
      paramInt = 0; 
    if (paramInt == 0) {
      Toast.makeText(this.cuf.getActivity(), this.cuf.getString(2131627158), 0).show();
      return;
    } 
    if (WeChatWeshopBindingActivity.c(this.cuf)) {
      Toast.makeText(this.cuf.getActivity(), this.cuf.getString(2131627880), 0).show();
    } else {
      Toast.makeText(this.cuf.getActivity(), this.cuf.getString(2131626749), 0).show();
    } 
    this.cuf.cjN.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */