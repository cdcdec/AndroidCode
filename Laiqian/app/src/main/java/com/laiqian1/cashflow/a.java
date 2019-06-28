package com.laiqian.cashflow;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.cashflow.a.c;
import com.laiqian.cashflow.a.e;
import com.laiqian.cashflow.b.c;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.g;
import com.laiqian.util.ar;
import java.util.List;

class a extends d {
  private View aDI;
  
  private View aJn;
  
  private View aJo;
  
  private EditText aJp;
  
  private EditText aJq;
  
  private TextView aJr;
  
  private TextView aJs;
  
  private g aJt;
  
  private g<c> aJu;
  
  private View aJv;
  
  private List<c> aJw;
  
  private long aJx;
  
  private long aJy = 0L;
  
  private a aJz;
  
  private List<e> list;
  
  private final ActivityRoot mActivity;
  
  a(ActivityRoot paramActivityRoot) {
    super(paramActivityRoot, 2131427530);
    setPositionTop();
    this.mActivity = paramActivityRoot;
    yR();
    initData();
    yP();
  }
  
  private List<c> bG(String paramString) {
    c c = new c(this.mActivity);
    List list1 = c.bG(paramString);
    c.close();
    return list1;
  }
  
  private void initData() {
    this.list = c.AY();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(((e)this.list.get(0)).getID());
    stringBuilder.append("");
    this.aJw = bG(stringBuilder.toString());
    this.aJx = ((e)this.list.get(0)).getID();
    if (this.aJw.size() > 0) {
      this.aJy = ((c)this.aJw.get(0)).getID();
      this.aJs.setText(((c)this.aJw.get(0)).getName());
    } 
    this.aJr.setText(((e)this.list.get(0)).getName());
  }
  
  private void yP() {
    this.aJn.setOnClickListener(new b(this));
    this.aJo.setOnClickListener(new d(this));
    this.aJv.setOnClickListener(new f(this));
    this.aDI.setOnClickListener(new g(this));
  }
  
  private void yR() {
    ((TextView)findViewById(2131299242)).setText(2131624601);
    this.aJn = findViewById(2131296694);
    this.aJo = findViewById(2131296689);
    this.aJr = (TextView)findViewById(2131299826);
    this.aJs = (TextView)findViewById(2131299092);
    this.aJp = (EditText)findViewById(2131296351);
    this.aJp.setFilters(ar.lw(99));
    this.aJp.requestFocus();
    this.aJp.setSelectAllOnFocus(true);
    this.aJq = (EditText)findViewById(2131298714);
    this.aJq.setSelectAllOnFocus(true);
    this.aJv = findViewById(2131296672);
    this.aDI = findViewById(2131299105);
  }
  
  public void a(a parama) { this.aJz = parama; }
  
  static interface a {
    void a(long param1Long1, long param1Long2, long param1Long3, String param1String);
    
    void bH(String param1String);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */