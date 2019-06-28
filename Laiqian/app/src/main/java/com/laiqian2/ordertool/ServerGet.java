package com.laiqian.ordertool;

import android.content.Context;
import android.database.Cursor;
import com.google.a.a.a.a.a.a;
import com.laiqian.dcb.api.b.a.b;
import com.laiqian.dcb.api.server.a.c;
import com.laiqian.models.p;
import hugo.weaving.DebugLog;
import io.netty.channel.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerGet {
  private static final String TEST_FILENAME;
  
  public static final HashSet<n> arrayListChannel;
  
  private static SimpleDateFormat dataFormat = new SimpleDateFormat("MM-dd-HH-mm-ss", Locale.CHINA);
  
  private static String sTableNoForTest = "49";
  
  private String TAG;
  
  private boolean bDebug;
  
  private Context mContext;
  
  private StringBuffer sOutPutMessage;
  
  static  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("test_server_");
    stringBuilder.append(dataFormat.format(new Date()));
    stringBuilder.append(".txt");
    TEST_FILENAME = stringBuilder.toString();
    arrayListChannel = new HashSet();
  }
  
  @DebugLog
  public ServerGet(Context paramContext, n paramn, String paramString) { // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: ldc com/laiqian/ordertool/ServerGet
    //   7: invokevirtual getName : ()Ljava/lang/String;
    //   10: putfield TAG : Ljava/lang/String;
    //   13: aload_0
    //   14: iconst_0
    //   15: putfield bDebug : Z
    //   18: aload_0
    //   19: new java/lang/StringBuffer
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: putfield sOutPutMessage : Ljava/lang/StringBuffer;
    //   29: aload_0
    //   30: aload_1
    //   31: putfield mContext : Landroid/content/Context;
    //   34: new org/json/JSONObject
    //   37: dup
    //   38: aload_3
    //   39: invokespecial <init> : (Ljava/lang/String;)V
    //   42: astore #10
    //   44: aload #10
    //   46: ldc 'method'
    //   48: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   51: invokestatic parseInt : (Ljava/lang/String;)I
    //   54: istore #4
    //   56: aload #10
    //   58: ldc 'phone'
    //   60: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   63: astore #12
    //   65: aload #10
    //   67: ldc 'pwd'
    //   69: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   72: invokevirtual toString : ()Ljava/lang/String;
    //   75: invokevirtual trim : ()Ljava/lang/String;
    //   78: invokestatic cH : (Ljava/lang/String;)Ljava/lang/String;
    //   81: astore #11
    //   83: aload #10
    //   85: ldc 'brand'
    //   87: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   90: pop
    //   91: aload #10
    //   93: ldc 'imei'
    //   95: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   98: astore #13
    //   100: aload #10
    //   102: ldc 'more_info'
    //   104: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   107: astore #14
    //   109: new com/laiqian/dcb/api/a/b
    //   112: dup
    //   113: invokespecial <init> : ()V
    //   116: astore #15
    //   118: aload #14
    //   120: invokestatic isNull : (Ljava/lang/String;)Z
    //   123: ifne -> 184
    //   126: new org/json/JSONObject
    //   129: dup
    //   130: aload #14
    //   132: invokespecial <init> : (Ljava/lang/String;)V
    //   135: astore #16
    //   137: aload #15
    //   139: aload #16
    //   141: ldc 'create_time'
    //   143: invokevirtual optLong : (Ljava/lang/String;)J
    //   146: invokevirtual W : (J)Lcom/laiqian/dcb/api/a/b;
    //   149: aload #16
    //   151: ldc 'device_type'
    //   153: invokevirtual optInt : (Ljava/lang/String;)I
    //   156: invokevirtual ek : (I)Lcom/laiqian/dcb/api/a/b;
    //   159: aload #16
    //   161: ldc 'message_type'
    //   163: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   166: invokevirtual cB : (Ljava/lang/String;)Lcom/laiqian/dcb/api/a/b;
    //   169: aload #16
    //   171: ldc 'version'
    //   173: invokevirtual optInt : (Ljava/lang/String;)I
    //   176: i2d
    //   177: invokevirtual h : (D)Lcom/laiqian/dcb/api/a/b;
    //   180: pop
    //   181: goto -> 221
    //   184: new java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial <init> : ()V
    //   191: astore #16
    //   193: aload #16
    //   195: invokestatic Xy : ()I
    //   198: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload #16
    //   204: ldc ''
    //   206: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload #15
    //   212: aload #16
    //   214: invokevirtual toString : ()Ljava/lang/String;
    //   217: invokevirtual cB : (Ljava/lang/String;)Lcom/laiqian/dcb/api/a/b;
    //   220: pop
    //   221: aload #10
    //   223: ldc 'device'
    //   225: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   228: astore #16
    //   230: aload #10
    //   232: ldc 'data'
    //   234: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   237: astore #17
    //   239: new java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial <init> : ()V
    //   246: astore #10
    //   248: aload #10
    //   250: ldc '用户method： {'
    //   252: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload #10
    //   258: iload #4
    //   260: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload #10
    //   266: ldc '}'
    //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: ldc 'dcb'
    //   274: aload #10
    //   276: invokevirtual toString : ()Ljava/lang/String;
    //   279: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   282: new java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial <init> : ()V
    //   289: astore #10
    //   291: aload #10
    //   293: ldc '用户phone： {'
    //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload #10
    //   301: aload #12
    //   303: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload #10
    //   309: ldc '}'
    //   311: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc 'dcb'
    //   317: aload #10
    //   319: invokevirtual toString : ()Ljava/lang/String;
    //   322: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   325: new java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial <init> : ()V
    //   332: astore #10
    //   334: aload #10
    //   336: ldc '用户imei： {'
    //   338: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload #10
    //   344: aload #13
    //   346: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload #10
    //   352: ldc '}'
    //   354: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: ldc 'dcb'
    //   360: aload #10
    //   362: invokevirtual toString : ()Ljava/lang/String;
    //   365: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   368: new java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial <init> : ()V
    //   375: astore #10
    //   377: aload #10
    //   379: ldc '用户device： {'
    //   381: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload #10
    //   387: aload #16
    //   389: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload #10
    //   395: ldc '}'
    //   397: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: ldc 'dcb'
    //   403: aload #10
    //   405: invokevirtual toString : ()Ljava/lang/String;
    //   408: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   411: new java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial <init> : ()V
    //   418: astore #10
    //   420: aload #10
    //   422: ldc '用户pwd： {'
    //   424: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload #10
    //   430: aload #11
    //   432: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload #10
    //   438: ldc '}'
    //   440: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: ldc 'dcb'
    //   446: aload #10
    //   448: invokevirtual toString : ()Ljava/lang/String;
    //   451: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   454: aload #11
    //   456: invokevirtual isEmpty : ()Z
    //   459: ifeq -> 476
    //   462: aload_2
    //   463: iload #4
    //   465: iconst_0
    //   466: ldc ''
    //   468: ldc 'this is from server'
    //   470: ldc 'SERVER_USER_PASSWORD_EMPTY'
    //   472: invokestatic a : (Lio/netty/channel/n;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   475: return
    //   476: aload #11
    //   478: invokevirtual length : ()I
    //   481: istore #5
    //   483: iload #5
    //   485: bipush #32
    //   487: if_icmpeq -> 507
    //   490: aload #11
    //   492: invokestatic cI : (Ljava/lang/String;)Ljava/lang/String;
    //   495: astore #10
    //   497: goto -> 511
    //   500: astore #10
    //   502: aload #10
    //   504: invokestatic e : (Ljava/lang/Throwable;)V
    //   507: aload #11
    //   509: astore #10
    //   511: new com/laiqian/models/bh
    //   514: dup
    //   515: aload_1
    //   516: invokespecial <init> : (Landroid/content/Context;)V
    //   519: astore #18
    //   521: aload #18
    //   523: aload #12
    //   525: aload #11
    //   527: aload #10
    //   529: invokevirtual B : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   532: astore #10
    //   534: aload #10
    //   536: invokeinterface moveToFirst : ()Z
    //   541: ifeq -> 568
    //   544: aload #10
    //   546: aload #10
    //   548: ldc 'nShopID'
    //   550: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   555: invokeinterface getString : (I)Ljava/lang/String;
    //   560: invokestatic parseLong : (Ljava/lang/String;)J
    //   563: lstore #6
    //   565: goto -> 571
    //   568: lconst_0
    //   569: lstore #6
    //   571: aload #10
    //   573: invokeinterface close : ()V
    //   578: aload #18
    //   580: invokevirtual close : ()V
    //   583: goto -> 632
    //   586: goto -> 592
    //   589: lconst_0
    //   590: lstore #6
    //   592: new java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial <init> : ()V
    //   599: astore #10
    //   601: aload #10
    //   603: ldc_w 'clientShopID is'
    //   606: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload #10
    //   612: lload #6
    //   614: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: ldc_w 'ClientShopID'
    //   621: aload #10
    //   623: invokevirtual toString : ()Ljava/lang/String;
    //   626: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   629: goto -> 583
    //   632: lload #6
    //   634: lconst_0
    //   635: lcmp
    //   636: ifne -> 655
    //   639: aload_2
    //   640: iload #4
    //   642: bipush #-6
    //   644: ldc ''
    //   646: ldc 'this is from server'
    //   648: ldc_w 'SERVER_USER_PASSWORD_CHECK_FAILED'
    //   651: invokestatic a : (Lio/netty/channel/n;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   654: return
    //   655: new com/laiqian/dcb/api/b/g
    //   658: dup
    //   659: aload_1
    //   660: invokespecial <init> : (Landroid/content/Context;)V
    //   663: astore #10
    //   665: aload #10
    //   667: invokevirtual DZ : ()J
    //   670: lstore #8
    //   672: aload #10
    //   674: invokevirtual close : ()V
    //   677: new java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial <init> : ()V
    //   684: astore #10
    //   686: aload #10
    //   688: ldc_w 'ServerShopID is'
    //   691: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload #10
    //   697: lload #8
    //   699: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: aload #10
    //   705: ldc_w 'clientShopID is'
    //   708: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload #10
    //   714: lload #6
    //   716: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: ldc_w 'ServerShopID'
    //   723: aload #10
    //   725: invokevirtual toString : ()Ljava/lang/String;
    //   728: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   731: lload #6
    //   733: lload #8
    //   735: lcmp
    //   736: ifeq -> 764
    //   739: aload_2
    //   740: sipush #1001
    //   743: bipush #-7
    //   745: ldc ''
    //   747: ldc 'this is from server'
    //   749: ldc_w 'SERVER_CURRENT_SHOP_NOT_CLIENT_REQUEST_SHOP'
    //   752: new com/laiqian/ordertool/e
    //   755: dup
    //   756: aload_0
    //   757: invokespecial <init> : (Lcom/laiqian/ordertool/ServerGet;)V
    //   760: invokestatic a : (Lio/netty/channel/n;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/netty/channel/t;)V
    //   763: return
    //   764: invokestatic Ze : ()Lcom/laiqian/dcb/api/server/a/a;
    //   767: aload_2
    //   768: aload #12
    //   770: aload #16
    //   772: aload #13
    //   774: invokevirtual a : (Lio/netty/channel/n;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   777: pop
    //   778: new com/laiqian/ordertool/a/b
    //   781: dup
    //   782: aload_0
    //   783: aload #15
    //   785: invokevirtual DO : ()Ljava/lang/String;
    //   788: invokestatic parseInt : (Ljava/lang/String;)I
    //   791: invokespecial <init> : (Lcom/laiqian/ordertool/ServerGet;I)V
    //   794: astore #10
    //   796: new com/laiqian/ordertool/c/c
    //   799: dup
    //   800: aload #15
    //   802: invokevirtual DO : ()Ljava/lang/String;
    //   805: invokestatic parseInt : (Ljava/lang/String;)I
    //   808: invokespecial <init> : (I)V
    //   811: astore #11
    //   813: iload #4
    //   815: sipush #-1000
    //   818: if_icmpeq -> 1159
    //   821: iload #4
    //   823: sipush #2002
    //   826: if_icmpeq -> 1116
    //   829: iload #4
    //   831: sipush #3021
    //   834: if_icmpeq -> 1097
    //   837: iload #4
    //   839: sipush #4003
    //   842: if_icmpeq -> 1079
    //   845: iload #4
    //   847: tableswitch default -> 1300, 2005 -> 1063, 2006 -> 1047, 2007 -> 1021
    //   872: aload_2
    //   873: iload #4
    //   875: iconst_1
    //   876: ldc ''
    //   878: ldc 'this is from server'
    //   880: ldc_w '0'
    //   883: invokestatic a : (Lio/netty/channel/n;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   886: goto -> 1185
    //   889: aload #11
    //   891: aload_1
    //   892: aload #12
    //   894: aload_2
    //   895: iload #4
    //   897: aload #17
    //   899: aload #15
    //   901: invokevirtual b : (Landroid/content/Context;Ljava/lang/String;Lio/netty/channel/n;ILjava/lang/String;Lcom/laiqian/dcb/api/a/b;)V
    //   904: goto -> 1185
    //   907: aload #15
    //   909: invokevirtual DP : ()J
    //   912: aload_1
    //   913: aload_2
    //   914: iload #4
    //   916: aload #14
    //   918: invokestatic processMessage : (JLandroid/content/Context;Lio/netty/channel/n;ILjava/lang/String;)Z
    //   921: ifne -> 1185
    //   924: aload #11
    //   926: aload_0
    //   927: invokevirtual getMessage : ()Ljava/lang/StringBuffer;
    //   930: aload_0
    //   931: getfield bDebug : Z
    //   934: aload #17
    //   936: aload_1
    //   937: aload_2
    //   938: iload #4
    //   940: aload #10
    //   942: aload #15
    //   944: invokevirtual b : (Ljava/lang/StringBuffer;ZLjava/lang/String;Landroid/content/Context;Lio/netty/channel/n;ILcom/laiqian/ordertool/a/a;Lcom/laiqian/dcb/api/a/b;)V
    //   947: goto -> 1185
    //   950: aload #11
    //   952: aload_1
    //   953: aload #12
    //   955: aload_2
    //   956: iload #4
    //   958: aload #15
    //   960: invokevirtual c : (Landroid/content/Context;Ljava/lang/String;Lio/netty/channel/n;ILcom/laiqian/dcb/api/a/b;)V
    //   963: goto -> 1185
    //   966: aload #11
    //   968: aload_1
    //   969: aload #17
    //   971: aload #12
    //   973: aload #15
    //   975: aload_2
    //   976: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/laiqian/dcb/api/a/b;Lio/netty/channel/n;)V
    //   979: goto -> 1185
    //   982: aload #11
    //   984: aload_1
    //   985: aload #12
    //   987: aload #13
    //   989: aload #16
    //   991: aload_2
    //   992: iload #4
    //   994: lload #8
    //   996: aload #15
    //   998: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/netty/channel/n;IJLcom/laiqian/dcb/api/a/b;)V
    //   1001: goto -> 1185
    //   1004: aload_2
    //   1005: sipush #3000
    //   1008: iconst_0
    //   1009: ldc ''
    //   1011: ldc ''
    //   1013: ldc ''
    //   1015: invokestatic a : (Lio/netty/channel/n;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1018: goto -> 1185
    //   1021: aload #11
    //   1023: aload_0
    //   1024: invokevirtual getMessage : ()Ljava/lang/StringBuffer;
    //   1027: aload_1
    //   1028: aload_0
    //   1029: getfield bDebug : Z
    //   1032: aload #17
    //   1034: aload_2
    //   1035: iload #4
    //   1037: aload #10
    //   1039: aload #15
    //   1041: invokevirtual a : (Ljava/lang/StringBuffer;Landroid/content/Context;ZLjava/lang/String;Lio/netty/channel/n;ILcom/laiqian/ordertool/a/a;Lcom/laiqian/dcb/api/a/b;)V
    //   1044: goto -> 1185
    //   1047: aload #11
    //   1049: aload_1
    //   1050: aload #17
    //   1052: aload_2
    //   1053: iload #4
    //   1055: aload #15
    //   1057: invokevirtual b : (Landroid/content/Context;Ljava/lang/String;Lio/netty/channel/n;ILcom/laiqian/dcb/api/a/b;)V
    //   1060: goto -> 1185
    //   1063: aload #11
    //   1065: aload_1
    //   1066: aload #12
    //   1068: aload_2
    //   1069: iload #4
    //   1071: aload #15
    //   1073: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Lio/netty/channel/n;ILcom/laiqian/dcb/api/a/b;)V
    //   1076: goto -> 1185
    //   1079: aload #11
    //   1081: aload_1
    //   1082: aload #12
    //   1084: aload_2
    //   1085: iload #4
    //   1087: aload #17
    //   1089: aload #15
    //   1091: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Lio/netty/channel/n;ILjava/lang/String;Lcom/laiqian/dcb/api/a/b;)V
    //   1094: goto -> 1185
    //   1097: new com/laiqian/ordertool/c/o
    //   1100: dup
    //   1101: invokespecial <init> : ()V
    //   1104: aload_1
    //   1105: aload #17
    //   1107: iload #4
    //   1109: aload_2
    //   1110: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;ILio/netty/channel/n;)V
    //   1113: goto -> 1185
    //   1116: aload #15
    //   1118: invokevirtual DP : ()J
    //   1121: aload_1
    //   1122: aload_2
    //   1123: iload #4
    //   1125: aload #14
    //   1127: invokestatic processMessage : (JLandroid/content/Context;Lio/netty/channel/n;ILjava/lang/String;)Z
    //   1130: ifne -> 1185
    //   1133: aload #11
    //   1135: aload_0
    //   1136: invokevirtual getMessage : ()Ljava/lang/StringBuffer;
    //   1139: aload_0
    //   1140: getfield bDebug : Z
    //   1143: aload #17
    //   1145: aload_1
    //   1146: aload_2
    //   1147: iload #4
    //   1149: aload #10
    //   1151: aload #15
    //   1153: invokevirtual a : (Ljava/lang/StringBuffer;ZLjava/lang/String;Landroid/content/Context;Lio/netty/channel/n;ILcom/laiqian/ordertool/a/a;Lcom/laiqian/dcb/api/a/b;)V
    //   1156: goto -> 1185
    //   1159: aload #17
    //   1161: invokestatic decode : (Ljava/lang/String;)Ljava/lang/String;
    //   1164: astore_1
    //   1165: aload_1
    //   1166: getstatic com/laiqian/ordertool/ServerGet.TEST_FILENAME : Ljava/lang/String;
    //   1169: invokestatic C : (Ljava/lang/String;Ljava/lang/String;)V
    //   1172: aload_2
    //   1173: iload #4
    //   1175: iconst_1
    //   1176: ldc ''
    //   1178: aload_1
    //   1179: ldc_w '0'
    //   1182: invokestatic a : (Lio/netty/channel/n;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1185: aload #10
    //   1187: invokevirtual close : ()V
    //   1190: return
    //   1191: astore_1
    //   1192: new java/lang/StringBuilder
    //   1195: dup
    //   1196: invokespecial <init> : ()V
    //   1199: astore_2
    //   1200: aload_2
    //   1201: ldc_w '服务器发生异常： {'
    //   1204: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: pop
    //   1208: aload_2
    //   1209: aload_1
    //   1210: invokevirtual toString : ()Ljava/lang/String;
    //   1213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: pop
    //   1217: aload_2
    //   1218: ldc_w '}\\n'
    //   1221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: pop
    //   1225: aload_2
    //   1226: aload_3
    //   1227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: pop
    //   1231: aload_2
    //   1232: invokevirtual toString : ()Ljava/lang/String;
    //   1235: invokestatic an : (Ljava/lang/Object;)V
    //   1238: aload_1
    //   1239: invokestatic e : (Ljava/lang/Throwable;)V
    //   1242: aload_0
    //   1243: invokevirtual getMessage : ()Ljava/lang/StringBuffer;
    //   1246: astore_2
    //   1247: new java/lang/StringBuilder
    //   1250: dup
    //   1251: invokespecial <init> : ()V
    //   1254: astore_3
    //   1255: aload_3
    //   1256: ldc_w 'Exception is: '
    //   1259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: pop
    //   1263: aload_3
    //   1264: aload_1
    //   1265: invokevirtual toString : ()Ljava/lang/String;
    //   1268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload_3
    //   1273: ldc_w '\\n'
    //   1276: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: pop
    //   1280: aload_2
    //   1281: aload_3
    //   1282: invokevirtual toString : ()Ljava/lang/String;
    //   1285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1288: pop
    //   1289: return
    //   1290: astore #10
    //   1292: goto -> 589
    //   1295: astore #10
    //   1297: goto -> 586
    //   1300: iload #4
    //   1302: tableswitch default -> 1336, 3000 -> 1004, 3001 -> 982, 3002 -> 966, 3003 -> 950, 3004 -> 907
    //   1336: iload #4
    //   1338: tableswitch default -> 1360, 3008 -> 889, 3009 -> 889
    //   1360: goto -> 872
    // Exception table:
    //   from	to	target	type
    //   34	181	1191	org/json/JSONException
    //   184	221	1191	org/json/JSONException
    //   221	475	1191	org/json/JSONException
    //   476	483	1191	org/json/JSONException
    //   490	497	500	java/security/NoSuchAlgorithmException
    //   490	497	1191	org/json/JSONException
    //   502	507	1191	org/json/JSONException
    //   511	565	1290	java/lang/Exception
    //   511	565	1191	org/json/JSONException
    //   571	583	1295	java/lang/Exception
    //   571	583	1191	org/json/JSONException
    //   592	629	1191	org/json/JSONException
    //   639	654	1191	org/json/JSONException
    //   655	731	1191	org/json/JSONException
    //   739	763	1191	org/json/JSONException
    //   764	813	1191	org/json/JSONException
    //   872	886	1191	org/json/JSONException
    //   889	904	1191	org/json/JSONException
    //   907	947	1191	org/json/JSONException
    //   950	963	1191	org/json/JSONException
    //   966	979	1191	org/json/JSONException
    //   982	1001	1191	org/json/JSONException
    //   1004	1018	1191	org/json/JSONException
    //   1021	1044	1191	org/json/JSONException
    //   1047	1060	1191	org/json/JSONException
    //   1063	1076	1191	org/json/JSONException
    //   1079	1094	1191	org/json/JSONException
    //   1097	1113	1191	org/json/JSONException
    //   1116	1156	1191	org/json/JSONException
    //   1159	1185	1191	org/json/JSONException
    //   1185	1190	1191	org/json/JSONException }
  
  public static String getTableNoForTest() { return sTableNoForTest; }
  
  private static boolean processMessage(long paramLong, Context paramContext, n paramn, int paramInt, String paramString) {
    p p = new p(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    Cursor cursor = p.ht(stringBuilder.toString());
    p.close();
    if (cursor.getCount() > 0) {
      jSONObject = new JSONObject();
      try {
        jSONObject.put("more_info", paramString);
        c.a(paramn, paramInt, -1, "", b.encode(jSONObject.toString()), "0");
        return true;
      } catch (JSONException jSONObject) {
        a.e(jSONObject);
      } catch (Exception jSONObject) {
        a.e(jSONObject);
      } 
    } 
    return false;
  }
  
  public Context getContext() { return this.mContext; }
  
  public boolean getDebugStatus() { return this.bDebug; }
  
  public StringBuffer getMessage() { return this.sOutPutMessage; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\ServerGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */