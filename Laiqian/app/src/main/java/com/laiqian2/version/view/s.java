package com.laiqian.version.view;

import android.view.View;

class s implements View.OnClickListener {
  s(ReplyActivity paramReplyActivity) {}
  
  public void onClick(View paramView) {
    boolean bool;
    String str = this.dKl.qY.getText().toString().trim();
    if ("".equals(str) || str == null) {
      this.dKl.sq("请输入内容，再提交");
      bool = false;
    } else {
      bool = true;
    } 
    if (bool)
      this.dKl.dKk.sn(str); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */