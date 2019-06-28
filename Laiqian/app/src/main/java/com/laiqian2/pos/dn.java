package com.laiqian.pos;

import android.content.Context;
import com.laiqian.pos.industry.a;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import java.util.HashMap;

public class dn extends Thread {
  private Context context;
  
  public dn(Context paramContext) { this.context = paramContext; }
  
  public void run() {
    av av = new av(this.context);
    String str1 = av.auU();
    if (str1 == null)
      return; 
    String str2 = av.Tx();
    av.close();
    HashMap hashMap = new HashMap();
    hashMap.put("clientId", str1);
    hashMap.put("shopId", str2);
    bh.a(a.cra, this.context, hashMap);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */