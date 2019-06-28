package com.laiqian.pos.help;

import com.laiqian.basic.LQKVersion;
import com.laiqian.c.a;
import com.laiqian.pos.hardware.q;

public abstract class e {
  public static String ckP = q.ckN;
  
  public static String cmS = "UTF-8";
  
  public static String cmT;
  
  public static String cmU;
  
  public static String cmV;
  
  public static String cmW;
  
  public static String cmX;
  
  public static String cmY;
  
  public static String cmZ;
  
  public static String cmt;
  
  public static String cmu;
  
  public static String cmv;
  
  public static String cna;
  
  public static String cnb;
  
  public static String cnc;
  
  public static String cnd;
  
  static  {
    String str = new StringBuilder();
    str.append(ckP);
    str.append("/info/check");
    cmT = str.toString();
    str = new StringBuilder();
    str.append(ckP);
    str.append("/info/index");
    cmU = str.toString();
    str = new StringBuilder();
    str.append(ckP);
    str.append("/message/posttime");
    cmV = str.toString();
    str = new StringBuilder();
    str.append(ckP);
    str.append("/message/detail?id=1");
    cmW = str.toString();
    str = new StringBuilder();
    str.append(ckP);
    str.append("/message/detail?id=2");
    cmX = str.toString();
    str = new StringBuilder();
    str.append(ckP);
    str.append("/message/detail?id=3");
    cmY = str.toString();
    str = new StringBuilder();
    str.append(ckP);
    str.append("/message/detail?id=4");
    cmZ = str.toString();
    str = new StringBuilder();
    str.append(ckP);
    str.append("/message/detail?id=5");
    cna = str.toString();
    str = new StringBuilder();
    str.append(ckP);
    str.append("/message/introduction?id=2");
    cmt = str.toString();
    str = new StringBuilder();
    str.append(ckP);
    str.append("/message/introduction?id=3");
    cmu = str.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(ckP);
    stringBuilder2.append("/message/introduction?id=");
    if (a.zR().Ag()) {
      String str1 = "5";
    } else if (a.zR().Ah()) {
      String str1 = "6";
    } else {
      str = "4";
    } 
    stringBuilder2.append(str);
    cmv = stringBuilder2.toString();
    str = LQKVersion.zi();
    byte b = -1;
    int i = str.hashCode();
    if (i != -1159930917) {
      if (i != -1102662825) {
        if (i != -319595696) {
          if (i == -190625801 && str.equals("lightsblue"))
            b = 1; 
        } else if (str.equals("zhenzhu")) {
          b = 3;
        } 
      } else if (str.equals("linnuo")) {
        b = 2;
      } 
    } else if (str.equals("jindou")) {
      b = 0;
    } 
    switch (b) {
      default:
        b = 4;
        break;
      case 3:
        b = 8;
        break;
      case 2:
        b = 7;
        break;
      case 1:
        b = 6;
        break;
      case 0:
        b = 5;
        break;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(ckP);
    stringBuilder1.append("/message/introduction?id=");
    stringBuilder1.append(b);
    cmv = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(ckP);
    stringBuilder1.append("/message/detail?id=17&type=order_introduction");
    cnb = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(ckP);
    stringBuilder1.append("/message/introduction?type=CanYin&id=11");
    cnc = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(ckP);
    stringBuilder1.append("/message/introduction?type=order_introduction&id=19");
    cnd = stringBuilder1.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\help\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */