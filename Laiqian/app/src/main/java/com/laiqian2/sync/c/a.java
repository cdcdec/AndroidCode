package com.laiqian.sync.c;

import com.laiqian.basic.LQKVersion;
import com.laiqian.pos.industry.a;

public class a {
  public static boolean afi = false;
  
  public static String bJz = "apk_version";
  
  public static String bUA = "IS_BYTE_ENCRYPTION_SUPPORT";
  
  public static String bUC = "bIsOssDownloadSupported";
  
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
  
  public static String bVt = "laiqian_encrypt";
  
  public static String bVu = "debug";
  
  public static String ckJ;
  
  public static String crk;
  
  public static String crl;
  
  public static String crm;
  
  public static String dpA;
  
  public static String dpB = "t_string,t_productdoc,t_accountdoc,t_bpartner_chargedoc,t_bpartner_pointsdoc,t_shift,t_order,t_charge_item_doc,t_productdoc_header,t_productdoc_ext1,t_temp_productdoc,t_temp_productdoc_status_history";
  
  public static String dpC = "t_product,t_product_ext1,t_string";
  
  public static String dpD = "t_bpartner";
  
  public static String dpE = "SERVICE_RETURN";
  
  public static String dpF = "SERVICE_RETURN_VALUE";
  
  public static String dpG = "industry";
  
  public static String dpH;
  
  public static boolean dpm = true;
  
  public static String dpn = "t_account,t_product,t_role,t_shop,t_string,t_user,t_bpartner,t_order,t_shift,t_food_table,t_window_access,t_tax,t_tax_customer,t_tax_product,t_product_ext1";
  
  public static String dpo = "t_account,t_role,t_shop,t_string,t_user,t_order,t_shift,t_food_table,t_window_access,t_tax,t_tax_customer,t_tax_product";
  
  public static String dpp = "t_productdoc,t_accountdoc,t_userchargedoc,t_charge_item_doc,t_bpartner_chargedoc,t_bpartner_pointsdoc";
  
  public static String dpq = "t_user,t_role,t_window_access,t_food_table";
  
  public static String dpr = "t_bpartner";
  
  public static String dps = "t_bpartner_chargedoc";
  
  public static String dpt = "t_productdoc,t_accountdoc,t_bpartner_chargedoc,t_bpartner_pointsdoc,t_charge_item_doc";
  
  public static String dpu = "t_string,t_shift,t_order";
  
  public static String dpv = "t_string";
  
  public static String dpw = "t_productdoc";
  
  public static String dpx = "t_string,t_productdoc";
  
  public static String dpy;
  
  public static String dpz;
  
  public static String url;
  
  static  {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("t_account,t_product,t_role,t_shop,t_string,t_user,t_bpartner,t_order,t_productdoc,t_accountdoc,t_userchargedoc,t_charge_item_doc,t_bpartner_chargedoc,t_shift,t_bpartner_pointsdoc,t_food_table,t_window_access,t_tax,t_tax_customer,t_tax_product,t_product_ext1,t_productdoc_header,t_productdoc_ext1t,t_temp_productdoc,t_temp_productdoc_status_history");
    if (LQKVersion.zl()) {
      str = ",t_promotion_with_condition,t_promotion_product";
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    dpy = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("t_food_table,t_account,t_product,t_role,t_shop,t_string,t_user,t_bpartner,t_order,t_tax,t_tax_customer,t_tax_product,t_product_ext1");
    if (LQKVersion.zl()) {
      str = ",t_promotion_with_condition,t_promotion_product";
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    dpz = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("t_food_table,t_account,t_role,t_shop,t_string,t_user,t_order,t_tax,t_tax_customer,t_tax_product");
    if (LQKVersion.zl()) {
      str = ",t_promotion_with_condition,t_promotion_product";
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    dpA = stringBuilder.toString();
    ckJ = a.ckJ;
    url = a.url;
    crl = a.crl;
    crk = a.crk;
    dpH = a.crj;
    crm = a.crm;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */