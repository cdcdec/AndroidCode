package com.laiqian.print.model.type.b;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.c;
import com.laiqian.print.model.e;
import com.laiqian.print.model.s;
import com.laiqian.print.util.b;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public static enum a implements c {
  cHO;
  
  private ThreadLocal<Socket> cHG = new ThreadLocal();
  
  private int cHP = 3;
  
  private boolean initialized = false;
  
  public static String getErrorMessage(int paramInt) {
    switch (paramInt) {
      default:
        return "Unknown";
      case 2:
        return "Transfer failed";
      case 1:
        return "Cannot connect to printer";
      case 0:
        break;
    } 
    return "Success";
  }
  
  public boolean connect(s params) {
    if (params.getType() == 2) {
      if (!(params instanceof c))
        return false; 
      null = (c)params;
      socket = (Socket)this.cHG.get();
      if (socket != null && socket.isConnected() && !socket.isClosed() && !socket.isOutputShutdown())
        return true; 
      socket = new Socket();
      try {
        socket.connect(new InetSocketAddress(null.getAddress(), null.getPort()), 5000);
        this.cHG.set(socket);
        return true;
      } catch (IOException null) {
        try {
          return false;
        } catch (IOException socket) {
          return false;
        } 
      } finally {
        try {
          socket.close();
        } catch (IOException socket) {
          a.e(socket);
        } 
      } 
    } 
    return false;
  }
  
  public void init(Context paramContext) { this.initialized = true; }
  
  public boolean isConnected(s params) { return false; }
  
  public boolean isInitialized() { return this.initialized; }
  
  public int print(s params, byte[] paramArrayOfByte) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual getType : ()I
    //   4: istore_3
    //   5: iconst_2
    //   6: istore #5
    //   8: iload_3
    //   9: iconst_2
    //   10: if_icmpne -> 360
    //   13: aload_1
    //   14: instanceof com/laiqian/print/model/type/b/c
    //   17: ifne -> 22
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_1
    //   23: checkcast com/laiqian/print/model/type/b/c
    //   26: astore #6
    //   28: aload_0
    //   29: getfield cHG : Ljava/lang/ThreadLocal;
    //   32: invokevirtual get : ()Ljava/lang/Object;
    //   35: checkcast java/net/Socket
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull -> 72
    //   43: aload_1
    //   44: invokevirtual isConnected : ()Z
    //   47: ifeq -> 72
    //   50: aload_1
    //   51: invokevirtual isClosed : ()Z
    //   54: ifne -> 72
    //   57: aload_1
    //   58: invokevirtual isOutputShutdown : ()Z
    //   61: ifeq -> 67
    //   64: goto -> 72
    //   67: iconst_0
    //   68: istore_3
    //   69: goto -> 192
    //   72: iconst_0
    //   73: istore #4
    //   75: iconst_0
    //   76: istore_3
    //   77: iload #4
    //   79: aload_0
    //   80: getfield cHP : I
    //   83: if_icmpge -> 192
    //   86: new java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial <init> : ()V
    //   93: astore_1
    //   94: aload_1
    //   95: ldc 'try '
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_1
    //   102: iload #4
    //   104: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: ldc 'tag'
    //   110: aload_1
    //   111: invokevirtual toString : ()Ljava/lang/String;
    //   114: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   117: pop
    //   118: new java/net/Socket
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: astore_1
    //   126: aload_1
    //   127: new java/net/InetSocketAddress
    //   130: dup
    //   131: aload #6
    //   133: invokevirtual getAddress : ()Ljava/lang/String;
    //   136: aload #6
    //   138: invokevirtual getPort : ()I
    //   141: invokespecial <init> : (Ljava/lang/String;I)V
    //   144: sipush #5000
    //   147: invokevirtual connect : (Ljava/net/SocketAddress;I)V
    //   150: ldc 'tag'
    //   152: ldc 'connect success'
    //   154: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: iconst_0
    //   159: istore_3
    //   160: goto -> 173
    //   163: ldc 'tag'
    //   165: ldc 'connect failed'
    //   167: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   170: pop
    //   171: iconst_1
    //   172: istore_3
    //   173: aload_1
    //   174: invokevirtual isConnected : ()Z
    //   177: ifeq -> 183
    //   180: goto -> 192
    //   183: iload #4
    //   185: iconst_1
    //   186: iadd
    //   187: istore #4
    //   189: goto -> 77
    //   192: aload_1
    //   193: ifnull -> 348
    //   196: aload_1
    //   197: invokevirtual isConnected : ()Z
    //   200: ifeq -> 348
    //   203: aload_1
    //   204: invokevirtual isClosed : ()Z
    //   207: ifne -> 348
    //   210: aload_1
    //   211: invokevirtual isOutputShutdown : ()Z
    //   214: ifeq -> 220
    //   217: goto -> 348
    //   220: aload_0
    //   221: getfield cHG : Ljava/lang/ThreadLocal;
    //   224: aload_1
    //   225: invokevirtual set : (Ljava/lang/Object;)V
    //   228: aload_1
    //   229: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   232: astore #6
    //   234: aload #6
    //   236: ifnull -> 323
    //   239: new java/io/ByteArrayInputStream
    //   242: dup
    //   243: aload_2
    //   244: invokespecial <init> : ([B)V
    //   247: astore_2
    //   248: aload_2
    //   249: invokevirtual available : ()I
    //   252: ifle -> 307
    //   255: sipush #1024
    //   258: aload_2
    //   259: invokevirtual available : ()I
    //   262: invokestatic min : (II)I
    //   265: newarray byte
    //   267: astore #7
    //   269: aload_2
    //   270: aload #7
    //   272: invokevirtual read : ([B)I
    //   275: pop
    //   276: aload #6
    //   278: aload #7
    //   280: invokevirtual write : ([B)V
    //   283: aload #6
    //   285: invokevirtual flush : ()V
    //   288: ldc2_w 100
    //   291: invokestatic sleep : (J)V
    //   294: goto -> 248
    //   297: astore #7
    //   299: aload #7
    //   301: invokestatic e : (Ljava/lang/Throwable;)V
    //   304: goto -> 248
    //   307: aload #6
    //   309: invokevirtual close : ()V
    //   312: ldc 'tag'
    //   314: ldc 'transfer successful'
    //   316: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   319: pop
    //   320: goto -> 331
    //   323: ldc 'tag'
    //   325: ldc 'what? null outStream'
    //   327: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   330: pop
    //   331: goto -> 350
    //   334: ldc 'tag'
    //   336: ldc 'transfer failed'
    //   338: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   341: pop
    //   342: iload #5
    //   344: istore_3
    //   345: goto -> 350
    //   348: iconst_1
    //   349: istore_3
    //   350: aload_1
    //   351: ifnull -> 358
    //   354: aload_1
    //   355: invokevirtual close : ()V
    //   358: iload_3
    //   359: ireturn
    //   360: iconst_1
    //   361: ireturn
    //   362: astore #7
    //   364: goto -> 163
    //   367: astore_2
    //   368: goto -> 334
    //   371: astore_1
    //   372: iload_3
    //   373: ireturn
    // Exception table:
    //   from	to	target	type
    //   126	158	362	java/io/IOException
    //   228	234	367	java/io/IOException
    //   239	248	367	java/io/IOException
    //   248	288	367	java/io/IOException
    //   288	294	297	java/lang/InterruptedException
    //   288	294	367	java/io/IOException
    //   299	304	367	java/io/IOException
    //   307	320	367	java/io/IOException
    //   323	331	367	java/io/IOException
    //   354	358	371	java/io/IOException }
  
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\type\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */