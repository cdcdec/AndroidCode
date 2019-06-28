package com.laiqian.print.type.net;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.laiqian.print.a.b;
import com.laiqian.print.a.d;
import com.laiqian.print.type.net.a.a;
import com.laiqian.print.type.net.a.b;
import com.laiqian.print.type.net.a.c;
import com.laiqian.print.type.net.a.d;
import com.laiqian.print.type.net.a.e;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;

public class NetPrinterDiagnoseActivity extends ActivityRoot {
  String abu;
  
  a cLL;
  
  b cLM;
  
  aa titleBar;
  
  private void ahU() {
    if (this.cLM != null) {
      this.cLM.stop();
      this.cLM = null;
    } 
    this.cLM = new b();
    b b1 = new b(this, this.abu);
    this.cLL.cLP.b(b1);
    this.cLM.a(b1);
    a a1 = new a(this);
    this.cLL.cLQ.b(a1);
    this.cLM.a(a1);
    d d = new d(this);
    this.cLL.cLR.b(d);
    this.cLM.a(d);
    e e = new e(this, this.abu);
    this.cLL.cLS.b(e);
    this.cLM.a(e);
    c c = new c(this, this.abu);
    this.cLL.cLT.b(c);
    this.cLM.a(c);
    this.cLM.a(new w(this, b1));
  }
  
  private void init() {
    String str = getIntent().getStringExtra("ip");
    TextView textView = this.titleBar.tvTitle;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.titleBar.tvTitle.getText());
    stringBuilder.append(": ");
    stringBuilder.append(str);
    textView.setText(stringBuilder.toString());
    if (str == null) {
      finish();
      return;
    } 
    this.abu = str;
    ahU();
    this.cLM.start();
  }
  
  private void setListeners() {}
  
  private void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131625019));
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setVisibility(8);
  }
  
  public static void start(Context paramContext, String paramString) {
    Intent intent = new Intent(paramContext, NetPrinterDiagnoseActivity.class);
    intent.putExtra("ip", paramString);
    paramContext.startActivity(intent);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cLL = a.k(getWindow());
    this.titleBar = aa.M(this);
    setupViews();
    setListeners();
    init();
  }
  
  private static class a {
    public View aQG;
    
    d cLP;
    
    d cLQ;
    
    d cLR;
    
    d cLS;
    
    d cLT;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cLP = new d(s.z(param1View, 2131297693));
      this.cLQ = new d(s.z(param1View, 2131297694));
      this.cLR = new d(s.z(param1View, 2131297695));
      this.cLS = new d(s.z(param1View, 2131297696));
      this.cLT = new d(s.z(param1View, 2131297697));
    }
    
    public static a k(Window param1Window) {
      View view = View.inflate(param1Window.getContext(), 2131427394, null);
      param1Window.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\NetPrinterDiagnoseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */