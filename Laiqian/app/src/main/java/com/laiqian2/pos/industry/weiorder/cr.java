package com.laiqian.pos.industry.weiorder;

import android.widget.Toast;

class cr implements Runnable {
  cr(WeChatWeshopBindingActivity.b paramb, boolean paramBoolean) {}
  
  public void run() {
    if (this.cuG.cuf.getActivity() == null)
      return; 
    if (this.cuF) {
      Toast.makeText(this.cuG.cuf.getActivity(), this.cuG.cuf.getString(2131626752), 0).show();
      this.cuG.cuf.cjN.dismiss();
      return;
    } 
    Toast.makeText(this.cuG.cuf.getActivity(), this.cuG.cuf.getString(2131626749), 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */