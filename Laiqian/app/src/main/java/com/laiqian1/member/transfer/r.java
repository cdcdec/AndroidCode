package com.laiqian.member.transfer;

import a.c;
import a.r;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Message;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.am;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class r {
  private static final String TAG = "r";
  
  public static final String bHV = RootApplication.zv().getString(R.string.export_vip_name);
  
  public static final String bHW = RootApplication.zv().getString(R.string.export_vip_number);
  
  public static final String bHX = RootApplication.zv().getString(R.string.export_vip_mobile);
  
  public static final String bHY = RootApplication.zv().getString(R.string.export_vip_birthday);
  
  public static final String bHZ = RootApplication.zv().getString(R.string.export_vip_amount);
  
  public static final String bIa = RootApplication.zv().getString(R.string.export_vip_point);
  
  String[] bIb = { bHV, bHW, bHX, bHY, bHZ, bIa };
  
  private int bIc;
  
  private HashMap<String, Integer> bId = new HashMap();
  
  private Context mContext;
  
  public r(Context paramContext) { this.mContext = paramContext; }
  
  private Message a(r paramr, Message paramMessage) {
    int[] arrayOfInt = new int[6];
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    arrayOfInt[4] = 0;
    arrayOfInt[5] = 0;
    arrayOfInt;
    c[] arrayOfc = paramr.pt(0);
    if (TextUtils.isEmpty(arrayOfc[0].aKn())) {
      paramMessage.arg1 = 1;
      paramMessage.obj = this.mContext.getString(R.string.import_failed_the_table_is_malformed);
      return paramMessage;
    } 
    for (byte b = 0; b < arrayOfc.length; b++) {
      String str = arrayOfc[b].aKn();
      byte b1;
      for (b1 = 0; b1 < this.bIb.length; b1++) {
        if (this.bIb[b1].equals(str)) {
          StringBuilder stringBuilder;
          this.bIc = 0;
          if (arrayOfInt[b1] >= 1) {
            paramMessage.arg1 = 1;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.bIb[b1]);
            stringBuilder.append(this.mContext.getString(R.string.pos_import_exists_same_title));
            paramMessage.obj = stringBuilder.toString();
            break;
          } 
          this.bId.put(stringBuilder, Integer.valueOf(b));
          arrayOfInt[b1] = arrayOfInt[b1] + 1;
          break;
        } 
      } 
    } 
    boolean bool = this.bId.containsKey(bHW);
    if (!this.bId.containsKey(bHX))
      bool = false; 
    if (!bool) {
      paramMessage.arg1 = 1;
      paramMessage.obj = this.mContext.getString(R.string.pos_import_lack_name_title);
    } 
    return paramMessage;
  }
  
  private boolean n(String... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b = 0;
    boolean bool = false;
    while (b < i) {
      if (!TextUtils.isEmpty(paramVarArgs[b]))
        bool = true; 
      b++;
    } 
    return bool;
  }
  
  public Message a(Context paramContext, String paramString, Message paramMessage) { // Byte code:
    //   0: aload_3
    //   1: astore #27
    //   3: new java/util/ArrayList
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore #29
    //   12: new java/util/ArrayList
    //   15: dup
    //   16: invokespecial <init> : ()V
    //   19: astore #33
    //   21: new java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc '/data/data/'
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: aload_1
    //   38: invokevirtual getPackageName : ()Ljava/lang/String;
    //   41: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_3
    //   46: ldc '/'
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_3
    //   53: ldc 'temp.excel'
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_3
    //   60: invokevirtual toString : ()Ljava/lang/String;
    //   63: astore_3
    //   64: new java/io/File
    //   67: dup
    //   68: aload_2
    //   69: invokespecial <init> : (Ljava/lang/String;)V
    //   72: astore_2
    //   73: new java/io/File
    //   76: dup
    //   77: aload_3
    //   78: invokespecial <init> : (Ljava/lang/String;)V
    //   81: astore #36
    //   83: aload_2
    //   84: aload #36
    //   86: invokestatic d : (Ljava/io/File;Ljava/io/File;)Z
    //   89: ifne -> 113
    //   92: aload #27
    //   94: iconst_1
    //   95: putfield arg1 : I
    //   98: aload #27
    //   100: aload_1
    //   101: getstatic com/laiqian/vip/R$string.pos_import_copy_fail : I
    //   104: invokevirtual getString : (I)Ljava/lang/String;
    //   107: putfield obj : Ljava/lang/Object;
    //   110: aload #27
    //   112: areturn
    //   113: new java/io/FileInputStream
    //   116: dup
    //   117: aload #36
    //   119: invokespecial <init> : (Ljava/io/File;)V
    //   122: astore_3
    //   123: aload_3
    //   124: invokestatic u : (Ljava/io/InputStream;)La/u;
    //   127: astore #28
    //   129: aload #28
    //   131: astore #26
    //   133: aload #26
    //   135: iconst_0
    //   136: invokevirtual pG : (I)La/r;
    //   139: astore #37
    //   141: new java/util/Date
    //   144: dup
    //   145: invokespecial <init> : ()V
    //   148: invokevirtual getTime : ()J
    //   151: lstore #21
    //   153: aload_0
    //   154: getfield bId : Ljava/util/HashMap;
    //   157: invokevirtual clear : ()V
    //   160: aload_0
    //   161: aload #37
    //   163: aload #27
    //   165: invokespecial a : (La/r;Landroid/os/Message;)Landroid/os/Message;
    //   168: astore_2
    //   169: new java/util/Date
    //   172: dup
    //   173: invokespecial <init> : ()V
    //   176: invokevirtual getTime : ()J
    //   179: lstore #23
    //   181: getstatic com/laiqian/member/transfer/r.TAG : Ljava/lang/String;
    //   184: astore #27
    //   186: new java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial <init> : ()V
    //   193: astore #30
    //   195: aload #30
    //   197: ldc 'import read excel title  : '
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: lload #23
    //   205: invokestatic valueOf : (J)Ljava/lang/Long;
    //   208: invokevirtual longValue : ()J
    //   211: lstore #23
    //   213: lload #21
    //   215: invokestatic valueOf : (J)Ljava/lang/Long;
    //   218: invokevirtual longValue : ()J
    //   221: lstore #21
    //   223: aload #30
    //   225: lload #23
    //   227: lload #21
    //   229: lsub
    //   230: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload #30
    //   236: ldc ' ms'
    //   238: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload #27
    //   244: aload #30
    //   246: invokevirtual toString : ()Ljava/lang/String;
    //   249: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   252: pop
    //   253: aload_2
    //   254: getfield arg1 : I
    //   257: istore #6
    //   259: iload #6
    //   261: iconst_1
    //   262: if_icmpne -> 299
    //   265: aload_3
    //   266: ifnull -> 281
    //   269: aload_3
    //   270: invokevirtual close : ()V
    //   273: goto -> 281
    //   276: astore_1
    //   277: aload_1
    //   278: invokestatic e : (Ljava/lang/Throwable;)V
    //   281: aload #26
    //   283: ifnull -> 291
    //   286: aload #26
    //   288: invokevirtual close : ()V
    //   291: aload #36
    //   293: invokevirtual delete : ()Z
    //   296: pop
    //   297: aload_2
    //   298: areturn
    //   299: aload_0
    //   300: getfield bId : Ljava/util/HashMap;
    //   303: getstatic com/laiqian/member/transfer/r.bHY : Ljava/lang/String;
    //   306: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   309: astore #27
    //   311: aload #27
    //   313: ifnull -> 407
    //   316: aload_0
    //   317: getfield bId : Ljava/util/HashMap;
    //   320: getstatic com/laiqian/member/transfer/r.bHY : Ljava/lang/String;
    //   323: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   326: checkcast java/lang/Integer
    //   329: invokevirtual intValue : ()I
    //   332: istore #12
    //   334: iconst_1
    //   335: istore #8
    //   337: goto -> 413
    //   340: aload #26
    //   342: astore_1
    //   343: aload_2
    //   344: astore #26
    //   346: aload_3
    //   347: astore_2
    //   348: aload #26
    //   350: astore_3
    //   351: goto -> 2987
    //   354: astore_1
    //   355: aload_1
    //   356: astore #29
    //   358: aload_2
    //   359: astore #27
    //   361: aload_3
    //   362: astore_1
    //   363: aload #26
    //   365: astore #28
    //   367: goto -> 2662
    //   370: astore_1
    //   371: aload_1
    //   372: astore #29
    //   374: aload_2
    //   375: astore #27
    //   377: aload_3
    //   378: astore_1
    //   379: aload #26
    //   381: astore #28
    //   383: goto -> 2733
    //   386: astore #27
    //   388: goto -> 2488
    //   391: astore_1
    //   392: aload_1
    //   393: astore #29
    //   395: aload_2
    //   396: astore #27
    //   398: aload_3
    //   399: astore_1
    //   400: aload #26
    //   402: astore #28
    //   404: goto -> 2918
    //   407: iconst_0
    //   408: istore #8
    //   410: iconst_0
    //   411: istore #12
    //   413: aload_0
    //   414: getfield bId : Ljava/util/HashMap;
    //   417: getstatic com/laiqian/member/transfer/r.bHZ : Ljava/lang/String;
    //   420: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   423: astore #27
    //   425: aload #27
    //   427: ifnull -> 454
    //   430: aload_0
    //   431: getfield bId : Ljava/util/HashMap;
    //   434: getstatic com/laiqian/member/transfer/r.bHZ : Ljava/lang/String;
    //   437: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   440: checkcast java/lang/Integer
    //   443: invokevirtual intValue : ()I
    //   446: istore #6
    //   448: iconst_1
    //   449: istore #9
    //   451: goto -> 460
    //   454: iconst_0
    //   455: istore #6
    //   457: iconst_0
    //   458: istore #9
    //   460: aload_0
    //   461: getfield bId : Ljava/util/HashMap;
    //   464: getstatic com/laiqian/member/transfer/r.bIa : Ljava/lang/String;
    //   467: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   470: astore #27
    //   472: aload #27
    //   474: ifnull -> 501
    //   477: aload_0
    //   478: getfield bId : Ljava/util/HashMap;
    //   481: getstatic com/laiqian/member/transfer/r.bIa : Ljava/lang/String;
    //   484: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   487: checkcast java/lang/Integer
    //   490: invokevirtual intValue : ()I
    //   493: istore #7
    //   495: iconst_1
    //   496: istore #13
    //   498: goto -> 507
    //   501: iconst_0
    //   502: istore #13
    //   504: iconst_0
    //   505: istore #7
    //   507: aload_0
    //   508: getfield bId : Ljava/util/HashMap;
    //   511: astore #27
    //   513: aload #27
    //   515: getstatic com/laiqian/member/transfer/r.bHV : Ljava/lang/String;
    //   518: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   521: astore #27
    //   523: aload #27
    //   525: ifnull -> 583
    //   528: aload_0
    //   529: getfield bId : Ljava/util/HashMap;
    //   532: getstatic com/laiqian/member/transfer/r.bHV : Ljava/lang/String;
    //   535: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   538: checkcast java/lang/Integer
    //   541: invokevirtual intValue : ()I
    //   544: istore #11
    //   546: iconst_1
    //   547: istore #10
    //   549: goto -> 589
    //   552: aload #26
    //   554: astore_1
    //   555: aload_2
    //   556: astore #26
    //   558: aload_3
    //   559: astore_2
    //   560: aload #26
    //   562: astore_3
    //   563: goto -> 2987
    //   566: astore_1
    //   567: goto -> 355
    //   570: astore_1
    //   571: goto -> 371
    //   574: astore #27
    //   576: goto -> 2476
    //   579: astore_1
    //   580: goto -> 392
    //   583: iconst_0
    //   584: istore #10
    //   586: iconst_0
    //   587: istore #11
    //   589: aload #28
    //   591: astore #26
    //   593: aload_0
    //   594: getfield bId : Ljava/util/HashMap;
    //   597: astore #27
    //   599: aload #27
    //   601: getstatic com/laiqian/member/transfer/r.bHW : Ljava/lang/String;
    //   604: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   607: checkcast java/lang/Integer
    //   610: invokevirtual intValue : ()I
    //   613: istore #16
    //   615: aload_0
    //   616: getfield bId : Ljava/util/HashMap;
    //   619: astore #27
    //   621: aload #27
    //   623: getstatic com/laiqian/member/transfer/r.bHX : Ljava/lang/String;
    //   626: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   629: checkcast java/lang/Integer
    //   632: invokevirtual intValue : ()I
    //   635: istore #18
    //   637: aload_2
    //   638: astore #27
    //   640: aload #37
    //   642: invokeinterface aKt : ()I
    //   647: istore #19
    //   649: aload #37
    //   651: invokeinterface aKu : ()I
    //   656: istore #15
    //   658: iload #7
    //   660: istore #14
    //   662: getstatic com/laiqian/member/transfer/r.TAG : Ljava/lang/String;
    //   665: astore #28
    //   667: new java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial <init> : ()V
    //   674: astore #30
    //   676: aload #30
    //   678: ldc_w 'the import excel Rows-----'
    //   681: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload #30
    //   687: iload #19
    //   689: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload #30
    //   695: ldc_w 'Cols---'
    //   698: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload #30
    //   704: iload #15
    //   706: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload #28
    //   712: aload #30
    //   714: invokevirtual toString : ()Ljava/lang/String;
    //   717: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   720: pop
    //   721: new java/util/Date
    //   724: dup
    //   725: invokespecial <init> : ()V
    //   728: invokevirtual getTime : ()J
    //   731: invokestatic valueOf : (J)Ljava/lang/Long;
    //   734: astore #32
    //   736: invokestatic currentTimeMillis : ()J
    //   739: lstore #21
    //   741: aload_0
    //   742: getfield bIc : I
    //   745: istore #7
    //   747: iload #7
    //   749: iconst_1
    //   750: iadd
    //   751: istore #17
    //   753: iconst_0
    //   754: istore #20
    //   756: iload #6
    //   758: istore #7
    //   760: iload #14
    //   762: istore #6
    //   764: iload #11
    //   766: istore #15
    //   768: iload #19
    //   770: istore #14
    //   772: iload #16
    //   774: istore #11
    //   776: aload #29
    //   778: astore #28
    //   780: iload #8
    //   782: istore #16
    //   784: iload #18
    //   786: istore #8
    //   788: iload #17
    //   790: iload #14
    //   792: iconst_1
    //   793: isub
    //   794: if_icmpgt -> 1839
    //   797: aload #28
    //   799: new java/lang/StringBuffer
    //   802: dup
    //   803: invokespecial <init> : ()V
    //   806: invokevirtual add : (Ljava/lang/Object;)Z
    //   809: pop
    //   810: iload #10
    //   812: ifeq -> 3075
    //   815: aload #37
    //   817: iload #15
    //   819: iload #17
    //   821: invokeinterface cu : (II)La/c;
    //   826: invokeinterface aKn : ()Ljava/lang/String;
    //   831: invokevirtual trim : ()Ljava/lang/String;
    //   834: astore #34
    //   836: goto -> 839
    //   839: aload #37
    //   841: iload #11
    //   843: iload #17
    //   845: invokeinterface cu : (II)La/c;
    //   850: invokeinterface aKn : ()Ljava/lang/String;
    //   855: invokevirtual trim : ()Ljava/lang/String;
    //   858: astore #35
    //   860: aload #37
    //   862: iload #8
    //   864: iload #17
    //   866: invokeinterface cu : (II)La/c;
    //   871: invokeinterface aKn : ()Ljava/lang/String;
    //   876: invokevirtual trim : ()Ljava/lang/String;
    //   879: astore #38
    //   881: iload #16
    //   883: ifeq -> 3091
    //   886: aload #37
    //   888: iload #12
    //   890: iload #17
    //   892: invokeinterface cu : (II)La/c;
    //   897: invokeinterface aKn : ()Ljava/lang/String;
    //   902: invokevirtual length : ()I
    //   905: ifle -> 3083
    //   908: aload #37
    //   910: iload #12
    //   912: iload #17
    //   914: invokeinterface cu : (II)La/c;
    //   919: invokeinterface aKn : ()Ljava/lang/String;
    //   924: invokevirtual trim : ()Ljava/lang/String;
    //   927: astore #29
    //   929: goto -> 932
    //   932: iload #9
    //   934: ifeq -> 3107
    //   937: iload #7
    //   939: istore #18
    //   941: aload #37
    //   943: iload #18
    //   945: iload #17
    //   947: invokeinterface cu : (II)La/c;
    //   952: invokeinterface aKn : ()Ljava/lang/String;
    //   957: invokevirtual length : ()I
    //   960: ifle -> 3099
    //   963: aload #37
    //   965: iload #18
    //   967: iload #17
    //   969: invokeinterface cu : (II)La/c;
    //   974: invokeinterface aKn : ()Ljava/lang/String;
    //   979: invokevirtual trim : ()Ljava/lang/String;
    //   982: astore #30
    //   984: goto -> 987
    //   987: iload #7
    //   989: istore #18
    //   991: iload #13
    //   993: ifeq -> 3123
    //   996: iload #6
    //   998: istore #7
    //   1000: aload #37
    //   1002: iload #7
    //   1004: iload #17
    //   1006: invokeinterface cu : (II)La/c;
    //   1011: invokeinterface aKn : ()Ljava/lang/String;
    //   1016: invokevirtual length : ()I
    //   1019: ifle -> 3115
    //   1022: aload #37
    //   1024: iload #7
    //   1026: iload #17
    //   1028: invokeinterface cu : (II)La/c;
    //   1033: invokeinterface aKn : ()Ljava/lang/String;
    //   1038: invokevirtual trim : ()Ljava/lang/String;
    //   1041: astore #31
    //   1043: goto -> 1046
    //   1046: iload #6
    //   1048: istore #19
    //   1050: ldc_w 'balance:'
    //   1053: aload #30
    //   1055: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1058: pop
    //   1059: ldc_w 'point:'
    //   1062: aload #31
    //   1064: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1067: pop
    //   1068: ldc_w 'birthday:'
    //   1071: aload #29
    //   1073: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1076: pop
    //   1077: ldc_w 'mobile:'
    //   1080: aload #38
    //   1082: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1085: pop
    //   1086: aload #30
    //   1088: invokestatic u : (Ljava/lang/CharSequence;)D
    //   1091: dstore #4
    //   1093: aload #31
    //   1095: invokestatic u : (Ljava/lang/CharSequence;)D
    //   1098: invokestatic floor : (D)D
    //   1101: d2i
    //   1102: istore #6
    //   1104: aload_0
    //   1105: bipush #6
    //   1107: anewarray java/lang/String
    //   1110: dup
    //   1111: iconst_0
    //   1112: aload #37
    //   1114: iload #15
    //   1116: iload #17
    //   1118: invokeinterface cu : (II)La/c;
    //   1123: invokeinterface aKn : ()Ljava/lang/String;
    //   1128: aastore
    //   1129: dup
    //   1130: iconst_1
    //   1131: aload #37
    //   1133: iload #11
    //   1135: iload #17
    //   1137: invokeinterface cu : (II)La/c;
    //   1142: invokeinterface aKn : ()Ljava/lang/String;
    //   1147: invokevirtual trim : ()Ljava/lang/String;
    //   1150: aastore
    //   1151: dup
    //   1152: iconst_2
    //   1153: aload #37
    //   1155: iload #8
    //   1157: iload #17
    //   1159: invokeinterface cu : (II)La/c;
    //   1164: invokeinterface aKn : ()Ljava/lang/String;
    //   1169: invokevirtual trim : ()Ljava/lang/String;
    //   1172: aastore
    //   1173: dup
    //   1174: iconst_3
    //   1175: aload #37
    //   1177: iload #12
    //   1179: iload #17
    //   1181: invokeinterface cu : (II)La/c;
    //   1186: invokeinterface aKn : ()Ljava/lang/String;
    //   1191: aastore
    //   1192: dup
    //   1193: iconst_4
    //   1194: aload #37
    //   1196: iload #18
    //   1198: iload #17
    //   1200: invokeinterface cu : (II)La/c;
    //   1205: invokeinterface aKn : ()Ljava/lang/String;
    //   1210: aastore
    //   1211: dup
    //   1212: iconst_5
    //   1213: aload #37
    //   1215: iload #19
    //   1217: iload #17
    //   1219: invokeinterface cu : (II)La/c;
    //   1224: invokeinterface aKn : ()Ljava/lang/String;
    //   1229: aastore
    //   1230: invokespecial n : ([Ljava/lang/String;)Z
    //   1233: istore #25
    //   1235: iload #20
    //   1237: bipush #6
    //   1239: if_icmplt -> 3131
    //   1242: goto -> 1839
    //   1245: aload #35
    //   1247: astore #31
    //   1249: aload #31
    //   1251: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1254: ifeq -> 3154
    //   1257: aload #28
    //   1259: iload #17
    //   1261: iconst_1
    //   1262: isub
    //   1263: invokevirtual get : (I)Ljava/lang/Object;
    //   1266: checkcast java/lang/StringBuffer
    //   1269: astore #35
    //   1271: new java/lang/StringBuilder
    //   1274: dup
    //   1275: invokespecial <init> : ()V
    //   1278: astore #39
    //   1280: aload #39
    //   1282: aload_0
    //   1283: getfield mContext : Landroid/content/Context;
    //   1286: getstatic com/laiqian/vip/R$string.pos_member_number_can_not_be_empty : I
    //   1289: invokevirtual getString : (I)Ljava/lang/String;
    //   1292: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: aload #39
    //   1298: ldc_w ' '
    //   1301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: pop
    //   1305: aload #35
    //   1307: aload #39
    //   1309: invokevirtual toString : ()Ljava/lang/String;
    //   1312: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1315: pop
    //   1316: iconst_1
    //   1317: istore #6
    //   1319: goto -> 1322
    //   1322: aload #28
    //   1324: astore #35
    //   1326: iload #6
    //   1328: istore #7
    //   1330: ldc_w '0'
    //   1333: aload #30
    //   1335: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1338: ifne -> 1415
    //   1341: iload #6
    //   1343: istore #7
    //   1345: aload #30
    //   1347: invokestatic pv : (Ljava/lang/String;)Z
    //   1350: ifne -> 1415
    //   1353: aload #35
    //   1355: iload #17
    //   1357: iconst_1
    //   1358: isub
    //   1359: invokevirtual get : (I)Ljava/lang/Object;
    //   1362: checkcast java/lang/StringBuffer
    //   1365: astore #30
    //   1367: new java/lang/StringBuilder
    //   1370: dup
    //   1371: invokespecial <init> : ()V
    //   1374: astore #39
    //   1376: aload #39
    //   1378: aload_0
    //   1379: getfield mContext : Landroid/content/Context;
    //   1382: getstatic com/laiqian/vip/R$string.pos_member_balance_format_is_error : I
    //   1385: invokevirtual getString : (I)Ljava/lang/String;
    //   1388: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: pop
    //   1392: aload #39
    //   1394: ldc_w ' '
    //   1397: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: pop
    //   1401: aload #30
    //   1403: aload #39
    //   1405: invokevirtual toString : ()Ljava/lang/String;
    //   1408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1411: pop
    //   1412: iconst_1
    //   1413: istore #7
    //   1415: aload #38
    //   1417: invokestatic pw : (Ljava/lang/String;)Z
    //   1420: ifne -> 1555
    //   1423: aload #38
    //   1425: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1428: ifeq -> 1493
    //   1431: aload #35
    //   1433: iload #17
    //   1435: iconst_1
    //   1436: isub
    //   1437: invokevirtual get : (I)Ljava/lang/Object;
    //   1440: checkcast java/lang/StringBuffer
    //   1443: astore #30
    //   1445: new java/lang/StringBuilder
    //   1448: dup
    //   1449: invokespecial <init> : ()V
    //   1452: astore #39
    //   1454: aload #39
    //   1456: aload_0
    //   1457: getfield mContext : Landroid/content/Context;
    //   1460: getstatic com/laiqian/vip/R$string.pos_member_mobile_can_not_be_empty : I
    //   1463: invokevirtual getString : (I)Ljava/lang/String;
    //   1466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: pop
    //   1470: aload #39
    //   1472: ldc_w ' '
    //   1475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: pop
    //   1479: aload #30
    //   1481: aload #39
    //   1483: invokevirtual toString : ()Ljava/lang/String;
    //   1486: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1489: pop
    //   1490: goto -> 3160
    //   1493: aload #35
    //   1495: iload #17
    //   1497: iconst_1
    //   1498: isub
    //   1499: invokevirtual get : (I)Ljava/lang/Object;
    //   1502: checkcast java/lang/StringBuffer
    //   1505: astore #30
    //   1507: new java/lang/StringBuilder
    //   1510: dup
    //   1511: invokespecial <init> : ()V
    //   1514: astore #39
    //   1516: aload #39
    //   1518: aload_0
    //   1519: getfield mContext : Landroid/content/Context;
    //   1522: getstatic com/laiqian/vip/R$string.pos_member_phone_format_is_error : I
    //   1525: invokevirtual getString : (I)Ljava/lang/String;
    //   1528: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: pop
    //   1532: aload #39
    //   1534: ldc_w ' '
    //   1537: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: pop
    //   1541: aload #30
    //   1543: aload #39
    //   1545: invokevirtual toString : ()Ljava/lang/String;
    //   1548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1551: pop
    //   1552: goto -> 3160
    //   1555: ldc_w '(%s|%s|%s)'
    //   1558: iconst_3
    //   1559: anewarray java/lang/Object
    //   1562: dup
    //   1563: iconst_0
    //   1564: ldc_w '(0?[13578]|1[02])-(0?[1-9]|[12][0-9]|3[01])'
    //   1567: aastore
    //   1568: dup
    //   1569: iconst_1
    //   1570: ldc_w '0?2-(0?[1-9]|[12][0-9])'
    //   1573: aastore
    //   1574: dup
    //   1575: iconst_2
    //   1576: ldc_w '(0?[469]|11)-(0?[1-9]|[12][0-9]|30)'
    //   1579: aastore
    //   1580: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1583: astore #30
    //   1585: ldc_w '^%s$'
    //   1588: iconst_1
    //   1589: anewarray java/lang/Object
    //   1592: dup
    //   1593: iconst_0
    //   1594: aload #30
    //   1596: aastore
    //   1597: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1600: astore #39
    //   1602: iload #7
    //   1604: istore #6
    //   1606: ldc_w '^[0-2][0-9]{3}-%s$'
    //   1609: iconst_1
    //   1610: anewarray java/lang/Object
    //   1613: dup
    //   1614: iconst_0
    //   1615: aload #30
    //   1617: aastore
    //   1618: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1621: aload #29
    //   1623: invokestatic bf : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1626: ifne -> 1705
    //   1629: iload #7
    //   1631: istore #6
    //   1633: aload #39
    //   1635: aload #29
    //   1637: invokestatic bf : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1640: ifne -> 1705
    //   1643: aload #35
    //   1645: iload #17
    //   1647: iconst_1
    //   1648: isub
    //   1649: invokevirtual get : (I)Ljava/lang/Object;
    //   1652: checkcast java/lang/StringBuffer
    //   1655: astore #30
    //   1657: new java/lang/StringBuilder
    //   1660: dup
    //   1661: invokespecial <init> : ()V
    //   1664: astore #35
    //   1666: aload #35
    //   1668: aload_0
    //   1669: getfield mContext : Landroid/content/Context;
    //   1672: getstatic com/laiqian/vip/R$string.pos_member_birthday_format_is_error : I
    //   1675: invokevirtual getString : (I)Ljava/lang/String;
    //   1678: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1681: pop
    //   1682: aload #35
    //   1684: ldc_w ' '
    //   1687: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: pop
    //   1691: aload #30
    //   1693: aload #35
    //   1695: invokevirtual toString : ()Ljava/lang/String;
    //   1698: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1701: pop
    //   1702: iconst_1
    //   1703: istore #6
    //   1705: iload #6
    //   1707: ifeq -> 1720
    //   1710: aload #33
    //   1712: aconst_null
    //   1713: invokevirtual add : (Ljava/lang/Object;)Z
    //   1716: pop
    //   1717: goto -> 1768
    //   1720: lload #21
    //   1722: lconst_1
    //   1723: ladd
    //   1724: lstore #21
    //   1726: aload #33
    //   1728: new com/laiqian/entity/aq$a
    //   1731: dup
    //   1732: lload #21
    //   1734: aload #31
    //   1736: aload #38
    //   1738: invokespecial <init> : (JLjava/lang/String;Ljava/lang/String;)V
    //   1741: dload #4
    //   1743: invokevirtual W : (D)Lcom/laiqian/entity/aq$a;
    //   1746: aload #29
    //   1748: invokevirtual dA : (Ljava/lang/String;)Lcom/laiqian/entity/aq$a;
    //   1751: aload #34
    //   1753: invokevirtual dz : (Ljava/lang/String;)Lcom/laiqian/entity/aq$a;
    //   1756: iload #20
    //   1758: invokevirtual eG : (I)Lcom/laiqian/entity/aq$a;
    //   1761: invokevirtual IW : ()Lcom/laiqian/entity/aq;
    //   1764: invokevirtual add : (Ljava/lang/Object;)Z
    //   1767: pop
    //   1768: iconst_0
    //   1769: istore #6
    //   1771: goto -> 1780
    //   1774: iload #20
    //   1776: iconst_1
    //   1777: iadd
    //   1778: istore #6
    //   1780: iload #17
    //   1782: iconst_1
    //   1783: iadd
    //   1784: istore #17
    //   1786: iload #18
    //   1788: istore #7
    //   1790: iload #6
    //   1792: istore #20
    //   1794: iload #19
    //   1796: istore #6
    //   1798: goto -> 788
    //   1801: aload #26
    //   1803: astore_1
    //   1804: aload_3
    //   1805: astore_2
    //   1806: aload #27
    //   1808: astore_3
    //   1809: goto -> 2987
    //   1812: astore_1
    //   1813: goto -> 355
    //   1816: astore_1
    //   1817: goto -> 371
    //   1820: astore #30
    //   1822: aload_2
    //   1823: astore #27
    //   1825: aload_3
    //   1826: astore #28
    //   1828: aload #26
    //   1830: astore #29
    //   1832: goto -> 2805
    //   1835: astore_1
    //   1836: goto -> 392
    //   1839: new com/laiqian/models/l
    //   1842: dup
    //   1843: aload_0
    //   1844: getfield mContext : Landroid/content/Context;
    //   1847: invokespecial <init> : (Landroid/content/Context;)V
    //   1850: astore #29
    //   1852: aload #29
    //   1854: aload #33
    //   1856: aload #28
    //   1858: invokevirtual a : (Ljava/util/ArrayList;Ljava/util/ArrayList;)I
    //   1861: istore #8
    //   1863: aload #29
    //   1865: invokevirtual close : ()V
    //   1868: iload #8
    //   1870: ifne -> 1963
    //   1873: aload #27
    //   1875: iconst_1
    //   1876: putfield arg1 : I
    //   1879: getstatic com/laiqian/vip/R$string.import_failed_please_check_the_table_contents : I
    //   1882: istore #6
    //   1884: aload #27
    //   1886: aload_1
    //   1887: iload #6
    //   1889: invokevirtual getString : (I)Ljava/lang/String;
    //   1892: putfield obj : Ljava/lang/Object;
    //   1895: goto -> 2143
    //   1898: astore #27
    //   1900: goto -> 1945
    //   1903: astore_1
    //   1904: goto -> 355
    //   1907: astore_1
    //   1908: goto -> 371
    //   1911: astore_1
    //   1912: goto -> 392
    //   1915: aload_2
    //   1916: astore #27
    //   1918: goto -> 1801
    //   1921: astore #29
    //   1923: aload_3
    //   1924: astore_1
    //   1925: aload #26
    //   1927: astore #28
    //   1929: goto -> 2662
    //   1932: astore #29
    //   1934: aload_3
    //   1935: astore_1
    //   1936: aload #26
    //   1938: astore #28
    //   1940: goto -> 2733
    //   1943: astore #27
    //   1945: aload #27
    //   1947: astore #30
    //   1949: goto -> 1822
    //   1952: astore #29
    //   1954: aload_3
    //   1955: astore_1
    //   1956: aload #26
    //   1958: astore #28
    //   1960: goto -> 2918
    //   1963: new java/lang/StringBuffer
    //   1966: dup
    //   1967: invokespecial <init> : ()V
    //   1970: astore #29
    //   1972: iconst_0
    //   1973: istore #6
    //   1975: iconst_0
    //   1976: istore #7
    //   1978: aload #28
    //   1980: invokevirtual size : ()I
    //   1983: istore #9
    //   1985: iload #6
    //   1987: iload #9
    //   1989: if_icmpge -> 2081
    //   1992: aload #28
    //   1994: iload #6
    //   1996: invokevirtual get : (I)Ljava/lang/Object;
    //   1999: checkcast java/lang/StringBuffer
    //   2002: invokevirtual length : ()I
    //   2005: ifle -> 3166
    //   2008: iload #7
    //   2010: iconst_1
    //   2011: iadd
    //   2012: istore #7
    //   2014: aload #27
    //   2016: iconst_3
    //   2017: putfield arg1 : I
    //   2020: aload #29
    //   2022: aload_0
    //   2023: getfield mContext : Landroid/content/Context;
    //   2026: getstatic com/laiqian/vip/R$string.row : I
    //   2029: invokevirtual getString : (I)Ljava/lang/String;
    //   2032: iconst_1
    //   2033: anewarray java/lang/Object
    //   2036: dup
    //   2037: iconst_0
    //   2038: iload #6
    //   2040: iconst_1
    //   2041: iadd
    //   2042: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   2045: aastore
    //   2046: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2049: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2052: pop
    //   2053: aload #29
    //   2055: aload #28
    //   2057: iload #6
    //   2059: invokevirtual get : (I)Ljava/lang/Object;
    //   2062: checkcast java/lang/StringBuffer
    //   2065: invokevirtual append : (Ljava/lang/StringBuffer;)Ljava/lang/StringBuffer;
    //   2068: pop
    //   2069: aload #29
    //   2071: ldc_w '\\n'
    //   2074: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2077: pop
    //   2078: goto -> 3166
    //   2081: iload #7
    //   2083: ifne -> 2092
    //   2086: aload #27
    //   2088: iconst_0
    //   2089: putfield arg1 : I
    //   2092: aload_0
    //   2093: getfield mContext : Landroid/content/Context;
    //   2096: getstatic com/laiqian/vip/R$string.import_complete_with_statistics : I
    //   2099: invokevirtual getString : (I)Ljava/lang/String;
    //   2102: astore #28
    //   2104: aload #27
    //   2106: aload #29
    //   2108: iconst_0
    //   2109: aload #28
    //   2111: iconst_2
    //   2112: anewarray java/lang/Object
    //   2115: dup
    //   2116: iconst_0
    //   2117: iload #8
    //   2119: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   2122: aastore
    //   2123: dup
    //   2124: iconst_1
    //   2125: iload #7
    //   2127: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   2130: aastore
    //   2131: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2134: invokevirtual insert : (ILjava/lang/String;)Ljava/lang/StringBuffer;
    //   2137: invokevirtual toString : ()Ljava/lang/String;
    //   2140: putfield obj : Ljava/lang/Object;
    //   2143: new java/util/Date
    //   2146: dup
    //   2147: invokespecial <init> : ()V
    //   2150: invokevirtual getTime : ()J
    //   2153: lstore #21
    //   2155: getstatic com/laiqian/member/transfer/r.TAG : Ljava/lang/String;
    //   2158: astore #27
    //   2160: new java/lang/StringBuilder
    //   2163: dup
    //   2164: invokespecial <init> : ()V
    //   2167: astore #28
    //   2169: aload #28
    //   2171: ldc_w 'import read excel data  : '
    //   2174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2177: pop
    //   2178: aload #28
    //   2180: lload #21
    //   2182: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2185: invokevirtual longValue : ()J
    //   2188: aload #32
    //   2190: invokevirtual longValue : ()J
    //   2193: lsub
    //   2194: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   2197: pop
    //   2198: aload #28
    //   2200: ldc ' ms'
    //   2202: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: pop
    //   2206: aload #27
    //   2208: aload #28
    //   2210: invokevirtual toString : ()Ljava/lang/String;
    //   2213: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   2216: pop
    //   2217: new java/util/Date
    //   2220: dup
    //   2221: invokespecial <init> : ()V
    //   2224: invokevirtual getTime : ()J
    //   2227: lstore #21
    //   2229: new java/util/Date
    //   2232: dup
    //   2233: invokespecial <init> : ()V
    //   2236: invokevirtual getTime : ()J
    //   2239: lstore #23
    //   2241: getstatic com/laiqian/member/transfer/r.TAG : Ljava/lang/String;
    //   2244: astore #27
    //   2246: new java/lang/StringBuilder
    //   2249: dup
    //   2250: invokespecial <init> : ()V
    //   2253: astore #28
    //   2255: aload #28
    //   2257: ldc_w 'import excel data  : '
    //   2260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2263: pop
    //   2264: aload #28
    //   2266: lload #23
    //   2268: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2271: invokevirtual longValue : ()J
    //   2274: lload #21
    //   2276: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2279: invokevirtual longValue : ()J
    //   2282: lsub
    //   2283: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   2286: pop
    //   2287: aload #28
    //   2289: ldc ' ms'
    //   2291: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2294: pop
    //   2295: aload #27
    //   2297: aload #28
    //   2299: invokevirtual toString : ()Ljava/lang/String;
    //   2302: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   2305: pop
    //   2306: aload_3
    //   2307: ifnull -> 2322
    //   2310: aload_3
    //   2311: invokevirtual close : ()V
    //   2314: goto -> 2322
    //   2317: astore_1
    //   2318: aload_1
    //   2319: invokestatic e : (Ljava/lang/Throwable;)V
    //   2322: aload #26
    //   2324: ifnull -> 2332
    //   2327: aload #26
    //   2329: invokevirtual close : ()V
    //   2332: aload #36
    //   2334: invokevirtual delete : ()Z
    //   2337: pop
    //   2338: aload_2
    //   2339: areturn
    //   2340: astore_1
    //   2341: goto -> 2400
    //   2344: astore_1
    //   2345: goto -> 2404
    //   2348: astore #27
    //   2350: goto -> 2409
    //   2353: astore_1
    //   2354: goto -> 2413
    //   2357: aload #26
    //   2359: astore_1
    //   2360: aload_3
    //   2361: astore_2
    //   2362: aload #27
    //   2364: astore_3
    //   2365: goto -> 2987
    //   2368: astore_1
    //   2369: goto -> 2426
    //   2372: astore_1
    //   2373: goto -> 2433
    //   2376: astore #27
    //   2378: goto -> 2387
    //   2381: astore_1
    //   2382: goto -> 2445
    //   2385: astore #27
    //   2387: goto -> 2441
    //   2390: aload #26
    //   2392: astore_1
    //   2393: aload_2
    //   2394: astore #27
    //   2396: goto -> 2545
    //   2399: astore_1
    //   2400: goto -> 2426
    //   2403: astore_1
    //   2404: goto -> 2433
    //   2407: astore #27
    //   2409: goto -> 2441
    //   2412: astore_1
    //   2413: goto -> 2445
    //   2416: aload #26
    //   2418: astore_1
    //   2419: aload_2
    //   2420: astore #27
    //   2422: goto -> 2545
    //   2425: astore_1
    //   2426: aload_2
    //   2427: astore #27
    //   2429: goto -> 2554
    //   2432: astore_1
    //   2433: aload_2
    //   2434: astore #27
    //   2436: goto -> 2567
    //   2439: astore #27
    //   2441: goto -> 2488
    //   2444: astore_1
    //   2445: aload_2
    //   2446: astore #27
    //   2448: goto -> 2594
    //   2451: aload #26
    //   2453: astore_1
    //   2454: aload_2
    //   2455: astore #27
    //   2457: goto -> 2545
    //   2460: astore_1
    //   2461: aload_2
    //   2462: astore #27
    //   2464: goto -> 2554
    //   2467: astore_1
    //   2468: aload_2
    //   2469: astore #27
    //   2471: goto -> 2567
    //   2474: astore #27
    //   2476: goto -> 2488
    //   2479: astore_1
    //   2480: aload_2
    //   2481: astore #27
    //   2483: goto -> 2594
    //   2486: astore #27
    //   2488: aload_2
    //   2489: astore #28
    //   2491: aload #27
    //   2493: astore_2
    //   2494: aload #28
    //   2496: astore #27
    //   2498: goto -> 2580
    //   2501: aload #26
    //   2503: astore_1
    //   2504: aload_2
    //   2505: astore #27
    //   2507: goto -> 2545
    //   2510: astore_1
    //   2511: aload_2
    //   2512: astore #27
    //   2514: goto -> 2554
    //   2517: astore_1
    //   2518: aload_2
    //   2519: astore #27
    //   2521: goto -> 2567
    //   2524: astore #28
    //   2526: aload_2
    //   2527: astore #27
    //   2529: aload #28
    //   2531: astore_2
    //   2532: goto -> 2580
    //   2535: astore_1
    //   2536: aload_2
    //   2537: astore #27
    //   2539: goto -> 2594
    //   2542: aload #26
    //   2544: astore_1
    //   2545: aload_3
    //   2546: astore_2
    //   2547: aload #27
    //   2549: astore_3
    //   2550: goto -> 2987
    //   2553: astore_1
    //   2554: aload_1
    //   2555: astore #29
    //   2557: aload_3
    //   2558: astore_1
    //   2559: aload #26
    //   2561: astore #28
    //   2563: goto -> 2662
    //   2566: astore_1
    //   2567: aload_1
    //   2568: astore #29
    //   2570: aload_3
    //   2571: astore_1
    //   2572: aload #26
    //   2574: astore #28
    //   2576: goto -> 2733
    //   2579: astore_2
    //   2580: aload_2
    //   2581: astore #30
    //   2583: aload_3
    //   2584: astore #28
    //   2586: aload #26
    //   2588: astore #29
    //   2590: goto -> 2805
    //   2593: astore_1
    //   2594: aload_1
    //   2595: astore #29
    //   2597: aload_3
    //   2598: astore_1
    //   2599: aload #26
    //   2601: astore #28
    //   2603: goto -> 2918
    //   2606: aload_3
    //   2607: astore_2
    //   2608: aload #27
    //   2610: astore_3
    //   2611: aconst_null
    //   2612: astore_1
    //   2613: goto -> 2987
    //   2616: astore #29
    //   2618: aload_3
    //   2619: astore_1
    //   2620: goto -> 2659
    //   2623: astore #29
    //   2625: aload_3
    //   2626: astore_1
    //   2627: goto -> 2730
    //   2630: astore #30
    //   2632: aload_3
    //   2633: astore #28
    //   2635: goto -> 2802
    //   2638: astore #29
    //   2640: aload_3
    //   2641: astore_1
    //   2642: goto -> 2915
    //   2645: aload #27
    //   2647: astore_3
    //   2648: aconst_null
    //   2649: astore_1
    //   2650: aconst_null
    //   2651: astore_2
    //   2652: goto -> 2987
    //   2655: astore #29
    //   2657: aconst_null
    //   2658: astore_1
    //   2659: aconst_null
    //   2660: astore #28
    //   2662: aload #27
    //   2664: astore #26
    //   2666: aload_1
    //   2667: astore_2
    //   2668: aload #28
    //   2670: astore_3
    //   2671: aload #27
    //   2673: iconst_1
    //   2674: putfield what : I
    //   2677: aload #27
    //   2679: astore #26
    //   2681: aload_1
    //   2682: astore_2
    //   2683: aload #28
    //   2685: astore_3
    //   2686: aload #29
    //   2688: invokestatic e : (Ljava/lang/Throwable;)V
    //   2691: aload_1
    //   2692: ifnull -> 2707
    //   2695: aload_1
    //   2696: invokevirtual close : ()V
    //   2699: goto -> 2707
    //   2702: astore_1
    //   2703: aload_1
    //   2704: invokestatic e : (Ljava/lang/Throwable;)V
    //   2707: aload #28
    //   2709: ifnull -> 2717
    //   2712: aload #28
    //   2714: invokevirtual close : ()V
    //   2717: aload #36
    //   2719: invokevirtual delete : ()Z
    //   2722: pop
    //   2723: aload #27
    //   2725: areturn
    //   2726: astore #29
    //   2728: aconst_null
    //   2729: astore_1
    //   2730: aconst_null
    //   2731: astore #28
    //   2733: aload #27
    //   2735: astore #26
    //   2737: aload_1
    //   2738: astore_2
    //   2739: aload #28
    //   2741: astore_3
    //   2742: aload #27
    //   2744: iconst_1
    //   2745: putfield what : I
    //   2748: aload #27
    //   2750: astore #26
    //   2752: aload_1
    //   2753: astore_2
    //   2754: aload #28
    //   2756: astore_3
    //   2757: aload #29
    //   2759: invokestatic e : (Ljava/lang/Throwable;)V
    //   2762: aload_1
    //   2763: ifnull -> 2778
    //   2766: aload_1
    //   2767: invokevirtual close : ()V
    //   2770: goto -> 2778
    //   2773: astore_1
    //   2774: aload_1
    //   2775: invokestatic e : (Ljava/lang/Throwable;)V
    //   2778: aload #28
    //   2780: ifnull -> 2788
    //   2783: aload #28
    //   2785: invokevirtual close : ()V
    //   2788: aload #36
    //   2790: invokevirtual delete : ()Z
    //   2793: pop
    //   2794: aload #27
    //   2796: areturn
    //   2797: astore #30
    //   2799: aconst_null
    //   2800: astore #28
    //   2802: aconst_null
    //   2803: astore #29
    //   2805: aload #27
    //   2807: astore #26
    //   2809: aload #28
    //   2811: astore_2
    //   2812: aload #29
    //   2814: astore_3
    //   2815: aload #27
    //   2817: iconst_1
    //   2818: putfield what : I
    //   2821: aload #27
    //   2823: astore #26
    //   2825: aload #28
    //   2827: astore_2
    //   2828: aload #29
    //   2830: astore_3
    //   2831: aload #27
    //   2833: aload_1
    //   2834: getstatic com/laiqian/vip/R$string.import_failed_not_support_xlsx : I
    //   2837: invokevirtual getString : (I)Ljava/lang/String;
    //   2840: putfield obj : Ljava/lang/Object;
    //   2843: aload #27
    //   2845: astore #26
    //   2847: aload #28
    //   2849: astore_2
    //   2850: aload #29
    //   2852: astore_3
    //   2853: aload #27
    //   2855: iconst_1
    //   2856: putfield arg1 : I
    //   2859: aload #27
    //   2861: astore #26
    //   2863: aload #28
    //   2865: astore_2
    //   2866: aload #29
    //   2868: astore_3
    //   2869: aload #30
    //   2871: invokestatic e : (Ljava/lang/Throwable;)V
    //   2874: aload #28
    //   2876: ifnull -> 2892
    //   2879: aload #28
    //   2881: invokevirtual close : ()V
    //   2884: goto -> 2892
    //   2887: astore_1
    //   2888: aload_1
    //   2889: invokestatic e : (Ljava/lang/Throwable;)V
    //   2892: aload #29
    //   2894: ifnull -> 2902
    //   2897: aload #29
    //   2899: invokevirtual close : ()V
    //   2902: aload #36
    //   2904: invokevirtual delete : ()Z
    //   2907: pop
    //   2908: aload #27
    //   2910: areturn
    //   2911: astore #29
    //   2913: aconst_null
    //   2914: astore_1
    //   2915: aconst_null
    //   2916: astore #28
    //   2918: aload #27
    //   2920: astore #26
    //   2922: aload_1
    //   2923: astore_2
    //   2924: aload #28
    //   2926: astore_3
    //   2927: aload #27
    //   2929: iconst_1
    //   2930: putfield what : I
    //   2933: aload #27
    //   2935: astore #26
    //   2937: aload_1
    //   2938: astore_2
    //   2939: aload #28
    //   2941: astore_3
    //   2942: aload #29
    //   2944: invokestatic e : (Ljava/lang/Throwable;)V
    //   2947: aload_1
    //   2948: ifnull -> 2963
    //   2951: aload_1
    //   2952: invokevirtual close : ()V
    //   2955: goto -> 2963
    //   2958: astore_1
    //   2959: aload_1
    //   2960: invokestatic e : (Ljava/lang/Throwable;)V
    //   2963: aload #28
    //   2965: ifnull -> 2973
    //   2968: aload #28
    //   2970: invokevirtual close : ()V
    //   2973: aload #36
    //   2975: invokevirtual delete : ()Z
    //   2978: pop
    //   2979: aload #27
    //   2981: areturn
    //   2982: aload_3
    //   2983: astore_1
    //   2984: aload #26
    //   2986: astore_3
    //   2987: aload_2
    //   2988: ifnull -> 3003
    //   2991: aload_2
    //   2992: invokevirtual close : ()V
    //   2995: goto -> 3003
    //   2998: astore_2
    //   2999: aload_2
    //   3000: invokestatic e : (Ljava/lang/Throwable;)V
    //   3003: aload_1
    //   3004: ifnull -> 3011
    //   3007: aload_1
    //   3008: invokevirtual close : ()V
    //   3011: aload #36
    //   3013: invokevirtual delete : ()Z
    //   3016: pop
    //   3017: aload_3
    //   3018: areturn
    //   3019: astore_1
    //   3020: goto -> 2645
    //   3023: astore_1
    //   3024: goto -> 2606
    //   3027: astore_1
    //   3028: goto -> 2542
    //   3031: astore_1
    //   3032: goto -> 2501
    //   3035: astore_1
    //   3036: goto -> 340
    //   3039: astore_1
    //   3040: goto -> 2451
    //   3043: astore_1
    //   3044: goto -> 552
    //   3047: astore_1
    //   3048: goto -> 2416
    //   3051: astore_1
    //   3052: goto -> 2390
    //   3055: astore_1
    //   3056: goto -> 2357
    //   3059: astore_1
    //   3060: goto -> 1801
    //   3063: astore_1
    //   3064: goto -> 1915
    //   3067: astore_1
    //   3068: goto -> 2390
    //   3071: astore_1
    //   3072: goto -> 2982
    //   3075: ldc_w ''
    //   3078: astore #34
    //   3080: goto -> 839
    //   3083: ldc_w '1-1'
    //   3086: astore #29
    //   3088: goto -> 932
    //   3091: ldc_w '1-1'
    //   3094: astore #29
    //   3096: goto -> 932
    //   3099: ldc_w '0'
    //   3102: astore #30
    //   3104: goto -> 987
    //   3107: ldc_w '0'
    //   3110: astore #30
    //   3112: goto -> 987
    //   3115: ldc_w '0'
    //   3118: astore #31
    //   3120: goto -> 1046
    //   3123: ldc_w '0'
    //   3126: astore #31
    //   3128: goto -> 1046
    //   3131: iload #25
    //   3133: ifeq -> 1774
    //   3136: iload #6
    //   3138: ifge -> 3147
    //   3141: iconst_0
    //   3142: istore #20
    //   3144: goto -> 1245
    //   3147: iload #6
    //   3149: istore #20
    //   3151: goto -> 1245
    //   3154: iconst_0
    //   3155: istore #6
    //   3157: goto -> 1322
    //   3160: iconst_1
    //   3161: istore #7
    //   3163: goto -> 1555
    //   3166: iload #6
    //   3168: iconst_1
    //   3169: iadd
    //   3170: istore #6
    //   3172: goto -> 1978
    // Exception table:
    //   from	to	target	type
    //   113	123	2911	java/io/FileNotFoundException
    //   113	123	2797	a/d/a/c
    //   113	123	2726	java/io/IOException
    //   113	123	2655	java/lang/Exception
    //   113	123	3019	finally
    //   123	129	2638	java/io/FileNotFoundException
    //   123	129	2630	a/d/a/c
    //   123	129	2623	java/io/IOException
    //   123	129	2616	java/lang/Exception
    //   123	129	3023	finally
    //   133	169	2593	java/io/FileNotFoundException
    //   133	169	2579	a/d/a/c
    //   133	169	2566	java/io/IOException
    //   133	169	2553	java/lang/Exception
    //   133	169	3027	finally
    //   169	223	2535	java/io/FileNotFoundException
    //   169	223	2524	a/d/a/c
    //   169	223	2517	java/io/IOException
    //   169	223	2510	java/lang/Exception
    //   169	223	3031	finally
    //   223	259	2535	java/io/FileNotFoundException
    //   223	259	2486	a/d/a/c
    //   223	259	2517	java/io/IOException
    //   223	259	2510	java/lang/Exception
    //   223	259	3031	finally
    //   269	273	276	java/io/IOException
    //   299	311	2535	java/io/FileNotFoundException
    //   299	311	2486	a/d/a/c
    //   299	311	2517	java/io/IOException
    //   299	311	2510	java/lang/Exception
    //   299	311	3031	finally
    //   316	334	391	java/io/FileNotFoundException
    //   316	334	386	a/d/a/c
    //   316	334	370	java/io/IOException
    //   316	334	354	java/lang/Exception
    //   316	334	3035	finally
    //   413	425	2535	java/io/FileNotFoundException
    //   413	425	2486	a/d/a/c
    //   413	425	2517	java/io/IOException
    //   413	425	2510	java/lang/Exception
    //   413	425	3031	finally
    //   430	448	391	java/io/FileNotFoundException
    //   430	448	386	a/d/a/c
    //   430	448	370	java/io/IOException
    //   430	448	354	java/lang/Exception
    //   430	448	3035	finally
    //   460	472	2535	java/io/FileNotFoundException
    //   460	472	2486	a/d/a/c
    //   460	472	2517	java/io/IOException
    //   460	472	2510	java/lang/Exception
    //   460	472	3031	finally
    //   477	495	391	java/io/FileNotFoundException
    //   477	495	386	a/d/a/c
    //   477	495	370	java/io/IOException
    //   477	495	354	java/lang/Exception
    //   477	495	3035	finally
    //   507	513	2535	java/io/FileNotFoundException
    //   507	513	2486	a/d/a/c
    //   507	513	2517	java/io/IOException
    //   507	513	2510	java/lang/Exception
    //   507	513	3031	finally
    //   513	523	2479	java/io/FileNotFoundException
    //   513	523	2474	a/d/a/c
    //   513	523	2467	java/io/IOException
    //   513	523	2460	java/lang/Exception
    //   513	523	3039	finally
    //   528	546	579	java/io/FileNotFoundException
    //   528	546	574	a/d/a/c
    //   528	546	570	java/io/IOException
    //   528	546	566	java/lang/Exception
    //   528	546	3043	finally
    //   593	599	2444	java/io/FileNotFoundException
    //   593	599	2439	a/d/a/c
    //   593	599	2432	java/io/IOException
    //   593	599	2425	java/lang/Exception
    //   593	599	3047	finally
    //   599	621	2412	java/io/FileNotFoundException
    //   599	621	2407	a/d/a/c
    //   599	621	2403	java/io/IOException
    //   599	621	2399	java/lang/Exception
    //   599	621	3051	finally
    //   621	637	2412	java/io/FileNotFoundException
    //   621	637	2385	a/d/a/c
    //   621	637	2403	java/io/IOException
    //   621	637	2399	java/lang/Exception
    //   621	637	3051	finally
    //   640	649	2381	java/io/FileNotFoundException
    //   640	649	2376	a/d/a/c
    //   640	649	2372	java/io/IOException
    //   640	649	2368	java/lang/Exception
    //   640	649	3055	finally
    //   649	658	2381	java/io/FileNotFoundException
    //   649	658	2376	a/d/a/c
    //   649	658	2372	java/io/IOException
    //   649	658	2368	java/lang/Exception
    //   649	658	3055	finally
    //   662	676	2381	java/io/FileNotFoundException
    //   662	676	2376	a/d/a/c
    //   662	676	2372	java/io/IOException
    //   662	676	2368	java/lang/Exception
    //   662	676	3055	finally
    //   676	747	2381	java/io/FileNotFoundException
    //   676	747	2376	a/d/a/c
    //   676	747	2372	java/io/IOException
    //   676	747	2368	java/lang/Exception
    //   676	747	3055	finally
    //   797	810	1835	java/io/FileNotFoundException
    //   797	810	1820	a/d/a/c
    //   797	810	1816	java/io/IOException
    //   797	810	1812	java/lang/Exception
    //   797	810	3059	finally
    //   815	836	1835	java/io/FileNotFoundException
    //   815	836	1820	a/d/a/c
    //   815	836	1816	java/io/IOException
    //   815	836	1812	java/lang/Exception
    //   815	836	3059	finally
    //   839	881	1835	java/io/FileNotFoundException
    //   839	881	1820	a/d/a/c
    //   839	881	1816	java/io/IOException
    //   839	881	1812	java/lang/Exception
    //   839	881	3059	finally
    //   886	929	1835	java/io/FileNotFoundException
    //   886	929	1820	a/d/a/c
    //   886	929	1816	java/io/IOException
    //   886	929	1812	java/lang/Exception
    //   886	929	3059	finally
    //   941	984	1835	java/io/FileNotFoundException
    //   941	984	1820	a/d/a/c
    //   941	984	1816	java/io/IOException
    //   941	984	1812	java/lang/Exception
    //   941	984	3059	finally
    //   1000	1043	1835	java/io/FileNotFoundException
    //   1000	1043	1820	a/d/a/c
    //   1000	1043	1816	java/io/IOException
    //   1000	1043	1812	java/lang/Exception
    //   1000	1043	3059	finally
    //   1050	1235	1835	java/io/FileNotFoundException
    //   1050	1235	1820	a/d/a/c
    //   1050	1235	1816	java/io/IOException
    //   1050	1235	1812	java/lang/Exception
    //   1050	1235	3059	finally
    //   1249	1316	1835	java/io/FileNotFoundException
    //   1249	1316	1820	a/d/a/c
    //   1249	1316	1816	java/io/IOException
    //   1249	1316	1812	java/lang/Exception
    //   1249	1316	3059	finally
    //   1330	1341	1835	java/io/FileNotFoundException
    //   1330	1341	1820	a/d/a/c
    //   1330	1341	1816	java/io/IOException
    //   1330	1341	1812	java/lang/Exception
    //   1330	1341	3059	finally
    //   1345	1412	1835	java/io/FileNotFoundException
    //   1345	1412	1820	a/d/a/c
    //   1345	1412	1816	java/io/IOException
    //   1345	1412	1812	java/lang/Exception
    //   1345	1412	3059	finally
    //   1415	1490	1835	java/io/FileNotFoundException
    //   1415	1490	1820	a/d/a/c
    //   1415	1490	1816	java/io/IOException
    //   1415	1490	1812	java/lang/Exception
    //   1415	1490	3059	finally
    //   1493	1552	1835	java/io/FileNotFoundException
    //   1493	1552	1820	a/d/a/c
    //   1493	1552	1816	java/io/IOException
    //   1493	1552	1812	java/lang/Exception
    //   1493	1552	3059	finally
    //   1555	1602	1835	java/io/FileNotFoundException
    //   1555	1602	1820	a/d/a/c
    //   1555	1602	1816	java/io/IOException
    //   1555	1602	1812	java/lang/Exception
    //   1555	1602	3059	finally
    //   1606	1629	1835	java/io/FileNotFoundException
    //   1606	1629	1820	a/d/a/c
    //   1606	1629	1816	java/io/IOException
    //   1606	1629	1812	java/lang/Exception
    //   1606	1629	3059	finally
    //   1633	1702	1835	java/io/FileNotFoundException
    //   1633	1702	1820	a/d/a/c
    //   1633	1702	1816	java/io/IOException
    //   1633	1702	1812	java/lang/Exception
    //   1633	1702	3059	finally
    //   1710	1717	1835	java/io/FileNotFoundException
    //   1710	1717	1820	a/d/a/c
    //   1710	1717	1816	java/io/IOException
    //   1710	1717	1812	java/lang/Exception
    //   1710	1717	3059	finally
    //   1726	1768	1835	java/io/FileNotFoundException
    //   1726	1768	1820	a/d/a/c
    //   1726	1768	1816	java/io/IOException
    //   1726	1768	1812	java/lang/Exception
    //   1726	1768	3059	finally
    //   1839	1868	2381	java/io/FileNotFoundException
    //   1839	1868	2376	a/d/a/c
    //   1839	1868	2372	java/io/IOException
    //   1839	1868	2368	java/lang/Exception
    //   1839	1868	3055	finally
    //   1873	1879	1952	java/io/FileNotFoundException
    //   1873	1879	1943	a/d/a/c
    //   1873	1879	1932	java/io/IOException
    //   1873	1879	1921	java/lang/Exception
    //   1873	1879	3063	finally
    //   1879	1884	1911	java/io/FileNotFoundException
    //   1879	1884	1943	a/d/a/c
    //   1879	1884	1907	java/io/IOException
    //   1879	1884	1903	java/lang/Exception
    //   1879	1884	3063	finally
    //   1884	1895	1911	java/io/FileNotFoundException
    //   1884	1895	1898	a/d/a/c
    //   1884	1895	1907	java/io/IOException
    //   1884	1895	1903	java/lang/Exception
    //   1884	1895	3063	finally
    //   1963	1972	2353	java/io/FileNotFoundException
    //   1963	1972	2348	a/d/a/c
    //   1963	1972	2344	java/io/IOException
    //   1963	1972	2340	java/lang/Exception
    //   1963	1972	3067	finally
    //   1978	1985	2353	java/io/FileNotFoundException
    //   1978	1985	2348	a/d/a/c
    //   1978	1985	2344	java/io/IOException
    //   1978	1985	2340	java/lang/Exception
    //   1978	1985	3067	finally
    //   1992	2008	1911	java/io/FileNotFoundException
    //   1992	2008	1898	a/d/a/c
    //   1992	2008	1907	java/io/IOException
    //   1992	2008	1903	java/lang/Exception
    //   1992	2008	3063	finally
    //   2014	2078	1911	java/io/FileNotFoundException
    //   2014	2078	1898	a/d/a/c
    //   2014	2078	1907	java/io/IOException
    //   2014	2078	1903	java/lang/Exception
    //   2014	2078	3063	finally
    //   2086	2092	1911	java/io/FileNotFoundException
    //   2086	2092	1898	a/d/a/c
    //   2086	2092	1907	java/io/IOException
    //   2086	2092	1903	java/lang/Exception
    //   2086	2092	3063	finally
    //   2092	2104	2353	java/io/FileNotFoundException
    //   2092	2104	2348	a/d/a/c
    //   2092	2104	2344	java/io/IOException
    //   2092	2104	2340	java/lang/Exception
    //   2092	2104	3067	finally
    //   2104	2143	2353	java/io/FileNotFoundException
    //   2104	2143	2348	a/d/a/c
    //   2104	2143	2344	java/io/IOException
    //   2104	2143	2340	java/lang/Exception
    //   2104	2143	3067	finally
    //   2143	2306	2353	java/io/FileNotFoundException
    //   2143	2306	2348	a/d/a/c
    //   2143	2306	2344	java/io/IOException
    //   2143	2306	2340	java/lang/Exception
    //   2143	2306	3067	finally
    //   2310	2314	2317	java/io/IOException
    //   2671	2677	3071	finally
    //   2686	2691	3071	finally
    //   2695	2699	2702	java/io/IOException
    //   2742	2748	3071	finally
    //   2757	2762	3071	finally
    //   2766	2770	2773	java/io/IOException
    //   2815	2821	3071	finally
    //   2831	2843	3071	finally
    //   2853	2859	3071	finally
    //   2869	2874	3071	finally
    //   2879	2884	2887	java/io/IOException
    //   2927	2933	3071	finally
    //   2942	2947	3071	finally
    //   2951	2955	2958	java/io/IOException
    //   2991	2995	2998	java/io/IOException }
  
  public boolean a(Activity paramActivity, String paramString) {
    try {
      String str;
      AssetManager assetManager = paramActivity.getAssets();
      if (n.bL(this.mContext)) {
        str = "memberTemplates_zh.xls";
      } else {
        str = "memberTemplates_en.xls";
      } 
      InputStream inputStream = assetManager.open(str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("/");
      stringBuilder.append(RootApplication.zv().getString(R.string.vip_template_name));
      stringBuilder.append(".xls");
      boolean bool = am.a(inputStream, stringBuilder.toString());
      if (!bool)
        return false; 
    } catch (IOException paramActivity) {
      a.e(paramActivity);
    } 
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\transfer\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */