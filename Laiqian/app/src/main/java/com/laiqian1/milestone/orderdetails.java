package com.laiqian.milestone;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;

public class orderdetails extends Activity {
  private static long bKJ;
  
  private static long bKe;
  
  private View azH;
  
  View.OnClickListener azO = new p(this);
  
  private long bLr;
  
  private Button bLs;
  
  private Button bLt;
  
  View.OnClickListener bLu = new q(this);
  
  View.OnClickListener bLv = new t(this);
  
  static  {
  
  }
  
  private void Ub() {
    getString(2131626102);
    h h = new h(this);
    Cursor cursor = h.aJ(bKJ);
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      long l = cursor.getLong(cursor.getColumnIndex("nProductTransacType"));
      ((TextView)findViewById(2131298261)).setText(cursor.getString(cursor.getColumnIndex("sTransacType")));
      ((TextView)findViewById(2131298269)).setText(cursor.getString(cursor.getColumnIndex("sOrderNo")));
      String str = (new SimpleDateFormat(getString(2131630071))).format(new Date(cursor.getLong(cursor.getColumnIndex("sDateTime"))));
      ((TextView)findViewById(2131298266)).setText(str);
      ((TextView)findViewById(2131298271)).setText(cursor.getString(cursor.getColumnIndex("sProductName")));
      ((TextView)findViewById(2131298270)).setText(cursor.getString(cursor.getColumnIndex("fPrice")));
      ((TextView)findViewById(2131298272)).setText(cursor.getString(cursor.getColumnIndex("nProductQty")));
      be(cursor.getLong(cursor.getColumnIndex("nProductUnit")));
      ((TextView)findViewById(2131298260)).setText(cursor.getString(cursor.getColumnIndex("fAmount")));
      ((TextView)findViewById(2131298275)).setText(cursor.getString(cursor.getColumnIndex("fReceived")));
      ((TextView)findViewById(2131298262)).setText(cursor.getString(cursor.getColumnIndex("sBPartner")));
      ((TextView)findViewById(2131298277)).setText(cursor.getString(cursor.getColumnIndex("sWarehouseName")));
      this.bLr = cursor.getLong(cursor.getColumnIndex("nWarehouseID"));
      ((EditText)findViewById(2131298265)).setText(cursor.getString(cursor.getColumnIndex("sBPartnerContact")));
      ((EditText)findViewById(2131298264)).setText(cursor.getString(cursor.getColumnIndex("sBPartnerMobile")));
      ((EditText)findViewById(2131298263)).setText(cursor.getString(cursor.getColumnIndex("sDocText")));
      if (l == 100001L) {
        ((TextView)findViewById(2131298274)).setText(getString(2131625952));
      } else if (l == 100002L) {
        ((TextView)findViewById(2131298274)).setText(getString(2131625941));
      } else {
        ((LinearLayout)findViewById(2131298273)).setVisibility(8);
      } 
    } else {
      finish();
    } 
    cursor.close();
    h.close();
  }
  
  private boolean bd(long paramLong) {
    h h = new h(this);
    Cursor cursor = h.aJ(paramLong);
    if (cursor.moveToFirst()) {
      paramLong = cursor.getLong(cursor.getColumnIndex("nFlag"));
    } else {
      paramLong = 0L;
    } 
    cursor.close();
    h.close();
    return (paramLong == 1L);
  }
  
  private void be(long paramLong) {
    h h = new h(this);
    String str = h.ba(paramLong);
    ((TextView)findViewById(2131298276)).setText(str);
    h.close();
  }
  
  private void wZ() {
    this.azH = findViewById(2131299878);
    this.bLs = (Button)findViewById(2131298267);
    this.bLt = (Button)findViewById(2131299879);
  }
  
  private void xa() {
    this.azH.setOnClickListener(this.azO);
    this.bLs.setOnClickListener(this.bLu);
    this.bLt.setOnClickListener(this.bLv);
  }
  
  private void xb() {
    ((TextView)findViewById(2131299889)).setText(2131625937);
    this.bLt.setText(2131625960);
    bKJ = getIntent().getExtras().getLong("recordID");
    if (!bd(bKJ)) {
      Ub();
      return;
    } 
    Toast.makeText(this, getString(2131625994), 1000).show();
    finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427796);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    xb();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\orderdetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */