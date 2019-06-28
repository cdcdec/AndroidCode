package com.laiqian.opentable.tablelist;

import android.arch.lifecycle.g;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.opentable.common.a.a;
import com.laiqian.opentable.common.a.ab;
import com.laiqian.opentable.common.m;
import com.laiqian.ordertool.c.a;
import com.laiqian.ui.a.bb;
import com.laiqian.util.by;

public class b {
  private a bYB;
  
  private a ccY;
  
  private Context context;
  
  private bb waitingDialog;
  
  public b(Context paramContext, a parama, a parama1) {
    this.bYB = new ab(paramContext, parama1);
    this.ccY = parama;
    this.context = paramContext;
  }
  
  public void Yu() {
    try {
      zL();
      this.bYB.a(new c(this));
      return;
    } catch (m m) {
      a(m);
      return;
    } 
  }
  
  public void a(m paramm) {
    if (!by.isNull(paramm.XI())) {
      this.ccY.fa(paramm.XI());
      Log.d(paramm.XI(), paramm.XJ());
    } 
    zM();
    a.e(paramm);
  }
  
  public void t(long paramLong1, long paramLong2) {
    try {
      zL();
      this.bYB.a(paramLong1, paramLong2, new d(this));
      return;
    } catch (m m) {
      a(m);
      return;
    } 
  }
  
  public void zL() {
    if (this.waitingDialog == null) {
      this.waitingDialog = new bb(this.context);
      this.waitingDialog.setCancelable(false);
    } 
    if (((AppCompatActivity)this.context).getLifecycle().L().a(g.b.br))
      this.waitingDialog.show(); 
  }
  
  public void zM() {
    if (this.waitingDialog != null)
      this.waitingDialog.dismiss(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\tablelist\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */