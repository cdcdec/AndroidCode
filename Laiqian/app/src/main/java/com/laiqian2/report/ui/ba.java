package com.laiqian.report.ui;

import android.widget.RadioGroup;

class ba implements RadioGroup.OnCheckedChangeListener {
  ba(ReportRoot paramReportRoot) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {
    switch (paramRadioGroup.getCheckedRadioButtonId()) {
      case 2131296699:
        this.dgN.dgp.accept(Integer.valueOf(1));
        ReportRoot.a(this.dgN, false);
        break;
      case 2131296698:
        this.dgN.dgp.accept(Integer.valueOf(2));
        ReportRoot.a(this.dgN, true);
        break;
      case 2131296697:
        this.dgN.dgp.accept(Integer.valueOf(0));
        ReportRoot.a(this.dgN, false);
        break;
    } 
    ReportRoot.q(this.dgN);
    this.dgN.AJ();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */