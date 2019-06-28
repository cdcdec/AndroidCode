package com.laiqian.print.model.type.usb.b;

import java.io.File;
import java.util.HashMap;

public class k {
  private HashMap<String, f> cIP = new HashMap();
  
  private void lE(String paramString) {
    this.cIP.clear();
    File[] arrayOfFile = (new File("/sys/bus/usb/devices")).listFiles(new l(this));
    if (arrayOfFile == null)
      return; 
    int i = arrayOfFile.length;
    for (byte b = 0; b < i; b++) {
      f f = f.B(arrayOfFile[b]);
      if (f != null)
        this.cIP.put(f.getName(), f); 
    } 
  }
  
  public HashMap<String, f> ahf() {
    lE("/sys/bus/usb/devices/");
    return this.cIP;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */