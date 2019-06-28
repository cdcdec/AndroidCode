package com.laiqian.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.util.m;

public class WeighSettingActivity extends ActivityRoot {
  private View dnH;
  
  private View dnI;
  
  private View dnJ;
  
  private View dnK;
  
  private boolean Az() { return (this.dnH.isSelected() != a.AZ().BE() || this.dnI.isSelected() != a.AZ().BF() || this.dnJ.isSelected() != a.AZ().Cs()); }
  
  private void save() {
    a.AZ().bT(this.dnH.isSelected());
    a.AZ().bU(this.dnI.isSelected());
    a.AZ().cl(this.dnJ.isSelected());
  }
  
  public boolean beforeCloseActivity() {
    if (Az()) {
      r r = new r(this, true, new de(this));
      r.setTitle(getString(2131627735));
      r.s(getString(2131627733));
      r.t(getString(2131627734));
      r.oZ(getString(2131627732));
      r.show();
      return true;
    } 
    return super.beforeCloseActivity();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131428203);
    setTitleTextView(2131630519);
    setTitleTextViewRight(2131624290, new da(this));
    View view = findViewById(2131299116);
    this.dnH = view.findViewById(2131299115);
    view.setOnClickListener(new m.b(this, this.dnH));
    this.dnH.setSelected(a.AZ().BE());
    this.dnI = findViewById(2131299956);
    this.dnI.setSelected(a.AZ().BF());
    findViewById(2131298457).setOnClickListener(new m.b(this, this.dnI));
    this.dnK = findViewById(2131299900);
    this.dnK.setBackgroundResource(2131231847);
    ((TextView)this.dnK.findViewById(2131297314)).setText(2131630324);
    this.dnK.setOnClickListener(new db(this));
    view = findViewById(2131298053);
    this.dnJ = findViewById(2131299117);
    boolean bool = a.AZ().Cs();
    this.dnJ.setSelected(bool);
    if (!bool) {
      this.dnK.setVisibility(8);
      this.dnK.setBackgroundResource(2131231837);
    } 
    m.b b = new m.b(this, this.dnJ);
    view.setOnClickListener(b);
    b.a(new dc(this));
  }
  
  protected void onResume() {
    super.onResume();
    getWindow().getDecorView().post(new dd(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\WeighSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */