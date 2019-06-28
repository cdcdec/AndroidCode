package com.laiqian.promotion.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ay;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.DateSelectEntity;
import com.laiqian.entity.ac;
import com.laiqian.entity.ae;
import com.laiqian.entity.ag;
import com.laiqian.entity.ak;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.promotion.R;
import com.laiqian.promotion.a.a;
import com.laiqian.promotion.d.a;
import com.laiqian.promotion.f.a;
import com.laiqian.promotion.g.b;
import com.laiqian.promotion.g.d;
import com.laiqian.promotion.ui.datePicker.e;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.AbstractActivity;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.util.ae;
import com.laiqian.util.ar;
import com.laiqian.util.bt;
import com.laiqian.util.n;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.List;

public class PromotionCreateActivity extends AbstractActivity implements View.OnClickListener, b, e.a {
  private String aRQ;
  
  private int aUv;
  
  private List<ac> ari = new ArrayList();
  
  d cWe;
  
  private a cWf;
  
  private ArrayList<ProductTypeEntity> cWg;
  
  private long[] cWh;
  
  private long[] cWi;
  
  private boolean cWj;
  
  private a cWk;
  
  public int cWl;
  
  private PopupWindow cWm;
  
  private boolean cWn;
  
  View.OnClickListener cWo = new p(this);
  
  TextWatcher cWp = new t(this);
  
  TextWatcher cWq = new u(this);
  
  TextWatcher cWr = new v(this);
  
  TextWatcher cWs = new w(this);
  
  TextWatcher cWt = new f(this);
  
  TextWatcher cWu = new g(this);
  
  TextWatcher cWv = new h(this);
  
  TextWatcher cWw = new i(this);
  
  TextWatcher cWx = new j(this);
  
  TextWatcher cWy = new k(this);
  
  TextWatcher cWz = new l(this);
  
  private boolean isDiscountConvertion;
  
  private Context mContext;
  
  aa titleBar;
  
  private void a(ak paramak) {
    a(this.cWe.cXx.cAO, getString(R.string.pos_promotion_name), true);
    a(this.cWe.cXy.cAO, getString(R.string.pos_promotion_create_date), true);
    a(this.cWe.cXz.cAO, getString(R.string.pos_promotion_create_fit_people));
    a(this.cWe.cXA.cAO, getString(R.string.pos_promotion_create_fit_product), true);
    a(this.cWe.cXB.cAO, getString(R.string.pos_promotion_create_fit_type));
    a(this.cWe.cXM.cAO, getString(R.string.pos_promotion_create_add_amount));
    ((AppCompatRadioButton)this.cWe.cXN.dwR.getView()).setText(R.string.pos_promotion_create_discount);
    ((AppCompatRadioButton)this.cWe.cXN.dwS.getView()).setText(R.string.pos_promotion_create_discount_price);
    a(this.cWe.cXs, getString(R.string.pos_promotion_discount_rate), true);
    a(this.cWe.cXF.cAO, getString(R.string.pos_promotion_create_reduce_amount), paramak.Ib());
    a(this.cWe.cXG.cAO, getString(R.string.pos_promotion_create_recharge_amount), paramak.If());
    a(this.cWe.cXH.cAO, getString(R.string.pos_promotion_create_gift_amount));
    a(this.cWe.cXI.cAO, getString(R.string.pos_promotion_create_gift_product), paramak.Ic());
    a(this.cWe.cXJ.cAO, getString(R.string.pos_promotion_create_buy_product_num), paramak.Ie());
    a(this.cWe.cXK.cAO, getString(R.string.pos_promotion_create_every_gift_num), paramak.Ic());
    a(this.cWe.cXL.cAO, getString(R.string.pos_promotion_create_gift_total_num), paramak.Id());
    a(this.cWe.cXD.cAO, getString(R.string.pos_promotion_create_min_buy_amount), paramak.Ia());
    a(this.cWe.cXE.cAO, getString(R.string.pos_promotion_create_min_buy_num));
    alV();
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, View paramView) {
    r r = new r(this, new m(this, paramBoolean1, paramInt, paramBoolean2, paramView));
    r.setOnDismissListener(new o(this));
    r.setTitle(getString(R.string.pos_quit_save_hint_dialog_title));
    r.s(getString(R.string.pos_quit_save_hint_dialog_msg));
    r.t(getString(R.string.pos_quit_save_hint_dialog_sure));
    r.oZ(getString(R.string.pos_quit_save_hint_dialog_cancel));
    r.show();
  }
  
  private void alN() {
    this.cWk = new a(this.ari);
    this.cWk.be(false);
    ((RecyclerView)this.cWe.cXv.getView()).c(new LinearLayoutManager(this));
    ((RecyclerView)this.cWe.cXv.getView()).a(this.cWk);
    ((RecyclerView)this.cWe.cXv.getView()).a(new ay(this.mContext, true));
    ((RecyclerView)this.cWe.cXv.getView()).a(new e(this));
  }
  
  private boolean alO() { return (this.cWk.alm().getState() == 0) ? false : (this.cWf.Az() ^ true); }
  
  private void alP() { this.cWf.alv(); }
  
  private void alQ() {
    if (!this.cWf.als())
      finish(); 
  }
  
  private void alR() {
    ((EditText)this.cWe.cXt.getView()).setFilters(ar.bE(6, 2));
    ((EditText)this.cWe.cXE.dwQ.getView()).setFilters(ar.bE(6, 3));
    ((EditText)this.cWe.cXH.dwQ.getView()).setFilters(ar.lw(9999));
    ((EditText)this.cWe.cXF.dwQ.getView()).setFilters(ar.lw(9999));
    ((EditText)this.cWe.cXD.dwQ.getView()).setFilters(ar.lw(9999));
    ((EditText)this.cWe.cXK.dwQ.getView()).setFilters(ar.bE(6, 3));
    ((EditText)this.cWe.cXL.dwQ.getView()).setFilters(ar.bE(6, 3));
    ((EditText)this.cWe.cXJ.dwQ.getView()).setFilters(ar.bE(6, 3));
    ((EditText)this.cWe.cXM.dwQ.getView()).setFilters(ar.lw(9999));
    ((EditText)this.cWe.cXG.dwQ.getView()).setFilters(ar.lw(9999));
  }
  
  private void alS() {
    this.cWe.cXw.setOnClickListener(this);
    ((RelativeLayout)this.cWe.cXy.getView()).setOnClickListener(this);
    ((ViewGroup)this.cWe.cXB.getView()).setOnClickListener(this);
    ((ViewGroup)this.cWe.cXz.getView()).setOnClickListener(this);
    ((ViewGroup)this.cWe.cXI.getView()).setOnClickListener(this);
    ((ViewGroup)this.cWe.cXA.getView()).setOnClickListener(this);
  }
  
  private void alT() {
    ((EditText)this.cWe.cXx.dwQ.getView()).addTextChangedListener(this.cWu);
    ((EditText)this.cWe.cXD.dwQ.getView()).addTextChangedListener(this.cWs);
    ((EditText)this.cWe.cXE.dwQ.getView()).addTextChangedListener(this.cWp);
    ((EditText)this.cWe.cXF.dwQ.getView()).addTextChangedListener(this.cWr);
    ((EditText)this.cWe.cXt.getView()).addTextChangedListener(this.cWq);
    ((EditText)this.cWe.cXM.dwQ.getView()).addTextChangedListener(this.cWt);
    ((EditText)this.cWe.cXK.dwQ.getView()).addTextChangedListener(this.cWv);
    ((EditText)this.cWe.cXL.dwQ.getView()).addTextChangedListener(this.cWx);
    ((EditText)this.cWe.cXJ.dwQ.getView()).addTextChangedListener(this.cWw);
    ((EditText)this.cWe.cXH.dwQ.getView()).addTextChangedListener(this.cWy);
    ((EditText)this.cWe.cXG.dwQ.getView()).addTextChangedListener(this.cWz);
    this.cWe.cXN.a(new s(this));
  }
  
  private void alU() {
    ((EditText)this.cWe.cXx.dwQ.getView()).removeTextChangedListener(this.cWu);
    ((EditText)this.cWe.cXD.dwQ.getView()).removeTextChangedListener(this.cWs);
    ((EditText)this.cWe.cXF.dwQ.getView()).removeTextChangedListener(this.cWr);
    ((EditText)this.cWe.cXt.getView()).removeTextChangedListener(this.cWq);
    ((EditText)this.cWe.cXE.dwQ.getView()).removeTextChangedListener(this.cWp);
    ((EditText)this.cWe.cXM.dwQ.getView()).removeTextChangedListener(this.cWt);
    ((EditText)this.cWe.cXK.dwQ.getView()).removeTextChangedListener(this.cWv);
    ((EditText)this.cWe.cXL.dwQ.getView()).removeTextChangedListener(this.cWx);
    ((EditText)this.cWe.cXJ.dwQ.getView()).removeTextChangedListener(this.cWw);
    ((EditText)this.cWe.cXH.dwQ.getView()).removeTextChangedListener(this.cWy);
    ((EditText)this.cWe.cXG.dwQ.getView()).removeTextChangedListener(this.cWz);
  }
  
  private void alV() {
    int i;
    ((EditText)this.cWe.cXx.dwQ.getView()).setHint(R.string.pos_promotion_create_please_input_name);
    ((TextView)this.cWe.cXy.dwP.getView()).setText(R.string.pos_people_type_not_limit);
    ((TextView)this.cWe.cXz.cAP.getView()).setText(R.string.pos_people_type_not_limit);
    ((TextView)this.cWe.cXA.cAP.getView()).setHint(R.string.pos_promotion_create_select_please);
    ((TextView)this.cWe.cXB.cAP.getView()).setText(R.string.pos_people_type_not_limit);
    ((EditText)this.cWe.cXM.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    ((EditText)this.cWe.cXF.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    ((EditText)this.cWe.cXG.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    ((EditText)this.cWe.cXH.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    ((TextView)this.cWe.cXI.cAP.getView()).setHint(R.string.pos_promotion_create_select_please);
    ((EditText)this.cWe.cXJ.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    ((EditText)this.cWe.cXL.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    ((EditText)this.cWe.cXK.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    ((EditText)this.cWe.cXD.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    ((EditText)this.cWe.cXE.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    EditText editText = (EditText)this.cWe.cXt.getView();
    if (this.isDiscountConvertion) {
      i = R.string.pos_promotion_create_input_zero;
    } else {
      i = R.string.pos_promotion_create_input_100;
    } 
    editText.setText(i);
  }
  
  private void alZ() {
    long[] arrayOfLong;
    if (LQKVersion.zl()) {
      arrayOfLong = "retailProductList";
    } else {
      String str;
      arrayOfLong = "productList";
    } 
    Intent intent = new Intent(this, LQKVersion.bF(arrayOfLong));
    if (this.cWl == 0) {
      long[] arrayOfLong1 = this.cWh;
    } else {
      arrayOfLong = this.cWi;
    } 
    intent.putExtra("productIDs", arrayOfLong);
    intent.putExtra("selectProduct", true);
    intent.putExtra("hasMealSet", true);
    intent.putExtra("singleProduct", false);
    intent.putExtra("isHaveBatch", false);
    startActivityForResult(intent, 2);
  }
  
  private void d(View paramView, int paramInt, boolean paramBoolean) {
    ac ac = (ac)this.cWk.tS().get(paramInt);
    int i = ac.getState();
    if (paramBoolean)
      paramView = this.cWk.h((RecyclerView)this.cWe.cXv.getView(), paramInt, R.id.tv_promotion_state); 
    if (i != 0)
      y(paramView, i); 
    if (this.cWk.all() != paramInt || paramBoolean) {
      this.cWk.jz(paramInt);
      this.cWf.b(ac);
      c(ac);
    } 
  }
  
  private void gv(boolean paramBoolean) { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  private void initData() {
    if (this.cWj) {
      this.cWh = new long[0];
      this.cWi = new long[0];
    } 
  }
  
  @DebugLog
  private void initView() {
    this.titleBar.tvTitle.setText(this.aRQ);
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setOnClickListener(new q(this));
    this.titleBar.cFF.setVisibility(0);
    this.titleBar.cFF.setOnClickListener(new r(this));
    ((ViewGroup)this.cWe.cXx.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((RelativeLayout)this.cWe.cXy.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    ((ViewGroup)this.cWe.cXz.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down);
    ((ViewGroup)this.cWe.cXA.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    ((ViewGroup)this.cWe.cXB.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    this.cWe.cXC.setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    ((ViewGroup)this.cWe.cXF.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    ((ViewGroup)this.cWe.cXD.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((ViewGroup)this.cWe.cXE.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down);
    ((ViewGroup)this.cWe.cXH.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    ((ViewGroup)this.cWe.cXI.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    ((ViewGroup)this.cWe.cXK.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    ((ViewGroup)this.cWe.cXL.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down);
    ((ViewGroup)this.cWe.cXJ.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down);
    ((ViewGroup)this.cWe.cXM.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((ViewGroup)this.cWe.cXG.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((EditText)this.cWe.cXt.getView()).setInputType(8194);
    ((EditText)this.cWe.cXE.dwQ.getView()).setInputType(8194);
    ((EditText)this.cWe.cXH.dwQ.getView()).setInputType(8194);
    ((EditText)this.cWe.cXF.dwQ.getView()).setInputType(8194);
    ((EditText)this.cWe.cXD.dwQ.getView()).setInputType(8194);
    ((EditText)this.cWe.cXK.dwQ.getView()).setInputType(8194);
    ((EditText)this.cWe.cXL.dwQ.getView()).setInputType(8194);
    ((EditText)this.cWe.cXJ.dwQ.getView()).setInputType(8194);
    ((EditText)this.cWe.cXM.dwQ.getView()).setInputType(8194);
    ((EditText)this.cWe.cXG.dwQ.getView()).setInputType(8194);
    alR();
  }
  
  private void r(Intent paramIntent) {
    String str;
    long[] arrayOfLong = paramIntent.getLongArrayExtra("IDs");
    int i = arrayOfLong.length;
    getString(R.string.pos_promotion_product_select_all);
    if (i == 0 && this.aUv != 6) {
      nd(getString(R.string.pos_must_select_one_product));
      return;
    } 
    if (i > 20) {
      nd(getString(R.string.pos_must_not_select_twenty_product));
      return;
    } 
    byte b1 = 1;
    if (i > 0) {
      str = String.format(getString(R.string.pos_promotion_selected_n_product), new Object[] { Integer.valueOf(i) });
    } else {
      str = "";
    } 
    if (this.cWl == 0) {
      ((TextView)this.cWe.cXA.cAP.getView()).setText(str);
      this.cWh = arrayOfLong;
      this.cWf.a(this.cWh, str);
      return;
    } 
    if (this.aUv == 5) {
      ((TextView)this.cWe.cXA.cAP.getView()).setText(str);
      b1 = 2;
    } else if (this.aUv == 6) {
      b1 = 3;
    } 
    ((TextView)this.cWe.cXI.cAP.getView()).setText(str);
    this.cWi = arrayOfLong;
    this.cWf.a(this.cWi, str, b1);
  }
  
  private void save() { this.cWf.save(); }
  
  private void y(View paramView, int paramInt) {
    View view = LayoutInflater.from(this).inflate(R.layout.promotion_status_change, null);
    Button button1 = (Button)view.findViewById(R.id.btn_delete);
    Button button2 = (Button)view.findViewById(R.id.btn_pause);
    if (1 == paramInt) {
      button2.setVisibility(0);
      button2.setText(R.string.pos_promotion_status_text_pause);
    } else if (2 == paramInt) {
      button2.setVisibility(0);
      button2.setText(R.string.pos_promotion_status_text_restart);
    } else if (3 == paramInt) {
      button2.setVisibility(8);
    } 
    view.measure(0, 0);
    this.cWm = new PopupWindow(view, view.getMeasuredWidth(), view.getMeasuredHeight(), true);
    this.cWm.setBackgroundDrawable(new ColorDrawable());
    button1.setTag(Integer.valueOf(paramInt));
    button2.setTag(Integer.valueOf(paramInt));
    button1.setOnClickListener(this.cWo);
    button2.setOnClickListener(this.cWo);
    this.cWm.showAsDropDown(paramView, ae.b(this.mContext, -20.0F), ae.b(this.mContext, -25.0F));
  }
  
  public void RA() {
    this.titleBar.brk.setVisibility(0);
    this.titleBar.aNv.setVisibility(8);
  }
  
  public void Rz() {
    this.titleBar.brk.setVisibility(8);
    this.titleBar.aNv.setVisibility(0);
  }
  
  public void a(int paramInt, ac paramac) { this.cWk.d(paramInt, paramac); }
  
  public void a(ab<?> paramab, String paramString, boolean paramBoolean) {
    Spanned spanned;
    if (paramBoolean) {
      bt.a a1;
      bt.a a2 = (a1 = bt.a.mj(ContextCompat.getColor(this, R.color.setting_text_color1))).mj(ContextCompat.getColor(this, R.color.red_color_1033));
      spanned = bt.a("%s<br>%s", new String[] { paramString, " *" }, new bt.a[] { a1, a2 });
      a(paramab.getView(), spanned, 0.0F);
      return;
    } 
    a(paramab.getView(), spanned, 0.0F);
  }
  
  public void alW() { this.cWk.jz(0); }
  
  public void alX() { this.cWn = false; }
  
  public void alY() { this.cWk.aln(); }
  
  public void b(ak paramak) {
    ViewGroup viewGroup4 = (ViewGroup)this.cWe.cXx.getView();
    boolean bool = paramak.HK();
    byte b2 = 8;
    if (bool) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup4.setVisibility(b1);
    RelativeLayout relativeLayout = (RelativeLayout)this.cWe.cXy.getView();
    if (paramak.HL()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    relativeLayout.setVisibility(b1);
    ViewGroup viewGroup3 = (ViewGroup)this.cWe.cXz.getView();
    if (paramak.HM()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup3.setVisibility(b1);
    viewGroup3 = (ViewGroup)this.cWe.cXA.getView();
    if (paramak.HN()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup3.setVisibility(b1);
    viewGroup3 = (ViewGroup)this.cWe.cXB.getView();
    if (paramak.HO()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup3.setVisibility(b1);
    viewGroup3 = (ViewGroup)this.cWe.cXM.getView();
    if (paramak.HR()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup3.setVisibility(b1);
    viewGroup3 = (ViewGroup)this.cWe.cXF.getView();
    if (paramak.HW()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup3.setVisibility(b1);
    viewGroup3 = (ViewGroup)this.cWe.cXG.getView();
    if (paramak.HS()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup3.setVisibility(b1);
    viewGroup3 = (ViewGroup)this.cWe.cXH.getView();
    if (paramak.Ig()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup3.setVisibility(b1);
    viewGroup3 = (ViewGroup)this.cWe.cXI.getView();
    if (paramak.HT()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup3.setVisibility(b1);
    viewGroup3 = (ViewGroup)this.cWe.cXJ.getView();
    if (paramak.HQ()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup3.setVisibility(b1);
    View view = this.cWe.cXC;
    if (paramak.HP() || paramak.HZ()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    view.setVisibility(b1);
    ViewGroup viewGroup2 = (ViewGroup)this.cWe.cXN.getView();
    if (paramak.HZ()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup2.setVisibility(b1);
    TextView textView = (TextView)this.cWe.cXs.getView();
    if (paramak.HP()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    textView.setVisibility(b1);
    ViewGroup viewGroup1 = (ViewGroup)this.cWe.cXK.getView();
    if (paramak.HU()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup1.setVisibility(b1);
    viewGroup1 = (ViewGroup)this.cWe.cXL.getView();
    if (paramak.HV()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup1.setVisibility(b1);
    viewGroup1 = (ViewGroup)this.cWe.cXD.getView();
    if (paramak.HX()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup1.setVisibility(b1);
    viewGroup1 = (ViewGroup)this.cWe.cXE.getView();
    byte b1 = b2;
    if (paramak.HY())
      b1 = 0; 
    viewGroup1.setVisibility(b1);
    a(paramak);
  }
  
  public void c(DateSelectEntity paramDateSelectEntity) {
    this.cWf.a(paramDateSelectEntity);
    String str = a.a(paramDateSelectEntity, this.mContext);
    ((TextView)this.cWe.cXy.dwP.getView()).setText(str);
  }
  
  public void c(ac paramac) {
    long[] arrayOfLong;
    alU();
    this.cWg = paramac.He();
    ag ag = paramac.Hn();
    ae ae = paramac.Hj();
    if (ag != null) {
      arrayOfLong = ag.Hy();
    } else {
      arrayOfLong = new long[0];
    } 
    this.cWh = arrayOfLong;
    if (ae != null) {
      arrayOfLong = ae.Hr();
    } else {
      arrayOfLong = new long[0];
    } 
    this.cWi = arrayOfLong;
    this.cWf.dd(paramac.Hd().AR());
    ((EditText)this.cWe.cXx.dwQ.getView()).setText(paramac.getName());
    ((TextView)this.cWe.cXy.dwP.getView()).setText(a.a(paramac.Hc(), this.mContext));
    ((TextView)this.cWe.cXz.cAP.getView()).setText(paramac.Hd().AT());
    TextView textView = (TextView)this.cWe.cXA.cAP.getView();
    if (ag != null) {
      String str = ag.HC();
    } else {
      arrayOfLong = null;
    } 
    textView.setText(arrayOfLong);
    ((TextView)this.cWe.cXB.cAP.getView()).setText(paramac.Hf());
    ((EditText)this.cWe.cXM.dwQ.getView()).setText(n.a(Double.valueOf(paramac.Hg()), true, false));
    ((EditText)this.cWe.cXF.dwQ.getView()).setText(n.a(Double.valueOf(paramac.Hi()), true, false));
    ((EditText)this.cWe.cXG.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    ((EditText)this.cWe.cXJ.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    ((EditText)this.cWe.cXK.dwQ.getView()).setText(R.string.pos_promotion_create_input_zero);
    ((TextView)this.cWe.cXI.cAP.getView()).setText("");
    if (ae != null) {
      ((TextView)this.cWe.cXI.cAP.getView()).setText(ae.Hu());
      if (this.aUv == 5)
        ((TextView)this.cWe.cXA.cAP.getView()).setText(ae.Hu()); 
      ((EditText)this.cWe.cXK.dwQ.getView()).setText(n.a(Double.valueOf(ae.Ht()), true, false, 3));
      ((EditText)this.cWe.cXJ.dwQ.getView()).setText(n.a(Double.valueOf(ae.Hs()), true, false, 3));
    } 
    ((EditText)this.cWe.cXL.dwQ.getView()).setText(n.a(Double.valueOf(paramac.Ho()), true, false, 3));
    ((EditText)this.cWe.cXD.dwQ.getView()).setText(n.a(Double.valueOf(paramac.Hk()), true, false));
    if (this.aUv == 3) {
      if (ag != null)
        if (ag.HB() == 0) {
          ((TextView)this.cWe.cXu.getView()).setVisibility(0);
          ((AppCompatRadioButton)this.cWe.cXN.dwR.getView()).setChecked(true);
          ((AppCompatRadioButton)this.cWe.cXN.dwS.getView()).setChecked(false);
          ((EditText)this.cWe.cXt.getView()).setText(n.a(Double.valueOf(ag.Hz()), true, false, 2));
        } else if (ag.HB() == 1) {
          ((TextView)this.cWe.cXu.getView()).setVisibility(4);
          ((AppCompatRadioButton)this.cWe.cXN.dwR.getView()).setChecked(false);
          ((AppCompatRadioButton)this.cWe.cXN.dwS.getView()).setChecked(true);
          ((EditText)this.cWe.cXt.getView()).setText(n.a(Double.valueOf(ag.HA()), true, false, 2));
        }  
    } else {
      ((TextView)this.cWe.cXu.getView()).setVisibility(0);
      ((EditText)this.cWe.cXt.getView()).setText(n.a(Double.valueOf(paramac.FI()), true, false, 2));
    } 
    ((EditText)this.cWe.cXE.dwQ.getView()).setText(n.a(Double.valueOf(paramac.Hl()), true, false, 3));
    ((EditText)this.cWe.cXG.dwQ.getView()).setText(n.a(Double.valueOf(paramac.Hh()), true, false));
    ((EditText)this.cWe.cXH.dwQ.getView()).setText(n.a(Double.valueOf(paramac.Hp()), true, false));
    alT();
  }
  
  public void f(ArrayList<ac> paramArrayList, int paramInt) {
    this.cWk.jA(paramInt);
    this.cWk.d(paramArrayList);
  }
  
  public void gw(boolean paramBoolean) {
    byte b1;
    this.cWf.gu(paramBoolean ^ true);
    TextView textView = this.cWe.cXw;
    byte b2 = 8;
    if (paramBoolean) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    textView.setVisibility(b1);
    View view = this.cWe.cXr;
    if (paramBoolean) {
      b1 = b2;
    } else {
      b1 = 0;
    } 
    view.setVisibility(b1);
  }
  
  public void gx(boolean paramBoolean) {
    ImageView imageView = this.titleBar.cFF;
    byte b2 = 8;
    if (paramBoolean) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    imageView.setVisibility(b1);
    Button button = this.titleBar.brk;
    byte b1 = b2;
    if (paramBoolean)
      b1 = 0; 
    button.setVisibility(b1);
    this.titleBar.brk.setText(getString(R.string.save));
  }
  
  public void jB(int paramInt) { this.cWk.bK(paramInt); }
  
  public void jC(int paramInt) {
    this.cWk.remove(paramInt);
    paramInt = this.cWk.all();
    if (paramInt > 0) {
      a a1 = this.cWk;
      a1.jz(--paramInt);
      ac ac = (ac)this.cWk.getItem(paramInt);
      c(ac);
      this.cWf.b(ac);
      return;
    } 
    if (this.cWk.tS().size() != 0) {
      this.cWk.jz(0);
      ac ac = (ac)this.cWk.getItem(0);
      c(ac);
      this.cWf.b(ac);
      return;
    } 
    gw(true);
    gx(false);
  }
  
  public void nd(@Nullable String paramString) {
    if (!TextUtils.isEmpty(paramString))
      n.o(paramString); 
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1) {
        default:
          return;
        case 2:
          r(paramIntent);
          return;
        case 1:
          break;
      } 
      String str = paramIntent.getStringExtra("typeName");
      if (paramIntent.getBooleanExtra("selectAll", false)) {
        this.cWg = new ArrayList();
      } else {
        this.cWg = paramIntent.getParcelableArrayListExtra("selectData");
      } 
      ((TextView)this.cWe.cXB.cAP.getView()).setText(str);
      this.cWf.i(this.cWg, str);
    } 
  }
  
  public void onBackPressed() {
    if (this.cWf.Az()) {
      a(true, 0, true, null);
      return;
    } 
    super.onBackPressed();
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    int j = R.id.tv_noData;
    boolean bool = false;
    if (i == j) {
      this.cWn = true;
      this.cWf.na(this.aRQ);
      gw(false);
      gx(true);
      return;
    } 
    if (i == R.id.layoutDate) {
      e e = new e(this);
      e.a(this);
      e.show();
      return;
    } 
    if (i == R.id.layoutFitType) {
      Intent intent = new Intent(this, ProductTypePromotionActivity.class);
      intent.putParcelableArrayListExtra("selectData", this.cWg);
      startActivityForResult(intent, 1);
      return;
    } 
    if (i == R.id.layoutFitPeople) {
      if (RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
        n.eP(R.string.pos_multipshop_not_allow_chang_fit_people);
        return;
      } 
      this.cWf.alt();
      return;
    } 
    if (i == R.id.layoutFitProduct) {
      if (this.aUv == 5)
        bool = true; 
      this.cWl = bool;
      alZ();
      return;
    } 
    if (i == R.id.layoutGiftProduct) {
      this.cWl = 1;
      alZ();
    } 
  }
  
  @DebugLog
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cWe = d.I(this);
    this.titleBar = aa.M(this);
    this.mContext = this;
    long l = getIntent().getLongExtra("promotionID", -1L);
    this.aUv = getIntent().getIntExtra("typeId", 1);
    this.aRQ = getIntent().getStringExtra("typeName");
    this.cWj = getIntent().getBooleanExtra("isCreate", true);
    this.cWf = new a(this, this, this.aUv);
    this.cWf.de(l);
    initData();
    initView();
    alN();
    alQ();
    alS();
    alP();
    this.isDiscountConvertion = getResources().getBoolean(R.bool.is_DiscountConvertion);
  }
  
  public void p(CharSequence paramCharSequence) { ((TextView)this.cWe.cXz.cAP.getView()).setText(paramCharSequence); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\PromotionCreateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */