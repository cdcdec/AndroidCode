package com.laiqian.charge;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChargeMethodSelector extends Activity {
  View.OnClickListener aKx = new a(this);
  
  View.OnClickListener azO = new b(this);
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427495);
    getWindow().setFeatureInt(7, 2131428168);
    ((TextView)findViewById(2131299889)).setText(2131624781);
    ((LinearLayout)findViewById(2131297799)).setOnClickListener(this.aKx);
    ((LinearLayout)findViewById(2131297866)).setOnClickListener(this.aKx);
    View view = findViewById(2131299878);
    view.setOnClickListener(this.azO);
    ((Button)findViewById(2131299879)).setVisibility(8);
    view.setFocusableInTouchMode(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\charge\ChargeMethodSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */