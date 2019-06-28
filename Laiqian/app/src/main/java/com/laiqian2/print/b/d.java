package com.laiqian.print.b;

import com.laiqian.print.model.PrintContent;
import com.laiqian.print.util.e;

public class d extends a {
  public d() { afX(); }
  
  public d(PrintContent.a parama) {
    super(parama);
    afX();
  }
  
  private void afX() {
    int i = e.jg(getWidth());
    int j = i * 1 / 2 + 1;
    n(new int[] { j, i - j });
    j = (int)(i * 7.0D / 17.0D);
    n(new int[] { j, i - j - j, j });
    j = i / 3;
    int k = i / 5;
    n(new int[] { j, k, k, i - j - k - k });
  }
  
  public void setWidth(int paramInt) {
    super.setWidth(paramInt);
    afX();
  }
  
  public void x(String... paramVarArgs) {
    int i = paramVarArgs.length;
    if (i == 0)
      return; 
    e.a(afT(), if(i), ig(i), paramVarArgs, getSize());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */