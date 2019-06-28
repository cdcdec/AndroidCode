package com.laiqian.sync.c;

import hugo.weaving.DebugLog;

public class c {
  static boolean finished = false;
  
  static  {
  
  }
  
  @DebugLog
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean) throws Exception { // Byte code:
    //   0: aload_2
    //   1: ifnull -> 16
    //   4: aload_2
    //   5: astore #7
    //   7: aload_2
    //   8: ldc ''
    //   10: invokevirtual equals : (Ljava/lang/Object;)Z
    //   13: ifeq -> 30
    //   16: aload_0
    //   17: aload_0
    //   18: ldc '/'
    //   20: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   23: iconst_1
    //   24: iadd
    //   25: invokevirtual substring : (I)Ljava/lang/String;
    //   28: astore #7
    //   30: new java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: astore_2
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: aload #7
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: ldc '.encrypt'
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_2
    //   59: invokevirtual toString : ()Ljava/lang/String;
    //   62: astore #9
    //   64: iconst_0
    //   65: putstatic com/laiqian/sync/c/c.finished : Z
    //   68: new java/net/URL
    //   71: dup
    //   72: aload_0
    //   73: invokespecial <init> : (Ljava/lang/String;)V
    //   76: astore #8
    //   78: aconst_null
    //   79: astore_2
    //   80: aload_0
    //   81: invokestatic iI : (Ljava/lang/String;)Z
    //   84: ifne -> 101
    //   87: invokestatic Js : ()Lcom/alibaba/a/a/b/c;
    //   90: aload #8
    //   92: invokevirtual getHost : ()Ljava/lang/String;
    //   95: invokeinterface I : (Ljava/lang/String;)Ljava/lang/String;
    //   100: astore_2
    //   101: aload_2
    //   102: ifnull -> 219
    //   105: aload #8
    //   107: invokevirtual getHost : ()Ljava/lang/String;
    //   110: astore #8
    //   112: new java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial <init> : ()V
    //   119: astore #10
    //   121: aload #10
    //   123: ldc 'Get IP: '
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload #10
    //   131: aload_2
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload #10
    //   138: ldc ' for host: '
    //   140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload #10
    //   146: aload #8
    //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload #10
    //   154: ldc ' for url:'
    //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload #10
    //   162: aload_0
    //   163: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload #10
    //   169: ldc ' from HTTPDNS successfully!'
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: ldc 'fileHttpDownloader'
    //   177: aload #10
    //   179: invokevirtual toString : ()Ljava/lang/String;
    //   182: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   185: pop
    //   186: aload_0
    //   187: aload #8
    //   189: aload_2
    //   190: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: astore_2
    //   194: new b/ae$a
    //   197: dup
    //   198: invokespecial <init> : ()V
    //   201: aload_2
    //   202: invokevirtual uS : (Ljava/lang/String;)Lb/ae$a;
    //   205: ldc 'Host'
    //   207: aload #8
    //   209: invokevirtual bZ : (Ljava/lang/String;Ljava/lang/String;)Lb/ae$a;
    //   212: invokevirtual aSZ : ()Lb/ae;
    //   215: astore_0
    //   216: goto -> 240
    //   219: new b/ae$a
    //   222: dup
    //   223: invokespecial <init> : ()V
    //   226: aload_0
    //   227: invokevirtual uS : (Ljava/lang/String;)Lb/ae$a;
    //   230: invokevirtual aSZ : ()Lb/ae;
    //   233: astore #8
    //   235: aload_0
    //   236: astore_2
    //   237: aload #8
    //   239: astore_0
    //   240: new java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial <init> : ()V
    //   247: astore #8
    //   249: aload #8
    //   251: ldc 'actual url: '
    //   253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload #8
    //   259: aload_2
    //   260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 'fileHttpDownloader'
    //   266: aload #8
    //   268: invokevirtual toString : ()Ljava/lang/String;
    //   271: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   274: pop
    //   275: getstatic com/laiqian/network/j.adg : Lb/aa;
    //   278: aload_0
    //   279: invokevirtual a : (Lb/ae;)Lb/f;
    //   282: invokeinterface aRI : ()Lb/aj;
    //   287: astore_0
    //   288: aload_0
    //   289: invokevirtual aTa : ()Z
    //   292: ifne -> 335
    //   295: new java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial <init> : ()V
    //   302: astore_1
    //   303: aload_1
    //   304: ldc 'downFile: response is '
    //   306: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_1
    //   311: aload_0
    //   312: invokevirtual toString : ()Ljava/lang/String;
    //   315: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: ldc 'fileHttpDownloader'
    //   321: aload_1
    //   322: invokevirtual toString : ()Ljava/lang/String;
    //   325: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   328: pop
    //   329: aload_0
    //   330: invokevirtual close : ()V
    //   333: iconst_0
    //   334: ireturn
    //   335: new java/io/File
    //   338: dup
    //   339: aload #9
    //   341: invokespecial <init> : (Ljava/lang/String;)V
    //   344: astore_2
    //   345: aload_2
    //   346: invokestatic U : (Ljava/io/File;)Lc/y;
    //   349: astore #8
    //   351: aload_0
    //   352: invokevirtual aTc : ()Lb/ak;
    //   355: invokevirtual aTj : ()Lc/h;
    //   358: aload #8
    //   360: invokeinterface b : (Lc/y;)J
    //   365: pop2
    //   366: aload #8
    //   368: invokeinterface flush : ()V
    //   373: aload #8
    //   375: invokeinterface close : ()V
    //   380: aload_0
    //   381: invokevirtual close : ()V
    //   384: aload_2
    //   385: invokevirtual exists : ()Z
    //   388: ifne -> 393
    //   391: iconst_0
    //   392: ireturn
    //   393: new java/io/FileInputStream
    //   396: dup
    //   397: aload_2
    //   398: invokespecial <init> : (Ljava/io/File;)V
    //   401: astore_0
    //   402: new java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial <init> : ()V
    //   409: astore_2
    //   410: aload_2
    //   411: aload_1
    //   412: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_2
    //   417: aload #7
    //   419: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: new java/io/FileOutputStream
    //   426: dup
    //   427: aload_2
    //   428: invokevirtual toString : ()Ljava/lang/String;
    //   431: invokespecial <init> : (Ljava/lang/String;)V
    //   434: astore_1
    //   435: iload #5
    //   437: ifeq -> 452
    //   440: aload_0
    //   441: aload_1
    //   442: aload_3
    //   443: aload #4
    //   445: invokestatic D : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   448: invokestatic a : (Ljava/io/InputStream;Ljava/io/FileOutputStream;Ljava/lang/String;)Z
    //   451: pop
    //   452: sipush #1024
    //   455: newarray byte
    //   457: astore_2
    //   458: aload_0
    //   459: aload_2
    //   460: invokevirtual read : ([B)I
    //   463: istore #6
    //   465: iload #6
    //   467: iconst_m1
    //   468: if_icmpeq -> 482
    //   471: aload_1
    //   472: aload_2
    //   473: iconst_0
    //   474: iload #6
    //   476: invokevirtual write : ([BII)V
    //   479: goto -> 458
    //   482: aload_1
    //   483: invokevirtual close : ()V
    //   486: aload_0
    //   487: invokevirtual close : ()V
    //   490: iconst_1
    //   491: ireturn
    //   492: astore_0
    //   493: aload_0
    //   494: invokestatic e : (Ljava/lang/Throwable;)V
    //   497: iconst_0
    //   498: ireturn
    // Exception table:
    //   from	to	target	type
    //   486	490	492	java/lang/Exception }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */