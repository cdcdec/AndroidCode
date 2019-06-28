package com.laiqian.setting;

import android.widget.CompoundButton;
import com.github.moduth.blockcanary.c;
import com.laiqian.crash.model.CrashApplication;

class as implements CompoundButton.OnCheckedChangeListener {
  as(SettingAboutFragment paramSettingAboutFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    CrashApplication.getLaiqianPreferenceManager().hR(paramBoolean);
    if (paramBoolean)
      c.a(this.dln.getActivity().getApplicationContext(), new at(this)).start(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */