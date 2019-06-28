package com.laiqian.util;

import android.os.Environment;
import android.util.Log;
import com.laiqian.pos.hardware.RootUrlParameter;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bb {
  private static long dGe;
  
  static  {
  
  }
  
  public static void an(Object paramObject) { e("_LQK", paramObject); }
  
  public static void ao(Object paramObject) { f("_LQK", paramObject); }
  
  public static void bs(String paramString1, String paramString2) {
    if (!RootUrlParameter.bDebug)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("\n");
    paramString1 = stringBuilder.toString();
    try {
      File file = new File(paramString2);
      if (!file.exists()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Create the file:");
        stringBuilder1.append(paramString2);
        f("TestFile", stringBuilder1.toString());
        if (!file.createNewFile())
          e("TestFile", "createNewFile failed."); 
      } 
      RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
      randomAccessFile.seek(file.length());
      randomAccessFile.write(paramString1.getBytes());
      randomAccessFile.close();
      return;
    } catch (Exception paramString1) {
      e("TestFile", "Error on write File.");
      return;
    } 
  }
  
  public static void dE(long paramLong) { dGe = paramLong; }
  
  public static void e(String paramString, Object paramObject) {
    if (RootUrlParameter.bDebug) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("[Logs.java]");
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramObject);
      stringBuilder2.append("      {");
      stringBuilder2.append(paramString);
      stringBuilder2.append("}. The time is: ");
      stringBuilder2.append((new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss")).format(new Date()));
      Log.e(str, stringBuilder2.toString());
    } 
  }
  
  public static void f(String paramString, Object paramObject) {
    if (RootUrlParameter.bDebug) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("[Logs.java]");
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramObject);
      stringBuilder2.append("      {");
      stringBuilder2.append(paramString);
      stringBuilder2.append("}. The time is: ");
      stringBuilder2.append((new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss")).format(new Date()));
      Log.d(str, stringBuilder2.toString());
    } 
  }
  
  public static void fU(String paramString) { Log.e("_Sync", paramString); }
  
  public static void j(String paramString, Object paramObject) {
    long l1 = System.currentTimeMillis();
    long l2 = dGe;
    dGe = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramObject);
    stringBuilder.append(". consumed miliseconds is: ");
    stringBuilder.append(l1 - l2);
    e(paramString, stringBuilder.toString());
  }
  
  public static void rM(String paramString) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    stringBuilder1.append("/logs.txt");
    String str1 = stringBuilder1.toString();
    Date date = new Date();
    String str2 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append(":");
    stringBuilder2.append(paramString);
    bs(stringBuilder2.toString(), str1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */