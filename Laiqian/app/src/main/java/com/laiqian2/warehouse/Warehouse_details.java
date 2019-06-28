package com.laiqian.warehouse;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.milestone.h;
import com.laiqian.util.l;
import com.laiqian.warehouse.a.a;

public class Warehouse_details extends Activity {
  View.OnClickListener aDd = new m(this);
  
  private View azH;
  
  View.OnClickListener azO = new l(this);
  
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
  
  View.OnClickListener dMd = new n(this);
  
  View.OnClickListener dMe = new r(this);
  
  private char dMh = 'Y';
  
  private int dMj = 3;
  
  View.OnClickListener dMk = new q(this);
  
  private void axG() {
    a a = new a(this);
    String str = a.axK();
    a.close();
    this.dLQ.setText(l.A(str, this.dMj));
    this.dLR.setText("");
    this.dLS.setText("");
    this.dLT.setText("");
    this.dLU.setText("");
    this.dLV.setChecked(false);
    this.dLW.setChecked(false);
    this.dLO.setVisibility(8);
  }
  
  private void dG(long paramLong) {
    this.dLX.setVisibility(0);
    h h = new h(this);
    Cursor cursor = h.aZ(paramLong);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      cursor.getString(cursor.getColumnIndex("_id"));
      cursor.getString(cursor.getColumnIndex("sName"));
      this.dLQ.setText(cursor.getString(cursor.getColumnIndex("sNumber")));
      this.dLR.setText(cursor.getString(cursor.getColumnIndex("sName")));
      this.dLS.setText(cursor.getString(cursor.getColumnIndex("sDescription")));
      this.dLT.setText(cursor.getString(cursor.getColumnIndex("sAddress")));
      this.dLU.setText(cursor.getString(cursor.getColumnIndex("sText")));
      if (cursor.getString(cursor.getColumnIndex("sIsDefaultMoveIn")) == null) {
        this.dLV.setChecked(false);
      } else if (cursor.getString(cursor.getColumnIndex("sIsDefaultMoveIn")).equals("Y")) {
        this.dLV.setChecked(true);
      } 
      if (cursor.getString(cursor.getColumnIndex("sIsDefaultMoveOut")) == null) {
        this.dLW.setChecked(false);
      } else if (cursor.getString(cursor.getColumnIndex("sIsDefaultMoveOut")).equals("Y")) {
        this.dLW.setChecked(true);
      } 
      cursor.close();
      h.close();
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
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428192);
    getWindow().setFeatureInt(7, 2131428168);
    ((TextView)findViewById(2131299889)).setText(2131625628);
    wZ();
    xa();
    this.dLO.setVisibility(8);
    this.bLr = getIntent().getExtras().getLong("warehouseID");
    if (this.bLr == 0L) {
      axG();
      return;
    } 
    dG(this.bLr);
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() { super.onResume(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\Warehouse_details.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */