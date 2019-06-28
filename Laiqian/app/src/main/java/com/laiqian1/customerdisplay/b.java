package com.laiqian.customerdisplay;

import com.laiqian.customerdisplay.b.a;

public class b {
  public static byte[] Da() { return new byte[] { 27, 115, 49 }; }
  
  public static byte[] Db() { return new byte[] { 27, 115, 50 }; }
  
  public static byte[] Dc() { return new byte[] { 27, 115, 52 }; }
  
  public static byte[] cn(String paramString) {
    a a = new a(false);
    a.s(new byte[] { 27, 81, 65 });
    a.s(paramString.getBytes());
    a.append(13);
    return a.toByteArray();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\customerdisplay\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */