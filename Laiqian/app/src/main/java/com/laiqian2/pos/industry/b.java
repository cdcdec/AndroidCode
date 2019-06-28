package com.laiqian.pos.industry;

import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.hardware.q;

public class b extends a {
  public static final String ckJ = q.ckJ;
  
  public static final String cqB;
  
  public static final String cqD;
  
  public static final String cqE;
  
  public static final String cqF;
  
  public static final String cqG;
  
  public static final String cqH;
  
  public static final String cqJ;
  
  public static final String cqL;
  
  public static final String cqM;
  
  public static final String cqN;
  
  public static final String cqP;
  
  public static final String cqQ;
  
  public static final String crA;
  
  public static final String crB;
  
  public static final String crC;
  
  public static final String crD;
  
  public static final String crE;
  
  public static final String crF;
  
  public static final String crG;
  
  public static final String crH;
  
  public static final String crI;
  
  public static final String crJ;
  
  public static final String crK;
  
  public static final String crL;
  
  public static final String crM;
  
  public static final String crN;
  
  public static final String crO;
  
  public static final String crP;
  
  public static final String crQ;
  
  public static final String crR;
  
  public static final String crS;
  
  public static final String crT;
  
  public static final String crh;
  
  public static final String cri;
  
  public static final String crj;
  
  public static final String crk;
  
  public static String crl;
  
  public static String crm;
  
  public static final String crs;
  
  public static final String crt;
  
  public static final String cru;
  
  public static final String crv;
  
  public static final String crw;
  
  public static final String crx;
  
  public static String cry;
  
  public static final String crz;
  
  public static String url;
  
  static  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://");
    stringBuilder.append(ckJ);
    stringBuilder.append("/serverCommandOperator.php");
    url = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("http://");
    stringBuilder.append(ckJ);
    stringBuilder.append("/test_serverCommandOperator.php");
    crs = stringBuilder.toString();
    crl = a.crl;
    crk = a.crk;
    crj = a.crj;
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckY);
    stringBuilder.append("/shop/update");
    crt = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckY);
    stringBuilder.append("/shop/synctimeupdate");
    cru = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckY);
    stringBuilder.append("/shop/isours");
    crv = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckC);
    stringBuilder.append("/transaction/delete");
    crw = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckY);
    stringBuilder.append("/shop/index");
    crx = stringBuilder.toString();
    crm = a.crm;
    cry = url;
    cri = a.cri;
    crh = a.crh;
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("servicetest/precreate");
    cqD = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("/servicetest/pay");
    cqE = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("/servicetest/query");
    cqF = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("/servicetest/cancel");
    cqG = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("/servicetest/refund");
    cqH = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("servicetest/querybarcode");
    cqJ = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("/wxservice/precreate");
    cqL = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("/wxservice/barcodepay");
    cqM = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("/wxservice/query");
    cqN = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("wxservice/reverse");
    cqP = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("wxservice/refund");
    cqQ = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckS);
    stringBuilder.append("wxservice/querybarcode");
    crz = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("takeaway");
    crA = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("setweixin/index");
    crB = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("setweixin/settings");
    crC = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckM);
    stringBuilder.append("shop/gettingpay");
    crD = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckM);
    stringBuilder.append("shop/settingpay");
    crE = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckM);
    stringBuilder.append("shop/gettingshop");
    crF = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckM);
    stringBuilder.append("shop/settingshop");
    crG = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckM);
    stringBuilder.append("token/generate");
    cqB = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("shop/getshopinfo");
    crH = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("shop/updateshopinfo");
    crI = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("product/update");
    crJ = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("wechat/qrcode");
    crK = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.ckW);
    stringBuilder.append("wechat");
    crL = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckY);
    stringBuilder.append("/shop/mine");
    crM = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("wechat/official-account");
    crN = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("wechat/save-official-account");
    crO = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckY);
    stringBuilder.append("/interface/check-patch");
    crP = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckY);
    stringBuilder.append("/interface/check-systempack");
    crQ = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("phone/check-product");
    crR = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("phone/confirm");
    crS = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(q.ckV);
    stringBuilder.append("phone/complete");
    crT = stringBuilder.toString();
    a.crg = "30050";
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */