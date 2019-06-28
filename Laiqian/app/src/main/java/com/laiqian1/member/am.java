package com.laiqian.member;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class am implements View.OnClickListener {
  am(MemberInfoActivity paramMemberInfoActivity) {}
  
  public void onClick(View paramView) {
    if (MemberInfoActivity.a(this.buu).PV() == null)
      return; 
    if (RootApplication.getLaiqianPreferenceManager().avs() == 1 && RootApplication.getLaiqianPreferenceManager().avr() == 1 && RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(R.string.only_headquarters_modifications_are_allowed);
      return;
    } 
    Intent intent = new Intent(this.buu, MemberChangeActivity.class);
    Bundle bundle = new Bundle();
    bundle.putSerializable("VIP_ENTITY", MemberInfoActivity.a(this.buu).PV());
    intent.putExtras(bundle);
    this.buu.startActivity(intent);
    this.buu.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */