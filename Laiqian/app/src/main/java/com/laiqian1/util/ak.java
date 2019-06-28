package com.laiqian.util;

public class ak {
  static Process dFl;
  
  static  {
  
  }
  
  public static void asR() {
    asS();
    asS();
  }
  
  private static boolean asS() { return qq("echo 1 > /sys/devices/platform/att_test/test/test\n"); }
  
  private static boolean qq(String paramString) { // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_2
    //   5: astore_1
    //   6: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   9: ldc 'su'
    //   11: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   14: putstatic com/laiqian/util/ak.dFl : Ljava/lang/Process;
    //   17: aload_2
    //   18: astore_1
    //   19: new java/io/DataOutputStream
    //   22: dup
    //   23: getstatic com/laiqian/util/ak.dFl : Ljava/lang/Process;
    //   26: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   29: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   32: astore_2
    //   33: aload_2
    //   34: aload_0
    //   35: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   38: aload_2
    //   39: invokevirtual flush : ()V
    //   42: aload_2
    //   43: invokevirtual close : ()V
    //   46: aload_2
    //   47: ifnull -> 61
    //   50: aload_2
    //   51: invokevirtual close : ()V
    //   54: iconst_1
    //   55: ireturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokestatic e : (Ljava/lang/Throwable;)V
    //   61: iconst_1
    //   62: ireturn
    //   63: aload_2
    //   64: astore_1
    //   65: goto -> 102
    //   68: astore_1
    //   69: aload_2
    //   70: astore_0
    //   71: aload_1
    //   72: astore_2
    //   73: goto -> 79
    //   76: astore_2
    //   77: aload_3
    //   78: astore_0
    //   79: aload_0
    //   80: astore_1
    //   81: aload_2
    //   82: invokestatic e : (Ljava/lang/Throwable;)V
    //   85: aload_0
    //   86: ifnull -> 100
    //   89: aload_0
    //   90: invokevirtual close : ()V
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_0
    //   96: aload_0
    //   97: invokestatic e : (Ljava/lang/Throwable;)V
    //   100: iconst_0
    //   101: ireturn
    //   102: aload_1
    //   103: ifnull -> 117
    //   106: aload_1
    //   107: invokevirtual close : ()V
    //   110: iconst_0
    //   111: ireturn
    //   112: astore_0
    //   113: aload_0
    //   114: invokestatic e : (Ljava/lang/Throwable;)V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_0
    //   120: goto -> 102
    //   123: astore_0
    //   124: goto -> 63
    // Exception table:
    //   from	to	target	type
    //   6	17	76	java/io/IOException
    //   6	17	119	finally
    //   19	33	76	java/io/IOException
    //   19	33	119	finally
    //   33	46	68	java/io/IOException
    //   33	46	123	finally
    //   50	54	56	java/io/IOException
    //   81	85	119	finally
    //   89	93	95	java/io/IOException
    //   106	110	112	java/io/IOException }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\util\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */