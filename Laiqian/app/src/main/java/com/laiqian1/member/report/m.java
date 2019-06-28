package com.laiqian.member.report;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.by;
import java.util.ArrayList;

class m implements Handler.Callback {
  m(VipReportActivity paramVipReportActivity) {}
  
  public boolean handleMessage(Message paramMessage) {
    ArrayList arrayList = (ArrayList)paramMessage.obj;
    VipReportActivity.o(this.bzE).setText(by.a(by.k(Double.valueOf(VipReportActivity.j(this.bzE).a(false, arrayList, new String[] { "370005" }))), 9999, this.bzE));
    VipReportActivity.p(this.bzE).setText(by.a(by.k(Double.valueOf(VipReportActivity.j(this.bzE).a(true, arrayList, new String[] { "370004", "370010" }))), 9999, this.bzE));
    VipReportActivity.q(this.bzE).setText(by.a(by.k(Double.valueOf(VipReportActivity.j(this.bzE).a(false, arrayList, new String[] { "370004", "370007", "370010" }))), 9999, this.bzE));
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */