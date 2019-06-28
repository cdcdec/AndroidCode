package com.laiqian.login.view;

import io.reactivex.c.g;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
final class av<T> extends Object implements g<Throwable> {
  av(as paramas) {}
  
  public final void k(@NotNull Throwable paramThrowable) {
    f.m(paramThrowable, "it");
    RegisterAccountActivity registerAccountActivity = this.bak.baj;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(paramThrowable.getMessage());
    stringBuilder.append("");
    stringBuilder.append(this.bak.baj.getString(2131627731));
    registerAccountActivity.eG(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */