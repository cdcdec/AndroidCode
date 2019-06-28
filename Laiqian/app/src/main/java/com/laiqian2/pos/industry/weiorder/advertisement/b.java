package com.laiqian.pos.industry.weiorder.advertisement;

import android.content.Context;
import com.laiqian.basic.RootApplication;
import com.laiqian.models.ar;
import com.laiqian.models.at;
import com.laiqian.print.usage.d;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.util.bd;
import com.laiqian.util.ce;
import com.laiqian.util.n;
import io.reactivex.android.b.a;
import io.reactivex.c.g;
import io.reactivex.g.a;
import io.reactivex.n;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b;
import kotlin.c;
import kotlin.c.e;
import kotlin.jvm.a.a;
import kotlin.jvm.b.f;
import kotlin.jvm.b.j;
import kotlin.jvm.b.k;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class b implements v {
  private final b cxn;
  
  private final b cxo;
  
  @NotNull
  private final w cxp;
  
  public b(@NotNull w paramw) {
    this.cxp = paramw;
    this.cxn = c.a((a)c.cxq);
    this.cxo = c.a((a)n.cxu);
  }
  
  private final a acu() {
    b b1 = this.cxn;
    e e1 = baf[0];
    return (a)b1.getValue();
  }
  
  private final ce acv() {
    b b1 = this.cxo;
    e e1 = baf[1];
    return (ce)b1.getValue();
  }
  
  private final void acw() {
    long l = System.currentTimeMillis();
    at at = new at((Context)RootApplication.zv());
    if (!at.Wt()) {
      at.a(true, l);
      at.close();
      (new ar.a((Context)RootApplication.zv(), String.valueOf(l), true)).start();
    } 
  }
  
  public final void acA() {
    d d = d.bj((Context)RootApplication.zv());
    f.l(d, "provider");
    ReceiptPrintSettings receiptPrintSettings = d.aef();
    f.l(receiptPrintSettings, "settings");
    if (receiptPrintSettings.aiw() != 3) {
      receiptPrintSettings.iQ(3);
      d.b(receiptPrintSettings);
    } 
  }
  
  @NotNull
  public final w acB() { return this.cxp; }
  
  public void acx() { acv().a(5L, TimeUnit.SECONDS, (ce.a)new m(this)); }
  
  public void acy() { acv().cancel(); }
  
  public boolean acz() {
    if (!bd.bH((Context)RootApplication.zv())) {
      b b1 = (b)this;
      n.eP(2131627849);
      return false;
    } 
    return true;
  }
  
  public void fv(boolean paramBoolean) {
    if (!acz())
      return; 
    n.e((Callable)new j(this)).f(a.aKh()).e(a.aJo()).a((g)new k(this, paramBoolean), (g)l.cxt);
  }
  
  public void kg(@NotNull String paramString) {
    f.m(paramString, "userPhone");
    if (!acz())
      return; 
    this.cxp.acF();
    n.e((Callable)new d(this, paramString)).f(a.aKh()).e(a.aJo()).a((g)new e(this, paramString), (g)new f(this));
  }
  
  public void kh(@NotNull String paramString) {
    f.m(paramString, "userPhone");
    if (!acz())
      return; 
    n.e((Callable)new g(this, paramString)).f(a.aKh()).e(a.aJo()).a((g)new h(this), (g)new i(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\advertisement\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */