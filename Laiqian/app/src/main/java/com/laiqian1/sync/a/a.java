package com.laiqian.sync.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.alibaba.a.a.d.b;
import com.alibaba.a.a.d.e;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.a;
import com.laiqian.dcb.api.b.a.b;
import com.laiqian.f.c;
import com.laiqian.f.d;
import com.laiqian.message.m;
import com.laiqian.milestone.h;
import com.laiqian.network.a;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.sync.a;
import com.laiqian.sync.b.b;
import com.laiqian.sync.c.b;
import com.laiqian.sync.model.i;
import com.laiqian.util.ab;
import com.laiqian.util.av;
import com.laiqian.util.l;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.orhanobut.logger.d;
import hugo.weaving.DebugLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private static final String TAG = "a";
  
  @SuppressLint({"StaticFieldLeak"})
  public static final a dob = new a();
  
  private final String aQt = "lq";
  
  private final String aQu = "unzipped";
  
  private List<l> bIT = new ArrayList();
  
  private final int bXR = 100;
  
  private Context context = RootApplication.zv();
  
  private boolean debug = RootUrlParameter.bDebug;
  
  private final String dnX = "laiqian.db";
  
  private final String dnY = "upload.db";
  
  private final String dnZ = "zipped";
  
  private final String doa;
  
  private final Map<String, a> doc = new LinkedHashMap();
  
  private final List<String> dod = new ArrayList();
  
  private final Map<String, b> doe = new HashMap();
  
  private a() {
    int i = RootUrlParameter.ckK;
    if (i != 9)
      switch (i) {
        default:
          this.doa = "91laiqian-oss-upload";
          return;
        case 4:
        case 5:
          break;
      }  
    this.doa = "91laiqian-singapore";
  }
  
  @DebugLog
  private void E(File paramFile) throws f {
    if (this.debug) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("applyDownloadedFile: ");
      stringBuilder.append(paramFile.getName());
      Log.d(str, stringBuilder.toString());
      F(paramFile);
    } 
    b b = new b(this.context);
    boolean bool = b.d(0L, System.currentTimeMillis(), paramFile.getAbsolutePath());
    b.close();
    if (bool) {
      Iterator iterator = this.bIT.iterator();
      while (iterator.hasNext())
        ((l)iterator.next()).onSuccess(); 
      return;
    } 
    h.a(new d(getClass().getName(), "applyDownloadedFile", "error updating local database", "failed"), h.a.dHv, h.b.dHC);
    throw new f("error updating local database");
  }
  
  private void F(File paramFile) throws f { nP(paramFile.getPath()); }
  
  private static void S(List<String> paramList) {
    for (String str : paramList)
      Log.d(TAG, str); 
  }
  
  private List<String> a(b paramb) {
    ArrayList arrayList = new ArrayList();
    for (String str : b.b(paramb)) {
      if (nM(str))
        arrayList.add(str); 
    } 
    return arrayList;
  }
  
  private void a(b paramb, long paramLong1, long paramLong2, String... paramVarArgs) throws f { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload #6
    //   4: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   7: astore #8
    //   9: new com/laiqian/sync/b/a
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #6
    //   18: aload #6
    //   20: aload_0
    //   21: getfield context : Landroid/content/Context;
    //   24: aload #8
    //   26: invokevirtual b : (Landroid/content/Context;Ljava/util/Collection;)Ljava/io/File;
    //   29: astore #6
    //   31: aload_0
    //   32: getfield debug : Z
    //   35: ifeq -> 89
    //   38: getstatic com/laiqian/sync/a/a.TAG : Ljava/lang/String;
    //   41: astore #9
    //   43: new java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial <init> : ()V
    //   50: astore #10
    //   52: aload #10
    //   54: ldc_w 'requestIncrementalDownload: '
    //   57: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload #10
    //   63: aload #6
    //   65: invokevirtual getName : ()Ljava/lang/String;
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload #9
    //   74: aload #10
    //   76: invokevirtual toString : ()Ljava/lang/String;
    //   79: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: aload_0
    //   84: aload #6
    //   86: invokespecial F : (Ljava/io/File;)V
    //   89: aload #6
    //   91: invokevirtual getParent : ()Ljava/lang/String;
    //   94: astore #9
    //   96: new java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: astore #10
    //   105: aload #10
    //   107: aload #6
    //   109: invokevirtual getName : ()Ljava/lang/String;
    //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload #10
    //   118: ldc_w '.'
    //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload #10
    //   127: ldc 'zipped'
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: new java/io/File
    //   136: dup
    //   137: aload #9
    //   139: aload #10
    //   141: invokevirtual toString : ()Ljava/lang/String;
    //   144: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   147: astore #10
    //   149: new com/laiqian/sync/c/b
    //   152: dup
    //   153: aload_0
    //   154: getfield context : Landroid/content/Context;
    //   157: aload #6
    //   159: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   162: aload #10
    //   164: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   167: getstatic com/laiqian/sync/c/b.aQg : I
    //   170: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   173: getfield aQh : Z
    //   176: ifne -> 222
    //   179: new com/laiqian/util/logger/d
    //   182: dup
    //   183: aload_0
    //   184: invokevirtual getClass : ()Ljava/lang/Class;
    //   187: invokevirtual getName : ()Ljava/lang/String;
    //   190: ldc_w 'requestIncrementalDownload'
    //   193: ldc_w 'error compressing file'
    //   196: ldc_w 'error compressing file'
    //   199: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   202: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   205: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   208: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   211: new java/lang/Exception
    //   214: dup
    //   215: ldc_w 'error compressing file'
    //   218: invokespecial <init> : (Ljava/lang/String;)V
    //   221: athrow
    //   222: aload #6
    //   224: invokevirtual delete : ()Z
    //   227: pop
    //   228: new java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial <init> : ()V
    //   235: astore #9
    //   237: aload #9
    //   239: aload #6
    //   241: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload #9
    //   250: ldc_w '-journal'
    //   253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: new java/io/File
    //   260: dup
    //   261: aload #9
    //   263: invokevirtual toString : ()Ljava/lang/String;
    //   266: invokespecial <init> : (Ljava/lang/String;)V
    //   269: astore #9
    //   271: aload #9
    //   273: invokevirtual exists : ()Z
    //   276: ifeq -> 285
    //   279: aload #9
    //   281: invokevirtual delete : ()Z
    //   284: pop
    //   285: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   288: invokevirtual atm : ()Ljava/lang/String;
    //   291: astore #11
    //   293: aload #11
    //   295: invokestatic parseLong : (Ljava/lang/String;)J
    //   298: invokestatic dj : (J)Ljava/lang/String;
    //   301: astore #12
    //   303: aload #10
    //   305: invokevirtual getParent : ()Ljava/lang/String;
    //   308: astore #9
    //   310: new java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial <init> : ()V
    //   317: astore #13
    //   319: aload #13
    //   321: aload #10
    //   323: invokevirtual getName : ()Ljava/lang/String;
    //   326: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload #13
    //   332: ldc_w '.'
    //   335: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload #13
    //   341: ldc 'lq'
    //   343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: new java/io/File
    //   350: dup
    //   351: aload #9
    //   353: aload #13
    //   355: invokevirtual toString : ()Ljava/lang/String;
    //   358: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   361: astore #9
    //   363: aload #10
    //   365: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   368: aload #9
    //   370: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   373: aload #11
    //   375: aload #12
    //   377: invokestatic D : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   380: invokestatic n : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   383: istore #7
    //   385: aload #10
    //   387: invokevirtual delete : ()Z
    //   390: pop
    //   391: iload #7
    //   393: ifne -> 438
    //   396: new com/laiqian/util/logger/d
    //   399: dup
    //   400: aload_0
    //   401: invokevirtual getClass : ()Ljava/lang/Class;
    //   404: invokevirtual getName : ()Ljava/lang/String;
    //   407: ldc_w 'requestIncrementalDownload'
    //   410: ldc_w 'error encrypt file'
    //   413: ldc 'failed'
    //   415: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   418: getstatic com/laiqian/util/logger/h$a.dHv : Lcom/laiqian/util/logger/h$a;
    //   421: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   424: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   427: new com/laiqian/sync/a/f
    //   430: dup
    //   431: ldc_w 'error encrypt file'
    //   434: invokespecial <init> : (Ljava/lang/String;)V
    //   437: athrow
    //   438: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   441: invokevirtual Ea : ()Ljava/lang/String;
    //   444: astore #10
    //   446: new java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial <init> : ()V
    //   453: astore #11
    //   455: aload #11
    //   457: aload #10
    //   459: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload #11
    //   465: ldc_w '/'
    //   468: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload #11
    //   474: aload #9
    //   476: invokevirtual getName : ()Ljava/lang/String;
    //   479: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload #11
    //   485: invokevirtual toString : ()Ljava/lang/String;
    //   488: astore #10
    //   490: aload_0
    //   491: aload_0
    //   492: getfield doa : Ljava/lang/String;
    //   495: aload #10
    //   497: aload #9
    //   499: invokespecial c : (Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V
    //   502: aload #9
    //   504: invokevirtual delete : ()Z
    //   507: pop
    //   508: aload_0
    //   509: getfield context : Landroid/content/Context;
    //   512: invokestatic bv : (Landroid/content/Context;)Lcom/laiqian/sync/a/j;
    //   515: astore #9
    //   517: aload #9
    //   519: lload_2
    //   520: invokevirtual dk : (J)V
    //   523: aload #9
    //   525: lload #4
    //   527: invokevirtual dl : (J)V
    //   530: aload #9
    //   532: aload #8
    //   534: invokevirtual C : (Ljava/util/Collection;)V
    //   537: aload #9
    //   539: aload #6
    //   541: invokevirtual getName : ()Ljava/lang/String;
    //   544: invokevirtual nU : (Ljava/lang/String;)V
    //   547: invokestatic currentTimeMillis : ()J
    //   550: invokestatic valueOf : (J)Ljava/lang/String;
    //   553: astore #6
    //   555: aload_0
    //   556: aload_0
    //   557: getfield doa : Ljava/lang/String;
    //   560: aload #10
    //   562: aload #9
    //   564: aload #6
    //   566: invokespecial b : (Ljava/lang/String;Ljava/lang/String;Lcom/laiqian/sync/a/j;Ljava/lang/String;)V
    //   569: aload_0
    //   570: aconst_null
    //   571: aconst_null
    //   572: aload #6
    //   574: aload #9
    //   576: aload_1
    //   577: invokespecial a : (Ljava/io/File;Ljava/io/File;Ljava/lang/String;Lcom/laiqian/sync/a/j;Lcom/laiqian/sync/a/a$b;)V
    //   580: aload_0
    //   581: monitorexit
    //   582: return
    //   583: astore_1
    //   584: new com/laiqian/util/logger/d
    //   587: dup
    //   588: aload_0
    //   589: invokevirtual getClass : ()Ljava/lang/Class;
    //   592: invokevirtual getName : ()Ljava/lang/String;
    //   595: ldc_w 'requestIncrementalDownload'
    //   598: ldc_w 'error sending message'
    //   601: aload_1
    //   602: invokevirtual getMessage : ()Ljava/lang/String;
    //   605: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   608: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   611: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   614: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   617: new com/laiqian/sync/a/f
    //   620: dup
    //   621: ldc_w 'error sending message'
    //   624: aload_1
    //   625: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   628: athrow
    //   629: astore_1
    //   630: goto -> 679
    //   633: astore_1
    //   634: new com/laiqian/util/logger/d
    //   637: dup
    //   638: aload_0
    //   639: invokevirtual getClass : ()Ljava/lang/Class;
    //   642: invokevirtual getName : ()Ljava/lang/String;
    //   645: ldc_w 'requestIncrementalDownload'
    //   648: ldc_w 'error uploading file'
    //   651: aload_1
    //   652: invokevirtual getMessage : ()Ljava/lang/String;
    //   655: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   658: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   661: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   664: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   667: new com/laiqian/sync/a/f
    //   670: dup
    //   671: ldc_w 'error uploading file'
    //   674: aload_1
    //   675: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   678: athrow
    //   679: aload #9
    //   681: invokevirtual delete : ()Z
    //   684: pop
    //   685: aload_1
    //   686: athrow
    //   687: astore_1
    //   688: goto -> 737
    //   691: astore_1
    //   692: new com/laiqian/util/logger/d
    //   695: dup
    //   696: aload_0
    //   697: invokevirtual getClass : ()Ljava/lang/Class;
    //   700: invokevirtual getName : ()Ljava/lang/String;
    //   703: ldc_w 'requestIncrementalDownload'
    //   706: ldc_w 'error compressing file'
    //   709: aload_1
    //   710: invokevirtual getMessage : ()Ljava/lang/String;
    //   713: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   716: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   719: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   722: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   725: new com/laiqian/sync/a/f
    //   728: dup
    //   729: ldc_w 'error compressing file'
    //   732: aload_1
    //   733: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   736: athrow
    //   737: aload #6
    //   739: invokevirtual delete : ()Z
    //   742: pop
    //   743: new java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial <init> : ()V
    //   750: astore #8
    //   752: aload #8
    //   754: aload #6
    //   756: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   759: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: aload #8
    //   765: ldc_w '-journal'
    //   768: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: new java/io/File
    //   775: dup
    //   776: aload #8
    //   778: invokevirtual toString : ()Ljava/lang/String;
    //   781: invokespecial <init> : (Ljava/lang/String;)V
    //   784: astore #6
    //   786: aload #6
    //   788: invokevirtual exists : ()Z
    //   791: ifeq -> 800
    //   794: aload #6
    //   796: invokevirtual delete : ()Z
    //   799: pop
    //   800: aload_1
    //   801: athrow
    //   802: astore_1
    //   803: new com/laiqian/util/logger/d
    //   806: dup
    //   807: aload_0
    //   808: invokevirtual getClass : ()Ljava/lang/Class;
    //   811: invokevirtual getName : ()Ljava/lang/String;
    //   814: ldc_w 'requestIncrementalDownload'
    //   817: ldc_w 'error create pivot db'
    //   820: aload_1
    //   821: invokevirtual getMessage : ()Ljava/lang/String;
    //   824: invokevirtual toString : ()Ljava/lang/String;
    //   827: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   830: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   833: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   836: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   839: new com/laiqian/sync/a/f
    //   842: dup
    //   843: ldc_w 'error create pivot db'
    //   846: aload_1
    //   847: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   850: athrow
    //   851: astore_1
    //   852: aload_0
    //   853: monitorexit
    //   854: aload_1
    //   855: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	851	finally
    //   18	89	802	java/lang/Exception
    //   18	89	851	finally
    //   89	149	851	finally
    //   149	222	691	java/lang/Exception
    //   149	222	687	finally
    //   222	285	851	finally
    //   285	391	851	finally
    //   396	438	851	finally
    //   438	490	851	finally
    //   490	502	633	com/alibaba/a/a/d/b
    //   490	502	633	com/alibaba/a/a/d/e
    //   490	502	629	finally
    //   502	555	851	finally
    //   555	569	583	java/lang/Exception
    //   555	569	851	finally
    //   569	580	851	finally
    //   584	629	851	finally
    //   634	679	629	finally
    //   679	687	851	finally
    //   692	737	687	finally
    //   737	800	851	finally
    //   800	802	851	finally
    //   803	851	851	finally }
  
  private void a(b paramb, Collection<String> paramCollection) throws f { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_2
    //   5: iconst_0
    //   6: anewarray java/lang/String
    //   9: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   14: checkcast [Ljava/lang/String;
    //   17: astore #4
    //   19: aload_0
    //   20: aload #4
    //   22: invokespecial z : ([Ljava/lang/String;)Z
    //   25: ifne -> 67
    //   28: getstatic com/laiqian/sync/a/a.TAG : Ljava/lang/String;
    //   31: astore_1
    //   32: new java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: astore_2
    //   40: aload_2
    //   41: ldc_w 'no new data, skip upload main database for table: '
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: aload #4
    //   51: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_1
    //   56: aload_2
    //   57: invokevirtual toString : ()Ljava/lang/String;
    //   60: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   63: pop
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: getfield context : Landroid/content/Context;
    //   71: invokevirtual getFilesDir : ()Ljava/io/File;
    //   74: invokevirtual getParentFile : ()Ljava/io/File;
    //   77: astore #5
    //   79: new java/io/File
    //   82: dup
    //   83: aload #5
    //   85: ldc 'laiqian.db'
    //   87: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   90: astore_2
    //   91: new java/io/File
    //   94: dup
    //   95: aload #5
    //   97: ldc 'upload.db'
    //   99: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   102: astore #5
    //   104: aload_0
    //   105: aload_2
    //   106: aload #5
    //   108: invokespecial c : (Ljava/io/File;Ljava/io/File;)V
    //   111: new com/laiqian/sync/b/a
    //   114: dup
    //   115: aload #4
    //   117: invokespecial <init> : ([Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield context : Landroid/content/Context;
    //   124: aload #5
    //   126: iconst_0
    //   127: invokevirtual b : (Landroid/content/Context;Ljava/io/File;I)Ljava/util/ArrayList;
    //   130: astore #4
    //   132: aload #5
    //   134: invokevirtual delete : ()Z
    //   137: pop
    //   138: iload_3
    //   139: aload #4
    //   141: invokevirtual size : ()I
    //   144: if_icmpge -> 778
    //   147: new java/io/File
    //   150: dup
    //   151: aload #4
    //   153: iload_3
    //   154: invokevirtual get : (I)Ljava/lang/Object;
    //   157: checkcast java/util/HashMap
    //   160: ldc_w 'FileName'
    //   163: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   166: checkcast java/lang/String
    //   169: invokespecial <init> : (Ljava/lang/String;)V
    //   172: astore #5
    //   174: aload_0
    //   175: getfield debug : Z
    //   178: ifeq -> 228
    //   181: getstatic com/laiqian/sync/a/a.TAG : Ljava/lang/String;
    //   184: astore #6
    //   186: new java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial <init> : ()V
    //   193: astore #7
    //   195: aload #7
    //   197: ldc_w 'requestUpload: split_'
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload #7
    //   206: iload_3
    //   207: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload #6
    //   213: aload #7
    //   215: invokevirtual toString : ()Ljava/lang/String;
    //   218: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   221: pop
    //   222: aload_0
    //   223: aload #5
    //   225: invokespecial F : (Ljava/io/File;)V
    //   228: aload #5
    //   230: invokevirtual getParent : ()Ljava/lang/String;
    //   233: astore #6
    //   235: new java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial <init> : ()V
    //   242: astore #7
    //   244: aload #7
    //   246: aload #5
    //   248: invokevirtual getName : ()Ljava/lang/String;
    //   251: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload #7
    //   257: ldc_w '.'
    //   260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload #7
    //   266: ldc 'zipped'
    //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: new java/io/File
    //   275: dup
    //   276: aload #6
    //   278: aload #7
    //   280: invokevirtual toString : ()Ljava/lang/String;
    //   283: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   286: astore #7
    //   288: new com/laiqian/sync/c/b
    //   291: dup
    //   292: aload_0
    //   293: getfield context : Landroid/content/Context;
    //   296: aload #5
    //   298: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   301: aload #7
    //   303: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   306: getstatic com/laiqian/sync/c/b.aQg : I
    //   309: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   312: getfield aQh : Z
    //   315: ifne -> 329
    //   318: new java/lang/Exception
    //   321: dup
    //   322: ldc_w 'error compressing file'
    //   325: invokespecial <init> : (Ljava/lang/String;)V
    //   328: athrow
    //   329: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   332: invokevirtual atm : ()Ljava/lang/String;
    //   335: astore #8
    //   337: aload #8
    //   339: invokestatic parseLong : (Ljava/lang/String;)J
    //   342: invokestatic dj : (J)Ljava/lang/String;
    //   345: astore #9
    //   347: aload #7
    //   349: invokevirtual getParent : ()Ljava/lang/String;
    //   352: astore #6
    //   354: new java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial <init> : ()V
    //   361: astore #10
    //   363: aload #10
    //   365: aload #7
    //   367: invokevirtual getName : ()Ljava/lang/String;
    //   370: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload #10
    //   376: ldc_w '.'
    //   379: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload #10
    //   385: ldc 'lq'
    //   387: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: new java/io/File
    //   394: dup
    //   395: aload #6
    //   397: aload #10
    //   399: invokevirtual toString : ()Ljava/lang/String;
    //   402: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   405: astore #6
    //   407: aload #7
    //   409: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   412: aload #6
    //   414: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   417: aload #8
    //   419: aload #9
    //   421: invokestatic D : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   424: invokestatic n : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   427: ifne -> 441
    //   430: new com/laiqian/sync/a/f
    //   433: dup
    //   434: ldc_w 'error encrypt file'
    //   437: invokespecial <init> : (Ljava/lang/String;)V
    //   440: athrow
    //   441: aload #7
    //   443: invokevirtual delete : ()Z
    //   446: pop
    //   447: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   450: invokevirtual Ea : ()Ljava/lang/String;
    //   453: astore #7
    //   455: new java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial <init> : ()V
    //   462: astore #8
    //   464: aload #8
    //   466: aload #7
    //   468: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload #8
    //   474: ldc_w '/'
    //   477: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload #8
    //   483: aload #6
    //   485: invokevirtual getName : ()Ljava/lang/String;
    //   488: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload #8
    //   494: invokevirtual toString : ()Ljava/lang/String;
    //   497: astore #7
    //   499: aload_0
    //   500: aload_0
    //   501: getfield doa : Ljava/lang/String;
    //   504: aload #7
    //   506: aload #6
    //   508: invokespecial c : (Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V
    //   511: aload #6
    //   513: invokevirtual delete : ()Z
    //   516: pop
    //   517: aload_0
    //   518: getfield context : Landroid/content/Context;
    //   521: aload #5
    //   523: invokestatic a : (Landroid/content/Context;Ljava/io/File;)Lcom/laiqian/sync/a/j;
    //   526: astore #6
    //   528: aload #6
    //   530: invokestatic Tw : ()Ljava/lang/String;
    //   533: invokevirtual nT : (Ljava/lang/String;)V
    //   536: aload #6
    //   538: invokestatic getDeviceType : ()I
    //   541: invokevirtual ki : (I)V
    //   544: invokestatic currentTimeMillis : ()J
    //   547: invokestatic valueOf : (J)Ljava/lang/String;
    //   550: astore #8
    //   552: aload_0
    //   553: aload_0
    //   554: getfield doa : Ljava/lang/String;
    //   557: aload #7
    //   559: aload #6
    //   561: aload #8
    //   563: invokespecial a : (Ljava/lang/String;Ljava/lang/String;Lcom/laiqian/sync/a/j;Ljava/lang/String;)V
    //   566: new com/laiqian/sync/a/e
    //   569: dup
    //   570: aload_0
    //   571: getfield context : Landroid/content/Context;
    //   574: invokespecial <init> : (Landroid/content/Context;)V
    //   577: astore #7
    //   579: aload #7
    //   581: getstatic com/laiqian/db/multidatabase/a/b.aOw : Lcom/laiqian/db/multidatabase/a/b;
    //   584: invokevirtual Dk : ()Landroid/database/sqlite/SQLiteDatabase;
    //   587: aload #5
    //   589: invokevirtual b : (Landroid/database/sqlite/SQLiteDatabase;Ljava/io/File;)V
    //   592: aload #7
    //   594: invokevirtual close : ()V
    //   597: aload_0
    //   598: aload_2
    //   599: aload #5
    //   601: aload #8
    //   603: aload #6
    //   605: aload_1
    //   606: invokespecial a : (Ljava/io/File;Ljava/io/File;Ljava/lang/String;Lcom/laiqian/sync/a/j;Lcom/laiqian/sync/a/a$b;)V
    //   609: iload_3
    //   610: iconst_1
    //   611: iadd
    //   612: istore_3
    //   613: goto -> 138
    //   616: astore_1
    //   617: new com/laiqian/util/logger/d
    //   620: dup
    //   621: ldc_w 'error sending message'
    //   624: aload_1
    //   625: invokevirtual getMessage : ()Ljava/lang/String;
    //   628: invokevirtual toString : ()Ljava/lang/String;
    //   631: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   634: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   637: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   640: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   643: new com/laiqian/sync/a/f
    //   646: dup
    //   647: ldc_w 'error sending message'
    //   650: aload_1
    //   651: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   654: athrow
    //   655: astore_1
    //   656: new com/laiqian/util/logger/d
    //   659: dup
    //   660: aload_0
    //   661: invokevirtual getClass : ()Ljava/lang/Class;
    //   664: invokevirtual getName : ()Ljava/lang/String;
    //   667: ldc_w 'requestUpload'
    //   670: ldc_w 'error uploading files'
    //   673: aload_1
    //   674: invokevirtual getMessage : ()Ljava/lang/String;
    //   677: invokevirtual toString : ()Ljava/lang/String;
    //   680: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   683: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   686: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   689: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   692: new com/laiqian/sync/a/f
    //   695: dup
    //   696: ldc_w 'error uploading files'
    //   699: aload_1
    //   700: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   703: athrow
    //   704: astore_1
    //   705: aload_0
    //   706: invokevirtual getClass : ()Ljava/lang/Class;
    //   709: invokevirtual getName : ()Ljava/lang/String;
    //   712: astore_2
    //   713: new java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial <init> : ()V
    //   720: astore #4
    //   722: aload #4
    //   724: ldc_w 'error compressing file'
    //   727: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload #4
    //   733: aload_1
    //   734: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: new com/laiqian/util/logger/d
    //   741: dup
    //   742: aload_2
    //   743: ldc_w 'requestUpload'
    //   746: ldc_w 'Exception'
    //   749: aload #4
    //   751: invokevirtual toString : ()Ljava/lang/String;
    //   754: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   757: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   760: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   763: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   766: new com/laiqian/sync/a/f
    //   769: dup
    //   770: ldc_w 'error compressing file'
    //   773: aload_1
    //   774: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   777: athrow
    //   778: aload_0
    //   779: monitorexit
    //   780: return
    //   781: astore_1
    //   782: aload_0
    //   783: invokevirtual getClass : ()Ljava/lang/Class;
    //   786: invokevirtual getName : ()Ljava/lang/String;
    //   789: astore_2
    //   790: new java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial <init> : ()V
    //   797: astore #4
    //   799: aload #4
    //   801: ldc_w 'copy database failed'
    //   804: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: pop
    //   808: aload #4
    //   810: aload_1
    //   811: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: new com/laiqian/util/logger/d
    //   818: dup
    //   819: aload_2
    //   820: ldc_w 'requestUpload'
    //   823: ldc_w 'Exception'
    //   826: aload #4
    //   828: invokevirtual toString : ()Ljava/lang/String;
    //   831: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   834: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   837: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   840: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   843: new com/laiqian/sync/a/f
    //   846: dup
    //   847: ldc_w 'copy database failed'
    //   850: aload_1
    //   851: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   854: athrow
    //   855: astore_1
    //   856: aload_0
    //   857: monitorexit
    //   858: aload_1
    //   859: athrow
    // Exception table:
    //   from	to	target	type
    //   4	64	855	finally
    //   67	104	855	finally
    //   104	111	781	java/io/IOException
    //   104	111	855	finally
    //   111	138	855	finally
    //   138	228	855	finally
    //   228	288	855	finally
    //   288	329	704	java/lang/Exception
    //   288	329	855	finally
    //   329	441	855	finally
    //   441	499	855	finally
    //   499	517	655	com/alibaba/a/a/d/e
    //   499	517	655	com/alibaba/a/a/d/b
    //   499	517	855	finally
    //   517	552	855	finally
    //   552	566	616	com/laiqian/sync/a/f
    //   552	566	855	finally
    //   566	609	855	finally
    //   617	655	855	finally
    //   656	704	855	finally
    //   705	778	855	finally
    //   782	855	855	finally }
  
  private void a(b paramb, String... paramVarArgs) throws f { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   6: astore_3
    //   7: getstatic com/laiqian/sync/c/a.dpn : Ljava/lang/String;
    //   10: ldc_w ','
    //   13: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   16: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   19: astore #4
    //   21: getstatic com/laiqian/sync/c/a.dpp : Ljava/lang/String;
    //   24: ldc_w ','
    //   27: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   30: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   33: pop
    //   34: new java/util/ArrayList
    //   37: dup
    //   38: aload_3
    //   39: invokespecial <init> : (Ljava/util/Collection;)V
    //   42: astore_2
    //   43: aload_2
    //   44: aload #4
    //   46: invokeinterface removeAll : (Ljava/util/Collection;)Z
    //   51: pop
    //   52: new java/util/ArrayList
    //   55: dup
    //   56: aload_3
    //   57: invokespecial <init> : (Ljava/util/Collection;)V
    //   60: astore_3
    //   61: aload_3
    //   62: invokeinterface size : ()I
    //   67: ifle -> 76
    //   70: aload_0
    //   71: aload_1
    //   72: aload_3
    //   73: invokespecial a : (Lcom/laiqian/sync/a/a$b;Ljava/util/Collection;)V
    //   76: aload_2
    //   77: invokeinterface size : ()I
    //   82: ifle -> 91
    //   85: aload_0
    //   86: aload_1
    //   87: aload_2
    //   88: invokespecial b : (Lcom/laiqian/sync/a/a$b;Ljava/util/Collection;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Exception table:
    //   from	to	target	type
    //   2	76	94	finally
    //   76	91	94	finally }
  
  @DebugLog
  private void a(i parami, a parama) throws f {
    if (parama == null)
      throw new f("specified message not exist or expired"); 
    if (parama.getFile() == null || !parama.getFile().exists())
      throw new f("recorded file has been deleted"); 
    SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openDatabase(a.d(parama).getPath(), null, 0);
    e e = new e(this.context);
    if (parami.dpl) {
      e.a(sQLiteDatabase, parama.getFile(), true);
    } else {
      e.b(sQLiteDatabase, parama.getFile(), true);
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("upload failed, ");
      stringBuilder.append(parami.getMessage());
      Log.w(str, stringBuilder.toString());
    } 
    a.Y(this.context).close();
    parama.getFile().delete();
    null = new StringBuilder();
    null.append(parama.getFile().getAbsolutePath());
    null.append("-journal");
    File file = new File(null.toString());
    if (file.exists())
      file.delete(); 
  }
  
  @DebugLog
  private void a(i parami, String paramString1, String paramString2, a parama) throws f {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onDownloadResponse ");
    stringBuilder.append(parami.apO());
    Log.i(str, stringBuilder.toString());
    if (parami.dpl && parami.apO()) {
      null = this.context.getFilesDir().getParent();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(RootApplication.getLaiqianPreferenceManager().atm());
      stringBuilder1.append("-");
      stringBuilder1.append(System.nanoTime());
      stringBuilder1.append(".download");
      file = new File(null, stringBuilder1.toString());
      try {
        d(paramString1, paramString2, file);
        paramString2 = RootApplication.getLaiqianPreferenceManager().atm();
        String str1 = l.dj(Long.parseLong(paramString2));
        paramString1 = file.getParent();
        stringBuilder = new StringBuilder();
        stringBuilder.append(file.getName());
        stringBuilder.append(".");
        stringBuilder.append("lq");
        File file2 = new File(paramString1, stringBuilder.toString());
        int j = d.m(file.getAbsolutePath(), file2.getAbsolutePath(), c.D(paramString2, str1));
        file.delete();
        if (j != 1) {
          h.a(new d(getClass().getName(), "onDownloadResponse", "error decrypt file", "failed"), h.a.dHv, h.b.dHC);
          throw new f("error decrypt file");
        } 
        null = file2.getParent();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(file2.getName());
        stringBuilder2.append(".");
        stringBuilder2.append("unzipped");
        File file1 = new File(null, stringBuilder2.toString());
        b b = new b(this.context, file2.getAbsolutePath(), file1.getAbsolutePath(), b.aQf);
        file2.delete();
        if (!b.aQh) {
          h.a(new d(getClass().getName(), "onDownloadResponse", "failed to uncompress file", "failed"), h.a.dHv, h.b.dHC);
          throw new f("failed to uncompress file");
        } 
        if (this.debug) {
          Log.d(TAG, "onDownloadResponse: download database");
          F(file1);
        } 
        E(file1);
        file1.delete();
        return;
      } catch (b|e|IOException file) {
        h.a(new d("failed to download file", file.getMessage()), h.a.dHw, h.b.dHC);
        throw new f("failed to download file", file);
      } 
    } 
    if (!file.dpl) {
      h.a(new d(getClass().getName(), "onDownloadResponse", "sync failed", file.getMessage()), h.a.dHv, h.b.dHC);
      paramString1 = TAG;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("sync failed, ");
      stringBuilder1.append(file.getMessage());
      Log.w(paramString1, stringBuilder1.toString());
      return;
    } 
    Log.i(TAG, "skip download");
    Iterator iterator = this.bIT.iterator();
    while (iterator.hasNext())
      ((l)iterator.next()).onSuccess(); 
  }
  
  private void a(@Nullable File paramFile1, @Nullable File paramFile2, String paramString, j paramj, b paramb) {
    if (this.doc.size() > 100) {
      d.b("shrinking records, current size: %d", new Object[] { Integer.valueOf(this.doc.size()) });
      int i = this.doc.size() - 100;
      Iterator iterator = this.doc.entrySet().iterator();
      while (iterator.hasNext() && i > 0) {
        String str = a.a((a)((Map.Entry)iterator.next()).getValue());
        iterator.remove();
        this.dod.add(str);
        i--;
      } 
      d.b("record size after shrink: %d", new Object[] { Integer.valueOf(this.doc.size()) });
    } 
    this.doc.put(paramString, new a(paramFile1, paramFile2, paramString, paramj, b.c(paramb)));
    paramb.nQ(paramString);
  }
  
  private void a(String paramString1, String paramString2, j paramj, String paramString3) throws f {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("ossObject", paramString2);
      jSONObject.put("ossBucket", paramString1);
      if (paramj.getDeviceId() == null)
        paramj.nT(m.Tw()); 
      paramj.ki(m.getDeviceType());
      try {
        jSONObject.put("laiqian_encrypt", b.encode(paramj.xy().toString()));
        jSONObject.put("message_id", paramString3);
        try {
          m.gD(jSONObject.toString());
          return;
        } catch (Exception paramString1) {
          h.a(new d(getClass().getName(), "sendUploadMessage", "error sending message", paramString1.getMessage()), h.a.dHw, h.b.dHC);
          throw new f("error sending message", paramString1);
        } 
      } catch (Exception paramString1) {
        throw new f("error handling request", paramString1);
      } 
    } catch (JSONException paramString1) {
      h.a(new d(getClass().getName(), "sendUploadMessage", "cannot build message content", paramString1.getMessage()), h.a.dHw, h.b.dHC);
      throw new f("cannot build message content", paramString1);
    } 
  }
  
  private void a(String paramString1, String paramString2, File paramFile, String paramString3) {
    HashMap hashMap = new HashMap();
    hashMap.put("flag", l.dj(Long.parseLong(paramString3)));
    hashMap.put("user_id", paramString3);
    hashMap.put("bucket", paramString1);
    hashMap.put("object", paramString2);
    String str = TAG;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("upload params-->flag=");
    stringBuilder2.append(l.dj(Long.parseLong(paramString3)));
    stringBuilder2.append("--user_id=");
    stringBuilder2.append(paramString3);
    stringBuilder2.append("--bucket=");
    stringBuilder2.append(paramString1);
    stringBuilder2.append("--objectKey=");
    stringBuilder2.append(paramString2);
    Log.i(str, stringBuilder2.toString());
    paramString1 = getClass().getSimpleName();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("post upload file uploadFile.length==");
    stringBuilder1.append(paramFile.length());
    Log.i(paramString1, stringBuilder1.toString());
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootUrlParameter.clk);
      stringBuilder.append("fileReciever.php");
      a.a(stringBuilder.toString(), hashMap, paramFile, new b(this));
      return;
    } catch (IOException paramString1) {
      a.e(paramString1);
      return;
    } 
  }
  
  private void apl() {
    av av = new av(this.context);
    h h = new h(this.context);
    h.gO(av.Ea());
    av.close();
    h.close();
  }
  
  private void b(b paramb, Collection<String> paramCollection) throws f { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: iconst_0
    //   4: anewarray java/lang/String
    //   7: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   12: checkcast [Ljava/lang/String;
    //   15: astore_2
    //   16: new com/laiqian/sync/b/b
    //   19: dup
    //   20: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: iconst_0
    //   27: aload_2
    //   28: invokevirtual b : (Z[Ljava/lang/String;)Landroid/support/v4/util/Pair;
    //   31: astore #4
    //   33: aload #4
    //   35: getfield second : Ljava/lang/Object;
    //   38: checkcast java/util/List
    //   41: invokeinterface isEmpty : ()Z
    //   46: ifne -> 877
    //   49: aload #4
    //   51: getfield second : Ljava/lang/Object;
    //   54: checkcast java/util/List
    //   57: invokeinterface iterator : ()Ljava/util/Iterator;
    //   62: astore #4
    //   64: aload #4
    //   66: invokeinterface hasNext : ()Z
    //   71: ifeq -> 877
    //   74: aload #4
    //   76: invokeinterface next : ()Ljava/lang/Object;
    //   81: checkcast java/lang/String
    //   84: astore #5
    //   86: aload_0
    //   87: getfield context : Landroid/content/Context;
    //   90: invokevirtual getFilesDir : ()Ljava/io/File;
    //   93: invokevirtual getParentFile : ()Ljava/io/File;
    //   96: astore #6
    //   98: new java/io/File
    //   101: dup
    //   102: aload #5
    //   104: invokespecial <init> : (Ljava/lang/String;)V
    //   107: astore #5
    //   109: new java/io/File
    //   112: dup
    //   113: aload #6
    //   115: ldc 'upload.db'
    //   117: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   120: astore #7
    //   122: aload_0
    //   123: aload #5
    //   125: aload #7
    //   127: invokespecial c : (Ljava/io/File;Ljava/io/File;)V
    //   130: new com/laiqian/sync/b/a
    //   133: dup
    //   134: aload_2
    //   135: invokespecial <init> : ([Ljava/lang/String;)V
    //   138: aload_0
    //   139: getfield context : Landroid/content/Context;
    //   142: aload #7
    //   144: iconst_0
    //   145: invokevirtual b : (Landroid/content/Context;Ljava/io/File;I)Ljava/util/ArrayList;
    //   148: astore #6
    //   150: aload #7
    //   152: invokevirtual delete : ()Z
    //   155: pop
    //   156: iconst_0
    //   157: istore_3
    //   158: iload_3
    //   159: aload #6
    //   161: invokevirtual size : ()I
    //   164: if_icmpge -> 64
    //   167: new java/io/File
    //   170: dup
    //   171: aload #6
    //   173: iload_3
    //   174: invokevirtual get : (I)Ljava/lang/Object;
    //   177: checkcast java/util/HashMap
    //   180: ldc_w 'FileName'
    //   183: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   186: checkcast java/lang/String
    //   189: invokespecial <init> : (Ljava/lang/String;)V
    //   192: astore #7
    //   194: aload_0
    //   195: getfield debug : Z
    //   198: ifeq -> 248
    //   201: getstatic com/laiqian/sync/a/a.TAG : Ljava/lang/String;
    //   204: astore #8
    //   206: new java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial <init> : ()V
    //   213: astore #9
    //   215: aload #9
    //   217: ldc_w 'requestUpload: split_'
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload #9
    //   226: iload_3
    //   227: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload #8
    //   233: aload #9
    //   235: invokevirtual toString : ()Ljava/lang/String;
    //   238: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   241: pop
    //   242: aload_0
    //   243: aload #7
    //   245: invokespecial F : (Ljava/io/File;)V
    //   248: aload #7
    //   250: invokevirtual getParent : ()Ljava/lang/String;
    //   253: astore #8
    //   255: new java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial <init> : ()V
    //   262: astore #9
    //   264: aload #9
    //   266: aload #7
    //   268: invokevirtual getName : ()Ljava/lang/String;
    //   271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload #9
    //   277: ldc_w '.'
    //   280: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload #9
    //   286: ldc 'zipped'
    //   288: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: new java/io/File
    //   295: dup
    //   296: aload #8
    //   298: aload #9
    //   300: invokevirtual toString : ()Ljava/lang/String;
    //   303: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   306: astore #9
    //   308: new com/laiqian/sync/c/b
    //   311: dup
    //   312: aload_0
    //   313: getfield context : Landroid/content/Context;
    //   316: aload #7
    //   318: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   321: aload #9
    //   323: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   326: getstatic com/laiqian/sync/c/b.aQg : I
    //   329: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    //   332: getfield aQh : Z
    //   335: ifne -> 349
    //   338: new java/lang/Exception
    //   341: dup
    //   342: ldc_w 'error compressing file'
    //   345: invokespecial <init> : (Ljava/lang/String;)V
    //   348: athrow
    //   349: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   352: invokevirtual atm : ()Ljava/lang/String;
    //   355: astore #10
    //   357: aload #10
    //   359: invokestatic parseLong : (Ljava/lang/String;)J
    //   362: invokestatic dj : (J)Ljava/lang/String;
    //   365: astore #11
    //   367: aload #9
    //   369: invokevirtual getParent : ()Ljava/lang/String;
    //   372: astore #8
    //   374: new java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial <init> : ()V
    //   381: astore #12
    //   383: aload #12
    //   385: aload #9
    //   387: invokevirtual getName : ()Ljava/lang/String;
    //   390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload #12
    //   396: ldc_w '.'
    //   399: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload #12
    //   405: ldc 'lq'
    //   407: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: new java/io/File
    //   414: dup
    //   415: aload #8
    //   417: aload #12
    //   419: invokevirtual toString : ()Ljava/lang/String;
    //   422: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   425: astore #8
    //   427: aload #9
    //   429: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   432: aload #8
    //   434: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   437: aload #10
    //   439: aload #11
    //   441: invokestatic D : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   444: invokestatic n : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   447: ifne -> 461
    //   450: new com/laiqian/sync/a/f
    //   453: dup
    //   454: ldc_w 'error encrypt file'
    //   457: invokespecial <init> : (Ljava/lang/String;)V
    //   460: athrow
    //   461: aload #9
    //   463: invokevirtual delete : ()Z
    //   466: pop
    //   467: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   470: invokevirtual Ea : ()Ljava/lang/String;
    //   473: astore #9
    //   475: new java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial <init> : ()V
    //   482: astore #10
    //   484: aload #10
    //   486: aload #9
    //   488: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload #10
    //   494: ldc_w '/'
    //   497: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload #10
    //   503: aload #8
    //   505: invokevirtual getName : ()Ljava/lang/String;
    //   508: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload #10
    //   514: invokevirtual toString : ()Ljava/lang/String;
    //   517: astore #9
    //   519: aload_0
    //   520: aload_0
    //   521: getfield doa : Ljava/lang/String;
    //   524: aload #9
    //   526: aload #8
    //   528: invokespecial c : (Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V
    //   531: aload #8
    //   533: invokevirtual delete : ()Z
    //   536: pop
    //   537: aload_0
    //   538: getfield context : Landroid/content/Context;
    //   541: aload #7
    //   543: invokestatic a : (Landroid/content/Context;Ljava/io/File;)Lcom/laiqian/sync/a/j;
    //   546: astore #8
    //   548: aload #8
    //   550: invokestatic Tw : ()Ljava/lang/String;
    //   553: invokevirtual nT : (Ljava/lang/String;)V
    //   556: aload #8
    //   558: invokestatic getDeviceType : ()I
    //   561: invokevirtual ki : (I)V
    //   564: invokestatic currentTimeMillis : ()J
    //   567: invokestatic valueOf : (J)Ljava/lang/String;
    //   570: astore #10
    //   572: aload_0
    //   573: aload_0
    //   574: getfield doa : Ljava/lang/String;
    //   577: aload #9
    //   579: aload #8
    //   581: aload #10
    //   583: invokespecial a : (Ljava/lang/String;Ljava/lang/String;Lcom/laiqian/sync/a/j;Ljava/lang/String;)V
    //   586: new com/laiqian/sync/a/e
    //   589: dup
    //   590: aload_0
    //   591: getfield context : Landroid/content/Context;
    //   594: invokespecial <init> : (Landroid/content/Context;)V
    //   597: astore #9
    //   599: aload #9
    //   601: aload #5
    //   603: invokevirtual getPath : ()Ljava/lang/String;
    //   606: aconst_null
    //   607: iconst_0
    //   608: invokestatic openDatabase : (Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   611: aload #7
    //   613: invokevirtual b : (Landroid/database/sqlite/SQLiteDatabase;Ljava/io/File;)V
    //   616: aload #9
    //   618: invokevirtual close : ()V
    //   621: aload_0
    //   622: aload #5
    //   624: aload #7
    //   626: aload #10
    //   628: aload #8
    //   630: aload_1
    //   631: invokespecial a : (Ljava/io/File;Ljava/io/File;Ljava/lang/String;Lcom/laiqian/sync/a/j;Lcom/laiqian/sync/a/a$b;)V
    //   634: iload_3
    //   635: iconst_1
    //   636: iadd
    //   637: istore_3
    //   638: goto -> 158
    //   641: astore_1
    //   642: new com/laiqian/util/logger/d
    //   645: dup
    //   646: ldc_w 'error sending message'
    //   649: aload_1
    //   650: invokevirtual getMessage : ()Ljava/lang/String;
    //   653: invokevirtual toString : ()Ljava/lang/String;
    //   656: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   659: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   662: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   665: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   668: new com/laiqian/sync/a/f
    //   671: dup
    //   672: ldc_w 'error sending message'
    //   675: aload_1
    //   676: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   679: athrow
    //   680: astore_1
    //   681: new com/laiqian/util/logger/d
    //   684: dup
    //   685: aload_0
    //   686: invokevirtual getClass : ()Ljava/lang/Class;
    //   689: invokevirtual getName : ()Ljava/lang/String;
    //   692: ldc_w 'requestUpload'
    //   695: ldc_w 'error uploading files'
    //   698: aload_1
    //   699: invokevirtual getMessage : ()Ljava/lang/String;
    //   702: invokevirtual toString : ()Ljava/lang/String;
    //   705: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   708: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   711: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   714: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   717: new com/laiqian/sync/a/f
    //   720: dup
    //   721: ldc_w 'error uploading files'
    //   724: aload_1
    //   725: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   728: athrow
    //   729: astore_1
    //   730: aload_0
    //   731: invokevirtual getClass : ()Ljava/lang/Class;
    //   734: invokevirtual getName : ()Ljava/lang/String;
    //   737: astore_2
    //   738: new java/lang/StringBuilder
    //   741: dup
    //   742: invokespecial <init> : ()V
    //   745: astore #4
    //   747: aload #4
    //   749: ldc_w 'error compressing file'
    //   752: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload #4
    //   758: aload_1
    //   759: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: new com/laiqian/util/logger/d
    //   766: dup
    //   767: aload_2
    //   768: ldc_w 'requestUpload'
    //   771: ldc_w 'Exception'
    //   774: aload #4
    //   776: invokevirtual toString : ()Ljava/lang/String;
    //   779: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   782: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   785: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   788: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   791: new com/laiqian/sync/a/f
    //   794: dup
    //   795: ldc_w 'error compressing file'
    //   798: aload_1
    //   799: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   802: athrow
    //   803: astore_1
    //   804: aload_0
    //   805: invokevirtual getClass : ()Ljava/lang/Class;
    //   808: invokevirtual getName : ()Ljava/lang/String;
    //   811: astore_2
    //   812: new java/lang/StringBuilder
    //   815: dup
    //   816: invokespecial <init> : ()V
    //   819: astore #4
    //   821: aload #4
    //   823: ldc_w 'copy database failed'
    //   826: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: pop
    //   830: aload #4
    //   832: aload_1
    //   833: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: new com/laiqian/util/logger/d
    //   840: dup
    //   841: aload_2
    //   842: ldc_w 'requestUpload'
    //   845: ldc_w 'Exception'
    //   848: aload #4
    //   850: invokevirtual toString : ()Ljava/lang/String;
    //   853: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   856: getstatic com/laiqian/util/logger/h$a.dHw : Lcom/laiqian/util/logger/h$a;
    //   859: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   862: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   865: new com/laiqian/sync/a/f
    //   868: dup
    //   869: ldc_w 'copy database failed'
    //   872: aload_1
    //   873: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   876: athrow
    //   877: aload_0
    //   878: monitorexit
    //   879: return
    //   880: astore_1
    //   881: aload_0
    //   882: monitorexit
    //   883: aload_1
    //   884: athrow
    // Exception table:
    //   from	to	target	type
    //   2	64	880	finally
    //   64	122	880	finally
    //   122	130	803	java/io/IOException
    //   122	130	880	finally
    //   130	156	880	finally
    //   158	248	880	finally
    //   248	308	880	finally
    //   308	349	729	java/lang/Exception
    //   308	349	880	finally
    //   349	461	880	finally
    //   461	519	880	finally
    //   519	537	680	com/alibaba/a/a/d/e
    //   519	537	680	com/alibaba/a/a/d/b
    //   519	537	880	finally
    //   537	572	880	finally
    //   572	586	641	com/laiqian/sync/a/f
    //   572	586	880	finally
    //   586	634	880	finally
    //   642	680	880	finally
    //   681	729	880	finally
    //   730	803	880	finally
    //   804	877	880	finally }
  
  @DebugLog
  private void b(String paramString1, String paramString2, j paramj, String paramString3) throws f {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("ossObject", paramString2);
      jSONObject.put("ossBucket", paramString1);
      jSONObject.put("message_id", paramString3);
      if (paramj.getDeviceId() == null)
        paramj.nT(m.Tw()); 
      paramj.ki(m.getDeviceType());
      try {
        jSONObject.put("laiqian_encrypt", b.encode(paramj.xy().toString()));
        try {
          m.gD(jSONObject.toString());
          return;
        } catch (Exception paramString1) {
          h.a(new d(getClass().getName(), "sendUploadAndDownloadMessage", "error sending message", paramString1.getMessage()), h.a.dHw, h.b.dHC);
          throw new f("error sending message", paramString1);
        } 
      } catch (Exception paramString1) {
        throw new f("error handling request", paramString1);
      } 
    } catch (JSONException paramString1) {
      h.a(new d(getClass().getName(), "sendUploadAndDownloadMessage", "cannot build message content", paramString1.getMessage()), h.a.dHw, h.b.dHC);
      throw new f("cannot build message content", paramString1);
    } 
  }
  
  private void b(String paramString1, String paramString2, File paramFile, String paramString3) {
    HashMap hashMap = new HashMap();
    hashMap.put("flag", l.dj(Long.parseLong(paramString3)));
    hashMap.put("user_id", paramString3);
    hashMap.put("bucket", paramString1);
    hashMap.put("object", paramString2);
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("download params-->flag=");
    stringBuilder.append(l.dj(Long.parseLong(paramString3)));
    stringBuilder.append("--user_id=");
    stringBuilder.append(paramString3);
    stringBuilder.append("--bucket=");
    stringBuilder.append(paramString1);
    stringBuilder.append("--objectKey=");
    stringBuilder.append(paramString2);
    Log.i(str, stringBuilder.toString());
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(RootUrlParameter.clk);
      stringBuilder1.append("fileSender.php");
      a.a(paramFile, stringBuilder1.toString(), hashMap, new c(this));
      return;
    } catch (IOException paramString1) {
      a.e(paramString1);
      return;
    } 
  }
  
  private void c(File paramFile1, File paramFile2) throws IOException {
    File file = null;
    try {
    
    } finally {
      paramFile1 = null;
      throwable = null;
    } 
    if (throwable != null)
      try {
        throwable.close();
      } catch (IOException throwable) {
        a.e(throwable);
      }  
    if (paramFile2 != null)
      try {
        paramFile2.close();
      } catch (IOException paramFile2) {
        h.a(new d("error updating local database", paramFile2.getMessage()), h.a.dHw, h.b.dHC);
        a.e(paramFile2);
      }  
    throw paramFile1;
  }
  
  private void c(String paramString1, String paramString2, File paramFile) throws b, e {
    av av = new av(RootApplication.zv());
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("upload fielpath-->");
    stringBuilder.append(paramFile.getAbsolutePath());
    stringBuilder.append("--exsists-");
    stringBuilder.append(paramFile.exists());
    Log.i(str, stringBuilder.toString());
    if (av.ava()) {
      a(paramString1, paramString2, paramFile, av.atm());
    } else {
      e(paramString1, paramString2, paramFile);
    } 
    av.close();
  }
  
  private void d(String paramString1, String paramString2, File paramFile) throws b, e {
    av av = new av(RootApplication.zv());
    if (av.ava()) {
      b(paramString1, paramString2, paramFile, av.atm());
    } else {
      f(paramString1, paramString2, paramFile);
    } 
    av.close();
  }
  
  @DebugLog
  private void e(String paramString1, String paramString2, File paramFile) throws b, e { a.b(paramString1, paramString2, paramFile); }
  
  private void f(String paramString1, String paramString2, File paramFile) throws b, e { a.a(paramString1, paramString2, paramFile); }
  
  private void g(SQLiteDatabase paramSQLiteDatabase) {
    try {
      S(ab.n(paramSQLiteDatabase));
      return;
    } catch (Exception paramSQLiteDatabase) {
      a.e(paramSQLiteDatabase);
      return;
    } 
  }
  
  private boolean nM(String paramString) { return this.dod.contains(paramString); }
  
  @DebugLog
  private void nO(@NonNull String paramString) throws f {
    try {
      StringBuilder stringBuilder1;
      JSONObject jSONObject = new JSONObject(paramString);
      null = jSONObject.getString("message_id");
      a a1 = (a)this.doc.get(null);
      if (a1 == null)
        throw new f("specified message not exist or expired"); 
      this.doc.remove(null);
      this.dod.add(null);
      if (LQKVersion.zg()) {
        long l = System.currentTimeMillis();
        Log.d(TAG, String.format("it takes %dms s to receive %s", new Object[] { Long.valueOf(l - a1.apn()), a1.toString() }));
      } 
      b b = (b)this.doe.get(a.b(a1));
      if (b != null) {
        int i = a(b).size();
        int j = b.apo().size();
        if (LQKVersion.zg())
          Log.d(TAG, String.format("this is %d/%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) })); 
        if (i >= j)
          this.doe.remove(b.c(b)); 
      } 
      if (jSONObject.has("laiqian_encrypt")) {
        paramString = jSONObject.getString("laiqian_encrypt");
        i i1 = new i();
        i1.ox(paramString);
        if (LQKVersion.zg())
          d.b(i1.toString(), new Object[0]); 
        if (i1.apI() == -1 || i1.apI() == -2) {
          apl();
          this.context.sendBroadcast(new Intent("pos_change_account"));
          return;
        } 
        int i = a.c(a1).getRequestType();
        if (i != 13) {
          if (i != 15) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("unknown service type: ");
            stringBuilder1.append(i);
            throw new f(stringBuilder1.toString());
          } 
          a(i1, jSONObject.getString("ossBucket"), jSONObject.getString("ossObject"), a1);
          return;
        } 
        a(i1, a1);
        return;
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("malformation message");
      stringBuilder2.append(stringBuilder1);
      throw new f(stringBuilder2.toString());
    } catch (JSONException|f paramString) {
      h.a(new d(getClass().getName(), "processMessage", "error processing message", paramString.getMessage()), h.a.dHw, h.b.dHC);
      throw new f("error processing message", paramString);
    } 
  }
  
  private void nP(String paramString) throws f {
    try {
      SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openDatabase(paramString, null, 0);
      g(sQLiteDatabase);
      sQLiteDatabase.close();
      return;
    } catch (Exception paramString) {
      a.e(paramString);
      return;
    } 
  }
  
  private boolean z(@NonNull String... paramVarArgs) {
    h h = new h(this.context);
    boolean bool = h.p(paramVarArgs);
    h.close();
    return bool;
  }
  
  public void a(long paramLong1, long paramLong2, Collection<String> paramCollection) throws f { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: lload_1
    //   4: lload_3
    //   5: aload #5
    //   7: aload #5
    //   9: invokevirtual a : (JJLjava/util/Collection;Ljava/util/Collection;)V
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: astore #5
    //   17: aload_0
    //   18: monitorexit
    //   19: aload #5
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	15	finally }
  
  public void a(long paramLong1, long paramLong2, Collection<String> paramCollection1, Collection<String> paramCollection2) throws f { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic currentTimeMillis : ()J
    //   5: invokestatic valueOf : (J)Ljava/lang/String;
    //   8: astore #8
    //   10: new com/laiqian/sync/a/a$b
    //   13: dup
    //   14: aload #8
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: astore #7
    //   21: aload #5
    //   23: ifnull -> 56
    //   26: aload #5
    //   28: invokeinterface isEmpty : ()Z
    //   33: ifne -> 56
    //   36: aload_0
    //   37: aload #7
    //   39: aload #5
    //   41: iconst_0
    //   42: anewarray java/lang/String
    //   45: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   50: checkcast [Ljava/lang/String;
    //   53: invokespecial a : (Lcom/laiqian/sync/a/a$b;[Ljava/lang/String;)V
    //   56: aload #6
    //   58: ifnull -> 93
    //   61: aload #6
    //   63: invokeinterface isEmpty : ()Z
    //   68: ifne -> 93
    //   71: aload_0
    //   72: aload #7
    //   74: lload_1
    //   75: lload_3
    //   76: aload #6
    //   78: iconst_0
    //   79: anewarray java/lang/String
    //   82: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   87: checkcast [Ljava/lang/String;
    //   90: invokespecial a : (Lcom/laiqian/sync/a/a$b;JJ[Ljava/lang/String;)V
    //   93: aload_0
    //   94: getfield doe : Ljava/util/Map;
    //   97: aload #8
    //   99: aload #7
    //   101: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: invokestatic zg : ()Z
    //   110: ifeq -> 172
    //   113: getstatic com/laiqian/sync/a/a.TAG : Ljava/lang/String;
    //   116: astore #5
    //   118: new java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: astore #6
    //   127: aload #6
    //   129: ldc_w 'requestSync: sent '
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload #6
    //   138: aload #7
    //   140: invokevirtual apo : ()Ljava/util/List;
    //   143: invokeinterface size : ()I
    //   148: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload #6
    //   154: ldc_w ' messages to server'
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #5
    //   163: aload #6
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   171: pop
    //   172: aload_0
    //   173: monitorexit
    //   174: return
    //   175: astore #5
    //   177: aload_0
    //   178: monitorexit
    //   179: aload #5
    //   181: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	175	finally
    //   26	56	175	finally
    //   61	93	175	finally
    //   93	172	175	finally }
  
  public void a(@NonNull l paraml) { this.bIT.add(paraml); }
  
  public void b(@NonNull l paraml) { this.bIT.remove(paraml); }
  
  @DebugLog
  public void nN(String paramString) throws f { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifeq -> 52
    //   9: ldc_w 'empty content message'
    //   12: iconst_0
    //   13: anewarray java/lang/Object
    //   16: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: new com/laiqian/util/logger/d
    //   22: dup
    //   23: aload_0
    //   24: invokevirtual getClass : ()Ljava/lang/Class;
    //   27: invokevirtual getName : ()Ljava/lang/String;
    //   30: ldc_w 'onSyncResponse'
    //   33: ldc_w 'empty content message'
    //   36: aload_1
    //   37: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   40: getstatic com/laiqian/util/logger/h$a.dHv : Lcom/laiqian/util/logger/h$a;
    //   43: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   46: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_1
    //   53: invokestatic decode : (Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: aload_2
    //   58: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   61: ifeq -> 130
    //   64: new com/laiqian/util/logger/d
    //   67: dup
    //   68: aload_0
    //   69: invokevirtual getClass : ()Ljava/lang/Class;
    //   72: invokevirtual getName : ()Ljava/lang/String;
    //   75: ldc_w 'onSyncResponse'
    //   78: ldc_w 'decrypt content failed'
    //   81: aload_1
    //   82: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   85: getstatic com/laiqian/util/logger/h$a.dHv : Lcom/laiqian/util/logger/h$a;
    //   88: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   91: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   94: new java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial <init> : ()V
    //   101: astore_2
    //   102: aload_2
    //   103: ldc_w 'decrypt content failed:'
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_2
    //   111: aload_1
    //   112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_2
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: iconst_0
    //   121: anewarray java/lang/Object
    //   124: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial nO : (Ljava/lang/String;)V
    //   135: goto -> 176
    //   138: astore_1
    //   139: new com/laiqian/util/logger/d
    //   142: dup
    //   143: aload_0
    //   144: invokevirtual getClass : ()Ljava/lang/Class;
    //   147: invokevirtual getName : ()Ljava/lang/String;
    //   150: ldc_w 'onSyncResponse'
    //   153: ldc_w 'SyncException'
    //   156: aload_1
    //   157: invokevirtual getMessage : ()Ljava/lang/String;
    //   160: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   163: getstatic com/laiqian/util/logger/h$a.dHv : Lcom/laiqian/util/logger/h$a;
    //   166: getstatic com/laiqian/util/logger/h$b.dHC : Lcom/laiqian/util/logger/h$b;
    //   169: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   172: aload_1
    //   173: invokestatic e : (Ljava/lang/Throwable;)V
    //   176: aload_0
    //   177: monitorexit
    //   178: return
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    // Exception table:
    //   from	to	target	type
    //   2	49	179	finally
    //   52	127	179	finally
    //   130	135	138	com/laiqian/sync/a/f
    //   130	135	179	finally
    //   139	176	179	finally }
  
  class a {}
  
  class a {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\sync\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */