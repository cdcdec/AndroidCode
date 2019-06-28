package com.laiqian.member.e;

import android.util.Log;
import android.view.View;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class g implements View.OnClickListener {
  g(e parame) {}
  
  public void onClick(View paramView) {
    Log.e("password", (e.a(this.byp)).aWH.password);
    if ((e.a(this.byp)).aWH.password.equals(e.b(this.byp).getText().toString().trim())) {
      e.c(this.byp).dj(true);
      this.byp.dismiss();
      return;
    } 
    n.eP(R.string.password_error);
    e.b(this.byp).requestFocus();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */