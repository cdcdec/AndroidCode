package com.laiqian.print.dualscreen;

import android.widget.CompoundButton;
import com.laiqian.crash.model.CrashApplication;

class f implements CompoundButton.OnCheckedChangeListener {
  f(DualScreenSettingsActivity paramDualScreenSettingsActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    CrashApplication.getLaiqianPreferenceManager().hQ(paramBoolean);
    if (!paramBoolean && o.afM() != null)
      o.afM().fB(false); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\dualscreen\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */