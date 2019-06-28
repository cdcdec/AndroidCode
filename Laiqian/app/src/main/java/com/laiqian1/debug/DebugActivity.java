package com.laiqian.debug;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.laiqian.ui.ActivityRoot;

public class DebugActivity extends ActivityRoot {
  a aQw;
  
  private Fragment Ei() { return new BackupFileDebugFragment(); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.aQw = a.g(this);
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(16908290, Ei());
    fragmentTransaction.commit();
  }
  
  public static class a {
    public LinearLayout aQx;
    
    public a(View param1View) { this.aQx = (LinearLayout)param1View; }
    
    public static a g(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427369, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\debug\DebugActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */