package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.ui.a.ab;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.d;
import com.laiqian.ui.container.f;
import com.laiqian.ui.container.l;
import com.laiqian.util.av;
import java.util.ArrayList;

public class WeshopPaymentSettingsFragment extends Fragment {
  ab cuO = null;
  
  b cxg = new b(16908290);
  
  gp cxh;
  
  gp cxi;
  
  private void b(gp paramgp) {
    ((CheckBox)this.cxg.cwM.dwV.getView()).setChecked(this.cxi.FH());
    ((CheckBox)this.cxg.cwN.dwV.getView()).setChecked(this.cxi.acl());
    EditText editText = (EditText)this.cxg.ctm.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.cxi.ack());
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
  }
  
  private void setListeners() {
    ((RelativeLayout)this.cxg.ctn.getView()).setOnClickListener(new gq(this));
    ((CheckBox)this.cxg.cwN.dwV.getView()).setOnCheckedChangeListener(new gr(this));
    ((CheckBox)this.cxg.cwM.dwV.getView()).setOnCheckedChangeListener(new gs(this));
    ((EditText)this.cxg.ctm.dwQ.getView()).addTextChangedListener(new gt(this));
  }
  
  void acq() {
    if (this.cuO != null) {
      if (!this.cuO.isShowing()) {
        this.cuO.show();
        return;
      } 
    } else {
      this.cuO = new ab(getActivity());
      this.cuO.setCanceledOnTouchOutside(false);
      this.cuO.show();
    } 
  }
  
  void acr() {
    if (this.cuO != null && this.cuO.isShowing())
      this.cuO.dismiss(); 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 1)
        return; 
      ArrayList arrayList = (ArrayList)paramIntent.getSerializableExtra("couponList");
      this.cxi.af(arrayList);
      this.cxh.af(arrayList);
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = paramLayoutInflater.inflate(2131427627, null);
    this.cxg.S(view);
    setListeners();
    (new a(this, null)).execute(new Void[0]);
    return view;
  }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private a(WeshopPaymentSettingsFragment this$0) {}
    
    protected void b(Boolean param1Boolean) {
      try {
        this.cxj.acr();
      } catch (Exception exception) {}
      if (param1Boolean.booleanValue()) {
        WeshopPaymentSettingsFragment.a(this.cxj, this.cxj.cxi);
        return;
      } 
      Toast.makeText(this.cxj.getActivity(), this.cxj.getString(2131630541), 0).show();
      av av = new av(this.cxj.getActivity());
      String str = av.Tx();
      av.close();
      this.cxj.cxh = new gp(str);
      this.cxj.cxi = this.cxj.cxh.acp();
      WeshopPaymentSettingsFragment.a(this.cxj, this.cxj.cxi);
    }
    
    protected Boolean g(Void... param1VarArgs) {
      this.cxj.cxh = fp.aX(this.cxj.getActivity()).abX();
      if (this.cxj.cxh == null)
        return Boolean.valueOf(false); 
      this.cxj.cxi = this.cxj.cxh.acp();
      return Boolean.valueOf(true);
    }
    
    protected void onPreExecute() { this.cxj.acq(); }
  }
  
  public static class b extends ab<ViewGroup> {
    public f ctm = new f(2131297691);
    
    public d ctn = new d(2131297538);
    
    public l cwM = new l(2131297726);
    
    public l cwN = new l(2131297512);
    
    public b(int param1Int) { super(param1Int); }
    
    public void S(View param1View) {
      super.S(param1View);
      acs();
    }
    
    public void acs() {
      ((TextView)this.cwM.cAO.getView()).setText(getContext().getString(2131630555));
      ((TextView)this.cwN.cAO.getView()).setText(getContext().getString(2131630549));
      ((TextView)this.ctm.cAO.getView()).setText(getContext().getString(2131630553));
      ((TextView)this.ctn.cAO.getView()).setText(getContext().getString(2131630550));
      ((TextView)this.ctm.cAT.getView()).setText(getContext().getString(2131624910));
      if (!getContext().getResources().getBoolean(2131034152))
        ((TextView)this.ctm.cAT.getView()).setVisibility(8); 
      ((ViewGroup)this.cwM.getView()).setBackgroundResource(2131230968);
      ((ViewGroup)this.cwN.getView()).setBackgroundResource(2131230968);
      ((RelativeLayout)this.ctn.getView()).setBackgroundResource(2131230968);
      ((EditText)this.ctm.dwQ.getView()).setInputType(8194);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WeshopPaymentSettingsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */