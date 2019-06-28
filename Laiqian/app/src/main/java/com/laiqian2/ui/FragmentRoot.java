package com.laiqian.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.av;

public class FragmentRoot extends Fragment {
  public av getLaiqianPreferenceManager() { return RootApplication.getLaiqianPreferenceManager(); }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\FragmentRoot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */