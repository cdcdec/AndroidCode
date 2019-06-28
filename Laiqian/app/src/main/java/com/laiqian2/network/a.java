package com.laiqian.network;

import android.util.Log;
import b.ae;
import b.af;
import b.aj;
import b.t;
import b.y;
import b.z;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class a {
  public static String a(File paramFile, String paramString, a parama) throws IOException {
    ae = (new ae.a()).uS(paramString).aSW().aSZ();
    aj2 = j.adg.a(ae).aRI();
    if (aj2.aTa()) {
      arrayOfByte = new byte[1024];
      ae = null;
      try {
        l2 = aj2.aTc().pl();
        l1 = 0L;
        inputStream2 = aj2.aTc().aTi();
        try {
          fileOutputStream = new FileOutputStream(paramFile);
        } catch (IOException ae) {
        
        } finally {
          ae = null;
        } 
        inputStream3 = inputStream2;
      } catch (IOException null) {
      
      } finally {
        ae = null;
        file = null;
      } 
      try {
        stringBuilder = new StringBuilder();
        stringBuilder.append("下载文件失败");
        stringBuilder.append(file);
      } finally {
        paramFile = null;
        ae ae1 = ae;
        File file1 = paramFile;
        aj1 = aj2;
        if (ae1 != null) {
          try {
            ae1.close();
            if (aj1 != null)
              aj1.close(); 
          } catch (IOException aj1) {
            Log.e("FileSyncHelper", aj1.toString());
            parama.dS("error");
          } 
          throw file1;
        } 
      } 
    } else {
      Log.e("FileSyncHelper", "下载文件失败");
      h.a(new d("FileSyncHelper", "downloadFile", "IOException/服务器下载文件失败", aj2.aTc().aTk()), h.a.dHw, h.b.dHG);
    } 
    return aj1.getAbsolutePath();
  }
  
  public static String a(File paramFile, String paramString, Map<String, String> paramMap, a parama) throws IOException {
    a1 = new t.a();
    for (Map.Entry entry : paramMap.entrySet())
      a1.bO((String)entry.getKey(), (String)entry.getValue()); 
    ae ae = (new ae.a()).uS(paramString).a(a1.aRU()).aSZ();
    aj2 = j.adg.a(ae).aRI();
    if (aj2.aTa()) {
      arrayOfByte = new byte[1024];
      stringBuilder = null;
      try {
        l2 = aj2.aTc().pl();
        l1 = 0L;
      } catch (IOException arrayOfByte) {
      
      } finally {
        arrayOfByte = null;
        a1 = null;
      } 
      try {
        stringBuilder = new StringBuilder();
        stringBuilder.append("下载文件失败");
        stringBuilder.append(arrayOfByte);
        Log.e("FileSyncHelper", stringBuilder.toString());
        h.a(new d("FileSyncHelper", "downLoadFile", "IOException/服务器下载文件失败", arrayOfByte.getCause().getMessage()), h.a.dHw, h.b.dHG);
      } finally {
        arrayOfByte = null;
        aj1 = aj2;
        if (a1 != null) {
          try {
            a1.close();
            if (aj1 != null)
              aj1.close(); 
          } catch (IOException aj1) {
            Log.e("FileSyncHelper", aj1.toString());
            parama.dS("error");
          } 
          throw arrayOfByte;
        } 
      } 
    } else {
      Log.e("FileSyncHelper", "下载文件失败");
      h.a(new d("FileSyncHelper", "downloadFile", "IOException/服务器下载文件失败", aj2.aTc().aTk()), h.a.dHw, h.b.dHG);
    } 
    return aj1.getAbsolutePath();
  }
  
  public static String a(String paramString, Map<String, String> paramMap, File paramFile, a parama) throws IOException {
    z.a a1 = (new z.a()).a(z.ffK);
    if (paramFile != null) {
      af af = af.a(y.uP("image/*"), paramFile);
      a1.a("upload_file", paramFile.getName(), af);
    } 
    if (paramMap != null)
      for (Map.Entry entry : paramMap.entrySet())
        a1.bW(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));  
    null = (new ae.a()).uS(paramString).a(a1.aSv()).ct(RootApplication.zv()).aSZ();
    aj aj = RootApplication.zv().zE().aSL().l(5000L, TimeUnit.MILLISECONDS).aSM().a(null).aRI();
    if (aj.aTa()) {
      String str1 = aj.message();
      String str2 = aj.aTc().aTk();
      if (aj.aTa()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aj.message());
        stringBuilder.append(" success : body ");
        stringBuilder.append(str2);
        Log.i("post upload ", stringBuilder.toString());
        parama.dS(str1);
      } else {
        h.a(new d("FileSyncHelper", "uploadFile", "上传文件失败", str2), h.a.dHv, h.b.dHC);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aj.message());
        stringBuilder.append(" error : body ");
        stringBuilder.append(str2);
        Log.i("post upload", stringBuilder.toString());
        parama.dS(str1);
      } 
    } else {
      Log.i("FileSyncHelper", "uploadFile 上传文件失败");
      h.a(new d("FileSyncHelper", "uploadFile", "上传文件失败", aj.aTc().aTk()), h.a.dHv, h.b.dHC);
    } 
    return "";
  }
  
  public static interface a {
    void dS(String param1String);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */