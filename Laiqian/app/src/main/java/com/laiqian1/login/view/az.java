package com.laiqian.login.view;

import com.laiqian.network.i;
import com.laiqian.network.k;
import com.laiqian.pos.hardware.RootUrlParameter;
import io.reactivex.d;
import io.reactivex.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.n;
import kotlin.d;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
final class az<T> extends Object implements f<T> {
  az(String paramString) {}
  
  public final void a(@NotNull d<Boolean> paramd) {
    f.m(paramd, "it");
    i i = (new k()).a((Map)n.a(new d[] { new d("phone", this.bal) }), RootUrlParameter.cmA, 1);
    if (i.bUi) {
      paramd.aK(Boolean.valueOf(true));
      return;
    } 
    paramd.f(new Throwable(i.message));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */