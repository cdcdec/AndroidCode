package com.laiqian.util;

import android.app.Activity;
import android.content.Intent;
import com.laiqian.basic.RootApplication;

public class bo extends m.c {
  protected String dmz;
  
  public bo(Activity paramActivity, Class<?> paramClass) { super(paramActivity, paramClass); }
  
  public bo(Activity paramActivity, Class<?> paramClass, String paramString) {
    super(paramActivity, paramClass);
    this.dmz = paramString;
    RootApplication.getLaiqianPreferenceManager().qO(this.dmz);
  }
  
  protected void i(Intent paramIntent) {
    if (!by.isNull(this.dmz) && !by.isNull(this.dmz))
      an.qt(this.dmz); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */