package com.laiqian.login.a;

import android.view.View;
import android.widget.Toast;
import com.laiqian.util.bd;
import com.laiqian.util.ch;
import com.umeng.analytics.MobclickAgent;

class n implements View.OnClickListener {
  n(b paramb) {}
  
  public void onClick(View paramView) {
    MobclickAgent.onEvent(b.b(this.aXX), "update_app", "in_login");
    if (!bd.bH(b.b(this.aXX))) {
      Toast.makeText(b.b(this.aXX), 2131628452, 0).show();
      return;
    } 
    b.a(this.aXX);
    ch.a(b.b(this.aXX), b.i(this.aXX));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */