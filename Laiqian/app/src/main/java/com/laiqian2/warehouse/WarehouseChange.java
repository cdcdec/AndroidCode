package com.laiqian.warehouse;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.warehouse.a.a;

public class WarehouseChange extends Activity {
  private View azH;
  
  View.OnClickListener azO = new e(this);
  
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
  
  View.OnClickListener dMd = new f(this);
  
  View.OnClickListener dMe = new i(this);
  
  private void dG(long paramLong) {
    this.dLX.setVisibility(0);
    Cursor cursor = (new a(this)).dH(paramLong);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      this.dLQ.setText(cursor.getString(cursor.getColumnIndex("sNumber")));
      this.dLR.setText(cursor.getString(cursor.getColumnIndex("sName")));
      this.dLS.setText(cursor.getString(cursor.getColumnIndex("sDescription")));
      this.dLT.setText(cursor.getString(cursor.getColumnIndex("sAddress")));
      this.dLU.setText(cursor.getString(cursor.getColumnIndex("sText")));
      if (cursor.getString(cursor.getColumnIndex("sIsDefaultMoveIn")) == null)
        this.dLV.setChecked(false); 
      if (cursor.getString(cursor.getColumnIndex("sIsDefaultMoveOut")) == null)
        this.dLW.setChecked(false); 
      if (cursor.getString(cursor.getColumnIndex("sIsDefaultMoveIn")).equals("Y"))
        this.dLV.setChecked(true); 
      if (cursor.getString(cursor.getColumnIndex("sIsDefaultMoveOut")).equals("Y"))
        this.dLW.setChecked(true); 
      cursor.close();
      return;
    } 
    finish();
  }
  
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
    this.dLO.setOnClickListener(this.dMd);
    this.dLP.setOnClickListener(this.dMe);
  }
  
  private void xb() {
    ((TextView)findViewById(2131299889)).setText(2131625628);
    this.bLr = getIntent().getExtras().getLong("warehouseID");
    dG(this.bLr);
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\WarehouseChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */