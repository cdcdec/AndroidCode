package com.laiqian.print.dualscreen;

import java.util.Comparator;

class c extends Object implements Comparator<String> {
  c(a.a parama) {}
  
  public int compare(String paramString1, String paramString2) { return Integer.parseInt(paramString1.substring(paramString1.lastIndexOf('_') + 1, paramString1.lastIndexOf('.'))) - Integer.parseInt(paramString2.substring(paramString2.lastIndexOf('_') + 1, paramString2.lastIndexOf('.'))); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\dualscreen\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */