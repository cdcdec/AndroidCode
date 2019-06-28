package com.laiqian.member.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.member.d.a;
import com.laiqian.models.aj;
import com.laiqian.models.bg;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.a;
import com.laiqian.ui.a.ab;
import com.laiqian.ui.a.w;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.ck;
import com.laiqian.util.n;
import com.laiqian.util.z;
import com.laiqian.vip.R;
import io.reactivex.g.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class VipReportActivity extends ActivityRoot implements an {
  protected String Ze;
  
  private long[][] bqA;
  
  private String[][] bqB;
  
  private w bqC;
  
  private View bqD;
  
  private TextView bqE;
  
  private View bqF;
  
  private String[] bqG;
  
  private long[] bqH;
  
  private long[] bqI;
  
  private String[] bqJ;
  
  private String[] bqK;
  
  private boolean bqL;
  
  protected int bqM;
  
  public ViewGroup bqN;
  
  private int bqO;
  
  FormListView.c bqR = new o(this);
  
  private FormListView bqp;
  
  private e bqq;
  
  private FrameLayout bqr;
  
  protected long[] bqs = { 0L, 0L };
  
  private a bqt;
  
  private View[] bqu;
  
  private TextView bqv;
  
  private TextView bqw;
  
  private View[] bqx;
  
  private w bqy;
  
  private String[] bqz;
  
  private TextView btM;
  
  private TextView btN;
  
  private TextView btO;
  
  private int btX;
  
  w btY;
  
  w btZ;
  
  private String[] buO;
  
  w bua;
  
  w bub;
  
  private View bud;
  
  String[] bul;
  
  boolean bum = false;
  
  Handler bus = new Handler(new m(this));
  
  private View bzA;
  
  View.OnClickListener bzB = new i(this);
  
  AdapterView.OnItemClickListener bzC = new l(this);
  
  private LinearLayout bzd;
  
  private TextView bze;
  
  private LinearLayout bzf;
  
  private TextView bzg;
  
  private LinearLayout bzh;
  
  private TextView bzi;
  
  private LinearLayout bzj;
  
  private am bzk;
  
  private View bzl;
  
  private w bzm;
  
  private long[] bzn;
  
  private String[] bzo;
  
  protected View bzp;
  
  LinearLayout bzq;
  
  a bzr;
  
  private TextView bzs;
  
  private TextView bzt;
  
  private TextView bzu;
  
  public ViewGroup bzv;
  
  public LinearLayout bzw;
  
  private ab bzx;
  
  private View bzy;
  
  private View bzz;
  
  Context context;
  
  private void PA() {
    if (RootUrlParameter.bDebug) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("选择的开始日期是：");
      stringBuilder.append(this.bqs[0]);
      stringBuilder.append(",");
      stringBuilder.append(simpleDateFormat.format(new Date(this.bqs[0])));
      n.println(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("选择的结束日期是：");
      stringBuilder.append(this.bqs[1]);
      stringBuilder.append(",");
      stringBuilder.append(simpleDateFormat.format(new Date(this.bqs[1])));
      n.println(stringBuilder.toString());
    } 
  }
  
  private void PR() {
    this.bzt.setText(R.string.mc_total_consume_txt);
    this.bzs.setText(R.string.mc_total_increment_amount_txt);
    this.bzu.setText(R.string.mc_total_consume_txt);
    this.bzt.setVisibility(4);
    this.btN.setVisibility(4);
    if (RootApplication.getLaiqianPreferenceManager().Wq()) {
      a.aKh().r(new g(this));
      return;
    } 
    HashMap hashMap = this.bzk.Ri();
    if (hashMap != null) {
      this.btO.setText((CharSequence)hashMap.get("totalGiftPoint"));
      String str = ((String)hashMap.get("totalConsumePoint")).replace("-", "");
      this.btM.setText((CharSequence)hashMap.get("fTotalPoint"));
      this.btM.setText(str);
    } 
  }
  
  private void PS() {
    if (this.bub != null)
      return; 
    this.bub = new w(this.context, this.bzk.PW(), new ah(this));
    this.bub.gn(0);
  }
  
  private void Py() {
    QZ();
    Pz();
  }
  
  private void Pz() {
    if (!this.bum) {
      this.bzt.setText(R.string.pos_member_total_gift_amount);
      this.bzs.setText(R.string.pos_member_total_charge_amount);
      this.bzu.setText(R.string.pos_member_total_consume_amount);
      if (RootApplication.getLaiqianPreferenceManager().Wq()) {
        a.aKh().r(new h(this));
      } else {
        this.btM.setText(this.bzk.a(false, new String[] { "370005" }));
        this.btN.setText(this.bzk.a(true, new String[] { "370004", "370010" }));
        this.btO.setText(this.bzk.a(false, new String[] { "370004", "370007", "370010" }));
      } 
    } 
    this.bzk.Qc();
    this.bqp.initData();
    if (ck.ml(this.bqp.getList().size())) {
      this.bud.setVisibility(8);
    } else {
      this.bud.setVisibility(0);
    } 
    if (this.bqq == null) {
      this.bqq = new n(this, this, this.bqp.getList(), this.bqp);
    } else {
      this.bqq.m(this.bqp.getList());
    } 
    this.bqp.setAdapter(this.bqq);
    FormListView formListView = this.bqp;
    String str = this.bzk.Qd();
    String[] arrayOfString1 = this.bzk.Qe();
    String[] arrayOfString2 = this.bzk.buM.Fu();
    formListView.setData(this, str, arrayOfString1, new String[] { 
          "nOperationTime", "fChargeAmount", "nChargeType", "fOldAmount", "fNewAmount", "points", "nSpareField2", "nSpareField3", "nWarehouseID", "nBPartnerID", 
          "nUserID", "sBPartnerNumber", "sBPartnerName", "sBPartnerMobile", "sSpareField5", "sText" }, arrayOfString2);
    this.bul = this.bzk.Qe();
    this.bzk.closeDB();
  }
  
  private void QW() {
    View.inflate(this, R.layout.pos_report_export_button_alone, this.bzq);
    this.bzp = this.bzq.getChildAt(this.bzq.getChildCount() - 1);
    this.bzp.setOnClickListener(this.bzB);
  }
  
  private void QX() {
    this.bzh.setOnClickListener(new p(this));
    try {
      exception = new bg(this);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    ArrayList arrayList = exception.Wz();
    int i = arrayList.size();
    byte b = 1;
    this.bzn = new long[++i];
    this.bzn[0] = 0L;
    this.bzo = new String[i];
    this.bzo[0] = getString(R.string.pos_report_transaction_user_all);
    String[] arrayOfString = new String[i];
    arrayOfString[0] = getString(R.string.pos_report_transaction_user_all);
    while (b < i) {
      null = (HashMap)arrayList.get(b - true);
      this.bzn[b] = Long.parseLong((String)null.get("id"));
      String str1 = (String)null.get("phone");
      String str2 = (String)null.get("name");
      if (str2 == null || str2.length() == 0) {
        this.bzo[b] = str1;
        arrayOfString[b] = str1;
      } else {
        this.bzo[b] = str2;
        if (str2.equals(str1)) {
          arrayOfString[b] = str1;
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str1);
          stringBuilder.append("  ");
          stringBuilder.append(str2);
          arrayOfString[b] = stringBuilder.toString();
        } 
      } 
      b++;
    } 
    exception.close();
    this.bzm = new w(this, arrayOfString, new q(this));
    fB(0);
  }
  
  private void QY() { this.bzk.dJ(" and nSpareField1!=0 "); }
  
  private void QZ() {
    if (this.bzd.getVisibility() == 8 || this.bzd.getVisibility() == 4) {
      String str = "";
      switch (QV()) {
        case 4:
          str = this.bzk.PW()[0];
          break;
        case 3:
          str = this.bzk.Qb()[0];
          break;
        case 2:
          str = this.bzk.Qa()[0];
          break;
        case 1:
          str = this.bzk.PZ()[0];
          break;
      } 
      if (!"0".equals(this.bzk.getUserID()) || !str.equals(this.bzg.getText().toString().trim())) {
        this.bzj.setVisibility(0);
        return;
      } 
      this.bzj.setVisibility(8);
      return;
    } 
    if (!"0".equals(this.bzk.getUserID()) || !this.buO[0].equals(this.bze.getText().toString().trim())) {
      this.bzj.setVisibility(0);
      return;
    } 
    this.bzj.setVisibility(8);
  }
  
  private void a(long paramLong1, long paramLong2, String paramString1, String paramString2) { // Byte code:
    //   0: aload_0
    //   1: getfield bqs : [J
    //   4: iconst_0
    //   5: lload_1
    //   6: lastore
    //   7: aload_0
    //   8: getfield bqs : [J
    //   11: iconst_1
    //   12: lload_3
    //   13: lastore
    //   14: aload_0
    //   15: getfield bzk : Lcom/laiqian/member/report/am;
    //   18: aload_0
    //   19: getfield bqs : [J
    //   22: invokevirtual f : ([J)V
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore #7
    //   34: aload #7
    //   36: invokestatic getInstance : ()Ljava/util/Calendar;
    //   39: iconst_1
    //   40: invokevirtual get : (I)I
    //   43: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload #7
    //   49: ldc_w ''
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload #5
    //   58: aload #7
    //   60: invokevirtual toString : ()Ljava/lang/String;
    //   63: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   66: ifeq -> 142
    //   69: new java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial <init> : ()V
    //   76: astore #7
    //   78: aload #7
    //   80: invokestatic getInstance : ()Ljava/util/Calendar;
    //   83: iconst_1
    //   84: invokevirtual get : (I)I
    //   87: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload #7
    //   93: ldc_w ''
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload #6
    //   102: aload #7
    //   104: invokevirtual toString : ()Ljava/lang/String;
    //   107: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   110: ifeq -> 142
    //   113: aload_0
    //   114: getfield bqv : Landroid/widget/TextView;
    //   117: aload #5
    //   119: iconst_5
    //   120: invokevirtual substring : (I)Ljava/lang/String;
    //   123: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   126: aload_0
    //   127: getfield bqw : Landroid/widget/TextView;
    //   130: aload #6
    //   132: iconst_5
    //   133: invokevirtual substring : (I)Ljava/lang/String;
    //   136: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   139: goto -> 160
    //   142: aload_0
    //   143: getfield bqv : Landroid/widget/TextView;
    //   146: aload #5
    //   148: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   151: aload_0
    //   152: getfield bqw : Landroid/widget/TextView;
    //   155: aload #6
    //   157: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   160: aload_0
    //   161: getfield bqv : Landroid/widget/TextView;
    //   164: lload_1
    //   165: invokestatic valueOf : (J)Ljava/lang/Long;
    //   168: invokevirtual setTag : (Ljava/lang/Object;)V
    //   171: aload_0
    //   172: getfield bqw : Landroid/widget/TextView;
    //   175: lload_3
    //   176: invokestatic valueOf : (J)Ljava/lang/Long;
    //   179: invokevirtual setTag : (Ljava/lang/Object;)V
    //   182: aload_0
    //   183: invokespecial PA : ()V
    //   186: return }
  
  private void a(View... paramVarArgs) {
    for (byte b = 0; b < this.bqx.length; b++)
      this.bqx[b].setSelected(n.a(this.bqx[b], paramVarArgs)); 
  }
  
  private void fB(int paramInt) {
    boolean bool;
    if (this.bzm == null)
      return; 
    this.bzm.gn(paramInt);
    this.bzi.setText(this.bzo[paramInt]);
    this.bzk.dd(String.valueOf(this.bzn[paramInt]));
    TextView textView = this.bzi;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    textView.setSelected(bool);
    QZ();
  }
  
  private void o(int paramInt, boolean paramBoolean) {
    this.bqy.gn(paramInt);
    this.bqO = 4;
    a(new View[] { this.bqF });
    long[] arrayOfLong = this.bqA[paramInt];
    String[] arrayOfString = this.bqB[paramInt];
    a(arrayOfLong[0], arrayOfLong[1], arrayOfString[0], arrayOfString[1]);
    if (paramBoolean)
      Py(); 
  }
  
  private void setListeners() {
    if (RootApplication.getLaiqianPreferenceManager().Wq())
      this.bqp.setOnLoadListener(this.bqR); 
    this.bqN.setOnClickListener(new v(this));
    QX();
    if (QV() == 3 || QV() == 4)
      QY(); 
    if (QV() == 1)
      this.bzk.h(new String[] { "370005" }); 
    if (QV() == 2)
      this.bzk.h(new String[] { "370004", "370007", "370010" }); 
    if (!getActivity().getResources().getBoolean(R.bool.show_all_mobile_version))
      this.bzl.setVisibility(8); 
    this.bqp.setOnPreLoadListener(new x(this));
    this.bqp.setOnAfterLoadListener(new y(this));
    this.bqp.setOnItemClickListener(this.bzC);
    this.bzd.setOnClickListener(new z(this));
    this.bzf.setOnClickListener(new ab(this));
    this.bzj.setOnClickListener(new ag(this));
  }
  
  private void setupViews() {
    Time time = new Time();
    time.setToNow();
    this.bqM = time.year;
    this.bze.setText(this.buO[0]);
  }
  
  private void v(View paramView, int paramInt) {
    this.bqE.setText(this.bqG[paramInt]);
    this.bqO = paramInt;
    a(new View[] { paramView });
    a(this.bqH[paramInt], this.bqI[paramInt], this.bqJ[paramInt], this.bqK[paramInt]);
  }
  
  private void wR() {
    this.bzx = new ab(this);
    ((TextView)findViewById(R.id.ui_titlebar_txt)).setText(R.string.pos_member_report);
    findViewById(R.id.ui_titlebar_help_btn).setVisibility(8);
    this.bzr = new a(this);
    this.bzq = (LinearLayout)findViewById(R.id.layout_right);
    this.bzq.setVisibility(0);
    this.bqN = (ViewGroup)findViewById(R.id.llRefresh);
    this.bzv = (ViewGroup)findViewById(R.id.llProgress);
    this.bzw = (LinearLayout)findViewById(R.id.ll_blank_views);
    findViewById(R.id.show_type_l).setVisibility(8);
    findViewById(R.id.select_product).setVisibility(8);
    this.bqp = (FormListView)findViewById(R.id.lvReport);
    this.bqp.setIsTransaction(true);
    LinearLayout linearLayout = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.pos_member_report_head_max, null);
    linearLayout.findViewById(R.id.llChargeType).setVisibility(8);
    this.bzy = linearLayout.findViewById(R.id.ll_pos_member_total_consume_amount);
    this.bzz = linearLayout.findViewById(R.id.ll_pos_member_total_gift_amount);
    this.bzA = linearLayout.findViewById(R.id.ll_pos_member_total_charge_amount);
    this.btM = (TextView)linearLayout.findViewById(R.id.tvTotalConsumeAmount);
    this.btN = (TextView)linearLayout.findViewById(R.id.tv_total_gift_amount);
    this.btO = (TextView)linearLayout.findViewById(R.id.tvTotalChargeAmount);
    this.bzs = (TextView)linearLayout.findViewById(R.id.tv_total_text);
    this.bzt = (TextView)linearLayout.findViewById(R.id.tv_gift_text);
    this.bzu = (TextView)linearLayout.findViewById(R.id.tv_consume_text);
    this.bzl = findViewById(R.id.pos_report_nodata_image_l);
    this.bqp.addHeaderView(linearLayout);
    this.bqr = (FrameLayout)findViewById(R.id.no_data);
    this.bzd = (LinearLayout)findViewById(R.id.pay_mode_l);
    this.bze = (TextView)findViewById(R.id.pay_mode);
    findViewById(R.id.select_pay_sales).setVisibility(8);
    ((TextView)findViewById(R.id.tv_select_able)).setText(getString(R.string.pos_member_report_type));
    findViewById(R.id.select_pay_sales).setVisibility(8);
    this.bzf = (LinearLayout)findViewById(R.id.pay_second_mode_l);
    this.bzg = (TextView)findViewById(R.id.pay_second_mode);
    ((TextView)findViewById(R.id.tv_second_type)).setText(R.string.pos_member_report_child_type);
    this.bzh = (LinearLayout)findViewById(R.id.select_user);
    this.bzi = (TextView)findViewById(R.id.user);
    this.bzj = (LinearLayout)findViewById(R.id.clear);
    this.bud = findViewById(R.id.first_blank_item);
  }
  
  public void PB() { // Byte code:
    //   0: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   3: invokevirtual Cc : ()Ljava/lang/String;
    //   6: astore #11
    //   8: aload #11
    //   10: invokestatic isNull : (Ljava/lang/String;)Z
    //   13: ifne -> 136
    //   16: aload #11
    //   18: ldc_w '-'
    //   21: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   24: ifeq -> 136
    //   27: aload #11
    //   29: ldc_w '-'
    //   32: ldc_w ':'
    //   35: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   38: ldc_w ':'
    //   41: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   44: astore #11
    //   46: aload #11
    //   48: arraylength
    //   49: iconst_4
    //   50: if_icmpne -> 136
    //   53: aload #11
    //   55: iconst_0
    //   56: aaload
    //   57: invokestatic parseInt : (Ljava/lang/String;)I
    //   60: istore_1
    //   61: aload #11
    //   63: iconst_1
    //   64: aaload
    //   65: invokestatic parseInt : (Ljava/lang/String;)I
    //   68: istore #4
    //   70: aload #11
    //   72: iconst_2
    //   73: aaload
    //   74: invokestatic parseInt : (Ljava/lang/String;)I
    //   77: istore_3
    //   78: aload #11
    //   80: iconst_3
    //   81: aaload
    //   82: invokestatic parseInt : (Ljava/lang/String;)I
    //   85: istore_2
    //   86: new android/text/format/Time
    //   89: dup
    //   90: invokespecial <init> : ()V
    //   93: astore #11
    //   95: aload #11
    //   97: invokevirtual setToNow : ()V
    //   100: aload #11
    //   102: getfield hour : I
    //   105: iload_1
    //   106: if_icmplt -> 128
    //   109: aload #11
    //   111: getfield hour : I
    //   114: iload_1
    //   115: if_icmpne -> 133
    //   118: aload #11
    //   120: getfield minute : I
    //   123: iload #4
    //   125: if_icmpge -> 133
    //   128: aload_0
    //   129: iconst_1
    //   130: putfield bqL : Z
    //   133: goto -> 147
    //   136: bipush #23
    //   138: istore_3
    //   139: bipush #59
    //   141: istore_2
    //   142: iconst_0
    //   143: istore #4
    //   145: iconst_0
    //   146: istore_1
    //   147: aload_0
    //   148: iconst_4
    //   149: anewarray java/lang/String
    //   152: putfield bqG : [Ljava/lang/String;
    //   155: aload_0
    //   156: iconst_4
    //   157: newarray long
    //   159: putfield bqH : [J
    //   162: aload_0
    //   163: iconst_4
    //   164: newarray long
    //   166: putfield bqI : [J
    //   169: aload_0
    //   170: iconst_4
    //   171: anewarray java/lang/String
    //   174: putfield bqJ : [Ljava/lang/String;
    //   177: aload_0
    //   178: iconst_4
    //   179: anewarray java/lang/String
    //   182: putfield bqK : [Ljava/lang/String;
    //   185: new android/text/format/Time
    //   188: dup
    //   189: invokespecial <init> : ()V
    //   192: astore #11
    //   194: aload_0
    //   195: getfield bqG : [Ljava/lang/String;
    //   198: iconst_0
    //   199: aload_0
    //   200: getstatic com/laiqian/vip/R$string.pos_report_fastSelect_today : I
    //   203: invokevirtual getString : (I)Ljava/lang/String;
    //   206: aastore
    //   207: aload #11
    //   209: invokevirtual setToNow : ()V
    //   212: aload #11
    //   214: iconst_0
    //   215: iconst_0
    //   216: iconst_0
    //   217: aload #11
    //   219: getfield monthDay : I
    //   222: aload #11
    //   224: getfield month : I
    //   227: aload #11
    //   229: getfield year : I
    //   232: invokevirtual set : (IIIIII)V
    //   235: aload #11
    //   237: iconst_0
    //   238: invokevirtual normalize : (Z)J
    //   241: lstore #5
    //   243: iload_1
    //   244: iload #4
    //   246: iload_3
    //   247: iload_2
    //   248: invokestatic q : (IIII)Z
    //   251: ifne -> 265
    //   254: lload #5
    //   256: ldc2_w 86400000
    //   259: ladd
    //   260: lstore #5
    //   262: goto -> 265
    //   265: lload #5
    //   267: iload_3
    //   268: bipush #60
    //   270: imul
    //   271: bipush #60
    //   273: imul
    //   274: sipush #1000
    //   277: imul
    //   278: i2l
    //   279: ladd
    //   280: iload_2
    //   281: bipush #60
    //   283: imul
    //   284: sipush #1000
    //   287: imul
    //   288: i2l
    //   289: ladd
    //   290: lstore #7
    //   292: lload #7
    //   294: invokestatic currentTimeMillis : ()J
    //   297: lcmp
    //   298: ifge -> 309
    //   301: invokestatic currentTimeMillis : ()J
    //   304: lstore #5
    //   306: goto -> 313
    //   309: lload #7
    //   311: lstore #5
    //   313: aload_0
    //   314: getfield bqI : [J
    //   317: iconst_0
    //   318: lload #5
    //   320: lastore
    //   321: aload #11
    //   323: lload #5
    //   325: invokevirtual set : (J)V
    //   328: aload_0
    //   329: getfield bqK : [Ljava/lang/String;
    //   332: iconst_0
    //   333: aload #11
    //   335: aload_0
    //   336: getfield Ze : Ljava/lang/String;
    //   339: invokevirtual format : (Ljava/lang/String;)Ljava/lang/String;
    //   342: aastore
    //   343: aload #11
    //   345: invokevirtual setToNow : ()V
    //   348: aload #11
    //   350: iconst_0
    //   351: iload #4
    //   353: iload_1
    //   354: aload #11
    //   356: getfield monthDay : I
    //   359: aload #11
    //   361: getfield month : I
    //   364: aload #11
    //   366: getfield year : I
    //   369: invokevirtual set : (IIIIII)V
    //   372: aload #11
    //   374: iconst_0
    //   375: invokevirtual normalize : (Z)J
    //   378: lstore #9
    //   380: aload_0
    //   381: getfield bqH : [J
    //   384: iconst_0
    //   385: lload #9
    //   387: lastore
    //   388: aload_0
    //   389: getfield bqJ : [Ljava/lang/String;
    //   392: iconst_0
    //   393: aload #11
    //   395: aload_0
    //   396: getfield Ze : Ljava/lang/String;
    //   399: invokevirtual format : (Ljava/lang/String;)Ljava/lang/String;
    //   402: aastore
    //   403: aload_0
    //   404: getfield bqG : [Ljava/lang/String;
    //   407: iconst_1
    //   408: aload_0
    //   409: getstatic com/laiqian/vip/R$string.pos_report_fastSelect_yesterday : I
    //   412: invokevirtual getString : (I)Ljava/lang/String;
    //   415: aastore
    //   416: aload_0
    //   417: getfield bqL : Z
    //   420: ifeq -> 431
    //   423: invokestatic currentTimeMillis : ()J
    //   426: lstore #5
    //   428: goto -> 439
    //   431: lload #7
    //   433: ldc2_w 86400000
    //   436: lsub
    //   437: lstore #5
    //   439: aload #11
    //   441: lload #5
    //   443: invokevirtual set : (J)V
    //   446: aload_0
    //   447: getfield bqI : [J
    //   450: iconst_1
    //   451: aload #11
    //   453: iconst_0
    //   454: invokevirtual normalize : (Z)J
    //   457: lastore
    //   458: aload_0
    //   459: getfield bqK : [Ljava/lang/String;
    //   462: iconst_1
    //   463: aload #11
    //   465: aload_0
    //   466: getfield Ze : Ljava/lang/String;
    //   469: invokevirtual format : (Ljava/lang/String;)Ljava/lang/String;
    //   472: aastore
    //   473: aload #11
    //   475: lload #9
    //   477: ldc2_w 86400000
    //   480: lsub
    //   481: invokevirtual set : (J)V
    //   484: aload_0
    //   485: getfield bqH : [J
    //   488: iconst_1
    //   489: aload #11
    //   491: iconst_0
    //   492: invokevirtual normalize : (Z)J
    //   495: lastore
    //   496: aload_0
    //   497: getfield bqJ : [Ljava/lang/String;
    //   500: iconst_1
    //   501: aload #11
    //   503: aload_0
    //   504: getfield Ze : Ljava/lang/String;
    //   507: invokevirtual format : (Ljava/lang/String;)Ljava/lang/String;
    //   510: aastore
    //   511: aload #11
    //   513: iconst_0
    //   514: iconst_0
    //   515: iconst_0
    //   516: aload #11
    //   518: getfield monthDay : I
    //   521: aload #11
    //   523: getfield month : I
    //   526: aload #11
    //   528: getfield year : I
    //   531: invokevirtual set : (IIIIII)V
    //   534: aload_0
    //   535: getfield bqG : [Ljava/lang/String;
    //   538: iconst_2
    //   539: aload_0
    //   540: getstatic com/laiqian/vip/R$string.pos_report_fastSelect_oneWeek : I
    //   543: invokevirtual getString : (I)Ljava/lang/String;
    //   546: aastore
    //   547: aload_0
    //   548: getfield bqI : [J
    //   551: iconst_2
    //   552: aload_0
    //   553: getfield bqI : [J
    //   556: iconst_0
    //   557: laload
    //   558: lastore
    //   559: aload_0
    //   560: getfield bqK : [Ljava/lang/String;
    //   563: iconst_2
    //   564: aload_0
    //   565: getfield bqK : [Ljava/lang/String;
    //   568: iconst_0
    //   569: aaload
    //   570: aastore
    //   571: aload #11
    //   573: aload #11
    //   575: getfield monthDay : I
    //   578: iconst_5
    //   579: isub
    //   580: putfield monthDay : I
    //   583: aload_0
    //   584: getfield bqH : [J
    //   587: iconst_2
    //   588: aload #11
    //   590: iconst_0
    //   591: invokevirtual normalize : (Z)J
    //   594: lastore
    //   595: aload_0
    //   596: getfield bqJ : [Ljava/lang/String;
    //   599: iconst_2
    //   600: aload #11
    //   602: aload_0
    //   603: getfield Ze : Ljava/lang/String;
    //   606: invokevirtual format : (Ljava/lang/String;)Ljava/lang/String;
    //   609: aastore
    //   610: aload_0
    //   611: getfield bqG : [Ljava/lang/String;
    //   614: iconst_3
    //   615: aload_0
    //   616: getstatic com/laiqian/vip/R$string.pos_report_fastSelect_thisMonth : I
    //   619: invokevirtual getString : (I)Ljava/lang/String;
    //   622: aastore
    //   623: aload_0
    //   624: getfield bqI : [J
    //   627: iconst_3
    //   628: aload_0
    //   629: getfield bqI : [J
    //   632: iconst_0
    //   633: laload
    //   634: lastore
    //   635: aload_0
    //   636: getfield bqK : [Ljava/lang/String;
    //   639: iconst_3
    //   640: aload_0
    //   641: getfield bqK : [Ljava/lang/String;
    //   644: iconst_0
    //   645: aaload
    //   646: aastore
    //   647: aload #11
    //   649: lload #9
    //   651: invokevirtual set : (J)V
    //   654: aload #11
    //   656: iconst_0
    //   657: iconst_0
    //   658: iconst_0
    //   659: aload #11
    //   661: getfield monthDay : I
    //   664: aload #11
    //   666: getfield month : I
    //   669: aload #11
    //   671: getfield year : I
    //   674: invokevirtual set : (IIIIII)V
    //   677: aload #11
    //   679: iconst_1
    //   680: putfield monthDay : I
    //   683: aload_0
    //   684: getfield bqH : [J
    //   687: iconst_3
    //   688: aload #11
    //   690: iconst_0
    //   691: invokevirtual normalize : (Z)J
    //   694: lastore
    //   695: aload_0
    //   696: getfield bqJ : [Ljava/lang/String;
    //   699: iconst_3
    //   700: aload #11
    //   702: aload_0
    //   703: getfield Ze : Ljava/lang/String;
    //   706: invokevirtual format : (Ljava/lang/String;)Ljava/lang/String;
    //   709: aastore
    //   710: return }
  
  protected int QV() { return 0; }
  
  protected void fA(int paramInt) { this.bzA.setVisibility(paramInt); }
  
  protected void fC(int paramInt) {
    if (this.btY == null)
      this.btY = new w(this, this.buO, new r(this)); 
    if (paramInt == 0) {
      this.bzd.setVisibility(0);
      return;
    } 
    this.bzd.setVisibility(8);
  }
  
  protected void fD(int paramInt) {
    if (this.btY == null)
      return; 
    this.btX = paramInt;
    this.bzk.dJ("");
    this.bum = false;
    this.bzt.setVisibility(0);
    this.btN.setVisibility(0);
    switch (paramInt) {
      case 4:
        this.bzk.h(this.bzk.Je());
        this.bzf.setVisibility(0);
        this.bzk.PY();
        this.bzg.setText(this.bzk.PW()[0]);
        QY();
        this.bum = true;
        PR();
        break;
      case 3:
        if (RootApplication.getLaiqianPreferenceManager().QV() == 0 && a.zR().zZ()) {
          this.bzk.h(new String[] { "370011" });
          this.bzf.setVisibility(8);
          this.bzk.PY();
          break;
        } 
        if (RootApplication.getLaiqianPreferenceManager().Wq() && QV() == 2) {
          this.bzk.h(new String[] { "370010" });
          this.bzf.setVisibility(0);
          this.bzk.PY();
          this.bzg.setText(this.bzk.fn(0));
          break;
        } 
        this.bzk.h(this.bzk.Je());
        this.bzk.PY();
        this.bzf.setVisibility(0);
        this.bzg.setText(this.bzk.PW()[0]);
        QY();
        this.bum = true;
        PR();
        break;
      case 2:
        this.bzk.h(new String[] { "370004", "370007", "370010" });
        this.bzf.setVisibility(0);
        this.bzk.PY();
        this.bzg.setText(this.bzk.fm(0));
        break;
      case 1:
        this.bzk.h(new String[] { "370005" });
        this.bzf.setVisibility(0);
        this.bzk.PY();
        this.bzg.setText(this.bzk.fl(0));
        break;
      case 0:
        this.bzk.h(this.bzk.Je());
        this.bzf.setVisibility(8);
        this.bzk.PY();
        break;
    } 
    this.bze.setText(this.buO[paramInt]);
    this.btY.gn(paramInt);
    Py();
    QZ();
  }
  
  protected void fx(int paramInt) { ((TextView)findViewById(R.id.ui_titlebar_txt)).setText(paramInt); }
  
  protected void fy(int paramInt) { this.bzy.setVisibility(paramInt); }
  
  protected void fz(int paramInt) { this.bzz.setVisibility(paramInt); }
  
  protected void n(int paramInt, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(z.B(Time.class));
    stringBuilder.append(" %H:%M");
    this.Ze = stringBuilder.toString();
    aj aj = findViewById(R.id.date_l);
    this.bqD = aj.findViewById(R.id.date_fast_l);
    this.bqE = (TextView)this.bqD.findViewById(R.id.date_fast);
    Object[] arrayOfObject = aj.findViewById(R.id.time_start_l);
    this.bqv = (TextView)arrayOfObject.findViewById(R.id.time_start);
    arrayOfObject.setOnClickListener(new a(this, this.bqv));
    View view = aj.findViewById(R.id.time_end_l);
    this.bqw = (TextView)view.findViewById(R.id.time_end);
    view.setOnClickListener(new a(this, this.bqw));
    int j = 1;
    this.bqu = new View[] { arrayOfObject, view };
    this.bqF = aj.findViewById(R.id.date_shift);
    if (paramBoolean) {
      this.bqx = new View[] { this.bqD, this.bqF, arrayOfObject, view };
      aj = null;
      try {
        aj aj1 = new aj(this);
        aj = aj1;
      } catch (Exception null) {
        a.e(arrayOfObject);
      } 
      arrayOfObject = aj.hS(this.Ze);
      aj.close();
      this.bqz = (String[])arrayOfObject[0];
      this.bqA = (long[][])arrayOfObject[1];
      this.bqB = (String[][])arrayOfObject[2];
      this.bqy = new w(this, this.bqz, new s(this));
      this.bqy.aW(0.35D);
      this.bqF.setOnClickListener(new t(this));
    } else {
      this.bqF.setVisibility(8);
      this.bqx = new View[] { this.bqD, arrayOfObject, view };
      this.bqD.setBackgroundResource(R.drawable.pos_report_filter_time_fast_background);
      aj.findViewById(R.id.date_line).setVisibility(8);
    } 
    PB();
    this.bqC = new w(this, this.bqG, new u(this));
    this.bqD.setOnClickListener(new w(this));
    int i = paramInt;
    if (paramInt == 0) {
      i = paramInt;
      if (this.bqL)
        i = 1; 
    } 
    if (i < this.bqH.length) {
      paramInt = j;
    } else {
      paramInt = 0;
    } 
    if (paramInt == 0)
      i = 0; 
    this.bqC.gn(i);
    v(this.bqD, i);
    if (paramInt == 0)
      o(0, false); 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.vip_report_main);
    getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    if (RootApplication.getLaiqianPreferenceManager().Wq() && QV() == 2) {
      this.buO = new String[] { getString(R.string.pos_vip_all_type_tltle), getString(R.string.pos_vip_consume_title), getString(R.string.pos_vip_charge_title), getString(R.string.charge_cancel_title), getString(R.string.pos_vip_point_title) };
    } else {
      this.buO = new String[] { getString(R.string.pos_vip_all_type_tltle), getString(R.string.pos_vip_consume_title), getString(R.string.pos_vip_charge_title), getString(R.string.pos_vip_point_title) };
      if (a.zR().zZ())
        this.buO = new String[] { getString(R.string.pos_vip_all_type_tltle), getString(R.string.pos_vip_consume_title), getString(R.string.pos_vip_charge_title), getString(R.string.vip_initial_balance_lab), getString(R.string.pos_vip_point_title) }; 
    } 
    this.bzk = new am(this, this);
    this.context = this;
    wR();
    setupViews();
    setListeners();
    QW();
    n(0, true);
  }
  
  protected void onStart() {
    super.onStart();
    a(this.bqs[0], this.bqs[1], (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(new Date(this.bqs[0])), (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(new Date(this.bqs[1])));
    Py();
  }
  
  class a implements View.OnClickListener {
    private TextView bqZ;
    
    public a(VipReportActivity this$0, TextView param1TextView) { this.bqZ = param1TextView; }
    
    public void onClick(View param1View) {
      if (VipReportActivity.v(this.bzE) == null) {
        VipReportActivity.a(this.bzE, new a(this.bzE, this.bzE.Ze));
        VipReportActivity.v(this.bzE).a(new aj(this));
      } 
      VipReportActivity.v(this.bzE).g(this.bqZ);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\VipReportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */