package com.laiqian.member;

import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.ui.a.r;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class p implements View.OnClickListener {
  p(MemberChangeActivity paramMemberChangeActivity) {}
  
  public void onClick(View paramView) {
    if (RootApplication.getLaiqianPreferenceManager().Wq() && (MemberChangeActivity.j(this.btq)).aWC > 0 && by.parseLong(RootApplication.getLaiqianPreferenceManager().Tx()) != (MemberChangeActivity.j(this.btq)).aWC) {
      n.o(this.btq.getString(R.string.non_store_account_cannot_be_deleted));
      return;
    } 
    q q = new q(this);
    r r = new r(this.btq, true, q);
    r.setTitle(this.btq.getString(R.string.ol_deleteItem));
    r.s(this.btq.getString(R.string.pos_member_delete));
    r.t(this.btq.getString(R.string.lqj_ok));
    r.oZ(this.btq.getString(R.string.lqj_cancel));
    r.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */