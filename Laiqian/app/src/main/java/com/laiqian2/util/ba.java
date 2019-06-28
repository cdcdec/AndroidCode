package com.laiqian.util;

import android.util.Log;

public class ba {
  private int level = 9;
  
  String tag = "tag";
  
  public ba(boolean paramBoolean) {
    if (paramBoolean) {
      this.level = 0;
      return;
    } 
    this.level = 9;
  }
  
  public void d(String paramString) {
    if (2 >= this.level)
      Log.d(this.tag, paramString); 
  }
  
  public void lA(String paramString) {
    if (1 >= this.level)
      Log.i(this.tag, paramString); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */