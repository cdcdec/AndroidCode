package com.laiqian.pos.settings;

import android.graphics.Bitmap;
import android.view.View;
import com.d.a.b.a.b;
import com.d.a.b.f.a;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class dh implements a {
  dh(ShopMoreInfoSettingsFragment paramShopMoreInfoSettingsFragment) {}
  
  public void a(@NotNull String paramString, @NotNull View paramView, @NotNull Bitmap paramBitmap) {
    f.m(paramString, "arg0");
    f.m(paramView, "arg1");
    f.m(paramBitmap, "arg2");
    ShopMoreInfoSettingsFragment.i(this.cBV).aea().setVisibility(8);
    ShopMoreInfoSettingsFragment.i(this.cBV).adZ().setVisibility(0);
    ShopMoreInfoSettingsFragment.i(this.cBV).aeb().setVisibility(8);
  }
  
  public void a(@NotNull String paramString, @NotNull View paramView, @NotNull b paramb) {
    f.m(paramString, "arg0");
    f.m(paramView, "arg1");
    f.m(paramb, "arg2");
    ShopMoreInfoSettingsFragment.i(this.cBV).aea().setVisibility(8);
    ShopMoreInfoSettingsFragment.i(this.cBV).adZ().setVisibility(8);
    ShopMoreInfoSettingsFragment.i(this.cBV).aeb().setVisibility(0);
  }
  
  public void e(@NotNull String paramString, @NotNull View paramView) {
    f.m(paramString, "arg0");
    f.m(paramView, "arg1");
  }
  
  public void f(@NotNull String paramString, @NotNull View paramView) {
    f.m(paramString, "arg0");
    f.m(paramView, "arg1");
    ShopMoreInfoSettingsFragment.i(this.cBV).aea().setVisibility(0);
    ShopMoreInfoSettingsFragment.i(this.cBV).adZ().setVisibility(8);
    ShopMoreInfoSettingsFragment.i(this.cBV).aeb().setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */