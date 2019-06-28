package com.laiqian.pos.hardware.a;

import eu.chainfire.libsuperuser.b;
import java.io.IOException;

public class g implements a {
  public void setEnabled(boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      b.f.tn("echo 1 > /sys/class/gpio/gpio56/data");
      return;
    } 
    b.f.tn("echo 0 > /sys/class/gpio/gpio56/data");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\hardware\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */