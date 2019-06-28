package com.laiqian.pos;

import android.content.Context;
import com.laiqian.util.av;
import com.laiqian.util.bk;
import java.io.File;

public class dw {
  public static String aR(Context paramContext) {
    av av = new av(paramContext);
    String str2 = av.Tx();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/");
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append("/shopQRcode_");
    stringBuilder.append(str2);
    String str1 = stringBuilder.toString();
    av.close();
    return str1;
  }
  
  public static boolean aS(Context paramContext) {
    av av = new av(paramContext);
    String str2 = av.Tx();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/");
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append("/shopQRcode_");
    stringBuilder.append(str2);
    String str1 = stringBuilder.toString();
    av.close();
    File file = new File(str1);
    return (file.exists() && file.delete());
  }
  
  public static String aT(Context paramContext) {
    av av = new av(paramContext);
    String str2 = av.Tx();
    File file = paramContext.getExternalFilesDir(null);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file.getAbsolutePath());
    stringBuilder.append(File.separator);
    stringBuilder.append("PrivateshopQRcode_");
    stringBuilder.append(str2);
    String str1 = stringBuilder.toString();
    av.close();
    return str1;
  }
  
  public static boolean h(Context paramContext, String paramString1, String paramString2) { return bk.a(paramString1, paramString2, 360, 360); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */