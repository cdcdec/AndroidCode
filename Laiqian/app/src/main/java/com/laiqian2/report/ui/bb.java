package com.laiqian.report.ui;

import android.widget.RadioGroup;

class bb implements RadioGroup.OnCheckedChangeListener {
  bb(ReportRoot paramReportRoot) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {
    switch (paramRadioGroup.getCheckedRadioButtonId()) {
      case 2131296780:
        this.dgN.dgo.accept(Integer.valueOf(2));
        ReportRoot.b(this.dgN, true);
        break;
      case 2131296779:
        this.dgN.dgo.accept(Integer.valueOf(1));
        ReportRoot.b(this.dgN, false);
        break;
      case 2131296778:
        this.dgN.dgo.accept(Integer.valueOf(0));
        ReportRoot.b(this.dgN, false);
        break;
    } 
    ReportRoot.q(this.dgN);
    this.dgN.AJ();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */