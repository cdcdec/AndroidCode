package com.laiqian.setting;

import android.os.AsyncTask;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.models.ab;

class br extends AsyncTask<Void, Void, Boolean> {
  br(SettingCashierFragment paramSettingCashierFragment) {}
  
  protected void b(Boolean paramBoolean) {
    if (SettingCashierFragment.h(this.dlV) != null)
      SettingCashierFragment.h(this.dlV).cancel(); 
  }
  
  protected Boolean g(Void... paramVarArgs) {
    ab ab = new ab(CrashApplication.zv());
    boolean bool = ab.Ve();
    ab.close();
    return Boolean.valueOf(bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */