package com.laiqian.opentable.pos;

import com.laiqian.opentable.R;
import com.laiqian.opentable.common.b;
import com.laiqian.ordertool.b.b;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.n;
import org.greenrobot.eventbus.c;

class ac implements Runnable {
  ac(ab paramab, int paramInt, PendingFullOrderDetail paramPendingFullOrderDetail, String paramString) {}
  
  public void run() {
    if (b.XF()) {
      if (this.cbo == -2) {
        n.eP(R.string.server_feedback_null);
        c.aYt().cN(new b(null));
      } 
    } else {
      if (this.cbo == -2)
        n.eP(R.string.server_feedback_null); 
      j.b(this.cbq.cbg).a(this.cbp, this.azy);
    } 
    this.cbq.cbg.zM();
    j.c(this.cbq.cbg).eD(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */