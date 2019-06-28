package com.laiqian.print.util;

import java.io.Serializable;

public final class b implements Serializable {
  private byte[] buffer;
  
  private int len;
  
  public b(int paramInt) {
    if (paramInt < 0)
      throw new IllegalArgumentException("capacity cannot be negative"); 
    this.buffer = new byte[paramInt];
  }
  
  private void ed(int paramInt) {
    byte[] arrayOfByte = new byte[Math.max(this.buffer.length << 1, paramInt)];
    System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.len);
    this.buffer = arrayOfByte;
  }
  
  public void append(int paramInt) {
    int i = this.len + 1;
    if (i > this.buffer.length)
      ed(i); 
    this.buffer[this.len] = (byte)paramInt;
    this.len = i;
  }
  
  public void append(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
    if (paramArrayOfByte == null)
      return; 
    if (paramInt1 >= 0 && paramInt1 <= paramArrayOfByte.length && paramInt2 >= 0) {
      int i = paramInt1 + paramInt2;
      if (i >= 0 && i <= paramArrayOfByte.length) {
        if (paramInt2 == 0)
          return; 
        i = this.len + paramInt2;
        if (i > this.buffer.length)
          ed(i); 
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.len, paramInt2);
        this.len = i;
        return;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("off: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" len: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" b.length: ");
    stringBuilder.append(paramArrayOfByte.length);
    throw new IndexOutOfBoundsException(stringBuilder.toString());
  }
  
  public void s(byte[] paramArrayOfByte) {
    if (paramArrayOfByte == null)
      return; 
    append(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public byte[] toByteArray() {
    byte[] arrayOfByte = new byte[this.len];
    if (this.len > 0)
      System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.len); 
    return arrayOfByte;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */