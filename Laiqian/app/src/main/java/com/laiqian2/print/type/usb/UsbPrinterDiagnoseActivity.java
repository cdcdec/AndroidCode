package com.laiqian.print.type.usb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.laiqian.print.a.b;
import com.laiqian.print.a.d;
import com.laiqian.print.type.usb.a.a;
import com.laiqian.print.type.usb.a.b;
import com.laiqian.print.type.usb.a.c;
import com.laiqian.print.type.usb.a.d;
import com.laiqian.print.type.usb.a.e;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;
import com.laiqian.util.r;

public class UsbPrinterDiagnoseActivity extends ActivityRoot {
  int arQ = -1;
  
  int arR = -1;
  
  b cLM;
  
  a cLX;
  
  aa titleBar;
  
  private void ahU() {
    if (this.cLM != null) {
      this.cLM.stop();
      this.cLM = null;
    } 
    this.cLM = new b();
    this.cLM.fz(false);
    a a1 = new a(this, this.arQ, this.arR);
    this.cLX.cLP.b(a1);
    this.cLM.a(a1);
    b b1 = new b(this, (UsbManager)r.E(this, "usb"), this.arQ, this.arR);
    this.cLX.cLQ.b(b1);
    this.cLM.a(b1);
    c c = new c(this, this.arQ, this.arR);
    this.cLX.cLR.b(c);
    this.cLM.a(c);
    d d = new d(this, this.arQ, this.arR);
    this.cLX.cLS.b(d);
    this.cLM.a(d);
    e e = new e(this, this.arQ, this.arR);
    this.cLX.cLT.b(e);
    this.cLM.a(e);
  }
  
  public static Intent b(Context paramContext, int paramInt1, int paramInt2) {
    Intent intent = new Intent(paramContext, UsbPrinterDiagnoseActivity.class);
    intent.putExtra("vendorId", paramInt1);
    intent.putExtra("productId", paramInt2);
    return intent;
  }
  
  @SuppressLint({"SetTextI18n"})
  private void init() {
    this.arQ = getIntent().getIntExtra("vendorId", -1);
    this.arR = getIntent().getIntExtra("productId", -1);
    if (this.arQ == -1 || this.arR == -1) {
      finish();
      return;
    } 
    TextView textView = this.titleBar.tvTitle;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.titleBar.tvTitle.getText());
    stringBuilder.append(": ");
    stringBuilder.append(String.valueOf(this.arQ));
    stringBuilder.append("_");
    stringBuilder.append(String.valueOf(this.arR));
    textView.setText(stringBuilder.toString());
    ahU();
    this.cLM.start();
  }
  
  private void setListeners() {}
  
  private void setupViews() {
    this.titleBar.tvTitle.setText(getString(2131625045));
    this.titleBar.brk.setVisibility(8);
    this.titleBar.brj.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cLX = a.l(getWindow());
    this.titleBar = aa.M(this);
    setupViews();
    setListeners();
    init();
  }
  
  private static class a {
    public View aQG;
    
    public d cLP;
    
    public d cLQ;
    
    public d cLR;
    
    public d cLS;
    
    public d cLT;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cLP = new d(s.z(param1View, 2131297693));
      this.cLQ = new d(s.z(param1View, 2131297694));
      this.cLR = new d(s.z(param1View, 2131297695));
      this.cLS = new d(s.z(param1View, 2131297696));
      this.cLT = new d(s.z(param1View, 2131297697));
    }
    
    public static a l(Window param1Window) {
      View view = View.inflate(param1Window.getContext(), 2131427436, null);
      param1Window.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\typ\\usb\UsbPrinterDiagnoseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */