package com.laiqian.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.aq;

public class SettingDecimals extends ActivityRoot {
  private String[] dlZ = { "0", "1", "2" };
  
  private aq dma;
  
  View dmb;
  
  TextView dmc;
  
  TextView dmd;
  
  private void gO(boolean paramBoolean) {
    if (paramBoolean) {
      this.dmc.setText("2");
      this.dmc.setTag(Integer.valueOf(2));
      a.AZ().dT(2);
      this.dmb.setClickable(false);
      return;
    } 
    this.dmb.setClickable(true);
  }
  
  private void nL(String paramString) {
    if ("1".equals(paramString)) {
      this.dmd.setText(2131624966);
      return;
    } 
    if ("2".equals(paramString)) {
      this.dmd.setText(2131624967);
      return;
    } 
    if ("0".equals(paramString))
      this.dmd.setText(2131624968); 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131428025);
    setTitleTextViewHideRightView(2131626533);
    null = findViewById(2131296410);
    this.dmb = findViewById(2131296850);
    this.dmd = (TextView)findViewById(2131296849);
    boolean bool = a.zR().Ad();
    byte b = 0;
    if (bool) {
      bool = a.AZ().BK();
      null.setSelected(bool);
      null.setOnClickListener(new bs(this));
    } else {
      null.setVisibility(8);
      this.dmb.setBackgroundResource(2130772052);
      bool = false;
    } 
    this.dmc = (TextView)this.dmb.findViewById(2131296848);
    null = new StringBuilder();
    null.append(a.AZ().Be());
    null.append("");
    String str = null.toString();
    while (b < this.dlZ.length) {
      if (str.equals(this.dlZ[b])) {
        this.dmc.setTag(Integer.valueOf(b));
        break;
      } 
      b++;
    } 
    this.dmc.setText(str);
    nL(str);
    this.dmb.setTag(this.dmc);
    this.dmb.setOnClickListener(new bt(this));
    gO(bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingDecimals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */