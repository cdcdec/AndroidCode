package com.laiqian.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class ay<T> extends Object {
  private T dGb;
  
  protected abstract T Lv();
  
  @NonNull
  public T get() {
    if (this.dGb == null)
      this.dGb = Lv(); 
    return (T)this.dGb;
  }
  
  @Nullable
  public T peek() { return (T)this.dGb; }
  
  public void set(T paramT) { this.dGb = paramT; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */