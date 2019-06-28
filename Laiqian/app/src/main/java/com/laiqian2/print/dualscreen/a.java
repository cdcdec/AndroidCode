package com.laiqian.print.dualscreen;

import android.annotation.TargetApi;
import android.os.Environment;
import com.google.a.a.a.a.a.a;
import com.laiqian.pos.settings.z;
import com.laiqian.product.models.g;
import com.laiqian.util.am;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

public abstract class a {
  private static WeakHashMap<String, a> cFh = new WeakHashMap();
  
  public static a lb(String paramString) {
    if (cFh.get(paramString) != null)
      return (a)cFh.get(paramString); 
    a a1 = new a(paramString);
    cFh.put(paramString, a1);
    return a1;
  }
  
  public abstract File[] afA();
  
  public abstract String afB();
  
  public abstract boolean b(File paramFile, int paramInt);
  
  public abstract boolean bi(int paramInt);
  
  public abstract File hW(int paramInt);
  
  public abstract boolean m(InputStream paramInputStream);
  
  public abstract int size();
  
  public abstract boolean t(File paramFile);
  
  public abstract boolean u(File paramFile);
  
  private static class a extends a {
    private File aQr;
    
    private final String aSI;
    
    public a(String param1String) throws IllegalStateException {
      this.aSI = param1String;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
      stringBuilder.append(File.separator);
      stringBuilder.append("dualscreen_");
      stringBuilder.append(param1String);
      this.aQr = new File(stringBuilder.toString());
      if (!this.aQr.exists() && !v(this.aQr))
        throw new IllegalStateException("dir cannot be created"); 
    }
    
    private String lc(String param1String) {
      String[] arrayOfString = this.aQr.list(new a(null));
      if (arrayOfString == null || arrayOfString.length == 0)
        return z.kF(String.format("%s%d.jpg", new Object[] { param1String, Integer.valueOf(0) })); 
      List list = Arrays.asList(arrayOfString);
      Collections.sort(list, new c(this));
      String str;
      return z.kF((str = (String)list.get(list.size() - 1)).format("%s%d.jpg", new Object[] { param1String, Integer.valueOf(Integer.parseInt(str.substring(str.lastIndexOf('_') + 1, str.lastIndexOf('.'))) + 1) }));
    }
    
    private boolean v(File param1File) { return param1File.exists() ? true : (!!param1File.mkdirs()); }
    
    public File[] afA() {
      String[] arrayOfString = this.aQr.list(new a(null));
      byte b = 0;
      if (arrayOfString == null)
        return new File[0]; 
      File[] arrayOfFile = new File[arrayOfString.length];
      while (b < arrayOfString.length) {
        arrayOfFile[b] = new File(this.aQr, arrayOfString[b]);
        b++;
      } 
      return arrayOfFile;
    }
    
    public String afB() {
      File file = new File(this.aQr, lc("logo_"));
      return file.exists() ? file.getAbsolutePath() : "";
    }
    
    public boolean b(File param1File, int param1Int) {
      if (param1File == null)
        throw new NullPointerException("source path cannot be null"); 
      File file = hW(param1Int);
      return am.B(param1File.getAbsolutePath(), file.getAbsolutePath());
    }
    
    public boolean bi(int param1Int) {
      String[] arrayOfString = this.aQr.list(new a(null));
      if (arrayOfString == null)
        return false; 
      if (param1Int < 0 || param1Int >= arrayOfString.length)
        throw new ArrayIndexOutOfBoundsException(param1Int); 
      return (new File(this.aQr, arrayOfString[param1Int])).delete();
    }
    
    public File hW(int param1Int) {
      String[] arrayOfString = this.aQr.list(new a(null));
      if (arrayOfString == null)
        return null; 
      if (param1Int < 0 || param1Int >= arrayOfString.length)
        throw new ArrayIndexOutOfBoundsException(param1Int); 
      return new File(this.aQr, arrayOfString[param1Int]);
    }
    
    public boolean m(InputStream param1InputStream) {
      if (param1InputStream == null)
        throw new NullPointerException("source path cannot be null"); 
      return am.a(param1InputStream, (new File(this.aQr, lc("pic_"))).getAbsolutePath());
    }
    
    public int size() {
      String[] arrayOfString = this.aQr.list(new a(null));
      return (arrayOfString != null) ? arrayOfString.length : 0;
    }
    
    @TargetApi(19)
    public boolean t(File param1File) {
      try {
        g g;
        Throwable throwable;
        fileInputStream = new FileInputStream(param1File);
        param1File = null;
        try {
          boolean bool = m(fileInputStream);
          if (fileInputStream != null)
            fileInputStream.close(); 
          return bool;
        } catch (Throwable null) {
          throwable = g;
          throw g;
        } finally {}
        if (fileInputStream != null)
          if (throwable != null) {
            try {
              fileInputStream.close();
            } catch (Throwable fileInputStream) {
              a.a(throwable, fileInputStream);
            } 
          } else {
            fileInputStream.close();
          }  
        throw g;
      } catch (IOException param1File) {
        a.e(param1File);
        return false;
      } 
    }
    
    @TargetApi(19)
    public boolean u(File param1File) {
      try {
        fileInputStream = new FileInputStream(param1File);
        file1 = null;
        if (fileInputStream == null) {
          param1File = file1;
          try {
            throw new NullPointerException("source path cannot be null");
          } catch (Throwable file1) {
            param1File = file1;
            throw file1;
          } finally {
            if (fileInputStream != null)
              if (param1File != null) {
                try {
                  fileInputStream.close();
                } catch (Throwable fileInputStream) {
                  a.a(param1File, fileInputStream);
                } 
              } else {
                fileInputStream.close();
              }  
          } 
        } 
        param1File = file1;
        File file2 = new File(this.aQr, lc("logo_"));
        param1File = file1;
        if (file2.exists()) {
          param1File = file1;
          file2.delete();
        } 
        param1File = file1;
        boolean bool = am.a(fileInputStream, file2.getAbsolutePath());
        if (fileInputStream != null)
          fileInputStream.close(); 
        return bool;
      } catch (IOException param1File) {
        a.e(param1File);
        return false;
      } 
    }
    
    private static class a implements FilenameFilter {
      private a() {}
      
      public boolean accept(File param2File, String param2String) { return param2String.startsWith("pic_"); }
    }
  }
  
  private static class a implements FilenameFilter {
    private a() {}
    
    public boolean accept(File param1File, String param1String) { return param1String.startsWith("pic_"); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\dualscreen\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */