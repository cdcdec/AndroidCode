package com.laiqian.member.report;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.AsyncTaskLoader;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aq;
import com.laiqian.main.bb;
import com.laiqian.models.j;
import com.laiqian.models.l;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.r;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import com.orhanobut.logger.d;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberChargeDetailRecord extends ActivityRoot {
  double aWo;
  
  private View azH;
  
  View.OnClickListener azO = new c(this);
  
  private String brb;
  
  private TextView btF;
  
  private TextView btG;
  
  String btU;
  
  private TextView bwh;
  
  private TextView bwj;
  
  private TextView bwk;
  
  private TextView bwl;
  
  private TextView bwm;
  
  private TextView bwn;
  
  private TextView bwo;
  
  private long bwp;
  
  private RelativeLayout bwq;
  
  long bwr;
  
  private TextView byI;
  
  private TextView byJ;
  
  private Button byK;
  
  private Long byL = null;
  
  long byM;
  
  boolean byN = false;
  
  private ImageView byO;
  
  private ProgressBarCircularIndeterminate byP;
  
  private r byQ;
  
  private r byR;
  
  private long byS;
  
  private boolean byT = true;
  
  public static aq I(String paramString1, String paramString2) {
    HashMap hashMap = new HashMap();
    hashMap.put("shop_id", paramString2);
    hashMap.put("member_id", paramString1);
    hashMap.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
    hashMap.put("password", RootApplication.getLaiqianPreferenceManager().atr());
    hashMap.put("auth_type", "0");
    hashMap.put("version", "1");
    if (RootApplication.getLaiqianPreferenceManager().avl()) {
      paramString1 = "0";
    } else {
      paramString1 = "1";
    } 
    hashMap.put("scope", paramString1);
    paramString1 = bh.a(RootUrlParameter.ckE, RootApplication.zv().getApplicationContext(), hashMap);
    if (!TextUtils.isEmpty(paramString1)) {
      HashMap hashMap1 = au.qC(paramString1);
      if (hashMap1.containsKey("result") && "TRUE".equals(hashMap1.get("result"))) {
        hashMap1 = au.qC((String)hashMap1.get("message"));
        aq aq = new aq();
        aq.aWn = (String)hashMap1.get("sNumber");
        aq.aWo = n.u((CharSequence)hashMap1.get("fAmount"));
        aq.aSW = Long.parseLong((String)hashMap1.get("_id"));
        aq.name = (String)hashMap1.get("sName");
        aq.aTp = (String)hashMap1.get("sContactMobilePhone");
        aq.aVq = (String)hashMap1.get("nDateTime");
        aq.aWp = n.parseInt((String)hashMap1.get("fPoints"));
        aq.aVw = (String)hashMap1.get("nSpareField1");
        aq.dy((String)hashMap1.get("sSpareField1"));
        aq.aWx = (String)hashMap1.get("sBPartnerTypeName");
        aq.aWw = n.parseLong((String)hashMap1.get("nBPartnerType"));
        aq.aWC = n.parseInt((String)hashMap1.get("nShopID"));
        return aq;
      } 
      return (hashMap1.containsKey("result") && "FALSE".equals(hashMap1.get("result"))) ? null : null;
    } 
    return null;
  }
  
  private void QR() {
    if (aD(this.bwr)) {
      this.brb = getString(R.string.cancel_fail_beyond_the_time_limit);
      this.byR.s(this.brb);
      this.byR.show();
      this.byK.setVisibility(8);
      return;
    } 
    l l = new l(getActivity());
    j j = new j(getActivity());
    l.beginTransaction();
    try {
      ArrayList arrayList = j.hd(String.valueOf(this.bwp));
      if (arrayList.size() != 1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected size is 1; real size is ");
        stringBuilder.append(arrayList.size());
        stringBuilder.append(".");
        throw new IllegalStateException(stringBuilder.toString());
      } 
      Double double = (Double)((j.a)arrayList.get(0)).b(j.bOB);
      l.a(this.byM, this.aWo - double.doubleValue());
      long l1 = ak.aF(getActivity()).a(this.bwp, this.aWo, this.byS);
      l.setTransactionSuccessful();
      this.byK.setVisibility(8);
      this.byO.setVisibility(0);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.bwp);
      stringBuilder1.append("");
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(l1);
      stringBuilder2.append("");
      (new OnlineCancelChargeSyncTask(this, this, str, stringBuilder2.toString(), false)).forceLoad();
    } catch (Exception exception) {
      a.e(exception);
    } finally {
      bb bb;
    } 
    l.endTransaction();
    l.close();
    j.close();
  }
  
  private void QS() {
    j j = new j(getActivity());
    j.beginTransaction();
    try {
      long l = ak.aF(getActivity()).a(this.bwp, this.aWo, this.byS);
      j.setTransactionSuccessful();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.bwp);
      stringBuilder1.append("");
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(l);
      stringBuilder2.append("");
      (new OnlineCancelChargeSyncTask(this, this, str, stringBuilder2.toString(), true)).forceLoad();
    } catch (Exception exception) {
      a.e(exception);
    } finally {
      bb bb;
    } 
    j.endTransaction();
    j.close();
    this.byK.setEnabled(true);
  }
  
  private boolean QT() { return "150001".equals(RootApplication.getLaiqianPreferenceManager().atp()); }
  
  public static void a(String paramString1, String paramString2, a parama) {
    HashMap hashMap = new HashMap();
    hashMap.put("shop_id", paramString2);
    hashMap.put("member_id", paramString1);
    hashMap.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
    hashMap.put("password", RootApplication.getLaiqianPreferenceManager().atr());
    hashMap.put("auth_type", "0");
    hashMap.put("version", "1");
    null = new StringBuilder();
    null.append(RootApplication.getLaiqianPreferenceManager().avm());
    null.append("");
    hashMap.put("scope", null.toString());
    String str = bh.a(RootUrlParameter.ckE, RootApplication.zv().getApplicationContext(), hashMap);
    if (!TextUtils.isEmpty(str)) {
      aq aq = au.qC(str);
      if (aq.containsKey("result") && "TRUE".equals(aq.get("result"))) {
        null = au.qC((String)aq.get("message"));
        aq = new aq();
        aq.aWn = (String)null.get("sNumber");
        aq.aWo = n.u((CharSequence)null.get("fAmount"));
        aq.aSW = Long.parseLong((String)null.get("_id"));
        aq.name = (String)null.get("sName");
        aq.aTp = (String)null.get("sContactMobilePhone");
        aq.aVq = (String)null.get("nDateTime");
        aq.aWp = (long)n.u((CharSequence)null.get("fPoints"));
        aq.aVw = (String)null.get("nSpareField1");
        aq.dy((String)null.get("sSpareField1"));
        aq.aWx = (String)null.get("sBPartnerTypeName");
        aq.aWw = n.parseLong((String)null.get("nBPartnerType"));
        aq.aWC = n.parseInt((String)null.get("nShopID"));
        String str1 = (String)null.get("bIsActive");
        if (!TextUtils.isEmpty(str1))
          aq.aWF = "Y".equals(str1); 
        parama.t(aq);
        return;
      } 
      if (aq.containsKey("result") && "FALSE".equals(aq.get("result"))) {
        parama.t(null);
        return;
      } 
      parama.t(null);
      return;
    } 
    parama.t(null);
  }
  
  private boolean aD(long paramLong) { return (System.currentTimeMillis() - paramLong > 172800000L); }
  
  private boolean checkNetwork() {
    boolean bool = bd.bH(this);
    if (!bd.bH(this))
      (new bc(this)).show(); 
    return bool;
  }
  
  private void wZ() {
    this.azH = findViewById(R.id.ui_titlebar_back_btn);
    this.azH.setFocusableInTouchMode(true);
    findViewById(R.id.ui_titlebar_help_btn).setVisibility(8);
    ((TextView)findViewById(R.id.ui_titlebar_txt)).setText(R.string.mc_record_detail_title_txt);
    this.bwh = (TextView)findViewById(R.id.mc_old_amount);
    this.byI = (TextView)findViewById(R.id.mc_charge_amount);
    this.byJ = (TextView)findViewById(R.id.mc_charge_increment_amount);
    this.bwj = (TextView)findViewById(R.id.mc_new_amount);
    this.bwk = (TextView)findViewById(R.id.mc_time);
    this.bwl = (TextView)findViewById(R.id.mc_user_name);
    this.bwm = (TextView)findViewById(R.id.tvPosMemberNumber);
    this.btG = (TextView)findViewById(R.id.tvPosMemberMobile);
    this.btF = (TextView)findViewById(R.id.tvPosMemberName);
    this.bwo = (TextView)findViewById(R.id.recharge_lab);
    this.bwn = (TextView)findViewById(R.id.tvPosMemberAmount);
    this.bwq = (RelativeLayout)findViewById(R.id.member_name_l);
    this.byK = (Button)findViewById(R.id.btn_cancel);
    this.byK.setText("撤销");
    this.byO = (ImageView)findViewById(R.id.iv_canceled);
    this.byP = (ProgressBarCircularIndeterminate)findViewById(R.id.iv_progress);
  }
  
  private void xa() {
    this.azH.setOnClickListener(this.azO);
    this.byK.setOnClickListener(new a(this));
  }
  
  @RequiresApi
  private void xb() { // Byte code:
    //   0: aload_0
    //   1: invokespecial QT : ()Z
    //   4: ifeq -> 18
    //   7: aload_0
    //   8: getfield byK : Landroid/widget/Button;
    //   11: iconst_0
    //   12: invokevirtual setVisibility : (I)V
    //   15: goto -> 27
    //   18: aload_0
    //   19: getfield byK : Landroid/widget/Button;
    //   22: bipush #8
    //   24: invokevirtual setVisibility : (I)V
    //   27: aload_0
    //   28: invokevirtual getIntent : ()Landroid/content/Intent;
    //   31: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   34: astore_2
    //   35: aload_0
    //   36: aload_2
    //   37: ldc '_id'
    //   39: invokevirtual getLong : (Ljava/lang/String;)J
    //   42: putfield bwp : J
    //   45: aload_0
    //   46: aload_2
    //   47: ldc 'nDateTime'
    //   49: invokevirtual getLong : (Ljava/lang/String;)J
    //   52: putfield byS : J
    //   55: aload_0
    //   56: aload_2
    //   57: ldc_w 'VIP_ID'
    //   60: invokevirtual getLong : (Ljava/lang/String;)J
    //   63: putfield byM : J
    //   66: aload_0
    //   67: aload_2
    //   68: ldc_w 'nBelongShopID'
    //   71: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   74: putfield btU : Ljava/lang/String;
    //   77: aload_2
    //   78: ldc_w 'AMOUNT'
    //   81: invokevirtual containsKey : (Ljava/lang/String;)Z
    //   84: ifeq -> 103
    //   87: aload_0
    //   88: aload_2
    //   89: ldc_w 'AMOUNT'
    //   92: invokevirtual getDouble : (Ljava/lang/String;)D
    //   95: putfield aWo : D
    //   98: aload_0
    //   99: iconst_1
    //   100: putfield byN : Z
    //   103: aload_0
    //   104: getfield bwo : Landroid/widget/TextView;
    //   107: aload_2
    //   108: ldc_w 'recharge'
    //   111: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   114: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   117: new com/laiqian/models/j
    //   120: dup
    //   121: aload_0
    //   122: invokespecial <init> : (Landroid/content/Context;)V
    //   125: astore #4
    //   127: aload #4
    //   129: aload_0
    //   130: getfield byS : J
    //   133: aload_0
    //   134: getfield bwp : J
    //   137: invokevirtual q : (JJ)Landroid/database/Cursor;
    //   140: astore #5
    //   142: aload #5
    //   144: ifnull -> 1073
    //   147: aload #5
    //   149: invokeinterface moveToNext : ()Z
    //   154: ifeq -> 1073
    //   157: aload_0
    //   158: aload #5
    //   160: aload #5
    //   162: ldc_w 'nOperationTime'
    //   165: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   170: invokeinterface getLong : (I)J
    //   175: putfield bwr : J
    //   178: aload_0
    //   179: aload #5
    //   181: aload #5
    //   183: ldc_w 'nChargeType'
    //   186: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   191: invokeinterface getLong : (I)J
    //   196: invokestatic valueOf : (J)Ljava/lang/Long;
    //   199: putfield byL : Ljava/lang/Long;
    //   202: aload #5
    //   204: aload #5
    //   206: ldc_w 'sBPartnerNumber'
    //   209: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   214: invokeinterface getString : (I)Ljava/lang/String;
    //   219: astore_2
    //   220: aload_2
    //   221: ifnull -> 237
    //   224: aload_0
    //   225: getfield bwm : Landroid/widget/TextView;
    //   228: aload_2
    //   229: bipush #30
    //   231: invokestatic H : (Ljava/lang/String;I)Ljava/lang/String;
    //   234: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   237: aload #5
    //   239: aload #5
    //   241: ldc_w 'sBPartnerMobile'
    //   244: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   249: invokeinterface getString : (I)Ljava/lang/String;
    //   254: astore_2
    //   255: aload_2
    //   256: ifnull -> 272
    //   259: aload_0
    //   260: getfield btG : Landroid/widget/TextView;
    //   263: aload_2
    //   264: bipush #30
    //   266: invokestatic G : (Ljava/lang/String;I)Ljava/lang/String;
    //   269: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   272: aload #5
    //   274: aload #5
    //   276: ldc_w 'sBPartnerName'
    //   279: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   284: invokeinterface getString : (I)Ljava/lang/String;
    //   289: astore_2
    //   290: aload_2
    //   291: ifnull -> 328
    //   294: ldc_w ''
    //   297: aload_2
    //   298: invokevirtual equals : (Ljava/lang/Object;)Z
    //   301: ifne -> 328
    //   304: aload_0
    //   305: getfield btF : Landroid/widget/TextView;
    //   308: aload_2
    //   309: bipush #20
    //   311: invokestatic J : (Ljava/lang/String;I)Ljava/lang/String;
    //   314: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   317: aload_0
    //   318: getfield bwq : Landroid/widget/RelativeLayout;
    //   321: iconst_0
    //   322: invokevirtual setVisibility : (I)V
    //   325: goto -> 337
    //   328: aload_0
    //   329: getfield bwq : Landroid/widget/RelativeLayout;
    //   332: bipush #8
    //   334: invokevirtual setVisibility : (I)V
    //   337: new java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial <init> : ()V
    //   344: astore_2
    //   345: aload_2
    //   346: aload #5
    //   348: aload #5
    //   350: ldc_w 'fOldAmount'
    //   353: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   358: invokeinterface getDouble : (I)D
    //   363: invokestatic valueOf : (D)Ljava/lang/Double;
    //   366: invokestatic k : (Ljava/lang/Double;)Ljava/lang/String;
    //   369: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload_2
    //   374: ldc_w ''
    //   377: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_2
    //   382: invokevirtual toString : ()Ljava/lang/String;
    //   385: astore_2
    //   386: aload_2
    //   387: ifnull -> 436
    //   390: aload_0
    //   391: getfield bwh : Landroid/widget/TextView;
    //   394: astore_3
    //   395: new java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial <init> : ()V
    //   402: astore #6
    //   404: aload #6
    //   406: aload_0
    //   407: getfield moneySymbol : Ljava/lang/String;
    //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload #6
    //   416: aload_2
    //   417: bipush #30
    //   419: aload_0
    //   420: invokestatic a : (Ljava/lang/String;ILandroid/content/Context;)Ljava/lang/String;
    //   423: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_3
    //   428: aload #6
    //   430: invokevirtual toString : ()Ljava/lang/String;
    //   433: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   436: new java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial <init> : ()V
    //   443: astore_2
    //   444: aload_2
    //   445: aload #5
    //   447: aload #5
    //   449: ldc_w 'fReceived'
    //   452: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   457: invokeinterface getDouble : (I)D
    //   462: invokestatic valueOf : (D)Ljava/lang/Double;
    //   465: invokestatic k : (Ljava/lang/Double;)Ljava/lang/String;
    //   468: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload_2
    //   473: ldc_w ''
    //   476: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload_2
    //   481: invokevirtual toString : ()Ljava/lang/String;
    //   484: astore_2
    //   485: aload_2
    //   486: ifnull -> 535
    //   489: aload_0
    //   490: getfield byI : Landroid/widget/TextView;
    //   493: astore_3
    //   494: new java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial <init> : ()V
    //   501: astore #6
    //   503: aload #6
    //   505: aload_0
    //   506: getfield moneySymbol : Ljava/lang/String;
    //   509: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload #6
    //   515: aload_2
    //   516: bipush #30
    //   518: aload_0
    //   519: invokestatic a : (Ljava/lang/String;ILandroid/content/Context;)Ljava/lang/String;
    //   522: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload_3
    //   527: aload #6
    //   529: invokevirtual toString : ()Ljava/lang/String;
    //   532: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   535: new java/lang/StringBuilder
    //   538: dup
    //   539: invokespecial <init> : ()V
    //   542: astore_2
    //   543: aload_2
    //   544: aload #5
    //   546: aload #5
    //   548: ldc_w 'fIncrementAmount'
    //   551: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   556: invokeinterface getDouble : (I)D
    //   561: invokestatic valueOf : (D)Ljava/lang/Double;
    //   564: invokestatic k : (Ljava/lang/Double;)Ljava/lang/String;
    //   567: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload_2
    //   572: ldc_w ''
    //   575: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_2
    //   580: invokevirtual toString : ()Ljava/lang/String;
    //   583: astore_2
    //   584: aload_2
    //   585: ifnull -> 634
    //   588: aload_0
    //   589: getfield byJ : Landroid/widget/TextView;
    //   592: astore_3
    //   593: new java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial <init> : ()V
    //   600: astore #6
    //   602: aload #6
    //   604: aload_0
    //   605: getfield moneySymbol : Ljava/lang/String;
    //   608: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload #6
    //   614: aload_2
    //   615: bipush #30
    //   617: aload_0
    //   618: invokestatic a : (Ljava/lang/String;ILandroid/content/Context;)Ljava/lang/String;
    //   621: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload_3
    //   626: aload #6
    //   628: invokevirtual toString : ()Ljava/lang/String;
    //   631: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   634: new java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial <init> : ()V
    //   641: astore_2
    //   642: aload_2
    //   643: aload #5
    //   645: aload #5
    //   647: ldc_w 'fNewAmount'
    //   650: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   655: invokeinterface getDouble : (I)D
    //   660: invokestatic valueOf : (D)Ljava/lang/Double;
    //   663: invokestatic k : (Ljava/lang/Double;)Ljava/lang/String;
    //   666: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload_2
    //   671: ldc_w ''
    //   674: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload_2
    //   679: invokevirtual toString : ()Ljava/lang/String;
    //   682: astore_2
    //   683: aload_2
    //   684: ifnull -> 733
    //   687: aload_0
    //   688: getfield bwj : Landroid/widget/TextView;
    //   691: astore_3
    //   692: new java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial <init> : ()V
    //   699: astore #6
    //   701: aload #6
    //   703: aload_0
    //   704: getfield moneySymbol : Ljava/lang/String;
    //   707: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload #6
    //   713: aload_2
    //   714: bipush #30
    //   716: aload_0
    //   717: invokestatic a : (Ljava/lang/String;ILandroid/content/Context;)Ljava/lang/String;
    //   720: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload_3
    //   725: aload #6
    //   727: invokevirtual toString : ()Ljava/lang/String;
    //   730: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   733: aload #5
    //   735: aload #5
    //   737: ldc_w 'nOperationTime'
    //   740: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   745: invokeinterface getString : (I)Ljava/lang/String;
    //   750: astore_2
    //   751: aload #5
    //   753: aload #5
    //   755: ldc_w 'nSpareField5'
    //   758: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   763: invokeinterface getInt : (I)I
    //   768: istore_1
    //   769: iload_1
    //   770: iconst_1
    //   771: if_icmpne -> 782
    //   774: aload_0
    //   775: getfield byO : Landroid/widget/ImageView;
    //   778: iconst_0
    //   779: invokevirtual setVisibility : (I)V
    //   782: aload_2
    //   783: ifnull -> 836
    //   786: aload_0
    //   787: getfield bwk : Landroid/widget/TextView;
    //   790: aload_2
    //   791: invokestatic pA : (Ljava/lang/String;)Ljava/lang/String;
    //   794: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   797: aload_0
    //   798: aload_0
    //   799: getfield bwr : J
    //   802: invokespecial aD : (J)Z
    //   805: ifne -> 827
    //   808: iload_1
    //   809: iconst_1
    //   810: if_icmpeq -> 827
    //   813: aload_0
    //   814: getfield byL : Ljava/lang/Long;
    //   817: invokevirtual longValue : ()J
    //   820: ldc2_w 370010
    //   823: lcmp
    //   824: ifne -> 836
    //   827: aload_0
    //   828: getfield byK : Landroid/widget/Button;
    //   831: bipush #8
    //   833: invokevirtual setVisibility : (I)V
    //   836: aload #5
    //   838: aload #5
    //   840: ldc_w 'sUserName'
    //   843: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   848: invokeinterface getString : (I)Ljava/lang/String;
    //   853: astore_3
    //   854: aload_3
    //   855: ifnull -> 870
    //   858: aload_3
    //   859: astore_2
    //   860: ldc_w ''
    //   863: aload_3
    //   864: invokevirtual equals : (Ljava/lang/Object;)Z
    //   867: ifeq -> 888
    //   870: aload #5
    //   872: aload #5
    //   874: ldc_w 'sUserPhone'
    //   877: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   882: invokeinterface getString : (I)Ljava/lang/String;
    //   887: astore_2
    //   888: aload_2
    //   889: ifnull -> 905
    //   892: aload_0
    //   893: getfield bwl : Landroid/widget/TextView;
    //   896: aload_2
    //   897: bipush #30
    //   899: invokestatic J : (Ljava/lang/String;I)Ljava/lang/String;
    //   902: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   905: aload #5
    //   907: invokeinterface close : ()V
    //   912: aload #4
    //   914: invokevirtual close : ()V
    //   917: aload_0
    //   918: getstatic com/laiqian/vip/R$id.layout_header : I
    //   921: invokevirtual findViewById : (I)Landroid/view/View;
    //   924: astore_2
    //   925: aload_0
    //   926: getfield byL : Ljava/lang/Long;
    //   929: invokevirtual longValue : ()J
    //   932: ldc2_w 370010
    //   935: lcmp
    //   936: ifne -> 1041
    //   939: aload_2
    //   940: aload_0
    //   941: invokevirtual getActivity : ()Lcom/laiqian/ui/ActivityRoot;
    //   944: getstatic com/laiqian/vip/R$drawable.shape_green_rectangle_round_upper_corner_with_shadow : I
    //   947: invokestatic getDrawable : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   950: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
    //   953: aload_0
    //   954: getfield bwh : Landroid/widget/TextView;
    //   957: aload_0
    //   958: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   961: getstatic com/laiqian/vip/R$color.green_color_10500 : I
    //   964: invokevirtual getColor : (I)I
    //   967: invokevirtual setTextColor : (I)V
    //   970: aload_0
    //   971: getfield bwj : Landroid/widget/TextView;
    //   974: aload_0
    //   975: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   978: getstatic com/laiqian/vip/R$color.green_color_10500 : I
    //   981: invokevirtual getColor : (I)I
    //   984: invokevirtual setTextColor : (I)V
    //   987: aload_0
    //   988: getfield byI : Landroid/widget/TextView;
    //   991: aload_0
    //   992: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   995: getstatic com/laiqian/vip/R$color.green_color_10500 : I
    //   998: invokevirtual getColor : (I)I
    //   1001: invokevirtual setTextColor : (I)V
    //   1004: aload_0
    //   1005: getfield byJ : Landroid/widget/TextView;
    //   1008: aload_0
    //   1009: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1012: getstatic com/laiqian/vip/R$color.green_color_10500 : I
    //   1015: invokevirtual getColor : (I)I
    //   1018: invokevirtual setTextColor : (I)V
    //   1021: aload_0
    //   1022: getfield byK : Landroid/widget/Button;
    //   1025: bipush #8
    //   1027: invokevirtual setVisibility : (I)V
    //   1030: aload_0
    //   1031: getfield byO : Landroid/widget/ImageView;
    //   1034: iconst_0
    //   1035: invokevirtual setVisibility : (I)V
    //   1038: goto -> 1055
    //   1041: aload_2
    //   1042: aload_0
    //   1043: invokevirtual getActivity : ()Lcom/laiqian/ui/ActivityRoot;
    //   1046: getstatic com/laiqian/vip/R$drawable.shape_red_rectangle_round_upper_corner_with_shadow : I
    //   1049: invokestatic getDrawable : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   1052: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
    //   1055: new com/laiqian/member/report/MemberChargeDetailRecord$c
    //   1058: dup
    //   1059: aload_0
    //   1060: aconst_null
    //   1061: invokespecial <init> : (Lcom/laiqian/member/report/MemberChargeDetailRecord;Lcom/laiqian/member/report/a;)V
    //   1064: iconst_0
    //   1065: anewarray java/lang/Void
    //   1068: invokevirtual execute : ([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   1071: pop
    //   1072: return
    //   1073: aload #5
    //   1075: invokeinterface close : ()V
    //   1080: aload #4
    //   1082: invokevirtual close : ()V
    //   1085: aload_0
    //   1086: invokevirtual finish : ()V
    //   1089: aload_0
    //   1090: aload_0
    //   1091: getstatic com/laiqian/vip/R$string.please_download_transaction_data : I
    //   1094: invokevirtual getString : (I)Ljava/lang/String;
    //   1097: invokestatic a : (Landroid/content/Context;Ljava/lang/CharSequence;)V
    //   1100: return
    //   1101: astore_2
    //   1102: aload_2
    //   1103: invokestatic e : (Ljava/lang/Throwable;)V
    //   1106: return
    // Exception table:
    //   from	to	target	type
    //   117	142	1101	java/lang/Exception
    //   147	220	1101	java/lang/Exception
    //   224	237	1101	java/lang/Exception
    //   237	255	1101	java/lang/Exception
    //   259	272	1101	java/lang/Exception
    //   272	290	1101	java/lang/Exception
    //   294	325	1101	java/lang/Exception
    //   328	337	1101	java/lang/Exception
    //   337	386	1101	java/lang/Exception
    //   390	436	1101	java/lang/Exception
    //   436	485	1101	java/lang/Exception
    //   489	535	1101	java/lang/Exception
    //   535	584	1101	java/lang/Exception
    //   588	634	1101	java/lang/Exception
    //   634	683	1101	java/lang/Exception
    //   687	733	1101	java/lang/Exception
    //   733	769	1101	java/lang/Exception
    //   774	782	1101	java/lang/Exception
    //   786	808	1101	java/lang/Exception
    //   813	827	1101	java/lang/Exception
    //   827	836	1101	java/lang/Exception
    //   836	854	1101	java/lang/Exception
    //   860	870	1101	java/lang/Exception
    //   870	888	1101	java/lang/Exception
    //   892	905	1101	java/lang/Exception
    //   905	1038	1101	java/lang/Exception
    //   1041	1055	1101	java/lang/Exception
    //   1055	1072	1101	java/lang/Exception
    //   1073	1100	1101	java/lang/Exception }
  
  public boolean beforeCloseActivity() {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    if (this.byP.getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    stringBuilder.append("");
    Log.e("beforeCloseActivity", stringBuilder.toString());
    return (this.byP.getVisibility() == 0) ? true : super.beforeCloseActivity();
  }
  
  @TargetApi(16)
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.pos_member_charge_detail);
    getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    wZ();
    xa();
    xb();
    this.byR = new r(this, 3, null);
    this.byR.setTitle(R.string.pos_dialog_title_prompt);
    this.byR.pa(getString(R.string.lqj_ok));
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() { super.onResume(); }
  
  public class OnlineCancelChargeSyncTask extends AsyncTaskLoader<Boolean> {
    private boolean byY;
    
    private String bya;
    
    private String byb;
    
    public OnlineCancelChargeSyncTask(MemberChargeDetailRecord this$0, Context param1Context, String param1String1, String param1String2, boolean param1Boolean) {
      super(param1Context);
      this.bya = param1String1;
      this.byb = param1String2;
      this.byY = param1Boolean;
    }
    
    public Boolean LN() {
      OnlineSyncRequest.a a = new OnlineSyncRequest.a();
      try {
        exception = new j(getContext());
      } catch (Exception exception) {
        a.e(exception);
        exception = null;
      } 
      a.a(exception.hd(this.bya), 2);
      a.a(exception.hd(this.byb), 1);
      exception.close();
      null = new av(getContext());
      a.iM(null.Ea());
      a.iN(null.atr());
      a.bV(Long.parseLong(null.Tx()));
      null.close();
      f = f.bXQ;
      try {
        boolean bool = (f.b(a.Xj())).bXV;
        return Boolean.valueOf(bool);
      } catch (Exception f) {
        h.awP().a(new d(MemberChargeDetailRecord.class.getSimpleName(), "onlineSync", "请求实时同步失败--", f.getMessage()), h.a.dHw, h.b.dHD);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("实时同步失败");
        stringBuilder.append(f.getMessage());
        d.b(stringBuilder.toString(), new Object[0]);
        a.e(f);
        return Boolean.valueOf(false);
      } 
    }
    
    public void g(Boolean param1Boolean) {
      j j;
      MemberChargeDetailRecord.i(this.byU).setVisibility(8);
      if (!this.byY)
        return; 
      if (param1Boolean.booleanValue()) {
        MemberChargeDetailRecord.h(this.byU).setVisibility(8);
        MemberChargeDetailRecord.k(this.byU).setVisibility(0);
        return;
      } 
      param1Boolean = null;
      try {
        j j1 = new j(getContext());
        j = j1;
      } catch (Exception exception) {
        a.e(exception);
      } 
      j.d(Long.valueOf(this.bya).longValue(), false);
      j.he(this.byb);
      j.close();
      MemberChargeDetailRecord.k(this.byU).setVisibility(8);
      MemberChargeDetailRecord.h(this.byU).setVisibility(0);
    }
  }
  
  static interface a {
    void t(aq param1aq);
  }
  
  private class b extends AsyncTask<Long, Void, Boolean> {
    private b(MemberChargeDetailRecord this$0) {}
    
    protected Boolean a(Long... param1VarArgs) { return Boolean.valueOf(MemberChargeDetailRecord.a(this.byU, this.byU.bwr) ^ true); }
    
    protected void b(Boolean param1Boolean) {
      if (param1Boolean.booleanValue()) {
        MemberChargeDetailRecord.j(this.byU);
        return;
      } 
      MemberChargeDetailRecord.a(this.byU, this.byU.getString(R.string.cancel_fail_beyond_the_time_limit));
      MemberChargeDetailRecord.b(this.byU).s(MemberChargeDetailRecord.a(this.byU));
      MemberChargeDetailRecord.b(this.byU).show();
      MemberChargeDetailRecord.i(this.byU).setVisibility(8);
      MemberChargeDetailRecord.h(this.byU).setEnabled(true);
    }
    
    protected void onPreExecute() {
      super.onPreExecute();
      MemberChargeDetailRecord.h(this.byU).setEnabled(false);
      MemberChargeDetailRecord.i(this.byU).setVisibility(0);
    }
  }
  
  private class c extends AsyncTask<Void, Void, aq> {
    aq bwz = new aq();
    
    private c(MemberChargeDetailRecord this$0) {}
    
    protected aq f(Void... param1VarArgs) {
      boolean bool = RootApplication.getLaiqianPreferenceManager().Wq();
      if (bool && this.byU.aWo == 0.0D) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.byU.byM);
        stringBuilder.append("");
        MemberChargeDetailRecord.a(stringBuilder.toString(), this.byU.btU, new d(this));
      } else if (!bool) {
        l l = new l(this.byU.getActivity());
        this.bwz = l.hp(String.valueOf(this.byU.byM));
        MemberChargeDetailRecord.a(this.byU, this.bwz.aWF);
        l.close();
      } 
      return this.bwz;
    }
    
    protected void m(aq param1aq) {
      if (param1aq != null && param1aq.aSW != 0L) {
        this.byU.aWo = param1aq.aWo;
        this.byU.byN = true;
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\MemberChargeDetailRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */