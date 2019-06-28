package com.laiqian.auth;

import android.content.Intent;
import android.view.View;
import com.laiqian.k.a;

class az implements View.OnClickListener {
  az(ShiftActivity paramShiftActivity) {}
  
  public void onClick(View paramView) {
    ShiftActivity.aEy = true;
    a.asx();
    a.asy();
    Intent intent = new Intent(this.aEC, com.laiqian.report.ui.ShiftReport.class);
    this.aEC.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */