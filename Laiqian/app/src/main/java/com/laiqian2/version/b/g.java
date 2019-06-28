package com.laiqian.version.b;

import java.util.regex.Pattern;

public class g {
  protected static String sm(String paramString) {
    Pattern pattern = Pattern.compile(".*[0-9]{11}.*");
    boolean bool;
    for (bool = pattern.matcher(paramString).matches(); bool; bool = pattern.matcher(paramString).matches()) {
      byte b2 = 0;
      byte b3 = 0;
      byte b1 = 0;
      while (b2 < paramString.length()) {
        if (Character.isDigit(paramString.charAt(b2))) {
          byte b = b1 + true;
          b1 = b;
          if (b == 11) {
            b3 = b2 - 10;
            b1 = b;
          } 
        } else {
          b1 = 0;
        } 
        b2++;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString.subSequence(0, b3).toString());
      stringBuilder.append("***********");
      paramString = stringBuilder.toString();
    } 
    return paramString;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */