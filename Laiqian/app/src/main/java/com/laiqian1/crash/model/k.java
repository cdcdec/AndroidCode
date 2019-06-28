package com.laiqian.crash.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import com.laiqian.util.bb;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class k implements Thread.UncaughtExceptionHandler {
  private static String aNa = "";
  
  private static k aNc = new k();
  
  l aMT = new l();
  
  private Thread.UncaughtExceptionHandler aNb;
  
  private Map<String, String> aNd = new HashMap();
  
  private Context mContext;
  
  public static k CP() { return aNc; }
  
  private boolean h(Throwable paramThrowable) {
    if (paramThrowable == null)
      return false; 
    if (T(this.mContext)) {
      bb.f("CrashHandler", "成功收集设备信息");
      String str = i(paramThrowable);
      if (str.length() > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("成功保存日志文件");
        stringBuilder.append(str);
        bb.f("CrashHandler", stringBuilder.toString());
        if (a(this.mContext, this.aMT.V(this.mContext), this.aMT.W(this.mContext), 0, str, this.aMT.timestamp())) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("成功保存到数据库:");
          stringBuilder.append(str);
          bb.f("CrashHandler", stringBuilder.toString());
          Intent intent = new Intent(this.mContext, com.laiqian.crash.CrashMethod.class);
          intent.setFlags(268435456);
          intent.putExtra("path", str);
          intent.putExtra("crashtime", this.aMT.CR());
          this.mContext.startActivity(intent);
          Process.killProcess(Process.myPid());
          System.exit(1);
          return true;
        } 
        bb.f("CrashHandler", "保存到数据库失败");
        return true;
      } 
      bb.f("CrashHandler", "保存日志文件失败");
      return true;
    } 
    bb.f("CrashHandler", "收集设备信息失败");
    return true;
  }
  
  private String i(Throwable paramThrowable) { // Byte code:
    //   0: new java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #11
    //   9: aload_0
    //   10: getfield aNd : Ljava/util/Map;
    //   13: invokeinterface entrySet : ()Ljava/util/Set;
    //   18: invokeinterface iterator : ()Ljava/util/Iterator;
    //   23: astore #9
    //   25: aload #9
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 126
    //   35: aload #9
    //   37: invokeinterface next : ()Ljava/lang/Object;
    //   42: checkcast java/util/Map$Entry
    //   45: astore #12
    //   47: aload #12
    //   49: invokeinterface getKey : ()Ljava/lang/Object;
    //   54: checkcast java/lang/String
    //   57: astore #10
    //   59: aload #12
    //   61: invokeinterface getValue : ()Ljava/lang/Object;
    //   66: checkcast java/lang/String
    //   69: astore #12
    //   71: new java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial <init> : ()V
    //   78: astore #13
    //   80: aload #13
    //   82: aload #10
    //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload #13
    //   90: ldc '='
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload #13
    //   98: aload #12
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload #13
    //   106: ldc '\\n'
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload #11
    //   114: aload #13
    //   116: invokevirtual toString : ()Ljava/lang/String;
    //   119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   122: pop
    //   123: goto -> 25
    //   126: new java/io/StringWriter
    //   129: dup
    //   130: invokespecial <init> : ()V
    //   133: astore #10
    //   135: new java/io/PrintWriter
    //   138: dup
    //   139: aload #10
    //   141: invokespecial <init> : (Ljava/io/Writer;)V
    //   144: astore #12
    //   146: aload_1
    //   147: aload #12
    //   149: invokestatic a : (Ljava/lang/Throwable;Ljava/io/PrintWriter;)V
    //   152: aload_1
    //   153: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   156: astore #9
    //   158: aload #9
    //   160: ifnull -> 180
    //   163: aload #9
    //   165: aload #12
    //   167: invokestatic a : (Ljava/lang/Throwable;Ljava/io/PrintWriter;)V
    //   170: aload #9
    //   172: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   175: astore #9
    //   177: goto -> 158
    //   180: aload #12
    //   182: invokevirtual close : ()V
    //   185: aload #10
    //   187: invokevirtual toString : ()Ljava/lang/String;
    //   190: astore #9
    //   192: aload #11
    //   194: aload #9
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   199: pop
    //   200: aload #11
    //   202: invokevirtual toString : ()Ljava/lang/String;
    //   205: putstatic com/laiqian/crash/model/k.aNa : Ljava/lang/String;
    //   208: ldc 'crash'
    //   210: aload #9
    //   212: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   215: aload_0
    //   216: getfield aMT : Lcom/laiqian/crash/model/l;
    //   219: aload_0
    //   220: getfield mContext : Landroid/content/Context;
    //   223: invokevirtual U : (Landroid/content/Context;)Ljava/lang/String;
    //   226: astore #10
    //   228: aload_0
    //   229: getfield aMT : Lcom/laiqian/crash/model/l;
    //   232: aload_0
    //   233: getfield mContext : Landroid/content/Context;
    //   236: invokevirtual X : (Landroid/content/Context;)Ljava/lang/String;
    //   239: astore #12
    //   241: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   244: ldc 'mounted'
    //   246: invokevirtual equals : (Ljava/lang/Object;)Z
    //   249: ifeq -> 687
    //   252: new java/io/File
    //   255: dup
    //   256: aload #12
    //   258: invokespecial <init> : (Ljava/lang/String;)V
    //   261: astore #9
    //   263: aload #9
    //   265: invokevirtual exists : ()Z
    //   268: ifne -> 277
    //   271: aload #9
    //   273: invokevirtual mkdirs : ()Z
    //   276: pop
    //   277: aload #9
    //   279: invokevirtual exists : ()Z
    //   282: ifeq -> 687
    //   285: new java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial <init> : ()V
    //   292: astore #9
    //   294: aload #9
    //   296: aload #12
    //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload #9
    //   304: aload #10
    //   306: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: new java/io/FileOutputStream
    //   313: dup
    //   314: aload #9
    //   316: invokevirtual toString : ()Ljava/lang/String;
    //   319: invokespecial <init> : (Ljava/lang/String;)V
    //   322: astore #9
    //   324: aload #9
    //   326: aload #11
    //   328: invokevirtual toString : ()Ljava/lang/String;
    //   331: invokevirtual getBytes : ()[B
    //   334: invokevirtual write : ([B)V
    //   337: aload #9
    //   339: invokevirtual close : ()V
    //   342: aload_1
    //   343: instanceof android/database/sqlite/SQLiteException
    //   346: ifne -> 363
    //   349: aload #10
    //   351: astore #9
    //   353: aload_1
    //   354: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   357: instanceof android/database/sqlite/SQLiteException
    //   360: ifeq -> 669
    //   363: new java/io/File
    //   366: dup
    //   367: aload_0
    //   368: getfield mContext : Landroid/content/Context;
    //   371: invokevirtual getFilesDir : ()Ljava/io/File;
    //   374: ldc_w 'laiqian.db'
    //   377: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   380: astore_1
    //   381: aload_1
    //   382: invokevirtual exists : ()Z
    //   385: istore #4
    //   387: iload #4
    //   389: ifne -> 440
    //   392: new java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial <init> : ()V
    //   399: astore_1
    //   400: aload_1
    //   401: ldc_w '/data/data/'
    //   404: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload_1
    //   409: aload_0
    //   410: getfield mContext : Landroid/content/Context;
    //   413: invokevirtual getPackageName : ()Ljava/lang/String;
    //   416: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_1
    //   421: ldc_w '/laiqian.db'
    //   424: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: new java/io/File
    //   431: dup
    //   432: aload_1
    //   433: invokevirtual toString : ()Ljava/lang/String;
    //   436: invokespecial <init> : (Ljava/lang/String;)V
    //   439: astore_1
    //   440: invokestatic currentTimeMillis : ()J
    //   443: lstore #5
    //   445: aload_0
    //   446: getfield mContext : Landroid/content/Context;
    //   449: invokestatic bN : (Landroid/content/Context;)Ljava/io/File;
    //   452: astore #9
    //   454: invokestatic currentTimeMillis : ()J
    //   457: lstore #7
    //   459: new java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial <init> : ()V
    //   466: astore #11
    //   468: aload #11
    //   470: ldc_w '获取最新的备份包耗时：'
    //   473: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload #11
    //   479: lload #7
    //   481: lload #5
    //   483: lsub
    //   484: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload #11
    //   490: invokevirtual toString : ()Ljava/lang/String;
    //   493: invokestatic println : (Ljava/lang/Object;)V
    //   496: aload #9
    //   498: ifnull -> 553
    //   501: new java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial <init> : ()V
    //   508: astore #11
    //   510: aload #11
    //   512: aload #12
    //   514: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload #11
    //   520: aload #10
    //   522: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload #11
    //   528: ldc_w '.lqk2'
    //   531: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload #9
    //   537: new java/io/File
    //   540: dup
    //   541: aload #11
    //   543: invokevirtual toString : ()Ljava/lang/String;
    //   546: invokespecial <init> : (Ljava/lang/String;)V
    //   549: invokestatic d : (Ljava/io/File;Ljava/io/File;)Z
    //   552: pop
    //   553: new java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial <init> : ()V
    //   560: astore #9
    //   562: aload #9
    //   564: aload #12
    //   566: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload #9
    //   572: aload #10
    //   574: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload #9
    //   580: ldc_w '.lqk'
    //   583: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: new java/io/File
    //   590: dup
    //   591: aload #9
    //   593: invokevirtual toString : ()Ljava/lang/String;
    //   596: invokespecial <init> : (Ljava/lang/String;)V
    //   599: astore #9
    //   601: new com/laiqian/milestone/g
    //   604: dup
    //   605: aload_0
    //   606: getfield mContext : Landroid/content/Context;
    //   609: aload_1
    //   610: invokevirtual getPath : ()Ljava/lang/String;
    //   613: aload #9
    //   615: invokevirtual getPath : ()Ljava/lang/String;
    //   618: ldc ''
    //   620: getstatic com/laiqian/milestone/g.aQe : I
    //   623: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   626: getfield aQh : Z
    //   629: istore_3
    //   630: iload_3
    //   631: istore_2
    //   632: iload_3
    //   633: ifne -> 643
    //   636: aload_1
    //   637: aload #9
    //   639: invokestatic d : (Ljava/io/File;Ljava/io/File;)Z
    //   642: istore_2
    //   643: aload #10
    //   645: astore #9
    //   647: iload_2
    //   648: ifeq -> 669
    //   651: aload #10
    //   653: astore #9
    //   655: iload #4
    //   657: ifeq -> 669
    //   660: aload_1
    //   661: invokevirtual delete : ()Z
    //   664: pop
    //   665: aload #10
    //   667: astore #9
    //   669: aload #9
    //   671: areturn
    //   672: ldc ''
    //   674: astore #9
    //   676: goto -> 669
    //   679: ldc 'CrashHandler'
    //   681: ldc_w 'an error occured while writing file...'
    //   684: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   687: ldc ''
    //   689: areturn
    //   690: astore_1
    //   691: goto -> 679
    //   694: astore_1
    //   695: goto -> 672
    //   698: astore_1
    //   699: aload #10
    //   701: astore #9
    //   703: goto -> 669
    // Exception table:
    //   from	to	target	type
    //   215	277	690	java/lang/Exception
    //   277	342	694	java/io/FileNotFoundException
    //   277	342	694	java/io/IOException
    //   277	342	694	java/lang/Exception
    //   342	349	698	java/io/FileNotFoundException
    //   342	349	698	java/io/IOException
    //   342	349	698	java/lang/Exception
    //   353	363	698	java/io/FileNotFoundException
    //   353	363	698	java/io/IOException
    //   353	363	698	java/lang/Exception
    //   363	387	698	java/io/FileNotFoundException
    //   363	387	698	java/io/IOException
    //   363	387	698	java/lang/Exception
    //   392	440	698	java/io/FileNotFoundException
    //   392	440	698	java/io/IOException
    //   392	440	698	java/lang/Exception
    //   440	496	698	java/io/FileNotFoundException
    //   440	496	698	java/io/IOException
    //   440	496	698	java/lang/Exception
    //   501	553	698	java/io/FileNotFoundException
    //   501	553	698	java/io/IOException
    //   501	553	698	java/lang/Exception
    //   553	630	698	java/io/FileNotFoundException
    //   553	630	698	java/io/IOException
    //   553	630	698	java/lang/Exception
    //   636	643	698	java/io/FileNotFoundException
    //   636	643	698	java/io/IOException
    //   636	643	698	java/lang/Exception
    //   660	665	698	java/io/FileNotFoundException
    //   660	665	698	java/io/IOException
    //   660	665	698	java/lang/Exception }
  
  public boolean T(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 1);
      if (packageInfo != null) {
        String str1;
        if (packageInfo.versionName == null) {
          str1 = "null";
        } else {
          str1 = packageInfo.versionName;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(packageInfo.versionCode);
        stringBuilder.append("");
        String str2 = stringBuilder.toString();
        this.aNd.put("versionName", str1);
        this.aNd.put("versionCode", str2);
        this.aNd.put("brand", Build.BRAND);
        this.aNd.put("model", Build.MODEL);
        this.aNd.put("release", Build.VERSION.RELEASE);
      } 
      Field[] arrayOfField = Build.class.getDeclaredFields();
      if (arrayOfField.length > 0) {
        field = arrayOfField[0];
        try {
          field.setAccessible(true);
          this.aNd.put(field.getName(), field.get(null).toString());
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(field.getName());
          stringBuilder.append(" : ");
          stringBuilder.append(field.get(null));
          bb.f("CrashHandler", stringBuilder.toString());
          return true;
        } catch (Exception field) {
          bb.e("CrashHandler", "an error occured when collect crash info");
          return false;
        } 
      } 
      return true;
    } catch (android.content.pm.PackageManager.NameNotFoundException paramContext) {
      return false;
    } 
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, long paramLong) {
    i = 0;
    b = 0;
    try {
    
    } catch (Exception paramContext) {
    
    } finally {
      paramContext = null;
      if (paramContext != null)
        paramContext.close(); 
    } 
    if (paramContext != null) {
      i = b;
      paramContext.close();
      return i;
    } 
    return i;
  }
  
  public void init(Context paramContext) {
    this.mContext = paramContext;
    this.aNb = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    if (!h(paramThrowable) && this.aNb != null) {
      this.aNb.uncaughtException(paramThread, paramThrowable);
      return;
    } 
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException paramThread) {
      bb.e("CrashHandler", "error : ");
    } 
    Process.killProcess(Process.myPid());
    System.exit(0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\model\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */