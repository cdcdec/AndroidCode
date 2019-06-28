package com.laiqian.main.module.productattr;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.assistne.icondottextview.IconDotTextView;
import com.jakewharton.rxbinding2.a.a;
import com.laiqian.main.dl;
import com.laiqian.product.ProductAttributeActivity;
import com.laiqian.util.n;
import io.reactivex.a.a;
import java.io.Serializable;
import java.util.HashMap;

public class PosActivityProductAttributeFragment extends Fragment {
  private final dl bfr;
  
  a biU;
  
  a biV = new a();
  
  public PosActivityProductAttributeFragment(dl paramdl) { this.bfr = paramdl; }
  
  private void setupViews() { a.bu(this.biU.bhL).b(new a(this)); }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 10)
      return; 
    if (paramInt2 == -1) {
      Serializable serializable = paramIntent.getSerializableExtra("ATTRIBUTE_SELECTION");
      boolean bool = paramIntent.getBooleanExtra("APPLY_TO_ALL", false);
      if (serializable != null) {
        HashMap hashMap = (HashMap)serializable;
        if (bool) {
          this.bfr.bea.p(hashMap);
          return;
        } 
        this.bfr.bea.o(hashMap);
      } 
    } 
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    this.biU = new a(paramActivity);
    setupViews();
  }
  
  public void onStart() {
    super.onStart();
    this.bfr.bea.Mf();
  }
  
  public void onStop() { super.onStop(); }
  
  static class a {
    IconDotTextView bhL;
    
    public a(Activity param1Activity) { this.bhL = (IconDotTextView)param1Activity.findViewById(2131296391); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productattr\PosActivityProductAttributeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */