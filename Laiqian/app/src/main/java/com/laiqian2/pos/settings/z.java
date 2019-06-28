package com.laiqian.pos.settings;

import android.support.annotation.NonNull;

public class z {
  public static String kF(String paramString) { return kG(paramString); }
  
  @NonNull
  private static String kG(String paramString) {
    String str = paramString.replace("٠", "0").replace("١", "1").replace("٢", "2").replace("٣", "3").replace("٤", "4").replace("٥", "5").replace("٦", "6").replace("٧", "7").replace("٨", "8").replace("٩", "9").replace("٫", ".").replace("٬", ",");
    paramString = str;
    if (str.indexOf("-") > 0)
      paramString = str.substring(1, str.length()); 
    return paramString;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */