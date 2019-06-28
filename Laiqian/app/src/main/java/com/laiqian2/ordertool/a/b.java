package com.laiqian.ordertool.a;

import android.content.Context;
import com.laiqian.ordertool.ServerGet;

public class b implements a {
  private ServerGet cdv;
  
  private a cdw;
  
  private Context mContext;
  
  public b(ServerGet paramServerGet, int paramInt) {
    this.mContext = paramServerGet.getContext();
    this.cdv = paramServerGet;
    if (paramInt == 2) {
      this.cdw = new d(this.mContext, paramServerGet);
      return;
    } 
    if (paramInt == 0) {
      this.cdw = new c(this.mContext, paramServerGet);
      return;
    } 
    if (paramInt == 1)
      this.cdw = new e(this.mContext, paramServerGet); 
  }
  
  public void close() {
    if (this.mContext != null)
      this.mContext = null; 
    if (this.cdv != null)
      this.cdv = null; 
  }
  
  public int jv(String paramString) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield cdw : Lcom/laiqian/ordertool/a/a;
    //   6: aload_1
    //   7: invokeinterface jv : (Ljava/lang/String;)I
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	17	finally }
  
  public int jw(String paramString) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield cdw : Lcom/laiqian/ordertool/a/a;
    //   6: aload_1
    //   7: invokeinterface jw : (Ljava/lang/String;)I
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	17	finally }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */