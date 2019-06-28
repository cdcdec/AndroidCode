package com.laiqian.cashflow.type;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.cashflow.a.e;
import com.laiqian.cashflow.b.c;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.g;
import com.laiqian.util.n;
import java.util.List;

class a extends d {
  private View aDI;
  
  private TextView aJr;
  
  private g aJt;
  
  private View aJv;
  
  private long aJx;
  
  private EditText aKd;
  
  private a aKe;
  
  private List<e> list;
  
  private ActivityRoot mActivity;
  
  a(ActivityRoot paramActivityRoot) {
    super(paramActivityRoot, 2131427531);
    setPositionTop();
    this.mActivity = paramActivityRoot;
    yR();
    yP();
    initData();
  }
  
  private void bO(String paramString) {
    n.a(this.mActivity, paramString);
    n.j(this.aKd);
    n.b(this.mActivity, this.aKd);
  }
  
  private void yP() {
    this.aJr.setOnClickListener(new b(this));
    this.aJv.setOnClickListener(new d(this));
    this.aDI.setOnClickListener(new e(this));
  }
  
  private void yR() {
    this.aKd = (EditText)findViewById(2131298198);
    this.aKd.requestFocus();
    this.aJr = (TextView)findViewById(2131299826);
    this.aJv = findViewById(2131296672);
    this.aDI = findViewById(2131299105);
  }
  
  void a(long paramLong, String paramString) {
    this.aJx = paramLong;
    this.aJr.setText(paramString);
  }
  
  public void a(a parama) { this.aKe = parama; }
  
  public void initData() {
    this.list = c.AY();
    this.aJr.setText(((e)this.list.get(0)).getName());
    this.aJx = 300001L;
  }
  
  static interface a {
    void bH(String param1String);
    
    void c(long param1Long1, String param1String, long param1Long2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\type\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */