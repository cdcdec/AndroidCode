package com.laiqian.report;

import android.os.Bundle;
import android.widget.LinearLayout;

public class FilterByStaffActivity20150320 extends FilterActivity20150320 {
  private LinearLayout cYG;
  
  private LinearLayout cYZ;
  
  private void xb() {
    this.cYZ = (LinearLayout)findViewById(2131297244);
    this.cYZ.setVisibility(8);
    this.cYG = (LinearLayout)findViewById(2131297250);
    this.cYG.setBackgroundResource(2130772035);
    this.cYG.setPadding(24, 0, 24, 0);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    xb();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\FilterByStaffActivity20150320.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */