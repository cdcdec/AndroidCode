package com.laiqian.member;

import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.AsyncTaskLoader;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aq;
import com.laiqian.entity.g;
import com.laiqian.member.b.a;
import com.laiqian.member.model.PosMemberAddModel;
import com.laiqian.member.model.PosMemberChargeModel;
import com.laiqian.member.setting.bc;
import com.laiqian.member.setting.sms.h;
import com.laiqian.milestone.h;
import com.laiqian.models.j;
import com.laiqian.models.l;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.pos.bm;
import com.laiqian.pos.industry.a;
import com.laiqian.print.cardreader.am;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.LayoutLeftTextRightTextWithDialog;
import com.laiqian.util.ar;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.by;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import com.orhanobut.logger.d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;

public class MemberChangeActivity extends ActivityRoot {
  r.a aCA = new f(this);
  
  private r aCz;
  
  private boolean aDM;
  
  int aDO = Build.VERSION.SDK_INT;
  
  bz aDP;
  
  Handler aDQ = new m(this);
  
  ProgressBarCircularIndeterminate aNv;
  
  private long aPs;
  
  private String aWq;
  
  private boolean afi = true;
  
  private View azH;
  
  private Button azI;
  
  private TextView azJ;
  
  View.OnClickListener azP = new e(this);
  
  boolean bBoss = false;
  
  EditText bsA = null;
  
  EditText bsB = null;
  
  EditText bsC = null;
  
  EditText bsD = null;
  
  private LinearLayout bsE;
  
  EditText bsF = null;
  
  Button bsG = null;
  
  String bsH;
  
  String bsI;
  
  String bsJ;
  
  TextView bsK;
  
  LinearLayout bsL;
  
  String bsM;
  
  private int bsN = 0;
  
  private String[] bsO;
  
  private boolean bsP = false;
  
  UsbCardReceiver bsQ;
  
  int bsR;
  
  private LinearLayout bsS;
  
  private TextView bsT;
  
  private w bsU;
  
  private List<g> bsV;
  
  private String[] bsW;
  
  private int bsX = 0;
  
  private long bsY;
  
  private String bsZ = "";
  
  TextView bsz;
  
  private aq bta;
  
  private boolean btb = false;
  
  private boolean btc = false;
  
  private boolean btd = false;
  
  private String bte;
  
  private String btf;
  
  private EditText btg;
  
  int bth;
  
  private LinearLayout bti;
  
  private LayoutLeftTextRightTextWithDialog btj;
  
  View.OnFocusChangeListener btk = new l(this);
  
  View.OnClickListener btl = new n(this);
  
  w.a btm = new o(this);
  
  View.OnClickListener bto = new p(this);
  
  private Handler handler = new g(this);
  
  private bb mWaitingDialog = null;
  
  private void PN() {
    Calendar calendar = Calendar.getInstance(Locale.CHINA);
    calendar.setTime(new Date(Long.parseLong(this.bta.aWs)));
    calendar.get(1);
    int i = calendar.get(2);
    int j = calendar.get(5);
    (new DatePickerDialog(getActivity(), new b(this), calendar.get(1), i, j)).show();
  }
  
  private void PO() {
    if (RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
      this.bsV = RootApplication.getLaiqianPreferenceManager().ave();
    } else {
      this.bsV = bc.RH().RJ();
    } 
    if (this.bsW == null)
      this.bsW = new String[this.bsV.size()]; 
    for (byte b = 0; b < this.bsV.size(); b++)
      this.bsW[b] = ((g)this.bsV.get(b)).EV(); 
    this.bsS.setOnClickListener(new j(this));
  }
  
  private void PP() {
    av av = new av(this);
    if (!"150001".equals(av.atp()) || RootApplication.getLaiqianPreferenceManager().Wq()) {
      this.bsC.setEnabled(false);
      this.bsC.setTextColor(-16777216);
    } 
    av.close();
  }
  
  private void fi(int paramInt) {
    if (paramInt == 0) {
      this.aWq = String.valueOf("0");
      return;
    } 
    if (paramInt == 1)
      PN(); 
  }
  
  private boolean k(aq paramaq) {
    try {
      exception = new l(this);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.bta.aWn);
    stringBuilder1.append("");
    String str1 = stringBuilder1.toString();
    String str2 = paramaq.aWn;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.bta.aSW);
    stringBuilder2.append("");
    if (!exception.v(str1, str2, stringBuilder2.toString())) {
      Toast.makeText(this, exception.Vn(), 0).show();
      exception.close();
      n.j(this.bsA);
      return false;
    } 
    str1 = this.bta.aTp;
    str2 = paramaq.aTp;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.bta.aSW);
    stringBuilder2.append("");
    boolean bool = exception.w(str1, str2, stringBuilder2.toString());
    if (!bool) {
      Toast.makeText(this, exception.Vn(), 0).show();
      exception.close();
      n.j(this.bsF);
      return false;
    } 
    exception.close();
    h h = new h(this);
    try {
      boolean bool1 = h.w(paramaq);
      bool = bool1;
    } catch (Exception paramaq) {
      a.e(paramaq);
    } 
    h.close();
    return bool;
  }
  
  private void save() {
    this.bsM = this.bsA.getText().toString().trim();
    if (TextUtils.isEmpty(this.bsM)) {
      Toast.makeText(this, getString(R.string.pos_member_number_can_not_be_empty), 0).show();
      this.bsA.requestFocus();
      this.bsA.setSelection(0);
      return;
    } 
    String str1 = this.bsF.getText().toString().trim();
    if (TextUtils.isEmpty(str1)) {
      Toast.makeText(this, getString(R.string.pos_member_mobile_can_not_be_empty), 0).show();
      this.bsF.requestFocus();
      this.bsF.setSelection(0);
      return;
    } 
    String str2 = this.bsC.getText().toString().trim();
    if (TextUtils.isEmpty(str2)) {
      Toast.makeText(this, getString(R.string.pos_member_amount_can_not_be_empty), 1).show();
      this.bsC.requestFocus();
      this.bsC.setSelection(0);
      return;
    } 
    String str5 = this.bsD.getText().toString().trim();
    if (by.isNull(str5)) {
      Toast.makeText(this, getString(R.string.points_can_not_be_empty), 1).show();
      this.bsD.requestFocus();
      this.bsD.setSelection(0);
      return;
    } 
    if (n.pu(str5)) {
      Toast.makeText(this, getString(R.string.points_can_not_be_double), 1).show();
      this.bsD.requestFocus();
      this.bsD.setSelection(0);
      return;
    } 
    if (n.parseInt(str5) < 0) {
      Toast.makeText(this, getString(R.string.points_can_not_be_negative), 1).show();
      this.bsD.requestFocus();
      this.bsD.setSelection(0);
      return;
    } 
    if (this.bta.aWo >= 0.0D && n.parseInt(str2) < 0) {
      Toast.makeText(this, getString(R.string.amount_can_not_be_negative), 1).show();
      this.bsC.requestFocus();
      this.bsC.setSelection(0);
      return;
    } 
    if (by.isNull(str2)) {
      Toast.makeText(this, getString(R.string.amount_can_not_be_empty), 1).show();
      this.bsC.requestFocus();
      this.bsC.setSelection(0);
      return;
    } 
    String str3 = this.bsB.getText().toString().trim();
    if (str3.contains("'")) {
      n.w(this, R.string.pos_product_name_error);
      this.bsB.requestFocus();
      return;
    } 
    this.azI.setClickable(false);
    this.azI.setEnabled(false);
    this.azI.setFocusable(false);
    String str4 = this.bsz.getText().toString().trim();
    null = this.btg.getText().toString().trim();
    null = (new aq.a(this.bta.aSW, this.bsM, str1)).dz(str3).W(this.bta.aWo);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(System.currentTimeMillis());
    stringBuilder2.append("");
    aq aq1 = null.dF(stringBuilder2.toString()).dB(this.bsI).aw(this.bsY).dC(this.bsZ).dA(str4).dD(this.bta.aWq).dE(null).IW();
    double d = Double.valueOf(str2).doubleValue();
    aq1.aWy = d;
    if (str2 != null && !bm.a(d, this.bta.aWo, 2)) {
      aq1.aWA = Double.valueOf(str2).doubleValue() - Double.valueOf(this.bta.aWo).doubleValue();
      aq1.aWD = 370007L;
      try {
        PosMemberChargeModel posMemberChargeModel = new PosMemberChargeModel(this);
      } catch (Exception null) {
        a.e(null);
        null = null;
      } 
      if (!null.q(aq1)) {
        Toast.makeText(this, null.Vn(), 0).show();
        return;
      } 
      this.btb = true;
      this.bte = aq1.aWr;
    } 
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(System.currentTimeMillis());
    stringBuilder1.append("");
    aq1.aWr = stringBuilder1.toString();
    int i = by.parseInt(str5);
    aq1.aWp = i;
    if (!by.isNull(str5)) {
      d = this.bta.aWp;
      double d1 = i;
      if (!bm.a(d1, d, 2)) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.bta.aWp);
        stringBuilder1.append("");
        double d2 = by.parseDouble(stringBuilder1.toString());
        aq1.aWD = 370009L;
        aq1.aWA = 0.0D;
        if (this.btb) {
          d = by.parseDouble(str2);
        } else {
          d = this.bta.aWo;
        } 
        aq1.aWo = d;
        aq1.aWy = by.parseDouble(str2);
        aq1.aWE = d1 - d2;
        this.btc = true;
        try {
          PosMemberChargeModel posMemberChargeModel = new PosMemberChargeModel(this);
        } catch (Exception stringBuilder1) {
          a.e(stringBuilder1);
          stringBuilder1 = null;
        } 
        if (!stringBuilder1.r(aq1))
          this.handler.obtainMessage(this.bth, stringBuilder1.Vn()).sendToTarget(); 
        this.btf = aq1.aWr;
      } 
    } 
    if (!this.bta.aWq.equals(this.aWq))
      aq1.aWq = this.aWq; 
    if (RootApplication.getLaiqianPreferenceManager().Wq()) {
      if (!bd.bH(this)) {
        Toast.makeText(this, getString(R.string.please_check_network), 0).show();
      } else {
        (new a(this)).execute(new aq[] { aq1 });
      } 
    } else if (!k(aq1)) {
      return;
    } 
    if (this.btb || this.btc) {
      d = Double.valueOf(str2).doubleValue();
      double d1 = Double.valueOf(this.bta.aWo).doubleValue();
      if (!bd.bH(this))
        Toast.makeText(this, getString(R.string.please_check_network), 0).show(); 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.bta.aSW);
      stringBuilder1.append("");
      null = new b(this, this, stringBuilder1.toString(), this.bte);
      null.fu(this.btf);
      null.forceLoad();
      h h = new h();
      h.bGF = String.valueOf(d - d1);
      h.bGD = "0";
      h.aTp = aq1.aTp;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(d);
      stringBuilder.append("");
      h.aTt = stringBuilder.toString();
      if (bc.RH().fY("isOpenSMSNotice") && bc.RH().fY("isMemberChargeNoticed")) {
        h.bGE = "SMS_12205400";
        (new PosMemberAddModel.SendSmsTask(this, h)).forceLoad();
      } 
    } else if (!RootApplication.getLaiqianPreferenceManager().Wq()) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.bta.aSW);
      stringBuilder1.append("");
      (new b(this, this, stringBuilder1.toString())).forceLoad();
    } 
    sendBroadcast((new Intent()).setAction("pos_activity_change_data_vip"));
    if (!RootApplication.getLaiqianPreferenceManager().Wq()) {
      this.bta.aWn = this.bsM;
      this.bta.aTp = str1;
      this.bta.aWo = Double.parseDouble(str2);
      this.bta.name = str3;
      this.bta.dy(str4);
      this.bta.aWx = this.bsT.getText().toString().trim();
      this.bta.aVw = this.bsI;
      this.bta.aWw = this.bsY;
      this.bta.aWx = this.bsZ;
      sendBroadcast(new Intent(a.bwV));
      Intent intent = new Intent(this, MemberInfoActivity.class);
      intent.putExtra("id", this.bta.aSW);
      intent.putExtra("nBelongShopID", String.valueOf(this.bta.aWC));
      startActivity(intent);
      finish();
      Toast.makeText(this, getString(R.string.poj_success_update), 0).show();
    } 
  }
  
  private void wZ() {
    this.aNv = (ProgressBarCircularIndeterminate)findViewById(R.id.ivProgress);
    this.azI = (Button)findViewById(R.id.ui_titlebar_help_btn);
    this.azJ = (TextView)findViewById(R.id.ui_titlebar_txt);
    this.azJ.setFocusable(true);
    this.azJ.setFocusableInTouchMode(true);
    this.azJ.requestFocus();
    this.azJ.requestFocusFromTouch();
    this.bsA = (EditText)findViewById(R.id.etPosMemberNumber);
    this.bsB = (EditText)findViewById(R.id.etPosMemberName);
    this.bsC = (EditText)findViewById(R.id.etPosMemberAmount);
    this.bsC.setEnabled(this.bBoss);
    this.bsF = (EditText)findViewById(R.id.etPosMemberMobile);
    this.bsG = (Button)findViewById(R.id.btnDeleteMember);
    this.bsL = (LinearLayout)findViewById(R.id.llMemberStatus);
    this.bsK = (TextView)findViewById(R.id.tvPosMemberStatus);
    this.bsO = new String[] { getString(R.string.pos_member_card_in_use), getString(R.string.pos_member_card_in_lock) };
    this.bsz = (TextView)findViewById(R.id.tvPosMemberBirthday);
    this.bsE = (LinearLayout)findViewById(R.id.llPosMemberBirthday);
    this.azH = findViewById(R.id.ui_titlebar_back_btn);
    this.bsS = (LinearLayout)findViewById(R.id.member_rank_ll);
    this.bsT = (TextView)findViewById(R.id.member_rank_tv);
    this.btg = (EditText)findViewById(R.id.etPosMemberRemark);
    this.bti = (LinearLayout)findViewById(R.id.ll_remark);
    this.bti.setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
    this.bsD = (EditText)findViewById(R.id.et_points);
    boolean bool = this.bBoss;
    this.bsD.setEnabled(bool);
    if (!bool)
      this.bsD.setTextColor(-16777216); 
    this.btj = (LayoutLeftTextRightTextWithDialog)findViewById(R.id.member_effective_period);
  }
  
  private boolean xB() { // Byte code:
    //   0: aload_0
    //   1: getfield bsC : Landroid/widget/EditText;
    //   4: invokevirtual getText : ()Landroid/text/Editable;
    //   7: invokevirtual toString : ()Ljava/lang/String;
    //   10: invokevirtual trim : ()Ljava/lang/String;
    //   13: astore_2
    //   14: aload_0
    //   15: getfield bsD : Landroid/widget/EditText;
    //   18: invokevirtual getText : ()Landroid/text/Editable;
    //   21: invokevirtual toString : ()Ljava/lang/String;
    //   24: invokevirtual trim : ()Ljava/lang/String;
    //   27: astore_3
    //   28: aload_2
    //   29: astore_1
    //   30: ldc ''
    //   32: aload_2
    //   33: invokevirtual equals : (Ljava/lang/Object;)Z
    //   36: ifeq -> 43
    //   39: ldc_w '0'
    //   42: astore_1
    //   43: aload_0
    //   44: getfield bta : Lcom/laiqian/entity/aq;
    //   47: getfield aWx : Ljava/lang/String;
    //   50: aload_0
    //   51: getfield bsT : Landroid/widget/TextView;
    //   54: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   57: invokeinterface toString : ()Ljava/lang/String;
    //   62: invokevirtual trim : ()Ljava/lang/String;
    //   65: invokevirtual equals : (Ljava/lang/Object;)Z
    //   68: ifne -> 73
    //   71: iconst_1
    //   72: ireturn
    //   73: aload_0
    //   74: getfield bta : Lcom/laiqian/entity/aq;
    //   77: getfield aWn : Ljava/lang/String;
    //   80: aload_0
    //   81: getfield bsA : Landroid/widget/EditText;
    //   84: invokevirtual getText : ()Landroid/text/Editable;
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: invokevirtual trim : ()Ljava/lang/String;
    //   93: invokevirtual equals : (Ljava/lang/Object;)Z
    //   96: ifne -> 101
    //   99: iconst_1
    //   100: ireturn
    //   101: aload_0
    //   102: getfield bta : Lcom/laiqian/entity/aq;
    //   105: invokevirtual getBirthday : ()Ljava/lang/String;
    //   108: aload_0
    //   109: getfield bsz : Landroid/widget/TextView;
    //   112: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   115: invokeinterface toString : ()Ljava/lang/String;
    //   120: invokevirtual trim : ()Ljava/lang/String;
    //   123: invokevirtual equals : (Ljava/lang/Object;)Z
    //   126: ifne -> 131
    //   129: iconst_1
    //   130: ireturn
    //   131: aload_0
    //   132: getfield bta : Lcom/laiqian/entity/aq;
    //   135: getfield aTp : Ljava/lang/String;
    //   138: aload_0
    //   139: getfield bsF : Landroid/widget/EditText;
    //   142: invokevirtual getText : ()Landroid/text/Editable;
    //   145: invokevirtual toString : ()Ljava/lang/String;
    //   148: invokevirtual trim : ()Ljava/lang/String;
    //   151: invokevirtual equals : (Ljava/lang/Object;)Z
    //   154: ifne -> 159
    //   157: iconst_1
    //   158: ireturn
    //   159: aload_0
    //   160: getfield bta : Lcom/laiqian/entity/aq;
    //   163: getfield name : Ljava/lang/String;
    //   166: aload_0
    //   167: getfield bsB : Landroid/widget/EditText;
    //   170: invokevirtual getText : ()Landroid/text/Editable;
    //   173: invokevirtual toString : ()Ljava/lang/String;
    //   176: invokevirtual trim : ()Ljava/lang/String;
    //   179: invokevirtual equals : (Ljava/lang/Object;)Z
    //   182: ifne -> 187
    //   185: iconst_1
    //   186: ireturn
    //   187: aload_0
    //   188: getfield bta : Lcom/laiqian/entity/aq;
    //   191: getfield aVw : Ljava/lang/String;
    //   194: aload_0
    //   195: getfield bsI : Ljava/lang/String;
    //   198: invokevirtual equals : (Ljava/lang/Object;)Z
    //   201: ifne -> 206
    //   204: iconst_1
    //   205: ireturn
    //   206: aload_0
    //   207: getfield bta : Lcom/laiqian/entity/aq;
    //   210: getfield aWx : Ljava/lang/String;
    //   213: aload_0
    //   214: getfield bsZ : Ljava/lang/String;
    //   217: invokevirtual equals : (Ljava/lang/Object;)Z
    //   220: ifeq -> 462
    //   223: aload_0
    //   224: getfield bta : Lcom/laiqian/entity/aq;
    //   227: getfield aWw : J
    //   230: aload_0
    //   231: getfield bsY : J
    //   234: lcmp
    //   235: ifeq -> 240
    //   238: iconst_1
    //   239: ireturn
    //   240: aload_0
    //   241: getfield bta : Lcom/laiqian/entity/aq;
    //   244: getfield aWq : Ljava/lang/String;
    //   247: aload_0
    //   248: getfield aWq : Ljava/lang/String;
    //   251: invokevirtual equals : (Ljava/lang/Object;)Z
    //   254: ifne -> 259
    //   257: iconst_1
    //   258: ireturn
    //   259: ldc_w '-'
    //   262: aload_1
    //   263: invokevirtual equals : (Ljava/lang/Object;)Z
    //   266: ifne -> 281
    //   269: aload_1
    //   270: astore_2
    //   271: ldc_w '+'
    //   274: aload_1
    //   275: invokevirtual equals : (Ljava/lang/Object;)Z
    //   278: ifeq -> 313
    //   281: new java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial <init> : ()V
    //   288: astore_1
    //   289: aload_1
    //   290: aload_0
    //   291: getfield bta : Lcom/laiqian/entity/aq;
    //   294: getfield aWo : D
    //   297: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_1
    //   302: ldc ''
    //   304: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_1
    //   309: invokevirtual toString : ()Ljava/lang/String;
    //   312: astore_2
    //   313: ldc_w '-'
    //   316: aload_3
    //   317: invokevirtual equals : (Ljava/lang/Object;)Z
    //   320: ifne -> 335
    //   323: aload_3
    //   324: astore_1
    //   325: ldc_w '+'
    //   328: aload_3
    //   329: invokevirtual equals : (Ljava/lang/Object;)Z
    //   332: ifeq -> 367
    //   335: new java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial <init> : ()V
    //   342: astore_1
    //   343: aload_1
    //   344: aload_0
    //   345: getfield bta : Lcom/laiqian/entity/aq;
    //   348: getfield aWp : J
    //   351: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload_1
    //   356: ldc ''
    //   358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_1
    //   363: invokevirtual toString : ()Ljava/lang/String;
    //   366: astore_1
    //   367: aload_1
    //   368: invokestatic isNull : (Ljava/lang/String;)Z
    //   371: ifne -> 404
    //   374: aload_1
    //   375: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   378: invokevirtual doubleValue : ()D
    //   381: aload_0
    //   382: getfield bta : Lcom/laiqian/entity/aq;
    //   385: getfield aWp : J
    //   388: l2d
    //   389: invokestatic valueOf : (D)Ljava/lang/Double;
    //   392: invokevirtual doubleValue : ()D
    //   395: dsub
    //   396: invokestatic bc : (D)Z
    //   399: ifne -> 404
    //   402: iconst_1
    //   403: ireturn
    //   404: aload_2
    //   405: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   408: invokevirtual doubleValue : ()D
    //   411: aload_0
    //   412: getfield bta : Lcom/laiqian/entity/aq;
    //   415: getfield aWo : D
    //   418: invokestatic valueOf : (D)Ljava/lang/Double;
    //   421: invokevirtual doubleValue : ()D
    //   424: dsub
    //   425: invokestatic bc : (D)Z
    //   428: ifne -> 433
    //   431: iconst_1
    //   432: ireturn
    //   433: aload_0
    //   434: getfield bsJ : Ljava/lang/String;
    //   437: aload_0
    //   438: getfield bsK : Landroid/widget/TextView;
    //   441: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   444: invokeinterface toString : ()Ljava/lang/String;
    //   449: invokevirtual trim : ()Ljava/lang/String;
    //   452: invokevirtual equals : (Ljava/lang/Object;)Z
    //   455: ifne -> 460
    //   458: iconst_1
    //   459: ireturn
    //   460: iconst_0
    //   461: ireturn
    //   462: iconst_1
    //   463: ireturn }
  
  private void xC() {
    if (xB()) {
      this.aCz = new r(this, true, this.aCA);
      this.aCz.setTitle(getString(R.string.pos_confirm));
      this.aCz.s(getString(R.string.pos_is_saved));
      this.aCz.t(getString(R.string.auth_submitButton));
      this.aCz.oZ(getString(R.string.lqj_cancel));
      this.aCz.show();
      return;
    } 
    Intent intent = new Intent(this, MemberInfoActivity.class);
    intent.putExtra("id", this.bta.aSW);
    intent.putExtra("nBelongShopID", String.valueOf(this.bta.aWC));
    startActivity(intent);
    finish();
  }
  
  private bb xS() {
    if (this.mWaitingDialog == null)
      this.mWaitingDialog = new bb(this); 
    return this.mWaitingDialog;
  }
  
  private void xV() {
    this.bsQ = new UsbCardReceiver(this);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("com.laiqian.USB_PERMISSION");
    registerReceiver(this.bsQ, intentFilter);
  }
  
  private void xa() {
    this.bsL.setOnClickListener(this.btl);
    this.azI.setOnClickListener(this.azP);
    this.bsG.setOnClickListener(this.bto);
    this.bsA.setOnFocusChangeListener(this.btk);
    this.bsE.setOnClickListener(new c(this));
    this.azH.setOnClickListener(new h(this));
    PO();
    String[] arrayOfString = getResources().getStringArray(R.array.forever_list_member_effective_period);
    this.btj.a(arrayOfString, new i(this));
  }
  
  private void xb() {
    this.azJ.setText(R.string.pos_member_edit);
    this.azI.setText(R.string.pos_combo_save);
    this.bta = (aq)getIntent().getSerializableExtra("VIP_ENTITY");
    this.bsH = this.bta.getBirthday();
    if (this.bsH == null)
      this.bsH = "1990-1-1"; 
    this.bsz.setText(this.bsH);
    this.bsM = this.bta.aWn;
    this.bsA.setText(this.bta.aWn);
    if (this.bta.aTp == null)
      this.bta.aTp = ""; 
    this.bsF.setText(this.bta.aTp);
    if (this.bta.name == null)
      this.bta.name = ""; 
    this.bsB.setText(this.bta.name);
    this.btg.setText(this.bta.aJX);
    this.bsC.setText(n.a(Double.valueOf(this.bta.aWo), false));
    this.bsC.setFilters(ar.lw(9999));
    this.bsI = this.bta.aVw;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.bta.aWp);
    stringBuilder1.append("");
    int i = (int)by.parseDouble(stringBuilder1.toString());
    EditText editText = this.bsD;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(i);
    stringBuilder2.append("");
    editText.setText(stringBuilder2.toString());
    this.bsD.setFilters(ar.lw(9999));
    if (TextUtils.isEmpty(this.bsI))
      this.bsI = "0"; 
    if ("0".equals(this.bsI) || "380001".equals(this.bsI)) {
      this.bsN = 0;
      this.bsJ = getString(R.string.pos_member_card_in_use);
      this.bsK.setText(getString(R.string.pos_member_card_in_use));
    } else if ("380003".equals(this.bsI)) {
      this.bsN = 1;
      this.bsJ = getString(R.string.pos_member_card_in_lock);
      this.bsK.setText(getString(R.string.pos_member_card_in_lock));
    } else {
      this.bsN = 0;
      this.bsJ = getString(R.string.pos_member_card_in_use);
      this.bsK.setText(getString(R.string.pos_member_card_in_use));
    } 
    this.bsZ = this.bta.aWx;
    this.bsY = this.bta.aWw;
    if (this.bsZ == null)
      this.bsZ = "未设置"; 
    this.bsT.setText(this.bsZ);
    this.aPs = Long.parseLong(this.bta.aVq);
    this.aWq = this.bta.aWq;
    this.btj.oX(this.bta.IV());
  }
  
  public boolean beforeCloseActivity() {
    xC();
    return true;
  }
  
  public void onCreate(Bundle paramBundle) {
    boolean bool;
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.pos_member_change);
    getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    if (this.aDO < 12) {
      bool = true;
    } else {
      bool = false;
    } 
    this.aDM = bool;
    if (!this.aDM)
      xV(); 
    av = new av(this);
    String str = av.atp();
    av.close();
    this.bBoss = "150001".equals(str);
    wZ();
    PP();
    xb();
    try {
      xa();
      return;
    } catch (JSONException av) {
      a.e(av);
      return;
    } 
  }
  
  protected void onDestroy() {
    if (!this.aDM)
      unregisterReceiver(this.bsQ); 
    super.onDestroy();
  }
  
  public void onPause() {
    super.onPause();
    if (this.aDP != null)
      this.aDP.stop(); 
  }
  
  public void onResume() {
    super.onResume();
    if (!this.bBoss) {
      this.bsG.setVisibility(8);
    } else {
      this.bsG.setVisibility(0);
    } 
    this.bsR = am.ba(this).afs().size();
    if (this.bsR == 0) {
      this.bsA.setHint("");
      return;
    } 
    if (this.bsR > 0)
      this.bsA.setHint(getString(R.string.pos_member_read_card)); 
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean && this.bsP) {
      this.bsA.requestFocus();
      return;
    } 
    if (this.bsA.hasFocus()) {
      this.bsP = true;
    } else {
      this.bsP = false;
    } 
    this.bsA.clearFocus();
  }
  
  public class UsbCardReceiver extends BroadcastReceiver {
    public UsbCardReceiver(MemberChangeActivity this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      String str = param1Intent.getAction();
      if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(str)) {
        bz bz;
        if ((bz = this.btq.aDP).aE(this.btq))
          if (this.btq.bsA.hasFocus()) {
            this.btq.aDP = bz.Qw();
            this.btq.aDP.a(this.btq, 500L, this.btq.aDQ);
            this.btq.aDP.start();
          } else if (this.btq.aDP != null) {
            this.btq.aDP.stop();
          }  
      } 
      if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(str)) {
        bz bz;
        if ((!(bz = this.btq.aDP).aE(this.btq) || !this.btq.bsA.hasFocus()) && this.btq.aDP != null)
          this.btq.aDP.stop(); 
      } 
    }
  }
  
  class a extends AsyncTask<aq, Object, Boolean> {
    String btw;
    
    a(MemberChangeActivity this$0) {}
    
    protected Boolean a(aq[] param1ArrayOfaq) {
      HashMap hashMap = new HashMap();
      String str2 = new StringBuilder();
      str2.append((param1ArrayOfaq[0]).aSW);
      str2.append("");
      hashMap.put("_id", str2.toString());
      hashMap.put("sNumber", (param1ArrayOfaq[0]).aWn);
      str2 = new StringBuilder();
      str2.append((param1ArrayOfaq[0]).aWw);
      str2.append("");
      hashMap.put("nBPartnerType", str2.toString());
      str2 = new StringBuilder();
      str2.append((param1ArrayOfaq[0]).aWx);
      str2.append("");
      hashMap.put("sBPartnerTypeName", str2.toString());
      hashMap.put("sContactPerson", (param1ArrayOfaq[0]).name);
      hashMap.put("sName", (param1ArrayOfaq[0]).name);
      hashMap.put("sContactMobilePhone", (param1ArrayOfaq[0]).aTp);
      hashMap.put("nSpareField1", (param1ArrayOfaq[0]).aVw);
      hashMap.put("sSpareField1", param1ArrayOfaq[0].getBirthday());
      hashMap.put("sIsMember", "Y");
      hashMap.put("sField1", (param1ArrayOfaq[0]).aJX);
      hashMap.put("nUserID", RootApplication.getLaiqianPreferenceManager().atm());
      str2 = new StringBuilder();
      str2.append((MemberChangeActivity.j(this.btq)).aWC);
      str2.append("");
      hashMap.put("shop_id", str2.toString());
      hashMap.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
      hashMap.put("password", RootApplication.getLaiqianPreferenceManager().atr());
      hashMap.put("auth_type", "0");
      hashMap.put("version", "2");
      if (RootApplication.getLaiqianPreferenceManager().avl()) {
        String str = "0";
      } else {
        str2 = "1";
      } 
      hashMap.put("scope", str2);
      hashMap.put("fSpareField3", (param1ArrayOfaq[0]).aWq);
      String str1 = bh.a(a.cqy, RootApplication.zv().getApplicationContext(), hashMap);
      if (!TextUtils.isEmpty(str1)) {
        HashMap hashMap1 = au.qB(str1);
        if (hashMap1.containsKey("result") && "TRUE".equals(String.valueOf(hashMap1.get("result")))) {
          Log.e("vipedit", String.valueOf(hashMap1.get("message")));
          return Boolean.valueOf(true);
        } 
        if (hashMap1.containsKey("result") && "FALSE".equals(String.valueOf(hashMap1.get("result")))) {
          this.btw = String.valueOf(hashMap1.get("message"));
          return Boolean.valueOf(false);
        } 
        this.btw = this.btq.getString(R.string.save_settings_failed);
        return Boolean.valueOf(false);
      } 
      this.btw = this.btq.getString(R.string.save_settings_failed);
      return Boolean.valueOf(false);
    }
    
    protected void b(Boolean param1Boolean) {
      MemberChangeActivity.q(this.btq).setVisibility(0);
      this.btq.aNv.setVisibility(8);
      if (param1Boolean.booleanValue()) {
        (MemberChangeActivity.j(this.btq)).aWn = this.btq.bsA.getText().toString();
        (MemberChangeActivity.j(this.btq)).aTp = this.btq.bsF.getText().toString();
        (MemberChangeActivity.j(this.btq)).aWo = Double.parseDouble(this.btq.bsC.getText().toString());
        (MemberChangeActivity.j(this.btq)).name = this.btq.bsB.getText().toString();
        MemberChangeActivity.j(this.btq).dy(this.btq.bsz.getText().toString());
        (MemberChangeActivity.j(this.btq)).aWx = MemberChangeActivity.d(this.btq).getText().toString().trim();
        (MemberChangeActivity.j(this.btq)).aVw = this.btq.bsI;
        (MemberChangeActivity.j(this.btq)).aWw = MemberChangeActivity.r(this.btq);
        (MemberChangeActivity.j(this.btq)).aWx = MemberChangeActivity.g(this.btq);
        Intent intent = new Intent(a.bwV);
        intent.putExtra("isEditMember", true);
        this.btq.sendBroadcast(intent);
        MemberChangeActivity.l(this.btq).postDelayed(new t(this), 1000L);
        return;
      } 
      Toast.makeText(this.btq, this.btw, 0).show();
      MemberChangeActivity.q(this.btq).setClickable(true);
      MemberChangeActivity.q(this.btq).setEnabled(true);
      MemberChangeActivity.q(this.btq).setFocusable(true);
    }
    
    protected void onPreExecute() {
      MemberChangeActivity.q(this.btq).setVisibility(8);
      this.btq.aNv.setVisibility(0);
    }
  }
  
  private class b extends AsyncTaskLoader<Boolean> {
    private String btA;
    
    private String btB;
    
    private String btz;
    
    public b(MemberChangeActivity this$0, Context param1Context, String param1String) {
      super(param1Context);
      this.btz = param1String;
    }
    
    public b(MemberChangeActivity this$0, Context param1Context, String param1String1, String param1String2) {
      super(param1Context);
      this.btz = param1String1;
      this.btA = param1String2;
    }
    
    public Boolean LN() {
      boolean bool;
      OnlineSyncRequest.a a = new OnlineSyncRequest.a();
      f f2 = null;
      try {
        exception = new l(getContext());
      } catch (Exception exception) {
        a.e(exception);
        exception = null;
      } 
      ArrayList arrayList = exception.hd(this.btz);
      if (MemberChangeActivity.n(this.btq)) {
        a.a(arrayList, 3);
      } else {
        a.a(arrayList, 2);
      } 
      exception.close();
      if (MemberChangeActivity.o(this.btq) || MemberChangeActivity.p(this.btq)) {
        try {
          j j = new j(getContext());
        } catch (Exception exception) {
          a.e(exception);
          exception = null;
        } 
        if (!by.isNull(this.btA))
          a.a(exception.hd(this.btA), 1); 
        if (!by.isNull(this.btB))
          a.a(exception.hd(this.btB), 1); 
        exception.close();
      } 
      null = new av(getContext());
      a.iM(null.Ea());
      a.iN(null.atr());
      a.bV(Long.parseLong(null.Tx()));
      null.close();
      f1 = f.bXQ;
      try {
        bool = (f1.b(a.Xj())).bXV;
      } catch (Exception f1) {
        h.awP().a(new d(MemberChangeActivity.class.getSimpleName(), "onlineSync", "请求实时同步失败--", f1.getMessage()), h.a.dHw, h.b.dHD);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请求实时同步失败");
        stringBuilder.append(f1.getMessage());
        d.b(stringBuilder.toString(), new Object[0]);
        a.e(f1);
        bool = false;
      } 
      if (MemberChangeActivity.p(this.btq)) {
        try {
          PosMemberChargeModel posMemberChargeModel = new PosMemberChargeModel(this.btq);
        } catch (Exception f1) {
          a.e(f1);
          f1 = f2;
        } 
        if (RootApplication.getLaiqianPreferenceManager().Wq() && !bool)
          f1.hc(this.btB); 
      } 
      return Boolean.valueOf(bool);
    }
    
    public void fu(String param1String) { this.btB = param1String; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\MemberChangeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */