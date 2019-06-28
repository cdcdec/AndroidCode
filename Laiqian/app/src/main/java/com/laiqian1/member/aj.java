package com.laiqian.member;

import android.view.View;
import com.laiqian.ui.a.aj;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class aj implements View.OnClickListener {
  aj(MemberInfoActivity paramMemberInfoActivity, aj.a parama) {}
  
  public void onClick(View paramView) {
    if (MemberInfoActivity.a(this.buu).PV() == null) {
      n.eP(R.string.failed_to_get_member_information);
      return;
    } 
    if (MemberInfoActivity.f(this.buu) == null) {
      MemberInfoActivity.a(this.buu, new aj(this.buu));
      MemberInfoActivity.f(this.buu).a(this.buI);
      MemberInfoActivity.f(this.buu).pc(this.buu.getString(R.string.vip_print));
    } 
    MemberInfoActivity.f(this.buu).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */