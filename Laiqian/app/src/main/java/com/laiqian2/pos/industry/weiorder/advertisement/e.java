package com.laiqian.pos.industry.weiorder.advertisement;

import com.laiqian.network.i;
import com.laiqian.util.n;
import io.reactivex.c.g;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
final class e<T> extends Object implements g<i> {
  e(b paramb, String paramString) {}
  
  public final void e(@NotNull i parami) {
    f.m(parami, "it");
    if (parami.bUi) {
      this.cxr.kh(this.bal);
      return;
    } 
    this.cxr.acB().acG();
    n.o((CharSequence)parami.message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\advertisement\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */