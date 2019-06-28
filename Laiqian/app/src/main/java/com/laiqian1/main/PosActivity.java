package com.laiqian.main;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.assistne.icondottextview.IconDotTextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.auth.cj;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.dcb.api.b.j;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.entity.aa;
import com.laiqian.entity.an;
import com.laiqian.entity.aq;
import com.laiqian.entity.j;
import com.laiqian.entity.u;
import com.laiqian.entity.z;
import com.laiqian.l.a;
import com.laiqian.main.module.hardware.cardreader.PosActivityCardReaderFragment;
import com.laiqian.main.module.hardware.dualscreen.PosActivityDualscreenFragment;
import com.laiqian.main.module.hardware.print.PosActivityPrinterStatusFragment;
import com.laiqian.main.module.hardware.weight.PosActivityScaleFragment;
import com.laiqian.main.module.hardware.weight.c;
import com.laiqian.main.module.misc.PosActivityMoreSettingsFragment;
import com.laiqian.main.module.opentable.PosActivityOpenTableFragment;
import com.laiqian.main.module.pendingorder.PosActivityPendingOrderFragment;
import com.laiqian.main.module.productattr.PosActivityProductAttributeFragment;
import com.laiqian.main.module.productcart.PosActivityProductCartFragment;
import com.laiqian.main.module.productcode.PosActivityProductCodeFragment;
import com.laiqian.main.module.productpool.PosActivityProductPoolFragment;
import com.laiqian.main.module.producttype.PosActivityProductTypeFragment;
import com.laiqian.main.module.setting.PosActivitySettingFragment;
import com.laiqian.main.module.settlement.PosActivitySettlementFragment;
import com.laiqian.main.module.takeaway.PosActivityTakeAwayFragment;
import com.laiqian.main.module.vip.PosActivityVipFragment;
import com.laiqian.meituan.t;
import com.laiqian.message.m;
import com.laiqian.models.at;
import com.laiqian.network.m;
import com.laiqian.network.receiver.a;
import com.laiqian.news.aa;
import com.laiqian.opentable.common.b;
import com.laiqian.pos.bg;
import com.laiqian.pos.hardware.b;
import com.laiqian.pos.help.c;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.print.dualscreen.o;
import com.laiqian.print.j;
import com.laiqian.print.model.g;
import com.laiqian.rx.b.l;
import com.laiqian.sync.a.a;
import com.laiqian.sync.a.l;
import com.laiqian.sync.model.b;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.af;
import com.laiqian.ui.a.r;
import com.laiqian.util.ae;
import com.laiqian.util.ak;
import com.laiqian.util.av;
import com.laiqian.util.bt;
import com.laiqian.util.bu;
import com.laiqian.util.by;
import com.laiqian.util.logger.a;
import com.laiqian.util.logger.h;
import com.laiqian.util.n;
import com.umeng.analytics.MobclickAgent;
import com.zhuge.analysis.b.a;
import hugo.weaving.DebugLog;
import io.reactivex.a.a;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PosActivity extends ActivityRoot {
  BroadcastReceiver accountReceiver = new ab(this);
  
  private boolean baA;
  
  private boolean baB;
  
  private r baC;
  
  private SmsReceiver baD;
  
  private a baE = new a();
  
  private dl baF;
  
  b baG;
  
  private af baH;
  
  private t baI;
  
  l baJ = new an(this);
  
  BroadcastReceiver baK = new aa(this);
  
  BroadcastReceiver baL = new ac(this);
  
  BroadcastReceiver baM = new af(this);
  
  a baN;
  
  c baO = new g(this);
  
  PosActivityOpenTableFragment bay;
  
  private boolean baz;
  
  private CharSequence KN() {
    String str1 = getString(2131625954);
    String str2 = getString(2131624445);
    bt.a a1;
    bt.a a2 = (a1 = bt.a.mj(getResources().getColor(2131100021))).mj(getResources().getColor(2131100024));
    return bt.a("%s<br>%s", new String[] { str1, str2 }, new bt.a[] { a1, a2 });
  }
  
  private void KO() {
    this.baG.baZ.bbf.setText("");
    this.baG.baZ.bbf.aI(ae.b(this, 36.0F), ae.b(this, 72.0F));
  }
  
  private void KP() { this.baG.baZ.bbf.setText(""); }
  
  private void KQ() { this.baE.b(this.baF.bee.b(new r(this))); }
  
  private void KR() {
    eM(0);
    this.baG.baZ.bbf.setOnClickListener(new aj(this));
    Lb();
  }
  
  private void KS() { this.baG.baZ.bbh.setOnClickListener(new ak(this)); }
  
  private void KV() {
    this.baG.bbc.setOnTouchListener(new al(this));
    a(this.baO);
    this.baF.bea.beZ.b(new s(this));
    this.baF.bem.bex.b(new t(this));
    this.baF.bem.bey.b(new u(this));
    this.baF.bem.beB.i(150L, TimeUnit.MILLISECONDS).b(new v(this));
  }
  
  private void KW() {
    if (j.k(getBaseContext(), ServerService.class.getName()))
      ServerService.ae(getBaseContext()); 
    if (a.AZ().Bd())
      ServerService.aa(getBaseContext()); 
  }
  
  private void KX() {
    this.baF.bel.beK.b(l.bu(getActivity()));
    if (a.zR().Ac())
      KO(); 
    if (!getResources().getBoolean(2131034123))
      KP(); 
    if ((getResources().getBoolean(2131034125) && getResources().getBoolean(2131034128)) || a.zR().zX())
      KR(); 
    KS();
    KV();
    KW();
    null = a.WR();
    null.c(getApplicationContext(), 3600000L);
    null.start();
    null = m.WP();
    null.c(getApplicationContext(), 3600000L);
    null.start();
    aa = aa.Xb();
    aa.c(getApplicationContext(), 5000L);
    aa.start();
    KY();
    if (getLaiqianPreferenceManager().atQ() == 0L)
      getLaiqianPreferenceManager().du(System.currentTimeMillis()); 
    this.baE.b(this.baF.bdS.b(new w(this)));
    this.baE.b(this.baF.bdS.b(new x(this)));
    Lk();
    KZ();
    try {
      b.ckg.aam();
      return;
    } catch (Exception aa) {
      a.e(aa);
      return;
    } 
  }
  
  private void KY() {
    if ("0".equals(getLaiqianPreferenceManager().atO())) {
      getLaiqianPreferenceManager().dt(System.currentTimeMillis() - 1L);
      bg bg = new bg(this, 2131690280);
      bg.setContentView(View.inflate(this, 2131427870, null));
      bg.show();
    } 
  }
  
  private void KZ() {
    intentFilter = new IntentFilter();
    intentFilter.addAction("pos_activity_change_data_all");
    intentFilter.addAction("pos_activity_order_change");
    intentFilter.addAction("pos_shut_down");
    intentFilter.addAction("pos_activity_change_data_paytype");
    intentFilter.addAction("pos_activity_change_data_order_type");
    intentFilter.addAction("accept_customer_message_notification");
    try {
      registerReceiver(this.baK, intentFilter);
    } catch (Exception intentFilter) {
      a.e(intentFilter);
    } 
    try {
      registerReceiver(this.accountReceiver, new IntentFilter("pos_change_account"));
    } catch (Exception intentFilter) {
      a.e(intentFilter);
    } 
    try {
      registerReceiver(this.baL, new IntentFilter("action_meituan_phone_number_error_orders"));
    } catch (Exception intentFilter) {
      a.e(intentFilter);
    } 
    try {
      registerReceiver(this.baM, new IntentFilter("action_openbox"));
      return;
    } catch (Exception intentFilter) {
      a.e(intentFilter);
      return;
    } 
  }
  
  private void La() {
    try {
      unregisterReceiver(this.baK);
      unregisterReceiver(this.accountReceiver);
      unregisterReceiver(this.baL);
      unregisterReceiver(this.baM);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private void Lb() {
    long l1 = getLaiqianPreferenceManager().auV();
    (new c(new am(this))).cr(l1);
  }
  
  private void Lc() {
    this.baF.bef.accept(Boolean.valueOf(true));
    this.baF.a(fg.Ml());
    cj cj = new cj(this);
    Boolean[] arrayOfBoolean = cj.yO();
    cj.close();
    arrayOfBoolean[1].booleanValue();
    de(true);
  }
  
  @SuppressLint({"CheckResult"})
  private void Ld() {
    Log.d("PosActivity", "checkSyncResult() called");
    b.a(RootApplication.getLaiqianPreferenceManager().Tx(), a.aKh()).c(y.aEp).e(a.aJo()).b(i.aEo).a(new j(this), new k(this));
  }
  
  private boolean Le() {
    av av = getLaiqianPreferenceManager();
    if (av.aue() || av.auF()) {
      Intent intent = new Intent();
      intent.setClass(this, com.laiqian.pos.PosDownloaderAfterLogin.class);
      if (av.aue())
        intent.putExtra("SyncIntentExtraName", 2); 
      if (av.auF()) {
        intent.putExtra("SyncIntentExtraName", 1);
        try {
          stopService(new Intent(this, com.laiqian.print.dualscreen.DualScreenService.class));
        } catch (Exception exception) {
          a.e(exception);
        } 
      } 
      av.hx(false);
      av.hD(false);
      startActivity(intent);
      return true;
    } 
    return false;
  }
  
  private void Lf() {
    at at = new at(this);
    this.baF.bdP.accept(Boolean.valueOf(at.em(false)));
    this.baF.LU();
    at.close();
  }
  
  private void Lg() {
    Intent intent = new Intent();
    intent.setClass(getActivity(), com.laiqian.login.view.LoginActivity.class);
    intent.putExtra("SyncIntentExtraName", 1);
    intent.setFlags(32768);
    startActivity(intent);
    if (!isFinishing())
      finish(); 
  }
  
  private void Li() {
    av av = new av(this);
    String str1 = av.atR();
    String str2 = av.atp();
    av.close();
    if ("150001".equals(str2) || "".equals(str1)) {
      sendBroadcast(new Intent("android.intent.money_test.action"));
      runtime = Runtime.getRuntime();
      try {
        runtime.exec("echo 0 > /sys/devices/platform/att_test/test");
      } catch (IOException runtime) {
        a.e(runtime);
      } 
      try {
        a.aKh().r(l.baQ);
      } catch (Exception runtime) {
        a.e(runtime);
      } 
      try {
        List list = j.cCx.a(new Object(), new String[] { "cash_drawer" });
        g.cGS.o(list);
        return;
      } catch (Exception runtime) {
        a.e(runtime);
      } 
    } 
  }
  
  private void Lj() {
    try {
      m.Tv();
      b.XA();
    } catch (Exception exception) {
      try {
        a.e(exception);
        Intent intent1 = new Intent();
        intent1.setClass(this, com.laiqian.pos.PosDownloaderAfterLogin.class);
        intent1.putExtra("SyncIntentExtraName", 1);
        startActivity(intent1);
      } catch (Exception exception) {
        a.e(exception);
      } 
    } 
    Intent intent = new Intent();
    intent.setClass(this, com.laiqian.pos.PosDownloaderAfterLogin.class);
    intent.putExtra("SyncIntentExtraName", 1);
    startActivity(intent);
  }
  
  private void Lk() {
    if (this.baD == null)
      this.baD = new SmsReceiver(this); 
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("SMS_QUANTITY_LEFT_RECEIVER");
    registerReceiver(this.baD, intentFilter);
  }
  
  private void Ll() {
    try {
      unregisterReceiver(this.baD);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private void Lm() {
    try {
      if (this.baF.bem.beC.wP())
        return; 
      ((PosActivitySettlementFragment)getSupportFragmentManager().findFragmentByTag("settle_legacy")).Mq();
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private void a(j paramj) {
    if ((paramj.EY().intValue() == 0 && paramj.EZ().longValue() > a.AZ().BR()) || (paramj.EY().intValue() == 1 && paramj.EZ().longValue() > a.AZ().BS())) {
      if (!n.D(getActivity(), PosActivity.class.getName()))
        return; 
      r r1 = new r(getActivity(), new ah(this, paramj));
      r1.setTitle(paramj.Fa());
      r1.s(paramj.oV());
      r1.t(getString(2131625208));
      r1.oZ(getString(2131626714));
      r1.setOnShowListener(new ai(this, paramj));
      if (n.D(getActivity(), PosActivity.class.getName()))
        r1.show(); 
      return;
    } 
  }
  
  private void a(a parama) { this.baN = parama; }
  
  private void a(@NonNull c paramc) { this.baG.bbb.bbd.setOnClickListener(new m(paramc)); }
  
  private void b(bb parambb, boolean paramBoolean) {
    this.baF.bea.beM.accept(u.an(a.AZ().Co()));
    this.baF.beb.accept(Integer.valueOf(0));
    this.baF.bem.beA.accept(new Object());
    Iterator iterator = parambb.bbS.iterator();
    double d;
    for (d = 0.0D; iterator.hasNext(); d += ((z)iterator.next()).aTw);
    this.baF.bea.ae(d);
    if (parambb.bbY != ((Double)this.baF.bea.beU.getValue()).doubleValue())
      this.baF.bea.beU.accept(Double.valueOf(parambb.bbY)); 
    if (paramBoolean)
      Li(); 
    if (parambb.vipEntity != null) {
      o o = o.afM();
      if (o != null)
        o.b(parambb.vipEntity, Double.valueOf(parambb.bco)); 
    } 
    if (CrashApplication.getLaiqianPreferenceManager().avA() && "150001".equals(CrashApplication.getLaiqianPreferenceManager().atp()) && (parambb.bcs || parambb.bct) && by.isNull(getLaiqianPreferenceManager().FC()) && by.isNull(getLaiqianPreferenceManager().FD())) {
      CrashApplication.getLaiqianPreferenceManager().hP(false);
      k(parambb.bcs, parambb.bct);
    } 
    b.ckg.aaj().c(Double.valueOf(Double.parseDouble(n.ba(d))));
    if (a.AZ().BE())
      c.MD().ag(d); 
    c(parambb);
  }
  
  private void c(bb parambb) {
    if (!((PendingFullOrderDetail.a)this.baF.bdQ.getValue()).equals(dl.ben) && !((Boolean)this.baF.bee.getValue()).booleanValue()) {
      a a1 = new a(this);
      a1.kj(((PendingFullOrderDetail.a)this.baF.bdQ.getValue()).orderNo);
      a1.close();
      this.baF.a(dl.ben);
    } else if (parambb.bcf == 15L && !TextUtils.isEmpty(parambb.bbQ)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("结算信息:单号");
      stringBuilder.append(parambb.orderNo);
      stringBuilder.append("，牌号");
      stringBuilder.append(parambb.bbQ);
      fg.eX(stringBuilder.toString());
    } 
    this.baF.bel.beH.accept(new Object());
    if (!parambb.bcr) {
      this.baF.bem.bex.accept(new Object());
      return;
    } 
    de(true);
  }
  
  private void de(boolean paramBoolean) {
    if (paramBoolean || this.baG.bbc.getVisibility() != 8) {
      this.baF.bea.Mi();
      if (((Boolean)this.baF.bee.getValue()).booleanValue()) {
        this.baF.Ma();
      } else {
        this.baF.LY();
      } 
      this.baF.c(aq.aWG);
      this.baF.bem.bey.accept(new Object());
    } 
  }
  
  private void eL(int paramInt) {
    ComponentName componentName = new ComponentName(this, com.laiqian.pos.industry.setting.MainSetting.class);
    Intent intent = new Intent();
    intent.setComponent(componentName);
    intent.putExtra("windowId", paramInt);
    startActivity(intent);
  }
  
  private void eM(int paramInt) {
    String str;
    IconDotTextView iconDotTextView = this.baG.baZ.bbf;
    if (paramInt > 99) {
      str = "99+";
    } else {
      str = String.valueOf(paramInt);
    } 
    iconDotTextView.m(str);
    if (paramInt <= 0) {
      this.baG.baZ.bbf.aZ(false);
      return;
    } 
    this.baG.baZ.bbf.aZ(true);
  }
  
  private void eN(int paramInt) {
    String str = new ae(this, paramInt);
    if ("150001".equals(CrashApplication.getLaiqianPreferenceManager().atp())) {
      this.baC = new r(this, str);
      this.baC.oZ(getString(2131624505));
      this.baC.t(getString(2131624538));
      String str1 = String.format(getResources().getString(2131629753), new Object[] { Integer.valueOf(paramInt) });
    } else {
      if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
        String str1 = String.format(getResources().getString(2131629754), new Object[] { Integer.valueOf(paramInt) });
      } else {
        String str1 = String.format(getResources().getString(2131629755), new Object[] { Integer.valueOf(paramInt) });
      } 
      this.baC = new r(this, 3, null);
      this.baC.pa(getString(2131624505));
    } 
    if (paramInt == 0)
      str = getString(2131629752); 
    this.baC.setTitle(getString(2131629766));
    this.baC.s(str);
    this.baC.show();
  }
  
  private void eO(String paramString) throws JSONException {
    if (TextUtils.isEmpty(paramString))
      return; 
    null = new JSONArray(paramString);
    ArrayList arrayList = new ArrayList();
    for (byte b1 = 0; b1 < null.length(); b1++) {
      JSONObject jSONObject = null.optJSONObject(b1);
      if (jSONObject != null)
        arrayList.add(j.cZ(jSONObject.toString())); 
    } 
    Iterator iterator = arrayList.iterator();
    while (iterator.hasNext())
      a((j)iterator.next()); 
  }
  
  private void k(boolean paramBoolean1, boolean paramBoolean2) {
    r r1 = new r(this, new ag(this, paramBoolean1, paramBoolean2));
    r1.setTitle(getString(2131625183));
    r1.arl();
    r1.s(KN());
    r1.arm().setText(getString(2131625903));
    r1.arn().setText(getString(2131625497));
    r1.show();
  }
  
  private void promptBeforeQuit() {
    r r1 = new r(this, new ad(this));
    r1.setTitle(getString(2131625532));
    r1.s(getString(2131628259));
    r1.arm().setText(getString(2131625529));
    r1.arn().setText(getString(2131625538));
    r1.show();
  }
  
  private void setOrderTypeID(String paramString) throws JSONException { this.baF.bea.beM.accept(paramString); }
  
  public void KT() {
    if (this.baH == null)
      this.baH = new af(this); 
    this.baH.show();
  }
  
  public void KU() {
    if (this.baI == null)
      this.baI = new t(this); 
    this.baI.show();
  }
  
  public void Lh() { this.baF.LT(); }
  
  public boolean beforeCloseActivity() {
    if (((Boolean)this.baF.bdU.getValue()).booleanValue()) {
      this.baF.bdU.accept(Boolean.FALSE);
      return true;
    } 
    if (this.baN != null && this.baN.beforeCloseActivity())
      return true; 
    promptBeforeQuit();
    return true;
  }
  
  @DebugLog
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    if (this.baG.bbc.getVisibility() == 0) {
      de(false);
      return true;
    } 
    this.baF.bel.beJ.accept(paramKeyEvent);
    return (paramKeyEvent.getKeyCode() == 4 || !a.AZ().Bm() || ((Boolean)this.baF.bdU.getValue()).booleanValue()) ? super.dispatchKeyEvent(paramKeyEvent) : 1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    this.baF.bel.beJ.accept(new KeyEvent(false, 111));
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void eP(String paramString) throws JSONException { setOrderTypeID(u.an(by.parseLong(paramString))); }
  
  @SuppressLint({"CheckResult"})
  protected void onCreate(Bundle paramBundle) {
    CrashApplication.zx();
    super.onCreate(null);
    bu bu = new bu(new a());
    bu.rY("start inflate");
    this.baG = b.b(getLayoutInflater());
    bu.rZ("end inflate");
    setContentView(this.baG.aQo);
    this.baF = new dl(getApplicationContext());
    fg.Mm();
    KX();
    Lc();
    getSupportFragmentManager().beginTransaction().add(new PosActivityPrinterStatusFragment(), "printer_status").add(new PosActivityProductPoolFragment(this.baF), "product_pool").add(new PosActivityProductTypeFragment(this.baF), "product_type").add(new PosActivityProductCartFragment(this.baF), "product_cart").add(new PosActivityProductAttributeFragment(this.baF), "product_attribute").add(new PosActivityProductCodeFragment(this.baF), "product_code").add(new PosActivityScaleFragment(this.baF), "scale").add(new PosActivityMoreSettingsFragment(this.baF), "more_setting").add(new PosActivitySettingFragment(this.baF), "setting").add(new PosActivityDualscreenFragment(this.baF), "dualscreen").add(new PosActivityCardReaderFragment(this.baF), "card_reader").add(new PosActivityTakeAwayFragment(this.baF), PosActivityTakeAwayFragment.TAG).add(new PosActivityVipFragment(this.baF), PosActivityVipFragment.TAG).add(new PosActivityPendingOrderFragment(this.baF), PosActivityPendingOrderFragment.TAG).add(new PosActivitySettlementFragment(this.baF), "settle_legacy").commit();
    KQ();
    this.baF.bel.beI.b(new h(this));
    this.baF.bek.b(new z(this));
    a.dob.a(this.baJ);
  }
  
  protected void onDestroy() {
    this.baE.wK();
    a.dob.b(this.baJ);
    super.onDestroy();
    Ll();
    La();
    an.Ij();
  }
  
  protected void onPause() {
    MobclickAgent.onPause(this);
    super.onPause();
  }
  
  protected void onResume() {
    super.onResume();
    MobclickAgent.onResume(this);
    a.aAU().init(this);
    a.cp(this);
    if (RootApplication.getLaiqianPreferenceManager().awf() && !"[]".equals(RootApplication.getLaiqianPreferenceManager().awg()) && !TextUtils.isEmpty(RootApplication.getLaiqianPreferenceManager().awg()))
      KU(); 
  }
  
  protected void onStart() {
    if (a.AZ().BT() && a.zR().zV()) {
      this.baG.baZ.bbg.setVisibility(0);
    } else {
      this.baG.baZ.bbg.setVisibility(8);
    } 
    if (!a.AZ().Bk() && a.AZ().Ct()) {
      this.baG.baZ.bbh.setVisibility(0);
    } else {
      this.baG.baZ.bbh.setVisibility(8);
    } 
    super.onStart();
    if (Le()) {
      finish();
      return;
    } 
    Lf();
    n.aL(this);
    if (this.baB) {
      this.baB = false;
      this.baF.bem.beA.accept(new Object());
    } 
    if (((Boolean)this.baF.bef.getValue()).booleanValue() || this.baz)
      this.baz = false; 
    if (((Boolean)this.baF.bef.getValue()).booleanValue() || this.baA) {
      this.baA = false;
      Lh();
    } 
    this.baF.bef.accept(Boolean.valueOf(false));
  }
  
  protected void onStop() { super.onStop(); }
  
  public class SmsReceiver extends BroadcastReceiver {
    public SmsReceiver(PosActivity this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      int i = param1Intent.getIntExtra("SMS_QUANTITY_LEFT", 0);
      PosActivity.c(this.baU, i);
    }
  }
  
  public static interface a {
    boolean beforeCloseActivity();
  }
  
  private static final class b {
    RelativeLayout aQo;
    
    b baZ;
    
    View bba;
    
    a bbb;
    
    RelativeLayout bbc;
    
    b(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.baZ = new b(param1View.findViewById(2131299275));
      this.bba = param1View.findViewById(2131298292);
      this.bbb = new a(param1View.findViewById(2131296486));
      this.bbc = (RelativeLayout)param1View.findViewById(2131298949);
    }
    
    static b b(LayoutInflater param1LayoutInflater) { return new b(param1LayoutInflater.inflate(2131427811, null)); }
    
    static final class a {
      LinearLayout aQx;
      
      TextView bbd;
      
      TextView bbe;
      
      a(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bbd = (TextView)param2View.findViewById(2131298948);
        this.bbe = (TextView)param2View.findViewById(2131299181);
      }
    }
    
    static final class b {
      RelativeLayout aQo;
      
      IconDotTextView bbf;
      
      IconDotTextView bbg;
      
      IconDotTextView bbh;
      
      View view;
      
      b(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bbf = (IconDotTextView)param2View.findViewById(2131299250);
        this.view = param2View.findViewById(2131299975);
        this.bbg = (IconDotTextView)param2View.findViewById(2131299195);
        this.bbh = (IconDotTextView)param2View.findViewById(2131298655);
      }
    }
  }
  
  static final class a {
    LinearLayout aQx;
    
    TextView bbd;
    
    TextView bbe;
    
    a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bbd = (TextView)param1View.findViewById(2131298948);
      this.bbe = (TextView)param1View.findViewById(2131299181);
    }
  }
  
  static final class b {
    RelativeLayout aQo;
    
    IconDotTextView bbf;
    
    IconDotTextView bbg;
    
    IconDotTextView bbh;
    
    View view;
    
    b(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bbf = (IconDotTextView)param1View.findViewById(2131299250);
      this.view = param1View.findViewById(2131299975);
      this.bbg = (IconDotTextView)param1View.findViewById(2131299195);
      this.bbh = (IconDotTextView)param1View.findViewById(2131298655);
    }
  }
  
  public static interface c {
    void Lp();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\PosActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */