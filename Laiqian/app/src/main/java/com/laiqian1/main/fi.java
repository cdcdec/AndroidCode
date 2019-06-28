package com.laiqian.main;

import com.laiqian.util.n;

public class fi extends Thread {
  private String bfo;
  
  private String bfp;
  
  public fi(Exception paramException, String paramString) { // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_1
    //   5: invokevirtual getStackTrace : ()[Ljava/lang/StackTraceElement;
    //   8: astore #5
    //   10: new java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: astore #6
    //   19: new java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: astore #7
    //   28: aload #7
    //   30: aload_1
    //   31: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload #7
    //   37: ldc '<br>'
    //   39: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload #6
    //   45: aload #7
    //   47: invokevirtual toString : ()Ljava/lang/String;
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload #5
    //   56: arraylength
    //   57: istore #4
    //   59: iconst_0
    //   60: istore_3
    //   61: iload_3
    //   62: iload #4
    //   64: if_icmpge -> 114
    //   67: aload #5
    //   69: iload_3
    //   70: aaload
    //   71: astore_1
    //   72: new java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: astore #7
    //   81: aload #7
    //   83: aload_1
    //   84: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload #7
    //   90: ldc '<br>'
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload #6
    //   98: aload #7
    //   100: invokevirtual toString : ()Ljava/lang/String;
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: iload_3
    //   108: iconst_1
    //   109: iadd
    //   110: istore_3
    //   111: goto -> 61
    //   114: aload_0
    //   115: aload #6
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: putfield bfp : Ljava/lang/String;
    //   123: aload_0
    //   124: aload_2
    //   125: putfield bfo : Ljava/lang/String;
    //   128: return }
  
  public void run() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bfo);
    stringBuilder.append("-交易记录存储失败");
    String str1 = stringBuilder.toString();
    String str2 = this.bfp;
    n.a(new String[] { "crash@91laiqian.com" }, str1, str2, null, null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\fi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */