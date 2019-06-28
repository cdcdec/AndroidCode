package com.laiqian.version.d;

import android.content.res.Resources;
import com.laiqian.infrastructure.R;
import com.laiqian.network.h;
import com.laiqian.util.bd;
import com.laiqian.util.ch;
import com.laiqian.version.c.a;
import com.laiqian.version.view.UpgradeAndEvaluationActivity;
import retrofit2.d;

public class g {
  public String TAG = g.class.getName();
  
  private Resources dJC;
  
  private UpgradeAndEvaluationActivity dJI;
  
  private String dJJ;
  
  private String dJK;
  
  private a dJm;
  
  public g(UpgradeAndEvaluationActivity paramUpgradeAndEvaluationActivity) {
    this.dJI = paramUpgradeAndEvaluationActivity;
    this.dJC = this.dJI.axk().getResources();
    this.dJm = new a();
  }
  
  public void R(Boolean paramBoolean) {
    String str;
    i i = new i(this, paramBoolean);
    if (paramBoolean.booleanValue()) {
      str = this.dJK;
    } else {
      str = this.dJJ;
    } 
    this.dJm.a(i, str);
  }
  
  public String axg() { return this.dJK; }
  
  public void c(d<h> paramd, String paramString1, String paramString2) { this.dJm.c(paramd, paramString1, paramString2); }
  
  public void initData() {
    if (bd.bH(this.dJI.axk())) {
      h h = new h(this);
      String str1 = axg();
      null = new StringBuilder();
      null.append("");
      null.append(ch.getVersionCode());
      String str2 = null.toString();
      if (str1 != null) {
        this.dJm.b(h, str2, str1);
        return;
      } 
      this.dJm.b(h, str2, "");
      return;
    } 
    this.dJI.sq(this.dJC.getString(R.string.version_checkNetwork));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */