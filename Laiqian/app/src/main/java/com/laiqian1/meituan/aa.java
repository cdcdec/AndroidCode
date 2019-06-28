package com.laiqian.meituan;

import com.laiqian.ui.listview.FormListView;

class aa implements FormListView.a {
  aa(MeituanPhoneNumberErrorsDocActivity paramMeituanPhoneNumberErrorsDocActivity) {}
  
  public void aX(int paramInt1, int paramInt2) {
    MeituanPhoneNumberErrorsDocActivity.b(this.bqT);
    if (paramInt2 == 0) {
      if (paramInt1 == 0) {
        MeituanPhoneNumberErrorsDocActivity.c(this.bqT).setVisibility(0);
        this.bqT.bqN.setVisibility(8);
        MeituanPhoneNumberErrorsDocActivity.d(this.bqT).hideFooterView();
        MeituanPhoneNumberErrorsDocActivity.d(this.bqT).setVisibility(8);
        return;
      } 
      if (paramInt1 > 0 && paramInt1 < 10) {
        MeituanPhoneNumberErrorsDocActivity.d(this.bqT).hideFooterView();
        MeituanPhoneNumberErrorsDocActivity.d(this.bqT).setVisibility(0);
        MeituanPhoneNumberErrorsDocActivity.c(this.bqT).setVisibility(8);
        this.bqT.bqN.setVisibility(8);
        return;
      } 
      if (paramInt1 >= 10) {
        MeituanPhoneNumberErrorsDocActivity.d(this.bqT).showFooterView();
        MeituanPhoneNumberErrorsDocActivity.d(this.bqT).setVisibility(0);
        MeituanPhoneNumberErrorsDocActivity.c(this.bqT).setVisibility(8);
        this.bqT.bqN.setVisibility(8);
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */