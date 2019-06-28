package com.laiqian.pos.industry.weiorder;

import android.widget.CompoundButton;
import android.widget.Toast;

class cl implements CompoundButton.OnCheckedChangeListener {
  cl(WeChatWeshopBindingActivity paramWeChatWeshopBindingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (paramBoolean) {
      if (this.cuf.cuc) {
        if (this.cuf.cue == null)
          return; 
        if (this.cuf.cue != null && this.cuf.cue.cxZ == -1) {
          Toast.makeText(this.cuf, "未认证订阅号无法新建菜单", 0).show();
          this.cuf.cua.cuB.setChecked(false);
          return;
        } 
        (new h(this.cuf.getActivity(), new cm(this))).show();
        return;
      } 
      WeChatWeshopBindingActivity.a(this.cuf, true);
      return;
    } 
    WeChatWeshopBindingActivity.a(this.cuf, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */