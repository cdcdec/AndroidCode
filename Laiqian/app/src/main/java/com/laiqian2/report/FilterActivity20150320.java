package com.laiqian.report;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.member.bz;
import com.laiqian.milestone.h;
import com.laiqian.sales.h;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.w;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class FilterActivity20150320 extends ActivityRoot {
  public static long bKe = 0L;
  
  public static String bLJ = "";
  
  public static long bLj;
  
  public static long bLk;
  
  private static int bsN;
  
  public static long byM;
  
  public static String cYQ;
  
  private boolean aDM;
  
  int aDO = Build.VERSION.SDK_INT;
  
  bz aDP;
  
  Handler aDQ = new e(this);
  
  private boolean afi = true;
  
  public boolean bLa;
  
  public int bLb;
  
  public int bLc;
  
  public int bLd;
  
  public int bLe;
  
  public int bLf;
  
  public int bLg;
  
  DatePickerDialog bLo;
  
  DatePickerDialog.OnDateSetListener bLp = new i(this);
  
  private String[] bsO;
  
  private boolean bsP = false;
  
  w.a btm = new j(this);
  
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
  
  private View.OnClickListener cYN = new f(this);
  
  private View.OnClickListener cYO = new h(this);
  
  public EditText cYR;
  
  private Button cYS;
  
  private TextView cYT;
  
  UsbCardReceiver cYU;
  
  private View.OnClickListener cYV = new g(this);
  
  w cYW = null;
  
  private ArrayList<HashMap<String, String>> cYX;
  
  public TextView cYt;
  
  public TextView cYu;
  
  public TextView cYv;
  
  public TextView cYw;
  
  public TextView cYx;
  
  public TextView cYy;
  
  public Calendar calendar;
  
  public String chT = "";
  
  static  {
  
  }
  
  private void TE() {}
  
  private void amg() {
    if (bLj > bLk) {
      Toast.makeText(this, getString(2131629793), 3000).show();
      return;
    } 
    Intent intent = getIntent();
    Bundle bundle = new Bundle();
    bundle.putString("sProductName", this.chT);
    bundle.putString("sBpartnerName", this.cYM);
    bundle.putString("sUserName", bLJ);
    bundle.putLong("nFromDate", bLj);
    bundle.putLong("nToDate", bLk);
    bundle.putLong("nProductID", this.cYL);
    if (this.cYR.getText().toString().trim() != null && !"".equals(this.cYR.getText().toString().trim()))
      cYQ = this.cYR.getText().toString().trim(); 
    bundle.putString("sMemberFilter", cYQ);
    bundle.putLong("nUserID", bKe);
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
  
  public static void ami() {
    bKe = 0L;
    bLJ = null;
    byM = 0L;
    cYQ = null;
    bLk = 0L;
    bLj = 0L;
    bsN = 0;
  }
  
  private void amj() {
    long l = Long.valueOf((new av(this)).Tx()).longValue();
    Cursor cursor = (new h(this)).aP(l);
    this.bsO = new String[cursor.getCount() + 1];
    this.cYX = new ArrayList();
    HashMap hashMap = new HashMap();
    hashMap.put("nUserID", "0");
    hashMap.put("sUserName", getString(2131626458));
    this.cYX.add(hashMap);
    String[] arrayOfString = this.bsO;
    String str = getString(2131626458);
    byte b = 0;
    arrayOfString[0] = str;
    if (cursor != null)
      while (cursor.moveToNext()) {
        HashMap hashMap1 = new HashMap();
        hashMap1.put("nUserID", cursor.getString(cursor.getColumnIndex("_id")));
        str = cursor.getString(cursor.getColumnIndex("sUserName"));
        if (str == null || "".equals(str)) {
          hashMap1.put("sUserName", cursor.getString(cursor.getColumnIndex("sUserPhone")));
        } else {
          hashMap1.put("sUserName", cursor.getString(cursor.getColumnIndex("sUserName")));
        } 
        String[] arrayOfString1 = this.bsO;
        arrayOfString1[++b] = cursor.getString(cursor.getColumnIndex("sUserName"));
        this.cYX.add(hashMap1);
      }  
    cursor.close();
  }
  
  private void wZ() {
    this.cYS = (Button)findViewById(2131296616);
    this.cYH = findViewById(2131299878);
    this.cYI = (Button)findViewById(2131299879);
    this.cYR = (EditText)findViewById(2131297140);
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
    this.cYT = (TextView)findViewById(2131299889);
    this.cYT.setText(2131629812);
    this.cYT.setFocusable(true);
    this.cYT.requestFocus();
    this.cYT.setFocusableInTouchMode(true);
    this.cYT.requestFocusFromTouch();
  }
  
  private void xV() {
    this.cYU = new UsbCardReceiver(this);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("com.laiqian.USB_PERMISSION");
    registerReceiver(this.cYU, intentFilter);
  }
  
  private void xa() {
    this.cYS.setOnClickListener(this.cYV);
    this.cYH.setOnClickListener(this.cYN);
    this.cYI.setOnClickListener(this.cYO);
    this.cYB.setOnClickListener(new a(this));
    this.cYC.setOnClickListener(new b(this));
    this.cYD.setOnClickListener(new d(this));
    this.cYE.setOnClickListener(new c(this));
    this.cYF.setOnClickListener(new f(this));
    this.cYG.setOnClickListener(new e(this));
    this.cYR.setOnFocusChangeListener(new d(this));
  }
  
  private void xb() {
    this.cYI.setText(2131625538);
    getSharedPreferences("settings", 0).edit().commit();
    this.calendar = Calendar.getInstance();
    if (bLk == 0L && bLj == 0L) {
      bLk = System.currentTimeMillis();
      bLj = bLk - 2592000000L;
    } 
    this.cYw.setText((String)DateFormat.format(getString(2131627408), bLj));
    this.cYx.setText((String)DateFormat.format(getString(2131627408), bLk));
    if (cYQ != null)
      this.cYR.setText(cYQ); 
    if (bLJ != null && !getString(2131626458).equals(bLJ)) {
      this.cYy.setText(bLJ);
      return;
    } 
    this.cYy.setText("");
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
      byM = h.getExtras().getLong("bpartnerID");
      h = new h(this);
      Cursor cursor = h.aX(byM);
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
      bKe = h.getExtras().getLong("nUserID");
      h = new h(this);
      Cursor cursor = h.aN(bKe);
      if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        bLJ = cursor.getString(cursor.getColumnIndex("sUserName"));
        this.cYv.setText(bLJ);
      } 
      cursor.close();
      h.close();
      return;
    } 
    if (paramInt1 == 3) {
      if (paramInt2 != -1)
        return; 
      bKe = h.getExtras().getLong("nUserID");
      h = new h(this);
      Cursor cursor = h.aN(bKe);
      if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        bLJ = cursor.getString(cursor.getColumnIndex("sUserName"));
        this.cYy.setText(bLJ);
      } 
      cursor.close();
      h.close();
      return;
    } 
    if (paramInt1 == 4) {
      if (paramInt2 != -1)
        return; 
      Bundle bundle = h.getExtras();
      byM = bundle.getLong("bpartnerID");
      this.cYM = bundle.getString("sName");
      ((TextView)findViewById(2131297140)).setText(this.cYM);
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    boolean bool;
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427865);
    getWindow().setFeatureInt(7, 2131428168);
    if (this.aDO < 12) {
      bool = true;
    } else {
      bool = false;
    } 
    this.aDM = bool;
    if (!this.aDM)
      xV(); 
    wZ();
    xa();
    TE();
    xb();
  }
  
  protected Dialog onCreateDialog(int paramInt) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        return null;
      case 3:
        this.calendar.setTimeInMillis(bLk);
        stringBuilder = new StringBuilder();
        stringBuilder.append("to=");
        stringBuilder.append(this.calendar.get(1));
        stringBuilder.append(this.calendar.get(2));
        stringBuilder.append(this.calendar.get(5));
        bb.ao(stringBuilder.toString());
        this.bLo = new DatePickerDialog(this, this.bLp, this.calendar.get(1), this.calendar.get(2), this.calendar.get(5));
        this.bLo.setTitle(getString(2131625412));
        this.bLo.setCancelable(false);
        return this.bLo;
      case 2:
        this.calendar.setTimeInMillis(bLj);
        stringBuilder = new StringBuilder();
        stringBuilder.append("from=");
        stringBuilder.append(this.calendar.get(1));
        stringBuilder.append(this.calendar.get(2));
        stringBuilder.append(this.calendar.get(5));
        bb.ao(stringBuilder.toString());
        this.bLo = new DatePickerDialog(this, this.bLp, this.calendar.get(1), this.calendar.get(2), this.calendar.get(5));
        this.bLo.setTitle(getString(2131625412));
        this.bLo.setCancelable(false);
        return this.bLo;
      case 1:
        break;
    } 
    this.bLo = new DatePickerDialog(this, this.bLp, this.calendar.get(1), this.calendar.get(2), this.calendar.get(5));
    this.bLo.setTitle(getString(2131625412));
    this.bLo.setCancelable(false);
    return this.bLo;
  }
  
  protected void onDestroy() {
    if (!this.aDM)
      unregisterReceiver(this.cYU); 
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4)
      amh(); 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause() {
    if (this.aDP != null)
      this.aDP.stop(); 
    super.onPause();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean && this.bsP) {
      this.cYR.requestFocus();
      return;
    } 
    if (this.cYR.hasFocus()) {
      this.bsP = true;
    } else {
      this.bsP = false;
    } 
    this.cYR.clearFocus();
  }
  
  public class UsbCardReceiver extends BroadcastReceiver {
    public UsbCardReceiver(FilterActivity20150320 this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      String str = param1Intent.getAction();
      if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(str)) {
        bz bz;
        if ((bz = this.cYY.aDP).aE(this.cYY))
          if (this.cYY.cYR.hasFocus()) {
            this.cYY.aDP = bz.Qw();
            this.cYY.aDP.a(this.cYY, 500L, this.cYY.aDQ);
            this.cYY.aDP.start();
          } else if (this.cYY.aDP != null) {
            this.cYY.aDP.stop();
          }  
      } 
      if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(str)) {
        bz bz;
        if ((!(bz = this.cYY.aDP).aE(this.cYY) || !this.cYY.cYR.hasFocus()) && this.cYY.aDP != null)
          this.cYY.aDP.stop(); 
      } 
    }
  }
  
  class a implements View.OnClickListener {
    a(FilterActivity20150320 this$0) {}
    
    public void onClick(View param1View) {
      FilterActivity20150320.c(this.cYY).setFocusable(true);
      FilterActivity20150320.c(this.cYY).requestFocus();
      FilterActivity20150320.c(this.cYY).setFocusableInTouchMode(true);
      FilterActivity20150320.c(this.cYY).requestFocusFromTouch();
      this.cYY.bLa = true;
      this.cYY.showDialog(2);
    }
  }
  
  class b implements View.OnClickListener {
    b(FilterActivity20150320 this$0) {}
    
    public void onClick(View param1View) {
      FilterActivity20150320.c(this.cYY).setFocusable(true);
      FilterActivity20150320.c(this.cYY).requestFocus();
      FilterActivity20150320.c(this.cYY).setFocusableInTouchMode(true);
      FilterActivity20150320.c(this.cYY).requestFocusFromTouch();
      this.cYY.bLa = false;
      this.cYY.showDialog(3);
    }
  }
  
  class c implements View.OnClickListener {
    c(FilterActivity20150320 this$0) {}
    
    public void onClick(View param1View) {}
  }
  
  class d implements View.OnClickListener {
    d(FilterActivity20150320 this$0) {}
    
    public void onClick(View param1View) {}
  }
  
  class e implements View.OnClickListener {
    e(FilterActivity20150320 this$0) {}
    
    public void onClick(View param1View) {
      this.cYY.cYG.setFocusable(true);
      this.cYY.cYG.setFocusableInTouchMode(true);
      this.cYY.cYG.requestFocus();
      this.cYY.cYG.requestFocusFromTouch();
      FilterActivity20150320.d(this.cYY);
      if (this.cYY.cYW == null)
        this.cYY.cYW = new w(this.cYY, FilterActivity20150320.e(this.cYY), this.cYY.btm); 
      this.cYY.cYW.gn(FilterActivity20150320.amk());
      this.cYY.cYW.show();
    }
  }
  
  protected class f implements View.OnClickListener {
    protected f(FilterActivity20150320 this$0) {}
    
    public void onClick(View param1View) {
      Intent intent = new Intent();
      intent.setClass(this.cYY, com.laiqian.milestone.userDisplay.class);
      SharedPreferences.Editor editor = this.cYY.getSharedPreferences("settings", 0).edit();
      editor.putString("sWindowID", "1250");
      editor.commit();
      this.cYY.startActivityForResult(intent, 2);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\FilterActivity20150320.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */