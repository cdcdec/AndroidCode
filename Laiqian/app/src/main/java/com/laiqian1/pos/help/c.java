package com.laiqian.pos.help;

import android.os.Handler;
import android.os.Message;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.crash.model.CrashApplication;
import io.reactivex.g.a;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class c {
  private long cmP = 0L;
  
  private final String cmQ;
  
  private Handler mHandler;
  
  public c(Handler paramHandler) {
    this.mHandler = paramHandler;
    this.cmQ = CrashApplication.getLaiqianPreferenceManager().Tx();
  }
  
  private String l(InputStream paramInputStream) throws Exception {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    while (true) {
      int i = paramInputStream.read(arrayOfByte);
      if (i != -1) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      break;
    } 
    String str = new String(byteArrayOutputStream.toByteArray(), e.cmS);
    byteArrayOutputStream.close();
    paramInputStream.close();
    return str;
  }
  
  public void aaw() { gW(1); }
  
  public void cr(long paramLong) {
    this.cmP = paramLong;
    gW(0);
  }
  
  public void gW(int paramInt) {
    String str1;
    StringBuilder stringBuilder;
    String str2 = "";
    switch (paramInt) {
      case 1:
        str2 = e.cmV;
        break;
      case 0:
        stringBuilder = new StringBuilder();
        stringBuilder.append(e.cmT);
        stringBuilder.append("?time=");
        stringBuilder.append(this.cmP);
        stringBuilder.append("&product=");
        stringBuilder.append(LQKVersion.zi());
        stringBuilder.append("&shopid=");
        stringBuilder.append(this.cmQ);
        str1 = stringBuilder.toString();
        break;
    } 
    a.aKh().r(new d(this, paramInt, str1));
  }
  
  public String jD(String paramString) {
    DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
    httpGet = new HttpGet(paramString);
    try {
      HttpResponse httpResponse = defaultHttpClient.execute(httpGet);
      if (httpResponse.getStatusLine().getStatusCode() == 200)
        return l(httpResponse.getEntity().getContent()); 
    } catch (Exception httpGet) {
      a.e(httpGet);
    } 
    return "";
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\help\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */