package com.laiqian.product;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.infrastructure.R;
import com.laiqian.models.ac;
import com.laiqian.product.models.g;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.util.m;
import com.laiqian.util.n;

public class fa extends d {
  private EditText aCO;
  
  private String aCP;
  
  private String aCR;
  
  private View aCT;
  
  private r aCU;
  
  @Nullable
  private EditText cTN;
  
  private CheckBox cTO;
  
  private boolean cTP;
  
  private boolean cTQ;
  
  private CheckBox cTR;
  
  private ViewGroup cTS;
  
  private a cTT;
  
  private String cTU;
  
  private int cTV;
  
  private ViewGroup cTW;
  
  private TextView cTX;
  
  private ViewGroup cTY;
  
  private w cTZ;
  
  public fa(Activity paramActivity) {
    super(paramActivity, R.layout.pos_product_main_type_dialog);
    setPositionTop();
    this.tvTitle = (TextView)this.mView.findViewById(R.id.title);
    ViewGroup viewGroup = (ViewGroup)this.mView.findViewById(R.id.mealset_info);
    View view = viewGroup.findViewById(R.id.type_name_l);
    this.aCO = (EditText)view.findViewById(R.id.name);
    view.setOnClickListener(new m.b(this.mActivity, this.aCO));
    view = viewGroup.findViewById(R.id.name2_l);
    if (this.mActivity.getResources().getBoolean(R.bool.has_second_product_name)) {
      this.cTN = (EditText)view.findViewById(R.id.name2);
      view.setOnClickListener(new m.b(this.mActivity, this.cTN));
    } else {
      this.cTN = null;
      ((ViewGroup)view.getParent()).removeView(view);
    } 
    this.cTS = (ViewGroup)viewGroup.findViewById(R.id.upper_l);
    this.cTR = (CheckBox)this.cTS.findViewById(R.id.cb_upper);
    this.cTS.setOnClickListener(new m.b(this.mActivity, this.cTR));
    this.cTW = (ViewGroup)viewGroup.findViewById(R.id.hot_sale_rule_l);
    this.cTX = (TextView)this.cTW.findViewById(R.id.tv_hot_sale_rule);
    this.cTW.setOnClickListener(new fb(this));
    this.cTY = (ViewGroup)viewGroup.findViewById(R.id.qty_l);
    this.cTO = (CheckBox)this.cTY.findViewById(R.id.qty);
    this.cTY.setOnClickListener(new m.b(this.mActivity, this.cTO));
    this.aCT = this.mView.findViewById(R.id.delete);
    this.mView.findViewById(R.id.canal).setOnClickListener(new fc(this));
    this.mView.findViewById(R.id.sure).setOnClickListener(new fd(this));
    this.aCT.setOnClickListener(new fe(this));
  }
  
  private void Xp() {
    this.mActivity.sendBroadcast(new Intent("pos_activity_change_data_producttype"));
    akk();
  }
  
  private void akj() {
    if (this.cTZ == null) {
      Context context = getContext();
      String str1 = getContext().getString(R.string.hot_sale_rules_by_one_month_sale_top_10);
      String str2 = getContext().getString(R.string.hot_sale_rules_by_every_type);
      String str3 = getContext().getString(R.string.hot_sale_rules_by_custom);
      ff ff = new ff(this);
      this.cTZ = new w(context, new String[] { str1, str2, str3 }, ff);
    } 
    this.cTZ.gn(this.cTV);
    this.cTZ.show();
  }
  
  private void akk() { (new fh(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]); }
  
  private String jr(int paramInt) {
    switch (paramInt) {
      default:
        return getContext().getString(R.string.hot_sale_rules_by_one_month_sale_top_10);
      case 2:
        return getContext().getString(R.string.hot_sale_rules_by_custom);
      case 1:
        return getContext().getString(R.string.hot_sale_rules_by_every_type);
      case 0:
        break;
    } 
    return getContext().getString(R.string.hot_sale_rules_by_one_month_sale_top_10);
  }
  
  private r xJ() {
    if (this.aCU == null) {
      this.aCU = new r(this.mActivity, new fg(this));
      this.aCU.s(this.mActivity.getString(R.string.pos_product_dialog_before_delete_type_text));
    } 
    return this.aCU;
  }
  
  public void a(a parama) { this.cTT = parama; }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4) {
    this.aCP = paramString1;
    this.aCO.setText(paramString2);
    if (paramString1 == null) {
      this.tvTitle.setText(R.string.pos_product_type_title_add);
      this.aCT.setVisibility(8);
      this.aCO.requestFocus();
      this.aCO.setEnabled(true);
      if (this.cTN != null)
        this.cTN.setText(null); 
    } else {
      this.tvTitle.setText(R.string.pos_product_type_title_update);
      boolean bool = a.AZ().BN();
      this.aCO.setEnabled(bool);
      if (this.cTN != null) {
        this.cTN.setEnabled(bool);
        this.cTN.setText(paramString3);
      } 
      if (bool) {
        this.aCT.setVisibility(0);
        n.j(this.aCO);
      } else {
        this.aCT.setVisibility(8);
      } 
    } 
    this.cTP = paramBoolean;
    this.cTO.setChecked(paramBoolean);
    this.cTU = paramString4;
    if (paramString4 != null && n.parseLong(paramString4) == 92L) {
      this.cTY.setVisibility(8);
      this.cTS.setVisibility(0);
      this.cTR.setChecked(true);
    } else {
      this.cTR = null;
      if (this.cTS != null) {
        ((ViewGroup)this.cTS.getParent()).removeView(this.cTS);
        this.cTS = null;
      } 
    } 
    this.cTW.setVisibility(8);
    super.show();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, int paramInt) {
    this.cTU = paramString4;
    this.aCP = paramString1;
    this.cTS.setVisibility(0);
    this.cTY.setVisibility(8);
    this.aCO.setText(paramString2);
    if (paramString1 == null) {
      this.tvTitle.setText(R.string.pos_product_type_title_add);
      this.aCT.setVisibility(8);
      this.aCO.requestFocus();
      this.aCO.setEnabled(true);
      if (this.cTN != null)
        this.cTN.setText(null); 
    } else {
      this.tvTitle.setText(R.string.pos_product_type_title_update);
      boolean bool = a.AZ().BN();
      this.aCO.setEnabled(bool);
      if (paramString4 != null && n.parseLong(paramString4) != 92L) {
        this.aCO.setTextColor(getContext().getResources().getColor(R.color.setting_text_color1));
        this.aCT.setVisibility(8);
      } else {
        this.aCO.setTextColor(getContext().getResources().getColor(R.color.pos_text_brown));
        if (bool) {
          this.aCT.setVisibility(0);
          n.j(this.aCO);
        } 
      } 
      if (this.cTN != null) {
        this.cTN.setEnabled(bool);
        this.cTN.setText(paramString3);
      } 
      if (paramString4 != null && n.parseLong(paramString4) == 91L) {
        this.cTW.setVisibility(0);
        this.cTX.setText(jr(paramInt));
        this.cTV = paramInt;
        this.aCO.setEnabled(false);
      } else if (paramString4 != null && n.parseLong(paramString4) == 92L) {
        this.cTW.setVisibility(8);
      } else {
        this.cTW.setVisibility(8);
        this.aCO.setEnabled(false);
      } 
    } 
    this.cTQ = paramBoolean;
    this.cTR.setChecked(paramBoolean);
    super.show();
  }
  
  protected boolean delete() {
    try {
      exception = new ac(this.mActivity);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    boolean bool = exception.O(Long.parseLong(this.aCP));
    if (bool) {
      Xp();
      cancel();
      n.w(this.mActivity, R.string.pos_product_deleted);
    } else {
      n.a(this.mActivity, exception.Vn());
    } 
    exception.close();
    return bool;
  }
  
  protected boolean save() {
    String str2;
    String str1;
    boolean bool1;
    stringBuilder = null;
    try {
      exception = new ac(this.mActivity);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    String str3 = this.aCO.getText().toString().trim();
    int i = str3.length();
    boolean bool = false;
    if (i == 0 || str3.contains("'")) {
      if (str3.length() == 0) {
        n.w(this.mActivity, R.string.pos_product_not_null);
      } else {
        n.w(this.mActivity, R.string.pos_product_name_error);
      } 
      this.aCO.requestFocus();
      n.b(this.mActivity, getCurrentFocus());
      return false;
    } 
    if (this.cTN != null) {
      str1 = this.cTN.getText().toString().trim();
      stringBuilder = str1;
      if (str1.contains("'")) {
        this.cTN.requestFocus();
        n.eP(R.string.pos_product_name_error);
        n.b(this.mActivity, getCurrentFocus());
        return false;
      } 
    } 
    if (this.cTR != null) {
      bool1 = this.cTR.isChecked();
    } else {
      bool1 = true;
    } 
    boolean bool2 = this.cTO.isChecked();
    if (bool2) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    if (bool1) {
      str2 = "0";
    } else {
      str2 = "1";
    } 
    if (this.aCP == null) {
      bool1 = exception.d(str3, stringBuilder, str1, this.cTU, str2);
      this.aCR = exception.hQ("_id");
      stringBuilder = new StringBuilder();
      stringBuilder.append("新建的商品类型ID：");
      stringBuilder.append(this.aCR);
      n.println(stringBuilder.toString());
    } else {
      try {
        long l = Long.parseLong(this.aCP);
        if (this.cTP != bool2) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        bool1 = exception.a(l, str3, stringBuilder, str1, bool1, this.cTU, str2, this.cTV);
      } catch (NumberFormatException stringBuilder) {
        a.e(stringBuilder);
        bool1 = bool;
      } 
    } 
    if (bool1) {
      Xp();
      cancel();
      if (this.aCP == null) {
        n.w(this.mActivity, R.string.pos_product_created);
      } else {
        n.w(this.mActivity, R.string.pos_product_updated);
      } 
    } else {
      n.a(this.mActivity, exception.Vn());
      n.j(this.aCO);
    } 
    exception.close();
    return bool1;
  }
  
  @Deprecated
  public void show() { super.show(); }
  
  protected void xI() {
    if ((new g(this.mActivity)).mC(this.aCP)) {
      n.w(this.mActivity, R.string.pos_product_dialog_delete_has_child);
      return;
    } 
    xJ().show();
  }
  
  public static interface a {
    void a(boolean param1Boolean1, String param1String1, String param1String2, boolean param1Boolean2);
    
    void a(boolean param1Boolean1, String param1String1, String param1String2, boolean param1Boolean2, int param1Int, boolean param1Boolean3);
    
    void c(boolean param1Boolean, String param1String1, String param1String2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\fa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */