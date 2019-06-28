package com.laiqian.models;

import android.content.Context;
import android.text.TextUtils;
import com.laiqian.report.models.l;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class b extends d {
  private ConcurrentHashMap<String, String> bNh;
  
  public b(Context paramContext) { super(paramContext); }
  
  public ArrayList<l> a(String paramString, boolean paramBoolean, long paramLong) { // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #17
    //   9: aload_0
    //   10: lload_3
    //   11: lload_3
    //   12: invokevirtual r : (JJ)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore #13
    //   17: aload_0
    //   18: lload_3
    //   19: lload_3
    //   20: invokestatic f : (JJ)Ljava/util/concurrent/ConcurrentHashMap;
    //   23: putfield bNh : Ljava/util/concurrent/ConcurrentHashMap;
    //   26: aload #13
    //   28: astore #14
    //   30: goto -> 52
    //   33: astore #14
    //   35: goto -> 43
    //   38: astore #14
    //   40: aconst_null
    //   41: astore #13
    //   43: aload #14
    //   45: invokestatic e : (Ljava/lang/Throwable;)V
    //   48: aload #13
    //   50: astore #14
    //   52: aload_0
    //   53: getfield bNh : Ljava/util/concurrent/ConcurrentHashMap;
    //   56: invokevirtual entrySet : ()Ljava/util/Set;
    //   59: astore #15
    //   61: ldc ''
    //   63: astore #13
    //   65: aload #15
    //   67: invokeinterface iterator : ()Ljava/util/Iterator;
    //   72: astore #15
    //   74: aload #15
    //   76: invokeinterface hasNext : ()Z
    //   81: ifeq -> 474
    //   84: aload #15
    //   86: invokeinterface next : ()Ljava/lang/Object;
    //   91: checkcast java/util/Map$Entry
    //   94: astore #16
    //   96: new java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: astore #13
    //   105: aload #13
    //   107: ldc 'select '
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload #13
    //   115: aload #16
    //   117: invokeinterface getValue : ()Ljava/lang/Object;
    //   122: checkcast java/lang/String
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload #13
    //   131: ldc '.t_accountdoc.nAccountID,'
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload #13
    //   139: aload #16
    //   141: invokeinterface getValue : ()Ljava/lang/Object;
    //   146: checkcast java/lang/String
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload #13
    //   155: ldc '.t_accountdoc.sAccountName,'
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #13
    //   163: aload #16
    //   165: invokeinterface getValue : ()Ljava/lang/Object;
    //   170: checkcast java/lang/String
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #13
    //   179: ldc '.t_accountdoc.fAccountAmount,'
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #13
    //   187: aload #16
    //   189: invokeinterface getValue : ()Ljava/lang/Object;
    //   194: checkcast java/lang/String
    //   197: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload #13
    //   203: ldc '.t_accountdoc.nSpareField1,'
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload #13
    //   211: aload #16
    //   213: invokeinterface getValue : ()Ljava/lang/Object;
    //   218: checkcast java/lang/String
    //   221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload #13
    //   227: ldc '.t_accountdoc.nSpareField2,'
    //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload #13
    //   235: aload #16
    //   237: invokeinterface getValue : ()Ljava/lang/Object;
    //   242: checkcast java/lang/String
    //   245: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload #13
    //   251: ldc '.t_accountdoc.nMoneyDirection,'
    //   253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload #13
    //   259: aload #16
    //   261: invokeinterface getValue : ()Ljava/lang/Object;
    //   266: checkcast java/lang/String
    //   269: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload #13
    //   275: ldc '.t_accountdoc.nOperationTime,t_user.sUserName,t_user.sUserPhone ,'
    //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload #13
    //   283: aload #16
    //   285: invokeinterface getValue : ()Ljava/lang/Object;
    //   290: checkcast java/lang/String
    //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload #13
    //   299: ldc '.t_accountdoc.sSpareField1 from '
    //   301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload #13
    //   307: aload #16
    //   309: invokeinterface getValue : ()Ljava/lang/Object;
    //   314: checkcast java/lang/String
    //   317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload #13
    //   323: ldc '.t_accountdoc left join t_user on t_user._id='
    //   325: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload #13
    //   331: aload #16
    //   333: invokeinterface getValue : ()Ljava/lang/Object;
    //   338: checkcast java/lang/String
    //   341: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload #13
    //   347: ldc '.t_accountdoc.nUserID where '
    //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload #13
    //   355: aload #16
    //   357: invokeinterface getValue : ()Ljava/lang/Object;
    //   362: checkcast java/lang/String
    //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload #13
    //   371: ldc '.t_accountdoc.sText=? and '
    //   373: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload #13
    //   379: aload #16
    //   381: invokeinterface getValue : ()Ljava/lang/Object;
    //   386: checkcast java/lang/String
    //   389: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload #13
    //   395: ldc '.t_accountdoc.nShopID=?'
    //   397: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload #13
    //   403: invokevirtual toString : ()Ljava/lang/String;
    //   406: astore #13
    //   408: iload_2
    //   409: ifeq -> 471
    //   412: new java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial <init> : ()V
    //   419: astore #18
    //   421: aload #18
    //   423: aload #13
    //   425: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload #18
    //   431: ldc ' and '
    //   433: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload #18
    //   439: aload #16
    //   441: invokeinterface getValue : ()Ljava/lang/Object;
    //   446: checkcast java/lang/String
    //   449: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload #18
    //   455: ldc '.t_accountdoc.nMoneyDirection=-1'
    //   457: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload #18
    //   463: invokevirtual toString : ()Ljava/lang/String;
    //   466: astore #13
    //   468: goto -> 74
    //   471: goto -> 74
    //   474: aload #14
    //   476: aload #13
    //   478: iconst_2
    //   479: anewarray java/lang/String
    //   482: dup
    //   483: iconst_0
    //   484: aload_1
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: aload_0
    //   489: invokevirtual VC : ()Ljava/lang/String;
    //   492: aastore
    //   493: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   496: astore #14
    //   498: aload #14
    //   500: invokeinterface moveToNext : ()Z
    //   505: ifeq -> 1122
    //   508: aload #14
    //   510: iconst_0
    //   511: invokeinterface getInt : (I)I
    //   516: istore #9
    //   518: aload #14
    //   520: iconst_2
    //   521: invokeinterface getDouble : (I)D
    //   526: dstore #5
    //   528: aload #14
    //   530: iconst_3
    //   531: invokeinterface getLong : (I)J
    //   536: lstore_3
    //   537: aload #14
    //   539: iconst_4
    //   540: invokeinterface getInt : (I)I
    //   545: istore #10
    //   547: iload #9
    //   549: sipush #10001
    //   552: if_icmpne -> 626
    //   555: iload #10
    //   557: tableswitch default -> 584, 1 -> 612, 2 -> 598, 3 -> 598
    //   584: aload_0
    //   585: getfield mContext : Landroid/content/Context;
    //   588: ldc 2131627781
    //   590: invokevirtual getString : (I)Ljava/lang/String;
    //   593: astore #13
    //   595: goto -> 994
    //   598: aload_0
    //   599: getfield mContext : Landroid/content/Context;
    //   602: ldc 2131627805
    //   604: invokevirtual getString : (I)Ljava/lang/String;
    //   607: astore #13
    //   609: goto -> 595
    //   612: aload_0
    //   613: getfield mContext : Landroid/content/Context;
    //   616: ldc 2131627790
    //   618: invokevirtual getString : (I)Ljava/lang/String;
    //   621: astore #13
    //   623: goto -> 595
    //   626: iload #9
    //   628: sipush #10007
    //   631: if_icmpeq -> 658
    //   634: iload #9
    //   636: sipush #10009
    //   639: if_icmpne -> 645
    //   642: goto -> 658
    //   645: aload #14
    //   647: iconst_1
    //   648: invokeinterface getString : (I)Ljava/lang/String;
    //   653: astore #13
    //   655: goto -> 595
    //   658: new java/lang/StringBuilder
    //   661: dup
    //   662: invokespecial <init> : ()V
    //   665: astore #13
    //   667: iload #10
    //   669: bipush #15
    //   671: if_icmpeq -> 763
    //   674: iload #10
    //   676: tableswitch default -> 708, 0 -> 763, 1 -> 737, 2 -> 711, 3 -> 711
    //   708: goto -> 786
    //   711: aload #13
    //   713: aload_0
    //   714: getfield mContext : Landroid/content/Context;
    //   717: ldc 2131627171
    //   719: invokevirtual getString : (I)Ljava/lang/String;
    //   722: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload #13
    //   728: ldc '-'
    //   730: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: goto -> 786
    //   737: aload #13
    //   739: aload_0
    //   740: getfield mContext : Landroid/content/Context;
    //   743: ldc 2131627814
    //   745: invokevirtual getString : (I)Ljava/lang/String;
    //   748: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload #13
    //   754: ldc '-'
    //   756: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: goto -> 786
    //   763: aload #13
    //   765: aload_0
    //   766: getfield mContext : Landroid/content/Context;
    //   769: ldc 2131627811
    //   771: invokevirtual getString : (I)Ljava/lang/String;
    //   774: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload #13
    //   780: ldc '-'
    //   782: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: lload_3
    //   787: l2i
    //   788: tableswitch default -> 840, 0 -> 969, 1 -> 951, 2 -> 933, 3 -> 840, 4 -> 915, 5 -> 897, 6 -> 879, 7 -> 861, 8 -> 843
    //   840: goto -> 984
    //   843: aload #13
    //   845: aload_0
    //   846: getfield mContext : Landroid/content/Context;
    //   849: ldc 2131627809
    //   851: invokevirtual getString : (I)Ljava/lang/String;
    //   854: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: goto -> 984
    //   861: aload #13
    //   863: aload_0
    //   864: getfield mContext : Landroid/content/Context;
    //   867: ldc 2131627807
    //   869: invokevirtual getString : (I)Ljava/lang/String;
    //   872: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: pop
    //   876: goto -> 984
    //   879: aload #13
    //   881: aload_0
    //   882: getfield mContext : Landroid/content/Context;
    //   885: ldc 2131627806
    //   887: invokevirtual getString : (I)Ljava/lang/String;
    //   890: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: pop
    //   894: goto -> 984
    //   897: aload #13
    //   899: aload_0
    //   900: getfield mContext : Landroid/content/Context;
    //   903: ldc 2131627808
    //   905: invokevirtual getString : (I)Ljava/lang/String;
    //   908: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: goto -> 984
    //   915: aload #13
    //   917: aload_0
    //   918: getfield mContext : Landroid/content/Context;
    //   921: ldc 2131627800
    //   923: invokevirtual getString : (I)Ljava/lang/String;
    //   926: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: goto -> 984
    //   933: aload #13
    //   935: aload_0
    //   936: getfield mContext : Landroid/content/Context;
    //   939: ldc 2131627801
    //   941: invokevirtual getString : (I)Ljava/lang/String;
    //   944: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: pop
    //   948: goto -> 984
    //   951: aload #13
    //   953: aload_0
    //   954: getfield mContext : Landroid/content/Context;
    //   957: ldc 2131627802
    //   959: invokevirtual getString : (I)Ljava/lang/String;
    //   962: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: pop
    //   966: goto -> 984
    //   969: aload #13
    //   971: aload_0
    //   972: getfield mContext : Landroid/content/Context;
    //   975: ldc 2131627803
    //   977: invokevirtual getString : (I)Ljava/lang/String;
    //   980: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: aload #13
    //   986: invokevirtual toString : ()Ljava/lang/String;
    //   989: astore #13
    //   991: goto -> 595
    //   994: aload #14
    //   996: bipush #6
    //   998: invokeinterface getLong : (I)J
    //   1003: lstore #11
    //   1005: aload #14
    //   1007: bipush #7
    //   1009: invokeinterface getString : (I)Ljava/lang/String;
    //   1014: astore #16
    //   1016: aload #16
    //   1018: ifnull -> 1039
    //   1021: aload #16
    //   1023: astore #15
    //   1025: aload #16
    //   1027: invokevirtual length : ()I
    //   1030: ifne -> 1036
    //   1033: goto -> 1039
    //   1036: goto -> 1053
    //   1039: aload #14
    //   1041: bipush #8
    //   1043: invokeinterface getString : (I)Ljava/lang/String;
    //   1048: astore #15
    //   1050: goto -> 1036
    //   1053: aload #14
    //   1055: iconst_5
    //   1056: invokeinterface getInt : (I)I
    //   1061: istore #10
    //   1063: iload #10
    //   1065: i2d
    //   1066: dstore #7
    //   1068: iload #10
    //   1070: iconst_1
    //   1071: if_icmpne -> 1079
    //   1074: iconst_1
    //   1075: istore_2
    //   1076: goto -> 1081
    //   1079: iconst_0
    //   1080: istore_2
    //   1081: aload #17
    //   1083: new com/laiqian/report/models/l
    //   1086: dup
    //   1087: iload #9
    //   1089: dload #7
    //   1091: dload #5
    //   1093: dmul
    //   1094: aload #13
    //   1096: lload_3
    //   1097: iload_2
    //   1098: aload_1
    //   1099: aload #15
    //   1101: lload #11
    //   1103: aload #14
    //   1105: bipush #9
    //   1107: invokeinterface getString : (I)Ljava/lang/String;
    //   1112: invokespecial <init> : (IDLjava/lang/String;JZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V
    //   1115: invokevirtual add : (Ljava/lang/Object;)Z
    //   1118: pop
    //   1119: goto -> 498
    //   1122: aload #14
    //   1124: invokeinterface close : ()V
    //   1129: aload #17
    //   1131: areturn
    // Exception table:
    //   from	to	target	type
    //   9	17	38	java/lang/Exception
    //   17	26	33	java/lang/Exception }
  
  public boolean a(boolean paramBoolean, long paramLong1, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong2, long paramLong3, long paramLong4, String paramString4) { return a(paramBoolean, paramLong1, paramInt, paramString1, paramString2, paramString3, paramLong2, paramLong3, paramLong4, paramString4, null, null); }
  
  public boolean a(boolean paramBoolean, long paramLong1, int paramInt, String paramString1, String paramString2, String paramString3, long paramLong2, long paramLong3, long paramLong4, String paramString4, String paramString5, String paramString6) {
    String str2;
    String str1;
    if (paramBoolean) {
      str1 = "800001";
      str2 = "1";
    } else {
      str1 = "800002";
      str2 = "-1";
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong1);
    stringBuilder2.append("");
    am("_id", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    am("nAccountID", stringBuilder2.toString());
    am("sAccountName", paramString1);
    am("nAccountTransacType", str1);
    am("nMoneyDirection", str2);
    am("fAccountAmount", paramString2);
    am("sText", paramString3);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramLong2);
    stringBuilder1.append("");
    am("nDateTime", stringBuilder1.toString());
    am("nWarehouseID", VC());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramLong3);
    stringBuilder1.append("");
    am("nSpareField1", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramLong4);
    stringBuilder1.append("");
    am("nSpareField2", stringBuilder1.toString());
    am("sSpareField1", paramString4);
    am("sSpareField2", paramString6);
    if (!TextUtils.isEmpty(paramString5))
      am("nUserID", paramString5); 
    return UF();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */