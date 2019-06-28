package com.laiqian.print.b;

public class b extends a {
  public b() {}
  
  public b(a parama) { super(parama); }
  
  public void afW() {
    n(new int[] { 0, 32 });
    o(new int[] { 2, 0 });
    n(new int[] { 0, 24, 32 });
    o(new int[] { 2, 0, 0 });
    n(new int[] { 0, 16, 24, 32 });
    o(new int[] { 2, 0, 0, 0 });
    n(new int[] { 0, 8, 16, 24, 32 });
    o(new int[] { 2, 0, 0, 0, 0 });
  }
  
  public void x(String... paramVarArgs) { // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: istore #5
    //   4: aload_0
    //   5: iload #5
    //   7: invokevirtual if : (I)[I
    //   10: astore #10
    //   12: aload_0
    //   13: iload #5
    //   15: invokevirtual ig : (I)[I
    //   18: astore #11
    //   20: aload_0
    //   21: invokevirtual getSize : ()I
    //   24: istore #6
    //   26: new com/laiqian/print/b/f
    //   29: dup
    //   30: invokespecial <init> : ()V
    //   33: astore #12
    //   35: new java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial <init> : ()V
    //   42: astore #7
    //   44: iconst_0
    //   45: istore_2
    //   46: iload_2
    //   47: iload #5
    //   49: if_icmpge -> 606
    //   52: aload #10
    //   54: iload_2
    //   55: iaload
    //   56: aload_0
    //   57: invokevirtual getWidth : ()I
    //   60: imul
    //   61: i2d
    //   62: ldc2_w 58.0
    //   65: ddiv
    //   66: d2i
    //   67: istore #4
    //   69: iload #6
    //   71: iconst_3
    //   72: if_icmpeq -> 84
    //   75: iload #4
    //   77: istore_3
    //   78: iload #6
    //   80: iconst_2
    //   81: if_icmpne -> 89
    //   84: iload #4
    //   86: iconst_2
    //   87: idiv
    //   88: istore_3
    //   89: aload #11
    //   91: iload_2
    //   92: iaload
    //   93: istore #4
    //   95: aload_1
    //   96: iload_2
    //   97: aaload
    //   98: astore #8
    //   100: iload #4
    //   102: tableswitch default -> 124, 0 -> 381, 1 -> 205
    //   124: iload_3
    //   125: aload #7
    //   127: invokevirtual toString : ()Ljava/lang/String;
    //   130: invokestatic ml : (Ljava/lang/String;)I
    //   133: isub
    //   134: istore_3
    //   135: iload_3
    //   136: ifle -> 555
    //   139: new java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial <init> : ()V
    //   146: astore #9
    //   148: aload #9
    //   150: ldc '%'
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #9
    //   158: iload_3
    //   159: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload #9
    //   165: ldc 's'
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload #7
    //   173: aload #9
    //   175: invokevirtual toString : ()Ljava/lang/String;
    //   178: iconst_1
    //   179: anewarray java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: ldc ''
    //   186: aastore
    //   187: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   190: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload #7
    //   196: aload #8
    //   198: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: goto -> 599
    //   205: aload #8
    //   207: astore #9
    //   209: iload_2
    //   210: ifeq -> 245
    //   213: new java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial <init> : ()V
    //   220: astore #9
    //   222: aload #9
    //   224: ldc ' '
    //   226: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload #9
    //   232: aload #8
    //   234: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload #9
    //   240: invokevirtual toString : ()Ljava/lang/String;
    //   243: astore #9
    //   245: iload_3
    //   246: aload #7
    //   248: invokevirtual toString : ()Ljava/lang/String;
    //   251: invokestatic ml : (Ljava/lang/String;)I
    //   254: isub
    //   255: aload #9
    //   257: invokestatic ml : (Ljava/lang/String;)I
    //   260: iconst_2
    //   261: idiv
    //   262: isub
    //   263: istore_3
    //   264: iload_3
    //   265: ifle -> 334
    //   268: new java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial <init> : ()V
    //   275: astore #8
    //   277: aload #8
    //   279: ldc '%'
    //   281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload #8
    //   287: iload_3
    //   288: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload #8
    //   294: ldc 's'
    //   296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload #7
    //   302: aload #8
    //   304: invokevirtual toString : ()Ljava/lang/String;
    //   307: iconst_1
    //   308: anewarray java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: ldc ''
    //   315: aastore
    //   316: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   319: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload #7
    //   325: aload #9
    //   327: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: goto -> 599
    //   334: iload_3
    //   335: ifge -> 370
    //   338: aload #12
    //   340: aload #7
    //   342: invokevirtual toString : ()Ljava/lang/String;
    //   345: iload #6
    //   347: iconst_0
    //   348: invokestatic g : (Ljava/lang/String;II)Lcom/laiqian/print/b/f$a;
    //   351: invokevirtual a : (Lcom/laiqian/print/b/f$a;)V
    //   354: new java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial <init> : ()V
    //   361: astore #7
    //   363: iload_2
    //   364: iconst_1
    //   365: isub
    //   366: istore_2
    //   367: goto -> 599
    //   370: aload #7
    //   372: aload #9
    //   374: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: goto -> 599
    //   381: aload #8
    //   383: astore #9
    //   385: iload_2
    //   386: ifeq -> 421
    //   389: new java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial <init> : ()V
    //   396: astore #9
    //   398: aload #9
    //   400: ldc ' '
    //   402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload #9
    //   408: aload #8
    //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload #9
    //   416: invokevirtual toString : ()Ljava/lang/String;
    //   419: astore #9
    //   421: iload_3
    //   422: aload #9
    //   424: invokestatic ml : (Ljava/lang/String;)I
    //   427: isub
    //   428: aload #7
    //   430: invokevirtual toString : ()Ljava/lang/String;
    //   433: invokestatic ml : (Ljava/lang/String;)I
    //   436: isub
    //   437: istore_3
    //   438: iload_3
    //   439: ifle -> 508
    //   442: new java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial <init> : ()V
    //   449: astore #8
    //   451: aload #8
    //   453: ldc '%'
    //   455: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload #8
    //   461: iload_3
    //   462: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload #8
    //   468: ldc 's'
    //   470: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload #7
    //   476: aload #8
    //   478: invokevirtual toString : ()Ljava/lang/String;
    //   481: iconst_1
    //   482: anewarray java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: ldc ''
    //   489: aastore
    //   490: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   493: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload #7
    //   499: aload #9
    //   501: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: goto -> 599
    //   508: iload_3
    //   509: ifge -> 544
    //   512: aload #12
    //   514: aload #7
    //   516: invokevirtual toString : ()Ljava/lang/String;
    //   519: iload #6
    //   521: iconst_0
    //   522: invokestatic g : (Ljava/lang/String;II)Lcom/laiqian/print/b/f$a;
    //   525: invokevirtual a : (Lcom/laiqian/print/b/f$a;)V
    //   528: new java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial <init> : ()V
    //   535: astore #7
    //   537: iload_2
    //   538: iconst_1
    //   539: isub
    //   540: istore_2
    //   541: goto -> 599
    //   544: aload #7
    //   546: aload #9
    //   548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: goto -> 599
    //   555: iload_3
    //   556: ifge -> 591
    //   559: aload #12
    //   561: aload #7
    //   563: invokevirtual toString : ()Ljava/lang/String;
    //   566: iload #6
    //   568: iconst_0
    //   569: invokestatic g : (Ljava/lang/String;II)Lcom/laiqian/print/b/f$a;
    //   572: invokevirtual a : (Lcom/laiqian/print/b/f$a;)V
    //   575: new java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial <init> : ()V
    //   582: astore #7
    //   584: iload_2
    //   585: iconst_1
    //   586: isub
    //   587: istore_2
    //   588: goto -> 599
    //   591: aload #7
    //   593: aload #8
    //   595: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: iload_2
    //   600: iconst_1
    //   601: iadd
    //   602: istore_2
    //   603: goto -> 46
    //   606: aload #12
    //   608: aload #7
    //   610: invokevirtual toString : ()Ljava/lang/String;
    //   613: iload #6
    //   615: iconst_0
    //   616: invokestatic g : (Ljava/lang/String;II)Lcom/laiqian/print/b/f$a;
    //   619: invokevirtual a : (Lcom/laiqian/print/b/f$a;)V
    //   622: aload #12
    //   624: aload_0
    //   625: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   628: invokevirtual a : (Lcom/laiqian/print/model/PrintContent$a;)V
    //   631: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */