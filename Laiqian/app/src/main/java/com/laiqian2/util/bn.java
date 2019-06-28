package com.laiqian.util;

import android.os.Environment;
import android.os.StatFs;
import com.google.a.a.a.a.a.a;

public class bn {
  static String aNf;
  
  static String dGl = "测试记录";
  
  static  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    stringBuilder.append("/crash/");
    aNf = stringBuilder.toString();
  }
  
  public static double py(String paramString) {
    double d2 = 0.0D;
    double d1 = d2;
    try {
      StatFs statFs = new StatFs(paramString);
      d1 = d2;
      long l = statFs.getBlockSize();
      d1 = d2;
      d2 = (statFs.getAvailableBlocks() * l / 1024L);
      d1 = d2;
      StringBuilder stringBuilder = new StringBuilder();
      d1 = d2;
      stringBuilder.append(d2);
      d1 = d2;
      stringBuilder.append("K");
      d1 = d2;
      bb.e("存储器剩余大小", stringBuilder.toString());
      return d2;
    } catch (Exception paramString) {
      a.e(paramString);
      return d1;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */