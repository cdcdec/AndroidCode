package com.laiqian.report;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.milestone.h;
import com.laiqian.sales.h;
import com.laiqian.ui.ActivityRoot;
import java.util.Calendar;

public class FilterActivity extends ActivityRoot {
  public long bKe = 0L;
  
  public String bLJ = "";
  
  public boolean bLa;
  
  public int bLb;
  
  public int bLc;
  
  public int bLd;
  
  public int bLe;
  
  public int bLf;
  
  public int bLg;
  
  public long bLj = 0L;
  
  public long bLk = 0L;
  
  DatePickerDialog bLo;
  
  DatePickerDialog.OnDateSetListener bLp = new c(this);
  
  public long byM = 0L;
  
  public CheckBox cYA;
  
  public LinearLayout cYB;
  
  public LinearLayout cYC;
  
  public LinearLayout cYD;
  
  public LinearLayout cYE;
  
  public LinearLayout cYF;
  
  public LinearLayout cYG;
  
  private View cYH;
  
  public Button cYI;
  
  public boolean cYJ;
  
  public boolean cYK;
  
  public long cYL = 0L;
  
  public String cYM = "";
  
  private View.OnClickListener cYN = new a(this);
  
  private View.OnClickListener cYO = new b(this);
  
  public TextView cYt;
  
  public TextView cYu;
  
  public TextView cYv;
  
  public TextView cYw;
  
  public TextView cYx;
  
  public TextView cYy;
  
  public CheckBox cYz;
  
  public Calendar calendar;
  
  public String chT = "";
  
  private void TE() {}
  
  private void amg() {
    if (this.bLj > this.bLk) {
      Toast.makeText(this, getString(2131629793), 3000).show();
      return;
    } 
    if (this.cYz.isChecked())
      this.cYJ = true; 
    if (this.cYA.isChecked())
      this.cYK = true; 
    Intent intent = getIntent();
    Bundle bundle = new Bundle();
    bundle.putString("sProductName", this.chT);
    bundle.putString("sBpartnerName", this.cYM);
    bundle.putString("sUserName", this.bLJ);
    bundle.putLong("nFromDate", this.bLj);
    bundle.putLong("nToDate", this.bLk);
    bundle.putLong("nProductID", this.cYL);
    bundle.putLong("nBpartnerID", this.byM);
    bundle.putLong("nUserID", this.bKe);
    bundle.putBoolean("bUnReceived", this.cYJ);
    bundle.putBoolean("bUnPayed", this.cYK);
    intent.putExtras(bundle);
    setResult(0, intent);
    finish();
  }
  
  private void amh() {
    setResult(2, getIntent());
    finish();
  }
  
  private void wZ() {
    this.cYH = findViewById(2131299878);
    this.cYI = (Button)findViewById(2131299879);
    this.cYB = (LinearLayout)findViewById(2131297221);
    this.cYC = (LinearLayout)findViewById(2131297222);
    this.cYD = (LinearLayout)findViewById(2131297247);
    this.cYE = (LinearLayout)findViewById(2131297229);
    this.cYF = (LinearLayout)findViewById(2131297249);
    this.cYG = (LinearLayout)findViewById(2131297250);
    this.cYw = (TextView)findViewById(2131297236);
    this.cYx = (TextView)findViewById(2131297253);
    this.cYt = (TextView)findViewById(2131297141);
    this.cYu = (TextView)findViewById(2131297139);
    this.cYv = (TextView)findViewById(2131297142);
    this.cYy = (TextView)findViewById(2131297143);
    this.cYz = (CheckBox)findViewById(2131297255);
    this.cYA = (CheckBox)findViewById(2131297254);
  }
  
  private void xa() {
    this.cYH.setOnClickListener(this.cYN);
    this.cYI.setOnClickListener(this.cYO);
    this.cYB.setOnClickListener(new a(this));
    this.cYC.setOnClickListener(new b(this));
    this.cYD.setOnClickListener(new d(this));
    this.cYE.setOnClickListener(new c(this));
    this.cYF.setOnClickListener(new f(this));
    this.cYG.setOnClickListener(new e(this));
  }
  
  private void xb() {
    this.cYI.setText(2131625538);
    ((TextView)findViewById(2131299889)).setText(2131629812);
    getSharedPreferences("settings", 0).edit().commit();
    this.calendar = Calendar.getInstance();
    this.bLk = System.currentTimeMillis();
    this.bLj = this.bLk - 2592000000L;
    this.cYw.setText((String)DateFormat.format(getString(2131627408), this.bLj));
    this.cYx.setText((String)DateFormat.format(getString(2131627408), this.bLk));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    h h;
    if (paramInt1 == 0) {
      h h1;
      if (paramInt2 != -1)
        return; 
      this.cYL = paramIntent.getExtras().getLong("_id");
      h = new h(this);
      null = new StringBuilder();
      null.append(this.cYL);
      null.append("");
      Cursor cursor = h.gJ(null.toString());
      if (cursor.moveToFirst()) {
        this.chT = cursor.getString(cursor.getColumnIndex("sProductName"));
        this.cYt.setText(this.chT);
      } 
      cursor.close();
      h.close();
      return;
    } 
    if (paramInt1 == 1) {
      if (paramInt2 != -1)
        return; 
      this.byM = h.getExtras().getLong("bpartnerID");
      h = new h(this);
      Cursor cursor = h.aX(this.byM);
      if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        this.cYM = cursor.getString(cursor.getColumnIndex("sName"));
        this.cYu.setText(this.cYM);
      } 
      cursor.close();
      h.close();
      return;
    } 
    if (paramInt1 == 2) {
      if (paramInt2 != -1)
        return; 
      this.bKe = h.getExtras().getLong("nUserID");
      h = new h(this);
      Cursor cursor = h.aN(this.bKe);
      if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        this.bLJ = cursor.getString(cursor.getColumnIndex("sUserName"));
        this.cYv.setText(this.bLJ);
      } 
      cursor.close();
      h.close();
      return;
    } 
    if (paramInt1 == 3) {
      if (paramInt2 != -1)
        return; 
      this.bKe = h.getExtras().getLong("nUserID");
      h = new h(this);
      Cursor cursor = h.aN(this.bKe);
      if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        this.bLJ = cursor.getString(cursor.getColumnIndex("sUserName"));
        this.cYy.setText(this.bLJ);
      } 
      cursor.close();
      h.close();
      return;
    } 
    if (paramInt1 == 4) {
      if (paramInt2 != -1)
        return; 
      Bundle bundle = h.getExtras();
      this.byM = bundle.getLong("bpartnerID");
      this.cYM = bundle.getString("sName");
      ((TextView)findViewById(2131297140)).setText(this.cYM);
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427502);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    TE();
    xb();
  }
  
  protected Dialog onCreateDialog(int paramInt) {
    if (paramInt != 1)
      return null; 
    this.bLo = new DatePickerDialog(this, this.bLp, this.calendar.get(1), this.calendar.get(2), this.calendar.get(5));
    this.bLo.setTitle(getString(2131625412));
    this.bLo.setCancelable(false);
    return this.bLo;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4)
      amh(); 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a implements View.OnClickListener {
    a(FilterActivity this$0) {}
    
    public void onClick(View param1View) {
      this.cYP.bLa = true;
      this.cYP.showDialog(1);
    }
  }
  
  class b implements View.OnClickListener {
    b(FilterActivity this$0) {}
    
    public void onClick(View param1View) {
      this.cYP.bLa = false;
      this.cYP.showDialog(1);
    }
  }
  
  class c implements View.OnClickListener {
    c(FilterActivity this$0) {}
    
    public void onClick(View param1View) {}
  }
  
  class d implements View.OnClickListener {
    d(FilterActivity this$0) {}
    
    public void onClick(View param1View) {}
  }
  
  class e implements View.OnClickListener {
    e(FilterActivity this$0) {}
    
    public void onClick(View param1View) {
      Intent intent = new Intent();
      intent.setClass(this.cYP, com.laiqian.milestone.userDisplay.class);
      SharedPreferences.Editor editor = this.cYP.getSharedPreferences("settings", 0).edit();
      editor.putString("sWindowID", "1250");
      editor.commit();
      this.cYP.startActivityForResult(intent, 3);
    }
  }
  
  protected class f implements View.OnClickListener {
    protected f(FilterActivity this$0) {}
    
    public void onClick(View param1View) {
      Intent intent = new Intent();
      intent.setClass(this.cYP, com.laiqian.milestone.userDisplay.class);
      SharedPreferences.Editor editor = this.cYP.getSharedPreferences("settings", 0).edit();
      editor.putString("sWindowID", "1250");
      editor.commit();
      this.cYP.startActivityForResult(intent, 2);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\FilterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */