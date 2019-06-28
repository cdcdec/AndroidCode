package com.laiqian.dcb.api.b;

import android.os.Environment;
import com.google.a.a.a.a.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class c {
  public static boolean B(String paramString1, String paramString2) {
    try {
      if ((new File(paramString1)).exists())
        return a(new FileInputStream(paramString1), paramString2); 
    } catch (Exception paramString1) {
      a.e(paramString1);
    } 
    return false;
  }
  
  public static boolean a(File paramFile, boolean paramBoolean) {
    boolean bool2 = paramFile.isDirectory();
    boolean bool1 = true;
    if (bool2) {
      String[] arrayOfString = paramFile.list();
      for (byte b = 0; b < arrayOfString.length; b++) {
        if (!a(new File(paramFile, arrayOfString[b]), true))
          return false; 
      } 
    } 
    if (paramBoolean)
      bool1 = paramFile.delete(); 
    return bool1;
  }
  
  public static boolean a(InputStream paramInputStream, String paramString) {
    if (paramInputStream != null)
      try {
        FileOutputStream fileOutputStream = new FileOutputStream(paramString);
        byte[] arrayOfByte = new byte[1444];
        while (true) {
          int i = paramInputStream.read(arrayOfByte);
          if (i != -1) {
            fileOutputStream.write(arrayOfByte, 0, i);
            continue;
          } 
          break;
        } 
        fileOutputStream.close();
        paramInputStream.close();
      } catch (Exception paramInputStream) {
        a.e(paramInputStream);
        return false;
      }  
    return true;
  }
  
  public static boolean cE(String paramString) { return a(new File(paramString), true); }
  
  public static String yX() {
    File file = Environment.getExternalStorageDirectory();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file.getParent());
    stringBuilder.append(File.separator);
    stringBuilder.append(file.getName());
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */