package com.laiqian.print.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;

public class q {
  private static final b.a cHi = new r();
  
  @NonNull
  private s cCm;
  
  @NonNull
  private final g cHj;
  
  @Nullable
  private b.a cHk = null;
  
  public q(@NonNull g paramg, @NonNull s params) {
    this.cHj = paramg;
    this.cCm = params;
  }
  
  public e D(List<PrintContent> paramList) { return new e(agE(), paramList, agG()); }
  
  public e a(PrintContent paramPrintContent) { return new e(agE(), paramPrintContent, agG()); }
  
  public void a(@Nullable b.a parama) { this.cHk = parama; }
  
  public s agE() { return this.cCm; }
  
  public int agF() { return this.cCm.agF(); }
  
  public b agG() { return (this.cHk != null) ? this.cHk.e(this.cCm) : cHi.e(this.cCm); }
  
  public String getIdentifier() { return this.cCm.getIdentifier(); }
  
  public int getType() { return this.cCm.getType(); }
  
  void i(s params) { this.cCm = params; }
  
  public void ii(int paramInt) { this.cCm.ii(paramInt); }
  
  public boolean isConnected() { return this.cCm.isConnected(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */