package com.laiqian.util;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import com.google.a.a.a.a.a.a;
import com.laiqian.network.s;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class am {
  public static boolean B(String paramString1, String paramString2) {
    try {
      if ((new File(paramString1)).exists())
        return a(new FileInputStream(paramString1), paramString2); 
    } catch (Exception paramString1) {
      a.e(paramString1);
    } 
    return false;
  }
  
  public static String D(String[] paramArrayOfString) {
    processBuilder1 = new ProcessBuilder(paramArrayOfString);
    inputStream1 = null;
    processBuilder5 = null;
    inputStream3 = null;
    try {
      byteArrayOutputStream = new ByteArrayOutputStream();
    } catch (IOException null) {
      processBuilder1 = null;
    } catch (Exception null) {
      processBuilder1 = null;
      processBuilder2 = processBuilder1;
      processBuilder6 = processBuilder1;
      processBuilder7 = processBuilder2;
    } finally {
      inputStream1 = null;
      processBuilder1 = null;
    } 
    ProcessBuilder processBuilder3 = processBuilder1;
    ProcessBuilder processBuilder4 = processBuilder2;
    InputStream inputStream2 = inputStream3;
    a.e(processBuilder5);
    if (inputStream3 != null) {
      try {
        inputStream3.close();
        if (processBuilder2 != null)
          processBuilder2.close(); 
      } catch (IOException processBuilder2) {
        a.e(processBuilder2);
      } 
      if (processBuilder1 != null) {
        processBuilder1.destroy();
        return "";
      } 
      return "";
    } 
    if (processBuilder2 != null)
      processBuilder2.close(); 
  }
  
  public static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString) {
    try {
      cursor = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, paramString, paramArrayOfString, null);
      return null;
    } finally {
      paramContext = null;
      if (paramContext != null)
        paramContext.close(); 
    } 
  }
  
  public static boolean a(ContentResolver paramContentResolver, Uri paramUri, String paramString) throws FileNotFoundException { return a(paramContentResolver.openInputStream(paramUri), paramString); }
  
  public static boolean a(File paramFile, boolean paramBoolean) {
    boolean bool2 = paramFile.isDirectory();
    boolean bool1 = true;
    if (bool2) {
      String[] arrayOfString = paramFile.list();
      for (byte b = 0; b < arrayOfString.length; b++) {
        if (!a(new File(paramFile, arrayOfString[b]), true))
          return false; 
      } 
    } 
    if (paramBoolean)
      bool1 = paramFile.delete(); 
    return bool1;
  }
  
  public static boolean a(InputStream paramInputStream, String paramString) {
    if (paramInputStream != null)
      try {
        FileOutputStream fileOutputStream = new FileOutputStream(paramString);
        byte[] arrayOfByte = new byte[1444];
        while (true) {
          int i = paramInputStream.read(arrayOfByte);
          if (i != -1) {
            fileOutputStream.write(arrayOfByte, 0, i);
            continue;
          } 
          break;
        } 
        fileOutputStream.getFD().sync();
        fileOutputStream.close();
        paramInputStream.close();
      } catch (Exception paramInputStream) {
        a.e(paramInputStream);
        return false;
      }  
    return true;
  }
  
  @TargetApi(19)
  public static String b(Context paramContext, Uri paramUri) {
    boolean bool;
    Uri uri;
    String[] arrayOfString;
    if (Build.VERSION.SDK_INT >= 19) {
      bool = true;
    } else {
      bool = false;
    } 
    String str = null;
    if (bool && DocumentsContract.isDocumentUri(paramContext, paramUri)) {
      if (d(paramUri)) {
        arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
        if ("primary".equalsIgnoreCase(arrayOfString[0])) {
          StringBuilder stringBuilder;
          uri = new StringBuilder();
          uri.append(Environment.getExternalStorageDirectory());
          uri.append(File.separator);
          uri.append(arrayOfString[1]);
          return uri.toString();
        } 
      } else {
        String str1;
        if (e(uri)) {
          str1 = DocumentsContract.getDocumentId(uri);
          return a(arrayOfString, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(str1).longValue()), null, null);
        } 
        if (f(str1)) {
          String[] arrayOfString1 = DocumentsContract.getDocumentId(str1).split(":");
          String str2 = arrayOfString1[0];
          if ("image".equals(str2)) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
          } else if ("video".equals(str2)) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
          } else {
            str1 = str;
            if ("audio".equals(str2))
              uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI; 
          } 
          return a(arrayOfString, uri, "_id=?", new String[] { arrayOfString1[1] });
        } 
      } 
    } else {
      if ("content".equalsIgnoreCase(uri.getScheme()))
        return g(uri) ? uri.getLastPathSegment() : a(arrayOfString, uri, null, null); 
      if ("file".equalsIgnoreCase(uri.getScheme()))
        return uri.getPath(); 
    } 
    return null;
  }
  
  public static boolean b(@NonNull Bitmap paramBitmap, @NonNull String paramString) {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(paramString);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
      fileOutputStream.flush();
      fileOutputStream.close();
      return true;
    } catch (IOException paramBitmap) {
      a.e(paramBitmap);
      return false;
    } 
  }
  
  public static boolean bj(String paramString1, String paramString2) {
    D(new String[] { "chmod", paramString1, paramString2 });
    return true;
  }
  
  public static String[] bk(String paramString1, String paramString2) {
    File[] arrayOfFile = (new File(paramString1)).listFiles();
    if (arrayOfFile == null)
      return null; 
    null = new HashMap();
    byte b1 = 0;
    byte b2;
    for (b2 = 0; b1 < arrayOfFile.length; b2 = b) {
      byte b = b2;
      if (arrayOfFile[b1].isFile()) {
        String str = arrayOfFile[b1].getName();
        b = b2;
        if (paramString2 != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(".");
          stringBuilder.append(paramString2);
          b = b2;
          if (str.indexOf(stringBuilder.toString()) >= 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(b2);
            null.put(stringBuilder.toString(), str);
            b = b2 + 1;
          } 
        } 
      } 
      b1++;
    } 
    String[] arrayOfString = new String[b2];
    for (Map.Entry entry : null.entrySet()) {
      String str1 = (String)entry.getKey();
      String str2 = (String)entry.getValue();
      arrayOfString[Integer.parseInt(str1)] = str2;
    } 
    return arrayOfString;
  }
  
  public static String c(Context paramContext, Uri paramUri) {
    str2 = null;
    if (paramUri != null) {
      String str = paramUri.toString();
      if (str.substring(10, str.length()).startsWith("com.sec.android.gallery3d")) {
        str1 = new StringBuilder();
        str1.append("It's auto backup pic path:");
        str1.append(paramUri.toString());
        bb.e("logg", str1.toString());
        return null;
      } 
    } 
    try {
      arrayOfString = new String[1];
      arrayOfString[0] = "_data";
    } catch (Exception stringBuilder) {
    
    } finally {
      str1 = str2;
      if (str1 != null)
        str1.close(); 
    } 
    if (str1 != null)
      str1.close(); 
    return null;
  }
  
  public static List<String> c(File paramFile, List<String> paramList) { // Byte code:
    //   0: aload_0
    //   1: invokevirtual isDirectory : ()Z
    //   4: ifeq -> 37
    //   7: aload_0
    //   8: invokevirtual listFiles : ()[Ljava/io/File;
    //   11: astore_0
    //   12: aload_0
    //   13: arraylength
    //   14: istore_3
    //   15: iconst_0
    //   16: istore_2
    //   17: iload_2
    //   18: iload_3
    //   19: if_icmpge -> 48
    //   22: aload_0
    //   23: iload_2
    //   24: aaload
    //   25: aload_1
    //   26: invokestatic c : (Ljava/io/File;Ljava/util/List;)Ljava/util/List;
    //   29: pop
    //   30: iload_2
    //   31: iconst_1
    //   32: iadd
    //   33: istore_2
    //   34: goto -> 17
    //   37: aload_1
    //   38: aload_0
    //   39: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   42: invokeinterface add : (Ljava/lang/Object;)Z
    //   47: pop
    //   48: aload_1
    //   49: areturn }
  
  public static boolean cE(String paramString) { return a(new File(paramString), true); }
  
  public static boolean d(Uri paramUri) { return "com.android.externalstorage.documents".equals(paramUri.getAuthority()); }
  
  public static boolean e(Uri paramUri) { return "com.android.providers.downloads.documents".equals(paramUri.getAuthority()); }
  
  public static boolean f(Uri paramUri) { return "com.android.providers.media.documents".equals(paramUri.getAuthority()); }
  
  public static boolean g(Uri paramUri) { return "com.google.android.apps.photos.content".equals(paramUri.getAuthority()); }
  
  public static boolean g(String paramString1, String paramString2, String paramString3, String paramString4) {
    File file = new File(paramString1);
    paramString1 = "";
    try {
      paramString2 = s.a(paramString2, paramString3, paramString4, file);
      paramString1 = paramString2;
    } catch (IOException paramString2) {
      a.e(paramString2);
    } catch (NoSuchAlgorithmException paramString2) {
      a.e(paramString2);
    } 
    if (paramString1.equals("1")) {
      bb.e("_LQK", " upload success");
      return true;
    } 
    bb.e("_LQK", " upload failed");
    return false;
  }
  
  public static String qr(String paramString) {
    try {
      null = new File(paramString);
      if (null == null || !null.exists())
        return ""; 
      FileInputStream fileInputStream = new FileInputStream(null);
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int i = fileInputStream.read(arrayOfByte);
        if (i != -1) {
          byteArrayOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        break;
      } 
      byteArrayOutputStream.close();
      fileInputStream.close();
      return byteArrayOutputStream.toString();
    } catch (IOException paramString) {
      a.e(paramString);
      return "";
    } 
  }
  
  public static Bitmap qs(String paramString) {
    Bitmap bitmap1;
    bitmap2 = null;
    try {
      BitmapFactory.Options options = new BitmapFactory.Options();
      options.inJustDecodeBounds = true;
      exception = BitmapFactory.decodeFile(paramString, options);
      try {
        options.inJustDecodeBounds = false;
        int i = options.outWidth;
        int j = options.outHeight;
        if (i > j && i > 800.0F) {
          i = (int)(options.outWidth / 800.0F);
        } else if (i < j && j > 1366.0F) {
          i = (int)(options.outHeight / 1366.0F);
        } else {
          i = 1;
        } 
      } catch (Exception bitmap2) {
        bitmap1 = exception;
        exception = bitmap2;
      } 
    } catch (Exception exception) {
      bitmap1 = bitmap2;
    } 
    a.e(exception);
    return bitmap1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */