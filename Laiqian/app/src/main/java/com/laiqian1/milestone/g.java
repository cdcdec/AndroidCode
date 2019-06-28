package com.laiqian.milestone;

import android.content.Context;
import java.io.File;

public class g {
  public static int aQe = 0;
  
  public static int aQf = 1;
  
  public static int aQg = 2;
  
  private static String aQi = "laiqian.db";
  
  public File aQd;
  
  public boolean aQh;
  
  static  {
  
  }
  
  public g(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield aQd : Ljava/io/File;
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield aQh : Z
    //   14: aload_0
    //   15: aload_3
    //   16: invokespecial gI : (Ljava/lang/String;)V
    //   19: iload #5
    //   21: getstatic com/laiqian/milestone/g.aQe : I
    //   24: if_icmpne -> 149
    //   27: new java/io/FileInputStream
    //   30: dup
    //   31: aload_2
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: astore_1
    //   36: new java/util/zip/ZipOutputStream
    //   39: dup
    //   40: new java/io/BufferedOutputStream
    //   43: dup
    //   44: new java/io/FileOutputStream
    //   47: dup
    //   48: aload_3
    //   49: invokespecial <init> : (Ljava/lang/String;)V
    //   52: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   55: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   58: astore #7
    //   60: aload #7
    //   62: new java/util/zip/ZipEntry
    //   65: dup
    //   66: aload_2
    //   67: aload_2
    //   68: ldc '/'
    //   70: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   73: iconst_1
    //   74: iadd
    //   75: invokevirtual substring : (I)Ljava/lang/String;
    //   78: invokespecial <init> : (Ljava/lang/String;)V
    //   81: invokevirtual putNextEntry : (Ljava/util/zip/ZipEntry;)V
    //   84: sipush #8192
    //   87: newarray byte
    //   89: astore #8
    //   91: aload_1
    //   92: aload #8
    //   94: invokevirtual read : ([B)I
    //   97: istore #6
    //   99: iload #6
    //   101: ifle -> 117
    //   104: aload #7
    //   106: aload #8
    //   108: iconst_0
    //   109: iload #6
    //   111: invokevirtual write : ([BII)V
    //   114: goto -> 91
    //   117: aload #7
    //   119: invokevirtual closeEntry : ()V
    //   122: aload #7
    //   124: invokevirtual close : ()V
    //   127: aload_1
    //   128: invokevirtual close : ()V
    //   131: aload_0
    //   132: iconst_1
    //   133: putfield aQh : Z
    //   136: goto -> 149
    //   139: astore_1
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield aQh : Z
    //   145: aload_1
    //   146: invokestatic e : (Ljava/lang/Throwable;)V
    //   149: iload #5
    //   151: getstatic com/laiqian/milestone/g.aQf : I
    //   154: if_icmpne -> 690
    //   157: new java/io/File
    //   160: dup
    //   161: aload_3
    //   162: invokespecial <init> : (Ljava/lang/String;)V
    //   165: pop
    //   166: new java/io/FileInputStream
    //   169: dup
    //   170: aload_2
    //   171: invokespecial <init> : (Ljava/lang/String;)V
    //   174: astore_1
    //   175: new java/util/zip/ZipInputStream
    //   178: dup
    //   179: new java/io/BufferedInputStream
    //   182: dup
    //   183: aload_1
    //   184: invokespecial <init> : (Ljava/io/InputStream;)V
    //   187: invokespecial <init> : (Ljava/io/InputStream;)V
    //   190: astore #7
    //   192: new java/io/FileOutputStream
    //   195: dup
    //   196: aload_3
    //   197: invokespecial <init> : (Ljava/lang/String;)V
    //   200: astore #11
    //   202: aload_1
    //   203: astore #8
    //   205: aload #7
    //   207: astore #9
    //   209: aload #11
    //   211: astore #10
    //   213: aload #7
    //   215: invokevirtual getNextEntry : ()Ljava/util/zip/ZipEntry;
    //   218: astore #12
    //   220: aload #12
    //   222: ifnull -> 412
    //   225: aload_1
    //   226: astore #8
    //   228: aload #7
    //   230: astore #9
    //   232: aload #11
    //   234: astore #10
    //   236: aload #12
    //   238: invokevirtual getName : ()Ljava/lang/String;
    //   241: astore #12
    //   243: aload_1
    //   244: astore #8
    //   246: aload #7
    //   248: astore #9
    //   250: aload #11
    //   252: astore #10
    //   254: new java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial <init> : ()V
    //   261: astore #13
    //   263: aload_1
    //   264: astore #8
    //   266: aload #7
    //   268: astore #9
    //   270: aload #11
    //   272: astore #10
    //   274: aload #13
    //   276: ldc '.'
    //   278: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_1
    //   283: astore #8
    //   285: aload #7
    //   287: astore #9
    //   289: aload #11
    //   291: astore #10
    //   293: aload #13
    //   295: aload #4
    //   297: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_1
    //   302: astore #8
    //   304: aload #7
    //   306: astore #9
    //   308: aload #11
    //   310: astore #10
    //   312: aload #12
    //   314: aload #13
    //   316: invokevirtual toString : ()Ljava/lang/String;
    //   319: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   322: ifeq -> 202
    //   325: aload_1
    //   326: astore #8
    //   328: aload #7
    //   330: astore #9
    //   332: aload #11
    //   334: astore #10
    //   336: sipush #8192
    //   339: newarray byte
    //   341: astore #12
    //   343: aload_1
    //   344: astore #8
    //   346: aload #7
    //   348: astore #9
    //   350: aload #11
    //   352: astore #10
    //   354: aload #7
    //   356: aload #12
    //   358: invokevirtual read : ([B)I
    //   361: istore #6
    //   363: iload #6
    //   365: iconst_m1
    //   366: if_icmpeq -> 393
    //   369: aload_1
    //   370: astore #8
    //   372: aload #7
    //   374: astore #9
    //   376: aload #11
    //   378: astore #10
    //   380: aload #11
    //   382: aload #12
    //   384: iconst_0
    //   385: iload #6
    //   387: invokevirtual write : ([BII)V
    //   390: goto -> 343
    //   393: aload_1
    //   394: astore #8
    //   396: aload #7
    //   398: astore #9
    //   400: aload #11
    //   402: astore #10
    //   404: aload_0
    //   405: iconst_1
    //   406: putfield aQh : Z
    //   409: goto -> 202
    //   412: aload #7
    //   414: ifnull -> 432
    //   417: aload #7
    //   419: invokevirtual close : ()V
    //   422: goto -> 432
    //   425: astore #4
    //   427: aload #4
    //   429: invokestatic e : (Ljava/lang/Throwable;)V
    //   432: aload #11
    //   434: ifnull -> 452
    //   437: aload #11
    //   439: invokevirtual close : ()V
    //   442: goto -> 452
    //   445: astore #4
    //   447: aload #4
    //   449: invokestatic e : (Ljava/lang/Throwable;)V
    //   452: aload_1
    //   453: ifnull -> 690
    //   456: aload_1
    //   457: invokevirtual close : ()V
    //   460: goto -> 690
    //   463: astore #8
    //   465: aload #11
    //   467: astore #4
    //   469: aload #8
    //   471: astore #11
    //   473: goto -> 537
    //   476: astore_3
    //   477: aconst_null
    //   478: astore #4
    //   480: aload_1
    //   481: astore_2
    //   482: aload #4
    //   484: astore_1
    //   485: goto -> 515
    //   488: astore #8
    //   490: aconst_null
    //   491: astore #4
    //   493: goto -> 533
    //   496: astore_3
    //   497: aload_1
    //   498: astore_2
    //   499: goto -> 510
    //   502: astore #8
    //   504: goto -> 527
    //   507: astore_3
    //   508: aconst_null
    //   509: astore_2
    //   510: aconst_null
    //   511: astore #7
    //   513: aconst_null
    //   514: astore_1
    //   515: aload_1
    //   516: astore #10
    //   518: aload_3
    //   519: astore_1
    //   520: goto -> 636
    //   523: astore #8
    //   525: aconst_null
    //   526: astore_1
    //   527: aconst_null
    //   528: astore #7
    //   530: aconst_null
    //   531: astore #4
    //   533: aload #8
    //   535: astore #11
    //   537: aload_1
    //   538: astore #8
    //   540: aload #7
    //   542: astore #9
    //   544: aload #4
    //   546: astore #10
    //   548: aload_0
    //   549: iconst_0
    //   550: putfield aQh : Z
    //   553: aload_1
    //   554: astore #8
    //   556: aload #7
    //   558: astore #9
    //   560: aload #4
    //   562: astore #10
    //   564: aload #11
    //   566: invokestatic e : (Ljava/lang/Throwable;)V
    //   569: aload #7
    //   571: ifnull -> 589
    //   574: aload #7
    //   576: invokevirtual close : ()V
    //   579: goto -> 589
    //   582: astore #7
    //   584: aload #7
    //   586: invokestatic e : (Ljava/lang/Throwable;)V
    //   589: aload #4
    //   591: ifnull -> 609
    //   594: aload #4
    //   596: invokevirtual close : ()V
    //   599: goto -> 609
    //   602: astore #4
    //   604: aload #4
    //   606: invokestatic e : (Ljava/lang/Throwable;)V
    //   609: aload_1
    //   610: ifnull -> 690
    //   613: aload_1
    //   614: invokevirtual close : ()V
    //   617: goto -> 690
    //   620: astore_1
    //   621: aload_1
    //   622: invokestatic e : (Ljava/lang/Throwable;)V
    //   625: goto -> 690
    //   628: astore_1
    //   629: aload #9
    //   631: astore #7
    //   633: aload #8
    //   635: astore_2
    //   636: aload #7
    //   638: ifnull -> 654
    //   641: aload #7
    //   643: invokevirtual close : ()V
    //   646: goto -> 654
    //   649: astore_3
    //   650: aload_3
    //   651: invokestatic e : (Ljava/lang/Throwable;)V
    //   654: aload #10
    //   656: ifnull -> 672
    //   659: aload #10
    //   661: invokevirtual close : ()V
    //   664: goto -> 672
    //   667: astore_3
    //   668: aload_3
    //   669: invokestatic e : (Ljava/lang/Throwable;)V
    //   672: aload_2
    //   673: ifnull -> 688
    //   676: aload_2
    //   677: invokevirtual close : ()V
    //   680: goto -> 688
    //   683: astore_2
    //   684: aload_2
    //   685: invokestatic e : (Ljava/lang/Throwable;)V
    //   688: aload_1
    //   689: athrow
    //   690: iload #5
    //   692: getstatic com/laiqian/milestone/g.aQg : I
    //   695: if_icmpne -> 801
    //   698: new java/io/FileInputStream
    //   701: dup
    //   702: aload_2
    //   703: invokespecial <init> : (Ljava/lang/String;)V
    //   706: astore_1
    //   707: new java/util/zip/ZipOutputStream
    //   710: dup
    //   711: new java/io/BufferedOutputStream
    //   714: dup
    //   715: new java/io/FileOutputStream
    //   718: dup
    //   719: aload_3
    //   720: invokespecial <init> : (Ljava/lang/String;)V
    //   723: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   726: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   729: astore_2
    //   730: aload_2
    //   731: new java/util/zip/ZipEntry
    //   734: dup
    //   735: getstatic com/laiqian/milestone/g.aQi : Ljava/lang/String;
    //   738: invokespecial <init> : (Ljava/lang/String;)V
    //   741: invokevirtual putNextEntry : (Ljava/util/zip/ZipEntry;)V
    //   744: sipush #8192
    //   747: newarray byte
    //   749: astore_3
    //   750: aload_1
    //   751: aload_3
    //   752: invokevirtual read : ([B)I
    //   755: istore #5
    //   757: iload #5
    //   759: ifle -> 773
    //   762: aload_2
    //   763: aload_3
    //   764: iconst_0
    //   765: iload #5
    //   767: invokevirtual write : ([BII)V
    //   770: goto -> 750
    //   773: aload_2
    //   774: invokevirtual closeEntry : ()V
    //   777: aload_2
    //   778: invokevirtual close : ()V
    //   781: aload_1
    //   782: invokevirtual close : ()V
    //   785: aload_0
    //   786: iconst_1
    //   787: putfield aQh : Z
    //   790: return
    //   791: astore_1
    //   792: aload_0
    //   793: iconst_0
    //   794: putfield aQh : Z
    //   797: aload_1
    //   798: invokestatic e : (Ljava/lang/Throwable;)V
    //   801: return
    // Exception table:
    //   from	to	target	type
    //   27	91	139	java/lang/Exception
    //   91	99	139	java/lang/Exception
    //   104	114	139	java/lang/Exception
    //   117	136	139	java/lang/Exception
    //   157	175	523	java/lang/Exception
    //   157	175	507	finally
    //   175	192	502	java/lang/Exception
    //   175	192	496	finally
    //   192	202	488	java/lang/Exception
    //   192	202	476	finally
    //   213	220	463	java/lang/Exception
    //   213	220	628	finally
    //   236	243	463	java/lang/Exception
    //   236	243	628	finally
    //   254	263	463	java/lang/Exception
    //   254	263	628	finally
    //   274	282	463	java/lang/Exception
    //   274	282	628	finally
    //   293	301	463	java/lang/Exception
    //   293	301	628	finally
    //   312	325	463	java/lang/Exception
    //   312	325	628	finally
    //   336	343	463	java/lang/Exception
    //   336	343	628	finally
    //   354	363	463	java/lang/Exception
    //   354	363	628	finally
    //   380	390	463	java/lang/Exception
    //   380	390	628	finally
    //   404	409	463	java/lang/Exception
    //   404	409	628	finally
    //   417	422	425	java/io/IOException
    //   437	442	445	java/io/IOException
    //   456	460	620	java/io/IOException
    //   548	553	628	finally
    //   564	569	628	finally
    //   574	579	582	java/io/IOException
    //   594	599	602	java/io/IOException
    //   613	617	620	java/io/IOException
    //   641	646	649	java/io/IOException
    //   659	664	667	java/io/IOException
    //   676	680	683	java/io/IOException
    //   698	750	791	java/lang/Exception
    //   750	757	791	java/lang/Exception
    //   762	770	791	java/lang/Exception
    //   773	790	791	java/lang/Exception }
  
  private void gI(String paramString) { s(new File(paramString)); }
  
  private void s(File paramFile) {
    paramFile = paramFile.getParentFile();
    if (paramFile.exists())
      return; 
    s(paramFile);
    paramFile.mkdir();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */