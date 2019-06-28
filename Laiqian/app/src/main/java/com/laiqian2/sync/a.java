package com.laiqian.sync;

import android.util.Log;
import c.g;
import c.n;
import c.z;
import com.a.a.a.a.a;
import com.a.a.a.c.b;
import com.a.a.a.c.d;
import com.alibaba.a.a.d.b;
import com.alibaba.a.a.d.e;
import com.laiqian.basic.LQKVersion;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class a {
  private static String TAG = "com.laiqian.sync.OssHelper";
  
  private static String afS = "6ho3FpLmpmGxPqqu";
  
  private static String afT = "EQ4MSBh1srwRfxwTuPWN4oVO0pZBfW";
  
  static  {
  
  }
  
  public static void a(String paramString1, String paramString2, File paramFile) throws b, e, IOException {
    b b = new b(paramString1, paramString2);
    b.as(afS);
    b.at(afT);
    InputStream inputStream = b.getInputStream();
    if (inputStream == null) {
      h.a(new d(TAG, "downloadFile", "oss下载文件,tsk.getInputStream()=null", "object not exist"), h.a.dHv, h.b.dHG);
      throw new IOException("object not exist");
    } 
    g g = n.c(n.U(paramFile));
    z z = n.v(inputStream);
    g.b(z);
    g.close();
    z.close();
  }
  
  public static void b(String paramString1, String paramString2, File paramFile) throws b, e, IOException {
    if (LQKVersion.zg() && paramFile.exists()) {
      String str = a.class.getSimpleName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("file size=");
      stringBuilder.append(paramFile.length());
      Log.d(str, stringBuilder.toString());
    } 
    d d = new d(paramString1, paramString2, a.afU.toString(), paramFile.getAbsolutePath());
    d.at(afT);
    d.as(afS);
    d.qv();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */