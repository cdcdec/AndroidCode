package com.laiqian.print.model.type.c;

import android.content.Context;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.c;
import com.laiqian.print.model.e;
import com.laiqian.print.model.s;
import com.laiqian.print.util.b;
import java.util.List;

public static enum a implements c {
  cIf;
  
  private boolean initialized = false;
  
  public static String getErrorMessage(int paramInt) {
    switch (paramInt) {
      default:
        return "Unknown";
      case 2:
        return "Transfer error";
      case 1:
        return "No such printer";
      case 0:
        break;
    } 
    return "Success";
  }
  
  public boolean connect(s params) {
    int i = params.getType();
    boolean bool = false;
    if (i == 4) {
      if (!(params instanceof c))
        return false; 
      params = (c)params;
      bool1 = params.agT();
      null = null;
      s s1 = null;
      try {
      
      } catch (Exception params) {
      
      } finally {
        params = s1;
        if (params != null)
          params.close(); 
      } 
      bool1 = bool;
      if (params != null) {
        params.close();
        bool1 = bool;
      } 
      return bool1;
    } 
    return false;
  }
  
  public void init(Context paramContext) { this.initialized = true; }
  
  public boolean isConnected(s params) { return false; }
  
  public boolean isInitialized() { return this.initialized; }
  
  public int print(s params, byte[] paramArrayOfByte) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual getType : ()I
    //   4: iconst_4
    //   5: if_icmpne -> 324
    //   8: aload_1
    //   9: instanceof com/laiqian/print/model/type/c/c
    //   12: ifne -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: aload_1
    //   18: checkcast com/laiqian/print/model/type/c/c
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual agT : ()Z
    //   26: istore #7
    //   28: new me/raid/libserialport/serialport/SerialPort
    //   31: dup
    //   32: new java/io/File
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual getPath : ()Ljava/lang/String;
    //   40: invokespecial <init> : (Ljava/lang/String;)V
    //   43: aload_1
    //   44: invokevirtual getBaudrate : ()I
    //   47: iconst_0
    //   48: iload #7
    //   50: invokespecial <init> : (Ljava/io/File;IIZ)V
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual open : ()V
    //   58: iconst_0
    //   59: istore_3
    //   60: goto -> 67
    //   63: aconst_null
    //   64: astore_1
    //   65: iconst_1
    //   66: istore_3
    //   67: iload_3
    //   68: istore #4
    //   70: aload_1
    //   71: ifnull -> 321
    //   74: aload_1
    //   75: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   78: astore #8
    //   80: aload_1
    //   81: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   84: astore #9
    //   86: aload #8
    //   88: ifnull -> 312
    //   91: new java/io/ByteArrayInputStream
    //   94: dup
    //   95: aload_2
    //   96: invokespecial <init> : ([B)V
    //   99: astore_2
    //   100: invokestatic newSingleThreadExecutor : ()Ljava/util/concurrent/ExecutorService;
    //   103: astore #10
    //   105: iconst_1
    //   106: istore #6
    //   108: iconst_0
    //   109: istore #5
    //   111: aload_2
    //   112: invokevirtual available : ()I
    //   115: ifle -> 297
    //   118: iload #6
    //   120: ifeq -> 147
    //   123: bipush #8
    //   125: newarray byte
    //   127: astore #11
    //   129: aload #8
    //   131: aload #11
    //   133: iconst_0
    //   134: aload_2
    //   135: aload #11
    //   137: iconst_0
    //   138: aload #11
    //   140: arraylength
    //   141: invokevirtual read : ([BII)I
    //   144: invokevirtual write : ([BII)V
    //   147: aload_2
    //   148: invokevirtual available : ()I
    //   151: ifle -> 111
    //   154: iload #5
    //   156: ifne -> 111
    //   159: aload #10
    //   161: new com/laiqian/print/model/type/c/b
    //   164: dup
    //   165: aload_0
    //   166: aload #9
    //   168: invokespecial <init> : (Lcom/laiqian/print/model/type/c/a;Ljava/io/InputStream;)V
    //   171: invokeinterface submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   176: astore #11
    //   178: aload #11
    //   180: ldc2_w 300
    //   183: getstatic java/util/concurrent/TimeUnit.MILLISECONDS : Ljava/util/concurrent/TimeUnit;
    //   186: invokeinterface get : (JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   191: checkcast java/lang/Boolean
    //   194: astore #12
    //   196: iload #6
    //   198: ifeq -> 215
    //   201: aload #12
    //   203: invokevirtual booleanValue : ()Z
    //   206: ifne -> 215
    //   209: iconst_0
    //   210: istore #4
    //   212: goto -> 243
    //   215: iload #6
    //   217: istore #4
    //   219: iload #6
    //   221: ifne -> 243
    //   224: aload #12
    //   226: invokevirtual booleanValue : ()Z
    //   229: istore #7
    //   231: iload #6
    //   233: istore #4
    //   235: iload #7
    //   237: ifeq -> 243
    //   240: iconst_1
    //   241: istore #4
    //   243: aload #11
    //   245: iconst_1
    //   246: invokeinterface cancel : (Z)Z
    //   251: pop
    //   252: iload #4
    //   254: istore #6
    //   256: goto -> 111
    //   259: astore_1
    //   260: goto -> 286
    //   263: ldc 'SerialPrintManager'
    //   265: ldc 'timeout, fallback to no flow control'
    //   267: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   270: pop
    //   271: aload #11
    //   273: iconst_1
    //   274: invokeinterface cancel : (Z)Z
    //   279: pop
    //   280: iconst_1
    //   281: istore #5
    //   283: goto -> 111
    //   286: aload #11
    //   288: iconst_1
    //   289: invokeinterface cancel : (Z)Z
    //   294: pop
    //   295: aload_1
    //   296: athrow
    //   297: aload #8
    //   299: invokevirtual flush : ()V
    //   302: aload #8
    //   304: invokevirtual close : ()V
    //   307: aload #9
    //   309: invokevirtual close : ()V
    //   312: aload_1
    //   313: invokevirtual close : ()V
    //   316: iload_3
    //   317: ireturn
    //   318: iconst_2
    //   319: istore #4
    //   321: iload #4
    //   323: ireturn
    //   324: iconst_1
    //   325: ireturn
    //   326: astore_1
    //   327: goto -> 63
    //   330: astore #8
    //   332: goto -> 65
    //   335: astore_1
    //   336: goto -> 318
    //   339: astore #12
    //   341: iload #6
    //   343: istore #4
    //   345: goto -> 243
    //   348: astore #12
    //   350: goto -> 263
    // Exception table:
    //   from	to	target	type
    //   28	54	326	java/lang/Exception
    //   54	58	330	java/lang/Exception
    //   74	86	335	java/io/IOException
    //   91	105	335	java/io/IOException
    //   111	118	335	java/io/IOException
    //   123	147	335	java/io/IOException
    //   147	154	335	java/io/IOException
    //   159	178	335	java/io/IOException
    //   178	196	339	java/lang/InterruptedException
    //   178	196	339	java/util/concurrent/ExecutionException
    //   178	196	348	java/util/concurrent/TimeoutException
    //   178	196	259	finally
    //   201	209	339	java/lang/InterruptedException
    //   201	209	339	java/util/concurrent/ExecutionException
    //   201	209	348	java/util/concurrent/TimeoutException
    //   201	209	259	finally
    //   224	231	339	java/lang/InterruptedException
    //   224	231	339	java/util/concurrent/ExecutionException
    //   224	231	348	java/util/concurrent/TimeoutException
    //   224	231	259	finally
    //   243	252	335	java/io/IOException
    //   263	271	259	finally
    //   271	280	335	java/io/IOException
    //   286	297	335	java/io/IOException
    //   297	312	335	java/io/IOException
    //   312	316	335	java/io/IOException }
  
  public void print(e parame) {
    parame.onStart();
    int i = 0;
    b b = new b(false);
    List list = parame.ags();
    int j = list.size();
    while (i < j) {
      b.s(parame.agt().a((PrintContent)list.get(i), parame.aew()));
      i++;
    } 
    i = print(parame.aew(), b.toByteArray());
    parame.setResultCode(i);
    parame.lp(getErrorMessage(i));
    if (i == 0) {
      parame.xx();
      return;
    } 
    parame.afv();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\type\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */