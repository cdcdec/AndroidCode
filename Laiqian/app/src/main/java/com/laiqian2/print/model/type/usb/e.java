package com.laiqian.print.model.type.usb;

import android.content.Context;
import java.io.File;

public class e {
  private static e cIr;
  
  private a cIs;
  
  private e(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((paramContext.getApplicationInfo()).dataDir);
    stringBuilder.append(File.separator);
    stringBuilder.append("printer.json");
    this.cIs = new c(new File(stringBuilder.toString()));
  }
  
  public static e bf(Context paramContext) {
    if (cIr == null)
      cIr = new e(paramContext.getApplicationContext()); 
    return cIr;
  }
  
  public b lw(String paramString) { return this.cIs.lv(paramString); }
  
  public static interface a {
    b lv(String param1String);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */