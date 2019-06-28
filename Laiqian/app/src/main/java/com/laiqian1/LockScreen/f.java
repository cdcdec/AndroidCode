package com.laiqian.LockScreen;

import android.view.View;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.c;
import com.laiqian.util.av;
import java.security.NoSuchAlgorithmException;

class f implements View.OnClickListener {
  f(LockScreenService paramLockScreenService) {}
  
  public void onClick(View paramView) {
    str = this.aAp.azY.getText().toString().trim();
    if (str.length() == 0) {
      Toast.makeText(this.aAp, this.aAp.getString(2131625511), 0).show();
      return;
    } 
    try {
      str = c.cI(str);
    } catch (NoSuchAlgorithmException str) {
      a.e(str);
      str = "";
    } 
    av av = new av(this.aAp);
    if (av.atr().equals(str)) {
      this.aAp.stopSelf();
      Toast.makeText(this.aAp, this.aAp.getString(2131625517), 0).show();
    } else {
      Toast.makeText(this.aAp, this.aAp.getString(2131625515), 0).show();
      this.aAp.azY.selectAll();
    } 
    av.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\LockScreen\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */