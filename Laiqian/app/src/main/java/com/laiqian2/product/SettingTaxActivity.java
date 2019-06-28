package com.laiqian.product;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.laiqian.d.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.layout.CheckBoxLayoutInMainSetting;

public class SettingTaxActivity extends ActivityRoot {
  boolean cTK;
  
  private CheckBoxLayoutInMainSetting cTL;
  
  public static void bs(Context paramContext) { paramContext.startActivity(new Intent(paramContext, SettingTaxActivity.class)); }
  
  private boolean save() {
    a.AZ().ca(this.cTK);
    Toast.makeText(this, 2131628160, 0).show();
    return true;
  }
  
  public boolean Az() { return (this.cTK != a.AZ().BV()); }
  
  public void ZA() {
    r r = new r(this, new ez(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  public boolean beforeCloseActivity() {
    finish();
    return true;
  }
  
  public void onBackPressed() {
    if (Az()) {
      ZA();
      return;
    } 
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427421);
    setTitleTextView(2131628355);
    setTitleTextViewRight(2131629495, new ex(this));
    this.cTL = (CheckBoxLayoutInMainSetting)findViewById(2131296741);
    this.cTK = a.AZ().BV();
    this.cTL.setChecked(this.cTK);
    this.cTL.a(new ey(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\SettingTaxActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */