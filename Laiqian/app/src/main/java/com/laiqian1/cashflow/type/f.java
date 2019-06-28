package com.laiqian.cashflow.type;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.cashflow.a.c;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.d;
import com.laiqian.util.n;

class f extends d {
  private View aCT;
  
  private View aDI;
  
  private TextView aJr;
  
  private View aJv;
  
  private long aJx;
  
  private long aJy;
  
  private EditText aKd;
  
  private View aKh;
  
  private View aKi;
  
  private c aKj;
  
  private a aKk;
  
  private ActivityRoot mActivity;
  
  f(ActivityRoot paramActivityRoot, c paramc) {
    super(paramActivityRoot, 2131427531);
    setPositionTop();
    this.mActivity = paramActivityRoot;
    this.aKj = paramc;
    yR();
    initData();
    yP();
  }
  
  private String H(long paramLong) { return (paramLong == 300001L) ? "Expense" : "Income"; }
  
  private void bO(String paramString) {
    n.a(this.mActivity, paramString);
    n.j(this.aKd);
    n.b(this.mActivity, this.aKd);
  }
  
  private void yP() {
    this.aJv.setOnClickListener(new g(this));
    this.aCT.setOnClickListener(new h(this));
    this.aDI.setOnClickListener(new i(this));
  }
  
  private void yR() {
    ((TextView)findViewById(2131299242)).setText(2131624616);
    this.aKd = (EditText)findViewById(2131298198);
    this.aJr = (TextView)findViewById(2131299826);
    this.aJv = findViewById(2131296672);
    this.aKh = findViewById(2131296692);
    this.aKi = findViewById(2131296693);
    this.aKh.setVisibility(4);
    this.aKi.setVisibility(4);
    this.aCT = findViewById(2131296858);
    this.aCT.setVisibility(0);
    this.aDI = findViewById(2131299105);
  }
  
  public void a(a parama) { this.aKk = parama; }
  
  public void initData() {
    this.aJy = this.aKj.getID();
    this.aJx = this.aKj.AL();
    this.aJr.setText(H(this.aJx));
    this.aKd.setText(this.aKj.getName());
  }
  
  static interface a {
    void bH(String param1String);
    
    void c(long param1Long1, String param1String, long param1Long2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\type\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */