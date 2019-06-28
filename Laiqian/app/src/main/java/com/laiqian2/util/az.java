package com.laiqian.util;

import android.os.Environment;
import android.util.Log;
import com.laiqian.pos.hardware.RootUrlParameter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class az {
  private static String YH;
  
  private static int dGc = 0;
  
  private static FileOutputStream dGd;
  
  private static File file;
  
  private static String pattern = "yyyy-MM-dd HH:mm:ss";
  
  static  {
    if (RootUrlParameter.bDebug && dGc == 2 && Environment.getExternalStorageState().equals("mounted")) {
      file1 = Environment.getExternalStorageDirectory();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(file1.getAbsolutePath());
      stringBuilder.append("/LQK/");
      YH = stringBuilder.toString();
      file1 = new File(YH);
      if (!file1.exists())
        file1.mkdirs(); 
      file = new File(new File(YH), "log.txt");
      Log.i("SDCAEDTAG", YH);
      try {
        dGd = new FileOutputStream(file, true);
        return;
      } catch (FileNotFoundException file1) {
        return;
      } 
    } 
  }
  
  public static void c(Class paramClass, String paramString) { // Byte code:
    //   0: getstatic com/laiqian/pos/hardware/RootUrlParameter.bDebug : Z
    //   3: ifne -> 7
    //   6: return
    //   7: getstatic com/laiqian/util/az.dGc : I
    //   10: tableswitch default -> 36, 0 -> 179, 1 -> 188, 2 -> 37
    //   36: return
    //   37: new java/util/Date
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore_2
    //   45: new java/text/SimpleDateFormat
    //   48: dup
    //   49: getstatic com/laiqian/util/az.pattern : Ljava/lang/String;
    //   52: invokespecial <init> : (Ljava/lang/String;)V
    //   55: aload_2
    //   56: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   59: astore_2
    //   60: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   63: ldc 'mounted'
    //   65: invokevirtual equals : (Ljava/lang/Object;)Z
    //   68: ifeq -> 188
    //   71: getstatic com/laiqian/util/az.dGd : Ljava/io/FileOutputStream;
    //   74: ifnull -> 170
    //   77: getstatic com/laiqian/util/az.dGd : Ljava/io/FileOutputStream;
    //   80: aload_2
    //   81: invokevirtual getBytes : ()[B
    //   84: invokevirtual write : ([B)V
    //   87: ldc ''
    //   89: astore_2
    //   90: aload_0
    //   91: ifnull -> 99
    //   94: aload_0
    //   95: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   98: astore_2
    //   99: getstatic com/laiqian/util/az.dGd : Ljava/io/FileOutputStream;
    //   102: astore_0
    //   103: new java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial <init> : ()V
    //   110: astore_3
    //   111: aload_3
    //   112: ldc '    '
    //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_3
    //   119: aload_2
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_3
    //   125: ldc '\\r\\n'
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_0
    //   132: aload_3
    //   133: invokevirtual toString : ()Ljava/lang/String;
    //   136: invokevirtual getBytes : ()[B
    //   139: invokevirtual write : ([B)V
    //   142: getstatic com/laiqian/util/az.dGd : Ljava/io/FileOutputStream;
    //   145: aload_1
    //   146: invokevirtual getBytes : ()[B
    //   149: invokevirtual write : ([B)V
    //   152: getstatic com/laiqian/util/az.dGd : Ljava/io/FileOutputStream;
    //   155: ldc '\\r\\n'
    //   157: invokevirtual getBytes : ()[B
    //   160: invokevirtual write : ([B)V
    //   163: getstatic com/laiqian/util/az.dGd : Ljava/io/FileOutputStream;
    //   166: invokevirtual flush : ()V
    //   169: return
    //   170: ldc 'SDCAEDTAG'
    //   172: ldc 'file is null'
    //   174: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   177: pop
    //   178: return
    //   179: aload_0
    //   180: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   183: aload_1
    //   184: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   187: pop
    //   188: return
    //   189: astore_0
    //   190: return
    // Exception table:
    //   from	to	target	type
    //   77	87	189	java/io/IOException
    //   94	99	189	java/io/IOException
    //   99	169	189	java/io/IOException }
  
  public static void info(String paramString) { c(az.class, paramString); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */