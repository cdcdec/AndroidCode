package com.laiqian.util;

import io.reactivex.a.b;
import io.reactivex.android.b.a;
import io.reactivex.h;
import io.reactivex.l;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
public final class ce {
  private b aBK;
  
  private long startTime;
  
  public final void a(long paramLong, @NotNull TimeUnit paramTimeUnit, @Nullable a parama) {
    f.m(paramTimeUnit, "timeUnit");
    h.e(paramLong, paramTimeUnit).c(a.aJo()).c((l)new cf(this, parama));
  }
  
  public final void cancel() {
    if (this.aBK != null) {
      b b1 = this.aBK;
      if (b1 == null)
        f.aQI(); 
      if (!b1.wL()) {
        b1 = this.aBK;
        if (b1 == null)
          f.aQI(); 
        b1.wK();
      } 
    } 
    this.startTime = 0L;
  }
  
  @Metadata
  public static interface a {
    void ct(long param1Long);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */