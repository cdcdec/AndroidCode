package com.laiqian.crash;

import com.google.a.a.a.a.a.a;
import java.io.File;
import java.io.FileInputStream;

public class a {
  private static final Object aMA = new Object();
  
  public static void CD() { // Byte code:
    //   0: getstatic com/laiqian/crash/a.aMA : Ljava/lang/Object;
    //   3: astore #10
    //   5: aload #10
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
    //   32: astore #11
    //   34: aload #11
    //   36: invokevirtual list : ()[Ljava/lang/String;
    //   39: astore #12
    //   41: aload #12
    //   43: ifnonnull -> 50
    //   46: aload #10
    //   48: monitorexit
    //   49: return
    //   50: aconst_null
    //   51: astore #4
    //   53: new java/util/ArrayList
    //   56: dup
    //   57: invokespecial <init> : ()V
    //   60: astore #9
    //   62: new java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial <init> : ()V
    //   69: astore #6
    //   71: iconst_1
    //   72: istore_2
    //   73: iconst_0
    //   74: istore_1
    //   75: iload_2
    //   76: aload #12
    //   78: arraylength
    //   79: if_icmpgt -> 558
    //   82: aload #12
    //   84: iload_2
    //   85: iconst_1
    //   86: isub
    //   87: aaload
    //   88: astore #13
    //   90: iload_2
    //   91: iconst_5
    //   92: irem
    //   93: ifeq -> 121
    //   96: aload #4
    //   98: astore #5
    //   100: aload #9
    //   102: astore #8
    //   104: iload_1
    //   105: istore_0
    //   106: aload #6
    //   108: astore #7
    //   110: iload_2
    //   111: iconst_5
    //   112: irem
    //   113: aload #12
    //   115: arraylength
    //   116: iconst_5
    //   117: irem
    //   118: if_icmpne -> 342
    //   121: aload #4
    //   123: astore #5
    //   125: aload #9
    //   127: invokevirtual isEmpty : ()Z
    //   130: ifne -> 322
    //   133: aload #4
    //   135: ifnull -> 568
    //   138: aload #4
    //   140: astore #5
    //   142: aload #4
    //   144: invokevirtual length : ()I
    //   147: ifne -> 153
    //   150: goto -> 568
    //   153: new java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial <init> : ()V
    //   160: astore #4
    //   162: aload #4
    //   164: aload #5
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload #4
    //   172: ldc '-crash数量：'
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload #4
    //   180: iload_1
    //   181: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #4
    //   187: invokevirtual toString : ()Ljava/lang/String;
    //   190: astore #4
    //   192: new java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial <init> : ()V
    //   199: astore #7
    //   201: aload #7
    //   203: ldc 'crash email title : '
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload #7
    //   211: aload #4
    //   213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload #7
    //   219: invokevirtual toString : ()Ljava/lang/String;
    //   222: iconst_0
    //   223: anewarray java/lang/Object
    //   226: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: new java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial <init> : ()V
    //   236: astore #7
    //   238: aload #7
    //   240: ldc 'crash email log : '
    //   242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload #7
    //   248: aload #6
    //   250: invokevirtual toString : ()Ljava/lang/String;
    //   253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload #7
    //   259: invokevirtual toString : ()Ljava/lang/String;
    //   262: iconst_0
    //   263: anewarray java/lang/Object
    //   266: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: new java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial <init> : ()V
    //   276: astore #7
    //   278: aload #7
    //   280: ldc ''
    //   282: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload #7
    //   288: aload #4
    //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload #6
    //   296: aload #7
    //   298: invokevirtual toString : ()Ljava/lang/String;
    //   301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: invokestatic init : ()V
    //   308: getstatic com/laiqian/util/logger/AliLog$b.dHc : Lcom/laiqian/util/logger/AliLog$b;
    //   311: getstatic com/laiqian/util/b$a.dEF : Lcom/laiqian/util/b$a;
    //   314: aload #6
    //   316: invokevirtual toString : ()Ljava/lang/String;
    //   319: invokestatic b : (Lcom/laiqian/util/logger/AliLog$b;Lcom/laiqian/util/b$a;Ljava/lang/String;)V
    //   322: new java/util/ArrayList
    //   325: dup
    //   326: invokespecial <init> : ()V
    //   329: astore #8
    //   331: new java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial <init> : ()V
    //   338: astore #7
    //   340: iconst_0
    //   341: istore_0
    //   342: aload #5
    //   344: astore #4
    //   346: iload_0
    //   347: istore_1
    //   348: aload #13
    //   350: ifnull -> 531
    //   353: aload #5
    //   355: astore #4
    //   357: iload_0
    //   358: istore_1
    //   359: aload #13
    //   361: ldc '.'
    //   363: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   366: ifne -> 531
    //   369: aload #5
    //   371: astore #4
    //   373: iload_0
    //   374: istore_1
    //   375: aload #13
    //   377: ldc '.log'
    //   379: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   382: ifeq -> 531
    //   385: new java/io/File
    //   388: dup
    //   389: aload #11
    //   391: aload #13
    //   393: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   396: astore #6
    //   398: aload #13
    //   400: ldc '.log'
    //   402: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   405: istore_3
    //   406: iload_0
    //   407: istore_1
    //   408: iload_3
    //   409: ifeq -> 480
    //   412: aload #7
    //   414: aload #13
    //   416: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload #7
    //   422: ldc '<br>'
    //   424: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload #7
    //   430: aload #6
    //   432: invokestatic m : (Ljava/io/File;)Ljava/lang/String;
    //   435: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload #7
    //   441: ldc '<br>'
    //   443: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload #7
    //   449: ldc '<br>'
    //   451: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload #7
    //   457: ldc '<br>'
    //   459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: iload_0
    //   464: iconst_1
    //   465: iadd
    //   466: istore_1
    //   467: goto -> 480
    //   470: astore #4
    //   472: aload #4
    //   474: invokestatic e : (Ljava/lang/Throwable;)V
    //   477: goto -> 558
    //   480: aload #5
    //   482: astore #4
    //   484: aload #5
    //   486: ifnonnull -> 520
    //   489: aload #13
    //   491: ldc '-shop'
    //   493: invokevirtual indexOf : (Ljava/lang/String;)I
    //   496: istore_0
    //   497: aload #13
    //   499: iconst_0
    //   500: iload_0
    //   501: invokevirtual substring : (II)Ljava/lang/String;
    //   504: astore #4
    //   506: goto -> 520
    //   509: astore #4
    //   511: aload #4
    //   513: invokestatic e : (Ljava/lang/Throwable;)V
    //   516: aload #5
    //   518: astore #4
    //   520: aload #8
    //   522: aload #6
    //   524: invokevirtual getPath : ()Ljava/lang/String;
    //   527: invokevirtual add : (Ljava/lang/Object;)Z
    //   530: pop
    //   531: iload_2
    //   532: iconst_1
    //   533: iadd
    //   534: istore_2
    //   535: aload #8
    //   537: astore #9
    //   539: aload #7
    //   541: astore #6
    //   543: goto -> 75
    //   546: astore #4
    //   548: goto -> 562
    //   551: astore #4
    //   553: aload #4
    //   555: invokestatic e : (Ljava/lang/Throwable;)V
    //   558: aload #10
    //   560: monitorexit
    //   561: return
    //   562: aload #10
    //   564: monitorexit
    //   565: aload #4
    //   567: athrow
    //   568: ldc '未知账号'
    //   570: astore #5
    //   572: goto -> 153
    // Exception table:
    //   from	to	target	type
    //   8	41	551	java/lang/Exception
    //   8	41	546	finally
    //   46	49	546	finally
    //   53	71	551	java/lang/Exception
    //   53	71	546	finally
    //   75	82	551	java/lang/Exception
    //   75	82	546	finally
    //   110	121	551	java/lang/Exception
    //   110	121	546	finally
    //   125	133	551	java/lang/Exception
    //   125	133	546	finally
    //   142	150	551	java/lang/Exception
    //   142	150	546	finally
    //   153	322	551	java/lang/Exception
    //   153	322	546	finally
    //   322	340	551	java/lang/Exception
    //   322	340	546	finally
    //   359	369	551	java/lang/Exception
    //   359	369	546	finally
    //   375	406	551	java/lang/Exception
    //   375	406	546	finally
    //   412	463	470	java/lang/Throwable
    //   412	463	551	java/lang/Exception
    //   412	463	546	finally
    //   472	477	551	java/lang/Exception
    //   472	477	546	finally
    //   489	497	551	java/lang/Exception
    //   489	497	546	finally
    //   497	506	509	java/lang/Exception
    //   497	506	546	finally
    //   511	516	551	java/lang/Exception
    //   511	516	546	finally
    //   520	531	551	java/lang/Exception
    //   520	531	546	finally
    //   553	558	546	finally
    //   558	561	546	finally
    //   562	565	546	finally }
  
  public static String m(File paramFile) {
    try {
      FileInputStream fileInputStream = new FileInputStream(paramFile);
      byte[] arrayOfByte = new byte[(int)paramFile.length()];
      fileInputStream.read(arrayOfByte);
      fileInputStream.close();
      return new String(arrayOfByte);
    } catch (Throwable paramFile) {
      a.e(paramFile);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("读取文件失败了，信息：");
      stringBuilder.append(paramFile.getMessage());
      return stringBuilder.toString();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */