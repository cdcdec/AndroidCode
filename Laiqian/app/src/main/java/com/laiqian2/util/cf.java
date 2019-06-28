package com.laiqian.util;

import io.reactivex.a.b;
import io.reactivex.annotations.NonNull;
import io.reactivex.l;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class cf extends Object implements l<Long> {
  cf(ce paramce, ce.a parama) {}
  
  public void a(@NonNull @NotNull b paramb) {
    f.m(paramb, "disposable");
    ce.a(this.dGG, paramb);
  }
  
  public void dF(long paramLong) {
    ce.a a1 = this.dGH;
    if (a1 != null)
      a1.ct(paramLong); 
  }
  
  public void f(@NonNull @NotNull Throwable paramThrowable) { f.m(paramThrowable, "e"); }
  
  public void xx() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */