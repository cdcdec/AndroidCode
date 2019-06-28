package com.laiqian.crash.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.multidex.a;
import android.webkit.WebView;
import b.aa;
import b.b.a;
import b.k;
import com.alipay.euler.andfix.patch.PatchManager;
import com.d.a.a.a.a.b;
import com.d.a.a.a.b.c;
import com.d.a.b.a.g;
import com.d.a.b.d;
import com.d.a.b.e;
import com.d.a.c.g;
import com.google.a.a.a.a.a.a;
import com.jakewharton.a.a;
import com.laiqian.auth.bd;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.h.a;
import com.laiqian.i.a;
import com.laiqian.i.d;
import com.laiqian.message.e;
import com.laiqian.message.j;
import com.laiqian.message.k;
import com.laiqian.models.h;
import com.laiqian.network.c;
import com.laiqian.network.f;
import com.laiqian.network.j;
import com.laiqian.network.n;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.b;
import com.laiqian.online.h;
import com.laiqian.opentable.h;
import com.laiqian.ordertool.d;
import com.laiqian.pos.hardware.q;
import com.laiqian.pos.hold.e;
import com.laiqian.print.j;
import com.laiqian.print.model.g;
import com.laiqian.print.model.type.b.b;
import com.laiqian.print.printtype.a;
import com.laiqian.print.printtype.g;
import com.laiqian.print.printtype.r;
import com.laiqian.sync.a.a;
import com.laiqian.takeaway.az;
import com.laiqian.util.n;
import com.orhanobut.logger.b;
import com.orhanobut.logger.d;
import com.squareup.a.ab;
import com.squareup.moshi.am;
import com.zhuge.analysis.b.a;
import io.reactivex.f.a;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import retrofit2.a.a.a;
import retrofit2.v;

@SuppressLint({"NewApi"})
public class CrashApplication extends RootApplication {
  public static final Class aMW = com.laiqian.main.PosActivity.class;
  
  private PatchManager aMX;
  
  protected boolean aMY = false;
  
  public long nanoTime = 0L;
  
  private void CH() {
    j.cCx.a(new r(zv()));
    j.cCx.a(new a());
    j.cCx.a(new g(zv()));
    j.cCx.a(new bd(zv()));
    j.cCx.a(new h(zv()));
    j.cCx.a(new az(zv()));
  }
  
  private void CI() {}
  
  private void CJ() { d.aXE = (new am.a()).a(a.aXC).bc(new OnlineSyncRequest.b.a()).bc(new h.a()).bc(new h.b.a()).bc(new h.e.a()).bc(new h.a.a()).bc(new h.c.a()).aAd(); }
  
  private void CK() { n.bUo = (new v.a()).a(j.adg).vX("http://interface.91laiqian.com").a(new c()).a(a.b(d.aXE)).aZh(); }
  
  private void CL() { ab.a((new ab.a(this)).d(Bitmap.Config.RGB_565).a(new a(j.adg)).aAv()); }
  
  private static void CM() {
    j.a a = new j.a();
    a.gs(q.cmD).gt(q.cmE).gr(q.cmC).gu(q.cmF).gv(q.bIz).gw("PAY_NOTIFY").gA("http://pre-channel.91laiqian.com/mns/device-login").gx(q.bID).gz(q.cmH);
    int i = q.zp();
    if (i != 9) {
      switch (i) {
        default:
          a.gy("91laiqian-odd-month");
          break;
        case 4:
        case 5:
          a.gy("91laiqian-singapore");
          break;
      } 
      j.bIw = a.Tq();
      return;
    } 
  }
  
  private static void CN() {
    b.a a = new b.a();
    a.iK(q.cla).ev(false);
    b.bXI = a.Xe();
  }
  
  private void CO() {
    this.aIW = new k(this, (new k.a.a()).a((new e.a()).b(2L, TimeUnit.SECONDS).To()).Tu());
    this.aIW.a(new e(this));
    this.aIW.a(new f(this));
    this.aIW.a(new g(this));
    this.aIW.a(new h(this));
    this.aIW.a(new i(this));
    this.aIW.a(new j(this));
    this.aIW.a(new c(this));
  }
  
  public static void S(Context paramContext) {
    File file = g.N(paramContext, "/laiqian/ImageCache/");
    e.a a = new e.a(paramContext);
    a.mu(3);
    a.ayT();
    a.a(new c());
    a.a(g.dQJ);
    a.a(new b(file));
    d.ayO().a(a.ayU());
  }
  
  protected void attachBaseContext(Context paramContext) {
    super.attachBaseContext(paramContext);
    a.k(this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    n.aL(this);
    super.onConfigurationChanged(paramConfiguration);
    if (!n.bL(zv()))
      Locale.setDefault(Locale.US); 
  }
  
  public void onCreate() {
    super.onCreate();
    CM();
    CN();
    new d(this);
    k.CP().init(getApplicationContext());
    aIQ = 1;
    n.aL(this);
    S(getApplicationContext());
    d.azE().a(b.dRH);
    e.aU(this);
    if (Build.VERSION.SDK_INT >= 19)
      WebView.setWebContentsDebuggingEnabled(true); 
    g.cGS.init(this);
    if (Build.MODEL.equals("Q11"))
      b.cHR = 20; 
    try {
      this.aMX = new PatchManager(getApplicationContext());
      PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
      this.aMX.init(packageInfo.versionName);
      this.aMX.loadPatch();
    } catch (Exception exception) {
      a.e(exception);
    } 
    if (!n.bL(zv()))
      Locale.setDefault(Locale.US); 
    CJ();
    CK();
    CL();
    CI();
    CH();
    a.dob.a(new d(this));
    a.aAU().aAW();
    a.aAU().aAV();
    a.init(zv());
    a.f(a.aEp);
    CO();
    zD();
  }
  
  protected void zD() { // Byte code:
    //   0: aload_0
    //   1: new com/laiqian/pos/hardware/a/b
    //   4: dup
    //   5: invokespecial <init> : ()V
    //   8: putfield aIX : Lcom/laiqian/pos/hardware/a/b;
    //   11: ldc_w 'persist.sys.model'
    //   14: ldc_w 'unknown'
    //   17: invokestatic get : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual hashCode : ()I
    //   25: istore_1
    //   26: iload_1
    //   27: ldc_w 81362
    //   30: if_icmpeq -> 58
    //   33: iload_1
    //   34: ldc_w 2329109
    //   37: if_icmpeq -> 43
    //   40: goto -> 73
    //   43: aload_2
    //   44: ldc_w 'LB10'
    //   47: invokevirtual equals : (Ljava/lang/Object;)Z
    //   50: ifeq -> 73
    //   53: iconst_0
    //   54: istore_1
    //   55: goto -> 75
    //   58: aload_2
    //   59: ldc_w 'S21'
    //   62: invokevirtual equals : (Ljava/lang/Object;)Z
    //   65: ifeq -> 73
    //   68: iconst_1
    //   69: istore_1
    //   70: goto -> 75
    //   73: iconst_m1
    //   74: istore_1
    //   75: iload_1
    //   76: tableswitch default -> 100, 0 -> 116, 1 -> 101
    //   100: return
    //   101: aload_0
    //   102: getfield aIX : Lcom/laiqian/pos/hardware/a/b;
    //   105: new com/laiqian/pos/hardware/a/g
    //   108: dup
    //   109: invokespecial <init> : ()V
    //   112: invokevirtual a : (Lcom/laiqian/pos/hardware/a/a;)V
    //   115: return
    //   116: aload_0
    //   117: getfield aIX : Lcom/laiqian/pos/hardware/a/b;
    //   120: new com/laiqian/pos/hardware/a/h
    //   123: dup
    //   124: invokespecial <init> : ()V
    //   127: invokevirtual a : (Lcom/laiqian/pos/hardware/a/a;)V
    //   130: return }
  
  protected aa zF() {
    a a = new a();
    a.a(a.a.flk);
    j.adg = (new aa.a()).jl(false).a(a).a(new f()).k(1L, TimeUnit.MINUTES).l(1L, TimeUnit.MINUTES).m(1L, TimeUnit.MINUTES).b(new k(false, 1L, TimeUnit.SECONDS)).aSM();
    return j.adg;
  }
  
  @NonNull
  protected LQKVersion.a zz() { return new b(this); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\model\CrashApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */