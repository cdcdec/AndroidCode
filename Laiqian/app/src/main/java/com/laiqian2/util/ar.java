package com.laiqian.util;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.laiqian.d.a;
import java.util.regex.Pattern;

public class ar {
  public static InputFilter[] asW() { return new InputFilter[] { new as() }; }
  
  public static InputFilter[] bE(int paramInt1, int paramInt2) {
    String str;
    if (paramInt2 > 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("(\\.\\d{0,");
      stringBuilder1.append(paramInt2);
      stringBuilder1.append("})?");
      str = stringBuilder1.toString();
    } else {
      str = "";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(-)?\\d{0,");
    stringBuilder.append(paramInt1);
    stringBuilder.append("}");
    stringBuilder.append(str);
    return new InputFilter[] { new a(stringBuilder.toString()) };
  }
  
  public static InputFilter[] lw(int paramInt) { return bE(paramInt, a.AZ().Be()); }
  
  public static InputFilter lx(int paramInt) {
    String str;
    int i = a.AZ().Be();
    if (i > 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("(\\.\\d{0,");
      stringBuilder1.append(i);
      stringBuilder1.append("})?");
      str = stringBuilder1.toString();
    } else {
      str = "";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(-)?\\d{0,");
    stringBuilder.append(paramInt);
    stringBuilder.append("}");
    stringBuilder.append(str);
    return new a(stringBuilder.toString());
  }
  
  private static class a implements InputFilter {
    String dFA;
    
    public a(String param1String) { this.dFA = param1String; }
    
    public CharSequence filter(CharSequence param1CharSequence, int param1Int1, int param1Int2, Spanned param1Spanned, int param1Int3, int param1Int4) {
      CharSequence charSequence = TextUtils.concat(new CharSequence[] { param1Spanned.subSequence(0, param1Int3), param1CharSequence, param1Spanned.subSequence(param1Int4, param1Spanned.length()) });
      return Pattern.matches(this.dFA, charSequence) ? (((param1CharSequence.length() == 0 || param1CharSequence.toString().startsWith(".")) && charSequence.toString().startsWith(".")) ? TextUtils.concat(new CharSequence[] { "0", param1CharSequence }) : null) : ((param1Int4 - param1Int3 > 0 && param1CharSequence.length() == 0) ? param1Spanned.subSequence(param1Int3, param1Int4) : "");
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */