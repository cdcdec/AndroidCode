package com.laiqian.setting;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.laiqian.d.a;
import com.laiqian.e.a.a;
import com.laiqian.e.a.f;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;
import io.reactivex.g.a;

public class DateSettingActivity extends ActivityRoot {
  private r bFM;
  
  private LinearLayout djN;
  
  private LinearLayout djO;
  
  private r djP;
  
  private a djQ;
  
  private Handler handler = new i(this);
  
  private void Jx() {
    g g = new g(this);
    if (this.bFM == null) {
      this.bFM = new r(this, g);
      this.bFM.setTitle(getString(2131626671));
      this.bFM.s(getString(2131626670));
      this.bFM.t(getString(2131628641));
    } 
    this.bFM.show();
  }
  
  private void aoU() {
    if (a.AZ().BN())
      this.djN.setVisibility(0); 
  }
  
  private boolean checkNetwork() {
    boolean bool = bd.bH(this);
    if (!bd.bH(this))
      (new bc(this)).show(); 
    return bool;
  }
  
  private void kc(int paramInt) {
    if (checkNetwork()) {
      this.djQ = new a(this, paramInt, new f(this, paramInt));
      this.djQ.show();
      return;
    } 
    Jx();
  }
  
  private void kd(int paramInt) {
    f f = new f(this);
    a.aKh().r(new c(this, f, paramInt));
  }
  
  private void ke(int paramInt) {
    h h = new h(this, paramInt);
    if (isFinishing())
      return; 
    if (this.djP == null) {
      this.djP = new r(this, h);
      this.djP.oZ(getString(2131626717));
      this.djP.t(getString(2131626715));
      if (paramInt == 0) {
        this.djP.setTitle(getString(2131626925));
      } else if (paramInt == 1) {
        this.djP.setTitle(getString(2131626927));
      } 
      this.djP.s(getString(2131626668));
    } 
    this.djP.show();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427418);
    setTitleTextView(2131626923);
    this.djN = (LinearLayout)findViewById(2131298446);
    this.djN.setBackgroundResource(2130772057);
    this.djN.setOnClickListener(new d(this));
    this.djO = (LinearLayout)findViewById(2131298447);
    this.djO.setBackgroundResource(2130772051);
    this.djO.setOnClickListener(new e(this));
    aoU();
  }
  
  public void showError(String paramString) { Toast.makeText(this, paramString, 0).show(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\DateSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */