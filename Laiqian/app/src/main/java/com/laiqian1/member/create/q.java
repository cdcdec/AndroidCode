package com.laiqian.member.create;

import android.os.Handler;
import android.os.Message;
import com.laiqian.entity.aq;
import com.laiqian.vip.R;

class q extends Handler {
  q(VipCreateDialog paramVipCreateDialog) {}
  
  public void handleMessage(Message paramMessage) {
    aq aq;
    switch (paramMessage.what) {
      default:
        return;
      case 3:
        aq = this.bxz.QF();
        this.bxz.bwG.a(VipCreateDialog.N(this.bxz).getString(R.string.pay_status_pending), VipCreateDialog.L(this.bxz), aq, false, false);
        return;
      case 2:
        VipCreateDialog.a(this.bxz, aq);
        this.bxz.bxc = new VipCreateDialog.b(this.bxz);
        aq = this.bxz.QF();
        this.bxz.bxc.execute(new aq[] { aq });
        this.bxz.bwG.a(VipCreateDialog.M(this.bxz).getString(R.string.pay_status_pending), VipCreateDialog.L(this.bxz), aq, false, true);
        return;
      case 1:
        break;
    } 
    VipCreateDialog.a(this.bxz, aq);
    this.bxz.bxc = new VipCreateDialog.b(this.bxz);
    this.bxz.bxc.execute(new aq[] { this.bxz.QF() });
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */