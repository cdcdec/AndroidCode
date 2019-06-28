package com.laiqian.sync.c;

import android.content.Context;
import hugo.weaving.DebugLog;
import java.io.File;

public class b {
  public static int aQe = 0;
  
  public static int aQf = 1;
  
  public static int aQg = 2;
  
  private static String aQi = "laiqian.db";
  
  public File aQd;
  
  public boolean aQh;
  
  static  {
  
  }
  
  @DebugLog
  public b(Context paramContext, String paramString1, String paramString2, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aconst_null
    //   5: astore #6
    //   7: aconst_null
    //   8: astore #7
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield aQd : Ljava/io/File;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield aQh : Z
    //   20: aload_0
    //   21: aload_3
    //   22: invokespecial gI : (Ljava/lang/String;)V
    //   25: iload #4
    //   27: getstatic com/laiqian/sync/c/b.aQe : I
    //   30: if_icmpne -> 155
    //   33: new java/io/FileInputStream
    //   36: dup
    //   37: aload_2
    //   38: invokespecial <init> : (Ljava/lang/String;)V
    //   41: astore_1
    //   42: new java/util/zip/ZipOutputStream
    //   45: dup
    //   46: new java/io/BufferedOutputStream
    //   49: dup
    //   50: new java/io/FileOutputStream
    //   53: dup
    //   54: aload_3
    //   55: invokespecial <init> : (Ljava/lang/String;)V
    //   58: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   61: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   64: astore #8
    //   66: aload #8
    //   68: new java/util/zip/ZipEntry
    //   71: dup
    //   72: aload_2
    //   73: aload_2
    //   74: ldc '/'
    //   76: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   79: iconst_1
    //   80: iadd
    //   81: invokevirtual substring : (I)Ljava/lang/String;
    //   84: invokespecial <init> : (Ljava/lang/String;)V
    //   87: invokevirtual putNextEntry : (Ljava/util/zip/ZipEntry;)V
    //   90: sipush #8192
    //   93: newarray byte
    //   95: astore #9
    //   97: aload_1
    //   98: aload #9
    //   100: invokevirtual read : ([B)I
    //   103: istore #5
    //   105: iload #5
    //   107: ifle -> 123
    //   110: aload #8
    //   112: aload #9
    //   114: iconst_0
    //   115: iload #5
    //   117: invokevirtual write : ([BII)V
    //   120: goto -> 97
    //   123: aload #8
    //   125: invokevirtual closeEntry : ()V
    //   128: aload #8
    //   130: invokevirtual close : ()V
    //   133: aload_1
    //   134: invokevirtual close : ()V
    //   137: aload_0
    //   138: iconst_1
    //   139: putfield aQh : Z
    //   142: goto -> 155
    //   145: astore_1
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield aQh : Z
    //   151: aload_1
    //   152: invokestatic e : (Ljava/lang/Throwable;)V
    //   155: iload #4
    //   157: getstatic com/laiqian/sync/c/b.aQf : I
    //   160: if_icmpne -> 570
    //   163: new java/io/FileInputStream
    //   166: dup
    //   167: aload_2
    //   168: invokespecial <init> : (Ljava/lang/String;)V
    //   171: astore #8
    //   173: aload #8
    //   175: invokevirtual available : ()I
    //   178: istore #5
    //   180: new java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial <init> : ()V
    //   187: astore_1
    //   188: aload_1
    //   189: ldc 'file: '
    //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_1
    //   196: aload_2
    //   197: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_1
    //   202: ldc ', available: '
    //   204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_1
    //   209: iload #5
    //   211: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: ldc 'compressionOperator'
    //   217: aload_1
    //   218: invokevirtual toString : ()Ljava/lang/String;
    //   221: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   224: pop
    //   225: new java/util/zip/ZipInputStream
    //   228: dup
    //   229: new java/io/BufferedInputStream
    //   232: dup
    //   233: aload #8
    //   235: invokespecial <init> : (Ljava/io/InputStream;)V
    //   238: invokespecial <init> : (Ljava/io/InputStream;)V
    //   241: astore_1
    //   242: new java/io/FileOutputStream
    //   245: dup
    //   246: aload_3
    //   247: invokespecial <init> : (Ljava/lang/String;)V
    //   250: astore #7
    //   252: aload_1
    //   253: invokevirtual getNextEntry : ()Ljava/util/zip/ZipEntry;
    //   256: astore #6
    //   258: aload #6
    //   260: ifnull -> 316
    //   263: aload #6
    //   265: invokevirtual getName : ()Ljava/lang/String;
    //   268: pop
    //   269: sipush #8192
    //   272: newarray byte
    //   274: astore #6
    //   276: aload_1
    //   277: aload #6
    //   279: invokevirtual read : ([B)I
    //   282: istore #5
    //   284: iload #5
    //   286: iconst_m1
    //   287: if_icmpeq -> 308
    //   290: iload #5
    //   292: ifeq -> 308
    //   295: aload #7
    //   297: aload #6
    //   299: iconst_0
    //   300: iload #5
    //   302: invokevirtual write : ([BII)V
    //   305: goto -> 276
    //   308: aload_0
    //   309: iconst_1
    //   310: putfield aQh : Z
    //   313: goto -> 252
    //   316: aload_1
    //   317: ifnull -> 332
    //   320: aload_1
    //   321: invokevirtual close : ()V
    //   324: goto -> 332
    //   327: astore_1
    //   328: aload_1
    //   329: invokestatic e : (Ljava/lang/Throwable;)V
    //   332: aload #7
    //   334: ifnull -> 350
    //   337: aload #7
    //   339: invokevirtual close : ()V
    //   342: goto -> 350
    //   345: astore_1
    //   346: aload_1
    //   347: invokestatic e : (Ljava/lang/Throwable;)V
    //   350: aload #8
    //   352: ifnull -> 570
    //   355: aload #8
    //   357: invokevirtual close : ()V
    //   360: goto -> 570
    //   363: astore_2
    //   364: aload #7
    //   366: astore_3
    //   367: goto -> 388
    //   370: astore #6
    //   372: aload_1
    //   373: astore #9
    //   375: aload #7
    //   377: astore_1
    //   378: aload #9
    //   380: astore #7
    //   382: goto -> 448
    //   385: astore_2
    //   386: aconst_null
    //   387: astore_3
    //   388: aload_1
    //   389: astore #7
    //   391: aload_3
    //   392: astore_1
    //   393: goto -> 516
    //   396: astore #6
    //   398: aconst_null
    //   399: astore #9
    //   401: aload_1
    //   402: astore #7
    //   404: aload #9
    //   406: astore_1
    //   407: goto -> 448
    //   410: astore_2
    //   411: aconst_null
    //   412: astore_1
    //   413: aload #6
    //   415: astore #7
    //   417: goto -> 516
    //   420: astore #6
    //   422: aconst_null
    //   423: astore_1
    //   424: goto -> 448
    //   427: astore_2
    //   428: aconst_null
    //   429: astore #8
    //   431: aload #8
    //   433: astore_1
    //   434: aload #6
    //   436: astore #7
    //   438: goto -> 516
    //   441: astore #6
    //   443: aconst_null
    //   444: astore_1
    //   445: aload_1
    //   446: astore #8
    //   448: aload_0
    //   449: iconst_0
    //   450: putfield aQh : Z
    //   453: aload #6
    //   455: invokestatic e : (Ljava/lang/Throwable;)V
    //   458: aload #7
    //   460: ifnull -> 478
    //   463: aload #7
    //   465: invokevirtual close : ()V
    //   468: goto -> 478
    //   471: astore #6
    //   473: aload #6
    //   475: invokestatic e : (Ljava/lang/Throwable;)V
    //   478: aload_1
    //   479: ifnull -> 494
    //   482: aload_1
    //   483: invokevirtual close : ()V
    //   486: goto -> 494
    //   489: astore_1
    //   490: aload_1
    //   491: invokestatic e : (Ljava/lang/Throwable;)V
    //   494: aload #8
    //   496: ifnull -> 570
    //   499: aload #8
    //   501: invokevirtual close : ()V
    //   504: goto -> 570
    //   507: astore_1
    //   508: aload_1
    //   509: invokestatic e : (Ljava/lang/Throwable;)V
    //   512: goto -> 570
    //   515: astore_2
    //   516: aload #7
    //   518: ifnull -> 534
    //   521: aload #7
    //   523: invokevirtual close : ()V
    //   526: goto -> 534
    //   529: astore_3
    //   530: aload_3
    //   531: invokestatic e : (Ljava/lang/Throwable;)V
    //   534: aload_1
    //   535: ifnull -> 550
    //   538: aload_1
    //   539: invokevirtual close : ()V
    //   542: goto -> 550
    //   545: astore_1
    //   546: aload_1
    //   547: invokestatic e : (Ljava/lang/Throwable;)V
    //   550: aload #8
    //   552: ifnull -> 568
    //   555: aload #8
    //   557: invokevirtual close : ()V
    //   560: goto -> 568
    //   563: astore_1
    //   564: aload_1
    //   565: invokestatic e : (Ljava/lang/Throwable;)V
    //   568: aload_2
    //   569: athrow
    //   570: iload #4
    //   572: getstatic com/laiqian/sync/c/b.aQg : I
    //   575: if_icmpne -> 681
    //   578: new java/io/FileInputStream
    //   581: dup
    //   582: aload_2
    //   583: invokespecial <init> : (Ljava/lang/String;)V
    //   586: astore_1
    //   587: new java/util/zip/ZipOutputStream
    //   590: dup
    //   591: new java/io/BufferedOutputStream
    //   594: dup
    //   595: new java/io/FileOutputStream
    //   598: dup
    //   599: aload_3
    //   600: invokespecial <init> : (Ljava/lang/String;)V
    //   603: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   606: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   609: astore_2
    //   610: aload_2
    //   611: new java/util/zip/ZipEntry
    //   614: dup
    //   615: getstatic com/laiqian/sync/c/b.aQi : Ljava/lang/String;
    //   618: invokespecial <init> : (Ljava/lang/String;)V
    //   621: invokevirtual putNextEntry : (Ljava/util/zip/ZipEntry;)V
    //   624: sipush #8192
    //   627: newarray byte
    //   629: astore_3
    //   630: aload_1
    //   631: aload_3
    //   632: invokevirtual read : ([B)I
    //   635: istore #4
    //   637: iload #4
    //   639: ifle -> 653
    //   642: aload_2
    //   643: aload_3
    //   644: iconst_0
    //   645: iload #4
    //   647: invokevirtual write : ([BII)V
    //   650: goto -> 630
    //   653: aload_2
    //   654: invokevirtual closeEntry : ()V
    //   657: aload_2
    //   658: invokevirtual close : ()V
    //   661: aload_1
    //   662: invokevirtual close : ()V
    //   665: aload_0
    //   666: iconst_1
    //   667: putfield aQh : Z
    //   670: return
    //   671: astore_1
    //   672: aload_0
    //   673: iconst_0
    //   674: putfield aQh : Z
    //   677: aload_1
    //   678: invokestatic e : (Ljava/lang/Throwable;)V
    //   681: return
    // Exception table:
    //   from	to	target	type
    //   33	97	145	java/lang/Exception
    //   97	105	145	java/lang/Exception
    //   110	120	145	java/lang/Exception
    //   123	142	145	java/lang/Exception
    //   163	173	441	java/lang/Exception
    //   163	173	427	finally
    //   173	242	420	java/lang/Exception
    //   173	242	410	finally
    //   242	252	396	java/lang/Exception
    //   242	252	385	finally
    //   252	258	370	java/lang/Exception
    //   252	258	363	finally
    //   263	276	370	java/lang/Exception
    //   263	276	363	finally
    //   276	284	370	java/lang/Exception
    //   276	284	363	finally
    //   295	305	370	java/lang/Exception
    //   295	305	363	finally
    //   308	313	370	java/lang/Exception
    //   308	313	363	finally
    //   320	324	327	java/io/IOException
    //   337	342	345	java/io/IOException
    //   355	360	507	java/io/IOException
    //   448	458	515	finally
    //   463	468	471	java/io/IOException
    //   482	486	489	java/io/IOException
    //   499	504	507	java/io/IOException
    //   521	526	529	java/io/IOException
    //   538	542	545	java/io/IOException
    //   555	560	563	java/io/IOException
    //   578	630	671	java/lang/Exception
    //   630	637	671	java/lang/Exception
    //   642	650	671	java/lang/Exception
    //   653	670	671	java/lang/Exception }
  
  private void gI(String paramString) { s(new File(paramString)); }
  
  private void s(File paramFile) {
    paramFile = paramFile.getParentFile();
    if (paramFile.exists())
      return; 
    s(paramFile);
    paramFile.mkdir();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */