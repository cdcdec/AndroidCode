package com.laiqian.models;

import android.support.v4.content.AsyncTaskLoader;

public class PosTelephoneAddModel extends l {
  public boolean QL() { return super.QL(); }
  
  public static class OnlineSyncTask extends AsyncTaskLoader<Boolean> {
    private String btA;
    
    private String btz;
    
    public Boolean LN() { // Byte code:
      //   0: new com/laiqian/online/OnlineSyncRequest$a
      //   3: dup
      //   4: invokespecial <init> : ()V
      //   7: astore #5
      //   9: aconst_null
      //   10: astore #4
      //   12: new com/laiqian/models/l
      //   15: dup
      //   16: aload_0
      //   17: invokevirtual getContext : ()Landroid/content/Context;
      //   20: invokespecial <init> : (Landroid/content/Context;)V
      //   23: astore_3
      //   24: goto -> 34
      //   27: astore_3
      //   28: aload_3
      //   29: invokestatic e : (Ljava/lang/Throwable;)V
      //   32: aconst_null
      //   33: astore_3
      //   34: aload_3
      //   35: aload_0
      //   36: getfield btz : Ljava/lang/String;
      //   39: invokevirtual hd : (Ljava/lang/String;)Ljava/util/ArrayList;
      //   42: astore #6
      //   44: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   47: invokevirtual QV : ()I
      //   50: istore_1
      //   51: iconst_2
      //   52: istore_2
      //   53: iload_1
      //   54: ifne -> 62
      //   57: iconst_1
      //   58: istore_1
      //   59: goto -> 64
      //   62: iconst_2
      //   63: istore_1
      //   64: aload #5
      //   66: aload #6
      //   68: iload_1
      //   69: invokevirtual a : (Ljava/util/Collection;I)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   72: pop
      //   73: aload_3
      //   74: invokevirtual close : ()V
      //   77: aload #6
      //   79: invokevirtual iterator : ()Ljava/util/Iterator;
      //   82: astore_3
      //   83: aload_3
      //   84: invokeinterface hasNext : ()Z
      //   89: ifeq -> 118
      //   92: aload_3
      //   93: invokeinterface next : ()Ljava/lang/Object;
      //   98: checkcast com/laiqian/models/l$a
      //   101: getstatic com/laiqian/models/l.bPh : Lcom/laiqian/models/ao$b;
      //   104: invokevirtual a : (Lcom/laiqian/models/ao$b;)Lcom/laiqian/models/ao$c;
      //   107: dconst_0
      //   108: invokestatic valueOf : (D)Ljava/lang/Double;
      //   111: invokevirtual setValue : (Ljava/lang/Object;)Ljava/lang/Object;
      //   114: pop
      //   115: goto -> 83
      //   118: new com/laiqian/models/j
      //   121: dup
      //   122: aload_0
      //   123: invokevirtual getContext : ()Landroid/content/Context;
      //   126: invokespecial <init> : (Landroid/content/Context;)V
      //   129: astore_3
      //   130: goto -> 141
      //   133: astore_3
      //   134: aload_3
      //   135: invokestatic e : (Ljava/lang/Throwable;)V
      //   138: aload #4
      //   140: astore_3
      //   141: aload_3
      //   142: aload_0
      //   143: getfield btA : Ljava/lang/String;
      //   146: invokevirtual hd : (Ljava/lang/String;)Ljava/util/ArrayList;
      //   149: astore #4
      //   151: iload_2
      //   152: istore_1
      //   153: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   156: invokevirtual QV : ()I
      //   159: ifne -> 164
      //   162: iconst_1
      //   163: istore_1
      //   164: aload #5
      //   166: aload #4
      //   168: iload_1
      //   169: invokevirtual a : (Ljava/util/Collection;I)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   172: pop
      //   173: aload_3
      //   174: invokevirtual close : ()V
      //   177: new com/laiqian/util/av
      //   180: dup
      //   181: aload_0
      //   182: invokevirtual getContext : ()Landroid/content/Context;
      //   185: invokespecial <init> : (Landroid/content/Context;)V
      //   188: astore_3
      //   189: aload #5
      //   191: aload_3
      //   192: invokevirtual Ea : ()Ljava/lang/String;
      //   195: invokevirtual iM : (Ljava/lang/String;)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   198: pop
      //   199: aload #5
      //   201: aload_3
      //   202: invokevirtual atr : ()Ljava/lang/String;
      //   205: invokevirtual iN : (Ljava/lang/String;)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   208: pop
      //   209: aload #5
      //   211: aload_3
      //   212: invokevirtual Tx : ()Ljava/lang/String;
      //   215: invokestatic parseLong : (Ljava/lang/String;)J
      //   218: invokevirtual bV : (J)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   221: pop
      //   222: aload_3
      //   223: invokevirtual close : ()V
      //   226: getstatic com/laiqian/online/f.bXQ : Lcom/laiqian/online/f;
      //   229: astore_3
      //   230: aload_3
      //   231: aload #5
      //   233: invokevirtual Xj : ()Lcom/laiqian/online/OnlineSyncRequest;
      //   236: invokevirtual a : (Lcom/laiqian/online/OnlineSyncRequest;)V
      //   239: iconst_1
      //   240: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   243: areturn
      //   244: astore_3
      //   245: new java/lang/StringBuilder
      //   248: dup
      //   249: invokespecial <init> : ()V
      //   252: astore #4
      //   254: aload #4
      //   256: ldc '实时同步失败'
      //   258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   261: pop
      //   262: aload #4
      //   264: aload_3
      //   265: invokevirtual getMessage : ()Ljava/lang/String;
      //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   271: pop
      //   272: aload #4
      //   274: invokevirtual toString : ()Ljava/lang/String;
      //   277: iconst_0
      //   278: anewarray java/lang/Object
      //   281: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
      //   284: aload_3
      //   285: invokestatic e : (Ljava/lang/Throwable;)V
      //   288: iconst_0
      //   289: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   292: areturn
      // Exception table:
      //   from	to	target	type
      //   12	24	27	java/lang/Exception
      //   118	130	133	java/lang/Exception
      //   230	239	244	java/lang/Exception }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\PosTelephoneAddModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */