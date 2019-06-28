package com.laiqian.pos.industry.weiorder.advertisement;

import com.laiqian.network.i;
import com.laiqian.util.n;
import io.reactivex.c.g;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
final class k<T> extends Object implements g<i> {
  k(b paramb, boolean paramBoolean) {}
  
  public final void e(@NotNull i parami) {
    f.m(parami, "it");
    if (this.cxs) {
      if (parami.bUj == 100004) {
        this.cxr.acB().acJ();
        b.b(this.cxr);
        this.cxr.acy();
        return;
      } 
    } else {
      this.cxr.acB().acK();
      if (parami.bUi) {
        this.cxr.acB().acH();
        return;
      } 
      if (parami.bUj == 100003) {
        this.cxr.acB().acI();
        this.cxr.acx();
        return;
      } 
      if (parami.bUj == 100004) {
        this.cxr.acB().acJ();
        b.b(this.cxr);
        return;
      } 
      n.eP(2131626172);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\advertisement\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */