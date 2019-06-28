package com.laiqian.product;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.product.models.f;
import com.laiqian.product.models.l;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.g;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.util.ar;
import com.laiqian.util.by;
import com.laiqian.util.m;
import com.laiqian.util.n;
import java.util.ArrayList;

public class bq extends d {
  private View aCT;
  
  private r aCU;
  
  private ArrayList<ProductTypeEntity> bbw;
  
  private String cQp;
  
  private TextView cQq;
  
  private TextView cQr;
  
  private String cQs;
  
  private TextView cQt;
  
  private a cQu;
  
  private View cQv;
  
  private w cQw;
  
  private View cQx;
  
  private g cQy;
  
  private EditText cft;
  
  private ActivityRoot cgM;
  
  private long cpq;
  
  private TextView cvO;
  
  public bq(ActivityRoot paramActivityRoot) {
    super(paramActivityRoot, 2131427937);
    this.cgM = paramActivityRoot;
    setPositionTop();
    this.tvTitle = (TextView)this.mView.findViewById(2131299242);
    this.cQq = (TextView)this.mView.findViewById(2131299826);
    this.cQr = (TextView)this.mView.findViewById(2131296771);
    Context context = this.mActivity;
    String str1 = getContext().getString(2131624248);
    String str2 = getContext().getString(2131624254);
    String str3 = getContext().getString(2131624253);
    String str4 = getContext().getString(2131624249);
    br br = new br(this);
    this.cQw = new w(context, new String[] { str1, str2, str3, str4 }, br);
    ajy();
    this.mView.findViewById(2131299838).setOnClickListener(new bs(this));
    this.mView.findViewById(2131296772).setOnClickListener(new bt(this));
    this.cft = (EditText)this.mView.findViewById(2131298198);
    this.mView.findViewById(2131298202).setOnClickListener(new m.b(this.mActivity, this.cft));
    this.cQv = this.mView.findViewById(2131299968);
    this.cvO = (TextView)this.cQv.findViewById(2131299967);
    this.cQt = (TextView)this.cQv.findViewById(2131299969);
    this.cQx = this.cQv.findViewById(2131298993);
    this.cQv.setOnClickListener(new m.b(this.mActivity, this.cvO));
    this.mView.findViewById(2131296671).setOnClickListener(new bu(this));
    this.mView.findViewById(2131298884).setOnClickListener(new bv(this));
    this.aCT = this.mView.findViewById(2131296858);
    this.aCT.setOnClickListener(new bw(this));
  }
  
  private void Xp() { this.mActivity.sendBroadcast(new Intent("pos_activity_change_data_attribute")); }
  
  private StringBuffer a(String paramString, StringBuffer paramStringBuffer) {
    if (by.isNull(paramString)) {
      this.cQs = "";
      paramStringBuffer.append(this.mActivity.getString(2131627613));
      return paramStringBuffer;
    } 
    this.cQs = paramString;
    if (paramString.split(",").length == this.bbw.size()) {
      paramStringBuffer.append(this.mActivity.getString(2131627613));
      return paramStringBuffer;
    } 
    byte b1 = 0;
    byte b2;
    for (b2 = 0; b1 < this.bbw.size(); b2 = b) {
      paramString = this.cQs;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((ProductTypeEntity)this.bbw.get(b1)).aSW);
      stringBuilder.append("");
      byte b = b2;
      if (paramString.contains(stringBuilder.toString())) {
        if (b2)
          paramStringBuffer.append(","); 
        paramStringBuffer.append(((ProductTypeEntity)this.bbw.get(b1)).name);
        b = b2 + true;
      } 
      b1++;
    } 
    return paramStringBuffer;
  }
  
  private void acb() {
    l l = new l(this.mActivity);
    this.bbw = l.a(true, null);
    l.close();
  }
  
  private long[] acc() {
    long[] arrayOfLong;
    byte b2 = 0;
    byte b1 = 0;
    if (by.isNull(this.cQs)) {
      long[] arrayOfLong1 = new long[this.bbw.size()];
      while (true) {
        arrayOfLong = arrayOfLong1;
        if (b1 < this.bbw.size()) {
          arrayOfLong1[b1] = ((ProductTypeEntity)this.bbw.get(b1)).aSW;
          b1++;
          continue;
        } 
        break;
      } 
    } else {
      String[] arrayOfString = this.cQs.split(",");
      arrayOfLong = new long[arrayOfString.length];
      for (b1 = b2; b1 < arrayOfString.length; b1++)
        arrayOfLong[b1] = Long.valueOf(arrayOfString[b1]).longValue(); 
    } 
    return arrayOfLong;
  }
  
  private void ajy() {
    acb();
    this.cQy = new g(this.cgM, this.bbw, new bx(this));
  }
  
  private String[] ajz() { // Byte code:
    //   0: aload_0
    //   1: getfield cft : Landroid/widget/EditText;
    //   4: invokevirtual getText : ()Landroid/text/Editable;
    //   7: invokevirtual toString : ()Ljava/lang/String;
    //   10: invokevirtual trim : ()Ljava/lang/String;
    //   13: astore #5
    //   15: aload #5
    //   17: invokevirtual length : ()I
    //   20: ifeq -> 272
    //   23: aload #5
    //   25: ldc_w '''
    //   28: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   31: ifeq -> 37
    //   34: goto -> 272
    //   37: new java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore_3
    //   45: aload_3
    //   46: aload_0
    //   47: getfield cpq : J
    //   50: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: ldc ''
    //   57: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: invokevirtual toString : ()Ljava/lang/String;
    //   65: astore #6
    //   67: aload_0
    //   68: getfield cQs : Ljava/lang/String;
    //   71: astore #7
    //   73: aload_0
    //   74: getfield cQv : Landroid/view/View;
    //   77: invokevirtual getVisibility : ()I
    //   80: ifne -> 242
    //   83: aload_0
    //   84: getfield cvO : Landroid/widget/TextView;
    //   87: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   90: invokeinterface toString : ()Ljava/lang/String;
    //   95: invokevirtual trim : ()Ljava/lang/String;
    //   98: astore #4
    //   100: aload #4
    //   102: invokevirtual length : ()I
    //   105: ifne -> 159
    //   108: new java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial <init> : ()V
    //   115: astore_3
    //   116: aload_3
    //   117: aload_0
    //   118: getfield cQt : Landroid/widget/TextView;
    //   121: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   124: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_3
    //   129: ldc_w ' '
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_3
    //   137: aload_0
    //   138: getfield mActivity : Landroid/content/Context;
    //   141: ldc_w 2131627462
    //   144: invokevirtual getString : (I)Ljava/lang/String;
    //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_3
    //   152: invokevirtual toString : ()Ljava/lang/String;
    //   155: astore_3
    //   156: goto -> 209
    //   159: aload #6
    //   161: ldc_w '3'
    //   164: invokevirtual equals : (Ljava/lang/Object;)Z
    //   167: ifeq -> 207
    //   170: aload #4
    //   172: ldc2_w -1.0
    //   175: invokestatic d : (Ljava/lang/String;D)D
    //   178: dstore_1
    //   179: dload_1
    //   180: dconst_0
    //   181: dcmpg
    //   182: iflt -> 193
    //   185: dload_1
    //   186: ldc2_w 100.0
    //   189: dcmpl
    //   190: ifle -> 207
    //   193: aload_0
    //   194: getfield mActivity : Landroid/content/Context;
    //   197: ldc_w 2131627466
    //   200: invokevirtual getString : (I)Ljava/lang/String;
    //   203: astore_3
    //   204: goto -> 209
    //   207: aconst_null
    //   208: astore_3
    //   209: aload_3
    //   210: ifnull -> 247
    //   213: aload_0
    //   214: getfield mActivity : Landroid/content/Context;
    //   217: aload_3
    //   218: invokestatic a : (Landroid/content/Context;Ljava/lang/CharSequence;)V
    //   221: aload_0
    //   222: getfield cvO : Landroid/widget/TextView;
    //   225: invokevirtual requestFocus : ()Z
    //   228: pop
    //   229: aload_0
    //   230: getfield mActivity : Landroid/content/Context;
    //   233: aload_0
    //   234: getfield cvO : Landroid/widget/TextView;
    //   237: invokestatic b : (Landroid/content/Context;Landroid/view/View;)V
    //   240: aconst_null
    //   241: areturn
    //   242: ldc_w '0'
    //   245: astore #4
    //   247: iconst_4
    //   248: anewarray java/lang/String
    //   251: dup
    //   252: iconst_0
    //   253: aload #5
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: aload #6
    //   260: aastore
    //   261: dup
    //   262: iconst_2
    //   263: aload #4
    //   265: aastore
    //   266: dup
    //   267: iconst_3
    //   268: aload #7
    //   270: aastore
    //   271: areturn
    //   272: aload #5
    //   274: invokevirtual length : ()I
    //   277: ifne -> 293
    //   280: aload_0
    //   281: getfield mActivity : Landroid/content/Context;
    //   284: ldc_w 2131627461
    //   287: invokestatic w : (Landroid/content/Context;I)V
    //   290: goto -> 303
    //   293: aload_0
    //   294: getfield mActivity : Landroid/content/Context;
    //   297: ldc_w 2131627554
    //   300: invokestatic w : (Landroid/content/Context;I)V
    //   303: aload_0
    //   304: getfield cft : Landroid/widget/EditText;
    //   307: invokevirtual requestFocus : ()Z
    //   310: pop
    //   311: aload_0
    //   312: getfield mActivity : Landroid/content/Context;
    //   315: aload_0
    //   316: getfield cft : Landroid/widget/EditText;
    //   319: invokestatic b : (Landroid/content/Context;Landroid/view/View;)V
    //   322: aconst_null
    //   323: areturn }
  
  private String cF(long paramLong) {
    if (paramLong == 0L)
      return getContext().getString(2131624248); 
    if (paramLong == 4L)
      return getContext().getString(2131624254); 
    if (paramLong == 1L)
      return getContext().getString(2131624253); 
    if (paramLong == 3L)
      return getContext().getString(2131624249); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unknown typeId: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private String cG(long paramLong) {
    if (paramLong == 0L)
      return getContext().getString(2131624255); 
    if (paramLong == 4L)
      return getContext().getString(2131624257); 
    if (paramLong == 3L)
      return getContext().getString(2131624256); 
    if (paramLong == 2L)
      return getContext().getString(2131624257); 
    if (paramLong == 1L)
      return getContext().getString(2131624258); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unknown attribute typeId: ");
    stringBuilder.append(paramLong);
    throw new RuntimeException(stringBuilder.toString());
  }
  
  private String cH(long paramLong) {
    if (paramLong == 0L)
      return getContext().getString(2131624248); 
    if (paramLong == 4L)
      return getContext().getString(2131624254); 
    if (paramLong == 3L)
      return getContext().getString(2131624249); 
    if (paramLong == 2L)
      return getContext().getString(2131624250); 
    if (paramLong == 1L)
      return getContext().getString(2131624253); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unknown attribute typeId: ");
    stringBuilder.append(paramLong);
    throw new RuntimeException(stringBuilder.toString());
  }
  
  private void ms(String paramString) {
    n.a(this.mActivity, paramString);
    n.j(this.cft);
    n.b(this.mActivity, this.cft);
  }
  
  private boolean save() {
    boolean bool;
    null = ajz();
    if (null == null)
      return false; 
    String str1 = null[0];
    String str2 = null[1];
    String str3 = null[2];
    String str4 = null[3];
    f f = new f(this.mActivity);
    if (this.cQp == null) {
      null = new StringBuilder();
      null.append(System.currentTimeMillis());
      null.append("");
      String str = null.toString();
      bool = f.f(str, str1, str2, str3, str4);
      if (this.cQu != null)
        this.cQu.c(bool, str, str1, str2, str4); 
    } else {
      boolean bool1 = f.g(this.cQp, str1, str2, str3, str4);
      bool = bool1;
      if (this.cQu != null) {
        this.cQu.a(bool1, this.cQp, str1, str2, str4);
        bool = bool1;
      } 
    } 
    if (bool) {
      Xp();
      if (this.cQp == null) {
        n.w(this.mActivity, 2131627484);
      } else {
        n.w(this.mActivity, 2131627647);
      } 
      cancel();
    } else {
      ms(f.Vn());
    } 
    f.close();
    return true;
  }
  
  private void xI() { xJ().show(); }
  
  private r xJ() {
    if (this.aCU == null) {
      this.aCU = new r(this.mActivity, new by(this));
      this.aCU.s(this.mActivity.getString(2131627458));
    } 
    return this.aCU;
  }
  
  public void a(a parama) { this.cQu = parama; }
  
  protected boolean delete() {
    f f = new f(this.mActivity);
    boolean bool = f.bM(this.cQp);
    f.close();
    if (bool)
      Xp(); 
    return bool;
  }
  
  public void e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    this.cQp = paramString1;
    this.cft.setText(paramString2);
    this.cvO.setFilters(new android.text.InputFilter[0]);
    if (paramString3 == null) {
      this.cpq = 0L;
    } else {
      this.cpq = Long.parseLong(paramString3);
    } 
    if (paramString1 == null) {
      this.tvTitle.setText(2131627456);
      this.cft.requestFocus();
      this.aCT.setVisibility(8);
      this.cvO.setText("0");
    } else {
      this.aCT.setVisibility(0);
      this.cvO.setText(paramString4);
      this.tvTitle.setText(2131627465);
      this.tvTitle.requestFocus();
    } 
    this.cvO.setFilters(ar.lw(99));
    StringBuffer stringBuffer = a(paramString5, new StringBuffer());
    this.cQq.setText(cH(this.cpq));
    this.cQr.setText(stringBuffer.toString());
    this.cQt.setText(cG(this.cpq));
    if (this.cpq == 3L) {
      this.cQx.setVisibility(0);
    } else {
      this.cQx.setVisibility(8);
    } 
    super.show();
  }
  
  @Deprecated
  public void show() { super.show(); }
  
  public static interface a {
    void a(boolean param1Boolean, String param1String1, String param1String2, String param1String3, String param1String4);
    
    void b(boolean param1Boolean, String param1String1, String param1String2, String param1String3, String param1String4);
    
    void c(boolean param1Boolean, String param1String1, String param1String2, String param1String3, String param1String4);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */