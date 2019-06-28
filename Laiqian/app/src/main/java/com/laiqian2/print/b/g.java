package com.laiqian.print.b;

import com.laiqian.print.model.PrintContent;
import com.laiqian.print.util.e;

public class g extends a {
  public g() { afX(); }
  
  public g(a parama) { super(parama); }
  
  public g(PrintContent.a parama) {
    super(parama);
    afX();
  }
  
  private void afX() {
    n(new int[] { 1 });
    n(new int[] { 1, 1 });
    n(new int[] { 7, 4, 7 });
    n(new int[] { 1, 1, 1, 1 });
  }
  
  public void x(String... paramVarArgs) {
    int n = paramVarArgs.length;
    int[] arrayOfInt1 = if(n);
    int k = 0;
    byte b = 0;
    int i = 0;
    while (b < arrayOfInt1.length) {
      i += arrayOfInt1[b];
      b++;
    } 
    int m = e.jg(getWidth());
    int[] arrayOfInt2 = new int[n];
    int j = m;
    b = k;
    while (true) {
      k = n - 1;
      if (b < k) {
        arrayOfInt2[b] = (int)(m * arrayOfInt1[b] / i);
        j -= arrayOfInt2[b];
        b++;
        continue;
      } 
      break;
    } 
    arrayOfInt2[k] = j;
    e.a(afT(), arrayOfInt2, ig(n), paramVarArgs, getSize());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */