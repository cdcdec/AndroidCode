package com.laiqian.member.create;

import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.bi;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.entity.al;
import com.laiqian.entity.aq;
import com.laiqian.entity.g;
import com.laiqian.entity.h;
import com.laiqian.entity.n;
import com.laiqian.member.bz;
import com.laiqian.member.f.a;
import com.laiqian.member.h.a;
import com.laiqian.member.h.c;
import com.laiqian.member.setting.bc;
import com.laiqian.models.ah;
import com.laiqian.pos.PayTypeSpecific;
import com.laiqian.pos.aw;
import com.laiqian.pos.bm;
import com.laiqian.print.cardreader.am;
import com.laiqian.print.dualscreen.o;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.c;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.LayoutLeftTextRightTextWithDialog;
import com.laiqian.util.ar;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.l;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class VipCreateDialog extends aw {
  private boolean aDM;
  
  int aDO = Build.VERSION.SDK_INT;
  
  bz aDP;
  
  Handler aDQ = new l(this);
  
  private boolean aDR = false;
  
  protected ProgressBarCircularIndeterminate aNv;
  
  private Context aTg;
  
  private String aWq;
  
  int bsR;
  
  private LinearLayout bsS;
  
  private TextView bsT;
  
  private w bsU;
  
  private List<g> bsV;
  
  private int bsX = 0;
  
  private LinearLayout bti;
  
  View.OnFocusChangeListener btk = new k(this);
  
  TextView bvB;
  
  private double bwB = -1.0D;
  
  private double bwC = -1.0D;
  
  private String bwD = "";
  
  protected a bwG;
  
  a bwH;
  
  c bwI;
  
  private TextView bwJ;
  
  public h bwK;
  
  public al bwL;
  
  TextWatcher bwM = new s(this);
  
  View.OnClickListener bwN = new g(this);
  
  View.OnFocusChangeListener bwO = new i(this);
  
  EditText bwZ;
  
  EditText bwv;
  
  EditText bww;
  
  LinearLayout bwx;
  
  protected Button bwy;
  
  EditText bxa;
  
  EditText bxb;
  
  b bxc;
  
  UsbCardReceiver bxd;
  
  private LinearLayout bxe;
  
  private EditText bxf;
  
  private String[] bxg;
  
  private String bxh = "";
  
  private String bxi = "";
  
  private LinearLayout bxj;
  
  private CheckBox bxk;
  
  private LinearLayout bxl;
  
  private EditText bxm;
  
  private LinearLayout bxn;
  
  private EditText bxo;
  
  private boolean bxp = false;
  
  String bxq;
  
  ScrollView bxr;
  
  private EditText bxs;
  
  private final LayoutLeftTextRightTextWithDialog bxt;
  
  View.OnClickListener bxu = new u(this);
  
  View.OnFocusChangeListener bxv = new h(this);
  
  View.OnFocusChangeListener bxw = new j(this);
  
  View.OnClickListener bxx = new m(this);
  
  @Nullable
  private o dualPresentation;
  
  bi onlinePayDialog;
  
  n onlinePayEntity;
  
  Handler scanCodeHandle = new q(this);
  
  private String scanCodeOrderNo;
  
  private long startTime;
  
  private bb waitingDialog;
  
  public VipCreateDialog(Context paramContext) {
    super(paramContext, R.style.dialog_fullscreen);
    this.aTg = paramContext;
    View view = View.inflate(this.mContext, R.layout.dialog_vip_create, null);
    this.bxt = (LayoutLeftTextRightTextWithDialog)view.findViewById(R.id.member_validity_period);
    this.startTime = System.currentTimeMillis();
    String[] arrayOfString = getContext().getResources().getStringArray(R.array.list_member_effective_period);
    this.bxt.oX(arrayOfString[0]);
    fi(0);
    this.bxt.a(arrayOfString, new b(this));
    this.bwG = new a(this.mContext, true, new n(this));
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      this.bwB = RootApplication.getLaiqianPreferenceManager().avD();
      this.bwC = RootApplication.getLaiqianPreferenceManager().avE();
      this.bwD = RootApplication.getLaiqianPreferenceManager().avX();
    } 
    if (LQKVersion.zl() && !RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
      this.bwH = new a(this.mContext);
      this.bwH.a(new r(this));
    } else {
      this.bwI = new c(this.mContext);
    } 
    setContentView(view);
  }
  
  private void PN() {
    Calendar calendar = Calendar.getInstance(Locale.CHINA);
    calendar.setTime(new Date());
    int i = calendar.get(1);
    int j = calendar.get(2);
    int k = calendar.get(5);
    (new DatePickerDialog(this.mContext, new a(this), i, j, k)).show();
  }
  
  private void QA() {
    this.bww.setFilters(ar.lw(9999));
    this.bxf.setFilters(ar.lw(9999));
    InputFilter inputFilter = ar.lx(99);
    InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(10);
    this.bwv.setFilters(new InputFilter[] { inputFilter, lengthFilter });
  }
  
  private void QC() {
    if (RootApplication.getLaiqianPreferenceManager().Wq() && RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      this.bww.setText("0");
      dG(RootApplication.getLaiqianPreferenceManager().atj());
    } else {
      this.bww.setText("0");
    } 
    this.bwZ.setText("");
    this.bxa.setText("");
    this.bxb.setText("");
    this.bvB.setText("1990-1-1");
    this.bwv.setText("");
    this.bww.setText("0");
    this.bxf.setText("0");
    this.bxa.requestFocus();
    this.bsT.setText(this.bxg[0]);
    this.bxm.setText("");
    this.bxo.setText("");
    this.bxk.setChecked(false);
  }
  
  private void a(al paramal) { this.bwL = paramal; }
  
  private void a(h paramh) { this.bwK = paramh; }
  
  private void a(String paramString, TextView paramTextView) { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  private void changePayTypeItemPayType(Message paramMessage) {
    if (a.zR().At()) {
      long l = paramMessage.arg1;
      this.bwG.bys.aTe = l;
      this.bwG.byt = getContext().getString(PayTypeSpecific.cn(l));
      this.bwG.bys.aTv = PayTypeSpecific.co(l);
      a a1 = this.bwG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(PayTypeSpecific.co(l));
      stringBuilder.append("");
      a1.byv = stringBuilder.toString();
    } 
  }
  
  private void fi(int paramInt) {
    if (paramInt == 1) {
      this.aWq = String.valueOf(this.startTime + TimeUnit.DAYS.toMillis(365L));
      return;
    } 
    if (paramInt == 2) {
      this.aWq = String.valueOf(this.startTime + TimeUnit.DAYS.toMillis(183L));
      return;
    } 
    if (paramInt == 3) {
      this.aWq = String.valueOf(this.startTime + TimeUnit.DAYS.toMillis(30L));
      return;
    } 
    if (paramInt == 4) {
      PN();
      return;
    } 
    this.aWq = String.valueOf("0");
  }
  
  private ArrayList<PrintContent> q(Bitmap paramBitmap) {
    String str;
    ArrayList arrayList = new ArrayList();
    c c1 = c.bp(this.mContext);
    Double double1;
    Double double2 = (double1 = Double.valueOf(bm.o(this.bwv.getText().toString(), 2))).valueOf(bm.o(this.bww.getText().toString(), 2));
    if (n.bL(getContext())) {
      str = by.bv(this.bxb.getText().toString(), "*");
    } else {
      str = this.bxb.getText().toString();
    } 
    arrayList.add(c1.a(new Date(System.currentTimeMillis()), str, by.bu(this.bwZ.getText().toString(), "****"), by.bu(this.bxa.getText().toString(), "****"), Double.valueOf(0.0D), double1, double2, Bitmap.createScaledBitmap(paramBitmap, 360, 360, true), this.bwG.byt));
    return arrayList;
  }
  
  private void showOnlineBarcodePayInDualPresentation(boolean paramBoolean) {
    o o1;
    if ((o1 = this.dualPresentation).afM() != null) {
      if (this.bwG.bys.aTe == 5L) {
        (o1 = this.dualPresentation).afM().afP().fN(paramBoolean);
        return;
      } 
      if (this.bwG.bys.aTe == 1L) {
        (o1 = this.dualPresentation).afM().afP().fM(paramBoolean);
        return;
      } 
      if (!paramBoolean)
        (o1 = this.dualPresentation).afM().afP().fM(paramBoolean); 
    } 
  }
  
  private void showScanCodeDialog() {
    String str = this.bwv.getText().toString().trim();
    if (by.isNull(str))
      return; 
    double d = n.aU(str);
    if (d < 0.01D || d > 1.0E8D) {
      n.eP(R.string.pos_alipay_AMOUNT_IS_OUT_RANG);
      return;
    } 
    this.scanCodeOrderNo = n.j(new Date());
    this.bwG.resetFirstPayTypeItemView(-1L);
    a(str, this.bwv);
  }
  
  private void xV() {
    if (this.bxd == null) {
      this.bxd = new UsbCardReceiver(this);
      if (!this.aDR) {
        this.aDR = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction("com.laiqian.USB_PERMISSION");
        this.mContext.registerReceiver(this.bxd, intentFilter);
      } 
    } 
  }
  
  protected abstract boolean J(String paramString1, String paramString2);
  
  protected aq QF() { // Byte code:
    //   0: aload_0
    //   1: getfield bwv : Landroid/widget/EditText;
    //   4: invokevirtual getText : ()Landroid/text/Editable;
    //   7: invokevirtual toString : ()Ljava/lang/String;
    //   10: invokevirtual trim : ()Ljava/lang/String;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull -> 29
    //   18: aload_2
    //   19: astore_1
    //   20: ldc ''
    //   22: aload_2
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifeq -> 33
    //   29: ldc_w '0'
    //   32: astore_1
    //   33: aload_0
    //   34: getfield bww : Landroid/widget/EditText;
    //   37: invokevirtual getText : ()Landroid/text/Editable;
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: invokevirtual trim : ()Ljava/lang/String;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull -> 62
    //   51: aload_3
    //   52: astore_2
    //   53: ldc ''
    //   55: aload_3
    //   56: invokevirtual equals : (Ljava/lang/Object;)Z
    //   59: ifeq -> 66
    //   62: ldc_w '0'
    //   65: astore_2
    //   66: aload_0
    //   67: aload_0
    //   68: getfield bxf : Landroid/widget/EditText;
    //   71: invokevirtual getText : ()Landroid/text/Editable;
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: invokevirtual trim : ()Ljava/lang/String;
    //   80: putfield bxq : Ljava/lang/String;
    //   83: aload_0
    //   84: getfield bxq : Ljava/lang/String;
    //   87: ifnull -> 102
    //   90: ldc ''
    //   92: aload_0
    //   93: getfield bxq : Ljava/lang/String;
    //   96: invokevirtual equals : (Ljava/lang/Object;)Z
    //   99: ifeq -> 109
    //   102: aload_0
    //   103: ldc_w '0'
    //   106: putfield bxq : Ljava/lang/String;
    //   109: aload_0
    //   110: aload_0
    //   111: getfield bsV : Ljava/util/List;
    //   114: aload_0
    //   115: getfield bsX : I
    //   118: invokeinterface get : (I)Ljava/lang/Object;
    //   123: checkcast com/laiqian/entity/g
    //   126: invokevirtual getId : ()J
    //   129: invokestatic valueOf : (J)Ljava/lang/String;
    //   132: putfield bxh : Ljava/lang/String;
    //   135: aload_0
    //   136: aload_0
    //   137: getfield bsT : Landroid/widget/TextView;
    //   140: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   143: invokeinterface toString : ()Ljava/lang/String;
    //   148: putfield bxi : Ljava/lang/String;
    //   151: aload_0
    //   152: getfield bxa : Landroid/widget/EditText;
    //   155: invokevirtual getText : ()Landroid/text/Editable;
    //   158: invokevirtual toString : ()Ljava/lang/String;
    //   161: invokevirtual trim : ()Ljava/lang/String;
    //   164: pop
    //   165: aload_0
    //   166: getfield bxh : Ljava/lang/String;
    //   169: astore_3
    //   170: aload_0
    //   171: getfield bxi : Ljava/lang/String;
    //   174: astore_3
    //   175: aload_0
    //   176: getfield bxb : Landroid/widget/EditText;
    //   179: invokevirtual getText : ()Landroid/text/Editable;
    //   182: invokevirtual toString : ()Ljava/lang/String;
    //   185: invokevirtual trim : ()Ljava/lang/String;
    //   188: pop
    //   189: aload_0
    //   190: getfield bxb : Landroid/widget/EditText;
    //   193: invokevirtual getText : ()Landroid/text/Editable;
    //   196: invokevirtual toString : ()Ljava/lang/String;
    //   199: invokevirtual trim : ()Ljava/lang/String;
    //   202: pop
    //   203: aload_0
    //   204: getfield bwZ : Landroid/widget/EditText;
    //   207: invokevirtual getText : ()Landroid/text/Editable;
    //   210: invokevirtual toString : ()Ljava/lang/String;
    //   213: invokevirtual trim : ()Ljava/lang/String;
    //   216: pop
    //   217: aload_0
    //   218: getfield bvB : Landroid/widget/TextView;
    //   221: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   224: invokeinterface toString : ()Ljava/lang/String;
    //   229: invokevirtual trim : ()Ljava/lang/String;
    //   232: pop
    //   233: new java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial <init> : ()V
    //   240: astore_3
    //   241: aload_3
    //   242: aload_0
    //   243: getfield bwG : Lcom/laiqian/member/f/a;
    //   246: getfield byv : Ljava/lang/String;
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_3
    //   254: ldc ''
    //   256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_3
    //   261: invokevirtual toString : ()Ljava/lang/String;
    //   264: pop
    //   265: new java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial <init> : ()V
    //   272: astore_3
    //   273: aload_3
    //   274: aload_0
    //   275: getfield bwG : Lcom/laiqian/member/f/a;
    //   278: getfield byu : Ljava/lang/String;
    //   281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_3
    //   286: ldc ''
    //   288: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload_3
    //   293: invokevirtual toString : ()Ljava/lang/String;
    //   296: pop
    //   297: aload_0
    //   298: getfield bwG : Lcom/laiqian/member/f/a;
    //   301: getfield byt : Ljava/lang/String;
    //   304: astore_3
    //   305: aload_0
    //   306: getfield bxq : Ljava/lang/String;
    //   309: astore_3
    //   310: new java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial <init> : ()V
    //   317: astore_3
    //   318: aload_3
    //   319: aload_0
    //   320: getfield bxk : Landroid/widget/CheckBox;
    //   323: invokevirtual isChecked : ()Z
    //   326: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_3
    //   331: ldc ''
    //   333: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_3
    //   338: invokevirtual toString : ()Ljava/lang/String;
    //   341: pop
    //   342: aload_0
    //   343: getfield bxm : Landroid/widget/EditText;
    //   346: invokevirtual getText : ()Landroid/text/Editable;
    //   349: invokevirtual toString : ()Ljava/lang/String;
    //   352: invokevirtual trim : ()Ljava/lang/String;
    //   355: pop
    //   356: new com/laiqian/entity/aq
    //   359: dup
    //   360: invokespecial <init> : ()V
    //   363: astore_3
    //   364: aload_3
    //   365: aload_0
    //   366: getfield bxa : Landroid/widget/EditText;
    //   369: invokevirtual getText : ()Landroid/text/Editable;
    //   372: invokevirtual toString : ()Ljava/lang/String;
    //   375: invokevirtual trim : ()Ljava/lang/String;
    //   378: putfield aWn : Ljava/lang/String;
    //   381: aload_3
    //   382: aload_0
    //   383: getfield bxh : Ljava/lang/String;
    //   386: invokestatic parseLong : (Ljava/lang/String;)J
    //   389: putfield aWw : J
    //   392: aload_3
    //   393: aload_0
    //   394: getfield bxi : Ljava/lang/String;
    //   397: putfield aWx : Ljava/lang/String;
    //   400: aload_3
    //   401: ldc_w '100'
    //   404: invokestatic parseDouble : (Ljava/lang/String;)D
    //   407: putfield discount : D
    //   410: aload_3
    //   411: aload_0
    //   412: getfield bxb : Landroid/widget/EditText;
    //   415: invokevirtual getText : ()Landroid/text/Editable;
    //   418: invokevirtual toString : ()Ljava/lang/String;
    //   421: invokevirtual trim : ()Ljava/lang/String;
    //   424: putfield name : Ljava/lang/String;
    //   427: aload_3
    //   428: aload_0
    //   429: getfield bwZ : Landroid/widget/EditText;
    //   432: invokevirtual getText : ()Landroid/text/Editable;
    //   435: invokevirtual toString : ()Ljava/lang/String;
    //   438: invokevirtual trim : ()Ljava/lang/String;
    //   441: putfield aTp : Ljava/lang/String;
    //   444: aload_3
    //   445: aload_1
    //   446: invokestatic parseDouble : (Ljava/lang/String;)D
    //   449: putfield aWA : D
    //   452: aload_3
    //   453: aload_2
    //   454: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   457: invokevirtual doubleValue : ()D
    //   460: putfield aWB : D
    //   463: aload_3
    //   464: aload_0
    //   465: getfield bvB : Landroid/widget/TextView;
    //   468: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   471: invokeinterface toString : ()Ljava/lang/String;
    //   476: invokevirtual trim : ()Ljava/lang/String;
    //   479: invokevirtual dy : (Ljava/lang/String;)V
    //   482: aload_3
    //   483: new com/laiqian/entity/as
    //   486: dup
    //   487: invokespecial <init> : ()V
    //   490: putfield aWH : Lcom/laiqian/entity/as;
    //   493: aload_3
    //   494: getfield aWH : Lcom/laiqian/entity/as;
    //   497: aload_0
    //   498: getfield bxm : Landroid/widget/EditText;
    //   501: invokevirtual getText : ()Landroid/text/Editable;
    //   504: invokevirtual toString : ()Ljava/lang/String;
    //   507: invokevirtual trim : ()Ljava/lang/String;
    //   510: putfield password : Ljava/lang/String;
    //   513: aload_3
    //   514: getfield aWH : Lcom/laiqian/entity/as;
    //   517: aload_0
    //   518: getfield bxk : Landroid/widget/CheckBox;
    //   521: invokevirtual isChecked : ()Z
    //   524: putfield isOpen : Z
    //   527: aload_3
    //   528: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   531: invokevirtual Tx : ()Ljava/lang/String;
    //   534: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   537: invokevirtual intValue : ()I
    //   540: putfield aWC : I
    //   543: aload_3
    //   544: dconst_0
    //   545: putfield aWo : D
    //   548: aload_3
    //   549: aload_0
    //   550: getfield bxs : Landroid/widget/EditText;
    //   553: invokevirtual getText : ()Landroid/text/Editable;
    //   556: invokevirtual toString : ()Ljava/lang/String;
    //   559: invokevirtual trim : ()Ljava/lang/String;
    //   562: putfield aJX : Ljava/lang/String;
    //   565: aload_3
    //   566: aload_0
    //   567: getfield aWq : Ljava/lang/String;
    //   570: putfield aWq : Ljava/lang/String;
    //   573: aload_3
    //   574: aload_0
    //   575: getfield startTime : J
    //   578: invokestatic valueOf : (J)Ljava/lang/String;
    //   581: putfield aVq : Ljava/lang/String;
    //   584: aload_3
    //   585: areturn }
  
  protected abstract void QG();
  
  protected abstract void QH();
  
  protected abstract void QI();
  
  public double ah(double paramDouble) {
    ArrayList arrayList = au.aW(this.bwD);
    double d1 = 0.0D;
    double d2 = d1;
    if (arrayList != null) {
      d2 = d1;
      if (arrayList.size() > 0) {
        byte b2;
        double d4;
        double d3;
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean bool = false;
        byte b1;
        for (b1 = 0; b1 < arrayList.size(); b1++)
          arrayList1.add(Double.valueOf(n.u((CharSequence)((Map)arrayList.get(b1)).get("fChargeAmount")))); 
        Collections.sort(arrayList1, Collections.reverseOrder());
        b1 = 0;
        while (true) {
          d3 = d1;
          b2 = bool;
          d4 = paramDouble;
          if (b1 < arrayList1.size()) {
            for (b2 = 0; b2 < arrayList.size(); b2++) {
              if (((Double)arrayList1.get(b1)).doubleValue() == n.u((CharSequence)((Map)arrayList.get(b2)).get("fChargeAmount")))
                arrayList2.add(Double.valueOf(n.u((CharSequence)((Map)arrayList.get(b2)).get("fBonusAmount")))); 
            } 
            b1++;
            continue;
          } 
          break;
        } 
        while (true) {
          d2 = d3;
          if (b2 < arrayList1.size()) {
            d1 = d3;
            paramDouble = d4;
            if (d4 / ((Double)arrayList1.get(b2)).doubleValue() >= 1.0D) {
              d1 = d3 + (int)(d4 / ((Double)arrayList1.get(b2)).doubleValue()) * ((Double)arrayList2.get(b2)).doubleValue();
              paramDouble = d4 - (int)(d4 / ((Double)arrayList1.get(b2)).doubleValue()) * ((Double)arrayList1.get(b2)).doubleValue();
            } 
            b2++;
            d3 = d1;
            d4 = paramDouble;
            continue;
          } 
          break;
        } 
      } 
    } 
    return d2;
  }
  
  protected void ct(View paramView) {
    super.ct(paramView);
    try {
      this.bwZ = (EditText)this.oR.findViewById(R.id.et_phone);
      this.bxa = (EditText)this.oR.findViewById(R.id.et_card_number);
      this.bxb = (EditText)this.oR.findViewById(R.id.et_name);
      this.bvB = (TextView)this.oR.findViewById(R.id.tv_birthday);
      this.bwv = (EditText)this.oR.findViewById(R.id.et_charge_amount);
      this.bww = (EditText)this.oR.findViewById(R.id.et_gift_amount);
      if (LQKVersion.zl() && !RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
        bool = this.bwH.Rl();
      } else {
        bool = this.bwI.Rl();
      } 
      null = RootApplication.getLaiqianPreferenceManager().atp();
      null = new StringBuilder();
      null.append(ah.bRU);
      null.append("");
      if (null.equals(null.toString())) {
        dG(true);
      } else {
        if (!bool) {
          bool = true;
        } else {
          bool = false;
        } 
        dG(bool);
      } 
      if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
        dG(RootApplication.getLaiqianPreferenceManager().atj()); 
      this.bxf = (EditText)this.oR.findViewById(R.id.et_initial_balance);
      this.aNv = (ProgressBarCircularIndeterminate)this.oR.findViewById(R.id.progress);
      this.bwy = (Button)this.oR.findViewById(R.id.btn_submit);
      this.bwx = (LinearLayout)this.oR.findViewById(R.id.title_l);
      this.bxs = (EditText)this.oR.findViewById(R.id.et_remark);
      this.bti = (LinearLayout)this.oR.findViewById(R.id.ll_remark);
      null = (LinearLayout)this.oR.findViewById(R.id.ll_name);
      null.setTag(this.bxb);
      null.setOnClickListener(this.bxu);
      this.bwv.addTextChangedListener(this.bwM);
      null = (LinearLayout)this.oR.findViewById(R.id.ll_phone);
      null.setTag(this.bwZ);
      null.setOnClickListener(this.bxu);
      null = (LinearLayout)this.oR.findViewById(R.id.ll_card_number);
      null.setTag(this.bxa);
      null.setOnClickListener(this.bxu);
      null = (LinearLayout)this.oR.findViewById(R.id.ll_charge_amount);
      RelativeLayout relativeLayout = (RelativeLayout)this.oR.findViewById(R.id.ll_gift_amount);
      this.bwJ = (TextView)this.oR.findViewById(R.id.tv_charge_gift_product);
      View view = this.oR.findViewById(R.id.tv_charge_gift_product_label);
      boolean bool = LQKVersion.zl();
      byte b2 = 8;
      if (bool && !RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      view.setVisibility(b1);
      TextView textView = this.bwJ;
      byte b1 = b2;
      if (LQKVersion.zl()) {
        b1 = b2;
        if (!RootApplication.getLaiqianPreferenceManager().isMultipleShop())
          b1 = 0; 
      } 
      textView.setVisibility(b1);
      if (!RootApplication.getLaiqianPreferenceManager().Wq()) {
        null.setTag(this.bwv);
        null.setOnClickListener(this.bxu);
        relativeLayout.setTag(this.bww);
        relativeLayout.setOnClickListener(this.bxu);
      } 
      this.bwy.setOnClickListener(this.bxx);
      QA();
      this.bsS = (LinearLayout)this.oR.findViewById(R.id.member_rank_ll);
      this.bsT = (TextView)this.oR.findViewById(R.id.member_rank_tv);
      if (RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
        this.bsV = RootApplication.getLaiqianPreferenceManager().ave();
      } else {
        this.bsV = bc.RH().RJ();
      } 
      ArrayList arrayList = new ArrayList();
      if (this.bsV != null)
        for (b1 = 0; b1 < this.bsV.size(); b1++)
          arrayList.add(((g)this.bsV.get(b1)).EV());  
      this.bxg = (String[])arrayList.toArray(new String[0]);
      this.bsT.setText(this.bxg[this.bsX]);
      this.bwG.cu(paramView);
      this.bxe = (LinearLayout)this.oR.findViewById(R.id.ll_initial_balance);
      this.bxe.setTag(this.bxf);
      this.bxe.setOnClickListener(this.bxu);
      if (RootApplication.getLaiqianPreferenceManager().QV() == 0 && a.zR().zZ() && "150001".equals(RootApplication.getLaiqianPreferenceManager().atp()))
        this.bxe.setVisibility(0); 
      this.bxj = (LinearLayout)this.oR.findViewById(R.id.ll_pay_password);
      this.bxl = (LinearLayout)this.oR.findViewById(R.id.ll_vip_password);
      this.bxn = (LinearLayout)this.oR.findViewById(R.id.ll_pay_password_comfirm);
      this.bxm = (EditText)this.oR.findViewById(R.id.et_pay_password);
      this.bxo = (EditText)this.oR.findViewById(R.id.et_confirm_password);
      this.bxk = (CheckBox)this.oR.findViewById(R.id.checkbox_pay_password);
      this.bxr = (ScrollView)this.oR.findViewById(R.id.scrollView);
      return;
    } catch (Exception paramView) {
      a.e(paramView);
      return;
    } 
  }
  
  void dG(boolean paramBoolean) {
    this.bww.setEnabled(paramBoolean);
    this.bww.setFocusable(paramBoolean);
    this.bww.setClickable(paramBoolean);
    if (paramBoolean) {
      this.bww.setTextColor(this.mContext.getResources().getColor(R.color.setting_text_color3));
      return;
    } 
    this.bww.setTextColor(this.mContext.getResources().getColor(R.color.pos_text_black));
  }
  
  protected void initialData() {
    super.initialData();
    QC();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getRepeatCount() > 0)
      return false; 
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      this.bwx.performClick();
      return false;
    } 
    if (paramInt != 62)
      return false; 
    this.bwy.performClick();
    return false;
  }
  
  protected void onStart() {
    boolean bool;
    super.onStart();
    if (this.aDO < 12) {
      bool = true;
    } else {
      bool = false;
    } 
    this.aDM = bool;
    if (!this.aDM)
      xV(); 
    this.bsR = am.ba(this.mContext).afs().size();
    this.bxp = a.AZ().Bw();
    if (this.bxp) {
      this.bxa.setHint(this.mContext.getString(R.string.pos_member_read_card));
    } else {
      this.bxa.setHint("");
    } 
    this.aDQ = new f(this);
  }
  
  protected void onStop() {
    if (!this.aDM && this.bxd != null)
      try {
        if (this.aDR) {
          this.aDR = false;
          this.mContext.unregisterReceiver(this.bxd);
        } 
        this.bxd = null;
      } catch (Exception exception) {
        a.e(exception);
      }  
    if (this.aDP != null)
      this.aDP.stop(); 
    if (this.aDQ != null)
      this.aDQ = null; 
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      if (!this.aDM)
        xV(); 
      this.aDQ = new t(this);
      bz bz1;
      if ((bz1 = this.aDP).aE(this.mContext)) {
        this.aDP = bz.Qw();
        this.aDP.a(this.mContext, 500L, this.aDQ);
        this.aDP.start();
        return;
      } 
    } else if (!this.aDM && this.bxd != null) {
      try {
        if (this.aDR) {
          this.aDR = false;
          this.mContext.unregisterReceiver(this.bxd);
        } 
        this.bxd = null;
        return;
      } catch (Exception exception) {
        a.e(exception);
      } 
    } 
  }
  
  protected abstract boolean p(aq paramaq);
  
  protected void showWaitingDialog(boolean paramBoolean) {
    if (paramBoolean) {
      if (this.waitingDialog == null) {
        this.waitingDialog = new bb(this.aTg);
        this.waitingDialog.setCancelable(false);
      } 
      if (!this.waitingDialog.isShowing()) {
        this.waitingDialog.show();
        return;
      } 
    } else if (this.waitingDialog != null) {
      this.waitingDialog.cancel();
    } 
  }
  
  protected void xU() {
    super.xU();
    Window window = getWindow();
    l.a(window, this.bxa);
    l.a(window, this.bwZ);
    l.a(window, this.bwv);
    l.a(window, this.bww);
    l.a(window, this.bxm);
    l.a(window, this.bxo);
    this.bxb.setOnFocusChangeListener(this.bxv);
    this.bwZ.setOnFocusChangeListener(this.bxw);
    this.bxa.setOnFocusChangeListener(this.btk);
    this.bwv.setOnFocusChangeListener(this.bwO);
    this.bww.setOnFocusChangeListener(this.bwO);
    this.bxm.setOnFocusChangeListener(this.bxw);
    this.bxm.addTextChangedListener(new v(this));
    this.bxo.setOnFocusChangeListener(this.bxw);
    this.bwx.setOnClickListener(this.bwN);
    this.bvB.setOnClickListener(new w(this));
    this.bsS.setOnClickListener(new y(this));
    this.bwv.addTextChangedListener(new c(this));
    this.bxk.setOnCheckedChangeListener(new d(this));
  }
  
  public class UsbCardReceiver extends BroadcastReceiver {
    public UsbCardReceiver(VipCreateDialog this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      String str = param1Intent.getAction();
      if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(str)) {
        bz bz;
        if ((bz = this.bxz.aDP).aE(VipCreateDialog.z(this.bxz)))
          if (this.bxz.bxa.hasFocus()) {
            this.bxz.aDP = bz.Qw();
            this.bxz.aDP.a(VipCreateDialog.A(this.bxz), 500L, this.bxz.aDQ);
            this.bxz.aDP.start();
          } else if (this.bxz.aDP != null) {
            this.bxz.aDP.stop();
          }  
      } 
      if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(str)) {
        bz bz;
        if ((!(bz = this.bxz.aDP).aE(VipCreateDialog.B(this.bxz)) || !this.bxz.bxa.hasFocus()) && this.bxz.aDP != null)
          this.bxz.aDP.stop(); 
      } 
    }
  }
  
  class a extends AsyncTask<String, Void, Boolean> {
    a(VipCreateDialog this$0) {}
    
    protected void b(Boolean param1Boolean) {
      if (param1Boolean.booleanValue()) {
        if (this.bxz.bwG.bys == null) {
          n.o("未知错误，没有选中支付类型");
          return;
        } 
        if (this.bxz.bwG.bys.bpq || this.bxz.bwG.bys.bpr) {
          VipCreateDialog.a(this.bxz);
          return;
        } 
        if (this.bxz.bwG.bys.aTv == 10007 && this.bxz.bwG.bys.aTe == 0L) {
          VipCreateDialog.a(this.bxz);
          return;
        } 
        if (this.bxz.bwG.bys.aTv == 10009 && this.bxz.bwG.bys.aTe == 8L) {
          VipCreateDialog.a(this.bxz);
          return;
        } 
        if (this.bxz.bwG.bys.aTv == 10001) {
          PrintContent.a a1 = new PrintContent.a();
          a1.age();
          PrintContent printContent = a1.afV();
          c.bp(VipCreateDialog.C(this.bxz)).e(printContent);
          this.bxz.getContext().sendBroadcast(new Intent("android.intent.money_test.action"));
        } 
        this.bxz.bxc = new VipCreateDialog.b(this.bxz);
        this.bxz.bxc.execute(new aq[] { this.bxz.QF() });
        return;
      } 
      this.bxz.bwy.setEnabled(true);
      this.bxz.bwy.setFocusable(true);
      this.bxz.bwy.setClickable(true);
      this.bxz.QI();
    }
    
    protected Boolean e(String[] param1ArrayOfString) { return Boolean.valueOf(this.bxz.J(param1ArrayOfString[0], param1ArrayOfString[1])); }
  }
  
  class b extends AsyncTask<aq, Void, Object> {
    b(VipCreateDialog this$0) {}
    
    protected Object b(aq[] param1ArrayOfaq) {
      if (this.bxz.p(param1ArrayOfaq[0])) {
        av av = new av(VipCreateDialog.u(this.bxz));
        av.rj((param1ArrayOfaq[0]).aWn);
        av.close();
        return Boolean.valueOf(true);
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPostExecute(Object param1Object) {
      this.bxz.aNv.setVisibility(8);
      this.bxz.bwy.setVisibility(0);
      if (((Boolean)param1Object).booleanValue() == true) {
        VipCreateDialog.v(this.bxz).sendBroadcast((new Intent()).setAction("pos_activity_change_data_paytype"));
        param1Object = new av(VipCreateDialog.w(this.bxz));
        param1Object.hB(true);
        param1Object.close();
        this.bxz.QG();
        Toast.makeText(VipCreateDialog.x(this.bxz), VipCreateDialog.y(this.bxz).getString(R.string.pos_charge_success), 1).show();
      } else {
        this.bxz.QH();
        this.bxz.bwy.setEnabled(true);
        this.bxz.bwy.setFocusable(true);
        this.bxz.bwy.setClickable(true);
      } 
      this.bxz.showWaitingDialog(false);
    }
    
    protected void onPreExecute() {
      this.bxz.aNv.setVisibility(0);
      this.bxz.bwy.setVisibility(8);
      this.bxz.showWaitingDialog(true);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\VipCreateDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */