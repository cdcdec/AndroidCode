package com.laiqian.print.usage.tag;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.tag.a.c;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.AbstractActivity;
import com.laiqian.ui.container.ab;
import java.util.ArrayList;
import java.util.Iterator;

public class TagPreviewActivity extends AbstractActivity implements a {
  private q cNL = null;
  
  private t cNM = new t(16908290);
  
  private int a(PrintContent.b paramb) {
    boolean bool1 = paramb.agi();
    boolean bool2 = paramb.agh();
    return (bool1 && bool2) ? 2 : 1;
  }
  
  private void abi() {
    r r = new r(this, new h(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  private void aiP() {
    w w = new w(this, this.cNL.cNS, new e(this), true);
    w.setTitle(getString(2131628933));
    w.show();
  }
  
  private void aiQ() {
    w w = new w(this, this.cNL.cNR, new f(this), true);
    w.setTitle(getString(2131628931));
    w.show();
  }
  
  private void aiR() {
    g g = new g(this);
    w w = new w(this, new String[] { "40mm*30mm", "60mm*40mm" }, g, true);
    w.setTitle(getString(2131629004));
    w.show();
  }
  
  private void aio() { this.cNL.ahz(); }
  
  private void c(ab paramab) { paramab.getView().setBackgroundResource(2130772054); }
  
  private int iZ(int paramInt) {
    switch (paramInt) {
      default:
        return 0;
      case 2:
        return Build.MODEL.equals("Q10") ? 37 : 48;
      case 1:
        break;
    } 
    return Build.MODEL.equals("Q10") ? 18 : 24;
  }
  
  private void save() {
    this.cNL.Kq();
    Toast.makeText(this, 2131628397, 0).show();
  }
  
  private void setListeners() {
    ((Button)this.cNM.cNW.cNc.getView()).setOnClickListener(new j(this));
    ((ViewGroup)this.cNM.cNW.cNX.getView()).setOnClickListener(new k(this));
    ((ViewGroup)this.cNM.cNW.cOc.getView()).setOnClickListener(new l(this));
    ((ViewGroup)this.cNM.cNW.cNZ.getView()).setOnClickListener(new m(this));
    ((EditText)this.cNM.cNW.cNw.dwQ.getView()).addTextChangedListener(new n(this));
    ((EditText)this.cNM.cNW.cNA.dwQ.getView()).addTextChangedListener(new o(this));
    ((CheckBox)this.cNM.cNW.cNY.dwV.getView()).setOnCheckedChangeListener(new p(this));
    ((CheckBox)this.cNM.cNW.cOb.dwV.getView()).setOnCheckedChangeListener(new c(this));
    ((CheckBox)this.cNM.cNW.cOa.dwV.getView()).setOnCheckedChangeListener(new d(this));
  }
  
  private void wR() {
    ((TextView)findViewById(2131299889)).setText(2131629000);
    ((Button)findViewById(2131299879)).setText(getString(2131628864));
    findViewById(2131299879).setOnClickListener(new b(this));
    findViewById(2131299878).setOnClickListener(new i(this));
    ((ViewGroup)this.cNM.cNW.cNX.getView()).setBackgroundResource(2130772057);
    ((ViewGroup)this.cNM.cNW.cNw.getView()).setBackgroundResource(2130772054);
    ((ViewGroup)this.cNM.cNW.cNw.getView()).setVisibility(8);
    ((ViewGroup)this.cNM.cNW.cNA.getView()).setBackgroundResource(2130772054);
    ((ViewGroup)this.cNM.cNW.cNY.getView()).setBackgroundResource(2130772050);
    c(this.cNM.cNW.cNZ);
    c(this.cNM.cNW.cOa);
    c(this.cNM.cNW.cOb);
    c(this.cNM.cNW.cOc);
    a(this.cNM.cNW.cNZ.cAO, getString(2131628905));
    a(this.cNM.cNW.cOa.cAO, getString(2131628954));
    a(this.cNM.cNW.cOb.cAO, getString(2131628953));
    a(this.cNM.cNW.cOc.cAO, getString(2131628932));
    a(this.cNM.cNW.cNX.cAO, getString(2131628998));
    a(this.cNM.cNW.cNw.cAO, getString(2131629001));
    a(this.cNM.cNW.cNA.cAO, getString(2131628966));
    a(this.cNM.cNW.cNY.cAO, getString(2131628997));
  }
  
  public void aD(boolean paramBoolean) { ((CheckBox)this.cNM.cNW.cNY.dwV.getView()).setChecked(paramBoolean ^ true); }
  
  public void f(PrintContent paramPrintContent) {
    null = paramPrintContent.Xi();
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
    Iterator iterator = null.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      PrintContent.b b = (PrintContent.b)iterator.next();
      if (!b.agl() && !b.agk()) {
        String str = b.cGI.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\n");
        str = stringBuilder.toString();
        spannableStringBuilder.append(str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(iZ(a(b)), true), i, str.length() + i, 18);
        spannableStringBuilder.setSpan(new AlignmentSpan.Standard(b.agj()), i, str.length() + i, 18);
        i += str.length();
      } 
    } 
    a(this.cNM.cNV.cMU, spannableStringBuilder);
  }
  
  public void ge(boolean paramBoolean) { ((CheckBox)this.cNM.cNW.cOb.dwV.getView()).setChecked(paramBoolean); }
  
  public void gf(boolean paramBoolean) { ((CheckBox)this.cNM.cNW.cOa.dwV.getView()).setChecked(paramBoolean); }
  
  public void mb(String paramString) { a(this.cNM.cNW.cNA.dwQ, paramString); }
  
  public void onBackPressed() {
    if (this.cNL.Az()) {
      abi();
      return;
    } 
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.cNL = new q(this, this);
    requestWindowFeature(7);
    setContentView(2131427429);
    getWindow().setFeatureInt(7, 2131428168);
    this.cNM.S(findViewById(this.cNM.getId()));
    wR();
    setListeners();
    this.cNL.init();
  }
  
  public void setSize(int paramInt1, int paramInt2) { a(this.cNM.cNW.cNX.cAP, String.format("%dmm*%dmm", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) })); }
  
  public void v(String paramString, int paramInt) {
    if (paramInt == c.cOl) {
      ((ViewGroup)this.cNM.cNW.cOa.getView()).setVisibility(8);
    } else {
      ((ViewGroup)this.cNM.cNW.cOa.getView()).setVisibility(0);
    } 
    a(this.cNM.cNW.cNZ.cAP, paramString);
  }
  
  public void w(String paramString, int paramInt) { a(this.cNM.cNW.cOc.cAP, paramString); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\tag\TagPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */