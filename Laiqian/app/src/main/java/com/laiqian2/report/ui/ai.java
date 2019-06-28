package com.laiqian.report.ui;

import com.google.a.a.a.a.a.a;
import com.laiqian.pos.model.a;

class ai implements Runnable {
  ai(OrderDetailsRoot paramOrderDetailsRoot) {}
  
  public void run() {
    a a = new a(this.dfa);
    a.beginTransaction();
    a.a a1 = a.aH(OrderDetailsRoot.access$000(this.dfa), OrderDetailsRoot.access$100(this.dfa));
    boolean bool1 = a1.cyx;
    if (bool1) {
      boolean bool2;
      try {
        bool2 = OrderDetailsRoot.access$400(this.dfa, a1.cyz, a1.cyA, false);
      } catch (Exception exception) {
        a.e(exception);
        bool2 = false;
      } 
      if (bool1)
        if (this.dfa.isUseOnlineMember()) {
          if (bool2)
            a.setTransactionSuccessful(); 
        } else {
          a.setTransactionSuccessful();
        }  
      a.endTransaction();
      a.close();
      if (bool1) {
        if (this.dfa.isUseOnlineMember()) {
          if (bool2) {
            OrderDetailsRoot.access$500(this.dfa).sendEmptyMessage(100);
            return;
          } 
          OrderDetailsRoot.access$500(this.dfa).obtainMessage(101, a1.cyy).sendToTarget();
          return;
        } 
        OrderDetailsRoot.access$500(this.dfa).sendEmptyMessage(100);
        return;
      } 
      OrderDetailsRoot.access$500(this.dfa).obtainMessage(101, a1.cyy).sendToTarget();
      return;
    } 
    boolean bool = false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */