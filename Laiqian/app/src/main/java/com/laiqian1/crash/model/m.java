package com.laiqian.crash.model;

import android.content.Context;
import android.os.Environment;
import com.google.a.a.a.a.a.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class m {
  private boolean aNe = false;
  
  private String aNf;
  
  private String aNg;
  
  private Context context;
  
  public m(Context paramContext) {
    this.context = paramContext;
    this.aNe = Environment.getExternalStorageState().equals("mounted");
    this.aNf = Environment.getExternalStorageDirectory().getPath();
    this.aNg = this.context.getFilesDir().getPath();
  }
  
  public String CT() { return this.aNf; }
  
  public String cl(String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    file = new File(paramString);
    try {
      bufferedReader = new BufferedReader(new FileReader(file));
      try {
        while (true) {
          String str = bufferedReader.readLine();
          if (str != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("<br>");
            stringBuffer.append(stringBuilder.toString());
            continue;
          } 
          break;
        } 
        bufferedReader.close();
      } catch (IOException bufferedReader) {
        a.e(bufferedReader);
      } 
    } catch (FileNotFoundException file) {
      a.e(file);
    } 
    return stringBuffer.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\model\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */