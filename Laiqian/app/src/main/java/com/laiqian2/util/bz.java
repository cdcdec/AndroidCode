package com.laiqian.util;

import com.google.a.a.a.a.a.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class bz {
  private static final SimpleDateFormat dGx = new SimpleDateFormat("HH:mm:ss");
  
  private static PrintWriter awx() throws FileNotFoundException {
    File file = new File("/sdcard/crash");
    if (!file.exists())
      file.mkdir(); 
    return new PrintWriter(new FileOutputStream(new File("/sdcard/crash/sync_log.txt"), true));
  }
  
  public static void g(String paramString1, String paramString2, boolean paramBoolean) {
    try {
      PrintWriter printWriter = awx();
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("time", dGx.format(new Date()));
      if (paramBoolean) {
        jSONObject.put("type", "update");
      } else {
        jSONObject.put("type", "store");
      } 
      jSONObject.put("tableName", paramString1);
      jSONObject.put("ids", paramString2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(jSONObject.toString());
      stringBuilder.append("\n");
      printWriter.append(stringBuilder.toString());
      printWriter.close();
      return;
    } catch (JSONException|java.io.IOException paramString1) {
      a.e(paramString1);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */