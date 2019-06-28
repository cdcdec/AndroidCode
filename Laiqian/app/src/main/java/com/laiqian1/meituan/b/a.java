package com.laiqian.meituan.b;

import com.laiqian.pos.hardware.RootUrlParameter;

public class a {
  public static String brA;
  
  public static String brB;
  
  public static String brC;
  
  public static String brD;
  
  public static String brE;
  
  public static String brF;
  
  public static String brG;
  
  public static String brH;
  
  public static String brI;
  
  public static String brJ;
  
  public static String brK;
  
  public static String brL;
  
  public static String brM;
  
  public static String brN;
  
  public static String brO;
  
  public static String bry = "https://api-open-cater.meituan.com/";
  
  public static String brz = "https://open-erp.meituan.com/";
  
  static  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bry);
    stringBuilder.append("waimai/poi/queryPoiInfo");
    brA = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(bry);
    stringBuilder.append("waimai/poi/close");
    brB = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(bry);
    stringBuilder.append("waimai/poi/open");
    brC = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(bry);
    stringBuilder.append("waimai/poi/updateOpenTime");
    brD = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(brz);
    stringBuilder.append("checkcoupon");
    brE = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(brz);
    stringBuilder.append("checkpigeon");
    brF = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(brz);
    stringBuilder.append("coupon");
    brG = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(brz);
    stringBuilder.append("pigeon");
    brH = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(bry);
    stringBuilder.append("tuangou/coupon/queryById");
    brI = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(bry);
    stringBuilder.append("tuangou/coupon/cancel");
    brJ = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(bry);
    stringBuilder.append("tuangou/coupon/prepare");
    brK = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(bry);
    stringBuilder.append("tuangou/coupon/consume");
    brL = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(bry);
    stringBuilder.append("tuangou/coupon/queryListByDate");
    brM = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.ckV);
    stringBuilder.append("meituan/tuan-callback");
    brN = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.ckV);
    stringBuilder.append("meituan/takeaway-callback");
    brO = stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */