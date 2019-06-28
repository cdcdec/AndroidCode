package com.laiqian.util;

import android.graphics.Color;
import android.text.Html;
import android.text.Spanned;

public class bt {
  public static Spanned a(String paramString, String[] paramArrayOfString, a[] paramArrayOfa) {
    if (paramArrayOfString.length != paramArrayOfa.length)
      return null; 
    String[] arrayOfString = new String[paramArrayOfString.length];
    for (byte b = 0; b < paramArrayOfString.length; b++) {
      String str;
      arrayOfString[b] = (str = paramArrayOfString[b]).format("<font color=\"%s\">%s</font>", new Object[] { paramArrayOfa[b].toString(), str });
    } 
    return Html.fromHtml(String.format(paramString, arrayOfString));
  }
  
  public static class a {
    private String dGq;
    
    private a(String param1String) { this.dGq = param1String; }
    
    public static a mj(int param1Int) {
      int i = Color.blue(param1Int);
      int j = Color.red(param1Int);
      param1Int = Color.green(param1Int);
      return new a(String.format("#%s%s%s", new Object[] { String.format("%02x", new Object[] { Integer.valueOf(j) }), String.format("%02x", new Object[] { Integer.valueOf(param1Int) }), String.format("%02x", new Object[] { Integer.valueOf(i) }) }));
    }
    
    public static a rX(String param1String) { return new a(param1String); }
    
    public String toString() { return this.dGq; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\util\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */