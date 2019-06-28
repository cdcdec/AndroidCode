package com.laiqian.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public abstract class FragmentActivityRoot extends FragmentActivity {
  public void closeActivity(View paramView) { finish(); }
  
  protected void onCreate(Bundle paramBundle) {
    if (paramBundle != null && paramBundle.containsKey("android:support:fragments"))
      paramBundle.remove("android:support:fragments"); 
    super.onCreate(paramBundle);
  }
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle) {
    paramBundle.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
    super.onSaveInstanceState(paramBundle, paramPersistableBundle);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\ui\FragmentActivityRoot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */