package com.laiqian.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.google.a.a.a.a.a.a;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class cm {
  private MediaPlayer dGQ;
  
  private Context mContext;
  
  private File mFile;
  
  private cm(Context paramContext) {
    this.mContext = paramContext;
    this.dGQ = new MediaPlayer();
    AudioManager audioManager = (AudioManager)paramContext.getSystemService("audio");
    audioManager.getStreamVolume(3);
    audioManager.setStreamVolume(3, audioManager.getStreamMaxVolume(3), 0);
    this.dGQ.setOnCompletionListener(new cn(this));
  }
  
  private void J(File paramFile) throws IOException {
    this.dGQ.reset();
    this.dGQ.setAudioStreamType(3);
    this.dGQ.setDataSource(paramFile.getAbsolutePath());
    this.dGQ.prepare();
    this.dGQ.start();
  }
  
  private void a(List<String> paramList, char paramChar) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cn_");
      stringBuilder.append(paramChar);
      stringBuilder.append(".mp3");
      paramList.add(stringBuilder.toString());
      return;
    } catch (Exception paramList) {
      a.e(paramList);
      return;
    } 
  }
  
  private boolean a(char paramChar1, char paramChar2) { return "0".equals(Character.toString(paramChar1)); }
  
  private Vector<AssetFileDescriptor> b(Vector<String> paramVector) throws IOException {
    Vector vector = new Vector();
    AssetManager assetManager = this.mContext.getAssets();
    Iterator iterator = paramVector.iterator();
    while (iterator.hasNext())
      vector.add(assetManager.openFd((String)iterator.next())); 
    return vector;
  }
  
  public static cm cm(Context paramContext) { // Byte code:
    //   0: getstatic com/laiqian/util/cm.dGP : Lcom/laiqian/util/cm;
    //   3: ifnonnull -> 38
    //   6: ldc com/laiqian/util/cm
    //   8: monitorenter
    //   9: getstatic com/laiqian/util/cm.dGP : Lcom/laiqian/util/cm;
    //   12: ifnonnull -> 26
    //   15: new com/laiqian/util/cm
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/laiqian/util/cm.dGP : Lcom/laiqian/util/cm;
    //   26: ldc com/laiqian/util/cm
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/laiqian/util/cm
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/laiqian/util/cm.dGP : Lcom/laiqian/util/cm;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally }
  
  private void g(List<String> paramList, int paramInt) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cn_");
      stringBuilder.append(paramInt);
      stringBuilder.append(".mp3");
      paramList.add(stringBuilder.toString());
      return;
    } catch (Exception paramList) {
      a.e(paramList);
      return;
    } 
  }
  
  public void a(Vector<AssetFileDescriptor> paramVector) throws IOException { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: new java/io/File
    //   6: dup
    //   7: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   10: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   13: ldc 'temp.mp3'
    //   15: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   18: putfield mFile : Ljava/io/File;
    //   21: aload_0
    //   22: getfield mFile : Ljava/io/File;
    //   25: invokevirtual exists : ()Z
    //   28: ifeq -> 39
    //   31: aload_0
    //   32: getfield mFile : Ljava/io/File;
    //   35: invokevirtual delete : ()Z
    //   38: pop
    //   39: new java/io/FileOutputStream
    //   42: dup
    //   43: aload_0
    //   44: getfield mFile : Ljava/io/File;
    //   47: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   50: invokespecial <init> : (Ljava/lang/String;)V
    //   53: astore_3
    //   54: aload_1
    //   55: invokevirtual iterator : ()Ljava/util/Iterator;
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface hasNext : ()Z
    //   65: ifeq -> 132
    //   68: aload_1
    //   69: invokeinterface next : ()Ljava/lang/Object;
    //   74: checkcast android/content/res/AssetFileDescriptor
    //   77: astore #4
    //   79: aload #4
    //   81: invokevirtual createInputStream : ()Ljava/io/FileInputStream;
    //   84: astore #4
    //   86: ldc 1048576
    //   88: newarray byte
    //   90: astore #5
    //   92: aload #4
    //   94: aload #5
    //   96: invokevirtual read : ([B)I
    //   99: istore_2
    //   100: iload_2
    //   101: iconst_m1
    //   102: if_icmpeq -> 59
    //   105: aload_3
    //   106: aload #5
    //   108: iconst_0
    //   109: iload_2
    //   110: invokevirtual write : ([BII)V
    //   113: goto -> 92
    //   116: astore_1
    //   117: goto -> 130
    //   120: astore #4
    //   122: aload #4
    //   124: invokestatic e : (Ljava/lang/Throwable;)V
    //   127: goto -> 59
    //   130: aload_1
    //   131: athrow
    //   132: aload_3
    //   133: invokevirtual close : ()V
    //   136: aload_0
    //   137: aload_0
    //   138: getfield mFile : Ljava/io/File;
    //   141: invokespecial J : (Ljava/io/File;)V
    //   144: aload_0
    //   145: monitorexit
    //   146: return
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    // Exception table:
    //   from	to	target	type
    //   2	39	147	finally
    //   39	59	147	finally
    //   59	79	147	finally
    //   79	92	120	java/io/IOException
    //   79	92	116	finally
    //   92	100	120	java/io/IOException
    //   92	100	116	finally
    //   105	113	120	java/io/IOException
    //   105	113	116	finally
    //   122	127	116	finally
    //   130	132	147	finally
    //   132	144	147	finally }
  
  public void sh(String paramString) { // Byte code:
    //   0: new java/util/Vector
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: aload #5
    //   11: ldc 'cn_please.mp3'
    //   13: invokevirtual add : (Ljava/lang/Object;)Z
    //   16: pop
    //   17: aload_1
    //   18: invokestatic parseInt : (Ljava/lang/String;)I
    //   21: iflt -> 46
    //   24: aload_1
    //   25: invokestatic parseInt : (Ljava/lang/String;)I
    //   28: bipush #9
    //   30: if_icmpgt -> 46
    //   33: aload_0
    //   34: aload #5
    //   36: aload_1
    //   37: invokestatic parseInt : (Ljava/lang/String;)I
    //   40: invokespecial g : (Ljava/util/List;I)V
    //   43: goto -> 387
    //   46: aload_1
    //   47: invokestatic parseInt : (Ljava/lang/String;)I
    //   50: invokestatic valueOf : (I)Ljava/lang/String;
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual length : ()I
    //   58: istore #4
    //   60: iconst_0
    //   61: istore_3
    //   62: iload_3
    //   63: iload #4
    //   65: if_icmpge -> 387
    //   68: aload_1
    //   69: iload_3
    //   70: invokevirtual charAt : (I)C
    //   73: istore_2
    //   74: iload #4
    //   76: tableswitch default -> 419, 2 -> 340, 3 -> 270, 4 -> 104
    //   104: iload_3
    //   105: iconst_1
    //   106: if_icmpne -> 135
    //   109: aload_0
    //   110: aload_1
    //   111: iconst_0
    //   112: invokevirtual charAt : (I)C
    //   115: bipush #48
    //   117: invokespecial a : (CC)Z
    //   120: ifne -> 367
    //   123: aload_0
    //   124: aload #5
    //   126: sipush #1000
    //   129: invokespecial g : (Ljava/util/List;I)V
    //   132: goto -> 367
    //   135: iload_3
    //   136: iconst_2
    //   137: if_icmpne -> 175
    //   140: aload_0
    //   141: aload_1
    //   142: iconst_1
    //   143: invokevirtual charAt : (I)C
    //   146: bipush #48
    //   148: invokespecial a : (CC)Z
    //   151: ifne -> 165
    //   154: aload_0
    //   155: aload #5
    //   157: bipush #100
    //   159: invokespecial g : (Ljava/util/List;I)V
    //   162: goto -> 367
    //   165: aload_0
    //   166: aload #5
    //   168: iconst_0
    //   169: invokespecial g : (Ljava/util/List;I)V
    //   172: goto -> 367
    //   175: iload_3
    //   176: iconst_3
    //   177: if_icmpne -> 367
    //   180: aload_0
    //   181: aload_1
    //   182: iconst_2
    //   183: invokevirtual charAt : (I)C
    //   186: bipush #48
    //   188: invokespecial a : (CC)Z
    //   191: ifne -> 205
    //   194: aload_0
    //   195: aload #5
    //   197: bipush #10
    //   199: invokespecial g : (Ljava/util/List;I)V
    //   202: goto -> 226
    //   205: aload_0
    //   206: aload_1
    //   207: iconst_3
    //   208: invokevirtual charAt : (I)C
    //   211: bipush #48
    //   213: invokespecial a : (CC)Z
    //   216: ifne -> 226
    //   219: aload_0
    //   220: aload #5
    //   222: iconst_0
    //   223: invokespecial g : (Ljava/util/List;I)V
    //   226: aload_0
    //   227: aload_1
    //   228: iconst_1
    //   229: invokevirtual charAt : (I)C
    //   232: bipush #48
    //   234: invokespecial a : (CC)Z
    //   237: ifeq -> 367
    //   240: aload_0
    //   241: aload_1
    //   242: iconst_2
    //   243: invokevirtual charAt : (I)C
    //   246: bipush #48
    //   248: invokespecial a : (CC)Z
    //   251: ifeq -> 367
    //   254: aload #5
    //   256: aload #5
    //   258: invokevirtual size : ()I
    //   261: iconst_2
    //   262: isub
    //   263: invokevirtual remove : (I)Ljava/lang/Object;
    //   266: pop
    //   267: goto -> 367
    //   270: iload_3
    //   271: iconst_1
    //   272: if_icmpne -> 300
    //   275: aload_0
    //   276: aload_1
    //   277: iconst_0
    //   278: invokevirtual charAt : (I)C
    //   281: bipush #48
    //   283: invokespecial a : (CC)Z
    //   286: ifne -> 367
    //   289: aload_0
    //   290: aload #5
    //   292: bipush #100
    //   294: invokespecial g : (Ljava/util/List;I)V
    //   297: goto -> 367
    //   300: iload_3
    //   301: iconst_2
    //   302: if_icmpne -> 367
    //   305: aload_0
    //   306: aload_1
    //   307: iconst_1
    //   308: invokevirtual charAt : (I)C
    //   311: bipush #48
    //   313: invokespecial a : (CC)Z
    //   316: ifne -> 330
    //   319: aload_0
    //   320: aload #5
    //   322: bipush #10
    //   324: invokespecial g : (Ljava/util/List;I)V
    //   327: goto -> 367
    //   330: aload_0
    //   331: aload #5
    //   333: iconst_0
    //   334: invokespecial g : (Ljava/util/List;I)V
    //   337: goto -> 367
    //   340: iload_3
    //   341: iconst_1
    //   342: if_icmpne -> 367
    //   345: aload_0
    //   346: aload_1
    //   347: iconst_0
    //   348: invokevirtual charAt : (I)C
    //   351: bipush #48
    //   353: invokespecial a : (CC)Z
    //   356: ifne -> 367
    //   359: aload_0
    //   360: aload #5
    //   362: bipush #10
    //   364: invokespecial g : (Ljava/util/List;I)V
    //   367: aload_0
    //   368: iload_2
    //   369: bipush #48
    //   371: invokespecial a : (CC)Z
    //   374: ifne -> 422
    //   377: aload_0
    //   378: aload #5
    //   380: iload_2
    //   381: invokespecial a : (Ljava/util/List;C)V
    //   384: goto -> 422
    //   387: aload #5
    //   389: ldc_w 'cn_take_dinner.mp3'
    //   392: invokevirtual add : (Ljava/lang/Object;)Z
    //   395: pop
    //   396: aload_0
    //   397: getfield mContext : Landroid/content/Context;
    //   400: invokestatic cm : (Landroid/content/Context;)Lcom/laiqian/util/cm;
    //   403: aload_0
    //   404: aload #5
    //   406: invokespecial b : (Ljava/util/Vector;)Ljava/util/Vector;
    //   409: invokevirtual a : (Ljava/util/Vector;)V
    //   412: return
    //   413: astore_1
    //   414: aload_1
    //   415: invokestatic e : (Ljava/lang/Throwable;)V
    //   418: return
    //   419: goto -> 367
    //   422: iload_3
    //   423: iconst_1
    //   424: iadd
    //   425: istore_3
    //   426: goto -> 62
    // Exception table:
    //   from	to	target	type
    //   0	43	413	java/lang/Exception
    //   46	60	413	java/lang/Exception
    //   68	74	413	java/lang/Exception
    //   109	132	413	java/lang/Exception
    //   140	162	413	java/lang/Exception
    //   165	172	413	java/lang/Exception
    //   180	202	413	java/lang/Exception
    //   205	226	413	java/lang/Exception
    //   226	267	413	java/lang/Exception
    //   275	297	413	java/lang/Exception
    //   305	327	413	java/lang/Exception
    //   330	337	413	java/lang/Exception
    //   345	367	413	java/lang/Exception
    //   367	384	413	java/lang/Exception
    //   387	412	413	java/lang/Exception }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */