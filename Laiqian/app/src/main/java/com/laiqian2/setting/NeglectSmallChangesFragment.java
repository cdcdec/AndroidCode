package com.laiqian.setting;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.laiqian.entity.k;
import com.laiqian.setting.a.a;
import com.laiqian.ui.container.LayoutLeftTextRightCheckbox;
import com.laiqian.ui.layout.CheckBoxLayout;

public class NeglectSmallChangesFragment extends Fragment {
  private final a dkb;
  
  private a dkf;
  
  public NeglectSmallChangesFragment(a parama) { this.dkb = parama; }
  
  public static NeglectSmallChangesFragment a(a parama) { return new NeglectSmallChangesFragment(parama); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) { return paramLayoutInflater.inflate(2131427595, paramViewGroup, false); }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.dkf = new a(getView(), getActivity());
    this.dkb.dnQ.b(new r(this));
    this.dkf.dkl.setOnCheckedChangeListener(new s(this));
    this.dkf.dkh.setOnClickListener(new t(this));
    this.dkf.dki.setOnClickListener(new u(this));
    this.dkf.dkj.setOnClickListener(new v(this));
    this.dkf.dkk.setOnClickListener(new w(this));
  }
  
  public void save() { this.dkb.save(); }
  
  static class a {
    View aQG;
    
    CheckBoxLayout dkh;
    
    CheckBoxLayout dki;
    
    CheckBoxLayout dkj;
    
    CheckBoxLayout dkk;
    
    LayoutLeftTextRightCheckbox dkl;
    
    ViewGroup dkm;
    
    Context mContext;
    
    public a(View param1View, Context param1Context) {
      this.aQG = param1View;
      this.mContext = param1Context;
      initView();
    }
    
    private void initView() {
      this.dkm = (ViewGroup)this.aQG.findViewById(2131297941);
      this.dkl = (LayoutLeftTextRightCheckbox)this.aQG.findViewById(2131298210);
      this.dkh = (CheckBoxLayout)this.aQG.findViewById(2131298209);
      this.dki = (CheckBoxLayout)this.aQG.findViewById(2131298208);
      this.dkj = (CheckBoxLayout)this.aQG.findViewById(2131298809);
      this.dkk = (CheckBoxLayout)this.aQG.findViewById(2131298808);
      CheckBoxLayout checkBoxLayout = this.dkh;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("<font color='#ff3b3b3b'>");
      stringBuilder.append(this.mContext.getString(2131625862));
      stringBuilder.append("<font color='#df554a'>");
      stringBuilder.append(this.mContext.getString(2131625195));
      stringBuilder.append("</font></font>");
      checkBoxLayout.setText(Html.fromHtml(stringBuilder.toString()));
      checkBoxLayout = this.dki;
      stringBuilder = new StringBuilder();
      stringBuilder.append("<font color='#ff3b3b3b'>");
      stringBuilder.append(this.mContext.getString(2131625861));
      stringBuilder.append("<font color='#df554a'>");
      stringBuilder.append(this.mContext.getString(2131625194));
      stringBuilder.append("</font></font>");
      checkBoxLayout.setText(Html.fromHtml(stringBuilder.toString()));
      checkBoxLayout = this.dkj;
      stringBuilder = new StringBuilder();
      stringBuilder.append("<font color='#ff3b3b3b'>");
      stringBuilder.append(this.mContext.getString(2131629343));
      stringBuilder.append("<font color='#df554a'>");
      stringBuilder.append(this.mContext.getString(2131625165));
      stringBuilder.append("</font></font>");
      checkBoxLayout.setText(Html.fromHtml(stringBuilder.toString()));
      checkBoxLayout = this.dkk;
      stringBuilder = new StringBuilder();
      stringBuilder.append("<font color='#ff3b3b3b'>");
      stringBuilder.append(this.mContext.getString(2131629342));
      stringBuilder.append("<font color='#df554a'>");
      stringBuilder.append(this.mContext.getString(2131625193));
      stringBuilder.append("</font></font>");
      checkBoxLayout.setText(Html.fromHtml(stringBuilder.toString()));
      this.dkh.arK().hb(true);
      this.dki.arK().hb(true);
      this.dkj.arK().hb(true);
      this.dkk.arK().hb(true);
    }
    
    public void c(k param1k) throws Exception {
      if (param1k.aSl) {
        this.dkm.setVisibility(0);
        this.dkl.setChecked(param1k.aSl);
        this.dkh.setSelected(param1k.aSm);
        this.dki.setSelected(param1k.aSn);
        this.dkj.setSelected(param1k.aSo);
        this.dkk.setSelected(param1k.aSp);
        return;
      } 
      this.dkl.setChecked(param1k.aSl);
      this.dkm.setVisibility(8);
    }
    
    public void de(View param1View) {
      for (byte b = 0; b < this.dkm.getChildCount(); b++) {
        View view = this.dkm.getChildAt(b);
        if (view instanceof CheckBoxLayout)
          ((CheckBoxLayout)view).setSelected(false); 
      } 
      param1View.setSelected(true);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\NeglectSmallChangesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */