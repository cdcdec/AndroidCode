package com.laiqian.setting;

import com.laiqian.ui.a.aq;

class bd extends Object implements aq.a<CharSequence> {
  bd(bc parambc) {}
  
  public void a(aq paramaq, int paramInt, CharSequence paramCharSequence) {
    if (SettingBillNumber.b(this.dlN.dlM) != paramInt) {
      this.dlN.dlM.dlF.setText("1");
      SettingBillNumber.a(this.dlN.dlM, paramInt);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */