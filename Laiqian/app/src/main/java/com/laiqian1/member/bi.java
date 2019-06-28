package com.laiqian.member;

import android.widget.Toast;
import com.laiqian.pos.s;
import com.laiqian.vip.R;

class bi implements s.a {
  bi(MemberListActivity paramMemberListActivity) {}
  
  public void Qo() {
    MemberListActivity.g(this.bvu).Qt().cancel();
    Toast.makeText(this.bvu.getActivity(), this.bvu.getActivity().getString(R.string.pos_download_transaction_data_failure), 1).show();
  }
  
  public void fr(int paramInt) {}
  
  public void onSuccess() { MemberListActivity.q(this.bvu); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */