package com.laiqian.pos.settings;

import android.text.Editable;
import com.laiqian.ui.r;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class at extends r {
  at(ShopBasicInfoFragment paramShopBasicInfoFragment) {}
  
  public void afterTextChanged(@NotNull Editable paramEditable) {
    f.m(paramEditable, "s");
    ShopBasicInfoFragment.b(this.cAE).kP(paramEditable.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */