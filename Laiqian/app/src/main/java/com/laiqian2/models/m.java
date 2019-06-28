package com.laiqian.models;

import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.format.Time;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.util.by;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class m {
  @Nullable
  public static String II() { return a.zR().Aw() ? UV() : UW(); }
  
  @Nullable
  private static File UU() {
    try {
      File file = Environment.getExternalStorageDirectory();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("lqk/");
      stringBuilder.append(RootApplication.getLaiqianPreferenceManager().Tx());
      stringBuilder.append("/BillNumber");
      file = new File(file, stringBuilder.toString());
      return (!file.exists() && !file.mkdirs()) ? null : file;
    } catch (Throwable throwable) {
      a.e(throwable);
      return null;
    } 
  }
  
  public static String UV() {
    String str;
    null = UY();
    if (null == null) {
      str = "";
    } else {
      str = null;
      if (null.length() > 0) {
        null = new StringBuilder();
        null.append(null);
        null.append("-");
        str = null.toString();
      } 
    } 
    int i = ek(true);
    Time time = new Time();
    time.set(System.currentTimeMillis());
    if (a.AZ().BL()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append(time.format("%m%d"));
      stringBuilder1.append(ba(i, 3));
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("000");
    stringBuilder.append(ba(i, 3));
    return stringBuilder.toString();
  }
  
  private static String UW() {
    String str1;
    String str2 = UY();
    if (str2 == null) {
      str1 = "";
    } else {
      str1 = str2;
      if (str2.length() > 0) {
        null = new StringBuilder();
        null.append(str2);
        null.append("-");
        str1 = null.toString();
      } 
    } 
    int i = ek(true);
    if (a.AZ().BL()) {
      Time time = new Time();
      time.set(RootApplication.getLaiqianPreferenceManager().atQ());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append(time.format("%d%m"));
      stringBuilder1.append("-");
      stringBuilder1.append(ba(i, 3));
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append(ba(i, 6));
    return stringBuilder.toString();
  }
  
  public static boolean UX() {
    File file = UU();
    return (file == null) ? false : (new File(file, "number")).delete();
  }
  
  @Nullable
  public static String UY() {
    file = UU();
    if (file == null)
      return null; 
    FileReader fileReader = new File(file, "TerminalNo");
    if (!fileReader.exists())
      return null; 
    try {
      char[] arrayOfChar = new char[(int)fileReader.length()];
      fileReader = new FileReader(fileReader);
      if (fileReader.read(arrayOfChar) != -1) {
        String str = new String(arrayOfChar);
        fileReader.close();
        return str;
      } 
    } catch (IOException file) {
      a.e(file);
      return null;
    } 
    file = null;
    fileReader.close();
    return file;
  }
  
  private static String ba(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    while (stringBuilder.length() < paramInt2)
      stringBuilder.insert(0, '0'); 
    return stringBuilder.toString();
  }
  
  public static int ek(boolean paramBoolean) {
    Integer integer = UU();
    if (integer == null)
      return 1; 
    File file = new File(integer, "number");
    if (file.exists()) {
      try {
        char[] arrayOfChar = new char[(int)file.length()];
        FileReader fileReader = new FileReader(file);
        if (fileReader.read(arrayOfChar) != -1) {
          Integer integer2 = Integer.valueOf(by.parseInt(new String(arrayOfChar)));
          Integer integer1 = integer2;
          if (integer2.intValue() < 1)
            integer1 = Integer.valueOf(1); 
        } else {
          Integer integer1 = Integer.valueOf(1);
        } 
        fileReader.close();
      } catch (IOException null) {
        a.e(integer);
        Integer integer1 = Integer.valueOf(1);
      } 
    } else {
      integer = Integer.valueOf(1);
    } 
    if (paramBoolean)
      try {
        FileWriter fileWriter = new FileWriter(file);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(integer.intValue() + 1);
        stringBuilder.append("");
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
      } catch (IOException iOException) {
        a.e(iOException);
      }  
    return integer.intValue();
  }
  
  public static boolean ge(int paramInt) {
    file = UU();
    if (file == null)
      return false; 
    file = new File(file, "number");
    try {
      FileWriter fileWriter = new FileWriter(file);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      fileWriter.write(stringBuilder.toString());
      fileWriter.close();
      return true;
    } catch (IOException file) {
      a.e(file);
      return false;
    } 
  }
  
  public static boolean hs(String paramString) {
    File file = UU();
    if (file == null)
      return false; 
    file = new File(file, "TerminalNo");
    try {
      FileWriter fileWriter = new FileWriter(file);
      fileWriter.write(paramString);
      fileWriter.close();
      return true;
    } catch (IOException paramString) {
      a.e(paramString);
      return false;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */