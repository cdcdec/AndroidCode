package com.laiqian.pos.settings;

import android.text.Editable;
import com.laiqian.ui.r;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class au extends r {
  au(ShopBasicInfoFragment paramShopBasicInfoFragment) {}
  
  public void afterTextChanged(@NotNull Editable paramEditable) {
    f.m(paramEditable, "s");
    ShopBasicInfoFragment.b(this.cAE).kQ(paramEditable.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */