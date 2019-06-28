package com.laiqian.print.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.type.a.b;
import com.laiqian.print.model.type.a.d;
import com.laiqian.print.model.type.b.a;
import com.laiqian.print.model.type.b.b;
import com.laiqian.print.model.type.c.a;
import com.laiqian.print.model.type.usb.UsbPrintManager;
import com.laiqian.print.model.type.usb.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public static enum g {
  cGS;
  
  private static final String TAG = "g";
  
  public static int cGT = 5000;
  
  private BroadcastReceiver cDk = new i(this);
  
  private Map<String, ExecutorService> cEC = new WeakHashMap();
  
  private final ArrayList<d> cGU = new ArrayList();
  
  private final d cGV = new h(this);
  
  ConcurrentHashMap<s, q> cGW = new ConcurrentHashMap();
  
  private c cGX = null;
  
  @Nullable
  private a cGY;
  
  @Nullable
  private UsbPrintManager cGZ;
  
  @Nullable
  private a cHa;
  
  @Nullable
  private b cHb;
  
  private b cHc = null;
  
  private Context mContext;
  
  g() {
    a(this.cGV);
    a(new j(this));
  }
  
  private void be(Context paramContext) {
    this.cGY = a.cHO;
    try {
      this.cGY.init(paramContext);
    } catch (Exception exception) {
      a.e(exception);
    } 
    if (!this.cGY.isInitialized())
      Log.d(TAG, "net print function not available"); 
    this.cGZ = UsbPrintManager.INSTANCE;
    try {
      this.cGZ.init(paramContext);
    } catch (IllegalStateException illegalStateException) {
      a.e(illegalStateException);
    } 
    if (!this.cGZ.isInitialized())
      Log.d(TAG, "usb print function not available"); 
    this.cHa = a.cIf;
    try {
      this.cHa.init(paramContext);
    } catch (Exception paramContext) {
      a.e(paramContext);
    } 
    if (!this.cHa.isInitialized())
      Log.d(TAG, "serial print function not available"); 
    this.cHb = b.cHB;
    try {
      this.cHb.init(this.mContext);
    } catch (IllegalStateException paramContext) {
      a.e(paramContext);
    } 
    if (!this.cHb.isInitialized())
      Log.d(TAG, "bluetooth print function not available"); 
  }
  
  private static a cy(long paramLong) { return new a(paramLong); }
  
  private boolean d(@NonNull e parame) {
    Iterator iterator = parame.ags().iterator();
    while (iterator.hasNext()) {
      if (((PrintContent)iterator.next()).agb())
        return true; 
    } 
    return false;
  }
  
  private ExecutorService h(s params) {
    ExecutorService executorService2 = (ExecutorService)this.cEC.get(params.getIdentifier());
    ExecutorService executorService1 = executorService2;
    if (executorService2 == null) {
      executorService1 = Executors.newSingleThreadExecutor(new e(params));
      this.cEC.put(params.getIdentifier(), executorService1);
    } 
    return executorService1;
  }
  
  public void a(c paramc) { this.cGX = paramc; }
  
  public void a(@NonNull d paramd) { this.cGU.add(paramd); }
  
  @Nullable
  public d agA() { return !agD() ? null : new d(this, this.mContext); }
  
  public boolean agB() { return (this.cGZ != null && this.cGZ.isInitialized()); }
  
  public boolean agC() { return (this.cGY != null && this.cGY.isInitialized()); }
  
  public boolean agD() { return (this.cHb != null && this.cHb.isInitialized()); }
  
  @Nullable
  public f agy() { return !agB() ? null : new f(this); }
  
  @Nullable
  public b agz() { return !agC() ? null : new b(this); }
  
  public void c(e parame) {
    UsbPrintManager usbPrintManager;
    switch (parame.aew().getType()) {
      default:
        null = null;
        break;
      case 4:
        null = this.cHa;
        break;
      case 3:
        null = this.cHb;
        break;
      case 2:
        null = this.cGY;
        break;
      case 1:
        usbPrintManager = this.cGZ;
        break;
    } 
    if (usbPrintManager != null) {
      ExecutorService executorService = h(parame.aew());
      parame.agv();
      executorService.submit(new o(this, parame, usbPrintManager));
    } 
  }
  
  @NonNull
  public q f(@NonNull s params) { // Byte code:
    //   0: aload_0
    //   1: getfield cGW : Ljava/util/concurrent/ConcurrentHashMap;
    //   4: aload_1
    //   5: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   8: ifeq -> 51
    //   11: aload_0
    //   12: getfield cGW : Ljava/util/concurrent/ConcurrentHashMap;
    //   15: aload_1
    //   16: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast com/laiqian/print/model/q
    //   22: astore #4
    //   24: aload #4
    //   26: astore_3
    //   27: aload #4
    //   29: invokevirtual agE : ()Lcom/laiqian/print/model/s;
    //   32: aload_1
    //   33: invokevirtual equals : (Ljava/lang/Object;)Z
    //   36: ifne -> 113
    //   39: aload #4
    //   41: aload_1
    //   42: invokevirtual i : (Lcom/laiqian/print/model/s;)V
    //   45: aload #4
    //   47: astore_3
    //   48: goto -> 113
    //   51: aload_0
    //   52: getfield cGU : Ljava/util/ArrayList;
    //   55: astore #4
    //   57: aload #4
    //   59: monitorenter
    //   60: aload_0
    //   61: getfield cGU : Ljava/util/ArrayList;
    //   64: invokevirtual size : ()I
    //   67: iconst_1
    //   68: isub
    //   69: istore_2
    //   70: iload_2
    //   71: iflt -> 169
    //   74: aload_0
    //   75: getfield cGU : Ljava/util/ArrayList;
    //   78: iload_2
    //   79: invokevirtual get : (I)Ljava/lang/Object;
    //   82: checkcast com/laiqian/print/model/g$d
    //   85: aload_0
    //   86: aload_1
    //   87: invokeinterface a : (Lcom/laiqian/print/model/g;Lcom/laiqian/print/model/s;)Lcom/laiqian/print/model/q;
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull -> 162
    //   97: aload_0
    //   98: getfield cGW : Ljava/util/concurrent/ConcurrentHashMap;
    //   101: aload_1
    //   102: aload_3
    //   103: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: goto -> 110
    //   110: aload #4
    //   112: monitorexit
    //   113: aload_3
    //   114: ifnonnull -> 154
    //   117: new java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial <init> : ()V
    //   124: astore_3
    //   125: aload_3
    //   126: ldc_w 'cannot create printer for '
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_3
    //   134: aload_1
    //   135: invokevirtual toString : ()Ljava/lang/String;
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: new java/lang/IllegalStateException
    //   145: dup
    //   146: aload_3
    //   147: invokevirtual toString : ()Ljava/lang/String;
    //   150: invokespecial <init> : (Ljava/lang/String;)V
    //   153: athrow
    //   154: aload_3
    //   155: areturn
    //   156: astore_1
    //   157: aload #4
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    //   162: iload_2
    //   163: iconst_1
    //   164: isub
    //   165: istore_2
    //   166: goto -> 70
    //   169: aconst_null
    //   170: astore_3
    //   171: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   60	70	156	finally
    //   74	93	156	finally
    //   97	107	156	finally
    //   110	113	156	finally
    //   157	160	156	finally }
  
  public void g(s params) {
    UsbPrintManager usbPrintManager;
    switch (params.getType()) {
      default:
        null = null;
        break;
      case 4:
        null = this.cHa;
        break;
      case 3:
        null = this.cHb;
        break;
      case 2:
        null = this.cGY;
        break;
      case 1:
        usbPrintManager = this.cGZ;
        break;
    } 
    if (usbPrintManager != null)
      h(params).submit(new n(this, usbPrintManager, params)); 
  }
  
  public void init(@NonNull Context paramContext) {
    this.mContext = paramContext;
    be(paramContext);
  }
  
  public boolean isConnected(s params) {
    UsbPrintManager usbPrintManager;
    a a2;
    b b1;
    a a1;
    switch (params.getType()) {
      default:
        a2 = null;
        break;
      case 4:
        a2 = this.cHa;
        break;
      case 3:
        b1 = this.cHb;
        break;
      case 2:
        a1 = this.cGY;
        break;
      case 1:
        usbPrintManager = this.cGZ;
        break;
    } 
    return (usbPrintManager != null && usbPrintManager.isConnected(params));
  }
  
  public void o(Collection<e> paramCollection) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      print((e)iterator.next()); 
  }
  
  public void print(e parame) {
    UsbPrintManager usbPrintManager;
    switch (parame.aew().getType()) {
      default:
        null = null;
        break;
      case 4:
        null = this.cHa;
        break;
      case 3:
        null = this.cHb;
        break;
      case 2:
        null = this.cGY;
        break;
      case 1:
        usbPrintManager = this.cGZ;
        break;
    } 
    if (usbPrintManager != null) {
      ExecutorService executorService = h(parame.aew());
      parame.agv();
      executorService.submit(new p(this, usbPrintManager, parame));
      if (parame.agx() != 0L && d(parame))
        executorService.submit(cy(parame.agx())); 
    } 
  }
  
  class g {}
  
  class g {}
  
  class g {}
  
  class g {}
  
  class g {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\print\model\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */