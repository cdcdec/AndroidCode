package com.laiqian;

class b implements Runnable {
  b(a parama) {}
  
  public void run() { // Byte code:
    //   0: aload_0
    //   1: getfield azo : Lcom/laiqian/a;
    //   4: getfield aBL : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   7: iconst_1
    //   8: invokevirtual set : (Z)V
    //   11: aload_0
    //   12: getfield azo : Lcom/laiqian/a;
    //   15: invokestatic a : (Lcom/laiqian/a;)Lcom/laiqian/entity/n;
    //   18: invokevirtual Fl : ()Ljava/lang/String;
    //   21: invokestatic aU : (Ljava/lang/Object;)D
    //   24: dstore_1
    //   25: aload_0
    //   26: getfield azo : Lcom/laiqian/a;
    //   29: getfield aBS : Landroid/os/Handler;
    //   32: invokevirtual obtainMessage : ()Landroid/os/Message;
    //   35: astore #5
    //   37: dload_1
    //   38: ldc2_w 0.01
    //   41: dcmpg
    //   42: iflt -> 765
    //   45: dload_1
    //   46: ldc2_w 1.0E8
    //   49: dcmpl
    //   50: ifle -> 56
    //   53: goto -> 765
    //   56: aload_0
    //   57: getfield azo : Lcom/laiqian/a;
    //   60: invokestatic b : (Lcom/laiqian/a;)Landroid/content/Context;
    //   63: invokestatic bH : (Landroid/content/Context;)Z
    //   66: ifne -> 89
    //   69: aload #5
    //   71: iconst_m1
    //   72: putfield what : I
    //   75: aload_0
    //   76: getfield azo : Lcom/laiqian/a;
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
    //   96: getfield azo : Lcom/laiqian/a;
    //   99: invokestatic b : (Lcom/laiqian/a;)Landroid/content/Context;
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
    //   147: ifnull -> 162
    //   150: aload_3
    //   151: astore #4
    //   153: ldc ''
    //   155: aload_3
    //   156: invokevirtual equals : (Ljava/lang/Object;)Z
    //   159: ifeq -> 177
    //   162: aload_0
    //   163: getfield azo : Lcom/laiqian/a;
    //   166: invokestatic b : (Lcom/laiqian/a;)Landroid/content/Context;
    //   169: getstatic com/laiqian/payment/R$string.nus_noti_title : I
    //   172: invokevirtual getString : (I)Ljava/lang/String;
    //   175: astore #4
    //   177: new java/util/HashMap
    //   180: dup
    //   181: invokespecial <init> : ()V
    //   184: astore #6
    //   186: aload #6
    //   188: ldc 'out_trade_no'
    //   190: aload_0
    //   191: getfield azo : Lcom/laiqian/a;
    //   194: invokestatic a : (Lcom/laiqian/a;)Lcom/laiqian/entity/n;
    //   197: invokevirtual xq : ()Ljava/lang/String;
    //   200: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   203: pop
    //   204: aload #6
    //   206: ldc 'subject'
    //   208: aload #4
    //   210: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   213: pop
    //   214: dload_1
    //   215: iconst_2
    //   216: invokestatic c : (DI)Ljava/lang/String;
    //   219: astore_3
    //   220: aload #6
    //   222: ldc 'total_amount'
    //   224: aload_3
    //   225: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   228: pop
    //   229: aload #6
    //   231: ldc 'shop_id'
    //   233: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   236: invokevirtual Tx : ()Ljava/lang/String;
    //   239: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   242: pop
    //   243: aload_0
    //   244: getfield azo : Lcom/laiqian/a;
    //   247: invokestatic a : (Lcom/laiqian/a;)Lcom/laiqian/entity/n;
    //   250: invokevirtual Fn : ()I
    //   253: iconst_1
    //   254: if_icmpne -> 312
    //   257: new java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial <init> : ()V
    //   264: astore #4
    //   266: aload #4
    //   268: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   271: invokevirtual avs : ()I
    //   274: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload #4
    //   280: ldc ''
    //   282: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload #6
    //   288: ldc 'pay_mode'
    //   290: aload #4
    //   292: invokevirtual toString : ()Ljava/lang/String;
    //   295: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   298: pop
    //   299: aload #6
    //   301: ldc 'business_type'
    //   303: ldc 'member'
    //   305: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   308: pop
    //   309: goto -> 322
    //   312: aload #6
    //   314: ldc 'business_type'
    //   316: ldc 'reception'
    //   318: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   321: pop
    //   322: getstatic com/laiqian/pos/industry/a.cqD : Ljava/lang/String;
    //   325: aload_0
    //   326: getfield azo : Lcom/laiqian/a;
    //   329: invokestatic b : (Lcom/laiqian/a;)Landroid/content/Context;
    //   332: aload #6
    //   334: invokestatic a : (Ljava/lang/String;Landroid/content/Context;Ljava/util/HashMap;)Ljava/lang/String;
    //   337: astore #4
    //   339: ldc ''
    //   341: aload #4
    //   343: invokevirtual equals : (Ljava/lang/Object;)Z
    //   346: ifeq -> 369
    //   349: aload #5
    //   351: iconst_4
    //   352: putfield what : I
    //   355: aload_0
    //   356: getfield azo : Lcom/laiqian/a;
    //   359: getfield aBS : Landroid/os/Handler;
    //   362: aload #5
    //   364: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   367: pop
    //   368: return
    //   369: ldc '-1'
    //   371: aload #4
    //   373: invokevirtual equals : (Ljava/lang/Object;)Z
    //   376: ifeq -> 399
    //   379: aload #5
    //   381: iconst_m1
    //   382: putfield what : I
    //   385: aload_0
    //   386: getfield azo : Lcom/laiqian/a;
    //   389: getfield aBS : Landroid/os/Handler;
    //   392: aload #5
    //   394: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   397: pop
    //   398: return
    //   399: aload #4
    //   401: invokestatic qB : (Ljava/lang/String;)Ljava/util/HashMap;
    //   404: astore #4
    //   406: aload #4
    //   408: ifnull -> 477
    //   411: aload #4
    //   413: ldc 'code'
    //   415: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   418: ifnull -> 477
    //   421: ldc '10000'
    //   423: aload #4
    //   425: ldc 'code'
    //   427: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   430: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   433: invokevirtual equals : (Ljava/lang/Object;)Z
    //   436: ifeq -> 477
    //   439: aload #5
    //   441: sipush #10000
    //   444: putfield what : I
    //   447: aload #4
    //   449: ldc 'total_amount_pay'
    //   451: aload_3
    //   452: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   455: pop
    //   456: aload #5
    //   458: aload #4
    //   460: putfield obj : Ljava/lang/Object;
    //   463: aload_0
    //   464: getfield azo : Lcom/laiqian/a;
    //   467: getfield aBS : Landroid/os/Handler;
    //   470: aload #5
    //   472: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   475: pop
    //   476: return
    //   477: aload #4
    //   479: ifnull -> 547
    //   482: aload #4
    //   484: ldc 'code'
    //   486: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   489: ifnull -> 547
    //   492: ldc '40004'
    //   494: aload #4
    //   496: ldc 'code'
    //   498: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   501: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   504: invokevirtual equals : (Ljava/lang/Object;)Z
    //   507: ifeq -> 547
    //   510: aload #5
    //   512: ldc 40004
    //   514: putfield what : I
    //   517: aload #4
    //   519: ldc 'total_amount_pay'
    //   521: aload_3
    //   522: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   525: pop
    //   526: aload #5
    //   528: aload #4
    //   530: putfield obj : Ljava/lang/Object;
    //   533: aload_0
    //   534: getfield azo : Lcom/laiqian/a;
    //   537: getfield aBS : Landroid/os/Handler;
    //   540: aload #5
    //   542: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   545: pop
    //   546: return
    //   547: aload #4
    //   549: ifnull -> 608
    //   552: aload #4
    //   554: ldc 'code'
    //   556: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   559: ifnull -> 608
    //   562: ldc '40002'
    //   564: aload #4
    //   566: ldc 'code'
    //   568: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   571: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   574: invokevirtual equals : (Ljava/lang/Object;)Z
    //   577: ifeq -> 608
    //   580: aload #5
    //   582: ldc 40002
    //   584: putfield what : I
    //   587: aload #5
    //   589: aload #4
    //   591: putfield obj : Ljava/lang/Object;
    //   594: aload_0
    //   595: getfield azo : Lcom/laiqian/a;
    //   598: getfield aBS : Landroid/os/Handler;
    //   601: aload #5
    //   603: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   606: pop
    //   607: return
    //   608: aload #4
    //   610: ifnull -> 669
    //   613: aload #4
    //   615: ldc 'code'
    //   617: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   620: ifnull -> 669
    //   623: ldc '40001'
    //   625: aload #4
    //   627: ldc 'code'
    //   629: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   632: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   635: invokevirtual equals : (Ljava/lang/Object;)Z
    //   638: ifeq -> 669
    //   641: aload #5
    //   643: ldc 40001
    //   645: putfield what : I
    //   648: aload #5
    //   650: aload #4
    //   652: putfield obj : Ljava/lang/Object;
    //   655: aload_0
    //   656: getfield azo : Lcom/laiqian/a;
    //   659: getfield aBS : Landroid/os/Handler;
    //   662: aload #5
    //   664: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   667: pop
    //   668: return
    //   669: aload #4
    //   671: ifnull -> 745
    //   674: aload #4
    //   676: ldc 'code'
    //   678: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   681: ifnull -> 745
    //   684: ldc '20001'
    //   686: aload #4
    //   688: ldc 'code'
    //   690: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   693: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   696: invokevirtual equals : (Ljava/lang/Object;)Z
    //   699: ifeq -> 745
    //   702: aload_0
    //   703: getfield azo : Lcom/laiqian/a;
    //   706: invokestatic c : (Lcom/laiqian/a;)Lcom/laiqian/n;
    //   709: ldc 'F'
    //   711: invokeinterface bg : (Ljava/lang/String;)V
    //   716: aload #5
    //   718: sipush #20001
    //   721: putfield what : I
    //   724: aload #5
    //   726: aload #4
    //   728: putfield obj : Ljava/lang/Object;
    //   731: aload_0
    //   732: getfield azo : Lcom/laiqian/a;
    //   735: getfield aBS : Landroid/os/Handler;
    //   738: aload #5
    //   740: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   743: pop
    //   744: return
    //   745: aload #5
    //   747: iconst_4
    //   748: putfield what : I
    //   751: aload_0
    //   752: getfield azo : Lcom/laiqian/a;
    //   755: getfield aBS : Landroid/os/Handler;
    //   758: aload #5
    //   760: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   763: pop
    //   764: return
    //   765: aload #5
    //   767: iconst_0
    //   768: putfield what : I
    //   771: aload_0
    //   772: getfield azo : Lcom/laiqian/a;
    //   775: getfield aBS : Landroid/os/Handler;
    //   778: aload #5
    //   780: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   783: pop
    //   784: return
    // Exception table:
    //   from	to	target	type
    //   91	107	113	java/lang/Exception }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */