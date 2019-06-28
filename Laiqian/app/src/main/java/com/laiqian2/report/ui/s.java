package com.laiqian.report.ui;

class s implements Runnable {
  s(OrderDetailsByReturn paramOrderDetailsByReturn) {}
  
  public void run() { // Byte code:
    //   0: aload_0
    //   1: getfield deB : Lcom/laiqian/report/ui/OrderDetailsByReturn;
    //   4: invokestatic b : (Lcom/laiqian/report/ui/OrderDetailsByReturn;)Ljava/util/ArrayList;
    //   7: invokevirtual size : ()I
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: getfield deB : Lcom/laiqian/report/ui/OrderDetailsByReturn;
    //   17: invokestatic b : (Lcom/laiqian/report/ui/OrderDetailsByReturn;)Ljava/util/ArrayList;
    //   20: invokevirtual size : ()I
    //   23: ifle -> 210
    //   26: aload_0
    //   27: getfield deB : Lcom/laiqian/report/ui/OrderDetailsByReturn;
    //   30: invokestatic b : (Lcom/laiqian/report/ui/OrderDetailsByReturn;)Ljava/util/ArrayList;
    //   33: iconst_0
    //   34: invokevirtual get : (I)Ljava/lang/Object;
    //   37: checkcast java/lang/String
    //   40: astore_3
    //   41: aload_3
    //   42: invokestatic fl : (Ljava/lang/String;)Ljava/util/HashMap;
    //   45: astore #4
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #5
    //   56: aload #5
    //   58: ldc '撤销团购券的返回值：'
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload #5
    //   66: aload #4
    //   68: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload #5
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: invokestatic println : (Ljava/lang/Object;)V
    //   80: aload #4
    //   82: ifnull -> 197
    //   85: aload #4
    //   87: ldc 'data'
    //   89: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore #5
    //   94: aload #4
    //   96: ldc 'error'
    //   98: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   101: astore #4
    //   103: aload #5
    //   105: ifnull -> 172
    //   108: aload #4
    //   110: ifnull -> 124
    //   113: aload #4
    //   115: invokevirtual toString : ()Ljava/lang/String;
    //   118: invokestatic isNull : (Ljava/lang/String;)Z
    //   121: ifeq -> 172
    //   124: aload #5
    //   126: checkcast org/json/JSONObject
    //   129: astore #4
    //   131: aload #4
    //   133: ldc 'result'
    //   135: iconst_m1
    //   136: invokevirtual optInt : (Ljava/lang/String;I)I
    //   139: ifne -> 161
    //   142: aload_0
    //   143: getfield deB : Lcom/laiqian/report/ui/OrderDetailsByReturn;
    //   146: invokestatic b : (Lcom/laiqian/report/ui/OrderDetailsByReturn;)Ljava/util/ArrayList;
    //   149: aload_3
    //   150: invokevirtual remove : (Ljava/lang/Object;)Z
    //   153: pop
    //   154: iload_1
    //   155: iconst_1
    //   156: iadd
    //   157: istore_1
    //   158: goto -> 13
    //   161: aload #4
    //   163: ldc 'message'
    //   165: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   168: astore_3
    //   169: goto -> 212
    //   172: aload #4
    //   174: ifnull -> 191
    //   177: aload #4
    //   179: checkcast org/json/JSONObject
    //   182: ldc 'message'
    //   184: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   187: astore_3
    //   188: goto -> 212
    //   191: ldc '异常，返回值错误'
    //   193: astore_3
    //   194: goto -> 212
    //   197: aload_0
    //   198: getfield deB : Lcom/laiqian/report/ui/OrderDetailsByReturn;
    //   201: ldc 2131625879
    //   203: invokevirtual getString : (I)Ljava/lang/String;
    //   206: astore_3
    //   207: goto -> 212
    //   210: aconst_null
    //   211: astore_3
    //   212: aload_0
    //   213: getfield deB : Lcom/laiqian/report/ui/OrderDetailsByReturn;
    //   216: invokestatic c : (Lcom/laiqian/report/ui/OrderDetailsByReturn;)Landroid/os/Handler;
    //   219: bipush #66
    //   221: iload_1
    //   222: iload_2
    //   223: iload_1
    //   224: isub
    //   225: aload_3
    //   226: invokevirtual obtainMessage : (IIILjava/lang/Object;)Landroid/os/Message;
    //   229: invokevirtual sendToTarget : ()V
    //   232: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */