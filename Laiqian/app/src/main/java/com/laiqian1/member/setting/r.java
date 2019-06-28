package com.laiqian.member.setting;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.Toast;
import com.laiqian.ui.r;
import com.laiqian.vip.R;

class r extends r {
  r(VipBasicInfoFragment.a parama) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (TextUtils.isEmpty(paramEditable.toString())) {
      Toast.makeText(this.bBV.bBT.getActivity(), R.string.member_discount_not_null, 0).show();
      return;
    } 
    VipBasicInfoFragment.a(this.bBV.bBT).al(Double.parseDouble(paramEditable.toString()));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */