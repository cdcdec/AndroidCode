package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;

public class ar extends at {
  public static class a extends Thread {
    private String bTn;
    
    private int bTo;
    
    private Context mContext;
    
    public a(Context param1Context, String param1String, int param1Int) {
      this.mContext = param1Context;
      this.bTn = param1String;
      this.bTo = param1Int;
    }
    
    public void run() {
      super.run();
      a1 = new OnlineSyncRequest.a();
      try {
        exception = new at(this.mContext);
      } catch (Exception exception) {
        a.e(exception);
        exception = null;
      } 
      a1.a(exception.gZ(this.bTn), this.bTo);
      a1.iM(RootApplication.getLaiqianPreferenceManager().Ea());
      a1.iN(RootApplication.getLaiqianPreferenceManager().atr());
      a1.bV(Long.parseLong(RootApplication.getLaiqianPreferenceManager().Tx()));
      f f = f.bXQ;
      try {
        f.a(a1.Xj());
      } catch (Exception a1) {
      
      } finally {}
      exception.close();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */