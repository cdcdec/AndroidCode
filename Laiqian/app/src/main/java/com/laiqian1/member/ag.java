package com.laiqian.member;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.by;
import java.util.ArrayList;

class ag implements Handler.Callback {
  ag(MemberInfoActivity paramMemberInfoActivity) {}
  
  public boolean handleMessage(Message paramMessage) {
    ArrayList arrayList = (ArrayList)paramMessage.obj;
    MemberInfoActivity.b(this.buu).setText(by.a(by.k(Double.valueOf(MemberInfoActivity.a(this.buu).a(false, arrayList, new String[] { "370005" }))), 9999, this.buu));
    MemberInfoActivity.c(this.buu).setText(by.a(by.k(Double.valueOf(MemberInfoActivity.a(this.buu).a(true, arrayList, new String[] { "370004", "370010" }))), 9999, this.buu));
    MemberInfoActivity.d(this.buu).setText(by.a(by.k(Double.valueOf(MemberInfoActivity.a(this.buu).a(false, arrayList, new String[] { "370004", "370007", "370010" }))), 9999, this.buu));
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */