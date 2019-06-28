package com.laiqian.main.module.setting;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.assistne.icondottextview.IconDotTextView;
import com.laiqian.main.dl;
import com.laiqian.util.an;

public class PosActivitySettingFragment extends Fragment {
  dl bfr;
  
  a blG;
  
  public PosActivitySettingFragment(dl paramdl) { this.bfr = paramdl; }
  
  private void setupViews() { this.blG.biz.setOnClickListener(new b(this, getActivity(), com.laiqian.pos.industry.setting.MainSetting.class)); }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    this.blG = new a(paramActivity);
    setupViews();
  }
  
  public void onResume() { super.onResume(); }
  
  public void onStart() {
    super.onStart();
    an.a("100001", new a(this));
  }
  
  public void onStop() { super.onStop(); }
  
  static class a {
    IconDotTextView biz;
    
    public a(Activity param1Activity) { this.biz = (IconDotTextView)param1Activity.findViewById(2131298946); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\setting\PosActivitySettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */