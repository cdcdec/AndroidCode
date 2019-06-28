package com.laiqian.milestone;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class orderOperationActivity extends Activity {
  private static long bKJ = 0L;
  
  private static String bKK = "";
  
  private static boolean bKL = false;
  
  View.OnClickListener aDd = new k(this);
  
  View.OnClickListener bKM = new l(this);
  
  View.OnClickListener bKN = new m(this);
  
  static  {
  
  }
  
  private void Ub() {
    boolean bool;
    String str = getString(2131626102);
    if (bKK.equals(str) || bKK == str) {
      bool = true;
    } else {
      bool = false;
    } 
    h h = new h(this);
    Cursor cursor = h.c(bKJ, bKK);
    if (bool) {
      ((TextView)findViewById(2131298255)).setText(getString(2131625951));
      ((TextView)findViewById(2131298257)).setText(getString(2131625952));
      ((TextView)findViewById(2131298252)).setText(getString(2131625949));
      ((TextView)findViewById(2131298250)).setText(getString(2131625948));
    } else {
      ((TextView)findViewById(2131298255)).setText(getString(2131625945));
      ((TextView)findViewById(2131298257)).setText(getString(2131625941));
      ((TextView)findViewById(2131298252)).setText(getString(2131625944));
      ((TextView)findViewById(2131298250)).setText(getString(2131625943));
    } 
    if (cursor.getCount() > 0) {
      cursor.moveToFirst();
      ((TextView)findViewById(2131298243)).setText(cursor.getString(cursor.getColumnIndex("sFieldName")));
      ((TextView)findViewById(2131298249)).setText(cursor.getString(cursor.getColumnIndex("_id")));
      String str1 = (new SimpleDateFormat(getString(2131630071))).format(new Date(cursor.getLong(cursor.getColumnIndex("nDateTime"))));
      ((TextView)findViewById(2131298246)).setText(str1);
      ((TextView)findViewById(2131298251)).setText(cursor.getString(cursor.getColumnIndex("sProductName")));
      ((TextView)findViewById(2131298242)).setText(cursor.getString(cursor.getColumnIndex("nProductQty")));
      ((EditText)findViewById(2131298245)).setText(cursor.getString(cursor.getColumnIndex("sText")));
      ((EditText)findViewById(2131298256)).setText(cursor.getString(cursor.getColumnIndex("fAmount")));
      ((EditText)findViewById(2131298258)).setText(cursor.getString(cursor.getColumnIndex("fReceived")));
      double d1 = Double.parseDouble(cursor.getString(cursor.getColumnIndex("fAmount")));
      double d2 = Double.parseDouble(cursor.getString(cursor.getColumnIndex("fReceived")));
      TextView textView = (TextView)findViewById(2131298253);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(d1 - d2);
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
    } else {
      finish();
    } 
    cursor.close();
    h.close();
  }
  
  public void onCreate(Bundle paramBundle) {
    boolean bool;
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427799);
    getWindow().setFeatureInt(7, 2131428168);
    paramBundle = getIntent().getExtras();
    bKJ = paramBundle.getLong("_id");
    bKK = paramBundle.getString("s_order_type");
    String str = getString(2131626102);
    if (bKK.equals(str) || bKK == str) {
      bool = true;
    } else {
      bool = false;
    } 
    bKL = bool;
    ((Button)findViewById(2131299879)).setOnClickListener(this.aDd);
    ((Button)findViewById(2131298259)).setOnClickListener(this.bKN);
    ((Button)findViewById(2131298244)).setOnClickListener(this.bKM);
    Ub();
    ((LinearLayout)findViewById(2131298247)).requestFocus();
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() { super.onResume(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\orderOperationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */