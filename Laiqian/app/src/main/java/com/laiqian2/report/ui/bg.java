package com.laiqian.report.ui;

import android.app.Activity;
import android.content.Intent;
import com.laiqian.util.m;

class bg extends m.c {
  bg(ReportRoot paramReportRoot, Activity paramActivity, Class paramClass, int paramInt) { super(paramActivity, paramClass, paramInt); }
  
  protected boolean h(Intent paramIntent) {
    paramIntent.putExtra("productIDs", this.dgN.cPh);
    paramIntent.putExtra("hasMealSet", true);
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */