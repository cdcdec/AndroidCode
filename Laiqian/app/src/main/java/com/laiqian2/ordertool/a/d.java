package com.laiqian.ordertool.a;

import android.content.Context;
import com.laiqian.models.ba;
import com.laiqian.ordertool.ServerGet;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import java.util.ArrayList;

public class d implements a {
  private ServerGet cdv;
  
  private Context mContext;
  
  public d(Context paramContext, ServerGet paramServerGet) {
    this.mContext = paramContext;
    this.cdv = paramServerGet;
  }
  
  private static long a(a parama, PendingFullOrderDetail.a parama1, long paramLong, PendingFullOrderDetail.c paramc, PendingFullOrderDetail.d paramd1, PendingFullOrderDetail.d paramd2, ba paramba) {
    if (paramd1.bbX == paramd2.bbX && paramd1.id == paramd2.id) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramd1.aTO);
      stringBuilder.append("");
      if (stringBuilder.toString().toString().length() < 13 && paramd1.cpo < 0.0D) {
        if (paramd2.cpo + paramd1.cpo > 0.0D) {
          paramd2.cpo = paramd1.cpo;
          parama.b(paramd2);
          paramd2.aTR = paramba.s(paramd1.id, "86003");
          parama.a(paramd2, paramLong, paramd2.cpl.longValue(), parama1, paramd2.bbX);
          paramc.cpg.add(paramd2);
          return paramLong + 1L;
        } 
        if (paramd2.cpo + paramd1.cpo == 0.0D) {
          paramd2.cpo = -paramd2.cpo;
          paramd2.aTP = true;
          parama.b(paramd2);
          paramc.cpg.add(paramd2);
        } 
      } 
    } 
    return paramLong;
  }
  
  public static a a(ArrayList<PendingFullOrderDetail.d> paramArrayList1, a parama, ArrayList<PendingFullOrderDetail.d> paramArrayList2, PendingFullOrderDetail.a parama1, long paramLong, ba paramba) {
    long l;
    PendingFullOrderDetail.c c = new PendingFullOrderDetail.c();
    a a1 = new a();
    int i = paramArrayList2.size();
    int j = paramArrayList1.size();
    byte b = 0;
    if (i != j) {
      b = 0;
      while (true) {
        l = paramLong;
        if (b < paramArrayList2.size()) {
          PendingFullOrderDetail.d d1 = (PendingFullOrderDetail.d)paramArrayList2.get(b);
          for (i = 0; i < paramArrayList1.size(); i++)
            paramLong = a(parama, parama1, paramLong, c, (PendingFullOrderDetail.d)paramArrayList1.get(i), d1, paramba); 
          b++;
          continue;
        } 
        break;
      } 
    } else {
      while (b < paramArrayList1.size()) {
        paramLong = a(parama, parama1, paramLong, c, (PendingFullOrderDetail.d)paramArrayList1.get(b), (PendingFullOrderDetail.d)paramArrayList2.get(b), paramba);
        b++;
      } 
      l = paramLong;
    } 
    a1.cdy = c;
    a1.cdx = true;
    a1.time = l;
    return a1;
  }
  
  public int jv(String paramString) { // Byte code:
    //   0: new org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial <init> : (Ljava/lang/String;)V
    //   8: astore #4
    //   10: aload #4
    //   12: ldc 'type'
    //   14: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   17: pop
    //   18: new org/json/JSONObject
    //   21: dup
    //   22: aload #4
    //   24: ldc 'header'
    //   26: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   29: ldc '\'
    //   31: ldc ''
    //   33: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   36: invokespecial <init> : (Ljava/lang/String;)V
    //   39: astore #5
    //   41: aload #5
    //   43: ldc 'order_status'
    //   45: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   48: astore #4
    //   50: aload #5
    //   52: ldc 'table_id'
    //   54: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   57: pop
    //   58: aload #4
    //   60: ldc '0'
    //   62: invokevirtual equals : (Ljava/lang/Object;)Z
    //   65: ifeq -> 288
    //   68: aload_1
    //   69: invokestatic iY : (Ljava/lang/String;)Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   72: astore #5
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: astore #6
    //   83: aload #6
    //   85: ldc '智能点菜局域网下单，订单号：'
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload #6
    //   93: aload #5
    //   95: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   98: getfield orderNo : Ljava/lang/String;
    //   101: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload #6
    //   107: ldc '\\n接收订单\\ndata: '
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload #6
    //   115: aload_1
    //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload #6
    //   122: invokevirtual toString : ()Ljava/lang/String;
    //   125: getstatic com/laiqian/util/b$a.dEC : Lcom/laiqian/util/b$a;
    //   128: getfield value : Ljava/lang/String;
    //   131: invokestatic bD : (Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload #5
    //   136: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   139: astore #6
    //   141: new java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial <init> : ()V
    //   148: astore #7
    //   150: aload #7
    //   152: aload #5
    //   154: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   157: getfield aEI : J
    //   160: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload #7
    //   166: ldc ''
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload #6
    //   174: aload #7
    //   176: invokevirtual toString : ()Ljava/lang/String;
    //   179: putfield coK : Ljava/lang/String;
    //   182: new com/laiqian/pos/model/a
    //   185: dup
    //   186: aload_0
    //   187: getfield mContext : Landroid/content/Context;
    //   190: invokespecial <init> : (Landroid/content/Context;)V
    //   193: astore #6
    //   195: aload #6
    //   197: aload #5
    //   199: aload #5
    //   201: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   204: getfield coE : Ljava/util/Date;
    //   207: invokevirtual getTime : ()J
    //   210: invokevirtual a : (Lcom/laiqian/pos/hold/PendingFullOrderDetail;J)Z
    //   213: istore_3
    //   214: aload #6
    //   216: invokevirtual close : ()V
    //   219: iload_3
    //   220: ifeq -> 471
    //   223: new java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial <init> : ()V
    //   230: astore #6
    //   232: aload #6
    //   234: ldc '智能点菜局域网下单，订单号：'
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload #6
    //   242: aload #5
    //   244: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   247: getfield orderNo : Ljava/lang/String;
    //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload #6
    //   256: ldc '\\n打印'
    //   258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload #6
    //   264: invokevirtual toString : ()Ljava/lang/String;
    //   267: getstatic com/laiqian/util/b$a.dEC : Lcom/laiqian/util/b$a;
    //   270: getfield value : Ljava/lang/String;
    //   273: invokestatic bD : (Ljava/lang/String;Ljava/lang/String;)V
    //   276: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   279: aload #5
    //   281: iconst_1
    //   282: invokestatic a : (Landroid/content/Context;Lcom/laiqian/pos/hold/PendingFullOrderDetail;Z)V
    //   285: goto -> 471
    //   288: aload #4
    //   290: ldc '1'
    //   292: invokevirtual equals : (Ljava/lang/Object;)Z
    //   295: ifeq -> 480
    //   298: aload_0
    //   299: aload_1
    //   300: invokevirtual jw : (Ljava/lang/String;)I
    //   303: istore_2
    //   304: goto -> 307
    //   307: iconst_m1
    //   308: iload_2
    //   309: if_icmpne -> 394
    //   312: aload #4
    //   314: ldc '0'
    //   316: invokevirtual equals : (Ljava/lang/Object;)Z
    //   319: ifeq -> 379
    //   322: aload_1
    //   323: invokestatic iY : (Ljava/lang/String;)Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   326: astore_1
    //   327: new java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial <init> : ()V
    //   334: astore #4
    //   336: aload #4
    //   338: ldc '智能点菜局域网下单，订单号：'
    //   340: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload #4
    //   346: aload_1
    //   347: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   350: getfield orderNo : Ljava/lang/String;
    //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload #4
    //   359: ldc '\\n刷新列表'
    //   361: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload #4
    //   367: invokevirtual toString : ()Ljava/lang/String;
    //   370: getstatic com/laiqian/util/b$a.dEC : Lcom/laiqian/util/b$a;
    //   373: getfield value : Ljava/lang/String;
    //   376: invokestatic bD : (Ljava/lang/String;Ljava/lang/String;)V
    //   379: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   382: new android/content/Intent
    //   385: dup
    //   386: ldc 'pos_activity_change_data_area'
    //   388: invokespecial <init> : (Ljava/lang/String;)V
    //   391: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   394: iload_2
    //   395: ireturn
    //   396: astore_1
    //   397: aload_0
    //   398: getfield cdv : Lcom/laiqian/ordertool/ServerGet;
    //   401: invokevirtual getMessage : ()Ljava/lang/StringBuffer;
    //   404: astore #4
    //   406: new java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial <init> : ()V
    //   413: astore #5
    //   415: aload #5
    //   417: ldc_w 'Exception is: '
    //   420: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload #5
    //   426: aload_1
    //   427: invokevirtual toString : ()Ljava/lang/String;
    //   430: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload #5
    //   436: ldc_w '\\n'
    //   439: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload #4
    //   445: aload #5
    //   447: invokevirtual toString : ()Ljava/lang/String;
    //   450: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   453: pop
    //   454: ldc_w 'dcbe'
    //   457: aload_1
    //   458: invokevirtual toString : ()Ljava/lang/String;
    //   461: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   464: aload_1
    //   465: invokestatic e : (Ljava/lang/Throwable;)V
    //   468: bipush #-2
    //   470: ireturn
    //   471: iload_3
    //   472: ifeq -> 480
    //   475: iconst_m1
    //   476: istore_2
    //   477: goto -> 307
    //   480: bipush #-2
    //   482: istore_2
    //   483: goto -> 307
    // Exception table:
    //   from	to	target	type
    //   0	219	396	java/lang/Exception
    //   223	285	396	java/lang/Exception
    //   288	304	396	java/lang/Exception
    //   312	379	396	java/lang/Exception
    //   379	394	396	java/lang/Exception }
  
  public int jw(String paramString) { // Byte code:
    //   0: aload_0
    //   1: astore #13
    //   3: new org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: astore #14
    //   13: aload #14
    //   15: ldc_w 'table_info'
    //   18: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   21: astore #12
    //   23: aload #14
    //   25: ldc 'header'
    //   27: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   30: astore #14
    //   32: aload #12
    //   34: ldc 'table_id'
    //   36: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   39: invokestatic parseLong : (Ljava/lang/String;)J
    //   42: lstore #5
    //   44: aload #12
    //   46: ldc_w 'from_table_id'
    //   49: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   52: invokestatic parseLong : (Ljava/lang/String;)J
    //   55: lstore #7
    //   57: aload #12
    //   59: ldc_w 'create_time'
    //   62: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic parseLong : (Ljava/lang/String;)J
    //   68: pop2
    //   69: aload #12
    //   71: ldc_w 'actual_person'
    //   74: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic parseInt : (Ljava/lang/String;)I
    //   80: pop
    //   81: aload #12
    //   83: ldc_w 'number_id'
    //   86: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic parseInt : (Ljava/lang/String;)I
    //   92: istore #4
    //   94: aload #14
    //   96: ldc_w 'user_id'
    //   99: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   102: astore #16
    //   104: lload #5
    //   106: aload #13
    //   108: getfield mContext : Landroid/content/Context;
    //   111: invokestatic a : (JLandroid/content/Context;)Lcom/laiqian/opentable/common/entity/TableEntity;
    //   114: astore #17
    //   116: lload #7
    //   118: lconst_0
    //   119: lcmp
    //   120: ifle -> 147
    //   123: lload #7
    //   125: aload #13
    //   127: getfield mContext : Landroid/content/Context;
    //   130: invokestatic a : (JLandroid/content/Context;)Lcom/laiqian/opentable/common/entity/TableEntity;
    //   133: astore #12
    //   135: aload #17
    //   137: invokevirtual getState : ()I
    //   140: iconst_2
    //   141: if_icmpne -> 158
    //   144: bipush #-5
    //   146: ireturn
    //   147: aload #17
    //   149: invokevirtual getState : ()I
    //   152: ifne -> 1189
    //   155: bipush #-4
    //   157: ireturn
    //   158: new com/laiqian/pos/model/a
    //   161: dup
    //   162: aload #13
    //   164: getfield mContext : Landroid/content/Context;
    //   167: invokespecial <init> : (Landroid/content/Context;)V
    //   170: astore #15
    //   172: new com/laiqian/models/ba
    //   175: dup
    //   176: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   179: invokespecial <init> : (Landroid/content/Context;)V
    //   182: astore #13
    //   184: aload_1
    //   185: invokestatic iX : (Ljava/lang/String;)Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   188: astore #18
    //   190: aload #18
    //   192: ifnonnull -> 213
    //   195: aload #15
    //   197: invokevirtual endTransaction : ()V
    //   200: aload #13
    //   202: invokevirtual close : ()V
    //   205: aload #15
    //   207: invokevirtual close : ()V
    //   210: bipush #-2
    //   212: ireturn
    //   213: aload #18
    //   215: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   218: getfield orderNo : Ljava/lang/String;
    //   221: invokestatic isNull : (Ljava/lang/String;)Z
    //   224: ifne -> 1211
    //   227: aload #15
    //   229: invokevirtual beginTransaction : ()V
    //   232: new java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial <init> : ()V
    //   239: astore_1
    //   240: aload_1
    //   241: aload #18
    //   243: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   246: getfield orderNo : Ljava/lang/String;
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_1
    //   254: ldc ''
    //   256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload #15
    //   262: aload_1
    //   263: invokevirtual toString : ()Ljava/lang/String;
    //   266: invokevirtual ky : (Ljava/lang/String;)Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   269: astore #19
    //   271: aload #19
    //   273: ifnonnull -> 294
    //   276: aload #15
    //   278: invokevirtual endTransaction : ()V
    //   281: aload #13
    //   283: invokevirtual close : ()V
    //   286: aload #15
    //   288: invokevirtual close : ()V
    //   291: bipush #-2
    //   293: ireturn
    //   294: invokestatic currentTimeMillis : ()J
    //   297: lstore #5
    //   299: new com/laiqian/pos/hold/PendingFullOrderDetail$c
    //   302: dup
    //   303: invokespecial <init> : ()V
    //   306: astore #20
    //   308: aload #18
    //   310: getfield coy : Ljava/util/ArrayList;
    //   313: astore_1
    //   314: aload #19
    //   316: getfield coy : Ljava/util/ArrayList;
    //   319: astore #21
    //   321: aload #19
    //   323: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   326: astore #22
    //   328: aload #13
    //   330: astore #14
    //   332: aload_1
    //   333: aload #15
    //   335: aload #21
    //   337: aload #22
    //   339: lload #5
    //   341: aload #14
    //   343: invokestatic a : (Ljava/util/ArrayList;Lcom/laiqian/pos/model/a;Ljava/util/ArrayList;Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;JLcom/laiqian/models/ba;)Lcom/laiqian/ordertool/a/d$a;
    //   346: astore_1
    //   347: aload #20
    //   349: getfield cpg : Ljava/util/ArrayList;
    //   352: aload_1
    //   353: getfield cdy : Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;
    //   356: getfield cpg : Ljava/util/ArrayList;
    //   359: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   362: pop
    //   363: aload_1
    //   364: getfield time : J
    //   367: lstore #5
    //   369: iconst_0
    //   370: istore_2
    //   371: iload_2
    //   372: aload #18
    //   374: getfield coz : Ljava/util/ArrayList;
    //   377: invokevirtual size : ()I
    //   380: if_icmpge -> 480
    //   383: aload #18
    //   385: getfield coz : Ljava/util/ArrayList;
    //   388: iload_2
    //   389: invokevirtual get : (I)Ljava/lang/Object;
    //   392: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$c
    //   395: astore_1
    //   396: iconst_0
    //   397: istore_3
    //   398: iload_3
    //   399: aload #19
    //   401: getfield coz : Ljava/util/ArrayList;
    //   404: invokevirtual size : ()I
    //   407: if_icmpge -> 1195
    //   410: aload #19
    //   412: getfield coz : Ljava/util/ArrayList;
    //   415: iload_3
    //   416: invokevirtual get : (I)Ljava/lang/Object;
    //   419: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$c
    //   422: astore #21
    //   424: aload_1
    //   425: getfield cpg : Ljava/util/ArrayList;
    //   428: aload #15
    //   430: aload #21
    //   432: getfield cpg : Ljava/util/ArrayList;
    //   435: aload #19
    //   437: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   440: lload #5
    //   442: aload #14
    //   444: invokestatic a : (Ljava/util/ArrayList;Lcom/laiqian/pos/model/a;Ljava/util/ArrayList;Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;JLcom/laiqian/models/ba;)Lcom/laiqian/ordertool/a/d$a;
    //   447: astore #21
    //   449: aload #20
    //   451: getfield cpg : Ljava/util/ArrayList;
    //   454: aload #21
    //   456: getfield cdy : Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;
    //   459: getfield cpg : Ljava/util/ArrayList;
    //   462: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   465: pop
    //   466: aload #21
    //   468: getfield time : J
    //   471: lstore #5
    //   473: iload_3
    //   474: iconst_1
    //   475: iadd
    //   476: istore_3
    //   477: goto -> 398
    //   480: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   483: aload #18
    //   485: aload #20
    //   487: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   490: invokevirtual Bk : ()Z
    //   493: invokestatic a : (Landroid/content/Context;Lcom/laiqian/pos/hold/PendingFullOrderDetail;Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;Z)V
    //   496: aload #18
    //   498: getfield coz : Ljava/util/ArrayList;
    //   501: invokevirtual size : ()I
    //   504: aload #19
    //   506: getfield coz : Ljava/util/ArrayList;
    //   509: invokevirtual size : ()I
    //   512: if_icmpeq -> 1208
    //   515: aload #18
    //   517: getfield coz : Ljava/util/ArrayList;
    //   520: aload #18
    //   522: getfield coz : Ljava/util/ArrayList;
    //   525: invokevirtual size : ()I
    //   528: iconst_1
    //   529: isub
    //   530: invokevirtual get : (I)Ljava/lang/Object;
    //   533: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$c
    //   536: astore_1
    //   537: invokestatic currentTimeMillis : ()J
    //   540: lstore #9
    //   542: iconst_0
    //   543: istore_2
    //   544: iload_2
    //   545: aload_1
    //   546: getfield cpg : Ljava/util/ArrayList;
    //   549: invokevirtual size : ()I
    //   552: if_icmpge -> 617
    //   555: aload_1
    //   556: getfield cpg : Ljava/util/ArrayList;
    //   559: iload_2
    //   560: invokevirtual get : (I)Ljava/lang/Object;
    //   563: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   566: astore #20
    //   568: aload #20
    //   570: aload #14
    //   572: aload #20
    //   574: getfield id : J
    //   577: ldc '86003'
    //   579: invokevirtual s : (JLjava/lang/String;)Ljava/util/ArrayList;
    //   582: putfield aTR : Ljava/util/ArrayList;
    //   585: aload #15
    //   587: aload #20
    //   589: lload #5
    //   591: iload_2
    //   592: i2l
    //   593: aload #19
    //   595: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   598: lload #9
    //   600: invokevirtual a : (Lcom/laiqian/pos/hold/PendingFullOrderDetail$d;JJLcom/laiqian/pos/hold/PendingFullOrderDetail$a;J)Z
    //   603: pop
    //   604: iload_2
    //   605: iconst_1
    //   606: iadd
    //   607: istore_2
    //   608: lload #5
    //   610: lconst_1
    //   611: ladd
    //   612: lstore #5
    //   614: goto -> 544
    //   617: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   620: astore #14
    //   622: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   625: invokevirtual Bk : ()Z
    //   628: ifeq -> 1202
    //   631: invokestatic zR : ()Lcom/laiqian/c/a;
    //   634: invokevirtual Af : ()Z
    //   637: ifne -> 1202
    //   640: iconst_1
    //   641: istore #11
    //   643: goto -> 646
    //   646: aload #14
    //   648: aload #18
    //   650: aload_1
    //   651: iload #11
    //   653: invokestatic a : (Landroid/content/Context;Lcom/laiqian/pos/hold/PendingFullOrderDetail;Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;Z)V
    //   656: goto -> 1208
    //   659: lload #7
    //   661: lconst_0
    //   662: lcmp
    //   663: ifne -> 684
    //   666: aload #18
    //   668: invokestatic n : (Lcom/laiqian/pos/hold/PendingFullOrderDetail;)Z
    //   671: istore #11
    //   673: goto -> 687
    //   676: astore_1
    //   677: goto -> 1119
    //   680: astore_1
    //   681: goto -> 723
    //   684: iconst_0
    //   685: istore #11
    //   687: aload #15
    //   689: invokevirtual setTransactionSuccessful : ()V
    //   692: aload #15
    //   694: invokevirtual endTransaction : ()V
    //   697: aload #13
    //   699: invokevirtual close : ()V
    //   702: aload #15
    //   704: invokevirtual close : ()V
    //   707: goto -> 745
    //   710: astore_1
    //   711: goto -> 1137
    //   714: astore_1
    //   715: goto -> 726
    //   718: astore_1
    //   719: goto -> 1119
    //   722: astore_1
    //   723: iconst_0
    //   724: istore #11
    //   726: aload_1
    //   727: invokestatic e : (Ljava/lang/Throwable;)V
    //   730: aload #15
    //   732: invokevirtual endTransaction : ()V
    //   735: aload #13
    //   737: invokevirtual close : ()V
    //   740: aload #15
    //   742: invokevirtual close : ()V
    //   745: lload #7
    //   747: lconst_0
    //   748: lcmp
    //   749: ifle -> 1217
    //   752: ldc ''
    //   754: astore #14
    //   756: iload #4
    //   758: iconst_m1
    //   759: if_icmpne -> 928
    //   762: aload #12
    //   764: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   767: invokevirtual iterator : ()Ljava/util/Iterator;
    //   770: astore_1
    //   771: aload_1
    //   772: invokeinterface hasNext : ()Z
    //   777: ifeq -> 834
    //   780: aload_1
    //   781: invokeinterface next : ()Ljava/lang/Object;
    //   786: checkcast com/laiqian/opentable/common/entity/c
    //   789: astore #13
    //   791: invokestatic XB : ()Z
    //   794: ifeq -> 810
    //   797: aload #13
    //   799: aload #17
    //   801: invokevirtual getID : ()J
    //   804: invokestatic valueOf : (J)Ljava/lang/String;
    //   807: invokevirtual da : (Ljava/lang/String;)V
    //   810: aload #13
    //   812: aload #17
    //   814: invokevirtual getID : ()J
    //   817: invokevirtual ch : (J)V
    //   820: aload #17
    //   822: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   825: aload #13
    //   827: invokevirtual add : (Ljava/lang/Object;)Z
    //   830: pop
    //   831: goto -> 771
    //   834: aload #17
    //   836: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   839: invokestatic sort : (Ljava/util/List;)V
    //   842: aload #17
    //   844: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   847: invokevirtual size : ()I
    //   850: ifle -> 870
    //   853: aload #17
    //   855: aload #17
    //   857: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   860: iconst_0
    //   861: invokevirtual get : (I)Ljava/lang/Object;
    //   864: checkcast com/laiqian/opentable/common/entity/c
    //   867: invokevirtual c : (Lcom/laiqian/opentable/common/entity/c;)V
    //   870: aload #17
    //   872: invokevirtual Yg : ()Lcom/laiqian/opentable/common/entity/c;
    //   875: aload #12
    //   877: invokevirtual Yg : ()Lcom/laiqian/opentable/common/entity/c;
    //   880: invokevirtual xq : ()Ljava/lang/String;
    //   883: invokevirtual da : (Ljava/lang/String;)V
    //   886: aload #17
    //   888: aload #12
    //   890: invokevirtual getState : ()I
    //   893: invokevirtual setState : (I)V
    //   896: aload #17
    //   898: aload #12
    //   900: invokevirtual DP : ()J
    //   903: invokevirtual cf : (J)V
    //   906: aload #17
    //   908: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   911: invokestatic Q : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   914: astore #13
    //   916: aload #12
    //   918: invokevirtual Yc : ()Lcom/laiqian/opentable/common/entity/TableEntity;
    //   921: pop
    //   922: aload #14
    //   924: astore_1
    //   925: goto -> 1026
    //   928: aload #12
    //   930: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   933: iload #4
    //   935: invokestatic b : (Ljava/util/ArrayList;I)Lcom/laiqian/opentable/common/entity/c;
    //   938: astore_1
    //   939: aload #12
    //   941: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   944: aload_1
    //   945: invokevirtual remove : (Ljava/lang/Object;)Z
    //   948: pop
    //   949: aload_1
    //   950: iconst_0
    //   951: invokevirtual gx : (I)V
    //   954: aload_1
    //   955: aload #17
    //   957: invokevirtual getID : ()J
    //   960: invokevirtual ch : (J)V
    //   963: aload #17
    //   965: iconst_2
    //   966: invokevirtual setState : (I)V
    //   969: aload #17
    //   971: aload_1
    //   972: invokevirtual DP : ()J
    //   975: invokevirtual cf : (J)V
    //   978: aload #17
    //   980: aload_1
    //   981: invokevirtual c : (Lcom/laiqian/opentable/common/entity/c;)V
    //   984: aload #17
    //   986: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   989: aload_1
    //   990: invokevirtual add : (Ljava/lang/Object;)Z
    //   993: pop
    //   994: aload_1
    //   995: invokestatic b : (Lcom/laiqian/opentable/common/entity/c;)Ljava/lang/String;
    //   998: astore #15
    //   1000: aload #12
    //   1002: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1005: invokevirtual size : ()I
    //   1008: istore_2
    //   1009: iload_2
    //   1010: ifle -> 1029
    //   1013: aload #12
    //   1015: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1018: invokestatic Q : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   1021: astore_1
    //   1022: aload #15
    //   1024: astore #13
    //   1026: goto -> 1065
    //   1029: aload #12
    //   1031: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1034: invokevirtual size : ()I
    //   1037: istore_2
    //   1038: aload #14
    //   1040: astore_1
    //   1041: aload #15
    //   1043: astore #13
    //   1045: iload_2
    //   1046: ifne -> 1026
    //   1049: aload #12
    //   1051: invokevirtual Yc : ()Lcom/laiqian/opentable/common/entity/TableEntity;
    //   1054: pop
    //   1055: aload #14
    //   1057: astore_1
    //   1058: aload #15
    //   1060: astore #13
    //   1062: goto -> 1026
    //   1065: new com/laiqian/ordertool/c/c
    //   1068: dup
    //   1069: invokestatic Xy : ()I
    //   1072: invokespecial <init> : (I)V
    //   1075: astore #14
    //   1077: aload #12
    //   1079: aload #17
    //   1081: aload_0
    //   1082: getfield mContext : Landroid/content/Context;
    //   1085: aload #14
    //   1087: aload_1
    //   1088: aload #13
    //   1090: iload #4
    //   1092: invokestatic a : (Lcom/laiqian/opentable/common/entity/TableEntity;Lcom/laiqian/opentable/common/entity/TableEntity;Landroid/content/Context;Lcom/laiqian/ordertool/c/a;Ljava/lang/String;Ljava/lang/String;I)Z
    //   1095: istore #11
    //   1097: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   1100: aload #12
    //   1102: aload #17
    //   1104: aload #16
    //   1106: iload #4
    //   1108: invokestatic a : (Landroid/content/Context;Lcom/laiqian/opentable/common/entity/TableEntity;Lcom/laiqian/opentable/common/entity/TableEntity;Ljava/lang/String;I)V
    //   1111: iload #11
    //   1113: ifeq -> 1214
    //   1116: bipush #-3
    //   1118: ireturn
    //   1119: aload #15
    //   1121: invokevirtual endTransaction : ()V
    //   1124: aload #13
    //   1126: invokevirtual close : ()V
    //   1129: aload #15
    //   1131: invokevirtual close : ()V
    //   1134: aload_1
    //   1135: athrow
    //   1136: astore_1
    //   1137: aload_1
    //   1138: invokestatic e : (Ljava/lang/Throwable;)V
    //   1141: aload_0
    //   1142: getfield cdv : Lcom/laiqian/ordertool/ServerGet;
    //   1145: invokevirtual getMessage : ()Ljava/lang/StringBuffer;
    //   1148: astore #12
    //   1150: new java/lang/StringBuilder
    //   1153: dup
    //   1154: invokespecial <init> : ()V
    //   1157: astore #13
    //   1159: aload #13
    //   1161: aload_1
    //   1162: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1165: pop
    //   1166: aload #13
    //   1168: ldc_w '\\n'
    //   1171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1174: pop
    //   1175: aload #12
    //   1177: aload #13
    //   1179: invokevirtual toString : ()Ljava/lang/String;
    //   1182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1185: pop
    //   1186: bipush #-2
    //   1188: ireturn
    //   1189: aconst_null
    //   1190: astore #12
    //   1192: goto -> 158
    //   1195: iload_2
    //   1196: iconst_1
    //   1197: iadd
    //   1198: istore_2
    //   1199: goto -> 371
    //   1202: iconst_0
    //   1203: istore #11
    //   1205: goto -> 646
    //   1208: goto -> 659
    //   1211: goto -> 659
    //   1214: bipush #-2
    //   1216: ireturn
    //   1217: iload #11
    //   1219: ifeq -> 1224
    //   1222: iconst_m1
    //   1223: ireturn
    //   1224: bipush #-2
    //   1226: ireturn
    //   1227: astore_1
    //   1228: goto -> 1137
    //   1231: astore_1
    //   1232: goto -> 719
    // Exception table:
    //   from	to	target	type
    //   3	116	1136	java/lang/Exception
    //   123	135	1136	java/lang/Exception
    //   135	144	1136	java/lang/Exception
    //   147	155	1136	java/lang/Exception
    //   158	184	1136	java/lang/Exception
    //   184	190	722	java/lang/Exception
    //   184	190	718	finally
    //   195	210	1136	java/lang/Exception
    //   213	271	722	java/lang/Exception
    //   213	271	718	finally
    //   276	291	1136	java/lang/Exception
    //   294	328	722	java/lang/Exception
    //   294	328	718	finally
    //   332	369	680	java/lang/Exception
    //   332	369	676	finally
    //   371	396	680	java/lang/Exception
    //   371	396	676	finally
    //   398	473	680	java/lang/Exception
    //   398	473	676	finally
    //   480	542	680	java/lang/Exception
    //   480	542	676	finally
    //   544	604	680	java/lang/Exception
    //   544	604	676	finally
    //   617	640	680	java/lang/Exception
    //   617	640	676	finally
    //   646	656	680	java/lang/Exception
    //   646	656	676	finally
    //   666	673	680	java/lang/Exception
    //   666	673	676	finally
    //   687	692	714	java/lang/Exception
    //   687	692	676	finally
    //   692	707	710	java/lang/Exception
    //   726	730	1231	finally
    //   730	745	1227	java/lang/Exception
    //   762	771	710	java/lang/Exception
    //   771	810	710	java/lang/Exception
    //   810	831	710	java/lang/Exception
    //   834	870	710	java/lang/Exception
    //   870	922	710	java/lang/Exception
    //   928	1009	1227	java/lang/Exception
    //   1013	1022	710	java/lang/Exception
    //   1029	1038	1227	java/lang/Exception
    //   1049	1055	710	java/lang/Exception
    //   1065	1077	1227	java/lang/Exception
    //   1077	1111	1136	java/lang/Exception
    //   1119	1136	1136	java/lang/Exception }
  
  public static class a {
    public boolean cdx;
    
    public PendingFullOrderDetail.c cdy;
    
    public long time;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */