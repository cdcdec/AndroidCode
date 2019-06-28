package com.laiqian.print.printtype;

import android.content.Context;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.opentable.common.b;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.hold.ah;
import com.laiqian.pos.model.orders.a;
import com.laiqian.print.b.g;
import com.laiqian.print.j;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.delivery.model.DeliveryPrintSettings;
import com.laiqian.print.usage.kitchen.a.c;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.print.usage.tag.a.c;
import com.laiqian.util.av;
import com.laiqian.util.aw;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class i implements j.f {
  i(g paramg) {}
  
  private List<PrintContent> a(PendingFullOrderDetail paramPendingFullOrderDetail, DeliveryPrintSettings paramDeliveryPrintSettings, j.i parami, boolean paramBoolean) {
    byte b1;
    if (paramDeliveryPrintSettings.ais() == 1) {
      b1 = 0;
    } else {
      b1 = 1;
    } 
    g g2 = paramPendingFullOrderDetail.bXb.coJ;
    int j = paramPendingFullOrderDetail.bXb.bZF;
    null = new b.a();
    a1 = null;
    if (j == 2) {
      a1 = null;
      if (g2 != null) {
        b.a a1;
        null = g.b(this.cJq);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramPendingFullOrderDetail.bXb.aEI);
        stringBuilder.append("");
        a1 = b.a(null, stringBuilder.toString(), Long.valueOf(Long.parseLong(paramPendingFullOrderDetail.bXb.coJ)), true);
        paramPendingFullOrderDetail.bXb.ceV = a1.bfo;
      } 
    } 
    g g1 = g.a(this.cJq, paramDeliveryPrintSettings.getWidth());
    if (paramBoolean)
      g1.lk(g.b(this.cJq).getString(2131628774)); 
    if (paramPendingFullOrderDetail.bXb.bZF == 1)
      g1.lk("Phone Order"); 
    byte b3 = 3;
    if (j == 2) {
      g2 = this.cJq;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a1.bZc);
      stringBuilder.append("-");
      stringBuilder.append(a1.bTe);
      g.a(g2, g1, stringBuilder.toString());
      paramPendingFullOrderDetail.bXb.coE = new Date();
    } else if (g2 != null) {
      g.b(this.cJq, g1, g2);
      g1.f(g.b(this.cJq).getString(2131628766), 3, 1);
    } 
    if (j == 1)
      g.c(this.cJq, g1, paramPendingFullOrderDetail.bXb.coS); 
    byte b2 = b3;
    switch (paramDeliveryPrintSettings.ait()) {
      default:
        b2 = b3;
        break;
      case 1:
        b2 = 0;
        break;
      case 2:
        break;
    } 
    g.a(this.cJq, g1, paramDeliveryPrintSettings.getTitle(), b2);
    g.a(this.cJq, g1, paramPendingFullOrderDetail.bXb.coE, paramPendingFullOrderDetail.bXb.ceV);
    if (j == 2)
      g.d(this.cJq, g1, a1.bZd); 
    if (!TextUtils.isEmpty(paramPendingFullOrderDetail.bXb.coK))
      g1.x(new String[] { g.b(this.cJq).getString(2131628739), by.bu(paramPendingFullOrderDetail.bXb.coK, "****") }); 
    if (paramPendingFullOrderDetail.bXb.bZF == 1) {
      g1.l('-');
      g.e(this.cJq, g1, paramPendingFullOrderDetail.bXb.coQ);
      g.f(this.cJq, g1, paramPendingFullOrderDetail.bXb.coP);
      String[] arrayOfString = paramPendingFullOrderDetail.bXb.headerText.split("`");
      if (arrayOfString.length > 0)
        g.g(this.cJq, g1, arrayOfString[0]); 
      if (arrayOfString.length > 1)
        g.h(this.cJq, g1, arrayOfString[1]); 
      if (arrayOfString.length > 2)
        g.i(this.cJq, g1, arrayOfString[2]); 
    } 
    g1.l('-');
    g.a(this.cJq, g1);
    g1.l('-');
    g.a(this.cJq, g1, paramPendingFullOrderDetail.coy, b1, true);
    for (PendingFullOrderDetail.c c : paramPendingFullOrderDetail.coz) {
      g1.l('-');
      g.a(this.cJq, g1, c.cpg, b1, true);
    } 
    g1.l('-');
    null = paramPendingFullOrderDetail.aaE();
    double d = null.acP();
    a.a a = null.acQ();
    d += a.aTG;
    if (!n.bc(a.cyF)) {
      g.a(this.cJq, g1, "Sales amount", Double.valueOf(d - a.cyF));
      g.a(this.cJq, g1, "Total tax", Double.valueOf(a.cyF));
    } 
    g.a(this.cJq, g1, Double.valueOf(d));
    if (!TextUtils.isEmpty(paramDeliveryPrintSettings.aiq()))
      g1.l('-'); 
    g1.ll(paramDeliveryPrintSettings.aiq());
    g.a(this.cJq, g1, paramDeliveryPrintSettings.air());
    g1.afT().ih(parami.getCopies());
    return Collections.singletonList(g1.afV());
  }
  
  private List<PrintContent> a(PendingFullOrderDetail paramPendingFullOrderDetail, ReceiptPrintSettings paramReceiptPrintSettings, j.i parami, boolean paramBoolean) { // Byte code:
    //   0: aload_2
    //   1: invokevirtual ais : ()I
    //   4: iconst_1
    //   5: if_icmpne -> 14
    //   8: iconst_0
    //   9: istore #7
    //   11: goto -> 17
    //   14: iconst_1
    //   15: istore #7
    //   17: aload_1
    //   18: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   21: getfield coJ : Ljava/lang/String;
    //   24: astore #14
    //   26: aload_1
    //   27: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   30: getfield bZF : I
    //   33: istore #9
    //   35: aload_1
    //   36: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   39: getfield cpb : I
    //   42: istore #10
    //   44: new com/laiqian/opentable/common/b$a
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore #12
    //   53: iload #9
    //   55: iconst_2
    //   56: if_icmpeq -> 69
    //   59: aload #12
    //   61: astore #11
    //   63: iload #9
    //   65: iconst_3
    //   66: if_icmpne -> 162
    //   69: aload #12
    //   71: astore #11
    //   73: aload #14
    //   75: ifnull -> 162
    //   78: aload_0
    //   79: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   82: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   85: astore #11
    //   87: new java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial <init> : ()V
    //   94: astore #12
    //   96: aload #12
    //   98: aload_1
    //   99: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   102: getfield aEI : J
    //   105: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload #12
    //   111: ldc ''
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload #11
    //   119: aload #12
    //   121: invokevirtual toString : ()Ljava/lang/String;
    //   124: aload_1
    //   125: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   128: getfield coJ : Ljava/lang/String;
    //   131: invokestatic parseLong : (Ljava/lang/String;)J
    //   134: invokestatic valueOf : (J)Ljava/lang/Long;
    //   137: iconst_1
    //   138: aload_1
    //   139: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   142: getfield bZM : I
    //   145: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;ZI)Lcom/laiqian/opentable/common/b$a;
    //   148: astore #11
    //   150: aload_1
    //   151: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   154: aload #11
    //   156: getfield bfo : Ljava/lang/String;
    //   159: putfield ceV : Ljava/lang/String;
    //   162: aload_0
    //   163: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   166: aload_2
    //   167: invokevirtual getWidth : ()I
    //   170: invokestatic a : (Lcom/laiqian/print/printtype/g;I)Lcom/laiqian/print/b/g;
    //   173: astore #13
    //   175: iload #4
    //   177: ifeq -> 197
    //   180: aload #13
    //   182: aload_0
    //   183: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   186: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   189: ldc 2131628774
    //   191: invokevirtual getString : (I)Ljava/lang/String;
    //   194: invokevirtual lk : (Ljava/lang/String;)V
    //   197: aload_1
    //   198: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   201: getfield aVN : J
    //   204: lconst_0
    //   205: lcmp
    //   206: ifle -> 215
    //   209: iconst_1
    //   210: istore #4
    //   212: goto -> 218
    //   215: iconst_0
    //   216: istore #4
    //   218: iload #9
    //   220: iconst_2
    //   221: if_icmpeq -> 272
    //   224: iload #9
    //   226: iconst_3
    //   227: if_icmpne -> 233
    //   230: goto -> 272
    //   233: aload #14
    //   235: ifnull -> 670
    //   238: aload_0
    //   239: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   242: aload #13
    //   244: aload #14
    //   246: invokestatic b : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   249: pop
    //   250: aload #13
    //   252: aload_0
    //   253: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   256: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   259: ldc 2131628766
    //   261: invokevirtual getString : (I)Ljava/lang/String;
    //   264: iconst_3
    //   265: iconst_1
    //   266: invokevirtual f : (Ljava/lang/String;II)V
    //   269: goto -> 670
    //   272: aload_0
    //   273: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   276: astore #12
    //   278: new java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial <init> : ()V
    //   285: astore #14
    //   287: aload #14
    //   289: aload #11
    //   291: getfield bZc : Ljava/lang/String;
    //   294: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload #14
    //   300: ldc '-'
    //   302: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload #14
    //   308: aload #11
    //   310: getfield bTe : Ljava/lang/String;
    //   313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload #12
    //   319: aload #13
    //   321: aload #14
    //   323: invokevirtual toString : ()Ljava/lang/String;
    //   326: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   329: pop
    //   330: ldc ''
    //   332: astore #12
    //   334: aload_1
    //   335: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   338: getfield coM : I
    //   341: ifeq -> 412
    //   344: new java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial <init> : ()V
    //   351: astore #12
    //   353: aload #12
    //   355: aload_0
    //   356: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   359: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   362: ldc_w 2131626009
    //   365: invokevirtual getString : (I)Ljava/lang/String;
    //   368: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload #12
    //   374: aload_1
    //   375: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   378: getfield coM : I
    //   381: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload #12
    //   387: invokevirtual toString : ()Ljava/lang/String;
    //   390: astore #12
    //   392: aload #13
    //   394: ldc_w '%s'
    //   397: iconst_1
    //   398: anewarray java/lang/Object
    //   401: dup
    //   402: iconst_0
    //   403: aload #12
    //   405: aastore
    //   406: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   409: invokevirtual lk : (Ljava/lang/String;)V
    //   412: aload #13
    //   414: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   417: astore #14
    //   419: aload #11
    //   421: getfield bZc : Ljava/lang/String;
    //   424: astore #15
    //   426: new java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial <init> : ()V
    //   433: astore #16
    //   435: aload #16
    //   437: aload #11
    //   439: getfield bTe : Ljava/lang/String;
    //   442: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload #16
    //   448: aload #12
    //   450: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload #14
    //   456: ldc_w 'number'
    //   459: ldc_w '%s-%s'
    //   462: iconst_2
    //   463: anewarray java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: aload #15
    //   470: aastore
    //   471: dup
    //   472: iconst_1
    //   473: aload #16
    //   475: invokevirtual toString : ()Ljava/lang/String;
    //   478: aastore
    //   479: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   482: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   485: pop
    //   486: iload #4
    //   488: ifeq -> 512
    //   491: aload #13
    //   493: aload_0
    //   494: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   497: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   500: ldc_w 2131628775
    //   503: invokevirtual getString : (I)Ljava/lang/String;
    //   506: invokevirtual lk : (Ljava/lang/String;)V
    //   509: goto -> 656
    //   512: iload #9
    //   514: iconst_2
    //   515: if_icmpne -> 541
    //   518: aload #13
    //   520: aload_0
    //   521: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   524: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   527: ldc_w 2131628761
    //   530: invokevirtual getString : (I)Ljava/lang/String;
    //   533: iconst_3
    //   534: iconst_1
    //   535: invokevirtual f : (Ljava/lang/String;II)V
    //   538: goto -> 656
    //   541: iload #9
    //   543: iconst_3
    //   544: if_icmpne -> 656
    //   547: new java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial <init> : ()V
    //   554: astore #14
    //   556: aload #14
    //   558: aload_0
    //   559: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   562: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   565: ldc_w 2131628761
    //   568: invokevirtual getString : (I)Ljava/lang/String;
    //   571: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload_0
    //   576: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   579: aload_1
    //   580: invokevirtual q : (Lcom/laiqian/pos/hold/PendingFullOrderDetail;)Z
    //   583: ifeq -> 632
    //   586: new java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial <init> : ()V
    //   593: astore #12
    //   595: aload #12
    //   597: ldc '-'
    //   599: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload #12
    //   605: aload_0
    //   606: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   609: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   612: ldc_w 2131626782
    //   615: invokevirtual getString : (I)Ljava/lang/String;
    //   618: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload #12
    //   624: invokevirtual toString : ()Ljava/lang/String;
    //   627: astore #12
    //   629: goto -> 636
    //   632: ldc ''
    //   634: astore #12
    //   636: aload #14
    //   638: aload #12
    //   640: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload #13
    //   646: aload #14
    //   648: invokevirtual toString : ()Ljava/lang/String;
    //   651: iconst_3
    //   652: iconst_1
    //   653: invokevirtual f : (Ljava/lang/String;II)V
    //   656: aload_1
    //   657: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   660: new java/util/Date
    //   663: dup
    //   664: invokespecial <init> : ()V
    //   667: putfield coE : Ljava/util/Date;
    //   670: aload_2
    //   671: invokevirtual ait : ()I
    //   674: tableswitch default -> 696, 1 -> 702, 2 -> 696
    //   696: iconst_3
    //   697: istore #8
    //   699: goto -> 705
    //   702: iconst_0
    //   703: istore #8
    //   705: aload_0
    //   706: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   709: aload #13
    //   711: aload_2
    //   712: invokevirtual getTitle : ()Ljava/lang/String;
    //   715: iload #8
    //   717: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;I)Z
    //   720: pop
    //   721: aload_0
    //   722: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   725: aload #13
    //   727: ldc_w '开单时间'
    //   730: aload_1
    //   731: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   734: getfield coE : Ljava/util/Date;
    //   737: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/util/Date;)Z
    //   740: pop
    //   741: aload_1
    //   742: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   745: getfield coU : Ljava/lang/String;
    //   748: ifnull -> 786
    //   751: aload #13
    //   753: iconst_2
    //   754: anewarray java/lang/String
    //   757: dup
    //   758: iconst_0
    //   759: aload_0
    //   760: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   763: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   766: ldc_w 2131628744
    //   769: invokevirtual getString : (I)Ljava/lang/String;
    //   772: aastore
    //   773: dup
    //   774: iconst_1
    //   775: aload_1
    //   776: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   779: getfield coU : Ljava/lang/String;
    //   782: aastore
    //   783: invokevirtual x : ([Ljava/lang/String;)V
    //   786: iload #9
    //   788: iconst_2
    //   789: if_icmpne -> 863
    //   792: aload_0
    //   793: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   796: astore #12
    //   798: iload #4
    //   800: ifeq -> 843
    //   803: new java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial <init> : ()V
    //   810: astore #11
    //   812: aload #11
    //   814: aload_1
    //   815: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   818: getfield bZM : I
    //   821: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload #11
    //   827: ldc ''
    //   829: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: aload #11
    //   835: invokevirtual toString : ()Ljava/lang/String;
    //   838: astore #11
    //   840: goto -> 850
    //   843: aload #11
    //   845: getfield bZd : Ljava/lang/String;
    //   848: astore #11
    //   850: aload #12
    //   852: aload #13
    //   854: aload #11
    //   856: invokestatic d : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   859: pop
    //   860: goto -> 918
    //   863: iload #9
    //   865: iconst_3
    //   866: if_icmpne -> 918
    //   869: aload_0
    //   870: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   873: astore #11
    //   875: new java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial <init> : ()V
    //   882: astore #12
    //   884: aload #12
    //   886: aload_1
    //   887: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   890: getfield bZM : I
    //   893: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   896: pop
    //   897: aload #12
    //   899: ldc ''
    //   901: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: aload #11
    //   907: aload #13
    //   909: aload #12
    //   911: invokevirtual toString : ()Ljava/lang/String;
    //   914: invokestatic d : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   917: pop
    //   918: aload_1
    //   919: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   922: getfield coK : Ljava/lang/String;
    //   925: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   928: ifne -> 972
    //   931: aload #13
    //   933: iconst_2
    //   934: anewarray java/lang/String
    //   937: dup
    //   938: iconst_0
    //   939: aload_0
    //   940: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   943: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   946: ldc 2131628739
    //   948: invokevirtual getString : (I)Ljava/lang/String;
    //   951: aastore
    //   952: dup
    //   953: iconst_1
    //   954: aload_0
    //   955: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   958: aload_1
    //   959: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   962: getfield coK : Ljava/lang/String;
    //   965: invokestatic a : (Lcom/laiqian/print/printtype/g;Ljava/lang/String;)Ljava/lang/String;
    //   968: aastore
    //   969: invokevirtual x : ([Ljava/lang/String;)V
    //   972: aload #13
    //   974: bipush #45
    //   976: invokevirtual l : (C)V
    //   979: aload_0
    //   980: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   983: aload #13
    //   985: aload_2
    //   986: invokevirtual aiN : ()Z
    //   989: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Z)Z
    //   992: pop
    //   993: iload #9
    //   995: iconst_3
    //   996: if_icmpeq -> 1029
    //   999: aload_0
    //   1000: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1003: aload #13
    //   1005: aload_1
    //   1006: getfield coy : Ljava/util/ArrayList;
    //   1009: iload #7
    //   1011: iconst_1
    //   1012: aload_2
    //   1013: invokevirtual aiN : ()Z
    //   1016: iload #4
    //   1018: aload_1
    //   1019: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1022: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/util/Collection;IZZZLcom/laiqian/pos/hold/PendingFullOrderDetail$a;)Z
    //   1025: pop
    //   1026: goto -> 1054
    //   1029: aload_0
    //   1030: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1033: aload #13
    //   1035: aload_1
    //   1036: getfield coy : Ljava/util/ArrayList;
    //   1039: iload #7
    //   1041: iconst_1
    //   1042: aload_2
    //   1043: invokevirtual aiN : ()Z
    //   1046: iload #4
    //   1048: iload #10
    //   1050: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/util/Collection;IZZZI)Z
    //   1053: pop
    //   1054: aload_1
    //   1055: getfield coz : Ljava/util/ArrayList;
    //   1058: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1061: astore #11
    //   1063: aload #11
    //   1065: invokeinterface hasNext : ()Z
    //   1070: ifeq -> 1147
    //   1073: aload #11
    //   1075: invokeinterface next : ()Ljava/lang/Object;
    //   1080: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$c
    //   1083: astore #12
    //   1085: iload #9
    //   1087: iconst_3
    //   1088: if_icmpne -> 1120
    //   1091: aload_0
    //   1092: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1095: aload #13
    //   1097: aload #12
    //   1099: getfield cpg : Ljava/util/ArrayList;
    //   1102: iload #7
    //   1104: iconst_1
    //   1105: aload_2
    //   1106: invokevirtual aiN : ()Z
    //   1109: iload #4
    //   1111: iload #10
    //   1113: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/util/Collection;IZZZI)Z
    //   1116: pop
    //   1117: goto -> 1144
    //   1120: aload_0
    //   1121: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1124: aload #13
    //   1126: aload #12
    //   1128: getfield cpg : Ljava/util/ArrayList;
    //   1131: iload #7
    //   1133: iconst_1
    //   1134: aload_2
    //   1135: invokevirtual aiN : ()Z
    //   1138: iload #4
    //   1140: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/util/Collection;IZZZ)Z
    //   1143: pop
    //   1144: goto -> 1063
    //   1147: iload #9
    //   1149: iconst_3
    //   1150: if_icmpne -> 1252
    //   1153: aload_1
    //   1154: getfield coy : Ljava/util/ArrayList;
    //   1157: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1160: astore #11
    //   1162: aload #11
    //   1164: invokeinterface hasNext : ()Z
    //   1169: ifeq -> 1252
    //   1172: aload #11
    //   1174: invokeinterface next : ()Ljava/lang/Object;
    //   1179: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   1182: astore #12
    //   1184: iload #10
    //   1186: iconst_1
    //   1187: if_icmpne -> 1198
    //   1190: aload #12
    //   1192: getfield aTU : I
    //   1195: ifeq -> 1212
    //   1198: iload #10
    //   1200: iconst_1
    //   1201: if_icmpeq -> 1162
    //   1204: aload #12
    //   1206: getfield aTU : I
    //   1209: ifeq -> 1162
    //   1212: aload #12
    //   1214: getfield cpx : J
    //   1217: ldc2_w 4
    //   1220: lcmp
    //   1221: ifne -> 1162
    //   1224: aload #13
    //   1226: iload #7
    //   1228: invokevirtual setSize : (I)V
    //   1231: aload_0
    //   1232: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1235: aload #13
    //   1237: aload #12
    //   1239: iconst_1
    //   1240: aload_2
    //   1241: invokevirtual aiN : ()Z
    //   1244: iload #4
    //   1246: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Lcom/laiqian/pos/hold/PendingFullOrderDetail$d;ZZZ)V
    //   1249: goto -> 1162
    //   1252: aload #13
    //   1254: bipush #45
    //   1256: invokevirtual l : (C)V
    //   1259: iload #9
    //   1261: iconst_3
    //   1262: if_icmpne -> 1282
    //   1265: aload_1
    //   1266: iconst_1
    //   1267: invokevirtual hc : (I)Lcom/laiqian/pos/model/orders/a;
    //   1270: astore_1
    //   1271: aload_1
    //   1272: iload #10
    //   1274: invokevirtual hn : (I)D
    //   1277: dstore #5
    //   1279: goto -> 1293
    //   1282: aload_1
    //   1283: invokevirtual aaE : ()Lcom/laiqian/pos/model/orders/a;
    //   1286: astore_1
    //   1287: aload_1
    //   1288: invokevirtual acP : ()D
    //   1291: dstore #5
    //   1293: aload_1
    //   1294: invokevirtual acQ : ()Lcom/laiqian/pos/model/orders/a$a;
    //   1297: astore_1
    //   1298: dload #5
    //   1300: aload_1
    //   1301: getfield aTG : D
    //   1304: dadd
    //   1305: dstore #5
    //   1307: aload_1
    //   1308: getfield cyF : D
    //   1311: invokestatic bc : (D)Z
    //   1314: ifne -> 1360
    //   1317: aload_0
    //   1318: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1321: aload #13
    //   1323: ldc_w 'Sales amount'
    //   1326: dload #5
    //   1328: aload_1
    //   1329: getfield cyF : D
    //   1332: dsub
    //   1333: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1336: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   1339: pop
    //   1340: aload_0
    //   1341: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1344: aload #13
    //   1346: ldc_w 'Total tax'
    //   1349: aload_1
    //   1350: getfield cyF : D
    //   1353: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1356: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   1359: pop
    //   1360: aload_0
    //   1361: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1364: aload #13
    //   1366: dload #5
    //   1368: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1371: iload #4
    //   1373: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/Double;Z)Z
    //   1376: pop
    //   1377: aload_1
    //   1378: getfield taxOfSettement : Ljava/util/HashMap;
    //   1381: ifnull -> 1600
    //   1384: aload_1
    //   1385: getfield taxOfSettement : Ljava/util/HashMap;
    //   1388: invokevirtual size : ()I
    //   1391: ifeq -> 1600
    //   1394: aload #13
    //   1396: bipush #45
    //   1398: invokevirtual l : (C)V
    //   1401: aload #13
    //   1403: iconst_3
    //   1404: newarray int
    //   1406: dup
    //   1407: iconst_0
    //   1408: bipush #12
    //   1410: iastore
    //   1411: dup
    //   1412: iconst_1
    //   1413: bipush #10
    //   1415: iastore
    //   1416: dup
    //   1417: iconst_2
    //   1418: bipush #10
    //   1420: iastore
    //   1421: invokevirtual n : ([I)V
    //   1424: aload #13
    //   1426: iconst_3
    //   1427: anewarray java/lang/String
    //   1430: dup
    //   1431: iconst_0
    //   1432: ldc_w 'GST'
    //   1435: aastore
    //   1436: dup
    //   1437: iconst_1
    //   1438: ldc_w 'Amount'
    //   1441: aastore
    //   1442: dup
    //   1443: iconst_2
    //   1444: ldc_w 'Tax'
    //   1447: aastore
    //   1448: invokevirtual x : ([Ljava/lang/String;)V
    //   1451: aload #13
    //   1453: bipush #45
    //   1455: invokevirtual l : (C)V
    //   1458: aload_1
    //   1459: getfield taxOfSettement : Ljava/util/HashMap;
    //   1462: invokevirtual entrySet : ()Ljava/util/Set;
    //   1465: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1470: astore_1
    //   1471: aload_1
    //   1472: invokeinterface hasNext : ()Z
    //   1477: ifeq -> 1600
    //   1480: aload_1
    //   1481: invokeinterface next : ()Ljava/lang/Object;
    //   1486: checkcast java/util/Map$Entry
    //   1489: invokeinterface getValue : ()Ljava/lang/Object;
    //   1494: checkcast com/laiqian/product/models/p
    //   1497: astore #11
    //   1499: new java/lang/StringBuilder
    //   1502: dup
    //   1503: invokespecial <init> : ()V
    //   1506: astore #12
    //   1508: aload #12
    //   1510: aload #11
    //   1512: invokevirtual IT : ()Ljava/lang/String;
    //   1515: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1518: pop
    //   1519: aload #12
    //   1521: ldc_w '='
    //   1524: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: pop
    //   1528: aload #12
    //   1530: aload #11
    //   1532: invokevirtual alg : ()D
    //   1535: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1538: pop
    //   1539: aload #12
    //   1541: ldc_w '%'
    //   1544: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: pop
    //   1548: aload #13
    //   1550: iconst_3
    //   1551: anewarray java/lang/String
    //   1554: dup
    //   1555: iconst_0
    //   1556: aload #12
    //   1558: invokevirtual toString : ()Ljava/lang/String;
    //   1561: aastore
    //   1562: dup
    //   1563: iconst_1
    //   1564: aload #11
    //   1566: invokevirtual ali : ()D
    //   1569: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1572: iconst_1
    //   1573: iconst_0
    //   1574: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   1577: aastore
    //   1578: dup
    //   1579: iconst_2
    //   1580: aload #11
    //   1582: invokevirtual alh : ()D
    //   1585: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1588: iconst_1
    //   1589: iconst_0
    //   1590: invokestatic a : (Ljava/lang/Object;ZZ)Ljava/lang/String;
    //   1593: aastore
    //   1594: invokevirtual x : ([Ljava/lang/String;)V
    //   1597: goto -> 1471
    //   1600: aload_2
    //   1601: invokevirtual aiq : ()Ljava/lang/String;
    //   1604: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1607: ifne -> 1617
    //   1610: aload #13
    //   1612: bipush #45
    //   1614: invokevirtual l : (C)V
    //   1617: aload #13
    //   1619: aload_2
    //   1620: invokevirtual aiq : ()Ljava/lang/String;
    //   1623: invokevirtual ll : (Ljava/lang/String;)V
    //   1626: aload_0
    //   1627: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1630: aload #13
    //   1632: aload_2
    //   1633: invokevirtual air : ()I
    //   1636: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;I)Z
    //   1639: pop
    //   1640: aload #13
    //   1642: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1645: aload_3
    //   1646: invokeinterface getCopies : ()I
    //   1651: invokevirtual ih : (I)Lcom/laiqian/print/model/PrintContent$a;
    //   1654: pop
    //   1655: aload #13
    //   1657: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1660: invokestatic singletonList : (Ljava/lang/Object;)Ljava/util/List;
    //   1663: areturn }
  
  private List<PrintContent> a(ah paramah, DeliveryPrintSettings paramDeliveryPrintSettings, j.i parami) {
    ArrayList arrayList2 = new ArrayList();
    ArrayList arrayList1 = new ArrayList();
    for (PendingFullOrderDetail.d d : paramah.cdy.cpg) {
      if (d.cpo > 0.0D) {
        arrayList2.add(d);
        continue;
      } 
      if (d.cpo < 0.0D)
        arrayList1.add(d); 
    } 
    b.a a1 = new b.a();
    String str = paramah.bXb.coJ;
    int j = paramah.bXb.bZF;
    b.a a2 = a1;
    if (j == 2) {
      a2 = a1;
      if (str != null) {
        Context context = g.b(this.cJq);
        null = new StringBuilder();
        null.append(paramah.bXb.aEI);
        null.append("");
        a2 = b.a(context, null.toString(), Long.valueOf(Long.parseLong(paramah.bXb.coJ)), true, paramah.bXb.bZM);
        paramah.bXb.ceV = a2.bfo;
      } 
    } 
    ArrayList arrayList3 = new ArrayList();
    if (arrayList1.size() > 0) {
      byte b;
      g g1 = g.a(this.cJq, paramDeliveryPrintSettings.getWidth());
      if (j == 2) {
        g g2 = this.cJq;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a2.bZc);
        stringBuilder.append("-");
        stringBuilder.append(a2.bTe);
        g.a(g2, g1, stringBuilder.toString());
        if (paramah.bXb.coM != 0) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(g.b(this.cJq).getString(2131626009));
          stringBuilder1.append(paramah.bXb.coM);
          g1.lk(String.format("%s", new Object[] { stringBuilder1.toString() }));
        } 
        paramah.bXb.coE = new Date();
      } else if (str != null) {
        g.b(this.cJq, g1, str);
      } else if (!by.isNull(paramah.bXb.coT)) {
        g.j(this.cJq, g1, paramah.bXb.coT);
      } 
      g1.f(g.b(this.cJq).getString(2131626775), 3, 1);
      switch (paramDeliveryPrintSettings.ait()) {
        default:
          b = 3;
          break;
        case 1:
          b = 0;
          break;
      } 
      g.a(this.cJq, g1, paramDeliveryPrintSettings.getTitle(), b);
      g.a(this.cJq, g1, paramah.bXb.coE, paramah.bXb.ceV);
      if (j == 2)
        g.d(this.cJq, g1, a2.bZd); 
      if (!TextUtils.isEmpty(paramah.bXb.coK))
        g1.x(new String[] { g.b(this.cJq).getString(2131628739), by.bu(paramah.bXb.coK, "****") }); 
      g1.l('-');
      if (paramDeliveryPrintSettings.ais() == 1) {
        b = 0;
      } else {
        b = 1;
      } 
      g.a(this.cJq, g1);
      g1.l('-');
      g.a(this.cJq, g1, arrayList1, b, false);
      Iterator iterator = arrayList1.iterator();
      double d1;
      for (d1 = 0.0D; iterator.hasNext(); d1 += d * d3.cpo) {
        double d;
        PendingFullOrderDetail.d d3 = (PendingFullOrderDetail.d)iterator.next();
        if (d3.cpt != null) {
          d = d3.cpt.doubleValue();
        } else {
          d = d3.cpn;
        } 
      } 
      double d2 = PendingFullOrderDetail.m(arrayList1);
      if (!n.bc(d2)) {
        g g2 = g1;
        g2.l('-');
        g.a(this.cJq, g2, "Sales amount", Double.valueOf(d1 - d2));
        g.a(this.cJq, g2, "Total tax", Double.valueOf(d2));
      } 
      g1.l('-');
      g.a(this.cJq, g1, Double.valueOf(d1));
      g.a(this.cJq, g1, paramDeliveryPrintSettings.air());
      g1.afT().ih(parami.getCopies());
      arrayList3.add(g1.afV());
    } 
    if (arrayList2.size() > 0) {
      StringBuilder stringBuilder;
      g g1 = g.a(this.cJq, paramDeliveryPrintSettings.getWidth());
      if (j == 2) {
        g g2 = this.cJq;
        stringBuilder = new StringBuilder();
        stringBuilder.append(a2.bZc);
        stringBuilder.append("-");
        stringBuilder.append(a2.bTe);
        g.a(g2, g1, stringBuilder.toString());
        paramah.bXb.coE = new Date();
      } else if (stringBuilder != null) {
        g.b(this.cJq, g1, stringBuilder);
      } else if (!by.isNull(paramah.bXb.coT)) {
        g.j(this.cJq, g1, paramah.bXb.coT);
      } 
      String str1 = g.b(this.cJq).getString(2131626782);
      byte b2 = 3;
      g1.f(str1, 3, 1);
      byte b1 = b2;
      switch (paramDeliveryPrintSettings.ait()) {
        default:
          b1 = b2;
          break;
        case 1:
          b1 = 0;
          break;
        case 2:
          break;
      } 
      g.a(this.cJq, g1, paramDeliveryPrintSettings.getTitle(), b1);
      g.a(this.cJq, g1, paramah.bXb.coE, paramah.bXb.ceV);
      if (j == 2)
        g.d(this.cJq, g1, a2.bZd); 
      if (!TextUtils.isEmpty(paramah.bXb.coK))
        g1.x(new String[] { g.b(this.cJq).getString(2131628739), by.bu(paramah.bXb.coK, "****") }); 
      b1 = 1;
      g1.l('-');
      if (paramDeliveryPrintSettings.ais() == 1)
        b1 = 0; 
      g.a(this.cJq, g1);
      g1.l('-');
      g.a(this.cJq, g1, arrayList2, b1, false);
      Iterator iterator = arrayList2.iterator();
      double d1;
      for (d1 = 0.0D; iterator.hasNext(); d1 += d.cpn * d.cpo)
        PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator.next(); 
      double d2 = PendingFullOrderDetail.m(arrayList2);
      if (!n.bc(d2)) {
        g1.l('-');
        g.a(this.cJq, g1, "Sales amount", Double.valueOf(d1 - d2));
        g.a(this.cJq, g1, "Total tax", Double.valueOf(d2));
      } 
      g1.l('-');
      g.a(this.cJq, g1, Double.valueOf(d1));
      g.a(this.cJq, g1, paramDeliveryPrintSettings.air());
      g1.afT().ih(parami.getCopies());
      arrayList3.add(g1.afV());
    } 
    return arrayList3;
  }
  
  private List<PrintContent> a(ah paramah, c paramc, j.c paramc1) { // Byte code:
    //   0: aload_1
    //   1: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   4: getfield bZF : I
    //   7: iconst_2
    //   8: if_icmpne -> 75
    //   11: new com/laiqian/opentable/b/q
    //   14: dup
    //   15: aload_0
    //   16: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   19: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   22: invokespecial <init> : (Landroid/content/Context;)V
    //   25: astore #11
    //   27: aload #11
    //   29: aload_1
    //   30: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   33: getfield coJ : Ljava/lang/String;
    //   36: invokestatic parseLong : (Ljava/lang/String;)J
    //   39: invokevirtual ck : (J)Lcom/laiqian/opentable/common/entity/TableEntity;
    //   42: astore #12
    //   44: aload #11
    //   46: invokevirtual close : ()V
    //   49: aload #12
    //   51: invokevirtual XY : ()J
    //   54: lstore #8
    //   56: aload_3
    //   57: invokevirtual aeq : ()Ljava/util/List;
    //   60: lload #8
    //   62: invokestatic valueOf : (J)Ljava/lang/Long;
    //   65: invokeinterface contains : (Ljava/lang/Object;)Z
    //   70: ifeq -> 75
    //   73: aconst_null
    //   74: areturn
    //   75: aload_2
    //   76: invokevirtual getOrder : ()I
    //   79: iconst_2
    //   80: if_icmpne -> 97
    //   83: aload_0
    //   84: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   87: aload_1
    //   88: getfield cdy : Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;
    //   91: getfield cpg : Ljava/util/ArrayList;
    //   94: invokestatic a : (Lcom/laiqian/print/printtype/g;Ljava/util/ArrayList;)V
    //   97: aload_1
    //   98: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   101: getfield coJ : Ljava/lang/String;
    //   104: astore #13
    //   106: aload_1
    //   107: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   110: getfield bZF : I
    //   113: istore #4
    //   115: new com/laiqian/opentable/common/b$a
    //   118: dup
    //   119: invokespecial <init> : ()V
    //   122: astore #12
    //   124: iconst_1
    //   125: istore #7
    //   127: iload #4
    //   129: iconst_3
    //   130: if_icmpeq -> 143
    //   133: aload #12
    //   135: astore #11
    //   137: iload #4
    //   139: iconst_2
    //   140: if_icmpne -> 236
    //   143: aload #12
    //   145: astore #11
    //   147: aload #13
    //   149: ifnull -> 236
    //   152: aload_0
    //   153: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   156: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   159: astore #11
    //   161: new java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial <init> : ()V
    //   168: astore #12
    //   170: aload #12
    //   172: aload_1
    //   173: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   176: getfield aEI : J
    //   179: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload #12
    //   185: ldc ''
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload #11
    //   193: aload #12
    //   195: invokevirtual toString : ()Ljava/lang/String;
    //   198: aload_1
    //   199: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   202: getfield coJ : Ljava/lang/String;
    //   205: invokestatic parseLong : (Ljava/lang/String;)J
    //   208: invokestatic valueOf : (J)Ljava/lang/Long;
    //   211: iconst_1
    //   212: aload_1
    //   213: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   216: getfield bZM : I
    //   219: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;ZI)Lcom/laiqian/opentable/common/b$a;
    //   222: astore #11
    //   224: aload_1
    //   225: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   228: aload #11
    //   230: getfield bfo : Ljava/lang/String;
    //   233: putfield ceV : Ljava/lang/String;
    //   236: new java/util/ArrayList
    //   239: dup
    //   240: invokespecial <init> : ()V
    //   243: astore #16
    //   245: aload_3
    //   246: invokevirtual aep : ()Ljava/util/List;
    //   249: astore #14
    //   251: aload_1
    //   252: getfield cdy : Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;
    //   255: getfield cpg : Ljava/util/ArrayList;
    //   258: invokevirtual iterator : ()Ljava/util/Iterator;
    //   261: astore #12
    //   263: iconst_0
    //   264: istore #6
    //   266: aload #12
    //   268: invokeinterface hasNext : ()Z
    //   273: ifeq -> 314
    //   276: aload #14
    //   278: aload #12
    //   280: invokeinterface next : ()Ljava/lang/Object;
    //   285: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   288: getfield cpq : J
    //   291: invokestatic valueOf : (J)Ljava/lang/Long;
    //   294: invokeinterface contains : (Ljava/lang/Object;)Z
    //   299: ifeq -> 305
    //   302: goto -> 266
    //   305: iload #6
    //   307: iconst_1
    //   308: iadd
    //   309: istore #6
    //   311: goto -> 266
    //   314: aload_1
    //   315: getfield cdy : Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;
    //   318: getfield cpg : Ljava/util/ArrayList;
    //   321: invokevirtual iterator : ()Ljava/util/Iterator;
    //   324: astore #12
    //   326: iconst_1
    //   327: istore #5
    //   329: aload #12
    //   331: invokeinterface hasNext : ()Z
    //   336: ifeq -> 1478
    //   339: aload #12
    //   341: invokeinterface next : ()Ljava/lang/Object;
    //   346: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   349: astore #17
    //   351: aload #14
    //   353: aload #17
    //   355: getfield cpq : J
    //   358: invokestatic valueOf : (J)Ljava/lang/Long;
    //   361: invokeinterface contains : (Ljava/lang/Object;)Z
    //   366: ifne -> 1475
    //   369: aload_0
    //   370: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   373: aload_2
    //   374: invokevirtual getWidth : ()I
    //   377: invokestatic a : (Lcom/laiqian/print/printtype/g;I)Lcom/laiqian/print/b/g;
    //   380: astore #18
    //   382: iload #6
    //   384: iload #7
    //   386: if_icmpne -> 755
    //   389: iload #4
    //   391: istore #7
    //   393: iload #7
    //   395: iconst_3
    //   396: if_icmpeq -> 532
    //   399: iload #7
    //   401: iconst_2
    //   402: if_icmpne -> 408
    //   405: goto -> 532
    //   408: aload #13
    //   410: ifnull -> 529
    //   413: aload_0
    //   414: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   417: astore #15
    //   419: aload_1
    //   420: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   423: getfield aVN : J
    //   426: lconst_1
    //   427: lcmp
    //   428: ifne -> 437
    //   431: iconst_1
    //   432: istore #10
    //   434: goto -> 440
    //   437: iconst_0
    //   438: istore #10
    //   440: aload #18
    //   442: ldc_w '%s %s'
    //   445: iconst_2
    //   446: anewarray java/lang/Object
    //   449: dup
    //   450: iconst_0
    //   451: aload #15
    //   453: iload #10
    //   455: invokevirtual fU : (Z)Ljava/lang/String;
    //   458: aastore
    //   459: dup
    //   460: iconst_1
    //   461: aload_1
    //   462: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   465: getfield coJ : Ljava/lang/String;
    //   468: aastore
    //   469: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   472: invokevirtual lk : (Ljava/lang/String;)V
    //   475: aload #18
    //   477: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   480: astore #15
    //   482: new java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial <init> : ()V
    //   489: astore #19
    //   491: aload #19
    //   493: aload_1
    //   494: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   497: getfield coJ : Ljava/lang/String;
    //   500: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload #19
    //   506: ldc ''
    //   508: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload #15
    //   514: ldc_w 'number'
    //   517: aload #19
    //   519: invokevirtual toString : ()Ljava/lang/String;
    //   522: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   525: pop
    //   526: goto -> 529
    //   529: goto -> 1260
    //   532: aload #18
    //   534: ldc_w '%s %s-%s'
    //   537: iconst_3
    //   538: anewarray java/lang/Object
    //   541: dup
    //   542: iconst_0
    //   543: aload_0
    //   544: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   547: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   550: ldc_w 2131628305
    //   553: invokevirtual getString : (I)Ljava/lang/String;
    //   556: aastore
    //   557: dup
    //   558: iconst_1
    //   559: aload #11
    //   561: getfield bZc : Ljava/lang/String;
    //   564: aastore
    //   565: dup
    //   566: iconst_2
    //   567: aload #11
    //   569: getfield bTe : Ljava/lang/String;
    //   572: aastore
    //   573: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   576: invokevirtual lk : (Ljava/lang/String;)V
    //   579: ldc ''
    //   581: astore #15
    //   583: aload_1
    //   584: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   587: getfield coM : I
    //   590: ifeq -> 664
    //   593: new java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial <init> : ()V
    //   600: astore #15
    //   602: aload #15
    //   604: aload_0
    //   605: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   608: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   611: ldc_w 2131626009
    //   614: invokevirtual getString : (I)Ljava/lang/String;
    //   617: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload #15
    //   623: aload_1
    //   624: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   627: getfield coM : I
    //   630: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload #15
    //   636: invokevirtual toString : ()Ljava/lang/String;
    //   639: astore #15
    //   641: aload #18
    //   643: ldc_w '%s'
    //   646: iconst_1
    //   647: anewarray java/lang/Object
    //   650: dup
    //   651: iconst_0
    //   652: aload #15
    //   654: aastore
    //   655: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   658: invokevirtual lk : (Ljava/lang/String;)V
    //   661: goto -> 664
    //   664: aload #18
    //   666: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   669: astore #19
    //   671: aload #11
    //   673: getfield bZc : Ljava/lang/String;
    //   676: astore #20
    //   678: new java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial <init> : ()V
    //   685: astore #21
    //   687: aload #21
    //   689: aload #11
    //   691: getfield bTe : Ljava/lang/String;
    //   694: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload #21
    //   700: aload #15
    //   702: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload #19
    //   708: ldc_w 'number'
    //   711: ldc_w '%s-%s'
    //   714: iconst_2
    //   715: anewarray java/lang/Object
    //   718: dup
    //   719: iconst_0
    //   720: aload #20
    //   722: aastore
    //   723: dup
    //   724: iconst_1
    //   725: aload #21
    //   727: invokevirtual toString : ()Ljava/lang/String;
    //   730: aastore
    //   731: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   734: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   737: pop
    //   738: aload_1
    //   739: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   742: new java/util/Date
    //   745: dup
    //   746: invokespecial <init> : ()V
    //   749: putfield coE : Ljava/util/Date;
    //   752: goto -> 1260
    //   755: iload #4
    //   757: istore #7
    //   759: iload #7
    //   761: iconst_3
    //   762: if_icmpeq -> 972
    //   765: iload #7
    //   767: iconst_2
    //   768: if_icmpne -> 774
    //   771: goto -> 972
    //   774: aload #18
    //   776: iconst_1
    //   777: anewarray java/lang/String
    //   780: dup
    //   781: iconst_0
    //   782: aload_0
    //   783: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   786: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   789: ldc_w 2131629622
    //   792: invokevirtual getString : (I)Ljava/lang/String;
    //   795: iconst_2
    //   796: anewarray java/lang/Object
    //   799: dup
    //   800: iconst_0
    //   801: iload #5
    //   803: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   806: aastore
    //   807: dup
    //   808: iconst_1
    //   809: iload #6
    //   811: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   814: aastore
    //   815: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   818: aastore
    //   819: invokevirtual x : ([Ljava/lang/String;)V
    //   822: aload #18
    //   824: iconst_1
    //   825: anewarray java/lang/String
    //   828: dup
    //   829: iconst_0
    //   830: ldc ''
    //   832: aastore
    //   833: invokevirtual x : ([Ljava/lang/String;)V
    //   836: aload_0
    //   837: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   840: astore #15
    //   842: aload_1
    //   843: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   846: getfield aVN : J
    //   849: lconst_1
    //   850: lcmp
    //   851: ifne -> 860
    //   854: iconst_1
    //   855: istore #10
    //   857: goto -> 863
    //   860: iconst_0
    //   861: istore #10
    //   863: aload #18
    //   865: ldc_w '%s %s'
    //   868: iconst_2
    //   869: anewarray java/lang/Object
    //   872: dup
    //   873: iconst_0
    //   874: aload #15
    //   876: iload #10
    //   878: invokevirtual fU : (Z)Ljava/lang/String;
    //   881: aastore
    //   882: dup
    //   883: iconst_1
    //   884: aload_1
    //   885: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   888: getfield coJ : Ljava/lang/String;
    //   891: aastore
    //   892: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   895: invokevirtual lk : (Ljava/lang/String;)V
    //   898: aload #18
    //   900: iconst_1
    //   901: anewarray java/lang/String
    //   904: dup
    //   905: iconst_0
    //   906: ldc ''
    //   908: aastore
    //   909: invokevirtual x : ([Ljava/lang/String;)V
    //   912: aload #18
    //   914: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   917: astore #15
    //   919: new java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial <init> : ()V
    //   926: astore #19
    //   928: aload #19
    //   930: aload_1
    //   931: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   934: getfield coJ : Ljava/lang/String;
    //   937: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: pop
    //   941: aload #19
    //   943: ldc ''
    //   945: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: pop
    //   949: aload #15
    //   951: ldc_w 'number'
    //   954: aload #19
    //   956: invokevirtual toString : ()Ljava/lang/String;
    //   959: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   962: pop
    //   963: iload #5
    //   965: iconst_1
    //   966: iadd
    //   967: istore #5
    //   969: goto -> 1260
    //   972: aload #18
    //   974: iconst_1
    //   975: anewarray java/lang/String
    //   978: dup
    //   979: iconst_0
    //   980: aload_0
    //   981: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   984: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   987: ldc_w 2131629622
    //   990: invokevirtual getString : (I)Ljava/lang/String;
    //   993: iconst_2
    //   994: anewarray java/lang/Object
    //   997: dup
    //   998: iconst_0
    //   999: iload #5
    //   1001: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1004: aastore
    //   1005: dup
    //   1006: iconst_1
    //   1007: iload #6
    //   1009: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1012: aastore
    //   1013: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1016: aastore
    //   1017: invokevirtual x : ([Ljava/lang/String;)V
    //   1020: aload #18
    //   1022: iconst_1
    //   1023: anewarray java/lang/String
    //   1026: dup
    //   1027: iconst_0
    //   1028: ldc ''
    //   1030: aastore
    //   1031: invokevirtual x : ([Ljava/lang/String;)V
    //   1034: aload #18
    //   1036: ldc_w '%s %s-%s'
    //   1039: iconst_3
    //   1040: anewarray java/lang/Object
    //   1043: dup
    //   1044: iconst_0
    //   1045: aload_0
    //   1046: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1049: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1052: ldc_w 2131628305
    //   1055: invokevirtual getString : (I)Ljava/lang/String;
    //   1058: aastore
    //   1059: dup
    //   1060: iconst_1
    //   1061: aload #11
    //   1063: getfield bZc : Ljava/lang/String;
    //   1066: aastore
    //   1067: dup
    //   1068: iconst_2
    //   1069: aload #11
    //   1071: getfield bTe : Ljava/lang/String;
    //   1074: aastore
    //   1075: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1078: invokevirtual lk : (Ljava/lang/String;)V
    //   1081: aload #18
    //   1083: iconst_1
    //   1084: anewarray java/lang/String
    //   1087: dup
    //   1088: iconst_0
    //   1089: ldc ''
    //   1091: aastore
    //   1092: invokevirtual x : ([Ljava/lang/String;)V
    //   1095: ldc ''
    //   1097: astore #15
    //   1099: aload_1
    //   1100: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1103: getfield coM : I
    //   1106: ifeq -> 1180
    //   1109: new java/lang/StringBuilder
    //   1112: dup
    //   1113: invokespecial <init> : ()V
    //   1116: astore #15
    //   1118: aload #15
    //   1120: aload_0
    //   1121: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1124: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1127: ldc_w 2131626009
    //   1130: invokevirtual getString : (I)Ljava/lang/String;
    //   1133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: pop
    //   1137: aload #15
    //   1139: aload_1
    //   1140: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1143: getfield coM : I
    //   1146: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1149: pop
    //   1150: aload #15
    //   1152: invokevirtual toString : ()Ljava/lang/String;
    //   1155: astore #15
    //   1157: aload #18
    //   1159: ldc_w '%s'
    //   1162: iconst_1
    //   1163: anewarray java/lang/Object
    //   1166: dup
    //   1167: iconst_0
    //   1168: aload #15
    //   1170: aastore
    //   1171: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1174: invokevirtual lk : (Ljava/lang/String;)V
    //   1177: goto -> 1180
    //   1180: aload #18
    //   1182: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1185: astore #19
    //   1187: aload #11
    //   1189: getfield bZc : Ljava/lang/String;
    //   1192: astore #20
    //   1194: new java/lang/StringBuilder
    //   1197: dup
    //   1198: invokespecial <init> : ()V
    //   1201: astore #21
    //   1203: aload #21
    //   1205: aload #11
    //   1207: getfield bTe : Ljava/lang/String;
    //   1210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: pop
    //   1214: aload #21
    //   1216: aload #15
    //   1218: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: pop
    //   1222: aload #19
    //   1224: ldc_w 'number'
    //   1227: ldc_w '%s-%s'
    //   1230: iconst_2
    //   1231: anewarray java/lang/Object
    //   1234: dup
    //   1235: iconst_0
    //   1236: aload #20
    //   1238: aastore
    //   1239: dup
    //   1240: iconst_1
    //   1241: aload #21
    //   1243: invokevirtual toString : ()Ljava/lang/String;
    //   1246: aastore
    //   1247: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1250: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   1253: pop
    //   1254: iload #5
    //   1256: iconst_1
    //   1257: iadd
    //   1258: istore #5
    //   1260: aload #17
    //   1262: getfield cpo : D
    //   1265: dconst_0
    //   1266: dcmpl
    //   1267: ifle -> 1291
    //   1270: aload #18
    //   1272: aload_0
    //   1273: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1276: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1279: ldc_w 2131626782
    //   1282: invokevirtual getString : (I)Ljava/lang/String;
    //   1285: invokevirtual lk : (Ljava/lang/String;)V
    //   1288: goto -> 1309
    //   1291: aload #18
    //   1293: aload_0
    //   1294: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1297: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1300: ldc_w 2131626775
    //   1303: invokevirtual getString : (I)Ljava/lang/String;
    //   1306: invokevirtual lk : (Ljava/lang/String;)V
    //   1309: aload_0
    //   1310: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1313: aload #18
    //   1315: aload_1
    //   1316: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1319: getfield coE : Ljava/util/Date;
    //   1322: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/util/Date;)Z
    //   1325: pop
    //   1326: iload #4
    //   1328: ifne -> 1407
    //   1331: aload_1
    //   1332: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1335: getfield coN : Ljava/lang/String;
    //   1338: invokestatic isNull : (Ljava/lang/String;)Z
    //   1341: ifne -> 1407
    //   1344: aload #18
    //   1346: bipush #45
    //   1348: invokevirtual l : (C)V
    //   1351: new java/lang/StringBuilder
    //   1354: dup
    //   1355: invokespecial <init> : ()V
    //   1358: astore #15
    //   1360: aload #15
    //   1362: aload_0
    //   1363: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1366: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1369: ldc_w 2131628790
    //   1372: invokevirtual getString : (I)Ljava/lang/String;
    //   1375: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload #15
    //   1381: aload_1
    //   1382: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1385: getfield coN : Ljava/lang/String;
    //   1388: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: pop
    //   1392: aload #18
    //   1394: aload #15
    //   1396: invokevirtual toString : ()Ljava/lang/String;
    //   1399: iconst_1
    //   1400: iconst_0
    //   1401: invokevirtual f : (Ljava/lang/String;II)V
    //   1404: goto -> 1407
    //   1407: iconst_1
    //   1408: istore #7
    //   1410: aload #18
    //   1412: bipush #45
    //   1414: invokevirtual l : (C)V
    //   1417: aload_0
    //   1418: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1421: aload #18
    //   1423: aload #17
    //   1425: aload_2
    //   1426: iconst_0
    //   1427: aload_1
    //   1428: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1431: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Lcom/laiqian/pos/hold/PendingFullOrderDetail$d;Lcom/laiqian/print/usage/kitchen/a/c;ZLcom/laiqian/pos/hold/PendingFullOrderDetail$a;)V
    //   1434: aload_0
    //   1435: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1438: aload #18
    //   1440: aload_2
    //   1441: invokevirtual air : ()I
    //   1444: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;I)Z
    //   1447: pop
    //   1448: aload #18
    //   1450: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1453: aload_3
    //   1454: invokevirtual getCopies : ()I
    //   1457: invokevirtual ih : (I)Lcom/laiqian/print/model/PrintContent$a;
    //   1460: pop
    //   1461: aload #16
    //   1463: aload #18
    //   1465: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1468: invokevirtual add : (Ljava/lang/Object;)Z
    //   1471: pop
    //   1472: goto -> 1475
    //   1475: goto -> 329
    //   1478: aload #16
    //   1480: new com/laiqian/print/model/PrintContent$a
    //   1483: dup
    //   1484: invokespecial <init> : ()V
    //   1487: invokevirtual agg : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1490: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1493: invokevirtual add : (Ljava/lang/Object;)Z
    //   1496: pop
    //   1497: aload #16
    //   1499: areturn }
  
  private List<PrintContent> a(ah paramah, ReceiptPrintSettings paramReceiptPrintSettings, j.i parami) { // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #14
    //   9: new java/util/ArrayList
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #15
    //   18: aload_1
    //   19: getfield cdy : Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;
    //   22: getfield cpg : Ljava/util/ArrayList;
    //   25: invokevirtual iterator : ()Ljava/util/Iterator;
    //   28: astore #10
    //   30: aload #10
    //   32: invokeinterface hasNext : ()Z
    //   37: ifeq -> 94
    //   40: aload #10
    //   42: invokeinterface next : ()Ljava/lang/Object;
    //   47: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   50: astore #11
    //   52: aload #11
    //   54: getfield cpo : D
    //   57: dconst_0
    //   58: dcmpl
    //   59: ifle -> 73
    //   62: aload #14
    //   64: aload #11
    //   66: invokevirtual add : (Ljava/lang/Object;)Z
    //   69: pop
    //   70: goto -> 30
    //   73: aload #11
    //   75: getfield cpo : D
    //   78: dconst_0
    //   79: dcmpg
    //   80: ifge -> 30
    //   83: aload #15
    //   85: aload #11
    //   87: invokevirtual add : (Ljava/lang/Object;)Z
    //   90: pop
    //   91: goto -> 30
    //   94: new com/laiqian/opentable/common/b$a
    //   97: dup
    //   98: invokespecial <init> : ()V
    //   101: astore #12
    //   103: aload_1
    //   104: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   107: getfield coJ : Ljava/lang/String;
    //   110: astore #11
    //   112: aload_1
    //   113: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   116: getfield bZF : I
    //   119: istore #9
    //   121: iload #9
    //   123: iconst_3
    //   124: if_icmpeq -> 137
    //   127: aload #12
    //   129: astore #10
    //   131: iload #9
    //   133: iconst_2
    //   134: if_icmpne -> 230
    //   137: aload #12
    //   139: astore #10
    //   141: aload #11
    //   143: ifnull -> 230
    //   146: aload_0
    //   147: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   150: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   153: astore #10
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial <init> : ()V
    //   162: astore #12
    //   164: aload #12
    //   166: aload_1
    //   167: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   170: getfield aEI : J
    //   173: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #12
    //   179: ldc ''
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #10
    //   187: aload #12
    //   189: invokevirtual toString : ()Ljava/lang/String;
    //   192: aload_1
    //   193: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   196: getfield coJ : Ljava/lang/String;
    //   199: invokestatic parseLong : (Ljava/lang/String;)J
    //   202: invokestatic valueOf : (J)Ljava/lang/Long;
    //   205: iconst_1
    //   206: aload_1
    //   207: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   210: getfield bZM : I
    //   213: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;ZI)Lcom/laiqian/opentable/common/b$a;
    //   216: astore #10
    //   218: aload_1
    //   219: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   222: aload #10
    //   224: getfield bfo : Ljava/lang/String;
    //   227: putfield ceV : Ljava/lang/String;
    //   230: new java/util/ArrayList
    //   233: dup
    //   234: invokespecial <init> : ()V
    //   237: astore #13
    //   239: aload #15
    //   241: invokevirtual size : ()I
    //   244: ifle -> 1057
    //   247: aload_0
    //   248: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   251: aload_2
    //   252: invokevirtual getWidth : ()I
    //   255: invokestatic a : (Lcom/laiqian/print/printtype/g;I)Lcom/laiqian/print/b/g;
    //   258: astore #16
    //   260: iload #9
    //   262: iconst_3
    //   263: if_icmpeq -> 328
    //   266: iload #9
    //   268: iconst_2
    //   269: if_icmpne -> 275
    //   272: goto -> 328
    //   275: aload #11
    //   277: ifnull -> 295
    //   280: aload_0
    //   281: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   284: aload #16
    //   286: aload #11
    //   288: invokestatic b : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   291: pop
    //   292: goto -> 556
    //   295: aload_1
    //   296: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   299: getfield coT : Ljava/lang/String;
    //   302: invokestatic isNull : (Ljava/lang/String;)Z
    //   305: ifne -> 556
    //   308: aload_0
    //   309: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   312: aload #16
    //   314: aload_1
    //   315: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   318: getfield coT : Ljava/lang/String;
    //   321: invokestatic j : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   324: pop
    //   325: goto -> 556
    //   328: aload_0
    //   329: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   332: astore #12
    //   334: new java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial <init> : ()V
    //   341: astore #17
    //   343: aload #17
    //   345: aload #10
    //   347: getfield bZc : Ljava/lang/String;
    //   350: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload #17
    //   356: ldc '-'
    //   358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload #17
    //   364: aload #10
    //   366: getfield bTe : Ljava/lang/String;
    //   369: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload #12
    //   375: aload #16
    //   377: aload #17
    //   379: invokevirtual toString : ()Ljava/lang/String;
    //   382: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   385: pop
    //   386: ldc ''
    //   388: astore #12
    //   390: aload_1
    //   391: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   394: getfield coM : I
    //   397: ifeq -> 468
    //   400: new java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial <init> : ()V
    //   407: astore #12
    //   409: aload #12
    //   411: aload_0
    //   412: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   415: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   418: ldc_w 2131626009
    //   421: invokevirtual getString : (I)Ljava/lang/String;
    //   424: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload #12
    //   430: aload_1
    //   431: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   434: getfield coM : I
    //   437: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload #12
    //   443: invokevirtual toString : ()Ljava/lang/String;
    //   446: astore #12
    //   448: aload #16
    //   450: ldc_w '%s'
    //   453: iconst_1
    //   454: anewarray java/lang/Object
    //   457: dup
    //   458: iconst_0
    //   459: aload #12
    //   461: aastore
    //   462: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   465: invokevirtual lk : (Ljava/lang/String;)V
    //   468: aload_1
    //   469: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   472: new java/util/Date
    //   475: dup
    //   476: invokespecial <init> : ()V
    //   479: putfield coE : Ljava/util/Date;
    //   482: aload #16
    //   484: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   487: astore #17
    //   489: aload #10
    //   491: getfield bZc : Ljava/lang/String;
    //   494: astore #18
    //   496: new java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial <init> : ()V
    //   503: astore #19
    //   505: aload #19
    //   507: aload #10
    //   509: getfield bTe : Ljava/lang/String;
    //   512: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload #19
    //   518: aload #12
    //   520: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload #17
    //   526: ldc_w 'number'
    //   529: ldc_w '%s-%s'
    //   532: iconst_2
    //   533: anewarray java/lang/Object
    //   536: dup
    //   537: iconst_0
    //   538: aload #18
    //   540: aastore
    //   541: dup
    //   542: iconst_1
    //   543: aload #19
    //   545: invokevirtual toString : ()Ljava/lang/String;
    //   548: aastore
    //   549: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   552: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   555: pop
    //   556: new java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial <init> : ()V
    //   563: astore #12
    //   565: aload #12
    //   567: aload_0
    //   568: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   571: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   574: ldc_w 2131628761
    //   577: invokevirtual getString : (I)Ljava/lang/String;
    //   580: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload #12
    //   586: ldc '-'
    //   588: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload #12
    //   594: aload_0
    //   595: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   598: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   601: ldc_w 2131626775
    //   604: invokevirtual getString : (I)Ljava/lang/String;
    //   607: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload #16
    //   613: aload #12
    //   615: invokevirtual toString : ()Ljava/lang/String;
    //   618: iconst_3
    //   619: iconst_1
    //   620: invokevirtual f : (Ljava/lang/String;II)V
    //   623: aload_2
    //   624: invokevirtual ait : ()I
    //   627: tableswitch default -> 648, 1 -> 654, 2 -> 648
    //   648: iconst_3
    //   649: istore #8
    //   651: goto -> 657
    //   654: iconst_0
    //   655: istore #8
    //   657: aload_0
    //   658: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   661: aload #16
    //   663: aload_2
    //   664: invokevirtual getTitle : ()Ljava/lang/String;
    //   667: iload #8
    //   669: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;I)Z
    //   672: pop
    //   673: aload_0
    //   674: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   677: aload #16
    //   679: aload_1
    //   680: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   683: getfield coE : Ljava/util/Date;
    //   686: aload_1
    //   687: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   690: getfield ceV : Ljava/lang/String;
    //   693: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/a;Ljava/util/Date;Ljava/lang/String;)Z
    //   696: pop
    //   697: iload #9
    //   699: iconst_3
    //   700: if_icmpeq -> 709
    //   703: iload #9
    //   705: iconst_2
    //   706: if_icmpne -> 724
    //   709: aload_0
    //   710: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   713: aload #16
    //   715: aload #10
    //   717: getfield bZd : Ljava/lang/String;
    //   720: invokestatic d : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   723: pop
    //   724: aload_1
    //   725: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   728: getfield coK : Ljava/lang/String;
    //   731: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   734: ifne -> 781
    //   737: aload #16
    //   739: iconst_2
    //   740: anewarray java/lang/String
    //   743: dup
    //   744: iconst_0
    //   745: aload_0
    //   746: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   749: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   752: ldc 2131628739
    //   754: invokevirtual getString : (I)Ljava/lang/String;
    //   757: aastore
    //   758: dup
    //   759: iconst_1
    //   760: aload_0
    //   761: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   764: aload_1
    //   765: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   768: getfield coK : Ljava/lang/String;
    //   771: invokestatic a : (Lcom/laiqian/print/printtype/g;Ljava/lang/String;)Ljava/lang/String;
    //   774: aastore
    //   775: invokevirtual x : ([Ljava/lang/String;)V
    //   778: goto -> 781
    //   781: aload #16
    //   783: bipush #45
    //   785: invokevirtual l : (C)V
    //   788: aload_2
    //   789: invokevirtual ais : ()I
    //   792: iconst_1
    //   793: if_icmpne -> 802
    //   796: iconst_0
    //   797: istore #8
    //   799: goto -> 805
    //   802: iconst_1
    //   803: istore #8
    //   805: aload_0
    //   806: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   809: aload #16
    //   811: aload_2
    //   812: invokevirtual aiN : ()Z
    //   815: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Z)Z
    //   818: pop
    //   819: aload #16
    //   821: bipush #45
    //   823: invokevirtual l : (C)V
    //   826: aload_0
    //   827: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   830: aload #16
    //   832: aload #15
    //   834: iload #8
    //   836: iconst_0
    //   837: aload_2
    //   838: invokevirtual aiN : ()Z
    //   841: aload_1
    //   842: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   845: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/util/Collection;IZZLcom/laiqian/pos/hold/PendingFullOrderDetail$a;)Z
    //   848: pop
    //   849: aload #15
    //   851: invokevirtual iterator : ()Ljava/util/Iterator;
    //   854: astore #12
    //   856: dconst_0
    //   857: dstore #4
    //   859: aload #12
    //   861: invokeinterface hasNext : ()Z
    //   866: ifeq -> 928
    //   869: aload #12
    //   871: invokeinterface next : ()Ljava/lang/Object;
    //   876: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   879: astore #17
    //   881: aload #17
    //   883: getfield cpt : Ljava/lang/Double;
    //   886: ifnull -> 902
    //   889: aload #17
    //   891: getfield cpt : Ljava/lang/Double;
    //   894: invokevirtual doubleValue : ()D
    //   897: dstore #6
    //   899: goto -> 912
    //   902: aload #17
    //   904: getfield cpn : D
    //   907: dstore #6
    //   909: goto -> 899
    //   912: dload #4
    //   914: dload #6
    //   916: aload #17
    //   918: getfield cpo : D
    //   921: dmul
    //   922: dadd
    //   923: dstore #4
    //   925: goto -> 859
    //   928: aload #15
    //   930: invokestatic m : (Ljava/util/Collection;)D
    //   933: dstore #6
    //   935: dload #6
    //   937: invokestatic bc : (D)Z
    //   940: ifne -> 992
    //   943: aload #16
    //   945: bipush #45
    //   947: invokevirtual l : (C)V
    //   950: aload_0
    //   951: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   954: aload #16
    //   956: ldc_w 'Sales amount'
    //   959: dload #4
    //   961: dload #6
    //   963: dsub
    //   964: invokestatic valueOf : (D)Ljava/lang/Double;
    //   967: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   970: pop
    //   971: aload_0
    //   972: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   975: aload #16
    //   977: ldc_w 'Total tax'
    //   980: dload #6
    //   982: invokestatic valueOf : (D)Ljava/lang/Double;
    //   985: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   988: pop
    //   989: goto -> 992
    //   992: aload #16
    //   994: bipush #45
    //   996: invokevirtual l : (C)V
    //   999: aload_0
    //   1000: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1003: aload #16
    //   1005: dload #4
    //   1007: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1010: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/Double;)Z
    //   1013: pop
    //   1014: aload_0
    //   1015: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1018: aload #16
    //   1020: aload_2
    //   1021: invokevirtual air : ()I
    //   1024: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;I)Z
    //   1027: pop
    //   1028: aload #16
    //   1030: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1033: aload_3
    //   1034: invokeinterface getCopies : ()I
    //   1039: invokevirtual ih : (I)Lcom/laiqian/print/model/PrintContent$a;
    //   1042: pop
    //   1043: aload #13
    //   1045: aload #16
    //   1047: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1050: invokevirtual add : (Ljava/lang/Object;)Z
    //   1053: pop
    //   1054: goto -> 1057
    //   1057: aload #14
    //   1059: invokevirtual size : ()I
    //   1062: ifle -> 1848
    //   1065: aload_0
    //   1066: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1069: aload_2
    //   1070: invokevirtual getWidth : ()I
    //   1073: invokestatic a : (Lcom/laiqian/print/printtype/g;I)Lcom/laiqian/print/b/g;
    //   1076: astore #15
    //   1078: iload #9
    //   1080: iconst_3
    //   1081: if_icmpeq -> 1146
    //   1084: iload #9
    //   1086: iconst_2
    //   1087: if_icmpne -> 1093
    //   1090: goto -> 1146
    //   1093: aload #11
    //   1095: ifnull -> 1113
    //   1098: aload_0
    //   1099: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1102: aload #15
    //   1104: aload #11
    //   1106: invokestatic b : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   1109: pop
    //   1110: goto -> 1381
    //   1113: aload_1
    //   1114: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1117: getfield coT : Ljava/lang/String;
    //   1120: invokestatic isNull : (Ljava/lang/String;)Z
    //   1123: ifne -> 1110
    //   1126: aload_0
    //   1127: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1130: aload #15
    //   1132: aload_1
    //   1133: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1136: getfield coT : Ljava/lang/String;
    //   1139: invokestatic j : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   1142: pop
    //   1143: goto -> 1110
    //   1146: aload_0
    //   1147: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1150: astore #11
    //   1152: new java/lang/StringBuilder
    //   1155: dup
    //   1156: invokespecial <init> : ()V
    //   1159: astore #16
    //   1161: aload #10
    //   1163: astore #12
    //   1165: aload #16
    //   1167: aload #12
    //   1169: getfield bZc : Ljava/lang/String;
    //   1172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: pop
    //   1176: aload #16
    //   1178: ldc '-'
    //   1180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: pop
    //   1184: aload #16
    //   1186: aload #12
    //   1188: getfield bTe : Ljava/lang/String;
    //   1191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: pop
    //   1195: aload #11
    //   1197: aload #15
    //   1199: aload #16
    //   1201: invokevirtual toString : ()Ljava/lang/String;
    //   1204: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   1207: pop
    //   1208: ldc ''
    //   1210: astore #11
    //   1212: aload_1
    //   1213: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1216: getfield coM : I
    //   1219: ifeq -> 1293
    //   1222: new java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial <init> : ()V
    //   1229: astore #11
    //   1231: aload #11
    //   1233: aload_0
    //   1234: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1237: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1240: ldc_w 2131626009
    //   1243: invokevirtual getString : (I)Ljava/lang/String;
    //   1246: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: pop
    //   1250: aload #11
    //   1252: aload_1
    //   1253: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1256: getfield coM : I
    //   1259: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1262: pop
    //   1263: aload #11
    //   1265: invokevirtual toString : ()Ljava/lang/String;
    //   1268: astore #11
    //   1270: aload #15
    //   1272: ldc_w '%s'
    //   1275: iconst_1
    //   1276: anewarray java/lang/Object
    //   1279: dup
    //   1280: iconst_0
    //   1281: aload #11
    //   1283: aastore
    //   1284: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1287: invokevirtual lk : (Ljava/lang/String;)V
    //   1290: goto -> 1293
    //   1293: aload_1
    //   1294: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1297: new java/util/Date
    //   1300: dup
    //   1301: invokespecial <init> : ()V
    //   1304: putfield coE : Ljava/util/Date;
    //   1307: aload #15
    //   1309: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1312: astore #16
    //   1314: aload #12
    //   1316: getfield bZc : Ljava/lang/String;
    //   1319: astore #17
    //   1321: new java/lang/StringBuilder
    //   1324: dup
    //   1325: invokespecial <init> : ()V
    //   1328: astore #18
    //   1330: aload #18
    //   1332: aload #12
    //   1334: getfield bTe : Ljava/lang/String;
    //   1337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: pop
    //   1341: aload #18
    //   1343: aload #11
    //   1345: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aload #16
    //   1351: ldc_w 'number'
    //   1354: ldc_w '%s-%s'
    //   1357: iconst_2
    //   1358: anewarray java/lang/Object
    //   1361: dup
    //   1362: iconst_0
    //   1363: aload #17
    //   1365: aastore
    //   1366: dup
    //   1367: iconst_1
    //   1368: aload #18
    //   1370: invokevirtual toString : ()Ljava/lang/String;
    //   1373: aastore
    //   1374: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1377: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   1380: pop
    //   1381: new java/lang/StringBuilder
    //   1384: dup
    //   1385: invokespecial <init> : ()V
    //   1388: astore #11
    //   1390: aload #11
    //   1392: aload_0
    //   1393: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1396: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1399: ldc_w 2131628761
    //   1402: invokevirtual getString : (I)Ljava/lang/String;
    //   1405: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: pop
    //   1409: aload #11
    //   1411: ldc '-'
    //   1413: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: pop
    //   1417: aload #11
    //   1419: aload_0
    //   1420: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1423: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1426: ldc_w 2131626782
    //   1429: invokevirtual getString : (I)Ljava/lang/String;
    //   1432: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1435: pop
    //   1436: aload #15
    //   1438: aload #11
    //   1440: invokevirtual toString : ()Ljava/lang/String;
    //   1443: iconst_3
    //   1444: iconst_1
    //   1445: invokevirtual f : (Ljava/lang/String;II)V
    //   1448: aload_2
    //   1449: invokevirtual ait : ()I
    //   1452: tableswitch default -> 1476, 1 -> 1482, 2 -> 1476
    //   1476: iconst_3
    //   1477: istore #8
    //   1479: goto -> 1485
    //   1482: iconst_0
    //   1483: istore #8
    //   1485: aload_0
    //   1486: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1489: aload #15
    //   1491: aload_2
    //   1492: invokevirtual getTitle : ()Ljava/lang/String;
    //   1495: iload #8
    //   1497: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;I)Z
    //   1500: pop
    //   1501: aload_0
    //   1502: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1505: aload #15
    //   1507: aload_1
    //   1508: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1511: getfield coE : Ljava/util/Date;
    //   1514: aload_1
    //   1515: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1518: getfield ceV : Ljava/lang/String;
    //   1521: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/a;Ljava/util/Date;Ljava/lang/String;)Z
    //   1524: pop
    //   1525: iload #9
    //   1527: iconst_3
    //   1528: if_icmpeq -> 1537
    //   1531: iload #9
    //   1533: iconst_2
    //   1534: if_icmpne -> 1552
    //   1537: aload_0
    //   1538: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1541: aload #15
    //   1543: aload #10
    //   1545: getfield bZd : Ljava/lang/String;
    //   1548: invokestatic d : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   1551: pop
    //   1552: aload_1
    //   1553: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1556: getfield coK : Ljava/lang/String;
    //   1559: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1562: ifne -> 1606
    //   1565: aload #15
    //   1567: iconst_2
    //   1568: anewarray java/lang/String
    //   1571: dup
    //   1572: iconst_0
    //   1573: aload_0
    //   1574: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1577: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1580: ldc 2131628739
    //   1582: invokevirtual getString : (I)Ljava/lang/String;
    //   1585: aastore
    //   1586: dup
    //   1587: iconst_1
    //   1588: aload_0
    //   1589: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1592: aload_1
    //   1593: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1596: getfield coK : Ljava/lang/String;
    //   1599: invokestatic a : (Lcom/laiqian/print/printtype/g;Ljava/lang/String;)Ljava/lang/String;
    //   1602: aastore
    //   1603: invokevirtual x : ([Ljava/lang/String;)V
    //   1606: aload #15
    //   1608: bipush #45
    //   1610: invokevirtual l : (C)V
    //   1613: aload_2
    //   1614: invokevirtual ais : ()I
    //   1617: iconst_1
    //   1618: if_icmpne -> 1627
    //   1621: iconst_0
    //   1622: istore #8
    //   1624: goto -> 1630
    //   1627: iconst_1
    //   1628: istore #8
    //   1630: aload_0
    //   1631: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1634: aload #15
    //   1636: aload_2
    //   1637: invokevirtual aiN : ()Z
    //   1640: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Z)Z
    //   1643: pop
    //   1644: aload #15
    //   1646: bipush #45
    //   1648: invokevirtual l : (C)V
    //   1651: aload_0
    //   1652: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1655: aload #15
    //   1657: aload #14
    //   1659: iload #8
    //   1661: iconst_0
    //   1662: aload_2
    //   1663: invokevirtual aiN : ()Z
    //   1666: aload_1
    //   1667: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1670: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/util/Collection;IZZLcom/laiqian/pos/hold/PendingFullOrderDetail$a;)Z
    //   1673: pop
    //   1674: aload #14
    //   1676: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1679: astore_1
    //   1680: dconst_0
    //   1681: dstore #4
    //   1683: aload_1
    //   1684: invokeinterface hasNext : ()Z
    //   1689: ifeq -> 1722
    //   1692: aload_1
    //   1693: invokeinterface next : ()Ljava/lang/Object;
    //   1698: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   1701: astore #10
    //   1703: dload #4
    //   1705: aload #10
    //   1707: getfield cpn : D
    //   1710: aload #10
    //   1712: getfield cpo : D
    //   1715: dmul
    //   1716: dadd
    //   1717: dstore #4
    //   1719: goto -> 1683
    //   1722: aload #14
    //   1724: invokestatic m : (Ljava/util/Collection;)D
    //   1727: dstore #6
    //   1729: dload #6
    //   1731: invokestatic bc : (D)Z
    //   1734: ifne -> 1783
    //   1737: aload #15
    //   1739: bipush #45
    //   1741: invokevirtual l : (C)V
    //   1744: aload_0
    //   1745: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1748: aload #15
    //   1750: ldc_w 'Sales amount'
    //   1753: dload #4
    //   1755: dload #6
    //   1757: dsub
    //   1758: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1761: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   1764: pop
    //   1765: aload_0
    //   1766: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1769: aload #15
    //   1771: ldc_w 'Total tax'
    //   1774: dload #6
    //   1776: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1779: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;Ljava/lang/Number;)Z
    //   1782: pop
    //   1783: aload #15
    //   1785: bipush #45
    //   1787: invokevirtual l : (C)V
    //   1790: aload_0
    //   1791: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1794: aload #15
    //   1796: dload #4
    //   1798: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1801: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/Double;)Z
    //   1804: pop
    //   1805: aload_0
    //   1806: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1809: aload #15
    //   1811: aload_2
    //   1812: invokevirtual air : ()I
    //   1815: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;I)Z
    //   1818: pop
    //   1819: aload #15
    //   1821: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1824: aload_3
    //   1825: invokeinterface getCopies : ()I
    //   1830: invokevirtual ih : (I)Lcom/laiqian/print/model/PrintContent$a;
    //   1833: pop
    //   1834: aload #13
    //   1836: aload #15
    //   1838: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1841: invokevirtual add : (Ljava/lang/Object;)Z
    //   1844: pop
    //   1845: aload #13
    //   1847: areturn
    //   1848: aload #13
    //   1850: areturn }
  
  private List<PrintContent> a(ah paramah, c paramc, j.m paramm) {
    ArrayList arrayList = new ArrayList();
    List list = paramm.aep();
    paramc.getWidth();
    paramc.getHeight();
    paramc.aiW();
    null = new av(g.b(this.cJq));
    null.atY();
    null.aub();
    null.close();
    new Date();
    Iterator iterator = paramah.cdy.cpg.iterator();
    int j;
    for (j = 0; iterator.hasNext(); j += k) {
      PendingFullOrderDetail.d d1 = (PendingFullOrderDetail.d)iterator.next();
      try {
        boolean bool = list.contains(Long.valueOf(d1.cpq));
        if (bool)
          continue; 
      } catch (ClassCastException classCastException) {
        a.e(classCastException);
      } 
      if (d1.cpx == 2L || !this.cJq.a(paramah.bXb, paramc, d1.aTZ))
        continue; 
      double d = d1.cpo;
      int k = Integer.parseInt(aw.kF((new DecimalFormat("0")).format(d)));
      if (k <= 0)
        continue; 
    } 
    if (j == 0)
      return null; 
    if (j > 1000)
      return null; 
    if (paramc.aiV() == c.cOl) {
      g.a(this.cJq, paramah.cdy, paramc, arrayList, list, j, paramah.bXb);
      return arrayList;
    } 
    g.a(this.cJq, paramah.cdy, paramc, arrayList, list, paramah.bXb);
    return arrayList;
  }
  
  private List<PrintContent> a(a parama, c paramc, j.c paramc1, boolean paramBoolean) { // Byte code:
    //   0: aload_1
    //   1: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   4: getfield bZF : I
    //   7: iconst_2
    //   8: if_icmpne -> 75
    //   11: new com/laiqian/opentable/b/q
    //   14: dup
    //   15: aload_0
    //   16: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   19: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   22: invokespecial <init> : (Landroid/content/Context;)V
    //   25: astore #11
    //   27: aload #11
    //   29: aload_1
    //   30: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   33: getfield coJ : Ljava/lang/String;
    //   36: invokestatic parseLong : (Ljava/lang/String;)J
    //   39: invokevirtual ck : (J)Lcom/laiqian/opentable/common/entity/TableEntity;
    //   42: astore #12
    //   44: aload #11
    //   46: invokevirtual close : ()V
    //   49: aload #12
    //   51: invokevirtual XY : ()J
    //   54: lstore #9
    //   56: aload_3
    //   57: invokevirtual aeq : ()Ljava/util/List;
    //   60: lload #9
    //   62: invokestatic valueOf : (J)Ljava/lang/Long;
    //   65: invokeinterface contains : (Ljava/lang/Object;)Z
    //   70: ifeq -> 75
    //   73: aconst_null
    //   74: areturn
    //   75: aload_2
    //   76: invokevirtual getOrder : ()I
    //   79: iconst_2
    //   80: if_icmpne -> 94
    //   83: aload_0
    //   84: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   87: aload_1
    //   88: getfield cpg : Ljava/util/ArrayList;
    //   91: invokestatic a : (Lcom/laiqian/print/printtype/g;Ljava/util/ArrayList;)V
    //   94: aload_1
    //   95: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   98: getfield coJ : Ljava/lang/String;
    //   101: astore #13
    //   103: aload_1
    //   104: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   107: getfield bZF : I
    //   110: istore #8
    //   112: new com/laiqian/opentable/common/b$a
    //   115: dup
    //   116: invokespecial <init> : ()V
    //   119: astore #11
    //   121: iload #8
    //   123: iconst_3
    //   124: if_icmpeq -> 137
    //   127: aload #11
    //   129: astore #12
    //   131: iload #8
    //   133: iconst_2
    //   134: if_icmpne -> 230
    //   137: aload #11
    //   139: astore #12
    //   141: aload #13
    //   143: ifnull -> 230
    //   146: aload_0
    //   147: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   150: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   153: astore #11
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial <init> : ()V
    //   162: astore #12
    //   164: aload #12
    //   166: aload_1
    //   167: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   170: getfield aEI : J
    //   173: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #12
    //   179: ldc ''
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #11
    //   187: aload #12
    //   189: invokevirtual toString : ()Ljava/lang/String;
    //   192: aload_1
    //   193: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   196: getfield coJ : Ljava/lang/String;
    //   199: invokestatic parseLong : (Ljava/lang/String;)J
    //   202: invokestatic valueOf : (J)Ljava/lang/Long;
    //   205: iconst_1
    //   206: aload_1
    //   207: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   210: getfield bZM : I
    //   213: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;ZI)Lcom/laiqian/opentable/common/b$a;
    //   216: astore #12
    //   218: aload_1
    //   219: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   222: aload #12
    //   224: getfield bfo : Ljava/lang/String;
    //   227: putfield ceV : Ljava/lang/String;
    //   230: new java/util/ArrayList
    //   233: dup
    //   234: invokespecial <init> : ()V
    //   237: astore #11
    //   239: aload_3
    //   240: invokevirtual aep : ()Ljava/util/List;
    //   243: astore #16
    //   245: aload_1
    //   246: getfield cpg : Ljava/util/ArrayList;
    //   249: invokevirtual iterator : ()Ljava/util/Iterator;
    //   252: astore #14
    //   254: iconst_0
    //   255: istore #6
    //   257: aload #14
    //   259: invokeinterface hasNext : ()Z
    //   264: ifeq -> 354
    //   267: aload #14
    //   269: invokeinterface next : ()Ljava/lang/Object;
    //   274: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   277: astore #15
    //   279: aload #16
    //   281: aload #15
    //   283: getfield cpq : J
    //   286: invokestatic valueOf : (J)Ljava/lang/Long;
    //   289: invokeinterface contains : (Ljava/lang/Object;)Z
    //   294: ifeq -> 304
    //   297: iload #6
    //   299: istore #5
    //   301: goto -> 338
    //   304: iload #8
    //   306: iconst_3
    //   307: if_icmpne -> 345
    //   310: iload #6
    //   312: istore #5
    //   314: aload #15
    //   316: getfield aTU : I
    //   319: ifne -> 338
    //   322: aload #15
    //   324: getfield cpx : J
    //   327: ldc2_w 4
    //   330: lcmp
    //   331: ifne -> 345
    //   334: iload #6
    //   336: istore #5
    //   338: iload #5
    //   340: istore #6
    //   342: goto -> 257
    //   345: iload #6
    //   347: iconst_1
    //   348: iadd
    //   349: istore #5
    //   351: goto -> 338
    //   354: aload_1
    //   355: getfield cpg : Ljava/util/ArrayList;
    //   358: invokevirtual iterator : ()Ljava/util/Iterator;
    //   361: astore #15
    //   363: iconst_1
    //   364: istore #7
    //   366: aload #11
    //   368: astore #14
    //   370: aload #15
    //   372: astore #11
    //   374: iload #8
    //   376: istore #5
    //   378: aload #11
    //   380: invokeinterface hasNext : ()Z
    //   385: ifeq -> 1562
    //   388: aload #11
    //   390: invokeinterface next : ()Ljava/lang/Object;
    //   395: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   398: astore #17
    //   400: iload #5
    //   402: iconst_3
    //   403: if_icmpne -> 432
    //   406: aload #17
    //   408: getfield aTU : I
    //   411: ifne -> 429
    //   414: aload #17
    //   416: getfield cpx : J
    //   419: ldc2_w 4
    //   422: lcmp
    //   423: ifne -> 432
    //   426: goto -> 429
    //   429: goto -> 378
    //   432: aload #16
    //   434: aload #17
    //   436: getfield cpq : J
    //   439: invokestatic valueOf : (J)Ljava/lang/Long;
    //   442: invokeinterface contains : (Ljava/lang/Object;)Z
    //   447: ifne -> 1559
    //   450: aload_0
    //   451: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   454: aload_2
    //   455: invokevirtual getWidth : ()I
    //   458: invokestatic a : (Lcom/laiqian/print/printtype/g;I)Lcom/laiqian/print/b/g;
    //   461: astore #18
    //   463: iload #6
    //   465: iconst_1
    //   466: if_icmpne -> 714
    //   469: iload #5
    //   471: istore #8
    //   473: iload #8
    //   475: iconst_3
    //   476: if_icmpeq -> 612
    //   479: iload #8
    //   481: iconst_2
    //   482: if_icmpne -> 488
    //   485: goto -> 612
    //   488: aload #13
    //   490: ifnull -> 609
    //   493: aload_0
    //   494: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   497: astore #15
    //   499: aload_1
    //   500: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   503: getfield aVN : J
    //   506: lconst_1
    //   507: lcmp
    //   508: ifne -> 517
    //   511: iconst_1
    //   512: istore #4
    //   514: goto -> 520
    //   517: iconst_0
    //   518: istore #4
    //   520: aload #18
    //   522: ldc_w '%s %s'
    //   525: iconst_2
    //   526: anewarray java/lang/Object
    //   529: dup
    //   530: iconst_0
    //   531: aload #15
    //   533: iload #4
    //   535: invokevirtual fU : (Z)Ljava/lang/String;
    //   538: aastore
    //   539: dup
    //   540: iconst_1
    //   541: aload_1
    //   542: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   545: getfield coJ : Ljava/lang/String;
    //   548: aastore
    //   549: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   552: invokevirtual lk : (Ljava/lang/String;)V
    //   555: aload #18
    //   557: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   560: astore #15
    //   562: new java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial <init> : ()V
    //   569: astore #19
    //   571: aload #19
    //   573: aload_1
    //   574: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   577: getfield coJ : Ljava/lang/String;
    //   580: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload #19
    //   586: ldc ''
    //   588: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload #15
    //   594: ldc_w 'number'
    //   597: aload #19
    //   599: invokevirtual toString : ()Ljava/lang/String;
    //   602: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   605: pop
    //   606: goto -> 609
    //   609: goto -> 711
    //   612: aload #18
    //   614: ldc_w '%s %s-%s'
    //   617: iconst_3
    //   618: anewarray java/lang/Object
    //   621: dup
    //   622: iconst_0
    //   623: aload_0
    //   624: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   627: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   630: ldc_w 2131628305
    //   633: invokevirtual getString : (I)Ljava/lang/String;
    //   636: aastore
    //   637: dup
    //   638: iconst_1
    //   639: aload #12
    //   641: getfield bZc : Ljava/lang/String;
    //   644: aastore
    //   645: dup
    //   646: iconst_2
    //   647: aload #12
    //   649: getfield bTe : Ljava/lang/String;
    //   652: aastore
    //   653: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   656: invokevirtual lk : (Ljava/lang/String;)V
    //   659: aload_1
    //   660: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   663: new java/util/Date
    //   666: dup
    //   667: invokespecial <init> : ()V
    //   670: putfield coE : Ljava/util/Date;
    //   673: aload #18
    //   675: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   678: ldc_w 'number'
    //   681: ldc_w '%s-%s'
    //   684: iconst_2
    //   685: anewarray java/lang/Object
    //   688: dup
    //   689: iconst_0
    //   690: aload #12
    //   692: getfield bZc : Ljava/lang/String;
    //   695: aastore
    //   696: dup
    //   697: iconst_1
    //   698: aload #12
    //   700: getfield bTe : Ljava/lang/String;
    //   703: aastore
    //   704: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   707: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   710: pop
    //   711: goto -> 1230
    //   714: iload #5
    //   716: istore #8
    //   718: iload #8
    //   720: iconst_3
    //   721: if_icmpeq -> 931
    //   724: iload #8
    //   726: iconst_2
    //   727: if_icmpne -> 733
    //   730: goto -> 931
    //   733: aload #18
    //   735: iconst_1
    //   736: anewarray java/lang/String
    //   739: dup
    //   740: iconst_0
    //   741: aload_0
    //   742: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   745: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   748: ldc_w 2131629622
    //   751: invokevirtual getString : (I)Ljava/lang/String;
    //   754: iconst_2
    //   755: anewarray java/lang/Object
    //   758: dup
    //   759: iconst_0
    //   760: iload #7
    //   762: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   765: aastore
    //   766: dup
    //   767: iconst_1
    //   768: iload #6
    //   770: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   773: aastore
    //   774: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   777: aastore
    //   778: invokevirtual x : ([Ljava/lang/String;)V
    //   781: aload #18
    //   783: iconst_1
    //   784: anewarray java/lang/String
    //   787: dup
    //   788: iconst_0
    //   789: ldc ''
    //   791: aastore
    //   792: invokevirtual x : ([Ljava/lang/String;)V
    //   795: aload_0
    //   796: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   799: astore #15
    //   801: aload_1
    //   802: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   805: getfield aVN : J
    //   808: lconst_1
    //   809: lcmp
    //   810: ifne -> 819
    //   813: iconst_1
    //   814: istore #4
    //   816: goto -> 822
    //   819: iconst_0
    //   820: istore #4
    //   822: aload #18
    //   824: ldc_w '%s %s'
    //   827: iconst_2
    //   828: anewarray java/lang/Object
    //   831: dup
    //   832: iconst_0
    //   833: aload #15
    //   835: iload #4
    //   837: invokevirtual fU : (Z)Ljava/lang/String;
    //   840: aastore
    //   841: dup
    //   842: iconst_1
    //   843: aload_1
    //   844: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   847: getfield coJ : Ljava/lang/String;
    //   850: aastore
    //   851: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   854: invokevirtual lk : (Ljava/lang/String;)V
    //   857: aload #18
    //   859: iconst_1
    //   860: anewarray java/lang/String
    //   863: dup
    //   864: iconst_0
    //   865: ldc ''
    //   867: aastore
    //   868: invokevirtual x : ([Ljava/lang/String;)V
    //   871: aload #18
    //   873: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   876: astore #15
    //   878: new java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial <init> : ()V
    //   885: astore #19
    //   887: aload #19
    //   889: aload_1
    //   890: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   893: getfield coJ : Ljava/lang/String;
    //   896: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: aload #19
    //   902: ldc ''
    //   904: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload #15
    //   910: ldc_w 'number'
    //   913: aload #19
    //   915: invokevirtual toString : ()Ljava/lang/String;
    //   918: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   921: pop
    //   922: iload #7
    //   924: iconst_1
    //   925: iadd
    //   926: istore #7
    //   928: goto -> 1230
    //   931: aload_0
    //   932: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   935: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   938: ldc_w 2131629622
    //   941: invokevirtual getString : (I)Ljava/lang/String;
    //   944: astore #15
    //   946: iload #7
    //   948: iconst_1
    //   949: iadd
    //   950: istore #8
    //   952: aload #18
    //   954: iconst_1
    //   955: anewarray java/lang/String
    //   958: dup
    //   959: iconst_0
    //   960: aload #15
    //   962: iconst_2
    //   963: anewarray java/lang/Object
    //   966: dup
    //   967: iconst_0
    //   968: iload #7
    //   970: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   973: aastore
    //   974: dup
    //   975: iconst_1
    //   976: iload #6
    //   978: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   981: aastore
    //   982: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   985: aastore
    //   986: invokevirtual x : ([Ljava/lang/String;)V
    //   989: aload #18
    //   991: iconst_1
    //   992: anewarray java/lang/String
    //   995: dup
    //   996: iconst_0
    //   997: ldc ''
    //   999: aastore
    //   1000: invokevirtual x : ([Ljava/lang/String;)V
    //   1003: aload #18
    //   1005: ldc_w '%s %s-%s'
    //   1008: iconst_3
    //   1009: anewarray java/lang/Object
    //   1012: dup
    //   1013: iconst_0
    //   1014: aload_0
    //   1015: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1018: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1021: ldc_w 2131628305
    //   1024: invokevirtual getString : (I)Ljava/lang/String;
    //   1027: aastore
    //   1028: dup
    //   1029: iconst_1
    //   1030: aload #12
    //   1032: getfield bZc : Ljava/lang/String;
    //   1035: aastore
    //   1036: dup
    //   1037: iconst_2
    //   1038: aload #12
    //   1040: getfield bTe : Ljava/lang/String;
    //   1043: aastore
    //   1044: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1047: invokevirtual lk : (Ljava/lang/String;)V
    //   1050: aload #18
    //   1052: iconst_1
    //   1053: anewarray java/lang/String
    //   1056: dup
    //   1057: iconst_0
    //   1058: ldc ''
    //   1060: aastore
    //   1061: invokevirtual x : ([Ljava/lang/String;)V
    //   1064: ldc ''
    //   1066: astore #15
    //   1068: aload_1
    //   1069: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1072: getfield coM : I
    //   1075: ifeq -> 1149
    //   1078: new java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial <init> : ()V
    //   1085: astore #15
    //   1087: aload #15
    //   1089: aload_0
    //   1090: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1093: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1096: ldc_w 2131626009
    //   1099: invokevirtual getString : (I)Ljava/lang/String;
    //   1102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: aload #15
    //   1108: aload_1
    //   1109: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1112: getfield coM : I
    //   1115: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: aload #15
    //   1121: invokevirtual toString : ()Ljava/lang/String;
    //   1124: astore #15
    //   1126: aload #18
    //   1128: ldc_w '%s'
    //   1131: iconst_1
    //   1132: anewarray java/lang/Object
    //   1135: dup
    //   1136: iconst_0
    //   1137: aload #15
    //   1139: aastore
    //   1140: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1143: invokevirtual lk : (Ljava/lang/String;)V
    //   1146: goto -> 1149
    //   1149: aload #18
    //   1151: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1154: astore #19
    //   1156: aload #12
    //   1158: getfield bZc : Ljava/lang/String;
    //   1161: astore #20
    //   1163: new java/lang/StringBuilder
    //   1166: dup
    //   1167: invokespecial <init> : ()V
    //   1170: astore #21
    //   1172: aload #21
    //   1174: aload #12
    //   1176: getfield bTe : Ljava/lang/String;
    //   1179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: pop
    //   1183: aload #21
    //   1185: aload #15
    //   1187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: pop
    //   1191: aload #19
    //   1193: ldc_w 'number'
    //   1196: ldc_w '%s-%s'
    //   1199: iconst_2
    //   1200: anewarray java/lang/Object
    //   1203: dup
    //   1204: iconst_0
    //   1205: aload #20
    //   1207: aastore
    //   1208: dup
    //   1209: iconst_1
    //   1210: aload #21
    //   1212: invokevirtual toString : ()Ljava/lang/String;
    //   1215: aastore
    //   1216: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1219: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   1222: pop
    //   1223: iload #8
    //   1225: istore #7
    //   1227: goto -> 711
    //   1230: iload #5
    //   1232: istore #8
    //   1234: iload #8
    //   1236: iconst_3
    //   1237: if_icmpne -> 1269
    //   1240: aload_0
    //   1241: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1244: aload_1
    //   1245: invokevirtual a : (Lcom/laiqian/pos/model/orders/a;)Z
    //   1248: ifeq -> 1269
    //   1251: aload #18
    //   1253: aload_0
    //   1254: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1257: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1260: ldc_w 2131626782
    //   1263: invokevirtual getString : (I)Ljava/lang/String;
    //   1266: invokevirtual lk : (Ljava/lang/String;)V
    //   1269: iload #8
    //   1271: iconst_3
    //   1272: if_icmpeq -> 1380
    //   1275: iload #8
    //   1277: iconst_2
    //   1278: if_icmpne -> 1284
    //   1281: goto -> 1380
    //   1284: aload_0
    //   1285: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1288: aload #18
    //   1290: aload_1
    //   1291: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1294: getfield coE : Ljava/util/Date;
    //   1297: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/util/Date;)Z
    //   1300: pop
    //   1301: aload_1
    //   1302: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1305: getfield coN : Ljava/lang/String;
    //   1308: invokestatic isNull : (Ljava/lang/String;)Z
    //   1311: ifne -> 1377
    //   1314: aload #18
    //   1316: bipush #45
    //   1318: invokevirtual l : (C)V
    //   1321: new java/lang/StringBuilder
    //   1324: dup
    //   1325: invokespecial <init> : ()V
    //   1328: astore #15
    //   1330: aload #15
    //   1332: aload_0
    //   1333: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1336: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1339: ldc_w 2131628790
    //   1342: invokevirtual getString : (I)Ljava/lang/String;
    //   1345: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aload #15
    //   1351: aload_1
    //   1352: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1355: getfield coN : Ljava/lang/String;
    //   1358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: pop
    //   1362: aload #18
    //   1364: aload #15
    //   1366: invokevirtual toString : ()Ljava/lang/String;
    //   1369: iconst_1
    //   1370: iconst_0
    //   1371: invokevirtual f : (Ljava/lang/String;II)V
    //   1374: goto -> 1377
    //   1377: goto -> 1487
    //   1380: aload_0
    //   1381: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1384: aload #18
    //   1386: aload_1
    //   1387: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1390: getfield coE : Ljava/util/Date;
    //   1393: aload_1
    //   1394: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1397: getfield ceV : Ljava/lang/String;
    //   1400: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/a;Ljava/util/Date;Ljava/lang/String;)Z
    //   1403: pop
    //   1404: aload_0
    //   1405: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1408: astore #19
    //   1410: aload_0
    //   1411: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1414: aload_1
    //   1415: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/pos/model/orders/a;)Z
    //   1418: ifne -> 1440
    //   1421: iload #8
    //   1423: iconst_3
    //   1424: if_icmpne -> 1430
    //   1427: goto -> 1440
    //   1430: aload #12
    //   1432: getfield bZd : Ljava/lang/String;
    //   1435: astore #15
    //   1437: goto -> 1477
    //   1440: new java/lang/StringBuilder
    //   1443: dup
    //   1444: invokespecial <init> : ()V
    //   1447: astore #15
    //   1449: aload #15
    //   1451: aload_1
    //   1452: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1455: getfield bZM : I
    //   1458: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1461: pop
    //   1462: aload #15
    //   1464: ldc ''
    //   1466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: pop
    //   1470: aload #15
    //   1472: invokevirtual toString : ()Ljava/lang/String;
    //   1475: astore #15
    //   1477: aload #19
    //   1479: aload #18
    //   1481: aload #15
    //   1483: invokestatic d : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   1486: pop
    //   1487: aload #18
    //   1489: bipush #45
    //   1491: invokevirtual l : (C)V
    //   1494: aload_0
    //   1495: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1498: aload #18
    //   1500: aload #17
    //   1502: aload_2
    //   1503: aload_0
    //   1504: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1507: aload_1
    //   1508: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/pos/model/orders/a;)Z
    //   1511: aload_1
    //   1512: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1515: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Lcom/laiqian/pos/hold/PendingFullOrderDetail$d;Lcom/laiqian/print/usage/kitchen/a/c;ZLcom/laiqian/pos/hold/PendingFullOrderDetail$a;)V
    //   1518: aload_0
    //   1519: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1522: aload #18
    //   1524: aload_2
    //   1525: invokevirtual air : ()I
    //   1528: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;I)Z
    //   1531: pop
    //   1532: aload #18
    //   1534: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1537: aload_3
    //   1538: invokevirtual getCopies : ()I
    //   1541: invokevirtual ih : (I)Lcom/laiqian/print/model/PrintContent$a;
    //   1544: pop
    //   1545: aload #14
    //   1547: aload #18
    //   1549: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1552: invokevirtual add : (Ljava/lang/Object;)Z
    //   1555: pop
    //   1556: goto -> 1559
    //   1559: goto -> 378
    //   1562: aload #14
    //   1564: new com/laiqian/print/model/PrintContent$a
    //   1567: dup
    //   1568: invokespecial <init> : ()V
    //   1571: invokevirtual agg : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1574: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1577: invokevirtual add : (Ljava/lang/Object;)Z
    //   1580: pop
    //   1581: aload #14
    //   1583: areturn }
  
  private List<PrintContent> a(a parama, c paramc, j.m paramm, boolean paramBoolean) {
    null = parama.cpg.iterator();
    while (null.hasNext()) {
      if (((PendingFullOrderDetail.d)null.next()).id == 6L)
        null.remove(); 
    } 
    ArrayList arrayList = new ArrayList();
    int k = parama.bXb.bZF;
    List list = paramm.aep();
    Iterator iterator = parama.cpg.iterator();
    int j;
    for (j = 0; iterator.hasNext(); j += n) {
      PendingFullOrderDetail.d d1 = (PendingFullOrderDetail.d)iterator.next();
      if ((k == 3 && d1.aTU != 0) || d1.cpx == 4L)
        continue; 
      try {
        paramBoolean = list.contains(Long.valueOf(d1.cpq));
        if (paramBoolean)
          continue; 
      } catch (ClassCastException classCastException) {
        a.e(classCastException);
      } 
      if (d1.cpx == 2L || !this.cJq.a(parama.bXb, paramc, d1.aTZ))
        continue; 
      double d = d1.cpo;
      int n = Integer.parseInt(aw.kF((new DecimalFormat("0")).format(d)));
      if (n <= 0)
        continue; 
    } 
    if (j == 0)
      return null; 
    if (j > 1000)
      return null; 
    if (paramc.aiV() == c.cOl) {
      g.a(this.cJq, parama, paramc, arrayList, list, j);
      return arrayList;
    } 
    g.a(this.cJq, parama, paramc, arrayList, list);
    return arrayList;
  }
  
  private List<PrintContent> b(ah paramah, c paramc, j.c paramc1) { // Byte code:
    //   0: aload_1
    //   1: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   4: getfield bZF : I
    //   7: iconst_2
    //   8: if_icmpne -> 75
    //   11: new com/laiqian/opentable/b/q
    //   14: dup
    //   15: aload_0
    //   16: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   19: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   22: invokespecial <init> : (Landroid/content/Context;)V
    //   25: astore #9
    //   27: aload #9
    //   29: aload_1
    //   30: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   33: getfield coJ : Ljava/lang/String;
    //   36: invokestatic parseLong : (Ljava/lang/String;)J
    //   39: invokevirtual ck : (J)Lcom/laiqian/opentable/common/entity/TableEntity;
    //   42: astore #10
    //   44: aload #9
    //   46: invokevirtual close : ()V
    //   49: aload #10
    //   51: invokevirtual XY : ()J
    //   54: lstore #6
    //   56: aload_3
    //   57: invokevirtual aeq : ()Ljava/util/List;
    //   60: lload #6
    //   62: invokestatic valueOf : (J)Ljava/lang/Long;
    //   65: invokeinterface contains : (Ljava/lang/Object;)Z
    //   70: ifeq -> 75
    //   73: aconst_null
    //   74: areturn
    //   75: aload_2
    //   76: invokevirtual getOrder : ()I
    //   79: iconst_2
    //   80: if_icmpne -> 97
    //   83: aload_0
    //   84: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   87: aload_1
    //   88: getfield cdy : Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;
    //   91: getfield cpg : Ljava/util/ArrayList;
    //   94: invokestatic a : (Lcom/laiqian/print/printtype/g;Ljava/util/ArrayList;)V
    //   97: aload_1
    //   98: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   101: getfield coJ : Ljava/lang/String;
    //   104: astore #16
    //   106: aload_1
    //   107: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   110: getfield bZF : I
    //   113: istore #4
    //   115: new com/laiqian/opentable/common/b$a
    //   118: dup
    //   119: invokespecial <init> : ()V
    //   122: astore #10
    //   124: iload #4
    //   126: iconst_3
    //   127: if_icmpeq -> 140
    //   130: aload #10
    //   132: astore #9
    //   134: iload #4
    //   136: iconst_2
    //   137: if_icmpne -> 233
    //   140: aload #10
    //   142: astore #9
    //   144: aload #16
    //   146: ifnull -> 233
    //   149: aload_0
    //   150: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   153: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   156: astore #9
    //   158: new java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial <init> : ()V
    //   165: astore #10
    //   167: aload #10
    //   169: aload_1
    //   170: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   173: getfield aEI : J
    //   176: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload #10
    //   182: ldc ''
    //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload #9
    //   190: aload #10
    //   192: invokevirtual toString : ()Ljava/lang/String;
    //   195: aload_1
    //   196: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   199: getfield coJ : Ljava/lang/String;
    //   202: invokestatic parseLong : (Ljava/lang/String;)J
    //   205: invokestatic valueOf : (J)Ljava/lang/Long;
    //   208: iconst_1
    //   209: aload_1
    //   210: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   213: getfield bZM : I
    //   216: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;ZI)Lcom/laiqian/opentable/common/b$a;
    //   219: astore #9
    //   221: aload_1
    //   222: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   225: aload #9
    //   227: getfield bfo : Ljava/lang/String;
    //   230: putfield ceV : Ljava/lang/String;
    //   233: new java/util/ArrayList
    //   236: dup
    //   237: invokespecial <init> : ()V
    //   240: astore #14
    //   242: new java/util/ArrayList
    //   245: dup
    //   246: invokespecial <init> : ()V
    //   249: astore #15
    //   251: new java/util/ArrayList
    //   254: dup
    //   255: invokespecial <init> : ()V
    //   258: astore #11
    //   260: aload_1
    //   261: getfield cdy : Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;
    //   264: getfield cpg : Ljava/util/ArrayList;
    //   267: invokevirtual iterator : ()Ljava/util/Iterator;
    //   270: astore #10
    //   272: aload #10
    //   274: invokeinterface hasNext : ()Z
    //   279: ifeq -> 336
    //   282: aload #10
    //   284: invokeinterface next : ()Ljava/lang/Object;
    //   289: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   292: astore #12
    //   294: aload #12
    //   296: getfield cpo : D
    //   299: dconst_0
    //   300: dcmpl
    //   301: ifle -> 315
    //   304: aload #15
    //   306: aload #12
    //   308: invokevirtual add : (Ljava/lang/Object;)Z
    //   311: pop
    //   312: goto -> 272
    //   315: aload #12
    //   317: getfield cpo : D
    //   320: dconst_0
    //   321: dcmpg
    //   322: ifge -> 272
    //   325: aload #11
    //   327: aload #12
    //   329: invokevirtual add : (Ljava/lang/Object;)Z
    //   332: pop
    //   333: goto -> 272
    //   336: aload #11
    //   338: invokevirtual size : ()I
    //   341: ifeq -> 1561
    //   344: aload_0
    //   345: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   348: aload_2
    //   349: invokevirtual getWidth : ()I
    //   352: invokestatic a : (Lcom/laiqian/print/printtype/g;I)Lcom/laiqian/print/b/g;
    //   355: astore #17
    //   357: iload #4
    //   359: iconst_3
    //   360: if_icmpeq -> 580
    //   363: iload #4
    //   365: iconst_2
    //   366: if_icmpne -> 372
    //   369: goto -> 580
    //   372: aload #16
    //   374: ifnull -> 493
    //   377: aload_0
    //   378: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   381: astore #10
    //   383: aload_1
    //   384: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   387: getfield aVN : J
    //   390: lconst_1
    //   391: lcmp
    //   392: ifne -> 401
    //   395: iconst_1
    //   396: istore #8
    //   398: goto -> 404
    //   401: iconst_0
    //   402: istore #8
    //   404: aload #17
    //   406: ldc_w '%s %s'
    //   409: iconst_2
    //   410: anewarray java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: aload #10
    //   417: iload #8
    //   419: invokevirtual fU : (Z)Ljava/lang/String;
    //   422: aastore
    //   423: dup
    //   424: iconst_1
    //   425: aload_1
    //   426: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   429: getfield coJ : Ljava/lang/String;
    //   432: aastore
    //   433: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   436: invokevirtual lk : (Ljava/lang/String;)V
    //   439: aload #17
    //   441: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   444: astore #10
    //   446: new java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial <init> : ()V
    //   453: astore #12
    //   455: aload #12
    //   457: aload_1
    //   458: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   461: getfield coJ : Ljava/lang/String;
    //   464: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload #12
    //   470: ldc ''
    //   472: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload #10
    //   478: ldc_w 'number'
    //   481: aload #12
    //   483: invokevirtual toString : ()Ljava/lang/String;
    //   486: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   489: pop
    //   490: goto -> 797
    //   493: aload_1
    //   494: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   497: getfield coT : Ljava/lang/String;
    //   500: invokestatic isNull : (Ljava/lang/String;)Z
    //   503: ifne -> 797
    //   506: aload #17
    //   508: ldc_w '%s-%s'
    //   511: iconst_2
    //   512: anewarray java/lang/Object
    //   515: dup
    //   516: iconst_0
    //   517: ldc 'Phone Order'
    //   519: aastore
    //   520: dup
    //   521: iconst_1
    //   522: aload_0
    //   523: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   526: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   529: ldc_w 2131628755
    //   532: invokevirtual getString : (I)Ljava/lang/String;
    //   535: aastore
    //   536: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   539: iconst_1
    //   540: iconst_1
    //   541: invokevirtual f : (Ljava/lang/String;II)V
    //   544: aload #17
    //   546: ldc_w '%s : %s'
    //   549: iconst_2
    //   550: anewarray java/lang/Object
    //   553: dup
    //   554: iconst_0
    //   555: ldc_w 'Order'
    //   558: aastore
    //   559: dup
    //   560: iconst_1
    //   561: aload_1
    //   562: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   565: getfield coT : Ljava/lang/String;
    //   568: aastore
    //   569: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   572: iconst_1
    //   573: iconst_1
    //   574: invokevirtual f : (Ljava/lang/String;II)V
    //   577: goto -> 797
    //   580: aload #17
    //   582: ldc_w '%s %s-%s'
    //   585: iconst_3
    //   586: anewarray java/lang/Object
    //   589: dup
    //   590: iconst_0
    //   591: aload_0
    //   592: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   595: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   598: ldc_w 2131628305
    //   601: invokevirtual getString : (I)Ljava/lang/String;
    //   604: aastore
    //   605: dup
    //   606: iconst_1
    //   607: aload #9
    //   609: getfield bZc : Ljava/lang/String;
    //   612: aastore
    //   613: dup
    //   614: iconst_2
    //   615: aload #9
    //   617: getfield bTe : Ljava/lang/String;
    //   620: aastore
    //   621: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   624: invokevirtual lk : (Ljava/lang/String;)V
    //   627: ldc ''
    //   629: astore #10
    //   631: aload_1
    //   632: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   635: getfield coM : I
    //   638: ifeq -> 709
    //   641: new java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial <init> : ()V
    //   648: astore #10
    //   650: aload #10
    //   652: aload_0
    //   653: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   656: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   659: ldc_w 2131626009
    //   662: invokevirtual getString : (I)Ljava/lang/String;
    //   665: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload #10
    //   671: aload_1
    //   672: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   675: getfield coM : I
    //   678: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: aload #10
    //   684: invokevirtual toString : ()Ljava/lang/String;
    //   687: astore #10
    //   689: aload #17
    //   691: ldc_w '%s'
    //   694: iconst_1
    //   695: anewarray java/lang/Object
    //   698: dup
    //   699: iconst_0
    //   700: aload #10
    //   702: aastore
    //   703: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   706: invokevirtual lk : (Ljava/lang/String;)V
    //   709: aload_1
    //   710: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   713: new java/util/Date
    //   716: dup
    //   717: invokespecial <init> : ()V
    //   720: putfield coE : Ljava/util/Date;
    //   723: aload #17
    //   725: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   728: astore #12
    //   730: aload #9
    //   732: getfield bZc : Ljava/lang/String;
    //   735: astore #13
    //   737: new java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial <init> : ()V
    //   744: astore #18
    //   746: aload #18
    //   748: aload #9
    //   750: getfield bTe : Ljava/lang/String;
    //   753: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload #18
    //   759: aload #10
    //   761: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: aload #12
    //   767: ldc_w 'number'
    //   770: ldc_w '%s-%s'
    //   773: iconst_2
    //   774: anewarray java/lang/Object
    //   777: dup
    //   778: iconst_0
    //   779: aload #13
    //   781: aastore
    //   782: dup
    //   783: iconst_1
    //   784: aload #18
    //   786: invokevirtual toString : ()Ljava/lang/String;
    //   789: aastore
    //   790: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   793: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   796: pop
    //   797: aload #17
    //   799: aload_0
    //   800: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   803: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   806: ldc_w 2131626775
    //   809: invokevirtual getString : (I)Ljava/lang/String;
    //   812: invokevirtual lk : (Ljava/lang/String;)V
    //   815: iload #4
    //   817: iconst_3
    //   818: if_icmpeq -> 923
    //   821: iload #4
    //   823: iconst_2
    //   824: if_icmpne -> 830
    //   827: goto -> 923
    //   830: aload_0
    //   831: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   834: aload #17
    //   836: aload_1
    //   837: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   840: getfield coE : Ljava/util/Date;
    //   843: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/util/Date;)Z
    //   846: pop
    //   847: aload_1
    //   848: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   851: getfield coN : Ljava/lang/String;
    //   854: invokestatic isNull : (Ljava/lang/String;)Z
    //   857: ifne -> 962
    //   860: aload #17
    //   862: bipush #45
    //   864: invokevirtual l : (C)V
    //   867: new java/lang/StringBuilder
    //   870: dup
    //   871: invokespecial <init> : ()V
    //   874: astore #10
    //   876: aload #10
    //   878: aload_0
    //   879: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   882: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   885: ldc_w 2131628790
    //   888: invokevirtual getString : (I)Ljava/lang/String;
    //   891: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: aload #10
    //   897: aload_1
    //   898: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   901: getfield coN : Ljava/lang/String;
    //   904: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload #17
    //   910: aload #10
    //   912: invokevirtual toString : ()Ljava/lang/String;
    //   915: iconst_1
    //   916: iconst_0
    //   917: invokevirtual f : (Ljava/lang/String;II)V
    //   920: goto -> 962
    //   923: aload_0
    //   924: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   927: aload #17
    //   929: aload_1
    //   930: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   933: getfield coE : Ljava/util/Date;
    //   936: aload_1
    //   937: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   940: getfield ceV : Ljava/lang/String;
    //   943: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/a;Ljava/util/Date;Ljava/lang/String;)Z
    //   946: pop
    //   947: aload_0
    //   948: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   951: aload #17
    //   953: aload #9
    //   955: getfield bZd : Ljava/lang/String;
    //   958: invokestatic d : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   961: pop
    //   962: aload #17
    //   964: bipush #45
    //   966: invokevirtual l : (C)V
    //   969: aload #17
    //   971: aload_0
    //   972: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   975: aload_2
    //   976: invokevirtual aiG : ()I
    //   979: invokestatic b : (Lcom/laiqian/print/printtype/g;I)I
    //   982: invokevirtual setSize : (I)V
    //   985: new java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial <init> : ()V
    //   992: astore #18
    //   994: aload_3
    //   995: invokevirtual aep : ()Ljava/util/List;
    //   998: astore #12
    //   1000: aload #11
    //   1002: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1005: astore #11
    //   1007: iconst_0
    //   1008: istore #5
    //   1010: aload #11
    //   1012: invokeinterface hasNext : ()Z
    //   1017: ifeq -> 1496
    //   1020: aload #11
    //   1022: invokeinterface next : ()Ljava/lang/Object;
    //   1027: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   1030: astore #19
    //   1032: aload #12
    //   1034: aload #19
    //   1036: getfield cpq : J
    //   1039: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1042: invokeinterface contains : (Ljava/lang/Object;)Z
    //   1047: ifne -> 1493
    //   1050: iload #5
    //   1052: ifne -> 1069
    //   1055: aload #18
    //   1057: aload #19
    //   1059: getfield name : Ljava/lang/String;
    //   1062: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: pop
    //   1066: goto -> 1089
    //   1069: aload #18
    //   1071: ldc_w '/'
    //   1074: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: pop
    //   1078: aload #18
    //   1080: aload #19
    //   1082: getfield name : Ljava/lang/String;
    //   1085: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: pop
    //   1089: aload #19
    //   1091: getfield name : Ljava/lang/String;
    //   1094: astore #13
    //   1096: aload_1
    //   1097: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1100: getfield aVN : J
    //   1103: lconst_1
    //   1104: lcmp
    //   1105: ifne -> 1114
    //   1108: iconst_1
    //   1109: istore #5
    //   1111: goto -> 1117
    //   1114: iconst_0
    //   1115: istore #5
    //   1117: iload #5
    //   1119: ifne -> 1136
    //   1122: aload #19
    //   1124: getfield aTZ : Z
    //   1127: ifeq -> 1136
    //   1130: iconst_1
    //   1131: istore #5
    //   1133: goto -> 1139
    //   1136: iconst_0
    //   1137: istore #5
    //   1139: aload #13
    //   1141: astore #10
    //   1143: iload #5
    //   1145: ifeq -> 1297
    //   1148: aload_0
    //   1149: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1152: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1155: ldc_w 2131626345
    //   1158: invokevirtual getString : (I)Ljava/lang/String;
    //   1161: astore #10
    //   1163: aload #13
    //   1165: ldc_w '|-'
    //   1168: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1171: iflt -> 1272
    //   1174: aload #13
    //   1176: ldc_w '|-'
    //   1179: ldc ''
    //   1181: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1184: astore #13
    //   1186: new java/lang/StringBuilder
    //   1189: dup
    //   1190: invokespecial <init> : ()V
    //   1193: astore #20
    //   1195: aload #20
    //   1197: ldc_w '['
    //   1200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: pop
    //   1204: aload #20
    //   1206: aload #10
    //   1208: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: pop
    //   1212: aload #20
    //   1214: ldc_w ']'
    //   1217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: pop
    //   1221: aload #20
    //   1223: aload #13
    //   1225: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: pop
    //   1229: aload #20
    //   1231: invokevirtual toString : ()Ljava/lang/String;
    //   1234: astore #10
    //   1236: new java/lang/StringBuilder
    //   1239: dup
    //   1240: invokespecial <init> : ()V
    //   1243: astore #13
    //   1245: aload #13
    //   1247: ldc_w '|-'
    //   1250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: aload #13
    //   1256: aload #10
    //   1258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload #13
    //   1264: invokevirtual toString : ()Ljava/lang/String;
    //   1267: astore #10
    //   1269: goto -> 1297
    //   1272: ldc_w '[%s]%s'
    //   1275: iconst_2
    //   1276: anewarray java/lang/Object
    //   1279: dup
    //   1280: iconst_0
    //   1281: aload #10
    //   1283: aastore
    //   1284: dup
    //   1285: iconst_1
    //   1286: aload #13
    //   1288: aastore
    //   1289: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1292: astore #10
    //   1294: goto -> 1297
    //   1297: aload_2
    //   1298: invokevirtual aiD : ()Z
    //   1301: ifeq -> 1379
    //   1304: aload #17
    //   1306: iconst_3
    //   1307: newarray int
    //   1309: dup
    //   1310: iconst_0
    //   1311: iconst_1
    //   1312: iastore
    //   1313: dup
    //   1314: iconst_1
    //   1315: iconst_1
    //   1316: iastore
    //   1317: dup
    //   1318: iconst_2
    //   1319: iconst_1
    //   1320: iastore
    //   1321: invokevirtual n : ([I)V
    //   1324: aload #17
    //   1326: iconst_3
    //   1327: anewarray java/lang/String
    //   1330: dup
    //   1331: iconst_0
    //   1332: aload #10
    //   1334: aastore
    //   1335: dup
    //   1336: iconst_1
    //   1337: aload #19
    //   1339: getfield cpo : D
    //   1342: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1345: iconst_0
    //   1346: iconst_0
    //   1347: getstatic com/laiqian/crash/model/CrashApplication.aIQ : I
    //   1350: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   1353: aastore
    //   1354: dup
    //   1355: iconst_2
    //   1356: aload #19
    //   1358: getfield cpn : D
    //   1361: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1364: iconst_1
    //   1365: iconst_0
    //   1366: getstatic com/laiqian/crash/model/CrashApplication.aIQ : I
    //   1369: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   1372: aastore
    //   1373: invokevirtual x : ([Ljava/lang/String;)V
    //   1376: goto -> 1412
    //   1379: aload #17
    //   1381: iconst_2
    //   1382: anewarray java/lang/String
    //   1385: dup
    //   1386: iconst_0
    //   1387: aload #10
    //   1389: aastore
    //   1390: dup
    //   1391: iconst_1
    //   1392: aload #19
    //   1394: getfield cpo : D
    //   1397: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1400: iconst_0
    //   1401: iconst_0
    //   1402: getstatic com/laiqian/crash/model/CrashApplication.aIQ : I
    //   1405: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   1408: aastore
    //   1409: invokevirtual x : ([Ljava/lang/String;)V
    //   1412: aload #19
    //   1414: getfield cpm : Ljava/lang/String;
    //   1417: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1420: ifne -> 1487
    //   1423: aload #19
    //   1425: getfield cpx : J
    //   1428: ldc2_w 3
    //   1431: lcmp
    //   1432: ifne -> 1477
    //   1435: new java/lang/StringBuilder
    //   1438: dup
    //   1439: invokespecial <init> : ()V
    //   1442: astore #10
    //   1444: aload #10
    //   1446: ldc_w '|-'
    //   1449: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: pop
    //   1453: aload #10
    //   1455: aload #19
    //   1457: getfield cpm : Ljava/lang/String;
    //   1460: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: pop
    //   1464: aload #17
    //   1466: aload #10
    //   1468: invokevirtual toString : ()Ljava/lang/String;
    //   1471: invokevirtual ll : (Ljava/lang/String;)V
    //   1474: goto -> 1487
    //   1477: aload #17
    //   1479: aload #19
    //   1481: getfield cpm : Ljava/lang/String;
    //   1484: invokevirtual ll : (Ljava/lang/String;)V
    //   1487: iconst_1
    //   1488: istore #5
    //   1490: goto -> 1493
    //   1493: goto -> 1010
    //   1496: iload #5
    //   1498: ifne -> 1503
    //   1501: aconst_null
    //   1502: areturn
    //   1503: aload_0
    //   1504: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1507: aload #17
    //   1509: aload_2
    //   1510: invokevirtual air : ()I
    //   1513: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;I)Z
    //   1516: pop
    //   1517: aload #17
    //   1519: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1522: aload_3
    //   1523: invokevirtual getCopies : ()I
    //   1526: invokevirtual ih : (I)Lcom/laiqian/print/model/PrintContent$a;
    //   1529: pop
    //   1530: aload #17
    //   1532: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1535: ldc_w 'name'
    //   1538: aload #18
    //   1540: invokevirtual toString : ()Ljava/lang/String;
    //   1543: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   1546: pop
    //   1547: aload #14
    //   1549: aload #17
    //   1551: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1554: invokevirtual add : (Ljava/lang/Object;)Z
    //   1557: pop
    //   1558: goto -> 1561
    //   1561: aload #15
    //   1563: invokevirtual size : ()I
    //   1566: ifeq -> 2891
    //   1569: aload_0
    //   1570: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1573: aload_2
    //   1574: invokevirtual getWidth : ()I
    //   1577: invokestatic a : (Lcom/laiqian/print/printtype/g;I)Lcom/laiqian/print/b/g;
    //   1580: astore #12
    //   1582: iload #4
    //   1584: iconst_3
    //   1585: if_icmpeq -> 1805
    //   1588: iload #4
    //   1590: iconst_2
    //   1591: if_icmpne -> 1597
    //   1594: goto -> 1805
    //   1597: aload #16
    //   1599: ifnull -> 1718
    //   1602: aload_0
    //   1603: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1606: astore #10
    //   1608: aload_1
    //   1609: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1612: getfield aVN : J
    //   1615: lconst_1
    //   1616: lcmp
    //   1617: ifne -> 1626
    //   1620: iconst_1
    //   1621: istore #8
    //   1623: goto -> 1629
    //   1626: iconst_0
    //   1627: istore #8
    //   1629: aload #12
    //   1631: ldc_w '%s %s'
    //   1634: iconst_2
    //   1635: anewarray java/lang/Object
    //   1638: dup
    //   1639: iconst_0
    //   1640: aload #10
    //   1642: iload #8
    //   1644: invokevirtual fU : (Z)Ljava/lang/String;
    //   1647: aastore
    //   1648: dup
    //   1649: iconst_1
    //   1650: aload_1
    //   1651: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1654: getfield coJ : Ljava/lang/String;
    //   1657: aastore
    //   1658: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1661: invokevirtual lk : (Ljava/lang/String;)V
    //   1664: aload #12
    //   1666: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1669: astore #10
    //   1671: new java/lang/StringBuilder
    //   1674: dup
    //   1675: invokespecial <init> : ()V
    //   1678: astore #11
    //   1680: aload #11
    //   1682: aload_1
    //   1683: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1686: getfield coJ : Ljava/lang/String;
    //   1689: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: pop
    //   1693: aload #11
    //   1695: ldc ''
    //   1697: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1700: pop
    //   1701: aload #10
    //   1703: ldc_w 'number'
    //   1706: aload #11
    //   1708: invokevirtual toString : ()Ljava/lang/String;
    //   1711: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   1714: pop
    //   1715: goto -> 1802
    //   1718: aload_1
    //   1719: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1722: getfield coT : Ljava/lang/String;
    //   1725: invokestatic isNull : (Ljava/lang/String;)Z
    //   1728: ifne -> 1802
    //   1731: aload #12
    //   1733: ldc_w '%s-%s'
    //   1736: iconst_2
    //   1737: anewarray java/lang/Object
    //   1740: dup
    //   1741: iconst_0
    //   1742: ldc 'Phone Order'
    //   1744: aastore
    //   1745: dup
    //   1746: iconst_1
    //   1747: aload_0
    //   1748: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1751: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1754: ldc_w 2131628755
    //   1757: invokevirtual getString : (I)Ljava/lang/String;
    //   1760: aastore
    //   1761: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1764: iconst_1
    //   1765: iconst_1
    //   1766: invokevirtual f : (Ljava/lang/String;II)V
    //   1769: aload #12
    //   1771: ldc_w '%s : %s'
    //   1774: iconst_2
    //   1775: anewarray java/lang/Object
    //   1778: dup
    //   1779: iconst_0
    //   1780: ldc_w 'Order'
    //   1783: aastore
    //   1784: dup
    //   1785: iconst_1
    //   1786: aload_1
    //   1787: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1790: getfield coT : Ljava/lang/String;
    //   1793: aastore
    //   1794: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1797: iconst_1
    //   1798: iconst_1
    //   1799: invokevirtual f : (Ljava/lang/String;II)V
    //   1802: goto -> 2019
    //   1805: aload_0
    //   1806: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1809: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1812: ldc_w 2131628305
    //   1815: invokevirtual getString : (I)Ljava/lang/String;
    //   1818: astore #10
    //   1820: aload #9
    //   1822: astore #11
    //   1824: aload #12
    //   1826: ldc_w '%s %s-%s'
    //   1829: iconst_3
    //   1830: anewarray java/lang/Object
    //   1833: dup
    //   1834: iconst_0
    //   1835: aload #10
    //   1837: aastore
    //   1838: dup
    //   1839: iconst_1
    //   1840: aload #11
    //   1842: getfield bZc : Ljava/lang/String;
    //   1845: aastore
    //   1846: dup
    //   1847: iconst_2
    //   1848: aload #11
    //   1850: getfield bTe : Ljava/lang/String;
    //   1853: aastore
    //   1854: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1857: invokevirtual lk : (Ljava/lang/String;)V
    //   1860: ldc ''
    //   1862: astore #10
    //   1864: aload_1
    //   1865: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1868: getfield coM : I
    //   1871: ifeq -> 1945
    //   1874: new java/lang/StringBuilder
    //   1877: dup
    //   1878: invokespecial <init> : ()V
    //   1881: astore #10
    //   1883: aload #10
    //   1885: aload_0
    //   1886: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1889: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1892: ldc_w 2131626009
    //   1895: invokevirtual getString : (I)Ljava/lang/String;
    //   1898: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: pop
    //   1902: aload #10
    //   1904: aload_1
    //   1905: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1908: getfield coM : I
    //   1911: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1914: pop
    //   1915: aload #10
    //   1917: invokevirtual toString : ()Ljava/lang/String;
    //   1920: astore #10
    //   1922: aload #12
    //   1924: ldc_w '%s'
    //   1927: iconst_1
    //   1928: anewarray java/lang/Object
    //   1931: dup
    //   1932: iconst_0
    //   1933: aload #10
    //   1935: aastore
    //   1936: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1939: invokevirtual lk : (Ljava/lang/String;)V
    //   1942: goto -> 1945
    //   1945: aload #12
    //   1947: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1950: astore #13
    //   1952: aload #11
    //   1954: getfield bZc : Ljava/lang/String;
    //   1957: astore #16
    //   1959: new java/lang/StringBuilder
    //   1962: dup
    //   1963: invokespecial <init> : ()V
    //   1966: astore #17
    //   1968: aload #17
    //   1970: aload #11
    //   1972: getfield bTe : Ljava/lang/String;
    //   1975: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1978: pop
    //   1979: aload #17
    //   1981: aload #10
    //   1983: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1986: pop
    //   1987: aload #13
    //   1989: ldc_w 'number'
    //   1992: ldc_w '%s-%s'
    //   1995: iconst_2
    //   1996: anewarray java/lang/Object
    //   1999: dup
    //   2000: iconst_0
    //   2001: aload #16
    //   2003: aastore
    //   2004: dup
    //   2005: iconst_1
    //   2006: aload #17
    //   2008: invokevirtual toString : ()Ljava/lang/String;
    //   2011: aastore
    //   2012: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2015: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   2018: pop
    //   2019: aload #12
    //   2021: aload_0
    //   2022: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   2025: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   2028: ldc_w 2131626782
    //   2031: invokevirtual getString : (I)Ljava/lang/String;
    //   2034: invokevirtual lk : (Ljava/lang/String;)V
    //   2037: iload #4
    //   2039: iconst_3
    //   2040: if_icmpeq -> 2145
    //   2043: iload #4
    //   2045: iconst_2
    //   2046: if_icmpne -> 2052
    //   2049: goto -> 2145
    //   2052: aload_0
    //   2053: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   2056: aload #12
    //   2058: aload_1
    //   2059: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   2062: getfield coE : Ljava/util/Date;
    //   2065: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/util/Date;)Z
    //   2068: pop
    //   2069: aload_1
    //   2070: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   2073: getfield coN : Ljava/lang/String;
    //   2076: invokestatic isNull : (Ljava/lang/String;)Z
    //   2079: ifne -> 2184
    //   2082: aload #12
    //   2084: bipush #45
    //   2086: invokevirtual l : (C)V
    //   2089: new java/lang/StringBuilder
    //   2092: dup
    //   2093: invokespecial <init> : ()V
    //   2096: astore #9
    //   2098: aload #9
    //   2100: aload_0
    //   2101: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   2104: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   2107: ldc_w 2131628790
    //   2110: invokevirtual getString : (I)Ljava/lang/String;
    //   2113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2116: pop
    //   2117: aload #9
    //   2119: aload_1
    //   2120: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   2123: getfield coN : Ljava/lang/String;
    //   2126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: pop
    //   2130: aload #12
    //   2132: aload #9
    //   2134: invokevirtual toString : ()Ljava/lang/String;
    //   2137: iconst_1
    //   2138: iconst_0
    //   2139: invokevirtual f : (Ljava/lang/String;II)V
    //   2142: goto -> 2184
    //   2145: aload_0
    //   2146: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   2149: aload #12
    //   2151: aload_1
    //   2152: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   2155: getfield coE : Ljava/util/Date;
    //   2158: aload_1
    //   2159: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   2162: getfield ceV : Ljava/lang/String;
    //   2165: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/a;Ljava/util/Date;Ljava/lang/String;)Z
    //   2168: pop
    //   2169: aload_0
    //   2170: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   2173: aload #12
    //   2175: aload #9
    //   2177: getfield bZd : Ljava/lang/String;
    //   2180: invokestatic d : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   2183: pop
    //   2184: aload #12
    //   2186: bipush #45
    //   2188: invokevirtual l : (C)V
    //   2191: new com/laiqian/print/b/b
    //   2194: dup
    //   2195: aload #12
    //   2197: invokespecial <init> : (Lcom/laiqian/print/b/a;)V
    //   2200: astore #10
    //   2202: aload #10
    //   2204: iconst_2
    //   2205: newarray int
    //   2207: dup
    //   2208: iconst_0
    //   2209: iconst_0
    //   2210: iastore
    //   2211: dup
    //   2212: iconst_1
    //   2213: bipush #32
    //   2215: iastore
    //   2216: invokevirtual n : ([I)V
    //   2219: aload #10
    //   2221: iconst_2
    //   2222: newarray int
    //   2224: dup
    //   2225: iconst_0
    //   2226: iconst_2
    //   2227: iastore
    //   2228: dup
    //   2229: iconst_1
    //   2230: iconst_0
    //   2231: iastore
    //   2232: invokevirtual o : ([I)V
    //   2235: aload #10
    //   2237: iconst_3
    //   2238: newarray int
    //   2240: dup
    //   2241: iconst_0
    //   2242: iconst_0
    //   2243: iastore
    //   2244: dup
    //   2245: iconst_1
    //   2246: bipush #24
    //   2248: iastore
    //   2249: dup
    //   2250: iconst_2
    //   2251: bipush #32
    //   2253: iastore
    //   2254: invokevirtual n : ([I)V
    //   2257: aload #10
    //   2259: iconst_3
    //   2260: newarray int
    //   2262: dup
    //   2263: iconst_0
    //   2264: iconst_2
    //   2265: iastore
    //   2266: dup
    //   2267: iconst_1
    //   2268: iconst_0
    //   2269: iastore
    //   2270: dup
    //   2271: iconst_2
    //   2272: iconst_0
    //   2273: iastore
    //   2274: invokevirtual o : ([I)V
    //   2277: aload #10
    //   2279: aload_0
    //   2280: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   2283: aload_2
    //   2284: invokevirtual aiG : ()I
    //   2287: invokestatic b : (Lcom/laiqian/print/printtype/g;I)I
    //   2290: invokevirtual setSize : (I)V
    //   2293: aload #10
    //   2295: aload_0
    //   2296: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   2299: aload_2
    //   2300: invokevirtual aiG : ()I
    //   2303: invokestatic b : (Lcom/laiqian/print/printtype/g;I)I
    //   2306: invokevirtual setSize : (I)V
    //   2309: new java/lang/StringBuilder
    //   2312: dup
    //   2313: invokespecial <init> : ()V
    //   2316: astore #11
    //   2318: aload_3
    //   2319: invokevirtual aep : ()Ljava/util/List;
    //   2322: astore #13
    //   2324: aload #15
    //   2326: invokevirtual iterator : ()Ljava/util/Iterator;
    //   2329: astore #15
    //   2331: iconst_0
    //   2332: istore #4
    //   2334: aload #15
    //   2336: invokeinterface hasNext : ()Z
    //   2341: ifeq -> 2829
    //   2344: aload #15
    //   2346: invokeinterface next : ()Ljava/lang/Object;
    //   2351: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   2354: astore #16
    //   2356: aload #13
    //   2358: ifnull -> 2385
    //   2361: aload #13
    //   2363: aload #16
    //   2365: getfield cpq : J
    //   2368: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2371: invokeinterface contains : (Ljava/lang/Object;)Z
    //   2376: ifne -> 2382
    //   2379: goto -> 2385
    //   2382: goto -> 2334
    //   2385: iload #4
    //   2387: ifne -> 2404
    //   2390: aload #11
    //   2392: aload #16
    //   2394: getfield name : Ljava/lang/String;
    //   2397: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2400: pop
    //   2401: goto -> 2424
    //   2404: aload #11
    //   2406: ldc_w '/'
    //   2409: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2412: pop
    //   2413: aload #11
    //   2415: aload #16
    //   2417: getfield name : Ljava/lang/String;
    //   2420: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2423: pop
    //   2424: aload #16
    //   2426: getfield name : Ljava/lang/String;
    //   2429: astore #9
    //   2431: aload_1
    //   2432: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   2435: getfield aVN : J
    //   2438: lconst_1
    //   2439: lcmp
    //   2440: ifne -> 2449
    //   2443: iconst_1
    //   2444: istore #4
    //   2446: goto -> 2452
    //   2449: iconst_0
    //   2450: istore #4
    //   2452: iload #4
    //   2454: ifne -> 2471
    //   2457: aload #16
    //   2459: getfield aTZ : Z
    //   2462: ifeq -> 2471
    //   2465: iconst_1
    //   2466: istore #4
    //   2468: goto -> 2474
    //   2471: iconst_0
    //   2472: istore #4
    //   2474: iload #4
    //   2476: ifeq -> 2628
    //   2479: aload_0
    //   2480: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   2483: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   2486: ldc_w 2131626345
    //   2489: invokevirtual getString : (I)Ljava/lang/String;
    //   2492: astore #17
    //   2494: aload #9
    //   2496: ldc_w '|-'
    //   2499: invokevirtual indexOf : (Ljava/lang/String;)I
    //   2502: iflt -> 2603
    //   2505: aload #9
    //   2507: ldc_w '|-'
    //   2510: ldc ''
    //   2512: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   2515: astore #9
    //   2517: new java/lang/StringBuilder
    //   2520: dup
    //   2521: invokespecial <init> : ()V
    //   2524: astore #18
    //   2526: aload #18
    //   2528: ldc_w '['
    //   2531: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2534: pop
    //   2535: aload #18
    //   2537: aload #17
    //   2539: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2542: pop
    //   2543: aload #18
    //   2545: ldc_w ']'
    //   2548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2551: pop
    //   2552: aload #18
    //   2554: aload #9
    //   2556: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2559: pop
    //   2560: aload #18
    //   2562: invokevirtual toString : ()Ljava/lang/String;
    //   2565: astore #9
    //   2567: new java/lang/StringBuilder
    //   2570: dup
    //   2571: invokespecial <init> : ()V
    //   2574: astore #17
    //   2576: aload #17
    //   2578: ldc_w '|-'
    //   2581: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2584: pop
    //   2585: aload #17
    //   2587: aload #9
    //   2589: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2592: pop
    //   2593: aload #17
    //   2595: invokevirtual toString : ()Ljava/lang/String;
    //   2598: astore #9
    //   2600: goto -> 2628
    //   2603: ldc_w '[%s]%s'
    //   2606: iconst_2
    //   2607: anewarray java/lang/Object
    //   2610: dup
    //   2611: iconst_0
    //   2612: aload #17
    //   2614: aastore
    //   2615: dup
    //   2616: iconst_1
    //   2617: aload #9
    //   2619: aastore
    //   2620: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2623: astore #9
    //   2625: goto -> 2628
    //   2628: aload_2
    //   2629: invokevirtual aiD : ()Z
    //   2632: ifeq -> 2712
    //   2635: aload #10
    //   2637: iconst_3
    //   2638: newarray int
    //   2640: dup
    //   2641: iconst_0
    //   2642: iconst_0
    //   2643: iastore
    //   2644: dup
    //   2645: iconst_1
    //   2646: bipush #16
    //   2648: iastore
    //   2649: dup
    //   2650: iconst_2
    //   2651: bipush #32
    //   2653: iastore
    //   2654: invokevirtual n : ([I)V
    //   2657: aload #10
    //   2659: iconst_3
    //   2660: anewarray java/lang/String
    //   2663: dup
    //   2664: iconst_0
    //   2665: aload #9
    //   2667: aastore
    //   2668: dup
    //   2669: iconst_1
    //   2670: aload #16
    //   2672: getfield cpo : D
    //   2675: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2678: iconst_0
    //   2679: iconst_0
    //   2680: getstatic com/laiqian/crash/model/CrashApplication.aIQ : I
    //   2683: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   2686: aastore
    //   2687: dup
    //   2688: iconst_2
    //   2689: aload #16
    //   2691: getfield cpn : D
    //   2694: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2697: iconst_1
    //   2698: iconst_0
    //   2699: getstatic com/laiqian/crash/model/CrashApplication.aIQ : I
    //   2702: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   2705: aastore
    //   2706: invokevirtual x : ([Ljava/lang/String;)V
    //   2709: goto -> 2745
    //   2712: aload #10
    //   2714: iconst_2
    //   2715: anewarray java/lang/String
    //   2718: dup
    //   2719: iconst_0
    //   2720: aload #9
    //   2722: aastore
    //   2723: dup
    //   2724: iconst_1
    //   2725: aload #16
    //   2727: getfield cpo : D
    //   2730: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2733: iconst_0
    //   2734: iconst_0
    //   2735: getstatic com/laiqian/crash/model/CrashApplication.aIQ : I
    //   2738: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   2741: aastore
    //   2742: invokevirtual x : ([Ljava/lang/String;)V
    //   2745: aload #16
    //   2747: getfield cpm : Ljava/lang/String;
    //   2750: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   2753: ifne -> 2823
    //   2756: aload #16
    //   2758: getfield cpx : J
    //   2761: ldc2_w 3
    //   2764: lcmp
    //   2765: ifne -> 2810
    //   2768: new java/lang/StringBuilder
    //   2771: dup
    //   2772: invokespecial <init> : ()V
    //   2775: astore #9
    //   2777: aload #9
    //   2779: ldc_w '|-'
    //   2782: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2785: pop
    //   2786: aload #9
    //   2788: aload #16
    //   2790: getfield cpm : Ljava/lang/String;
    //   2793: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2796: pop
    //   2797: aload #10
    //   2799: aload #9
    //   2801: invokevirtual toString : ()Ljava/lang/String;
    //   2804: invokevirtual ll : (Ljava/lang/String;)V
    //   2807: goto -> 2823
    //   2810: aload #10
    //   2812: aload #16
    //   2814: getfield cpm : Ljava/lang/String;
    //   2817: invokevirtual ll : (Ljava/lang/String;)V
    //   2820: goto -> 2823
    //   2823: iconst_1
    //   2824: istore #4
    //   2826: goto -> 2334
    //   2829: iload #4
    //   2831: ifne -> 2836
    //   2834: aconst_null
    //   2835: areturn
    //   2836: aload_0
    //   2837: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   2840: aload #12
    //   2842: aload_2
    //   2843: invokevirtual air : ()I
    //   2846: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;I)Z
    //   2849: pop
    //   2850: aload #12
    //   2852: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   2855: aload_3
    //   2856: invokevirtual getCopies : ()I
    //   2859: invokevirtual ih : (I)Lcom/laiqian/print/model/PrintContent$a;
    //   2862: pop
    //   2863: aload #12
    //   2865: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   2868: ldc_w 'name'
    //   2871: aload #11
    //   2873: invokevirtual toString : ()Ljava/lang/String;
    //   2876: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   2879: pop
    //   2880: aload #14
    //   2882: aload #12
    //   2884: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   2887: invokevirtual add : (Ljava/lang/Object;)Z
    //   2890: pop
    //   2891: aload #14
    //   2893: new com/laiqian/print/model/PrintContent$a
    //   2896: dup
    //   2897: invokespecial <init> : ()V
    //   2900: invokevirtual agg : ()Lcom/laiqian/print/model/PrintContent$a;
    //   2903: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   2906: invokevirtual add : (Ljava/lang/Object;)Z
    //   2909: pop
    //   2910: aload #14
    //   2912: areturn }
  
  private List<PrintContent> b(a parama, c paramc, j.c paramc1, boolean paramBoolean) { // Byte code:
    //   0: aload_1
    //   1: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   4: getfield bZF : I
    //   7: iconst_2
    //   8: if_icmpne -> 75
    //   11: new com/laiqian/opentable/b/q
    //   14: dup
    //   15: aload_0
    //   16: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   19: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   22: invokespecial <init> : (Landroid/content/Context;)V
    //   25: astore #9
    //   27: aload #9
    //   29: aload_1
    //   30: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   33: getfield coJ : Ljava/lang/String;
    //   36: invokestatic parseLong : (Ljava/lang/String;)J
    //   39: invokevirtual ck : (J)Lcom/laiqian/opentable/common/entity/TableEntity;
    //   42: astore #10
    //   44: aload #9
    //   46: invokevirtual close : ()V
    //   49: aload #10
    //   51: invokevirtual XY : ()J
    //   54: lstore #7
    //   56: aload_3
    //   57: invokevirtual aeq : ()Ljava/util/List;
    //   60: lload #7
    //   62: invokestatic valueOf : (J)Ljava/lang/Long;
    //   65: invokeinterface contains : (Ljava/lang/Object;)Z
    //   70: ifeq -> 75
    //   73: aconst_null
    //   74: areturn
    //   75: aload_2
    //   76: invokevirtual getOrder : ()I
    //   79: iconst_2
    //   80: if_icmpne -> 94
    //   83: aload_0
    //   84: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   87: aload_1
    //   88: getfield cpg : Ljava/util/ArrayList;
    //   91: invokestatic a : (Lcom/laiqian/print/printtype/g;Ljava/util/ArrayList;)V
    //   94: aload_1
    //   95: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   98: getfield coJ : Ljava/lang/String;
    //   101: astore #11
    //   103: aload_1
    //   104: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   107: getfield bZF : I
    //   110: istore #5
    //   112: new com/laiqian/opentable/common/b$a
    //   115: dup
    //   116: invokespecial <init> : ()V
    //   119: astore #10
    //   121: iload #5
    //   123: iconst_3
    //   124: if_icmpeq -> 137
    //   127: aload #10
    //   129: astore #9
    //   131: iload #5
    //   133: iconst_2
    //   134: if_icmpne -> 230
    //   137: aload #10
    //   139: astore #9
    //   141: aload #11
    //   143: ifnull -> 230
    //   146: aload_0
    //   147: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   150: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   153: astore #9
    //   155: new java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial <init> : ()V
    //   162: astore #10
    //   164: aload #10
    //   166: aload_1
    //   167: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   170: getfield aEI : J
    //   173: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload #10
    //   179: ldc ''
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #9
    //   187: aload #10
    //   189: invokevirtual toString : ()Ljava/lang/String;
    //   192: aload_1
    //   193: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   196: getfield coJ : Ljava/lang/String;
    //   199: invokestatic parseLong : (Ljava/lang/String;)J
    //   202: invokestatic valueOf : (J)Ljava/lang/Long;
    //   205: iconst_1
    //   206: aload_1
    //   207: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   210: getfield bZM : I
    //   213: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;ZI)Lcom/laiqian/opentable/common/b$a;
    //   216: astore #9
    //   218: aload_1
    //   219: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   222: aload #9
    //   224: getfield bfo : Ljava/lang/String;
    //   227: putfield ceV : Ljava/lang/String;
    //   230: new java/util/ArrayList
    //   233: dup
    //   234: invokespecial <init> : ()V
    //   237: astore #12
    //   239: aload_0
    //   240: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   243: aload_2
    //   244: invokevirtual getWidth : ()I
    //   247: invokestatic a : (Lcom/laiqian/print/printtype/g;I)Lcom/laiqian/print/b/g;
    //   250: astore #13
    //   252: iload #5
    //   254: iconst_3
    //   255: if_icmpeq -> 481
    //   258: iload #5
    //   260: iconst_2
    //   261: if_icmpne -> 267
    //   264: goto -> 481
    //   267: aload #11
    //   269: ifnull -> 388
    //   272: aload_0
    //   273: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   276: astore #9
    //   278: aload_1
    //   279: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   282: getfield aVN : J
    //   285: lconst_1
    //   286: lcmp
    //   287: ifne -> 296
    //   290: iconst_1
    //   291: istore #4
    //   293: goto -> 299
    //   296: iconst_0
    //   297: istore #4
    //   299: aload #13
    //   301: ldc_w '%s %s'
    //   304: iconst_2
    //   305: anewarray java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: aload #9
    //   312: iload #4
    //   314: invokevirtual fU : (Z)Ljava/lang/String;
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: aload_1
    //   321: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   324: getfield coJ : Ljava/lang/String;
    //   327: aastore
    //   328: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   331: invokevirtual lk : (Ljava/lang/String;)V
    //   334: aload #13
    //   336: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   339: astore #9
    //   341: new java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial <init> : ()V
    //   348: astore #10
    //   350: aload #10
    //   352: aload_1
    //   353: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   356: getfield coJ : Ljava/lang/String;
    //   359: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload #10
    //   365: ldc ''
    //   367: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload #9
    //   373: ldc_w 'number'
    //   376: aload #10
    //   378: invokevirtual toString : ()Ljava/lang/String;
    //   381: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   384: pop
    //   385: goto -> 388
    //   388: aload_0
    //   389: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   392: aload #13
    //   394: aload_1
    //   395: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   398: getfield coE : Ljava/util/Date;
    //   401: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/util/Date;)Z
    //   404: pop
    //   405: aload_1
    //   406: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   409: getfield coN : Ljava/lang/String;
    //   412: invokestatic isNull : (Ljava/lang/String;)Z
    //   415: ifne -> 478
    //   418: aload #13
    //   420: bipush #45
    //   422: invokevirtual l : (C)V
    //   425: new java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial <init> : ()V
    //   432: astore #9
    //   434: aload #9
    //   436: aload_0
    //   437: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   440: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   443: ldc_w 2131628790
    //   446: invokevirtual getString : (I)Ljava/lang/String;
    //   449: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload #9
    //   455: aload_1
    //   456: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   459: getfield coN : Ljava/lang/String;
    //   462: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload #13
    //   468: aload #9
    //   470: invokevirtual toString : ()Ljava/lang/String;
    //   473: iconst_1
    //   474: iconst_0
    //   475: invokevirtual f : (Ljava/lang/String;II)V
    //   478: goto -> 869
    //   481: aload #13
    //   483: ldc_w '%s %s-%s'
    //   486: iconst_3
    //   487: anewarray java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: aload_0
    //   493: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   496: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   499: ldc_w 2131628305
    //   502: invokevirtual getString : (I)Ljava/lang/String;
    //   505: aastore
    //   506: dup
    //   507: iconst_1
    //   508: aload #9
    //   510: getfield bZc : Ljava/lang/String;
    //   513: aastore
    //   514: dup
    //   515: iconst_2
    //   516: aload #9
    //   518: getfield bTe : Ljava/lang/String;
    //   521: aastore
    //   522: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   525: invokevirtual lk : (Ljava/lang/String;)V
    //   528: ldc ''
    //   530: astore #10
    //   532: aload_1
    //   533: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   536: getfield coM : I
    //   539: ifeq -> 610
    //   542: new java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial <init> : ()V
    //   549: astore #10
    //   551: aload #10
    //   553: aload_0
    //   554: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   557: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   560: ldc_w 2131626009
    //   563: invokevirtual getString : (I)Ljava/lang/String;
    //   566: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload #10
    //   572: aload_1
    //   573: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   576: getfield coM : I
    //   579: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload #10
    //   585: invokevirtual toString : ()Ljava/lang/String;
    //   588: astore #10
    //   590: aload #13
    //   592: ldc_w '%s'
    //   595: iconst_1
    //   596: anewarray java/lang/Object
    //   599: dup
    //   600: iconst_0
    //   601: aload #10
    //   603: aastore
    //   604: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   607: invokevirtual lk : (Ljava/lang/String;)V
    //   610: iload #5
    //   612: iconst_3
    //   613: if_icmpne -> 645
    //   616: aload_0
    //   617: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   620: aload_1
    //   621: invokevirtual a : (Lcom/laiqian/pos/model/orders/a;)Z
    //   624: ifeq -> 645
    //   627: aload #13
    //   629: aload_0
    //   630: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   633: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   636: ldc_w 2131626782
    //   639: invokevirtual getString : (I)Ljava/lang/String;
    //   642: invokevirtual lk : (Ljava/lang/String;)V
    //   645: aload_0
    //   646: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   649: aload_1
    //   650: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/pos/model/orders/a;)Z
    //   653: ifeq -> 674
    //   656: aload #13
    //   658: aload_0
    //   659: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   662: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   665: ldc_w 2131628775
    //   668: invokevirtual getString : (I)Ljava/lang/String;
    //   671: invokevirtual lk : (Ljava/lang/String;)V
    //   674: aload_1
    //   675: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   678: new java/util/Date
    //   681: dup
    //   682: invokespecial <init> : ()V
    //   685: putfield coE : Ljava/util/Date;
    //   688: aload_0
    //   689: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   692: aload #13
    //   694: aload_1
    //   695: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   698: getfield coE : Ljava/util/Date;
    //   701: aload_1
    //   702: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   705: getfield ceV : Ljava/lang/String;
    //   708: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/a;Ljava/util/Date;Ljava/lang/String;)Z
    //   711: pop
    //   712: aload_0
    //   713: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   716: astore #14
    //   718: aload_0
    //   719: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   722: aload_1
    //   723: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/pos/model/orders/a;)Z
    //   726: ifne -> 748
    //   729: iload #5
    //   731: iconst_3
    //   732: if_icmpne -> 738
    //   735: goto -> 748
    //   738: aload #9
    //   740: getfield bZd : Ljava/lang/String;
    //   743: astore #11
    //   745: goto -> 785
    //   748: new java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial <init> : ()V
    //   755: astore #11
    //   757: aload #11
    //   759: aload_1
    //   760: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   763: getfield bZM : I
    //   766: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload #11
    //   772: ldc ''
    //   774: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload #11
    //   780: invokevirtual toString : ()Ljava/lang/String;
    //   783: astore #11
    //   785: aload #14
    //   787: aload #13
    //   789: aload #11
    //   791: invokestatic d : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;Ljava/lang/String;)Z
    //   794: pop
    //   795: aload #13
    //   797: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   800: astore #11
    //   802: aload #9
    //   804: getfield bZc : Ljava/lang/String;
    //   807: astore #14
    //   809: new java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial <init> : ()V
    //   816: astore #15
    //   818: aload #15
    //   820: aload #9
    //   822: getfield bTe : Ljava/lang/String;
    //   825: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: pop
    //   829: aload #15
    //   831: aload #10
    //   833: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: aload #11
    //   839: ldc_w 'number'
    //   842: ldc_w '%s-%s'
    //   845: iconst_2
    //   846: anewarray java/lang/Object
    //   849: dup
    //   850: iconst_0
    //   851: aload #14
    //   853: aastore
    //   854: dup
    //   855: iconst_1
    //   856: aload #15
    //   858: invokevirtual toString : ()Ljava/lang/String;
    //   861: aastore
    //   862: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   865: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   868: pop
    //   869: aload #13
    //   871: bipush #45
    //   873: invokevirtual l : (C)V
    //   876: new com/laiqian/print/b/b
    //   879: dup
    //   880: aload #13
    //   882: invokespecial <init> : (Lcom/laiqian/print/b/a;)V
    //   885: astore #14
    //   887: aload #14
    //   889: iconst_2
    //   890: newarray int
    //   892: dup
    //   893: iconst_0
    //   894: iconst_0
    //   895: iastore
    //   896: dup
    //   897: iconst_1
    //   898: bipush #32
    //   900: iastore
    //   901: invokevirtual n : ([I)V
    //   904: aload #14
    //   906: iconst_2
    //   907: newarray int
    //   909: dup
    //   910: iconst_0
    //   911: iconst_2
    //   912: iastore
    //   913: dup
    //   914: iconst_1
    //   915: iconst_0
    //   916: iastore
    //   917: invokevirtual o : ([I)V
    //   920: aload #14
    //   922: iconst_3
    //   923: newarray int
    //   925: dup
    //   926: iconst_0
    //   927: iconst_0
    //   928: iastore
    //   929: dup
    //   930: iconst_1
    //   931: bipush #24
    //   933: iastore
    //   934: dup
    //   935: iconst_2
    //   936: bipush #32
    //   938: iastore
    //   939: invokevirtual n : ([I)V
    //   942: aload #14
    //   944: iconst_3
    //   945: newarray int
    //   947: dup
    //   948: iconst_0
    //   949: iconst_2
    //   950: iastore
    //   951: dup
    //   952: iconst_1
    //   953: iconst_0
    //   954: iastore
    //   955: dup
    //   956: iconst_2
    //   957: iconst_0
    //   958: iastore
    //   959: invokevirtual o : ([I)V
    //   962: aload #14
    //   964: aload_0
    //   965: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   968: aload_2
    //   969: invokevirtual aiG : ()I
    //   972: invokestatic b : (Lcom/laiqian/print/printtype/g;I)I
    //   975: invokevirtual setSize : (I)V
    //   978: new java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial <init> : ()V
    //   985: astore #15
    //   987: aload_3
    //   988: invokevirtual aep : ()Ljava/util/List;
    //   991: astore #16
    //   993: aload_1
    //   994: getfield cpg : Ljava/util/ArrayList;
    //   997: invokevirtual iterator : ()Ljava/util/Iterator;
    //   1000: astore #17
    //   1002: iconst_0
    //   1003: istore #6
    //   1005: aload #12
    //   1007: astore #9
    //   1009: aload #17
    //   1011: invokeinterface hasNext : ()Z
    //   1016: ifeq -> 1607
    //   1019: aload #17
    //   1021: invokeinterface next : ()Ljava/lang/Object;
    //   1026: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   1029: astore #12
    //   1031: aload #12
    //   1033: getfield id : J
    //   1036: ldc2_w 6
    //   1039: lcmp
    //   1040: ifne -> 1046
    //   1043: goto -> 1072
    //   1046: iload #5
    //   1048: iconst_3
    //   1049: if_icmpne -> 1075
    //   1052: aload #12
    //   1054: getfield aTU : I
    //   1057: ifne -> 1072
    //   1060: aload #12
    //   1062: getfield cpx : J
    //   1065: ldc2_w 4
    //   1068: lcmp
    //   1069: ifne -> 1075
    //   1072: goto -> 1009
    //   1075: aload #16
    //   1077: aload #12
    //   1079: getfield cpq : J
    //   1082: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1085: invokeinterface contains : (Ljava/lang/Object;)Z
    //   1090: ifne -> 1604
    //   1093: iload #6
    //   1095: ifeq -> 1141
    //   1098: new java/lang/StringBuilder
    //   1101: dup
    //   1102: invokespecial <init> : ()V
    //   1105: astore #10
    //   1107: aload #10
    //   1109: ldc_w '/'
    //   1112: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: pop
    //   1116: aload #10
    //   1118: aload #12
    //   1120: getfield name : Ljava/lang/String;
    //   1123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: pop
    //   1127: aload #15
    //   1129: aload #10
    //   1131: invokevirtual toString : ()Ljava/lang/String;
    //   1134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: goto -> 1152
    //   1141: aload #15
    //   1143: aload #12
    //   1145: getfield name : Ljava/lang/String;
    //   1148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: pop
    //   1152: aload #12
    //   1154: getfield name : Ljava/lang/String;
    //   1157: astore #11
    //   1159: aload_1
    //   1160: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   1163: getfield aVN : J
    //   1166: lconst_1
    //   1167: lcmp
    //   1168: ifne -> 1177
    //   1171: iconst_1
    //   1172: istore #6
    //   1174: goto -> 1180
    //   1177: iconst_0
    //   1178: istore #6
    //   1180: iload #6
    //   1182: ifne -> 1199
    //   1185: aload #12
    //   1187: getfield aTZ : Z
    //   1190: ifeq -> 1199
    //   1193: iconst_1
    //   1194: istore #6
    //   1196: goto -> 1202
    //   1199: iconst_0
    //   1200: istore #6
    //   1202: aload #11
    //   1204: astore #10
    //   1206: iload #6
    //   1208: ifeq -> 1357
    //   1211: aload_0
    //   1212: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1215: invokestatic b : (Lcom/laiqian/print/printtype/g;)Landroid/content/Context;
    //   1218: ldc_w 2131626345
    //   1221: invokevirtual getString : (I)Ljava/lang/String;
    //   1224: astore #10
    //   1226: aload #11
    //   1228: ldc_w '|-'
    //   1231: invokevirtual indexOf : (Ljava/lang/String;)I
    //   1234: iflt -> 1335
    //   1237: aload #11
    //   1239: ldc_w '|-'
    //   1242: ldc ''
    //   1244: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1247: astore #11
    //   1249: new java/lang/StringBuilder
    //   1252: dup
    //   1253: invokespecial <init> : ()V
    //   1256: astore #18
    //   1258: aload #18
    //   1260: ldc_w '['
    //   1263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: pop
    //   1267: aload #18
    //   1269: aload #10
    //   1271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: pop
    //   1275: aload #18
    //   1277: ldc_w ']'
    //   1280: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: pop
    //   1284: aload #18
    //   1286: aload #11
    //   1288: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: pop
    //   1292: aload #18
    //   1294: invokevirtual toString : ()Ljava/lang/String;
    //   1297: astore #10
    //   1299: new java/lang/StringBuilder
    //   1302: dup
    //   1303: invokespecial <init> : ()V
    //   1306: astore #11
    //   1308: aload #11
    //   1310: ldc_w '|-'
    //   1313: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: pop
    //   1317: aload #11
    //   1319: aload #10
    //   1321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: pop
    //   1325: aload #11
    //   1327: invokevirtual toString : ()Ljava/lang/String;
    //   1330: astore #10
    //   1332: goto -> 1357
    //   1335: ldc_w '[%s]%s'
    //   1338: iconst_2
    //   1339: anewarray java/lang/Object
    //   1342: dup
    //   1343: iconst_0
    //   1344: aload #10
    //   1346: aastore
    //   1347: dup
    //   1348: iconst_1
    //   1349: aload #11
    //   1351: aastore
    //   1352: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1355: astore #10
    //   1357: aload_2
    //   1358: invokevirtual aiD : ()Z
    //   1361: istore #4
    //   1363: iconst_m1
    //   1364: istore #6
    //   1366: iload #4
    //   1368: ifeq -> 1469
    //   1371: aload #14
    //   1373: iconst_3
    //   1374: newarray int
    //   1376: dup
    //   1377: iconst_0
    //   1378: iconst_0
    //   1379: iastore
    //   1380: dup
    //   1381: iconst_1
    //   1382: bipush #16
    //   1384: iastore
    //   1385: dup
    //   1386: iconst_2
    //   1387: bipush #32
    //   1389: iastore
    //   1390: invokevirtual n : ([I)V
    //   1393: aload_0
    //   1394: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1397: aload_1
    //   1398: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/pos/model/orders/a;)Z
    //   1401: ifeq -> 1407
    //   1404: goto -> 1410
    //   1407: iconst_1
    //   1408: istore #6
    //   1410: aload #14
    //   1412: iconst_3
    //   1413: anewarray java/lang/String
    //   1416: dup
    //   1417: iconst_0
    //   1418: aload #10
    //   1420: aastore
    //   1421: dup
    //   1422: iconst_1
    //   1423: iload #6
    //   1425: i2d
    //   1426: aload #12
    //   1428: getfield cpo : D
    //   1431: dmul
    //   1432: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1435: iconst_0
    //   1436: iconst_0
    //   1437: getstatic com/laiqian/crash/model/CrashApplication.aIQ : I
    //   1440: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   1443: aastore
    //   1444: dup
    //   1445: iconst_2
    //   1446: aload #12
    //   1448: getfield cpn : D
    //   1451: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1454: iconst_1
    //   1455: iconst_0
    //   1456: getstatic com/laiqian/crash/model/CrashApplication.aIQ : I
    //   1459: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   1462: aastore
    //   1463: invokevirtual x : ([Ljava/lang/String;)V
    //   1466: goto -> 1523
    //   1469: aload_0
    //   1470: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1473: aload_1
    //   1474: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/pos/model/orders/a;)Z
    //   1477: ifeq -> 1483
    //   1480: goto -> 1486
    //   1483: iconst_1
    //   1484: istore #6
    //   1486: aload #14
    //   1488: iconst_2
    //   1489: anewarray java/lang/String
    //   1492: dup
    //   1493: iconst_0
    //   1494: aload #10
    //   1496: aastore
    //   1497: dup
    //   1498: iconst_1
    //   1499: iload #6
    //   1501: i2d
    //   1502: aload #12
    //   1504: getfield cpo : D
    //   1507: dmul
    //   1508: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1511: iconst_0
    //   1512: iconst_0
    //   1513: getstatic com/laiqian/crash/model/CrashApplication.aIQ : I
    //   1516: invokestatic a : (Ljava/lang/Object;ZZI)Ljava/lang/String;
    //   1519: aastore
    //   1520: invokevirtual x : ([Ljava/lang/String;)V
    //   1523: aload #12
    //   1525: getfield cpm : Ljava/lang/String;
    //   1528: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1531: ifne -> 1598
    //   1534: aload #12
    //   1536: getfield cpx : J
    //   1539: ldc2_w 3
    //   1542: lcmp
    //   1543: ifne -> 1588
    //   1546: new java/lang/StringBuilder
    //   1549: dup
    //   1550: invokespecial <init> : ()V
    //   1553: astore #10
    //   1555: aload #10
    //   1557: ldc_w '|-'
    //   1560: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: pop
    //   1564: aload #10
    //   1566: aload #12
    //   1568: getfield cpm : Ljava/lang/String;
    //   1571: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1574: pop
    //   1575: aload #14
    //   1577: aload #10
    //   1579: invokevirtual toString : ()Ljava/lang/String;
    //   1582: invokevirtual ll : (Ljava/lang/String;)V
    //   1585: goto -> 1598
    //   1588: aload #14
    //   1590: aload #12
    //   1592: getfield cpm : Ljava/lang/String;
    //   1595: invokevirtual ll : (Ljava/lang/String;)V
    //   1598: iconst_1
    //   1599: istore #6
    //   1601: goto -> 1604
    //   1604: goto -> 1009
    //   1607: iload #6
    //   1609: ifne -> 1614
    //   1612: aconst_null
    //   1613: areturn
    //   1614: aload #13
    //   1616: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1619: ldc_w 'name'
    //   1622: aload #15
    //   1624: invokevirtual toString : ()Ljava/lang/String;
    //   1627: invokevirtual aJ : (Ljava/lang/String;Ljava/lang/String;)Lcom/laiqian/print/model/PrintContent$a;
    //   1630: pop
    //   1631: aload_0
    //   1632: getfield cJq : Lcom/laiqian/print/printtype/g;
    //   1635: aload #13
    //   1637: aload_2
    //   1638: invokevirtual air : ()I
    //   1641: invokestatic a : (Lcom/laiqian/print/printtype/g;Lcom/laiqian/print/b/e;I)Z
    //   1644: pop
    //   1645: aload #13
    //   1647: invokevirtual afT : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1650: aload_3
    //   1651: invokevirtual getCopies : ()I
    //   1654: invokevirtual ih : (I)Lcom/laiqian/print/model/PrintContent$a;
    //   1657: pop
    //   1658: aload #9
    //   1660: aload #13
    //   1662: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1665: invokevirtual add : (Ljava/lang/Object;)Z
    //   1668: pop
    //   1669: aload #9
    //   1671: new com/laiqian/print/model/PrintContent$a
    //   1674: dup
    //   1675: invokespecial <init> : ()V
    //   1678: invokevirtual agg : ()Lcom/laiqian/print/model/PrintContent$a;
    //   1681: invokevirtual afV : ()Lcom/laiqian/print/model/PrintContent;
    //   1684: invokevirtual add : (Ljava/lang/Object;)Z
    //   1687: pop
    //   1688: aload #9
    //   1690: areturn }
  
  public List<PrintContent> a(Object paramObject, String paramString, j.i parami, f paramf) {
    byte b;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 2006648068:
        if (paramString.equals("kitchen_total_reprint")) {
          b = 7;
          break;
        } 
      case 1676462825:
        if (paramString.equals("kitchen_total")) {
          b = 5;
          break;
        } 
      case 1328327225:
        if (paramString.equals("delivery_not_specified")) {
          b = 8;
          break;
        } 
      case 608149564:
        if (paramString.equals("kitchen_port")) {
          b = 4;
          break;
        } 
      case 3083674:
        if (paramString.equals("dish")) {
          b = 2;
          break;
        } 
      case -325560454:
        if (paramString.equals("tag_not_specified_reprint")) {
          b = 1;
          break;
        } 
      case -640940363:
        if (paramString.equals("dish_reprint")) {
          b = 3;
          break;
        } 
      case -931604649:
        if (paramString.equals("kitchen_port_reprint")) {
          b = 6;
          break;
        } 
      case -1979255969:
        if (paramString.equals("tag_not_specified")) {
          b = 0;
          break;
        } 
    } 
    switch (b) {
      default:
        throw new IllegalArgumentException("not match");
      case 8:
        return paramObject.getClass().isAssignableFrom(ah.class) ? a((ah)paramObject, (DeliveryPrintSettings)paramf, parami) : (paramObject.getClass().isAssignableFrom(PendingFullOrderDetail.class) ? a((PendingFullOrderDetail)paramObject, (DeliveryPrintSettings)paramf, parami, false) : null);
      case 7:
        return paramObject.getClass().isAssignableFrom(a.class) ? b((a)paramObject, (c)paramf, (j.c)parami, true) : null;
      case 6:
        return paramObject.getClass().isAssignableFrom(a.class) ? a((a)paramObject, (c)paramf, (j.c)parami, true) : null;
      case 5:
        return paramObject.getClass().isAssignableFrom(a.class) ? b((a)paramObject, (c)paramf, (j.c)parami, false) : (paramObject.getClass().isAssignableFrom(ah.class) ? b((ah)paramObject, (c)paramf, (j.c)parami) : null);
      case 4:
        return paramObject.getClass().isAssignableFrom(a.class) ? a((a)paramObject, (c)paramf, (j.c)parami, false) : (paramObject.getClass().isAssignableFrom(ah.class) ? a((ah)paramObject, (c)paramf, (j.c)parami) : null);
      case 3:
        return paramObject.getClass().isAssignableFrom(PendingFullOrderDetail.class) ? a((PendingFullOrderDetail)paramObject, (ReceiptPrintSettings)paramf, parami, true) : null;
      case 2:
        return paramObject.getClass().isAssignableFrom(PendingFullOrderDetail.class) ? a((PendingFullOrderDetail)paramObject, (ReceiptPrintSettings)paramf, parami, false) : (paramObject.getClass().isAssignableFrom(ah.class) ? a((ah)paramObject, (ReceiptPrintSettings)paramf, parami) : null);
      case 1:
        return paramObject.getClass().isAssignableFrom(a.class) ? a((a)paramObject, (c)paramf, (j.m)parami, true) : null;
      case 0:
        break;
    } 
    return paramObject.getClass().isAssignableFrom(a.class) ? a((a)paramObject, (c)paramf, (j.m)parami, false) : (paramObject.getClass().isAssignableFrom(ah.class) ? a((ah)paramObject, (c)paramf, (j.m)parami) : null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\printtype\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */