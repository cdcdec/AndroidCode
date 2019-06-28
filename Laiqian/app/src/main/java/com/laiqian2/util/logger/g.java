package com.laiqian.util.logger;

import android.text.TextUtils;

final class g implements k {
  private final ThreadLocal<String> dHo = new ThreadLocal();
  
  private final ThreadLocal<Integer> dHp = new ThreadLocal();
  
  private l dHq;
  
  private String tag;
  
  private int a(StackTraceElement[] paramArrayOfStackTraceElement) {
    for (byte b = 3; b < paramArrayOfStackTraceElement.length; b++) {
      String str = paramArrayOfStackTraceElement[b].getClassName();
      if (!str.equals(g.class.getName()) && !str.equals(com.orhanobut.logger.d.class.getName()))
        return b - 1; 
    } 
    return -1;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2) {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (this.dHq.awQ()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("║ Thread: ");
      stringBuilder.append(Thread.currentThread().getName());
      d(paramInt1, paramString, stringBuilder.toString());
      w(paramInt1, paramString);
    } 
    String str2 = "";
    int j = a(arrayOfStackTraceElement) + this.dHq.awS();
    String str1 = str2;
    int i = paramInt2;
    if (paramInt2 + j > arrayOfStackTraceElement.length) {
      i = arrayOfStackTraceElement.length - j - 1;
      str1 = str2;
    } 
    while (i > 0) {
      paramInt2 = i + j;
      if (paramInt2 < arrayOfStackTraceElement.length) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("║ ");
        stringBuilder1.append(str1);
        stringBuilder1.append(sk(arrayOfStackTraceElement[paramInt2].getClassName()));
        stringBuilder1.append(".");
        stringBuilder1.append(arrayOfStackTraceElement[paramInt2].getMethodName());
        stringBuilder1.append(" ");
        stringBuilder1.append(" (");
        stringBuilder1.append(arrayOfStackTraceElement[paramInt2].getFileName());
        stringBuilder1.append(":");
        stringBuilder1.append(arrayOfStackTraceElement[paramInt2].getLineNumber());
        stringBuilder1.append(")");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str1);
        stringBuilder2.append("   ");
        str1 = stringBuilder2.toString();
        d(paramInt1, paramString, stringBuilder1.toString());
      } 
      i--;
    } 
  }
  
  private void a(int paramInt, String paramString, Object... paramVarArgs) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield dHq : Lcom/laiqian/util/logger/l;
    //   6: invokevirtual awR : ()Lcom/laiqian/util/logger/e;
    //   9: astore #6
    //   11: getstatic com/laiqian/util/logger/e.dHm : Lcom/laiqian/util/logger/e;
    //   14: astore #7
    //   16: aload #6
    //   18: aload #7
    //   20: if_acmpne -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: invokespecial getTag : ()Ljava/lang/String;
    //   30: astore #6
    //   32: aload_0
    //   33: aload_2
    //   34: aload_3
    //   35: invokespecial f : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   38: astore_2
    //   39: aload_0
    //   40: invokespecial awO : ()I
    //   43: istore #4
    //   45: aload_0
    //   46: iload_1
    //   47: aload #6
    //   49: invokespecial u : (ILjava/lang/String;)V
    //   52: aload_0
    //   53: iload_1
    //   54: aload #6
    //   56: iload #4
    //   58: invokespecial a : (ILjava/lang/String;I)V
    //   61: aload_2
    //   62: invokevirtual getBytes : ()[B
    //   65: astore_3
    //   66: aload_3
    //   67: arraylength
    //   68: istore #5
    //   70: iload #5
    //   72: sipush #4000
    //   75: if_icmpgt -> 108
    //   78: iload #4
    //   80: ifle -> 90
    //   83: aload_0
    //   84: iload_1
    //   85: aload #6
    //   87: invokespecial w : (ILjava/lang/String;)V
    //   90: aload_0
    //   91: iload_1
    //   92: aload #6
    //   94: aload_2
    //   95: invokespecial c : (ILjava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: iload_1
    //   100: aload #6
    //   102: invokespecial v : (ILjava/lang/String;)V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: iload #4
    //   110: ifle -> 184
    //   113: aload_0
    //   114: iload_1
    //   115: aload #6
    //   117: invokespecial w : (ILjava/lang/String;)V
    //   120: goto -> 184
    //   123: iload #4
    //   125: iload #5
    //   127: if_icmpge -> 169
    //   130: aload_0
    //   131: iload_1
    //   132: aload #6
    //   134: new java/lang/String
    //   137: dup
    //   138: aload_3
    //   139: iload #4
    //   141: iload #5
    //   143: iload #4
    //   145: isub
    //   146: sipush #4000
    //   149: invokestatic min : (II)I
    //   152: invokespecial <init> : ([BII)V
    //   155: invokespecial c : (ILjava/lang/String;Ljava/lang/String;)V
    //   158: iload #4
    //   160: sipush #4000
    //   163: iadd
    //   164: istore #4
    //   166: goto -> 123
    //   169: aload_0
    //   170: iload_1
    //   171: aload #6
    //   173: invokespecial v : (ILjava/lang/String;)V
    //   176: aload_0
    //   177: monitorexit
    //   178: return
    //   179: astore_2
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_2
    //   183: athrow
    //   184: iconst_0
    //   185: istore #4
    //   187: goto -> 123
    // Exception table:
    //   from	to	target	type
    //   2	16	179	finally
    //   26	70	179	finally
    //   83	90	179	finally
    //   90	105	179	finally
    //   113	120	179	finally
    //   130	158	179	finally
    //   169	176	179	finally }
  
  private int awO() {
    Integer integer = (Integer)this.dHp.get();
    int i = this.dHq.awO();
    if (integer != null) {
      this.dHp.remove();
      i = integer.intValue();
    } 
    if (i < 0)
      throw new IllegalStateException("methodCount cannot be negative"); 
    return i;
  }
  
  private void c(int paramInt, String paramString1, String paramString2) {
    for (String str : paramString2.split(System.getProperty("line.separator"))) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("║ ");
      stringBuilder.append(str);
      d(paramInt, paramString1, stringBuilder.toString());
    } 
  }
  
  private void d(int paramInt, String paramString1, String paramString2) {
    paramString1 = sl(paramString1);
    if (paramInt != 2) {
      switch (paramInt) {
        default:
          this.dHq.awT().d(paramString1, paramString2);
          return;
        case 7:
          this.dHq.awT().bC(paramString1, paramString2);
          return;
        case 6:
          this.dHq.awT().e(paramString1, paramString2);
          return;
        case 5:
          this.dHq.awT().bz(paramString1, paramString2);
          return;
        case 4:
          break;
      } 
      this.dHq.awT().bA(paramString1, paramString2);
      return;
    } 
    this.dHq.awT().bB(paramString1, paramString2);
  }
  
  private String f(String paramString, Object... paramVarArgs) { return (paramVarArgs.length == 0) ? paramString : String.format(paramString, paramVarArgs); }
  
  private String getTag() {
    String str = (String)this.dHo.get();
    if (str != null) {
      this.dHo.remove();
      return str;
    } 
    return this.tag;
  }
  
  private String sk(String paramString) { return paramString.substring(paramString.lastIndexOf(".") + 1); }
  
  private String sl(String paramString) {
    if (!TextUtils.isEmpty(paramString) && !TextUtils.equals(this.tag, paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.tag);
      stringBuilder.append("-");
      stringBuilder.append(paramString);
      return stringBuilder.toString();
    } 
    return this.tag;
  }
  
  private void u(int paramInt, String paramString) { d(paramInt, paramString, "╔════════════════════════════════════════════════════════════════════════════════════════"); }
  
  private void v(int paramInt, String paramString) { d(paramInt, paramString, "╚════════════════════════════════════════════════════════════════════════════════════════"); }
  
  private void w(int paramInt, String paramString) { d(paramInt, paramString, "╟────────────────────────────────────────────────────────────────────────────────────────"); }
  
  public void a(Throwable paramThrowable, String paramString, Object... paramVarArgs) {
    String str2 = paramString;
    if (paramThrowable != null) {
      str2 = paramString;
      if (paramString != null) {
        null = new StringBuilder();
        null.append(paramString);
        null.append(" : ");
        null.append(paramThrowable.toString());
        str2 = null.toString();
      } 
    } 
    paramString = str2;
    if (paramThrowable != null) {
      paramString = str2;
      if (str2 == null)
        paramString = paramThrowable.toString(); 
    } 
    String str1 = paramString;
    if (paramString == null)
      str1 = "No message/exception is set"; 
    a(6, str1, paramVarArgs);
  }
  
  public void b(String paramString, Object... paramVarArgs) { a(3, paramString, paramVarArgs); }
  
  public void d(String paramString, Object... paramVarArgs) { a(4, paramString, paramVarArgs); }
  
  public void e(String paramString, Object... paramVarArgs) { a(5, paramString, paramVarArgs); }
  
  public l si(String paramString) {
    if (paramString == null)
      throw new NullPointerException("tag may not be null"); 
    if (paramString.trim().length() == 0)
      throw new IllegalStateException("tag may not be empty"); 
    this.tag = paramString;
    this.dHq = new l();
    return this.dHq;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\logger\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */