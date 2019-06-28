package com.laiqian.print.model.type.usb.b;

import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class e {
  public static String A(File paramFile) {
    if (paramFile == null)
      return ""; 
    if (!paramFile.exists())
      return ""; 
    if (paramFile.isDirectory())
      return ""; 
    StringBuffer stringBuffer = new StringBuffer('Ϩ');
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(paramFile));
      char[] arrayOfChar = new char[1024];
      while (true) {
        int i = bufferedReader.read(arrayOfChar);
        if (i != -1) {
          stringBuffer.append(String.valueOf(arrayOfChar, 0, i));
          arrayOfChar = new char[1024];
          continue;
        } 
        break;
      } 
      bufferedReader.close();
      return stringBuffer.toString().trim();
    } catch (FileNotFoundException paramFile) {
      a.e(paramFile);
      return "";
    } catch (IOException paramFile) {
      a.e(paramFile);
      return "";
    } 
  }
  
  public static int i(String paramString, int paramInt1, int paramInt2) {
    try {
      return Integer.parseInt(paramString, paramInt2);
    } catch (NumberFormatException paramString) {
      return paramInt1;
    } 
  }
  
  public static String lD(String paramString) { return TextUtils.isEmpty(paramString) ? "" : A(new File(paramString)); }
  
  public static int parseInt(String paramString) { return i(paramString, 0, 10); }
  
  public static int parseInt(String paramString, int paramInt) { return i(paramString, 0, paramInt); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */