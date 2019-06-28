package com.laiqian.main.module.productcode;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jakewharton.rxbinding2.a.a;
import com.laiqian.d.a;
import com.laiqian.main.dl;
import com.laiqian.product.models.g;
import com.laiqian.product.models.h;
import com.laiqian.util.by;
import com.laiqian.util.n;
import io.reactivex.a.a;
import java.io.PrintStream;

public class PosActivityProductCodeFragment extends Fragment {
  dl bfr;
  
  a biV = new a();
  
  a bkn;
  
  boolean bko = false;
  
  Runnable bkp = new a(this);
  
  Handler handler = new Handler();
  
  public PosActivityProductCodeFragment(dl paramdl) { this.bfr = paramdl; }
  
  private void Mq() {
    this.biV.b(a.bu(this.bkn.bks.bku).b(new b(this)));
    this.biV.b(this.bfr.bel.beJ.b(new c(this)));
  }
  
  private void NU() { this.bkn.bks.bkt.setKeyListener(new d(this)); }
  
  private void NV() {
    if (!NW()) {
      this.bkn.bks.aQo.setVisibility(0);
      this.bkn.bks.bkt.setText(getString(2131627481));
    } 
  }
  
  private boolean NW() { return (this.bkn.bks.aQo.getVisibility() == 0); }
  
  private void NX() {
    if (this.bkn.bks.aQo.getVisibility() != 8)
      this.bkn.bks.aQo.setVisibility(8); 
  }
  
  private CharSequence NY() {
    null = this.bkn.bks.bkt;
    CharSequence charSequence1 = null;
    if (null == null)
      return null; 
    CharSequence charSequence2 = this.bkn.bks.bkt.getText();
    int k = charSequence2.length();
    int i = k - 1;
    int j = k;
    while (i >= 0) {
      char c = charSequence2.charAt(i);
      String str = getString(2131629177);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(c);
      stringBuilder.append("");
      if (str.contains(stringBuilder.toString())) {
        j = i;
        i--;
      } 
    } 
    if (k > j)
      charSequence1 = charSequence2.subSequence(j, k); 
    return charSequence1;
  }
  
  private void wK() { this.biV.clear(); }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    this.bkn = new a(paramActivity);
    NU();
  }
  
  public void onStart() {
    super.onStart();
    Mq();
  }
  
  public void onStop() {
    super.onStop();
    wK();
  }
  
  static class a {
    a bks;
    
    public a(Activity param1Activity) { this.bks = new a(param1Activity.findViewById(2131298537)); }
    
    static final class a {
      RelativeLayout aQo;
      
      TextView bkt;
      
      View bku;
      
      a(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bkt = (TextView)param2View.findViewById(2131298538);
        this.bku = param2View.findViewById(2131297215);
      }
    }
  }
  
  static final class a {
    RelativeLayout aQo;
    
    TextView bkt;
    
    View bku;
    
    a(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bkt = (TextView)param1View.findViewById(2131298538);
      this.bku = param1View.findViewById(2131297215);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcode\PosActivityProductCodeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */