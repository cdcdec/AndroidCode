package com.laiqian.util;

import android.content.Context;

public class aa extends am {
  private String bVw = "lq";
  
  private String dFg = "";
  
  private String dFh = "laiqian.db";
  
  private String dFi = "laiqian_backup.db";
  
  private Context mContext;
  
  public aa(Context paramContext) {
    this.mContext = paramContext;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/");
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append("/");
    this.dFg = stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */