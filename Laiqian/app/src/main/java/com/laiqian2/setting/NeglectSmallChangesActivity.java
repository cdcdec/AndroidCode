package com.laiqian.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.laiqian.setting.a.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;

public class NeglectSmallChangesActivity extends ActivityRoot {
  private NeglectSmallChangesFragment dka;
  
  private a dkb;
  
  private void abi() {
    if (((Boolean)this.dkb.dnM.getValue()).booleanValue()) {
      r r = new r(this, new p(this));
      r.setTitle(getString(2131627735));
      r.s(getString(2131627733));
      r.t(getString(2131627734));
      r.oZ(getString(2131627732));
      r.show();
    } 
  }
  
  private void aoV() { this.dkb.dnR.b(new o(this)); }
  
  public void onBackPressed() {
    if (((Boolean)this.dkb.dnM.getValue()).booleanValue()) {
      abi();
      return;
    } 
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427393);
    setTitleTextView(2131625863);
    this.dkb = new a(getActivity());
    this.dka = NeglectSmallChangesFragment.a(this.dkb);
    getSupportFragmentManager().beginTransaction().add(2131297068, this.dka).commit();
    setTitleTextViewRight(getString(2131629495), true, new n(this));
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.dkb != null)
      this.dkb.clear(); 
  }
  
  protected void onStart() {
    super.onStart();
    aoV();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\NeglectSmallChangesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */