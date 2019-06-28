package com.laiqian.print.model.type.usb.b;

import java.io.File;

public class a {
  private String cIv;
  
  public a(String paramString) { this.cIv = paramString; }
  
  public String lx(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.cIv);
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    return e.lD(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */