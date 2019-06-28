package com.laiqian.member.f;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import com.laiqian.entity.au;
import com.laiqian.entity.v;
import com.laiqian.models.be;
import com.laiqian.models.f;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import com.orhanobut.logger.d;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class a {
  private f accountTableModel;
  
  private boolean byA;
  
  private boolean byB;
  
  public b bys;
  
  public String byt = "";
  
  public String byu = "";
  
  public String byv = "";
  
  private String[] byw;
  
  private b byx;
  
  private a byy;
  
  private boolean byz;
  
  View.OnClickListener clickOtherPayTypeItem = new d(this);
  
  View.OnClickListener clickPayTypeItem = new c(this);
  
  private Context mContext;
  
  private ViewGroup otherPayViewGroup;
  
  private PopupWindow otherPayWindow;
  
  private ArrayList<b> payTypeItemViewList;
  
  private ArrayList<v> payTypeOther;
  
  public a(Context paramContext, boolean paramBoolean, a parama) {
    this.mContext = paramContext;
    this.byy = parama;
    this.byB = paramBoolean;
    int i = RootApplication.getLaiqianPreferenceManager().QV();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 1 && RootApplication.getLaiqianPreferenceManager().avs() == 1) {
      if (RootApplication.getLaiqianPreferenceManager().avp() == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      this.byA = paramBoolean;
      paramBoolean = bool1;
      if (RootApplication.getLaiqianPreferenceManager().avo() == 1)
        paramBoolean = true; 
      this.byz = paramBoolean;
    } else {
      if (RootApplication.getLaiqianPreferenceManager().FD() != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      this.byA = paramBoolean;
      paramBoolean = bool2;
      if (RootApplication.getLaiqianPreferenceManager().FC() != null)
        paramBoolean = true; 
      this.byz = paramBoolean;
    } 
    try {
      this.accountTableModel = new f(this.mContext);
    } catch (Exception paramContext) {
      a.e(paramContext);
    } 
    this.payTypeOther = new ArrayList();
  }
  
  private void QQ() {
    this.byt = "";
    this.byu = "";
    this.byv = "";
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt, boolean paramBoolean) {
    byte b1;
    for (b1 = 0; b1 < paramViewGroup.getChildCount(); b1++) {
      View view = paramViewGroup.getChildAt(b1);
      if (b1 == 0 || paramInt == 0) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        if (b1 == 0)
          marginLayoutParams.leftMargin = 0; 
        if (paramInt == 0)
          marginLayoutParams.topMargin = 0; 
      } 
      b b2 = new b(this, view, (TextView)view.findViewById(R.id.icon), (TextView)view.findViewById(R.id.name));
      if (paramBoolean && RootApplication.getLaiqianPreferenceManager().QV() == 1 && RootApplication.getLaiqianPreferenceManager().avs() == 1 && (b1 == 0 || b1 == 3 || b1 == 4)) {
        view.setVisibility(8);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MULTIPLE_SHOP HEAD_QUARTERS_PAY_MODE View.GONE i=");
        stringBuilder.append(b1);
        d.b(stringBuilder.toString(), new Object[0]);
      } 
      this.payTypeItemViewList.add(b2);
    } 
  }
  
  private boolean ft(int paramInt) { return (paramInt == 10013); }
  
  private void fu(int paramInt) {
    Iterator iterator = this.payTypeItemViewList.iterator();
    while (iterator.hasNext())
      b.a((b)iterator.next(), paramInt); 
  }
  
  private void fv(int paramInt) { fu(paramInt); }
  
  private long getAliPay(long paramLong) { return (paramLong == 2L && a.AZ().Bo() == 2) ? -1L : a.AZ().Bo(); }
  
  private long getWechat(long paramLong) { return (paramLong == 7L && a.AZ().Bq() == 7) ? -1L : a.AZ().Bq(); }
  
  private void resetFirstPayTypeItem(long paramLong) {
    int i = this.bys.aTv;
    byte b2 = 0;
    byte b1 = 0;
    if (i == 10007) {
      long l = paramLong;
      if (paramLong < 0L) {
        paramLong = getAliPay(this.bys.aTe);
        l = paramLong;
        if (paramLong < 0L)
          return; 
      } 
      b b4 = this.bys;
      if (l == 1L) {
        b3 = 1;
      } else {
        b3 = 0;
      } 
      b4.bpq = b3;
      b4 = this.bys;
      byte b3 = b1;
      if (l == 0L)
        b3 = 1; 
      b4.bpr = b3;
      this.bys.aTe = l;
      return;
    } 
    if (this.bys.aTv == 10009) {
      long l = paramLong;
      if (paramLong < 0L) {
        paramLong = getWechat(this.bys.aTe);
        l = paramLong;
        if (paramLong < 0L)
          return; 
      } 
      b b4 = this.bys;
      if (l == 5L) {
        b3 = 1;
      } else {
        b3 = 0;
      } 
      b4.bpq = b3;
      b4 = this.bys;
      byte b3 = b2;
      if (l == 8L)
        b3 = 1; 
      b4.bpr = b3;
      this.bys.aTe = l;
    } 
  }
  
  private void selectedOtherPayTypeValue(v paramv) {
    if (this.byx == null) {
      n.println("其他支付的按钮View=null，这里不会进来");
      return;
    } 
    if (paramv.FQ()) {
      QQ();
      this.byv = "10013";
      this.byt = paramv.name;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramv.aSW);
      stringBuilder.append("");
      this.byu = stringBuilder.toString();
      b.a(this.byx, paramv.aTa, paramv.name, paramv.aSW);
    } 
  }
  
  private void selectedOtherPayTypeValueInitial() {
    if (this.byx == null) {
      n.println("没有其他支付");
      return;
    } 
    if (this.payTypeOther.size() == 1) {
      v v = (v)this.payTypeOther.get(0);
      this.byw = new String[2];
      String[] arrayOfString = this.byw;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(v.aSW);
      stringBuilder.append("");
      arrayOfString[0] = stringBuilder.toString();
      this.byw[1] = v.name;
      b.a(this.byx, v.aTa, v.name, v.aSW);
      return;
    } 
    this.byx.a(10013, R.drawable.other_unselected, this.mContext.getString(R.string.pos_main_pay_payment_others), 0L, R.string.pos_main_pay_finish, "");
  }
  
  private void setOtherPayViewGroupChild() {
    this.otherPayViewGroup.removeAllViews();
    int i = this.payTypeOther.size();
    View view = null;
    for (byte b1 = 0; b1 < i; b1++) {
      LinearLayout linearLayout;
      if (b1 % 5 == 0) {
        if (b1) {
          view = new View(this.mContext);
          view.setBackgroundColor(this.mContext.getResources().getColor(R.color.pos_activity_main_split_line));
          this.otherPayViewGroup.addView(view, 1, -1);
        } 
        linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        this.otherPayViewGroup.addView(linearLayout);
      } 
      View view1 = View.inflate(this.mContext, R.layout.pos_activity_settlement_type_other_item, null);
      if (linearLayout == null) {
        n.println("设置其他支付的子项时出错，这里不会进来");
        return;
      } 
      v v = (v)this.payTypeOther.get(b1);
      ((TextView)view1.findViewById(R.id.name)).setText(v.name);
      TextView textView = (TextView)view1.findViewById(R.id.icon);
      if (v.FQ()) {
        textView.setTextColor(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(v.aTa);
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setText(String.valueOf(v.name.charAt(0)));
      } else {
        textView.setBackgroundResource(v.aTb);
      } 
      view1.setTag(v);
      view1.setOnClickListener(this.clickOtherPayTypeItem);
      linearLayout.addView(view1);
    } 
  }
  
  private void showOtherPayWindow(View paramView) {
    Rect rect = new Rect();
    paramView.getGlobalVisibleRect(rect);
    int i = rect.right;
    int j = rect.top;
    this.otherPayWindow.showAtLocation(paramView, 0, i + 5, j - 11);
  }
  
  public void QO() {
    this.otherPayViewGroup = (ViewGroup)View.inflate(this.mContext, R.layout.pos_activity_settlement_type_other, null);
    this.otherPayWindow = new PopupWindow(this.otherPayViewGroup, -2, -2, true);
    this.otherPayWindow.setBackgroundDrawable(new ColorDrawable(false));
    this.otherPayWindow.setAnimationStyle(R.style.PopupAnimation);
    this.otherPayWindow.setOutsideTouchable(true);
  }
  
  public boolean QP() { return (RootApplication.getLaiqianPreferenceManager().QV() == 1 && RootApplication.getLaiqianPreferenceManager().avs() == 1); }
  
  public void a(String paramString1, String paramString2, aq paramaq, boolean paramBoolean1, boolean paramBoolean2) {
    au au = new au(System.currentTimeMillis(), paramString1, paramString2, this.bys.aTv, this.bys.aTe, paramaq.aWy, paramaq.aWA, paramaq.aWB, paramaq.aWz, paramaq.aSW, paramaq.aWn);
    a.aKh().r(new b(this, au, paramString1, paramBoolean1, paramBoolean2));
  }
  
  public void aC(long paramLong) {
    if (paramLong == 2L) {
      this.byu = "370012";
      return;
    } 
    if (paramLong == 1L || paramLong == 0L) {
      this.byu = "370013";
      return;
    } 
    if (paramLong == 7L) {
      this.byu = "370014";
      return;
    } 
  }
  
  public void cu(View paramView) {
    initPayTypeListView(paramView);
    QO();
    dL(this.byB);
  }
  
  public void dL(boolean paramBoolean) { // Byte code:
    //   0: aload_0
    //   1: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   4: iconst_0
    //   5: invokevirtual get : (I)Ljava/lang/Object;
    //   8: checkcast com/laiqian/member/f/a$b
    //   11: getfield aTv : I
    //   14: istore #7
    //   16: aload_0
    //   17: invokevirtual QP : ()Z
    //   20: istore #9
    //   22: invokestatic zR : ()Lcom/laiqian/c/a;
    //   25: invokevirtual At : ()Z
    //   28: istore #10
    //   30: iconst_2
    //   31: istore #8
    //   33: iload #10
    //   35: ifne -> 929
    //   38: iload #9
    //   40: ifeq -> 272
    //   43: aload_0
    //   44: getfield byz : Z
    //   47: ifeq -> 260
    //   50: aload_0
    //   51: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   54: iconst_1
    //   55: invokevirtual get : (I)Ljava/lang/Object;
    //   58: checkcast com/laiqian/member/f/a$b
    //   61: astore #11
    //   63: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   66: invokevirtual Bo : ()I
    //   69: istore_2
    //   70: iload_2
    //   71: istore_3
    //   72: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   75: invokevirtual QV : ()I
    //   78: iconst_1
    //   79: if_icmpne -> 101
    //   82: iload_2
    //   83: istore_3
    //   84: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   87: invokevirtual avs : ()I
    //   90: iconst_1
    //   91: if_icmpne -> 101
    //   94: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   97: invokevirtual avn : ()I
    //   100: istore_3
    //   101: iload_3
    //   102: ifne -> 112
    //   105: getstatic com/laiqian/vip/R$string.pos_main_pay_finish_scan_click : I
    //   108: istore_2
    //   109: goto -> 131
    //   112: iload_3
    //   113: iconst_1
    //   114: if_icmpne -> 124
    //   117: getstatic com/laiqian/vip/R$string.pos_main_pay_finish_scan_click : I
    //   120: istore_2
    //   121: goto -> 109
    //   124: getstatic com/laiqian/vip/R$string.pos_main_pay_finish : I
    //   127: istore_2
    //   128: goto -> 109
    //   131: aload_0
    //   132: getfield mContext : Landroid/content/Context;
    //   135: getstatic com/laiqian/vip/R$string.pos_main_pay_payment_alipay : I
    //   138: invokevirtual getString : (I)Ljava/lang/String;
    //   141: astore #12
    //   143: aload #11
    //   145: sipush #10007
    //   148: getstatic com/laiqian/vip/R$drawable.bg_alipay_image : I
    //   151: aload #12
    //   153: iload_3
    //   154: i2l
    //   155: iload_2
    //   156: aload #12
    //   158: invokevirtual a : (IILjava/lang/String;JILjava/lang/String;)V
    //   161: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   164: invokevirtual Wq : ()Z
    //   167: ifeq -> 200
    //   170: aload_0
    //   171: getfield bys : Lcom/laiqian/member/f/a$b;
    //   174: getfield aTv : I
    //   177: ifne -> 200
    //   180: aload #11
    //   182: getfield view : Landroid/view/View;
    //   185: invokevirtual performClick : ()Z
    //   188: pop
    //   189: aload_0
    //   190: aload #11
    //   192: putfield bys : Lcom/laiqian/member/f/a$b;
    //   195: iconst_0
    //   196: istore_3
    //   197: goto -> 202
    //   200: iconst_1
    //   201: istore_3
    //   202: iload #7
    //   204: istore_2
    //   205: iload #8
    //   207: istore #6
    //   209: iload_3
    //   210: istore #5
    //   212: aload_0
    //   213: getfield bys : Lcom/laiqian/member/f/a$b;
    //   216: ifnull -> 479
    //   219: iload #7
    //   221: istore_2
    //   222: iload #8
    //   224: istore #6
    //   226: iload_3
    //   227: istore #5
    //   229: aload_0
    //   230: getfield bys : Lcom/laiqian/member/f/a$b;
    //   233: getfield aTv : I
    //   236: aload #11
    //   238: getfield aTv : I
    //   241: if_icmpne -> 479
    //   244: aload #11
    //   246: getfield aTv : I
    //   249: istore_2
    //   250: iload #8
    //   252: istore #6
    //   254: iload_3
    //   255: istore #5
    //   257: goto -> 479
    //   260: iconst_1
    //   261: istore #6
    //   263: iconst_1
    //   264: istore #5
    //   266: iload #7
    //   268: istore_2
    //   269: goto -> 479
    //   272: aload_0
    //   273: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   276: iconst_1
    //   277: invokevirtual get : (I)Ljava/lang/Object;
    //   280: checkcast com/laiqian/member/f/a$b
    //   283: astore #11
    //   285: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   288: invokevirtual Bo : ()I
    //   291: istore_2
    //   292: iload_2
    //   293: istore_3
    //   294: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   297: invokevirtual QV : ()I
    //   300: iconst_1
    //   301: if_icmpne -> 323
    //   304: iload_2
    //   305: istore_3
    //   306: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   309: invokevirtual avs : ()I
    //   312: iconst_1
    //   313: if_icmpne -> 323
    //   316: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   319: invokevirtual avn : ()I
    //   322: istore_3
    //   323: iload_3
    //   324: ifne -> 334
    //   327: getstatic com/laiqian/vip/R$string.pos_main_pay_finish_scan_click : I
    //   330: istore_2
    //   331: goto -> 353
    //   334: iload_3
    //   335: iconst_1
    //   336: if_icmpne -> 346
    //   339: getstatic com/laiqian/vip/R$string.pos_main_pay_finish_scan_click : I
    //   342: istore_2
    //   343: goto -> 331
    //   346: getstatic com/laiqian/vip/R$string.pos_main_pay_finish : I
    //   349: istore_2
    //   350: goto -> 331
    //   353: aload_0
    //   354: getfield mContext : Landroid/content/Context;
    //   357: getstatic com/laiqian/vip/R$string.pos_main_pay_payment_alipay : I
    //   360: invokevirtual getString : (I)Ljava/lang/String;
    //   363: astore #12
    //   365: aload #11
    //   367: sipush #10007
    //   370: getstatic com/laiqian/vip/R$drawable.bg_alipay_image : I
    //   373: aload #12
    //   375: iload_3
    //   376: i2l
    //   377: iload_2
    //   378: aload #12
    //   380: invokevirtual a : (IILjava/lang/String;JILjava/lang/String;)V
    //   383: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   386: invokevirtual Wq : ()Z
    //   389: ifeq -> 422
    //   392: aload_0
    //   393: getfield bys : Lcom/laiqian/member/f/a$b;
    //   396: getfield aTv : I
    //   399: ifne -> 422
    //   402: aload #11
    //   404: getfield view : Landroid/view/View;
    //   407: invokevirtual performClick : ()Z
    //   410: pop
    //   411: aload_0
    //   412: aload #11
    //   414: putfield bys : Lcom/laiqian/member/f/a$b;
    //   417: iconst_0
    //   418: istore_3
    //   419: goto -> 424
    //   422: iconst_1
    //   423: istore_3
    //   424: iload #7
    //   426: istore_2
    //   427: iload #8
    //   429: istore #6
    //   431: iload_3
    //   432: istore #5
    //   434: aload_0
    //   435: getfield bys : Lcom/laiqian/member/f/a$b;
    //   438: ifnull -> 479
    //   441: iload #7
    //   443: istore_2
    //   444: iload #8
    //   446: istore #6
    //   448: iload_3
    //   449: istore #5
    //   451: aload_0
    //   452: getfield bys : Lcom/laiqian/member/f/a$b;
    //   455: getfield aTv : I
    //   458: aload #11
    //   460: getfield aTv : I
    //   463: if_icmpne -> 479
    //   466: aload #11
    //   468: getfield aTv : I
    //   471: istore_2
    //   472: iload_3
    //   473: istore #5
    //   475: iload #8
    //   477: istore #6
    //   479: iload #9
    //   481: ifeq -> 713
    //   484: iload_2
    //   485: istore #4
    //   487: iload #6
    //   489: istore_3
    //   490: aload_0
    //   491: getfield byA : Z
    //   494: ifeq -> 1138
    //   497: aload_0
    //   498: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   501: astore #11
    //   503: iload #6
    //   505: iconst_1
    //   506: iadd
    //   507: istore #7
    //   509: aload #11
    //   511: iload #6
    //   513: invokevirtual get : (I)Ljava/lang/Object;
    //   516: checkcast com/laiqian/member/f/a$b
    //   519: astore #11
    //   521: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   524: invokevirtual Bq : ()I
    //   527: istore_3
    //   528: iload_3
    //   529: istore #4
    //   531: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   534: invokevirtual QV : ()I
    //   537: iconst_1
    //   538: if_icmpne -> 562
    //   541: iload_3
    //   542: istore #4
    //   544: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   547: invokevirtual avs : ()I
    //   550: iconst_1
    //   551: if_icmpne -> 562
    //   554: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   557: invokevirtual avq : ()I
    //   560: istore #4
    //   562: iload #4
    //   564: bipush #8
    //   566: if_icmpne -> 576
    //   569: getstatic com/laiqian/vip/R$string.pos_main_pay_finish_scan_click : I
    //   572: istore_3
    //   573: goto -> 596
    //   576: iload #4
    //   578: iconst_5
    //   579: if_icmpne -> 589
    //   582: getstatic com/laiqian/vip/R$string.pos_main_pay_finish_scan_click : I
    //   585: istore_3
    //   586: goto -> 573
    //   589: getstatic com/laiqian/vip/R$string.pos_main_pay_finish : I
    //   592: istore_3
    //   593: goto -> 573
    //   596: aload_0
    //   597: getfield mContext : Landroid/content/Context;
    //   600: getstatic com/laiqian/vip/R$string.pos_pay_WeChat : I
    //   603: invokevirtual getString : (I)Ljava/lang/String;
    //   606: astore #12
    //   608: aload #11
    //   610: sipush #10009
    //   613: getstatic com/laiqian/vip/R$drawable.bg_weixin_image : I
    //   616: aload #12
    //   618: iload #4
    //   620: i2l
    //   621: iload_3
    //   622: aload #12
    //   624: invokevirtual a : (IILjava/lang/String;JILjava/lang/String;)V
    //   627: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   630: invokevirtual Wq : ()Z
    //   633: ifeq -> 666
    //   636: iload #5
    //   638: ifeq -> 666
    //   641: aload_0
    //   642: getfield bys : Lcom/laiqian/member/f/a$b;
    //   645: getfield aTv : I
    //   648: ifne -> 666
    //   651: aload #11
    //   653: getfield view : Landroid/view/View;
    //   656: invokevirtual performClick : ()Z
    //   659: pop
    //   660: aload_0
    //   661: aload #11
    //   663: putfield bys : Lcom/laiqian/member/f/a$b;
    //   666: iload_2
    //   667: istore #4
    //   669: iload #7
    //   671: istore_3
    //   672: aload_0
    //   673: getfield bys : Lcom/laiqian/member/f/a$b;
    //   676: ifnull -> 926
    //   679: iload_2
    //   680: istore #4
    //   682: iload #7
    //   684: istore_3
    //   685: aload_0
    //   686: getfield bys : Lcom/laiqian/member/f/a$b;
    //   689: getfield aTv : I
    //   692: aload #11
    //   694: getfield aTv : I
    //   697: if_icmpne -> 926
    //   700: aload #11
    //   702: getfield aTv : I
    //   705: istore #4
    //   707: iload #7
    //   709: istore_3
    //   710: goto -> 926
    //   713: aload_0
    //   714: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   717: astore #11
    //   719: iload #6
    //   721: iconst_1
    //   722: iadd
    //   723: istore #7
    //   725: aload #11
    //   727: iload #6
    //   729: invokevirtual get : (I)Ljava/lang/Object;
    //   732: checkcast com/laiqian/member/f/a$b
    //   735: astore #11
    //   737: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   740: invokevirtual Bq : ()I
    //   743: istore_3
    //   744: iload_3
    //   745: istore #4
    //   747: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   750: invokevirtual QV : ()I
    //   753: iconst_1
    //   754: if_icmpne -> 778
    //   757: iload_3
    //   758: istore #4
    //   760: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   763: invokevirtual avs : ()I
    //   766: iconst_1
    //   767: if_icmpne -> 778
    //   770: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   773: invokevirtual avq : ()I
    //   776: istore #4
    //   778: iload #4
    //   780: bipush #8
    //   782: if_icmpne -> 792
    //   785: getstatic com/laiqian/vip/R$string.pos_main_pay_finish_scan_click : I
    //   788: istore_3
    //   789: goto -> 812
    //   792: iload #4
    //   794: iconst_5
    //   795: if_icmpne -> 805
    //   798: getstatic com/laiqian/vip/R$string.pos_main_pay_finish_scan_click : I
    //   801: istore_3
    //   802: goto -> 789
    //   805: getstatic com/laiqian/vip/R$string.pos_main_pay_finish : I
    //   808: istore_3
    //   809: goto -> 789
    //   812: aload_0
    //   813: getfield mContext : Landroid/content/Context;
    //   816: getstatic com/laiqian/vip/R$string.pos_pay_WeChat : I
    //   819: invokevirtual getString : (I)Ljava/lang/String;
    //   822: astore #12
    //   824: aload #11
    //   826: sipush #10009
    //   829: getstatic com/laiqian/vip/R$drawable.bg_weixin_image : I
    //   832: aload #12
    //   834: iload #4
    //   836: i2l
    //   837: iload_3
    //   838: aload #12
    //   840: invokevirtual a : (IILjava/lang/String;JILjava/lang/String;)V
    //   843: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   846: invokevirtual Wq : ()Z
    //   849: ifeq -> 882
    //   852: iload #5
    //   854: ifeq -> 882
    //   857: aload_0
    //   858: getfield bys : Lcom/laiqian/member/f/a$b;
    //   861: getfield aTv : I
    //   864: ifne -> 882
    //   867: aload #11
    //   869: getfield view : Landroid/view/View;
    //   872: invokevirtual performClick : ()Z
    //   875: pop
    //   876: aload_0
    //   877: aload #11
    //   879: putfield bys : Lcom/laiqian/member/f/a$b;
    //   882: iload_2
    //   883: istore #4
    //   885: iload #7
    //   887: istore_3
    //   888: aload_0
    //   889: getfield bys : Lcom/laiqian/member/f/a$b;
    //   892: ifnull -> 926
    //   895: iload_2
    //   896: istore #4
    //   898: iload #7
    //   900: istore_3
    //   901: aload_0
    //   902: getfield bys : Lcom/laiqian/member/f/a$b;
    //   905: getfield aTv : I
    //   908: aload #11
    //   910: getfield aTv : I
    //   913: if_icmpne -> 926
    //   916: aload #11
    //   918: getfield aTv : I
    //   921: istore #4
    //   923: iload #7
    //   925: istore_3
    //   926: goto -> 1138
    //   929: aload_0
    //   930: getfield byA : Z
    //   933: ifeq -> 1132
    //   936: aload_0
    //   937: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   940: iconst_1
    //   941: invokevirtual get : (I)Ljava/lang/Object;
    //   944: checkcast com/laiqian/member/f/a$b
    //   947: astore #11
    //   949: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   952: invokevirtual Bq : ()I
    //   955: istore_2
    //   956: iload_2
    //   957: istore_3
    //   958: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   961: invokevirtual QV : ()I
    //   964: iconst_1
    //   965: if_icmpne -> 987
    //   968: iload_2
    //   969: istore_3
    //   970: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   973: invokevirtual avs : ()I
    //   976: iconst_1
    //   977: if_icmpne -> 987
    //   980: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   983: invokevirtual avq : ()I
    //   986: istore_3
    //   987: iload_3
    //   988: bipush #8
    //   990: if_icmpne -> 1000
    //   993: getstatic com/laiqian/vip/R$string.pos_main_pay_finish_scan_click : I
    //   996: istore_2
    //   997: goto -> 1019
    //   1000: iload_3
    //   1001: iconst_5
    //   1002: if_icmpne -> 1012
    //   1005: getstatic com/laiqian/vip/R$string.pos_main_pay_finish_scan_click : I
    //   1008: istore_2
    //   1009: goto -> 997
    //   1012: getstatic com/laiqian/vip/R$string.pos_main_pay_finish : I
    //   1015: istore_2
    //   1016: goto -> 997
    //   1019: aload_0
    //   1020: getfield mContext : Landroid/content/Context;
    //   1023: getstatic com/laiqian/vip/R$string.version_title_comprehensive : I
    //   1026: invokevirtual getString : (I)Ljava/lang/String;
    //   1029: astore #12
    //   1031: aload #11
    //   1033: sipush #10009
    //   1036: getstatic com/laiqian/vip/R$drawable.bg_fubei_image : I
    //   1039: aload #12
    //   1041: iload_3
    //   1042: i2l
    //   1043: iload_2
    //   1044: aload #12
    //   1046: invokevirtual a : (IILjava/lang/String;JILjava/lang/String;)V
    //   1049: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   1052: invokevirtual Wq : ()Z
    //   1055: ifeq -> 1083
    //   1058: aload_0
    //   1059: getfield bys : Lcom/laiqian/member/f/a$b;
    //   1062: getfield aTv : I
    //   1065: ifne -> 1083
    //   1068: aload #11
    //   1070: getfield view : Landroid/view/View;
    //   1073: invokevirtual performClick : ()Z
    //   1076: pop
    //   1077: aload_0
    //   1078: aload #11
    //   1080: putfield bys : Lcom/laiqian/member/f/a$b;
    //   1083: iload #7
    //   1085: istore #4
    //   1087: iload #8
    //   1089: istore_3
    //   1090: aload_0
    //   1091: getfield bys : Lcom/laiqian/member/f/a$b;
    //   1094: ifnull -> 1138
    //   1097: iload #7
    //   1099: istore #4
    //   1101: iload #8
    //   1103: istore_3
    //   1104: aload_0
    //   1105: getfield bys : Lcom/laiqian/member/f/a$b;
    //   1108: getfield aTv : I
    //   1111: aload #11
    //   1113: getfield aTv : I
    //   1116: if_icmpne -> 1138
    //   1119: aload #11
    //   1121: getfield aTv : I
    //   1124: istore #4
    //   1126: iload #8
    //   1128: istore_3
    //   1129: goto -> 1138
    //   1132: iconst_1
    //   1133: istore_3
    //   1134: iload #7
    //   1136: istore #4
    //   1138: aload_0
    //   1139: getfield payTypeOther : Ljava/util/ArrayList;
    //   1142: invokevirtual clear : ()V
    //   1145: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   1148: invokevirtual QV : ()I
    //   1151: iconst_1
    //   1152: if_icmpne -> 1165
    //   1155: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   1158: invokevirtual avs : ()I
    //   1161: iconst_1
    //   1162: if_icmpeq -> 1226
    //   1165: aload_0
    //   1166: getfield payTypeOther : Ljava/util/ArrayList;
    //   1169: aload_0
    //   1170: getfield accountTableModel : Lcom/laiqian/models/f;
    //   1173: iconst_1
    //   1174: iconst_0
    //   1175: invokevirtual o : (ZZ)Ljava/util/ArrayList;
    //   1178: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   1181: pop
    //   1182: aload_0
    //   1183: getfield payTypeOther : Ljava/util/ArrayList;
    //   1186: invokevirtual size : ()I
    //   1189: ifle -> 1226
    //   1192: aload_0
    //   1193: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   1196: astore #11
    //   1198: iload_3
    //   1199: iconst_1
    //   1200: iadd
    //   1201: istore_2
    //   1202: aload_0
    //   1203: aload #11
    //   1205: iload_3
    //   1206: invokevirtual get : (I)Ljava/lang/Object;
    //   1209: checkcast com/laiqian/member/f/a$b
    //   1212: putfield byx : Lcom/laiqian/member/f/a$b;
    //   1215: aload_0
    //   1216: invokespecial selectedOtherPayTypeValueInitial : ()V
    //   1219: aload_0
    //   1220: invokespecial setOtherPayViewGroupChild : ()V
    //   1223: goto -> 1228
    //   1226: iload_3
    //   1227: istore_2
    //   1228: new java/lang/StringBuilder
    //   1231: dup
    //   1232: invokespecial <init> : ()V
    //   1235: astore #11
    //   1237: aload #11
    //   1239: ldc_w 'size='
    //   1242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: pop
    //   1246: aload #11
    //   1248: aload_0
    //   1249: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   1252: invokevirtual size : ()I
    //   1255: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1258: pop
    //   1259: aload #11
    //   1261: ldc_w ' index='
    //   1264: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: pop
    //   1268: aload #11
    //   1270: iload_2
    //   1271: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1274: pop
    //   1275: aload #11
    //   1277: invokevirtual toString : ()Ljava/lang/String;
    //   1280: iconst_0
    //   1281: anewarray java/lang/Object
    //   1284: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   1287: iload_2
    //   1288: iconst_5
    //   1289: if_icmpgt -> 1297
    //   1292: iconst_1
    //   1293: istore_3
    //   1294: goto -> 1299
    //   1297: iconst_0
    //   1298: istore_3
    //   1299: iload_2
    //   1300: istore #5
    //   1302: aload_0
    //   1303: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   1306: invokevirtual size : ()I
    //   1309: istore #6
    //   1311: iconst_4
    //   1312: istore #7
    //   1314: iload #5
    //   1316: iload #6
    //   1318: if_icmpge -> 1487
    //   1321: new java/lang/StringBuilder
    //   1324: dup
    //   1325: invokespecial <init> : ()V
    //   1328: astore #11
    //   1330: aload #11
    //   1332: ldc_w 'is gone='
    //   1335: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: iload_3
    //   1340: ifeq -> 1355
    //   1343: iload #5
    //   1345: iconst_5
    //   1346: if_icmplt -> 1355
    //   1349: iconst_1
    //   1350: istore #9
    //   1352: goto -> 1358
    //   1355: iconst_0
    //   1356: istore #9
    //   1358: aload #11
    //   1360: iload #9
    //   1362: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   1365: pop
    //   1366: aload #11
    //   1368: invokevirtual toString : ()Ljava/lang/String;
    //   1371: iconst_0
    //   1372: anewarray java/lang/Object
    //   1375: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   1378: aload_0
    //   1379: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   1382: iload #5
    //   1384: invokevirtual get : (I)Ljava/lang/Object;
    //   1387: checkcast com/laiqian/member/f/a$b
    //   1390: getfield view : Landroid/view/View;
    //   1393: astore #11
    //   1395: iload #7
    //   1397: istore #6
    //   1399: iload_3
    //   1400: ifeq -> 1417
    //   1403: iload #7
    //   1405: istore #6
    //   1407: iload #5
    //   1409: iconst_5
    //   1410: if_icmplt -> 1417
    //   1413: bipush #8
    //   1415: istore #6
    //   1417: aload #11
    //   1419: iload #6
    //   1421: invokevirtual setVisibility : (I)V
    //   1424: new java/lang/StringBuilder
    //   1427: dup
    //   1428: invokespecial <init> : ()V
    //   1431: astore #11
    //   1433: aload #11
    //   1435: ldc_w 'cur view Visibility='
    //   1438: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: pop
    //   1442: aload #11
    //   1444: aload_0
    //   1445: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   1448: iload #5
    //   1450: invokevirtual get : (I)Ljava/lang/Object;
    //   1453: checkcast com/laiqian/member/f/a$b
    //   1456: getfield view : Landroid/view/View;
    //   1459: invokevirtual getVisibility : ()I
    //   1462: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1465: pop
    //   1466: aload #11
    //   1468: invokevirtual toString : ()Ljava/lang/String;
    //   1471: iconst_0
    //   1472: anewarray java/lang/Object
    //   1475: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   1478: iload #5
    //   1480: iconst_1
    //   1481: iadd
    //   1482: istore #5
    //   1484: goto -> 1302
    //   1487: iload_1
    //   1488: ifeq -> 1659
    //   1491: iconst_0
    //   1492: istore_3
    //   1493: iload_3
    //   1494: iload_2
    //   1495: if_icmpge -> 1659
    //   1498: aload_0
    //   1499: getfield payTypeItemViewList : Ljava/util/ArrayList;
    //   1502: iload_3
    //   1503: invokevirtual get : (I)Ljava/lang/Object;
    //   1506: checkcast com/laiqian/member/f/a$b
    //   1509: getfield view : Landroid/view/View;
    //   1512: astore #11
    //   1514: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   1517: invokevirtual QV : ()I
    //   1520: iconst_1
    //   1521: if_icmpne -> 1652
    //   1524: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   1527: invokevirtual avs : ()I
    //   1530: iconst_1
    //   1531: if_icmpne -> 1652
    //   1534: new java/lang/StringBuilder
    //   1537: dup
    //   1538: invokespecial <init> : ()V
    //   1541: astore #12
    //   1543: aload #12
    //   1545: ldc_w 'MULTIPLE_SHOP HEAD_QUARTERS_PAY_MODE ViewE  cur Visibility='
    //   1548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: pop
    //   1552: aload #12
    //   1554: aload #11
    //   1556: invokevirtual getVisibility : ()I
    //   1559: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1562: pop
    //   1563: aload #12
    //   1565: invokevirtual toString : ()Ljava/lang/String;
    //   1568: iconst_0
    //   1569: anewarray java/lang/Object
    //   1572: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   1575: iload_3
    //   1576: ifne -> 1599
    //   1579: aload #11
    //   1581: bipush #8
    //   1583: invokevirtual setVisibility : (I)V
    //   1586: ldc_w 'MULTIPLE_SHOP HEAD_QUARTERS_PAY_MODE View.GONE i=0'
    //   1589: iconst_0
    //   1590: anewarray java/lang/Object
    //   1593: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   1596: goto -> 1652
    //   1599: iload_3
    //   1600: iconst_3
    //   1601: if_icmpeq -> 1609
    //   1604: iload_3
    //   1605: iconst_4
    //   1606: if_icmpne -> 1652
    //   1609: new java/lang/StringBuilder
    //   1612: dup
    //   1613: invokespecial <init> : ()V
    //   1616: astore #12
    //   1618: aload #12
    //   1620: ldc_w 'MULTIPLE_SHOP HEAD_QUARTERS_PAY_MODE View.INVISIBLE i='
    //   1623: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: pop
    //   1627: aload #12
    //   1629: iload_3
    //   1630: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1633: pop
    //   1634: aload #12
    //   1636: invokevirtual toString : ()Ljava/lang/String;
    //   1639: iconst_0
    //   1640: anewarray java/lang/Object
    //   1643: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   1646: aload #11
    //   1648: iconst_4
    //   1649: invokevirtual setVisibility : (I)V
    //   1652: iload_3
    //   1653: iconst_1
    //   1654: iadd
    //   1655: istore_3
    //   1656: goto -> 1493
    //   1659: ldc_w '这里是结算界面，设置了支付类型View'
    //   1662: invokestatic println : (Ljava/lang/Object;)V
    //   1665: ldc_w '结算界面显示的时候，重新选中了选中项'
    //   1668: invokestatic println : (Ljava/lang/Object;)V
    //   1671: aload_0
    //   1672: iload #4
    //   1674: invokespecial fu : (I)V
    //   1677: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   1680: invokevirtual QV : ()I
    //   1683: iconst_1
    //   1684: if_icmpne -> 1697
    //   1687: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   1690: invokevirtual avs : ()I
    //   1693: iconst_1
    //   1694: if_icmpeq -> 1711
    //   1697: aload_0
    //   1698: sipush #10001
    //   1701: invokespecial fu : (I)V
    //   1704: aload_0
    //   1705: ldc_w '10001'
    //   1708: putfield byv : Ljava/lang/String;
    //   1711: return }
  
  public void initPayTypeListView(View paramView) {
    this.payTypeItemViewList = new ArrayList();
    a((ViewGroup)paramView.findViewById(R.id.pay_type_body1), 0, this.byB);
    b b1 = (b)this.payTypeItemViewList.get(0);
    if (RootApplication.getLaiqianPreferenceManager().avs() != 1) {
      b1.a(10001, R.drawable.bg_cash_image, this.mContext.getString(R.string.pos_main_pay_payment_cash), 0L, R.string.pos_main_pay_finish, null);
      b1.view.performClick();
    } 
    this.bys = b1;
  }
  
  public void resetFirstPayTypeItemView(long paramLong) {
    if (this.bys.aTv == 10007) {
      long l = paramLong;
      if (paramLong < 0L) {
        paramLong = getAliPay(this.bys.aTe);
        l = paramLong;
        if (paramLong < 0L)
          return; 
      } 
      resetFirstPayTypeItem(l);
      return;
    } 
    if (this.bys.aTv == 10009) {
      long l = paramLong;
      if (paramLong < 0L) {
        paramLong = getWechat(this.bys.aTe);
        l = paramLong;
        if (paramLong < 0L)
          return; 
      } 
      resetFirstPayTypeItem(l);
    } 
  }
  
  public static interface a {
    void dJ(boolean param1Boolean);
    
    void fs(int param1Int);
  }
  
  public class b {
    TextView aKu;
    
    int aTc;
    
    public long aTe;
    
    public int aTv;
    
    public boolean bpq;
    
    public boolean bpr;
    
    TextView bpt;
    
    View view;
    
    public b(a this$0, View param1View, TextView param1TextView1, TextView param1TextView2) {
      this.view = param1View;
      this.bpt = param1TextView1;
      this.aKu = param1TextView2;
      this.view.setOnClickListener(this$0.clickPayTypeItem);
    }
    
    private void a(int param1Int, String param1String, long param1Long) {
      this.aTv = 10013;
      this.bpt.setBackgroundResource(R.drawable.pos_oval_white);
      this.bpt.setTextColor(param1Int);
      this.bpt.setText(String.valueOf(param1String.charAt(0)));
      this.aKu.setText(param1String);
      this.aTe = param1Long;
      this.aTc = R.string.pos_main_pay_finish;
      this.view.setTag(this);
      this.view.setVisibility(0);
      this.bpq = false;
      this.bpr = false;
    }
    
    private void fw(int param1Int) {
      if (this.view.getVisibility() == 0) {
        boolean bool;
        if (this.aTv == 10013) {
          bool = a.a(this.byH, param1Int);
        } else if (this.aTv == param1Int) {
          bool = true;
        } else {
          bool = false;
        } 
        setSelected(bool);
      } 
    }
    
    private void setSelected(boolean param1Boolean) {
      if (this.view.getVisibility() == 0) {
        this.view.setSelected(param1Boolean);
        if (param1Boolean) {
          this.byH.bys = this;
          a.a(this.byH).fs(this.aTc);
        } 
      } 
    }
    
    public void a(int param1Int1, int param1Int2, String param1String1, long param1Long, int param1Int3, String param1String2) { // Byte code:
      //   0: aload_0
      //   1: iload_1
      //   2: putfield aTv : I
      //   5: aload_0
      //   6: getfield bpt : Landroid/widget/TextView;
      //   9: iload_2
      //   10: invokevirtual setBackgroundResource : (I)V
      //   13: aload_0
      //   14: getfield bpt : Landroid/widget/TextView;
      //   17: invokevirtual getText : ()Ljava/lang/CharSequence;
      //   20: invokeinterface length : ()I
      //   25: ifle -> 37
      //   28: aload_0
      //   29: getfield bpt : Landroid/widget/TextView;
      //   32: ldc ''
      //   34: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   37: aload_0
      //   38: getfield aKu : Landroid/widget/TextView;
      //   41: aload_3
      //   42: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   45: aload_0
      //   46: lload #4
      //   48: putfield aTe : J
      //   51: aload_0
      //   52: iload #6
      //   54: putfield aTc : I
      //   57: aload_0
      //   58: getfield view : Landroid/view/View;
      //   61: aload_0
      //   62: invokevirtual setTag : (Ljava/lang/Object;)V
      //   65: aload_0
      //   66: getfield view : Landroid/view/View;
      //   69: iconst_0
      //   70: invokevirtual setVisibility : (I)V
      //   73: iconst_1
      //   74: istore #9
      //   76: iload_1
      //   77: sipush #10007
      //   80: if_icmpne -> 90
      //   83: lload #4
      //   85: lconst_1
      //   86: lcmp
      //   87: ifeq -> 106
      //   90: iload_1
      //   91: sipush #10009
      //   94: if_icmpne -> 112
      //   97: lload #4
      //   99: ldc2_w 5
      //   102: lcmp
      //   103: ifne -> 112
      //   106: iconst_1
      //   107: istore #8
      //   109: goto -> 115
      //   112: iconst_0
      //   113: istore #8
      //   115: aload_0
      //   116: iload #8
      //   118: putfield bpq : Z
      //   121: iload_1
      //   122: sipush #10007
      //   125: if_icmpne -> 139
      //   128: iload #9
      //   130: istore #8
      //   132: lload #4
      //   134: lconst_0
      //   135: lcmp
      //   136: ifeq -> 165
      //   139: iload_1
      //   140: sipush #10009
      //   143: if_icmpne -> 162
      //   146: lload #4
      //   148: ldc2_w 8
      //   151: lcmp
      //   152: ifne -> 162
      //   155: iload #9
      //   157: istore #8
      //   159: goto -> 165
      //   162: iconst_0
      //   163: istore #8
      //   165: aload_0
      //   166: iload #8
      //   168: putfield bpr : Z
      //   171: return }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */