package com.laiqian.version.d;

import android.content.res.Resources;
import com.laiqian.version.c.a;
import com.laiqian.version.view.MyEvaluationActivity;

public class c {
  public String TAG = c.class.getName();
  
  private Resources dJC;
  
  private MyEvaluationActivity dJE;
  
  private String dJb;
  
  private a dJm;
  
  public c(MyEvaluationActivity paramMyEvaluationActivity, String paramString) {
    this.dJE = paramMyEvaluationActivity;
    this.dJC = this.dJE.axk().getResources();
    this.dJm = new a();
    this.dJb = paramString;
  }
  
  public void axf() {
    d d = new d(this);
    this.dJm.a(d, this.dJb);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */