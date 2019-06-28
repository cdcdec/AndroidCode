package com.laiqian.pos;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.models.x;
import com.laiqian.opentable.common.b;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.pos.model.orders.a;
import com.laiqian.pos.model.orders.b;
import com.laiqian.print.j;
import com.laiqian.print.model.g;
import com.laiqian.print.usage.tag.a.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.s;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.squareup.moshi.Json;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@DebugLog
public class ReprintActivity extends ActivityRoot {
  private static final String TAG = "ReprintActivity";
  
  static List<HashMap<String, String>> cij = new ArrayList();
  
  private a cic;
  
  private View cid;
  
  private b cie;
  
  @Nullable
  private String cif = null;
  
  private int cig = 0;
  
  private long cih;
  
  private int cii = 0;
  
  private boolean isLoading = false;
  
  private void ZW() { n.a(getActivity(), getCurrentFocus()); }
  
  private void ZX() { (new cx(this)).execute(new Void[0]); }
  
  private void ZY() {
    if (this.cig > this.cii) {
      if (this.cic.bLC.getFooterViewsCount() == 0) {
        this.cic.bLC.addFooterView(ZZ());
        return;
      } 
    } else if (this.cic.bLC.getFooterViewsCount() == 1) {
      this.cic.bLC.removeFooterView(ZZ());
    } 
  }
  
  private View ZZ() {
    if (this.cid == null) {
      this.cid = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(2131427454, null);
      ImageView imageView = (ImageView)this.cid.findViewById(2131297346);
      Animation animation = AnimationUtils.loadAnimation(getActivity(), 2130772030);
      animation.setInterpolator(new LinearInterpolator());
      imageView.startAnimation(animation);
    } 
    return this.cid;
  }
  
  @Nullable
  public static b a(c paramc, Context paramContext) { // Byte code:
    //   0: aload_1
    //   1: astore #35
    //   3: new java/util/ArrayList
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore #40
    //   12: aload_0
    //   13: getfield orderNo : Ljava/lang/String;
    //   16: astore #46
    //   18: aload_0
    //   19: getfield ciA : Ljava/lang/String;
    //   22: astore #30
    //   24: getstatic com/laiqian/pos/ReprintActivity.TAG : Ljava/lang/String;
    //   27: ldc 'getSettlementOrder --datTime--->2131296826'
    //   29: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   32: pop
    //   33: aload_0
    //   34: getfield ciC : Ljava/lang/String;
    //   37: ifnull -> 52
    //   40: aload_0
    //   41: getfield ciC : Ljava/lang/String;
    //   44: invokevirtual toString : ()Ljava/lang/String;
    //   47: astore #29
    //   49: goto -> 55
    //   52: aconst_null
    //   53: astore #29
    //   55: aload_0
    //   56: getfield aJW : D
    //   59: dstore #12
    //   61: new com/laiqian/models/b
    //   64: dup
    //   65: aload #35
    //   67: invokespecial <init> : (Landroid/content/Context;)V
    //   70: astore #31
    //   72: aload #31
    //   74: aload #46
    //   76: iconst_0
    //   77: aload #30
    //   79: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   82: invokevirtual longValue : ()J
    //   85: invokevirtual a : (Ljava/lang/String;ZJ)Ljava/util/ArrayList;
    //   88: astore #42
    //   90: aload #31
    //   92: invokevirtual close : ()V
    //   95: new com/laiqian/pos/model/a
    //   98: dup
    //   99: aload #35
    //   101: invokespecial <init> : (Landroid/content/Context;)V
    //   104: aload #46
    //   106: iconst_0
    //   107: invokevirtual t : (Ljava/lang/String;Z)Lcom/laiqian/report/models/o;
    //   110: astore #49
    //   112: new com/laiqian/models/x
    //   115: dup
    //   116: aload #35
    //   118: invokespecial <init> : (Landroid/content/Context;)V
    //   121: astore #30
    //   123: aload #30
    //   125: aload #46
    //   127: invokevirtual hz : (Ljava/lang/String;)Landroid/database/Cursor;
    //   130: astore #31
    //   132: aload #30
    //   134: aload #46
    //   136: invokevirtual hA : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   139: astore #32
    //   141: aload #30
    //   143: aload #46
    //   145: invokevirtual hB : (Ljava/lang/String;)Ljava/lang/Double;
    //   148: astore #34
    //   150: iconst_1
    //   151: istore #26
    //   153: aload #31
    //   155: ifnull -> 210
    //   158: aload #31
    //   160: invokeinterface moveToNext : ()Z
    //   165: ifeq -> 210
    //   168: aload #31
    //   170: aload #31
    //   172: ldc 'nProductTransacType'
    //   174: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   179: invokeinterface getLong : (I)J
    //   184: lstore #27
    //   186: lload #27
    //   188: ldc2_w 100015
    //   191: lcmp
    //   192: ifeq -> 153
    //   195: lload #27
    //   197: ldc2_w 100060
    //   200: lcmp
    //   201: ifeq -> 153
    //   204: iconst_0
    //   205: istore #26
    //   207: goto -> 153
    //   210: aload #31
    //   212: ifnull -> 2450
    //   215: aload #31
    //   217: invokeinterface moveToFirst : ()Z
    //   222: ifeq -> 2450
    //   225: aload_0
    //   226: getfield aEI : J
    //   229: invokestatic valueOf : (J)Ljava/lang/String;
    //   232: aload #35
    //   234: invokestatic d : (Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   237: astore #50
    //   239: aload #31
    //   241: aload #31
    //   243: ldc_w 'sSpareField1'
    //   246: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   251: invokeinterface getString : (I)Ljava/lang/String;
    //   256: astore #51
    //   258: aload #31
    //   260: aload #31
    //   262: ldc_w 'nBPartnerID'
    //   265: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   270: invokeinterface getLong : (I)J
    //   275: lstore #27
    //   277: ldc_w ''
    //   280: astore #33
    //   282: lload #27
    //   284: invokestatic valueOf : (J)Ljava/lang/Long;
    //   287: lconst_0
    //   288: invokestatic valueOf : (J)Ljava/lang/Long;
    //   291: invokevirtual equals : (Ljava/lang/Object;)Z
    //   294: ifne -> 348
    //   297: new com/laiqian/models/j
    //   300: dup
    //   301: aload #35
    //   303: invokespecial <init> : (Landroid/content/Context;)V
    //   306: astore #36
    //   308: aload #36
    //   310: aload_0
    //   311: getfield ciA : Ljava/lang/String;
    //   314: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   317: invokevirtual longValue : ()J
    //   320: aload #46
    //   322: invokevirtual k : (JLjava/lang/String;)Lcom/laiqian/entity/b;
    //   325: astore #30
    //   327: goto -> 340
    //   330: astore #30
    //   332: aload #30
    //   334: invokestatic e : (Ljava/lang/Throwable;)V
    //   337: aconst_null
    //   338: astore #30
    //   340: aload #36
    //   342: invokevirtual close : ()V
    //   345: goto -> 351
    //   348: aconst_null
    //   349: astore #30
    //   351: new com/laiqian/util/av
    //   354: dup
    //   355: aload #35
    //   357: invokespecial <init> : (Landroid/content/Context;)V
    //   360: astore #36
    //   362: ldc_w ''
    //   365: aload #29
    //   367: invokevirtual equals : (Ljava/lang/Object;)Z
    //   370: ifne -> 381
    //   373: aload #29
    //   375: ifnull -> 381
    //   378: goto -> 384
    //   381: aconst_null
    //   382: astore #29
    //   384: aload_0
    //   385: getfield ciG : I
    //   388: istore #24
    //   390: aload_0
    //   391: getfield ciG : I
    //   394: istore #25
    //   396: iload #25
    //   398: bipush #7
    //   400: if_icmpne -> 418
    //   403: aload_0
    //   404: getfield bch : Ljava/lang/String;
    //   407: astore #38
    //   409: aload_0
    //   410: getfield openTableName : Ljava/lang/String;
    //   413: astore #39
    //   415: goto -> 424
    //   418: aconst_null
    //   419: astore #39
    //   421: aconst_null
    //   422: astore #38
    //   424: aload #36
    //   426: aload #46
    //   428: invokevirtual rB : (Ljava/lang/String;)Lcom/laiqian/pos/dc;
    //   431: astore #41
    //   433: aload #36
    //   435: invokevirtual close : ()V
    //   438: new com/laiqian/product/models/l
    //   441: dup
    //   442: aload #35
    //   444: invokespecial <init> : (Landroid/content/Context;)V
    //   447: astore_0
    //   448: aload_0
    //   449: invokevirtual Vi : ()Ljava/util/ArrayList;
    //   452: astore #45
    //   454: aload_0
    //   455: invokevirtual close : ()V
    //   458: new com/laiqian/models/ab
    //   461: dup
    //   462: aload #35
    //   464: invokespecial <init> : (Landroid/content/Context;)V
    //   467: astore #35
    //   469: new java/util/ArrayList
    //   472: dup
    //   473: invokespecial <init> : ()V
    //   476: astore #47
    //   478: dconst_0
    //   479: invokestatic valueOf : (D)Ljava/lang/Double;
    //   482: astore #37
    //   484: ldc2_w 100.0
    //   487: dstore #8
    //   489: aconst_null
    //   490: astore #36
    //   492: dconst_0
    //   493: dstore #10
    //   495: dconst_0
    //   496: dstore_2
    //   497: dconst_0
    //   498: dstore #4
    //   500: aload #29
    //   502: astore #43
    //   504: aload #30
    //   506: astore #44
    //   508: aload #31
    //   510: astore_0
    //   511: aload #33
    //   513: astore #29
    //   515: aload #47
    //   517: astore #33
    //   519: aload #46
    //   521: astore #31
    //   523: aload #40
    //   525: astore #30
    //   527: aload_0
    //   528: invokeinterface isFirst : ()Z
    //   533: ifeq -> 598
    //   536: aload_0
    //   537: aload_0
    //   538: ldc_w 'nDateTime'
    //   541: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   546: invokeinterface getString : (I)Ljava/lang/String;
    //   551: astore #40
    //   553: aload #40
    //   555: invokestatic parseLong : (Ljava/lang/String;)J
    //   558: lstore #27
    //   560: new java/util/Date
    //   563: dup
    //   564: lload #27
    //   566: invokespecial <init> : (J)V
    //   569: astore #40
    //   571: aload #40
    //   573: astore #36
    //   575: goto -> 598
    //   578: astore #40
    //   580: goto -> 590
    //   583: astore #40
    //   585: goto -> 590
    //   588: astore #40
    //   590: aload #40
    //   592: invokestatic e : (Ljava/lang/Throwable;)V
    //   595: goto -> 598
    //   598: aload #39
    //   600: astore #40
    //   602: aload #38
    //   604: astore #46
    //   606: aload #29
    //   608: astore #39
    //   610: aload_0
    //   611: aload_0
    //   612: ldc_w 'nSpareField3'
    //   615: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   620: invokeinterface getInt : (I)I
    //   625: istore #25
    //   627: iload #25
    //   629: iconst_1
    //   630: if_icmpne -> 658
    //   633: dload_2
    //   634: dstore #6
    //   636: dload #8
    //   638: dstore #14
    //   640: dload #10
    //   642: dstore_2
    //   643: aload #37
    //   645: astore #29
    //   647: dload #6
    //   649: dstore #8
    //   651: dload #14
    //   653: dstore #6
    //   655: goto -> 1965
    //   658: aload_0
    //   659: aload_0
    //   660: ldc_w 'fDiscount'
    //   663: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   668: invokeinterface getDouble : (I)D
    //   673: dstore #14
    //   675: dload #14
    //   677: invokestatic isInfinite : (D)Z
    //   680: ifne -> 702
    //   683: dload #14
    //   685: invokestatic isNaN : (D)Z
    //   688: ifne -> 702
    //   691: dload #14
    //   693: dstore #6
    //   695: dload #14
    //   697: dconst_0
    //   698: dcmpl
    //   699: ifne -> 707
    //   702: ldc2_w 100.0
    //   705: dstore #6
    //   707: dload #6
    //   709: ldc2_w 100.0
    //   712: dsub
    //   713: invokestatic bc : (D)Z
    //   716: ifne -> 723
    //   719: dload #6
    //   721: dstore #8
    //   723: aload_0
    //   724: aload_0
    //   725: ldc 'nProductTransacType'
    //   727: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   732: invokeinterface getLong : (I)J
    //   737: invokestatic valueOf : (J)Ljava/lang/Long;
    //   740: astore #53
    //   742: aload_0
    //   743: aload_0
    //   744: ldc_w 'sProductName'
    //   747: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   752: invokeinterface getString : (I)Ljava/lang/String;
    //   757: astore #48
    //   759: aload_0
    //   760: aload_0
    //   761: getstatic com/laiqian/models/x.bQu : Lcom/laiqian/models/ao$b;
    //   764: invokevirtual getName : ()Ljava/lang/String;
    //   767: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   772: invokeinterface getLong : (I)J
    //   777: lstore #27
    //   779: aload_0
    //   780: aload_0
    //   781: ldc_w 'nProductQty'
    //   784: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   789: invokeinterface getDouble : (I)D
    //   794: dstore #14
    //   796: aload_0
    //   797: aload_0
    //   798: ldc_w 'fPrice'
    //   801: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   806: invokeinterface getDouble : (I)D
    //   811: dstore #16
    //   813: aload_0
    //   814: aload_0
    //   815: ldc_w 'fAmount'
    //   818: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   823: invokeinterface getDouble : (I)D
    //   828: dstore #18
    //   830: aload_0
    //   831: aload_0
    //   832: ldc_w 'fReceived'
    //   835: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   840: invokeinterface getDouble : (I)D
    //   845: dstore #22
    //   847: aload_0
    //   848: aload_0
    //   849: ldc_w 'fSpareField1'
    //   852: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   857: invokeinterface getDouble : (I)D
    //   862: dstore #20
    //   864: aload_0
    //   865: aload_0
    //   866: getstatic com/laiqian/models/x.bPY : Lcom/laiqian/models/ao$b;
    //   869: invokevirtual getName : ()Ljava/lang/String;
    //   872: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   877: invokeinterface getLong : (I)J
    //   882: pop2
    //   883: iload #26
    //   885: ifne -> 952
    //   888: aload #53
    //   890: ifnull -> 941
    //   893: aload #37
    //   895: astore #29
    //   897: dload #10
    //   899: dstore #6
    //   901: aload #53
    //   903: ldc2_w 100015
    //   906: invokestatic valueOf : (J)Ljava/lang/Long;
    //   909: invokevirtual equals : (Ljava/lang/Object;)Z
    //   912: ifne -> 949
    //   915: aload #37
    //   917: invokevirtual doubleValue : ()D
    //   920: dload #22
    //   922: dadd
    //   923: invokestatic valueOf : (D)Ljava/lang/Double;
    //   926: astore #29
    //   928: dload #10
    //   930: dload #20
    //   932: dload #14
    //   934: dmul
    //   935: dadd
    //   936: dstore #6
    //   938: goto -> 949
    //   941: dload #10
    //   943: dstore #6
    //   945: aload #37
    //   947: astore #29
    //   949: goto -> 978
    //   952: aload #37
    //   954: invokevirtual doubleValue : ()D
    //   957: dload #22
    //   959: dadd
    //   960: invokestatic valueOf : (D)Ljava/lang/Double;
    //   963: astore #29
    //   965: dload #10
    //   967: dload #20
    //   969: dload #14
    //   971: dmul
    //   972: dadd
    //   973: dstore #6
    //   975: goto -> 949
    //   978: aload #53
    //   980: ldc2_w 100060
    //   983: invokestatic valueOf : (J)Ljava/lang/Long;
    //   986: invokevirtual equals : (Ljava/lang/Object;)Z
    //   989: ifeq -> 1146
    //   992: aload_0
    //   993: aload_0
    //   994: getstatic com/laiqian/models/x.bQu : Lcom/laiqian/models/ao$b;
    //   997: invokevirtual getName : ()Ljava/lang/String;
    //   1000: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1005: invokeinterface getLong : (I)J
    //   1010: lstore #27
    //   1012: new com/laiqian/models/ba
    //   1015: dup
    //   1016: aload_1
    //   1017: invokespecial <init> : (Landroid/content/Context;)V
    //   1020: astore #37
    //   1022: aload #37
    //   1024: lload #27
    //   1026: invokevirtual bO : (J)Lcom/laiqian/product/models/o;
    //   1029: astore #38
    //   1031: dload_2
    //   1032: dstore #10
    //   1034: aload #38
    //   1036: ifnull -> 1119
    //   1039: aload_0
    //   1040: aload_0
    //   1041: ldc_w 'fAmount'
    //   1044: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1049: invokeinterface getDouble : (I)D
    //   1054: dstore #10
    //   1056: aload #33
    //   1058: new com/laiqian/product/models/p
    //   1061: dup
    //   1062: lload #27
    //   1064: aload #38
    //   1066: invokevirtual akZ : ()Ljava/lang/String;
    //   1069: aload #38
    //   1071: invokevirtual ala : ()D
    //   1074: dload #10
    //   1076: aload_0
    //   1077: aload_0
    //   1078: ldc_w 'fSpareField4'
    //   1081: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1086: invokeinterface getDouble : (I)D
    //   1091: aload_0
    //   1092: aload_0
    //   1093: ldc_w 'fSpareField1'
    //   1096: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1101: invokeinterface getDouble : (I)D
    //   1106: invokespecial <init> : (JLjava/lang/String;DDDD)V
    //   1109: invokevirtual add : (Ljava/lang/Object;)Z
    //   1112: pop
    //   1113: dload_2
    //   1114: dload #10
    //   1116: dadd
    //   1117: dstore #10
    //   1119: aload #37
    //   1121: invokevirtual close : ()V
    //   1124: dload #6
    //   1126: dstore_2
    //   1127: dload #10
    //   1129: dstore #6
    //   1131: dload #8
    //   1133: dstore #10
    //   1135: dload #6
    //   1137: dstore #8
    //   1139: dload #10
    //   1141: dstore #6
    //   1143: goto -> 1965
    //   1146: aload #53
    //   1148: ldc2_w 100068
    //   1151: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1154: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1157: ifeq -> 1216
    //   1160: aload_0
    //   1161: aload_0
    //   1162: getstatic com/laiqian/models/x.bPh : Lcom/laiqian/models/ao$b;
    //   1165: invokevirtual getName : ()Ljava/lang/String;
    //   1168: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1173: invokeinterface getDouble : (I)D
    //   1178: dstore #4
    //   1180: aload_0
    //   1181: aload_0
    //   1182: getstatic com/laiqian/models/x.bNL : Lcom/laiqian/models/ao$b;
    //   1185: invokevirtual getName : ()Ljava/lang/String;
    //   1188: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1193: invokeinterface getDouble : (I)D
    //   1198: dstore #10
    //   1200: dload #6
    //   1202: dload #10
    //   1204: dadd
    //   1205: dstore #10
    //   1207: dload_2
    //   1208: dstore #6
    //   1210: dload #10
    //   1212: dstore_2
    //   1213: goto -> 1131
    //   1216: new java/util/HashMap
    //   1219: dup
    //   1220: invokespecial <init> : ()V
    //   1223: astore #52
    //   1225: aload #52
    //   1227: ldc_w 'nSpareField3'
    //   1230: iload #25
    //   1232: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1235: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1238: pop
    //   1239: lload #27
    //   1241: ldc2_w 6
    //   1244: lcmp
    //   1245: ifne -> 1265
    //   1248: aload #52
    //   1250: ldc_w 'sProductName'
    //   1253: aload #48
    //   1255: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1258: pop
    //   1259: aconst_null
    //   1260: astore #37
    //   1262: goto -> 1743
    //   1265: aload #35
    //   1267: lload #27
    //   1269: invokevirtual bp : (J)Landroid/database/Cursor;
    //   1272: astore #54
    //   1274: aload #54
    //   1276: invokeinterface moveToFirst : ()Z
    //   1281: ifeq -> 1733
    //   1284: aload #54
    //   1286: aload #54
    //   1288: getstatic com/laiqian/models/ab.bQQ : Lcom/laiqian/models/ao$b;
    //   1291: invokevirtual getName : ()Ljava/lang/String;
    //   1294: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1299: invokeinterface getLong : (I)J
    //   1304: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1307: astore #47
    //   1309: aload #52
    //   1311: ldc_w 'nProductType'
    //   1314: aload #47
    //   1316: invokevirtual toString : ()Ljava/lang/String;
    //   1319: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1322: pop
    //   1323: aload #54
    //   1325: aload #54
    //   1327: ldc_w 'sProductName'
    //   1330: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1335: invokeinterface getString : (I)Ljava/lang/String;
    //   1340: astore #38
    //   1342: aload #54
    //   1344: aload #54
    //   1346: ldc_w 'nProductType'
    //   1349: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1354: invokeinterface getString : (I)Ljava/lang/String;
    //   1359: astore #56
    //   1361: aload #54
    //   1363: aload #54
    //   1365: ldc_w 'sSpareField3'
    //   1368: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1373: invokeinterface getString : (I)Ljava/lang/String;
    //   1378: astore #37
    //   1380: aload #54
    //   1382: aload #54
    //   1384: ldc_w 'sSpareField5'
    //   1387: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1392: invokeinterface getString : (I)Ljava/lang/String;
    //   1397: astore #55
    //   1399: aload #54
    //   1401: aload #54
    //   1403: ldc_w 'fDiscountSalePrice'
    //   1406: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1411: invokeinterface isNull : (I)Z
    //   1416: ifne -> 1451
    //   1419: aload #52
    //   1421: ldc_w 'fMemberPrice'
    //   1424: aload #54
    //   1426: aload #54
    //   1428: ldc_w 'fDiscountSalePrice'
    //   1431: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1436: invokeinterface getDouble : (I)D
    //   1441: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1444: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1447: pop
    //   1448: goto -> 1451
    //   1451: aload #37
    //   1453: invokestatic isNull : (Ljava/lang/String;)Z
    //   1456: ifne -> 1464
    //   1459: aload #37
    //   1461: invokestatic jz : (Ljava/lang/String;)V
    //   1464: aload #52
    //   1466: ldc_w 'fDbOrigPrice'
    //   1469: aload #54
    //   1471: aload #54
    //   1473: ldc_w 'fSalePrice'
    //   1476: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1481: invokeinterface getDouble : (I)D
    //   1486: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1489: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1492: pop
    //   1493: aload #38
    //   1495: astore #37
    //   1497: aload #48
    //   1499: aload #38
    //   1501: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   1504: ifeq -> 1568
    //   1507: aload #38
    //   1509: astore #37
    //   1511: aload #48
    //   1513: invokevirtual length : ()I
    //   1516: aload #38
    //   1518: invokevirtual length : ()I
    //   1521: if_icmple -> 1568
    //   1524: aload #48
    //   1526: aload #38
    //   1528: invokevirtual length : ()I
    //   1531: invokevirtual substring : (I)Ljava/lang/String;
    //   1534: astore #37
    //   1536: new java/lang/StringBuilder
    //   1539: dup
    //   1540: invokespecial <init> : ()V
    //   1543: astore #48
    //   1545: aload #48
    //   1547: aload #38
    //   1549: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1552: pop
    //   1553: aload #48
    //   1555: aload #37
    //   1557: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: pop
    //   1561: aload #48
    //   1563: invokevirtual toString : ()Ljava/lang/String;
    //   1566: astore #37
    //   1568: aload #37
    //   1570: astore #38
    //   1572: aload #56
    //   1574: ldc_w '50001'
    //   1577: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1580: ifeq -> 1616
    //   1583: new java/lang/StringBuilder
    //   1586: dup
    //   1587: invokespecial <init> : ()V
    //   1590: astore #38
    //   1592: aload #38
    //   1594: ldc_w '|-'
    //   1597: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: pop
    //   1601: aload #38
    //   1603: aload #37
    //   1605: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: pop
    //   1609: aload #38
    //   1611: invokevirtual toString : ()Ljava/lang/String;
    //   1614: astore #38
    //   1616: new java/lang/StringBuilder
    //   1619: dup
    //   1620: invokespecial <init> : ()V
    //   1623: astore #48
    //   1625: aload #48
    //   1627: lload #27
    //   1629: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1632: pop
    //   1633: aload #48
    //   1635: ldc_w ''
    //   1638: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1641: pop
    //   1642: aload #38
    //   1644: astore #37
    //   1646: aload #48
    //   1648: invokevirtual toString : ()Ljava/lang/String;
    //   1651: invokestatic jA : (Ljava/lang/String;)Z
    //   1654: ifeq -> 1690
    //   1657: new java/lang/StringBuilder
    //   1660: dup
    //   1661: invokespecial <init> : ()V
    //   1664: astore #37
    //   1666: aload #37
    //   1668: ldc_w '|-'
    //   1671: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: pop
    //   1675: aload #37
    //   1677: aload #38
    //   1679: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: pop
    //   1683: aload #37
    //   1685: invokevirtual toString : ()Ljava/lang/String;
    //   1688: astore #37
    //   1690: aload #52
    //   1692: ldc_w 'sSpareField5'
    //   1695: aload #55
    //   1697: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1700: pop
    //   1701: aload #52
    //   1703: ldc_w 'sProductName'
    //   1706: aload #37
    //   1708: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1711: pop
    //   1712: aload #52
    //   1714: ldc_w 'nFoodCategory'
    //   1717: iload #25
    //   1719: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1722: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1725: pop
    //   1726: aload #47
    //   1728: astore #37
    //   1730: goto -> 1736
    //   1733: aconst_null
    //   1734: astore #37
    //   1736: aload #54
    //   1738: invokeinterface close : ()V
    //   1743: aload #52
    //   1745: ldc 'nProductTransacType'
    //   1747: aload #53
    //   1749: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1752: pop
    //   1753: new java/lang/StringBuilder
    //   1756: dup
    //   1757: invokespecial <init> : ()V
    //   1760: astore #38
    //   1762: aload #38
    //   1764: dload #16
    //   1766: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1769: pop
    //   1770: aload #38
    //   1772: ldc_w ''
    //   1775: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1778: pop
    //   1779: aload #52
    //   1781: ldc_w 'fPrice'
    //   1784: aload #38
    //   1786: invokevirtual toString : ()Ljava/lang/String;
    //   1789: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1792: pop
    //   1793: new java/lang/StringBuilder
    //   1796: dup
    //   1797: invokespecial <init> : ()V
    //   1800: astore #38
    //   1802: aload #38
    //   1804: dload #18
    //   1806: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1809: pop
    //   1810: aload #38
    //   1812: ldc_w ''
    //   1815: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: pop
    //   1819: aload #52
    //   1821: ldc_w 'fAmount'
    //   1824: aload #38
    //   1826: invokevirtual toString : ()Ljava/lang/String;
    //   1829: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1832: pop
    //   1833: aload #52
    //   1835: ldc_w 'nProductQty'
    //   1838: dload #14
    //   1840: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1843: invokestatic d : (Ljava/lang/Number;)Ljava/lang/String;
    //   1846: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1849: pop
    //   1850: aload #52
    //   1852: ldc_w 'fAmount'
    //   1855: aload_0
    //   1856: aload_0
    //   1857: ldc_w 'fAmount'
    //   1860: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1865: invokeinterface getString : (I)Ljava/lang/String;
    //   1870: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1873: pop
    //   1874: new java/lang/StringBuilder
    //   1877: dup
    //   1878: invokespecial <init> : ()V
    //   1881: astore #38
    //   1883: aload #38
    //   1885: dload #20
    //   1887: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1890: pop
    //   1891: aload #38
    //   1893: ldc_w ''
    //   1896: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1899: pop
    //   1900: aload #52
    //   1902: ldc_w 'fOriginalPrice'
    //   1905: aload #38
    //   1907: invokevirtual toString : ()Ljava/lang/String;
    //   1910: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1913: pop
    //   1914: aload #45
    //   1916: aload #37
    //   1918: invokevirtual contains : (Ljava/lang/Object;)Z
    //   1921: ifne -> 1927
    //   1924: goto -> 1943
    //   1927: aload #52
    //   1929: ldc_w 'noDiscount'
    //   1932: iconst_1
    //   1933: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   1936: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1939: pop
    //   1940: goto -> 1924
    //   1943: aload #30
    //   1945: aload #52
    //   1947: invokevirtual add : (Ljava/lang/Object;)Z
    //   1950: pop
    //   1951: dload #6
    //   1953: dstore #10
    //   1955: dload #8
    //   1957: dstore #6
    //   1959: dload_2
    //   1960: dstore #8
    //   1962: dload #10
    //   1964: dstore_2
    //   1965: aload_0
    //   1966: invokeinterface moveToNext : ()Z
    //   1971: ifne -> 2409
    //   1974: aload #35
    //   1976: invokevirtual close : ()V
    //   1979: getstatic com/laiqian/pos/ReprintActivity.cij : Ljava/util/List;
    //   1982: invokeinterface clear : ()V
    //   1987: aload #32
    //   1989: new com/laiqian/pos/cw
    //   1992: dup
    //   1993: invokespecial <init> : ()V
    //   1996: invokestatic a : (Ljava/util/Collection;Lcom/laiqian/util/k$b;)D
    //   1999: dstore #14
    //   2001: dload #12
    //   2003: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2006: astore #35
    //   2008: aload #29
    //   2010: invokevirtual doubleValue : ()D
    //   2013: pop2
    //   2014: aload #34
    //   2016: ifnull -> 2029
    //   2019: aload #34
    //   2021: invokevirtual doubleValue : ()D
    //   2024: dstore #10
    //   2026: goto -> 2032
    //   2029: dconst_0
    //   2030: dstore #10
    //   2032: aload #35
    //   2034: astore_1
    //   2035: iload #26
    //   2037: ifeq -> 2050
    //   2040: aload #35
    //   2042: invokevirtual doubleValue : ()D
    //   2045: dneg
    //   2046: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2049: astore_1
    //   2050: new com/laiqian/pos/model/orders/b
    //   2053: dup
    //   2054: invokespecial <init> : ()V
    //   2057: astore #35
    //   2059: aload #35
    //   2061: aload #31
    //   2063: putfield orderNo : Ljava/lang/String;
    //   2066: aload #34
    //   2068: ifnull -> 2100
    //   2071: aload #34
    //   2073: invokevirtual isInfinite : ()Z
    //   2076: ifne -> 2100
    //   2079: aload #34
    //   2081: invokevirtual isNaN : ()Z
    //   2084: ifne -> 2100
    //   2087: aload #35
    //   2089: aload #34
    //   2091: invokevirtual doubleValue : ()D
    //   2094: putfield cyL : D
    //   2097: goto -> 2100
    //   2100: aload #35
    //   2102: iconst_1
    //   2103: putfield aWg : Z
    //   2106: aload #35
    //   2108: iload #26
    //   2110: putfield aWa : Z
    //   2113: aload #35
    //   2115: aload #36
    //   2117: putfield bkf : Ljava/util/Date;
    //   2120: aload #35
    //   2122: iload #24
    //   2124: i2l
    //   2125: putfield bcf : J
    //   2128: aload #35
    //   2130: aload #46
    //   2132: putfield bch : Ljava/lang/String;
    //   2135: aload #35
    //   2137: aload #46
    //   2139: invokestatic a : (Lcom/laiqian/pos/model/orders/b;Ljava/lang/String;)Lcom/laiqian/pos/model/orders/b;
    //   2142: astore #31
    //   2144: aload #31
    //   2146: aload #40
    //   2148: putfield openTableName : Ljava/lang/String;
    //   2151: aload #31
    //   2153: aload #43
    //   2155: putfield coJ : Ljava/lang/String;
    //   2158: aload #31
    //   2160: aload #39
    //   2162: putfield cyJ : Ljava/lang/String;
    //   2165: aload #31
    //   2167: dload_2
    //   2168: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2171: putfield cyP : Ljava/lang/Double;
    //   2174: aload #31
    //   2176: dload #4
    //   2178: putfield cpa : D
    //   2181: aload #31
    //   2183: getfield cyP : Ljava/lang/Double;
    //   2186: dconst_0
    //   2187: invokestatic a : (Ljava/lang/Double;D)V
    //   2190: aload #31
    //   2192: aload #29
    //   2194: putfield cyO : Ljava/lang/Double;
    //   2197: aload #31
    //   2199: getfield cyO : Ljava/lang/Double;
    //   2202: dconst_0
    //   2203: invokestatic a : (Ljava/lang/Double;D)V
    //   2206: aload #31
    //   2208: aload_1
    //   2209: putfield cyH : Ljava/lang/Double;
    //   2212: aload #31
    //   2214: dload #6
    //   2216: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2219: putfield ceX : Ljava/lang/Double;
    //   2222: aload #31
    //   2224: aload #49
    //   2226: getfield daT : D
    //   2229: aload #49
    //   2231: invokevirtual amN : ()D
    //   2234: dsub
    //   2235: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2238: putfield cyI : Ljava/lang/Double;
    //   2241: aload #31
    //   2243: getfield cyI : Ljava/lang/Double;
    //   2246: dconst_0
    //   2247: invokestatic a : (Ljava/lang/Double;D)V
    //   2250: aload #31
    //   2252: getfield cyN : Ljava/util/ArrayList;
    //   2255: aload #32
    //   2257: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   2260: pop
    //   2261: iload #26
    //   2263: ifeq -> 2291
    //   2266: aload #31
    //   2268: aload #31
    //   2270: getfield cyI : Ljava/lang/Double;
    //   2273: invokevirtual doubleValue : ()D
    //   2276: aload #31
    //   2278: getfield cyL : D
    //   2281: dsub
    //   2282: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2285: putfield cyI : Ljava/lang/Double;
    //   2288: goto -> 2313
    //   2291: aload #31
    //   2293: aload #31
    //   2295: getfield cyI : Ljava/lang/Double;
    //   2298: invokevirtual doubleValue : ()D
    //   2301: aload #31
    //   2303: getfield cyL : D
    //   2306: dadd
    //   2307: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2310: putfield cyI : Ljava/lang/Double;
    //   2313: aload #31
    //   2315: aload #31
    //   2317: getfield cyI : Ljava/lang/Double;
    //   2320: invokevirtual doubleValue : ()D
    //   2323: dload #14
    //   2325: dadd
    //   2326: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2329: putfield cyI : Ljava/lang/Double;
    //   2332: aload #31
    //   2334: getfield bbS : Ljava/util/ArrayList;
    //   2337: aload #42
    //   2339: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   2342: pop
    //   2343: aload #31
    //   2345: getfield bJf : Ljava/util/ArrayList;
    //   2348: aload #30
    //   2350: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   2353: pop
    //   2354: aload #31
    //   2356: aload #50
    //   2358: putfield ceV : Ljava/lang/String;
    //   2361: aload #31
    //   2363: aload #44
    //   2365: putfield vipEntity : Lcom/laiqian/entity/aq;
    //   2368: aload #31
    //   2370: getfield cyR : Ljava/util/ArrayList;
    //   2373: aload #33
    //   2375: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   2378: pop
    //   2379: aload #31
    //   2381: dload #8
    //   2383: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2386: putfield cyQ : Ljava/lang/Double;
    //   2389: aload #31
    //   2391: aload #41
    //   2393: putfield ciN : Lcom/laiqian/pos/dc;
    //   2396: aload #31
    //   2398: aload #51
    //   2400: putfield billNumber : Ljava/lang/String;
    //   2403: aload #31
    //   2405: astore_1
    //   2406: goto -> 2455
    //   2409: aload #46
    //   2411: astore #38
    //   2413: aload #41
    //   2415: astore #46
    //   2417: aload #39
    //   2419: astore #41
    //   2421: aload #40
    //   2423: astore #39
    //   2425: aload #29
    //   2427: astore #37
    //   2429: aload #41
    //   2431: astore #29
    //   2433: aload #46
    //   2435: astore #41
    //   2437: dload_2
    //   2438: dstore #10
    //   2440: dload #8
    //   2442: dstore_2
    //   2443: dload #6
    //   2445: dstore #8
    //   2447: goto -> 527
    //   2450: aload #31
    //   2452: astore_0
    //   2453: aconst_null
    //   2454: astore_1
    //   2455: aload_0
    //   2456: ifnull -> 2465
    //   2459: aload_0
    //   2460: invokeinterface close : ()V
    //   2465: aload_1
    //   2466: areturn
    // Exception table:
    //   from	to	target	type
    //   308	327	330	java/lang/Exception
    //   536	553	588	java/lang/Exception
    //   553	560	583	java/lang/Exception
    //   560	571	578	java/lang/Exception }
  
  @DebugLog
  public static final ArrayList<c> a(@NonNull Cursor paramCursor, Context paramContext) {
    Cursor cursor = paramCursor;
    ArrayList arrayList = new ArrayList();
    int i = RootApplication.aIQ;
    int k = cursor.getColumnIndex("sTableName");
    int j = cursor.getColumnIndex("sProductNames");
    int i2 = cursor.getColumnIndex("sTime");
    int i3 = cursor.getColumnIndex("orderAmount");
    int i4 = cursor.getColumnIndex("_id");
    int i5 = cursor.getColumnIndex("sHeaderText");
    int i6 = cursor.getColumnIndex("orderType");
    i = cursor.getColumnIndex("nUserID");
    int i1 = cursor.getColumnIndex("sUserPhone");
    int m = cursor.getColumnIndex("nProductTransacType");
    int i7 = cursor.getColumnIndex("actualPerson");
    int i8 = cursor.getColumnIndex("openTableNumber");
    int i9 = cursor.getColumnIndex("openTableName");
    int n = cursor.getColumnIndex("fSpareField5");
    av av = new av(paramContext);
    int i10 = cursor.getColumnIndex("nTime");
    while (true) {
      Cursor cursor1 = paramCursor;
      if (paramCursor.moveToNext()) {
        int i11 = cursor1.getInt(n);
        c c = new c();
        String str2 = cursor1.getString(k);
        if (str2.equalsIgnoreCase("T_PRODUCTDOC")) {
          c.type = 1;
        } else {
          c.type = 2;
        } 
        c.ciH = i11;
        c.ciA = cursor1.getString(i10);
        c.name = cursor1.getString(j);
        c.ciB = cursor1.getString(i2);
        c.aJW = cursor1.getDouble(i3);
        c.orderNo = cursor1.getString(i4);
        c.ciG = cursor1.getInt(i6);
        c.bch = cursor1.getString(i7);
        c.openTableName = cursor1.getString(i9);
        if (c.type == 2) {
          String str = cursor1.getString(i5);
          if (c.ciG == 2 && !TextUtils.isEmpty(str)) {
            null = b.a(paramContext, "", Long.valueOf(by.parseLong(str)), true);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(null.bZc);
            stringBuilder.append("-");
            stringBuilder.append(null.bTe);
            str = stringBuilder.toString();
          } 
          if (!TextUtils.isEmpty(str)) {
            c.ciC = str;
          } else {
            c.ciC = null;
          } 
        } else {
          String str;
          if (c.ciG == 7) {
            str = cursor1.getString(i8);
          } else {
            str = cursor1.getString(i5);
          } 
          if (!TextUtils.isEmpty(str)) {
            c.ciC = str;
          } else {
            c.ciC = null;
          } 
        } 
        c.aEI = cursor1.getLong(i);
        c.bfo = cursor1.getString(i1);
        String str1 = cursor1.getString(m);
        if ("100001".equals(str1)) {
          c.aWa = false;
        } else if ("100015".equals(str1)) {
          c.aWa = true;
        } 
        c.ciD = av.bp(c.orderNo, str2.toUpperCase());
        c.ciE = av.bq(c.orderNo, str2.toUpperCase());
        c.ciF = av.br(c.orderNo, str2.toUpperCase());
        arrayList.add(c);
        continue;
      } 
      break;
    } 
    av.close();
    return arrayList;
  }
  
  private static void a(Double paramDouble, double paramDouble1) {
    if (paramDouble == null)
      return; 
    if (Double.isNaN(paramDouble.doubleValue()) || Double.isInfinite(paramDouble.doubleValue()));
  }
  
  private boolean a(c paramc) {
    List list2;
    List list1;
    ArrayList arrayList = new ArrayList();
    av av = new av(getActivity());
    switch (paramc.type) {
      case 2:
        null = b(paramc, getActivity()).aaE();
        try {
          arrayList.addAll(j.cCx.a(null, new String[] { "kitchen_total_reprint", "kitchen_port_reprint" }));
        } catch (Exception null) {
          a.e(null);
        } 
        if (arrayList.size() > 0) {
          paramc.ciF++;
          av.i(paramc.orderNo, "T_ORDER", paramc.ciF);
          this.cie.notifyDataSetChanged();
        } 
        break;
      case 1:
        b1 = a(paramc, getActivity());
        list1 = new ArrayList();
        try {
          List list = j.cCx.a(b1, new String[] { "kitchen_total_reprint" });
          list1 = list;
        } catch (Exception exception) {
          a.e(exception);
        } 
        list2 = new ArrayList();
        try {
          List list = j.cCx.a(b1, new String[] { "kitchen_port_reprint" });
          list2 = list;
        } catch (Exception b1) {
          a.e(b1);
        } 
        if (list1.size() > 0 || list2.size() > 0) {
          arrayList.addAll(list1);
          arrayList.addAll(list2);
          paramc.ciF++;
          av.i(paramc.orderNo, "T_PRODUCTDOC", paramc.ciF);
          this.cie.notifyDataSetChanged();
        } 
        break;
    } 
    av.close();
    if (arrayList.size() > 0) {
      g.cGS.o(arrayList);
      return true;
    } 
    return false;
  }
  
  public static Intent aQ(Context paramContext) { return new Intent(paramContext, ReprintActivity.class); }
  
  @Nullable
  public static PendingFullOrderDetail b(c paramc, Context paramContext) {
    a a1 = new a(paramContext);
    PendingFullOrderDetail pendingFullOrderDetail = a1.ky(paramc.orderNo);
    a1.close();
    return pendingFullOrderDetail;
  }
  
  private void b(c paramc) {
    c(paramc);
    d(paramc);
    a(paramc);
    finish();
  }
  
  @DebugLog
  private ArrayList<c> c(@NonNull Cursor paramCursor) {
    ArrayList arrayList = a(paramCursor, this);
    this.cii += paramCursor.getCount();
    return arrayList;
  }
  
  private boolean c(c paramc) {
    List list;
    ArrayList arrayList = new ArrayList();
    av av = new av(getActivity());
    switch (paramc.type) {
      case 2:
        null = b(paramc, getActivity());
        list = Collections.EMPTY_LIST;
        try {
          List list1 = j.cCx.a(null, new String[] { "dish_reprint" });
          list = list1;
        } catch (Exception null) {
          a.e(null);
        } 
        if (list.size() > 0) {
          paramc.ciD++;
          av.g(paramc.orderNo, "T_ORDER", paramc.ciD);
          this.cie.notifyDataSetChanged();
          arrayList.addAll(list);
        } 
        break;
      case 1:
        b1 = a(paramc, getActivity());
        list = Collections.EMPTY_LIST;
        try {
          List list1 = j.cCx.a(b1, new String[] { "settle_receipt_reprint" });
          list = list1;
        } catch (Exception b1) {
          a.e(b1);
        } 
        if (list.size() > 0) {
          paramc.ciD++;
          av.g(paramc.orderNo, "T_PRODUCTDOC", paramc.ciD);
          this.cie.notifyDataSetChanged();
          arrayList.addAll(list);
        } 
        break;
    } 
    av.close();
    if (arrayList.size() > 0) {
      g.cGS.o(arrayList);
      return true;
    } 
    return false;
  }
  
  private boolean d(c paramc) {
    List list;
    ArrayList arrayList = new ArrayList();
    av av = new av(getActivity());
    switch (paramc.type) {
      case 2:
        null = b(paramc, getActivity());
        list = Collections.EMPTY_LIST;
        try {
          List list1 = j.cCx.a(null.aaE(), new String[] { "tag_not_specified_reprint" });
          list = list1;
        } catch (Exception null) {
          a.e(null);
        } 
        if (list.size() > 0) {
          paramc.ciE++;
          av.h(paramc.orderNo, "T_ORDER", paramc.ciE);
          arrayList.addAll(list);
          this.cie.notifyDataSetChanged();
        } 
        break;
      case 1:
        b1 = a(paramc, getActivity());
        list = Collections.EMPTY_LIST;
        try {
          List list1 = j.cCx.a(b1, new String[] { "tag_not_specified_reprint" });
          list = list1;
        } catch (Exception b1) {
          a.e(b1);
        } 
        if (list.size() > 0) {
          paramc.ciE++;
          av.h(paramc.orderNo, "T_PRODUCTDOC", paramc.ciE);
          arrayList.addAll(list);
          this.cie.notifyDataSetChanged();
        } 
        break;
    } 
    av.close();
    if (arrayList.size() > 0) {
      g.cGS.o(arrayList);
      return true;
    } 
    return false;
  }
  
  private void init() {
    this.cic.cio.setVisibility(8);
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
    this.cih = calendar.getTimeInMillis();
    this.cie = new b(getActivity());
    this.cie.a(new cu(this));
    this.cic.bLC.setAdapter(this.cie);
    u(this.cih, null);
  }
  
  public static boolean jA(String paramString) {
    if (cij != null && cij.size() > 0) {
      Iterator iterator = cij.iterator();
      while (iterator.hasNext()) {
        if (((HashMap)iterator.next()).containsKey(paramString))
          return true; 
      } 
    } 
    return false;
  }
  
  public static void jz(String paramString) {
    try {
      JSONArray jSONArray = new JSONArray(paramString);
      for (byte b1 = 0; b1 < jSONArray.length(); b1++) {
        JSONArray jSONArray1 = new JSONArray(jSONArray.optJSONObject(b1).optString("products"));
        if (jSONArray1 != null && jSONArray1.length() > 0) {
          JSONObject jSONObject = jSONArray1.optJSONObject(0);
          HashMap hashMap = new HashMap();
          hashMap.put(jSONObject.optString("nProductID"), jSONObject.optString("sProductName"));
          cij.add(hashMap);
        } 
      } 
    } catch (JSONException paramString) {
      a.e(paramString);
    } 
  }
  
  private void setupViews() {
    this.cic.cim.setOnClickListener(new co(this));
    this.cic.bLC.setEmptyView(this.cic.ciq);
    this.cic.byK.setOnClickListener(new cp(this));
    this.cic.cin.setOnClickListener(new cq(this));
    this.cic.cip.addTextChangedListener(new cr(this));
    this.cic.cio.setOnClickListener(new cs(this));
    this.cic.bLC.setOnScrollListener(new ct(this));
  }
  
  @DebugLog
  private void u(long paramLong, @Nullable String paramString) {
    this.cii = 0;
    x x = new x(getActivity());
    this.cig = x.n(paramLong, paramString);
    if (this.cig <= 0) {
      if (TextUtils.isEmpty(paramString)) {
        this.cic.cin.setVisibility(8);
        this.cic.ciq.setText(2131628082);
      } else {
        this.cic.ciq.setText(getString(2131629570));
      } 
    } else {
      this.cic.cin.setVisibility(0);
    } 
    try {
      Cursor cursor = x.a(paramLong, paramString, this.cii, 30);
    } catch (Exception paramString) {
      a.e(paramString);
      paramString = null;
    } 
    if (paramString != null) {
      ArrayList arrayList = c(paramString);
      paramString.close();
      ZY();
      this.cie.clear();
      this.cie.addAll(arrayList);
      this.cie.notifyDataSetChanged();
    } else {
      this.cie.clear();
    } 
    x.close();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    this.cic = a.c(getWindow());
    setupViews();
    init();
  }
  
  private static class a {
    public View aQG;
    
    public ListView bLC;
    
    public Button byK;
    
    public LinearLayout cim;
    
    public TextView cin;
    
    public ImageView cio;
    
    public EditText cip;
    
    public TextView ciq;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cim = (LinearLayout)s.z(param1View, 2131297514);
      this.byK = (Button)s.z(param1View, 2131296614);
      this.cin = (TextView)s.z(param1View, 2131299676);
      this.cip = (EditText)s.z(param1View, 2131297014);
      this.ciq = (TextView)s.z(param1View, 2131299533);
      this.bLC = (ListView)s.z(param1View, 2131298066);
      this.cio = (ImageView)s.z(param1View, 2131297365);
    }
    
    public static a c(Window param1Window) { return new a(View.inflate(param1Window.getContext(), 2131427413, s.p(param1Window))); }
  }
  
  private static class b extends BaseAdapter {
    private final ArrayList<ReprintActivity.c> bWG = new ArrayList();
    
    private boolean cir;
    
    @Nullable
    private a cis;
    
    private Context context;
    
    public b(Context param1Context) {
      boolean bool = true;
      this.cir = true;
      this.cis = null;
      this.context = param1Context;
      if (a.bq(param1Context).getPrinters().size() <= 0)
        bool = false; 
      this.cir = bool;
    }
    
    private void a(ReprintActivity.c param1c, b param1b) {
      double d;
      param1b.ciu.setText(param1c.name);
      TextView textView = param1b.buE;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(CrashApplication.zA());
      if (param1c.aWa) {
        d = -param1c.aJW;
      } else {
        d = param1c.aJW;
      } 
      stringBuilder.append(n.d(Double.valueOf(d)));
      textView.setText(stringBuilder.toString());
      param1b.bqW.setText(param1c.ciB);
      if (param1c.ciC != null) {
        param1b.civ.setVisibility(0);
        if (param1c.ciG == 7) {
          if (!param1c.openTableName.contains(".")) {
            param1b.civ.setText(param1c.openTableName);
          } else {
            int i = param1c.openTableName.indexOf(".");
            param1b.civ.setText(param1c.openTableName.substring(0, i));
            textView = param1b.civ;
            stringBuilder = new StringBuilder();
            stringBuilder.append("\n");
            stringBuilder.append(param1c.openTableName.substring(i + 1));
            textView.append(stringBuilder.toString());
          } 
        } else {
          param1b.civ.setText(param1c.ciC.toString());
        } 
      } else {
        param1b.civ.setVisibility(8);
      } 
      if (this.context.getResources().getBoolean(2131034127)) {
        param1b.ciz.setVisibility(0);
      } else {
        param1b.ciz.setVisibility(8);
      } 
      if (param1c.ciD > 0) {
        textView = param1b.ciw;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.context.getString(2131627284));
        stringBuilder.append(" x");
        stringBuilder.append(param1c.ciD);
        textView.setText(stringBuilder.toString());
      } else {
        param1b.ciw.setText(this.context.getString(2131627284));
      } 
      if (param1c.ciE > 0) {
        textView = param1b.cix;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.context.getString(2131626970));
        stringBuilder.append(" x");
        stringBuilder.append(param1c.ciE);
        textView.setText(stringBuilder.toString());
      } else {
        param1b.cix.setText(this.context.getString(2131626970));
      } 
      if (param1c.ciF > 0) {
        textView = param1b.ciy;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.context.getString(2131626877));
        stringBuilder.append(" x");
        stringBuilder.append(param1c.ciF);
        textView.setText(stringBuilder.toString());
      } else {
        param1b.ciy.setText(this.context.getString(2131626877));
      } 
      if (this.cir) {
        param1b.cix.setVisibility(0);
        return;
      } 
      param1b.cix.setVisibility(8);
    }
    
    public void a(@Nullable a param1a) { this.cis = param1a; }
    
    public void addAll(Collection<ReprintActivity.c> param1Collection) { this.bWG.addAll(param1Collection); }
    
    public void clear() { this.bWG.clear(); }
    
    public ReprintActivity.c gS(int param1Int) { return (ReprintActivity.c)this.bWG.get(param1Int); }
    
    public int getCount() { return this.bWG.size(); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      b b1;
      if (param1View == null) {
        param1View = View.inflate(this.context, 2131428017, null);
        b1 = new b(param1View);
        param1View.setTag(b1);
      } else {
        b1 = (b)param1View.getTag();
      } 
      b1.ciz.setOnClickListener(new cy(this, param1Int));
      b1.ciw.setOnClickListener(new cz(this, param1Int));
      b1.cix.setOnClickListener(new da(this, param1Int));
      b1.ciy.setOnClickListener(new db(this, param1Int));
      a(gS(param1Int), b1);
      return param1View;
    }
    
    public static interface a {
      void gO(int param2Int);
      
      void gP(int param2Int);
      
      void gQ(int param2Int);
      
      void gR(int param2Int);
    }
    
    private static class b {
      TextView bqW;
      
      TextView buE;
      
      TextView ciu;
      
      TextView civ;
      
      TextView ciw;
      
      TextView cix;
      
      TextView ciy;
      
      TextView ciz;
      
      public b(View param2View) {
        this.ciu = (TextView)param2View.findViewById(2131299410);
        this.bqW = (TextView)param2View.findViewById(2131299444);
        this.buE = (TextView)param2View.findViewById(2131299296);
        this.civ = (TextView)param2View.findViewById(2131299371);
        this.ciw = (TextView)param2View.findViewById(2131296645);
        this.cix = (TextView)param2View.findViewById(2131296655);
        this.ciy = (TextView)param2View.findViewById(2131296630);
        this.ciz = (TextView)param2View.findViewById(2131296555);
      }
    }
  }
  
  public static interface a {
    void gO(int param1Int);
    
    void gP(int param1Int);
    
    void gQ(int param1Int);
    
    void gR(int param1Int);
  }
  
  private static class b {
    TextView bqW;
    
    TextView buE;
    
    TextView ciu;
    
    TextView civ;
    
    TextView ciw;
    
    TextView cix;
    
    TextView ciy;
    
    TextView ciz;
    
    public b(View param1View) {
      this.ciu = (TextView)param1View.findViewById(2131299410);
      this.bqW = (TextView)param1View.findViewById(2131299444);
      this.buE = (TextView)param1View.findViewById(2131299296);
      this.civ = (TextView)param1View.findViewById(2131299371);
      this.ciw = (TextView)param1View.findViewById(2131296645);
      this.cix = (TextView)param1View.findViewById(2131296655);
      this.ciy = (TextView)param1View.findViewById(2131296630);
      this.ciz = (TextView)param1View.findViewById(2131296555);
    }
  }
  
  public static final class c {
    @Json(name = "userId")
    public long aEI;
    
    @Json(name = "amount")
    public double aJW;
    
    @Json(name = "isReturn")
    public boolean aWa = false;
    
    @Json(name = "actualPerson")
    public String bch;
    
    @Json(name = "userPhone")
    public String bfo;
    
    @Json(name = "dateTime")
    public String ciA;
    
    @Json(name = "time")
    public String ciB;
    
    @Json(name = "tableNo")
    @Nullable
    public String ciC;
    
    @Json(name = "receiptReprintCount")
    public int ciD = 0;
    
    @Json(name = "tagReprintCount")
    public int ciE = 0;
    
    @Json(name = "kitchenReprintCount")
    public int ciF = 0;
    
    @Json(name = "oderSource")
    public int ciG;
    
    @Json(name = "numberDecimals")
    public int ciH;
    
    @Json(name = "name")
    public String name;
    
    @Json(name = "openTableName")
    public String openTableName;
    
    @Json(name = "orderNo")
    public String orderNo;
    
    @Json(name = "type")
    public int type;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ReprintActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */