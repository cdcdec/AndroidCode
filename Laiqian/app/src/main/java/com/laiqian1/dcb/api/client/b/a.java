package com.laiqian.dcb.api.client.b;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.laiqian.dcb.api.b.a;
import com.laiqian.dcb.api.b.g;
import com.laiqian.dcb.api.b.k;
import java.io.File;

public class a extends Thread {
  public static boolean aPm = false;
  
  String aPj;
  
  String aPk;
  
  a aPl;
  
  private Context mContext;
  
  static  {
  
  }
  
  private boolean DL() {
    null = new StringBuilder();
    null.append(this.mContext.getFilesDir().getAbsolutePath());
    null.append("/laiqian_download.lq");
    String str1 = null.toString();
    String str2 = ((TelephonyManager)this.mContext.getSystemService("phone")).getDeviceId();
    g g = new g(this.mContext);
    String str3 = g.Ea();
    g.close();
    String str4 = this.aPk;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append("android");
    stringBuilder.append(str3);
    int i = b.m(str4, str1, stringBuilder.toString());
    boolean bool = true;
    boolean bool1 = false;
    if (i != 1)
      bool = false; 
    if (bool) {
      (new File(this.aPk)).delete();
      bool1 = (new k(this.mContext, str1, a.j(this.mContext, "laiqian.db"), "db", k.aQf)).aQh;
    } 
    return bool1;
  }
  
  private void ej(int paramInt) {
    aPm = false;
    if (this.aPl != null)
      this.aPl.ej(paramInt); 
  }
  
  public void run() { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  public static interface a {
    void ej(int param1Int);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\client\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */