package com.laiqian.setting;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.auth.cj;
import com.laiqian.d.a;
import com.laiqian.product.dq;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import java.util.concurrent.Executors;

public class SettingProductFragment extends FragmentRoot {
  boolean aGu;
  
  private dq cSp;
  
  private String[] dlO = { "1", "2" };
  
  private aq dlP;
  
  private aq dlQ;
  
  private r dlR;
  
  private Dialog dlU;
  
  @Nullable
  TextView dmN;
  
  TextView dmO;
  
  private final int dmP = 1;
  
  private void ape() {
    if (this.dlU == null) {
      this.dlU = new bb(getActivity());
      this.dlU.setCancelable(false);
    } 
    this.dlU.show();
    (new ck(this)).executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
  }
  
  private void apg() {
    if (this.cSp != null) {
      if (this.cSp.ajU() <= 0) {
        this.dmN.setVisibility(8);
        this.dmO.setVisibility(8);
        return;
      } 
      this.dmN.setVisibility(0);
      this.dmO.setVisibility(0);
      this.dmN.setText(String.valueOf(this.cSp.ajU()));
    } 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
      return; 
    if (paramInt1 == 1)
      apg(); 
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle) {
    View view1 = paramLayoutInflater.inflate(2131428035, null);
    View view2 = view1.findViewById(2131298553);
    boolean bool = a.AZ().BN();
    int j = 0;
    if (bool) {
      view2.setVisibility(0);
      cj cj = new cj(getActivity());
      Boolean[] arrayOfBoolean = cj.yO();
      cj.close();
      this.aGu = arrayOfBoolean[1].booleanValue();
      view2.findViewById(2131298499).setOnClickListener(new by(getActivity(), com.laiqian.product.ProductList.class));
      view2.findViewById(2131296389).setOnClickListener(new cb(this, getActivity(), com.laiqian.product.ProductAttributeActivity.class));
      view2.findViewById(2131298118).setOnClickListener(new cc(this, getActivity(), com.laiqian.product.MealSetActivity.class));
      i = 1;
    } else {
      view2.setVisibility(8);
      i = 0;
    } 
    view2 = view1.findViewById(2131298664);
    if (a.AZ().BO()) {
      view2.setVisibility(0);
      view2.findViewById(2131298662).setOnClickListener(new by(getActivity(), com.laiqian.product.RawMaterialListActivity.class));
      view2.findViewById(2131298663).setOnClickListener(new by(getActivity(), com.laiqian.report.ui.RawMaterialReportActivity.class));
      if (i + true == true)
        view2.findViewById(2131297751).setVisibility(8); 
    } else {
      view2.setVisibility(8);
    } 
    view1.findViewById(2131298451).setOnClickListener(new by(getActivity(), com.laiqian.pos.ProductPictureManagementActivity.class, null));
    view2 = view1.findViewById(2131299185);
    if (getResources().getBoolean(2131034127)) {
      view2.setVisibility(0);
      view2 = view2.findViewById(2131299183);
      view2.setOnClickListener(new cd(this));
      this.dmN = (TextView)view2.findViewById(2131299772);
      this.dmO = (TextView)view2.findViewById(2131299779);
      this.cSp = new dq(getActivity());
      apg();
    } else {
      view2.setVisibility(8);
    } 
    if (getActivity().getResources().getBoolean(2131034126)) {
      view2 = view1.findViewById(2131298452);
      view2.setVisibility(0);
      view2.setOnClickListener(new by(getActivity(), com.laiqian.product.ServiceChargeActivity.class, null));
    } 
    view2 = view1.findViewById(2131298594);
    TextView textView = (TextView)view2.findViewById(2131298593);
    int i = a.AZ().Bg();
    textView.setText(getResources().getTextArray(2130903071)[i]);
    textView.setTag(Integer.valueOf(i));
    view2.setTag(textView);
    view2.setOnClickListener(new ce(this));
    view2 = view1.findViewById(2131299844);
    textView = (TextView)view2.findViewById(2131299843);
    null = new StringBuilder();
    null.append(a.AZ().Bf());
    null.append("");
    String str = null.toString();
    for (i = j; i < this.dlO.length; i++) {
      if (str.equals(this.dlO[i])) {
        textView.setTag(Integer.valueOf(i));
        break;
      } 
    } 
    textView.setText(str);
    view2.setTag(textView);
    view2.setOnClickListener(new cg(this));
    view2 = view1.findViewById(2131298590);
    View view3 = view2.findViewById(2131298584);
    view3.setSelected(a.AZ().BD());
    view2.setOnClickListener(new ci(this, getActivity(), view3));
    view2 = view1.findViewById(2131298536);
    view3 = view2.findViewById(2131298535);
    view3.setSelected(a.AZ().Bm());
    view2.setOnClickListener(new cj(this, getActivity(), view3));
    return view1;
  }
  
  public void onStart() { super.onStart(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingProductFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */