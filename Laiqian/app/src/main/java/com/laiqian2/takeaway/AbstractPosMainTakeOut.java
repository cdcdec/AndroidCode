package com.laiqian.takeaway;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.entity.ap;
import com.laiqian.entity.x;
import com.laiqian.entity.z;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.takeaway.a.b;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.SwipeLayout;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.k;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bj;
import com.laiqian.util.by;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.laiqian.util.n;
import com.zhuge.analysis.b.a;
import io.reactivex.g.a;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public abstract class AbstractPosMainTakeOut extends ActivityRoot implements am.a {
  private static int WECHAT = 90004;
  
  View.OnClickListener aDd = new f(this);
  
  Button aGS;
  
  TextView bLV;
  
  private final int bWa = -1;
  
  private int bWb = -1;
  
  private Button[] bWc;
  
  boolean bfn;
  
  private String dcY;
  
  private View dqA;
  
  private View dqB;
  
  private am dqC;
  
  private TextView dqD;
  
  private TextView dqE;
  
  private TextView dqF;
  
  private TextView dqG;
  
  private k dqH;
  
  private k dqI;
  
  private k dqJ;
  
  private y dqK;
  
  private TextView dqL;
  
  private TextView dqM;
  
  private TextView dqN;
  
  private TextView dqO;
  
  private TextView dqP;
  
  private TextView dqQ;
  
  private String[] dqR;
  
  private String[] dqS;
  
  private String[] dqT;
  
  private String[] dqU;
  
  private ArrayList<String> dqV;
  
  private ArrayList<ap> dqW;
  
  private ArrayList<String> dqX = new ArrayList();
  
  private String dqY;
  
  private ay dqZ;
  
  private ListView dqy;
  
  private SwipeLayout dqz;
  
  private x drA;
  
  private ArrayList<TakeOrderEntity> drB;
  
  private Class<?> drC;
  
  @SuppressLint({"HandlerLeak"})
  Handler drD = new g(this);
  
  al.b drE = new h(this);
  
  v drF = new k(this);
  
  Button dra;
  
  View drb;
  
  Button drc;
  
  Button drd;
  
  Button dre;
  
  Button drf;
  
  TableRow drg;
  
  private final int drh = 7;
  
  private final int dri = 4;
  
  private final int drj = 6;
  
  private final int drk = 0;
  
  private final int drl = 1;
  
  private final int drm = 2;
  
  private final int drn = 3;
  
  final int dro = 6;
  
  String drp = "";
  
  String drq = "";
  
  boolean drr = false;
  
  private TakeOutReceiver drs;
  
  int drt = 1;
  
  private final int dru = 5;
  
  private double drv = 0.0D;
  
  private double drw = 0.0D;
  
  private int drx = 0;
  
  private View dry;
  
  private a drz;
  
  private boolean isLoading = true;
  
  private String type;
  
  ImageView uiTitlebarHelpIv;
  
  private bb waitingDialog;
  
  static  {
  
  }
  
  private void Pf() {
    ks(this.dqC.aqz());
    kt(this.dqC.aqA());
  }
  
  private void a(int paramInt, int... paramVarArgs) {
    this.dqz.setRefreshing(true);
    switch (paramInt) {
      case 3:
        this.drp = "pending";
        this.drr = false;
        break;
      case 2:
        this.drp = "all";
        this.drr = false;
        break;
      case 1:
        this.drp = "refund";
        this.drr = false;
        break;
      case 0:
        this.drp = "pending";
        this.drr = true;
        break;
    } 
    View view = this.dqA;
    byte b2 = 8;
    if (paramInt == 2) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    view.setVisibility(b1);
    view = this.dqB;
    byte b1 = b2;
    if (paramInt == 3)
      b1 = 0; 
    view.setVisibility(b1);
    this.dqK.oz(this.drp);
    if (!aqi()) {
      b(paramInt, paramVarArgs);
      return;
    } 
    kr(1);
    this.drw = 0.0D;
    this.dqX.clear();
    this.dqX.addAll(this.dqX);
    this.drB = this.dqC.j(this.dcY, 5, this.drt);
    a(null, new int[0]);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, TakeOrderEntity paramTakeOrderEntity, String paramString4) {
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("clickReceived ...");
    stringBuilder3.append(paramTakeOrderEntity.orderNo);
    Log.i("onClick", stringBuilder3.toString());
    if (this.waitingDialog != null)
      this.waitingDialog.show(); 
    ay ay1 = new ay(this.dqC.a(paramString1, paramString2, paramString3, paramString4, aqi(), this.drr), new j(this, paramTakeOrderEntity, paramString3));
    PrintStream printStream = System.out;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("online order URL is: ");
    stringBuilder2.append(RootUrlParameter.clr);
    stringBuilder2.append(paramString3);
    printStream.println(stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(RootUrlParameter.clr);
    stringBuilder1.append(paramString3);
    ay1.execute(new String[] { stringBuilder1.toString() });
  }
  
  private void a(ArrayList<TakeOrderEntity> paramArrayList, boolean paramBoolean) {
    byte b1;
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isNoDeliveryManSelected");
    stringBuilder.append(paramBoolean);
    printStream.println(stringBuilder.toString());
    TextView textView = this.dqQ;
    if (!paramBoolean && paramArrayList.size() > 0) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    textView.setVisibility(b1);
  }
  
  private void aC(ArrayList<TakeOrderEntity> paramArrayList) {
    this.drB = paramArrayList;
    this.dqK.U(this.drB);
    this.dqK.notifyDataSetChanged();
  }
  
  private void aD(ArrayList<TakeOrderEntity> paramArrayList) {
    String str2;
    String str1;
    TextView textView2 = this.dqL;
    if (paramArrayList == null) {
      str2 = "0";
    } else {
      null = new StringBuilder();
      null.append(" ");
      null.append(paramArrayList.size());
      str2 = null.toString();
    } 
    textView2.setText(str2);
    TextView textView1 = this.dqM;
    if (paramArrayList == null) {
      str1 = "0";
    } else {
      null = new StringBuilder();
      null.append(" ");
      null.append(n.a(Double.valueOf(this.dqC.AO()), true, false));
      str1 = null.toString();
    } 
    textView1.setText(str1);
  }
  
  private void ahr() {
    WECHAT = apX();
    this.drC = apY();
    this.dqC = new am(this);
    this.dqC.a(this);
    this.dqR = getResources().getStringArray(R.array.orderItem);
    this.dqS = getResources().getStringArray(R.array.orderItemUrl);
    this.dqT = getResources().getStringArray(R.array.sourceItem);
    this.dqU = getResources().getStringArray(R.array.sourceItemUrl);
    this.bfn = "150001".equals(RootApplication.getLaiqianPreferenceManager().atp());
    this.dqW = this.dqC.aqB();
    this.drA = (x)getIntent().getExtras().getSerializable("userPermission");
    this.dqV = this.dqC.aE(this.dqW);
    this.dqW.add(0, new ap(0L, getString(R.string.all_delivery), "0"));
    this.dqV.add(0, getString(R.string.all_delivery));
    this.dqY = (new SimpleDateFormat("yyyy/MM/dd")).format(new Date());
  }
  
  private void apZ() {
    int i = this.dqR.length;
    int j = 5;
    if (i > 5) {
      i = 5;
    } else {
      i = this.dqR.length;
    } 
    this.dqH = new k(this, '', i * 33);
    if (this.dqT.length > 5) {
      i = 5;
    } else {
      i = this.dqT.length;
    } 
    this.dqI = new k(this, '', i * 33);
    if (this.dqV.size() > 5) {
      i = j;
    } else {
      i = this.dqV.size();
    } 
    this.dqJ = new k(this, '', i * 43);
    this.dqJ.aF(this.dqV);
  }
  
  private boolean aqa() {
    if (a.zR().Af() && aqb().aiw() == 0) {
      this.drd.setVisibility(8);
      this.drf.setVisibility(8);
      this.drc.setBackgroundResource(R.drawable.selector_rounded_rectangle);
      return false;
    } 
    return true;
  }
  
  private int aqc() {
    boolean bool = a.zR().zV();
    int i = 0;
    if (bool && a.AZ().BT()) {
      i = this.dqC.aqC();
      return (aqa() && i > 0) ? 0 : 3;
    } 
    if (a.zR().Af()) {
      if (aqa())
        return 0; 
      this.dqA.setVisibility(8);
      this.dqB.setVisibility(8);
      i = -1;
    } 
    return i;
  }
  
  private void aqd() {
    if (this.dqK != null)
      this.dqK.aaQ(); 
  }
  
  private void aqe() {
    bb.f("tag", "registerTakeOutReceiver");
    if (this.drs == null)
      this.drs = new TakeOutReceiver(this); 
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("ListTakeOutBroadReceiver");
    registerReceiver(this.drs, intentFilter);
  }
  
  private void aqf() {
    bb.f("tag", "unregisterTakeOutReceiver");
    try {
      unregisterReceiver(this.drs);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private void aqg() {
    if (aqh())
      this.dqE.setText(R.string.all_delivery); 
  }
  
  private boolean aqh() { return by.isNull(this.dcY); }
  
  private boolean aqi() { return (this.bWb == 3); }
  
  private boolean aqj() { return (this.bWb == 0); }
  
  private boolean aqk() { return (this.bWb == 1); }
  
  private boolean aql() { return (this.bWb == 2); }
  
  private void aqm() {
    aqo();
    this.dqN.setText(String.format("%s", new Object[] { Integer.valueOf(this.drx) }));
    this.dqO.setText(String.format("%s", new Object[] { n.a(Double.valueOf(this.drv), true, false) }));
    this.dqP.setText(String.format("%s", new Object[] { n.a(Double.valueOf(this.drw), true, false) }));
  }
  
  private void aqn() {
    this.dqN.setText(String.format("%s", new Object[] { Integer.valueOf(0) }));
    this.dqO.setText(String.format("%s", new Object[] { Integer.valueOf(0) }));
    this.dqP.setText(String.format("%s", new Object[] { Integer.valueOf(0) }));
  }
  
  private void aqo() {
    Map map = this.dqC.oB(this.dcY);
    this.drw = ((Double)map.get("fCashAmount")).doubleValue();
    this.drv = ((Double)map.get("fAmount")).doubleValue();
    this.drx = ((Integer)map.get("orderNum")).intValue();
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Recalcuate Total Order data. orderNum is:");
    stringBuilder.append(this.drx);
    stringBuilder.append(".fAmount is:");
    stringBuilder.append(this.drv);
    stringBuilder.append(".fCashAmount is:");
    stringBuilder.append(this.drw);
    printStream.println(stringBuilder.toString());
  }
  
  private void b(int paramInt, int... paramVarArgs) {
    HashMap hashMap = this.dqC.a(aql(), aqi(), this.type, this.dqY, this.drq);
    String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS")).format(new Date(System.currentTimeMillis()));
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(System.currentTimeMillis());
    stringBuilder2.append(" ");
    stringBuilder2.append(str);
    Log.d("数据查询", stringBuilder2.toString());
    if (this.dqZ != null && this.dqZ.getStatus() != AsyncTask.Status.FINISHED)
      this.dqZ.cancel(true); 
    this.dqZ = new ay(hashMap, new e(this, paramVarArgs));
    PrintStream printStream = System.out;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("online order url is:");
    stringBuilder1.append(RootUrlParameter.clr);
    stringBuilder1.append(this.drp);
    printStream.println(stringBuilder1.toString());
    ay ay1 = this.dqZ;
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(RootUrlParameter.clr);
    stringBuilder1.append(this.drp);
    ay1.execute(new String[] { stringBuilder1.toString() });
  }
  
  private void b(String paramString, ArrayList<TakeOrderEntity> paramArrayList) throws JSONException {
    if (by.isNull(paramString))
      return; 
    paramString = (new JSONObject(paramString)).getString("push_context");
    (new bc(this)).updateOrders(paramString, false, true);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramArrayList.size());
    stringBuilder.append("");
    setPendingNums(stringBuilder.toString());
  }
  
  private void gn(int paramInt) {
    int i = paramInt;
    if (paramInt == -1) {
      paramInt = aqc();
      i = paramInt;
      if (paramInt < 0)
        return; 
    } 
    if (this.bWb == i)
      return; 
    aqd();
    this.bWb = i;
    go(i);
    a(i, new int[0]);
  }
  
  private void go(int paramInt) {
    for (byte b1 = 0; b1 < this.bWc.length; b1++) {
      boolean bool;
      if (paramInt == b1) {
        bool = true;
      } else {
        bool = false;
      } 
      this.bWc[b1].setSelected(bool ^ true);
      if (bool) {
        this.bWc[b1].setTextColor(getResources().getColor(R.color.red_color_10500));
      } else {
        this.bWc[b1].setTextColor(getResources().getColor(R.color.setting_text_color1));
      } 
    } 
  }
  
  private void kr(int paramInt) { this.drt = paramInt; }
  
  private void ks(int paramInt) {
    String str;
    Button button = this.drd;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getString(R.string.pos_wechat_titlebar_left));
    if (paramInt > 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("(");
      stringBuilder1.append(paramInt);
      stringBuilder1.append(")");
      str = stringBuilder1.toString();
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    button.setText(String.format("%s", new Object[] { stringBuilder.toString() }));
  }
  
  private void kt(int paramInt) {
    String str;
    Button button = this.dre;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getString(R.string.pos_wechat_titlebar_center));
    if (paramInt > 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("(");
      stringBuilder1.append(paramInt);
      stringBuilder1.append(")");
      str = stringBuilder1.toString();
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    button.setText(String.format("%s", new Object[] { stringBuilder.toString() }));
  }
  
  private void q(int... paramVarArgs) {
    if (this.bWb < 0) {
      this.dqz.setRefreshing(false);
      return;
    } 
    a(this.bWb, paramVarArgs);
  }
  
  private void yP() { // Byte code:
    //   0: aload_0
    //   1: getfield dqz : Lcom/laiqian/ui/SwipeLayout;
    //   4: iconst_4
    //   5: newarray int
    //   7: dup
    //   8: iconst_0
    //   9: ldc_w 17170450
    //   12: iastore
    //   13: dup
    //   14: iconst_1
    //   15: ldc_w 17170454
    //   18: iastore
    //   19: dup
    //   20: iconst_2
    //   21: ldc_w 17170456
    //   24: iastore
    //   25: dup
    //   26: iconst_3
    //   27: ldc_w 17170452
    //   30: iastore
    //   31: invokevirtual setColorSchemeResources : ([I)V
    //   34: aload_0
    //   35: getfield dqz : Lcom/laiqian/ui/SwipeLayout;
    //   38: new com/laiqian/takeaway/a
    //   41: dup
    //   42: aload_0
    //   43: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   46: invokevirtual setOnRefreshListener : (Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V
    //   49: aload_0
    //   50: getfield bWc : [Landroid/widget/Button;
    //   53: astore_3
    //   54: aload_3
    //   55: arraylength
    //   56: istore_2
    //   57: iconst_0
    //   58: istore_1
    //   59: iload_1
    //   60: iload_2
    //   61: if_icmpge -> 85
    //   64: aload_3
    //   65: iload_1
    //   66: aaload
    //   67: new com/laiqian/takeaway/AbstractPosMainTakeOut$b
    //   70: dup
    //   71: aload_0
    //   72: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   75: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   78: iload_1
    //   79: iconst_1
    //   80: iadd
    //   81: istore_1
    //   82: goto -> 59
    //   85: aload_0
    //   86: getfield aGS : Landroid/widget/Button;
    //   89: aload_0
    //   90: getfield aDd : Landroid/view/View$OnClickListener;
    //   93: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   96: aload_0
    //   97: getfield aGS : Landroid/widget/Button;
    //   100: bipush #8
    //   102: invokevirtual setVisibility : (I)V
    //   105: aload_0
    //   106: getfield dra : Landroid/widget/Button;
    //   109: new com/laiqian/takeaway/l
    //   112: dup
    //   113: aload_0
    //   114: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   117: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   120: aload_0
    //   121: getfield drb : Landroid/view/View;
    //   124: new com/laiqian/takeaway/m
    //   127: dup
    //   128: aload_0
    //   129: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   132: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   135: aload_0
    //   136: getfield dqE : Landroid/widget/TextView;
    //   139: new com/laiqian/takeaway/n
    //   142: dup
    //   143: aload_0
    //   144: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   147: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   150: aload_0
    //   151: getfield dqJ : Lcom/laiqian/ui/k;
    //   154: new com/laiqian/takeaway/o
    //   157: dup
    //   158: aload_0
    //   159: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   162: invokevirtual setOnItemClickListener : (Landroid/widget/AdapterView$OnItemClickListener;)V
    //   165: aload_0
    //   166: getfield dqQ : Landroid/widget/TextView;
    //   169: new com/laiqian/takeaway/p
    //   172: dup
    //   173: aload_0
    //   174: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   177: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   180: aload_0
    //   181: getfield dqH : Lcom/laiqian/ui/k;
    //   184: aload_0
    //   185: getfield dqR : [Ljava/lang/String;
    //   188: invokevirtual B : ([Ljava/lang/String;)V
    //   191: aload_0
    //   192: getfield dqD : Landroid/widget/TextView;
    //   195: new com/laiqian/takeaway/q
    //   198: dup
    //   199: aload_0
    //   200: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   203: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   206: aload_0
    //   207: getfield dqH : Lcom/laiqian/ui/k;
    //   210: new com/laiqian/takeaway/s
    //   213: dup
    //   214: aload_0
    //   215: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   218: invokevirtual setOnItemClickListener : (Landroid/widget/AdapterView$OnItemClickListener;)V
    //   221: aload_0
    //   222: getfield dqI : Lcom/laiqian/ui/k;
    //   225: aload_0
    //   226: getfield dqT : [Ljava/lang/String;
    //   229: invokevirtual B : ([Ljava/lang/String;)V
    //   232: invokestatic zR : ()Lcom/laiqian/c/a;
    //   235: invokevirtual zU : ()Z
    //   238: ifne -> 250
    //   241: aload_0
    //   242: getfield dqF : Landroid/widget/TextView;
    //   245: bipush #8
    //   247: invokevirtual setVisibility : (I)V
    //   250: aload_0
    //   251: getfield dqF : Landroid/widget/TextView;
    //   254: new com/laiqian/takeaway/t
    //   257: dup
    //   258: aload_0
    //   259: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   262: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   265: aload_0
    //   266: getfield dqI : Lcom/laiqian/ui/k;
    //   269: new com/laiqian/takeaway/b
    //   272: dup
    //   273: aload_0
    //   274: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   277: invokevirtual setOnItemClickListener : (Landroid/widget/AdapterView$OnItemClickListener;)V
    //   280: new java/text/SimpleDateFormat
    //   283: dup
    //   284: ldc_w 'yyyy/MM/dd'
    //   287: invokespecial <init> : (Ljava/lang/String;)V
    //   290: astore_3
    //   291: aload_0
    //   292: getfield dqG : Landroid/widget/TextView;
    //   295: aload_3
    //   296: new java/util/Date
    //   299: dup
    //   300: invokespecial <init> : ()V
    //   303: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   306: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   309: aload_0
    //   310: getfield dqG : Landroid/widget/TextView;
    //   313: new com/laiqian/takeaway/c
    //   316: dup
    //   317: aload_0
    //   318: invokespecial <init> : (Lcom/laiqian/takeaway/AbstractPosMainTakeOut;)V
    //   321: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   324: return }
  
  private void yR() {
    this.dqz = (SwipeLayout)findViewById(R.id.take_swipe_layout);
    this.dqy = (ListView)findViewById(R.id.list_view_takeout);
    this.dqy.setEmptyView(findViewById(R.id.body_selected_nodata));
    this.dqA = findViewById(R.id.ll_top);
    this.dqB = findViewById(R.id.ll_phone_top);
    this.drg = (TableRow)findViewById(R.id.ui_titlebar_weiorder);
    this.drg.setVisibility(0);
    this.bLV = (TextView)findViewById(R.id.ui_titlebar_txt);
    this.aGS = (Button)findViewById(R.id.ui_titlebar_help_btn);
    this.aGS.setText(getString(R.string.pos_wechat_titlebar_right_btn));
    this.bLV.setText(getString(R.string.pos_wechat_titlebar_title));
    this.dra = (Button)findViewById(R.id.ui_titlebar_help_btn2);
    this.dra.setText(R.string.setting);
    if (!getResources().getBoolean(R.bool.takeout_settings))
      this.dra.setVisibility(8); 
    this.uiTitlebarHelpIv = (ImageView)findViewById(R.id.ui_titlebar_help_iv);
    this.drb = findViewById(R.id.ui_titlebar_help_ll);
    if (a.zR().Ab()) {
      this.uiTitlebarHelpIv.setImageResource(R.drawable.take_away_setting);
      this.uiTitlebarHelpIv.setClickable(false);
      this.drb.setVisibility(0);
    } 
    this.drd = (Button)findViewById(R.id.weiorder_title_left);
    this.drc = (Button)findViewById(R.id.phone_title);
    this.dre = (Button)findViewById(R.id.weiorder_title_center);
    if (!getResources().getBoolean(R.bool.takeout_refund))
      this.dre.setVisibility(8); 
    if (a.zR().zV() && a.AZ().BT()) {
      this.drc.setVisibility(0);
      this.drd.setBackgroundResource(R.drawable.whitebg_greysolid_center);
    } else {
      this.drc.setVisibility(8);
      this.drd.setBackgroundResource(R.drawable.whitebg_greysolid_left);
    } 
    this.drf = (Button)findViewById(R.id.weiorder_title_right);
    this.bWc = new Button[] { this.drd, this.dre, this.drf, this.drc };
    this.dqD = (TextView)findViewById(R.id.tv_takeout_order);
    this.dqE = (TextView)findViewById(R.id.tv_takeout_distributor);
    this.dqF = (TextView)findViewById(R.id.tv_takeout_source);
    this.dqG = (TextView)findViewById(R.id.tv_takeout_date);
    this.dqL = (TextView)findViewById(R.id.tv_takeout_all_count);
    this.dqM = (TextView)findViewById(R.id.tv_takeout_all_amount);
    this.dqN = (TextView)findViewById(R.id.tv_takeout_distributor_all_count);
    this.dqO = (TextView)findViewById(R.id.tv_takeout_distributor_all_amount);
    this.dqP = (TextView)findViewById(R.id.tv_takeout_distributor_all_cash_amount);
    this.dqQ = (TextView)findViewById(R.id.tv_takeout_distributor_settle_all);
    this.dqE.setText(R.string.all_delivery);
    this.dry = LayoutInflater.from(this).inflate(R.layout.ui201406_loading, null);
    this.waitingDialog = new bb(this);
    this.waitingDialog.setCancelable(false);
    this.waitingDialog.eH(false);
    apZ();
    this.dqD.setText(this.dqR[0]);
    this.dqF.setText(this.dqT[0]);
  }
  
  public void a(TakeOrderEntity paramTakeOrderEntity, int paramInt, ArrayList<z> paramArrayList, boolean paramBoolean, String paramString, v paramv, double paramDouble, long paramLong) { b(paramTakeOrderEntity, paramInt, paramArrayList, paramBoolean, paramString, paramv, paramDouble, paramLong); }
  
  public void a(PendingFullOrderDetail paramPendingFullOrderDetail, int paramInt, ArrayList<z> paramArrayList, v paramv, double paramDouble) { b(paramPendingFullOrderDetail, paramInt, paramArrayList, paramv, paramDouble); }
  
  public void a(String paramString, int... paramVarArgs) {
    try {
      TextView textView;
      PrintStream printStream = System.out;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("order value is:");
      stringBuilder2.append(paramString);
      printStream.println(stringBuilder2.toString());
      if (this.drB == null) {
        this.dqz.setRefreshing(false);
        if (paramVarArgs.length > 0 && paramVarArgs[0] < 0)
          this.dqK.ha(false); 
        this.dqz.setRefreshing(false);
        if (this.waitingDialog != null)
          this.waitingDialog.cancel(); 
        return;
      } 
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(System.currentTimeMillis());
      stringBuilder2.append(" ");
      stringBuilder2.append(simpleDateFormat.format(new Date(System.currentTimeMillis())));
      Log.d("数据解析结果返回", stringBuilder2.toString());
      this.dqK.aaQ();
      this.dqK.T(this.drB);
      this.dqK.notifyDataSetChanged();
      if (aqi()) {
        byte b1;
        aqg();
        aqm();
        a(this.drB, aqh());
        textView = this.dqN;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(" ");
        stringBuilder2.append(this.drx);
        textView.setText(String.format("%s", new Object[] { stringBuilder2.toString() }));
        textView = this.dqO;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(" ");
        stringBuilder2.append(n.a(Double.valueOf(this.drv), true, false, 2));
        textView.setText(String.format("%s", new Object[] { stringBuilder2.toString() }));
        textView = this.dqQ;
        if (!aqh() && this.drB.size() > 0) {
          b1 = 0;
        } else {
          b1 = 8;
        } 
        textView.setVisibility(b1);
      } else if (aqj()) {
        b(textView, this.drB);
        ks(this.drB.size());
      } else if (aql()) {
        aD(this.drB);
      } else if (aqk()) {
        kt(this.drB.size());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(System.currentTimeMillis());
      stringBuilder1.append(" ");
      stringBuilder1.append(simpleDateFormat.format(new Date(System.currentTimeMillis())));
      Log.d("数据渲染结果返回", stringBuilder1.toString());
      if (paramVarArgs.length > 0 && paramVarArgs[0] < 0)
        this.dqK.ha(false); 
      this.dqz.setRefreshing(false);
      if (this.waitingDialog != null) {
        this.waitingDialog.cancel();
        return;
      } 
    } catch (Exception paramString) {
      a.e(paramString);
      h.awP().a(new d(AbstractPosMainTakeOut.class.getName(), "loadOrderData()", "error", "外卖异常"), h.a.dHw, h.b.dHA);
      if (paramVarArgs.length > 0 && paramVarArgs[0] < 0)
        this.dqK.ha(false); 
      this.dqz.setRefreshing(false);
      if (this.waitingDialog != null) {
        this.waitingDialog.cancel();
        return;
      } 
    } finally {}
  }
  
  protected abstract int apX();
  
  protected abstract Class<?> apY();
  
  public ReceiptPrintSettings aqb() { return b.bB(this).aiL(); }
  
  protected abstract void b(TakeOrderEntity paramTakeOrderEntity, int paramInt, ArrayList<z> paramArrayList, boolean paramBoolean, String paramString, v paramv, double paramDouble, long paramLong);
  
  protected abstract void b(PendingFullOrderDetail paramPendingFullOrderDetail, int paramInt, ArrayList<z> paramArrayList, v paramv, double paramDouble);
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.pos_main_takeout);
    getWindow().setFeatureInt(7, R.layout.titlebar_takeout);
    ahr();
    yR();
    yP();
    aqe();
    if (this.drB == null)
      this.drB = new ArrayList(); 
    this.dqK = new y(this, this.drB, this.drE, this.dqy, this.drD, this.drA);
    this.drz = new a(this, this.drB);
    this.dqy.setOnScrollListener(this.drz);
    this.dqy.setAdapter(this.dqK);
    Pf();
    gn(this.bWb);
  }
  
  public void onDestroy() {
    if (this.waitingDialog != null)
      this.waitingDialog.dismiss(); 
    super.onDestroy();
    a.aAU().flush(this);
    aqf();
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() {
    super.onResume();
    a.aAU().init(this);
    bj.awq().initialize(getApplicationContext());
    new aq(this);
  }
  
  @JavascriptInterface
  public void setPendingNums(String paramString) {
    bb.e("sPendingOrders", paramString);
    int i = Integer.parseInt(paramString);
    av av = new av(this);
    av.lC(i);
    av.close();
    Message message = new Message();
    message.what = 0;
    message.arg1 = i;
    this.drD.sendMessage(message);
  }
  
  public class TakeOutReceiver extends BroadcastReceiver {
    public TakeOutReceiver(AbstractPosMainTakeOut this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      AbstractPosMainTakeOut.z(this.drG);
      try {
        boolean bool1 = param1Intent.getBooleanExtra("bRefereshPending", false);
        boolean bool2 = param1Intent.getBooleanExtra("bRefereshRefund", false);
        if ((bool1 && AbstractPosMainTakeOut.A(this.drG) == 0) || (bool2 && AbstractPosMainTakeOut.A(this.drG) == 1)) {
          AbstractPosMainTakeOut.a(this.drG, new int[0]);
          return;
        } 
      } catch (Exception param1Context) {
        a.e(param1Context);
      } 
    }
  }
  
  class a implements AbsListView.OnScrollListener {
    ArrayList<TakeOrderEntity> bjv = new ArrayList();
    
    a(AbstractPosMainTakeOut this$0, ArrayList<TakeOrderEntity> param1ArrayList) {
      if (this.bjv != null)
        this.bjv.clear(); 
      this.bjv = param1ArrayList;
    }
    
    public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {
      if (param1Int1 + param1Int2 == param1Int3) {
        AbstractPosMainTakeOut.a(this.drG, true);
        return;
      } 
      AbstractPosMainTakeOut.a(this.drG, false);
    }
    
    public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
      if (AbstractPosMainTakeOut.A(this.drG) != 3)
        return; 
      if (param1Int == 0 && AbstractPosMainTakeOut.E(this.drG)) {
        AbstractPosMainTakeOut.a(this.drG, false);
        AbstractPosMainTakeOut.g(this.drG).addFooterView(AbstractPosMainTakeOut.x(this.drG));
        AbstractPosMainTakeOut.g(this.drG).setOnScrollListener(null);
        a.aKh().r(new u(this));
      } 
    }
  }
  
  class b implements View.OnTouchListener {
    b(AbstractPosMainTakeOut this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      int i = param1View.getId();
      if (i == R.id.weiorder_title_left) {
        if (param1MotionEvent.getAction() == 1) {
          AbstractPosMainTakeOut.a(this.drG, 0);
          return true;
        } 
      } else if (i == R.id.weiorder_title_center) {
        if (param1MotionEvent.getAction() == 1) {
          AbstractPosMainTakeOut.a(this.drG, 1);
          return true;
        } 
      } else if (i == R.id.weiorder_title_right) {
        if (param1MotionEvent.getAction() == 1) {
          AbstractPosMainTakeOut.a(this.drG, 2);
          return true;
        } 
      } else if (i == R.id.phone_title && param1MotionEvent.getAction() == 1) {
        AbstractPosMainTakeOut.a(this.drG, 3);
      } 
      return true;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\AbstractPosMainTakeOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */