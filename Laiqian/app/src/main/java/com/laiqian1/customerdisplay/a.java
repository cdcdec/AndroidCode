package com.laiqian.customerdisplay;

import com.laiqian.customerdisplay.a.a;
import java.io.IOException;

public class a {
  private final a aNi;
  
  private boolean opened = false;
  
  public a(a parama) { this.aNi = parama; }
  
  public a CU() { return this.aNi; }
  
  public boolean CV() throws IOException {
    this.opened = this.aNi.CV();
    return this.opened;
  }
  
  public boolean CW() throws IOException { return this.aNi.CW(); }
  
  public void CX() throws IOException { r(b.Da()); }
  
  public void CY() throws IOException { r(b.Db()); }
  
  public void CZ() throws IOException { r(b.Dc()); }
  
  public void b(Number paramNumber) throws IOException { cm(paramNumber.toString()); }
  
  public void cm(String paramString) throws IOException { r(b.cn(paramString.substring(0, Math.min(9, paramString.length())))); }
  
  public boolean isOpened() throws IOException { return this.opened; }
  
  public void r(byte[] paramArrayOfByte) throws IOException {
    int i = this.aNi.write(paramArrayOfByte, 0, paramArrayOfByte.length);
    if (i != paramArrayOfByte.length) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("send failed, expected length: ");
      stringBuilder.append(paramArrayOfByte.length);
      stringBuilder.append(", actual sent: ");
      stringBuilder.append(i);
      throw new IOException(stringBuilder.toString());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\customerdisplay\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */