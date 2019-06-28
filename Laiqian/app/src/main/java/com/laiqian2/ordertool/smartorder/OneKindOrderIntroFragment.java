package com.laiqian.ordertool.smartorder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.s;

public class OneKindOrderIntroFragment extends FragmentRoot {
  a ceB;
  
  private void setupViews() {
    switch (getArguments().getInt("instruction_fragment")) {
      default:
        return;
      case 6:
        this.ceB.aNl.setText(getString(2131629732));
        this.ceB.ceC.setImageResource(2131231154);
        return;
      case 5:
        this.ceB.aNl.setText(getString(2131629731));
        this.ceB.ceC.setImageResource(2131231153);
        return;
      case 4:
        break;
    } 
    this.ceB.aNl.setText(getString(2131629737));
    this.ceB.ceC.setImageResource(2131231155);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.ceB = a.j(this);
    setupViews();
    return this.ceB.aQG;
  }
  
  public static class a {
    public TextView aNl;
    
    public View aQG;
    
    public ImageView ceC;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.aNl = (TextView)s.z(param1View, 2131297284);
      this.ceC = (ImageView)s.z(param1View, 2131297279);
    }
    
    public static a j(Fragment param1Fragment) { return new a(LayoutInflater.from(param1Fragment.getActivity()).inflate(2131427612, null)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\smartorder\OneKindOrderIntroFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */