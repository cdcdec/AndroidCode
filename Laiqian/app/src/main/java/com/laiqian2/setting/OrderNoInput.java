package com.laiqian.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.sales.h;

public class OrderNoInput extends Activity {
  private static String dkv = "100001";
  
  private static String dkw = "100015";
  
  private static String dkx = "100002";
  
  private static String dky = "1000016";
  
  View.OnClickListener dkA = new y(this);
  
  View.OnClickListener dkB = new z(this);
  
  TextWatcher dkC = new aa(this);
  
  private View dkn;
  
  private Button dko;
  
  private TextView dkp;
  
  private TextView dkq;
  
  private EditText dkr;
  
  private Button dks;
  
  private String dkt;
  
  private String dku;
  
  View.OnClickListener dkz = new x(this);
  
  static  {
  
  }
  
  private void wZ() {
    this.dkn = findViewById(2131299878);
    this.dkp = (TextView)findViewById(2131299889);
    this.dkq = (TextView)findViewById(2131298304);
    this.dko = (Button)findViewById(2131299879);
    this.dkr = (EditText)findViewById(2131298303);
    this.dks = (Button)findViewById(2131298305);
    this.dks.setOnClickListener(this.dkz);
  }
  
  private void xa() {
    this.dkn.setOnClickListener(this.dkA);
    this.dko.setOnClickListener(this.dkB);
    this.dkr.addTextChangedListener(this.dkC);
  }
  
  private void xb() {
    Bundle bundle = getIntent().getExtras();
    this.dkt = bundle.getString("BusinessType");
    this.dku = bundle.getString("sOrderNo");
    this.dkr.setText(this.dku);
    this.dkp.setText(getString(2131625117));
    this.dko.setText(getString(2131626119));
  }
  
  public boolean nB(String paramString) {
    h h = new h(this);
    boolean bool = h.nB(paramString);
    h.close();
    return bool;
  }
  
  public boolean nC(String paramString) {
    h h = new h(this);
    boolean bool = h.nC(paramString);
    h.close();
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt1 == 0) {
      if (paramInt2 != -1)
        return; 
      this.dku = paramIntent.getExtras().getString("sOrderNo");
      this.dkr.setText(this.dku);
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427788);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    xb();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\OrderNoInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */