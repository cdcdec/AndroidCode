package com.laiqian.member.setting.discount;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.entity.g;
import com.laiqian.member.model.a;
import com.laiqian.member.setting.as;
import com.laiqian.models.at;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.l;
import com.laiqian.ui.container.m;
import com.laiqian.ui.container.n;
import com.laiqian.ui.container.w;
import com.laiqian.ui.s;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.util.ArrayList;
import java.util.List;

public class VipDiscountFragment extends Fragment implements as, aa {
  private static final String TAG = "VipDiscountFragment";
  
  a bDJ;
  
  v bDK;
  
  w bDL;
  
  ArrayList<g> bDM;
  
  private boolean bDN;
  
  at bDO;
  
  View.OnClickListener bDP = new n(this);
  
  Context context;
  
  private boolean isDiscountConvertion;
  
  aa titleBar;
  
  static  {
  
  }
  
  private void A(Boolean paramBoolean) {
    if (paramBoolean.booleanValue()) {
      ((ViewGroup)this.bDJ.bDR.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
      ((TextView)this.bDJ.bDR.cAP.getView()).setText(getString(R.string.pos_vip_dicount_title));
    } else {
      ((ViewGroup)this.bDJ.bDR.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
      ((TextView)this.bDJ.bDR.cAP.getView()).setText(getString(R.string.pos_vip_price));
    } 
    dW(paramBoolean.booleanValue());
  }
  
  private void B(Boolean paramBoolean) {
    ((CheckBox)this.bDJ.bDS.dwV.getView()).setChecked(paramBoolean.booleanValue());
    dX(paramBoolean.booleanValue());
  }
  
  private void RG() {
    String str2 = "";
    String str1 = str2;
    if (RootApplication.getLaiqianPreferenceManager().QV() != 1) {
      null = new a(this.context);
      null = null.aY(0, 10);
      null.close();
      StringBuilder stringBuilder1 = new StringBuilder();
      if (null != null) {
        while (null.moveToNext()) {
          stringBuilder1.append(null.getString(0));
          stringBuilder1.append(";");
        } 
        null.close();
      } 
      str1 = str2;
      if (stringBuilder1.length() > 1)
        str1 = stringBuilder1.deleteCharAt(stringBuilder1.lastIndexOf(";")).toString(); 
    } 
    ((TextView)this.bDJ.bDU.dwP.getView()).setSingleLine();
    ((TextView)this.bDJ.bDU.dwP.getView()).setEllipsize(TextUtils.TruncateAt.END);
    TextView textView = (TextView)this.bDJ.bDU.dwP.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(str1);
    textView.setText(stringBuilder.toString());
  }
  
  private void Se() {
    if (this.bDL == null) {
      FragmentActivity fragmentActivity = getActivity();
      String str1 = getString(R.string.pos_vip_dicount_title);
      String str2 = getString(R.string.pos_vip_price);
      u u = new u(this);
      this.bDL = new w(fragmentActivity, new String[] { str1, str2 }, u);
      this.bDL.gn(getString(R.string.pos_vip_dicount_title).equals(((TextView)this.bDJ.bDR.cAP.getView()).getText().toString()) ^ true);
    } 
    this.bDL.show();
  }
  
  private void b(int paramInt, ArrayList<g> paramArrayList) {
    Intent intent = new Intent(getActivity(), com.laiqian.member.setting.rank.MemberRankDetailActivity.class);
    intent.putExtra("extra_id", paramInt);
    intent.putExtra("extra_data", paramArrayList);
    startActivityForResult(intent, 1);
  }
  
  private void dW(boolean paramBoolean) {
    ViewGroup viewGroup = (ViewGroup)this.bDJ.bDS.getView();
    byte b2 = 8;
    if (paramBoolean) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    viewGroup.setVisibility(b1);
    viewGroup = (ViewGroup)this.bDJ.bDT.getView();
    byte b1 = b2;
    if (paramBoolean)
      b1 = 0; 
    viewGroup.setVisibility(b1);
  }
  
  private void dX(boolean paramBoolean) {
    TextView textView = (TextView)this.bDJ.bDT.dwW.getView();
    byte b2 = 4;
    if (paramBoolean) {
      b1 = 0;
    } else {
      b1 = 4;
    } 
    textView.setVisibility(b1);
    textView = (TextView)this.bDJ.bDT.dwX.getView();
    byte b1 = b2;
    if (paramBoolean)
      b1 = 0; 
    textView.setVisibility(b1);
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
    this.isDiscountConvertion = getResources().getBoolean(R.bool.is_DiscountConvertion);
    A(Boolean.valueOf(a.AZ().Bx()));
    B(Boolean.valueOf(a.AZ().Bs()));
    this.bDM = this.bDO.RJ();
    y(this.bDM);
    RG();
  }
  
  private void setListeners() {
    byte b;
    ((ViewGroup)this.bDJ.bDR.getView()).setOnClickListener(new o(this));
    ViewGroup viewGroup = (ViewGroup)this.bDJ.bDU.getView();
    if (LQKVersion.zl()) {
      b = 8;
    } else {
      b = 0;
    } 
    viewGroup.setVisibility(b);
    ((ViewGroup)this.bDJ.bDU.getView()).setOnClickListener(new p(this));
    ((CheckBox)this.bDJ.bDS.dwV.getView()).setOnCheckedChangeListener(new q(this));
    ((LinearLayout)this.bDJ.bDT.dxh.getView()).setOnClickListener(new r(this));
    ((LinearLayout)this.bDJ.bDT.dxi.getView()).setOnClickListener(new s(this));
    ((LinearLayout)this.bDJ.bDT.dxj.getView()).setOnClickListener(new t(this));
    boolean bool = this.bDN;
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      ((ViewGroup)this.bDJ.bDR.getView()).setOnClickListener(this.bDP);
      ((LinearLayout)this.bDJ.bDT.dxh.getView()).setOnClickListener(this.bDP);
      ((LinearLayout)this.bDJ.bDT.dxi.getView()).setOnClickListener(this.bDP);
      ((LinearLayout)this.bDJ.bDT.dxj.getView()).setOnClickListener(this.bDP);
    } 
  }
  
  private void setupViews() {
    ((TextView)this.bDJ.bDR.cAO.getView()).setText(getString(R.string.pos_vip_favourable));
    ((ViewGroup)this.bDJ.bDR.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((TextView)this.bDJ.bDS.cAO.getView()).setText(getString(R.string.member_auto_update));
    ((ViewGroup)this.bDJ.bDS.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
    ((ViewGroup)this.bDJ.bDT.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    ((ImageView)this.bDJ.bDT.dwZ.getView()).setImageResource(R.drawable.member_silver);
    ((ImageView)this.bDJ.bDT.dxc.getView()).setImageResource(R.drawable.member_gold);
    ((ImageView)this.bDJ.bDT.dxf.getView()).setImageResource(R.drawable.member_diamond);
    ((LinearLayout)this.bDJ.bDT.dxh.getView()).setBackgroundResource(R.drawable.member_rank_left);
    ((LinearLayout)this.bDJ.bDT.dxi.getView()).setBackgroundResource(R.drawable.member_rank_center);
    ((LinearLayout)this.bDJ.bDT.dxj.getView()).setBackgroundResource(R.drawable.member_rank_right);
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
      a.AZ().bN(false); 
    ((TextView)this.bDJ.bDU.cAO.getView()).setText(getString(R.string.recharge_discount));
    ((ViewGroup)this.bDJ.bDU.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
  }
  
  public boolean Az() { return false; }
  
  public void Em() {}
  
  public void RA() {
    if (this.titleBar != null) {
      this.titleBar.brk.setVisibility(0);
      this.titleBar.aNv.setVisibility(8);
    } 
  }
  
  public void Rz() {
    if (this.titleBar != null) {
      this.titleBar.brk.setVisibility(8);
      this.titleBar.aNv.setVisibility(0);
    } 
  }
  
  public void a(aa paramaa) {
    this.titleBar = paramaa;
    this.bDK.dT(true);
  }
  
  public void hideProgress() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 != -1)
      return; 
    if (paramInt1 == 1) {
      this.bDM = (ArrayList)paramIntent.getSerializableExtra("extra_data");
      y(this.bDM);
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.bDJ = a.d(this);
    this.bDK = new v(getActivity(), this);
    this.context = getActivity();
    this.bDO = new at(getActivity());
    if (RootApplication.getLaiqianPreferenceManager().QV() == 0 && !a.zR().Ab() && !a.zR().Ad())
      this.bDN = true; 
    setupViews();
    try {
      initData();
    } catch (Exception paramLayoutInflater) {
      a.e(paramLayoutInflater);
    } 
    setListeners();
    return this.bDJ.getView();
  }
  
  public void onResume() {
    super.onResume();
    RG();
  }
  
  public void save() { this.bDK.dT(true); }
  
  public void showError(String paramString) { n.o(paramString); }
  
  public void y(List<g> paramList) {
    if (paramList != null && paramList.size() >= 3) {
      ((TextView)this.bDJ.bDT.dwY.getView()).setText(((g)paramList.get(0)).EV());
      String str = e(paramList, 0);
      ((TextView)this.bDJ.bDT.dxa.getView()).setText(str);
      ((TextView)this.bDJ.bDT.dxb.getView()).setText(((g)paramList.get(1)).EV());
      str = e(paramList, 1);
      ((TextView)this.bDJ.bDT.dxd.getView()).setText(str);
      ((TextView)this.bDJ.bDT.dxe.getView()).setText(((g)paramList.get(2)).EV());
      str = e(paramList, 2);
      ((TextView)this.bDJ.bDT.dxg.getView()).setText(str);
      ((TextView)this.bDJ.bDT.dwW.getView()).setText(String.format(getString(R.string.member_amount), new Object[] { Double.valueOf(((g)paramList.get(1)).ET()) }));
      ((TextView)this.bDJ.bDT.dwX.getView()).setText(String.format(getString(R.string.member_amount), new Object[] { Double.valueOf(((g)paramList.get(2)).ET()) }));
    } 
  }
  
  public boolean zP() { return isAdded(); }
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.fragment_vip_discount_setting;
    
    public w bDR = new w(R.id.layoutDiscountType);
    
    public l bDS = new l(R.id.layoutAutoUpdate);
    
    public n bDT = new n(R.id.layoutMemberRank);
    
    public m bDU = new m(R.id.layout_recharge_privilege);
    
    public ViewGroup bDV;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.bDV = (ViewGroup)s.z(param1View, R.id.llContent);
    }
    
    public static a d(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(aCt, null);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\VipDiscountFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */