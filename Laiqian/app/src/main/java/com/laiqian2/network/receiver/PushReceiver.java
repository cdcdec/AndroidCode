package com.laiqian.network.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.laiqian.member.setting.sms.i;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.h;
import io.reactivex.i;

public class PushReceiver extends BroadcastReceiver {
  public static StringBuilder bVz = new StringBuilder();
  
  public void a(Context paramContext, Double paramDouble) { h.a(new b(paramDouble, paramContext)).d(a.aKh()).c(a.aJo()).aJk(); }
  
  public void onReceive(Context paramContext, Intent paramIntent) { // Byte code:
    //   0: aload_2
    //   1: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   4: astore_2
    //   5: new java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore #8
    //   14: aload #8
    //   16: ldc 'onReceive() action='
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload #8
    //   24: aload_2
    //   25: ldc 'action'
    //   27: invokevirtual getInt : (Ljava/lang/String;)I
    //   30: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: ldc 'GetuiSdkDemo'
    //   36: aload #8
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: aload_2
    //   46: ldc 'action'
    //   48: invokevirtual getInt : (Ljava/lang/String;)I
    //   51: tableswitch default -> 92, 10001 -> 191, 10002 -> 164, 10003 -> 92, 10004 -> 92, 10005 -> 92, 10006 -> 850, 10007 -> 93
    //   92: return
    //   93: new java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial <init> : ()V
    //   100: astore #8
    //   102: aload #8
    //   104: ldc 'onReceive() bundle='
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload #8
    //   112: aload_2
    //   113: invokevirtual toString : ()Ljava/lang/String;
    //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc 'GetuiSdkDemo'
    //   122: aload #8
    //   124: invokevirtual toString : ()Ljava/lang/String;
    //   127: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   130: pop
    //   131: aload_2
    //   132: ldc 'onlineState'
    //   134: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   137: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   140: invokevirtual booleanValue : ()Z
    //   143: ifne -> 850
    //   146: invokestatic getInstance : ()Lcom/igexin/sdk/PushManager;
    //   149: aload_1
    //   150: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   153: invokevirtual initialize : (Landroid/content/Context;)V
    //   156: ldc 'getui'
    //   158: ldc '重启中'
    //   160: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   163: return
    //   164: aload_2
    //   165: ldc 'clientid'
    //   167: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   170: astore_2
    //   171: new com/laiqian/util/av
    //   174: dup
    //   175: aload_1
    //   176: invokespecial <init> : (Landroid/content/Context;)V
    //   179: astore_1
    //   180: aload_1
    //   181: aload_2
    //   182: invokevirtual rt : (Ljava/lang/String;)Z
    //   185: pop
    //   186: aload_1
    //   187: invokevirtual close : ()V
    //   190: return
    //   191: aload_2
    //   192: ldc 'payload'
    //   194: invokevirtual getByteArray : (Ljava/lang/String;)[B
    //   197: astore #8
    //   199: aload_2
    //   200: ldc 'taskid'
    //   202: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   205: astore #9
    //   207: aload_2
    //   208: ldc 'messageid'
    //   210: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   213: astore_2
    //   214: invokestatic getInstance : ()Lcom/igexin/sdk/PushManager;
    //   217: aload_1
    //   218: aload #9
    //   220: aload_2
    //   221: ldc 90001
    //   223: invokevirtual sendFeedbackMessage : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Z
    //   226: istore #7
    //   228: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   231: astore #9
    //   233: new java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial <init> : ()V
    //   240: astore #10
    //   242: aload #10
    //   244: ldc '第三方回执接口调用'
    //   246: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: iload #7
    //   252: ifeq -> 261
    //   255: ldc '成功'
    //   257: astore_2
    //   258: goto -> 264
    //   261: ldc '失败'
    //   263: astore_2
    //   264: aload #10
    //   266: aload_2
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload #9
    //   273: aload #10
    //   275: invokevirtual toString : ()Ljava/lang/String;
    //   278: invokevirtual println : (Ljava/lang/String;)V
    //   281: aload #8
    //   283: ifnull -> 850
    //   286: new java/lang/String
    //   289: dup
    //   290: aload #8
    //   292: invokespecial <init> : ([B)V
    //   295: astore_2
    //   296: new java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial <init> : ()V
    //   303: astore #8
    //   305: aload #8
    //   307: ldc 'receiver payload : '
    //   309: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload #8
    //   315: aload_2
    //   316: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: ldc 'GetuiSdkDemo'
    //   322: aload #8
    //   324: invokevirtual toString : ()Ljava/lang/String;
    //   327: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   330: pop
    //   331: getstatic com/laiqian/network/receiver/PushReceiver.bVz : Ljava/lang/StringBuilder;
    //   334: aload_2
    //   335: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: getstatic com/laiqian/network/receiver/PushReceiver.bVz : Ljava/lang/StringBuilder;
    //   342: ldc '\\n'
    //   344: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: iconst_0
    //   349: istore #6
    //   351: new org/json/JSONObject
    //   354: dup
    //   355: aload_2
    //   356: invokespecial <init> : (Ljava/lang/String;)V
    //   359: astore #8
    //   361: aload #8
    //   363: ldc 'type'
    //   365: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   368: astore #9
    //   370: aload #8
    //   372: ldc 'fAmount'
    //   374: invokevirtual optDouble : (Ljava/lang/String;)D
    //   377: dstore_3
    //   378: ldc 'ALIPAY_SMS'
    //   380: aload #9
    //   382: invokevirtual equals : (Ljava/lang/Object;)Z
    //   385: ifeq -> 418
    //   388: new com/laiqian/member/setting/sms/i
    //   391: dup
    //   392: aload_1
    //   393: invokespecial <init> : (Landroid/content/Context;)V
    //   396: aload #8
    //   398: aload_1
    //   399: invokevirtual a : (Lorg/json/JSONObject;Landroid/content/Context;)V
    //   402: aload_0
    //   403: aload_1
    //   404: dload_3
    //   405: invokestatic valueOf : (D)Ljava/lang/Double;
    //   408: invokevirtual a : (Landroid/content/Context;Ljava/lang/Double;)V
    //   411: iload #6
    //   413: istore #5
    //   415: goto -> 797
    //   418: ldc 'member-set'
    //   420: aload #9
    //   422: invokevirtual equals : (Ljava/lang/Object;)Z
    //   425: ifeq -> 441
    //   428: invokestatic RH : ()Lcom/laiqian/member/setting/bc;
    //   431: invokevirtual RN : ()V
    //   434: iload #6
    //   436: istore #5
    //   438: goto -> 797
    //   441: ldc_w 'ALIPAY_SIGN'
    //   444: aload #9
    //   446: invokevirtual equals : (Ljava/lang/Object;)Z
    //   449: ifeq -> 584
    //   452: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   455: invokevirtual Tx : ()Ljava/lang/String;
    //   458: aload #8
    //   460: ldc_w 'shopid'
    //   463: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   466: invokevirtual equals : (Ljava/lang/Object;)Z
    //   469: ifeq -> 562
    //   472: aload #8
    //   474: ldc_w 'appid'
    //   477: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   480: astore_1
    //   481: aload_1
    //   482: ifnull -> 851
    //   485: aload_1
    //   486: invokevirtual length : ()I
    //   489: ifle -> 851
    //   492: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   495: invokevirtual FC : ()Ljava/lang/String;
    //   498: ifnonnull -> 851
    //   501: iconst_1
    //   502: istore #5
    //   504: goto -> 507
    //   507: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   510: aload #8
    //   512: ldc_w 'alipay_channel_id'
    //   515: ldc_w '5'
    //   518: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   521: invokevirtual bQ : (Ljava/lang/String;)Z
    //   524: pop
    //   525: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   528: aload_1
    //   529: invokevirtual ro : (Ljava/lang/String;)Z
    //   532: pop
    //   533: iload #5
    //   535: ifeq -> 562
    //   538: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   541: iconst_1
    //   542: invokevirtual dW : (I)Z
    //   545: pop
    //   546: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   549: new android/content/Intent
    //   552: dup
    //   553: ldc_w 'pos_activity_change_data_paytype'
    //   556: invokespecial <init> : (Ljava/lang/String;)V
    //   559: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   562: invokestatic RH : ()Lcom/laiqian/member/setting/bc;
    //   565: aload #8
    //   567: ldc_w 'result'
    //   570: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   573: invokevirtual fZ : (Ljava/lang/String;)Z
    //   576: pop
    //   577: iload #6
    //   579: istore #5
    //   581: goto -> 797
    //   584: ldc_w 'NEW_REPLY'
    //   587: aload #9
    //   589: invokevirtual equals : (Ljava/lang/Object;)Z
    //   592: ifeq -> 641
    //   595: aload #8
    //   597: ldc_w 'version_id'
    //   600: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   603: astore #8
    //   605: new android/content/Intent
    //   608: dup
    //   609: ldc_w 'customer_service_reply'
    //   612: invokespecial <init> : (Ljava/lang/String;)V
    //   615: astore #9
    //   617: aload #9
    //   619: ldc_w 'version_id'
    //   622: aload #8
    //   624: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   627: pop
    //   628: aload_1
    //   629: aload #9
    //   631: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   634: iload #6
    //   636: istore #5
    //   638: goto -> 797
    //   641: ldc_w 'mswxpay_id'
    //   644: aload #9
    //   646: invokevirtual equals : (Ljava/lang/Object;)Z
    //   649: ifeq -> 766
    //   652: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   655: invokevirtual Tx : ()Ljava/lang/String;
    //   658: aload #8
    //   660: ldc_w 'shopid'
    //   663: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   666: invokevirtual equals : (Ljava/lang/Object;)Z
    //   669: ifeq -> 744
    //   672: aload #8
    //   674: ldc_w 'appid'
    //   677: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   680: astore_1
    //   681: aload_1
    //   682: invokestatic isNull : (Ljava/lang/String;)Z
    //   685: istore #7
    //   687: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   690: aload #8
    //   692: ldc_w 'wechat_pay_channel_id'
    //   695: ldc_w '5'
    //   698: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   701: invokevirtual bR : (Ljava/lang/String;)Z
    //   704: pop
    //   705: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   708: aload_1
    //   709: invokevirtual rp : (Ljava/lang/String;)Z
    //   712: pop
    //   713: iload #7
    //   715: iconst_1
    //   716: ixor
    //   717: ifeq -> 744
    //   720: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   723: iconst_5
    //   724: invokevirtual dX : (I)Z
    //   727: pop
    //   728: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   731: new android/content/Intent
    //   734: dup
    //   735: ldc_w 'pos_activity_change_data_paytype'
    //   738: invokespecial <init> : (Ljava/lang/String;)V
    //   741: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   744: invokestatic RH : ()Lcom/laiqian/member/setting/bc;
    //   747: aload #8
    //   749: ldc_w 'result'
    //   752: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   755: invokevirtual fZ : (Ljava/lang/String;)Z
    //   758: pop
    //   759: iload #6
    //   761: istore #5
    //   763: goto -> 797
    //   766: new com/laiqian/takeaway/aq
    //   769: dup
    //   770: aload_1
    //   771: invokespecial <init> : (Landroid/content/Context;)V
    //   774: aload #8
    //   776: aload_1
    //   777: iconst_1
    //   778: iconst_1
    //   779: invokevirtual a : (Lorg/json/JSONObject;Landroid/content/Context;ZZ)V
    //   782: iload #6
    //   784: istore #5
    //   786: goto -> 797
    //   789: astore_1
    //   790: aload_1
    //   791: invokestatic e : (Ljava/lang/Throwable;)V
    //   794: iconst_1
    //   795: istore #5
    //   797: iload #5
    //   799: ifeq -> 850
    //   802: aload_2
    //   803: invokestatic decode : (Ljava/lang/String;)Ljava/lang/String;
    //   806: astore_1
    //   807: new java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial <init> : ()V
    //   814: astore #8
    //   816: aload #8
    //   818: ldc 'receiver payload : '
    //   820: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload #8
    //   826: aload_1
    //   827: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: ldc 'GetuiSdkDemo'
    //   833: aload #8
    //   835: invokevirtual toString : ()Ljava/lang/String;
    //   838: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   841: pop
    //   842: getstatic com/laiqian/opentable/c.bYa : Lcom/laiqian/opentable/c;
    //   845: aload_2
    //   846: aconst_null
    //   847: invokevirtual a : (Ljava/lang/String;Lcom/laiqian/opentable/c$a;)V
    //   850: return
    //   851: iconst_0
    //   852: istore #5
    //   854: goto -> 507
    // Exception table:
    //   from	to	target	type
    //   351	411	789	org/json/JSONException
    //   418	434	789	org/json/JSONException
    //   441	481	789	org/json/JSONException
    //   485	501	789	org/json/JSONException
    //   507	533	789	org/json/JSONException
    //   538	562	789	org/json/JSONException
    //   562	577	789	org/json/JSONException
    //   584	634	789	org/json/JSONException
    //   641	713	789	org/json/JSONException
    //   720	744	789	org/json/JSONException
    //   744	759	789	org/json/JSONException
    //   766	782	789	org/json/JSONException }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\receiver\PushReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */