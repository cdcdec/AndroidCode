package com.laiqian.login.view;

import android.arch.lifecycle.v;
import io.reactivex.android.b.a;
import io.reactivex.c;
import io.reactivex.c.h;
import io.reactivex.f;
import io.reactivex.g.a;
import io.reactivex.h;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class RegisterAccountActivityViewModel extends v {
  private final h<Boolean> eK(String paramString) {
    h h = c.a((f)new az(paramString)).aJf();
    f.l(h, "Maybe.create<Boolean> {\n…\n        }.toObservable()");
    return h;
  }
  
  @NotNull
  public final h<String> G(@NotNull String paramString1, @NotNull String paramString2) {
    f.m(paramString1, "userPhone");
    f.m(paramString2, "pwd");
    h h = eK(paramString1).c((h)new ax(paramString1, paramString2)).d(a.aKh()).c(a.aJo());
    f.l(h, "verifyRemote(userPhone).…dSchedulers.mainThread())");
    return h;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\RegisterAccountActivityViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */