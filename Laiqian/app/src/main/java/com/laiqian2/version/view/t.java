package com.laiqian.version.view;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.version.b.d;

class t implements View.OnClickListener {
  private boolean dJo = true;
  
  private boolean isLoading = false;
  
  t(UpgradeAndEvaluationActivity paramUpgradeAndEvaluationActivity, d paramd, TextView paramTextView, String paramString) {}
  
  public void onClick(View paramView) {
    if (this.isLoading) {
      Toast.makeText(this.dKB, "加载中", 0).show();
      return;
    } 
    this.isLoading = true;
    if (this.dKz.axd() > 0) {
      this.dJo = true;
      this.dKz.axc();
    } else {
      this.dJo = false;
    } 
    UpgradeAndEvaluationActivity.a(this.dKB).c(new u(this), this.dKz.axb(), this.bgQ);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */