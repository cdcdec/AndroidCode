package com.laiqian.util;

import java.util.ArrayList;
import java.util.Collection;

public class bp<T> extends ArrayList<T> {
  private int dGm = -1;
  
  public bp() {}
  
  public bp(Collection<? extends T> paramCollection, int paramInt) {
    super(paramCollection);
    this.dGm = paramInt;
  }
  
  public int arY() { return this.dGm; }
  
  public T aws() { return (T)get(this.dGm); }
  
  public void li(int paramInt) {
    if (paramInt < 0 || paramInt > size()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("selecting index must be in range of size, index is");
      stringBuilder.append(paramInt);
      stringBuilder.append("size is");
      stringBuilder.append(size());
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    this.dGm = paramInt;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */