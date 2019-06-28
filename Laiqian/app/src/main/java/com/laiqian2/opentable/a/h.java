package com.laiqian.opentable.a;

import android.content.Context;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.opentable.common.a.a;
import com.laiqian.opentable.common.a.ab;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;
import com.laiqian.ordertool.c.a;
import com.laiqian.ui.a.bb;
import com.laiqian.util.bd;
import com.laiqian.util.by;

public class h {
  private a bYB;
  
  private g bYC;
  
  private Context context;
  
  private bb waitingDialog;
  
  public h(Context paramContext, g paramg, a parama) {
    this.bYB = new ab(paramContext, parama);
    this.bYC = paramg;
    this.context = paramContext;
  }
  
  private void a(long paramLong, int paramInt, t.f paramf) throws m {
    if (b.XC() && bd.bH(this.context)) {
      b.a(this.context, "", "", 3006);
      paramf.dp(true);
    } 
    if (bd.bH(this.context)) {
      Context context1 = this.context;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLong);
      stringBuilder.append("");
      (new a.a(context1, stringBuilder.toString(), paramInt, new u(this, paramf))).start();
      return;
    } 
    paramf.dp(true);
  }
  
  public void a(m paramm) {
    if (!by.isNull(paramm.XI())) {
      this.bYC.fa(paramm.XI());
      Log.d(paramm.XI(), paramm.XJ());
    } 
    zM();
    a.e(paramm);
  }
  
  public void bW(long paramLong) {
    try {
      zL();
      this.bYB.a(paramLong, new q(this, paramLong));
      return;
    } catch (m m) {
      a(m);
      return;
    } 
  }
  
  public void bX(long paramLong) {
    try {
      zL();
      this.bYB.b(paramLong, new v(this));
      return;
    } catch (m m) {
      a(m);
      return;
    } 
  }
  
  public void f(a parama) {
    try {
      zL();
      this.bYB.a(parama, new m(this, parama));
      return;
    } catch (m parama) {
      a(parama);
      return;
    } 
  }
  
  public void iU(String paramString) {
    try {
      zL();
      this.bYB.a(paramString, new i(this, paramString));
      return;
    } catch (m paramString) {
      a(paramString);
      return;
    } 
  }
  
  public void zL() {
    if (this.waitingDialog == null) {
      this.waitingDialog = new bb(this.context);
      this.waitingDialog.setCancelable(false);
    } 
    this.waitingDialog.show();
  }
  
  public void zM() {
    if (this.waitingDialog != null)
      this.waitingDialog.dismiss(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */