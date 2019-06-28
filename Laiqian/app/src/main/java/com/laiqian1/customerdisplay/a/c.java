package com.laiqian.customerdisplay.a;

import java.io.File;
import java.io.IOException;
import me.raid.libserialport.serialport.SerialPort;

public class c implements a {
  private SerialPort aNj;
  
  public c(File paramFile) { this(paramFile, 9600, 0); }
  
  public c(File paramFile, int paramInt1, int paramInt2) { this.aNj = new SerialPort(paramFile, paramInt1, paramInt2); }
  
  public boolean CV() throws IOException {
    this.aNj.open();
    return true;
  }
  
  public boolean CW() throws IOException {
    this.aNj.close();
    return true;
  }
  
  public void setBaudrate(int paramInt) { this.aNj.setBaudrate(paramInt); }
  
  public int write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) throws IOException {
    this.aNj.getOutputStream().write(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\customerdisplay\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */