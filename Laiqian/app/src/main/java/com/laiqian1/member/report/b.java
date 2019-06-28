package com.laiqian.member.report;

import android.widget.Toast;
import com.laiqian.ui.a.r;
import com.laiqian.vip.R;

class b implements r.a {
  b(a parama, boolean paramBoolean) {}
  
  public void xD() {}
  
  public void xE() {
    if (!MemberChargeDetailRecord.d(this.byW.byU)) {
      Toast.makeText(this.byW.byU.getActivity(), R.string.cancel_fail_has_consume_after_charge_cause_member_be_deleted, 0).show();
      return;
    } 
    if (this.byV) {
      if (MemberChargeDetailRecord.e(this.byW.byU)) {
        (new MemberChargeDetailRecord.b(this.byW.byU, null)).execute(new Long[] { Long.valueOf(MemberChargeDetailRecord.f(this.byW.byU)) });
        return;
      } 
    } else {
      MemberChargeDetailRecord.g(this.byW.byU);
    } 
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */