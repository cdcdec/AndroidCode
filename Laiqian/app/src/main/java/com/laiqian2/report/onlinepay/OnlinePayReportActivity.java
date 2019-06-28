package com.laiqian.report.onlinepay;

import android.content.Context;
import android.os.Bundle;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.models.aj;
import com.laiqian.models.bg;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.a;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.w;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.by;
import com.laiqian.util.ck;
import com.laiqian.util.n;
import com.laiqian.util.z;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class OnlinePayReportActivity extends ActivityRoot implements r {
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
  
  private View bud;
  
  AdapterView.OnItemClickListener bzC = new p(this);
  
  private LinearLayout bzd;
  
  private TextView bze;
  
  private LinearLayout bzh;
  
  private TextView bzi;
  
  private LinearLayout bzj;
  
  private View bzl;
  
  private w bzm;
  
  private long[] bzn;
  
  private String[] bzo;
  
  LinearLayout bzq;
  
  public LinearLayout bzw;
  
  Context context;
  
  private LinearLayout dda;
  
  private TextView ddb;
  
  private s ddc;
  
  w ddd;
  
  w dde;
  
  private String[] ddf;
  
  private String[] ddg;
  
  private int ddh;
  
  boolean ddi = false;
  
  private bb mWaitingDialog = null;
  
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
  
  private void Pz() {
    Em();
    String[] arrayOfString = (this.ddc.anE()).dcm.split(",");
    this.bqp.initData();
    if (ck.ml(this.bqp.getList().size())) {
      this.bud.setVisibility(8);
    } else {
      this.bud.setVisibility(0);
    } 
    if (this.bqq == null) {
      this.bqq = new l(this, this, this.bqp.getList(), this.bqp);
    } else {
      this.bqq.m(this.bqp.getList());
    } 
    this.bqp.setAdapter(this.bqq);
    this.bqp.setData(this, (this.ddc.anE()).bsx, (this.ddc.anE()).dcl.split(","), arrayOfString, this.ddc.ddv.Fu());
  }
  
  private void QX() {
    this.bzh.setOnClickListener(new n(this));
    bg bg = new bg(this);
    ArrayList arrayList = bg.Wz();
    int i = arrayList.size();
    byte b = 1;
    this.bzn = new long[++i];
    this.bzn[0] = 0L;
    this.bzo = new String[i];
    this.bzo[0] = getString(2131628072);
    String[] arrayOfString = new String[i];
    arrayOfString[0] = getString(2131628072);
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
    bg.close();
    this.bzm = new w(this, arrayOfString, new o(this));
    fB(0);
  }
  
  private void QZ() {
    if (!"0".equals(this.ddc.getUserID()) || !this.ddf[0].equals(this.bze.getText().toString().trim())) {
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
    //   15: getfield ddc : Lcom/laiqian/report/onlinepay/s;
    //   18: aload_0
    //   19: getfield bqs : [J
    //   22: invokevirtual f : ([J)V
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore #7
    //   34: aload #7
    //   36: aload_0
    //   37: getfield bqM : I
    //   40: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload #7
    //   46: ldc_w ''
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload #5
    //   55: aload #7
    //   57: invokevirtual toString : ()Ljava/lang/String;
    //   60: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   63: ifeq -> 136
    //   66: new java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial <init> : ()V
    //   73: astore #7
    //   75: aload #7
    //   77: aload_0
    //   78: getfield bqM : I
    //   81: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload #7
    //   87: ldc_w ''
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload #6
    //   96: aload #7
    //   98: invokevirtual toString : ()Ljava/lang/String;
    //   101: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   104: ifeq -> 136
    //   107: aload_0
    //   108: getfield bqv : Landroid/widget/TextView;
    //   111: aload #5
    //   113: iconst_5
    //   114: invokevirtual substring : (I)Ljava/lang/String;
    //   117: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   120: aload_0
    //   121: getfield bqw : Landroid/widget/TextView;
    //   124: aload #6
    //   126: iconst_5
    //   127: invokevirtual substring : (I)Ljava/lang/String;
    //   130: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   133: goto -> 154
    //   136: aload_0
    //   137: getfield bqv : Landroid/widget/TextView;
    //   140: aload #5
    //   142: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   145: aload_0
    //   146: getfield bqw : Landroid/widget/TextView;
    //   149: aload #6
    //   151: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   154: aload_0
    //   155: getfield bqv : Landroid/widget/TextView;
    //   158: lload_1
    //   159: invokestatic valueOf : (J)Ljava/lang/Long;
    //   162: invokevirtual setTag : (Ljava/lang/Object;)V
    //   165: aload_0
    //   166: getfield bqw : Landroid/widget/TextView;
    //   169: lload_3
    //   170: invokestatic valueOf : (J)Ljava/lang/Long;
    //   173: invokevirtual setTag : (Ljava/lang/Object;)V
    //   176: aload_0
    //   177: invokespecial PA : ()V
    //   180: return }
  
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
    this.ddc.dd(String.valueOf(this.bzn[paramInt]));
    TextView textView = this.bzi;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    textView.setSelected(bool);
    QZ();
  }
  
  private void fD(int paramInt) {
    if (this.ddd == null)
      return; 
    switch (paramInt) {
      case 4:
        this.ddc.a(new Integer[] { Integer.valueOf(1) });
        break;
      case 3:
        this.ddc.a(new Integer[] { Integer.valueOf(0) });
        break;
      case 2:
        this.ddc.a(new Integer[] { Integer.valueOf(5) });
        break;
      case 1:
        this.ddc.a(new Integer[] { Integer.valueOf(8) });
        break;
      case 0:
        this.ddc.a(this.ddc.Fv());
        break;
    } 
    this.bze.setText(this.ddf[paramInt]);
    this.ddd.gn(paramInt);
    Py();
    QZ();
  }
  
  private void jM(int paramInt) {
    if (this.dde == null)
      return; 
    switch (paramInt) {
      case 5:
        this.ddc.b(new Integer[] { Integer.valueOf(-4) });
        break;
      case 4:
        this.ddc.b(new Integer[] { Integer.valueOf(-2) });
        break;
      case 3:
        this.ddc.b(new Integer[] { Integer.valueOf(0) });
        break;
      case 2:
        this.ddc.b(new Integer[] { Integer.valueOf(-1) });
        break;
      case 1:
        this.ddc.b(new Integer[] { Integer.valueOf(1) });
        break;
      case 0:
        this.ddc.b(this.ddc.Fw());
        break;
    } 
    this.ddb.setText(this.ddg[paramInt]);
    this.dde.gn(paramInt);
    Py();
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
    this.bqN.setOnClickListener(new a(this));
    QX();
    if (!getActivity().getResources().getBoolean(2131034140))
      this.bzl.setVisibility(8); 
    this.bqp.setOnAfterLoadListener(new f(this));
    this.bqp.setOnItemClickListener(this.bzC);
    this.bzd.setOnClickListener(new g(this));
    this.dda.setOnClickListener(new i(this));
    this.bzj.setOnClickListener(new k(this));
    String str1 = getString(2131626969);
    String str2 = getString(2131624776);
    int i = by.parseInt("0");
    int j = by.parseInt("1");
    int k = by.parseInt("0");
    a(new String[] { str1, str2 }, new int[] { i, j }, k);
  }
  
  private void setupViews() {
    Time time = new Time();
    time.setToNow();
    this.bqM = time.year;
    this.ddf = new String[] { getString(2131626186), getString(2131626194), getString(2131626193), getString(2131626155), getString(2131626154) };
    this.ddg = new String[] { getString(2131626186), getString(2131626181), getString(2131626164), getString(2131626177), getString(2131626183), getString(2131626172) };
    this.bze.setText(this.ddf[0]);
    this.ddb.setText(this.ddg[0]);
  }
  
  private void v(View paramView, int paramInt) {
    this.bqE.setText(this.bqG[paramInt]);
    this.bqO = paramInt;
    a(new View[] { paramView });
    a(this.bqH[paramInt], this.bqI[paramInt], this.bqJ[paramInt], this.bqK[paramInt]);
  }
  
  private void wR() {
    ((TextView)findViewById(2131299889)).setText(2131627897);
    findViewById(2131299879).setVisibility(8);
    this.bzq = (LinearLayout)findViewById(2131297658);
    this.bzq.setVisibility(0);
    this.bqN = (ViewGroup)findViewById(2131297855);
    this.bzw = (LinearLayout)findViewById(2131297889);
    ((TextView)findViewById(2131299675)).setText(2131626218);
    findViewById(2131298929).setVisibility(8);
    this.bqp = (FormListView)findViewById(2131298080);
    this.bqp.setIsTransaction(true);
    this.bqp.setNeedCopyParams(false);
    this.bzl = findViewById(2131298456);
    this.bqr = (FrameLayout)findViewById(2131298220);
    this.bzd = (LinearLayout)findViewById(2131298360);
    this.bze = (TextView)findViewById(2131298359);
    this.dda = (LinearLayout)findViewById(2131298316);
    this.ddb = (TextView)findViewById(2131298315);
    this.dda.setVisibility(0);
    findViewById(2131298928).setVisibility(8);
    ((TextView)findViewById(2131299682)).setText(getString(2131627071));
    findViewById(2131298928).setVisibility(8);
    ((TextView)findViewById(2131299681)).setText(2131627069);
    this.bzh = (LinearLayout)findViewById(2131298931);
    this.bzi = (TextView)findViewById(2131299930);
    this.bzj = (LinearLayout)findViewById(2131296773);
    this.bud = findViewById(2131297047);
    LinearLayout linearLayout = (LinearLayout)LayoutInflater.from(this).inflate(2131427687, null);
    ((TextView)linearLayout.findViewById(2131299312)).setText(2131629313);
    ((TextView)linearLayout.findViewById(2131299369)).setText(2131629292);
    ((TextView)linearLayout.findViewById(2131299373)).setText(2131629295);
    ((TextView)linearLayout.findViewById(2131299431)).setText(2131629311);
    ((TextView)linearLayout.findViewById(2131299296)).setText(2131629315);
    ((TextView)linearLayout.findViewById(2131299366)).setText(2131629289);
    this.bqp.addHeaderView(linearLayout);
  }
  
  public void Em() {
    if (this.mWaitingDialog == null)
      this.mWaitingDialog = new bb(this); 
    this.mWaitingDialog.setCancelable(false);
    this.mWaitingDialog.show();
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
    //   200: ldc_w 2131627885
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
    //   409: ldc_w 2131627886
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
    //   540: ldc_w 2131627881
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
    //   616: ldc_w 2131627884
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
  
  public void Py() { Pz(); }
  
  protected void a(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt) {
    View[] arrayOfView;
    View view = findViewById(2131298990);
    if (paramArrayOfString == null) {
      view.setVisibility(8);
      return;
    } 
    cU(view);
    ViewGroup viewGroup1 = (ViewGroup)findViewById(2131298988);
    ViewGroup viewGroup2 = (ViewGroup)findViewById(2131298989);
    if (paramArrayOfString.length > 3) {
      arrayOfView = new View[viewGroup1.getChildCount() + viewGroup2.getChildCount()];
      viewGroup2.setVisibility(0);
    } else {
      viewGroup2.setVisibility(8);
      arrayOfView = new View[viewGroup1.getChildCount()];
    } 
    TextView textView = null;
    int i;
    for (i = 0; i < arrayOfView.length; i++) {
      ViewGroup viewGroup;
      TextView textView1;
      if (i < viewGroup1.getChildCount()) {
        textView1 = (TextView)viewGroup1.getChildAt(i);
        viewGroup = viewGroup1;
      } else {
        textView1 = (TextView)viewGroup2.getChildAt(i - viewGroup1.getChildCount());
        viewGroup = viewGroup2;
      } 
      arrayOfView[i] = textView1;
      if (i >= paramArrayOfString.length) {
        if (viewGroup == viewGroup1) {
          textView1.setVisibility(8);
        } else {
          textView1.setVisibility(0);
        } 
      } else {
        textView1.setText(paramArrayOfString[i]);
        textView1.setOnClickListener(new b(this, paramArrayOfInt[i], arrayOfView));
        if (paramArrayOfInt[i] == paramInt)
          textView = textView1; 
      } 
    } 
    if (textView != null)
      performClick(textView); 
  }
  
  protected boolean anD() { return false; }
  
  protected void cU(View paramView) { paramView.findViewById(2131297351).setVisibility(8); }
  
  public void hideProgress() {
    if (this.mWaitingDialog != null) {
      this.mWaitingDialog.dismiss();
      this.mWaitingDialog = null;
    } 
  }
  
  protected void n(int paramInt, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(z.B(Time.class));
    stringBuilder.append(" %H:%M");
    this.Ze = stringBuilder.toString();
    aj aj = findViewById(2131296833);
    this.bqD = aj.findViewById(2131296832);
    this.bqE = (TextView)this.bqD.findViewById(2131296831);
    Object[] arrayOfObject = aj.findViewById(2131299236);
    this.bqv = (TextView)arrayOfObject.findViewById(2131299235);
    arrayOfObject.setOnClickListener(new a(this, this.bqv));
    View view = aj.findViewById(2131299231);
    this.bqw = (TextView)view.findViewById(2131299230);
    view.setOnClickListener(new a(this, this.bqw));
    int j = 1;
    this.bqu = new View[] { arrayOfObject, view };
    this.bqF = aj.findViewById(2131296841);
    if (paramBoolean) {
      this.bqx = new View[] { this.bqD, this.bqF, arrayOfObject, view };
      aj = new aj(this);
      arrayOfObject = aj.hS(this.Ze);
      aj.close();
      this.bqz = (String[])arrayOfObject[0];
      this.bqA = (long[][])arrayOfObject[1];
      this.bqB = (String[][])arrayOfObject[2];
      this.bqy = new w(this, this.bqz, new b(this));
      this.bqy.aW(0.35D);
      this.bqF.setOnClickListener(new c(this));
    } else {
      this.bqF.setVisibility(8);
      this.bqx = new View[] { this.bqD, arrayOfObject, view };
      this.bqD.setBackgroundResource(2131231602);
      aj.findViewById(2131296834).setVisibility(8);
    } 
    PB();
    this.bqC = new w(this, this.bqG, new d(this));
    this.bqD.setOnClickListener(new e(this));
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
    setContentView(2131427397);
    getWindow().setFeatureInt(7, 2131428168);
    this.ddc = new s(this, this);
    this.context = this;
    wR();
    setupViews();
    setListeners();
  }
  
  protected void onResume() {
    super.onResume();
    this.ddc.init();
    n(0, true);
    Py();
    this.ddi = true;
  }
  
  class a implements View.OnClickListener {
    private TextView bqZ;
    
    public a(OnlinePayReportActivity this$0, TextView param1TextView) { this.bqZ = param1TextView; }
    
    public void onClick(View param1View) {
      if (OnlinePayReportActivity.l(this.ddj) == null) {
        OnlinePayReportActivity.a(this.ddj, new a(this.ddj, this.ddj.Ze));
        OnlinePayReportActivity.l(this.ddj).a(new q(this));
      } 
      OnlinePayReportActivity.l(this.ddj).g(this.bqZ);
    }
  }
  
  class b implements View.OnClickListener {
    private int dds;
    
    private View[] ddt;
    
    public b(OnlinePayReportActivity this$0, int param1Int, View[] param1ArrayOfView) {
      this.dds = param1Int;
      this.ddt = param1ArrayOfView;
    }
    
    public void onClick(View param1View) {
      OnlinePayReportActivity.e(this.ddj, this.dds);
      if (this.ddj.anD())
        return; 
      for (byte b1 = 0; b1 < this.ddt.length; b1++) {
        boolean bool;
        View view = this.ddt[b1];
        if (this.ddt[b1] == param1View) {
          bool = true;
        } else {
          bool = false;
        } 
        view.setSelected(bool);
      } 
      if (this.ddj.ddi) {
        OnlinePayReportActivity.f(this.ddj).de(String.valueOf(OnlinePayReportActivity.g(this.ddj)));
        this.ddj.Py();
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\OnlinePayReportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */