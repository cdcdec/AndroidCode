package com.laiqian.main.b;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;

public class e implements InputFilter {
  int bpA;
  
  boolean bpB;
  
  boolean bpC;
  
  boolean bpz;
  
  public e(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3) {
    this.bpz = paramBoolean1;
    this.bpA = paramInt;
    this.bpB = paramBoolean2;
    this.bpC = paramBoolean3;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4) {
    if (this.bpB) {
      if (this.bpz && this.bpC)
        return null; 
      paramCharSequence = TextUtils.concat(new CharSequence[] { paramSpanned.subSequence(0, paramInt3), paramCharSequence, paramSpanned.subSequence(paramInt4, paramSpanned.length()) }).toString();
      paramInt1 = paramCharSequence.indexOf(".");
      if (paramInt1 != -1 && paramCharSequence.length() - 1 - paramInt1 == this.bpA) {
        paramInt1 = paramCharSequence.charAt(paramCharSequence.length() - 1);
        return (paramInt1 != 48) ? ((paramInt1 == 53) ? null : "") : null;
      } 
      return null;
    } 
    return null;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */