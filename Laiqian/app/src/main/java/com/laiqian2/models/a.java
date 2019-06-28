package com.laiqian.models;

import android.content.Context;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.util.bd;

public class a extends f {
  public a(Context paramContext) { super(paramContext); }
  
  public boolean g(long paramLong, String paramString) {
    boolean bool = a(paramLong, 10013, paramString);
    if (bool && bd.bH(this.mContext)) {
      Context context = this.mContext;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong);
      stringBuilder.append("");
      (new a(context, stringBuilder.toString())).start();
    } 
    return bool;
  }
  
  public static class a extends Thread {
    private String bNg;
    
    private Context mContext;
    
    public a(Context param1Context, String param1String) {
      this.mContext = param1Context;
      this.bNg = param1String;
    }
    
    public void run() {
      super.run();
      a1 = new OnlineSyncRequest.a();
      f f = new f(this.mContext);
      a1.a(f.gZ(this.bNg), 1);
      a1.iM(CrashApplication.getLaiqianPreferenceManager().Ea());
      a1.iN(CrashApplication.getLaiqianPreferenceManager().atr());
      a1.bV(Long.parseLong(CrashApplication.getLaiqianPreferenceManager().Tx()));
      f f1 = f.bXQ;
      try {
        f1.a(a1.Xj());
      } catch (Exception a1) {
      
      } finally {}
      f.close();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */