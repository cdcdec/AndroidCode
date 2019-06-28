package com.laiqian.member.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.g;
import com.laiqian.ui.container.LayoutLeftTextRightCheckbox;
import com.laiqian.ui.container.LayoutLeftTextRightEditText;
import com.laiqian.ui.container.LayoutLeftTextRightEditTextWithUnit;
import com.laiqian.ui.container.LayoutLeftTextRightTextWithDialog;
import com.laiqian.ui.container.aa;
import com.laiqian.util.n;
import com.laiqian.vip.R;

public class VipBasicInfoFragment extends Fragment implements v {
  private a bBJ;
  
  u bBK;
  
  private n bBL;
  
  private n bBM;
  
  public static VipBasicInfoFragment Ry() {
    VipBasicInfoFragment vipBasicInfoFragment = new VipBasicInfoFragment();
    vipBasicInfoFragment.setArguments(new Bundle());
    return vipBasicInfoFragment;
  }
  
  public boolean Az() { return (this.bBL != null && this.bBM != null) ? (this.bBL.equals(this.bBM) ^ true) : 0; }
  
  public void Em() {}
  
  public void RA() {}
  
  public void Rz() {}
  
  public void a(aa paramaa) {
    if (getActivity() != null)
      n.R(getActivity()); 
    this.bBJ.bBO.aqU().clearFocus();
    this.bBJ.bBP.aqU().clearFocus();
    if (!Az())
      return; 
    if (a.AZ().Bx()) {
      double d = this.bBM.Ru();
      if (Double.compare(d, 0.0D) <= 0 || Double.compare(d, 100.0D) > 0) {
        n.eP(R.string.member_discount_range);
        return;
      } 
    } 
    this.bBK.dT(false);
  }
  
  public void dQ(boolean paramBoolean) {
    if (paramBoolean)
      try {
        this.bBL = this.bBM.Rx();
        return;
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        a.e(cloneNotSupportedException);
      }  
  }
  
  public void hideProgress() {}
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (a.AZ().BA() < 0.0D) {
      g g = bc.RH().fN(0);
      if (g != null) {
        double d = g.EU();
        a.AZ().f(d);
      } else {
        a.AZ().f(100.0D);
      } 
    } 
    n1 = new n(a.AZ().P(getActivity()), a.AZ().Bx(), a.AZ().BA(), a.AZ().Bu(), a.AZ().Bw());
    try {
      this.bBL = n1.Rx();
      this.bBM = n1.Rx();
    } catch (CloneNotSupportedException n1) {
      a.e(n1);
    } 
    this.bBK = new u(getActivity(), this, this.bBM);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) { return paramLayoutInflater.inflate(R.layout.fragment_vip_basic_info, paramViewGroup, false); }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.bBJ = new a(this, getView());
  }
  
  public void save() { a(null); }
  
  public void showError(String paramString) {
    if (getActivity() != null && !isDetached())
      Toast.makeText(getActivity(), paramString, 0).show(); 
  }
  
  public boolean zP() { return false; }
  
  class a {
    View bBN;
    
    LayoutLeftTextRightEditText bBO;
    
    LayoutLeftTextRightEditTextWithUnit bBP;
    
    LayoutLeftTextRightTextWithDialog bBQ;
    
    LayoutLeftTextRightCheckbox bBR;
    
    LayoutLeftTextRightCheckbox bBS;
    
    public a(VipBasicInfoFragment this$0, View param1View) {
      this.bBN = param1View;
      initView();
      initData();
      Ek();
    }
    
    private void Ek() {
      this.bBO.aqU().addTextChangedListener(new q(this));
      this.bBP.aqU().addTextChangedListener(new r(this));
      this.bBR.setOnCheckedChangeListener(new s(this));
      this.bBS.setOnCheckedChangeListener(new t(this));
    }
    
    private void dR(boolean param1Boolean) { this.bBS.setChecked(param1Boolean); }
    
    private void initData() {
      int i;
      z(Boolean.valueOf(a.AZ().Bu()));
      dR(a.AZ().Bw());
      boolean bool = a.AZ().Bx();
      LayoutLeftTextRightTextWithDialog layoutLeftTextRightTextWithDialog = this.bBQ;
      if (bool) {
        i = R.string.pos_vip_dicount_title;
      } else {
        i = R.string.pos_vip_price;
      } 
      layoutLeftTextRightTextWithDialog.kI(i);
      LayoutLeftTextRightEditTextWithUnit layoutLeftTextRightEditTextWithUnit = this.bBP;
      if (bool) {
        i = 0;
      } else {
        i = 8;
      } 
      layoutLeftTextRightEditTextWithUnit.setVisibility(i);
      this.bBP.oX(n.ba(a.AZ().BA()));
      this.bBO.aqU().setFilters(new InputFilter[] { new InputFilter.LengthFilter(10) });
      this.bBO.oX(a.AZ().P(this.bBT.getActivity()));
      if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
        this.bBP.setVisibility(8);
        ((ViewGroup.MarginLayoutParams)this.bBS.getLayoutParams()).topMargin = 0;
        this.bBS.setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
        this.bBS.requestLayout();
        this.bBR.setVisibility(8);
        this.bBQ.setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
      } 
    }
    
    private void initView() {
      this.bBO = (LayoutLeftTextRightEditText)this.bBN.findViewById(R.id.layout_vip_card_name);
      this.bBO.setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
      this.bBQ = (LayoutLeftTextRightTextWithDialog)this.bBN.findViewById(R.id.layoutDiscountType);
      LayoutLeftTextRightTextWithDialog layoutLeftTextRightTextWithDialog = this.bBQ;
      String str1 = this.bBT.getString(R.string.pos_vip_dicount_title);
      byte b = 0;
      String str2 = this.bBT.getString(R.string.pos_vip_price);
      p p = new p(this);
      layoutLeftTextRightTextWithDialog.a(new String[] { str1, str2 }, p);
      if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
        this.bBQ.setOnClickListener(o.bBU); 
      this.bBP = (LayoutLeftTextRightEditTextWithUnit)this.bBN.findViewById(R.id.layout_discount);
      this.bBP.aqU().setInputType(8194);
      n.a(this.bBP.aqU(), 20, a.AZ().Be());
      LayoutLeftTextRightEditTextWithUnit layoutLeftTextRightEditTextWithUnit = this.bBP;
      if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
        b = 8; 
      layoutLeftTextRightEditTextWithUnit.setVisibility(b);
      this.bBR = (LayoutLeftTextRightCheckbox)this.bBN.findViewById(R.id.layoutVipOnCredit);
      this.bBS = (LayoutLeftTextRightCheckbox)this.bBN.findViewById(R.id.only_read_card_layout);
    }
    
    private void z(Boolean param1Boolean) { this.bBR.setChecked(param1Boolean.booleanValue()); }
    
    public void dS(boolean param1Boolean) {
      if (param1Boolean) {
        this.bBP.setVisibility(0);
        this.bBQ.setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
        return;
      } 
      this.bBP.setVisibility(8);
      this.bBQ.setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\VipBasicInfoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */