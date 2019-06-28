package com.laiqian.dcb.api.server.b;

import com.google.a.a.a.a.a.a;
import com.laiqian.dcb.api.server.a;
import io.netty.b.ar;
import io.netty.c.a.a.ag;
import io.netty.c.a.a.ai;
import io.netty.c.a.a.ak;
import io.netty.c.a.a.al;
import io.netty.c.a.a.b;
import io.netty.c.a.a.h;
import io.netty.c.a.a.k;
import io.netty.c.a.a.l;
import io.netty.c.a.a.m;
import io.netty.c.a.a.t;
import io.netty.c.d.a;
import io.netty.channel.cb;
import io.netty.channel.co;
import io.netty.channel.s;
import io.netty.channel.t;
import io.netty.channel.z;
import io.netty.e.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class a extends co<k> {
  private static final Pattern aPO;
  
  private static final Pattern aPP = (aPO = Pattern.compile(".*[<>&\"].*")).compile("[A-Za-z0-9][-_A-Za-z0-9\\.]*");
  
  private static void a(ag paramag, File paramFile) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    paramag.aFY().t("Date", simpleDateFormat.format(gregorianCalendar.getTime()));
    gregorianCalendar.add(13, 0);
    paramag.aFY().t("Expires", simpleDateFormat.format(gregorianCalendar.getTime()));
    paramag.aFY().t("Cache-Control", "private, max-age=0");
    paramag.aFY().t("Last-Modified", simpleDateFormat.format(new Date(paramFile.lastModified())));
  }
  
  private static void a(l paraml) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    paraml.aFY().t("Date", simpleDateFormat.format(gregorianCalendar.getTime()));
  }
  
  private static void a(z paramz, ai paramai) {
    ak ak = ak.ekL;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failure: ");
    stringBuilder.append(paramai);
    stringBuilder.append("\r\n");
    b b = new b(ak, paramai, ar.a(stringBuilder.toString(), g.UTF_8));
    b.aFY().t("Content-Type", "text/plain; charset=UTF-8");
    paramz.aM(b).a(t.ebK);
  }
  
  private static void a(z paramz, String paramString) {
    b b = new b(ak.ekL, ai.ejR);
    b.aFY().t("Location", paramString);
    paramz.aM(b).a(t.ebK);
  }
  
  private static void b(ag paramag, File paramFile) { paramag.aFY().t("Content-Type", "application/x-download"); }
  
  private static void c(z paramz) {
    b b = new b(ak.ekL, ai.ejT);
    a(b);
    paramz.aM(b).a(t.ebK);
  }
  
  private static String cD(String paramString) {
    try {
      String str1;
      paramString = URLDecoder.decode(paramString, "UTF-8");
      boolean bool = paramString.startsWith("/");
      String str2 = null;
      if (!bool)
        return null; 
      String str3 = paramString.replace('/', File.separatorChar);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(File.separator);
      stringBuilder.append('.');
      paramString = str2;
      if (!str3.contains(stringBuilder.toString())) {
        stringBuilder = new StringBuilder();
        stringBuilder.append('.');
        stringBuilder.append(File.separator);
        paramString = str2;
        if (!str3.contains(stringBuilder.toString())) {
          paramString = str2;
          if (!str3.startsWith(".")) {
            paramString = str2;
            if (!str3.endsWith(".")) {
              paramString = str2;
              if (!aPO.matcher(str3).matches()) {
                null = new StringBuilder();
                null.append(a.DR());
                null.append(File.separator);
                null.append(str3);
                str1 = null.toString();
              } 
            } 
          } 
        } 
      } 
      return str1;
    } catch (UnsupportedEncodingException paramString) {
      throw new Error(paramString);
    } 
  }
  
  protected void a(z paramz, k paramk) throws Exception {
    s s;
    if (!paramk.aGa().aEG()) {
      a(paramz, ai.ejW);
      return;
    } 
    String str = paramk.getUri();
    null = cD(str);
    if (null == null) {
      a(paramz, ai.ejZ);
      return;
    } 
    File file = new File(null);
    if (!file.isHidden() && file.exists()) {
      if (file.isDirectory()) {
        if (!str.endsWith("/")) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          stringBuilder.append('/');
          a(paramz, stringBuilder.toString());
          return;
        } 
      } else {
        PrintStream printStream = System.err;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("file");
        stringBuilder1.append(file);
        printStream.println(stringBuilder1.toString());
        if (!file.isFile()) {
          a(paramz, ai.ejZ);
          return;
        } 
        String str1 = stringBuilder.aFY().get("If-Modified-Since");
        if (str1 != null && !str1.isEmpty() && (new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US)).parse(str1).getTime() / 1000L == file.lastModified() / 1000L) {
          c(paramz);
          return;
        } 
        try {
          s s1;
          RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
          long l = randomAccessFile.length();
          h h = new h(ak.ekL, ai.ejH);
          t.b(h, l);
          b(h, file);
          a(h, file);
          if (t.a(stringBuilder))
            h.aFY().t("CONNECTION", "keep-alive"); 
          paramz.bp(h);
          if (paramz.YY().J(io.netty.c.c.i.class) == null) {
            System.err.println("SslHandler is null");
            s1 = paramz.b(new cb(randomAccessFile.getChannel(), 0L, l), paramz.aDk());
          } else {
            System.err.println("SslHandler is not null");
            s1 = paramz.b(new m(new a(randomAccessFile, 0L, l, ' ')), paramz.aDk());
          } 
          s1.a(new b(this));
          s = paramz.aM(al.ekQ);
          if (!t.a(stringBuilder)) {
            s.a(t.ebK);
            return;
          } 
          return;
        } catch (FileNotFoundException stringBuilder) {
          a(s, ai.eka);
          return;
        } 
      } 
    } else {
      a(s, ai.eka);
    } 
  }
  
  public void a(z paramz, Throwable paramThrowable) {
    a.e(paramThrowable);
    if (paramz.aDb().isActive())
      a(paramz, ai.ekx); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\server\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */