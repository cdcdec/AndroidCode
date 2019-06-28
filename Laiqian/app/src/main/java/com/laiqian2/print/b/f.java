package com.laiqian.print.b;

import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.PrintContent.IntAlign;
import com.laiqian.print.model.PrintContent.IntFontSize;
import java.util.ArrayList;
import java.util.List;

public class f {
  private final List<a> cGt = new ArrayList();
  
  public void a(a parama) { this.cGt.add(parama); }
  
  public void a(PrintContent.a parama) {
    for (a a1 : this.cGt) {
      if (a1.afY() != 1)
        continue; 
      parama.c(a1.afZ());
    } 
  }
  
  public static class a {
    private final int cGu;
    
    private final PrintContent.b cGv;
    
    public a(int param1Int, PrintContent.b param1b) {
      this.cGu = param1Int;
      this.cGv = param1b;
    }
    
    public static a a(String param1String, boolean param1Boolean1, boolean param1Boolean2, @IntAlign int param1Int, boolean param1Boolean3, boolean param1Boolean4) {
      int k;
      int j;
      int i;
      int m = 0;
      if (param1Boolean1) {
        i = 4;
      } else {
        i = 0;
      } 
      if (param1Boolean2) {
        j = 8;
      } else {
        j = 0;
      } 
      if (param1Boolean3) {
        k = 16;
      } else {
        k = 0;
      } 
      if (param1Boolean4)
        m = 32; 
      return new a(true, new PrintContent.b(param1String, param1Int + 0 + i + j + k + m, true));
    }
    
    public static a g(String param1String, @IntFontSize int param1Int1, @IntAlign int param1Int2) {
      StringBuilder stringBuilder;
      switch (param1Int1) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("unknown size: ");
          stringBuilder.append(param1Int1);
          throw new IllegalArgumentException(stringBuilder.toString());
        case 3:
          return a(stringBuilder, false, false, param1Int2, true, true);
        case 2:
          return a(stringBuilder, false, false, param1Int2, true, false);
        case 1:
          return a(stringBuilder, false, false, param1Int2, false, true);
        case 0:
          break;
      } 
      return a(stringBuilder, false, false, param1Int2, false, false);
    }
    
    public int afY() { return this.cGu; }
    
    public PrintContent.b afZ() { return this.cGv; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */