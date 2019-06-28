package com.laiqian.member.select;

import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class ae implements View.OnClickListener {
  ae(ad paramad) {}
  
  public void onClick(View paramView) {
    if (RootApplication.getLaiqianPreferenceManager().avs() == 1 && RootApplication.getLaiqianPreferenceManager().avr() == 1 && RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(R.string.only_headquarters_modifications_are_allowed);
      return;
    } 
    int i = ((Integer)paramView.getTag()).intValue();
    this.bAV.bAT.bAx = i - this.bAV.bAT.bAq.getHeaderViewsCount();
    this.bAV.bAT.fH(i - this.bAV.bAT.bAq.getHeaderViewsCount());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */