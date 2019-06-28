package com.laiqian.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.bd;

public class aw extends ba {
  public aw(Context paramContext) { super(paramContext); }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long[] paramArrayOfLong) {
    String[] arrayOfString = new String[paramArrayOfLong.length];
    ay = new ay(this.mContext);
    try {
      ay.Vq().beginTransaction();
    } catch (Exception exception) {
      a.e(exception);
    } 
    try {
      am("_id", paramString1);
      am("sName", paramString2);
      am("fValue", paramString3);
      am("nType", paramString4);
      am("nUpdateFlag", "0");
      am("nIsClosed", paramString5);
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append("");
      am("nDateTime", stringBuilder.toString());
      boolean bool1 = QL();
      bool = bool1;
      if (bool1) {
        bool = bool1;
        byte b;
        for (b = 0; b < paramArrayOfLong.length; b++) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramString1);
          stringBuilder.append(b);
          arrayOfString[b] = stringBuilder.toString();
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramString1);
          stringBuilder.append(b);
          stringBuilder.append("");
          ay.am("_id", stringBuilder.toString());
          ay.am("nTaxID", paramString1);
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramArrayOfLong[b]);
          stringBuilder.append("");
          ay.am("nProductID", stringBuilder.toString());
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramString1);
          stringBuilder.append("");
          ay.am("nDateTime", stringBuilder.toString());
          am("nUpdateFlag", "0");
          bool = ay.QL();
        } 
      } 
      if (bool)
        ay.Vq().setTransactionSuccessful(); 
    } catch (Exception paramString2) {
      try {
        ay.Vq().endTransaction();
      } catch (Exception paramString2) {
        a.e(paramString2);
      } 
    } finally {
      try {
        ay.Vq().endTransaction();
      } catch (Exception paramString2) {
        a.e(paramString2);
      } 
    } 
    ay.close();
    if (bool && bd.bH(this.mContext))
      (new a(this.mContext, paramString1, arrayOfString)).start(); 
    return bool;
  }
  
  public static class a extends Thread {
    private String bTF;
    
    private String[] bTG;
    
    private Context mContext;
    
    public a(Context param1Context, String param1String, String[] param1ArrayOfString) {
      this.mContext = param1Context;
      this.bTF = param1String;
      this.bTG = param1ArrayOfString;
    }
    
    public void run() { // Byte code:
      //   0: aload_0
      //   1: invokespecial run : ()V
      //   4: new com/laiqian/online/OnlineSyncRequest$a
      //   7: dup
      //   8: invokespecial <init> : ()V
      //   11: astore #5
      //   13: new com/laiqian/models/ba
      //   16: dup
      //   17: aload_0
      //   18: getfield mContext : Landroid/content/Context;
      //   21: invokespecial <init> : (Landroid/content/Context;)V
      //   24: astore_3
      //   25: aload #5
      //   27: aload_3
      //   28: aload_0
      //   29: getfield bTF : Ljava/lang/String;
      //   32: invokevirtual gZ : (Ljava/lang/String;)Ljava/util/ArrayList;
      //   35: iconst_1
      //   36: invokevirtual a : (Ljava/util/Collection;I)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   39: pop
      //   40: new com/laiqian/models/ax
      //   43: dup
      //   44: aload_0
      //   45: getfield mContext : Landroid/content/Context;
      //   48: invokespecial <init> : (Landroid/content/Context;)V
      //   51: astore #4
      //   53: aload_0
      //   54: getfield bTG : [Ljava/lang/String;
      //   57: astore #6
      //   59: aload #6
      //   61: arraylength
      //   62: istore_2
      //   63: iconst_0
      //   64: istore_1
      //   65: iload_1
      //   66: iload_2
      //   67: if_icmpge -> 93
      //   70: aload #5
      //   72: aload #4
      //   74: aload #6
      //   76: iload_1
      //   77: aaload
      //   78: invokevirtual hE : (Ljava/lang/String;)Ljava/util/ArrayList;
      //   81: iconst_1
      //   82: invokevirtual a : (Ljava/util/Collection;I)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   85: pop
      //   86: iload_1
      //   87: iconst_1
      //   88: iadd
      //   89: istore_1
      //   90: goto -> 65
      //   93: aload #5
      //   95: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   98: invokevirtual Ea : ()Ljava/lang/String;
      //   101: invokevirtual iM : (Ljava/lang/String;)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   104: pop
      //   105: aload #5
      //   107: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   110: invokevirtual atr : ()Ljava/lang/String;
      //   113: invokevirtual iN : (Ljava/lang/String;)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   116: pop
      //   117: aload #5
      //   119: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
      //   122: invokevirtual Tx : ()Ljava/lang/String;
      //   125: invokestatic parseLong : (Ljava/lang/String;)J
      //   128: invokevirtual bV : (J)Lcom/laiqian/online/OnlineSyncRequest$a;
      //   131: pop
      //   132: getstatic com/laiqian/online/f.bXQ : Lcom/laiqian/online/f;
      //   135: astore #6
      //   137: aload #6
      //   139: aload #5
      //   141: invokevirtual Xj : ()Lcom/laiqian/online/OnlineSyncRequest;
      //   144: invokevirtual a : (Lcom/laiqian/online/OnlineSyncRequest;)V
      //   147: aload_3
      //   148: invokevirtual close : ()V
      //   151: aload #4
      //   153: invokevirtual close : ()V
      //   156: return
      //   157: astore #5
      //   159: goto -> 208
      //   162: astore #5
      //   164: new java/lang/StringBuilder
      //   167: dup
      //   168: invokespecial <init> : ()V
      //   171: astore #6
      //   173: aload #6
      //   175: ldc '请求实时同步失败'
      //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   180: pop
      //   181: aload #6
      //   183: aload #5
      //   185: invokevirtual getMessage : ()Ljava/lang/String;
      //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: pop
      //   192: aload #6
      //   194: invokevirtual toString : ()Ljava/lang/String;
      //   197: invokestatic println : (Ljava/lang/Object;)V
      //   200: aload #5
      //   202: invokestatic e : (Ljava/lang/Throwable;)V
      //   205: goto -> 147
      //   208: aload_3
      //   209: invokevirtual close : ()V
      //   212: aload #4
      //   214: invokevirtual close : ()V
      //   217: aload #5
      //   219: athrow
      // Exception table:
      //   from	to	target	type
      //   137	147	162	java/lang/Exception
      //   137	147	157	finally
      //   164	205	157	finally }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */