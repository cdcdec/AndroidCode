package com.laiqian.ordertool.mealorder;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.s;

public class MealOrderIntroFragment extends FragmentRoot {
  a cei;
  
  private void setListeners() {}
  
  private void setupViews() {
    this.cei.cek.loadUrl(getResources().getString(2131625684));
    this.cei.cek.setWebViewClient(new f(this));
    int i = Build.VERSION.SDK_INT;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.cei = a.i(this);
    setupViews();
    setListeners();
    return this.cei.aQG;
  }
  
  public static class a {
    public View aQG;
    
    public WebView cek;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cek = (WebView)s.z(param1View, 2131298116);
    }
    
    public static a i(Fragment param1Fragment) { return new a(LayoutInflater.from(param1Fragment.getActivity()).inflate(2131427592, null)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\mealorder\MealOrderIntroFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */