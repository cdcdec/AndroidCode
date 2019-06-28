package com.laiqian.auth;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.i.d;
import com.laiqian.models.at;

class ah extends Handler {
  ah(PrivilegeLimitActivity paramPrivilegeLimitActivity) {}
  
  public void handleMessage(Message paramMessage) {
    PrivilegeLimitActivity.a(this.aEm).apy().gW(false);
    boolean bool = ((Boolean)paramMessage.obj).booleanValue();
    if (PrivilegeLimitActivity.b(this.aEm) != null) {
      PrivilegeLimitActivity.b(this.aEm).dismiss();
      PrivilegeLimitActivity.a(this.aEm, null);
    } 
    if (bool) {
      Toast.makeText(this.aEm, this.aEm.getString(2131629905), 0).show();
      this.aEm.finish();
    } else {
      String str = d.ac(PrivilegeLimitActivity.c(this.aEm));
      at at = new at(this.aEm);
      bool = at.an(PrivilegeLimitActivity.d(this.aEm), str);
      at.close();
      if (bool) {
        Toast.makeText(this.aEm, this.aEm.getString(2131629498), 0).show();
      } else {
        Toast.makeText(this.aEm, this.aEm.getString(2131629904), 0).show();
      } 
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */