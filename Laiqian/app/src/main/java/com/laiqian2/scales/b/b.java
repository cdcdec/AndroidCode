package com.laiqian.scales.b;

import java.io.File;
import java.io.IOException;
import me.raid.libserialport.serialport.SerialPort;

public class b implements a {
  private SerialPort aNj;
  
  public b(File paramFile, int paramInt1, int paramInt2) { this.aNj = new SerialPort(paramFile, paramInt1, paramInt2); }
  
  public boolean CV() throws IOException {
    this.aNj.open();
    return true;
  }
  
  public boolean CW() throws IOException {
    this.aNj.close();
    return true;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2) throws IOException { return this.aNj.getInputStream().read(paramArrayOfByte, paramInt1, paramInt2); }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) throws IOException { this.aNj.getOutputStream().write(paramArrayOfByte, paramInt1, paramInt2); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scales\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */