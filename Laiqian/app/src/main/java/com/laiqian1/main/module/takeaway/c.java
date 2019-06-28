package com.laiqian.main.module.takeaway;

class c implements Runnable {
  c(PosActivityTakeAwayFragment paramPosActivityTakeAwayFragment) {}
  
  public void run() { // Byte code:
    //   0: aload_0
    //   1: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   4: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   7: ifnull -> 1080
    //   10: aload_0
    //   11: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   14: invokevirtual isDetached : ()Z
    //   17: ifeq -> 21
    //   20: return
    //   21: ldc 'tag'
    //   23: ldc 'checking takeout expired orders'
    //   25: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   32: astore #12
    //   34: aload #12
    //   36: invokevirtual aug : ()Ljava/lang/String;
    //   39: astore #9
    //   41: new java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: astore #7
    //   50: aload #7
    //   52: ldc 'all: '
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload #7
    //   60: aload #9
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 'tag'
    //   68: aload #7
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: aload_0
    //   78: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   81: getfield bpd : Ljava/lang/String;
    //   84: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   87: istore #6
    //   89: iconst_0
    //   90: istore #4
    //   92: iconst_1
    //   93: istore #5
    //   95: iload #6
    //   97: ifne -> 917
    //   100: aload #9
    //   102: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   105: ifne -> 917
    //   108: new org/json/JSONObject
    //   111: dup
    //   112: aload #9
    //   114: invokespecial <init> : (Ljava/lang/String;)V
    //   117: astore #8
    //   119: new org/json/JSONObject
    //   122: dup
    //   123: aload_0
    //   124: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   127: getfield bpd : Ljava/lang/String;
    //   130: invokespecial <init> : (Ljava/lang/String;)V
    //   133: astore #13
    //   135: aload #12
    //   137: invokevirtual aui : ()Ljava/lang/String;
    //   140: astore #7
    //   142: aload #8
    //   144: astore #10
    //   146: aload #7
    //   148: astore #9
    //   150: aload #7
    //   152: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   155: ifne -> 251
    //   158: new org/json/JSONObject
    //   161: dup
    //   162: aload #7
    //   164: invokespecial <init> : (Ljava/lang/String;)V
    //   167: astore #9
    //   169: aload_0
    //   170: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   173: aload #9
    //   175: aload #13
    //   177: ldc 'weixin_eat_in'
    //   179: invokestatic a : (Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   182: istore #6
    //   184: aload #9
    //   186: astore #8
    //   188: aload #7
    //   190: astore #10
    //   192: iload #6
    //   194: ifeq -> 259
    //   197: iconst_1
    //   198: istore_1
    //   199: aload #9
    //   201: astore #8
    //   203: goto -> 265
    //   206: astore #10
    //   208: aload #9
    //   210: astore #8
    //   212: aload #10
    //   214: astore #9
    //   216: goto -> 238
    //   219: astore #9
    //   221: goto -> 238
    //   224: astore #7
    //   226: aload #9
    //   228: astore #10
    //   230: aload #7
    //   232: astore #9
    //   234: aload #10
    //   236: astore #7
    //   238: aload #9
    //   240: invokestatic e : (Ljava/lang/Throwable;)V
    //   243: aload #7
    //   245: astore #9
    //   247: aload #8
    //   249: astore #10
    //   251: aload #10
    //   253: astore #8
    //   255: aload #9
    //   257: astore #10
    //   259: iconst_0
    //   260: istore_1
    //   261: aload #10
    //   263: astore #7
    //   265: aload #12
    //   267: invokevirtual auj : ()Ljava/lang/String;
    //   270: astore #9
    //   272: aload #8
    //   274: astore #7
    //   276: aload #9
    //   278: astore #10
    //   280: aload #9
    //   282: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   285: ifne -> 388
    //   288: new org/json/JSONObject
    //   291: dup
    //   292: aload #9
    //   294: invokespecial <init> : (Ljava/lang/String;)V
    //   297: astore #11
    //   299: aload #11
    //   301: astore #7
    //   303: aload #9
    //   305: astore #8
    //   307: aload_0
    //   308: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   311: aload #11
    //   313: aload #13
    //   315: ldc 'meituan'
    //   317: invokestatic a : (Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   320: ifeq -> 384
    //   323: ldc 'meituan'
    //   325: invokestatic oP : (Ljava/lang/String;)V
    //   328: aload #11
    //   330: astore #7
    //   332: aload #9
    //   334: astore #8
    //   336: goto -> 384
    //   339: astore #10
    //   341: aload #11
    //   343: astore #7
    //   345: aload #9
    //   347: astore #8
    //   349: goto -> 379
    //   352: astore #10
    //   354: aload #8
    //   356: astore #7
    //   358: aload #9
    //   360: astore #8
    //   362: goto -> 379
    //   365: astore #10
    //   367: aload #8
    //   369: astore #9
    //   371: aload #7
    //   373: astore #8
    //   375: aload #9
    //   377: astore #7
    //   379: aload #10
    //   381: invokestatic e : (Ljava/lang/Throwable;)V
    //   384: aload #8
    //   386: astore #10
    //   388: aload #12
    //   390: invokevirtual auk : ()Ljava/lang/String;
    //   393: astore #9
    //   395: aload #7
    //   397: astore #10
    //   399: aload #9
    //   401: astore #8
    //   403: aload #9
    //   405: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   408: ifne -> 524
    //   411: new org/json/JSONObject
    //   414: dup
    //   415: aload #9
    //   417: invokespecial <init> : (Ljava/lang/String;)V
    //   420: astore #11
    //   422: aload #9
    //   424: astore #8
    //   426: aload #11
    //   428: astore #7
    //   430: aload_0
    //   431: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   434: aload #11
    //   436: aload #13
    //   438: ldc 'eleme'
    //   440: invokestatic a : (Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   443: ifeq -> 1081
    //   446: ldc 'eleme'
    //   448: invokestatic oP : (Ljava/lang/String;)V
    //   451: aload #9
    //   453: astore #8
    //   455: aload #11
    //   457: astore #7
    //   459: goto -> 1081
    //   462: astore #10
    //   464: aload #9
    //   466: astore #8
    //   468: aload #11
    //   470: astore #9
    //   472: goto -> 506
    //   475: astore #10
    //   477: aload #9
    //   479: astore #8
    //   481: aload #7
    //   483: astore #9
    //   485: goto -> 506
    //   488: astore #8
    //   490: aload #7
    //   492: astore #9
    //   494: aload #8
    //   496: astore #7
    //   498: aload #10
    //   500: astore #8
    //   502: aload #7
    //   504: astore #10
    //   506: iload_1
    //   507: istore_3
    //   508: aload #8
    //   510: astore #7
    //   512: aload #10
    //   514: invokestatic e : (Ljava/lang/Throwable;)V
    //   517: aload #9
    //   519: astore #7
    //   521: goto -> 1081
    //   524: iload_1
    //   525: istore_3
    //   526: aload #8
    //   528: astore #7
    //   530: aload_0
    //   531: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   534: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   537: invokestatic bz : (Landroid/content/Context;)Ljava/util/HashMap;
    //   540: astore #9
    //   542: aload #9
    //   544: ifnull -> 552
    //   547: iconst_1
    //   548: istore_3
    //   549: goto -> 554
    //   552: iconst_0
    //   553: istore_3
    //   554: iload_1
    //   555: istore_2
    //   556: iload_3
    //   557: ifeq -> 602
    //   560: aload_0
    //   561: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   564: aload #10
    //   566: aload #13
    //   568: ldc 'tdd'
    //   570: invokestatic a : (Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   573: istore #6
    //   575: iload_1
    //   576: istore_2
    //   577: iload #6
    //   579: ifeq -> 602
    //   582: iconst_1
    //   583: istore_2
    //   584: goto -> 602
    //   587: astore #9
    //   589: iload_1
    //   590: istore_3
    //   591: aload #8
    //   593: astore #7
    //   595: aload #9
    //   597: invokestatic e : (Ljava/lang/Throwable;)V
    //   600: iload_1
    //   601: istore_2
    //   602: iload_2
    //   603: istore_3
    //   604: aload #8
    //   606: astore #7
    //   608: aload_0
    //   609: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   612: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   615: invokestatic aX : (Landroid/content/Context;)Lcom/laiqian/pos/industry/weiorder/fp;
    //   618: invokevirtual abV : ()Lcom/laiqian/entity/aw;
    //   621: invokevirtual Jq : ()Z
    //   624: istore #6
    //   626: iload #6
    //   628: ifeq -> 1088
    //   631: aload #12
    //   633: invokevirtual aug : ()Ljava/lang/String;
    //   636: astore #9
    //   638: aload #9
    //   640: astore #7
    //   642: iload_2
    //   643: istore_1
    //   644: aload #9
    //   646: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   649: ifne -> 733
    //   652: new org/json/JSONObject
    //   655: dup
    //   656: aload #9
    //   658: invokespecial <init> : (Ljava/lang/String;)V
    //   661: astore #7
    //   663: aload_0
    //   664: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   667: aload #7
    //   669: aload #13
    //   671: ldc 'weixin'
    //   673: invokestatic a : (Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   676: istore #6
    //   678: aload #9
    //   680: astore #7
    //   682: iload_2
    //   683: istore_1
    //   684: iload #6
    //   686: ifeq -> 733
    //   689: iconst_1
    //   690: istore_1
    //   691: aload #9
    //   693: astore #7
    //   695: goto -> 733
    //   698: astore #8
    //   700: aload #9
    //   702: astore #7
    //   704: aload #8
    //   706: astore #9
    //   708: goto -> 717
    //   711: astore #9
    //   713: aload #8
    //   715: astore #7
    //   717: aload #7
    //   719: astore #8
    //   721: iload_2
    //   722: istore_3
    //   723: aload #9
    //   725: invokestatic e : (Ljava/lang/Throwable;)V
    //   728: iload_2
    //   729: istore_1
    //   730: goto -> 733
    //   733: aload #7
    //   735: astore #8
    //   737: iload_1
    //   738: istore_3
    //   739: aload #12
    //   741: invokevirtual auW : ()Z
    //   744: istore #6
    //   746: aload #7
    //   748: astore #9
    //   750: iload_1
    //   751: istore_2
    //   752: iload #6
    //   754: ifeq -> 919
    //   757: aload #12
    //   759: invokevirtual auh : ()Ljava/lang/String;
    //   762: astore #8
    //   764: iload_1
    //   765: istore_2
    //   766: aload #8
    //   768: astore #7
    //   770: aload #8
    //   772: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   775: ifne -> 910
    //   778: new org/json/JSONObject
    //   781: dup
    //   782: aload #8
    //   784: invokespecial <init> : (Ljava/lang/String;)V
    //   787: astore #7
    //   789: aload_0
    //   790: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   793: aload #7
    //   795: aload #13
    //   797: ldc 'koubei'
    //   799: invokestatic a : (Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   802: istore #6
    //   804: iload_1
    //   805: istore_2
    //   806: aload #8
    //   808: astore #7
    //   810: iload #6
    //   812: ifeq -> 910
    //   815: iconst_1
    //   816: istore_2
    //   817: aload #8
    //   819: astore #7
    //   821: goto -> 910
    //   824: astore #9
    //   826: goto -> 835
    //   829: astore #9
    //   831: aload #7
    //   833: astore #8
    //   835: iload_1
    //   836: istore_3
    //   837: aload #8
    //   839: astore #7
    //   841: aload #9
    //   843: invokestatic e : (Ljava/lang/Throwable;)V
    //   846: iload_1
    //   847: istore_2
    //   848: aload #8
    //   850: astore #7
    //   852: goto -> 910
    //   855: astore #9
    //   857: aload #8
    //   859: astore #7
    //   861: aload #9
    //   863: astore #8
    //   865: iload_3
    //   866: istore_1
    //   867: goto -> 903
    //   870: astore #8
    //   872: iload_3
    //   873: istore_1
    //   874: goto -> 903
    //   877: astore #9
    //   879: aload #8
    //   881: astore #7
    //   883: aload #9
    //   885: astore #8
    //   887: goto -> 903
    //   890: astore #8
    //   892: goto -> 901
    //   895: astore #8
    //   897: aload #9
    //   899: astore #7
    //   901: iconst_0
    //   902: istore_1
    //   903: aload #8
    //   905: invokestatic e : (Ljava/lang/Throwable;)V
    //   908: iload_1
    //   909: istore_2
    //   910: aload #7
    //   912: astore #9
    //   914: goto -> 919
    //   917: iconst_0
    //   918: istore_2
    //   919: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   922: invokevirtual avQ : ()I
    //   925: ifle -> 934
    //   928: iload #5
    //   930: istore_1
    //   931: goto -> 936
    //   934: iconst_0
    //   935: istore_1
    //   936: aload #12
    //   938: invokevirtual close : ()V
    //   941: aload_0
    //   942: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   945: aload #9
    //   947: putfield bpd : Ljava/lang/String;
    //   950: aload_0
    //   951: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   954: invokestatic b : (Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;)Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment$a;
    //   957: getfield biy : Lcom/assistne/icondottextview/IconDotTextView;
    //   960: aload_0
    //   961: ldc2_w 60000
    //   964: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   967: pop
    //   968: iload_2
    //   969: ifne -> 976
    //   972: iload_1
    //   973: ifeq -> 1079
    //   976: ldc 'tag'
    //   978: ldc 'here should be print'
    //   980: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   983: pop
    //   984: iload_2
    //   985: ifeq -> 1035
    //   988: new com/laiqian/print/b/g
    //   991: dup
    //   992: invokespecial <init> : ()V
    //   995: astore #7
    //   997: aload #7
    //   999: aload_0
    //   1000: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   1003: ldc 2131628758
    //   1005: invokevirtual getString : (I)Ljava/lang/String;
    //   1008: iconst_3
    //   1009: iconst_0
    //   1010: invokevirtual f : (Ljava/lang/String;II)V
    //   1013: iload #4
    //   1015: istore_1
    //   1016: iload_1
    //   1017: iconst_5
    //   1018: if_icmpge -> 1035
    //   1021: aload #7
    //   1023: ldc ''
    //   1025: invokevirtual ll : (Ljava/lang/String;)V
    //   1028: iload_1
    //   1029: iconst_1
    //   1030: iadd
    //   1031: istore_1
    //   1032: goto -> 1016
    //   1035: aload_0
    //   1036: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   1039: invokestatic c : (Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;)Lcom/laiqian/util/bq;
    //   1042: ifnonnull -> 1067
    //   1045: aload_0
    //   1046: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   1049: new com/laiqian/util/bq
    //   1052: dup
    //   1053: aload_0
    //   1054: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   1057: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   1060: invokespecial <init> : (Landroid/content/Context;)V
    //   1063: invokestatic a : (Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;Lcom/laiqian/util/bq;)Lcom/laiqian/util/bq;
    //   1066: pop
    //   1067: aload_0
    //   1068: getfield bpg : Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;
    //   1071: invokestatic c : (Lcom/laiqian/main/module/takeaway/PosActivityTakeAwayFragment;)Lcom/laiqian/util/bq;
    //   1074: ldc 2131558417
    //   1076: invokevirtual mi : (I)V
    //   1079: return
    //   1080: return
    //   1081: aload #7
    //   1083: astore #10
    //   1085: goto -> 524
    //   1088: aload #8
    //   1090: astore #7
    //   1092: iload_2
    //   1093: istore_1
    //   1094: goto -> 733
    // Exception table:
    //   from	to	target	type
    //   108	135	895	org/json/JSONException
    //   135	142	224	org/json/JSONException
    //   150	169	219	org/json/JSONException
    //   169	184	206	org/json/JSONException
    //   238	243	890	org/json/JSONException
    //   265	272	365	org/json/JSONException
    //   280	299	352	org/json/JSONException
    //   307	328	339	org/json/JSONException
    //   379	384	877	org/json/JSONException
    //   388	395	488	org/json/JSONException
    //   403	422	475	org/json/JSONException
    //   430	451	462	org/json/JSONException
    //   512	517	870	org/json/JSONException
    //   530	542	870	org/json/JSONException
    //   560	575	587	org/json/JSONException
    //   595	600	870	org/json/JSONException
    //   608	626	870	org/json/JSONException
    //   631	638	711	org/json/JSONException
    //   644	678	698	org/json/JSONException
    //   723	728	855	org/json/JSONException
    //   739	746	855	org/json/JSONException
    //   757	764	829	org/json/JSONException
    //   770	804	824	org/json/JSONException
    //   841	846	870	org/json/JSONException }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\takeaway\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */