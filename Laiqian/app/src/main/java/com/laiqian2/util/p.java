package com.laiqian.util;

import android.content.Context;
import android.content.Intent;
import android.os.StatFs;
import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.pos.hardware.b;
import com.laiqian.wallet.k;
import io.reactivex.g.a;

public class p extends n {
  private static final Object aMA = new Object();
  
  public static void asD() { asE(); }
  
  public static void asE() { // Byte code:
    //   0: getstatic com/laiqian/util/p.aMA : Ljava/lang/Object;
    //   3: astore #6
    //   5: aload #6
    //   7: monitorenter
    //   8: new com/laiqian/crash/model/l
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore #4
    //   17: new java/io/File
    //   20: dup
    //   21: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   24: aload #4
    //   26: invokevirtual CQ : ()Ljava/lang/String;
    //   29: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   32: astore #9
    //   34: aload #9
    //   36: invokevirtual list : ()[Ljava/lang/String;
    //   39: astore #10
    //   41: aload #10
    //   43: ifnonnull -> 50
    //   46: aload #6
    //   48: monitorexit
    //   49: return
    //   50: new java/util/ArrayList
    //   53: dup
    //   54: invokespecial <init> : ()V
    //   57: astore #8
    //   59: new java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial <init> : ()V
    //   66: astore #7
    //   68: aconst_null
    //   69: astore #4
    //   71: iconst_0
    //   72: istore_2
    //   73: iconst_0
    //   74: istore_0
    //   75: iload_2
    //   76: aload #10
    //   78: arraylength
    //   79: if_icmpge -> 315
    //   82: iload_2
    //   83: aload #10
    //   85: arraylength
    //   86: iconst_1
    //   87: isub
    //   88: if_icmpeq -> 100
    //   91: aload #4
    //   93: astore #5
    //   95: iload_0
    //   96: istore_1
    //   97: goto -> 426
    //   100: aload #4
    //   102: astore #5
    //   104: iload_0
    //   105: istore_1
    //   106: aload #10
    //   108: iload_2
    //   109: aaload
    //   110: ifnull -> 426
    //   113: aload #4
    //   115: astore #5
    //   117: iload_0
    //   118: istore_1
    //   119: aload #10
    //   121: iload_2
    //   122: aaload
    //   123: ldc '.'
    //   125: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   128: ifne -> 426
    //   131: aload #4
    //   133: astore #5
    //   135: iload_0
    //   136: istore_1
    //   137: aload #10
    //   139: iload_2
    //   140: aaload
    //   141: ldc '.log'
    //   143: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   146: ifeq -> 426
    //   149: new java/io/File
    //   152: dup
    //   153: aload #9
    //   155: aload #10
    //   157: iload_2
    //   158: aaload
    //   159: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   162: astore #11
    //   164: aload #10
    //   166: iload_2
    //   167: aaload
    //   168: ldc '.log'
    //   170: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   173: istore_3
    //   174: iload_0
    //   175: istore_1
    //   176: iload_3
    //   177: ifeq -> 257
    //   180: aload #7
    //   182: aload #10
    //   184: iload_2
    //   185: aaload
    //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload #7
    //   192: ldc '<br>'
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload #7
    //   200: aload #11
    //   202: invokestatic m : (Ljava/io/File;)Ljava/lang/String;
    //   205: ldc '\\n'
    //   207: ldc '<br>'
    //   209: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload #7
    //   218: ldc '<br>'
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload #7
    //   226: ldc '<br>'
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload #7
    //   234: ldc '<br>'
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: iload_0
    //   241: iconst_1
    //   242: iadd
    //   243: istore_1
    //   244: goto -> 257
    //   247: astore #5
    //   249: aload #5
    //   251: invokestatic e : (Ljava/lang/Throwable;)V
    //   254: goto -> 315
    //   257: aload #4
    //   259: astore #5
    //   261: aload #4
    //   263: ifnonnull -> 301
    //   266: aload #10
    //   268: iload_2
    //   269: aaload
    //   270: ldc '-shop'
    //   272: invokevirtual indexOf : (Ljava/lang/String;)I
    //   275: istore_0
    //   276: aload #10
    //   278: iload_2
    //   279: aaload
    //   280: iconst_0
    //   281: iload_0
    //   282: invokevirtual substring : (II)Ljava/lang/String;
    //   285: astore #5
    //   287: goto -> 301
    //   290: astore #5
    //   292: aload #5
    //   294: invokestatic e : (Ljava/lang/Throwable;)V
    //   297: aload #4
    //   299: astore #5
    //   301: aload #8
    //   303: aload #11
    //   305: invokevirtual getPath : ()Ljava/lang/String;
    //   308: invokevirtual add : (Ljava/lang/Object;)Z
    //   311: pop
    //   312: goto -> 426
    //   315: aload #8
    //   317: invokevirtual isEmpty : ()Z
    //   320: ifne -> 416
    //   323: aload #4
    //   325: ifnull -> 439
    //   328: aload #4
    //   330: astore #5
    //   332: aload #4
    //   334: invokevirtual length : ()I
    //   337: ifne -> 343
    //   340: goto -> 439
    //   343: new java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial <init> : ()V
    //   350: astore #4
    //   352: aload #4
    //   354: aload #5
    //   356: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload #4
    //   362: ldc '-crash数量：'
    //   364: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload #4
    //   370: iload_0
    //   371: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: new com/laiqian/util/logger/d
    //   378: dup
    //   379: aload #4
    //   381: invokevirtual toString : ()Ljava/lang/String;
    //   384: aload #7
    //   386: invokevirtual toString : ()Ljava/lang/String;
    //   389: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   392: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   395: getstatic com/laiqian/util/logger/h$b.dHB : Lcom/laiqian/util/logger/h$b;
    //   398: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   401: goto -> 416
    //   404: astore #4
    //   406: goto -> 420
    //   409: astore #4
    //   411: aload #4
    //   413: invokestatic e : (Ljava/lang/Throwable;)V
    //   416: aload #6
    //   418: monitorexit
    //   419: return
    //   420: aload #6
    //   422: monitorexit
    //   423: aload #4
    //   425: athrow
    //   426: iload_2
    //   427: iconst_1
    //   428: iadd
    //   429: istore_2
    //   430: aload #5
    //   432: astore #4
    //   434: iload_1
    //   435: istore_0
    //   436: goto -> 75
    //   439: ldc '未知账号'
    //   441: astore #5
    //   443: goto -> 343
    // Exception table:
    //   from	to	target	type
    //   8	41	409	java/lang/Exception
    //   8	41	404	finally
    //   46	49	404	finally
    //   50	68	409	java/lang/Exception
    //   50	68	404	finally
    //   75	91	409	java/lang/Exception
    //   75	91	404	finally
    //   119	131	409	java/lang/Exception
    //   119	131	404	finally
    //   137	174	409	java/lang/Exception
    //   137	174	404	finally
    //   180	240	247	java/lang/Throwable
    //   180	240	409	java/lang/Exception
    //   180	240	404	finally
    //   249	254	409	java/lang/Exception
    //   249	254	404	finally
    //   266	276	409	java/lang/Exception
    //   266	276	404	finally
    //   276	287	290	java/lang/Exception
    //   276	287	404	finally
    //   292	297	409	java/lang/Exception
    //   292	297	404	finally
    //   301	312	409	java/lang/Exception
    //   301	312	404	finally
    //   315	323	409	java/lang/Exception
    //   315	323	404	finally
    //   332	340	409	java/lang/Exception
    //   332	340	404	finally
    //   343	401	409	java/lang/Exception
    //   343	401	404	finally
    //   411	416	404	finally
    //   416	419	404	finally
    //   420	423	404	finally }
  
  public static void asF() {
    try {
      a.AZ().Ba();
    } catch (Exception exception) {
      a.e(exception);
    } 
    b.ckg.b(b.ckg.aan());
    CrashApplication.zv().sendBroadcast(new Intent("pos_activity_change_data_all"));
  }
  
  public static void bO(@Nullable Context paramContext) {
    a.aKh().r(q.baQ);
    asF();
  }
  
  public static Class bP(Context paramContext) { return CrashApplication.aMW; }
  
  public static double bg(double paramDouble) {
    int i = (int)(paramDouble * 100.0D + 0.50001D) % 5;
    if (i >= 3) {
      i = 5 - i;
    } else {
      i = -i;
    } 
    return i / 100.0D;
  }
  
  public static double py(String paramString) {
    double d2 = 0.0D;
    double d1 = d2;
    try {
      StatFs statFs = new StatFs(paramString);
      d1 = d2;
      long l = statFs.getBlockSize();
      d1 = d2;
      d2 = (statFs.getAvailableBlocks() * l / 1024L);
      d1 = d2;
      StringBuilder stringBuilder = new StringBuilder();
      d1 = d2;
      stringBuilder.append(d2);
      d1 = d2;
      stringBuilder.append("K");
      d1 = d2;
      bb.e("存储器剩余大小", stringBuilder.toString());
      return d2;
    } catch (Exception paramString) {
      a.e(paramString);
      return d1;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */