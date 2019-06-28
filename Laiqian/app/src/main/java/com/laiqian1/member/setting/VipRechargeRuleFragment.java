package com.laiqian.member.setting;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.member.b.b;
import com.laiqian.member.model.a;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.container.LayoutLeftTextRightTextWithArrow;
import com.laiqian.ui.container.LayoutLeftTextRightTextWithDialog;
import com.laiqian.ui.container.aa;
import com.laiqian.util.bo;
import com.laiqian.util.n;
import com.laiqian.vip.R;

public class VipRechargeRuleFragment extends Fragment implements aa {
  private a bCJ;
  
  public static VipRechargeRuleFragment RF() {
    VipRechargeRuleFragment vipRechargeRuleFragment = new VipRechargeRuleFragment();
    vipRechargeRuleFragment.setArguments(new Bundle());
    return vipRechargeRuleFragment;
  }
  
  private void RG() {
    String str2 = "";
    String str1 = str2;
    if (RootApplication.getLaiqianPreferenceManager().QV() != 1) {
      null = new a(getActivity());
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
    this.bCJ.bCL.aqW().setSingleLine();
    this.bCJ.bCL.aqW().setEllipsize(TextUtils.TruncateAt.END);
    TextView textView = this.bCJ.bCL.aqW();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(str1);
    textView.setText(stringBuilder.toString());
  }
  
  public boolean Az() { return false; }
  
  public void a(aa paramaa) {}
  
  public void onCreate(Bundle paramBundle) { super.onCreate(paramBundle); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) { return paramLayoutInflater.inflate(R.layout.fragment_vip_recharge_rule, paramViewGroup, false); }
  
  public void onResume() {
    super.onResume();
    RG();
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.bCJ = new a(getActivity());
  }
  
  public void save() {}
  
  static class a {
    LayoutLeftTextRightTextWithDialog bCK;
    
    LayoutLeftTextRightTextWithArrow bCL;
    
    Context mContext;
    
    public a(Activity param1Activity) {
      this.mContext = param1Activity;
      this.bCK = (LayoutLeftTextRightTextWithDialog)param1Activity.findViewById(R.id.layout_gift_model);
      this.bCL = (LayoutLeftTextRightTextWithArrow)param1Activity.findViewById(R.id.layout_gift_scheme);
      String str = a.AZ().Cz();
      boolean bool = TextUtils.isEmpty(str);
      byte b = 0;
      if (!bool) {
        this.bCK.oX(str);
      } else {
        this.bCK.oX(param1Activity.getString(b.bwY[0]));
      } 
      this.bCK.a((String[])n.a(param1Activity, b.bwY).toArray(new String[0]), new ar(this));
      if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
        this.bCL.setOnClickListener(aq.bBU);
      } else {
        this.bCL.setOnClickListener(new bo(param1Activity, com.laiqian.member.setting.discount.RechargePrivilegeActivity.class));
      } 
      LayoutLeftTextRightTextWithArrow layoutLeftTextRightTextWithArrow = this.bCL;
      if (LQKVersion.zl())
        b = 8; 
      layoutLeftTextRightTextWithArrow.setVisibility(b);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\VipRechargeRuleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */