package com.laiqian.member;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.laiqian.print.cardreader.ah;
import com.laiqian.print.cardreader.am;
import com.laiqian.print.cardreader.s;
import com.laiqian.util.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"NewApi"})
public class bz {
  public static bz aDP;
  
  private Timer aCb;
  
  private Intent bvZ = new Intent("action_usb_card_read_once");
  
  boolean bwa = false;
  
  private Handler handler;
  
  private Context mContext;
  
  private long time = 500L;
  
  static  {
  
  }
  
  public static bz Qw() { // Byte code:
    //   0: getstatic com/laiqian/member/bz.aDP : Lcom/laiqian/member/bz;
    //   3: ifnonnull -> 31
    //   6: ldc com/laiqian/member/bz
    //   8: monitorenter
    //   9: new com/laiqian/member/bz
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/laiqian/member/bz.aDP : Lcom/laiqian/member/bz;
    //   19: ldc com/laiqian/member/bz
    //   21: monitorexit
    //   22: goto -> 31
    //   25: astore_0
    //   26: ldc com/laiqian/member/bz
    //   28: monitorexit
    //   29: aload_0
    //   30: athrow
    //   31: getstatic com/laiqian/member/bz.aDP : Lcom/laiqian/member/bz;
    //   34: areturn
    // Exception table:
    //   from	to	target	type
    //   9	22	25	finally
    //   26	29	25	finally }
  
  @SuppressLint({"NewApi"})
  public static String aD(Context paramContext) { // Byte code:
    //   0: aload_0
    //   1: ldc 'usb'
    //   3: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast android/hardware/usb/UsbManager
    //   9: astore_3
    //   10: aload_0
    //   11: iconst_0
    //   12: new android/content/Intent
    //   15: dup
    //   16: ldc 'com.android.example.USB_PERMISSION'
    //   18: invokespecial <init> : (Ljava/lang/String;)V
    //   21: iconst_0
    //   22: invokestatic getBroadcast : (Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   25: astore_0
    //   26: aload_3
    //   27: ifnull -> 208
    //   30: aload_3
    //   31: invokevirtual getDeviceList : ()Ljava/util/HashMap;
    //   34: ifnonnull -> 40
    //   37: goto -> 208
    //   40: aload_3
    //   41: invokevirtual getDeviceList : ()Ljava/util/HashMap;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnonnull -> 52
    //   49: ldc ''
    //   51: areturn
    //   52: aload_2
    //   53: invokevirtual values : ()Ljava/util/Collection;
    //   56: invokeinterface iterator : ()Ljava/util/Iterator;
    //   61: astore #4
    //   63: aload #4
    //   65: invokeinterface hasNext : ()Z
    //   70: istore_1
    //   71: aconst_null
    //   72: astore_2
    //   73: iload_1
    //   74: ifeq -> 128
    //   77: aload #4
    //   79: invokeinterface next : ()Ljava/lang/Object;
    //   84: checkcast android/hardware/usb/UsbDevice
    //   87: astore_2
    //   88: aload_2
    //   89: ifnull -> 63
    //   92: aload_2
    //   93: invokestatic b : (Landroid/hardware/usb/UsbDevice;)Z
    //   96: ifeq -> 63
    //   99: aload_3
    //   100: aload_2
    //   101: invokevirtual hasPermission : (Landroid/hardware/usb/UsbDevice;)Z
    //   104: ifne -> 116
    //   107: aload_3
    //   108: aload_2
    //   109: aload_0
    //   110: invokevirtual requestPermission : (Landroid/hardware/usb/UsbDevice;Landroid/app/PendingIntent;)V
    //   113: ldc ''
    //   115: areturn
    //   116: new com/b/a/b
    //   119: dup
    //   120: aload_3
    //   121: invokespecial <init> : (Landroid/hardware/usb/UsbManager;)V
    //   124: astore_0
    //   125: goto -> 130
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_2
    //   131: ifnonnull -> 137
    //   134: ldc ''
    //   136: areturn
    //   137: aload_0
    //   138: aload_2
    //   139: invokevirtual k : (Landroid/hardware/usb/UsbDevice;)Z
    //   142: ifeq -> 205
    //   145: new com/b/a/a
    //   148: dup
    //   149: aload_0
    //   150: invokespecial <init> : (Lcom/b/a/b;)V
    //   153: astore_2
    //   154: aload_2
    //   155: invokevirtual axO : ()V
    //   158: aload_2
    //   159: getstatic com/b/a/a$a.dMH : Lcom/b/a/a$a;
    //   162: invokevirtual a : (Lcom/b/a/a$a;)Ljava/lang/String;
    //   165: astore_2
    //   166: aload_2
    //   167: ifnull -> 176
    //   170: aload_0
    //   171: invokevirtual close : ()V
    //   174: aload_2
    //   175: areturn
    //   176: aload_0
    //   177: invokevirtual close : ()V
    //   180: ldc ''
    //   182: areturn
    //   183: astore_2
    //   184: goto -> 199
    //   187: astore_2
    //   188: aload_2
    //   189: invokestatic e : (Ljava/lang/Throwable;)V
    //   192: aload_0
    //   193: invokevirtual close : ()V
    //   196: ldc ''
    //   198: areturn
    //   199: aload_0
    //   200: invokevirtual close : ()V
    //   203: aload_2
    //   204: athrow
    //   205: ldc ''
    //   207: areturn
    //   208: ldc ''
    //   210: areturn
    // Exception table:
    //   from	to	target	type
    //   145	166	187	com/b/a/c
    //   145	166	183	finally
    //   188	192	183	finally }
  
  public static boolean aE(Context paramContext) {
    new Build.VERSION();
    if (Build.VERSION.SDK_INT < 12)
      return false; 
    null = am.ba(paramContext);
    s s = s.aZ(paramContext);
    ArrayList arrayList = null.afs();
    boolean bool2 = arrayList.isEmpty();
    boolean bool1 = true;
    if (bool2 ^ true) {
      Iterator iterator = arrayList.iterator();
      while (iterator.hasNext()) {
        if (!s.d(((ah)iterator.next()).afr()))
          bool1 = false; 
      } 
      return bool1;
    } 
    return false;
  }
  
  public void Qx() {
    if (!this.bwa)
      start(); 
  }
  
  public void a(Context paramContext, long paramLong, Handler paramHandler) {
    this.mContext = paramContext;
    this.handler = paramHandler;
    this.time = paramLong;
  }
  
  public void start() {
    if (this.aCb != null) {
      this.aCb.cancel();
      this.aCb.purge();
      this.aCb = null;
    } 
    if (this.aCb == null)
      this.aCb = new Timer(); 
    a a = new a(this);
    this.aCb.schedule(a, 0L, this.time);
    this.bwa = true;
  }
  
  public void stop() {
    if (this.aCb != null) {
      this.aCb.cancel();
      this.aCb = null;
    } 
    aDP = null;
    this.bwa = false;
  }
  
  class a extends TimerTask {
    a(bz this$0) {}
    
    public void run() {
      bb.ao("读卡中");
      String str = bz.aD(bz.a(this.bwb));
      Message message = new Message();
      message.obj = str;
      if (bz.b(this.bwb) != null)
        bz.b(this.bwb).sendMessage(message); 
      bz.c(this.bwb).putExtra("extra_card_read_number", str);
      bz.a(this.bwb).sendBroadcast(bz.c(this.bwb));
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */