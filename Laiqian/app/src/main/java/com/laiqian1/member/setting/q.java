package com.laiqian.member.setting;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.Toast;
import com.laiqian.ui.r;
import com.laiqian.vip.R;

class q extends r {
  q(VipBasicInfoFragment.a parama) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (TextUtils.isEmpty(paramEditable.toString())) {
      Toast.makeText(this.bBV.bBT.getActivity(), R.string.member_card_name_not_null, 0).show();
      return;
    } 
    VipBasicInfoFragment.a(this.bBV.bBT).fV(paramEditable.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */