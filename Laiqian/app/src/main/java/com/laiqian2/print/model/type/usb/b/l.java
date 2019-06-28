package com.laiqian.print.model.type.usb.b;

import java.io.File;
import java.io.FilenameFilter;

class l implements FilenameFilter {
  l(k paramk) {}
  
  public boolean accept(File paramFile, String paramString) { return paramString.startsWith("usb") ? false : (paramString.contains(":") ? false : (!(paramString.length() >= 3 && paramString.charAt(2) == '0'))); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */