package com.laiqian.setting;

import android.app.Activity;
import android.content.Intent;
import com.laiqian.util.an;
import com.laiqian.util.by;
import com.laiqian.util.m;

public class by extends m.c {
  protected String dmz;
  
  public by(Activity paramActivity, Class<?> paramClass) { super(paramActivity, paramClass); }
  
  public by(Activity paramActivity, Class<?> paramClass, String paramString) {
    super(paramActivity, paramClass);
    this.dmz = paramString;
  }
  
  protected void i(Intent paramIntent) {
    if (!by.isNull(this.dmz))
      an.qt(this.dmz); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */