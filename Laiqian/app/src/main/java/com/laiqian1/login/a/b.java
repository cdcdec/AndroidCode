package com.laiqian.login.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.login.view.c;
import com.laiqian.network.service.e;
import com.laiqian.network.service.i;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.industry.b;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.r;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.by;
import com.laiqian.util.ca;
import com.laiqian.util.ch;
import com.laiqian.util.n;
import com.laiqian.version.a;
import io.reactivex.g.a;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class b {
  private Handler aIy = new p(this);
  
  private String aXF;
  
  private String aXG = "";
  
  private r aXH = null;
  
  private r aXI = null;
  
  private String aXJ;
  
  private String aXK;
  
  private String aXL;
  
  private Handler aXM = new g(this);
  
  private View.OnClickListener aXN = new h(this);
  
  private View.OnClickListener aXO = new i(this);
  
  private String aXP;
  
  private String aXQ;
  
  private Handler aXR = new j(this);
  
  private View.OnClickListener aXS = new m(this);
  
  private View.OnClickListener aXT = new n(this);
  
  private View.OnClickListener aXU = new o(this);
  
  private Handler aXV = new q(this);
  
  private Context mContext;
  
  public b(Context paramContext) { this.mContext = paramContext; }
  
  private void JA() { a.aKh().r(new d(this)); }
  
  private r JB() {
    if (this.aXI == null)
      this.aXI = new r(this.mContext, null); 
    return this.aXI;
  }
  
  private void JC() {
    if (n.S((Activity)this.mContext))
      return; 
    this.aXI.arn().setText(this.mContext.getString(2131628451));
    this.aXI.arn().setOnClickListener(this.aXN);
    this.aXI.show();
  }
  
  private void JD() {
    if (this.aXI != null && this.aXI.isShowing())
      this.aXI.dismiss(); 
    this.aXI = null;
    JB();
    if (n.S((Activity)this.mContext))
      return; 
    this.aXI.setTitle(this.mContext.getString(2131628441));
    r r1 = this.aXI;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("V");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(ch.ce(this.mContext));
    stringBuilder2.append("");
    stringBuilder1.append(by.sc(stringBuilder2.toString()));
    stringBuilder1.append("\n");
    stringBuilder1.append(this.aXG);
    r1.s(stringBuilder1.toString());
    this.aXI.arn().setVisibility(8);
    this.aXI.arm().setVisibility(8);
    this.aXI.aro().setVisibility(0);
    this.aXI.aro().setBackgroundResource(2131230980);
    this.aXI.aro().setTextColor(this.mContext.getResources().getColor(2131099898));
    this.aXI.aro().setText(this.mContext.getString(2131628451));
    this.aXI.aro().setOnClickListener(new e(this));
    if (!"-1".equals(RootApplication.getLaiqianPreferenceManager().atl()))
      this.aXI.show(); 
  }
  
  private void JE() {
    if (n.S((Activity)this.mContext))
      return; 
    this.aXI.setTitle(this.mContext.getString(2131628299));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mContext.getString(2131628300));
    stringBuilder.append(CrashApplication.getLaiqianPreferenceManager().avw());
    SpannableString spannableString = by.b(stringBuilder.toString(), this.mContext.getString(2131628300), 20, this.mContext.getResources().getColor(2131099898));
    this.aXI.s(spannableString);
    this.aXI.arn().setText(this.mContext.getString(2131628451));
    this.aXI.arn().setOnClickListener(this.aXO);
    this.aXI.show();
  }
  
  private void JF() {
    if (n.S((Activity)this.mContext))
      return; 
    this.aXI.arn().setText(this.mContext.getString(2131628444));
    this.aXI.arn().setOnClickListener(this.aXS);
    this.aXI.show();
  }
  
  private void JG() {
    if (n.S((Activity)this.mContext))
      return; 
    this.aXI.setTitle(this.mContext.getString(2131628299));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mContext.getString(2131628300));
    stringBuilder.append(CrashApplication.getLaiqianPreferenceManager().avw());
    SpannableString spannableString = by.b(stringBuilder.toString(), this.mContext.getString(2131628300), 20, this.mContext.getResources().getColor(2131099898));
    this.aXI.s(spannableString);
    this.aXI.arn().setText(this.mContext.getString(2131628444));
    this.aXI.arn().setOnClickListener(this.aXU);
    this.aXI.show();
  }
  
  private void JH() { a.aKh().r(new f(this)); }
  
  private void Jy() {
    if (!bd.bH(this.mContext))
      n.o("请联网"); 
    if (ch.awC()) {
      JB();
      JE();
      return;
    } 
    JA();
  }
  
  private void Jz() { a.aKh().r(new c(this)); }
  
  public void JI() { (new c(this.mContext)).show(); }
  
  public void Jx() {
    if (this.aXH == null)
      this.aXH = new bc(this.mContext); 
    this.aXH.show();
  }
  
  public int aj(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionCode;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return 1890;
    } 
  }
  
  public ArrayList<String> dP(String paramString) {
    ArrayList arrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString))
      return arrayList; 
    Collections.addAll(arrayList, paramString.split(","));
    return arrayList;
  }
  
  public void da(boolean paramBoolean) {
    if (!bd.bH(this.mContext)) {
      if (ch.cb(this.mContext)) {
        Context context = this.mContext;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(ch.cd(this.mContext));
        stringBuilder1.append("");
        String str = ch.H(context, stringBuilder1.toString());
        if (str == null)
          return; 
        JB();
        r r1 = this.aXI;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("V");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(ch.cd(this.mContext));
        stringBuilder3.append("");
        stringBuilder2.append(by.sc(stringBuilder3.toString()));
        stringBuilder2.append(this.mContext.getString(2131628454));
        stringBuilder2.append("\n");
        stringBuilder2.append(str);
        r1.s(stringBuilder2.toString());
        this.aXI.setTitle(this.mContext.getString(2131625960));
        JC();
      } 
      if (ch.cc(this.mContext)) {
        JD();
        return;
      } 
    } else {
      av av = new av(this.mContext);
      String str = av.atq();
      if (paramBoolean && !"".equals(str) && str != null) {
        Log.d("修改上次登录的信息", str);
        SharedPreferences.Editor editor = this.mContext.getSharedPreferences("settings", 0).edit();
        editor.putString("shop_id", av.atl());
        editor.putString("user_id", av.ato());
        editor.putString("user_password", av.ats());
        editor.putString("user_phone", av.atq());
        editor.commit();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramBoolean);
      stringBuilder.append("");
      Log.d("修改上次登录的信息", stringBuilder.toString());
      JH();
      if (!ch.L(this.mContext, "com.laiqian.network.service.DownloadPatchService")) {
        i.close();
        Jz();
      } 
      if (!ch.L(this.mContext, "com.laiqian.network.service.DownloadOtaService")) {
        e.close();
        Jy();
      } 
    } 
  }
  
  public String s(ArrayList<String> paramArrayList) {
    if (paramArrayList == null || paramArrayList.size() == 0)
      return ""; 
    Iterator iterator = paramArrayList.iterator();
    StringBuilder stringBuilder = new StringBuilder();
    while (iterator.hasNext()) {
      stringBuilder.append((String)iterator.next());
      if (iterator.hasNext())
        stringBuilder.append(","); 
    } 
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */