package com.laiqian.opentable.a;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.opentable.R;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.ordertool.c.a;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.util.m;
import com.laiqian.util.n;

public class b extends d implements g {
  private View aCT;
  
  private r aCU;
  
  private EditText bYv;
  
  private String bYw;
  
  private String bYx;
  
  private a bYy;
  
  private h bYz;
  
  public b(FragmentActivity paramFragmentActivity, a parama) {
    super(paramFragmentActivity, R.layout.pos_main_area_dialog);
    setPositionTop();
    this.bYz = new h(this.mActivity, this, parama);
    this.tvTitle = (TextView)this.mView.findViewById(R.id.title);
    View view = findViewById(R.id.type_name_l);
    this.bYv = (EditText)view.findViewById(R.id.name);
    view.setOnClickListener(new m.b(this.mActivity, this.bYv));
    this.aCT = this.mView.findViewById(R.id.delete);
    this.mView.findViewById(R.id.canal).setOnClickListener(new c(this));
    this.mView.findViewById(R.id.sure).setOnClickListener(new d(this));
    this.aCT.setOnClickListener(new e(this));
  }
  
  private void Xp() { this.mActivity.sendBroadcast(new Intent("pos_activity_change_data_area")); }
  
  private r xJ() {
    if (this.aCU == null) {
      this.aCU = new r(this.mActivity, new f(this));
      this.aCU.s(this.mActivity.getString(R.string.pos_area_dialog_before_delete_area_text));
    } 
    return this.aCU;
  }
  
  public void Xq() {
    String str = this.bYv.getText().toString().trim();
    if (iT(str))
      this.bYz.iU(str); 
  }
  
  public void Xr() {
    String str = this.bYv.getText().toString().trim();
    if (iT(str)) {
      long l = Long.parseLong(this.bYw);
      this.bYz.f(new a(l, str));
    } 
  }
  
  public void Xs() { this.bYz.bX(Long.valueOf(this.bYw).longValue()); }
  
  public void Xt() {
    long l = Long.parseLong(this.bYw);
    this.bYz.bW(l);
  }
  
  public void a(a parama) { this.bYy = parama; }
  
  public void at(String paramString1, String paramString2) {
    this.bYw = paramString1;
    this.bYv.setText(paramString2);
    if (paramString1 == null) {
      this.tvTitle.setText(R.string.pos_area_new_title_add);
      this.aCT.setVisibility(8);
      this.bYv.requestFocus();
      this.bYv.setEnabled(true);
    } else {
      this.tvTitle.setText(R.string.pos_product_type_title_update);
      this.aCT.setVisibility(0);
      n.j(this.bYv);
    } 
    super.show();
  }
  
  public void d(boolean paramBoolean, String paramString1, String paramString2) {
    if (paramBoolean) {
      this.bYx = paramString1;
      Xp();
      cancel();
      n.w(this.mActivity, R.string.pos_product_created);
      if (this.bYy != null)
        this.bYy.e(paramBoolean, this.bYx, paramString2); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("新建区域ID：");
      stringBuilder.append(this.bYx);
      n.println(stringBuilder.toString());
      return;
    } 
    n.j(this.bYv);
  }
  
  public void ex(boolean paramBoolean) {
    if (paramBoolean) {
      Xp();
      cancel();
      n.w(this.mActivity, R.string.pos_product_updated);
      if (this.bYy != null) {
        String str = this.bYv.getText().toString();
        this.bYy.f(paramBoolean, this.bYw, str);
        return;
      } 
    } else {
      n.j(this.bYv);
    } 
  }
  
  public void ey(boolean paramBoolean) {
    if (paramBoolean) {
      n.w(this.mActivity, R.string.pos_area_dialog_delete_has_child);
      return;
    } 
    xJ().show();
  }
  
  public void ez(boolean paramBoolean) {
    if (paramBoolean) {
      Xp();
      cancel();
      n.w(this.mActivity, R.string.pos_product_deleted);
      this.aCU.cancel();
      if (this.bYy != null) {
        this.bYy.g(paramBoolean, this.bYw, this.bYv.getText().toString());
        return;
      } 
    } else {
      n.eP(R.string.diagnose_state_failed);
    } 
  }
  
  public void fa(String paramString) { n.o(paramString); }
  
  public boolean iT(String paramString) {
    if (paramString.length() == 0 || paramString.contains("'")) {
      if (paramString.length() == 0) {
        n.w(this.mActivity, R.string.pos_product_not_null);
      } else {
        n.w(this.mActivity, R.string.pos_product_name_error);
      } 
      this.bYv.requestFocus();
      n.b(this.mActivity, getCurrentFocus());
      return false;
    } 
    return true;
  }
  
  @Deprecated
  public void show() { super.show(); }
  
  public static interface a {
    void e(boolean param1Boolean, String param1String1, String param1String2);
    
    void f(boolean param1Boolean, String param1String1, String param1String2);
    
    void g(boolean param1Boolean, String param1String1, String param1String2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */