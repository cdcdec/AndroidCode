package com.laiqian.print.dualscreen;

import android.widget.CompoundButton;
import com.laiqian.util.av;

class e implements CompoundButton.OnCheckedChangeListener {
  e(DualScreenSettingsActivity paramDualScreenSettingsActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    av av = new av(this.cFt.getActivity());
    av.hO(paramBoolean);
    av.close();
    if (!paramBoolean && o.afM() != null)
      o.afM().fA(false); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\dualscreen\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */