package com.laiqian.main;

import android.content.Intent;
import com.laiqian.ui.a.r;

class ae implements r.a {
  ae(PosActivity paramPosActivity, int paramInt) {}
  
  public void xD() { PosActivity.e(this.baU).dismiss(); }
  
  public void xE() {
    Intent intent = new Intent(this.baU.getActivity(), com.laiqian.member.setting.sms.BuySmsActivity.class);
    intent.putExtra("SMS_QUANTITY_LEFT", this.baV);
    this.baU.startActivity(intent);
  }
  
  public void xF() { PosActivity.e(this.baU).dismiss(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */