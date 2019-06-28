package com.laiqian.version.d;

import android.content.res.Resources;
import com.laiqian.version.c.a;
import com.laiqian.version.view.DoEvaluateActivity;

public class a {
  public String TAG = g.class.getName();
  
  private DoEvaluateActivity dJB;
  
  private Resources dJC;
  
  private String dJb;
  
  private a dJm;
  
  public a(DoEvaluateActivity paramDoEvaluateActivity, String paramString) {
    this.dJB = paramDoEvaluateActivity;
    this.dJC = this.dJB.axk().getResources();
    this.dJm = new a();
    this.dJb = paramString;
  }
  
  public void x(int paramInt, String paramString) {
    b b = new b(this);
    a a1 = this.dJm;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(paramInt);
    a1.a(b, stringBuilder.toString(), paramString, this.dJb);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */