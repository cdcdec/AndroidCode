package com.laiqian.util;

import android.text.InputFilter;
import android.text.Spanned;

final class as implements InputFilter {
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4) { return paramCharSequence.equals("'") ? "" : null; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */