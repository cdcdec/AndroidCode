package com.laiqian.opentable.common.a;

import com.google.a.a.a.a.a.a;
import com.laiqian.models.p;
import com.laiqian.ordertool.b.a;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.c;

class f extends TimerTask {
  f(b paramb, Timer paramTimer) {}
  
  public void run() {
    try {
      exception = new p(b.a(this.bZS));
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    List list = exception.Va();
    exception.close();
    if (list.size() > 0)
      c.aYt().cM(new a(list)); 
    this.bZT.cancel();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */