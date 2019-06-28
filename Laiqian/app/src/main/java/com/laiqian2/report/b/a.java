package com.laiqian.report.b;

import java.util.HashMap;

public class a {
  static HashMap<Long, String> cZh = new HashMap();
  
  static  {
    cZh.put(Long.valueOf(5L), "Pone Order");
    cZh.put(Long.valueOf(8L), "Car Order");
    cZh.put(Long.valueOf(0L), "Table");
    cZh.put(Long.valueOf(9L), "Other Order");
    cZh.put(Long.valueOf(86004L), "Online Order");
  }
  
  public static String dg(long paramLong) { return cZh.containsKey(Long.valueOf(paramLong)) ? (String)cZh.get(Long.valueOf(paramLong)) : "All"; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */