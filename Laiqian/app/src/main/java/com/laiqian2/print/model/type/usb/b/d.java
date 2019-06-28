package com.laiqian.print.model.type.usb.b;

import android.util.Log;
import com.google.a.a.a.a.a.a;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class d {
  final String TAG = getClass().getName();
  
  public String lC(String paramString) {
    String str = this.TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("^ Executing '");
    stringBuilder.append(paramString);
    stringBuilder.append("'");
    Log.d(str, stringBuilder.toString());
    try {
      Process process = Runtime.getRuntime().exec("sh");
      DataInputStream dataInputStream = new DataInputStream(process.getInputStream());
      DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("\n");
      dataOutputStream.writeBytes(stringBuilder1.toString());
      dataOutputStream.writeBytes("exit\n");
      dataOutputStream.flush();
      dataOutputStream.close();
      bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
      try {
        StringBuilder stringBuilder2 = new StringBuilder();
        while (true) {
          String str1 = bufferedReader.readLine();
          if (str1 != null) {
            stringBuilder2.append(str1);
            stringBuilder2.append("\n");
            continue;
          } 
          break;
        } 
        bufferedReader.close();
        return stringBuilder2.toString();
      } catch (IOException bufferedReader) {
        Log.e(this.TAG, "^ exec, IOException 1");
        a.e(bufferedReader);
        process.waitFor();
      } 
    } catch (IOException paramString) {
      Log.e(this.TAG, "^ exec, IOException 2");
      a.e(paramString);
    } catch (InterruptedException paramString) {
      Log.e(this.TAG, "^ exec, InterruptedException");
      a.e(paramString);
    } 
    return "";
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */