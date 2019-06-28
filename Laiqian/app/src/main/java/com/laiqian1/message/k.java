package com.laiqian.message;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class k {
  private final a bIR;
  
  private final Map<String, i.a> bIS = new HashMap();
  
  private final List<b> bIT = new ArrayList();
  
  private final Context context;
  
  private boolean enabled = true;
  
  public k(Context paramContext, a parama) {
    this.context = paramContext;
    this.bIR = parama;
  }
  
  private void Ts() {
    Intent intent = new Intent(this.context, RequestMessageService2.class);
    this.context.startService(intent);
  }
  
  private void Tt() {
    Intent intent = new Intent(this.context, RequestMessageService2.class);
    this.context.stopService(intent);
  }
  
  public i Tr() { return a.a(this.bIR); }
  
  public void a(i.a parama) { this.bIS.put(parama.name(), parama); }
  
  public void a(b paramb) { this.bIT.add(paramb); }
  
  public i.a gB(String paramString) { return (i.a)this.bIS.get(paramString); }
  
  public List<b> getCallbacks() { return Collections.unmodifiableList(this.bIT); }
  
  public void start() {
    if (this.enabled)
      Ts(); 
  }
  
  public void stop() { Tt(); }
  
  public static class a {
    private final i bIU;
    
    private a(a param1a) { this.bIU = a.a(param1a); }
    
    public static class a {
      private i bIU = null;
      
      public k.a Tu() { return new k.a(this, null); }
      
      public a a(i param2i) {
        this.bIU = param2i;
        return this;
      }
    }
  }
  
  public static class a {
    private i bIU = null;
    
    public k.a Tu() { return new k.a(this, null); }
    
    public a a(i param1i) {
      this.bIU = param1i;
      return this;
    }
  }
  
  public static interface b {
    boolean ci(String param1String);
    
    void cj(String param1String);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */