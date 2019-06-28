package com.laiqian.report.a;

import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.network.i;
import com.laiqian.network.k;
import com.laiqian.pos.industry.a;
import java.util.HashMap;
import java.util.TimerTask;

public class a extends TimerTask {
  private final int btX;
  
  a cZe;
  
  private String mOrderNo;
  
  private int times = 0;
  
  public a(String paramString, int paramInt) {
    this.mOrderNo = paramString;
    this.btX = paramInt;
  }
  
  private i aml() {
    hashMap = new HashMap();
    hashMap.put("out_trade_no", this.mOrderNo);
    hashMap.put("shop_id", RootApplication.getLaiqianPreferenceManager().Tx());
    null = new StringBuilder();
    null.append(RootApplication.getLaiqianPreferenceManager().avs());
    null.append("");
    hashMap.put("pay_mode", null.toString());
    String str = jF(this.btX);
    try {
      return (new k()).a(hashMap, str, 1);
    } catch (Exception hashMap) {
      a.e(hashMap);
      return new i(false, false, "Result Parse Error.");
    } 
  }
  
  public static boolean f(i parami) { return (parami.bUj == 303); }
  
  public void a(a parama) { this.cZe = parama; }
  
  public String jF(int paramInt) { return (paramInt != 10007) ? ((paramInt != 10009) ? "" : a.cqR) : a.cqI; }
  
  public void run() {
    i i = aml();
    this.times++;
    if (this.cZe == null)
      return; 
    if (i.bUi) {
      this.cZe.g(i);
      return;
    } 
    if (f(i)) {
      this.cZe.a(i, this.times);
      return;
    } 
    this.cZe.h(i);
  }
  
  public static interface a {
    void a(i param1i, int param1Int);
    
    void g(i param1i);
    
    void h(i param1i);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */