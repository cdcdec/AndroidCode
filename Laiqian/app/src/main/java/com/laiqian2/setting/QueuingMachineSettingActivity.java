package com.laiqian.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laiqian.d.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.util.m;

public class QueuingMachineSettingActivity extends ActivityRoot {
  private View dkM;
  
  private boolean Az() { return (this.dkM.isSelected() != a.AZ().Ct()); }
  
  private void aoX() { findViewById(2131298052).setOnClickListener(new ae(this)); }
  
  private void aoY() {
    View view1 = findViewById(2131298052);
    View view2 = findViewById(2131297980);
    this.dkM = view2.findViewById(2131299118);
    boolean bool = a.AZ().Ct();
    this.dkM.setSelected(bool);
    if (!bool) {
      view1.setVisibility(8);
      view1.setBackgroundResource(2131231837);
    } 
    m.b b = new m.b(this, this.dkM);
    view2.setOnClickListener(b);
    b.a(new af(this, view1));
  }
  
  private void aoZ() {
    ViewGroup viewGroup = getTitleRightCustomize();
    View view = LayoutInflater.from(this).inflate(2131428159, null);
    viewGroup.addView(view);
    view.findViewById(2131299269).setOnClickListener(new ag(this));
    view.findViewById(2131299270).setOnClickListener(new ah(this));
  }
  
  private void apa() { (new a(this, this)).show(); }
  
  private void save() { a.AZ().cm(this.dkM.isSelected()); }
  
  public boolean beforeCloseActivity() {
    if (Az()) {
      r r = new r(this, true, new ai(this));
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
    setContentViewSetCustomTitle(2131427410);
    setTitleTextView(2131629181);
    aoZ();
    aoY();
    aoX();
    if (a.AZ().Cu())
      apa(); 
  }
  
  class a extends d {
    public a(QueuingMachineSettingActivity this$0, Context param1Context) {
      super(param1Context, 2131427559);
      setCancelable(false);
      this.mView.findViewById(2131297439).setOnClickListener(new aj(this, this$0));
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\QueuingMachineSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */