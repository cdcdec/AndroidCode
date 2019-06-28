package com.laiqian.report.ui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.jakewharton.b.b;
import com.laiqian.auth.cj;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.entity.ap;
import com.laiqian.entity.u;
import com.laiqian.entity.v;
import com.laiqian.models.aj;
import com.laiqian.models.bg;
import com.laiqian.models.f;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.report.models.aa;
import com.laiqian.report.models.e;
import com.laiqian.report.models.i;
import com.laiqian.report.models.j;
import com.laiqian.report.models.t;
import com.laiqian.report.models.u;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.a;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.g;
import com.laiqian.ui.a.m;
import com.laiqian.ui.a.p;
import com.laiqian.ui.a.w;
import com.laiqian.util.n;
import com.laiqian.util.z;
import com.orhanobut.logger.d;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class ReportRoot extends ActivityRoot {
  protected String Ze;
  
  private w aNu;
  
  protected long bKe;
  
  protected ListView bWY;
  
  @Nullable
  private String bci;
  
  private View bqD;
  
  private TextView bqE;
  
  private View bqF;
  
  private String[] bqG;
  
  private long[] bqH;
  
  private long[] bqI;
  
  private String[] bqJ;
  
  private String[] bqK;
  
  protected int bqM;
  
  protected int bqO;
  
  protected long[] bqs = { 0L, 0L };
  
  private a bqt;
  
  private View[] bqu;
  
  private TextView bqv;
  
  private TextView bqw;
  
  private View[] bqx;
  
  private ArrayList<HashMap<String, String>> bvM;
  
  protected final String bvN = "mail";
  
  protected Dialog bvO;
  
  private final int bvP = 1234;
  
  private final int bvQ = 1;
  
  private final int bvR = 2;
  
  private m bvS;
  
  private p bvT;
  
  private TextView bvi;
  
  private TextView bvj;
  
  private PopupWindow bvk;
  
  private TextView bvl;
  
  protected View bzp;
  
  protected long[] cPh;
  
  private int ddh;
  
  private View dfS;
  
  protected String dfT;
  
  protected View dfU;
  
  protected u dfV;
  
  protected j dfW;
  
  private int dfX;
  
  protected String dfY;
  
  protected final int dfZ = 30;
  
  private TextView dgA;
  
  private TextView dgB;
  
  private View dgC;
  
  @Nullable
  private String dgD;
  
  protected u dgE;
  
  private TextView dgF;
  
  @Nullable
  private aq<h> dgG;
  
  @Nullable
  protected v dgH;
  
  private TextView dgI;
  
  @Nullable
  private aq<v> dgJ;
  
  private View dgK;
  
  protected final int dga = 10;
  
  protected final int dgb = 99;
  
  protected final int dgc = 98;
  
  protected final int dgd = 981;
  
  protected final int dge = 97;
  
  protected final int dgf = 11;
  
  protected final int dgg = 12;
  
  private View dgh;
  
  protected View dgi;
  
  protected View dgj;
  
  protected boolean dgk;
  
  View dgl;
  
  private View dgm;
  
  protected boolean dgn = true;
  
  b<Integer> dgo;
  
  b<Integer> dgp;
  
  b<Integer> dgq = (this.dgp = (this.dgo = b.ak(Integer.valueOf(0))).ak(Integer.valueOf(0))).ak(Integer.valueOf(0));
  
  protected AbsListView.OnScrollListener dgr = new bp(this);
  
  @Nullable
  private aq<e> dgs;
  
  private aq<e> dgt;
  
  private e dgu;
  
  private aa dgv = new aa();
  
  private final int dgw = 1001;
  
  private final int dgx = 1002;
  
  @Nullable
  private g<ap> dgy;
  
  private g<u> dgz;
  
  protected Handler handler = new au(this);
  
  protected String orderTypeID;
  
  private void PA() {}
  
  private void QZ() {
    if (this.bKe != 0L || (this.cPh != null && this.cPh.length > 0) || this.dgD != null || (this.dgH != null && this.dgH.aSX != 0) || ((Integer)this.dgo.getValue()).intValue() != 0 || ((Integer)this.dgp.getValue()).intValue() != 0 || (!TextUtils.isEmpty(this.orderTypeID) && Integer.valueOf(this.orderTypeID).intValue() != -1)) {
      this.dgC.setVisibility(0);
      return;
    } 
    this.dgC.setVisibility(8);
  }
  
  private void Qs() {
    HashMap hashMap = (HashMap)this.bvM.get(0);
    ArrayList arrayList = n.a(this, true);
    if (arrayList.isEmpty()) {
      hashMap.put("state", getString(2131627877));
      hashMap.put("address", null);
      return;
    } 
    hashMap.put("state", getString(2131627876));
    hashMap.put("address", arrayList.get(0));
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
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #7
    //   23: aload #7
    //   25: aload_0
    //   26: getfield bqM : I
    //   29: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload #7
    //   35: ldc_w ''
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload #5
    //   44: aload #7
    //   46: invokevirtual toString : ()Ljava/lang/String;
    //   49: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   52: ifeq -> 125
    //   55: new java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial <init> : ()V
    //   62: astore #7
    //   64: aload #7
    //   66: aload_0
    //   67: getfield bqM : I
    //   70: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload #7
    //   76: ldc_w ''
    //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload #6
    //   85: aload #7
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   93: ifeq -> 125
    //   96: aload_0
    //   97: getfield bqv : Landroid/widget/TextView;
    //   100: aload #5
    //   102: iconst_5
    //   103: invokevirtual substring : (I)Ljava/lang/String;
    //   106: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   109: aload_0
    //   110: getfield bqw : Landroid/widget/TextView;
    //   113: aload #6
    //   115: iconst_5
    //   116: invokevirtual substring : (I)Ljava/lang/String;
    //   119: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   122: goto -> 332
    //   125: new java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial <init> : ()V
    //   132: astore #7
    //   134: aload #7
    //   136: ldc_w '-'
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload #7
    //   145: aload_0
    //   146: getfield bqM : I
    //   149: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload #5
    //   155: aload #7
    //   157: invokevirtual toString : ()Ljava/lang/String;
    //   160: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   163: ifeq -> 314
    //   166: new java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial <init> : ()V
    //   173: astore #7
    //   175: aload #7
    //   177: ldc_w '-'
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload #7
    //   186: aload_0
    //   187: getfield bqM : I
    //   190: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload #6
    //   196: aload #7
    //   198: invokevirtual toString : ()Ljava/lang/String;
    //   201: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   204: ifeq -> 314
    //   207: aload_0
    //   208: getfield bqv : Landroid/widget/TextView;
    //   211: astore #7
    //   213: new java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial <init> : ()V
    //   220: astore #8
    //   222: aload #8
    //   224: ldc_w '-'
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload #8
    //   233: aload_0
    //   234: getfield bqM : I
    //   237: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload #7
    //   243: aload #5
    //   245: aload #8
    //   247: invokevirtual toString : ()Ljava/lang/String;
    //   250: ldc_w ''
    //   253: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   256: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   259: aload_0
    //   260: getfield bqw : Landroid/widget/TextView;
    //   263: astore #5
    //   265: new java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial <init> : ()V
    //   272: astore #7
    //   274: aload #7
    //   276: ldc_w '-'
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload #7
    //   285: aload_0
    //   286: getfield bqM : I
    //   289: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload #5
    //   295: aload #6
    //   297: aload #7
    //   299: invokevirtual toString : ()Ljava/lang/String;
    //   302: ldc_w ''
    //   305: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   308: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   311: goto -> 332
    //   314: aload_0
    //   315: getfield bqv : Landroid/widget/TextView;
    //   318: aload #5
    //   320: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   323: aload_0
    //   324: getfield bqw : Landroid/widget/TextView;
    //   327: aload #6
    //   329: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   332: aload_0
    //   333: getfield bqv : Landroid/widget/TextView;
    //   336: lload_1
    //   337: invokestatic valueOf : (J)Ljava/lang/Long;
    //   340: invokevirtual setTag : (Ljava/lang/Object;)V
    //   343: aload_0
    //   344: getfield bqw : Landroid/widget/TextView;
    //   347: lload_3
    //   348: invokestatic valueOf : (J)Ljava/lang/Long;
    //   351: invokevirtual setTag : (Ljava/lang/Object;)V
    //   354: aload_0
    //   355: invokespecial PA : ()V
    //   358: return }
  
  private void a(ap paramap) {
    if (this.dgy == null)
      return; 
    boolean bool = false;
    ap ap1 = paramap;
    if (paramap == null) {
      paramap = (ap)this.dgy.kT(0);
      ap1 = paramap;
      if (paramap == null) {
        n.println("改变员工过滤时，出现未知错误");
        return;
      } 
    } 
    this.dgy.dn(ap1.AR());
    this.bKe = ap1.AR();
    this.dgA.setText(ap1.AT());
    TextView textView = this.dgA;
    if (ap1.AR() > 0L)
      bool = true; 
    textView.setSelected(bool);
    QZ();
  }
  
  private void a(u paramu, TextView paramTextView) {
    if (this.dgz == null)
      return; 
    boolean bool = false;
    u u1 = paramu;
    if (paramu == null) {
      paramu = (u)this.dgz.kT(0);
      u1 = paramu;
      if (paramu == null) {
        n.println("改变员工过滤时，出现未知错误");
        return;
      } 
    } 
    this.dgz.dn(u1.AR());
    this.dgE = u1;
    this.orderTypeID = String.valueOf(u1.AR());
    paramTextView.setText(u1.AT());
    if (u1.AR() > 0L)
      bool = true; 
    paramTextView.setSelected(bool);
    QZ();
  }
  
  private void a(e parame) {
    this.dgu = parame;
    this.dgv.dcr = false;
    this.dgv.isShow = false;
    this.bqE.setText(parame.AT());
    this.bqO = (int)parame.AR();
    a(new View[] { this.bqD });
    long[] arrayOfLong = parame.amF();
    String[] arrayOfString = parame.amG();
    a(arrayOfLong[0], arrayOfLong[1], arrayOfString[0], arrayOfString[1]);
  }
  
  private void a(e parame, boolean paramBoolean) {
    this.dgu = parame;
    this.dgv.dcr = true;
    this.dgv.isShow = false;
    this.bqO = 4;
    a(new View[] { this.bqF });
    long[] arrayOfLong = parame.amF();
    String[] arrayOfString = parame.amG();
    a(arrayOfLong[0], arrayOfLong[1], arrayOfString[0], arrayOfString[1]);
    if (paramBoolean)
      AJ(); 
  }
  
  private void a(h paramh) {
    if (this.dgG == null)
      return; 
    boolean bool = false;
    h h1 = paramh;
    if (paramh == null) {
      paramh = (h)this.dgG.kT(0);
      h1 = paramh;
      if (paramh == null) {
        n.o("类型的选择框异常");
        return;
      } 
    } 
    h1.dgW.run();
    this.dgD = h1.value;
    this.dgF.setText(h1.cZi);
    TextView textView = this.dgF;
    if (this.dgD != null)
      bool = true; 
    textView.setSelected(bool);
    this.dgG.dn(h1.AR());
    QZ();
  }
  
  private void a(boolean paramBoolean, String paramString, int paramInt) {
    /* monitor enter ThisExpression{ObjectType{com/laiqian/report/ui/ReportRoot}} */
    if (paramBoolean)
      try {
        if (!paramString.equals(this.dfT)) {
          n.println("该页面已关闭或被覆盖,下拉加载不会被覆盖掉;连续点击查询的时候，会进来");
          /* monitor exit ThisExpression{ObjectType{com/laiqian/report/ui/ReportRoot}} */
          return;
        } 
        a(this.dfV);
        t t = (new t.a(this.bqs[0], this.bqs[1])).dh(this.bKe).k(this.cPh).d(this.dgH).nn(this.dgD).no(this.bci).np(this.orderTypeID).anl();
        this.dfV.a(t);
        if (!paramString.equals(this.dfT)) {
          n.println("该页面已关闭或被覆盖,下拉加载不会被覆盖掉;连续点击查询的时候，会进来");
          /* monitor exit ThisExpression{ObjectType{com/laiqian/report/ui/ReportRoot}} */
          return;
        } 
      } catch (Exception paramString) {
      
      } finally {} 
    ArrayList arrayList = this.dfV.zJ();
    if (this.dfT == null) {
      n.println("页面已经被关闭");
      /* monitor exit ThisExpression{ObjectType{com/laiqian/report/ui/ReportRoot}} */
      return;
    } 
    if (paramBoolean && !paramString.equals(this.dfT)) {
      n.println("该页面已关闭或被覆盖,下拉加载不会被覆盖掉");
    } else {
      byte b1;
      Message message = new Message();
      message.obj = arrayList;
      message.what = 10;
      if (paramBoolean) {
        b1 = 11;
      } else {
        b1 = 12;
      } 
      message.arg1 = b1;
      message.arg2 = paramInt;
      this.handler.sendMessage(message);
    } 
    /* monitor exit ThisExpression{ObjectType{com/laiqian/report/ui/ReportRoot}} */
  }
  
  private void a(long[] paramArrayOfLong, String[] paramArrayOfString) {
    int i;
    if (this.dgB == null)
      return; 
    if (paramArrayOfLong == null) {
      this.cPh = new long[0];
    } else {
      this.cPh = paramArrayOfLong;
    } 
    if (paramArrayOfString == null) {
      i = 0;
    } else {
      i = paramArrayOfString.length;
    } 
    if (this.cPh.length != i) {
      n.a(this, "未知错误，商品ID的数量和商品名称的数量不一致");
      return;
    } 
    if (this.cPh.length == 0) {
      this.dgB.setSelected(false);
      this.dgB.setText(2131628069);
    } else {
      null = this.dgB;
      i = 1;
      null.setSelected(true);
      StringBuilder stringBuilder1 = new StringBuilder(paramArrayOfString[0]);
      while (i < paramArrayOfString.length) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        stringBuilder.append(paramArrayOfString[i]);
        stringBuilder1.append(stringBuilder.toString());
        i++;
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("数组的类型是：");
      stringBuilder2.append(paramArrayOfString.getClass());
      stringBuilder2.append(",筛选的商品：");
      stringBuilder2.append(stringBuilder1);
      n.println(stringBuilder2.toString());
      this.dgB.setText(stringBuilder1);
    } 
    QZ();
  }
  
  private void a(View... paramVarArgs) {
    for (byte b1 = 0; b1 < this.bqx.length; b1++)
      this.bqx[b1].setSelected(n.a(this.bqx[b1], paramVarArgs)); 
  }
  
  private void aoe() {
    HashMap hashMap = new HashMap();
    if (this.bqO > -1)
      hashMap.put("time", getResources().getStringArray(2130903089)[this.bqO]); 
    X(hashMap);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("report_");
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("_filter");
    MobclickAgent.onEvent(this, stringBuilder.toString(), hashMap);
  }
  
  private ArrayList<e> c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    ArrayList arrayList = new ArrayList();
    this.bqG = new String[4];
    this.bqH = new long[4];
    this.bqI = new long[4];
    this.bqJ = new String[4];
    this.bqK = new String[4];
    Time time1 = new Time();
    time1.setToNow();
    time1.set(0, 0, 0, time1.monthDay, time1.month, time1.year);
    long l4 = time1.normalize(false);
    Time time2 = new Time();
    time2.setToNow();
    time2.set(0, paramInt1, paramInt2, time2.monthDay, time2.month, time2.year);
    long l5 = time2.normalize(false);
    String str4 = time2.format(this.Ze);
    long l3 = l4 + 86400000L - 1L;
    time1.set(l3);
    long l1 = l4 + ((paramInt4 * 60 + paramInt3) * 60 * 1000) + 59000L;
    if (!z.q(paramInt2, paramInt1, paramInt4, paramInt3))
      l1 += 86400000L; 
    if (System.currentTimeMillis() > l1) {
      l2 = System.currentTimeMillis();
    } else {
      l2 = l1;
    } 
    time2.set(l2);
    String str1 = time1.format(this.Ze);
    String str5 = time2.format(this.Ze);
    String str6 = getString(2131627885);
    arrayList.add(new e(0L, new long[] { l5, l2 }, new String[] { str4, str5 }, str6));
    long l2 = l5 - 86400000L;
    time2.set(l2);
    str4 = time2.format(this.Ze);
    l1 -= 86400000L;
    if (paramBoolean)
      l1 = System.currentTimeMillis(); 
    time2.set(l1);
    String str3 = time2.format(this.Ze);
    str5 = getString(2131627886);
    arrayList.add(new e(1L, new long[] { l2, l1 }, new String[] { str4, str3 }, str5));
    time1.set(0, 0, 0, time1.monthDay - 6, time1.month, time1.year);
    l1 = time1.normalize(false);
    str3 = time1.format(this.Ze);
    str4 = getString(2131627881);
    arrayList.add(new e(2L, new long[] { l1, l3 }, new String[] { str3, str1 }, str4));
    time1.set(l4);
    time1.monthDay = 1;
    l1 = time1.normalize(false);
    String str2 = time1.format(this.Ze);
    str3 = getString(2131627884);
    arrayList.add(new e(3L, new long[] { l1, l3 }, new String[] { str2, str1 }, str3));
    return arrayList;
  }
  
  private void e(v paramv) {
    if (this.dgJ == null)
      return; 
    boolean bool = false;
    if (paramv == null) {
      this.dgH = (v)this.dgJ.kT(0);
      if (this.dgH == null) {
        n.o("支付方式的选择框异常");
        return;
      } 
    } else {
      this.dgH = paramv;
    } 
    this.dgI.setText(this.dgH.AT());
    TextView textView = this.dgI;
    if (this.dgH.aSX > 0)
      bool = true; 
    textView.setSelected(bool);
    this.dgJ.dn(this.dgH.AR());
    QZ();
  }
  
  private void fB(String paramString) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield dfV : Lcom/laiqian/report/models/u;
    //   6: astore #5
    //   8: aload #5
    //   10: ifnonnull -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield dfV : Lcom/laiqian/report/models/u;
    //   20: instanceof com/laiqian/report/models/i
    //   23: ifne -> 36
    //   26: aload_0
    //   27: ldc_w '当前类，既然要用导出，就必须实现导出接口'
    //   30: invokestatic a : (Landroid/content/Context;Ljava/lang/CharSequence;)V
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_0
    //   37: invokevirtual Td : ()Ljava/lang/String;
    //   40: astore #5
    //   42: aload #5
    //   44: ifnull -> 67
    //   47: aload_0
    //   48: getfield handler : Landroid/os/Handler;
    //   51: sipush #1234
    //   54: iconst_0
    //   55: iconst_0
    //   56: aload #5
    //   58: invokevirtual obtainMessage : (IIILjava/lang/Object;)Landroid/os/Message;
    //   61: invokevirtual sendToTarget : ()V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: new java/io/File
    //   70: dup
    //   71: aload_0
    //   72: getfield dfV : Lcom/laiqian/report/models/u;
    //   75: invokevirtual Tf : ()Ljava/lang/String;
    //   78: invokespecial <init> : (Ljava/lang/String;)V
    //   81: astore #7
    //   83: aload_0
    //   84: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   87: ldc_w 2131034123
    //   90: invokevirtual getBoolean : (I)Z
    //   93: istore #4
    //   95: iconst_1
    //   96: istore_3
    //   97: iload #4
    //   99: ifeq -> 114
    //   102: aload_0
    //   103: ldc_w 2131627844
    //   106: invokevirtual getString : (I)Ljava/lang/String;
    //   109: astore #6
    //   111: goto -> 177
    //   114: new com/laiqian/util/av
    //   117: dup
    //   118: aload_0
    //   119: invokespecial <init> : (Landroid/content/Context;)V
    //   122: astore #6
    //   124: new com/laiqian/models/bh
    //   127: dup
    //   128: aload_0
    //   129: invokespecial <init> : (Landroid/content/Context;)V
    //   132: astore #8
    //   134: aload #8
    //   136: aload #6
    //   138: invokevirtual atm : ()Ljava/lang/String;
    //   141: invokevirtual iB : (Ljava/lang/String;)Ljava/lang/String;
    //   144: astore #9
    //   146: aload #8
    //   148: invokevirtual close : ()V
    //   151: aload #6
    //   153: invokevirtual close : ()V
    //   156: aload_0
    //   157: ldc_w 2131627845
    //   160: invokevirtual getString : (I)Ljava/lang/String;
    //   163: iconst_1
    //   164: anewarray java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload #9
    //   171: aastore
    //   172: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   175: astore #6
    //   177: aload_1
    //   178: ldc_w '@'
    //   181: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   184: ifeq -> 262
    //   187: aload_0
    //   188: getfield dfV : Lcom/laiqian/report/models/u;
    //   191: checkcast com/laiqian/report/models/i
    //   194: invokeinterface AX : ()Ljava/lang/String;
    //   199: astore #7
    //   201: aload_0
    //   202: getfield dfV : Lcom/laiqian/report/models/u;
    //   205: invokevirtual Tf : ()Ljava/lang/String;
    //   208: astore #8
    //   210: iconst_1
    //   211: anewarray java/lang/String
    //   214: dup
    //   215: iconst_0
    //   216: aload_1
    //   217: aastore
    //   218: aload #7
    //   220: aload #6
    //   222: iconst_1
    //   223: anewarray java/lang/String
    //   226: dup
    //   227: iconst_0
    //   228: aload #8
    //   230: aastore
    //   231: invokestatic a : ([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   234: ifne -> 246
    //   237: aload_0
    //   238: ldc_w 2131627851
    //   241: invokevirtual getString : (I)Ljava/lang/String;
    //   244: astore #5
    //   246: aload #5
    //   248: ifnonnull -> 363
    //   251: aload_0
    //   252: invokevirtual getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   255: aload_1
    //   256: invokevirtual rr : (Ljava/lang/String;)V
    //   259: goto -> 363
    //   262: new java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial <init> : ()V
    //   269: astore #6
    //   271: aload #6
    //   273: aload_0
    //   274: ldc_w 2131627843
    //   277: invokevirtual getString : (I)Ljava/lang/String;
    //   280: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload #6
    //   286: ldc_w '/'
    //   289: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload #6
    //   295: aload #7
    //   297: invokevirtual getName : ()Ljava/lang/String;
    //   300: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: iload_3
    //   305: istore_2
    //   306: aload #7
    //   308: new java/io/File
    //   311: dup
    //   312: aload_1
    //   313: aload #6
    //   315: invokevirtual toString : ()Ljava/lang/String;
    //   318: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   321: invokestatic d : (Ljava/io/File;Ljava/io/File;)Z
    //   324: ifne -> 338
    //   327: aload_0
    //   328: ldc_w 2131627879
    //   331: invokevirtual getString : (I)Ljava/lang/String;
    //   334: astore #5
    //   336: iload_3
    //   337: istore_2
    //   338: aload_0
    //   339: getfield handler : Landroid/os/Handler;
    //   342: sipush #1234
    //   345: iload_2
    //   346: iconst_0
    //   347: aload #5
    //   349: invokevirtual obtainMessage : (IIILjava/lang/Object;)Landroid/os/Message;
    //   352: invokevirtual sendToTarget : ()V
    //   355: aload_0
    //   356: monitorexit
    //   357: return
    //   358: astore_1
    //   359: aload_0
    //   360: monitorexit
    //   361: aload_1
    //   362: athrow
    //   363: iconst_2
    //   364: istore_2
    //   365: goto -> 338
    // Exception table:
    //   from	to	target	type
    //   2	8	358	finally
    //   16	33	358	finally
    //   36	42	358	finally
    //   47	64	358	finally
    //   67	95	358	finally
    //   102	111	358	finally
    //   114	177	358	finally
    //   177	210	358	finally
    //   210	246	358	finally
    //   251	259	358	finally
    //   262	304	358	finally
    //   306	336	358	finally
    //   338	355	358	finally }
  
  private void fx(String paramString) {
    if (paramString == null) {
      if (!n.a(this, true).isEmpty()) {
        Qs();
        this.bvT.notifyDataSetChanged();
        paramString = (String)((HashMap)this.bvM.get(0)).get("address");
        if (paramString != null) {
          fx(paramString);
          return;
        } 
      } 
    } else {
      Rect rect;
      if (paramString == "mail") {
        if (this.bvk == null) {
          boolean bool;
          View view1 = View.inflate(this, 2131427863, null);
          this.bvj = (TextView)view1.findViewById(2131296334);
          this.bvi = (TextView)view1.findViewById(2131296893);
          if (!a.zR().Ad() && !a.zR().Ab()) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool) {
            int n;
            null = getResources();
            if (getResources().getBoolean(2131034123)) {
              n = 2130903069;
            } else {
              n = 2130903070;
            } 
            String[] arrayOfString1 = null.getStringArray(n);
            String[] arrayOfString2 = getLaiqianPreferenceManager().auT();
            if (arrayOfString2 != null) {
              this.bvj.setText(arrayOfString2[0]);
              this.bvi.setText(arrayOfString2[1]);
              view1.requestFocus();
            } else {
              this.bvj.setText("");
              this.bvj.requestFocus();
              this.bvi.setText(arrayOfString1[0]);
              n.b(this, this.bvj);
            } 
            this.aNu = new w(this, arrayOfString1, new bu(this, arrayOfString1));
            this.bvi.setOnClickListener(new bv(this));
          } else {
            this.bvi.setVisibility(8);
          } 
          this.bvk = new PopupWindow(view1, -2, -2, true);
          this.bvk.setBackgroundDrawable(new ColorDrawable());
          this.bvk.setOutsideTouchable(true);
          this.bvl = (TextView)view1.findViewById(2131299317);
          view1.findViewById(2131298939).setOnClickListener(new bw(this, bool));
          view1.findViewById(2131296671).setOnClickListener(new av(this));
        } 
        rect = new Rect();
        View view = this.bvS.ark();
        view.getGlobalVisibleRect(rect);
        int i = rect.right;
        int k = rect.top;
        this.bvl.setText(null);
        this.bvk.showAtLocation(view, 0, i, k);
        return;
      } 
      if (n.a(this, true).isEmpty()) {
        Qs();
        this.bvT.notifyDataSetChanged();
        return;
      } 
      this.bvO.show();
      (new c(this, rect, null)).start();
    } 
  }
  
  private void g(Message paramMessage) {
    if (this.dfV == null)
      return; 
    boolean bool = this.dfV.ano();
    ArrayList arrayList = (ArrayList)paramMessage.obj;
    gE(bool);
    i i = (i)n.b(this.bWY);
    if (paramMessage.arg1 == 11) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      i.a(i, arrayList);
    } else {
      i.b(i, arrayList);
    } 
    if (!bool || !arrayList.isEmpty())
      aoi(); 
    a(bool, arrayList, paramMessage.arg2);
    this.dfS.setVisibility(8);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("目前有多少数据：");
    stringBuilder.append(i.getCount());
    n.println(stringBuilder.toString());
  }
  
  private void gH(boolean paramBoolean) {
    RadioButton radioButton1 = (RadioButton)findViewById(2131296778);
    RadioButton radioButton2 = (RadioButton)findViewById(2131296779);
    RadioButton radioButton3 = (RadioButton)findViewById(2131296780);
    if (paramBoolean) {
      radioButton2.setChecked(true);
      this.dgo.accept(Integer.valueOf(1));
    } 
    if (paramBoolean) {
      radioButton1.setBackgroundResource(2131231777);
      radioButton3.setBackgroundResource(2131231777);
    } else {
      radioButton1.setBackgroundResource(2131231778);
      radioButton3.setBackgroundResource(2131231778);
    } 
    radioButton1.setEnabled(paramBoolean ^ true);
    radioButton2.setEnabled(paramBoolean ^ true);
    radioButton3.setEnabled(paramBoolean ^ true);
  }
  
  private void gI(boolean paramBoolean) {
    RadioButton radioButton1 = (RadioButton)findViewById(2131296697);
    RadioButton radioButton2 = (RadioButton)findViewById(2131296699);
    RadioButton radioButton3 = (RadioButton)findViewById(2131296698);
    if (paramBoolean) {
      radioButton2.setChecked(true);
      this.dgp.accept(Integer.valueOf(1));
    } 
    if (paramBoolean) {
      radioButton1.setBackgroundResource(2131231777);
      radioButton3.setBackgroundResource(2131231777);
    } else {
      radioButton1.setBackgroundResource(2131231778);
      radioButton3.setBackgroundResource(2131231778);
    } 
    radioButton1.setEnabled(paramBoolean ^ true);
    radioButton2.setEnabled(paramBoolean ^ true);
    radioButton3.setEnabled(paramBoolean ^ true);
  }
  
  private b jX(int paramInt) { // Byte code:
    //   0: new com/laiqian/report/ui/ReportRoot$b
    //   3: dup
    //   4: aload_0
    //   5: invokespecial <init> : (Lcom/laiqian/report/ui/ReportRoot;)V
    //   8: astore #8
    //   10: iload_1
    //   11: istore_2
    //   12: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   15: invokevirtual Cc : ()Ljava/lang/String;
    //   18: astore #9
    //   20: iload_1
    //   21: istore_2
    //   22: iload_1
    //   23: istore_3
    //   24: aload #9
    //   26: invokestatic isNull : (Ljava/lang/String;)Z
    //   29: ifne -> 229
    //   32: iload_1
    //   33: istore_2
    //   34: iload_1
    //   35: istore_3
    //   36: aload #9
    //   38: ldc_w '-'
    //   41: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   44: ifeq -> 229
    //   47: iload_1
    //   48: istore_2
    //   49: aload #9
    //   51: ldc_w '-'
    //   54: ldc_w ':'
    //   57: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   60: ldc_w ':'
    //   63: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   66: astore #9
    //   68: iload_1
    //   69: istore_2
    //   70: iload_1
    //   71: istore_3
    //   72: aload #9
    //   74: arraylength
    //   75: iconst_4
    //   76: if_icmpne -> 229
    //   79: iload_1
    //   80: istore_2
    //   81: aload #9
    //   83: iconst_0
    //   84: aaload
    //   85: invokestatic parseInt : (Ljava/lang/String;)I
    //   88: istore_3
    //   89: iload_1
    //   90: istore_2
    //   91: aload #9
    //   93: iconst_1
    //   94: aaload
    //   95: invokestatic parseInt : (Ljava/lang/String;)I
    //   98: istore #4
    //   100: iload_1
    //   101: istore_2
    //   102: aload #9
    //   104: iconst_2
    //   105: aaload
    //   106: invokestatic parseInt : (Ljava/lang/String;)I
    //   109: istore #5
    //   111: iload_1
    //   112: istore_2
    //   113: aload #9
    //   115: iconst_3
    //   116: aaload
    //   117: invokestatic parseInt : (Ljava/lang/String;)I
    //   120: istore #6
    //   122: iload_1
    //   123: ifne -> 246
    //   126: iload_1
    //   127: istore_2
    //   128: new android/text/format/Time
    //   131: dup
    //   132: invokespecial <init> : ()V
    //   135: astore #9
    //   137: iload_1
    //   138: istore_2
    //   139: aload #9
    //   141: invokevirtual setToNow : ()V
    //   144: iload_1
    //   145: istore_2
    //   146: aload #9
    //   148: getfield hour : I
    //   151: iload_3
    //   152: if_icmplt -> 238
    //   155: iload_1
    //   156: istore_2
    //   157: aload #9
    //   159: getfield hour : I
    //   162: iload_3
    //   163: if_icmpne -> 246
    //   166: iload_1
    //   167: istore_2
    //   168: aload #9
    //   170: getfield minute : I
    //   173: iload #4
    //   175: if_icmpge -> 246
    //   178: goto -> 238
    //   181: iload_1
    //   182: istore_2
    //   183: aload #8
    //   185: aload_0
    //   186: iload #4
    //   188: iload_3
    //   189: iload #6
    //   191: iload #5
    //   193: iload #7
    //   195: invokespecial c : (IIIIZ)Ljava/util/ArrayList;
    //   198: putfield bjv : Ljava/util/ArrayList;
    //   201: iload_1
    //   202: istore_3
    //   203: goto -> 229
    //   206: astore #9
    //   208: aload #9
    //   210: invokestatic e : (Ljava/lang/Throwable;)V
    //   213: aload #8
    //   215: aload_0
    //   216: iconst_0
    //   217: iconst_0
    //   218: iconst_0
    //   219: iconst_0
    //   220: iconst_0
    //   221: invokespecial c : (IIIIZ)Ljava/util/ArrayList;
    //   224: putfield bjv : Ljava/util/ArrayList;
    //   227: iload_2
    //   228: istore_3
    //   229: aload #8
    //   231: iload_3
    //   232: putfield dgR : I
    //   235: aload #8
    //   237: areturn
    //   238: iconst_1
    //   239: istore_1
    //   240: iconst_1
    //   241: istore #7
    //   243: goto -> 181
    //   246: iconst_0
    //   247: istore #7
    //   249: goto -> 181
    // Exception table:
    //   from	to	target	type
    //   12	20	206	java/lang/Exception
    //   24	32	206	java/lang/Exception
    //   36	47	206	java/lang/Exception
    //   49	68	206	java/lang/Exception
    //   72	79	206	java/lang/Exception
    //   81	89	206	java/lang/Exception
    //   91	100	206	java/lang/Exception
    //   102	111	206	java/lang/Exception
    //   113	122	206	java/lang/Exception
    //   128	137	206	java/lang/Exception
    //   139	144	206	java/lang/Exception
    //   146	155	206	java/lang/Exception
    //   157	166	206	java/lang/Exception
    //   168	178	206	java/lang/Exception
    //   183	201	206	java/lang/Exception }
  
  private void l(View paramView, boolean paramBoolean) {
    null = paramView.findViewById(2131298360);
    if (!paramBoolean)
      null.setVisibility(8); 
    paramView = null.findViewById(2131298928);
    this.dgm = null.findViewById(2131298927);
    ArrayList arrayList1 = new ArrayList();
    arrayList1.add(new h(this, 11, getText(2131628048), null, new bh(this), null));
    arrayList1.add(new h(this, 22, getText(2131627810), "100001,100066", new bi(this), null));
    arrayList1.add(new h(this, 33, getText(2131627816), "100015", new bj(this), null));
    arrayList1.add(new h(this, 44, getText(2131627957), "100066", new bk(this), null));
    this.dgF = (TextView)paramView.findViewById(2131298364);
    this.dgG = new g(this, arrayList1, new bl(this));
    paramView.setOnClickListener(new bm(this));
    a((h)arrayList1.get(0));
    v v1;
    v v2;
    v v3;
    v v4 = (v3 = (v2 = (v1 = new v(0L, getString(2131628048), false, false)).FV()).FY()).FZ();
    arrayList1 = new ArrayList();
    arrayList1.add(v1);
    f f = new f(this);
    ArrayList arrayList3 = f.o(false, false);
    f.close();
    arrayList1.addAll(arrayList3);
    arrayList1.add(v2);
    if (getResources().getBoolean(2131034129))
      arrayList1.add(v.FX()); 
    if (getResources().getBoolean(2131034136))
      arrayList1.add(v.FW()); 
    if (getResources().getBoolean(2131034133)) {
      arrayList1.add(v.FS());
      arrayList1.add(v.FT());
    } 
    if (a.AZ().BJ())
      arrayList1.add(v4); 
    arrayList1.add(v.FU());
    arrayList1.add(v.FY());
    ArrayList arrayList2 = new ArrayList();
    arrayList2.add(v1);
    arrayList2.add(v2);
    arrayList2.add(v3);
    this.dgI = (TextView)this.dgm.findViewById(2131298359);
    bn bn = new bn(this);
    this.dgJ = new g(this, new ArrayList[] { arrayList1, arrayList2 }, bn);
    this.dgm.setOnClickListener(new bo(this));
    e(v1);
  }
  
  protected void AB() {
    setContentViewSetCustomTitle(2131427986);
    if (!getResources().getBoolean(2131034140))
      findViewById(2131298456).setVisibility(8); 
    this.dfS = findViewById(2131297048);
    this.bWY = (ListView)findViewById(2131296481);
    this.dfU = LayoutInflater.from(this).inflate(2131428163, null);
    Time time = new Time();
    time.setToNow();
    this.bqM = time.year;
    this.dfV = AI();
    if (this.dfV != null) {
      if (this.dfV instanceof i)
        AD(); 
      if (this.dfV instanceof j)
        AC(); 
    } 
  }
  
  protected void AC() {
    ViewGroup viewGroup = getTitleRightCustomize();
    View.inflate(this, 2131427997, viewGroup);
    this.dgh = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
    this.dgl = this.dgh.findViewById(2131298484);
    this.dgi = this.dgl.findViewById(2131298489);
    this.dgj = this.dgh.findViewById(2131298490);
    this.dgl.setOnClickListener(new bq(this));
  }
  
  protected void AD() {
    this.bvO = new bb(this);
    ViewGroup viewGroup = getTitleRightCustomize();
    View.inflate(this, 2131427981, viewGroup);
    this.bzp = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
    this.bzp.setOnClickListener(new bs(this));
  }
  
  protected void AG() {}
  
  @NonNull
  protected abstract u AI();
  
  protected abstract void AJ();
  
  protected String Td() {
    ArrayList arrayList = Te();
    return ((i)this.dfV).a(arrayList, this.bqs[0], this.bqs[1], this.bKe, this.cPh, this.dgH, aor(), aos());
  }
  
  protected ArrayList<HashMap<String, String>> Te() {
    if (!this.dfV.ano())
      return i.b((i)n.b(this.bWY)); 
    n.println("导出数据时，由于当前数据没有显示完整，或者字段不全，重新查询了数据");
    return this.dfV.anr();
  }
  
  protected void X(HashMap<String, String> paramHashMap) {}
  
  public void a(aa paramaa) {
    this.dgv = paramaa;
    if (this.dgv.isShow) {
      a(this.dgv.dcn, this.dgv.dco, this.dgv.dcp, this.dgv.dcq);
      this.bqD.setSelected(false);
      this.bqF.setSelected(false);
    } 
  }
  
  protected void a(u paramu) {}
  
  protected void a(boolean paramBoolean, ArrayList<HashMap<String, String>> paramArrayList, int paramInt) {}
  
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
        textView1.setOnClickListener(new g(this, paramArrayOfInt[i], arrayOfView));
        if (paramArrayOfInt[i] == paramInt)
          textView = textView1; 
      } 
    } 
    if (textView != null)
      performClick(textView); 
  }
  
  protected void aaQ() {
    this.dfS.setVisibility(0);
    i.a((i)n.b(this.bWY));
    aoj();
  }
  
  protected void aab() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield dgk : Z
    //   7: aload_0
    //   8: invokestatic bo : (Landroid/content/Context;)Lcom/laiqian/print/usage/receipt/model/a;
    //   11: astore #5
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_0
    //   16: invokevirtual anN : ()Lcom/laiqian/print/model/PrintContent$a;
    //   19: astore #4
    //   21: aload #4
    //   23: astore_3
    //   24: goto -> 34
    //   27: astore #4
    //   29: aload #4
    //   31: invokestatic e : (Ljava/lang/Throwable;)V
    //   34: aload_3
    //   35: ifnonnull -> 72
    //   38: aload_0
    //   39: getfield dfV : Lcom/laiqian/report/models/u;
    //   42: ifnonnull -> 59
    //   45: aload_0
    //   46: getfield handler : Landroid/os/Handler;
    //   49: sipush #981
    //   52: invokevirtual sendEmptyMessage : (I)Z
    //   55: pop
    //   56: goto -> 69
    //   59: aload_0
    //   60: getfield handler : Landroid/os/Handler;
    //   63: bipush #98
    //   65: invokevirtual sendEmptyMessage : (I)Z
    //   68: pop
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload #5
    //   74: invokevirtual aiL : ()Lcom/laiqian/print/usage/receipt/model/ReceiptPrintSettings;
    //   77: invokevirtual air : ()I
    //   80: istore_2
    //   81: iconst_0
    //   82: istore_1
    //   83: iload_1
    //   84: iload_2
    //   85: if_icmpge -> 103
    //   88: aload_3
    //   89: ldc_w '\\n'
    //   92: invokevirtual ln : (Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   95: pop
    //   96: iload_1
    //   97: iconst_1
    //   98: iadd
    //   99: istore_1
    //   100: goto -> 83
    //   103: aload_3
    //   104: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   107: astore_3
    //   108: aload_0
    //   109: getfield dgk : Z
    //   112: ifne -> 128
    //   115: aload_0
    //   116: getfield handler : Landroid/os/Handler;
    //   119: bipush #97
    //   121: invokevirtual sendEmptyMessage : (I)Z
    //   124: pop
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: aload #5
    //   130: invokevirtual getPrinters : ()Ljava/util/List;
    //   133: astore #6
    //   135: new com/laiqian/report/ui/ReportRoot$e
    //   138: dup
    //   139: aload_0
    //   140: aload #6
    //   142: invokeinterface size : ()I
    //   147: invokespecial <init> : (Lcom/laiqian/report/ui/ReportRoot;I)V
    //   150: astore #4
    //   152: getstatic com/laiqian/print/model/g.cGS : Lcom/laiqian/print/model/g;
    //   155: astore #5
    //   157: aload #6
    //   159: invokeinterface iterator : ()Ljava/util/Iterator;
    //   164: astore #6
    //   166: aload #6
    //   168: invokeinterface hasNext : ()Z
    //   173: ifeq -> 219
    //   176: aload #6
    //   178: invokeinterface next : ()Ljava/lang/Object;
    //   183: checkcast com/laiqian/print/model/s
    //   186: astore #7
    //   188: getstatic com/laiqian/print/model/g.cGS : Lcom/laiqian/print/model/g;
    //   191: aload #7
    //   193: invokevirtual f : (Lcom/laiqian/print/model/s;)Lcom/laiqian/print/model/q;
    //   196: aload_3
    //   197: invokevirtual a : (Lcom/laiqian/print/model/PrintContent;)Lcom/laiqian/print/model/e;
    //   200: astore #7
    //   202: aload #7
    //   204: aload #4
    //   206: invokevirtual a : (Lcom/laiqian/print/model/e$a;)V
    //   209: aload #5
    //   211: aload #7
    //   213: invokevirtual print : (Lcom/laiqian/print/model/e;)V
    //   216: goto -> 166
    //   219: aload_0
    //   220: monitorexit
    //   221: return
    //   222: astore_3
    //   223: aload_0
    //   224: monitorexit
    //   225: aload_3
    //   226: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	222	finally
    //   15	21	27	java/lang/Exception
    //   15	21	222	finally
    //   29	34	222	finally
    //   38	56	222	finally
    //   59	69	222	finally
    //   72	81	222	finally
    //   88	96	222	finally
    //   103	125	222	finally
    //   128	166	222	finally
    //   166	216	222	finally }
  
  protected boolean anD() { return false; }
  
  protected void anM() {}
  
  protected PrintContent.a anN() {
    ArrayList arrayList = aok();
    return ((j)this.dfV).a(this.bqs[0], this.bqs[1], arrayList);
  }
  
  protected ViewGroup aof() { return (ViewGroup)findViewById(2131298739); }
  
  protected void aog() { (new d(this, false)).start(); }
  
  protected void aoh() { gF(false); }
  
  protected void aoi() {
    if (this.dgh != null)
      this.dgh.setVisibility(0); 
    if (this.bzp != null)
      this.bzp.setVisibility(0); 
  }
  
  protected void aoj() {
    if (this.dgh != null)
      this.dgh.setVisibility(8); 
    if (this.bzp != null)
      this.bzp.setVisibility(8); 
  }
  
  protected ArrayList<HashMap<String, String>> aok() {
    if (!this.dfV.ano())
      return i.b((i)n.b(this.bWY)); 
    n.println("打印数据时，由于当前数据没有显示完整，或者字段不全，重新查询了数据");
    return this.dfV.anq();
  }
  
  protected void aol() {
    if (this.bvM == null) {
      this.bvM = new ArrayList();
      HashMap hashMap = new HashMap();
      hashMap.put("name", getString(2131627875));
      hashMap.put("state", null);
      hashMap.put("address", null);
      this.bvM.add(hashMap);
      hashMap = new HashMap();
      hashMap.put("name", getString(2131627874));
      hashMap.put("state", null);
      hashMap.put("address", "mail");
      this.bvM.add(hashMap);
    } 
    Qs();
    if (this.bvS == null) {
      this.bvT = new p(this, this.bvM, 2131427854, new String[] { "name", "state" }, new int[] { 2131299035, 2131299034 });
      this.bvS = new m(this, false);
      this.bvS.a(this.bvT);
      this.bvS.getListView().setOnItemClickListener(new bt(this));
      this.bvS.setTitle(2131627873);
      DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
      this.bvS.setWidth(displayMetrics.widthPixels / 4);
    } 
    this.bvT.notifyDataSetChanged();
    this.bvS.show();
  }
  
  protected int aom() { return this.ddh; }
  
  public e aon() { return this.dgu; }
  
  public aa aoo() { return this.dgv; }
  
  public void aop() { this.cPh = new long[0]; }
  
  protected void aoq() {
    int i;
    cj cj = new cj(this);
    Boolean[] arrayOfBoolean = cj.yO();
    cj.close();
    View view = this.dgC;
    if (arrayOfBoolean[0].booleanValue()) {
      i = 0;
    } else {
      i = 8;
    } 
    view.setVisibility(i);
    TextView textView = this.dgA;
    if (arrayOfBoolean[0].booleanValue()) {
      i = getResources().getColor(2131099862);
    } else {
      i = getResources().getColor(2131099858);
    } 
    textView.setTextColor(i);
    this.dgK.setClickable(arrayOfBoolean[0].booleanValue());
  }
  
  protected String aor() { return (this.bKe > 0L) ? this.dgA.getText().toString() : ""; }
  
  protected String aos() { return (this.cPh != null && this.cPh.length > 0) ? this.dgB.getText().toString() : ""; }
  
  protected void b(int paramInt, List<u> paramList) {
    View view = findViewById(2131298925);
    TextView textView = (TextView)findViewById(2131298318);
    if (paramInt == 0 && !paramList.isEmpty()) {
      long l;
      u u1;
      view.setVisibility(0);
      this.dgz = new g(this, paramList, new as(this, textView));
      view.setOnClickListener(new at(this));
      if (this.dgE != null && paramList.contains(this.dgE)) {
        paramInt = 1;
      } else {
        paramInt = 0;
      } 
      if (paramInt != 0) {
        u1 = this.dgE;
      } else {
        u1 = (u)u1.get(0);
      } 
      a(u1, textView);
      g g1 = this.dgz;
      if (!TextUtils.isEmpty(this.orderTypeID)) {
        l = Integer.valueOf(this.orderTypeID).intValue();
      } else {
        l = 0L;
      } 
      g1.dn(l);
      return;
    } 
    view.setVisibility(8);
  }
  
  public void b(e parame) {
    if (this.dgv.dcr) {
      a(parame, true);
      return;
    } 
    a(parame);
  }
  
  protected void b(boolean paramBoolean, ArrayList<HashMap<String, String>> paramArrayList, int paramInt) {
    if (this.dfX != 0) {
      if (this.dfX != paramInt)
        return; 
      this.dfX = 0;
      if (paramBoolean) {
        if (paramArrayList.isEmpty())
          return; 
        (new bf(this)).start();
      } 
      return;
    } 
  }
  
  protected void b(double[] paramArrayOfDouble) {}
  
  protected void cU(View paramView) { paramView.findViewById(2131297351).setVisibility(8); }
  
  protected void di(long paramLong) {
    if (this.dgy == null) {
      n.println("设置交班的员工时，选择员工的选择框没有赋值");
      return;
    } 
    ap ap = null;
    byte b1 = 0;
    while (true) {
      ap ap1 = (ap)this.dgy.kT(b1);
      if (ap1 != null)
        if (ap1.AR() == paramLong) {
          ap = ap1;
        } else {
          b1++;
          continue;
        }  
      if (ap == null) {
        n.println("设置交班的员工时，出现未知错误");
        return;
      } 
      a(ap);
      aoq();
      return;
    } 
  }
  
  protected void f(Message paramMessage) {}
  
  public void finish() {
    aoe();
    super.finish();
    this.dfT = null;
    this.dfY = null;
  }
  
  protected void gE(boolean paramBoolean) {
    if (paramBoolean) {
      if (!isHasProgressBar())
        this.bWY.addFooterView(this.dfU); 
    } else if (isHasProgressBar()) {
      if (!(this.bWY.getAdapter() instanceof android.widget.HeaderViewListAdapter))
        this.bWY.setAdapter(this.bWY.getAdapter()); 
      this.bWY.removeFooterView(this.dfU);
    } 
    gF(paramBoolean);
  }
  
  protected void gF(boolean paramBoolean) {
    if (paramBoolean) {
      this.bWY.setOnScrollListener(this.dgr);
      return;
    } 
    this.bWY.setOnScrollListener(null);
  }
  
  protected void gG(boolean paramBoolean) {
    byte b1;
    View view = findViewById(2131298990);
    if (paramBoolean) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    view.setVisibility(b1);
  }
  
  public void gJ(boolean paramBoolean) { this.dgv.dcr = paramBoolean; }
  
  protected boolean isHasProgressBar() { return (this.bWY.getFooterViewsCount() > 0); }
  
  protected void jS(int paramInt) {
    View view = findViewById(2131297894);
    if (paramInt == 0) {
      view.setVisibility(0);
      ((RadioGroup)view.findViewById(2131298735)).setOnCheckedChangeListener(new ba(this));
    } 
  }
  
  protected void jT(int paramInt) {
    View view = findViewById(2131298925);
    TextView textView = (TextView)findViewById(2131298318);
    if (paramInt == 0) {
      view.setVisibility(0);
      textView.setText(2131628072);
      return;
    } 
    view.setVisibility(8);
  }
  
  protected void jU(int paramInt) {
    View view = findViewById(2131297900);
    if (paramInt == 0) {
      view.setVisibility(0);
      ((RadioGroup)view.findViewById(2131298736)).setOnCheckedChangeListener(new bb(this));
    } 
  }
  
  protected void jV(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 2:
        ((RadioButton)findViewById(2131296780)).setChecked(true);
        return;
      case 1:
        ((RadioButton)findViewById(2131296779)).setChecked(true);
        return;
      case 0:
        break;
    } 
    ((RadioButton)findViewById(2131296778)).setChecked(true);
  }
  
  protected void jW(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 2:
        ((RadioButton)findViewById(2131296698)).setChecked(true);
        return;
      case 1:
        ((RadioButton)findViewById(2131296699)).setChecked(true);
        return;
      case 0:
        break;
    } 
    ((RadioButton)findViewById(2131296697)).setChecked(true);
  }
  
  protected void jY(@FilterOtherCode int paramInt) {
    boolean bool;
    boolean bool2;
    boolean bool1;
    if ((paramInt & true) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if ((paramInt & 0x2) > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if ((paramInt & 0x4) > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    View view = findViewById(2131297043);
    this.dgC = view.findViewById(2131296773);
    if (paramInt == 0) {
      view.setVisibility(8);
      return;
    } 
    this.dgC.setOnClickListener(new bc(this));
    l(view, bool);
    view = view.findViewById(2131298332);
    if (!bool1 && !bool2) {
      view.setVisibility(8);
      return;
    } 
    this.dgK = view.findViewById(2131298931);
    if (bool1) {
      this.dgA = (TextView)this.dgK.findViewById(2131299930);
      bg bg = new bg(this);
      ArrayList arrayList = bg.er(true);
      bg.close();
      this.dgy = new g(this, arrayList, new bd(this));
      this.dgK.setOnClickListener(new be(this));
      a((ap)arrayList.get(0));
    } else {
      this.dgK.setVisibility(8);
    } 
    view = view.findViewById(2131298929);
    if (bool2) {
      this.dgB = (TextView)view.findViewById(2131298499);
      view.setOnClickListener(new bg(this, this, com.laiqian.product.ProductList.class, 'ϩ'));
      a(null, null);
      return;
    } 
    view.setVisibility(8);
  }
  
  protected void n(@FilterDatePosition int paramInt, boolean paramBoolean) {
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.dfV.B(Time.class));
    stringBuilder.append(" %H:%M");
    this.Ze = stringBuilder.toString();
    aj = findViewById(2131296833);
    this.bqD = aj.findViewById(2131296832);
    this.bqE = (TextView)this.bqD.findViewById(2131296831);
    ArrayList arrayList = aj.findViewById(2131299236);
    this.bqv = (TextView)arrayList.findViewById(2131299235);
    arrayList.setOnClickListener(new f(this, this.bqv));
    View view = aj.findViewById(2131299231);
    this.bqw = (TextView)view.findViewById(2131299230);
    view.setOnClickListener(new f(this, this.bqw));
    int k = 1;
    this.bqu = new View[] { arrayList, view };
    this.bqF = aj.findViewById(2131296841);
    new ArrayList();
    if (paramBoolean) {
      StringBuilder stringBuilder;
      aj aj;
      this.bqx = new View[] { this.bqD, this.bqF, arrayList, view };
      aj = new aj(this);
      arrayList = aj.hR(this.Ze);
      aj.close();
      this.dgs = new g(this, arrayList, new aw(this));
      this.bqF.setOnClickListener(new ax(this));
    } else {
      this.bqF.setVisibility(8);
      this.bqx = new View[] { this.bqD, arrayList, view };
      this.bqD.setBackgroundResource(2131231602);
      aj.findViewById(2131296834).setVisibility(8);
    } 
    null = jX(paramInt);
    arrayList = null.bjv;
    int i = null.dgR;
    this.dgt = new g(this, arrayList, new ay(this));
    this.bqD.setOnClickListener(new az(this));
    if (i < this.bqH.length) {
      paramInt = k;
    } else {
      paramInt = 0;
    } 
    if (paramInt == 0)
      i = 0; 
    e e1 = (e)this.dgt.kT(i);
    if (e1 != null) {
      this.dgt.dn(i);
      a(e1);
    } 
    if (paramInt == 0) {
      e1 = (e)this.dgs.kT(0);
      if (e1 == null) {
        n.o("交班时间选择框的选项错误");
        return;
      } 
      a(e1, false);
      this.dgs.dn(e1.AR());
    } 
  }
  
  public void nx(String paramString) { this.bci = paramString; }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
      return; 
    switch (paramInt1) {
      default:
        return;
      case 1002:
        AJ();
        return;
      case 1001:
        break;
    } 
    a(paramIntent.getLongArrayExtra("IDs"), paramIntent.getStringArrayExtra("names"));
    AJ();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    AB();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.dfV != null) {
      this.dfV.close();
      this.dfV = null;
    } 
  }
  
  protected void onStart() {
    super.onStart();
    if (getLaiqianPreferenceManager().atC()) {
      n.println("这里，只有更新了数据的时候才会进来");
      getLaiqianPreferenceManager().ht(false);
      AJ();
    } 
  }
  
  public void setOrderTypeID(String paramString) {
    this.orderTypeID = paramString;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("transactonReport.orderTypeID is:");
    stringBuilder.append(this.orderTypeID);
    d.b(stringBuilder.toString(), new Object[0]);
  }
  
  private static @interface FilterDatePosition {}
  
  private static @interface FilterOtherCode {}
  
  protected class a {
    private TextView dgQ;
    
    private View view;
    
    public a(ReportRoot this$0, @StringRes int param1Int, View.OnClickListener param1OnClickListener) { this(this$0, param1Int, param1OnClickListener, false, true); }
    
    public a(ReportRoot this$0, @StringRes int param1Int, View.OnClickListener param1OnClickListener, boolean param1Boolean1, boolean param1Boolean2) {
      ViewGroup viewGroup = (ViewGroup)this$0.findViewById(2131296820);
      viewGroup.setVisibility(0);
      View.inflate(this$0, 2131427983, viewGroup);
      this.view = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
      this.view.setEnabled(param1Boolean2);
      ((TextView)this.view.findViewById(2131296821)).setText(param1Int);
      this.dgQ = (TextView)this.view.findViewById(2131296823);
      if (param1Boolean1)
        this.view.findViewById(2131296822).setVisibility(8); 
      this.view.setOnClickListener(param1OnClickListener);
    }
    
    public TextView aov() { return this.dgQ; }
  }
  
  public class b {
    public ArrayList<e> bjv;
    
    public int dgR;
    
    public b(ReportRoot this$0) {}
  }
  
  private class c extends Thread {
    private String bvY;
    
    private c(ReportRoot this$0, String param1String) { this.bvY = param1String; }
    
    public void run() {
      super.run();
      ReportRoot.b(this.dgN, this.bvY);
    }
  }
  
  protected class d extends Thread {
    private int arg2;
    
    private boolean dgS;
    
    public d(ReportRoot this$0, boolean param1Boolean) { this.dgS = param1Boolean; }
    
    public d aow() {
      ReportRoot.a(this.dgN, (int)(Math.random() * 10000.0D) + 1);
      this.arg2 = ReportRoot.a(this.dgN);
      return this;
    }
    
    public void run() {
      super.run();
      this.dgN.dfT = getName();
      ReportRoot.a(this.dgN, this.dgS, getName(), this.arg2);
    }
  }
  
  private class e implements e.a {
    int dgT;
    
    int dgU;
    
    public e(ReportRoot this$0, int param1Int) { this.dgT = param1Int; }
    
    public void a(e param1e, int param1Int) {
      if (param1e.agu()) {
        this.dgU++;
        if (this.dgU >= this.dgT)
          this.dgN.handler.sendEmptyMessage(99); 
      } 
    }
  }
  
  class f implements View.OnClickListener {
    private TextView bqZ;
    
    public f(ReportRoot this$0, TextView param1TextView) { this.bqZ = param1TextView; }
    
    public void onClick(View param1View) {
      if (ReportRoot.l(this.dgN) == null) {
        ReportRoot.a(this.dgN, new a(this.dgN, this.dgN.Ze));
        ReportRoot.l(this.dgN).a(new bx(this));
      } 
      ReportRoot.l(this.dgN).g(this.bqZ);
    }
  }
  
  class g implements View.OnClickListener {
    private int dds;
    
    private View[] ddt;
    
    public g(ReportRoot this$0, int param1Int, View[] param1ArrayOfView) {
      this.dds = param1Int;
      this.ddt = param1ArrayOfView;
    }
    
    public void onClick(View param1View) {
      ReportRoot.b(this.dgN, this.dds);
      if (this.dgN.anD())
        return; 
      for (byte b = 0; b < this.ddt.length; b++) {
        boolean bool;
        View view = this.ddt[b];
        if (this.ddt[b] == param1View) {
          bool = true;
        } else {
          bool = false;
        } 
        view.setSelected(bool);
      } 
      this.dgN.anM();
    }
  }
  
  private class h implements g.b {
    CharSequence cZi;
    
    Runnable dgW;
    
    int id;
    
    @Nullable
    String value;
    
    private h(ReportRoot this$0, int param1Int, CharSequence param1CharSequence, @Nullable String param1String, Runnable param1Runnable) {
      this.id = param1Int;
      this.cZi = param1CharSequence;
      this.value = param1String;
      this.dgW = param1Runnable;
    }
    
    public long AR() { return this.id; }
    
    public CharSequence AS() { return this.cZi; }
    
    public CharSequence AT() { return this.cZi; }
  }
  
  protected abstract class i extends BaseAdapter {
    private ArrayList<HashMap<String, String>> bjv;
    
    private String[] dgX;
    
    private int[] dgY;
    
    View.OnClickListener dgZ = new by(this);
    
    private int resource;
    
    protected i(ReportRoot this$0, ArrayList<HashMap<String, String>> param1ArrayList, int param1Int, String[] param1ArrayOfString, int[] param1ArrayOfInt) {
      this.bjv = param1ArrayList;
      this.resource = param1Int;
      this.dgX = param1ArrayOfString;
      this.dgY = param1ArrayOfInt;
    }
    
    private ArrayList<HashMap<String, String>> aA(ArrayList<HashMap<String, String>> param1ArrayList) {
      this.bjv.addAll(param1ArrayList);
      notifyDataSetChanged();
      return this.bjv;
    }
    
    private void aaQ() {
      this.bjv.clear();
      notifyDataSetChanged();
    }
    
    private void az(ArrayList<HashMap<String, String>> param1ArrayList) {
      this.bjv = param1ArrayList;
      notifyDataSetChanged();
      this.dgN.bWY.setSelection(0);
    }
    
    private ArrayList<HashMap<String, String>> zJ() { return this.bjv; }
    
    protected boolean AK() { return false; }
    
    public void a(a param1a, View param1View, HashMap<String, String> param1HashMap, int param1Int) {}
    
    public abstract a bJ(View param1View);
    
    public HashMap<String, String> gN(int param1Int) { return (HashMap)this.bjv.get(param1Int); }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a2;
      a a1;
      HashMap hashMap = (HashMap)this.bjv.get(param1Int);
      boolean bool = false;
      if (param1View == null) {
        a2 = LayoutInflater.from(this.dgN).inflate(this.resource, null);
        if (AK())
          a2.setOnClickListener(this.dgZ); 
        a a = bJ(a2);
        a1 = a;
        if (a == null)
          a1 = new a(this); 
        if (this.dgX != null) {
          TextView[] arrayOfTextView = new TextView[this.dgX.length];
          byte b;
          for (b = 0; b < arrayOfTextView.length; b++)
            arrayOfTextView[b] = (TextView)a2.findViewById(this.dgY[b]); 
          a1.dhb = arrayOfTextView;
        } 
        a2.setTag(a1);
      } else {
        a a = (a)a1.getTag();
        a2 = a1;
        a1 = a;
      } 
      if (AK())
        a1.dhc = hashMap; 
      if (this.dgX != null) {
        TextView[] arrayOfTextView = a1.dhb;
        byte b;
        for (b = bool; b < arrayOfTextView.length; b++) {
          if (arrayOfTextView[b] != null)
            arrayOfTextView[b].setText((CharSequence)hashMap.get(this.dgX[b])); 
        } 
      } 
      a(a1, a2, hashMap, param1Int);
      return a2;
    }
    
    protected void i(HashMap<String, String> param1HashMap) {}
    
    public class a {
      TextView[] dhb;
      
      HashMap<String, String> dhc;
      
      public a(ReportRoot.i this$0) {}
    }
  }
  
  public class a {
    TextView[] dhb;
    
    HashMap<String, String> dhc;
    
    public a(ReportRoot this$0) {}
  }
  
  protected class j {
    private ViewGroup dhd;
    
    private View view;
    
    public j(ReportRoot this$0, @StringRes int param1Int, @StringRes int... param1VarArgs) {
      this.view = View.inflate(this$0, 2131428008, null);
      this.dhd = (ViewGroup)this.view.findViewById(2131299276);
      this.dhd.removeAllViews();
      jZ(param1Int);
      if (param1VarArgs != null && param1VarArgs.length > 0) {
        int i = param1VarArgs.length;
        for (param1Int = 0; param1Int < i; param1Int++)
          jZ(param1VarArgs[param1Int]); 
      } 
    }
    
    private void jZ(@StringRes int param1Int) {
      View.inflate(this.dgN, 2131428009, this.dhd);
      View view1 = this.dhd.getChildAt(this.dhd.getChildCount() - 1);
      ((TextView)view1.findViewById(2131297452)).setText(param1Int);
      view1.setTag((TextView)view1.findViewById(2131299967));
    }
    
    public View getView() { return this.view; }
    
    public void p(@ColorRes int... param1VarArgs) {
      if (param1VarArgs != null) {
        if (param1VarArgs.length == 0)
          return; 
        for (byte b = 0; b < param1VarArgs.length; b++) {
          View view1 = this.dhd.getChildAt(b);
          int i = param1VarArgs[b];
          if (view1 != null && i != 0)
            ((TextView)view1.getTag()).setTextColor(this.dgN.getResources().getColor(i)); 
        } 
        return;
      } 
    }
    
    public void y(String... param1VarArgs) {
      if (param1VarArgs == null || param1VarArgs.length == 0) {
        this.view.setVisibility(8);
        return;
      } 
      View view1 = this.view;
      byte b = 0;
      view1.setVisibility(0);
      while (b < param1VarArgs.length) {
        view1 = this.dhd.getChildAt(b);
        if (view1 != null)
          ((TextView)view1.getTag()).setText(param1VarArgs[b]); 
        b++;
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ReportRoot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */