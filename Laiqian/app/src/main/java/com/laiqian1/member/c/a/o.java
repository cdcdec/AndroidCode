package com.laiqian.member.c.a;

import android.content.Context;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.member.cb;

public class o implements b {
  private b bxG;
  
  private Context context;
  
  public o(Context paramContext) { this.context = paramContext; }
  
  public b QJ() {
    if (this.bxG == null)
      if (RootApplication.getLaiqianPreferenceManager().avL() != 0 && a.AZ().Ca() == 1) {
        if (RootApplication.getLaiqianPreferenceManager().Wq()) {
          this.bxG = new m(this.context);
        } else {
          this.bxG = new f(this.context);
        } 
      } else {
        this.bxG = new m(this.context);
      }  
    return this.bxG;
  }
  
  public void a(int paramInt1, int paramInt2, cb paramcb, d.a parama) { QJ().a(paramInt1, paramInt2, paramcb, parama); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\c\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */