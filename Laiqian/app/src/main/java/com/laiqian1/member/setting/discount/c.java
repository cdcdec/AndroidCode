package com.laiqian.member.setting.discount;

import android.content.Context;
import android.text.InputFilter;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.entity.h;
import com.laiqian.member.model.a;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.util.ar;
import com.laiqian.util.by;
import com.laiqian.util.e;
import com.laiqian.util.n;
import com.laiqian.vip.R;

public class c extends d {
  private r aCU;
  
  TextView bDA;
  
  private String bDB;
  
  e.a<String> bDC = new l(this);
  
  e.a<String> bDD = new m(this);
  
  e.a<String> bDE = new e(this);
  
  EditText bDu;
  
  EditText bDv;
  
  a bDw = null;
  
  h bDx;
  
  InputMethodManager bDy;
  
  TextView bDz;
  
  Context mContext;
  
  TextView tvTitle;
  
  public c(Context paramContext) {
    super(paramContext, R.layout.recharge_privilege_dialog);
    this.mContext = paramContext;
    setPositionTop();
    this.tvTitle = (TextView)this.mView.findViewById(R.id.parameter).findViewById(R.id.title);
    this.bDu = (EditText)findViewById(R.id.et_recharge_amount);
    this.bDv = (EditText)findViewById(R.id.et_give_amount);
    this.bDy = (InputMethodManager)paramContext.getSystemService("input_method");
    e(this.bDv);
    e(this.bDu);
    this.bDA = (TextView)findViewById(R.id.tv_confirm);
    findViewById(R.id.tv_cancel).setOnClickListener(new d(this));
    this.bDA.setOnClickListener(new f(this));
    RE();
    this.bDz = (TextView)findViewById(R.id.tv_delete);
    this.bDz.setOnClickListener(new g(this));
  }
  
  private void O(String paramString1, String paramString2) { (new j(this, this.bDE, paramString1, paramString2)).asz(); }
  
  private void P(String paramString1, String paramString2) { (new k(this, this.bDC, paramString1, paramString2)).asz(); }
  
  private void RE() {
    if (this.aCU == null) {
      this.aCU = new r(this.mContext, new h(this));
      this.aCU.s(this.mContext.getString(R.string.pos_member_delete));
    } 
  }
  
  private void Sb() {
    String str1 = this.bDu.getText().toString().trim();
    if (by.isNull(str1)) {
      this.bDu.requestFocus();
      n.eP(R.string.recharge_empty);
      return;
    } 
    if (by.parseDouble(str1) <= 0.0D) {
      this.bDu.requestFocus();
      n.eP(R.string.recharge_invalid);
      return;
    } 
    String str2 = this.bDv.getText().toString().trim();
    if (by.isNull(str2)) {
      this.bDv.requestFocus();
      n.eP(R.string.give_empty);
      return;
    } 
    if (by.parseDouble(str2) < 0.0D) {
      this.bDv.requestFocus();
      n.eP(R.string.give_invalid);
      return;
    } 
    dV(false);
    a a1 = new a(this.mContext);
    if (this.bDx != null) {
      O(str1, str2);
    } else {
      P(str1, str2);
    } 
    a1.close();
  }
  
  private void Sc() { (new i(this, this.bDD)).asz(); }
  
  private void delete() { Sc(); }
  
  void Sd() {
    if (this.bDw != null)
      this.bDw.Sa(); 
  }
  
  public void a(a parama) { this.bDw = parama; }
  
  public void b(h paramh) {
    this.bDx = paramh;
    if (paramh != null) {
      this.bDu.setText(n.b(this.mContext, Double.valueOf(paramh.aSc), true, false));
      this.bDB = n.b(this.mContext, Double.valueOf(paramh.aSc), true, false);
      this.bDv.setText(n.b(this.mContext, Double.valueOf(paramh.aSd), true, false));
      this.bDz.setVisibility(0);
      this.bDu.clearFocus();
      this.bDu.requestFocus();
      this.tvTitle.setText(this.mContext.getString(R.string.update_recharge));
      return;
    } 
    this.bDu.setText("");
    this.bDv.setText("");
    this.bDz.setVisibility(8);
    this.tvTitle.setText(this.mContext.getString(R.string.create_recharge));
  }
  
  public void cancel() { super.cancel(); }
  
  public void dV(boolean paramBoolean) {
    this.bDA.setEnabled(paramBoolean);
    this.bDA.setClickable(paramBoolean);
    this.bDA.setFocusable(paramBoolean);
  }
  
  void e(EditText paramEditText) {
    paramEditText.setFilters(new InputFilter[0]);
    paramEditText.setFilters(new InputFilter[] { ar.lx(99), new InputFilter.LengthFilter(10) });
  }
  
  public void show() {
    super.show();
    this.bDu.requestFocus();
  }
  
  public static interface a {
    void Sa();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */