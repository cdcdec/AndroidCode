package com.laiqian.print.cardreader;

import com.laiqian.print.model.type.usb.a.a;
import java.io.Serializable;

public class ah implements Serializable {
  private a cEN;
  
  private ai cEO;
  
  public ah(a parama, ai paramai) {
    this.cEN = parama;
    this.cEO = paramai;
  }
  
  public ai afl() { return this.cEO; }
  
  public a afr() { return this.cEN; }
  
  public void b(ai paramai) { this.cEO = paramai; }
  
  public void d(ah paramah) {
    this.cEN = paramah.afr();
    this.cEO = paramah.afl();
  }
  
  public boolean equals(Object paramObject) {
    byte b = 0;
    if (paramObject == null)
      return false; 
    if (paramObject instanceof ah) {
      if (paramObject == this)
        return true; 
      paramObject = (ah)paramObject;
      int i = b;
      if (paramObject.cEN.equals(this.cEN)) {
        i = b;
        if (paramObject.cEO.equals(this.cEO))
          i = 1; 
      } 
      return i;
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */