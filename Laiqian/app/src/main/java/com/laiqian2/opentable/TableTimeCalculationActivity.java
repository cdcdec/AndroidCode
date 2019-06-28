package com.laiqian.opentable;

import android.os.Bundle;
import android.view.View;
import com.laiqian.d.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.util.m;

public class TableTimeCalculationActivity extends ActivityRoot {
  private View bYp;
  
  private View bYq;
  
  private boolean Az() { return (this.bYp.isSelected() != a.AZ().Cv() || this.bYq.isSelected() != a.AZ().Cw()); }
  
  private void initView() {
    View view1 = findViewById(2131298010);
    this.bYq = view1.findViewById(2131298008);
    boolean bool = a.AZ().Cw();
    View view2 = view1.findViewById(2131298009);
    if (bool) {
      this.bYq.setSelected(true);
    } else {
      view2.setSelected(true);
    } 
    this.bYq.setOnClickListener(new y(this, view2));
    view2.setOnClickListener(new z(this, view2));
    view2 = findViewById(2131299119);
    this.bYp = view2.findViewById(2131299120);
    bool = a.AZ().Cv();
    this.bYp.setSelected(bool);
    if (!bool)
      view1.setVisibility(8); 
    m.b b = new m.b(this, this.bYp);
    view2.setOnClickListener(b);
    b.a(new aa(this, view1));
  }
  
  private void save() {
    a.AZ().co(this.bYp.isSelected());
    a.AZ().cp(this.bYq.isSelected());
  }
  
  public boolean beforeCloseActivity() {
    if (Az()) {
      r r = new r(this, true, new x(this));
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
    setContentViewSetCustomTitle(2131427428);
    setTitleTextView(2131629943);
    setTitleTextViewRight(2131624290, new w(this));
    initView();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\TableTimeCalculationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */