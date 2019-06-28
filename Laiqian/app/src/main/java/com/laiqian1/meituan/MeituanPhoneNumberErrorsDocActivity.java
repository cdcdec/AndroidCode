package com.laiqian.meituan;

import android.os.Bundle;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.models.aj;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.a;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.w;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.n;
import com.laiqian.util.z;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MeituanPhoneNumberErrorsDocActivity extends ActivityRoot {
  protected String Ze;
  
  private long aRC = 0L;
  
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
  
  private String bqP = "SELECT GROUP_CONCAT(`nOrderId`) as sOrderIds ,GROUP_CONCAT(`nRealPhoneNumber`) as sRealPhoneNumbers,count(nDateTime) AS nQuantity,nDateTime from t_meituan_phone_number where ePoiId= ? and nDateTime between ? and ?  GROUP BY nDateTime";
  
  private String[] bqQ = new String[3];
  
  FormListView.c bqR = new af(this);
  
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
  
  bb mWaitingDialog = null;
  
  private long startTime = 0L;
  
  private void Em() {
    if (this.mWaitingDialog == null)
      this.mWaitingDialog = new bb(this); 
    this.mWaitingDialog.setCancelable(false);
    this.mWaitingDialog.show();
  }
  
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
  
  private void Px() {
    this.bqQ[0] = RootApplication.getLaiqianPreferenceManager().Tx();
    String[] arrayOfString = this.bqQ;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bqs[0]);
    stringBuilder.append("");
    arrayOfString[1] = stringBuilder.toString();
    arrayOfString = this.bqQ;
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.bqs[1]);
    stringBuilder.append("");
    arrayOfString[2] = stringBuilder.toString();
  }
  
  private void Py() {
    Em();
    Pz();
  }
  
  private void Pz() {
    this.bqp.initData();
    if (this.bqq == null) {
      this.bqq = new w(this, this, this.bqp.getList(), this.bqp);
    } else {
      this.bqq.m(this.bqp.getList());
    } 
    this.bqp.setAdapter(this.bqq);
    FormListView formListView = this.bqp;
    String str = this.bqP;
    String[] arrayOfString = this.bqQ;
    long l1 = this.bqs[0];
    long l2 = this.bqs[1];
    formListView.setData(this, str, arrayOfString, new String[] { "nDateTime", "nQuantity", "sOrderIds" }, new String[] { null, (new String[2][0] = (new String[4][3] = "sRealPhoneNumbers").valueOf(l1)).valueOf(l2) });
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
    //   15: invokespecial Px : ()V
    //   18: new java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore #7
    //   27: aload #7
    //   29: aload_0
    //   30: getfield bqM : I
    //   33: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload #7
    //   39: ldc ''
    //   41: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload #5
    //   47: aload #7
    //   49: invokevirtual toString : ()Ljava/lang/String;
    //   52: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   55: ifeq -> 127
    //   58: new java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial <init> : ()V
    //   65: astore #7
    //   67: aload #7
    //   69: aload_0
    //   70: getfield bqM : I
    //   73: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload #7
    //   79: ldc ''
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload #6
    //   87: aload #7
    //   89: invokevirtual toString : ()Ljava/lang/String;
    //   92: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   95: ifeq -> 127
    //   98: aload_0
    //   99: getfield bqv : Landroid/widget/TextView;
    //   102: aload #5
    //   104: iconst_5
    //   105: invokevirtual substring : (I)Ljava/lang/String;
    //   108: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   111: aload_0
    //   112: getfield bqw : Landroid/widget/TextView;
    //   115: aload #6
    //   117: iconst_5
    //   118: invokevirtual substring : (I)Ljava/lang/String;
    //   121: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   124: goto -> 145
    //   127: aload_0
    //   128: getfield bqv : Landroid/widget/TextView;
    //   131: aload #5
    //   133: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   136: aload_0
    //   137: getfield bqw : Landroid/widget/TextView;
    //   140: aload #6
    //   142: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   145: aload_0
    //   146: getfield bqv : Landroid/widget/TextView;
    //   149: lload_1
    //   150: invokestatic valueOf : (J)Ljava/lang/Long;
    //   153: invokevirtual setTag : (Ljava/lang/Object;)V
    //   156: aload_0
    //   157: getfield bqw : Landroid/widget/TextView;
    //   160: lload_3
    //   161: invokestatic valueOf : (J)Ljava/lang/Long;
    //   164: invokevirtual setTag : (Ljava/lang/Object;)V
    //   167: aload_0
    //   168: invokespecial PA : ()V
    //   171: return }
  
  private void a(View... paramVarArgs) {
    for (byte b = 0; b < this.bqx.length; b++)
      this.bqx[b].setSelected(n.a(this.bqx[b], paramVarArgs)); 
  }
  
  private void hideProgress() {
    if (this.mWaitingDialog != null) {
      this.mWaitingDialog.dismiss();
      this.mWaitingDialog = null;
    } 
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
    this.bqp.setOnLoadListener(this.bqR);
    this.bqN.setOnClickListener(new z(this));
    this.bqp.setOnAfterLoadListener(new aa(this));
  }
  
  private void setupViews() {
    Time time = new Time();
    time.setToNow();
    this.bqM = time.year;
  }
  
  private void v(View paramView, int paramInt) {
    this.bqE.setText(this.bqG[paramInt]);
    this.bqO = paramInt;
    a(new View[] { paramView });
    a(this.bqH[paramInt], this.bqI[paramInt], this.bqJ[paramInt], this.bqK[paramInt]);
  }
  
  private void wR() {
    ((TextView)findViewById(R.id.ui_titlebar_txt)).setText(R.string.phone_number_error_doc);
    findViewById(R.id.ui_titlebar_help_btn).setVisibility(8);
    this.bqN = (ViewGroup)findViewById(R.id.llRefresh);
    this.bqp = (FormListView)findViewById(R.id.lvReport);
    this.bqp.setIsTransaction(true);
    LinearLayout linearLayout = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.item_meituan_phone_number_header, null);
    this.bqp.addHeaderView(linearLayout);
    this.bqr = (FrameLayout)findViewById(R.id.no_data);
    findViewById(R.id.show_type_l).setVisibility(8);
    findViewById(R.id.select_product).setVisibility(8);
    findViewById(R.id.filter_other).setVisibility(8);
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
    //   200: getstatic com/laiqian/meituan/R$string.pos_report_fastSelect_today : I
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
    //   409: getstatic com/laiqian/meituan/R$string.pos_report_fastSelect_yesterday : I
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
    //   540: getstatic com/laiqian/meituan/R$string.pos_report_fastSelect_oneWeek : I
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
    //   616: getstatic com/laiqian/meituan/R$string.pos_report_fastSelect_thisMonth : I
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
      this.bqy = new w(this, this.bqz, new ab(this));
      this.bqy.aW(0.35D);
      this.bqF.setOnClickListener(new ac(this));
    } else {
      this.bqF.setVisibility(8);
      this.bqx = new View[] { this.bqD, arrayOfObject, view };
      this.bqD.setBackgroundResource(R.drawable.pos_report_filter_time_fast_background);
      aj.findViewById(R.id.date_line).setVisibility(8);
    } 
    PB();
    this.bqC = new w(this, this.bqG, new ad(this));
    this.bqD.setOnClickListener(new ae(this));
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
    setContentView(R.layout.activity_meituan_phone_number_errors_doc);
    getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    wR();
    setupViews();
    setListeners();
  }
  
  protected void onResume() {
    super.onResume();
    n(0, true);
    Py();
  }
  
  class a implements View.OnClickListener {
    private TextView bqZ;
    
    public a(MeituanPhoneNumberErrorsDocActivity this$0, TextView param1TextView) { this.bqZ = param1TextView; }
    
    public void onClick(View param1View) {
      if (MeituanPhoneNumberErrorsDocActivity.h(this.bqT) == null) {
        MeituanPhoneNumberErrorsDocActivity.a(this.bqT, new a(this.bqT, this.bqT.Ze));
        MeituanPhoneNumberErrorsDocActivity.h(this.bqT).a(new ag(this));
      } 
      MeituanPhoneNumberErrorsDocActivity.h(this.bqT).g(this.bqZ);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\MeituanPhoneNumberErrorsDocActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */