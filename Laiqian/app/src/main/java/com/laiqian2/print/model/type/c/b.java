package com.laiqian.print.model.type.c;

import java.io.InputStream;
import java.util.concurrent.Callable;

class b extends Object implements Callable<Boolean> {
  b(a parama, InputStream paramInputStream) {}
  
  public Boolean Md() throws Exception {
    byte[] arrayOfByte = new byte[1];
    if (this.cIh.read(arrayOfByte, 0, 1) == 1) {
      if (arrayOfByte[0] == 19)
        return Boolean.valueOf(false); 
      if (arrayOfByte[0] == 17)
        return Boolean.valueOf(true); 
    } 
    return Boolean.valueOf(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\type\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */