package com.laiqian.member.setting.rank;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.d.a;
import com.laiqian.entity.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.f;
import com.laiqian.ui.container.h;
import com.laiqian.ui.container.n;
import com.laiqian.util.ar;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class MemberRankDetailActivity extends ActivityRoot implements a.b {
  private ArrayList<g> bDM;
  
  private a.a bFO;
  
  private int bFP;
  
  a bFQ;
  
  private boolean isDiscountConvertion;
  
  aa titleBar;
  
  private void SJ() {
    ((ViewGroup)this.bFQ.bFU.getView()).setVisibility(8);
    ((TextView)this.bFQ.bDT.dwW.getView()).setVisibility(4);
    ((TextView)this.bFQ.bDT.dwX.getView()).setVisibility(4);
  }
  
  @NonNull
  private String e(List<g> paramList, int paramInt) {
    if (this.isDiscountConvertion) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(n.aY(100.0D - ((g)paramList.get(paramInt)).EU()));
      stringBuilder1.append("%");
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(n.aY(((g)paramList.get(paramInt)).EU() / 10.0D));
    stringBuilder.append(getString(R.string.member_discount_unit));
    return stringBuilder.toString();
  }
  
  private void initData() {
    StringBuilder stringBuilder;
    int i;
    if (a.AZ().Bs()) {
      xp();
    } else {
      SJ();
    } 
    this.isDiscountConvertion = getResources().getBoolean(R.bool.is_DiscountConvertion);
    String str2 = n.ba(((g)this.bDM.get(this.bFP)).ET());
    ((EditText)this.bFQ.bFS.dwQ.getView()).setText(((g)this.bDM.get(this.bFP)).EV());
    double d = ((g)this.bDM.get(this.bFP)).EU();
    EditText editText = (EditText)this.bFQ.bFT.dwQ.getView();
    if (this.isDiscountConvertion) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(100.0D - d);
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append(d);
    } 
    stringBuilder.append("");
    String str1 = stringBuilder.toString();
    editText.setText(str1);
    ((EditText)this.bFQ.bFU.dwQ.getView()).setText(str2);
    ((TextView)this.bFQ.bDT.dwY.getView()).setText(((g)this.bDM.get(0)).EV());
    str1 = e(this.bDM, 0);
    ((TextView)this.bFQ.bDT.dxa.getView()).setText(str1);
    ((TextView)this.bFQ.bDT.dxb.getView()).setText(((g)this.bDM.get(1)).EV());
    str1 = e(this.bDM, 1);
    ((TextView)this.bFQ.bDT.dxd.getView()).setText(str1);
    ((TextView)this.bFQ.bDT.dxe.getView()).setText(((g)this.bDM.get(2)).EV());
    str1 = e(this.bDM, 2);
    ((TextView)this.bFQ.bDT.dxg.getView()).setText(str1);
    ((TextView)this.bFQ.bDT.dwW.getView()).setText(String.format(getString(R.string.member_amount), new Object[] { Double.valueOf(((g)this.bDM.get(1)).ET()) }));
    ((TextView)this.bFQ.bDT.dwX.getView()).setText(String.format(getString(R.string.member_amount), new Object[] { Double.valueOf(((g)this.bDM.get(2)).ET()) }));
    TextView textView = (TextView)this.bFQ.bDT.dwY.getView();
    Resources resources = getResources();
    if (this.bFP == 0) {
      i = R.color.setting_text_color3;
    } else {
      i = R.color.setting_text_color2;
    } 
    textView.setTextColor(resources.getColor(i));
    textView = (TextView)this.bFQ.bDT.dxb.getView();
    resources = getResources();
    if (this.bFP == 1) {
      i = R.color.setting_text_color3;
    } else {
      i = R.color.setting_text_color2;
    } 
    textView.setTextColor(resources.getColor(i));
    textView = (TextView)this.bFQ.bDT.dxe.getView();
    resources = getResources();
    if (this.bFP == 2) {
      i = R.color.setting_text_color3;
    } else {
      i = R.color.setting_text_color2;
    } 
    textView.setTextColor(resources.getColor(i));
    textView = (TextView)this.bFQ.bDT.dxa.getView();
    resources = getResources();
    if (this.bFP == 0) {
      i = R.color.setting_text_color3;
    } else {
      i = R.color.setting_text_color2;
    } 
    textView.setTextColor(resources.getColor(i));
    textView = (TextView)this.bFQ.bDT.dxd.getView();
    resources = getResources();
    if (this.bFP == 1) {
      i = R.color.setting_text_color3;
    } else {
      i = R.color.setting_text_color2;
    } 
    textView.setTextColor(resources.getColor(i));
    textView = (TextView)this.bFQ.bDT.dxg.getView();
    resources = getResources();
    if (this.bFP == 2) {
      i = R.color.setting_text_color3;
    } else {
      i = R.color.setting_text_color2;
    } 
    textView.setTextColor(resources.getColor(i));
    textView = (TextView)this.bFQ.bDT.dwW.getView();
    resources = getResources();
    if (this.bFP == 1) {
      i = R.color.setting_text_color3;
    } else {
      i = R.color.setting_text_color2;
    } 
    textView.setTextColor(resources.getColor(i));
    textView = (TextView)this.bFQ.bDT.dwX.getView();
    resources = getResources();
    if (this.bFP == 2) {
      i = R.color.setting_text_color3;
    } else {
      i = R.color.setting_text_color2;
    } 
    textView.setTextColor(resources.getColor(i));
    ImageView imageView = (ImageView)this.bFQ.bDT.dwZ.getView();
    if (this.bFP == 0) {
      i = R.drawable.member_silver;
    } else {
      i = R.drawable.member_default;
    } 
    imageView.setImageResource(i);
    imageView = (ImageView)this.bFQ.bDT.dxc.getView();
    if (this.bFP == 1) {
      i = R.drawable.member_gold;
    } else {
      i = R.drawable.member_default;
    } 
    imageView.setImageResource(i);
    imageView = (ImageView)this.bFQ.bDT.dxf.getView();
    if (this.bFP == 2) {
      i = R.drawable.member_diamond;
    } else {
      i = R.drawable.member_default;
    } 
    imageView.setImageResource(i);
  }
  
  private void setListeners() {
    ((EditText)this.bFQ.bFS.dwQ.getView()).addTextChangedListener(new b(this));
    ((EditText)this.bFQ.bFT.dwQ.getView()).addTextChangedListener(new c(this));
    ((EditText)this.bFQ.bFU.dwQ.getView()).addTextChangedListener(new d(this));
    this.titleBar.brk.setOnClickListener(new e(this));
    this.titleBar.bri.setOnClickListener(new f(this));
  }
  
  private void wR() {
    ((ViewGroup)this.bFQ.bDT.getView()).setFocusable(true);
    ((ViewGroup)this.bFQ.bDT.getView()).setFocusableInTouchMode(true);
    ((ViewGroup)this.bFQ.bDT.getView()).requestFocus();
    this.titleBar.tvTitle.setText(getString(R.string.member_rank_title));
    this.titleBar.brk.setVisibility(0);
    this.titleBar.brk.setText(getString(R.string.member_rank_save));
    this.titleBar.brj.setVisibility(8);
    ((ViewGroup)this.bFQ.bFS.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((ViewGroup)this.bFQ.bFT.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    ((ViewGroup)this.bFQ.bFU.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
    ((ViewGroup)this.bFQ.bDT.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    ((TextView)this.bFQ.bFS.cAO.getView()).setText(getString(R.string.member_rank_name));
    ((TextView)this.bFQ.bFT.cAO.getView()).setText(getString(R.string.member_rank_discount));
    ((TextView)this.bFQ.bFT.cAT.getView()).setText("%");
    ((TextView)this.bFQ.bFU.cAO.getView()).setText(getString(R.string.member_rank_amount));
    ((TextView)this.bFQ.bFU.cAT.getView()).setText(getString(R.string.member_total_amount_unit));
    ((EditText)this.bFQ.bFS.dwQ.getView()).setFilters(ar.asW());
    ((EditText)this.bFQ.bFT.dwQ.getView()).setInputType(8194);
    ((EditText)this.bFQ.bFT.dwQ.getView()).setFilters(ar.bE(3, 2));
    ((EditText)this.bFQ.bFU.dwQ.getView()).setInputType(8194);
    ((EditText)this.bFQ.bFU.dwQ.getView()).setFilters(ar.lw(99));
  }
  
  private void xp() {
    if (this.bFP == 0) {
      ((ViewGroup)this.bFQ.bFU.getView()).setVisibility(8);
    } else {
      ((ViewGroup)this.bFQ.bFU.getView()).setVisibility(0);
    } 
    ((TextView)this.bFQ.bDT.dwW.getView()).setVisibility(0);
    ((TextView)this.bFQ.bDT.dwX.getView()).setVisibility(0);
  }
  
  public void G(ArrayList<g> paramArrayList) {
    Intent intent = new Intent();
    intent.putExtra("extra_data", paramArrayList);
    setResult(-1, intent);
    finish();
  }
  
  public void H(ArrayList<g> paramArrayList) {
    r r = new r(this, new g(this));
    r.setTitle(getString(R.string.pos_quit_save_hint_dialog_title));
    r.s(getString(R.string.pos_quit_save_hint_dialog_msg));
    r.t(getString(R.string.pos_quit_save_hint_dialog_sure));
    r.oZ(getString(R.string.pos_quit_save_hint_dialog_cancel));
    r.show();
  }
  
  public boolean Rq() {
    if (TextUtils.isEmpty(((EditText)this.bFQ.bFS.dwQ.getView()).getText().toString())) {
      fU(getString(R.string.member_rank_name_not_null));
      return false;
    } 
    if (TextUtils.isEmpty(((EditText)this.bFQ.bFT.dwQ.getView()).getText().toString())) {
      fU(getString(R.string.member_discount_not_null));
      return false;
    } 
    if (TextUtils.isEmpty(((EditText)this.bFQ.bFU.dwQ.getView()).getText().toString())) {
      fU(getString(R.string.member_amount_not_null));
      return false;
    } 
    return true;
  }
  
  public void at(double paramDouble) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(n.aY(paramDouble / 10.0D));
    stringBuilder.append(getString(R.string.member_discount_unit));
    String str = stringBuilder.toString();
    switch (this.bFP) {
      default:
        return;
      case 2:
        ((TextView)this.bFQ.bDT.dxg.getView()).setText(str);
        return;
      case 1:
        ((TextView)this.bFQ.bDT.dxd.getView()).setText(str);
        return;
      case 0:
        break;
    } 
    ((TextView)this.bFQ.bDT.dxa.getView()).setText(str);
  }
  
  public void au(double paramDouble) {
    String str = n.b(null, Double.valueOf(paramDouble), true, true);
    switch (this.bFP) {
      default:
        return;
      case 2:
        ((TextView)this.bFQ.bDT.dwX.getView()).setText(String.format(getString(R.string.member_amount), new Object[] { str }));
        return;
      case 1:
        ((TextView)this.bFQ.bDT.dwW.getView()).setText(String.format(getString(R.string.member_amount), new Object[] { str }));
        break;
      case 0:
        break;
    } 
  }
  
  public void back() { finish(); }
  
  public void fU(String paramString) { Toast.makeText(this, paramString, 0).show(); }
  
  public void ge(String paramString) {
    switch (this.bFP) {
      default:
        return;
      case 2:
        ((TextView)this.bFQ.bDT.dxe.getView()).setText(paramString);
        return;
      case 1:
        ((TextView)this.bFQ.bDT.dxb.getView()).setText(paramString);
        return;
      case 0:
        break;
    } 
    ((TextView)this.bFQ.bDT.dwY.getView()).setText(paramString);
  }
  
  public void onBackPressed() { this.bFO.back(); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.bFQ = a.q(this);
    this.titleBar = aa.M(this);
    this.bFP = getIntent().getIntExtra("extra_id", -1);
    this.bDM = (ArrayList)getIntent().getSerializableExtra("extra_data");
    this.bFO = new h(this, this);
    this.bFO.c(this.bFP, this.bDM);
    wR();
    initData();
    setListeners();
  }
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.activity_member_rank;
    
    public n bDT = new n(R.id.layoutMemberRank);
    
    public h bFS = new h(R.id.layoutRankName);
    
    public f bFT = new f(R.id.layoutDiscount);
    
    public f bFU = new f(R.id.layoutAmount);
    
    public a(int param1Int) { super(param1Int); }
    
    public static a q(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(aCt, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\rank\MemberRankDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */