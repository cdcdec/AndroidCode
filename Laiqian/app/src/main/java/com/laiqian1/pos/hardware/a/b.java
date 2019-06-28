package com.laiqian.pos.hardware.a;

import android.annotation.SuppressLint;
import com.google.a.a.a.a.a.a;
import io.reactivex.a.a;
import io.reactivex.g.a;
import io.reactivex.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class b {
  private static final TimeUnit cmJ = TimeUnit.MILLISECONDS;
  
  private final a bgv = new a();
  
  private final List<a> cmK = new ArrayList();
  
  private final boolean cmL = false;
  
  private void eQ(boolean paramBoolean) {
    for (a a1 : this.cmK) {
      try {
        a1.setEnabled(paramBoolean);
      } catch (Exception a1) {
        a.e(a1);
      } 
    } 
  }
  
  public void a(a parama) { this.cmK.add(parama); }
  
  public void aat() {
    this.bgv.clear();
    reset();
  }
  
  @SuppressLint({"CheckResult"})
  public void c(long paramLong, TimeUnit paramTimeUnit) {
    h.c(new c(this)).d(a.aKi()).aJk();
    h.b(paramLong, paramTimeUnit, a.aKi()).b(new d(this));
  }
  
  public void d(long paramLong, TimeUnit paramTimeUnit) { this.bgv.b(h.a(paramLong, paramTimeUnit, a.aKi()).d(e.beq).b(new f(this))); }
  
  public void reset() { eQ(false); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\hardware\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */