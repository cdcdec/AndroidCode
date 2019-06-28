package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.view.View;

class bt implements View.OnClickListener {
  bt(WeChatWeshopBindingActivity paramWeChatWeshopBindingActivity) {}
  
  public void onClick(View paramView) { this.cuf.startActivity(new Intent(this.cuf.getActivity(), com.laiqian.pos.industry.weiorder.auth.WechatAutoActivity.class)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */