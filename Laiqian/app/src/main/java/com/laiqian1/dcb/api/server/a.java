package com.laiqian.dcb.api.server;

import com.laiqian.dcb.api.b.c;
import java.io.File;

public class a {
  private static boolean aOL = true;
  
  private static boolean aOM = true;
  
  private static long aON = 17000L;
  
  private static String aPu = "com.laiqian.ordertool.ServerGet";
  
  private static String aPv;
  
  private static String aPw;
  
  private static boolean bDebug = false;
  
  static  {
  
  }
  
  public static String DR() {
    if (aPv == null) {
      null = new StringBuilder();
      null.append(c.yX());
      null.append(File.separator);
      null.append("laiqian");
      null.append(File.separator);
      null.append("download");
      null.append(File.separator);
      aPv = null.toString();
      File file = new File(aPv);
      if (!file.exists())
        file.mkdirs(); 
    } 
    return aPv;
  }
  
  public static String DS() {
    if (aPw == null) {
      null = new StringBuilder();
      null.append(c.yX());
      null.append(File.separator);
      null.append("laiqian");
      null.append(File.separator);
      null.append("Temp");
      null.append(File.separator);
      aPw = null.toString();
      File file = new File(aPw);
      if (!file.exists())
        file.mkdirs(); 
    } 
    return aPw;
  }
  
  public boolean DT() { return aOL; }
  
  public boolean Ds() { return aOM; }
  
  public String Dt() { return aPu; }
  
  public void cC(String paramString) { aPu = paramString; }
  
  public void cr(boolean paramBoolean) { aOM = paramBoolean; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\server\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */