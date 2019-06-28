package com.laiqian.entity;

import android.os.Handler;
import android.widget.TextView;
import com.laiqian.main.bb;

public class n {
  private String aSr;
  
  private TextView aSs;
  
  private int aSt;
  
  private long aSu;
  
  private boolean aSv;
  
  private boolean aSw;
  
  private bb aSx;
  
  private Handler handler;
  
  private String orderNo;
  
  private n() {}
  
  private n(a parama) {
    this.orderNo = a.a(parama);
    this.handler = a.b(parama);
    this.aSr = a.c(parama);
    this.aSs = a.d(parama);
    this.aSt = a.e(parama);
    this.aSu = a.f(parama);
    this.aSw = a.g(parama);
    this.aSv = a.h(parama);
    this.aSx = a.i(parama);
  }
  
  public boolean Fj() { return this.aSv; }
  
  public boolean Fk() { return this.aSw; }
  
  public String Fl() { return this.aSr; }
  
  public TextView Fm() { return this.aSs; }
  
  public int Fn() { return this.aSt; }
  
  public long Fo() { return this.aSu; }
  
  public bb Fp() { return this.aSx; }
  
  public q Fq() { return (new q.a()).b(this.aSx).df(this.orderNo).aj(this.aSu).dg(this.aSr).Fy(); }
  
  public void ah(long paramLong) { this.aSu = paramLong; }
  
  public void da(String paramString) { this.orderNo = paramString; }
  
  public Handler getHandler() { return this.handler; }
  
  public String xq() { return this.orderNo; }
  
  public static class a {
    private String aSr;
    
    private TextView aSs;
    
    private int aSt;
    
    private long aSu;
    
    private boolean aSv;
    
    private boolean aSw;
    
    private bb aSx;
    
    private Handler handler;
    
    private String orderNo;
    
    public n Fr() { return new n(this, null); }
    
    public a a(bb param1bb) {
      this.aSx = param1bb;
      return this;
    }
    
    public a ai(long param1Long) {
      this.aSu = param1Long;
      return this;
    }
    
    public a b(Handler param1Handler) {
      this.handler = param1Handler;
      return this;
    }
    
    public a cA(boolean param1Boolean) {
      this.aSv = param1Boolean;
      return this;
    }
    
    public a cB(boolean param1Boolean) {
      this.aSw = param1Boolean;
      return this;
    }
    
    public a db(String param1String) {
      this.orderNo = param1String;
      return this;
    }
    
    public a dc(String param1String) {
      this.aSr = param1String;
      return this;
    }
    
    public a e(TextView param1TextView) {
      this.aSs = param1TextView;
      return this;
    }
    
    public a eu(int param1Int) {
      this.aSt = param1Int;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */