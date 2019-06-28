package com.laiqian.pos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.github.moduth.blockcanary.c;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.db.b;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.models.an;
import com.laiqian.models.at;
import com.laiqian.models.h;
import com.laiqian.opentable.common.b;
import com.laiqian.print.dualscreen.a;
import com.laiqian.report.models.a;
import com.laiqian.sync.a.g;
import com.laiqian.sync.c.a;
import com.laiqian.sync.model.SyncProgessMessage;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.util.p;
import com.umeng.analytics.MobclickAgent;
import hugo.weaving.DebugLog;
import io.reactivex.g.a;
import java.io.IOException;
import java.util.Timer;

@SuppressLint({"NewApi"})
public class PosDownloaderAfterLogin extends ActivityRoot {
  private Button aGS;
  
  private View azH;
  
  private long bJx = -1L;
  
  private TextView bLV;
  
  private long cfe = -1L;
  
  public int cff = 0;
  
  private Class<?> cgi;
  
  private TextView cgj;
  
  private int cgk = 0;
  
  private TextView cgl;
  
  private TextView cgm;
  
  private ImageView cgn;
  
  private ImageView cgo;
  
  private final int cgp = 60000;
  
  String cgq = "";
  
  Timer cgr = null;
  
  private e cgs;
  
  private String cgt = null;
  
  RotateAnimation cgu = null;
  
  private boolean cgv = false;
  
  Handler cgw = new bf(this);
  
  public int message = 0;
  
  public int nProgress = 0;
  
  private g syncManager;
  
  private void XV() {
    if (this.cgr != null) {
      this.cgr.cancel();
      this.cgr = null;
    } 
  }
  
  private void ZF() {
    an.c c = (new an(this)).Vu();
    if (c == null || !a(c))
      this.cgi = com.laiqian.pos.settings.InitialSettingsActivity.class; 
  }
  
  private void ZG() {
    ZI();
    (new b()).Z(this);
    a.aKh().r(new ay(this));
  }
  
  private void ZH() {
    at at = new at(this);
    boolean bool1 = at.Wr();
    at.close();
    if (this.cgi == null) {
      MobclickAgent.reportError(this, "PosDownloaderAfterLogin.intentPage is null. Error happened.");
      this.cgi = p.bP(this);
    } 
    if (this.cgk == 0)
      ZF(); 
    boolean bool2 = a.zR().Ab();
    if (!bool1 && n.bL(CrashApplication.zv()) && !bool2)
      this.cgi = com.laiqian.login.view.AgreementActivity.class; 
    Intent intent = new Intent();
    intent.setClass(this, this.cgi);
    startActivity(intent);
    overridePendingTransition(2130771979, 2130771980);
    finish();
  }
  
  private void ZI() {
    if (this.cgu == null) {
      this.cgu = new RotateAnimation(0.0F, 358.0F, true, 0.5F, true, 0.5F);
      this.cgu.setFillAfter(true);
      this.cgu.setDuration(800L);
      this.cgu.setInterpolator(new LinearInterpolator());
      this.cgu.setRepeatCount(-1);
    } 
    this.cgn.startAnimation(this.cgu);
  }
  
  private void ZJ() {
    if (this.cgu != null) {
      this.cgn.clearAnimation();
      this.cgu = null;
    } 
  }
  
  private void ZK() {
    IntentFilter intentFilter = new IntentFilter();
    if (this.cgs == null)
      this.cgs = new e(this, null); 
    intentFilter.addAction("logout");
    registerReceiver(this.cgs, intentFilter);
  }
  
  private boolean a(an.c paramc) {
    if (TextUtils.isEmpty(paramc.aVs))
      return false; 
    if (paramc.bSp == 0)
      return false; 
    if (by.isNull(paramc.bSq))
      return false; 
    if (!a.zR().Ad()) {
      if (TextUtils.isEmpty(paramc.aWV))
        return false; 
      h.e e1 = (h.e)h.aM(this).UJ().UM().get(paramc.bSu);
      if (e1 == null)
        return false; 
      h.a a = (h.a)e1.UO().get(paramc.bSv);
      if (a == null)
        return false; 
      if ((h.c)a.UK().get(paramc.bSw) == null)
        return false; 
    } 
    return true;
  }
  
  private void xb() {
    this.cfe = System.currentTimeMillis();
    this.bJx = 0L;
    this.syncManager = new g(this);
    this.syncManager.a(new az(this));
  }
  
  public void Zp() {
    this.nProgress = this.syncManager.apy().getProgress();
    this.cff = this.syncManager.apy().apH();
    this.message = this.syncManager.apy().apI();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("当前进度是: ");
    stringBuilder.append(this.nProgress);
    bb.fU(stringBuilder.toString());
    if (this.nProgress > SyncProgessMessage.COMPLETE)
      return; 
    if (this.nProgress == SyncProgessMessage.START) {
      Zq();
      return;
    } 
    if (this.nProgress == SyncProgessMessage.COMPLETE) {
      if (this.cff == 1) {
        Zs();
      } else if (this.cff == 0) {
        gI(this.message);
      } 
      Zr();
      return;
    } 
    gH(this.nProgress);
  }
  
  public void Zq() {
    this.cgo.setVisibility(8);
    this.cgl.setText(getString(2131625621));
  }
  
  public void Zr() {
    if (this.syncManager != null)
      this.syncManager.apy().gW(false); 
    this.cgm.setVisibility(4);
    this.cgn.setVisibility(8);
    ZJ();
    XV();
    ZH();
  }
  
  public void Zs() {
    this.cgo.setImageResource(2131231929);
    this.cgo.setVisibility(0);
    this.cgl.setText("");
    Toast.makeText(this, getString(2131629886), 1).show();
  }
  
  public void gH(int paramInt) {
    this.cgm.setVisibility(4);
    TextView textView = this.cgl;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("%");
    textView.setText(stringBuilder.toString());
    this.cgn.setVisibility(0);
    this.cgo.setVisibility(8);
  }
  
  public void gI(int paramInt) {
    this.cgo.setImageResource(2131231924);
    this.cgo.setVisibility(0);
    this.cgl.setText("");
    Toast.makeText(this, getString(2131629885), 1).show();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427862);
    getWindow().setFeatureInt(7, 2131428168);
    this.azH = findViewById(2131299878);
    this.aGS = (Button)findViewById(2131299879);
    this.cgl = (TextView)findViewById(2131298618);
    this.azH.setClickable(false);
    (this.azH.getLayoutParams()).width = -1;
    this.azH.findViewById(2131298460).setVisibility(8);
    this.aGS.setText(2131626735);
    this.cgn = (ImageView)findViewById(2131298616);
    this.cgm = (TextView)findViewById(2131299124);
    this.cgo = (ImageView)findViewById(2131298619);
    this.bLV = (TextView)findViewById(2131299889);
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.bLV.getLayoutParams();
    marginLayoutParams.width = -1;
    marginLayoutParams.leftMargin = 0;
    marginLayoutParams.rightMargin = 0;
    this.bLV.setGravity(17);
    this.cgj = (TextView)findViewById(2131299277);
    this.bLV.setText(getString(2131625621));
    xb();
    ZK();
    (new c(this, null)).execute(new Void[0]);
    (new b(this, null)).execute(new Void[0]);
    if (!a.zR().Ad()) {
      av = new av(this);
      String str = av.Tx();
      boolean bool = av.rw(str);
      try {
        a = a.lb(str);
        if (a.size() == 0 && bool) {
          String[] arrayOfString = getResources().getStringArray(2130903050);
          try {
            int i = arrayOfString.length;
            for (byte b = 0; b < i; b++) {
              String str1 = arrayOfString[b];
              a.m(getAssets().open(str1));
            } 
          } catch (IOException a) {
            a.e(a);
          } 
          av.D(str, false);
        } 
        av.close();
      } catch (Exception av) {
        ActivityRoot activityRoot = getActivity();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("failed to prepare default pictures: ");
        stringBuilder.append(av.getMessage());
        Toast.makeText(activityRoot, stringBuilder.toString(), 0).show();
      } 
    } 
    (new d(this, null)).execute(new Void[0]);
    if (a.zR().Ae())
      (new a(this, null)).execute(new Void[0]); 
    b.Xw();
  }
  
  public void onDestroy() {
    if (this.cgs != null)
      unregisterReceiver(this.cgs); 
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) { return (paramKeyEvent.getRepeatCount() > 0) ? false : ((paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) ? false : false); }
  
  protected void onPause() {
    MobclickAgent.onPause(this);
    super.onPause();
  }
  
  protected void onResume() {
    super.onResume();
    MobclickAgent.onResume(this);
    try {
      this.cgk = getIntent().getIntExtra("SyncIntentExtraName", 0);
    } catch (Exception exception) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("当前页面请求类型");
    stringBuilder.append(this.cgk);
    bb.fU(stringBuilder.toString());
    this.aGS.setVisibility(0);
    this.aGS.setOnClickListener(new bd(this));
    switch (this.cgk) {
      default:
        this.cgi = p.bP(this);
        return;
      case 3:
        (new a.a()).ams();
        dj.ciW.aad();
      case 2:
        this.cgi = com.laiqian.login.view.LoginActivity.class;
        this.cgj.setVisibility(0);
        this.cgq = getString(2131629642);
        this.cgw.sendEmptyMessage(0);
        this.cgj.setText(this.cgq);
        dj.ciW.aad();
        return;
      case 1:
        (new a.a()).ams();
        this.cgi = com.laiqian.login.view.LoginActivity.class;
        this.cgw.sendEmptyMessage(0);
        this.cgj.setVisibility(4);
        RootApplication.zv().zB().stop();
        dj.ciW.aad();
        return;
      case 0:
        break;
    } 
    this.cgi = p.bP(this);
    this.cgj.setVisibility(4);
    (new dn(this)).start();
    if (CrashApplication.getLaiqianPreferenceManager().avJ())
      c.a(getApplicationContext(), new be(this)).start(); 
    RootApplication.zv().zB().start();
    ZH();
  }
  
  @DebugLog
  protected void onStart() { super.onStart(); }
  
  protected void onStop() {
    super.onStop();
    XV();
  }
  
  class PosDownloaderAfterLogin {}
  
  class PosDownloaderAfterLogin {}
  
  class PosDownloaderAfterLogin {}
  
  class PosDownloaderAfterLogin {}
  
  class PosDownloaderAfterLogin {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\PosDownloaderAfterLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */