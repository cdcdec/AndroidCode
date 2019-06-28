package com.laiqian.login.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.entity.g;
import com.laiqian.f.c;
import com.laiqian.login.a.b;
import com.laiqian.login.b.f;
import com.laiqian.login.c.a;
import com.laiqian.member.bz;
import com.laiqian.member.setting.bc;
import com.laiqian.message.m;
import com.laiqian.milestone.c;
import com.laiqian.milestone.h;
import com.laiqian.models.at;
import com.laiqian.models.bg;
import com.laiqian.network.o;
import com.laiqian.network.service.AppInstallReceiver;
import com.laiqian.network.service.a;
import com.laiqian.network.t;
import com.laiqian.online.g;
import com.laiqian.opentable.common.b;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.industry.a;
import com.laiqian.pos.industry.b;
import com.laiqian.print.dualscreen.DualScreenService;
import com.laiqian.print.dualscreen.o;
import com.laiqian.print.m;
import com.laiqian.sync.a.d;
import com.laiqian.sync.a.g;
import com.laiqian.sync.a.m;
import com.laiqian.sync.c.a;
import com.laiqian.sync.model.i;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ImageCheckBox;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.ui.keybord.KeyBoardLinearlayout;
import com.laiqian.ui.keybord.d;
import com.laiqian.ui.s;
import com.laiqian.util.ae;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.b;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.bs;
import com.laiqian.util.bt;
import com.laiqian.util.ch;
import com.laiqian.util.l;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.laiqian.util.m;
import com.laiqian.util.n;
import hugo.weaving.DebugLog;
import io.reactivex.g.a;
import io.reactivex.h;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.FutureTask;
import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.c;

public class LoginActivity extends ActivityRoot {
  private static String TAG = "LoginActivity";
  
  private boolean aDM;
  
  int aDO = Build.VERSION.SDK_INT;
  
  bz aDP;
  
  Handler aDQ = new h(this);
  
  private boolean aDR = false;
  
  b aZA = null;
  
  Handler aZB = new aa(this);
  
  private c aZc;
  
  private AppInstallReceiver aZd;
  
  private bs aZe = null;
  
  private d aZf;
  
  protected a aZg;
  
  private b aZh;
  
  UsbCardReceiver aZi;
  
  private boolean aZj = true;
  
  private boolean aZk = false;
  
  private DualScreenService aZl;
  
  private o aZm;
  
  private ServiceConnection aZn = new ag(this);
  
  private ArrayList<String> aZo = null;
  
  View.OnClickListener aZp = new q(this);
  
  i aZq;
  
  Handler aZr = new s(this);
  
  Handler aZs = new t(this);
  
  Handler aZt = new v(this);
  
  Handler aZu = new w(this);
  
  Handler aZv = new z(this);
  
  String aZw = null;
  
  int aZx;
  
  int aZy = 0;
  
  int aZz = -1;
  
  private g syncManager;
  
  static  {
  
  }
  
  private void Ka() {
    try {
      o.WQ().a(new FutureTask(new ab(this), null));
      return;
    } catch (InterruptedException interruptedException) {
      a.e(interruptedException);
      return;
    } 
  }
  
  private void Kb() {
    if (DualScreenService.bc(this)) {
      startService(new Intent(this, DualScreenService.class));
      Kc();
    } 
  }
  
  private void Kc() { bindService(new Intent(this, DualScreenService.class), this.aZn, 1); }
  
  private void Kd() {
    if (this.aZk) {
      unbindService(this.aZn);
      this.aZk = false;
    } 
  }
  
  private void Ke() {
    if (a.zR().Ac()) {
      RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.aZg.aZH.baa.getLayoutParams();
      layoutParams.height = -2;
      layoutParams.width = -2;
      layoutParams.setMargins(0, 0, 0, 0);
      this.aZg.aZH.baa.setLayoutParams(layoutParams);
      this.aZg.aZH.tvTitle.setVisibility(8);
    } 
    if (!getResources().getBoolean(2131034139)) {
      this.aZg.aZV.setVisibility(8);
    } else {
      this.aZg.aZV.setVisibility(0);
    } 
    av av = new av(this);
    if (av.avc()) {
      try {
        c c1 = new c(getResources(), 2131231827);
        this.aZg.aZH.bad.setImageDrawable(c1);
      } catch (IOException iOException) {
        a.e(iOException);
      } 
      av.hL(false);
    } else {
      this.aZg.aZH.bad.setImageResource(2131231915);
    } 
    av.close();
  }
  
  private void Kf() {
    this.aZg.aZU.setOnClickListener(this.aZp);
    this.aZg.aZL.setOnClickListener(new e(this));
    this.aZg.aZI.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    Km();
    this.aZg.aZH.bad.setOnClickListener(new ai(this));
    if (!getResources().getBoolean(2131034123)) {
      this.aZg.aZH.baa.setVisibility(8);
      this.aZg.aZH.tvTitle.setVisibility(8);
      this.aZg.aZH.bab.setVisibility(0);
    } 
    this.aZg.aZH.bae.setOnClickListener(new aj(this));
    this.aZg.aZV.setOnClickListener(new m.c(this, RegisterAccountActivity.class));
  }
  
  private void Kg() {
    this.aZg.aZS.setVisibility(8);
    av av = new av(this);
    String str = av.Ea();
    av.close();
    this.aZg.aZI.setText(str);
    if (str.equals(""))
      this.aZg.aZI.requestFocus(); 
    if (!getResources().getBoolean(2131034124))
      getWindow().getDecorView().post(new ak(this)); 
  }
  
  private void Kh() {
    String str1 = getString(2131626143);
    String str2 = getString(2131626142);
    String str3 = getString(2131626144);
    String str4 = getString(2131626145);
    bt.a a1;
    bt.a a2;
    bt.a a3;
    bt.a a4;
    bt.a a5 = (a4 = (a3 = (a2 = (a1 = bt.a.mj(getResources().getColor(2131099972))).mj(getResources().getColor(2131099898))).mj(getResources().getColor(2131099972))).mj(getResources().getColor(2131099898))).mj(getResources().getColor(2131099972));
    (new c(this, bt.a("%s:%s<br>%s:%s<br>%s", new String[] { str1, str2, str3, "123456", str4 }, new bt.a[] { a1, a2, a3, a4, a5 }), '', 'ŉ', 2131231057)).showAsDropDown(this.aZg.aZH.bae, -ae.b(this, 260.0F), 0);
  }
  
  @SuppressLint({"CheckResult"})
  private void Ki() { h.c(new e(this)).d(a.aKh()).a(f.aEp, g.aEp); }
  
  private void Kj() {
    null = new av(this);
    String str = null.auE();
    null.close();
    this.aZo = this.aZh.dP(str);
    if (this.aZo.size() > 0) {
      this.aZg.aZI.setText((CharSequence)this.aZo.get(0));
      this.aZg.aZK.requestFocus();
    } 
    this.aZg.aZI.setDropDownBackgroundDrawable(getResources().getDrawable(17170445));
    j j = new j(this, this, 2131427741, 2131299454, this.aZo);
    if (Kk()) {
      this.aZg.aZI.setAdapter(j);
      if (j.getCount() <= 3) {
        this.aZg.aZI.setDropDownHeight(-2);
        return;
      } 
      this.aZg.aZI.setDropDownHeight(ae.b(this, 120.0F));
    } 
  }
  
  private void Km() {
    this.aZg.aZI.addTextChangedListener(new m(this));
    this.aZg.aZK.addTextChangedListener(new n(this));
    this.aZg.aZK.setOnFocusChangeListener(new o(this));
    this.aZg.aZN.a(new p(this));
  }
  
  private void Kn() {
    bb.fU("去服务器检查密码.");
    if (!bd.bH(this)) {
      this.aZh.Jx();
      hideProgress();
      return;
    } 
    Ko();
  }
  
  private void Kq() {
    av av = new av(this);
    if (a.AZ().Bd()) {
      ServerService.ae(this);
      ServerService.aa(this);
    } 
    av.hl(false);
    String str = this.aZg.aZI.getText().toString().trim();
    if (this.aZo.contains(str))
      this.aZo.remove(str); 
    this.aZo.add(0, str);
    Kr();
    av.hz(true);
    av.close();
    bg bg = new bg(getActivity());
    long l = bg.WA();
    a.aOD = l;
    a.aOC = b.U(l);
    bg.close();
  }
  
  private void Kr() {
    h h = new h(this);
    RootApplication.getLaiqianPreferenceManager().close();
    null = new av(this);
    long l = Long.parseLong(null.atm());
    null.close();
    Cursor cursor = h.aK(l);
    SharedPreferences.Editor editor = getSharedPreferences("settings", 0).edit();
    if (cursor == null || cursor.getCount() == 0) {
      editor.remove(t.bUY);
      editor.remove(t.bUz);
      editor.remove(t.bVe);
      editor.remove(t.bVd);
    } else {
      cursor.moveToFirst();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(cursor.getColumnIndex("sUserPhone"));
      stringBuilder.append("");
      Log.d("修改服务器请求登录的信息", stringBuilder.toString());
      editor.putString(t.bUY, cursor.getString(cursor.getColumnIndex("sUserPassword")));
      editor.putString(t.bUz, cursor.getString(cursor.getColumnIndex("sUserPhone")));
      editor.putString(t.bVe, cursor.getString(cursor.getColumnIndex("sMail")));
      editor.putString(t.bVd, cursor.getString(cursor.getColumnIndex("sUserName")));
    } 
    editor.commit();
    if (cursor != null)
      cursor.close(); 
    h.close();
  }
  
  private void Ks() {
    av av = new av(this);
    if (!av.ati()) {
      at at = new at(this);
      ArrayList arrayList = at.RJ();
      if (arrayList.isEmpty()) {
        double d1 = at.Wg();
        int[] arrayOfInt = getResources().getIntArray(2130903063);
        String[] arrayOfString1 = getResources().getStringArray(2130903062);
        String[] arrayOfString2 = new String[3];
        arrayOfString2[0] = "001";
        arrayOfString2[1] = "002";
        arrayOfString2[2] = "003";
        null = new StringBuilder();
        null.append(av.Tx());
        null.append("26");
        String str = null.toString();
        ArrayList arrayList1 = new ArrayList();
        if (arrayList.size() > 0)
          for (byte b2 = 0; b2 < arrayList.size(); b2++)
            arrayList1.add(Long.valueOf(((g)arrayList.get(b2)).getId()));  
        for (byte b1 = 0; b1 < arrayOfString1.length; b1++) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          stringBuilder.append(arrayOfString2[b1]);
          long l = Long.valueOf(stringBuilder.toString()).longValue();
          if (arrayList1.size() <= 0 || !arrayList1.contains(Long.valueOf(l)))
            arrayList.add(new g(l, b1, arrayOfInt[b1], d1, arrayOfString1[b1])); 
        } 
        at.x(arrayList);
        at.close();
        av.close();
      } 
    } 
  }
  
  private void Kt() {
    Ks();
    a.AZ().Ba();
    Ku();
    Intent intent = new Intent();
    if (bd.bH(this)) {
      m.g(d.app());
      m.c(d.app());
      m.e(g.Xh());
      m.a(g.Xh());
      intent.setClass(this, com.laiqian.pos.PosDownloaderAfterLogin.class);
    } else {
      intent.setClass(this, CrashApplication.aMW);
    } 
    b.Xz();
    Ka();
    startActivity(intent);
    overridePendingTransition(2130771979, 2130771980);
    finish();
    RootApplication.getLaiqianPreferenceManager().mc(0);
    b.init();
    a.AZ().cb(true);
    av av = new av(this);
    String str1 = av.Tx();
    av.close();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("?id=");
    stringBuilder2.append(str1);
    str1 = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(eI(a.url));
    stringBuilder2.append(str1);
    a.url = stringBuilder2.toString();
    String str2 = a.url;
    t.url = str2;
    a.crl = str2;
    m.url = str2;
    a.url = str2;
    b.crl = str2;
    a.crl = str2;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(eI(RootUrlParameter.cla));
    stringBuilder1.append(str1);
    RootUrlParameter.cla = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(eI(b.url));
    stringBuilder1.append(str1);
    b.url = stringBuilder1.toString();
    b.cry = a.url;
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(eI(a.cqs));
    stringBuilder1.append(str1);
    a.cqs = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(eI(a.cqt));
    stringBuilder1.append(str1);
    a.cqt = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(eI(a.cqv));
    stringBuilder1.append(str1);
    a.cqv = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(eI(a.cqw));
    stringBuilder1.append(str1);
    a.cqw = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(eI(a.cqx));
    stringBuilder1.append(str1);
    a.cqx = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(eI(a.cqy));
    stringBuilder1.append(str1);
    a.cqy = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(eI(a.cqz));
    stringBuilder1.append(str1);
    a.cqz = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(eI(a.cqA));
    stringBuilder1.append(str1);
    a.cqA = stringBuilder1.toString();
    x x = new x(this);
    a.aKh().r(x);
    Ki();
  }
  
  private void Ku() {
    at at = new at(this);
    boolean bool = at.Wl().booleanValue();
    at.close();
    if (bool)
      a.AZ().bQ(a.AZ().By()); 
  }
  
  private void Kv() {
    r r = new r(this, new y(this));
    r.setTitle(getString(2131625532));
    r.s(getString(2131625533));
    r.oZ(getString(2131625529));
    r.t(getString(2131625538));
    r.show();
  }
  
  private boolean Kw() {
    null = CrashApplication.getLaiqianPreferenceManager().Tx();
    null = new HashMap();
    Log.e("request_shopid", null);
    null.put("shopid", null);
    null.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
    null.put("password", RootApplication.getLaiqianPreferenceManager().atr());
    null.put("auth_type", "0");
    null.put("version", "2");
    null = bh.a(b.cqq, CrashApplication.zv().getApplicationContext(), null);
    Log.e("sResultLog", null);
    HashMap hashMap = au.qB(null);
    if (hashMap != null && hashMap.containsKey("open_log")) {
      boolean bool;
      av av2 = CrashApplication.getLaiqianPreferenceManager();
      int j = n.parseInt(String.valueOf(hashMap.get("open_log")));
      boolean bool1 = true;
      if (j == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      av2.hV(bool);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(hashMap.get("min_number"));
      stringBuilder.append("");
      Long long = Long.valueOf(Long.parseLong(stringBuilder.toString()));
      av av1 = CrashApplication.getLaiqianPreferenceManager();
      if (long.longValue() == 0L) {
        bool = bool1;
      } else {
        bool = false;
      } 
      av1.O(Boolean.valueOf(bool));
      CrashApplication.getLaiqianPreferenceManager().dy(long.longValue());
    } 
    String str = bh.a(b.cqs, CrashApplication.zv().getApplicationContext(), null);
    Log.e("QueryVipSettingTask", str);
    return !TextUtils.isEmpty(str) ? bc.RH().fZ(str) : 0;
  }
  
  public static void av(Context paramContext) {
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("settings", 0);
    Log.d("修改cleanPreference登录的信息", sharedPreferences.getString("user_phone", "默认"));
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.remove("shop_id");
    editor.remove("user_id");
    editor.remove("user_password");
    editor.remove("user_phone");
    editor.remove("SERVICE_RETURN");
    editor.commit();
  }
  
  private void dc(boolean paramBoolean) {
    String str2 = this.aZg.aZI.getText().toString().trim();
    str1 = this.aZg.aZK.getText().toString().trim();
    boolean bool = paramBoolean;
    if (paramBoolean) {
      av av = new av(this);
      try {
        null = new h(this);
        long[] arrayOfLong = null.Y(str2, str1);
        null.close();
        if (arrayOfLong[0] == -3L) {
          dd(false);
          hideProgress();
          eG(getString(2131626840));
          return;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append(arrayOfLong[0]);
        stringBuilder.append("");
        av.qD(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(arrayOfLong[1]);
        stringBuilder.append("");
        av.qG(stringBuilder.toString());
        try {
          String str = c.cI(str1);
          str1 = str;
        } catch (NoSuchAlgorithmException stringBuilder) {
          a.e(stringBuilder);
        } 
        av.qJ(str2);
        av.qL(str1);
        stringBuilder = new StringBuilder();
        stringBuilder.append(arrayOfLong[0]);
        stringBuilder.append("");
        av.qF(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(arrayOfLong[1]);
        stringBuilder.append("");
        av.qH(stringBuilder.toString());
        av.qK(str2);
        av.qM(str1);
        av.close();
        bool = paramBoolean;
      } catch (Exception str1) {
        a.e(str1);
        bool = false;
      } 
    } 
    if (bool) {
      Log.e("GetShopInfoTask", "1");
      (new d(this, null)).execute(new Void[0]);
    } 
  }
  
  private void dd(boolean paramBoolean) {
    if (paramBoolean) {
      Kq();
      Kt();
      return;
    } 
    av(this);
  }
  
  private String eI(String paramString) {
    int j = paramString.lastIndexOf("?id=");
    return (j == -1) ? paramString : paramString.substring(0, j);
  }
  
  private void init() {
    this.aZh = new b(this);
    this.syncManager = new g(this);
    this.syncManager.a(new ac(this));
    if (getResources().getBoolean(2131034124)) {
      this.aZg.aZH.bae.setVisibility(8);
      this.aZg.aZH.bad.setVisibility(8);
    } 
    this.aZg.aZH.bad.setVisibility(8);
    Kg();
    Kj();
    av(this);
    CrashApplication.zx();
    if (!getResources().getBoolean(2131034133)) {
      getLaiqianPreferenceManager().hE(false);
      getLaiqianPreferenceManager().hF(false);
    } 
    if (this.aZe == null)
      this.aZe = new bs(); 
    AutoCompleteTextView autoCompleteTextView = this.aZg.aZI;
    EditText editText = this.aZg.aZK;
    KeyBoardLinearlayout keyBoardLinearlayout = this.aZg.aZJ;
    bs bs1 = this.aZe;
    this.aZf = new d(this, new EditText[] { autoCompleteTextView, editText }, keyBoardLinearlayout, bs1);
    this.aZc = new c(this, null);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.DOWNLOAD_RECEIVER");
    registerReceiver(this.aZc, intentFilter);
    this.aZd = new AppInstallReceiver();
    a(this.aZd);
    Kb();
  }
  
  private void xV() {
    if (this.aZi == null) {
      this.aZi = new UsbCardReceiver(this);
      if (!this.aDR) {
        this.aDR = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction("com.laiqian.USB_PERMISSION");
        registerReceiver(this.aZi, intentFilter);
      } 
    } 
  }
  
  protected void Em() {
    this.aZg.aZL.setClickable(false);
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(500L);
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, (this.aZg.aZR.getWidth() / 2), (this.aZg.aZR.getHeight() / 2));
    scaleAnimation.setDuration(500L);
    AnimationSet animationSet = new AnimationSet(false);
    animationSet.addAnimation(scaleAnimation);
    animationSet.addAnimation(alphaAnimation);
    this.aZg.aZR.startAnimation(animationSet);
    this.aZg.aZR.setVisibility(8);
    this.aZg.aZQ.setVisibility(0);
  }
  
  protected boolean Kk() { return true; }
  
  protected void Kl() { this.aZg.aZO.setText(""); }
  
  public void Ko() {
    r r = new r(this);
    a.aKh().r(r);
  }
  
  public void Kp() {
    this.syncManager.apy().gW(false);
    dc(true);
  }
  
  public void a(AppInstallReceiver paramAppInstallReceiver) {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    intentFilter.addDataScheme("package");
    registerReceiver(paramAppInstallReceiver, intentFilter);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getKeyCode() == 160) {
      this.aZg.aZL.performClick();
      return true;
    } 
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void eG(String paramString) {
    if (this.aZg.aZT.getVisibility() == 0)
      this.aZg.aZT.setVisibility(4); 
    this.aZg.aZO.setText(paramString);
  }
  
  public String eH(String paramString) { return paramString.equals("-1") ? getString(2131625525) : (paramString.equals("-2") ? getString(2131625524) : getString(2131626846)); }
  
  protected void hideProgress() {
    this.aZg.aZR.clearAnimation();
    this.aZg.aZQ.setVisibility(8);
    this.aZg.aZP.setVisibility(8);
    this.aZg.aZR.setVisibility(0);
    this.aZg.aZL.setClickable(true);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.aZg = a.i(this);
    this.aZg.aQG.post(new u(this));
    Ke();
    Kf();
    init();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.aZe != null)
      this.aZe.release(); 
    try {
      if (this.aZc != null)
        unregisterReceiver(this.aZc); 
      if (this.aZd != null)
        unregisterReceiver(this.aZd); 
      if (this.syncManager != null)
        this.syncManager.close(); 
    } catch (IllegalArgumentException illegalArgumentException) {
      a.e(illegalArgumentException);
    } 
    Kd();
    if (!this.aDM && this.aZi != null)
      try {
        if (this.aDR) {
          this.aDR = false;
          unregisterReceiver(this.aZi);
        } 
        this.aZi = null;
      } catch (Exception exception) {
        a.e(exception);
      }  
    if (this.aDP != null)
      this.aDP.stop(); 
    if (this.aDQ != null)
      this.aDQ = null; 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      Kv();
      return false;
    } 
    return false;
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() {
    av av = new av(this);
    boolean bool = false;
    av.hz(false);
    av.close();
    if (!ch.L(this, "com.laiqian.network.service.DownloadApkService")) {
      a.close();
      this.aZh.da(this.aZj);
      this.aZj = false;
    } 
    (new m(this)).aes();
    if (this.aDO < 12)
      bool = true; 
    this.aDM = bool;
    if (!this.aDM)
      xV(); 
    this.aDQ = new ah(this);
    super.onResume();
  }
  
  @DebugLog
  protected void onStart() {
    super.onStart();
    i i1 = new i(this);
    a.aKh().r(i1);
  }
  
  protected void onStop() {
    super.onStop();
    av av = new av(this);
    av.rn(this.aZh.s(this.aZo));
    av.close();
    this.aZs.removeCallbacksAndMessages(null);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) { super.onWindowFocusChanged(paramBoolean); }
  
  public class UsbCardReceiver extends BroadcastReceiver {
    public UsbCardReceiver(LoginActivity this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      String str = param1Intent.getAction();
      if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(str)) {
        bz bz;
        if ((bz = this.aZD.aDP).aE(this.aZD))
          if (this.aZD.aZg.aZK.hasFocus()) {
            this.aZD.aDP = bz.Qw();
            this.aZD.aDP.a(this.aZD, 500L, this.aZD.aDQ);
            this.aZD.aDP.start();
          } else if (this.aZD.aDP != null) {
            this.aZD.aDP.stop();
          }  
      } 
      if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(str)) {
        bz bz;
        if ((!(bz = this.aZD.aDP).aE(this.aZD) || !this.aZD.aZg.aZK.hasFocus()) && this.aZD.aDP != null)
          this.aZD.aDP.stop(); 
      } 
    }
  }
  
  public static class a {
    public View aQG;
    
    public LoginActivity.f aZH;
    
    AutoCompleteTextView aZI;
    
    KeyBoardLinearlayout aZJ;
    
    EditText aZK;
    
    View aZL;
    
    View aZM;
    
    ImageCheckBox aZN;
    
    TextView aZO;
    
    TextView aZP;
    
    public View aZQ;
    
    TextView aZR;
    
    View aZS;
    
    TextView aZT;
    
    TextView aZU;
    
    TextView aZV;
    
    View aZW;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.aZH = new LoginActivity.f(s.z(param1View, 2131297864));
      this.aZI = (AutoCompleteTextView)s.z(param1View, 2131297450);
      this.aZJ = (KeyBoardLinearlayout)s.z(param1View, 2131298195);
      this.aZK = (EditText)s.z(param1View, 2131297448);
      this.aZL = s.z(param1View, 2131297446);
      this.aZM = s.z(param1View, 2131298749);
      this.aZN = (ImageCheckBox)s.z(param1View, 2131297256);
      this.aZO = (TextView)s.z(param1View, 2131299318);
      this.aZP = (TextView)s.z(param1View, 2131299335);
      this.aZQ = s.z(param1View, 2131297346);
      this.aZR = (TextView)s.z(param1View, 2131299334);
      this.aZS = s.z(param1View, 2131297421);
      this.aZT = (TextView)s.z(param1View, 2131299311);
      this.aZU = (TextView)s.z(param1View, 2131297445);
      this.aZV = (TextView)s.z(param1View, 2131299672);
      this.aZW = s.z(param1View, 2131297917);
    }
    
    public static a a(Window param1Window) { return m(s.p(param1Window)); }
    
    public static a i(Activity param1Activity) { return a(param1Activity.getWindow()); }
    
    public static a m(ViewGroup param1ViewGroup) { return new a(View.inflate(param1ViewGroup.getContext(), 2131427740, param1ViewGroup)); }
  }
  
  private static class b extends d {}
  
  private class c extends BroadcastReceiver {
    private c(LoginActivity this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      int i = param1Intent.getExtras().getInt("progress");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Activity中的进度");
      stringBuilder.append(i);
      stringBuilder.append("%");
      bb.ao(stringBuilder.toString());
      if (i == 100) {
        if (LoginActivity.j(this.aZD) != null)
          this.aZD.unregisterReceiver(LoginActivity.j(this.aZD)); 
        Message message = new Message();
        message.obj = "1";
        this.aZD.aZB.sendMessage(message);
      } 
    }
  }
  
  private class d extends AsyncTask<Void, Void, Void> {
    private d(LoginActivity this$0) {}
    
    protected Void doInBackground(Void... param1VarArgs) {
      LoginActivity.h(this.aZD);
      return null;
    }
    
    protected void onPostExecute(Void param1Void) throws Exception { LoginActivity.b(this.aZD, true); }
  }
  
  class e implements View.OnClickListener {
    e(LoginActivity this$0) {}
    
    private void Kz() { (new am(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]); }
    
    public void onClick(View param1View) {
      this.aZD.Em();
      l.Q(this.aZD);
      this.aZD.Kl();
      String str2 = this.aZD.aZg.aZI.getText().toString().trim();
      String str1 = this.aZD.aZg.aZK.getText().toString().trim();
      if (str2.equals("") || str1.equals("")) {
        this.aZD.eG(this.aZD.getString(2131625462));
        this.aZD.hideProgress();
        return;
      } 
      this.aZD.getLaiqianPreferenceManager().rq(str1);
      bb.fU("开始检查密码");
      h h = new h(this.aZD);
      long[] arrayOfLong = h.Y(str2, str1);
      h.close();
      if (arrayOfLong[0] > 0L) {
        bb.fU("本地检查密码通过.");
        SharedPreferences.Editor editor = this.aZD.getSharedPreferences("settings", 0).edit();
        editor.remove("shop_id");
        editor.remove("user_id");
        stringBuilder = new StringBuilder();
        stringBuilder.append(arrayOfLong[0]);
        stringBuilder.append("");
        editor.putString("shop_id", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(arrayOfLong[1]);
        stringBuilder.append("");
        editor.putString("user_id", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("");
        Log.d("修改LoginButton登录的信息", stringBuilder.toString());
        try {
          String str = c.cI(str1);
          str1 = str;
        } catch (NoSuchAlgorithmException stringBuilder) {
          h.a(new d(getClass().getSimpleName(), "LoginButtonListener.onClick()", "exception", stringBuilder.getCause().toString()), h.a.dHw, h.b.dHF);
          a.e(stringBuilder);
        } 
        editor.putString("user_password", str1);
        editor.putString("user_phone", str2);
        editor.commit();
        LoginActivity.e(this.aZD);
        if (bd.bH(this.aZD.getActivity())) {
          a a = new a();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(arrayOfLong[1]);
          stringBuilder2.append("");
          a.aYR = stringBuilder2.toString();
          a.password = str1;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(arrayOfLong[0]);
          stringBuilder1.append("");
          a.aSI = stringBuilder1.toString();
          a.context = this.aZD.getActivity();
          a.a(new al(this));
          a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
          return;
        } 
        LoginActivity.f(this.aZD);
        return;
      } 
      bb.fU("本地密码检查失败.");
      LoginActivity.g(this.aZD);
    }
  }
  
  public static class f {
    ImageView baa;
    
    ImageView bab;
    
    TextView bac;
    
    GifImageView bad;
    
    ImageView bae;
    
    TextView tvTitle;
    
    public f(View param1View) {
      this.baa = (ImageView)s.z(param1View, 2131297357);
      this.tvTitle = (TextView)s.z(param1View, 2131299802);
      this.bac = (TextView)s.z(param1View, 2131299942);
      this.bad = (GifImageView)s.z(param1View, 2131296623);
      this.bab = (ImageView)s.z(param1View, 2131297358);
      this.bae = (ImageView)s.z(param1View, 2131296626);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */