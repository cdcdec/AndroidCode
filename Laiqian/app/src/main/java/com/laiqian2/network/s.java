package com.laiqian.network;

import com.laiqian.f.c;
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

public class s {
  private static String bUA = "IS_BYTE_ENCRYPTION_SUPPORT";
  
  private static String bUB = "FUPLOADFILE";
  
  private static String bUx = "CHECK_FLAG";
  
  private static String bUy = "NUSERID";
  
  private static String bUz = "SUSERPHONE";
  
  static  {
  
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, File paramFile) throws IOException, NoSuchAlgorithmException {
    String str2 = UUID.randomUUID().toString();
    HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(paramString1)).openConnection();
    httpURLConnection.setReadTimeout(15000);
    httpURLConnection.setDoInput(true);
    httpURLConnection.setDoOutput(true);
    httpURLConnection.setUseCaches(false);
    httpURLConnection.setRequestMethod("POST");
    httpURLConnection.setRequestProperty("connection", "keep-alive");
    httpURLConnection.setRequestProperty("Charsert", "UTF-8");
    httpURLConnection.setRequestProperty("enctype", "multipart/form-data");
    null = new StringBuilder();
    null.append("multipart/form-data");
    null.append(";boundary=");
    null.append(str2);
    httpURLConnection.setRequestProperty("Content-Type", null.toString());
    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
    null = new StringBuilder();
    null.append("--");
    null.append(str2);
    null.append("\r\n");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Disposition: form-data; name=\"");
    stringBuilder.append(bUy);
    stringBuilder.append("\"");
    stringBuilder.append("\r\n");
    null.append(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Type: text/plain; charset=");
    stringBuilder.append("UTF-8");
    stringBuilder.append("\r\n");
    null.append(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Transfer-Encoding: 8bit");
    stringBuilder.append("\r\n");
    null.append(stringBuilder.toString());
    null.append("\r\n");
    null.append(paramString2);
    null.append("\r\n");
    null.append("--");
    null.append(str2);
    null.append("\r\n");
    stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Disposition: form-data; name=\"");
    stringBuilder.append(bUx);
    stringBuilder.append("\"");
    stringBuilder.append("\r\n");
    null.append(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Type: text/plain; charset=");
    stringBuilder.append("UTF-8");
    stringBuilder.append("\r\n");
    null.append(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Transfer-Encoding: 8bit");
    stringBuilder.append("\r\n");
    null.append(stringBuilder.toString());
    null.append("\r\n");
    null.append(paramString3);
    null.append("\r\n");
    null.append("--");
    null.append(str2);
    null.append("\r\n");
    stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Disposition: form-data; name=\"");
    stringBuilder.append(bUA);
    stringBuilder.append("\"");
    stringBuilder.append("\r\n");
    null.append(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Type: text/plain; charset=");
    stringBuilder.append("UTF-8");
    stringBuilder.append("\r\n");
    null.append(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Transfer-Encoding: 8bit");
    stringBuilder.append("\r\n");
    null.append(stringBuilder.toString());
    null.append("\r\n");
    null.append(c.E(paramString2, paramString3));
    null.append("\r\n");
    dataOutputStream.write(null.toString().getBytes());
    if (paramFile != null) {
      null = new StringBuilder();
      null.append("--");
      null.append(str2);
      null.append("\r\n");
      null = new StringBuilder();
      null.append("Content-Disposition: form-data; name=\"");
      null.append(bUB);
      null.append("\"; filename=\"");
      null.append(paramFile.getName());
      null.append("\"");
      null.append("\r\n");
      null.append(null.toString());
      null = new StringBuilder();
      null.append("Content-Type: application/octet-stream; charset=");
      null.append("UTF-8");
      null.append("\r\n");
      null.append(null.toString());
      null.append("\r\n");
      dataOutputStream.write(null.toString().getBytes());
      FileInputStream fileInputStream = new FileInputStream(paramFile);
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int j = fileInputStream.read(arrayOfByte);
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
    dataOutputStream.flush();
    int i = httpURLConnection.getResponseCode();
    InputStream inputStream = httpURLConnection.getInputStream();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    String str1 = "";
    while (true) {
      String str = bufferedReader.readLine();
      if (str != null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(str);
        str1 = stringBuilder1.toString();
        continue;
      } 
      break;
    } 
    if (i == 200) {
      StringBuilder stringBuilder1 = new StringBuilder();
      while (true) {
        i = inputStream.read();
        if (i != -1) {
          stringBuilder1.append((char)i);
          continue;
        } 
        break;
      } 
    } 
    dataOutputStream.close();
    httpURLConnection.disconnect();
    return str1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */