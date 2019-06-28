package com.laiqian.db.multidatabase.b;

import com.laiqian.basic.RootApplication;
import java.util.Calendar;

public class a {
  public static final String aOB;
  
  public static int aOC = 2011;
  
  public static long aOD = 1325347200000L;
  
  public static final String aOz;
  
  static  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/");
    stringBuilder.append(RootApplication.zv().getPackageName());
    stringBuilder.append("/laiqiandbs/");
    aOz = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(aOz);
    stringBuilder.append(YEAR);
    aOA = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/");
    stringBuilder.append(RootApplication.zv().getPackageName());
    stringBuilder.append("/laiqian.db");
    aOB = stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\multidatabase\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */