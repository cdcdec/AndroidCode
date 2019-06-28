package com.laiqian.print.b;

import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.PrintContent.IntFontSize;
import com.laiqian.print.util.e;
import java.nio.charset.Charset;
import java.util.HashMap;

public abstract class a implements e {
  private PrintContent.a cGp = new PrintContent.a();
  
  private HashMap<Integer, int[]> cGq = new HashMap();
  
  private HashMap<Integer, int[]> cGr = new HashMap();
  
  private int cGs = 1;
  
  @IntFontSize
  private int size = 0;
  
  private int width = 58;
  
  public a() {}
  
  public a(a parama) {
    this.width = parama.width;
    this.cGq.putAll(parama.cGq);
    this.cGr.putAll(parama.cGr);
    this.size = parama.size;
    this.cGs = parama.cGs;
  }
  
  public a(PrintContent.a parama) {}
  
  public PrintContent.a afT() { return this.cGp; }
  
  public int afU() { return this.cGs; }
  
  public PrintContent afV() { return this.cGp.afV(); }
  
  public void f(String paramString, int paramInt1, int paramInt2) {
    byte[] arrayOfByte;
    if (e.mm(paramString)) {
      arrayOfByte = e.mp(paramString);
      switch (paramInt1) {
        default:
          return;
        case 3:
          this.cGp.c(new String(arrayOfByte, Charset.forName("cp864")), false, false, paramInt2, true, true);
          return;
        case 2:
          this.cGp.c(new String(arrayOfByte, Charset.forName("cp864")), false, false, paramInt2, true, false);
          return;
        case 1:
          this.cGp.c(new String(arrayOfByte, Charset.forName("cp864")), false, false, paramInt2, false, true);
          return;
        case 0:
          break;
      } 
      this.cGp.c(new String(arrayOfByte, Charset.forName("cp864")), false, false, paramInt2, false, false);
      return;
    } 
    e.a(this.cGp, new int[] { e.jg(this.width) }, new int[] { paramInt2 }, new String[] { arrayOfByte }, paramInt1);
  }
  
  @IntFontSize
  public int getSize() { return this.size; }
  
  public int getWidth() { return this.width; }
  
  public void ic(int paramInt) { this.cGs = paramInt; }
  
  public int[] id(int paramInt) {
    int i = e.jg(this.width) / paramInt;
    int[] arrayOfInt = new int[paramInt];
    for (byte b = 0; b < paramInt; b++)
      arrayOfInt[b] = i; 
    return arrayOfInt;
  }
  
  public int[] ie(int paramInt) {
    int[] arrayOfInt = new int[paramInt];
    for (byte b = 0; b < paramInt; b++) {
      byte b1;
      if (!b) {
        b1 = 0;
      } else {
        b1 = 2;
      } 
      arrayOfInt[b] = b1;
    } 
    return arrayOfInt;
  }
  
  public int[] if(int paramInt) {
    int[] arrayOfInt2 = (int[])this.cGq.get(Integer.valueOf(paramInt));
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null)
      arrayOfInt1 = id(paramInt); 
    return arrayOfInt1;
  }
  
  public int[] ig(int paramInt) {
    int[] arrayOfInt2 = (int[])this.cGr.get(Integer.valueOf(paramInt));
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null)
      arrayOfInt1 = ie(paramInt); 
    return arrayOfInt1;
  }
  
  public void l(char paramChar) {
    int i = e.jg(this.width);
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < i; b++)
      stringBuilder.append(paramChar); 
    afT().ln(stringBuilder.toString());
  }
  
  public void lk(String paramString) {
    byte[] arrayOfByte;
    if (e.mm(paramString)) {
      arrayOfByte = e.mp(paramString);
      this.cGp.c(new String(arrayOfByte, Charset.forName("cp864")), false, false, 1, true, true);
      return;
    } 
    this.cGp.h(arrayOfByte, 3, 1);
  }
  
  public void ll(String paramString) {
    byte[] arrayOfByte;
    if (e.mm(paramString)) {
      arrayOfByte = e.mp(paramString);
      this.cGp.lo(new String(arrayOfByte, Charset.forName("cp864")));
      return;
    } 
    PrintContent.a a1 = this.cGp;
    int i = e.jg(this.width);
    int j = this.size;
    e.a(a1, new int[] { i }, new int[] { 0 }, new String[] { arrayOfByte }, j);
  }
  
  public void n(int[] paramArrayOfInt) {
    if (paramArrayOfInt == null)
      throw new NullPointerException("parameter cannot be null"); 
    this.cGq.put(Integer.valueOf(paramArrayOfInt.length), paramArrayOfInt);
  }
  
  public void o(int[] paramArrayOfInt) {
    if (paramArrayOfInt == null)
      throw new NullPointerException("parameter cannot be null"); 
    this.cGr.put(Integer.valueOf(paramArrayOfInt.length), paramArrayOfInt);
  }
  
  public void setSize(@IntFontSize int paramInt) { this.size = paramInt; }
  
  public void setWidth(int paramInt) { this.width = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */