package com.laiqian.pos.features;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.models.an;
import com.laiqian.pos.hardware.q;
import com.laiqian.pos.industry.weiorder.g;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.aa;
import com.laiqian.util.al;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ScanOrderExportFragment extends FragmentRoot implements g {
  private String aGA;
  
  private ArrayList<String> aGI;
  
  private String aGK;
  
  private ImageView azs;
  
  private int bHq = 0;
  
  w.a btm = new s(this);
  
  private View cjC;
  
  private EditText cjD;
  
  private EditText cjE;
  
  private TextView cjF;
  
  private String cjG;
  
  private Bitmap cjH;
  
  private int cjI = 0;
  
  private TextView cjJ;
  
  private View cjK;
  
  private View cjL;
  
  private View cjM;
  
  w cjN;
  
  private View.OnClickListener cjO = new p(this);
  
  Handler handler = new q(this);
  
  private Context mContext;
  
  private void Tb() {
    if (getActivity() == null)
      return; 
    this.aGI = new ArrayList();
    this.aGI = n.a(getActivity(), true);
    int i = this.aGI.size();
    byte b = 0;
    if (i == 1) {
      this.aGK = (String)this.aGI.get(0);
      gU(1);
      return;
    } 
    if (i >= 1) {
      String[] arrayOfString = new String[i];
      while (b < this.aGI.size()) {
        arrayOfString[b] = (String)this.aGI.get(b);
        b++;
      } 
      w w1 = new w(this.mContext, arrayOfString, this.btm);
      w1.setWidth(500);
      w1.gn(this.bHq);
      w1.setOnCancelListener(new r(this));
      w1.show();
      return;
    } 
    gU(0);
  }
  
  private void a(String paramString, Bitmap paramBitmap, int paramInt) throws Exception {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("/");
    stringBuilder.append(this.mContext.getString(2131626653));
    stringBuilder.append(paramInt);
    stringBuilder.append(".jpg");
    FileOutputStream fileOutputStream = new FileOutputStream(new File(stringBuilder.toString()));
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
    fileOutputStream.close();
  }
  
  private void aah() { this.cjK.setOnClickListener(this.cjO); }
  
  private void aai() {
    r r = new r(getActivity(), new aa(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131626756));
    r.t(getString(2131627282));
    r.oZ(getString(2131627285));
    r.show();
  }
  
  private void be(int paramInt1, int paramInt2) {
    if (getActivity() != null) {
      if (!isAdded())
        return; 
      FragmentActivity fragmentActivity = getActivity();
      String str1 = getString(2131627875);
      String str2 = getString(2131627874);
      t t = new t(this, paramInt1, paramInt2);
      this.cjN = new w(fragmentActivity, new String[] { str1, str2 }, t, false);
      this.cjN.show();
      return;
    } 
  }
  
  private void bf(int paramInt1, int paramInt2) {
    if (getActivity() == null)
      return; 
    this.aGI = n.a(getActivity(), true);
    int i = this.aGI.size();
    byte b = 0;
    if (i == 1) {
      this.aGK = (String)this.aGI.get(0);
      e(this.aGK, paramInt1, paramInt2);
      return;
    } 
    String[] arrayOfString = new String[i];
    while (b < this.aGI.size()) {
      arrayOfString[b] = (String)this.aGI.get(b);
      b++;
    } 
    w w1 = new w(this.mContext, arrayOfString, new u(this, arrayOfString, paramInt1, paramInt2));
    w1.setWidth(500);
    w1.gn(this.bHq);
    w1.setOnCancelListener(new v(this));
    w1.show();
  }
  
  private void bg(int paramInt1, int paramInt2) {
    String[] arrayOfString1;
    if (getActivity() == null)
      return; 
    View view1 = View.inflate(getActivity(), 2131427863, null);
    TextView textView1 = (TextView)view1.findViewById(2131296334);
    TextView textView2 = (TextView)view1.findViewById(2131296893);
    if (a.zR().Ad()) {
      arrayOfString1 = new String[5];
      arrayOfString1[0] = "@yahoo.com";
      arrayOfString1[1] = "@hotmail.com";
      arrayOfString1[2] = "@gmail.com";
      arrayOfString1[3] = "@icloud.com";
      arrayOfString1[4] = "@163.com";
    } else {
      arrayOfString1 = new String[11];
      arrayOfString1[0] = "@qq.com";
      arrayOfString1[1] = "@163.com";
      arrayOfString1[2] = "@aliyun.com";
      arrayOfString1[3] = "@sina.com";
      arrayOfString1[4] = "@sina.cn";
      arrayOfString1[5] = "@139.com";
      arrayOfString1[6] = "@sohu.com";
      arrayOfString1[7] = "@189.cn";
      arrayOfString1[8] = "@126.com";
      arrayOfString1[9] = "@tom.com";
      arrayOfString1[10] = "@foxmail.com";
    } 
    String[] arrayOfString2 = getLaiqianPreferenceManager().auT();
    if (arrayOfString2 != null) {
      textView1.setText(arrayOfString2[0]);
      textView2.setText(arrayOfString2[1]);
      view1.requestFocus();
    } else {
      textView1.setText("");
      textView1.requestFocus();
      textView2.setText(arrayOfString1[0]);
      n.b(getActivity(), textView1);
    } 
    textView2.setOnClickListener(new x(this, new w(getActivity(), arrayOfString1, new w(this, textView2, arrayOfString1))));
    PopupWindow popupWindow = new PopupWindow(view1, -2, -2, true);
    popupWindow.setBackgroundDrawable(new ColorDrawable());
    popupWindow.setOutsideTouchable(true);
    TextView textView3 = (TextView)view1.findViewById(2131299317);
    view1.findViewById(2131298939).setOnClickListener(new y(this, textView1, textView3, textView2, paramInt1, paramInt2));
    view1.findViewById(2131296671).setOnClickListener(new z(this, popupWindow));
    Rect rect = new Rect();
    View view2 = this.cjN.ark();
    view2.getGlobalVisibleRect(rect);
    paramInt1 = rect.right;
    paramInt2 = rect.top;
    textView3.setText(null);
    popupWindow.showAtLocation(view2, 0, paramInt1, paramInt2);
  }
  
  private void e(String paramString, int paramInt1, int paramInt2) {
    this.cjL.setVisibility(0);
    this.cjF.setVisibility(8);
    a.aKh().r(new o(this, paramInt1, paramInt2, paramString));
  }
  
  private View findViewById(int paramInt) { return this.cjC.findViewById(paramInt); }
  
  private Bitmap gT(int paramInt) {
    str2 = q.clo;
    String str3 = this.aGA;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    str3 = String.format(str2, new Object[] { str3, stringBuilder2.toString() });
    str2 = str3;
    if (a.zR().Ad()) {
      null = new StringBuilder();
      null.append(str3);
      null.append("&en=1");
      str2 = null.toString();
    } 
    Bitmap bitmap = Bitmap.createBitmap(this.cjH.getWidth(), this.cjH.getHeight(), this.cjH.getConfig());
    Canvas canvas = new Canvas(bitmap);
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setDither(true);
    canvas.drawBitmap(this.cjH, 0.0F, 0.0F, paint);
    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
    try {
      Bitmap bitmap1 = al.C(str2, 540);
    } catch (Exception str2) {
      a.e(str2);
      str2 = null;
    } 
    canvas.drawBitmap(str2, 261.0F, 320.0F, paint);
    int i = this.cjH.getWidth();
    int j = i / 50;
    paint.setColor(-13421773);
    paint.setTextSize(80.0F);
    paint.setTypeface(Typeface.DEFAULT_BOLD);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.mContext.getString(2131626653));
    stringBuilder1.append("    ");
    stringBuilder1.append(paramInt);
    String str1 = stringBuilder1.toString();
    Paint.FontMetrics fontMetrics = paint.getFontMetrics();
    float f2 = 81;
    float f3 = fontMetrics.descent;
    float f4 = (fontMetrics.descent - fontMetrics.ascent) / 2.0F;
    float f1 = i / 2.0F;
    paint.setTextAlign(Paint.Align.CENTER);
    canvas.drawText(str1, f1, f2 - f3 + f4, paint);
    paint.setTypeface(Typeface.DEFAULT);
    paint.setTextSize(56.0F);
    f2 = fontMetrics.descent;
    f3 = (fontMetrics.descent - fontMetrics.ascent) / 2.0F;
    paint.setTextAlign(Paint.Align.CENTER);
    canvas.drawText(this.cjG, f1, 920.0F - f2 + f3, paint);
    return bitmap;
  }
  
  private void gU(int paramInt) {
    StringBuilder stringBuilder;
    TextView textView;
    this.cjI = paramInt;
    switch (this.cjI) {
      default:
        return;
      case 1:
        textView = this.cjJ;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.mContext.getString(2131628410));
        stringBuilder.append(this.aGK);
        textView.setText(stringBuilder.toString());
        this.cjF.setText(getString(2131626772));
        this.cjM.setVisibility(8);
        return;
      case 0:
        break;
    } 
    this.bHq = 0;
    this.aGK = "";
    this.cjJ.setText(this.aGK);
    this.cjF.setText(getString(2131626772));
    this.cjM.setVisibility(0);
  }
  
  private void initData() {
    this.cjD.setText("1");
    this.cjE.setText("10");
    this.mContext = getActivity();
    this.cjH = BitmapFactory.decodeStream(getResources().openRawResource(2131558414));
    an.c c = (new an(this.mContext)).Vu();
    this.cjG = c.aVs;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c.bSo);
    stringBuilder.append("");
    this.aGA = stringBuilder.toString();
    this.azs.setImageBitmap(gT(1));
    Tb();
  }
  
  private void xT() {
    this.cjL = findViewById(2131297334);
    this.cjK = findViewById(2131298753);
    this.cjM = findViewById(2131296385);
    this.cjF = (TextView)findViewById(2131296553);
    this.cjJ = (TextView)findViewById(2131299631);
    this.azs = (ImageView)findViewById(2131297399);
    this.cjD = (EditText)findViewById(2131296941);
    this.cjE = (EditText)findViewById(2131296947);
  }
  
  public boolean Az() {
    View view = this.cjL;
    boolean bool = false;
    if (view != null) {
      if (this.cjL.getVisibility() == 0)
        bool = true; 
      return bool;
    } 
    return false;
  }
  
  public void a(aa paramaa) {}
  
  public void onCreate(Bundle paramBundle) { super.onCreate(paramBundle); }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.cjC = paramLayoutInflater.inflate(2131427583, paramViewGroup, false);
    xT();
    aah();
    initData();
    return this.cjC;
  }
  
  public void save() {}
  
  private class a extends Thread {
    private String bvY;
    
    private int end;
    
    private int start;
    
    private a(ScanOrderExportFragment this$0, String param1String, int param1Int1, int param1Int2) {
      this.bvY = param1String;
      this.start = param1Int1;
      this.end = param1Int2;
    }
    
    public void run() { // Byte code:
      //   0: aload_0
      //   1: getfield cjQ : Lcom/laiqian/pos/features/ScanOrderExportFragment;
      //   4: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
      //   7: invokevirtual getExternalCacheDir : ()Ljava/io/File;
      //   10: astore #5
      //   12: aload #5
      //   14: ifnonnull -> 28
      //   17: aload_0
      //   18: getfield cjQ : Lcom/laiqian/pos/features/ScanOrderExportFragment;
      //   21: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
      //   24: invokestatic P : (Landroid/app/Activity;)V
      //   27: return
      //   28: new java/util/ArrayList
      //   31: dup
      //   32: invokespecial <init> : ()V
      //   35: astore #4
      //   37: new java/util/ArrayList
      //   40: dup
      //   41: invokespecial <init> : ()V
      //   44: astore_3
      //   45: aload_0
      //   46: getfield start : I
      //   49: istore_1
      //   50: iload_1
      //   51: aload_0
      //   52: getfield end : I
      //   55: if_icmpgt -> 231
      //   58: aload_0
      //   59: getfield cjQ : Lcom/laiqian/pos/features/ScanOrderExportFragment;
      //   62: iload_1
      //   63: invokestatic b : (Lcom/laiqian/pos/features/ScanOrderExportFragment;I)Landroid/graphics/Bitmap;
      //   66: astore #6
      //   68: new java/lang/StringBuilder
      //   71: dup
      //   72: invokespecial <init> : ()V
      //   75: astore #7
      //   77: aload #7
      //   79: aload #5
      //   81: invokevirtual getAbsolutePath : ()Ljava/lang/String;
      //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   87: pop
      //   88: aload #7
      //   90: getstatic java/io/File.separator : Ljava/lang/String;
      //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   96: pop
      //   97: aload #7
      //   99: ldc 'scan_order_'
      //   101: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: pop
      //   105: aload #7
      //   107: iload_1
      //   108: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   111: pop
      //   112: aload #7
      //   114: ldc '.jpg'
      //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   119: pop
      //   120: aload #7
      //   122: invokevirtual toString : ()Ljava/lang/String;
      //   125: astore #7
      //   127: new java/io/FileOutputStream
      //   130: dup
      //   131: aload #7
      //   133: invokespecial <init> : (Ljava/lang/String;)V
      //   136: astore #8
      //   138: aload #6
      //   140: getstatic android/graphics/Bitmap$CompressFormat.JPEG : Landroid/graphics/Bitmap$CompressFormat;
      //   143: bipush #100
      //   145: aload #8
      //   147: invokevirtual compress : (Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   150: pop
      //   151: aload #8
      //   153: invokevirtual flush : ()V
      //   156: aload #8
      //   158: invokevirtual close : ()V
      //   161: aload #4
      //   163: aload #7
      //   165: invokevirtual add : (Ljava/lang/Object;)Z
      //   168: pop
      //   169: new java/lang/StringBuilder
      //   172: dup
      //   173: invokespecial <init> : ()V
      //   176: astore #6
      //   178: aload #6
      //   180: aload_0
      //   181: getfield cjQ : Lcom/laiqian/pos/features/ScanOrderExportFragment;
      //   184: ldc 2131628306
      //   186: invokevirtual getString : (I)Ljava/lang/String;
      //   189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   192: pop
      //   193: aload #6
      //   195: iload_1
      //   196: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   199: pop
      //   200: aload #6
      //   202: ldc '.jpg'
      //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   207: pop
      //   208: aload_3
      //   209: aload #6
      //   211: invokevirtual toString : ()Ljava/lang/String;
      //   214: invokevirtual add : (Ljava/lang/Object;)Z
      //   217: pop
      //   218: goto -> 394
      //   221: astore #6
      //   223: aload #6
      //   225: invokestatic e : (Ljava/lang/Throwable;)V
      //   228: goto -> 394
      //   231: aload #4
      //   233: invokevirtual size : ()I
      //   236: anewarray java/lang/String
      //   239: astore #9
      //   241: aload #4
      //   243: invokevirtual size : ()I
      //   246: anewarray java/lang/String
      //   249: astore #8
      //   251: iconst_1
      //   252: istore_2
      //   253: aload_0
      //   254: getfield bvY : Ljava/lang/String;
      //   257: astore #5
      //   259: aload_0
      //   260: getfield cjQ : Lcom/laiqian/pos/features/ScanOrderExportFragment;
      //   263: ldc 2131629538
      //   265: invokevirtual getString : (I)Ljava/lang/String;
      //   268: astore #6
      //   270: aload_0
      //   271: getfield cjQ : Lcom/laiqian/pos/features/ScanOrderExportFragment;
      //   274: ldc 2131629537
      //   276: invokevirtual getString : (I)Ljava/lang/String;
      //   279: astore #7
      //   281: aload #4
      //   283: aload #9
      //   285: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
      //   288: checkcast [Ljava/lang/String;
      //   291: astore #4
      //   293: aload_3
      //   294: aload #8
      //   296: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
      //   299: checkcast [Ljava/lang/String;
      //   302: astore_3
      //   303: iconst_1
      //   304: anewarray java/lang/String
      //   307: dup
      //   308: iconst_0
      //   309: aload #5
      //   311: aastore
      //   312: aload #6
      //   314: aload #7
      //   316: aload #4
      //   318: aload_3
      //   319: invokestatic a : ([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)Z
      //   322: ifeq -> 401
      //   325: aload_0
      //   326: getfield cjQ : Lcom/laiqian/pos/features/ScanOrderExportFragment;
      //   329: invokevirtual getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   332: aload_0
      //   333: getfield bvY : Ljava/lang/String;
      //   336: invokevirtual rr : (Ljava/lang/String;)V
      //   339: goto -> 342
      //   342: new android/os/Message
      //   345: dup
      //   346: invokespecial <init> : ()V
      //   349: astore_3
      //   350: aload_3
      //   351: iload_2
      //   352: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   355: putfield obj : Ljava/lang/Object;
      //   358: aload_0
      //   359: getfield cjQ : Lcom/laiqian/pos/features/ScanOrderExportFragment;
      //   362: getfield handler : Landroid/os/Handler;
      //   365: aload_3
      //   366: invokevirtual sendMessage : (Landroid/os/Message;)Z
      //   369: pop
      //   370: aload_0
      //   371: getfield cjQ : Lcom/laiqian/pos/features/ScanOrderExportFragment;
      //   374: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
      //   377: invokestatic P : (Landroid/app/Activity;)V
      //   380: return
      //   381: astore_3
      //   382: aload_0
      //   383: getfield cjQ : Lcom/laiqian/pos/features/ScanOrderExportFragment;
      //   386: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
      //   389: invokestatic P : (Landroid/app/Activity;)V
      //   392: aload_3
      //   393: athrow
      //   394: iload_1
      //   395: iconst_1
      //   396: iadd
      //   397: istore_1
      //   398: goto -> 50
      //   401: iconst_0
      //   402: istore_2
      //   403: goto -> 342
      // Exception table:
      //   from	to	target	type
      //   0	12	381	finally
      //   28	50	381	finally
      //   50	68	381	finally
      //   68	218	221	java/io/IOException
      //   68	218	381	finally
      //   223	228	381	finally
      //   231	251	381	finally
      //   253	339	381	finally
      //   342	370	381	finally }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\features\ScanOrderExportFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */