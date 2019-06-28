package com.laiqian.milestone;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;
import java.util.Calendar;

public class orderQuery extends ActivityRoot {
  private static long bLj = 0L;
  
  private static long bLk = 0L;
  
  private static long bLl = -1L;
  
  private static long bLm = -1L;
  
  private static int bLn;
  
  private Button aGS;
  
  ProgressDialog aIw = null;
  
  private View azH;
  
  View.OnClickListener azO = new n(this);
  
  private String bJs = "";
  
  private LinearLayout bKP;
  
  private LinearLayout bKQ;
  
  private LinearLayout bKR;
  
  private LinearLayout bKS;
  
  private LinearLayout bKT;
  
  private TextView bKU;
  
  private TextView bKV;
  
  private TextView bKW;
  
  private TextView bKX;
  
  private TextView bKY;
  
  private Button bKZ;
  
  private boolean bLa;
  
  private int bLb;
  
  private int bLc;
  
  private int bLd;
  
  private int bLe;
  
  private int bLf;
  
  private int bLg;
  
  private long bLh = 0L;
  
  private long bLi = 0L;
  
  DatePickerDialog bLo;
  
  DatePickerDialog.OnDateSetListener bLp = new o(this);
  
  private Calendar calendar;
  
  static  {
  
  }
  
  private void TE() {}
  
  private void wZ() {
    this.azH = findViewById(2131299878);
    this.aGS = (Button)findViewById(2131299879);
    this.bKU = (TextView)findViewById(2131297234);
    this.bKV = (TextView)findViewById(2131297251);
    this.bKY = (TextView)findViewById(2131297226);
    this.bKW = (TextView)findViewById(2131297246);
    this.bKX = (TextView)findViewById(2131297223);
    this.bKZ = (Button)findViewById(2131297227);
    this.bKP = (LinearLayout)findViewById(2131297221);
    this.bKQ = (LinearLayout)findViewById(2131297222);
    this.bKT = (LinearLayout)findViewById(2131297225);
    this.bKR = (LinearLayout)findViewById(2131297247);
    this.bKS = (LinearLayout)findViewById(2131297224);
  }
  
  private void xa() {
    this.bKP.setOnClickListener(new a(this));
    this.bKQ.setOnClickListener(new c(this));
    this.bKT.setOnClickListener(new e(this));
    this.bKR.setOnClickListener(new b(this));
    this.bKS.setOnClickListener(new d(this));
    this.azH.setOnClickListener(new g(this));
    this.aGS.setOnClickListener(new h(this));
    this.bKZ.setOnClickListener(new f(this));
  }
  
  private void xb() {
    this.bLa = false;
    this.aGS.setText(2131625961);
    ((TextView)findViewById(2131299889)).setText(getString(2131629812));
    this.azH.setFocusable(true);
    this.azH.setFocusableInTouchMode(true);
    this.azH.requestFocus();
    bLk = System.currentTimeMillis();
    bLj = bLk - 2592000000L;
    this.calendar = Calendar.getInstance();
    this.bKU.setText((String)DateFormat.format(getString(2131627408), bLj));
    this.bKV.setText((String)DateFormat.format(getString(2131627408), bLk));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    h h;
    if (paramInt1 == 0) {
      String str;
      if (paramInt2 != -1)
        return; 
      null = paramIntent.getExtras();
      this.bJs = null.getString("sProductTransacType");
      h = null.getString("sProductTransacTypeName");
      this.bKY.setText(h);
      return;
    } 
    if (paramInt1 == 1) {
      if (paramInt2 != -1)
        return; 
      this.bLh = h.getExtras().getLong("_id");
      h = new h(this);
      null = new StringBuilder();
      null.append(this.bLh);
      null.append("");
      Cursor cursor = h.gJ(null.toString());
      if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        String str = cursor.getString(cursor.getColumnIndex("sProductName"));
        this.bKW.setText(str);
      } 
      cursor.close();
      h.close();
      return;
    } 
    if (paramInt1 == 2) {
      if (paramInt2 != -1)
        return; 
      this.bLi = h.getExtras().getLong("bpartnerID");
      h = new h(this);
      Cursor cursor = h.aX(this.bLi);
      if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        String str = cursor.getString(cursor.getColumnIndex("sName"));
        this.bKX.setText(str);
      } 
      cursor.close();
      h.close();
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427790);
    getWindow().setFeatureInt(7, 2131428168);
    ((TextView)findViewById(2131299889)).setText(2131625973);
    wZ();
    xa();
    TE();
    xb();
  }
  
  protected Dialog onCreateDialog(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 2:
        return (new AlertDialog.Builder(this)).setTitle(2131625467).setMessage(2131629196).setPositiveButton(2131625460, null).show();
      case 1:
        break;
    } 
    this.bLo = new DatePickerDialog(this, this.bLp, this.calendar.get(1), this.calendar.get(2), this.calendar.get(5));
    this.bLo.setTitle(getString(2131625412));
    this.bLo.setCancelable(false);
    return this.bLo;
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() { super.onResume(); }
  
  class a implements View.OnClickListener {
    a(orderQuery this$0) {}
    
    public void onClick(View param1View) {
      orderQuery.a(this.bLq, true);
      this.bLq.showDialog(1);
    }
  }
  
  class b implements View.OnClickListener {
    b(orderQuery this$0) {}
    
    public void onClick(View param1View) {}
  }
  
  class c implements View.OnClickListener {
    c(orderQuery this$0) {}
    
    public void onClick(View param1View) {
      orderQuery.a(this.bLq, false);
      this.bLq.showDialog(1);
    }
  }
  
  class d implements View.OnClickListener {
    d(orderQuery this$0) {}
    
    public void onClick(View param1View) {}
  }
  
  class e implements View.OnClickListener {
    e(orderQuery this$0) {}
    
    public void onClick(View param1View) {
      Intent intent = new Intent();
      intent.setClass(this.bLq, BusinessTypeSelector.class);
      this.bLq.startActivityForResult(intent, 0);
    }
  }
  
  class f implements View.OnClickListener {
    f(orderQuery this$0) {}
    
    public void onClick(View param1View) {
      orderQuery.a(this.bLq, 0L);
      orderQuery.b(this.bLq, 0L);
      orderQuery.a(this.bLq, "");
      orderQuery.d(this.bLq).setText("");
      orderQuery.e(this.bLq).setText("");
      orderQuery.f(this.bLq).setText("");
    }
  }
  
  class g implements View.OnClickListener {
    g(orderQuery this$0) {}
    
    public void onClick(View param1View) { this.bLq.finish(); }
  }
  
  class h implements View.OnClickListener {
    h(orderQuery this$0) {}
    
    public void onClick(View param1View) {
      Intent intent = new Intent();
      Bundle bundle = new Bundle();
      bundle.putLong("nFromDate", orderQuery.Ud());
      bundle.putLong("nToDate", orderQuery.Ue());
      bundle.putInt("nDateSource", orderQuery.Uf());
      bundle.putString("sProductTransacType", orderQuery.a(this.bLq));
      bundle.putLong("nProductID", orderQuery.b(this.bLq));
      bundle.putLong("nbPartnerID", orderQuery.c(this.bLq));
      intent.putExtras(bundle);
      this.bLq.setResult(-1, intent);
      this.bLq.finish();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\orderQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */