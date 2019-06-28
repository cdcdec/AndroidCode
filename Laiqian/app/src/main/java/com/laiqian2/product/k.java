package com.laiqian.product;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.product.models.a;
import com.laiqian.product.models.g;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.util.ar;
import com.laiqian.util.m;
import com.laiqian.util.n;

public class k extends d {
  private r aCU;
  
  private EditText aFf;
  
  private a cPj;
  
  private ViewGroup cPk;
  
  @Nullable
  private EditText cPl;
  
  private EditText cPm;
  
  private View cPn;
  
  private EditText cPo;
  
  private a cPp;
  
  private View ccU;
  
  public k(Activity paramActivity, a parama) {
    super(paramActivity, 2131427948);
    this.cPp = parama;
    setPositionTop();
    this.tvTitle = (TextView)this.mView.findViewById(2131299242);
    this.cPk = (ViewGroup)this.mView.findViewById(2131298119);
    View view = this.cPk.findViewById(2131298202);
    this.aFf = (EditText)view.findViewById(2131298198);
    view.setOnClickListener(new m.b(this.mActivity, this.aFf));
    view = this.cPk.findViewById(2131298200);
    if (this.mActivity.getResources().getBoolean(2131034120)) {
      this.cPl = (EditText)view.findViewById(2131298199);
      view.setOnClickListener(new m.b(this.mActivity, this.cPl));
    } else {
      this.cPl = null;
      this.cPk.removeView(view);
    } 
    view = this.cPk.findViewById(2131298478);
    this.cPm = (EditText)view.findViewById(2131298473);
    view.setOnClickListener(new m.b(this.mActivity, this.cPm));
    this.cPn = this.cPk.findViewById(2131298482);
    this.cPo = (EditText)this.cPn.findViewById(2131298481);
    this.cPn.setOnClickListener(new m.b(this.mActivity, this.cPo));
    this.ccU = this.mView.findViewById(2131296858);
    this.mView.findViewById(2131296671).setOnClickListener(new l(this));
    this.mView.findViewById(2131299105).setOnClickListener(new m(this));
    this.ccU.setOnClickListener(new n(this));
  }
  
  private String[] ajp() {
    String str1;
    String str4 = this.aFf.getText().toString().trim();
    int i = str4.length();
    String str2 = null;
    if (i == 0 || str4.contains("'")) {
      if (str4.length() == 0) {
        n.eP(2131627529);
      } else {
        n.eP(2131627554);
      } 
      this.aFf.requestFocus();
      n.b(this.mActivity, getCurrentFocus());
      return null;
    } 
    String str3 = this.cPm.getText().toString().trim();
    if (str3.length() == 0) {
      n.eP(2131627532);
      this.cPm.requestFocus();
      n.b(this.mActivity, getCurrentFocus());
      return null;
    } 
    if (this.cPn.getParent() != null) {
      String str = this.cPo.getText().toString().trim();
      str1 = str;
      if (str.length() == 0) {
        n.eP(2131627534);
        this.cPo.requestFocus();
        n.b(this.mActivity, getCurrentFocus());
        return null;
      } 
    } else {
      str1 = str3;
    } 
    if (this.cPl != null) {
      str2 = this.cPl.getText().toString().trim();
      if (str2.contains("'")) {
        n.eP(2131627554);
        this.cPl.requestFocus();
        n.b(this.mActivity, getCurrentFocus());
        return null;
      } 
    } 
    return new String[] { str4, str3, str1, str2 };
  }
  
  private r xJ() {
    if (this.aCU == null) {
      this.aCU = new r(this.mActivity, new o(this));
      this.aCU.s(this.mActivity.getString(2131627539));
    } 
    return this.aCU;
  }
  
  protected void delete() {
    g g = new g(this.mActivity);
    boolean bool = g.cR(this.cPj.aSW);
    if (bool) {
      this.mActivity.sendBroadcast(new Intent("pos_activity_change_data_producttype"));
      cancel();
      n.eP(2131627489);
    } else {
      n.o(g.Vn());
    } 
    g.close();
    if (this.cPp != null)
      this.cPp.c(bool, this.cPj.aSW, this.cPj.name); 
  }
  
  public void e(a parama) {
    this.cPj = parama;
    InputFilter[] arrayOfInputFilter = new InputFilter[0];
    this.cPm.setFilters(arrayOfInputFilter);
    this.cPo.setFilters(arrayOfInputFilter);
    if (parama == null) {
      this.tvTitle.setText(2131627527);
      this.ccU.setVisibility(8);
      this.aFf.requestFocus();
      this.aFf.setText("");
      this.cPm.setText("");
      this.cPo.setText("");
      if (this.cPl != null)
        this.cPl.setText(null); 
    } else {
      this.tvTitle.setText(2131627550);
      this.ccU.setVisibility(0);
      this.tvTitle.requestFocus();
      this.aFf.setText(parama.name);
      this.cPm.setText(String.valueOf(parama.akI()));
      this.cPo.setText(String.valueOf(parama.akK()));
      if (this.cPl != null)
        this.cPl.setText(parama.cpm); 
    } 
    this.cPm.setFilters(ar.lw(99));
    this.cPo.setFilters(ar.lw(99));
    if (a.AZ().Bx()) {
      if (this.cPn.getParent() != null)
        ((ViewGroup)this.cPn.getParent()).removeView(this.cPn); 
    } else if (this.cPn.getParent() == null) {
      this.cPk.addView(this.cPn);
    } 
    super.show();
  }
  
  protected void save() {
    boolean bool;
    null = ajp();
    if (null == null)
      return; 
    String str1 = null[0];
    String str2 = null[1];
    String str3 = null[2];
    String str4 = null[3];
    g g = new g(this.mActivity);
    if (this.cPj == null) {
      long l = System.currentTimeMillis();
      boolean bool1 = g.a(l, str1, str2, str3, str4);
      if (bool1)
        n.eP(2131627484); 
      bool = bool1;
      if (this.cPp != null) {
        this.cPp.a(bool1, l, str1);
        bool = bool1;
      } 
    } else {
      long l = this.cPj.aSW;
      boolean bool1 = g.b(l, str1, str2, str3, str4);
      if (bool1) {
        n.eP(2131627647);
        this.mActivity.sendBroadcast(new Intent("pos_activity_change_data_product"));
      } 
      bool = bool1;
      if (this.cPp != null) {
        this.cPp.b(bool1, l, str1);
        bool = bool1;
      } 
    } 
    if (bool) {
      cancel();
    } else {
      n.j(this.aFf);
      n.a(this.mActivity, g.Vn());
    } 
    g.close();
  }
  
  @Deprecated
  public void show() { super.show(); }
  
  protected void xI() { xJ().show(); }
  
  public static interface a {
    void a(boolean param1Boolean, long param1Long, String param1String);
    
    void b(boolean param1Boolean, long param1Long, String param1String);
    
    void c(boolean param1Boolean, long param1Long, String param1String);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */