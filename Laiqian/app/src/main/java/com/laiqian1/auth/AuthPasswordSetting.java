package com.laiqian.auth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.c;
import com.laiqian.util.av;
import java.security.NoSuchAlgorithmException;

public class AuthPasswordSetting extends Activity {
  EditText aCW = null;
  
  EditText aCX = null;
  
  EditText aCY = null;
  
  private EditText aCZ;
  
  private EditText aDa;
  
  private EditText aDb;
  
  View.OnClickListener aDc = new f(this);
  
  View.OnClickListener aDd = new h(this);
  
  String aDe;
  
  View.OnClickListener azO = new g(this);
  
  private EditText etDiscount;
  
  private void save() {
    this.aDe = "";
    av av = new av(this);
    try {
      String str = this.aCW.getText().toString().trim();
      if (!"".equals(str)) {
        av.qV(c.cI(str));
      } else {
        av.qV("");
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      Toast.makeText(this, getString(2131626529), 0).show();
      a.e(noSuchAlgorithmException);
    } 
    try {
      String str = this.aCX.getText().toString().trim();
      if (!"".equals(str)) {
        av.qW(c.cI(str));
      } else {
        av.qW("");
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      Toast.makeText(this, getString(2131628141), 0).show();
      a.e(noSuchAlgorithmException);
    } 
    try {
      String str = this.aCY.getText().toString().trim();
      if (!"".equals(str)) {
        av.qX(c.cI(str));
      } else {
        av.qX("");
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      Toast.makeText(this, "设置POS机设置密码失败.", 0).show();
      a.e(noSuchAlgorithmException);
    } 
    try {
      String str = this.etDiscount.getText().toString().trim();
      if (!"".equals(str)) {
        av.qZ(c.cI(str));
      } else {
        av.qZ("");
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      Toast.makeText(this, getString(2131626724), 0).show();
      a.e(noSuchAlgorithmException);
    } 
    try {
      String str = this.aCZ.getText().toString().trim();
      if (!"".equals(str)) {
        av.qY(c.cI(str));
      } else {
        av.qY("");
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      Toast.makeText(this, getString(2131628212), 0).show();
      a.e(noSuchAlgorithmException);
    } 
    try {
      String str = this.aDa.getText().toString().trim();
      if (!"".equals(str)) {
        av.ra(c.cI(str));
      } else {
        av.ra("");
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      Toast.makeText(this, getString(2131627094), 0).show();
      a.e(noSuchAlgorithmException);
    } 
    try {
      String str = this.aDb.getText().toString().trim();
      if (!"".equals(str)) {
        av.rb(c.cI(str));
      } else {
        av.rb("");
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      Toast.makeText(this, getString(2131623951), 0).show();
      a.e(noSuchAlgorithmException);
    } 
    av.close();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427467);
    getWindow().setFeatureInt(7, 2131428168);
    ((LinearLayout)findViewById(2131297838)).setOnClickListener(this.aDc);
    this.aCW = (EditText)findViewById(2131296955);
    this.aCX = (EditText)findViewById(2131296974);
    this.aCY = (EditText)findViewById(2131296971);
    this.aCZ = (EditText)findViewById(2131296977);
    ((TextView)findViewById(2131299889)).setText(getResources().getString(2131626911));
    this.etDiscount = (EditText)findViewById(2131296944);
    this.aDa = (EditText)findViewById(2131296951);
    this.aDb = (EditText)findViewById(2131296943);
    View view = findViewById(2131299878);
    view.setOnClickListener(this.azO);
    Button button = (Button)findViewById(2131299879);
    button.setOnClickListener(this.aDd);
    ((Button)findViewById(2131296605)).setOnClickListener(this.aDd);
    button.setText(getString(2131626588));
    view.setFocusableInTouchMode(true);
    av av = new av(this);
    this.aCW.setText(av.atR());
    this.aCX.setText(av.atS());
    this.aCY.setText(av.atT());
    this.aCZ.setText(av.atU());
    this.etDiscount.setText(av.atV());
    this.aDa.setText(av.atW());
    this.aDb.setText(av.atX());
    av.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\AuthPasswordSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */