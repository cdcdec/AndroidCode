package com.laiqian.cashflow;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.cashflow.a.a;
import com.laiqian.cashflow.a.c;
import com.laiqian.cashflow.a.e;
import com.laiqian.cashflow.b.a;
import com.laiqian.cashflow.b.c;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.g;
import com.laiqian.ui.a.r;
import com.laiqian.util.ar;
import io.reactivex.g.a;
import java.io.PrintStream;
import java.util.List;

public class CashFlowDetailActivity extends ActivityRoot {
  private View aCT;
  
  private View aDo;
  
  private View aJD;
  
  private View aJE;
  
  private View aJF;
  
  private a aJG = null;
  
  private EditText aJp;
  
  private EditText aJq;
  
  private TextView aJr;
  
  private TextView aJs;
  
  private g<e> aJt;
  
  private g<c> aJu;
  
  private List<c> aJw;
  
  private long aJx;
  
  private long aJy;
  
  private long id = 0L;
  
  private List<e> list;
  
  private void Ax() {
    if (!Az()) {
      finish();
      return;
    } 
    r r = new r(this, new p(this));
    r.setTitle(getString(2131624603));
    r.s(getString(2131624610));
    r.t(getString(2131624608));
    r.oZ(getString(2131624602));
    r.show();
  }
  
  private boolean Ay() {
    double d;
    if (!xW())
      return false; 
    a a1 = new a(this);
    String str1 = this.aJs.getText().toString();
    try {
      d = Double.parseDouble(this.aJp.getText().toString());
    } catch (Exception exception) {
      a.e(exception);
      d = 0.0D;
    } 
    String str2 = this.aJq.getText().toString();
    long l = System.currentTimeMillis();
    boolean bool = a1.a(this.id, d, this.aJx, this.aJy, str1, l, str2);
    a1.close();
    if (bool) {
      Toast.makeText(this, getString(2131630211), 1).show();
      a.aKh().r(new a.a(this.id, 2));
      setResult(-1);
      return true;
    } 
    Toast.makeText(this, getString(2131630210), 1).show();
    return false;
  }
  
  private boolean Az() {
    if (this.aJx != this.aJG.AL())
      return true; 
    if (this.aJy != this.aJG.AM())
      return true; 
    String str = this.aJp.getText().toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.aJG.AO());
    stringBuilder.append("");
    return !str.equals(stringBuilder.toString()) ? true : (!this.aJq.getText().toString().equals(this.aJG.AP()));
  }
  
  private String H(long paramLong) { return (paramLong == 300002L) ? "Income" : "Expense"; }
  
  private List<c> bG(String paramString) {
    c c = new c(this);
    List list1 = c.bG(paramString);
    c.close();
    return list1;
  }
  
  private boolean xW() {
    if ("".equals(this.aJp.getText().toString())) {
      this.aJp.requestFocus();
      Toast.makeText(this, getString(2131624611), 1).show();
      return false;
    } 
    if (this.aJy == 0L) {
      Toast.makeText(this, getString(2131624604), 1).show();
      return false;
    } 
    return true;
  }
  
  private void yP() {
    this.aDo.setOnClickListener(new h(this));
    this.aJE.setOnClickListener(new i(this));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.aJx);
    stringBuilder.append("");
    this.aJw = bG(stringBuilder.toString());
    this.aJF.setOnClickListener(new k(this));
    this.aJD.setOnClickListener(new m(this));
    this.aCT.setOnClickListener(new n(this));
  }
  
  private void yR() {
    this.aJD = findViewById(2131298884);
    this.aDo = findViewById(2131296416);
    this.aJE = findViewById(2131296686);
    this.aJF = findViewById(2131296685);
    this.aJr = (TextView)findViewById(2131299826);
    this.aJr.setFocusable(true);
    this.aJr.setFocusableInTouchMode(true);
    this.aJr.requestFocus();
    this.aJs = (TextView)findViewById(2131299092);
    this.aJp = (EditText)findViewById(2131296351);
    this.aJp.setFilters(ar.lw(99));
    this.aJp.setSelectAllOnFocus(true);
    this.aJq = (EditText)findViewById(2131298714);
    this.aJq.setSelectAllOnFocus(true);
    this.aCT = findViewById(2131296858);
  }
  
  public void initData() {
    this.list = c.AY();
    null = new StringBuilder();
    null.append(((e)this.list.get(0)).getID());
    null.append("");
    this.aJw = bG(null.toString());
    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      this.id = bundle.getLong("id");
      a a1 = (new a(this)).L(this.id);
      this.aJG = a1;
      System.out.println(a1.toString());
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("oldEntity value is:");
      stringBuilder.append(this.aJG.toString());
      printStream.println(stringBuilder.toString());
      this.aJx = a1.AL();
      this.aJy = a1.AM();
      this.aJr.setText(H(this.aJx));
      this.aJs.setText(a1.AN());
      this.aJp.setText(String.valueOf(a1.AO()));
      this.aJq.setText(a1.AP());
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetNoTitle(2131427365);
    yR();
    initData();
    yP();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4)
      Ax(); 
    return false;
  }
  
  public void onPause() { super.onPause(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\CashFlowDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */