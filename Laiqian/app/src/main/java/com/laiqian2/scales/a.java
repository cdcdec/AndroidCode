package com.laiqian.scales;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.laiqian.scales.a.a;
import com.laiqian.scales.a.b;
import com.laiqian.scales.b.a;
import com.laiqian.scales.c.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class a {
  private final ByteBuffer diw;
  
  private final a dix;
  
  private b diy;
  
  private boolean opened = false;
  
  public a(@NonNull a parama, b paramb) {
    this.dix = parama;
    this.diy = paramb;
    this.diw = ByteBuffer.allocate(1024);
  }
  
  public boolean CV() throws IOException {
    this.opened = this.dix.CV();
    return this.opened;
  }
  
  public boolean CW() throws IOException { return this.dix.CW(); }
  
  @Nullable
  public b aoM() throws IOException {
    if (!this.opened)
      throw new IllegalStateException("not opened"); 
    ArrayList arrayList = aoN();
    return (arrayList.size() > 0) ? (b)arrayList.get(arrayList.size() - 1) : null;
  }
  
  public ArrayList<? extends b> aoN() throws IOException {
    if (!this.opened)
      throw new IllegalStateException("not opened"); 
    byte[] arrayOfByte = new byte[64];
    int i = this.dix.read(arrayOfByte, 0, arrayOfByte.length);
    if (i == -1)
      throw new IOException("error: read returned -1"); 
    if (this.diw.remaining() < i)
      this.diw.clear(); 
    this.diw.put(arrayOfByte, 0, i);
    str = (new String(this.diw.array(), false, this.diw.position())).intern();
    ArrayList arrayList = new ArrayList();
    i = 1;
    try {
      ArrayList arrayList1 = this.diy.nE(str);
      arrayList = arrayList1;
    } catch (a str) {
      i = 0;
    } 
    if (arrayList.size() == 0)
      i = 0; 
    if (i != 0)
      this.diw.clear(); 
    return arrayList;
  }
  
  public boolean isOpened() throws IOException { return this.opened; }
  
  public void write(byte[] paramArrayOfByte) throws IOException {
    if (!this.opened)
      throw new IllegalStateException("not opened"); 
    this.dix.write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scales\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */