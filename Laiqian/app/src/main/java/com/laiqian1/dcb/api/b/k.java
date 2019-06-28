package com.laiqian.dcb.api.b;

import android.content.Context;
import java.io.File;

public class k {
  public static int aQe = 0;
  
  public static int aQf = 1;
  
  public static int aQg = 2;
  
  private static String aQi = "laiqian.db";
  
  public File aQd;
  
  public boolean aQh;
  
  static  {
  
  }
  
  public k(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield aQd : Ljava/io/File;
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield aQh : Z
    //   14: iload #5
    //   16: getstatic com/laiqian/dcb/api/b/k.aQe : I
    //   19: if_icmpne -> 144
    //   22: new java/io/FileInputStream
    //   25: dup
    //   26: aload_2
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: astore_1
    //   31: new java/util/zip/ZipOutputStream
    //   34: dup
    //   35: new java/io/BufferedOutputStream
    //   38: dup
    //   39: new java/io/FileOutputStream
    //   42: dup
    //   43: aload_3
    //   44: invokespecial <init> : (Ljava/lang/String;)V
    //   47: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   50: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   53: astore #7
    //   55: aload #7
    //   57: new java/util/zip/ZipEntry
    //   60: dup
    //   61: aload_2
    //   62: aload_2
    //   63: ldc '/'
    //   65: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   68: iconst_1
    //   69: iadd
    //   70: invokevirtual substring : (I)Ljava/lang/String;
    //   73: invokespecial <init> : (Ljava/lang/String;)V
    //   76: invokevirtual putNextEntry : (Ljava/util/zip/ZipEntry;)V
    //   79: sipush #8192
    //   82: newarray byte
    //   84: astore #8
    //   86: aload_1
    //   87: aload #8
    //   89: invokevirtual read : ([B)I
    //   92: istore #6
    //   94: iload #6
    //   96: ifle -> 112
    //   99: aload #7
    //   101: aload #8
    //   103: iconst_0
    //   104: iload #6
    //   106: invokevirtual write : ([BII)V
    //   109: goto -> 86
    //   112: aload #7
    //   114: invokevirtual closeEntry : ()V
    //   117: aload #7
    //   119: invokevirtual close : ()V
    //   122: aload_1
    //   123: invokevirtual close : ()V
    //   126: aload_0
    //   127: iconst_1
    //   128: putfield aQh : Z
    //   131: goto -> 144
    //   134: astore_1
    //   135: aload_0
    //   136: iconst_0
    //   137: putfield aQh : Z
    //   140: aload_1
    //   141: invokestatic e : (Ljava/lang/Throwable;)V
    //   144: iload #5
    //   146: getstatic com/laiqian/dcb/api/b/k.aQf : I
    //   149: if_icmpne -> 676
    //   152: new java/io/FileInputStream
    //   155: dup
    //   156: aload_2
    //   157: invokespecial <init> : (Ljava/lang/String;)V
    //   160: astore_1
    //   161: new java/util/zip/ZipInputStream
    //   164: dup
    //   165: new java/io/BufferedInputStream
    //   168: dup
    //   169: aload_1
    //   170: invokespecial <init> : (Ljava/io/InputStream;)V
    //   173: invokespecial <init> : (Ljava/io/InputStream;)V
    //   176: astore #7
    //   178: new java/io/FileOutputStream
    //   181: dup
    //   182: aload_3
    //   183: invokespecial <init> : (Ljava/lang/String;)V
    //   186: astore #11
    //   188: aload_1
    //   189: astore #8
    //   191: aload #7
    //   193: astore #9
    //   195: aload #11
    //   197: astore #10
    //   199: aload #7
    //   201: invokevirtual getNextEntry : ()Ljava/util/zip/ZipEntry;
    //   204: astore #12
    //   206: aload #12
    //   208: ifnonnull -> 262
    //   211: aload #7
    //   213: ifnull -> 231
    //   216: aload #7
    //   218: invokevirtual close : ()V
    //   221: goto -> 231
    //   224: astore #4
    //   226: aload #4
    //   228: invokestatic e : (Ljava/lang/Throwable;)V
    //   231: aload #11
    //   233: ifnull -> 251
    //   236: aload #11
    //   238: invokevirtual close : ()V
    //   241: goto -> 251
    //   244: astore #4
    //   246: aload #4
    //   248: invokestatic e : (Ljava/lang/Throwable;)V
    //   251: aload_1
    //   252: ifnull -> 676
    //   255: aload_1
    //   256: invokevirtual close : ()V
    //   259: goto -> 676
    //   262: aload_1
    //   263: astore #8
    //   265: aload #7
    //   267: astore #9
    //   269: aload #11
    //   271: astore #10
    //   273: aload #12
    //   275: invokevirtual getName : ()Ljava/lang/String;
    //   278: astore #12
    //   280: aload_1
    //   281: astore #8
    //   283: aload #7
    //   285: astore #9
    //   287: aload #11
    //   289: astore #10
    //   291: new java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial <init> : ()V
    //   298: astore #13
    //   300: aload_1
    //   301: astore #8
    //   303: aload #7
    //   305: astore #9
    //   307: aload #11
    //   309: astore #10
    //   311: aload #13
    //   313: ldc '.'
    //   315: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_1
    //   320: astore #8
    //   322: aload #7
    //   324: astore #9
    //   326: aload #11
    //   328: astore #10
    //   330: aload #13
    //   332: aload #4
    //   334: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_1
    //   339: astore #8
    //   341: aload #7
    //   343: astore #9
    //   345: aload #11
    //   347: astore #10
    //   349: aload #12
    //   351: aload #13
    //   353: invokevirtual toString : ()Ljava/lang/String;
    //   356: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   359: ifeq -> 188
    //   362: aload_1
    //   363: astore #8
    //   365: aload #7
    //   367: astore #9
    //   369: aload #11
    //   371: astore #10
    //   373: sipush #8192
    //   376: newarray byte
    //   378: astore #12
    //   380: aload_1
    //   381: astore #8
    //   383: aload #7
    //   385: astore #9
    //   387: aload #11
    //   389: astore #10
    //   391: aload #7
    //   393: aload #12
    //   395: invokevirtual read : ([B)I
    //   398: istore #6
    //   400: iload #6
    //   402: iconst_m1
    //   403: if_icmpeq -> 430
    //   406: aload_1
    //   407: astore #8
    //   409: aload #7
    //   411: astore #9
    //   413: aload #11
    //   415: astore #10
    //   417: aload #11
    //   419: aload #12
    //   421: iconst_0
    //   422: iload #6
    //   424: invokevirtual write : ([BII)V
    //   427: goto -> 380
    //   430: aload_1
    //   431: astore #8
    //   433: aload #7
    //   435: astore #9
    //   437: aload #11
    //   439: astore #10
    //   441: aload_0
    //   442: iconst_1
    //   443: putfield aQh : Z
    //   446: goto -> 188
    //   449: astore #8
    //   451: aload #11
    //   453: astore #4
    //   455: aload #8
    //   457: astore #11
    //   459: goto -> 523
    //   462: astore_3
    //   463: aconst_null
    //   464: astore #4
    //   466: aload_1
    //   467: astore_2
    //   468: aload #4
    //   470: astore_1
    //   471: goto -> 501
    //   474: astore #8
    //   476: aconst_null
    //   477: astore #4
    //   479: goto -> 519
    //   482: astore_3
    //   483: aload_1
    //   484: astore_2
    //   485: goto -> 496
    //   488: astore #8
    //   490: goto -> 513
    //   493: astore_3
    //   494: aconst_null
    //   495: astore_2
    //   496: aconst_null
    //   497: astore #7
    //   499: aconst_null
    //   500: astore_1
    //   501: aload_1
    //   502: astore #10
    //   504: aload_3
    //   505: astore_1
    //   506: goto -> 622
    //   509: astore #8
    //   511: aconst_null
    //   512: astore_1
    //   513: aconst_null
    //   514: astore #7
    //   516: aconst_null
    //   517: astore #4
    //   519: aload #8
    //   521: astore #11
    //   523: aload_1
    //   524: astore #8
    //   526: aload #7
    //   528: astore #9
    //   530: aload #4
    //   532: astore #10
    //   534: aload_0
    //   535: iconst_0
    //   536: putfield aQh : Z
    //   539: aload_1
    //   540: astore #8
    //   542: aload #7
    //   544: astore #9
    //   546: aload #4
    //   548: astore #10
    //   550: aload #11
    //   552: invokestatic e : (Ljava/lang/Throwable;)V
    //   555: aload #7
    //   557: ifnull -> 575
    //   560: aload #7
    //   562: invokevirtual close : ()V
    //   565: goto -> 575
    //   568: astore #7
    //   570: aload #7
    //   572: invokestatic e : (Ljava/lang/Throwable;)V
    //   575: aload #4
    //   577: ifnull -> 595
    //   580: aload #4
    //   582: invokevirtual close : ()V
    //   585: goto -> 595
    //   588: astore #4
    //   590: aload #4
    //   592: invokestatic e : (Ljava/lang/Throwable;)V
    //   595: aload_1
    //   596: ifnull -> 676
    //   599: aload_1
    //   600: invokevirtual close : ()V
    //   603: goto -> 676
    //   606: astore_1
    //   607: aload_1
    //   608: invokestatic e : (Ljava/lang/Throwable;)V
    //   611: goto -> 676
    //   614: astore_1
    //   615: aload #9
    //   617: astore #7
    //   619: aload #8
    //   621: astore_2
    //   622: aload #7
    //   624: ifnull -> 640
    //   627: aload #7
    //   629: invokevirtual close : ()V
    //   632: goto -> 640
    //   635: astore_3
    //   636: aload_3
    //   637: invokestatic e : (Ljava/lang/Throwable;)V
    //   640: aload #10
    //   642: ifnull -> 658
    //   645: aload #10
    //   647: invokevirtual close : ()V
    //   650: goto -> 658
    //   653: astore_3
    //   654: aload_3
    //   655: invokestatic e : (Ljava/lang/Throwable;)V
    //   658: aload_2
    //   659: ifnull -> 674
    //   662: aload_2
    //   663: invokevirtual close : ()V
    //   666: goto -> 674
    //   669: astore_2
    //   670: aload_2
    //   671: invokestatic e : (Ljava/lang/Throwable;)V
    //   674: aload_1
    //   675: athrow
    //   676: iload #5
    //   678: getstatic com/laiqian/dcb/api/b/k.aQg : I
    //   681: if_icmpne -> 787
    //   684: new java/io/FileInputStream
    //   687: dup
    //   688: aload_2
    //   689: invokespecial <init> : (Ljava/lang/String;)V
    //   692: astore_1
    //   693: new java/util/zip/ZipOutputStream
    //   696: dup
    //   697: new java/io/BufferedOutputStream
    //   700: dup
    //   701: new java/io/FileOutputStream
    //   704: dup
    //   705: aload_3
    //   706: invokespecial <init> : (Ljava/lang/String;)V
    //   709: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   712: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   715: astore_2
    //   716: aload_2
    //   717: new java/util/zip/ZipEntry
    //   720: dup
    //   721: getstatic com/laiqian/dcb/api/b/k.aQi : Ljava/lang/String;
    //   724: invokespecial <init> : (Ljava/lang/String;)V
    //   727: invokevirtual putNextEntry : (Ljava/util/zip/ZipEntry;)V
    //   730: sipush #8192
    //   733: newarray byte
    //   735: astore_3
    //   736: aload_1
    //   737: aload_3
    //   738: invokevirtual read : ([B)I
    //   741: istore #5
    //   743: iload #5
    //   745: ifle -> 759
    //   748: aload_2
    //   749: aload_3
    //   750: iconst_0
    //   751: iload #5
    //   753: invokevirtual write : ([BII)V
    //   756: goto -> 736
    //   759: aload_2
    //   760: invokevirtual closeEntry : ()V
    //   763: aload_2
    //   764: invokevirtual close : ()V
    //   767: aload_1
    //   768: invokevirtual close : ()V
    //   771: aload_0
    //   772: iconst_1
    //   773: putfield aQh : Z
    //   776: return
    //   777: astore_1
    //   778: aload_0
    //   779: iconst_0
    //   780: putfield aQh : Z
    //   783: aload_1
    //   784: invokestatic e : (Ljava/lang/Throwable;)V
    //   787: return
    // Exception table:
    //   from	to	target	type
    //   22	86	134	java/lang/Exception
    //   86	94	134	java/lang/Exception
    //   99	109	134	java/lang/Exception
    //   112	131	134	java/lang/Exception
    //   152	161	509	java/lang/Exception
    //   152	161	493	finally
    //   161	178	488	java/lang/Exception
    //   161	178	482	finally
    //   178	188	474	java/lang/Exception
    //   178	188	462	finally
    //   199	206	449	java/lang/Exception
    //   199	206	614	finally
    //   216	221	224	java/io/IOException
    //   236	241	244	java/io/IOException
    //   255	259	606	java/io/IOException
    //   273	280	449	java/lang/Exception
    //   273	280	614	finally
    //   291	300	449	java/lang/Exception
    //   291	300	614	finally
    //   311	319	449	java/lang/Exception
    //   311	319	614	finally
    //   330	338	449	java/lang/Exception
    //   330	338	614	finally
    //   349	362	449	java/lang/Exception
    //   349	362	614	finally
    //   373	380	449	java/lang/Exception
    //   373	380	614	finally
    //   391	400	449	java/lang/Exception
    //   391	400	614	finally
    //   417	427	449	java/lang/Exception
    //   417	427	614	finally
    //   441	446	449	java/lang/Exception
    //   441	446	614	finally
    //   534	539	614	finally
    //   550	555	614	finally
    //   560	565	568	java/io/IOException
    //   580	585	588	java/io/IOException
    //   599	603	606	java/io/IOException
    //   627	632	635	java/io/IOException
    //   645	650	653	java/io/IOException
    //   662	666	669	java/io/IOException
    //   684	736	777	java/lang/Exception
    //   736	743	777	java/lang/Exception
    //   748	756	777	java/lang/Exception
    //   759	776	777	java/lang/Exception }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */