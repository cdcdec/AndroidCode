package com.laiqian.db.multidatabase.d;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Size;
import android.util.Log;
import android.util.Pair;
import com.laiqian.db.multidatabase.a.a;
import com.laiqian.db.multidatabase.a.b;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.pos.hardware.RootUrlParameter;
import hugo.weaving.DebugLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class b {
  private static final boolean DEBUG;
  
  private static final String TAG = "b";
  
  private static final Pattern aOK = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
  
  static  {
    DEBUG = RootUrlParameter.bDebug;
  }
  
  public static String Dm() { return aU(Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(1)); }
  
  public static String Dn() { return aV(Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(1)); }
  
  public static void Do() {
    Iterator iterator = b(new File(a.aOz), new ArrayList()).iterator();
    while (iterator.hasNext()) {
      SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openDatabase((String)iterator.next(), null, 16, new c());
      a.Dl().f(sQLiteDatabase);
      sQLiteDatabase.close();
    } 
  }
  
  @DebugLog
  public static void Dp() { // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #19
    //   9: getstatic com/laiqian/db/multidatabase/a/b.aOw : Lcom/laiqian/db/multidatabase/a/b;
    //   12: invokevirtual Dk : ()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore #17
    //   17: ldc 'TAG'
    //   19: ldc '------------1---------'
    //   21: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: aload #17
    //   27: ldc 'select name,sql from sqlite_master where type='table' and tbl_name like '%DOC%' or tbl_name='ts_table_profile' '
    //   29: aconst_null
    //   30: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore #18
    //   35: aload #18
    //   37: invokeinterface moveToNext : ()Z
    //   42: istore #12
    //   44: iconst_0
    //   45: istore_2
    //   46: iload #12
    //   48: ifeq -> 111
    //   51: aload #18
    //   53: iconst_1
    //   54: invokeinterface getString : (I)Ljava/lang/String;
    //   59: astore #20
    //   61: new java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial <init> : ()V
    //   68: astore #21
    //   70: aload #21
    //   72: ldc 'CREATE TABLE IF NOT EXISTS '
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #21
    //   80: aload #20
    //   82: aload #20
    //   84: ldc '['
    //   86: iconst_0
    //   87: invokevirtual indexOf : (Ljava/lang/String;I)I
    //   90: invokevirtual substring : (I)Ljava/lang/String;
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload #19
    //   99: aload #21
    //   101: invokevirtual toString : ()Ljava/lang/String;
    //   104: invokevirtual add : (Ljava/lang/Object;)Z
    //   107: pop
    //   108: goto -> 35
    //   111: aload #17
    //   113: ldc 'select sql from sqlite_master where type='index' and tbl_name like '%DOC%' '
    //   115: iconst_0
    //   116: anewarray java/lang/String
    //   119: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   122: astore #18
    //   124: aload #18
    //   126: ifnull -> 241
    //   129: aload #18
    //   131: invokeinterface moveToNext : ()Z
    //   136: ifeq -> 241
    //   139: aload #18
    //   141: iconst_0
    //   142: invokeinterface getString : (I)Ljava/lang/String;
    //   147: astore #20
    //   149: aload #20
    //   151: ifnull -> 124
    //   154: new java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial <init> : ()V
    //   161: astore #21
    //   163: aload #21
    //   165: ldc 'CREATE INDEX IF NOT EXISTS '
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload #21
    //   173: aload #20
    //   175: aload #20
    //   177: ldc '['
    //   179: iconst_0
    //   180: invokevirtual indexOf : (Ljava/lang/String;I)I
    //   183: invokevirtual substring : (I)Ljava/lang/String;
    //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload #21
    //   192: invokevirtual toString : ()Ljava/lang/String;
    //   195: astore #20
    //   197: aload #19
    //   199: aload #20
    //   201: invokevirtual add : (Ljava/lang/Object;)Z
    //   204: pop
    //   205: new java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial <init> : ()V
    //   212: astore #21
    //   214: aload #21
    //   216: ldc 'DOC数据库建索引sql-->'
    //   218: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload #21
    //   224: aload #20
    //   226: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload #21
    //   232: invokevirtual toString : ()Ljava/lang/String;
    //   235: invokestatic ct : (Ljava/lang/String;)V
    //   238: goto -> 124
    //   241: aload #17
    //   243: ldc 'select name,sql from sqlite_master where type='table' and tbl_name like '%DOC%' or tbl_name='ts_table_profile' '
    //   245: aconst_null
    //   246: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   249: astore #25
    //   251: iconst_0
    //   252: istore_3
    //   253: aload #25
    //   255: invokeinterface moveToNext : ()Z
    //   260: ifeq -> 1716
    //   263: iload_3
    //   264: iconst_1
    //   265: iadd
    //   266: istore #10
    //   268: aload #25
    //   270: iload_2
    //   271: invokeinterface getString : (I)Ljava/lang/String;
    //   276: astore #19
    //   278: ldc 'ts_table_profile'
    //   280: aload #19
    //   282: invokevirtual equals : (Ljava/lang/Object;)Z
    //   285: ifeq -> 303
    //   288: aload #17
    //   290: astore #20
    //   292: aload #18
    //   294: astore #17
    //   296: aload #20
    //   298: astore #18
    //   300: goto -> 1698
    //   303: new java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial <init> : ()V
    //   310: astore #20
    //   312: aload #20
    //   314: ldc '----tableName----'
    //   316: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload #20
    //   322: aload #19
    //   324: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload #20
    //   330: invokevirtual toString : ()Ljava/lang/String;
    //   333: invokestatic ct : (Ljava/lang/String;)V
    //   336: ldc 'TAG'
    //   338: ldc '------------2---------'
    //   340: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   343: pop
    //   344: new java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial <init> : ()V
    //   351: astore #20
    //   353: aload #20
    //   355: ldc 'SELECT min(_id),max(_id)  FROM '
    //   357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload #20
    //   363: aload #19
    //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload #17
    //   371: aload #20
    //   373: invokevirtual toString : ()Ljava/lang/String;
    //   376: aconst_null
    //   377: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   380: astore #20
    //   382: invokestatic currentTimeMillis : ()J
    //   385: lstore #13
    //   387: invokestatic currentTimeMillis : ()J
    //   390: lstore #15
    //   392: aload #20
    //   394: invokeinterface moveToNext : ()Z
    //   399: ifeq -> 425
    //   402: aload #20
    //   404: iload_2
    //   405: invokeinterface getLong : (I)J
    //   410: lstore #13
    //   412: aload #20
    //   414: iconst_1
    //   415: invokeinterface getLong : (I)J
    //   420: lstore #15
    //   422: goto -> 392
    //   425: aload #20
    //   427: invokeinterface close : ()V
    //   432: new java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial <init> : ()V
    //   439: astore #20
    //   441: aload #20
    //   443: ldc '------------3-----------firstTimeStamp='
    //   445: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload #20
    //   451: lload #13
    //   453: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: ldc 'TAG'
    //   459: aload #20
    //   461: invokevirtual toString : ()Ljava/lang/String;
    //   464: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   467: pop
    //   468: new java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial <init> : ()V
    //   475: astore #20
    //   477: aload #20
    //   479: ldc '------------4---------lastTimeStamp='
    //   481: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload #20
    //   487: lload #15
    //   489: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: ldc 'TAG'
    //   495: aload #20
    //   497: invokevirtual toString : ()Ljava/lang/String;
    //   500: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   503: pop
    //   504: lload #13
    //   506: invokestatic T : (J)I
    //   509: istore #5
    //   511: lload #13
    //   513: invokestatic U : (J)I
    //   516: istore_3
    //   517: lload #15
    //   519: invokestatic T : (J)I
    //   522: istore #9
    //   524: lload #15
    //   526: invokestatic U : (J)I
    //   529: istore #11
    //   531: new java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial <init> : ()V
    //   538: astore #20
    //   540: aload #20
    //   542: ldc '------------5---------firstMonth='
    //   544: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload #20
    //   550: iload #5
    //   552: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload #20
    //   558: ldc '--firstYear='
    //   560: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload #20
    //   566: iload_3
    //   567: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload #20
    //   573: ldc '--endMonth='
    //   575: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload #20
    //   581: iload #9
    //   583: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload #20
    //   589: ldc '--endYear='
    //   591: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload #20
    //   597: iload #11
    //   599: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: ldc 'TAG'
    //   605: aload #20
    //   607: invokevirtual toString : ()Ljava/lang/String;
    //   610: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   613: pop
    //   614: ldc 'TAG'
    //   616: ldc '------------5---------'
    //   618: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   621: pop
    //   622: iload_3
    //   623: istore #7
    //   625: iconst_0
    //   626: istore #8
    //   628: iload_2
    //   629: istore #4
    //   631: aload #18
    //   633: astore #21
    //   635: aload #17
    //   637: astore #20
    //   639: aload #21
    //   641: astore #18
    //   643: iload #4
    //   645: istore_2
    //   646: iload #7
    //   648: iload #11
    //   650: if_icmpgt -> 292
    //   653: iload #7
    //   655: iload_3
    //   656: if_icmpne -> 673
    //   659: iload #5
    //   661: istore #6
    //   663: aload #19
    //   665: astore #18
    //   667: iload #9
    //   669: istore_2
    //   670: goto -> 683
    //   673: iconst_0
    //   674: istore #6
    //   676: iload #9
    //   678: istore_2
    //   679: aload #19
    //   681: astore #18
    //   683: iload #7
    //   685: iload #11
    //   687: if_icmpne -> 696
    //   690: iload_2
    //   691: istore #9
    //   693: goto -> 700
    //   696: bipush #11
    //   698: istore #9
    //   700: iload #6
    //   702: iload #9
    //   704: if_icmpgt -> 1682
    //   707: iload #8
    //   709: iconst_1
    //   710: iadd
    //   711: istore #8
    //   713: iload #7
    //   715: iload #6
    //   717: invokestatic aW : (II)[J
    //   720: astore #22
    //   722: aload #22
    //   724: iload #4
    //   726: laload
    //   727: lstore #13
    //   729: lload #13
    //   731: aload #22
    //   733: iconst_1
    //   734: laload
    //   735: invokestatic f : (JJ)Ljava/util/concurrent/ConcurrentHashMap;
    //   738: invokevirtual entrySet : ()Ljava/util/Set;
    //   741: invokeinterface iterator : ()Ljava/util/Iterator;
    //   746: astore #23
    //   748: ldc ''
    //   750: astore #19
    //   752: iload_2
    //   753: istore #4
    //   755: iload #5
    //   757: istore_2
    //   758: aload #19
    //   760: astore #20
    //   762: aload #23
    //   764: invokeinterface hasNext : ()Z
    //   769: istore #12
    //   771: iload #12
    //   773: ifeq -> 1356
    //   776: aload #23
    //   778: invokeinterface next : ()Ljava/lang/Object;
    //   783: checkcast java/util/Map$Entry
    //   786: astore #26
    //   788: new java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial <init> : ()V
    //   795: astore #19
    //   797: aload #19
    //   799: ldc '------------正在升级--'
    //   801: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload #18
    //   807: astore #24
    //   809: aload #19
    //   811: aload #24
    //   813: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload #19
    //   819: ldc_w '-'
    //   822: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: aload #19
    //   828: iload #7
    //   830: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   833: pop
    //   834: aload #19
    //   836: ldc_w '年-'
    //   839: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload #19
    //   845: iload #6
    //   847: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   850: pop
    //   851: aload #19
    //   853: ldc_w '月数据---------'
    //   856: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: ldc 'TAG'
    //   862: aload #19
    //   864: invokevirtual toString : ()Ljava/lang/String;
    //   867: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   870: pop
    //   871: invokestatic aYt : ()Lorg/greenrobot/eventbus/c;
    //   874: astore #19
    //   876: new java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial <init> : ()V
    //   883: astore #27
    //   885: iload #8
    //   887: i2d
    //   888: ldc2_w 100.0
    //   891: dmul
    //   892: iload #11
    //   894: iload_3
    //   895: isub
    //   896: iconst_1
    //   897: iadd
    //   898: bipush #12
    //   900: imul
    //   901: i2d
    //   902: ddiv
    //   903: dstore_0
    //   904: aload #27
    //   906: dload_0
    //   907: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   910: pop
    //   911: aload #27
    //   913: ldc_w ','
    //   916: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: pop
    //   920: aload #27
    //   922: iload #10
    //   924: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   927: pop
    //   928: aload #27
    //   930: ldc_w ','
    //   933: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: pop
    //   937: aload #27
    //   939: aload #25
    //   941: invokeinterface getCount : ()I
    //   946: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload #19
    //   952: new com/laiqian/db/multidatabase/a
    //   955: dup
    //   956: aload #27
    //   958: invokevirtual toString : ()Ljava/lang/String;
    //   961: invokespecial <init> : (Ljava/lang/String;)V
    //   964: invokevirtual cM : (Ljava/lang/Object;)V
    //   967: aload #26
    //   969: invokeinterface getValue : ()Ljava/lang/Object;
    //   974: checkcast java/lang/String
    //   977: astore #19
    //   979: invokestatic Dr : ()V
    //   982: new java/lang/StringBuilder
    //   985: dup
    //   986: invokespecial <init> : ()V
    //   989: astore #20
    //   991: aload #20
    //   993: ldc_w 'attach database ''
    //   996: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: pop
    //   1000: aload #20
    //   1002: aload #26
    //   1004: invokeinterface getKey : ()Ljava/lang/Object;
    //   1009: checkcast java/lang/String
    //   1012: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: pop
    //   1016: aload #20
    //   1018: ldc_w '' as ''
    //   1021: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: pop
    //   1025: aload #20
    //   1027: aload #26
    //   1029: invokeinterface getValue : ()Ljava/lang/Object;
    //   1034: checkcast java/lang/String
    //   1037: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: aload #20
    //   1043: ldc_w '''
    //   1046: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: pop
    //   1050: aload #20
    //   1052: invokevirtual toString : ()Ljava/lang/String;
    //   1055: astore #27
    //   1057: aload #17
    //   1059: astore #20
    //   1061: aload #20
    //   1063: aload #27
    //   1065: invokevirtual execSQL : (Ljava/lang/String;)V
    //   1068: new java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial <init> : ()V
    //   1075: astore #27
    //   1077: aload #27
    //   1079: ldc_w 'replace into '
    //   1082: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: pop
    //   1086: aload #27
    //   1088: aload #26
    //   1090: invokeinterface getValue : ()Ljava/lang/Object;
    //   1095: checkcast java/lang/String
    //   1098: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload #27
    //   1104: ldc_w '.'
    //   1107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: aload #27
    //   1113: aload #24
    //   1115: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: aload #27
    //   1121: ldc_w ' select * from '
    //   1124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: aload #27
    //   1130: aload #24
    //   1132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: aload #27
    //   1138: ldc_w ' where _id between '
    //   1141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: pop
    //   1145: aload #27
    //   1147: aload #22
    //   1149: iconst_0
    //   1150: laload
    //   1151: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1154: pop
    //   1155: aload #27
    //   1157: ldc_w ' and '
    //   1160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: pop
    //   1164: aload #27
    //   1166: aload #22
    //   1168: iconst_1
    //   1169: laload
    //   1170: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: aload #27
    //   1176: invokevirtual toString : ()Ljava/lang/String;
    //   1179: astore #26
    //   1181: new java/lang/StringBuilder
    //   1184: dup
    //   1185: invokespecial <init> : ()V
    //   1188: astore #27
    //   1190: aload #27
    //   1192: ldc_w '-----------正在升级 insertSql='
    //   1195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: pop
    //   1199: aload #27
    //   1201: aload #26
    //   1203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: aload #27
    //   1209: ldc_w '----------'
    //   1212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: pop
    //   1216: ldc 'TAG'
    //   1218: aload #27
    //   1220: invokevirtual toString : ()Ljava/lang/String;
    //   1223: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1226: pop
    //   1227: aload #20
    //   1229: aload #26
    //   1231: invokevirtual execSQL : (Ljava/lang/String;)V
    //   1234: ldc 'TAG'
    //   1236: ldc_w '------------6-insert---------'
    //   1239: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1242: pop
    //   1243: aload #24
    //   1245: astore #18
    //   1247: aload #20
    //   1249: astore #17
    //   1251: goto -> 758
    //   1254: astore #18
    //   1256: aload #19
    //   1258: astore #20
    //   1260: goto -> 1449
    //   1263: astore #20
    //   1265: goto -> 1295
    //   1268: astore #18
    //   1270: goto -> 1445
    //   1273: astore #20
    //   1275: goto -> 1295
    //   1278: astore #18
    //   1280: goto -> 1445
    //   1283: astore #20
    //   1285: goto -> 1295
    //   1288: astore #18
    //   1290: goto -> 1445
    //   1293: astore #20
    //   1295: aload #19
    //   1297: astore #22
    //   1299: aload #20
    //   1301: astore #19
    //   1303: aload #22
    //   1305: astore #20
    //   1307: goto -> 1458
    //   1310: astore #19
    //   1312: goto -> 1578
    //   1315: astore #19
    //   1317: goto -> 1327
    //   1320: astore #19
    //   1322: goto -> 1327
    //   1325: astore #19
    //   1327: goto -> 1341
    //   1330: astore #18
    //   1332: aload #20
    //   1334: astore #19
    //   1336: goto -> 1445
    //   1339: astore #19
    //   1341: aload #19
    //   1343: astore #22
    //   1345: aload #18
    //   1347: astore #19
    //   1349: aload #22
    //   1351: astore #18
    //   1353: goto -> 1508
    //   1356: aload #18
    //   1358: astore #19
    //   1360: aload #17
    //   1362: astore #18
    //   1364: ldc 'TAG'
    //   1366: ldc_w '------------7-detach--------'
    //   1369: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1372: pop
    //   1373: aload #17
    //   1375: astore #18
    //   1377: new java/lang/StringBuilder
    //   1380: dup
    //   1381: invokespecial <init> : ()V
    //   1384: astore #22
    //   1386: aload #17
    //   1388: astore #18
    //   1390: aload #22
    //   1392: ldc_w 'detach database '
    //   1395: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: pop
    //   1399: aload #17
    //   1401: astore #18
    //   1403: aload #22
    //   1405: aload #20
    //   1407: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: pop
    //   1411: aload #17
    //   1413: astore #18
    //   1415: aload #22
    //   1417: invokevirtual toString : ()Ljava/lang/String;
    //   1420: astore #20
    //   1422: iconst_0
    //   1423: istore #5
    //   1425: aload #17
    //   1427: astore #18
    //   1429: aload #17
    //   1431: aload #20
    //   1433: invokevirtual execSQL : (Ljava/lang/String;)V
    //   1436: goto -> 1740
    //   1439: astore #18
    //   1441: aload #20
    //   1443: astore #19
    //   1445: aload #19
    //   1447: astore #20
    //   1449: aload #18
    //   1451: astore #19
    //   1453: goto -> 1578
    //   1456: astore #19
    //   1458: aload #19
    //   1460: astore #22
    //   1462: aload #18
    //   1464: astore #19
    //   1466: aload #22
    //   1468: astore #18
    //   1470: goto -> 1508
    //   1473: astore #19
    //   1475: goto -> 1487
    //   1478: astore #20
    //   1480: aload #18
    //   1482: astore #19
    //   1484: goto -> 1494
    //   1487: ldc ''
    //   1489: astore #20
    //   1491: goto -> 1578
    //   1494: aload #20
    //   1496: astore #18
    //   1498: ldc ''
    //   1500: astore #20
    //   1502: iload_2
    //   1503: istore #4
    //   1505: iload #5
    //   1507: istore_2
    //   1508: aload #18
    //   1510: invokestatic e : (Ljava/lang/Throwable;)V
    //   1513: aload #17
    //   1515: astore #18
    //   1517: ldc 'TAG'
    //   1519: ldc_w '------------7-detach--------'
    //   1522: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1525: pop
    //   1526: aload #17
    //   1528: astore #18
    //   1530: new java/lang/StringBuilder
    //   1533: dup
    //   1534: invokespecial <init> : ()V
    //   1537: astore #22
    //   1539: aload #17
    //   1541: astore #18
    //   1543: aload #22
    //   1545: ldc_w 'detach database '
    //   1548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: pop
    //   1552: aload #17
    //   1554: astore #18
    //   1556: aload #22
    //   1558: aload #20
    //   1560: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: pop
    //   1564: aload #17
    //   1566: astore #18
    //   1568: aload #22
    //   1570: invokevirtual toString : ()Ljava/lang/String;
    //   1573: astore #20
    //   1575: goto -> 1422
    //   1578: aload #17
    //   1580: astore #18
    //   1582: ldc 'TAG'
    //   1584: ldc_w '------------7-detach--------'
    //   1587: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1590: pop
    //   1591: aload #17
    //   1593: astore #18
    //   1595: new java/lang/StringBuilder
    //   1598: dup
    //   1599: invokespecial <init> : ()V
    //   1602: astore #22
    //   1604: aload #17
    //   1606: astore #18
    //   1608: aload #22
    //   1610: ldc_w 'detach database '
    //   1613: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1616: pop
    //   1617: aload #17
    //   1619: astore #18
    //   1621: aload #22
    //   1623: aload #20
    //   1625: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: pop
    //   1629: aload #17
    //   1631: astore #18
    //   1633: aload #17
    //   1635: aload #22
    //   1637: invokevirtual toString : ()Ljava/lang/String;
    //   1640: invokevirtual execSQL : (Ljava/lang/String;)V
    //   1643: aload #17
    //   1645: astore #18
    //   1647: aload #19
    //   1649: athrow
    //   1650: iconst_0
    //   1651: istore_2
    //   1652: astore #17
    //   1654: goto -> 1670
    //   1657: astore #19
    //   1659: iload #4
    //   1661: istore_2
    //   1662: aload #17
    //   1664: astore #18
    //   1666: aload #19
    //   1668: astore #17
    //   1670: aload #17
    //   1672: invokestatic e : (Ljava/lang/Throwable;)V
    //   1675: aload #21
    //   1677: astore #17
    //   1679: goto -> 1698
    //   1682: iload #7
    //   1684: iconst_1
    //   1685: iadd
    //   1686: istore #7
    //   1688: aload #18
    //   1690: astore #19
    //   1692: iload_2
    //   1693: istore #9
    //   1695: goto -> 635
    //   1698: aload #17
    //   1700: astore #19
    //   1702: aload #18
    //   1704: astore #17
    //   1706: aload #19
    //   1708: astore #18
    //   1710: iload #10
    //   1712: istore_3
    //   1713: goto -> 253
    //   1716: aload #25
    //   1718: invokeinterface close : ()V
    //   1723: aload #18
    //   1725: invokeinterface close : ()V
    //   1730: ldc 'TAG'
    //   1732: ldc_w '------------8---------'
    //   1735: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1738: pop
    //   1739: return
    //   1740: iload #6
    //   1742: iconst_1
    //   1743: iadd
    //   1744: istore #9
    //   1746: aload #19
    //   1748: astore #18
    //   1750: iload #4
    //   1752: istore #6
    //   1754: iload #5
    //   1756: istore #4
    //   1758: iload_2
    //   1759: istore #5
    //   1761: iload #6
    //   1763: istore_2
    //   1764: iload #9
    //   1766: istore #6
    //   1768: goto -> 683
    //   1771: astore #19
    //   1773: goto -> 1578
    // Exception table:
    //   from	to	target	type
    //   713	722	1657	java/lang/Exception
    //   729	748	1478	java/lang/Exception
    //   729	748	1473	finally
    //   762	771	1456	java/lang/Exception
    //   762	771	1439	finally
    //   776	805	1339	java/lang/Exception
    //   776	805	1330	finally
    //   809	817	1325	java/lang/Exception
    //   809	817	1330	finally
    //   817	885	1320	java/lang/Exception
    //   817	885	1330	finally
    //   904	979	1315	java/lang/Exception
    //   904	979	1310	finally
    //   979	1057	1293	java/lang/Exception
    //   979	1057	1288	finally
    //   1061	1145	1283	java/lang/Exception
    //   1061	1145	1278	finally
    //   1145	1164	1273	java/lang/Exception
    //   1145	1164	1268	finally
    //   1164	1243	1263	java/lang/Exception
    //   1164	1243	1254	finally
    //   1364	1373	1650	java/lang/Exception
    //   1377	1386	1650	java/lang/Exception
    //   1390	1399	1650	java/lang/Exception
    //   1403	1411	1650	java/lang/Exception
    //   1415	1422	1650	java/lang/Exception
    //   1429	1436	1650	java/lang/Exception
    //   1508	1513	1771	finally
    //   1517	1526	1650	java/lang/Exception
    //   1530	1539	1650	java/lang/Exception
    //   1543	1552	1650	java/lang/Exception
    //   1556	1564	1650	java/lang/Exception
    //   1568	1575	1650	java/lang/Exception
    //   1582	1591	1650	java/lang/Exception
    //   1595	1604	1650	java/lang/Exception
    //   1608	1617	1650	java/lang/Exception
    //   1621	1629	1650	java/lang/Exception
    //   1633	1643	1650	java/lang/Exception
    //   1647	1650	1650	java/lang/Exception }
  
  public static void Dq() {
    SQLiteDatabase sQLiteDatabase = b.aOw.Dk();
    List list = sQLiteDatabase.getAttachedDbs();
    if (list != null) {
      if (list.isEmpty())
        return; 
      if (list.size() < 7)
        return; 
      for (byte b1 = 0; b1 < list.size(); b1++) {
        Pair pair = (Pair)list.get(b1);
        if (!"main".equals(pair.first)) {
          String str = cu((String)pair.second);
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("reportRoot的detachSQL alia-->");
          stringBuilder2.append((String)pair.second);
          stringBuilder2.append("----");
          stringBuilder2.append(str);
          ct(stringBuilder2.toString());
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("DETACH DATABASE ");
          stringBuilder1.append(str);
          str = stringBuilder1.toString();
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("reportRoot的detachSQL-->");
          stringBuilder1.append(str);
          ct(stringBuilder1.toString());
          sQLiteDatabase.execSQL(str);
        } 
      } 
      return;
    } 
  }
  
  public static void Dr() {
    SQLiteDatabase sQLiteDatabase = b.aOw.Dk();
    List list = sQLiteDatabase.getAttachedDbs();
    if (list != null) {
      if (list.isEmpty())
        return; 
      for (byte b1 = 0; b1 < list.size(); b1++) {
        Pair pair = (Pair)list.get(b1);
        if (!"main".equals(pair.first)) {
          String str = cu((String)pair.second);
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("reportRoot的detachSQL alia-->");
          stringBuilder2.append((String)pair.second);
          stringBuilder2.append("----");
          stringBuilder2.append(str);
          ct(stringBuilder2.toString());
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("DETACH DATABASE ");
          stringBuilder1.append(str);
          str = stringBuilder1.toString();
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("reportRoot的detachSQL-->");
          stringBuilder1.append(str);
          ct(stringBuilder1.toString());
          sQLiteDatabase.execSQL(str);
        } 
      } 
      return;
    } 
  }
  
  public static int S(long paramLong) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(paramLong);
    return calendar.get(2) + 1;
  }
  
  public static int T(long paramLong) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(paramLong);
    return calendar.get(2);
  }
  
  public static int U(long paramLong) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(paramLong);
    return calendar.get(1);
  }
  
  public static String V(long paramLong) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(paramLong);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(calendar.get(1));
    stringBuilder.append("年");
    stringBuilder.append(calendar.get(2) + 1);
    stringBuilder.append("月");
    stringBuilder.append(calendar.get(5));
    stringBuilder.append("日");
    stringBuilder.append(calendar.get(11));
    stringBuilder.append("时");
    stringBuilder.append(calendar.get(12));
    stringBuilder.append("分");
    stringBuilder.append(calendar.get(13));
    stringBuilder.append("秒");
    stringBuilder.append(calendar.get(14));
    stringBuilder.append("毫秒");
    return stringBuilder.toString();
  }
  
  public static String aU(int paramInt1, int paramInt2) {
    String str = eh(paramInt1).getDatabaseName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str.substring(0, str.lastIndexOf(".")));
    stringBuilder.append(paramInt2);
    return stringBuilder.toString();
  }
  
  public static String aV(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a.aOz);
    stringBuilder.append(paramInt2);
    stringBuilder.append(File.separator);
    stringBuilder.append(eh(paramInt1).getDatabaseName());
    return stringBuilder.toString();
  }
  
  @Size
  public static long[] aW(int paramInt1, int paramInt2) {
    int i;
    Calendar calendar = Calendar.getInstance();
    int j = paramInt2 + 1;
    if (j == 12) {
      i = paramInt1 + 1;
    } else {
      i = paramInt1;
    } 
    if (j == 12)
      j = 0; 
    calendar.set(i, j, 1, 0, 0, 0);
    calendar.setTimeInMillis(calendar.getTimeInMillis() - calendar.get(14) - 1L);
    long l = calendar.getTimeInMillis();
    calendar.set(paramInt1, paramInt2, 1, 0, 0, 0);
    return new long[] { calendar.getTimeInMillis() - calendar.get(14), l };
  }
  
  public static List<String> b(File paramFile, List<String> paramList) {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null) {
      int i = arrayOfFile.length;
      for (byte b1 = 0; b1 < i; b1++) {
        File file = arrayOfFile[b1];
        if (file.isDirectory()) {
          b(file, paramList);
        } else if (cx(file.getPath()) >= a.aOC && !file.getPath().contains("-journal")) {
          paramList.add(file.getPath());
        } 
      } 
    } 
    return paramList;
  }
  
  @DebugLog
  private static ConcurrentHashMap<String, String> b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) throws Exception {
    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    if (paramInt2 > paramInt4)
      throw new Exception("startTime must lower than endTime"); 
    int i = paramInt2;
    if (paramInt2 > Calendar.getInstance().get(1)) {
      i = Calendar.getInstance().get(1);
      paramInt1 = S(ei(i).getTime());
    } 
    int j = paramInt3;
    paramInt3 = paramInt4;
    if (paramInt4 > Calendar.getInstance().get(1)) {
      paramInt3 = Calendar.getInstance().get(1);
      j = S(ei(paramInt3).getTime());
    } 
    int k = paramInt3;
    paramInt3 = j - paramInt1;
    if (paramInt3 < 0 && i == k)
      throw new Exception("startTime must lower than endTime"); 
    if (!paramBoolean && !e(paramInt1, i, j, k, 3))
      throw new IllegalArgumentException("时间跨度不能超过3个月"); 
    if (paramInt4 - paramInt2 == 0) {
      paramInt2 = paramInt1;
      if (paramInt3 == 0) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("时间区间是同一个年份--");
        stringBuilder1.append(i);
        stringBuilder1.append("--同一个月分--");
        stringBuilder1.append(paramInt1);
        ct(stringBuilder1.toString());
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(a.aOz);
        stringBuilder1.append(i);
        stringBuilder1.append(File.separator);
        stringBuilder1.append(eh(paramInt1).getDatabaseName());
        String str = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("数据库地址：");
        stringBuilder2.append(str);
        ct(stringBuilder2.toString());
        concurrentHashMap.put(str, aU(paramInt1, i));
      } else {
        while (paramInt2 <= j) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("时间是同一个年份");
          stringBuilder.append(i);
          stringBuilder.append("跨越了");
          stringBuilder.append(paramInt2);
          stringBuilder.append("月份");
          ct(stringBuilder.toString());
          stringBuilder = new StringBuilder();
          stringBuilder.append("数据库地址：");
          stringBuilder.append(a.aOz);
          stringBuilder.append(i);
          stringBuilder.append(File.separator);
          stringBuilder.append(eh(paramInt2).getDatabaseName());
          ct(stringBuilder.toString());
          stringBuilder = new StringBuilder();
          stringBuilder.append(a.aOz);
          stringBuilder.append(i);
          stringBuilder.append(File.separator);
          stringBuilder.append(eh(paramInt2).getDatabaseName());
          concurrentHashMap.put(stringBuilder.toString(), aU(paramInt2, i));
          paramInt2++;
        } 
      } 
    } else {
      for (paramInt2 = i; paramInt2 <= k; paramInt2++) {
        if (paramInt2 == i) {
          for (paramInt3 = paramInt1; paramInt3 <= 12; paramInt3++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("跨越了");
            stringBuilder.append(paramInt2);
            stringBuilder.append("年");
            stringBuilder.append(paramInt3);
            stringBuilder.append("月");
            ct(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("数据库地址：");
            stringBuilder.append(a.aOz);
            stringBuilder.append(paramInt2);
            stringBuilder.append(File.separator);
            stringBuilder.append(eh(paramInt3).getDatabaseName());
            ct(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(a.aOz);
            stringBuilder.append(paramInt2);
            stringBuilder.append(File.separator);
            stringBuilder.append(eh(paramInt3).getDatabaseName());
            concurrentHashMap.put(stringBuilder.toString(), aU(paramInt3, paramInt2));
          } 
        } else if (paramInt2 == k) {
          for (paramInt3 = 1; paramInt3 <= j; paramInt3++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("跨越了");
            stringBuilder.append(paramInt2);
            stringBuilder.append("年");
            stringBuilder.append(paramInt3);
            stringBuilder.append("月");
            ct(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("数据库地址：");
            stringBuilder.append(a.aOz);
            stringBuilder.append(paramInt2);
            stringBuilder.append(File.separator);
            stringBuilder.append(eh(paramInt3).getDatabaseName());
            ct(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(a.aOz);
            stringBuilder.append(paramInt2);
            stringBuilder.append(File.separator);
            stringBuilder.append(eh(paramInt3).getDatabaseName());
            concurrentHashMap.put(stringBuilder.toString(), aU(paramInt3, paramInt2));
          } 
        } else {
          for (paramInt3 = 1; paramInt3 <= 12; paramInt3++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("跨越了");
            stringBuilder.append(paramInt2);
            stringBuilder.append("年");
            stringBuilder.append(paramInt3);
            stringBuilder.append("月");
            ct(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("数据库地址：");
            stringBuilder.append(a.aOz);
            stringBuilder.append(paramInt2);
            stringBuilder.append(File.separator);
            stringBuilder.append(eh(paramInt3).getDatabaseName());
            ct(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(a.aOz);
            stringBuilder.append(paramInt2);
            stringBuilder.append(File.separator);
            stringBuilder.append(eh(paramInt3).getDatabaseName());
            concurrentHashMap.put(stringBuilder.toString(), aU(paramInt3, paramInt2));
          } 
        } 
      } 
    } 
    b(concurrentHashMap);
    return concurrentHashMap;
  }
  
  private static void b(ConcurrentHashMap<String, String> paramConcurrentHashMap) {
    for (Map.Entry entry : paramConcurrentHashMap.entrySet())
      a.Dl().cr((String)entry.getKey()); 
  }
  
  public static <T> T[] c(T[] paramArrayOfT, int paramInt) {
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length * paramInt);
    byte b1 = 0;
    while (b1 < paramInt - 1)
      System.arraycopy(paramArrayOfT, 0, arrayOfObject, paramArrayOfT.length * ++b1, paramArrayOfT.length); 
    return (T[])arrayOfObject;
  }
  
  public static boolean cs(String paramString) {
    File file = new File(paramString);
    if (!file.exists()) {
      boolean bool = file.mkdirs();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("创建文件--");
      stringBuilder.append(bool);
      ct(stringBuilder.toString());
      return bool;
    } 
    return true;
  }
  
  @DebugLog
  public static void ct(String paramString) {
    if (DEBUG)
      Log.i(TAG, paramString); 
  }
  
  public static String cu(String paramString) {
    String str = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
    paramString = paramString.substring(paramString.lastIndexOf("/") - 4, paramString.lastIndexOf("/"));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private static int cv(String paramString) {
    int i = paramString.hashCode();
    byte b1 = 1;
    switch (i) {
      default:
        i = -1;
        break;
      case 1896367803:
        if (paramString.equals("september.db")) {
          i = 8;
          break;
        } 
      case 1820635834:
        if (paramString.equals("november.db")) {
          i = 10;
          break;
        } 
      case 1234032870:
        if (paramString.equals("april.db")) {
          i = 3;
          break;
        } 
      case 262344423:
        if (paramString.equals("december.db")) {
          i = 11;
          break;
        } 
      case 239606793:
        if (paramString.equals("march.db")) {
          i = 2;
          break;
        } 
      case -248922548:
        if (paramString.equals("october.db")) {
          i = 9;
          break;
        } 
      case -799700862:
        if (paramString.equals("january.db")) {
          i = 0;
          break;
        } 
      case -1081156185:
        if (paramString.equals("may.db")) {
          i = 4;
          break;
        } 
      case -1096127415:
        if (paramString.equals("august.db")) {
          i = 7;
          break;
        } 
      case -1254603350:
        if (paramString.equals("june.db")) {
          i = 5;
          break;
        } 
      case -1255854572:
        if (paramString.equals("july.db")) {
          i = 6;
          break;
        } 
      case -1848725942:
        if (paramString.equals("february.db")) {
          i = 1;
          break;
        } 
    } 
    switch (i) {
      default:
        return 0;
      case 11:
        return 12;
      case 10:
        return 11;
      case 9:
        return 10;
      case 8:
        return 9;
      case 7:
        return 8;
      case 6:
        return 7;
      case 5:
        return 6;
      case 4:
        return 5;
      case 3:
        return 4;
      case 2:
        return 3;
      case 1:
        b1 = 2;
        break;
      case 0:
        break;
    } 
    return b1;
  }
  
  public static int cw(String paramString) {
    if (paramString.contains("-journal")) {
      paramString = paramString.replaceAll("-journal", "").substring(paramString.lastIndexOf("/") + 1);
    } else {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1);
    } 
    return cv(paramString);
  }
  
  public static int cx(String paramString) { return Integer.parseInt(paramString.substring(paramString.lastIndexOf("/") - 4, paramString.lastIndexOf("/"))); }
  
  public static boolean e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    paramInt2 = paramInt4 - paramInt2;
    paramInt4 = paramInt3 - paramInt1;
    if (paramInt2 == 0) {
      if (paramInt4 > paramInt5 - 1)
        return false; 
    } else {
      return (paramInt2 == 1) ? ((paramInt4 == 0) ? false : (!(Math.abs(paramInt1 - paramInt3 + 12) + 1 > paramInt5))) : false;
    } 
    return true;
  }
  
  public static boolean eg(int paramInt) { return (paramInt > 0); }
  
  public static a eh(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 12:
        return a.aOt;
      case 11:
        return a.aOs;
      case 10:
        return a.aOr;
      case 9:
        return a.aOq;
      case 8:
        return a.aOp;
      case 7:
        return a.aOo;
      case 6:
        return a.aOn;
      case 5:
        return a.aOm;
      case 4:
        return a.aOl;
      case 3:
        return a.aOk;
      case 2:
        return a.aOj;
      case 1:
        break;
    } 
    return a.aOi;
  }
  
  private static Date ei(int paramInt) {
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(1, paramInt);
    calendar.roll(6, -1);
    return calendar.getTime();
  }
  
  public static ConcurrentHashMap<String, String> f(long paramLong1, long paramLong2) throws Exception {
    if (paramLong1 == 0L) {
      l = a.aOD;
    } else {
      l = paramLong1;
    } 
    int i = S(l);
    long l = paramLong1;
    if (paramLong1 == 0L)
      l = a.aOD; 
    return l(i, U(l), S(paramLong2), U(paramLong2));
  }
  
  public static List<String> g(long paramLong1, long paramLong2) throws Exception {
    ArrayList arrayList = new ArrayList();
    if (paramLong1 == 0L) {
      l = a.aOD;
    } else {
      l = paramLong1;
    } 
    int i = S(l);
    long l = paramLong1;
    if (paramLong1 == 0L)
      l = a.aOD; 
    Iterator iterator = l(i, U(l), S(paramLong2), U(paramLong2)).entrySet().iterator();
    while (iterator.hasNext())
      arrayList.add(((Map.Entry)iterator.next()).getValue()); 
    return arrayList;
  }
  
  public static boolean h(long paramLong1, long paramLong2) {
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTimeInMillis(paramLong1);
    Calendar calendar2 = Calendar.getInstance();
    calendar2.setTimeInMillis(paramLong2);
    int i = calendar2.get(2);
    int j = calendar1.get(2);
    return !(Math.abs((calendar2.get(1) - calendar1.get(1)) * 12 + i - j) > 6);
  }
  
  public static List<String> i(long paramLong1, long paramLong2) throws Exception {
    ArrayList arrayList = new ArrayList();
    if (paramLong1 == 0L) {
      l = a.aOD;
    } else {
      l = paramLong1;
    } 
    int i = S(l);
    long l = paramLong1;
    if (paramLong1 == 0L)
      l = a.aOD; 
    Iterator iterator = b(i, U(l), S(paramLong2), U(paramLong2), true).entrySet().iterator();
    while (iterator.hasNext())
      arrayList.add(((Map.Entry)iterator.next()).getKey()); 
    return arrayList;
  }
  
  public static ConcurrentHashMap<String, String> l(int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws Exception { return b(paramInt1, paramInt2, paramInt3, paramInt4, false); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\multidatabase\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */