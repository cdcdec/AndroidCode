package com.laiqian.opentable.b;

import android.content.Context;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.opentable.common.a.a;
import com.laiqian.opentable.common.a.ab;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;
import com.laiqian.ordertool.c.a;
import com.laiqian.ui.a.bb;
import com.laiqian.util.bd;
import com.laiqian.util.by;

public class b {
  private a bYB;
  
  private a ccG;
  
  private Context context;
  
  private bb waitingDialog;
  
  public b(Context paramContext, a parama, a parama1) {
    this.bYB = new ab(paramContext, parama1);
    this.ccG = parama;
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
      (new q.a(context1, stringBuilder.toString(), paramInt, new k(this, paramf))).start();
      return;
    } 
    paramf.dp(true);
  }
  
  public void a(TableEntity paramTableEntity, boolean paramBoolean) {
    try {
      zL();
      this.bYB.a(paramTableEntity, new c(this, paramTableEntity, paramBoolean));
      return;
    } catch (m paramTableEntity) {
      a(paramTableEntity);
      return;
    } 
  }
  
  public void a(m paramm) {
    if (!by.isNull(paramm.XI())) {
      this.ccG.fa(paramm.XI());
      Log.d(paramm.XI(), paramm.XJ());
    } else {
      a.e(paramm);
    } 
    zM();
  }
  
  public void ci(long paramLong) {
    try {
      zL();
      this.bYB.c(paramLong, new l(this, paramLong));
      return;
    } catch (m m) {
      a(m);
      return;
    } 
  }
  
  public void o(TableEntity paramTableEntity) {
    try {
      zL();
      this.bYB.b(paramTableEntity, new g(this, paramTableEntity));
      return;
    } catch (m paramTableEntity) {
      a(paramTableEntity);
      return;
    } 
  }
  
  public void u(long paramLong1, long paramLong2) {
    try {
      zL();
      this.bYB.a(paramLong1, paramLong2, new p(this, paramLong2));
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
    this.waitingDialog.show();
  }
  
  public void zM() {
    if (this.waitingDialog != null)
      this.waitingDialog.dismiss(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */