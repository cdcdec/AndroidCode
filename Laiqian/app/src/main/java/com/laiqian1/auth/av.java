package com.laiqian.auth;

import android.app.Activity;
import android.support.annotation.Nullable;
import com.laiqian.ui.a.aq;

public class av extends aq<String> {
  private Activity aEv;
  
  String[] aEw = new String[2];
  
  protected av(Activity paramActivity, @Nullable aq.a<String> parama, int paramInt) {
    super(paramActivity, parama);
    this.aEv = paramActivity;
    this.aEw[1] = this.aEv.getString(2131627448);
    this.aEw[0] = this.aEv.getString(2131627449);
    kR(paramInt);
  }
  
  protected aq<String>.b yd() { return new aw(this); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */