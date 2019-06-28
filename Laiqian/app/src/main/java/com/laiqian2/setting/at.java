package com.laiqian.setting;

import android.content.Context;
import com.github.moduth.blockcanary.a.a;
import com.github.moduth.blockcanary.e;
import com.laiqian.util.b;
import com.laiqian.util.logger.AliLog;
import hugo.weaving.DebugLog;

class at extends e {
  at(as paramas) {}
  
  @DebugLog
  public void a(Context paramContext, a parama) {
    super.a(paramContext, parama);
    b.c(AliLog.b.dHc, b.a.dEJ, parama.toString());
  }
  
  public boolean uX() { return false; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */