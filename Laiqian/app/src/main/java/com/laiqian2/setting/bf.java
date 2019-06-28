package com.laiqian.setting;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.laiqian.util.m;

public class bf extends m.c {
  private boolean aFB = false;
  
  private Activity azD;
  
  public bf(Activity paramActivity, Class<?> paramClass, boolean paramBoolean) {
    super(paramActivity, paramClass);
    this.azD = paramActivity;
    this.aFB = paramBoolean;
  }
  
  protected boolean h(Intent paramIntent) {
    if (!this.aFB) {
      Toast.makeText(this.azD, "非老板账号，无权限！", 0).show();
      return true;
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */