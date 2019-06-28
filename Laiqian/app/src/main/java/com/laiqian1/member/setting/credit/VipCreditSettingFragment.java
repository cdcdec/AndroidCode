package com.laiqian.member.setting.credit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.pos.settings.aa;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.f;
import com.laiqian.ui.container.l;
import com.laiqian.util.ar;
import com.laiqian.vip.R;

public class VipCreditSettingFragment extends Fragment implements e, aa {
  a bCY;
  
  d bCZ;
  
  private void RX() {
    ((ViewGroup)this.bCY.bDc.getView()).setFocusableInTouchMode(true);
    ((ViewGroup)this.bCY.bDc.getView()).setFocusable(true);
    ((ViewGroup)this.bCY.bDc.getView()).requestFocus();
  }
  
  private void setListeners() {
    ((CheckBox)this.bCY.bDc.dwV.getView()).setOnCheckedChangeListener(new b(this));
    ((EditText)this.bCY.bDb.dwQ.getView()).addTextChangedListener(new c(this));
  }
  
  private void setupViews() {
    ((TextView)this.bCY.bDc.cAO.getView()).setText(getString(R.string.membership_allows_negative_values));
    ((TextView)this.bCY.bDb.cAO.getView()).setText(getString(R.string.vip_credit_limit));
    ((EditText)this.bCY.bDb.dwQ.getView()).setInputType(8194);
    ((EditText)this.bCY.bDb.dwQ.getView()).setFilters(ar.lw(99));
    ((ViewGroup)this.bCY.bDc.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    ((ViewGroup)this.bCY.bDb.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
  }
  
  public boolean Az() { return (this.bCZ != null) ? this.bCZ.Az() : 0; }
  
  public void a(aa paramaa) { this.bCZ.save(); }
  
  public void ao(double paramDouble) {
    if (paramDouble >= 0.0D) {
      EditText editText = (EditText)this.bCY.bDb.dwQ.getView();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramDouble);
      stringBuilder.append("");
      editText.setText(stringBuilder.toString());
    } 
  }
  
  public void dU(boolean paramBoolean) {
    byte b;
    ((CheckBox)this.bCY.bDc.dwV.getView()).setChecked(paramBoolean);
    ViewGroup viewGroup = (ViewGroup)this.bCY.bDb.getView();
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    viewGroup.setVisibility(b);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    this.bCY = a.c(this);
    this.bCZ = new d(getActivity(), this);
    this.bCZ.init();
    setupViews();
    setListeners();
    return this.bCY.getView();
  }
  
  public void save() { this.bCZ.save(); }
  
  public static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.fragment_vip_credit_setting;
    
    public f bDb = new f(R.id.layoutLimit);
    
    public l bDc = new l(R.id.layoutCredit);
    
    public a(int param1Int, View param1View) { super(param1Int); }
    
    public static a c(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(aCt, null);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\credit\VipCreditSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */