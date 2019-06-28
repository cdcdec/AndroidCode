package com.laiqian.print.model.a;

import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.b;
import com.laiqian.print.model.s;
import com.laiqian.print.util.a;

public class e implements b {
  private final b cHn;
  
  public e(b paramb) { this.cHn = paramb; }
  
  private PrintContent b(PrintContent paramPrintContent) {
    PrintContent.a a = new PrintContent.a();
    int i = paramPrintContent.Xi().size();
    for (byte b1 = 0; b1 < i; b1++) {
      PrintContent.b b2 = (PrintContent.b)paramPrintContent.Xi().get(b1);
      int k = b2.agr();
      int j = b2.getType();
      if (b2.agl()) {
        a.c(b2);
      } else if (b2.agk()) {
        a.c(b2);
      } else if (b2.agn()) {
        a.c(b2);
      } else if (b2.vS()) {
        k = ij(k);
        a.c(new PrintContent.b(b2.getString(), k, j));
      } 
    } 
    a.ih(paramPrintContent.getCopies());
    return a.afV();
  }
  
  private int ij(int paramInt) { return a.k(paramInt, 4, 5); }
  
  public byte[] a(PrintContent paramPrintContent, s params) { return this.cHn.a(b(paramPrintContent), params); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */