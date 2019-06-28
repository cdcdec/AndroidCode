package com.laiqian.sync.a;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.k.a;
import com.laiqian.sync.model.SyncProgessMessage;

class h extends Handler {
  h(g paramg) {}
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    String str = g.a(this.doD);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MultithreadOSSDownloadHandler = ");
    stringBuilder.append(paramMessage.what);
    Log.e(str, stringBuilder.toString());
    if (i == 1) {
      a.bc("download_file", a.asv());
      g.b(this.doD).setProgress(SyncProgessMessage.dpc);
      this.doD.b(g.b(this.doD));
      a.start();
      this.doD.B(a.aOD, System.currentTimeMillis());
      a.bc("merge_file", a.asv());
      a.B(this.doD.context, "sync");
      g.b(this.doD).setProgress(SyncProgessMessage.dpd);
      this.doD.b(g.b(this.doD));
      g.b(this.doD).setProgress(SyncProgessMessage.COMPLETE);
      this.doD.b(g.b(this.doD));
      (new i(this)).start();
      return;
    } 
    if (i == 0 || i == 2) {
      if (i == 0) {
        a.bc("download_file", a.asv());
      } else if (i == 2) {
        a.bc("merge_file", a.asv());
      } 
      a.B(this.doD.context, "sync");
      g.b(this.doD).setResult(0);
      g.b(this.doD).kn(5004);
      g.b(this.doD).setProgress(SyncProgessMessage.COMPLETE);
      this.doD.b(g.b(this.doD));
      return;
    } 
    g.b(this.doD).setResult(0);
    g.b(this.doD).kn(5004);
    g.b(this.doD).setProgress(SyncProgessMessage.dpb);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */