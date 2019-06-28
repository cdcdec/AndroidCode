package com.laiqian.takeaway.phone.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.entity.y;
import com.laiqian.takeaway.phone.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;

public class PhoneChangeActivity extends ActivityRoot {
  r.a aCA = new i(this);
  
  private r aCz;
  
  private EditText aFf;
  
  private EditText aFi;
  
  ProgressBarCircularIndeterminate aNv;
  
  private int aRw;
  
  private View azH;
  
  private Button azI;
  
  private TextView azJ;
  
  View.OnClickListener azP = new g(this);
  
  boolean bBoss = true;
  
  private EditText duB;
  
  private TextView duC;
  
  private TextView duD;
  
  private TextView duE;
  
  private TextView duF;
  
  private RadioGroup duG;
  
  private RadioButton duH;
  
  private RadioButton duI;
  
  private EditText duJ;
  
  private EditText duK;
  
  private Button duL = null;
  
  private boolean duM = false;
  
  View.OnClickListener duN = new e(this);
  
  private y duy;
  
  private y aqI() {
    long l = this.duy.aSW;
    String str1 = this.duB.getText().toString().trim();
    String str2 = this.aFf.getText().toString().trim();
    int i = this.aRw;
    String str3 = this.duJ.getText().toString().trim();
    String str4 = this.aFi.getText().toString().trim();
    String str5 = this.duK.getText().toString().trim();
    String str6 = this.duC.getText().toString().trim();
    String str7 = this.duE.getText().toString().trim();
    return new y(l, str2, str1, i, str3, str4, str5, str6, this.duD.getText().toString().trim(), str7, this.duF.getText().toString().trim());
  }
  
  private void save() {
    String str1 = this.duB.getText().toString().trim();
    if (TextUtils.isEmpty(str1)) {
      Toast.makeText(this, getString(2131627047), 0).show();
      this.duB.requestFocus();
      this.duB.setSelection(0);
      return;
    } 
    String str2 = this.aFf.getText().toString().trim();
    String str3 = this.duJ.getText().toString().trim();
    if (TextUtils.isEmpty(str3)) {
      Toast.makeText(this, getString(2131628359), 0).show();
      this.duJ.requestFocus();
      this.duJ.setSelection(0);
      return;
    } 
    String str4 = this.aFi.getText().toString().trim();
    if (TextUtils.isEmpty(str4)) {
      Toast.makeText(this, getString(2131628358), 1).show();
      this.aFi.requestFocus();
      this.aFi.setSelection(0);
      return;
    } 
    String str5 = this.duK.getText().toString().trim();
    String str6 = this.duC.getText().toString().trim();
    String str7 = this.duE.getText().toString().trim();
    String str8 = this.duF.getText().toString().trim();
    String str9 = this.duD.getText().toString().trim();
    (new a(this, new y(this.duy.aSW, str2, str1, this.aRw, str3, str4, str5, str6, str9, str7, str8), this.duM, new h(this))).save();
  }
  
  private void wZ() {
    this.aNv = (ProgressBarCircularIndeterminate)findViewById(2131297346);
    this.azI = (Button)findViewById(2131299879);
    this.duL = (Button)findViewById(2131296550);
    this.azJ = (TextView)findViewById(2131299889);
    this.azJ.setFocusable(true);
    this.azJ.setFocusableInTouchMode(true);
    this.azJ.requestFocus();
    this.azJ.requestFocusFromTouch();
    this.azH = findViewById(2131299878);
    this.duB = (EditText)findViewById(2131297025);
    this.duB.setEnabled(false);
    this.duJ = (EditText)findViewById(2131297020);
    this.aFi = (EditText)findViewById(2131297019);
    this.aFf = (EditText)findViewById(2131297024);
    this.duC = (EditText)findViewById(2131297022);
    this.duE = (TextView)findViewById(2131299786);
    this.duK = (EditText)findViewById(2131297023);
    this.duD = (TextView)findViewById(2131299790);
    this.duF = (TextView)findViewById(2131299785);
    this.duG = (RadioGroup)findViewById(2131299197);
    this.duH = (RadioButton)findViewById(2131299196);
    this.duI = (RadioButton)findViewById(2131299198);
    this.duD.setVisibility(0);
    this.duF.setVisibility(0);
    findViewById(2131297021).setVisibility(8);
  }
  
  private boolean xB() { return !this.duy.aTp.equals(this.duB.getText().toString().trim()) ? true : (!this.duy.name.equals(this.aFf.getText().toString().trim()) ? true : ((Integer.valueOf(this.duy.aRw).intValue() != this.aRw) ? true : (!this.duy.aRu.equals(this.duJ.getText().toString().trim()) ? true : (!this.duy.address.equals(this.aFi.getText().toString().trim()) ? true : (!this.duy.aTq.equals(this.duK.getText().toString().trim()) ? true : ((this.duy.birthday != null && !this.duy.birthday.equals(this.duE.getText().toString().trim()) && !this.duy.birthday.equals("")))))))); }
  
  private void xC() {
    if (xB()) {
      this.aCz = new r(this, true, this.aCA);
      this.aCz.setTitle(getString(2131626593));
      this.aCz.s(getString(2131626814));
      this.aCz.t(getString(2131624290));
      this.aCz.oZ(getString(2131628275));
      this.aCz.show();
      return;
    } 
    finish();
  }
  
  private void xa() {
    this.azI.setOnClickListener(this.azP);
    this.duL.setOnClickListener(this.duN);
    this.azH.setOnClickListener(new a(this));
    this.duG.setOnCheckedChangeListener(new b(this));
    this.duE.setOnClickListener(new c(this));
  }
  
  private void xb() {
    boolean bool;
    this.azJ.setText(2131626621);
    this.azI.setText(2131626588);
    this.duy = (y)getIntent().getSerializableExtra("TELEPHONE_ENTITY");
    if (this.duy == null)
      return; 
    if (Integer.valueOf(this.duy.aRw).intValue() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.duH.setChecked(bool);
    this.duI.setChecked(bool ^ true);
    this.duB.setText(this.duy.aTp);
    this.aFf.setText(this.duy.name);
    this.duJ.setText(this.duy.aRu);
    this.aFi.setText(this.duy.address);
    this.duK.setText(this.duy.aTq);
    this.duC.setText(this.duy.aTr);
    if (this.duy.birthday == null) {
      this.duE.setText("1990-1-1");
    } else {
      this.duE.setText(this.duy.birthday);
    } 
    this.duD.setText(this.duy.aTs);
    this.duF.setText(this.duy.aTt);
  }
  
  public boolean beforeCloseActivity() {
    xC();
    return true;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428052);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    xb();
  }
  
  protected void onDestroy() { super.onDestroy(); }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() {
    super.onResume();
    av av = new av(this);
    String str = av.atp();
    av.close();
    this.bBoss = "150001".equals(str);
    if (!this.bBoss) {
      this.duL.setVisibility(8);
      return;
    } 
    if ("PosSelectTelephone".equals(getIntent().getStringExtra("PosSelectTelephone"))) {
      this.duL.setVisibility(8);
      return;
    } 
    this.duL.setVisibility(0);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) { super.onWindowFocusChanged(paramBoolean); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\PhoneChangeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */