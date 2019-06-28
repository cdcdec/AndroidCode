package com.laiqian.util;

import c.n;
import com.google.a.a.a.a.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class cq {
  private static void a(String paramString1, String paramString2, ZipOutputStream paramZipOutputStream) throws Exception {
    FileInputStream fileInputStream;
    byte[] arrayOfByte;
    if (paramZipOutputStream == null)
      return; 
    null = new StringBuilder();
    null.append(paramString1);
    null.append(paramString2);
    null = new File(null.toString());
    boolean bool = null.isFile();
    byte b2 = 0;
    if (bool) {
      null = new ZipEntry(paramString2);
      fileInputStream = new FileInputStream(null);
      paramZipOutputStream.putNextEntry(null);
      arrayOfByte = new byte[4096];
      while (true) {
        int i = fileInputStream.read(arrayOfByte);
        if (i != -1) {
          paramZipOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        break;
      } 
      paramZipOutputStream.closeEntry();
      return;
    } 
    String[] arrayOfString = null.list();
    byte b1 = b2;
    if (arrayOfString.length <= 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(fileInputStream);
      stringBuilder.append(File.separator);
      paramZipOutputStream.putNextEntry(new ZipEntry(stringBuilder.toString()));
      paramZipOutputStream.closeEntry();
      b1 = b2;
    } 
    while (b1 < arrayOfString.length) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(fileInputStream);
      stringBuilder.append(File.separator);
      stringBuilder.append(arrayOfString[b1]);
      a(arrayOfByte, stringBuilder.toString(), paramZipOutputStream);
      b1++;
    } 
  }
  
  public static boolean a(String paramString1, String paramString2, InputStream paramInputStream) {
    try {
      ZipInputStream zipInputStream = new ZipInputStream(paramInputStream);
      while (true) {
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        if (zipEntry != null) {
          String str = zipEntry.getName();
          if (zipEntry.isDirectory()) {
            str = str.substring(0, str.length() - 1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(paramString2);
            stringBuilder.append(File.separator);
            stringBuilder.append(str);
            (new File(stringBuilder.toString())).mkdirs();
            continue;
          } 
          null = new StringBuilder();
          null.append(paramString2);
          null.append(File.separator);
          null.append(str);
          File file1 = new File(null.toString());
          File file2 = file1.getParentFile();
          if (!file2.exists())
            file2.mkdirs(); 
          n.c(n.v(zipInputStream)).b(n.U(file1));
          continue;
        } 
        break;
      } 
      zipInputStream.close();
      return true;
    } catch (Exception paramString1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("zip error->");
      stringBuilder.append(paramString1.toString());
      bb.e("zip error", stringBuilder.toString());
      return false;
    } 
  }
  
  public static boolean bx(String paramString1, String paramString2) {
    try {
      return a(paramString1, paramString2, new FileInputStream(paramString1));
    } catch (FileNotFoundException paramString1) {
      a.e(paramString1);
      return false;
    } 
  }
  
  public static void by(String paramString1, String paramString2) throws Exception {
    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(paramString2));
    File file = new File(paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file.getParent());
    stringBuilder.append(File.separator);
    a(stringBuilder.toString(), file.getName(), zipOutputStream);
    zipOutputStream.finish();
    zipOutputStream.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */