package com.laiqian.backup;

import android.os.Message;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;
import io.reactivex.g.a;

class d implements r.a {
  d(c paramc) {}
  
  public void xD() {}
  
  public void xE() {
    av av = new av(this.aHr.aHq);
    av.hn(false);
    av.close();
    Message message = new Message();
    message.obj = "start";
    this.aHr.aHq.aHl.sendMessage(message);
    e e = new e(this);
    a.aKh().r(e);
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */