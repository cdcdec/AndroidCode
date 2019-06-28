package com.laiqian.milestone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;

public class BusinessTypeSelector extends ActivityRoot {
  private Button aGS;
  
  private View azH;
  
  View.OnClickListener azO = new b(this);
  
  private LinearLayout bJq;
  
  private LinearLayout bJr;
  
  protected String bJs;
  
  View.OnClickListener bJt = new a(this);
  
  private void TE() {}
  
  private void wZ() {
    this.azH = findViewById(2131299878);
    this.aGS = (Button)findViewById(2131299879);
    this.bJq = (LinearLayout)findViewById(2131296664);
    this.bJr = (LinearLayout)findViewById(2131296665);
  }
  
  private void xa() {
    this.azH.setOnClickListener(this.azO);
    this.bJq.setOnClickListener(this.bJt);
    this.bJr.setOnClickListener(this.bJt);
  }
  
  private void xb() {
    this.aGS.setVisibility(8);
    this.azH.setFocusableInTouchMode(true);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427493);
    getWindow().setFeatureInt(7, 2131428168);
    ((TextView)findViewById(2131299889)).setText(2131626061);
    wZ();
    xa();
    TE();
    xb();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\BusinessTypeSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */