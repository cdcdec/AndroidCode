package com.laiqian.main.module.hardware.weight;

import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import com.jakewharton.b.b;
import com.laiqian.d.a;
import com.laiqian.scales.a;
import com.laiqian.scales.a.e;
import com.laiqian.scales.b.b;
import com.laiqian.scales.c.b;
import io.reactivex.a.a;
import io.reactivex.android.b.a;
import io.reactivex.c;
import io.reactivex.g.a;
import io.reactivex.g.b;
import io.reactivex.h;
import io.reactivex.k;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class c {
  private static c bgr;
  
  private static final b bgt = new g(0.0D);
  
  @Nullable
  private a bgs;
  
  private b<b<? extends b>> bgu = b.ak(new b(bgt, 0L, TimeUnit.MILLISECONDS));
  
  private a bgv = new a();
  
  public static c MD() {
    if (bgr == null)
      bgr = new c(); 
    return bgr;
  }
  
  @Nullable
  public a ME() { return this.bgs; }
  
  public void MF() { this.bgv.b(h.b(0L, 200L, TimeUnit.MILLISECONDS).a(new d(this)).c(new e(this)).b(TimeUnit.MILLISECONDS).b(this.bgu)); }
  
  public void MG() { this.bgv.clear(); }
  
  public void MH() {
    if (this.bgs != null)
      try {
        this.bgs.CV();
        MF();
        return;
      } catch (Exception exception) {
        a.e(exception);
      }  
  }
  
  public void MI() {
    if (this.bgs != null && this.bgs.isOpened()) {
      this.bgs.CW();
      MG();
    } 
  }
  
  public Double MJ() throws Exception {
    if (this.bgs == null)
      return null; 
    if (!this.bgs.isOpened())
      MH(); 
    b b1 = (b)this.bgu.getValue();
    return (System.currentTimeMillis() - b1.aKj() < TimeUnit.SECONDS.toMillis(1L)) ? Double.valueOf(((b)b1.value()).getWeight()) : null;
  }
  
  public Double MK() throws Exception { return a.AZ().BE() ? MD().MJ() : (a.AZ().BF() ? ML() : null); }
  
  public Double ML() throws Exception {
    b b1 = b.ak(Double.valueOf(-1.0D));
    c.b(f.bgx).b(a.aKh()).a(a.aJo()).b(b1);
    return (Double)b1.getValue();
  }
  
  public void a(a parama) { this.bgs = parama; }
  
  public void ag(double paramDouble) {
    if (this.bgs == null)
      return; 
    if (!this.bgs.isOpened())
      MH(); 
    try {
      String str = String.format("%07.2f", new Object[] { Double.valueOf(paramDouble) }).replace(".", "");
      int i = Math.max(0, str.length() - 6);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str.substring(i, str.length()));
      stringBuilder.append("\n\r");
      byte[] arrayOfByte = stringBuilder.toString().getBytes();
      this.bgs.write(arrayOfByte);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\hardware\weight\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */