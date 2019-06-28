package com.laiqian.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.ax;
import com.laiqian.util.by;

public class SettingPayRequestTime extends ActivityRoot {
  private String[] dmA = { "5", "10", "20", "30", "60" };
  
  private aq dmB;
  
  View dmC;
  
  TextView dmD;
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131428032);
    setTitleTextViewHideRightView(2131627306);
    this.dmC = findViewById(2131299233);
    this.dmD = (TextView)this.dmC.findViewById(2131299229);
    null = new StringBuilder();
    null.append(a.AZ().Cr());
    null.append("");
    String str = null.toString();
    for (byte b = 0; b < this.dmA.length; b++) {
      if (str.equals(this.dmA[b])) {
        this.dmD.setTag(Integer.valueOf(b));
        break;
      } 
    } 
    this.dmD.setText(str);
    this.dmC.setTag(this.dmD);
    this.dmC.setOnClickListener(new bz(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingPayRequestTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */