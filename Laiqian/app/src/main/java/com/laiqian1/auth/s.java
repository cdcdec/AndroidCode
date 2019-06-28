package com.laiqian.auth;

import android.os.Handler;
import android.os.Message;

class s extends Handler {
  s(CreateEmployeeDialog paramCreateEmployeeDialog) {}
  
  public void handleMessage(Message paramMessage) {
    if (!"".equals(String.valueOf(paramMessage.obj))) {
      CreateEmployeeDialog.a(this.aDT).setText(String.valueOf(paramMessage.obj));
      if (CreateEmployeeDialog.a(this.aDT).hasFocus())
        CreateEmployeeDialog.a(this.aDT).requestFocus(); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */