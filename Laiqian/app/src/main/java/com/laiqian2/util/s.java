package com.laiqian.util;

import android.content.Context;
import android.os.Environment;
import com.google.a.a.a.a.a.a;
import java.io.File;
import java.math.BigDecimal;

public class s {
  private static boolean H(File paramFile) {
    if (paramFile != null && paramFile.isDirectory()) {
      String[] arrayOfString = paramFile.list();
      for (byte b = 0; b < arrayOfString.length; b++) {
        if (!H(new File(paramFile, arrayOfString[b])))
          return false; 
      } 
    } 
    return paramFile.delete();
  }
  
  public static long I(File paramFile) throws Exception {
    long l3;
    long l1 = 0L;
    long l2 = l1;
    try {
      File[] arrayOfFile = paramFile.listFiles();
      byte b = 0;
      while (true) {
        l2 = l1;
        l3 = l1;
        if (b < arrayOfFile.length) {
          l2 = l1;
          if (arrayOfFile[b].isDirectory()) {
            l2 = l1;
            l1 += I(arrayOfFile[b]);
          } else {
            l2 = l1;
            l3 = arrayOfFile[b].length();
            l1 += l3;
          } 
          b++;
          continue;
        } 
        break;
      } 
    } catch (Exception paramFile) {
      a.e(paramFile);
      l3 = l2;
    } 
    return l3;
  }
  
  public static String bQ(Context paramContext) throws Exception {
    long l2 = I(paramContext.getCacheDir());
    long l1 = l2;
    if (Environment.getExternalStorageState().equals("mounted"))
      l1 = l2 + I(paramContext.getExternalCacheDir()); 
    return bh(l1);
  }
  
  public static void bR(Context paramContext) {
    H(paramContext.getCacheDir());
    if (Environment.getExternalStorageState().equals("mounted"))
      H(paramContext.getExternalCacheDir()); 
  }
  
  private static String bh(double paramDouble) {
    double d = paramDouble / 1024.0D;
    if (d < 1.0D)
      return "0KB"; 
    paramDouble = d / 1024.0D;
    if (paramDouble < 1.0D) {
      BigDecimal bigDecimal1 = new BigDecimal(Double.toString(d));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(bigDecimal1.setScale(2, 4).toPlainString());
      stringBuilder1.append("KB");
      return stringBuilder1.toString();
    } 
    d = paramDouble / 1024.0D;
    if (d < 1.0D) {
      BigDecimal bigDecimal1 = new BigDecimal(Double.toString(paramDouble));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(bigDecimal1.setScale(2, 4).toPlainString());
      stringBuilder1.append("MB");
      return stringBuilder1.toString();
    } 
    paramDouble = d / 1024.0D;
    if (paramDouble < 1.0D) {
      BigDecimal bigDecimal1 = new BigDecimal(Double.toString(d));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(bigDecimal1.setScale(2, 4).toPlainString());
      stringBuilder1.append("GB");
      return stringBuilder1.toString();
    } 
    BigDecimal bigDecimal = new BigDecimal(paramDouble);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bigDecimal.setScale(2, 4).toPlainString());
    stringBuilder.append("TB");
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */