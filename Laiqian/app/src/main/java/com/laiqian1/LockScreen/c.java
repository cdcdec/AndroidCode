package com.laiqian.LockScreen;

import android.view.View;
import android.widget.Toast;
import com.laiqian.util.av;

class c implements View.OnClickListener {
  c(LockScreenManage paramLockScreenManage) {}
  
  public void onClick(View paramView) {
    av av = new av(this.azR);
    if (LockScreenManage.d(this.azR).isChecked()) {
      String str = LockScreenManage.c(this.azR).getText().toString().trim();
      if (str.length() == 4) {
        av.qT(str);
        av.hv(true);
        Toast.makeText(this.azR.getBaseContext(), this.azR.getString(2131625518), 1).show();
        return;
      } 
      Toast.makeText(this.azR.getBaseContext(), this.azR.getString(2131625516), 1).show();
      return;
    } 
    av.hv(false);
    Toast.makeText(this.azR.getBaseContext(), this.azR.getString(2131625510), 1).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\LockScreen\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */