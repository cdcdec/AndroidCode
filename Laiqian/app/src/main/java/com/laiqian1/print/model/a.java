package com.laiqian.print.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a implements d {
  private d.a cGw;
  
  private Map<String, q> cGx = new ConcurrentHashMap();
  
  private int mStatus;
  
  public void a(d.a parama) { this.cGw = parama; }
  
  public boolean aeN() { return (this.mStatus == 2); }
  
  protected void afa() {
    setStatus(3);
    d.a a1 = aga();
    if (a1 != null)
      a1.aeV(); 
  }
  
  public d.a aga() { return this.cGw; }
  
  protected void m(q paramq) {
    this.cGx.put(paramq.agE().getIdentifier(), paramq);
    d.a a1 = aga();
    if (a1 != null)
      a1.l(paramq); 
  }
  
  protected void onCancelled() {
    setStatus(5);
    d.a a1 = aga();
    if (a1 != null)
      a1.aeW(); 
  }
  
  protected void onStarted() {
    setStatus(2);
    d.a a1 = aga();
    if (a1 != null)
      a1.aeX(); 
  }
  
  protected void setStatus(int paramInt) { this.mStatus = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\print\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */