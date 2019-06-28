package com.laiqian.auth;

import android.os.Handler;
import android.os.Message;

class aa extends Handler {
  aa(ModifyUserPasswordDialog paramModifyUserPasswordDialog) {}
  
  public void handleMessage(Message paramMessage) {
    if (!"".equals(String.valueOf(paramMessage.obj))) {
      if (ModifyUserPasswordDialog.a(this.aEe).hasFocus()) {
        ModifyUserPasswordDialog.a(this.aEe).setText(String.valueOf(paramMessage.obj));
        ModifyUserPasswordDialog.a(this.aEe).requestFocus();
        return;
      } 
      if (ModifyUserPasswordDialog.b(this.aEe).hasFocus()) {
        ModifyUserPasswordDialog.b(this.aEe).setText(String.valueOf(paramMessage.obj));
        ModifyUserPasswordDialog.b(this.aEe).requestFocus();
        return;
      } 
      if (ModifyUserPasswordDialog.c(this.aEe).hasFocus()) {
        ModifyUserPasswordDialog.c(this.aEe).setText(String.valueOf(paramMessage.obj));
        ModifyUserPasswordDialog.c(this.aEe).requestFocus();
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */