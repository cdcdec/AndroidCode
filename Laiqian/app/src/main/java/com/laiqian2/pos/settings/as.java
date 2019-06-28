package com.laiqian.pos.settings;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.e.g;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class as implements TextWatcher {
  as(ShopBasicInfoFragment paramShopBasicInfoFragment) {}
  
  public void afterTextChanged(@NotNull Editable paramEditable) { f.m(paramEditable, "s"); }
  
  public void beforeTextChanged(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) { f.m(paramCharSequence, "s"); }
  
  public void onTextChanged(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    f.m(paramCharSequence, "s");
    if (g.a((CharSequence)paramCharSequence.toString(), (CharSequence)".", false, 2, null)) {
      paramCharSequence = (CharSequence)paramCharSequence.toString();
      paramInt2 = paramCharSequence.length() - 1;
      paramInt1 = 0;
      paramInt3 = 0;
      while (paramInt1 <= paramInt2) {
        int i;
        if (paramInt3 == 0) {
          i = paramInt1;
        } else {
          i = paramInt2;
        } 
        if (paramCharSequence.charAt(i) <= ' ') {
          i = 1;
        } else {
          i = 0;
        } 
        if (paramInt3 == 0) {
          if (i == 0) {
            paramInt3 = 1;
            continue;
          } 
          paramInt1++;
          continue;
        } 
        if (i == 0)
          break; 
        paramInt2--;
      } 
      paramCharSequence = g.a(paramCharSequence.subSequence(paramInt1, paramInt2 + 1).toString(), ".", "", false, 4, null);
      ShopBasicInfoFragment.a(this.cAE).adr().oX(paramCharSequence);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */