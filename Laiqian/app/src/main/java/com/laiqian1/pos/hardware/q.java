package com.laiqian.pos.hardware;

import android.util.Log;
import com.google.a.a.a.a.a.a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class q extends RootUrlParameter {
  public static String bID;
  
  public static final String bIz;
  
  private static String ckO = "http://hotpatch-singapore.91laiqian.cn";
  
  private static String ckP = "http://hotpatch-pre-slb.91laiqian.cn";
  
  private static String ckQ = "http://hotpatch.91laiqian.cn";
  
  public static final String cmC;
  
  public static final String cmD;
  
  public static final String cmE;
  
  public static final String cmF;
  
  public static final String cmG;
  
  public static String cmH = "http://1572569036704262.mns.cn-hangzhou.aliyuncs.com/";
  
  public static final String cmI;
  
  static  {
    switch (zp()) {
      default:
        ckJ = "interface.91laiqian.com";
        ckN = ckQ;
        cmC = "ONLINE-SYNC-PROD";
        cmD = "LOGIN-PROD";
        cmE = "SYNC-PROD";
        cmF = "ORDER-PROD";
        bIz = "NOTIFICATION-PROD";
        cmG = "PAY-CHECK";
        break;
      case 12:
        ckJ = "interface.jindou.info";
        ckN = "http://hotpatch.jindou.info";
        cmC = "ONLINE-SYNC-PROD";
        cmD = "LOGIN-PROD";
        cmE = "SYNC-PROD";
        cmF = "ORDER-PROD";
        bIz = "NOTIFICATION-PROD";
        cmG = "PAY-CHECK";
        break;
      case 11:
        ckJ = "interface.91laiqian.com";
        ckS = "https://wallet20180329.91laiqian.com/";
        cmC = "ONLINE-SYNC-PROD";
        cmD = "LOGIN-PROD";
        cmE = "SYNC-PROD";
        cmF = "ORDER-PROD";
        bIz = "NOTIFICATION-PROD";
        cmG = "PAY-CHECK";
        break;
      case 10:
        ckJ = "interface.jindou.info";
        ckN = "http://hotpatch.jindou.info";
        cmC = "ONLINE-SYNC-PROD";
        cmD = "LOGIN-PROD";
        cmE = "SYNC-PROD";
        cmF = "ORDER-PROD";
        bIz = "NOTIFICATION-PROD";
        cmG = "PAY-CHECK";
        break;
      case 9:
        ckJ = "singapore.91laiqian.com";
        ckN = ckO;
        cmC = "ONLINE-SYNC-ABROAD";
        cmD = "LOGIN-ABROAD";
        cmE = "SYNC-ABROAD";
        cmF = "ORDER-ABROAD";
        bIz = "NOTIFICATION-ABROAD";
        cmG = "PAY-CHECK";
        break;
      case 8:
        ckJ = "interface.androidcloudpos.cn";
        ckN = "http://hotpatch.androidcloudpos.cn";
        cmC = "ONLINE-SYNC-PROD";
        cmD = "LOGIN-PROD";
        cmE = "SYNC-PROD";
        cmF = "ORDER-PROD";
        bIz = "NOTIFICATION-PROD";
        cmG = "PAY-CHECK";
        break;
      case 6:
        ckJ = "pos-pre-slb.91laiqian.com";
        ckM = "http://pos-pre-evako.91laiqian.com/";
        ckN = ckP;
        cmC = "ONLINE-SYNC";
        cmD = "LOGIN";
        cmE = "SYNC";
        cmF = "ORDER";
        bIz = "NOTIFICATION";
        cmG = "PRE-PAY-CHECK";
        break;
      case 5:
        ckJ = "singapore.91laiqian.com";
        ckM = "http://order.evako.asia/";
        ckN = ckO;
        cmC = "ONLINE-SYNC-ABROAD";
        cmD = "LOGIN-ABROAD";
        cmE = "SYNC-ABROAD";
        cmF = "ORDER-ABROAD";
        bIz = "NOTIFICATION-ABROAD";
        cmG = "PAY-CHECK";
        break;
      case 4:
        ckJ = "singapore.91laiqian.com";
        ckN = ckO;
        cmC = "ONLINE-SYNC-ABROAD";
        cmD = "LOGIN-ABROAD";
        cmE = "SYNC-ABROAD";
        cmF = "ORDER-ABROAD";
        bIz = "NOTIFICATION-ABROAD";
        cmG = "PAY-CHECK-ABROAD";
        break;
      case 3:
        ckJ = "pos-pre-slb.91laiqian.com";
        cmC = "ONLINE-SYNC";
        cmD = "LOGIN";
        cmE = "SYNC";
        cmF = "ORDER";
        bIz = "NOTIFICATION";
        cmG = "PRE-PAY-CHECK";
        ckM = "http://order.evako.asia/";
        ckN = ckP;
        break;
    } 
    int i = zp();
    if (i != 9) {
      switch (i) {
        default:
          bID = "http://oss-cn-qingdao.aliyuncs.com";
          cmH = "http://1572569036704262.mns.cn-hangzhou.aliyuncs.com/";
          break;
        case 4:
        case 5:
          bID = "http://oss-ap-southeast-1.aliyuncs.com";
          cmH = "http://1572569036704262.mns.ap-southeast-1.aliyuncs.com/";
          break;
      } 
      try {
        String str13;
        String str12;
        String str11;
        String str10;
        String str9;
        String str8;
        String str7;
        String str6;
        String str5;
        String str4;
        String str3;
        String str2;
        String str1;
        if (ckJ.contains("http")) {
          str1 = (new URL(ckJ)).getHost();
        } else {
          str1 = ckJ;
        } 
        if (ckV.contains("http")) {
          str2 = (new URL(ckV)).getHost();
        } else {
          str2 = ckV;
        } 
        if (ckN.contains("http")) {
          str3 = (new URL(ckN)).getHost();
        } else {
          str3 = ckN;
        } 
        if (ckS.contains("http")) {
          str4 = (new URL(ckS)).getHost();
        } else {
          str4 = ckS;
        } 
        if (ckC.contains("http")) {
          str5 = (new URL(ckC)).getHost();
        } else {
          str5 = ckC;
        } 
        if (ckD.contains("http")) {
          str6 = (new URL(ckD)).getHost();
        } else {
          str6 = ckD;
        } 
        if (ckI.contains("http")) {
          str7 = (new URL(ckI)).getHost();
        } else {
          str7 = ckI;
        } 
        if (ckY.contains("http")) {
          str8 = (new URL(ckY)).getHost();
        } else {
          str8 = ckY;
        } 
        if (ckZ.contains("http")) {
          str9 = (new URL(ckZ)).getHost();
        } else {
          str9 = ckZ;
        } 
        if (cla.contains("http")) {
          str10 = (new URL(cla)).getHost();
        } else {
          str10 = cla;
        } 
        if (clk.contains("http")) {
          str11 = (new URL(clk)).getHost();
        } else {
          str11 = clk;
        } 
        if (ckT.contains("http")) {
          str12 = (new URL(ckT)).getHost();
        } else {
          str12 = ckT;
        } 
        if (ckU.contains("http")) {
          str13 = (new URL(ckU)).getHost();
        } else {
          str13 = ckU;
        } 
        clm = new ArrayList(Arrays.asList(new String[] { 
                str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, 
                str11, str12, str13 }));
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("URLLIST:");
        stringBuilder1.append(clm.toString());
        Log.d("_LQK", stringBuilder1.toString());
      } catch (MalformedURLException malformedURLException) {
        a.e(malformedURLException);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(ckC);
      stringBuilder.append("user/change-password");
      cmI = stringBuilder.toString();
      return;
    } 
  }
  
  public static int zp() { // Byte code:
    //   0: ldc 'prod'
    //   2: invokevirtual hashCode : ()I
    //   5: istore_0
    //   6: iconst_0
    //   7: istore_3
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_0
    //   11: ldc 111267
    //   13: if_icmpeq -> 40
    //   16: iload_0
    //   17: ldc 3449687
    //   19: if_icmpeq -> 25
    //   22: goto -> 55
    //   25: ldc 'prod'
    //   27: ldc 'prod'
    //   29: invokevirtual equals : (Ljava/lang/Object;)Z
    //   32: ifeq -> 55
    //   35: iconst_1
    //   36: istore_0
    //   37: goto -> 57
    //   40: ldc 'prod'
    //   42: ldc 'pre'
    //   44: invokevirtual equals : (Ljava/lang/Object;)Z
    //   47: ifeq -> 55
    //   50: iconst_0
    //   51: istore_0
    //   52: goto -> 57
    //   55: iconst_m1
    //   56: istore_0
    //   57: iconst_4
    //   58: istore_1
    //   59: iload_0
    //   60: tableswitch default -> 84, 0 -> 641, 1 -> 94
    //   84: new java/lang/IllegalStateException
    //   87: dup
    //   88: ldc '未定义的 FLAVOR_environment'
    //   90: invokespecial <init> : (Ljava/lang/String;)V
    //   93: athrow
    //   94: ldc 'lqk'
    //   96: invokevirtual hashCode : ()I
    //   99: lookupswitch default -> 244, -2057880470 -> 507, -1159930917 -> 490, -1138526881 -> 474, -1102662825 -> 457, -1048825921 -> 440, -708812539 -> 424, -319595696 -> 407, -190625801 -> 390, 97728 -> 374, 101293 -> 358, 107398 -> 342, 96887604 -> 325, 97782103 -> 309, 554980728 -> 294, 950388016 -> 279, 1659666169 -> 263, 1993200265 -> 247
    //   244: goto -> 524
    //   247: ldc 'lqk'
    //   249: ldc 'chuanbei'
    //   251: invokevirtual equals : (Ljava/lang/Object;)Z
    //   254: ifeq -> 524
    //   257: bipush #13
    //   259: istore_0
    //   260: goto -> 526
    //   263: ldc 'lqk'
    //   265: ldc 'chuanbeib'
    //   267: invokevirtual equals : (Ljava/lang/Object;)Z
    //   270: ifeq -> 524
    //   273: bipush #14
    //   275: istore_0
    //   276: goto -> 526
    //   279: ldc 'lqk'
    //   281: ldc 'menuway'
    //   283: invokevirtual equals : (Ljava/lang/Object;)Z
    //   286: ifeq -> 524
    //   289: iconst_4
    //   290: istore_0
    //   291: goto -> 526
    //   294: ldc 'lqk'
    //   296: ldc 'cashcow'
    //   298: invokevirtual equals : (Ljava/lang/Object;)Z
    //   301: ifeq -> 524
    //   304: iconst_5
    //   305: istore_0
    //   306: goto -> 526
    //   309: ldc 'lqk'
    //   311: ldc 'fubei'
    //   313: invokevirtual equals : (Ljava/lang/Object;)Z
    //   316: ifeq -> 524
    //   319: bipush #15
    //   321: istore_0
    //   322: goto -> 526
    //   325: ldc 'lqk'
    //   327: ldc_w 'evako'
    //   330: invokevirtual equals : (Ljava/lang/Object;)Z
    //   333: ifeq -> 524
    //   336: bipush #6
    //   338: istore_0
    //   339: goto -> 526
    //   342: ldc 'lqk'
    //   344: ldc 'lqk'
    //   346: invokevirtual equals : (Ljava/lang/Object;)Z
    //   349: ifeq -> 524
    //   352: bipush #8
    //   354: istore_0
    //   355: goto -> 526
    //   358: ldc 'lqk'
    //   360: ldc_w 'ffm'
    //   363: invokevirtual equals : (Ljava/lang/Object;)Z
    //   366: ifeq -> 524
    //   369: iload_2
    //   370: istore_0
    //   371: goto -> 526
    //   374: ldc 'lqk'
    //   376: ldc_w 'bom'
    //   379: invokevirtual equals : (Ljava/lang/Object;)Z
    //   382: ifeq -> 524
    //   385: iconst_2
    //   386: istore_0
    //   387: goto -> 526
    //   390: ldc 'lqk'
    //   392: ldc_w 'lightsblue'
    //   395: invokevirtual equals : (Ljava/lang/Object;)Z
    //   398: ifeq -> 524
    //   401: bipush #10
    //   403: istore_0
    //   404: goto -> 526
    //   407: ldc 'lqk'
    //   409: ldc_w 'zhenzhu'
    //   412: invokevirtual equals : (Ljava/lang/Object;)Z
    //   415: ifeq -> 524
    //   418: bipush #11
    //   420: istore_0
    //   421: goto -> 526
    //   424: ldc 'lqk'
    //   426: ldc_w 'kipcash'
    //   429: invokevirtual equals : (Ljava/lang/Object;)Z
    //   432: ifeq -> 524
    //   435: iconst_1
    //   436: istore_0
    //   437: goto -> 526
    //   440: ldc 'lqk'
    //   442: ldc_w 'newsmy'
    //   445: invokevirtual equals : (Ljava/lang/Object;)Z
    //   448: ifeq -> 524
    //   451: bipush #9
    //   453: istore_0
    //   454: goto -> 526
    //   457: ldc 'lqk'
    //   459: ldc_w 'linnuo'
    //   462: invokevirtual equals : (Ljava/lang/Object;)Z
    //   465: ifeq -> 524
    //   468: bipush #12
    //   470: istore_0
    //   471: goto -> 526
    //   474: ldc 'lqk'
    //   476: ldc_w 'kassen'
    //   479: invokevirtual equals : (Ljava/lang/Object;)Z
    //   482: ifeq -> 524
    //   485: iconst_3
    //   486: istore_0
    //   487: goto -> 526
    //   490: ldc 'lqk'
    //   492: ldc_w 'jindou'
    //   495: invokevirtual equals : (Ljava/lang/Object;)Z
    //   498: ifeq -> 524
    //   501: bipush #7
    //   503: istore_0
    //   504: goto -> 526
    //   507: ldc 'lqk'
    //   509: ldc_w 'xingpei'
    //   512: invokevirtual equals : (Ljava/lang/Object;)Z
    //   515: ifeq -> 524
    //   518: bipush #16
    //   520: istore_0
    //   521: goto -> 526
    //   524: iconst_m1
    //   525: istore_0
    //   526: iload_0
    //   527: tableswitch default -> 608, 0 -> 1172, 1 -> 1172, 2 -> 1172, 3 -> 1172, 4 -> 1172, 5 -> 1172, 6 -> 639, 7 -> 636, 8 -> 634, 9 -> 1172, 10 -> 631, 11 -> 628, 12 -> 625, 13 -> 622, 14 -> 622, 15 -> 622, 16 -> 619
    //   608: new java/lang/IllegalStateException
    //   611: dup
    //   612: ldc_w '未定义的 FLAVOR_brand'
    //   615: invokespecial <init> : (Ljava/lang/String;)V
    //   618: athrow
    //   619: bipush #14
    //   621: ireturn
    //   622: bipush #13
    //   624: ireturn
    //   625: bipush #11
    //   627: ireturn
    //   628: bipush #12
    //   630: ireturn
    //   631: bipush #8
    //   633: ireturn
    //   634: iconst_2
    //   635: ireturn
    //   636: bipush #10
    //   638: ireturn
    //   639: iconst_5
    //   640: ireturn
    //   641: ldc 'lqk'
    //   643: invokevirtual hashCode : ()I
    //   646: lookupswitch default -> 792, -2057880470 -> 1055, -1159930917 -> 1038, -1138526881 -> 1022, -1102662825 -> 1005, -1048825921 -> 988, -708812539 -> 972, -319595696 -> 955, -190625801 -> 938, 97728 -> 922, 101293 -> 906, 107398 -> 890, 96887604 -> 873, 97782103 -> 857, 554980728 -> 842, 950388016 -> 827, 1659666169 -> 811, 1993200265 -> 795
    //   792: goto -> 1072
    //   795: ldc 'lqk'
    //   797: ldc 'chuanbei'
    //   799: invokevirtual equals : (Ljava/lang/Object;)Z
    //   802: ifeq -> 1072
    //   805: bipush #11
    //   807: istore_0
    //   808: goto -> 1074
    //   811: ldc 'lqk'
    //   813: ldc 'chuanbeib'
    //   815: invokevirtual equals : (Ljava/lang/Object;)Z
    //   818: ifeq -> 1072
    //   821: bipush #12
    //   823: istore_0
    //   824: goto -> 1074
    //   827: ldc 'lqk'
    //   829: ldc 'menuway'
    //   831: invokevirtual equals : (Ljava/lang/Object;)Z
    //   834: ifeq -> 1072
    //   837: iconst_4
    //   838: istore_0
    //   839: goto -> 1074
    //   842: ldc 'lqk'
    //   844: ldc 'cashcow'
    //   846: invokevirtual equals : (Ljava/lang/Object;)Z
    //   849: ifeq -> 1072
    //   852: iconst_5
    //   853: istore_0
    //   854: goto -> 1074
    //   857: ldc 'lqk'
    //   859: ldc 'fubei'
    //   861: invokevirtual equals : (Ljava/lang/Object;)Z
    //   864: ifeq -> 1072
    //   867: bipush #13
    //   869: istore_0
    //   870: goto -> 1074
    //   873: ldc 'lqk'
    //   875: ldc_w 'evako'
    //   878: invokevirtual equals : (Ljava/lang/Object;)Z
    //   881: ifeq -> 1072
    //   884: bipush #16
    //   886: istore_0
    //   887: goto -> 1074
    //   890: ldc 'lqk'
    //   892: ldc 'lqk'
    //   894: invokevirtual equals : (Ljava/lang/Object;)Z
    //   897: ifeq -> 1072
    //   900: bipush #7
    //   902: istore_0
    //   903: goto -> 1074
    //   906: ldc 'lqk'
    //   908: ldc_w 'ffm'
    //   911: invokevirtual equals : (Ljava/lang/Object;)Z
    //   914: ifeq -> 1072
    //   917: iload_3
    //   918: istore_0
    //   919: goto -> 1074
    //   922: ldc 'lqk'
    //   924: ldc_w 'bom'
    //   927: invokevirtual equals : (Ljava/lang/Object;)Z
    //   930: ifeq -> 1072
    //   933: iconst_2
    //   934: istore_0
    //   935: goto -> 1074
    //   938: ldc 'lqk'
    //   940: ldc_w 'lightsblue'
    //   943: invokevirtual equals : (Ljava/lang/Object;)Z
    //   946: ifeq -> 1072
    //   949: bipush #9
    //   951: istore_0
    //   952: goto -> 1074
    //   955: ldc 'lqk'
    //   957: ldc_w 'zhenzhu'
    //   960: invokevirtual equals : (Ljava/lang/Object;)Z
    //   963: ifeq -> 1072
    //   966: bipush #10
    //   968: istore_0
    //   969: goto -> 1074
    //   972: ldc 'lqk'
    //   974: ldc_w 'kipcash'
    //   977: invokevirtual equals : (Ljava/lang/Object;)Z
    //   980: ifeq -> 1072
    //   983: iconst_1
    //   984: istore_0
    //   985: goto -> 1074
    //   988: ldc 'lqk'
    //   990: ldc_w 'newsmy'
    //   993: invokevirtual equals : (Ljava/lang/Object;)Z
    //   996: ifeq -> 1072
    //   999: bipush #8
    //   1001: istore_0
    //   1002: goto -> 1074
    //   1005: ldc 'lqk'
    //   1007: ldc_w 'linnuo'
    //   1010: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1013: ifeq -> 1072
    //   1016: bipush #15
    //   1018: istore_0
    //   1019: goto -> 1074
    //   1022: ldc 'lqk'
    //   1024: ldc_w 'kassen'
    //   1027: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1030: ifeq -> 1072
    //   1033: iconst_3
    //   1034: istore_0
    //   1035: goto -> 1074
    //   1038: ldc 'lqk'
    //   1040: ldc_w 'jindou'
    //   1043: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1046: ifeq -> 1072
    //   1049: bipush #6
    //   1051: istore_0
    //   1052: goto -> 1074
    //   1055: ldc 'lqk'
    //   1057: ldc_w 'xingpei'
    //   1060: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1063: ifeq -> 1072
    //   1066: bipush #14
    //   1068: istore_0
    //   1069: goto -> 1074
    //   1072: iconst_m1
    //   1073: istore_0
    //   1074: iload_0
    //   1075: tableswitch default -> 1156, 0 -> 1170, 1 -> 1170, 2 -> 1170, 3 -> 1170, 4 -> 1170, 5 -> 1170, 6 -> 1170, 7 -> 1170, 8 -> 1170, 9 -> 1170, 10 -> 1170, 11 -> 1170, 12 -> 1170, 13 -> 1170, 14 -> 1170, 15 -> 1170, 16 -> 1167
    //   1156: new java/lang/IllegalStateException
    //   1159: dup
    //   1160: ldc_w '未定义的 FLAVOR_brand'
    //   1163: invokespecial <init> : (Ljava/lang/String;)V
    //   1166: athrow
    //   1167: bipush #6
    //   1169: ireturn
    //   1170: iconst_3
    //   1171: istore_1
    //   1172: iload_1
    //   1173: ireturn }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\hardware\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */