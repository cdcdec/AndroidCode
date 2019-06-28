package com.laiqian.report.a;

import android.content.Context;
import android.os.AsyncTask;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.f;
import com.laiqian.network.i;
import com.laiqian.network.k;
import com.laiqian.pos.industry.a;
import java.util.HashMap;

public class b extends AsyncTask<Void, Void, i> {
  private double aJW;
  
  private final int btX;
  
  private String cZf;
  
  private a cZg;
  
  private Context mContext;
  
  private String mOrderNo;
  
  public b(Context paramContext, String paramString1, String paramString2, double paramDouble, int paramInt, a parama) {
    this.mContext = paramContext;
    this.mOrderNo = paramString1;
    this.cZf = paramString2;
    this.aJW = paramDouble;
    this.btX = paramInt;
    this.cZg = parama;
  }
  
  public static boolean f(i parami) { return (parami.bUj == 203); }
  
  protected void a(i parami) {
    if (parami == null)
      return; 
    if (this.cZg == null)
      return; 
    if (parami.bUi) {
      this.cZg.g(parami);
      return;
    } 
    this.cZg.h(parami);
  }
  
  protected i c(Void... paramVarArgs) {
    hashMap = new HashMap();
    hashMap.put("out_trade_no", this.mOrderNo);
    hashMap.put("out_refund_no", this.cZf);
    null = new StringBuilder();
    null.append(this.aJW);
    null.append("");
    hashMap.put("total_amount", null.toString());
    hashMap.put("shop_id", RootApplication.getLaiqianPreferenceManager().Tx());
    null = new StringBuilder();
    null.append(RootApplication.getLaiqianPreferenceManager().avs());
    null.append("");
    hashMap.put("pay_mode", null.toString());
    f.e(hashMap);
    String str = jG(this.btX);
    try {
      return (new k()).a(hashMap, str, 1);
    } catch (Exception hashMap) {
      a.e(hashMap);
      return null;
    } 
  }
  
  public String jG(int paramInt) { return (paramInt != 10007) ? ((paramInt != 10009) ? "" : a.cqQ) : a.cqH; }
  
  public static interface a {
    void g(i param1i);
    
    void h(i param1i);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */