package com.laiqian.print.b;

import com.laiqian.print.model.PrintContent;
import com.laiqian.print.util.e;

public class c extends a {
  private int width = 58;
  
  public c() { afX(); }
  
  public c(PrintContent.a parama) {
    super(parama);
    afX();
  }
  
  private void afX() {
    int j = e.jg(getSize());
    n(new int[] { 0 });
    int i = j - 1;
    n(new int[] { 0, i });
    n(new int[] { 0, j / 3 * 2, i });
    j /= 4;
    n(new int[] { 0, j * 2, j * 3, i });
  }
  
  public void setWidth(int paramInt) {
    super.setWidth(paramInt);
    afX();
  }
  
  public void x(String... paramVarArgs) {
    int i = paramVarArgs.length;
    if (i == 0)
      return; 
    e.a(afT(), this.width, if(i), ig(i), paramVarArgs, getSize());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */