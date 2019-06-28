package com.laiqian.login.view;

import android.content.Intent;
import io.reactivex.c.g;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
final class au<T> extends Object implements g<String> {
  au(as paramas) {}
  
  public final void eJ(@NotNull String paramString) {
    f.m(paramString, "it");
    RegisterAccountActivity registerAccountActivity = this.bak.baj;
    Intent intent = new Intent(this.bak.baj.getBaseContext(), com.laiqian.ui.webview.SimpleWebViewActivity.class);
    intent.putExtra("url", paramString).putExtra("title", this.bak.baj.getString(2131625478)).putExtra("dst_activity", "com.laiqian.login.view.LoginActivity");
    registerAccountActivity.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */