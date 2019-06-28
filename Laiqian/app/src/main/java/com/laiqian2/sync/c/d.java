package com.laiqian.sync.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.laiqian.f.c;
import com.laiqian.f.e;
import com.laiqian.h.a;
import com.laiqian.network.k;
import com.laiqian.network.t;
import com.laiqian.pos.industry.a;
import com.laiqian.util.bd;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class d {
  private static String bUA = "IS_BYTE_ENCRYPTION_SUPPORT";
  
  private static String bUB = "FUPLOADFILE";
  
  private static String bUx = "CHECK_FLAG";
  
  private static String bUy = "NUSERID";
  
  private static String bUz = "SUSERPHONE";
  
  static  {
  
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, File paramFile, String paramString4, String paramString5) throws IOException, NoSuchAlgorithmException {
    StringBuilder stringBuilder1;
    System.currentTimeMillis();
    long l = paramFile.length();
    String str2 = UUID.randomUUID().toString();
    URL uRL = new URL(paramString1);
    str = (HttpURLConnection)uRL.openConnection();
    if (!k.iI(paramString1)) {
      str = a.Js().I(uRL.getHost());
    } else {
      String str;
      str = null;
    } 
    if (str != null) {
      String str;
      str = uRL.getHost();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Get IP: ");
      stringBuilder.append(str);
      stringBuilder.append(" for host: ");
      stringBuilder.append(str);
      stringBuilder.append(" for url:");
      stringBuilder.append(paramString1);
      stringBuilder.append(" from HTTPDNS successfully!");
      Log.d("fileHttpUploader", stringBuilder.toString());
      stringBuilder1 = (HttpURLConnection)(new URL(paramString1.replaceFirst(str, str))).openConnection();
      stringBuilder1.setRequestProperty("Host", str);
    } else {
      paramString1 = str;
    } 
    paramString1.setReadTimeout(bd.dGg);
    paramString1.setConnectTimeout(bd.dGh);
    paramString1.setDoInput(true);
    paramString1.setDoOutput(true);
    paramString1.setUseCaches(false);
    paramString1.setRequestMethod("POST");
    paramString1.setRequestProperty("connection", "keep-alive");
    paramString1.setRequestProperty("Charset", "UTF-8");
    paramString1.setRequestProperty("enctype", "multipart/form-data");
    null = new StringBuilder();
    null.append("multipart/form-data");
    null.append(";boundary=");
    null.append(str2);
    paramString1.setRequestProperty("Content-Type", null.toString());
    DataOutputStream dataOutputStream = new DataOutputStream(paramString1.getOutputStream());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("--");
    stringBuilder2.append(str2);
    stringBuilder2.append("\r\n");
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("Content-Disposition: form-data; name=\"");
    stringBuilder4.append(bUy);
    stringBuilder4.append("\"");
    stringBuilder4.append("\r\n");
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("Content-Type: text/plain; charset=");
    stringBuilder4.append("UTF-8");
    stringBuilder4.append("\r\n");
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("Content-Transfer-Encoding: 8bit");
    stringBuilder4.append("\r\n");
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder2.append("\r\n");
    stringBuilder2.append(paramString2);
    stringBuilder2.append("\r\n");
    stringBuilder2.append("--");
    stringBuilder2.append(str2);
    stringBuilder2.append("\r\n");
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("Content-Disposition: form-data; name=\"");
    stringBuilder4.append(bUx);
    stringBuilder4.append("\"");
    stringBuilder4.append("\r\n");
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("Content-Type: text/plain; charset=");
    stringBuilder4.append("UTF-8");
    stringBuilder4.append("\r\n");
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("Content-Transfer-Encoding: 8bit");
    stringBuilder4.append("\r\n");
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder2.append("\r\n");
    stringBuilder2.append(paramString3);
    stringBuilder2.append("\r\n");
    stringBuilder2.append("--");
    stringBuilder2.append(str2);
    stringBuilder2.append("\r\n");
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("Content-Disposition: form-data; name=\"");
    stringBuilder4.append(bUA);
    stringBuilder4.append("\"");
    stringBuilder4.append("\r\n");
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("Content-Type: text/plain; charset=");
    stringBuilder4.append("UTF-8");
    stringBuilder4.append("\r\n");
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("Content-Transfer-Encoding: 8bit");
    stringBuilder4.append("\r\n");
    stringBuilder2.append(stringBuilder4.toString());
    stringBuilder2.append("\r\n");
    stringBuilder2.append(c.E(paramString2, paramString3));
    stringBuilder2.append("\r\n");
    null = paramContext.getSharedPreferences("settings", 0);
    String str3 = null.getString("user_phone", "1371001");
    stringBuilder2.append("--");
    stringBuilder2.append(str2);
    stringBuilder2.append("\r\n");
    StringBuilder stringBuilder5 = new StringBuilder();
    stringBuilder5.append("Content-Disposition: form-data; name=\"");
    stringBuilder5.append(bUz);
    stringBuilder5.append("\"");
    stringBuilder5.append("\r\n");
    stringBuilder2.append(stringBuilder5.toString());
    stringBuilder5 = new StringBuilder();
    stringBuilder5.append("Content-Type: text/plain; charset=");
    stringBuilder5.append("UTF-8");
    stringBuilder5.append("\r\n");
    stringBuilder2.append(stringBuilder5.toString());
    stringBuilder5 = new StringBuilder();
    stringBuilder5.append("Content-Transfer-Encoding: 8bit");
    stringBuilder5.append("\r\n");
    stringBuilder2.append(stringBuilder5.toString());
    stringBuilder2.append("\r\n");
    stringBuilder2.append(str3);
    stringBuilder2.append("\r\n");
    null = null.getString(t.bJz, "0");
    stringBuilder2.append("--");
    stringBuilder2.append(str2);
    stringBuilder2.append("\r\n");
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("Content-Disposition: form-data; name=\"");
    stringBuilder3.append(t.bJz);
    stringBuilder3.append("\"");
    stringBuilder3.append("\r\n");
    stringBuilder2.append(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("Content-Type: text/plain; charset=");
    stringBuilder3.append("UTF-8");
    stringBuilder3.append("\r\n");
    stringBuilder2.append(stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("Content-Transfer-Encoding: 8bit");
    stringBuilder3.append("\r\n");
    stringBuilder2.append(stringBuilder3.toString());
    stringBuilder2.append("\r\n");
    stringBuilder2.append(null);
    stringBuilder2.append("\r\n");
    stringBuilder2.append("--");
    stringBuilder2.append(str2);
    stringBuilder2.append("\r\n");
    null = new StringBuilder();
    null.append("Content-Disposition: form-data; name=\"");
    null.append(t.bVm);
    null.append("\"");
    null.append("\r\n");
    stringBuilder2.append(null.toString());
    null = new StringBuilder();
    null.append("Content-Type: text/plain; charset=");
    null.append("UTF-8");
    null.append("\r\n");
    stringBuilder2.append(null.toString());
    null = new StringBuilder();
    null.append("Content-Transfer-Encoding: 8bit");
    null.append("\r\n");
    stringBuilder2.append(null.toString());
    stringBuilder2.append("\r\n");
    stringBuilder2.append(a.crh);
    stringBuilder2.append("\r\n");
    if (paramString4 != null) {
      stringBuilder2.append("--");
      stringBuilder2.append(str2);
      stringBuilder2.append("\r\n");
      null = new StringBuilder();
      null.append("Content-Disposition: form-data; name=\"");
      null.append(t.bUZ);
      null.append("\"");
      null.append("\r\n");
      stringBuilder2.append(null.toString());
      null = new StringBuilder();
      null.append("Content-Type: text/plain; charset=");
      null.append("UTF-8");
      null.append("\r\n");
      stringBuilder2.append(null.toString());
      null = new StringBuilder();
      null.append("Content-Transfer-Encoding: 8bit");
      null.append("\r\n");
      stringBuilder2.append(null.toString());
      stringBuilder2.append("\r\n");
      stringBuilder2.append(paramString4);
      stringBuilder2.append("\r\n");
    } 
    if (paramString5 != null) {
      stringBuilder2.append("--");
      stringBuilder2.append(str2);
      stringBuilder2.append("\r\n");
      null = new StringBuilder();
      null.append("Content-Disposition: form-data; name=\"");
      null.append(t.bVt);
      null.append("\"");
      null.append("\r\n");
      stringBuilder2.append(null.toString());
      null = new StringBuilder();
      null.append("Content-Type: text/plain; charset=");
      null.append("UTF-8");
      null.append("\r\n");
      stringBuilder2.append(null.toString());
      null = new StringBuilder();
      null.append("Content-Transfer-Encoding: 8bit");
      null.append("\r\n");
      stringBuilder2.append(null.toString());
      stringBuilder2.append("\r\n");
      stringBuilder2.append(paramString5);
      stringBuilder2.append("\r\n");
    } 
    stringBuilder2.append("--");
    stringBuilder2.append(str2);
    stringBuilder2.append("\r\n");
    null = new StringBuilder();
    null.append("Content-Disposition: form-data; name=\"");
    null.append(t.bUZ);
    null.append("\"");
    null.append("\r\n");
    stringBuilder2.append(null.toString());
    null = new StringBuilder();
    null.append("Content-Type: text/plain; charset=");
    null.append("UTF-8");
    null.append("\r\n");
    stringBuilder2.append(null.toString());
    null = new StringBuilder();
    null.append("Content-Transfer-Encoding: 8bit");
    null.append("\r\n");
    stringBuilder2.append(null.toString());
    stringBuilder2.append("\r\n");
    stringBuilder2.append(paramString4);
    stringBuilder2.append("\r\n");
    dataOutputStream.write(stringBuilder2.toString().getBytes());
    if (paramFile != null) {
      null = new StringBuilder();
      null.append("--");
      null.append(str2);
      null.append("\r\n");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Content-Disposition: form-data; name=\"");
      stringBuilder.append(bUB);
      stringBuilder.append("\"; filename=\"");
      stringBuilder.append(paramFile.getName());
      stringBuilder.append("\"");
      stringBuilder.append("\r\n");
      null.append(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("Content-Type: application/octet-stream; charset=");
      stringBuilder.append("UTF-8");
      stringBuilder.append("\r\n");
      null.append(stringBuilder.toString());
      null.append("\r\n");
      dataOutputStream.write(null.toString().getBytes());
      FileInputStream fileInputStream = new FileInputStream(paramFile);
      e.a(fileInputStream, dataOutputStream, c.D(paramString2, paramString3));
      int j = Math.min(fileInputStream.available(), 5120);
      byte[] arrayOfByte = new byte[j];
      int k = fileInputStream.read(arrayOfByte, 0, j);
      long l1 = 0L;
      while (k > 0) {
        dataOutputStream.write(arrayOfByte, 0, j);
        l1 += j;
        long l2 = 100L * l1 / l;
        j = Math.min(fileInputStream.available(), 5120);
        k = fileInputStream.read(arrayOfByte, 0, j);
      } 
      arrayOfByte = new byte[1024];
      while (true) {
        j = fileInputStream.read(arrayOfByte);
        if (j != -1) {
          dataOutputStream.write(arrayOfByte, 0, j);
          continue;
        } 
        break;
      } 
      fileInputStream.close();
      dataOutputStream.write("\r\n".getBytes());
    } 
    null = new StringBuilder();
    null.append("--");
    null.append(str2);
    null.append("--");
    null.append("\r\n");
    dataOutputStream.write(null.toString().getBytes());
    if (dataOutputStream != null) {
      dataOutputStream.flush();
      dataOutputStream.close();
    } 
    int i = paramString1.getResponseCode();
    if (i != 200) {
      null = new BufferedReader(new InputStreamReader(paramString1.getErrorStream()));
      null = new StringBuilder();
      while (true) {
        paramString2 = null.readLine();
        if (paramString2 != null) {
          null.append(paramString2);
          continue;
        } 
        break;
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("url：");
      stringBuilder1.append(uRL.toString());
      stringBuilder1.append("详情：");
      stringBuilder1.append(i);
      h.a(new d("fileHttpUploader", "sendRequestToServer", "请求异常", stringBuilder1.toString()), h.a.dHx, h.b.dHJ);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(null.toString());
      stringBuilder1.append("statusCode: ");
      stringBuilder1.append(i);
      throw new RuntimeException(stringBuilder1.toString());
    } 
    InputStream inputStream = stringBuilder1.getInputStream();
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    String str1 = "";
    while (true) {
      paramString4 = bufferedReader.readLine();
      if (paramString4 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append(paramString4);
        str1 = stringBuilder.toString();
        continue;
      } 
      break;
    } 
    if (i == 200) {
      StringBuilder stringBuilder = new StringBuilder();
      while (true) {
        i = inputStream.read();
        if (i != -1) {
          stringBuilder.append((char)i);
          continue;
        } 
        break;
      } 
      stringBuilder.setLength(0);
      stringBuilder.delete(0, stringBuilder.length());
    } 
    stringBuilder1.disconnect();
    inputStreamReader.close();
    bufferedReader.close();
    System.currentTimeMillis();
    return str1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */