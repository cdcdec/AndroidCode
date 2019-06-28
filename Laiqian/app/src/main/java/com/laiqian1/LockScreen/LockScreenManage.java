package com.laiqian.LockScreen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.util.av;

public class LockScreenManage extends Activity {
  private View azH;
  
  private Button azI;
  
  private TextView azJ;
  
  private LinearLayout azK;
  
  private LinearLayout azL;
  
  private EditText azM;
  
  private CheckBox azN;
  
  View.OnClickListener azO = new b(this);
  
  View.OnClickListener azP = new c(this);
  
  private void wZ() {
    this.azH = findViewById(2131299878);
    this.azH.setFocusableInTouchMode(true);
    this.azJ = (TextView)findViewById(2131299889);
    this.azI = (Button)findViewById(2131299879);
    this.azL = (LinearLayout)findViewById(2131298979);
    this.azK = (LinearLayout)findViewById(2131298980);
    this.azM = (EditText)findViewById(2131296997);
    this.azN = (CheckBox)findViewById(2131298294);
  }
  
  private void xa() {
    this.azH.setOnClickListener(this.azO);
    this.azI.setOnClickListener(this.azP);
  }
  
  private void xb() {
    this.azJ.setText(2131625512);
    this.azI.setText(2131626317);
    av av = new av(this);
    String str = av.atL();
    if (av.atM()) {
      this.azN.setChecked(true);
      this.azK.setVisibility(0);
      this.azL.setBackgroundResource(2130772056);
      this.azM.setText(str);
    } else {
      this.azN.setChecked(false);
      this.azK.setVisibility(8);
      this.azL.setBackgroundResource(2130772048);
    } 
    this.azN.setOnCheckedChangeListener(new a(this, str));
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427739);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    xb();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\LockScreen\LockScreenManage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */