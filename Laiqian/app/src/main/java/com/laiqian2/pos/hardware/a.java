package com.laiqian.pos.hardware;

import android.view.View;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.customerdisplay.a;

class a implements View.OnClickListener {
  a(CustomerDisplayDebugFragment paramCustomerDisplayDebugFragment) {}
  
  public void onClick(View paramView) {
    try {
      a a1 = CustomerDisplayDebugFragment.a(this.ckd).aam();
      a1.CX();
      a1.b(Integer.valueOf(123412));
      return;
    } catch (SecurityException|java.io.IOException paramView) {
      Toast.makeText(this.ckd.getActivity(), paramView.getMessage(), 0).show();
      a.e(paramView);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hardware\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */