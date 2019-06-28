package com.laiqian.auth;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.db.d;
import com.laiqian.util.av;

public class cj extends d {
  public static int aGx = 150001;
  
  public static int aGy = 150003;
  
  public static int aGz = 90025;
  
  private String aDZ;
  
  private String aGA;
  
  private String aGB;
  
  final String aGC = "sClassName";
  
  private Context mContext;
  
  static  {
  
  }
  
  public cj(Context paramContext) {
    super(paramContext);
    this.mContext = paramContext;
    av av = new av(this.mContext);
    this.aGA = av.Tx();
    this.aDZ = av.atm();
    this.aGB = av.atp();
    av.close();
  }
  
  public boolean F(long paramLong) {
    Context context;
    try {
      this.bJQ.beginTransaction();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("update t_role set sIsActive='N',nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+10000 end,nIsUpdated=0  where _id = ");
      stringBuilder2.append(paramLong);
      stringBuilder2.append(" and nShopID=");
      stringBuilder2.append(this.bKd);
      stringBuilder2.append(" ;");
      String str = stringBuilder2.toString();
      this.bJQ.execSQL(str);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("update t_user set nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end,nIsUpdated=0, nUserRole=150003 where nShopID=");
      stringBuilder1.append(this.bKd);
      stringBuilder1.append(" and nUserRole=");
      stringBuilder1.append(paramLong);
      context = stringBuilder1.toString();
      this.bJQ.execSQL(context);
      this.bJQ.setTransactionSuccessful();
      this.bJQ.endTransaction();
      return true;
    } catch (SQLException null) {
      a.e(context);
      this.bJQ.endTransaction();
      return false;
    } finally {}
    this.bJQ.endTransaction();
    throw context;
  }
  
  public boolean a(String paramString1, String paramString2, Boolean[] paramArrayOfBoolean, boolean paramBoolean) { // Byte code:
    //   0: aload_0
    //   1: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   4: invokevirtual beginTransaction : ()V
    //   7: iload #4
    //   9: ifeq -> 534
    //   12: aload_1
    //   13: ifnonnull -> 531
    //   16: new java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore_1
    //   24: aload_1
    //   25: aload_0
    //   26: invokevirtual Di : ()J
    //   29: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: ldc ''
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual toString : ()Ljava/lang/String;
    //   44: astore_1
    //   45: goto -> 48
    //   48: new java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: astore #8
    //   57: aload #8
    //   59: ldc 'insert into t_role(_id, nShopID, nUserID, nUpdateFlag,sRoleName, sIsActive,nIsUpdated) values(''
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload #8
    //   67: aload_1
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload #8
    //   74: ldc '',''
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload #8
    //   82: aload_0
    //   83: getfield bKd : J
    //   86: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload #8
    //   92: ldc '',''
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload #8
    //   100: aload_0
    //   101: getfield bKe : J
    //   104: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload #8
    //   110: ldc '',''
    //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload #8
    //   118: iconst_0
    //   119: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload #8
    //   125: ldc '',?,'Y',0);'
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload #8
    //   133: invokevirtual toString : ()Ljava/lang/String;
    //   136: astore #8
    //   138: aload_0
    //   139: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   142: aload #8
    //   144: iconst_1
    //   145: anewarray java/lang/String
    //   148: dup
    //   149: iconst_0
    //   150: aload_2
    //   151: aastore
    //   152: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: goto -> 158
    //   158: aload_0
    //   159: getfield mContext : Landroid/content/Context;
    //   162: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   165: aload_0
    //   166: getfield mContext : Landroid/content/Context;
    //   169: invokevirtual getPackageName : ()Ljava/lang/String;
    //   172: iconst_0
    //   173: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   176: getfield versionName : Ljava/lang/String;
    //   179: astore #8
    //   181: new java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial <init> : ()V
    //   188: astore_2
    //   189: aload_2
    //   190: aload_0
    //   191: getfield mContext : Landroid/content/Context;
    //   194: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   197: aload_0
    //   198: getfield mContext : Landroid/content/Context;
    //   201: invokevirtual getPackageName : ()Ljava/lang/String;
    //   204: iconst_0
    //   205: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   208: getfield versionCode : I
    //   211: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_2
    //   216: ldc ''
    //   218: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_2
    //   223: invokevirtual toString : ()Ljava/lang/String;
    //   226: astore #10
    //   228: getstatic com/laiqian/pos/industry/a.crg : Ljava/lang/String;
    //   231: astore #11
    //   233: invokestatic currentTimeMillis : ()J
    //   236: lstore #6
    //   238: aload_0
    //   239: invokevirtual yM : ()Landroid/database/Cursor;
    //   242: astore_2
    //   243: iconst_0
    //   244: istore #5
    //   246: aload_2
    //   247: invokeinterface moveToNext : ()Z
    //   252: ifeq -> 482
    //   255: aload_3
    //   256: iload #5
    //   258: aaload
    //   259: invokevirtual booleanValue : ()Z
    //   262: ifeq -> 537
    //   265: ldc 'Y'
    //   267: astore #9
    //   269: goto -> 272
    //   272: aload_2
    //   273: iconst_0
    //   274: invokeinterface getString : (I)Ljava/lang/String;
    //   279: astore #12
    //   281: aload_2
    //   282: iconst_1
    //   283: invokeinterface getString : (I)Ljava/lang/String;
    //   288: astore #13
    //   290: aload_0
    //   291: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   294: astore #14
    //   296: new java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial <init> : ()V
    //   303: astore #15
    //   305: aload #15
    //   307: lload #6
    //   309: iload #5
    //   311: i2l
    //   312: ladd
    //   313: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload #15
    //   319: ldc ''
    //   321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload #15
    //   327: invokevirtual toString : ()Ljava/lang/String;
    //   330: astore #15
    //   332: new java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial <init> : ()V
    //   339: astore #16
    //   341: aload #16
    //   343: aload_0
    //   344: getfield bKd : J
    //   347: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload #16
    //   353: ldc ''
    //   355: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload #16
    //   361: invokevirtual toString : ()Ljava/lang/String;
    //   364: astore #16
    //   366: new java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial <init> : ()V
    //   373: astore #17
    //   375: aload #17
    //   377: aload_0
    //   378: getfield bKe : J
    //   381: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload #17
    //   387: ldc ''
    //   389: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload #14
    //   395: ldc 'insert into T_WINDOW_ACCESS (_id, nShopID, nUserID,nWindowID,nSortNo, nUpdateFlag, sIsActive,fVersion,sWindowType,sDbTemplateID,nUserRole,nIsUpdated) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)'
    //   397: bipush #12
    //   399: anewarray java/lang/String
    //   402: dup
    //   403: iconst_0
    //   404: aload #15
    //   406: aastore
    //   407: dup
    //   408: iconst_1
    //   409: aload #16
    //   411: aastore
    //   412: dup
    //   413: iconst_2
    //   414: aload #17
    //   416: invokevirtual toString : ()Ljava/lang/String;
    //   419: aastore
    //   420: dup
    //   421: iconst_3
    //   422: aload #12
    //   424: aastore
    //   425: dup
    //   426: iconst_4
    //   427: aload #13
    //   429: aastore
    //   430: dup
    //   431: iconst_5
    //   432: aload #10
    //   434: aastore
    //   435: dup
    //   436: bipush #6
    //   438: aload #9
    //   440: aastore
    //   441: dup
    //   442: bipush #7
    //   444: aload #8
    //   446: aastore
    //   447: dup
    //   448: bipush #8
    //   450: ldc 'module'
    //   452: aastore
    //   453: dup
    //   454: bipush #9
    //   456: aload #11
    //   458: aastore
    //   459: dup
    //   460: bipush #10
    //   462: aload_1
    //   463: aastore
    //   464: dup
    //   465: bipush #11
    //   467: ldc '0'
    //   469: aastore
    //   470: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   473: iload #5
    //   475: iconst_1
    //   476: iadd
    //   477: istore #5
    //   479: goto -> 246
    //   482: aload_2
    //   483: invokeinterface close : ()V
    //   488: aload_0
    //   489: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   492: invokevirtual setTransactionSuccessful : ()V
    //   495: aload_0
    //   496: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   499: invokevirtual endTransaction : ()V
    //   502: iconst_1
    //   503: ireturn
    //   504: astore_1
    //   505: goto -> 522
    //   508: astore_1
    //   509: aload_1
    //   510: invokestatic e : (Ljava/lang/Throwable;)V
    //   513: aload_0
    //   514: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   517: invokevirtual endTransaction : ()V
    //   520: iconst_0
    //   521: ireturn
    //   522: aload_0
    //   523: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   526: invokevirtual endTransaction : ()V
    //   529: aload_1
    //   530: athrow
    //   531: goto -> 48
    //   534: goto -> 158
    //   537: ldc 'N'
    //   539: astore #9
    //   541: goto -> 272
    // Exception table:
    //   from	to	target	type
    //   16	45	508	java/lang/Exception
    //   16	45	504	finally
    //   48	155	508	java/lang/Exception
    //   48	155	504	finally
    //   158	243	508	java/lang/Exception
    //   158	243	504	finally
    //   246	265	508	java/lang/Exception
    //   246	265	504	finally
    //   272	473	508	java/lang/Exception
    //   272	473	504	finally
    //   482	495	508	java/lang/Exception
    //   482	495	504	finally
    //   509	513	504	finally }
  
  public boolean a(String paramString1, String paramString2, Boolean[] paramArrayOfBoolean, boolean paramBoolean1, boolean paramBoolean2) { // Byte code:
    //   0: aload_0
    //   1: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   4: invokevirtual beginTransaction : ()V
    //   7: iload #4
    //   9: ifeq -> 75
    //   12: aload_0
    //   13: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore #8
    //   18: new java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore #9
    //   27: aload #9
    //   29: aload_0
    //   30: getfield bKd : J
    //   33: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload #9
    //   39: ldc ''
    //   41: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload #8
    //   47: ldc 'update t_role set nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end, sRoleName=?, nIsUpdated=0 where _id=? and nShopID=?;'
    //   49: iconst_3
    //   50: anewarray java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_2
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: aload_1
    //   60: aastore
    //   61: dup
    //   62: iconst_2
    //   63: aload #9
    //   65: invokevirtual toString : ()Ljava/lang/String;
    //   68: aastore
    //   69: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: goto -> 75
    //   75: aload_0
    //   76: getfield mContext : Landroid/content/Context;
    //   79: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   82: aload_0
    //   83: getfield mContext : Landroid/content/Context;
    //   86: invokevirtual getPackageName : ()Ljava/lang/String;
    //   89: iconst_0
    //   90: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   93: getfield versionCode : I
    //   96: istore #7
    //   98: aload_0
    //   99: getfield mContext : Landroid/content/Context;
    //   102: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   105: aload_0
    //   106: getfield mContext : Landroid/content/Context;
    //   109: invokevirtual getPackageName : ()Ljava/lang/String;
    //   112: iconst_0
    //   113: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   116: getfield versionName : Ljava/lang/String;
    //   119: astore #10
    //   121: getstatic com/laiqian/pos/industry/a.crg : Ljava/lang/String;
    //   124: astore #11
    //   126: aload_0
    //   127: invokevirtual yM : ()Landroid/database/Cursor;
    //   130: astore #8
    //   132: aload_0
    //   133: aload_1
    //   134: iload #5
    //   136: invokevirtual c : (Ljava/lang/String;Z)Ljava/lang/String;
    //   139: astore_2
    //   140: iconst_0
    //   141: istore #6
    //   143: aload #8
    //   145: invokeinterface moveToNext : ()Z
    //   150: ifeq -> 533
    //   153: aload_3
    //   154: arraylength
    //   155: iload #6
    //   157: if_icmpne -> 163
    //   160: goto -> 533
    //   163: aload #8
    //   165: iconst_0
    //   166: invokeinterface getString : (I)Ljava/lang/String;
    //   171: astore #12
    //   173: aload_3
    //   174: iload #6
    //   176: aaload
    //   177: invokevirtual booleanValue : ()Z
    //   180: ifeq -> 586
    //   183: ldc 'Y'
    //   185: astore #9
    //   187: goto -> 190
    //   190: aload_2
    //   191: aload #12
    //   193: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   196: ifeq -> 308
    //   199: new java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial <init> : ()V
    //   206: astore #13
    //   208: aload #13
    //   210: ldc 'update T_WINDOW_ACCESS set nUpdateFlag= case when nUpdateFlag is null then '
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload #13
    //   218: iload #7
    //   220: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload #13
    //   226: ldc ' else nUpdateFlag+2 end, sIsActive=?, nIsUpdated=0 where nWindowID=? and nShopID=? and nUserRole=? ;'
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload #13
    //   234: invokevirtual toString : ()Ljava/lang/String;
    //   237: astore #13
    //   239: new java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial <init> : ()V
    //   246: astore #14
    //   248: aload #14
    //   250: aload_0
    //   251: getfield bKd : J
    //   254: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload #14
    //   260: ldc ''
    //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload #14
    //   268: invokevirtual toString : ()Ljava/lang/String;
    //   271: astore #14
    //   273: aload_0
    //   274: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   277: aload #13
    //   279: iconst_4
    //   280: anewarray java/lang/String
    //   283: dup
    //   284: iconst_0
    //   285: aload #9
    //   287: aastore
    //   288: dup
    //   289: iconst_1
    //   290: aload #12
    //   292: aastore
    //   293: dup
    //   294: iconst_2
    //   295: aload #14
    //   297: aastore
    //   298: dup
    //   299: iconst_3
    //   300: aload_1
    //   301: aastore
    //   302: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: goto -> 593
    //   308: aload #8
    //   310: iconst_1
    //   311: invokeinterface getString : (I)Ljava/lang/String;
    //   316: astore #13
    //   318: aload_0
    //   319: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   322: astore #14
    //   324: new java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial <init> : ()V
    //   331: astore #15
    //   333: aload #15
    //   335: invokestatic currentTimeMillis : ()J
    //   338: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload #15
    //   344: ldc ''
    //   346: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload #15
    //   352: invokevirtual toString : ()Ljava/lang/String;
    //   355: astore #15
    //   357: new java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial <init> : ()V
    //   364: astore #16
    //   366: aload #16
    //   368: aload_0
    //   369: getfield bKd : J
    //   372: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload #16
    //   378: ldc ''
    //   380: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload #16
    //   386: invokevirtual toString : ()Ljava/lang/String;
    //   389: astore #16
    //   391: new java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial <init> : ()V
    //   398: astore #17
    //   400: aload #17
    //   402: aload_0
    //   403: getfield bKe : J
    //   406: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload #17
    //   412: ldc ''
    //   414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload #17
    //   420: invokevirtual toString : ()Ljava/lang/String;
    //   423: astore #17
    //   425: new java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial <init> : ()V
    //   432: astore #18
    //   434: aload #18
    //   436: iload #7
    //   438: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload #18
    //   444: ldc ''
    //   446: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload #14
    //   452: ldc 'insert into T_WINDOW_ACCESS (_id, nShopID, nUserID,nWindowID,nSortNo, nUpdateFlag, sIsActive,fVersion,sWindowType,sDbTemplateID,nUserRole,nIsUpdated) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)'
    //   454: bipush #12
    //   456: anewarray java/lang/String
    //   459: dup
    //   460: iconst_0
    //   461: aload #15
    //   463: aastore
    //   464: dup
    //   465: iconst_1
    //   466: aload #16
    //   468: aastore
    //   469: dup
    //   470: iconst_2
    //   471: aload #17
    //   473: aastore
    //   474: dup
    //   475: iconst_3
    //   476: aload #12
    //   478: aastore
    //   479: dup
    //   480: iconst_4
    //   481: aload #13
    //   483: aastore
    //   484: dup
    //   485: iconst_5
    //   486: aload #18
    //   488: invokevirtual toString : ()Ljava/lang/String;
    //   491: aastore
    //   492: dup
    //   493: bipush #6
    //   495: aload #9
    //   497: aastore
    //   498: dup
    //   499: bipush #7
    //   501: aload #10
    //   503: aastore
    //   504: dup
    //   505: bipush #8
    //   507: ldc 'module'
    //   509: aastore
    //   510: dup
    //   511: bipush #9
    //   513: aload #11
    //   515: aastore
    //   516: dup
    //   517: bipush #10
    //   519: aload_1
    //   520: aastore
    //   521: dup
    //   522: bipush #11
    //   524: ldc '0'
    //   526: aastore
    //   527: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   530: goto -> 593
    //   533: aload #8
    //   535: invokeinterface close : ()V
    //   540: aload_0
    //   541: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   544: invokevirtual setTransactionSuccessful : ()V
    //   547: aload_0
    //   548: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   551: invokevirtual endTransaction : ()V
    //   554: iconst_1
    //   555: ireturn
    //   556: aload_1
    //   557: invokestatic e : (Ljava/lang/Throwable;)V
    //   560: aload_0
    //   561: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   564: invokevirtual endTransaction : ()V
    //   567: iconst_0
    //   568: ireturn
    //   569: aload_0
    //   570: getfield bJQ : Landroid/database/sqlite/SQLiteDatabase;
    //   573: invokevirtual endTransaction : ()V
    //   576: aload_1
    //   577: athrow
    //   578: astore_1
    //   579: goto -> 569
    //   582: astore_1
    //   583: goto -> 556
    //   586: ldc 'N'
    //   588: astore #9
    //   590: goto -> 190
    //   593: iload #6
    //   595: iconst_1
    //   596: iadd
    //   597: istore #6
    //   599: goto -> 143
    // Exception table:
    //   from	to	target	type
    //   12	72	582	java/lang/Exception
    //   12	72	578	finally
    //   75	140	582	java/lang/Exception
    //   75	140	578	finally
    //   143	160	582	java/lang/Exception
    //   143	160	578	finally
    //   163	183	582	java/lang/Exception
    //   163	183	578	finally
    //   190	305	582	java/lang/Exception
    //   190	305	578	finally
    //   308	530	582	java/lang/Exception
    //   308	530	578	finally
    //   533	547	582	java/lang/Exception
    //   533	547	578	finally
    //   556	560	578	finally }
  
  public boolean b(String paramString1, String paramString2, Boolean[] paramArrayOfBoolean, boolean paramBoolean) { return a(paramString1, paramString2, paramArrayOfBoolean, paramBoolean, true); }
  
  public boolean bA(String paramString) {
    SQLiteDatabase sQLiteDatabase = this.bJQ;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.aGA);
    stringBuilder.append("");
    String str = stringBuilder.toString();
    byte b = 1;
    Cursor cursor = sQLiteDatabase.rawQuery("select sIsActive from T_ROLE where nShopID = ? and nUserID = ? and sText = 150003 and sRoleName = 90021", new String[] { str, paramString });
    int i = b;
    if (cursor.moveToFirst())
      if (cursor.getString(0).equals("Y")) {
        i = b;
      } else {
        i = 0;
      }  
    cursor.close();
    return i;
  }
  
  public boolean bv(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bKd);
    stringBuilder.append("");
    String str = stringBuilder.toString();
    Cursor cursor = this.bJQ.rawQuery("SELECT [T_WINDOW_ACCESS].*  FROM [T_WINDOW_ACCESS] WHERE [T_WINDOW_ACCESS].[nUserRole] =  ? and ([T_WINDOW_ACCESS].[nShopID] is null or [T_WINDOW_ACCESS].[nShopID]=?) and sWindowType='module';", new String[] { paramString, str });
    int i = cursor.getCount();
    cursor.close();
    return (i > 0);
  }
  
  public String bw(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bKd);
    stringBuilder.append("");
    String str = stringBuilder.toString();
    Cursor cursor = this.bJQ.rawQuery("SELECT group_concat([T_WINDOW_ACCESS].nWindowID) as nWindowIDs  FROM [T_WINDOW_ACCESS] join [T_WINDOW] on [T_WINDOW]._id=[T_WINDOW_ACCESS].nWindowID WHERE [T_WINDOW_ACCESS].[nUserRole] =  ? and ([T_WINDOW_ACCESS].[nShopID] is null or [T_WINDOW_ACCESS].[nShopID]=?) and [T_WINDOW_ACCESS].sIsActive='Y' and [T_WINDOW_ACCESS].sWindowType='module' group by nUserRole ;", new String[] { paramString, str });
    paramString = "";
    str = paramString;
    if (cursor != null) {
      if (cursor.moveToFirst())
        paramString = cursor.getString(0); 
      cursor.close();
      str = paramString;
    } 
    return str;
  }
  
  public Cursor bx(String paramString) {
    SQLiteDatabase sQLiteDatabase = this.bJQ;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bKd);
    stringBuilder.append("");
    return sQLiteDatabase.rawQuery("select * from t_role  where sRoleName = ? and sIsActive='Y' and (nShopID is null or nShopID=?) and _id <> 150002 ;", new String[] { paramString, stringBuilder.toString() });
  }
  
  public boolean by(String paramString) {
    Cursor cursor = bx(paramString);
    boolean bool = false;
    if (cursor != null) {
      int i = cursor.getCount();
      cursor.close();
      if (i > 0)
        bool = true; 
      return bool;
    } 
    return false;
  }
  
  public String bz(String paramString) { return d(paramString, true); }
  
  public String c(String paramString, boolean paramBoolean) {
    null = new StringBuilder();
    null.append("SELECT group_concat([T_WINDOW_ACCESS].nWindowID) as nWindowIDs  FROM [T_WINDOW_ACCESS] join [T_WINDOW] on [T_WINDOW]._id=[T_WINDOW_ACCESS].nWindowID WHERE [T_WINDOW_ACCESS].[nUserRole] =  ? and (");
    if (paramBoolean) {
      str = "[T_WINDOW_ACCESS].[nShopID] is null or";
    } else {
      str = "";
    } 
    null.append(str);
    null.append(" [T_WINDOW_ACCESS].[nShopID]=?) and [T_WINDOW_ACCESS].sWindowType='module' group by nUserRole ;");
    String str = null.toString();
    null = new StringBuilder();
    null.append(this.bKd);
    null.append("");
    null = null.toString();
    Cursor cursor = this.bJQ.rawQuery(str, new String[] { paramString, null });
    paramString = "";
    str = paramString;
    if (cursor != null) {
      if (cursor.moveToFirst())
        paramString = cursor.getString(0); 
      cursor.close();
      str = paramString;
    } 
    return str;
  }
  
  public String d(String paramString, boolean paramBoolean) {
    String str = new StringBuilder();
    str.append(this.bKd);
    str.append("");
    null = str.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select group_concat(sRoleName) from T_ROLE where nShopID=? and nUserID=? and sText=150003");
    if (paramBoolean) {
      String str1 = " and sIsActive='Y'";
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    str = stringBuilder.toString();
    Cursor cursor = this.bJQ.rawQuery(str, new String[] { null, paramString });
    str = "";
    paramString = str;
    if (cursor != null) {
      paramString = str;
      if (cursor.moveToFirst())
        paramString = cursor.getString(0); 
      cursor.close();
    } 
    str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  public boolean dP(int paramInt) { return this.aGB.equals("150001") ? true : bz((new av(this.context)).atm()).contains(String.valueOf(paramInt)); }
  
  public boolean l(String paramString1, String paramString2, String paramString3) {
    try {
      String str = d(paramString1, false);
      if (str != null && str.contains(paramString2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update T_ROLE set sIsActive='");
        stringBuilder.append(paramString3);
        stringBuilder.append("',nIsUpdated=0,nUpdateFlag=case when nUpdateFlag is null then 2   when nUpdateFlag=0 then 2  else nUpdateFlag+2 end   where sText=150003 and nShopID=");
        stringBuilder.append(this.bKd);
        stringBuilder.append(" and nUserID=");
        stringBuilder.append(paramString1);
        stringBuilder.append(" and sRoleName=");
        stringBuilder.append(paramString2);
        paramString1 = stringBuilder.toString();
      } else {
        long l = Di();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into T_ROLE(_id,nShopID,nUserID,sText,sIsActive,sRoleName,nIsUpdated) values(");
        stringBuilder.append(l);
        stringBuilder.append(",");
        stringBuilder.append(this.bKd);
        stringBuilder.append(",");
        stringBuilder.append(paramString1);
        stringBuilder.append(",150003,'");
        stringBuilder.append(paramString3);
        stringBuilder.append("',");
        stringBuilder.append(paramString2);
        stringBuilder.append(",0)");
        paramString1 = stringBuilder.toString();
      } 
      this.bJQ.execSQL(paramString1);
      return true;
    } catch (Exception paramString1) {
      return false;
    } 
  }
  
  public Cursor yL() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bKd);
    stringBuilder.append("");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery("SELECT * from t_role where nShopID=? and sIsActive='Y'", new String[] { str });
  }
  
  public Cursor yM() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bKd);
    stringBuilder.append("");
    String str = stringBuilder.toString();
    return this.bJQ.rawQuery("SELECT _id,nSortNo  FROM [T_WINDOW] WHERE  ([T_WINDOW].[nShopID] is null or [T_WINDOW].[nShopID]=?) and sIsActive='Y' and sWindowType='module' order by nSortNo ;", new String[] { str });
  }
  
  public boolean yN() { return this.aGB.equals("150001") ? true : bA(this.aDZ); }
  
  public Boolean[] yO() {
    av av = new av(this.mContext);
    String str2 = av.atp();
    String str3 = av.atm();
    av.close();
    if (LQKVersion.zl()) {
      if ("150001".equals(str2))
        return new Boolean[] { null, null, null, null, null, null, null, null, (new Boolean[9][7] = (new Boolean[9][6] = (new Boolean[9][5] = (new Boolean[9][4] = (new Boolean[9][3] = (new Boolean[9][2] = (new Boolean[9][1] = (new Boolean[9][0] = Boolean.valueOf(true)).valueOf(true)).valueOf(true)).valueOf(true)).valueOf(true)).valueOf(true)).valueOf(true)).valueOf(true)).valueOf(true) }; 
      String str = d(str3, true);
      return (str == null) ? new Boolean[] { null, null, null, null, null, null, null, null, (new Boolean[9][7] = (new Boolean[9][6] = (new Boolean[9][5] = (new Boolean[9][4] = (new Boolean[9][3] = (new Boolean[9][2] = (new Boolean[9][1] = (new Boolean[9][0] = Boolean.valueOf(false)).valueOf(false)).valueOf(false)).valueOf(false)).valueOf(false)).valueOf(false)).valueOf(false)).valueOf(false)).valueOf(false) } : new Boolean[] { null, null, null, null, null, null, null, null, (new Boolean[9][7] = (new Boolean[9][6] = (new Boolean[9][5] = (new Boolean[9][4] = (new Boolean[9][3] = (new Boolean[9][2] = (new Boolean[9][1] = (new Boolean[9][0] = Boolean.valueOf(str.contains("90001"))).valueOf(str.contains("90004"))).valueOf(str.contains("90020"))).valueOf(str.contains("90022"))).valueOf(str.contains("90025"))).valueOf(str.contains("90026"))).valueOf(str.contains("90015"))).valueOf(str.contains("90027"))).valueOf(str.contains("90031")) };
    } 
    if ("150001".equals(str2))
      return new Boolean[] { null, null, (new Boolean[3][1] = (new Boolean[3][0] = Boolean.valueOf(true)).valueOf(true)).valueOf(true) }; 
    String str1 = d(str3, true);
    return (str1 == null) ? new Boolean[] { null, null, (new Boolean[3][1] = (new Boolean[3][0] = Boolean.valueOf(false)).valueOf(false)).valueOf(false) } : new Boolean[] { null, null, (new Boolean[3][1] = (new Boolean[3][0] = Boolean.valueOf(str1.contains("90001"))).valueOf(str1.contains("90004"))).valueOf(str1.contains("90020")) };
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */