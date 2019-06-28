package com.laiqian.member.setting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.g;
import com.laiqian.member.b.b;
import com.laiqian.models.at;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.LayoutLeftTextRightEditText;
import com.laiqian.ui.container.LayoutLeftTextRightEditTextWithUnit;
import com.laiqian.ui.container.LayoutLeftTextRightTextWithDialog;
import com.laiqian.ui.container.aa;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CreateVipGradeAndGradeDetailActivity extends ActivityRoot implements m, aa {
  private int bBd = -1;
  
  private int bBe = 2;
  
  private int bBf;
  
  private a bBg;
  
  private g bBh;
  
  private g bBi;
  
  private j bBj;
  
  private ArrayList<Integer> bBk;
  
  private r bBl;
  
  private BlockingQueue<Integer> bBm = new ArrayBlockingQueue(5);
  
  private void Rn() {
    long l = bc.RH().RI() + 1L;
    if (LQKVersion.zo()) {
      String str = String.valueOf(l);
      int i = n.parseInt(str.substring(str.length() - 3, str.length()));
      if (i > 3 && i < 7) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RootApplication.getLaiqianPreferenceManager().Tx());
        stringBuilder.append(26);
        stringBuilder.append("007");
        String str1 = stringBuilder.toString();
        this.bBi.ag(n.parseLong(str1));
        return;
      } 
      this.bBi.ag(l);
      return;
    } 
    this.bBi.ag(l);
  }
  
  private boolean Ro() {
    double d;
    if (!Az())
      return true; 
    if (this.bBk == null)
      return false; 
    if (this.bBk.isEmpty())
      return false; 
    if (this.bBe == -1)
      return true; 
    int i = this.bBe;
    at at = new at(this);
    g g1 = at.bJ(i);
    at.close();
    if (g1 == null)
      return false; 
    if (!a.AZ().Bs()) {
      d = g1.ET();
      this.bBi.j(d);
    } else {
      String str = this.bBg.bBu.aqU().getText().toString();
      if (TextUtils.isEmpty(str)) {
        fU(getString(R.string.member_amount_not_null));
        return false;
      } 
      d = Double.parseDouble(str);
    } 
    if (Double.compare(d, g1.ET()) < 0) {
      i = R.string.member_amount_not_fit;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(g1.ET());
      stringBuilder.append("");
      fU(getString(i, new Object[] { stringBuilder.toString() }));
      return false;
    } 
    if (this.bBf == 1 && Double.compare(this.bBh.ET(), this.bBi.ET()) != 0)
      this.bBm.add(Integer.valueOf(2)); 
    return true;
  }
  
  @SuppressLint({"StringFormatInvalid"})
  private boolean Rp() {
    double d;
    if (!Az())
      return true; 
    String str = this.bBg.bBq.aqU().getText().toString();
    if (TextUtils.isEmpty(str)) {
      fU(getString(R.string.member_discount_not_null));
      return false;
    } 
    boolean bool = a.AZ().Bx();
    if (bool) {
      d = Double.parseDouble(str);
    } else {
      d = this.bBh.EU();
    } 
    if (this.bBk == null)
      return false; 
    if (this.bBk.isEmpty())
      return false; 
    if (this.bBe == -1) {
      if (Double.compare(d, a.AZ().BA()) != 0) {
        a.AZ().f(d);
        this.bBm.add(Integer.valueOf(1));
        return true;
      } 
    } else {
      int i = this.bBe;
      g g1 = bc.RH().fN(i);
      if (g1 == null)
        return false; 
      double d1 = d;
      if (this.bBf == 0) {
        d1 = d;
        if (!bool) {
          d1 = g1.EU();
          this.bBi.k(d1);
        } 
      } 
      if (Double.compare(d1, g1.EU()) > 0) {
        i = R.string.member_discount_not_fit;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(g1.EU());
        stringBuilder.append("%");
        fU(getString(i, new Object[] { stringBuilder.toString() }));
        return false;
      } 
      if (this.bBf == 1 && Double.compare(this.bBh.EU(), this.bBi.EU()) != 0) {
        this.bBm.add(Integer.valueOf(1));
        return true;
      } 
    } 
    return true;
  }
  
  private boolean a(g paramg) {
    if (paramg.getId() <= 0L) {
      fU(getString(R.string.member_rank_name_is_existed));
      return true;
    } 
    if (Az()) {
      if (this.bBh.EV().equals(paramg.EV()))
        return false; 
      boolean bool = bc.RH().f(paramg);
      if (bool)
        fU(getString(R.string.member_rank_name_is_existed)); 
      return bool;
    } 
    return false;
  }
  
  private void initData() {
    setTitleTextViewRight(getString(R.string.auth_submitButton), true, new a(this));
    bundle = getIntent().getExtras();
    int i = bundle.getInt("enterType", 1);
    bundle.getLong("last_level_id", -1L);
    this.bBk = bundle.getIntegerArrayList("grade_ids");
    this.bBf = i;
    this.bBe = bundle.getInt("last_level", -1);
    this.bBd = bundle.getInt("position_in_list", 0);
    if (i == 1) {
      try {
        g g1 = (g)bundle.getSerializable("gradeData");
        this.bBh = g1.EO();
        this.bBi = g1.EO();
      } catch (Exception bundle) {
        a.e(bundle);
      } 
      this.bBg.fK(this.bBd);
      this.bBg.b(this.bBh);
      this.bBg.bBv.setOnClickListener(new b(this));
      return;
    } 
    this.bBh = new g();
    this.bBi = new g();
    Rn();
    this.bBi.es(this.bBe + 1);
    this.bBg.fL(this.bBd);
    this.bBg.bBp.requestFocus();
    this.bBg.Rs();
    this.bBg.bBv.setVisibility(8);
    this.bBg.bBt.a((String[])n.a(this, b.bwW).toArray(new String[0]), new c(this));
    this.bBi.er(this.bBg.bBt.aaL());
  }
  
  private void setListeners() {
    this.bBl = new r(getActivity(), new d(this));
    this.bBl.setTitle(getActivity().getString(R.string.ol_deleteItem));
    this.bBl.s(getActivity().getString(R.string.confirm_delete));
    this.bBl.oZ(getActivity().getString(R.string.pos_dialog_confirm_no));
    this.bBl.t(getActivity().getString(R.string.pos_dialog_confirm_yes));
    this.bBg.bBo.a(new e(this));
    this.bBg.bBp.a(new f(this));
    this.bBg.bBq.a(new g(this));
    this.bBg.bBu.a(new h(this));
  }
  
  private void setupViews() { this.bBg = new a(this); }
  
  public boolean Az() { return this.bBh.equals(this.bBi) ^ true; }
  
  public boolean Rq() {
    if (Az()) {
      if (TextUtils.isEmpty(this.bBg.bBo.aqU().getText().toString())) {
        fU(getString(R.string.member_rank_title_not_null));
        return false;
      } 
      if (TextUtils.isEmpty(this.bBg.bBp.aqU().getText().toString())) {
        this.bBg.bBp.aqU().requestFocus();
        fU(getString(R.string.member_rank_name_not_null));
        return false;
      } 
      if (TextUtils.isEmpty(this.bBg.bBq.aqU().getText().toString())) {
        this.bBg.bBq.aqU().requestFocus();
        fU(getString(R.string.member_discount_not_null));
        return false;
      } 
      if (TextUtils.isEmpty(this.bBg.bBu.aqU().getText().toString()) && a.AZ().Bs()) {
        this.bBg.bBu.aqU().requestFocus();
        fU(getString(R.string.member_amount_not_null));
        return false;
      } 
      this.bBi.EV();
      double d = this.bBi.EU();
      this.bBi.ET();
      if (d <= 0.0D || d > 100.0D) {
        fU(getString(R.string.invalid_discount));
        return false;
      } 
    } 
    return true;
  }
  
  public void Rr() { resetSaveButtonProgress(); }
  
  public void a(aa paramaa) {}
  
  public void close() {
    Rr();
    finish();
  }
  
  public void fU(String paramString) { Toast.makeText(this, paramString, 0).show(); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.activity_grade_create_and_detail);
    setTitleTextView(R.string.member_rank_title);
    setupViews();
    initData();
    setListeners();
    this.bBj = new j(this, this.bBh, this.bBi, this, this.bBm);
  }
  
  protected void onResume() {
    super.onResume();
    if (this.bBf == 0)
      this.bBg.bBp.aqU().requestFocus(); 
  }
  
  public void save() { this.bBj.save(); }
  
  static class a {
    LayoutLeftTextRightEditText bBo;
    
    LayoutLeftTextRightEditText bBp;
    
    LayoutLeftTextRightEditTextWithUnit bBq;
    
    LayoutLeftTextRightEditText bBr;
    
    LinearLayout bBs;
    
    LayoutLeftTextRightTextWithDialog bBt;
    
    LayoutLeftTextRightEditTextWithUnit bBu;
    
    Button bBv;
    
    Context mContext;
    
    int position = 0;
    
    public a(Activity param1Activity) {
      this.mContext = param1Activity;
      this.bBo = (LayoutLeftTextRightEditText)param1Activity.findViewById(R.id.member_level);
      this.bBo.aqU().setInputType(2);
      this.bBp = (LayoutLeftTextRightEditText)param1Activity.findViewById(R.id.member_level_name);
      this.bBq = (LayoutLeftTextRightEditTextWithUnit)param1Activity.findViewById(R.id.member_level_discount);
      this.bBq.aqU().setInputType(8194);
      if (a.AZ().Bx()) {
        n.a(this.bBq.aqU(), 20, a.AZ().Be());
        this.bBq.setFocusable(false);
      } 
      this.bBr = (LayoutLeftTextRightEditText)param1Activity.findViewById(R.id.member_level_point);
      this.bBr.aqU().setInputType(8194);
      n.a(this.bBr.aqU(), 20, a.AZ().Be());
      this.bBs = (LinearLayout)param1Activity.findViewById(R.id.ll_upgrade_rule);
      this.bBt = (LayoutLeftTextRightTextWithDialog)param1Activity.findViewById(R.id.member_level_upgrade_rule);
      this.bBu = (LayoutLeftTextRightEditTextWithUnit)param1Activity.findViewById(R.id.member_level_upgrade_rule_threshold);
      this.bBu.aqU().setInputType(8194);
      n.a(this.bBu.aqU(), 20, a.AZ().Be());
      this.bBv = (Button)param1Activity.findViewById(R.id.member_grade_delete);
      if (a.AZ().Bs()) {
        this.bBs.setVisibility(0);
        this.bBt.oX(a.AZ().Bt());
        return;
      } 
      this.bBs.setVisibility(8);
    }
    
    public void Rs() {
      String str;
      boolean bool = a.AZ().Bx();
      LayoutLeftTextRightEditTextWithUnit layoutLeftTextRightEditTextWithUnit = this.bBq;
      if (bool) {
        str = "%";
      } else {
        str = "";
      } 
      layoutLeftTextRightEditTextWithUnit.oY(str);
      layoutLeftTextRightEditTextWithUnit = this.bBq;
      if (bool) {
        str = "";
      } else {
        str = this.mContext.getString(R.string.product_member_price);
      } 
      layoutLeftTextRightEditTextWithUnit.oX(str);
      this.bBq.aqU().setEnabled(bool);
      this.bBq.aqU().setFocusable(bool);
    }
    
    public void b(g param1g) {
      fL(this.position);
      this.bBp.oX(param1g.EV());
      c(param1g);
      LayoutLeftTextRightEditText layoutLeftTextRightEditText = this.bBr;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1g.ER());
      stringBuilder.append("");
      layoutLeftTextRightEditText.oX(stringBuilder.toString());
      LayoutLeftTextRightTextWithDialog layoutLeftTextRightTextWithDialog = this.bBt;
      String str = n.a((String[])n.a(this.mContext, b.bwW).toArray(new String[0]), param1g.ES());
      i i = new i(this);
      layoutLeftTextRightTextWithDialog.a(new String[] { str }, i);
      this.bBu.oX(n.ba(param1g.ET()));
      if (param1g.getNumber() == 0)
        this.bBu.aqU().setEnabled(false); 
      if (param1g.getNumber() < 3) {
        this.bBv.setVisibility(8);
        return;
      } 
      this.bBv.setVisibility(0);
    }
    
    public void c(g param1g) {
      String str2;
      String str1;
      boolean bool = a.AZ().Bx();
      LayoutLeftTextRightEditTextWithUnit layoutLeftTextRightEditTextWithUnit2 = this.bBq;
      if (bool) {
        str2 = "%";
      } else {
        str2 = "";
      } 
      layoutLeftTextRightEditTextWithUnit2.oY(str2);
      LayoutLeftTextRightEditTextWithUnit layoutLeftTextRightEditTextWithUnit1 = this.bBq;
      if (bool) {
        str1 = n.ba(param1g.EU());
      } else {
        str1 = this.mContext.getString(R.string.product_member_price);
      } 
      layoutLeftTextRightEditTextWithUnit1.oX(str1);
      this.bBq.aqU().setEnabled(bool);
      this.bBq.aqU().setFocusable(bool);
    }
    
    public void fK(int param1Int) { this.position = param1Int; }
    
    public void fL(int param1Int) {
      LayoutLeftTextRightEditText layoutLeftTextRightEditText = this.bBo;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1Int);
      stringBuilder.append("");
      layoutLeftTextRightEditText.oX(stringBuilder.toString());
      this.bBo.aqU().setEnabled(false);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\CreateVipGradeAndGradeDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */