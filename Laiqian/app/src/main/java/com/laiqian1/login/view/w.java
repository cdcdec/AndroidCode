package com.laiqian.login.view;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.laiqian.sync.model.i;
import com.laiqian.util.bb;

class w extends Handler {
  w(LoginActivity paramLoginActivity) {}
  
  public void handleMessage(Message paramMessage) {
    bb.fU("登录过程失败.开始更新失败界面的UI ");
    LoginActivity.i(this.aZD).apy().gW(false);
    if (paramMessage.obj != null && paramMessage.obj instanceof i) {
      i i = (i)paramMessage.obj;
      TextView textView = this.aZD.aZg.aZO;
      LoginActivity loginActivity = this.aZD;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i.apI());
      stringBuilder.append("");
      textView.setText(loginActivity.eH(stringBuilder.toString()));
    } else {
      this.aZD.aZg.aZO.setText(this.aZD.getString(2131626844));
    } 
    LoginActivity.i(this.aZD).apz().init();
    LoginActivity.i(this.aZD).apx().init();
    this.aZD.hideProgress();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */