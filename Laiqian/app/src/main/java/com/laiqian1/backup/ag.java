package com.laiqian.backup;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.f.c;
import com.laiqian.f.d;
import com.laiqian.f.e;
import com.laiqian.infrastructure.R;
import com.laiqian.milestone.g;
import com.laiqian.milestone.h;
import com.laiqian.util.am;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bn;
import com.laiqian.util.by;
import com.laiqian.util.ch;
import com.laiqian.util.cq;
import com.laiqian.version.r;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ag {
  public static String aIA = "";
  
  static  {
  
  }
  
  private static String G(long paramLong) {
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    if (paramLong == 0L)
      return "0B"; 
    if (paramLong < 1024L) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(decimalFormat.format(paramLong));
      stringBuilder1.append("B");
      return stringBuilder1.toString();
    } 
    if (paramLong < 1048576L) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(decimalFormat.format(paramLong / 1024.0D));
      stringBuilder1.append("KB");
      return stringBuilder1.toString();
    } 
    if (paramLong < 1073741824L) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(decimalFormat.format(paramLong / 1048576.0D));
      stringBuilder1.append("MB");
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(decimalFormat.format(paramLong / 1.073741824E9D));
    stringBuilder.append("GB");
    return stringBuilder.toString();
  }
  
  public static void K(Context paramContext) {
    if (!za())
      return; 
    av av = new av(paramContext);
    if (av.atA()) {
      int i = av.atx();
      ArrayList arrayList = a(L(paramContext), ".lq508", true);
      if (arrayList != null) {
        int j = arrayList.size();
        if (j > i)
          while (i < j) {
            String str = ((HashMap)arrayList.get(i)).get("path").toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("deleting old backup file: ");
            stringBuilder.append(str);
            Log.i("BackUpUtility", stringBuilder.toString());
            bE(str);
            i++;
          }  
      } 
    } 
    av.close();
  }
  
  public static String L(Context paramContext) { return y(yX(), paramContext.getString(R.string.backup_menu_file_directory)); }
  
  public static String M(Context paramContext) {
    double d = bn.py(yX());
    return (!za() || d < 20480.0D) ? "" : f(paramContext, yX(), paramContext.getString(R.string.backup_menu_file_directory));
  }
  
  public static String N(Context paramContext) {
    String[] arrayOfString = O(paramContext);
    return c.F(arrayOfString[0], arrayOfString[1]);
  }
  
  private static String[] O(Context paramContext) {
    av av = new av(paramContext);
    String str3 = av.Tx();
    String str2 = av.atm();
    h h = new h(paramContext);
    long l = h.TZ();
    String str1 = str2;
    if (l > 0L) {
      null = new StringBuilder();
      null.append(l);
      null.append("");
      str1 = null.toString();
    } 
    bb.e("backupUserID", str1);
    h.close();
    av.close();
    return new String[] { str3, str1 };
  }
  
  private static Pair<Boolean, String> a(boolean paramBoolean1, Context paramContext, String paramString1, String paramString2, boolean paramBoolean2, String paramString3) {
    File file2 = new File(paramString3);
    File file1 = paramContext.getDatabasePath("encrypted.db");
    file1.mkdirs();
    file1.delete();
    try {
      int i;
      file1.createNewFile();
      FileInputStream fileInputStream = new FileInputStream(file2.getAbsolutePath());
      FileOutputStream fileOutputStream = new FileOutputStream(file1.getAbsolutePath());
      byte[] arrayOfByte = new byte[8192];
      while (true) {
        i = fileInputStream.read(arrayOfByte);
        if (i > 0) {
          fileOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        break;
      } 
      fileOutputStream.close();
      fileInputStream.close();
      av av = new av(paramContext);
      String str2 = av.Ea();
      av.close();
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmm_ss");
      paramString1 = z(paramString1, paramString2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      if (paramBoolean2) {
        i = R.string.backup_menu_list_backup_file_auto_pre;
      } else {
        i = R.string.backup_menu_list_backup_file_manual_pre;
      } 
      paramString1 = paramContext.getString(i);
      stringBuilder.append(paramString1);
      stringBuilder.append("_");
      if (paramBoolean1) {
        paramString1 = "main";
      } else {
        String str;
        null = new StringBuilder();
        null.append("branch$");
        null.append(paramString3.replace("/", "-").replace(".", "~"));
        null.append("$");
        str = null.toString();
      } 
      stringBuilder.append(str);
      stringBuilder.append("_");
      stringBuilder.append(ch.cf(paramContext));
      stringBuilder.append("_");
      stringBuilder.append(str2);
      stringBuilder.append("_");
      stringBuilder.append(simpleDateFormat.format(new Date()));
      if (paramBoolean2) {
        str = ".lq508";
      } else {
        str = ".lq507";
      } 
      stringBuilder.append(str);
      aIA = stringBuilder.toString();
      null = new StringBuilder();
      null.append(aIA);
      null.append(".temp");
      String str1 = null.toString();
      if ((new g(paramContext, file1.getAbsolutePath(), str1, "", g.aQe)).aQh) {
        paramBoolean1 = e.n(str1, aIA, N(paramContext));
        file1.delete();
        (new File(str1)).delete();
        return new Pair(Boolean.valueOf(paramBoolean1), aIA);
      } 
      return new Pair(Boolean.valueOf(false), "");
    } catch (IOException paramContext) {
      a.e(paramContext);
      return new Pair(Boolean.valueOf(false), "");
    } 
  }
  
  private static File a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2) {
    int i;
    String str1;
    av av = new av(paramContext);
    String str2 = av.Ea();
    av.close();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmm_ss");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(y(paramString1, paramString2));
    if (paramBoolean) {
      i = R.string.backup_menu_list_backup_file_auto_pre;
    } else {
      i = R.string.backup_menu_list_backup_file_manual_pre;
    } 
    paramString1 = paramContext.getString(i);
    stringBuilder.append(paramString1);
    stringBuilder.append("_");
    stringBuilder.append(ch.cf(paramContext));
    stringBuilder.append("_");
    stringBuilder.append(str2);
    stringBuilder.append("_");
    stringBuilder.append(simpleDateFormat.format(new Date()));
    if (paramBoolean) {
      str1 = ".lq508";
    } else {
      str1 = ".lq507";
    } 
    stringBuilder.append(str1);
    return new File(stringBuilder.toString());
  }
  
  private static String a(File paramFile, List<String> paramList) throws Exception {
    if (paramList != null && paramFile != null) {
      if (paramList.isEmpty())
        return ""; 
      File file = new File(RootApplication.zv().getCacheDir(), "/backupTemp");
      boolean bool = file.exists();
      byte b2 = 0;
      if (bool)
        if (file.isFile()) {
          file.delete();
        } else {
          am.a(file, false);
        }  
      byte b1 = b2;
      if (!file.exists()) {
        file.mkdirs();
        b1 = b2;
      } 
      while (b1 < paramList.size()) {
        File file1 = new File((String)paramList.get(b1));
        String str = (String)paramList.get(b1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append(file1.getName());
        am.B(str, stringBuilder.toString());
        b1++;
      } 
      cq.by(file.getAbsolutePath(), paramFile.getAbsolutePath());
      return paramFile.getAbsolutePath();
    } 
    return "";
  }
  
  public static ArrayList<HashMap<String, Object>> a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) { return a(paramString1, paramString2, paramString3, paramBoolean, true); }
  
  public static ArrayList<HashMap<String, Object>> a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2) {
    ArrayList arrayList2 = new ArrayList();
    File[] arrayOfFile = (new File(paramString1)).listFiles();
    if (arrayOfFile == null)
      return arrayList2; 
    byte b;
    for (b = 0; b < arrayOfFile.length; b++) {
      if (arrayOfFile[b].isFile()) {
        String str = arrayOfFile[b].getName();
        long l = arrayOfFile[b].lastModified();
        if (str.contains(paramString2) && (by.isNull(paramString3) || str.contains(paramString3))) {
          long l1 = arrayOfFile[b].length();
          String str1 = arrayOfFile[b].getAbsolutePath();
          if (l1 > 0L) {
            String str2 = G(l1);
            HashMap hashMap = new HashMap();
            hashMap.put("path", str1);
            hashMap.put("name", str);
            hashMap.put("direct", paramString1);
            hashMap.put("size", str2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(l);
            stringBuilder.append("");
            hashMap.put("time", stringBuilder.toString());
            arrayList2.add(hashMap);
          } else {
            bE(str1);
          } 
        } 
      } 
    } 
    ArrayList arrayList1 = arrayList2;
    if (paramBoolean2)
      arrayList1 = a(arrayList2, "time", paramBoolean1); 
    return arrayList1;
  }
  
  public static ArrayList<HashMap<String, Object>> a(String paramString1, String paramString2, boolean paramBoolean) { return a(paramString1, paramString2, null, paramBoolean, true); }
  
  public static ArrayList<HashMap<String, Object>> a(String paramString, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2) {
    byte b2;
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    boolean bool = false;
    byte b1;
    for (b1 = 0; b1 < paramArrayOfString.length; b1++)
      arrayList1.add(new ArrayList()); 
    File[] arrayOfFile = (new File(paramString)).listFiles();
    if (arrayOfFile == null)
      return arrayList2; 
    b1 = 0;
    while (true) {
      b2 = bool;
      if (b1 < arrayOfFile.length) {
        if (arrayOfFile[b1].isFile()) {
          String str = arrayOfFile[b1].getName();
          long l = arrayOfFile[b1].lastModified();
          for (b2 = 0; b2 < paramArrayOfString.length; b2++) {
            if (str.indexOf(paramArrayOfString[b2]) >= 0) {
              long l1 = arrayOfFile[b1].length();
              StringBuilder stringBuilder = arrayOfFile[b1].getAbsolutePath();
              if (l1 > 0L) {
                String str1 = G(l1);
                HashMap hashMap = new HashMap();
                hashMap.put("path", stringBuilder);
                hashMap.put("name", str);
                hashMap.put("direct", paramString);
                hashMap.put("size", str1);
                stringBuilder = new StringBuilder();
                stringBuilder.append(l);
                stringBuilder.append("");
                hashMap.put("time", stringBuilder.toString());
                ((ArrayList)arrayList1.get(b2)).add(hashMap);
              } else if (str.indexOf("lqk") >= 0) {
                bE(stringBuilder);
              } 
            } 
          } 
        } 
        b1++;
        continue;
      } 
      break;
    } 
    while (b2 < paramArrayOfString.length) {
      Collection collection;
      if (paramBoolean2) {
        collection = a((ArrayList)arrayList1.get(b2), "time", paramBoolean1);
      } else {
        collection = (Collection)arrayList1.get(b2);
      } 
      arrayList2.addAll(collection);
      b2++;
    } 
    return arrayList2;
  }
  
  public static ArrayList<HashMap<String, Object>> a(ArrayList<HashMap<String, Object>> paramArrayList, String paramString, boolean paramBoolean) {
    Collections.sort(paramArrayList, new ah(paramBoolean, paramString));
    return paramArrayList;
  }
  
  public static File b(File paramFile1, File paramFile2) throws IOException {
    if (paramFile1 == null || paramFile2 == null)
      return null; 
    cq.bx(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath());
    return paramFile2;
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, String paramString3) {
    null = new StringBuilder();
    null.append("/data/data/");
    null.append(paramContext.getPackageName());
    null.append("/");
    null = null.toString();
    null = new StringBuilder();
    null.append(null);
    null.append("laiqian.db");
    File file1 = new File(null.toString());
    null = new StringBuilder();
    null.append(paramString3);
    null.append(paramString1);
    File file2 = new File(null.toString());
    try {
      file2.createNewFile();
      null = new FileInputStream(file1.getAbsolutePath());
      FileOutputStream fileOutputStream = new FileOutputStream(file2);
      byte[] arrayOfByte = new byte[8192];
      while (true) {
        int i = null.read(arrayOfByte);
        if (i > 0) {
          fileOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        break;
      } 
      fileOutputStream.close();
      null.close();
      null = new StringBuilder();
      null.append(paramString1);
      null.append(".zip");
      String str = null.toString();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString3);
      stringBuilder.append(paramString1);
      paramString1 = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString3);
      stringBuilder.append(str);
      if ((new g(paramContext, paramString1, stringBuilder.toString(), "", g.aQe)).aQh) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString3);
        stringBuilder1.append(str);
        String str1 = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramString3);
        stringBuilder2.append(paramString2);
        return e.n(str1, stringBuilder2.toString(), N(paramContext));
      } 
      return false;
    } catch (IOException paramContext) {
      a.e(paramContext);
      return false;
    } 
  }
  
  public static boolean b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean) { // Byte code:
    //   0: ldc com/laiqian/backup/ag
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic K : (Landroid/content/Context;)V
    //   7: ldc ''
    //   9: astore #6
    //   11: new java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: astore #5
    //   20: aload #5
    //   22: ldc_w '/data/data/'
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload #5
    //   31: aload_0
    //   32: invokevirtual getPackageName : ()Ljava/lang/String;
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload #5
    //   41: ldc '/'
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload #5
    //   49: ldc_w 'laiqian.db'
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload #5
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: astore #5
    //   63: new java/util/ArrayList
    //   66: dup
    //   67: invokespecial <init> : ()V
    //   70: astore #7
    //   72: iconst_1
    //   73: aload_0
    //   74: aload_1
    //   75: aload_2
    //   76: iload_3
    //   77: aload #5
    //   79: invokestatic a : (ZLandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/util/Pair;
    //   82: astore #5
    //   84: aload #5
    //   86: getfield first : Ljava/lang/Object;
    //   89: checkcast java/lang/Boolean
    //   92: invokevirtual booleanValue : ()Z
    //   95: ifeq -> 125
    //   98: aload #5
    //   100: getfield second : Ljava/lang/Object;
    //   103: checkcast java/lang/CharSequence
    //   106: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   109: ifne -> 125
    //   112: aload #7
    //   114: aload #5
    //   116: getfield second : Ljava/lang/Object;
    //   119: invokeinterface add : (Ljava/lang/Object;)Z
    //   124: pop
    //   125: new java/io/File
    //   128: dup
    //   129: getstatic com/laiqian/db/multidatabase/b/a.aOz : Ljava/lang/String;
    //   132: invokespecial <init> : (Ljava/lang/String;)V
    //   135: new java/util/ArrayList
    //   138: dup
    //   139: invokespecial <init> : ()V
    //   142: invokestatic b : (Ljava/io/File;Ljava/util/List;)Ljava/util/List;
    //   145: invokeinterface iterator : ()Ljava/util/Iterator;
    //   150: astore #5
    //   152: aload #5
    //   154: invokeinterface hasNext : ()Z
    //   159: ifeq -> 226
    //   162: iconst_0
    //   163: aload_0
    //   164: aload_1
    //   165: aload_2
    //   166: iload_3
    //   167: aload #5
    //   169: invokeinterface next : ()Ljava/lang/Object;
    //   174: checkcast java/lang/String
    //   177: invokestatic a : (ZLandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/util/Pair;
    //   180: astore #8
    //   182: aload #8
    //   184: getfield first : Ljava/lang/Object;
    //   187: checkcast java/lang/Boolean
    //   190: invokevirtual booleanValue : ()Z
    //   193: ifeq -> 152
    //   196: aload #8
    //   198: getfield second : Ljava/lang/Object;
    //   201: checkcast java/lang/CharSequence
    //   204: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   207: ifne -> 152
    //   210: aload #7
    //   212: aload #8
    //   214: getfield second : Ljava/lang/Object;
    //   217: invokeinterface add : (Ljava/lang/Object;)Z
    //   222: pop
    //   223: goto -> 152
    //   226: aload #7
    //   228: invokeinterface isEmpty : ()Z
    //   233: istore #4
    //   235: aload #6
    //   237: astore #5
    //   239: iload #4
    //   241: ifne -> 287
    //   244: aload_0
    //   245: iload_3
    //   246: aload_1
    //   247: aload_2
    //   248: invokestatic a : (Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   251: aload #7
    //   253: invokestatic a : (Ljava/io/File;Ljava/util/List;)Ljava/lang/String;
    //   256: astore_0
    //   257: aload #7
    //   259: invokestatic e : (Ljava/util/Collection;)I
    //   262: pop
    //   263: aload_0
    //   264: astore #5
    //   266: goto -> 287
    //   269: astore_1
    //   270: aload_0
    //   271: astore #5
    //   273: aload_1
    //   274: astore_0
    //   275: goto -> 283
    //   278: astore_0
    //   279: aload #6
    //   281: astore #5
    //   283: aload_0
    //   284: invokestatic e : (Ljava/lang/Throwable;)V
    //   287: aload #5
    //   289: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   292: istore_3
    //   293: ldc com/laiqian/backup/ag
    //   295: monitorexit
    //   296: iload_3
    //   297: iconst_1
    //   298: ixor
    //   299: ireturn
    //   300: astore_0
    //   301: ldc com/laiqian/backup/ag
    //   303: monitorexit
    //   304: aload_0
    //   305: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	300	finally
    //   11	125	300	finally
    //   125	152	300	finally
    //   152	223	300	finally
    //   226	235	300	finally
    //   244	257	278	java/lang/Exception
    //   244	257	300	finally
    //   257	263	269	java/lang/Exception
    //   257	263	300	finally
    //   283	287	300	finally
    //   287	293	300	finally }
  
  public static boolean b(Context paramContext, boolean paramBoolean) { return !za() ? false : b(paramContext, yX(), paramContext.getString(R.string.backup_menu_file_directory), paramBoolean); }
  
  public static String[] b(ArrayList<HashMap<String, String>> paramArrayList, String paramString) {
    String[] arrayOfString = new String[paramArrayList.size()];
    for (byte b = 0; b < paramArrayList.size(); b++)
      arrayOfString[b] = (String)((HashMap)paramArrayList.get(b)).get(paramString); 
    return arrayOfString;
  }
  
  public static boolean bE(String paramString) { return (new File(paramString)).delete(); }
  
  public static boolean c(ArrayList<HashMap<String, String>> paramArrayList, String paramString) {
    if (paramArrayList != null && paramArrayList.size() > 0)
      for (byte b = 0; b < paramArrayList.size(); b++) {
        if (((String)((HashMap)paramArrayList.get(b)).get("name")).equals(paramString))
          return true; 
      }  
    return false;
  }
  
  private static void d(ArrayList<HashMap<String, String>> paramArrayList, String paramString) {
    if (!paramString.toLowerCase().contains("u"))
      return; 
    File file = new File(paramString);
    if (file.isDirectory() && !c(paramArrayList, file.getName())) {
      File file1 = new File(file.getAbsolutePath(), "test.laiqian");
      if (file1.exists() || file1.mkdirs()) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", file.getName());
        bb.e("sonFile.getParent()).getName()", paramString);
        hashMap.put("path", file.getAbsolutePath());
        paramArrayList.add(hashMap);
      } 
    } 
  }
  
  private static int e(Collection<String> paramCollection) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      arrayList.add(new File((String)iterator.next())); 
    return f(arrayList);
  }
  
  private static int f(Collection<File> paramCollection) {
    Iterator iterator = paramCollection.iterator();
    byte b = 0;
    while (iterator.hasNext()) {
      if (((File)iterator.next()).delete())
        b++; 
    } 
    return b;
  }
  
  public static String f(Context paramContext, String paramString1, String paramString2) { // Byte code:
    //   0: ldc com/laiqian/backup/ag
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic K : (Landroid/content/Context;)V
    //   7: ldc ''
    //   9: astore #5
    //   11: new java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial <init> : ()V
    //   18: astore #4
    //   20: aload #4
    //   22: ldc_w '/data/data/'
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload #4
    //   31: aload_0
    //   32: invokevirtual getPackageName : ()Ljava/lang/String;
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload #4
    //   41: ldc '/'
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload #4
    //   49: ldc_w 'laiqian.db'
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload #4
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: astore #4
    //   63: new java/util/ArrayList
    //   66: dup
    //   67: invokespecial <init> : ()V
    //   70: astore #6
    //   72: iconst_1
    //   73: aload_0
    //   74: aload_1
    //   75: aload_2
    //   76: iconst_0
    //   77: aload #4
    //   79: invokestatic a : (ZLandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/util/Pair;
    //   82: astore #4
    //   84: aload #4
    //   86: getfield first : Ljava/lang/Object;
    //   89: checkcast java/lang/Boolean
    //   92: invokevirtual booleanValue : ()Z
    //   95: ifeq -> 125
    //   98: aload #4
    //   100: getfield second : Ljava/lang/Object;
    //   103: checkcast java/lang/CharSequence
    //   106: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   109: ifne -> 125
    //   112: aload #6
    //   114: aload #4
    //   116: getfield second : Ljava/lang/Object;
    //   119: invokeinterface add : (Ljava/lang/Object;)Z
    //   124: pop
    //   125: new java/io/File
    //   128: dup
    //   129: getstatic com/laiqian/db/multidatabase/b/a.aOz : Ljava/lang/String;
    //   132: invokespecial <init> : (Ljava/lang/String;)V
    //   135: new java/util/ArrayList
    //   138: dup
    //   139: invokespecial <init> : ()V
    //   142: invokestatic b : (Ljava/io/File;Ljava/util/List;)Ljava/util/List;
    //   145: invokeinterface iterator : ()Ljava/util/Iterator;
    //   150: astore #4
    //   152: aload #4
    //   154: invokeinterface hasNext : ()Z
    //   159: ifeq -> 226
    //   162: iconst_0
    //   163: aload_0
    //   164: aload_1
    //   165: aload_2
    //   166: iconst_0
    //   167: aload #4
    //   169: invokeinterface next : ()Ljava/lang/Object;
    //   174: checkcast java/lang/String
    //   177: invokestatic a : (ZLandroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/util/Pair;
    //   180: astore #7
    //   182: aload #7
    //   184: getfield first : Ljava/lang/Object;
    //   187: checkcast java/lang/Boolean
    //   190: invokevirtual booleanValue : ()Z
    //   193: ifeq -> 152
    //   196: aload #7
    //   198: getfield second : Ljava/lang/Object;
    //   201: checkcast java/lang/CharSequence
    //   204: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   207: ifne -> 152
    //   210: aload #6
    //   212: aload #7
    //   214: getfield second : Ljava/lang/Object;
    //   217: invokeinterface add : (Ljava/lang/Object;)Z
    //   222: pop
    //   223: goto -> 152
    //   226: aload #6
    //   228: invokeinterface isEmpty : ()Z
    //   233: istore_3
    //   234: aload #5
    //   236: astore #4
    //   238: iload_3
    //   239: ifne -> 285
    //   242: aload_0
    //   243: iconst_0
    //   244: aload_1
    //   245: aload_2
    //   246: invokestatic a : (Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   249: aload #6
    //   251: invokestatic a : (Ljava/io/File;Ljava/util/List;)Ljava/lang/String;
    //   254: astore_0
    //   255: aload #6
    //   257: invokestatic e : (Ljava/util/Collection;)I
    //   260: pop
    //   261: aload_0
    //   262: astore #4
    //   264: goto -> 285
    //   267: astore_1
    //   268: aload_0
    //   269: astore #4
    //   271: aload_1
    //   272: astore_0
    //   273: goto -> 281
    //   276: astore_0
    //   277: aload #5
    //   279: astore #4
    //   281: aload_0
    //   282: invokestatic e : (Ljava/lang/Throwable;)V
    //   285: ldc com/laiqian/backup/ag
    //   287: monitorexit
    //   288: aload #4
    //   290: areturn
    //   291: astore_0
    //   292: ldc com/laiqian/backup/ag
    //   294: monitorexit
    //   295: aload_0
    //   296: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	291	finally
    //   11	125	291	finally
    //   125	152	291	finally
    //   152	223	291	finally
    //   226	234	291	finally
    //   242	255	276	java/lang/Exception
    //   242	255	291	finally
    //   255	261	267	java/lang/Exception
    //   255	261	291	finally
    //   281	285	291	finally }
  
  public static String g(Context paramContext, String paramString1, String paramString2) {
    paramContext.getString(R.string.backup_load_file_success);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramString1);
    stringBuilder3.append("/");
    stringBuilder3.append(paramString2);
    String str3 = stringBuilder3.toString();
    if (!paramString2.contains("branch")) {
      String str;
      null = new StringBuilder();
      null.append("/data/data/");
      null.append(paramContext.getPackageName());
      null.append("/");
      null.append("encrypted.db");
      stringBuilder = null.toString();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("备份文件该被恢复的地址1-->/data/data/");
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append("/");
      b.ct(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("解压后的备份文件存在的地址1-->");
      stringBuilder.append(stringBuilder);
      b.ct(stringBuilder.toString());
    } else {
      stringBuilder = stringBuilder.substring(stringBuilder.indexOf("$", 1) + 1, stringBuilder.lastIndexOf("$")).replace("-", "/").replace("~", ".").replace("*", ".");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("备份文件该被恢复的地址2-->");
      stringBuilder.append(stringBuilder);
      stringBuilder.append("");
      b.ct(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(stringBuilder.substring(0, stringBuilder.lastIndexOf("/")));
      stringBuilder.append("/");
      stringBuilder.append(stringBuilder.substring(stringBuilder.lastIndexOf("/") + 1, stringBuilder.lastIndexOf(".")));
      stringBuilder.append("_");
      stringBuilder.append("encrypted.db");
      stringBuilder = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append("解压后的备份文件存在的地址2-->");
      stringBuilder.append(stringBuilder);
      b.ct(stringBuilder.toString());
    } 
    (new File(paramString1)).mkdir();
    String str2 = new File(stringBuilder);
    if (str2.exists())
      str2.delete(); 
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(str3);
    stringBuilder4.append(".decrypted");
    String str4 = stringBuilder4.toString();
    int i = d.m(str3, str4, N(paramContext));
    if (i == 0 || i == 2) {
      StringBuilder stringBuilder;
      String str = paramContext.getString(R.string.backup_load_file_fail);
      if (i == 0) {
        str1 = paramContext.getString(R.string.backup_load_file_load_fail_before_205);
      } else {
        str1 = str1.getString(R.string.backup_load_file_load_fail_error_account);
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(str1);
      return stringBuilder.toString();
    } 
    if (!(new g(str1, str4, stringBuilder, "db", g.aQf)).aQh) {
      str2 = str1.getString(R.string.backup_load_file_fail);
      stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append(str1.getString(R.string.backup_load_file_zip_fail));
      return stringBuilder.toString();
    } 
    (new File(str4)).delete();
    StringBuilder stringBuilder1 = new r(str1, stringBuilder);
    if (stringBuilder1.dJx) {
      if (stringBuilder1.load()) {
        str1 = str1.getString(R.string.backup_load_file_success);
        stringBuilder1.close();
        str2.delete();
        return str1;
      } 
      str2 = str1.getString(R.string.backup_load_file_fail);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append(str1.getString(R.string.backup_load_file_load_fail));
      return stringBuilder1.toString();
    } 
    str2 = str1.getString(R.string.backup_load_file_fail);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append(str1.getString(R.string.backup_load_file_old_version_fail));
    String str1 = stringBuilder2.toString();
    stringBuilder1.close();
    return str1;
  }
  
  public static String i(Context paramContext, String paramString) {
    String str1;
    paramContext.getString(R.string.backup_load_file_success);
    null = yX();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(null);
    stringBuilder2.append("/");
    stringBuilder2.append(paramContext.getString(R.string.backup_menu_file_directory));
    stringBuilder2.append("/");
    stringBuilder2.append(paramString);
    paramString = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("/data/data/");
    stringBuilder2.append(paramContext.getPackageName());
    stringBuilder2.append("/");
    stringBuilder2.append("encrypted.db");
    String str2 = stringBuilder2.toString();
    (new File(null)).mkdir();
    (new File(str2)).delete();
    null = new StringBuilder();
    null.append(paramString);
    null.append(".decrypted");
    StringBuilder stringBuilder1 = null.toString();
    int i = d.m(paramString, stringBuilder1, N(paramContext));
    if (i == 0 || i == 2) {
      paramString = paramContext.getString(R.string.backup_load_file_fail);
      if (i == 0) {
        str1 = paramContext.getString(R.string.backup_load_file_load_fail_before_205);
      } else {
        str1 = str1.getString(R.string.backup_load_file_load_fail_error_account);
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append(str1);
      return stringBuilder1.toString();
    } 
    (new File(paramString)).delete();
    if (!(new g(str1, stringBuilder1, str2, "db", g.aQf)).aQh) {
      paramString = str1.getString(R.string.backup_load_file_fail);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append(str1.getString(R.string.backup_load_file_zip_fail));
      return stringBuilder1.toString();
    } 
    (new File(stringBuilder1)).delete();
    return str1.getString(R.string.backup_load_file_success);
  }
  
  public static boolean x(String paramString1, String paramString2) {
    try {
      ArrayList arrayList = a(paramString1, paramString2, true);
      for (byte b = 0; b < arrayList.size(); b++)
        bE(((HashMap)arrayList.get(b)).get("path").toString()); 
      return true;
    } catch (Exception paramString1) {
      return false;
    } 
  }
  
  public static String y(String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append(File.separator);
      stringBuilder.append(paramString2);
      stringBuilder.append(File.separator);
      paramString1 = stringBuilder.toString();
      try {
        (new File(paramString1)).mkdirs();
        return paramString1;
      } catch (Exception paramString2) {
        return paramString1;
      } 
    } catch (Exception paramString1) {
      return null;
    } 
  }
  
  public static String yX() {
    File file = Environment.getExternalStorageDirectory();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file.getParent());
    stringBuilder.append(File.separator);
    stringBuilder.append(file.getName());
    return stringBuilder.toString();
  }
  
  public static File yY() {
    File file = new File(RootApplication.zv().getCacheDir(), "/backupRecovery");
    if (file.exists())
      if (file.isFile()) {
        file.delete();
      } else {
        am.a(file, false);
      }  
    if (!file.exists())
      file.mkdirs(); 
    return file;
  }
  
  public static ArrayList<HashMap<String, String>> yZ() {
    ArrayList arrayList = new ArrayList();
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("mount").getInputStream()));
      while (true) {
        String str = bufferedReader.readLine();
        if (str != null) {
          String[] arrayOfString;
          if (str.contains("secure") || str.contains("asec") || str.contains("firmware") || str.contains("emulated"))
            continue; 
          if (str.contains("fat")) {
            arrayOfString = str.split(" ");
            if (arrayOfString != null && arrayOfString.length > 1)
              d(arrayList, arrayOfString[1]); 
            continue;
          } 
          if (arrayOfString.contains("fuse")) {
            arrayOfString = arrayOfString.split(" ");
            if (arrayOfString != null && arrayOfString.length > 1)
              d(arrayList, arrayOfString[1]); 
          } 
          continue;
        } 
        break;
      } 
    } catch (FileNotFoundException fileNotFoundException) {
      a.e(fileNotFoundException);
    } catch (IOException iOException) {
      a.e(iOException);
      return arrayList;
    } 
    return arrayList;
  }
  
  public static String z(String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append(File.separator);
      stringBuilder.append("lqkbak/");
      stringBuilder.append(paramString2);
      stringBuilder.append(File.separator);
      paramString1 = stringBuilder.toString();
      try {
        (new File(paramString1)).mkdirs();
        return paramString1;
      } catch (Exception paramString2) {
        return paramString1;
      } 
    } catch (Exception paramString1) {
      return null;
    } 
  }
  
  public static boolean za() { return "mounted".equals(Environment.getExternalStorageState()); }
  
  public static String zb() {
    if (b(RootApplication.zv(), true))
      K(RootApplication.zv()); 
    return "success";
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */