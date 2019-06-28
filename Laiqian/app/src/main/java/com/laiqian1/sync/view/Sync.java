package com.laiqian.sync.view;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.sync.a.a;
import com.laiqian.sync.a.f;
import com.laiqian.sync.b.b;
import com.laiqian.sync.c.a;
import com.laiqian.sync.model.SyncProgessMessage;
import com.laiqian.sync.model.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.laiqian.util.z;
import com.umeng.analytics.MobclickAgent;
import hugo.weaving.DebugLog;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;

public class Sync extends ActivityRoot {
  public static int dqi = SyncProgessMessage.doZ;
  
  protected String TAG = Sync.class.getSimpleName();
  
  r.a aCA = new t(this);
  
  r aCz;
  
  protected Button aGS;
  
  private View azH;
  
  View.OnClickListener azO = new q(this);
  
  long bJx;
  
  Timer bxH = null;
  
  long cfe;
  
  public int cff = 0;
  
  private TextView cgl;
  
  private TextView cgm;
  
  private ImageView cgn;
  
  private ImageView cgo;
  
  private RotateAnimation cgu = null;
  
  protected Button dqb;
  
  private TextView dqc;
  
  protected TextView dqd;
  
  private a dqe;
  
  protected LinearLayout dqf;
  
  protected LinearLayout dqg;
  
  protected LinearLayout dqh;
  
  Handler dqj = new p(this);
  
  View.OnClickListener dqk = new r(this);
  
  View.OnClickListener dql = new s(this);
  
  boolean dqm = false;
  
  public int message = 0;
  
  public int nProgress = 0;
  
  private Handler uiHandler = new k(this);
  
  private void XV() {
    this.dqm = false;
    this.uiHandler.removeMessages(1);
    if (this.bxH != null) {
      this.bxH.cancel();
      this.bxH = null;
    } 
  }
  
  private void ZI() {
    if (this.cgu == null) {
      bb.fU("同步圆形进度条开始转动");
      this.cgu = new RotateAnimation(0.0F, 358.0F, true, 0.5F, true, 0.5F);
      this.cgu.setFillAfter(true);
      this.cgu.setDuration(800L);
      this.cgu.setInterpolator(new LinearInterpolator());
      this.cgu.setRepeatCount(-1);
      this.cgn.startAnimation(this.cgu);
    } 
  }
  
  private void ZJ() {
    if (this.cgu != null) {
      bb.fU("同步圆形进度条关闭");
      this.cgn.clearAnimation();
      this.cgu = null;
    } 
  }
  
  private boolean apQ() {
    boolean bool = bd.bH(this);
    if (!bool) {
      if (this.dqg.getVisibility() == 8)
        this.dqg.setVisibility(0); 
      bd.bX(this);
      return bool;
    } 
    if (this.dqg.getVisibility() == 0)
      this.dqg.setVisibility(8); 
    return bool;
  }
  
  private void apS() { this.dqj.sendMessageDelayed(Message.obtain(), 1000L); }
  
  private void apT() {
    sendBroadcast(new Intent("pos_change_account"));
    getLaiqianPreferenceManager();
    Intent intent = new Intent();
    intent.setClass(this, com.laiqian.login.view.LoginActivity.class);
    startActivity(intent);
    finish();
  }
  
  private void apU() {
    XV();
    this.dqm = true;
    this.bxH = new Timer();
    this.bxH.schedule(new l(this), 0L, 32L);
  }
  
  private void apV() {
    IntentFilter intentFilter = new IntentFilter();
    this.dqe = new a(this, null);
    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.dqe, intentFilter);
  }
  
  private void apl() {
    av av = new av(this);
    b b = new b(this);
    b.gO(av.Ea());
    av.close();
    b.close();
  }
  
  private void promptBeforeQuit() {
    if (this.dqm) {
      if (this.aCz == null) {
        this.aCz = new r(this, 2, this.aCA);
        this.aCz.setTitle(getString(2131625621));
        this.aCz.arm().setTextColor(getResources().getColor(2131099813));
        this.aCz.arn().setTextColor(getResources().getColor(2131099898));
        this.aCz.s(getString(2131629909));
      } 
      this.aCz.show();
      return;
    } 
    finish();
  }
  
  private void startSync() {
    apU();
    if (!apQ())
      return; 
    if (apR()) {
      ZI();
      Zp();
      bb.fU("同步页面开始同步");
      a.aKh().r(new i(this));
    } 
  }
  
  private void wZ() {
    this.azH = findViewById(2131299878);
    this.aGS = (Button)findViewById(2131299879);
    this.dqc = (TextView)findViewById(2131299123);
    this.cgn = (ImageView)findViewById(2131298616);
    this.cgo = (ImageView)findViewById(2131298619);
    this.cgl = (TextView)findViewById(2131298618);
    this.cgm = (TextView)findViewById(2131299124);
    this.dqf = (LinearLayout)findViewById(2131299128);
    this.dqg = (LinearLayout)findViewById(2131299132);
  }
  
  private void xa() {
    this.azH.setOnClickListener(this.azO);
    this.aGS.setOnClickListener(this.dql);
    this.aGS.setVisibility(0);
    this.dqf.setOnClickListener(this.dqk);
    this.dqg.setOnClickListener(new j(this));
  }
  
  private void xb() {
    ((TextView)findViewById(2131299889)).setText(getString(2131626959));
    this.aGS.setText(getString(2131629907));
  }
  
  public void Zp() { gH(1); }
  
  @DebugLog
  public void Zr() {
    this.dqf.setClickable(true);
    ZJ();
    this.cgn.setVisibility(8);
    this.aGS.setClickable(true);
    this.aGS.setTextColor(getResources().getColor(2131099936));
    this.cgm.setVisibility(4);
    av av = new av(this);
    av.ds(this.cfe);
    av.close();
  }
  
  @DebugLog
  public void Zs() {
    this.cgo.setVisibility(0);
    this.cgo.setImageResource(2131231929);
    this.cgl.setText("");
    apS();
    bb.e("_Sync", "同步页面同步成功");
  }
  
  protected boolean apR() {
    this.cfe = System.currentTimeMillis();
    this.bJx = -1L;
    return (this.bJx <= this.cfe);
  }
  
  public void gH(int paramInt) {
    dqi = paramInt;
    TextView textView = this.cgl;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("%");
    textView.setText(stringBuilder.toString());
    this.cgn.setVisibility(0);
    this.cgo.setVisibility(8);
    this.aGS.setClickable(false);
    this.aGS.setTextColor(getResources().getColor(2131099959));
    this.cgm.setVisibility(4);
    this.dqf.setClickable(false);
  }
  
  public void gI(int paramInt) {
    this.cgo.setVisibility(0);
    this.cgo.setImageResource(2131231924);
    this.cgl.setText("");
    apS();
    if (paramInt == -2) {
      Toast.makeText(this, getString(2131625524), 0).show();
      apl();
      apT();
    } else if (paramInt == -1) {
      Toast.makeText(this, getString(2131625525), 0).show();
      apl();
      apT();
    } 
    bb.e("_Sync", "同步页面同步失败");
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    MobclickAgent.onEvent(this, "sync");
    requestWindowFeature(7);
    setContentView(2131428135);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    xb();
    apV();
  }
  
  public void onDestroy() {
    if (this.dqe != null)
      unregisterReceiver(this.dqe); 
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getRepeatCount() > 0)
      return false; 
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      promptBeforeQuit();
      return false;
    } 
    return false;
  }
  
  public void onPause() {
    super.onPause();
    MobclickAgent.onPause(this);
    MobclickAgent.onPageStart("laiqian_android_sync_activity");
    ZJ();
  }
  
  public void onResume() {
    super.onResume();
    MobclickAgent.onResume(this);
    MobclickAgent.onPageStart("laiqian_android_sync_activity");
    av av = new av(this);
    long l = av.atE();
    av.close();
    if (l > 0L) {
      TextView textView = this.dqc;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l);
      stringBuilder.append("");
      textView.setText(getString(2131629896, new Object[] { z.e(stringBuilder.toString(), this) }));
    } else {
      this.dqc.setVisibility(4);
    } 
    apQ();
    startSync();
  }
  
  @DebugLog
  protected void onStart() { super.onStart(); }
  
  class Sync {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\sync\view\Sync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */