package com.laiqian.pos;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;

public class PayTypeSelectSpecific extends ActivityRoot {
  private boolean aAZ;
  
  private boolean bfn;
  
  private int cfA;
  
  private int cfB;
  
  View cfC;
  
  View cfD;
  
  private int cfw;
  
  private int cfx;
  
  private int cfy;
  
  private boolean cfz;
  
  private boolean Az() { return (this.cfA != this.cfB); }
  
  private void Zz() {
    setResult(-1, getIntent().putExtra("code", this.cfA).putExtra("changed", Az()));
    finish();
  }
  
  private void cz(View paramView) {
    boolean bool;
    this.cfA = ((Integer)paramView.getTag()).intValue();
    paramView = this.cfC;
    int i = this.cfA;
    int j = this.cfx;
    boolean bool1 = true;
    if (i == j || this.cfA == this.cfw) {
      bool = true;
    } else {
      bool = false;
    } 
    j(paramView, bool);
    paramView = this.cfD;
    if (this.cfA == this.cfy) {
      bool = bool1;
    } else {
      bool = false;
    } 
    j(paramView, bool);
  }
  
  private void j(View paramView, boolean paramBoolean) {
    paramView.findViewById(2131298932).setSelected(paramBoolean);
    k(paramView, paramBoolean);
    paramView.setActivated(paramBoolean);
  }
  
  private void k(View paramView, boolean paramBoolean) {
    Resources resources = getResources();
    if (paramBoolean) {
      i = 2131099855;
    } else {
      i = 2131099942;
    } 
    int i = resources.getColor(i);
    Drawable drawable = paramView.findViewById(2131299267).getBackground();
    if (drawable != null && drawable instanceof GradientDrawable)
      ((GradientDrawable)drawable).setColor(i); 
  }
  
  private void save() {
    if (this.aAZ) {
      a.AZ().dW(this.cfA);
      getLaiqianPreferenceManager().P(Boolean.valueOf(false));
    } else {
      a.AZ().dX(this.cfA);
      getLaiqianPreferenceManager().Q(Boolean.valueOf(false));
    } 
    sendBroadcast(new Intent("pos_activity_change_data_paytype"));
  }
  
  public void ZA() {
    r r = new r(this, new aj(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  public void onBackPressed() {
    if (Az()) {
      ZA();
      return;
    } 
    Zz();
  }
  
  protected void onCreate(Bundle paramBundle) {
    boolean bool;
    int i;
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427931);
    this.cfB = getIntent().getIntExtra("code", 2);
    this.cfA = this.cfB;
    null = getIntent();
    boolean bool1 = true;
    this.aAZ = null.getBooleanExtra("isAlipay", true);
    TextView textView1 = (TextView)findViewById(2131296437);
    TextView textView2 = (TextView)findViewById(2131298637);
    TextView textView3 = (TextView)findViewById(2131296303);
    this.bfn = "150001".equals(CrashApplication.getLaiqianPreferenceManager().atp());
    if (this.aAZ) {
      this.cfw = 0;
      this.cfx = 1;
      this.cfy = 2;
      if (getLaiqianPreferenceManager().FC() != null) {
        bool = true;
      } else {
        boolean bool2;
        bool = false;
      } 
      this.cfz = bool;
      i = 2131231545;
      setTitleTextView(2131627314);
      textView1.setText(2131627313);
      textView2.setText(2131627316);
      textView3.setText(2131627311);
    } else {
      this.cfw = 8;
      this.cfx = 5;
      this.cfy = 7;
      if (getLaiqianPreferenceManager().FD() != null) {
        bool = true;
      } else {
        boolean bool2;
        bool = false;
      } 
      this.cfz = bool;
      i = 2131231549;
      setTitleTextView(2131627371);
      textView1.setText(2131627313);
      textView2.setText(2131627373);
      textView3.setText(2131627311);
    } 
    ag ag = new ag(this);
    setTitleTextViewRight(2131624290, new ah(this));
    this.cfC = findViewById(2131296439);
    this.cfC.findViewById(2131296438).setBackgroundResource(i);
    View view2 = this.cfC;
    if (this.cfB == this.cfx || this.cfB == this.cfw) {
      bool = true;
    } else {
      bool = false;
    } 
    j(view2, bool);
    this.cfC.setTag(Integer.valueOf(this.cfx));
    this.cfC.setOnClickListener(ag);
    this.cfD = findViewById(2131296304);
    View view1 = this.cfD;
    if (this.cfB == this.cfy) {
      bool = bool1;
    } else {
      bool = false;
    } 
    j(view1, bool);
    this.cfD.setTag(Integer.valueOf(this.cfy));
    this.cfD.setOnClickListener(new ai(this));
    findViewById(2131296667).setVisibility(8);
  }
  
  class PayTypeSelectSpecific {}
  
  class PayTypeSelectSpecific {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\PayTypeSelectSpecific.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */