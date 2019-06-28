package com.laiqian.wallet;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.av;

public class BindingAlipay extends ActivityRoot {
  private av aIP;
  
  private View dKE;
  
  private TextView dKF;
  
  private View dKG;
  
  private TextView dKH;
  
  private View dKI;
  
  private TextView dKJ;
  
  private String dKK;
  
  private String dKL;
  
  private View dKM;
  
  private EditText dKN;
  
  private EditText dKO;
  
  private TextView dKP;
  
  private View dKQ;
  
  private View dKR;
  
  private View dKS;
  
  private String dKT;
  
  private final int dKU = 1;
  
  private final int dKV = -1;
  
  private final int dKW = 2;
  
  private final int dKX = -2;
  
  Handler handler = new g(this);
  
  private void axu() {
    this.dKE = findViewById(R.id.validate_password);
    this.dKH = (TextView)this.dKE.findViewById(R.id.validate_fail);
    this.dKG = this.dKE.findViewById(R.id.validate);
    this.dKG.setEnabled(false);
    this.dKG.setOnClickListener(new a(this));
    this.dKI = this.dKG.findViewById(R.id.validate_icon);
    this.dKJ = (TextView)this.dKG.findViewById(R.id.validate_text);
    this.dKF = (TextView)this.dKE.findViewById(R.id.password);
    this.dKF.addTextChangedListener(new c(this));
  }
  
  private void axv() {
    this.aIP = new av(this);
    this.dKM = findViewById(R.id.binding_l);
    this.dKN = (EditText)this.dKM.findViewById(R.id.account);
    this.dKO = (EditText)this.dKM.findViewById(R.id.name);
    d d = new d(this);
    this.dKN.addTextChangedListener(d);
    this.dKO.addTextChangedListener(d);
    this.dKP = (TextView)this.dKM.findViewById(R.id.binding_fail);
    this.dKQ = this.dKM.findViewById(R.id.bind);
    this.dKQ.setEnabled(false);
    this.dKR = this.dKQ.findViewById(R.id.bind_icon);
    this.dKS = this.dKQ.findViewById(R.id.bind_text);
    this.dKQ.setOnClickListener(new e(this));
  }
  
  public void finish() {
    super.finish();
    overridePendingTransition(R.anim.pos_nomove, R.anim.wallet_bindind_alipay_exit);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.pos_wallet_binding);
    getWindow().setFeatureInt(7, R.layout.pos_title);
    setTitleTextViewHideRightView(R.string.pos_wallet_reflect_add_alipay);
    axu();
    axv();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\BindingAlipay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */