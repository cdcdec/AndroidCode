package com.laiqian.warehouse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class WarehouseCreate extends Activity {
  private View azH;
  
  View.OnClickListener azO = new j(this);
  
  private long bLr = 0L;
  
  private Button dLO;
  
  private Button dLP;
  
  private EditText dLQ;
  
  private EditText dLR;
  
  private EditText dLS;
  
  private EditText dLT;
  
  private EditText dLU;
  
  private CheckBox dLV;
  
  private CheckBox dLW;
  
  private TextView dLX;
  
  private String dLY;
  
  private String dLZ;
  
  private String dMa;
  
  private String dMb;
  
  private String dMc;
  
  View.OnClickListener dMe = new k(this);
  
  private char dMh = 'Y';
  
  private void wZ() {
    this.azH = findViewById(2131299878);
    this.dLP = (Button)findViewById(2131299879);
    this.dLP.setText(2131626317);
    this.dLO = (Button)findViewById(2131300046);
    this.dLQ = (EditText)findViewById(2131300049);
    this.dLR = (EditText)findViewById(2131300048);
    this.dLS = (EditText)findViewById(2131300039);
    this.dLT = (EditText)findViewById(2131300045);
    this.dLU = (EditText)findViewById(2131300041);
    this.dLV = (CheckBox)findViewById(2131300055);
    this.dLW = (CheckBox)findViewById(2131300056);
    this.dLX = (TextView)findViewById(2131296861);
  }
  
  private void xa() {
    this.azH.setOnClickListener(this.azO);
    this.dLP.setOnClickListener(this.dMe);
  }
  
  private void xb() {
    ((TextView)findViewById(2131299889)).setText(2131625628);
    this.dLO.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428192);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    xb();
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() { super.onResume(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\WarehouseCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */