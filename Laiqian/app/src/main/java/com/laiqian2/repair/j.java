package com.laiqian.repair;

import android.view.View;
import com.laiqian.infrastructure.R;
import com.laiqian.util.bd;
import com.laiqian.util.bg;
import com.laiqian.util.n;

class j implements View.OnClickListener {
  j(SelfRepairMain paramSelfRepairMain) {}
  
  public void onClick(View paramView) {
    SelfRepairMain.a(this.cYp, SelfRepairMain.a(this.cYp).getText().toString().trim());
    if (SelfRepairMain.b(this.cYp).length() == 0) {
      n.w(this.cYp, R.string.pos_repair_self_no_code);
      return;
    } 
    if (!bd.bH(this.cYp)) {
      n.w(this.cYp, R.string.pos_repair_self_no_network);
      return;
    } 
    SelfRepairMain.c(this.cYp).setVisibility(8);
    SelfRepairMain.d(this.cYp).setVisibility(0);
    if (bg.equals("119007", SelfRepairMain.a(this.cYp))) {
      SelfRepairMain.b(this.cYp, SelfRepairMain.b(this.cYp));
      return;
    } 
    if (bg.equals("119008", SelfRepairMain.b(this.cYp))) {
      SelfRepairMain.e(this.cYp);
      return;
    } 
    (new SelfRepairMain.b(this.cYp, SelfRepairMain.b(this.cYp), null)).start();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repair\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */