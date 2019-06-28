package com.laiqian.member;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.vip.R;

public class VipPointDetailActivity extends ActivityRoot {
  private View azH;
  
  private Button azI;
  
  View.OnClickListener azO = new cd(this);
  
  private TextView btF;
  
  private TextView btG;
  
  private TextView bwh;
  
  private TextView bwi;
  
  private TextView bwj;
  
  private TextView bwk;
  
  private TextView bwl;
  
  private TextView bwm;
  
  private TextView bwn;
  
  private TextView bwo;
  
  private long bwp;
  
  private RelativeLayout bwq;
  
  long bwr;
  
  private long bws;
  
  private void wZ() {
    this.azH = findViewById(R.id.ui_titlebar_back_btn);
    this.azH.setFocusableInTouchMode(true);
    ((TextView)findViewById(R.id.ui_titlebar_txt)).setText(R.string.pos_vip_point_detail_title);
    this.bwh = (TextView)findViewById(R.id.mc_old_amount);
    this.bwi = (TextView)findViewById(R.id.tv_point_change);
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
    //   11: aload_0
    //   12: invokevirtual getIntent : ()Landroid/content/Intent;
    //   15: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   18: ldc '_id'
    //   20: invokevirtual getLong : (Ljava/lang/String;)J
    //   23: putfield bwp : J
    //   26: aconst_null
    //   27: astore #7
    //   29: new com/laiqian/models/j
    //   32: dup
    //   33: aload_0
    //   34: invokespecial <init> : (Landroid/content/Context;)V
    //   37: astore #6
    //   39: aload #6
    //   41: aload_0
    //   42: getfield bws : J
    //   45: aload_0
    //   46: getfield bwp : J
    //   49: invokevirtual q : (JJ)Landroid/database/Cursor;
    //   52: astore #5
    //   54: goto -> 88
    //   57: astore #8
    //   59: aload #6
    //   61: astore #5
    //   63: aload #8
    //   65: astore #6
    //   67: goto -> 75
    //   70: astore #6
    //   72: aconst_null
    //   73: astore #5
    //   75: aload #6
    //   77: invokestatic e : (Ljava/lang/Throwable;)V
    //   80: aload #5
    //   82: astore #6
    //   84: aload #7
    //   86: astore #5
    //   88: aload #5
    //   90: ifnull -> 533
    //   93: aload #5
    //   95: iconst_0
    //   96: invokeinterface moveToPosition : (I)Z
    //   101: iconst_1
    //   102: if_icmpne -> 533
    //   105: aload_0
    //   106: aload #5
    //   108: aload #5
    //   110: ldc 'nOperationTime'
    //   112: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   117: invokeinterface getLong : (I)J
    //   122: putfield bwr : J
    //   125: aload #5
    //   127: aload #5
    //   129: ldc 'sBPartnerNumber'
    //   131: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   136: invokeinterface getString : (I)Ljava/lang/String;
    //   141: astore #7
    //   143: aload #7
    //   145: ifnull -> 162
    //   148: aload_0
    //   149: getfield bwm : Landroid/widget/TextView;
    //   152: aload #7
    //   154: bipush #30
    //   156: invokestatic H : (Ljava/lang/String;I)Ljava/lang/String;
    //   159: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   162: aload #5
    //   164: aload #5
    //   166: ldc 'sBPartnerMobile'
    //   168: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   173: invokeinterface getString : (I)Ljava/lang/String;
    //   178: astore #7
    //   180: aload #7
    //   182: ifnull -> 199
    //   185: aload_0
    //   186: getfield btG : Landroid/widget/TextView;
    //   189: aload #7
    //   191: bipush #30
    //   193: invokestatic G : (Ljava/lang/String;I)Ljava/lang/String;
    //   196: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   199: aload #5
    //   201: aload #5
    //   203: ldc 'sBPartnerName'
    //   205: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   210: invokeinterface getString : (I)Ljava/lang/String;
    //   215: astore #7
    //   217: aload #7
    //   219: ifnull -> 257
    //   222: ldc ''
    //   224: aload #7
    //   226: invokevirtual equals : (Ljava/lang/Object;)Z
    //   229: ifne -> 257
    //   232: aload_0
    //   233: getfield btF : Landroid/widget/TextView;
    //   236: aload #7
    //   238: bipush #20
    //   240: invokestatic J : (Ljava/lang/String;I)Ljava/lang/String;
    //   243: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   246: aload_0
    //   247: getfield bwq : Landroid/widget/RelativeLayout;
    //   250: iconst_0
    //   251: invokevirtual setVisibility : (I)V
    //   254: goto -> 266
    //   257: aload_0
    //   258: getfield bwq : Landroid/widget/RelativeLayout;
    //   261: bipush #8
    //   263: invokevirtual setVisibility : (I)V
    //   266: aload #5
    //   268: aload #5
    //   270: ldc 'fSpareField3'
    //   272: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   277: invokeinterface getDouble : (I)D
    //   282: dstore_1
    //   283: aload #5
    //   285: aload #5
    //   287: ldc 'nSpareField1'
    //   289: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   294: invokeinterface getDouble : (I)D
    //   299: dstore_3
    //   300: aload_0
    //   301: getfield bwh : Landroid/widget/TextView;
    //   304: astore #7
    //   306: new java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial <init> : ()V
    //   313: astore #8
    //   315: aload #8
    //   317: dload_1
    //   318: dload_3
    //   319: dsub
    //   320: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload #8
    //   326: ldc ''
    //   328: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload #7
    //   334: aload #8
    //   336: invokevirtual toString : ()Ljava/lang/String;
    //   339: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   342: aload_0
    //   343: getfield bwi : Landroid/widget/TextView;
    //   346: astore #7
    //   348: new java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial <init> : ()V
    //   355: astore #8
    //   357: aload #8
    //   359: dload_3
    //   360: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload #8
    //   366: ldc ''
    //   368: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload #7
    //   374: aload #8
    //   376: invokevirtual toString : ()Ljava/lang/String;
    //   379: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   382: aload_0
    //   383: getfield bwj : Landroid/widget/TextView;
    //   386: astore #7
    //   388: new java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial <init> : ()V
    //   395: astore #8
    //   397: aload #8
    //   399: dload_1
    //   400: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload #8
    //   406: ldc ''
    //   408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload #7
    //   414: aload #8
    //   416: invokevirtual toString : ()Ljava/lang/String;
    //   419: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   422: aload #5
    //   424: aload #5
    //   426: ldc 'nOperationTime'
    //   428: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   433: invokeinterface getString : (I)Ljava/lang/String;
    //   438: astore #7
    //   440: aload #7
    //   442: ifnull -> 457
    //   445: aload_0
    //   446: getfield bwk : Landroid/widget/TextView;
    //   449: aload #7
    //   451: invokestatic pA : (Ljava/lang/String;)Ljava/lang/String;
    //   454: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   457: aload #5
    //   459: aload #5
    //   461: ldc_w 'sUserName'
    //   464: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   469: invokeinterface getString : (I)Ljava/lang/String;
    //   474: astore #8
    //   476: aload #8
    //   478: ifnull -> 495
    //   481: aload #8
    //   483: astore #7
    //   485: ldc ''
    //   487: aload #8
    //   489: invokevirtual equals : (Ljava/lang/Object;)Z
    //   492: ifeq -> 514
    //   495: aload #5
    //   497: aload #5
    //   499: ldc_w 'sUserPhone'
    //   502: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   507: invokeinterface getString : (I)Ljava/lang/String;
    //   512: astore #7
    //   514: aload #7
    //   516: ifnull -> 533
    //   519: aload_0
    //   520: getfield bwl : Landroid/widget/TextView;
    //   523: aload #7
    //   525: bipush #30
    //   527: invokestatic J : (Ljava/lang/String;I)Ljava/lang/String;
    //   530: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   533: aload #5
    //   535: ifnull -> 545
    //   538: aload #5
    //   540: invokeinterface close : ()V
    //   545: aload #6
    //   547: invokevirtual close : ()V
    //   550: aload_0
    //   551: getstatic com/laiqian/vip/R$id.layout_header : I
    //   554: invokevirtual findViewById : (I)Landroid/view/View;
    //   557: aload_0
    //   558: invokevirtual getActivity : ()Lcom/laiqian/ui/ActivityRoot;
    //   561: getstatic com/laiqian/vip/R$drawable.shape_red_rectangle_round_upper_corner_with_shadow : I
    //   564: invokestatic getDrawable : (Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   567: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
    //   570: return
    // Exception table:
    //   from	to	target	type
    //   29	39	70	java/lang/Exception
    //   39	54	57	java/lang/Exception }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.activity_vip_point_detail);
    this.bws = getIntent().getExtras().getLong("nDateTime");
    getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    wZ();
    xa();
    xb();
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() { super.onResume(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\VipPointDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */