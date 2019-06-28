package com.laiqian.network;

import com.google.a.a.a.a.a.a;
import com.laiqian.f.c;
import com.laiqian.pos.industry.a;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class t {
  public static boolean afi = false;
  
  public static int bJy = 12345;
  
  public static String bJz = "apk_version";
  
  public static String bKa = "laiqian_upload.db";
  
  public static String bKb = "";
  
  public static String bKc = "";
  
  public static String bUA = "IS_BYTE_ENCRYPTION_SUPPORT";
  
  public static String bUC = "bIsOssDownloadSupported";
  
  public static String bUD = "SERVICE_TYPE";
  
  public static String bUE = "nShopID";
  
  public static String bUF = "nUserID";
  
  public static String bUG = "sUserPhone";
  
  public static String bUH = "NSHOPID";
  
  public static String bUI = "POST_RICH_RESULT";
  
  public static String bUJ = "nDateTime";
  
  public static String bUK = "nUpdateFlag";
  
  public static String bUL = "sIsActive";
  
  public static String bUM = "nIsUpdated";
  
  public static String bUN = "nOperationTime";
  
  public static String bUO = "sPlatform";
  
  public static String bUP = "sFeedbackType";
  
  public static String bUQ = "nIndustry";
  
  public static String bUR = "fVersion";
  
  public static String bUS = "sUpgradeDescOfFeedback";
  
  public static String bUT = "sFeedbackContent";
  
  public static String bUU = "sHardwareDescInJson";
  
  public static String bUV = "sAndroidVersion";
  
  public static String bUW = "sEquipmentName";
  
  public static String bUX = "sLinuxKernelVersion";
  
  public static String bUY = "SPASSWORD";
  
  public static String bUZ = "SFILENAME";
  
  public static String bUx = "CHECK_FLAG";
  
  public static String bUy = "NUSERID";
  
  public static String bUz = "SUSERPHONE";
  
  public static String bVa = "FROMDATE";
  
  public static String bVb = "TODATE";
  
  public static String bVc = "TABLE_NAMES";
  
  public static String bVd = "SUSERNAME";
  
  public static String bVe = "SUSERMAIL";
  
  public static String bVf = "SCHANNELID";
  
  public static String bVg = "sLanguage";
  
  public static String bVh = "NDBTEMPLATEID";
  
  public static String bVi = "TABLE_LIST";
  
  public static String bVj = "YES";
  
  public static String bVk = ".lq";
  
  public static String bVl = "upload";
  
  public static String bVm = "SQL_INDUSTRY_TYPE";
  
  public static String bVn = "MACHINE_MODEL";
  
  public static String bVo = "T_BPARTNER";
  
  public static String bVp = "T_PRODUCT";
  
  public static final String[] bVq = { "t_role", "t_string", "t_window_access", "t_user" };
  
  public static String bVr = "SHARE_MESSAGE";
  
  public static String bVs = "SCONDITION";
  
  public static String bVt = "laiqian_encrypt";
  
  public static String bVu = "debug";
  
  public static String bVv = "laiqian.apk";
  
  public static String bVw = "download";
  
  public static String url = a.url;
  
  public static String iF() {
    date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(simpleDateFormat.format(date));
      stringBuilder.append("laiqian");
      return c.cI(stringBuilder.toString());
    } catch (NoSuchAlgorithmException date) {
      a.e(date);
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */