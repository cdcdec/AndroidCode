package com.laiqian.member;

import android.content.Intent;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.member.b.a;
import com.laiqian.models.l;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class q implements r.a {
  q(p paramp) {}
  
  public void xD() {}
  
  public void xE() {
    if (RootApplication.getLaiqianPreferenceManager().Wq() && !bd.bH(this.btt.btq)) {
      n.o(this.btt.btq.getString(R.string.please_check_network));
      return;
    } 
    l l = null;
    try {
      l l1 = new l(this.btt.btq);
      l = l1;
    } catch (Exception exception) {
      a.e(exception);
    } 
    boolean bool = l.bm((MemberChangeActivity.j(this.btt.btq)).aSW);
    l.close();
    if (bool) {
      MemberChangeActivity.a(this.btt.btq, true);
      MemberChangeActivity memberChangeActivity1 = this.btt.btq;
      MemberChangeActivity memberChangeActivity2 = this.btt.btq;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append((MemberChangeActivity.j(this.btt.btq)).aSW);
      stringBuilder1.append("");
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append((MemberChangeActivity.j(this.btt.btq)).aSW);
      stringBuilder2.append("");
      (new MemberChangeActivity.b(memberChangeActivity1, memberChangeActivity2, str, stringBuilder2.toString())).forceLoad();
      this.btt.btq.sendBroadcast((new Intent()).setAction("pos_activity_change_data_paytype"));
      this.btt.btq.sendBroadcast((new Intent()).setAction("pos_activity_change_data_vip"));
      MemberChangeActivity.k(this.btt.btq).show();
      Intent intent = new Intent(a.bwV);
      this.btt.btq.sendBroadcast(intent);
      MemberChangeActivity.l(this.btt.btq).postDelayed(new r(this), 1000L);
      return;
    } 
    Toast.makeText(this.btt.btq, this.btt.btq.getString(R.string.pos_delete_fail), 0).show();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */