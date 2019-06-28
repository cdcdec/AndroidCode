package com.laiqian.print.usage.kitchen;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.o;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.AbstractActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class KitchenPreviewActivity extends AbstractActivity implements a {
  private w cML = new w(16908290);
  
  private t cMM = null;
  
  private void abi() {
    r r = new r(this, new k(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  private void aiA() {
    String str1 = getString(2131628993);
    String str2 = getString(2131628992);
    f f = new f(this);
    w w1 = new w(this, new String[] { str1, str2 }, f);
    w1.setTitle(getString(2131628990));
    w1.show();
  }
  
  private void aig() {
    i i = new i(this);
    w w1 = new w(this, new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }, i, true);
    w1.setTitle(getString(2131628970));
    w1.show();
  }
  
  private void aii() {
    h h = new h(this);
    w w1 = new w(this, new String[] { "58mm", "80mm" }, h, true);
    w1.setTitle(getString(2131629004));
    w1.show();
  }
  
  private void ail() {
    String str1 = getString(2131628892);
    String str2 = getString(2131628890);
    g g = new g(this);
    w w1 = new w(this, new String[] { str1, str2 }, g, true);
    w1.setTitle(getString(2131628973));
    w1.show();
  }
  
  private void ain() {
    j j = new j(this);
    w w1 = new w(this, new String[] { 
          "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
          "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }, j, true);
    w1.setTitle(getString(2131628967));
    w1.show();
  }
  
  private void aio() { this.cMM.ahz(); }
  
  private void setListeners() {
    ((Button)this.cML.cMT.cNc.getView()).setOnClickListener(new m(this));
    ((ViewGroup)this.cML.cMT.cMV.getView()).setOnClickListener(new n(this));
    ((ViewGroup)this.cML.cMT.cMW.getView()).setOnClickListener(new o(this));
    ((ViewGroup)this.cML.cMT.cMX.getView()).setOnClickListener(new p(this));
    ((ViewGroup)this.cML.cMT.cMY.getView()).setOnClickListener(new q(this));
    ((CheckBox)this.cML.cMT.cNa.dwV.getView()).setOnCheckedChangeListener(new r(this));
    ((ViewGroup)this.cML.cMT.cNa.getView()).setOnClickListener(new s(this));
    ((CheckBox)this.cML.cMT.cMZ.dwV.getView()).setOnCheckedChangeListener(new c(this));
    ((ViewGroup)this.cML.cMT.cMZ.getView()).setOnClickListener(new d(this));
    ((ViewGroup)this.cML.cMT.cNb.getView()).setOnClickListener(new e(this));
  }
  
  private void wR() {
    ((TextView)findViewById(2131299889)).setText(2131628982);
    ((Button)findViewById(2131299879)).setText(getString(2131628864));
    findViewById(2131299879).setOnClickListener(new b(this));
    findViewById(2131299878).setOnClickListener(new l(this));
    ((ViewGroup)this.cML.cMT.cMV.getView()).setBackgroundResource(2131231855);
    ((ViewGroup)this.cML.cMT.cMW.getView()).setBackgroundResource(2131231853);
    ((ViewGroup)this.cML.cMT.cMX.getView()).setBackgroundResource(2131231853);
    ((ViewGroup)this.cML.cMT.cMY.getView()).setBackgroundResource(2131231847);
    ((ViewGroup)this.cML.cMT.cNa.getView()).setBackgroundResource(2131231855);
    ((ViewGroup)this.cML.cMT.cMZ.getView()).setBackgroundResource(2131231847);
    ((ViewGroup)this.cML.cMT.cNb.getView()).setBackgroundResource(2131231853);
    a(this.cML.cMT.cMV.cAO, getString(2131628998));
    a(this.cML.cMT.cMW.cAO, getString(2131628970));
    a(this.cML.cMT.cMX.cAO, getString(2131628967));
    ((TextView)this.cML.cMT.cMY.cAO.getView()).setText(2131628974);
    ((TextView)this.cML.cMT.cNa.cAO.getView()).setText(2131628999);
    ((TextView)this.cML.cMT.cMZ.cAO.getView()).setText(2131628953);
    ((TextView)this.cML.cMT.cNb.cAO.getView()).setText(getString(2131628991));
    ((TextView)this.cML.cMT.cMW.cAP.getView()).setInputType(2);
    ((TextView)this.cML.cMT.cMW.cAP.getView()).setFilters(new InputFilter[] { new InputFilter.LengthFilter(true) });
    ((ViewGroup)this.cML.cMT.cMW.getView()).setVisibility(8);
    ((ViewGroup)this.cML.cMT.cNa.getView()).setVisibility(8);
  }
  
  public void e(ArrayList<PrintContent> paramArrayList, int paramInt) {
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
    Iterator iterator = paramArrayList.iterator();
    while (iterator.hasNext())
      spannableStringBuilder.append(o.a(this, (PrintContent)iterator.next(), paramInt)); 
    a(this.cML.cMS.cMU, spannableStringBuilder);
  }
  
  public void fY(boolean paramBoolean) { ((CheckBox)this.cML.cMT.cNa.dwV.getView()).setChecked(paramBoolean); }
  
  public void fZ(boolean paramBoolean) { ((CheckBox)this.cML.cMT.cMZ.dwV.getView()).setChecked(paramBoolean); }
  
  public void iR(int paramInt) { ((TextView)this.cML.cMT.cMX.cAP.getView()).setText(String.valueOf(paramInt)); }
  
  public void iS(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 2:
        ((TextView)this.cML.cMT.cNb.cAP.getView()).setText(getString(2131628992));
        return;
      case 1:
        break;
    } 
    ((TextView)this.cML.cMT.cNb.cAP.getView()).setText(getString(2131628993));
  }
  
  public void iz(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 2:
        ((TextView)this.cML.cMT.cMY.cAP.getView()).setText(getString(2131628890));
        return;
      case 1:
        break;
    } 
    ((TextView)this.cML.cMT.cMY.cAP.getView()).setText(getString(2131628892));
  }
  
  public void onBackPressed() {
    if (this.cMM.Az()) {
      abi();
      return;
    } 
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.cMM = new t(this, this);
    requestWindowFeature(7);
    setContentView(2131427378);
    getWindow().setFeatureInt(7, 2131428168);
    this.cML.S(findViewById(this.cML.getId()));
    wR();
    setListeners();
    this.cMM.init();
  }
  
  public void save() {
    this.cMM.Kq();
    Toast.makeText(this, 2131628397, 0).show();
  }
  
  public void setCopies(int paramInt) { a(this.cML.cMT.cMW.cAP, Integer.valueOf(paramInt)); }
  
  public void setWidth(int paramInt) { a(this.cML.cMT.cMV.cAP, String.format("%dmm", new Object[] { Integer.valueOf(paramInt) })); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\kitchen\KitchenPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */