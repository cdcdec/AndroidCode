package com.laiqian.member.report;

import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.ui.a.r;
import com.laiqian.vip.R;

class a implements View.OnClickListener {
  a(MemberChargeDetailRecord paramMemberChargeDetailRecord) {}
  
  public void onClick(View paramView) {
    boolean bool = RootApplication.getLaiqianPreferenceManager().Wq();
    if (!this.byU.byN) {
      MemberChargeDetailRecord.a(this.byU, this.byU.getString(R.string.vip_get_balance_fail));
      MemberChargeDetailRecord.b(this.byU).s(MemberChargeDetailRecord.a(this.byU));
      MemberChargeDetailRecord.b(this.byU).show();
      return;
    } 
    if (MemberChargeDetailRecord.c(this.byU) == null) {
      MemberChargeDetailRecord.a(this.byU, new r(this.byU, new b(this, bool)));
      MemberChargeDetailRecord.c(this.byU).setTitle(this.byU.getString(R.string.pos_dialog_title_prompt));
      MemberChargeDetailRecord.c(this.byU).s(this.byU.getString(R.string.is_cancel_charge));
    } 
    if (!this.byU.isFinishing())
      MemberChargeDetailRecord.c(this.byU).show(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */