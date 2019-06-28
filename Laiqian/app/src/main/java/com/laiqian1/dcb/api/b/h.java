package com.laiqian.dcb.api.b;

public class h {
  public static void C(String paramString1, String paramString2) { // Byte code:
    //   0: invokestatic zg : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: invokestatic getExternalStorageState : ()Ljava/lang/String;
    //   10: ldc 'mounted'
    //   12: invokevirtual equals : (Ljava/lang/Object;)Z
    //   15: ifeq -> 172
    //   18: new java/io/File
    //   21: dup
    //   22: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   25: aload_1
    //   26: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_2
    //   30: aconst_null
    //   31: astore_3
    //   32: aconst_null
    //   33: astore #4
    //   35: aconst_null
    //   36: astore_1
    //   37: new java/io/FileOutputStream
    //   40: dup
    //   41: aload_2
    //   42: iconst_1
    //   43: invokespecial <init> : (Ljava/io/File;Z)V
    //   46: astore_2
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore_1
    //   55: aload_1
    //   56: ldc '\\n'
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_1
    //   63: aload_0
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_1
    //   69: ldc '\\n\\n'
    //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_2
    //   76: aload_1
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: ldc 'UTF-8'
    //   82: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   85: invokevirtual write : ([B)V
    //   88: aload_2
    //   89: invokevirtual flush : ()V
    //   92: aload_2
    //   93: invokevirtual close : ()V
    //   96: return
    //   97: astore_0
    //   98: goto -> 158
    //   101: astore_1
    //   102: aload_2
    //   103: astore_0
    //   104: aload_1
    //   105: astore_2
    //   106: goto -> 126
    //   109: astore_1
    //   110: aload_2
    //   111: astore_0
    //   112: aload_1
    //   113: astore_2
    //   114: goto -> 141
    //   117: astore_0
    //   118: aload_1
    //   119: astore_2
    //   120: goto -> 158
    //   123: astore_2
    //   124: aload_3
    //   125: astore_0
    //   126: aload_0
    //   127: astore_1
    //   128: aload_2
    //   129: invokestatic e : (Ljava/lang/Throwable;)V
    //   132: aload_0
    //   133: invokevirtual close : ()V
    //   136: return
    //   137: astore_2
    //   138: aload #4
    //   140: astore_0
    //   141: aload_0
    //   142: astore_1
    //   143: aload_2
    //   144: invokestatic e : (Ljava/lang/Throwable;)V
    //   147: aload_0
    //   148: invokevirtual close : ()V
    //   151: return
    //   152: astore_0
    //   153: aload_0
    //   154: invokestatic e : (Ljava/lang/Throwable;)V
    //   157: return
    //   158: aload_2
    //   159: invokevirtual close : ()V
    //   162: goto -> 170
    //   165: astore_1
    //   166: aload_1
    //   167: invokestatic e : (Ljava/lang/Throwable;)V
    //   170: aload_0
    //   171: athrow
    //   172: return
    // Exception table:
    //   from	to	target	type
    //   37	47	137	java/io/FileNotFoundException
    //   37	47	123	java/io/IOException
    //   37	47	117	finally
    //   47	92	109	java/io/FileNotFoundException
    //   47	92	101	java/io/IOException
    //   47	92	97	finally
    //   92	96	152	java/io/IOException
    //   128	132	117	finally
    //   132	136	152	java/io/IOException
    //   143	147	117	finally
    //   147	151	152	java/io/IOException
    //   158	162	165	java/io/IOException }
  
  public static void cF(String paramString) { C(paramString, "connect.txt"); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */