package com.laiqian.member.a;

import android.content.Intent;
import android.view.View;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.c;
import com.laiqian.util.n;

class e implements View.OnClickListener {
  e(a parama) {}
  
  public void onClick(View paramView) {
    if (this.bwR.bwG.bys == null) {
      n.o("未知错误，没有选中支付类型");
      return;
    } 
    if (this.bwR.bwG.bys.bpq || this.bwR.bwG.bys.bpr) {
      a.a(this.bwR, true);
      return;
    } 
    if (this.bwR.bwG.bys.aTv == 10007 && this.bwR.bwG.bys.aTe == 0L) {
      a.a(this.bwR, true);
      return;
    } 
    if (this.bwR.bwG.bys.aTv == 10009 && this.bwR.bwG.bys.aTe == 8L) {
      a.a(this.bwR, true);
      return;
    } 
    if (a.g(this.bwR)) {
      if (this.bwR.bwG.bys.aTv == 10001) {
        PrintContent.a a1 = new PrintContent.a();
        a1.age();
        PrintContent printContent = a1.afV();
        c.bp(a.o(this.bwR)).e(printContent);
        this.bwR.getContext().sendBroadcast(new Intent("android.intent.money_test.action"));
      } 
      this.bwR.QD();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */