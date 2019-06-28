package com.laiqian.member.e;

import android.widget.CompoundButton;
import android.widget.LinearLayout;

class b implements CompoundButton.OnCheckedChangeListener {
  b(a parama) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    LinearLayout linearLayout = a.a(this.bym);
    byte b2 = 8;
    if (paramBoolean) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    linearLayout.setVisibility(b1);
    linearLayout = a.b(this.bym);
    byte b1 = b2;
    if (paramBoolean)
      b1 = 0; 
    linearLayout.setVisibility(b1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */