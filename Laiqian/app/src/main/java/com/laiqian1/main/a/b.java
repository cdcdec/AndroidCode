package com.laiqian.main.a;

import android.app.Activity;
import android.content.Context;
import com.laiqian.milestone.h;
import com.laiqian.report.ui.a;
import com.laiqian.util.av;

public class b {
  String aDZ = "";
  
  String aGA = "";
  
  Context context;
  
  public b(Context paramContext) {
    this.context = paramContext;
    av av = new av(paramContext);
    this.aGA = av.Tx();
    this.aDZ = av.atm();
  }
  
  public boolean Pl() { return (new h(this.context)).Z(this.aGA, this.aDZ); }
  
  public void a(a.a parama) {
    a a1 = new a(this.context);
    a1.b(parama);
    Activity activity = (Activity)this.context;
    if (!activity.isFinishing() && !activity.isDestroyed())
      a1.show(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */