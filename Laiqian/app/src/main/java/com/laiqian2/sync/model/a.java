package com.laiqian.sync.model;

import android.os.Environment;
import android.text.format.Time;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class a {
  private static final Object lock = new Object();
  
  public static void apF() {
    str = RootApplication.getLaiqianPreferenceManager().Tx();
    file = oq(str);
    if (!file.exists() || file.length() < 3L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("没有该账号缺少数据的文件，或者大小是");
      stringBuilder.append(file.length());
      n.println(stringBuilder.toString());
      return;
    } 
    synchronized (lock) {
      l = System.currentTimeMillis();
      stringBuilder = null;
      arrayOfString1 = null;
      try {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] arrayOfByte = new byte[(int)file.length()];
        fileInputStream.read(arrayOfByte);
        fileInputStream.close();
        str1 = new String(arrayOfByte);
        long l1 = System.currentTimeMillis();
        arrayOfString3 = new StringBuilder();
        arrayOfString3.append("从文件中获取字符串耗时：");
        arrayOfString3.append(l1 - l);
        n.println(arrayOfString3.toString());
      } catch (Throwable str) {
        a.e(str);
        n.println("哪里错了");
        str = null;
        str1 = str;
      } 
      if (str1 == null) {
        n.println("获取缺少数据的文件的内容时，出错了");
        return;
      } 
      if (LQKVersion.zg()) {
        int i = str1.length();
        if (i > 0)
          try {
            File file1 = new File(Environment.getExternalStorageDirectory(), "missdata");
            if (!file1.exists())
              file1.mkdirs(); 
            Time time = new Time();
            time.setToNow();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(time.format("%Y%m%d_%H%M%S"));
            stringBuilder1.append(".txt");
            file1 = new File(file1, stringBuilder1.toString());
            file1.createNewFile();
            arrayOfString3 = new FileWriter(file1);
            arrayOfString3.write(str1);
            arrayOfString3.flush();
            arrayOfString3.close();
            n.println("保存丢失的数据的ID成功");
          } catch (IOException null) {
            a.e(arrayOfString3);
            n.println("保存丢失的数据的ID失败");
          }  
      } 
      try {
      
      } catch (Throwable null) {
      
      } finally {
        arrayOfString3 = null;
        arrayOfString2 = arrayOfString1;
      } 
      arrayOfString1 = arrayOfString2;
      a.e(arrayOfString3);
      arrayOfString1 = arrayOfString2;
      n.println("执行失败了");
      if (arrayOfString2 != null) {
        arrayOfString2.endTransaction();
        arrayOfString2.close();
      } 
    } 
  }
  
  private static File oq(String paramString) {
    File file = RootApplication.zv().getFilesDir();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(".miss");
    return new File(file, stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */