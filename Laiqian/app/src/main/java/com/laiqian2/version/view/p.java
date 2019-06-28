package com.laiqian.version.view;

import android.view.View;
import android.widget.Toast;
import com.laiqian.version.b.b;

class p implements View.OnClickListener {
  private boolean dJo = true;
  
  private boolean isLoading = false;
  
  p(MyEvaluationActivity paramMyEvaluationActivity, b paramb, View paramView) {}
  
  public void onClick(View paramView) {
    if (this.isLoading) {
      Toast.makeText(this.dKi, "加载中", 0).show();
      return;
    } 
    this.isLoading = true;
    if (this.dJp.axd() > 0) {
      this.dJo = true;
      this.dJp.axc();
    } else {
      this.dJo = false;
    } 
    this.dKi.d(this.dKi.dKg);
    MyEvaluationActivity.a(this.dKi, new q(this), (String)paramView.getTag(), this.dJp.axb());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */