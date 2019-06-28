package com.laiqian.member.report;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.vip.R;

public class VipInitialBalanceDetailActivity extends ActivityRoot {
  private View azH;
  
  private Button azI;
  
  View.OnClickListener azO = new f(this);
  
  private TextView btF;
  
  private TextView btG;
  
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
  
  private TextView bzb;
  
  private void wZ() {
    findViewById(R.id.ui_titlebar_help_btn).setVisibility(8);
    this.azH = findViewById(R.id.ui_titlebar_back_btn);
    this.azH.setFocusableInTouchMode(true);
    ((TextView)findViewById(R.id.ui_titlebar_txt)).setText(R.string.vip_initial_balance_title);
    this.bwh = (TextView)findViewById(R.id.mc_old_amount);
    this.bzb = (TextView)findViewById(R.id.tv_initial_balance);
    this.bwj = (TextView)findViewById(R.id.mc_new_amount);
    this.bwk = (TextView)findViewById(R.id.mc_time);
    this.bwl = (TextView)findViewById(R.id.mc_user_name);
    this.azI = (Button)findViewById(R.id.ui_titlebar_help_btn);
    this.azI.setVisibility(8);
    this.bwm = (TextView)findViewById(R.id.tvPosMemberNumber);
    this.btG = (TextView)findViewById(R.id.tvPosMemberMobile);
    this.btF = (TextView)findViewById(R.id.tvPosMemberName);
    this.bwo = (TextView)findViewById(R.id.recharge_lab);
    this.bwn = (TextView)findViewById(R.id.tvPosMemberAmount);
    this.bwq = (RelativeLayout)findViewById(R.id.member_name_l);
  }
  
  private void xa() { this.azH.setOnClickListener(this.azO); }
  
  @TargetApi(16)
  private void xb() { // Byte code:
    //   0: aload_0
    //   1: getfield azI : Landroid/widget/Button;
    //   4: getstatic com/laiqian/vip/R$string.pos_edit : I
    //   7: invokevirtual setText : (I)V
    //   10: aload_0
    //   11: invokevirtual getIntent : ()Landroid/content/Intent;
    //   14: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   17: astore_3
    //   18: aload_0
    //   19: aload_3
    //   20: ldc '_id'
    //   22: invokevirtual getLong : (Ljava/lang/String;)J
    //   25: putfield bwp : J
    //   28: aload_3
    //   29: ldc 'nDateTime'
    //   31: invokevirtual getLong : (Ljava/lang/String;)J
    //   34: lstore_1
    //   35: aload_0
    //   36: getfield bwo : Landroid/widget/TextView;
    //   39: aload_3
    //   40: ldc 'recharge'
    //   42: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   45: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   48: new com/laiqian/models/j
    //   51: dup
    //   52: aload_0
    //   53: invokespecial <init> : (Landroid/content/Context;)V
    //   56: astore #5
    //   58: aload #5
    //   60: lload_1
    //   61: aload_0
    //   62: getfield bwp : J
    //   65: invokevirtual q : (JJ)Landroid/database/Cursor;
    //   68: astore #6
    //   70: aload #6
    //   72: ifnull -> 637
    //   75: aload #6
    //   77: invokeinterface moveToFirst : ()Z
    //   82: pop
    //   83: aload_0
    //   84: aload #6
    //   86: aload #6
    //   88: ldc 'nOperationTime'
    //   90: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   95: invokeinterface getLong : (I)J
    //   100: putfield bwr : J
    //   103: aload #6
    //   105: aload #6
    //   107: ldc 'sBPartnerNumber'
    //   109: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   114: invokeinterface getString : (I)Ljava/lang/String;
    //   119: astore_3
    //   120: aload_3
    //   121: ifnull -> 137
    //   124: aload_0
    //   125: getfield bwm : Landroid/widget/TextView;
    //   128: aload_3
    //   129: bipush #30
    //   131: invokestatic H : (Ljava/lang/String;I)Ljava/lang/String;
    //   134: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   137: aload #6
    //   139: aload #6
    //   141: ldc 'sBPartnerMobile'
    //   143: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   148: invokeinterface getString : (I)Ljava/lang/String;
    //   153: astore_3
    //   154: aload_3
    //   155: ifnull -> 171
    //   158: aload_0
    //   159: getfield btG : Landroid/widget/TextView;
    //   162: aload_3
    //   163: bipush #30
    //   165: invokestatic G : (Ljava/lang/String;I)Ljava/lang/String;
    //   168: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   171: aload #6
    //   173: aload #6
    //   175: ldc 'sBPartnerName'
    //   177: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   182: invokeinterface getString : (I)Ljava/lang/String;
    //   187: astore_3
    //   188: aload_3
    //   189: ifnull -> 225
    //   192: ldc ''
    //   194: aload_3
    //   195: invokevirtual equals : (Ljava/lang/Object;)Z
    //   198: ifne -> 225
    //   201: aload_0
    //   202: getfield btF : Landroid/widget/TextView;
    //   205: aload_3
    //   206: bipush #20
    //   208: invokestatic J : (Ljava/lang/String;I)Ljava/lang/String;
    //   211: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   214: aload_0
    //   215: getfield bwq : Landroid/widget/RelativeLayout;
    //   218: iconst_0
    //   219: invokevirtual setVisibility : (I)V
    //   222: goto -> 234
    //   225: aload_0
    //   226: getfield bwq : Landroid/widget/RelativeLayout;
    //   229: bipush #8
    //   231: invokevirtual setVisibility : (I)V
    //   234: new java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial <init> : ()V
    //   241: astore_3
    //   242: aload_3
    //   243: aload #6
    //   245: aload #6
    //   247: ldc 'fOldAmount'
    //   249: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   254: invokeinterface getDouble : (I)D
    //   259: invokestatic valueOf : (D)Ljava/lang/Double;
    //   262: invokestatic k : (Ljava/lang/Double;)Ljava/lang/String;
    //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_3
    //   270: ldc ''
    //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_3
    //   277: invokevirtual toString : ()Ljava/lang/String;
    //   280: astore_3
    //   281: aload_3
    //   282: ifnull -> 333
    //   285: aload_0
    //   286: getfield bwh : Landroid/widget/TextView;
    //   289: astore #4
    //   291: new java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial <init> : ()V
    //   298: astore #7
    //   300: aload #7
    //   302: aload_0
    //   303: getfield moneySymbol : Ljava/lang/String;
    //   306: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload #7
    //   312: aload_3
    //   313: bipush #30
    //   315: aload_0
    //   316: invokestatic a : (Ljava/lang/String;ILandroid/content/Context;)Ljava/lang/String;
    //   319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload #4
    //   325: aload #7
    //   327: invokevirtual toString : ()Ljava/lang/String;
    //   330: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   333: new java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial <init> : ()V
    //   340: astore_3
    //   341: aload_3
    //   342: aload #6
    //   344: aload #6
    //   346: ldc_w 'fReceived'
    //   349: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   354: invokeinterface getDouble : (I)D
    //   359: invokestatic valueOf : (D)Ljava/lang/Double;
    //   362: invokestatic k : (Ljava/lang/Double;)Ljava/lang/String;
    //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload_3
    //   370: ldc ''
    //   372: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_3
    //   377: invokevirtual toString : ()Ljava/lang/String;
    //   380: astore_3
    //   381: aload_3
    //   382: ifnull -> 433
    //   385: aload_0
    //   386: getfield bzb : Landroid/widget/TextView;
    //   389: astore #4
    //   391: new java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial <init> : ()V
    //   398: astore #7
    //   400: aload #7
    //   402: aload_0
    //   403: getfield moneySymbol : Ljava/lang/String;
    //   406: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload #7
    //   412: aload_3
    //   413: bipush #30
    //   415: aload_0
    //   416: invokestatic a : (Ljava/lang/String;ILandroid/content/Context;)Ljava/lang/String;
    //   419: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload #4
    //   425: aload #7
    //   427: invokevirtual toString : ()Ljava/lang/String;
    //   430: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   433: new java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial <init> : ()V
    //   440: astore_3
    //   441: aload_3
    //   442: aload #6
    //   444: aload #6
    //   446: ldc_w 'fNewAmount'
    //   449: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   454: invokeinterface getDouble : (I)D
    //   459: invokestatic valueOf : (D)Ljava/lang/Double;
    //   462: invokestatic k : (Ljava/lang/Double;)Ljava/lang/String;
    //   465: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload_3
    //   470: ldc ''
    //   472: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload_3
    //   477: invokevirtual toString : ()Ljava/lang/String;
    //   480: astore_3
    //   481: aload_3
    //   482: ifnull -> 533
    //   485: aload_0
    //   486: getfield bwj : Landroid/widget/TextView;
    //   489: astore #4
    //   491: new java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial <init> : ()V
    //   498: astore #7
    //   500: aload #7
    //   502: aload_0
    //   503: getfield moneySymbol : Ljava/lang/String;
    //   506: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload #7
    //   512: aload_3
    //   513: bipush #30
    //   515: aload_0
    //   516: invokestatic a : (Ljava/lang/String;ILandroid/content/Context;)Ljava/lang/String;
    //   519: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload #4
    //   525: aload #7
    //   527: invokevirtual toString : ()Ljava/lang/String;
    //   530: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   533: aload #6
    //   535: aload #6
    //   537: ldc 'nOperationTime'
    //   539: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   544: invokeinterface getString : (I)Ljava/lang/String;
    //   549: astore_3
    //   550: aload_3
    //   551: ifnull -> 565
    //   554: aload_0
    //   555: getfield bwk : Landroid/widget/TextView;
    //   558: aload_3
    //   559: invokestatic pA : (Ljava/lang/String;)Ljava/lang/String;
    //   562: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   565: aload #6
    //   567: aload #6
    //   569: ldc_w 'sUserName'
    //   572: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   577: invokeinterface getString : (I)Ljava/lang/String;
    //   582: astore #4
    //   584: aload #4
    //   586: ifnull -> 602
    //   589: aload #4
    //   591: astore_3
    //   592: ldc ''
    //   594: aload #4
    //   596: invokevirtual equals : (Ljava/lang/Object;)Z
    //   599: ifeq -> 620
    //   602: aload #6
    //   604: aload #6
    //   606: ldc_w 'sUserPhone'
    //   609: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   614: invokeinterface getString : (I)Ljava/lang/String;
    //   619: astore_3
    //   620: aload_3
    //   621: ifnull -> 637
    //   624: aload_0
    //   625: getfield bwl : Landroid/widget/TextView;
    //   628: aload_3
    //   629: bipush #30
    //   631: invokestatic J : (Ljava/lang/String;I)Ljava/lang/String;
    //   634: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   637: aload #6
    //   639: invokeinterface close : ()V
    //   644: aload #5
    //   646: invokevirtual close : ()V
    //   649: aload_0
    //   650: getstatic com/laiqian/vip/R$id.layout_header : I
    //   653: invokevirtual findViewById : (I)Landroid/view/View;
    //   656: aload_0
    //   657: invokevirtual getActivity : ()Lcom/laiqian/ui/ActivityRoot;
    //   660: getstatic com/laiqian/vip/R$drawable.shape_red_rectangle_round_upper_corner_with_shadow : I
    //   663: invokestatic getDrawable : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   666: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
    //   669: return
    //   670: astore_3
    //   671: aload_3
    //   672: invokestatic e : (Ljava/lang/Throwable;)V
    //   675: return
    // Exception table:
    //   from	to	target	type
    //   48	70	670	java/lang/Exception
    //   75	120	670	java/lang/Exception
    //   124	137	670	java/lang/Exception
    //   137	154	670	java/lang/Exception
    //   158	171	670	java/lang/Exception
    //   171	188	670	java/lang/Exception
    //   192	222	670	java/lang/Exception
    //   225	234	670	java/lang/Exception
    //   234	281	670	java/lang/Exception
    //   285	333	670	java/lang/Exception
    //   333	381	670	java/lang/Exception
    //   385	433	670	java/lang/Exception
    //   433	481	670	java/lang/Exception
    //   485	533	670	java/lang/Exception
    //   533	550	670	java/lang/Exception
    //   554	565	670	java/lang/Exception
    //   565	584	670	java/lang/Exception
    //   592	602	670	java/lang/Exception
    //   602	620	670	java/lang/Exception
    //   624	637	670	java/lang/Exception
    //   637	669	670	java/lang/Exception }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.activity_vip_initial_balance_detail);
    getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    wZ();
    xa();
    xb();
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() { super.onResume(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\VipInitialBalanceDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */