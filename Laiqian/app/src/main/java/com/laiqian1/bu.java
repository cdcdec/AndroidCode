package com.laiqian;

class bu implements Runnable {
  bu(bt parambt) {}
  
  public void run() { // Byte code:
    //   0: aload_0
    //   1: getfield aBV : Lcom/laiqian/bt;
    //   4: getfield aBL : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   7: iconst_1
    //   8: invokevirtual set : (Z)V
    //   11: aload_0
    //   12: getfield aBV : Lcom/laiqian/bt;
    //   15: getfield onlinePayEntity : Lcom/laiqian/entity/n;
    //   18: invokevirtual Fl : ()Ljava/lang/String;
    //   21: invokestatic aU : (Ljava/lang/Object;)D
    //   24: dstore_1
    //   25: aload_0
    //   26: getfield aBV : Lcom/laiqian/bt;
    //   29: getfield aBS : Landroid/os/Handler;
    //   32: invokevirtual obtainMessage : ()Landroid/os/Message;
    //   35: astore #5
    //   37: dload_1
    //   38: ldc2_w 0.01
    //   41: dcmpg
    //   42: iflt -> 608
    //   45: dload_1
    //   46: ldc2_w 1.0E8
    //   49: dcmpl
    //   50: ifle -> 56
    //   53: goto -> 608
    //   56: aload_0
    //   57: getfield aBV : Lcom/laiqian/bt;
    //   60: getfield mContext : Landroid/content/Context;
    //   63: invokestatic bH : (Landroid/content/Context;)Z
    //   66: ifne -> 89
    //   69: aload #5
    //   71: iconst_m1
    //   72: putfield what : I
    //   75: aload_0
    //   76: getfield aBV : Lcom/laiqian/bt;
    //   79: getfield aBS : Landroid/os/Handler;
    //   82: aload #5
    //   84: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   87: pop
    //   88: return
    //   89: aconst_null
    //   90: astore_3
    //   91: new com/laiqian/models/an
    //   94: dup
    //   95: aload_0
    //   96: getfield aBV : Lcom/laiqian/bt;
    //   99: getfield mContext : Landroid/content/Context;
    //   102: invokespecial <init> : (Landroid/content/Context;)V
    //   105: astore #4
    //   107: aload #4
    //   109: astore_3
    //   110: goto -> 120
    //   113: astore #4
    //   115: aload #4
    //   117: invokestatic e : (Ljava/lang/Throwable;)V
    //   120: aload_3
    //   121: invokevirtual Vu : ()Lcom/laiqian/models/an$c;
    //   124: astore #4
    //   126: ldc ''
    //   128: astore_3
    //   129: aload #4
    //   131: getfield aVs : Ljava/lang/String;
    //   134: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   137: ifne -> 146
    //   140: aload #4
    //   142: getfield aVs : Ljava/lang/String;
    //   145: astore_3
    //   146: aload_3
    //   147: astore #4
    //   149: aload_3
    //   150: invokevirtual length : ()I
    //   153: bipush #100
    //   155: if_icmple -> 167
    //   158: aload_3
    //   159: iconst_0
    //   160: bipush #100
    //   162: invokevirtual substring : (II)Ljava/lang/String;
    //   165: astore #4
    //   167: aload #4
    //   169: ifnull -> 185
    //   172: aload #4
    //   174: astore_3
    //   175: ldc ''
    //   177: aload #4
    //   179: invokevirtual equals : (Ljava/lang/Object;)Z
    //   182: ifeq -> 199
    //   185: aload_0
    //   186: getfield aBV : Lcom/laiqian/bt;
    //   189: getfield mContext : Landroid/content/Context;
    //   192: getstatic com/laiqian/payment/R$string.nus_noti_title : I
    //   195: invokevirtual getString : (I)Ljava/lang/String;
    //   198: astore_3
    //   199: new java/util/HashMap
    //   202: dup
    //   203: invokespecial <init> : ()V
    //   206: astore #4
    //   208: aload #4
    //   210: ldc 'out_trade_no'
    //   212: aload_0
    //   213: getfield aBV : Lcom/laiqian/bt;
    //   216: getfield onlinePayEntity : Lcom/laiqian/entity/n;
    //   219: invokevirtual xq : ()Ljava/lang/String;
    //   222: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   225: pop
    //   226: aload #4
    //   228: ldc 'subject'
    //   230: aload_3
    //   231: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   234: pop
    //   235: dload_1
    //   236: iconst_2
    //   237: invokestatic c : (DI)Ljava/lang/String;
    //   240: astore_3
    //   241: aload #4
    //   243: ldc 'total_amount'
    //   245: aload_3
    //   246: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: new com/laiqian/util/av
    //   253: dup
    //   254: aload_0
    //   255: getfield aBV : Lcom/laiqian/bt;
    //   258: getfield mContext : Landroid/content/Context;
    //   261: invokespecial <init> : (Landroid/content/Context;)V
    //   264: astore #6
    //   266: aload #4
    //   268: ldc 'shop_id'
    //   270: aload #6
    //   272: invokevirtual Tx : ()Ljava/lang/String;
    //   275: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   278: pop
    //   279: aload #6
    //   281: invokevirtual close : ()V
    //   284: aload_0
    //   285: getfield aBV : Lcom/laiqian/bt;
    //   288: getfield onlinePayEntity : Lcom/laiqian/entity/n;
    //   291: invokevirtual Fn : ()I
    //   294: iconst_1
    //   295: if_icmpne -> 353
    //   298: new java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial <init> : ()V
    //   305: astore #6
    //   307: aload #6
    //   309: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   312: invokevirtual avs : ()I
    //   315: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload #6
    //   321: ldc ''
    //   323: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload #4
    //   329: ldc 'pay_mode'
    //   331: aload #6
    //   333: invokevirtual toString : ()Ljava/lang/String;
    //   336: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: aload #4
    //   342: ldc 'business_type'
    //   344: ldc 'member'
    //   346: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   349: pop
    //   350: goto -> 363
    //   353: aload #4
    //   355: ldc 'business_type'
    //   357: ldc 'reception'
    //   359: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   362: pop
    //   363: getstatic com/laiqian/pos/industry/a.cqL : Ljava/lang/String;
    //   366: aload_0
    //   367: getfield aBV : Lcom/laiqian/bt;
    //   370: getfield mContext : Landroid/content/Context;
    //   373: aload #4
    //   375: invokestatic a : (Ljava/lang/String;Landroid/content/Context;Ljava/util/HashMap;)Ljava/lang/String;
    //   378: astore #4
    //   380: ldc ''
    //   382: aload #4
    //   384: invokevirtual equals : (Ljava/lang/Object;)Z
    //   387: ifeq -> 410
    //   390: aload #5
    //   392: iconst_4
    //   393: putfield what : I
    //   396: aload_0
    //   397: getfield aBV : Lcom/laiqian/bt;
    //   400: getfield aBS : Landroid/os/Handler;
    //   403: aload #5
    //   405: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   408: pop
    //   409: return
    //   410: ldc '-1'
    //   412: aload #4
    //   414: invokevirtual equals : (Ljava/lang/Object;)Z
    //   417: ifeq -> 440
    //   420: aload #5
    //   422: iconst_m1
    //   423: putfield what : I
    //   426: aload_0
    //   427: getfield aBV : Lcom/laiqian/bt;
    //   430: getfield aBS : Landroid/os/Handler;
    //   433: aload #5
    //   435: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   438: pop
    //   439: return
    //   440: aload #4
    //   442: invokestatic qB : (Ljava/lang/String;)Ljava/util/HashMap;
    //   445: astore #4
    //   447: aload #4
    //   449: ifnull -> 518
    //   452: aload #4
    //   454: ldc 'result_code'
    //   456: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   459: ifnull -> 518
    //   462: ldc 'SUCCESS'
    //   464: aload #4
    //   466: ldc 'result_code'
    //   468: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   471: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   474: invokevirtual equals : (Ljava/lang/Object;)Z
    //   477: ifeq -> 518
    //   480: aload #5
    //   482: sipush #10000
    //   485: putfield what : I
    //   488: aload #4
    //   490: ldc 'total_amount_pay'
    //   492: aload_3
    //   493: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   496: pop
    //   497: aload #5
    //   499: aload #4
    //   501: putfield obj : Ljava/lang/Object;
    //   504: aload_0
    //   505: getfield aBV : Lcom/laiqian/bt;
    //   508: getfield aBS : Landroid/os/Handler;
    //   511: aload #5
    //   513: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   516: pop
    //   517: return
    //   518: aload #4
    //   520: ifnull -> 588
    //   523: aload #4
    //   525: ldc 'result_code'
    //   527: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   530: ifnull -> 588
    //   533: ldc 'FAIL'
    //   535: aload #4
    //   537: ldc 'result_code'
    //   539: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   542: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   545: invokevirtual equals : (Ljava/lang/Object;)Z
    //   548: ifeq -> 588
    //   551: aload #5
    //   553: ldc 40004
    //   555: putfield what : I
    //   558: aload #4
    //   560: ldc 'total_amount_pay'
    //   562: aload_3
    //   563: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   566: pop
    //   567: aload #5
    //   569: aload #4
    //   571: putfield obj : Ljava/lang/Object;
    //   574: aload_0
    //   575: getfield aBV : Lcom/laiqian/bt;
    //   578: getfield aBS : Landroid/os/Handler;
    //   581: aload #5
    //   583: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   586: pop
    //   587: return
    //   588: aload #5
    //   590: iconst_4
    //   591: putfield what : I
    //   594: aload_0
    //   595: getfield aBV : Lcom/laiqian/bt;
    //   598: getfield aBS : Landroid/os/Handler;
    //   601: aload #5
    //   603: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   606: pop
    //   607: return
    //   608: aload #5
    //   610: iconst_0
    //   611: putfield what : I
    //   614: aload_0
    //   615: getfield aBV : Lcom/laiqian/bt;
    //   618: getfield aBS : Landroid/os/Handler;
    //   621: aload #5
    //   623: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   626: pop
    //   627: return
    // Exception table:
    //   from	to	target	type
    //   91	107	113	java/lang/Exception }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */