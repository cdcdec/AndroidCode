package com.laiqian.takeaway.phone.setting;

import android.view.View;
import com.laiqian.ui.a.r;

class e implements View.OnClickListener {
  e(PhoneChangeActivity paramPhoneChangeActivity) {}
  
  public void onClick(View paramView) {
    f f = new f(this);
    r r = new r(this.duO, true, f);
    r.setTitle(this.duO.getString(2131625963));
    r.s(this.duO.getString(2131627033));
    r.t(this.duO.getString(2131625538));
    r.oZ(this.duO.getString(2131628275));
    r.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */