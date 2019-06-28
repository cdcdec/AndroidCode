package com.laiqian.backup;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class i extends Handler {
  i(BackUpRootActivity paramBackUpRootActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.obj.equals("start")) {
      BackUpRootActivity.h(this.aHq).setVisibility(0);
      this.aHq.aGF.setText("");
      this.aHq.aGF.setClickable(false);
    } 
    if (paramMessage.obj.equals("fail")) {
      Toast.makeText(this.aHq, this.aHq.getString(2131624366), 1).show();
      this.aHq.aGF.setClickable(true);
      BackUpRootActivity.h(this.aHq).setVisibility(8);
      this.aHq.aGF.setText(2131624361);
    } 
    if (paramMessage.obj.equals("success")) {
      this.aHq.aGF.setClickable(true);
      BackUpRootActivity.h(this.aHq).setVisibility(8);
      this.aHq.aGF.setText(2131624361);
      BackUpRootActivity.f(this.aHq);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */