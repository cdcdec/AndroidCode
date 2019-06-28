package com.laiqian.takeaway;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aw;
import com.laiqian.f.b;
import com.laiqian.models.an;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.av;
import com.laiqian.util.bq;
import com.laiqian.util.n;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aq {
  public static final String dtB;
  
  private bq bpc;
  
  private Context context;
  
  private String dtA;
  
  private final String dtC;
  
  private final String dtD;
  
  private final String dtE;
  
  private final String dtF;
  
  private final String dtG;
  
  private final String dtH;
  
  private final String dtI;
  
  private final String dtv = "takeoutweb";
  
  private final String dtw = "version.txt";
  
  private final String dtx;
  
  private final String dty;
  
  private final String dtz = "takeoutweb.zip";
  
  static  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.ckV);
    stringBuilder.append("tdd/shops?sessionKey=");
    dtB = stringBuilder.toString();
  }
  
  public aq(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.ckV);
    stringBuilder.append("waimai/resource");
    this.dtA = stringBuilder.toString();
    this.dtC = "tao";
    this.dtD = "weixin";
    this.dtE = "koubei";
    this.dtF = "weixin_eat_in";
    this.dtG = "meituan";
    this.dtH = "pending";
    this.dtI = "refund";
    this.context = paramContext;
    stringBuilder = new StringBuilder();
    stringBuilder.append(Environment.getExternalStorageDirectory());
    stringBuilder.append("/laiqian/");
    stringBuilder.append("takeoutweb");
    this.dtx = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    stringBuilder.append("/");
    stringBuilder.append("takeoutweb");
    this.dty = stringBuilder.toString();
  }
  
  public static void b(Context paramContext, HashMap<String, String> paramHashMap) {
    av av = new av(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("arrTddInfo_");
    stringBuilder.append(av.Tx());
    av.h(stringBuilder.toString(), paramHashMap);
    av.close();
  }
  
  public static boolean by(Context paramContext) {
    av av = new av(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("arrTddInfo_");
    stringBuilder.append(av.Tx());
    av.qS(stringBuilder.toString());
    av.close();
    return true;
  }
  
  public static HashMap<String, String> bz(Context paramContext) {
    av av = new av(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("arrTddInfo_");
    stringBuilder.append(av.Tx());
    HashMap hashMap = (HashMap)av.qQ(stringBuilder.toString());
    av.close();
    return hashMap;
  }
  
  public static void oP(String paramString) {
    HashMap hashMap = new HashMap();
    hashMap.put("c", w(RootApplication.zv(), paramString));
    hashMap.put("shopid", RootApplication.getLaiqianPreferenceManager().Tx());
    hashMap.put("type", paramString);
    hashMap.put("client_type", RootApplication.zv().getString(R.string.version_name));
    hashMap.put("language", (RootApplication.zv().getResources().getConfiguration()).locale.toString());
    ay ay = new ay(hashMap, new ax(paramString));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.clr);
    stringBuilder.append("check-orders");
    ay.execute(new String[] { stringBuilder.toString() });
  }
  
  private void oQ(String paramString) { (new bc(this.context)).oQ(paramString); }
  
  public static String w(Context paramContext, String paramString) {
    av = new av(paramContext);
    String str1 = av.Ea();
    String str2 = av.atr();
    if ("".equals(str1))
      return null; 
    JSONObject jSONObject = new JSONObject();
    try {
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("sName", str1);
      jSONObject1.put("sPwd", str2);
      jSONObject.put(paramString, jSONObject1);
    } catch (JSONException paramString) {
      a.e(paramString);
    } 
    av.close();
    try {
      if (jSONObject.length() > 0)
        return b.encode(jSONObject.toString()); 
    } catch (Exception av) {
      a.e(av);
    } 
    return "";
  }
  
  public void a(JSONObject paramJSONObject, Context paramContext, boolean paramBoolean1, boolean paramBoolean2) { // Byte code:
    //   0: bipush #7
    //   2: anewarray java/lang/String
    //   5: astore #58
    //   7: aload #58
    //   9: iconst_0
    //   10: ldc 'tao'
    //   12: aastore
    //   13: aload #58
    //   15: iconst_1
    //   16: ldc 'weixin'
    //   18: aastore
    //   19: aload #58
    //   21: iconst_2
    //   22: ldc 'koubei'
    //   24: aastore
    //   25: aload #58
    //   27: iconst_3
    //   28: ldc 'weixin_eat_in'
    //   30: aastore
    //   31: aload #58
    //   33: iconst_4
    //   34: ldc 'meituan'
    //   36: aastore
    //   37: aload #58
    //   39: iconst_5
    //   40: ldc_w 'phone_order'
    //   43: aastore
    //   44: aload #58
    //   46: bipush #6
    //   48: ldc_w 'eleme'
    //   51: aastore
    //   52: iconst_2
    //   53: anewarray java/lang/String
    //   56: astore #53
    //   58: aload #53
    //   60: iconst_0
    //   61: ldc 'pending'
    //   63: aastore
    //   64: aload #53
    //   66: iconst_1
    //   67: ldc 'refund'
    //   69: aastore
    //   70: aload_1
    //   71: ldc 'shopid'
    //   73: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   76: invokevirtual toString : ()Ljava/lang/String;
    //   79: astore #52
    //   81: aload_1
    //   82: ldc_w 'refresh'
    //   85: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   88: invokevirtual toString : ()Ljava/lang/String;
    //   91: invokestatic parseBoolean : (Ljava/lang/String;)Z
    //   94: istore #48
    //   96: new com/laiqian/util/av
    //   99: dup
    //   100: aload_2
    //   101: invokespecial <init> : (Landroid/content/Context;)V
    //   104: astore #59
    //   106: aload #59
    //   108: invokevirtual Tx : ()Ljava/lang/String;
    //   111: aload #52
    //   113: invokevirtual equals : (Ljava/lang/Object;)Z
    //   116: ifne -> 125
    //   119: aload #59
    //   121: invokevirtual close : ()V
    //   124: return
    //   125: aload_0
    //   126: invokevirtual abV : ()Lcom/laiqian/entity/aw;
    //   129: invokevirtual Jq : ()Z
    //   132: istore #50
    //   134: aload #59
    //   136: invokevirtual auW : ()Z
    //   139: istore #51
    //   141: aload_2
    //   142: invokestatic bz : (Landroid/content/Context;)Ljava/util/HashMap;
    //   145: ifnull -> 3563
    //   148: iconst_1
    //   149: istore #38
    //   151: goto -> 154
    //   154: aload_1
    //   155: astore #52
    //   157: aload_1
    //   158: ldc_w 'all'
    //   161: invokevirtual has : (Ljava/lang/String;)Z
    //   164: ifeq -> 3569
    //   167: ldc_w 'all'
    //   170: ldc_w '进来了all'
    //   173: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   176: pop
    //   177: aload_1
    //   178: ldc_w 'all'
    //   181: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   184: astore #52
    //   186: goto -> 3569
    //   189: iload #39
    //   191: aload #58
    //   193: arraylength
    //   194: if_icmpge -> 2926
    //   197: aload #52
    //   199: aload #58
    //   201: iconst_0
    //   202: aaload
    //   203: invokevirtual has : (Ljava/lang/String;)Z
    //   206: ifeq -> 261
    //   209: ldc 'tao'
    //   211: aload #58
    //   213: iload #39
    //   215: aaload
    //   216: invokevirtual equals : (Ljava/lang/Object;)Z
    //   219: ifeq -> 261
    //   222: aload #59
    //   224: invokevirtual aum : ()Ljava/lang/String;
    //   227: astore #54
    //   229: aload #54
    //   231: ifnull -> 3637
    //   234: new org/json/JSONObject
    //   237: dup
    //   238: aload #54
    //   240: invokespecial <init> : (Ljava/lang/String;)V
    //   243: astore_1
    //   244: goto -> 247
    //   247: aload #59
    //   249: aload #52
    //   251: invokevirtual toString : ()Ljava/lang/String;
    //   254: invokevirtual ri : (Ljava/lang/String;)Z
    //   257: pop
    //   258: goto -> 866
    //   261: aload #52
    //   263: aload #58
    //   265: iconst_1
    //   266: aaload
    //   267: invokevirtual has : (Ljava/lang/String;)Z
    //   270: ifeq -> 325
    //   273: ldc 'weixin'
    //   275: aload #58
    //   277: iload #39
    //   279: aaload
    //   280: invokevirtual equals : (Ljava/lang/Object;)Z
    //   283: ifeq -> 325
    //   286: aload #59
    //   288: invokevirtual aug : ()Ljava/lang/String;
    //   291: astore #54
    //   293: aload #54
    //   295: ifnull -> 3640
    //   298: new org/json/JSONObject
    //   301: dup
    //   302: aload #54
    //   304: invokespecial <init> : (Ljava/lang/String;)V
    //   307: astore_1
    //   308: goto -> 311
    //   311: aload #59
    //   313: aload #52
    //   315: invokevirtual toString : ()Ljava/lang/String;
    //   318: invokevirtual rc : (Ljava/lang/String;)Z
    //   321: pop
    //   322: goto -> 866
    //   325: aload #52
    //   327: aload #58
    //   329: iconst_2
    //   330: aaload
    //   331: invokevirtual has : (Ljava/lang/String;)Z
    //   334: ifeq -> 389
    //   337: ldc 'koubei'
    //   339: aload #58
    //   341: iload #39
    //   343: aaload
    //   344: invokevirtual equals : (Ljava/lang/Object;)Z
    //   347: ifeq -> 389
    //   350: aload #59
    //   352: invokevirtual auh : ()Ljava/lang/String;
    //   355: astore #54
    //   357: aload #54
    //   359: ifnull -> 3643
    //   362: new org/json/JSONObject
    //   365: dup
    //   366: aload #54
    //   368: invokespecial <init> : (Ljava/lang/String;)V
    //   371: astore_1
    //   372: goto -> 375
    //   375: aload #59
    //   377: aload #52
    //   379: invokevirtual toString : ()Ljava/lang/String;
    //   382: invokevirtual rd : (Ljava/lang/String;)Z
    //   385: pop
    //   386: goto -> 866
    //   389: aload #52
    //   391: aload #58
    //   393: iconst_3
    //   394: aaload
    //   395: invokevirtual has : (Ljava/lang/String;)Z
    //   398: ifeq -> 453
    //   401: ldc 'weixin_eat_in'
    //   403: aload #58
    //   405: iload #39
    //   407: aaload
    //   408: invokevirtual equals : (Ljava/lang/Object;)Z
    //   411: ifeq -> 453
    //   414: aload #59
    //   416: invokevirtual aui : ()Ljava/lang/String;
    //   419: astore #54
    //   421: aload #54
    //   423: ifnull -> 3646
    //   426: new org/json/JSONObject
    //   429: dup
    //   430: aload #54
    //   432: invokespecial <init> : (Ljava/lang/String;)V
    //   435: astore_1
    //   436: goto -> 439
    //   439: aload #59
    //   441: aload #52
    //   443: invokevirtual toString : ()Ljava/lang/String;
    //   446: invokevirtual re : (Ljava/lang/String;)Z
    //   449: pop
    //   450: goto -> 866
    //   453: aload #52
    //   455: aload #58
    //   457: iconst_4
    //   458: aaload
    //   459: invokevirtual has : (Ljava/lang/String;)Z
    //   462: ifeq -> 733
    //   465: ldc 'meituan'
    //   467: aload #58
    //   469: iload #39
    //   471: aaload
    //   472: invokevirtual equals : (Ljava/lang/Object;)Z
    //   475: ifeq -> 733
    //   478: aload #59
    //   480: invokevirtual auj : ()Ljava/lang/String;
    //   483: astore #54
    //   485: aload #54
    //   487: ifnull -> 3649
    //   490: new org/json/JSONObject
    //   493: dup
    //   494: aload #54
    //   496: invokespecial <init> : (Ljava/lang/String;)V
    //   499: astore_1
    //   500: goto -> 503
    //   503: aload #59
    //   505: aload #52
    //   507: invokevirtual toString : ()Ljava/lang/String;
    //   510: invokevirtual rf : (Ljava/lang/String;)Z
    //   513: pop
    //   514: new org/json/JSONObject
    //   517: dup
    //   518: aload #52
    //   520: aload #58
    //   522: iload #39
    //   524: aaload
    //   525: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   528: invokespecial <init> : (Ljava/lang/String;)V
    //   531: astore #54
    //   533: goto -> 539
    //   536: aconst_null
    //   537: astore #54
    //   539: aload #54
    //   541: ldc_w 'cancel'
    //   544: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   547: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   550: ifne -> 3652
    //   553: new org/json/JSONArray
    //   556: dup
    //   557: aload #54
    //   559: ldc_w 'cancel'
    //   562: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   565: invokespecial <init> : (Ljava/lang/String;)V
    //   568: astore #55
    //   570: aload #55
    //   572: ifnull -> 611
    //   575: iconst_0
    //   576: istore #5
    //   578: iload #5
    //   580: aload #55
    //   582: invokevirtual length : ()I
    //   585: if_icmpge -> 611
    //   588: aload_0
    //   589: aload #55
    //   591: iload #5
    //   593: invokevirtual get : (I)Ljava/lang/Object;
    //   596: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   599: invokespecial oQ : (Ljava/lang/String;)V
    //   602: iload #5
    //   604: iconst_1
    //   605: iadd
    //   606: istore #5
    //   608: goto -> 578
    //   611: aload #54
    //   613: ldc_w 'phoneNumber'
    //   616: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   619: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   622: ifne -> 3661
    //   625: new org/json/JSONArray
    //   628: dup
    //   629: aload #54
    //   631: ldc_w 'phoneNumber'
    //   634: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   637: invokespecial <init> : (Ljava/lang/String;)V
    //   640: astore #54
    //   642: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   645: astore #55
    //   647: aload #54
    //   649: ifnull -> 3655
    //   652: aload #54
    //   654: invokevirtual length : ()I
    //   657: ifle -> 3655
    //   660: iconst_1
    //   661: istore #49
    //   663: goto -> 666
    //   666: aload #55
    //   668: iload #49
    //   670: invokevirtual hX : (Z)Z
    //   673: pop
    //   674: aload #54
    //   676: ifnull -> 3661
    //   679: ldc_w '[]'
    //   682: aload #54
    //   684: invokevirtual toString : ()Ljava/lang/String;
    //   687: invokevirtual equals : (Ljava/lang/Object;)Z
    //   690: ifne -> 3661
    //   693: ldc_w 'newMeituanPhoneOrderErrorOrders'
    //   696: aload #54
    //   698: invokevirtual toString : ()Ljava/lang/String;
    //   701: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   704: pop
    //   705: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   708: aload #54
    //   710: invokevirtual toString : ()Ljava/lang/String;
    //   713: invokevirtual rI : (Ljava/lang/String;)V
    //   716: aload_2
    //   717: new android/content/Intent
    //   720: dup
    //   721: ldc_w 'action_meituan_phone_number_error_orders'
    //   724: invokespecial <init> : (Ljava/lang/String;)V
    //   727: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   730: goto -> 3661
    //   733: aload #52
    //   735: aload #58
    //   737: iconst_5
    //   738: aaload
    //   739: invokevirtual has : (Ljava/lang/String;)Z
    //   742: ifeq -> 794
    //   745: aload #58
    //   747: iload #39
    //   749: aaload
    //   750: ldc_w 'phone_order'
    //   753: if_acmpne -> 794
    //   756: aload #59
    //   758: invokevirtual aul : ()Ljava/lang/String;
    //   761: ifnull -> 3664
    //   764: new org/json/JSONObject
    //   767: dup
    //   768: aload #59
    //   770: invokevirtual aul : ()Ljava/lang/String;
    //   773: invokespecial <init> : (Ljava/lang/String;)V
    //   776: astore_1
    //   777: goto -> 780
    //   780: aload #59
    //   782: aload #52
    //   784: invokevirtual toString : ()Ljava/lang/String;
    //   787: invokevirtual rh : (Ljava/lang/String;)Z
    //   790: pop
    //   791: goto -> 866
    //   794: aload_1
    //   795: astore #54
    //   797: aload #52
    //   799: aload #58
    //   801: bipush #6
    //   803: aaload
    //   804: invokevirtual has : (Ljava/lang/String;)Z
    //   807: ifeq -> 863
    //   810: aload_1
    //   811: astore #54
    //   813: ldc_w 'eleme'
    //   816: aload #58
    //   818: iload #39
    //   820: aaload
    //   821: invokevirtual equals : (Ljava/lang/Object;)Z
    //   824: ifeq -> 863
    //   827: aload #59
    //   829: invokevirtual auk : ()Ljava/lang/String;
    //   832: astore #54
    //   834: aload #54
    //   836: ifnull -> 849
    //   839: new org/json/JSONObject
    //   842: dup
    //   843: aload #54
    //   845: invokespecial <init> : (Ljava/lang/String;)V
    //   848: astore_1
    //   849: aload #59
    //   851: aload #52
    //   853: invokevirtual toString : ()Ljava/lang/String;
    //   856: invokevirtual rg : (Ljava/lang/String;)Z
    //   859: pop
    //   860: aload_1
    //   861: astore #54
    //   863: aload #54
    //   865: astore_1
    //   866: aload #52
    //   868: ifnull -> 937
    //   871: new org/json/JSONObject
    //   874: dup
    //   875: aload #52
    //   877: aload #58
    //   879: iload #39
    //   881: aaload
    //   882: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   885: invokespecial <init> : (Ljava/lang/String;)V
    //   888: astore #54
    //   890: new java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial <init> : ()V
    //   897: astore #55
    //   899: aload #55
    //   901: ldc_w 'newTypeMap:'
    //   904: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload #55
    //   910: aload #54
    //   912: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   915: pop
    //   916: ldc_w 'test'
    //   919: aload #55
    //   921: invokevirtual toString : ()Ljava/lang/String;
    //   924: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   927: pop
    //   928: goto -> 940
    //   931: aconst_null
    //   932: astore #54
    //   934: goto -> 940
    //   937: goto -> 931
    //   940: aload_1
    //   941: ifnull -> 1009
    //   944: new org/json/JSONObject
    //   947: dup
    //   948: aload_1
    //   949: aload #58
    //   951: iload #39
    //   953: aaload
    //   954: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   957: invokespecial <init> : (Ljava/lang/String;)V
    //   960: astore #55
    //   962: new java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial <init> : ()V
    //   969: astore #56
    //   971: aload #56
    //   973: ldc_w 'oldTypeMap:'
    //   976: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: aload #56
    //   982: aload #55
    //   984: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: ldc_w 'test'
    //   991: aload #56
    //   993: invokevirtual toString : ()Ljava/lang/String;
    //   996: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   999: pop
    //   1000: goto -> 1012
    //   1003: aconst_null
    //   1004: astore #55
    //   1006: goto -> 1012
    //   1009: goto -> 1003
    //   1012: iconst_0
    //   1013: istore #45
    //   1015: iload #21
    //   1017: istore #15
    //   1019: aload #54
    //   1021: astore #56
    //   1023: aload #53
    //   1025: arraylength
    //   1026: istore #5
    //   1028: iload #45
    //   1030: iload #5
    //   1032: if_icmpge -> 2899
    //   1035: aload #56
    //   1037: ifnull -> 1062
    //   1040: new org/json/JSONArray
    //   1043: dup
    //   1044: aload #56
    //   1046: aload #53
    //   1048: iload #45
    //   1050: aaload
    //   1051: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1054: invokespecial <init> : (Ljava/lang/String;)V
    //   1057: astore #57
    //   1059: goto -> 1065
    //   1062: aconst_null
    //   1063: astore #57
    //   1065: aload #55
    //   1067: ifnull -> 1150
    //   1070: new org/json/JSONArray
    //   1073: dup
    //   1074: aload #55
    //   1076: aload #53
    //   1078: iload #45
    //   1080: aaload
    //   1081: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   1084: invokespecial <init> : (Ljava/lang/String;)V
    //   1087: astore #54
    //   1089: new java/lang/StringBuilder
    //   1092: dup
    //   1093: invokespecial <init> : ()V
    //   1096: astore #60
    //   1098: aload #60
    //   1100: ldc_w 'oldTypeMap:'
    //   1103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: pop
    //   1107: aload #60
    //   1109: aload #55
    //   1111: aload #53
    //   1113: iload #45
    //   1115: aaload
    //   1116: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   1119: invokevirtual toString : ()Ljava/lang/String;
    //   1122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: pop
    //   1126: ldc_w 'waimai'
    //   1129: aload #60
    //   1131: invokevirtual toString : ()Ljava/lang/String;
    //   1134: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1137: pop
    //   1138: goto -> 1153
    //   1141: goto -> 1144
    //   1144: aconst_null
    //   1145: astore #54
    //   1147: goto -> 1153
    //   1150: aconst_null
    //   1151: astore #54
    //   1153: aload #57
    //   1155: aload #54
    //   1157: invokestatic a : (Lorg/json/JSONArray;Lorg/json/JSONArray;)I
    //   1160: istore #47
    //   1162: iload #14
    //   1164: istore #37
    //   1166: iload #13
    //   1168: istore #36
    //   1170: iload #12
    //   1172: istore #35
    //   1174: iload #11
    //   1176: istore #34
    //   1178: iload #10
    //   1180: istore #33
    //   1182: iload #9
    //   1184: istore #32
    //   1186: iload #7
    //   1188: istore #31
    //   1190: iload #8
    //   1192: istore #30
    //   1194: iload #6
    //   1196: istore #5
    //   1198: new java/lang/StringBuilder
    //   1201: dup
    //   1202: invokespecial <init> : ()V
    //   1205: astore #60
    //   1207: iload #14
    //   1209: istore #37
    //   1211: iload #13
    //   1213: istore #36
    //   1215: iload #12
    //   1217: istore #35
    //   1219: iload #11
    //   1221: istore #34
    //   1223: iload #10
    //   1225: istore #33
    //   1227: iload #9
    //   1229: istore #32
    //   1231: iload #7
    //   1233: istore #31
    //   1235: iload #8
    //   1237: istore #30
    //   1239: iload #6
    //   1241: istore #5
    //   1243: aload #60
    //   1245: ldc_w 'newOrders:'
    //   1248: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: pop
    //   1252: iload #14
    //   1254: istore #37
    //   1256: iload #13
    //   1258: istore #36
    //   1260: iload #12
    //   1262: istore #35
    //   1264: iload #11
    //   1266: istore #34
    //   1268: iload #10
    //   1270: istore #33
    //   1272: iload #9
    //   1274: istore #32
    //   1276: iload #7
    //   1278: istore #31
    //   1280: iload #8
    //   1282: istore #30
    //   1284: iload #6
    //   1286: istore #5
    //   1288: aload #60
    //   1290: aload #57
    //   1292: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: iload #14
    //   1298: istore #37
    //   1300: iload #13
    //   1302: istore #36
    //   1304: iload #12
    //   1306: istore #35
    //   1308: iload #11
    //   1310: istore #34
    //   1312: iload #10
    //   1314: istore #33
    //   1316: iload #9
    //   1318: istore #32
    //   1320: iload #7
    //   1322: istore #31
    //   1324: iload #8
    //   1326: istore #30
    //   1328: iload #6
    //   1330: istore #5
    //   1332: ldc_w 'waimai'
    //   1335: aload #60
    //   1337: invokevirtual toString : ()Ljava/lang/String;
    //   1340: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1343: pop
    //   1344: iload #14
    //   1346: istore #37
    //   1348: iload #13
    //   1350: istore #36
    //   1352: iload #12
    //   1354: istore #35
    //   1356: iload #11
    //   1358: istore #34
    //   1360: iload #10
    //   1362: istore #33
    //   1364: iload #9
    //   1366: istore #32
    //   1368: iload #7
    //   1370: istore #31
    //   1372: iload #8
    //   1374: istore #30
    //   1376: iload #6
    //   1378: istore #5
    //   1380: new java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial <init> : ()V
    //   1387: astore #60
    //   1389: iload #14
    //   1391: istore #37
    //   1393: iload #13
    //   1395: istore #36
    //   1397: iload #12
    //   1399: istore #35
    //   1401: iload #11
    //   1403: istore #34
    //   1405: iload #10
    //   1407: istore #33
    //   1409: iload #9
    //   1411: istore #32
    //   1413: iload #7
    //   1415: istore #31
    //   1417: iload #8
    //   1419: istore #30
    //   1421: iload #6
    //   1423: istore #5
    //   1425: aload #60
    //   1427: ldc_w 'oldOrders:'
    //   1430: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: pop
    //   1434: iload #14
    //   1436: istore #37
    //   1438: iload #13
    //   1440: istore #36
    //   1442: iload #12
    //   1444: istore #35
    //   1446: iload #11
    //   1448: istore #34
    //   1450: iload #10
    //   1452: istore #33
    //   1454: iload #9
    //   1456: istore #32
    //   1458: iload #7
    //   1460: istore #31
    //   1462: iload #8
    //   1464: istore #30
    //   1466: iload #6
    //   1468: istore #5
    //   1470: aload #60
    //   1472: aload #54
    //   1474: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1477: pop
    //   1478: iload #14
    //   1480: istore #37
    //   1482: iload #13
    //   1484: istore #36
    //   1486: iload #12
    //   1488: istore #35
    //   1490: iload #11
    //   1492: istore #34
    //   1494: iload #10
    //   1496: istore #33
    //   1498: iload #9
    //   1500: istore #32
    //   1502: iload #7
    //   1504: istore #31
    //   1506: iload #8
    //   1508: istore #30
    //   1510: iload #6
    //   1512: istore #5
    //   1514: ldc_w 'waimai'
    //   1517: aload #60
    //   1519: invokevirtual toString : ()Ljava/lang/String;
    //   1522: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1525: pop
    //   1526: iload #14
    //   1528: istore #37
    //   1530: iload #13
    //   1532: istore #36
    //   1534: iload #12
    //   1536: istore #35
    //   1538: iload #11
    //   1540: istore #34
    //   1542: iload #10
    //   1544: istore #33
    //   1546: iload #9
    //   1548: istore #32
    //   1550: iload #7
    //   1552: istore #31
    //   1554: iload #8
    //   1556: istore #30
    //   1558: iload #6
    //   1560: istore #5
    //   1562: new java/lang/StringBuilder
    //   1565: dup
    //   1566: invokespecial <init> : ()V
    //   1569: astore #60
    //   1571: iload #14
    //   1573: istore #37
    //   1575: iload #13
    //   1577: istore #36
    //   1579: iload #12
    //   1581: istore #35
    //   1583: iload #11
    //   1585: istore #34
    //   1587: iload #10
    //   1589: istore #33
    //   1591: iload #9
    //   1593: istore #32
    //   1595: iload #7
    //   1597: istore #31
    //   1599: iload #8
    //   1601: istore #30
    //   1603: iload #6
    //   1605: istore #5
    //   1607: aload #60
    //   1609: ldc_w 'nNewStatus:'
    //   1612: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: pop
    //   1616: iload #14
    //   1618: istore #37
    //   1620: iload #13
    //   1622: istore #36
    //   1624: iload #12
    //   1626: istore #35
    //   1628: iload #11
    //   1630: istore #34
    //   1632: iload #10
    //   1634: istore #33
    //   1636: iload #9
    //   1638: istore #32
    //   1640: iload #7
    //   1642: istore #31
    //   1644: iload #8
    //   1646: istore #30
    //   1648: iload #6
    //   1650: istore #5
    //   1652: aload #60
    //   1654: iload #47
    //   1656: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1659: pop
    //   1660: iload #14
    //   1662: istore #37
    //   1664: iload #13
    //   1666: istore #36
    //   1668: iload #12
    //   1670: istore #35
    //   1672: iload #11
    //   1674: istore #34
    //   1676: iload #10
    //   1678: istore #33
    //   1680: iload #9
    //   1682: istore #32
    //   1684: iload #7
    //   1686: istore #31
    //   1688: iload #8
    //   1690: istore #30
    //   1692: iload #6
    //   1694: istore #5
    //   1696: ldc_w 'waimai'
    //   1699: aload #60
    //   1701: invokevirtual toString : ()Ljava/lang/String;
    //   1704: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   1707: pop
    //   1708: aload #57
    //   1710: ifnull -> 1763
    //   1713: iload #14
    //   1715: istore #37
    //   1717: iload #13
    //   1719: istore #36
    //   1721: iload #12
    //   1723: istore #35
    //   1725: iload #11
    //   1727: istore #34
    //   1729: iload #10
    //   1731: istore #33
    //   1733: iload #9
    //   1735: istore #32
    //   1737: iload #7
    //   1739: istore #31
    //   1741: iload #8
    //   1743: istore #30
    //   1745: iload #6
    //   1747: istore #5
    //   1749: aload #57
    //   1751: invokevirtual length : ()I
    //   1754: istore #21
    //   1756: iload #21
    //   1758: istore #5
    //   1760: goto -> 1766
    //   1763: iconst_0
    //   1764: istore #5
    //   1766: iload #39
    //   1768: ifne -> 1819
    //   1771: iload #45
    //   1773: ifne -> 1819
    //   1776: iload #5
    //   1778: istore #25
    //   1780: iload #5
    //   1782: istore #46
    //   1784: iload #14
    //   1786: istore #21
    //   1788: iload #13
    //   1790: istore #22
    //   1792: iload #12
    //   1794: istore #23
    //   1796: iload #11
    //   1798: istore #24
    //   1800: iload #9
    //   1802: istore #26
    //   1804: iload #7
    //   1806: istore #27
    //   1808: iload #8
    //   1810: istore #28
    //   1812: iload #6
    //   1814: istore #29
    //   1816: goto -> 2383
    //   1819: iload #39
    //   1821: iconst_1
    //   1822: if_icmpne -> 1873
    //   1825: iload #45
    //   1827: ifne -> 1873
    //   1830: iload #5
    //   1832: istore #22
    //   1834: iload #5
    //   1836: istore #46
    //   1838: iload #14
    //   1840: istore #21
    //   1842: iload #12
    //   1844: istore #23
    //   1846: iload #11
    //   1848: istore #24
    //   1850: iload #10
    //   1852: istore #25
    //   1854: iload #9
    //   1856: istore #26
    //   1858: iload #7
    //   1860: istore #27
    //   1862: iload #8
    //   1864: istore #28
    //   1866: iload #6
    //   1868: istore #29
    //   1870: goto -> 2383
    //   1873: iload #39
    //   1875: iconst_2
    //   1876: if_icmpne -> 1927
    //   1879: iload #45
    //   1881: ifne -> 1927
    //   1884: iload #5
    //   1886: istore #24
    //   1888: iload #5
    //   1890: istore #46
    //   1892: iload #14
    //   1894: istore #21
    //   1896: iload #13
    //   1898: istore #22
    //   1900: iload #12
    //   1902: istore #23
    //   1904: iload #10
    //   1906: istore #25
    //   1908: iload #9
    //   1910: istore #26
    //   1912: iload #7
    //   1914: istore #27
    //   1916: iload #8
    //   1918: istore #28
    //   1920: iload #6
    //   1922: istore #29
    //   1924: goto -> 2383
    //   1927: iload #39
    //   1929: iconst_3
    //   1930: if_icmpne -> 1981
    //   1933: iload #45
    //   1935: ifne -> 1981
    //   1938: iload #5
    //   1940: istore #23
    //   1942: iload #5
    //   1944: istore #46
    //   1946: iload #14
    //   1948: istore #21
    //   1950: iload #13
    //   1952: istore #22
    //   1954: iload #11
    //   1956: istore #24
    //   1958: iload #10
    //   1960: istore #25
    //   1962: iload #9
    //   1964: istore #26
    //   1966: iload #7
    //   1968: istore #27
    //   1970: iload #8
    //   1972: istore #28
    //   1974: iload #6
    //   1976: istore #29
    //   1978: goto -> 2383
    //   1981: iload #39
    //   1983: iconst_4
    //   1984: if_icmpne -> 2035
    //   1987: iload #45
    //   1989: ifne -> 2035
    //   1992: iload #5
    //   1994: istore #26
    //   1996: iload #5
    //   1998: istore #46
    //   2000: iload #14
    //   2002: istore #21
    //   2004: iload #13
    //   2006: istore #22
    //   2008: iload #12
    //   2010: istore #23
    //   2012: iload #11
    //   2014: istore #24
    //   2016: iload #10
    //   2018: istore #25
    //   2020: iload #7
    //   2022: istore #27
    //   2024: iload #8
    //   2026: istore #28
    //   2028: iload #6
    //   2030: istore #29
    //   2032: goto -> 2383
    //   2035: iload #39
    //   2037: iconst_4
    //   2038: if_icmpne -> 2121
    //   2041: iload #45
    //   2043: iconst_1
    //   2044: if_icmpne -> 2121
    //   2047: aload #59
    //   2049: invokevirtual aqA : ()I
    //   2052: istore #7
    //   2054: iload #7
    //   2056: iload #5
    //   2058: iadd
    //   2059: istore #21
    //   2061: iload #5
    //   2063: istore #7
    //   2065: iload #21
    //   2067: istore #5
    //   2069: iload #5
    //   2071: istore #46
    //   2073: iload #14
    //   2075: istore #21
    //   2077: iload #13
    //   2079: istore #22
    //   2081: iload #12
    //   2083: istore #23
    //   2085: iload #11
    //   2087: istore #24
    //   2089: iload #10
    //   2091: istore #25
    //   2093: iload #9
    //   2095: istore #26
    //   2097: iload #7
    //   2099: istore #27
    //   2101: iload #8
    //   2103: istore #28
    //   2105: iload #6
    //   2107: istore #29
    //   2109: goto -> 2383
    //   2112: astore #54
    //   2114: iload #5
    //   2116: istore #7
    //   2118: goto -> 2912
    //   2121: iload #39
    //   2123: iconst_5
    //   2124: if_icmpne -> 2133
    //   2127: iconst_1
    //   2128: istore #21
    //   2130: goto -> 2136
    //   2133: iconst_0
    //   2134: istore #21
    //   2136: iload #45
    //   2138: ifne -> 2147
    //   2141: iconst_1
    //   2142: istore #22
    //   2144: goto -> 2150
    //   2147: iconst_0
    //   2148: istore #22
    //   2150: iload #21
    //   2152: iload #22
    //   2154: iand
    //   2155: ifeq -> 2201
    //   2158: iload #5
    //   2160: istore #21
    //   2162: iload #5
    //   2164: istore #46
    //   2166: iload #13
    //   2168: istore #22
    //   2170: iload #12
    //   2172: istore #23
    //   2174: iload #11
    //   2176: istore #24
    //   2178: iload #10
    //   2180: istore #25
    //   2182: iload #9
    //   2184: istore #26
    //   2186: iload #7
    //   2188: istore #27
    //   2190: iload #8
    //   2192: istore #28
    //   2194: iload #6
    //   2196: istore #29
    //   2198: goto -> 2383
    //   2201: iload #39
    //   2203: bipush #6
    //   2205: if_icmpne -> 2256
    //   2208: iload #45
    //   2210: ifne -> 2256
    //   2213: iload #5
    //   2215: istore #28
    //   2217: iload #5
    //   2219: istore #46
    //   2221: iload #14
    //   2223: istore #21
    //   2225: iload #13
    //   2227: istore #22
    //   2229: iload #12
    //   2231: istore #23
    //   2233: iload #11
    //   2235: istore #24
    //   2237: iload #10
    //   2239: istore #25
    //   2241: iload #9
    //   2243: istore #26
    //   2245: iload #7
    //   2247: istore #27
    //   2249: iload #6
    //   2251: istore #29
    //   2253: goto -> 2383
    //   2256: iload #5
    //   2258: istore #46
    //   2260: iload #14
    //   2262: istore #21
    //   2264: iload #13
    //   2266: istore #22
    //   2268: iload #12
    //   2270: istore #23
    //   2272: iload #11
    //   2274: istore #24
    //   2276: iload #10
    //   2278: istore #25
    //   2280: iload #9
    //   2282: istore #26
    //   2284: iload #7
    //   2286: istore #27
    //   2288: iload #8
    //   2290: istore #28
    //   2292: iload #6
    //   2294: istore #29
    //   2296: iload #39
    //   2298: bipush #6
    //   2300: if_icmpne -> 2383
    //   2303: iload #5
    //   2305: istore #46
    //   2307: iload #14
    //   2309: istore #21
    //   2311: iload #13
    //   2313: istore #22
    //   2315: iload #12
    //   2317: istore #23
    //   2319: iload #11
    //   2321: istore #24
    //   2323: iload #10
    //   2325: istore #25
    //   2327: iload #9
    //   2329: istore #26
    //   2331: iload #7
    //   2333: istore #27
    //   2335: iload #8
    //   2337: istore #28
    //   2339: iload #6
    //   2341: istore #29
    //   2343: iload #45
    //   2345: iconst_1
    //   2346: if_icmpne -> 2383
    //   2349: aload #59
    //   2351: invokevirtual aqA : ()I
    //   2354: istore #6
    //   2356: iload #6
    //   2358: iload #5
    //   2360: iadd
    //   2361: istore #21
    //   2363: iload #5
    //   2365: istore #6
    //   2367: iload #21
    //   2369: istore #5
    //   2371: goto -> 2069
    //   2374: astore #54
    //   2376: iload #5
    //   2378: istore #6
    //   2380: goto -> 2912
    //   2383: iload #45
    //   2385: ifne -> 2588
    //   2388: aload #54
    //   2390: ifnull -> 2409
    //   2393: aload #57
    //   2395: invokevirtual length : ()I
    //   2398: aload #54
    //   2400: invokevirtual length : ()I
    //   2403: if_icmpeq -> 3673
    //   2406: goto -> 3667
    //   2409: iload #16
    //   2411: istore #5
    //   2413: aload #57
    //   2415: ifnull -> 2478
    //   2418: aload #57
    //   2420: invokevirtual length : ()I
    //   2423: istore #5
    //   2425: iload #5
    //   2427: ifle -> 3673
    //   2430: goto -> 3667
    //   2433: iload #21
    //   2435: istore #37
    //   2437: iload #22
    //   2439: istore #36
    //   2441: iload #23
    //   2443: istore #35
    //   2445: iload #24
    //   2447: istore #34
    //   2449: iload #25
    //   2451: istore #33
    //   2453: iload #26
    //   2455: istore #32
    //   2457: iload #27
    //   2459: istore #31
    //   2461: iload #28
    //   2463: istore #30
    //   2465: iload #29
    //   2467: istore #5
    //   2469: aload #54
    //   2471: invokestatic e : (Ljava/lang/Throwable;)V
    //   2474: iload #16
    //   2476: istore #5
    //   2478: iload #39
    //   2480: ifne -> 2493
    //   2483: iload #20
    //   2485: iload #47
    //   2487: iadd
    //   2488: istore #20
    //   2490: goto -> 2550
    //   2493: iload #39
    //   2495: iconst_1
    //   2496: if_icmpne -> 2509
    //   2499: iload #19
    //   2501: iload #47
    //   2503: iadd
    //   2504: istore #19
    //   2506: goto -> 2550
    //   2509: iload #39
    //   2511: iconst_2
    //   2512: if_icmpne -> 2525
    //   2515: iload #18
    //   2517: iload #47
    //   2519: iadd
    //   2520: istore #18
    //   2522: goto -> 2550
    //   2525: iload #39
    //   2527: iconst_3
    //   2528: if_icmpne -> 2541
    //   2531: iload #17
    //   2533: iload #47
    //   2535: iadd
    //   2536: istore #17
    //   2538: goto -> 2550
    //   2541: iload #39
    //   2543: iconst_4
    //   2544: if_icmpne -> 2550
    //   2547: goto -> 2550
    //   2550: iload #41
    //   2552: iload #46
    //   2554: iadd
    //   2555: istore #30
    //   2557: iload #20
    //   2559: istore #6
    //   2561: iload #44
    //   2563: istore #7
    //   2565: iload #19
    //   2567: istore #8
    //   2569: iload #18
    //   2571: istore #9
    //   2573: iload #17
    //   2575: istore #10
    //   2577: iload #40
    //   2579: istore #31
    //   2581: iload #15
    //   2583: istore #32
    //   2585: goto -> 2762
    //   2588: iload #20
    //   2590: istore #6
    //   2592: iload #44
    //   2594: istore #7
    //   2596: iload #19
    //   2598: istore #8
    //   2600: iload #18
    //   2602: istore #9
    //   2604: iload #17
    //   2606: istore #10
    //   2608: iload #41
    //   2610: istore #30
    //   2612: iload #40
    //   2614: istore #31
    //   2616: iload #16
    //   2618: istore #5
    //   2620: iload #15
    //   2622: istore #32
    //   2624: iload #45
    //   2626: iconst_1
    //   2627: if_icmpne -> 2762
    //   2630: aload #54
    //   2632: ifnull -> 2651
    //   2635: aload #57
    //   2637: invokevirtual length : ()I
    //   2640: aload #54
    //   2642: invokevirtual length : ()I
    //   2645: if_icmpeq -> 3690
    //   2648: goto -> 3684
    //   2651: iload #15
    //   2653: istore #5
    //   2655: aload #57
    //   2657: ifnull -> 2720
    //   2660: aload #57
    //   2662: invokevirtual length : ()I
    //   2665: istore #5
    //   2667: iload #5
    //   2669: ifle -> 3690
    //   2672: goto -> 3684
    //   2675: iload #21
    //   2677: istore #37
    //   2679: iload #22
    //   2681: istore #36
    //   2683: iload #23
    //   2685: istore #35
    //   2687: iload #24
    //   2689: istore #34
    //   2691: iload #25
    //   2693: istore #33
    //   2695: iload #26
    //   2697: istore #32
    //   2699: iload #27
    //   2701: istore #31
    //   2703: iload #28
    //   2705: istore #30
    //   2707: iload #29
    //   2709: istore #5
    //   2711: aload #54
    //   2713: invokestatic e : (Ljava/lang/Throwable;)V
    //   2716: iload #15
    //   2718: istore #5
    //   2720: iload #44
    //   2722: iload #47
    //   2724: iadd
    //   2725: istore #7
    //   2727: iload #40
    //   2729: iload #46
    //   2731: iadd
    //   2732: istore #31
    //   2734: iload #5
    //   2736: istore #32
    //   2738: iload #16
    //   2740: istore #5
    //   2742: iload #41
    //   2744: istore #30
    //   2746: iload #17
    //   2748: istore #10
    //   2750: iload #18
    //   2752: istore #9
    //   2754: iload #19
    //   2756: istore #8
    //   2758: iload #20
    //   2760: istore #6
    //   2762: iload #43
    //   2764: iload #47
    //   2766: iadd
    //   2767: istore #43
    //   2769: iload #42
    //   2771: iload #46
    //   2773: iadd
    //   2774: istore #42
    //   2776: iload #45
    //   2778: iconst_1
    //   2779: iadd
    //   2780: istore #45
    //   2782: iload #6
    //   2784: istore #20
    //   2786: iload #7
    //   2788: istore #44
    //   2790: iload #8
    //   2792: istore #19
    //   2794: iload #9
    //   2796: istore #18
    //   2798: iload #10
    //   2800: istore #17
    //   2802: iload #21
    //   2804: istore #14
    //   2806: iload #22
    //   2808: istore #13
    //   2810: iload #23
    //   2812: istore #12
    //   2814: iload #24
    //   2816: istore #11
    //   2818: iload #25
    //   2820: istore #10
    //   2822: iload #26
    //   2824: istore #9
    //   2826: iload #27
    //   2828: istore #7
    //   2830: iload #28
    //   2832: istore #8
    //   2834: iload #29
    //   2836: istore #6
    //   2838: iload #30
    //   2840: istore #41
    //   2842: iload #31
    //   2844: istore #40
    //   2846: iload #5
    //   2848: istore #16
    //   2850: iload #32
    //   2852: istore #15
    //   2854: goto -> 1023
    //   2857: astore #54
    //   2859: iload #37
    //   2861: istore #14
    //   2863: iload #36
    //   2865: istore #13
    //   2867: iload #35
    //   2869: istore #12
    //   2871: iload #34
    //   2873: istore #11
    //   2875: iload #33
    //   2877: istore #10
    //   2879: iload #32
    //   2881: istore #9
    //   2883: iload #31
    //   2885: istore #7
    //   2887: iload #30
    //   2889: istore #8
    //   2891: goto -> 2908
    //   2894: astore #54
    //   2896: goto -> 2904
    //   2899: goto -> 3701
    //   2902: astore #54
    //   2904: iload #6
    //   2906: istore #5
    //   2908: iload #5
    //   2910: istore #6
    //   2912: ldc_w 'TDDException'
    //   2915: aload #54
    //   2917: invokevirtual toString : ()Ljava/lang/String;
    //   2920: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   2923: goto -> 3701
    //   2926: iload_3
    //   2927: ifeq -> 3717
    //   2930: iload #43
    //   2932: ifle -> 3717
    //   2935: getstatic com/laiqian/takeaway/R$raw.sound_new_orders : I
    //   2938: istore #5
    //   2940: iload #20
    //   2942: istore #22
    //   2944: iload #22
    //   2946: ifle -> 3714
    //   2949: iload #44
    //   2951: ifle -> 2962
    //   2954: getstatic com/laiqian/takeaway/R$raw.sound_new_orders : I
    //   2957: istore #5
    //   2959: goto -> 2962
    //   2962: iload #5
    //   2964: istore #15
    //   2966: iload #15
    //   2968: istore #5
    //   2970: iload #19
    //   2972: iload #43
    //   2974: if_icmpne -> 2991
    //   2977: iload #15
    //   2979: istore #5
    //   2981: iload #50
    //   2983: ifeq -> 2991
    //   2986: getstatic com/laiqian/takeaway/R$raw.sound_new_orders : I
    //   2989: istore #5
    //   2991: iload #5
    //   2993: istore #15
    //   2995: iload #22
    //   2997: iload #43
    //   2999: if_icmpne -> 3016
    //   3002: iload #5
    //   3004: istore #15
    //   3006: iload #38
    //   3008: ifeq -> 3016
    //   3011: getstatic com/laiqian/takeaway/R$raw.sound_new_orders : I
    //   3014: istore #15
    //   3016: iload #15
    //   3018: istore #5
    //   3020: iload #18
    //   3022: iload #43
    //   3024: if_icmpne -> 3041
    //   3027: iload #15
    //   3029: istore #5
    //   3031: iload #51
    //   3033: ifeq -> 3041
    //   3036: getstatic com/laiqian/takeaway/R$raw.sound_new_orders : I
    //   3039: istore #5
    //   3041: iload #17
    //   3043: iload #43
    //   3045: if_icmpne -> 3053
    //   3048: getstatic com/laiqian/takeaway/R$raw.sound_new_orders : I
    //   3051: istore #5
    //   3053: iload #44
    //   3055: iload #43
    //   3057: if_icmpne -> 3065
    //   3060: getstatic com/laiqian/takeaway/R$raw.sound_new_orders_return : I
    //   3063: istore #5
    //   3065: new java/lang/StringBuilder
    //   3068: dup
    //   3069: invokespecial <init> : ()V
    //   3072: astore_1
    //   3073: aload_1
    //   3074: ldc_w 'nTotleUntreatedNums'
    //   3077: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3080: pop
    //   3081: aload_1
    //   3082: iload #42
    //   3084: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   3087: pop
    //   3088: ldc_w '外卖'
    //   3091: aload_1
    //   3092: invokevirtual toString : ()Ljava/lang/String;
    //   3095: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   3098: aload_0
    //   3099: getfield bpc : Lcom/laiqian/util/bq;
    //   3102: ifnonnull -> 3117
    //   3105: aload_0
    //   3106: new com/laiqian/util/bq
    //   3109: dup
    //   3110: aload_2
    //   3111: invokespecial <init> : (Landroid/content/Context;)V
    //   3114: putfield bpc : Lcom/laiqian/util/bq;
    //   3117: iload #5
    //   3119: ifeq -> 3134
    //   3122: aload_0
    //   3123: getfield bpc : Lcom/laiqian/util/bq;
    //   3126: iload #5
    //   3128: invokevirtual mi : (I)V
    //   3131: goto -> 3134
    //   3134: iconst_0
    //   3135: istore #49
    //   3137: aload #52
    //   3139: aload #58
    //   3141: iconst_0
    //   3142: aaload
    //   3143: invokevirtual has : (Ljava/lang/String;)Z
    //   3146: ifeq -> 3157
    //   3149: aload #59
    //   3151: iload #10
    //   3153: invokevirtual lJ : (I)Z
    //   3156: pop
    //   3157: aload #52
    //   3159: aload #58
    //   3161: iconst_1
    //   3162: aaload
    //   3163: invokevirtual has : (Ljava/lang/String;)Z
    //   3166: ifeq -> 3177
    //   3169: aload #59
    //   3171: iload #13
    //   3173: invokevirtual lD : (I)Z
    //   3176: pop
    //   3177: aload #52
    //   3179: aload #58
    //   3181: iconst_2
    //   3182: aaload
    //   3183: invokevirtual has : (Ljava/lang/String;)Z
    //   3186: ifeq -> 3197
    //   3189: aload #59
    //   3191: iload #11
    //   3193: invokevirtual lI : (I)Z
    //   3196: pop
    //   3197: aload #52
    //   3199: aload #58
    //   3201: iconst_3
    //   3202: aaload
    //   3203: invokevirtual has : (Ljava/lang/String;)Z
    //   3206: ifeq -> 3217
    //   3209: aload #59
    //   3211: iload #12
    //   3213: invokevirtual lK : (I)Z
    //   3216: pop
    //   3217: aload #52
    //   3219: aload #58
    //   3221: iconst_4
    //   3222: aaload
    //   3223: invokevirtual has : (Ljava/lang/String;)Z
    //   3226: ifeq -> 3245
    //   3229: aload #59
    //   3231: iload #9
    //   3233: invokevirtual lE : (I)Z
    //   3236: pop
    //   3237: aload #59
    //   3239: iload #7
    //   3241: invokevirtual lF : (I)Z
    //   3244: pop
    //   3245: aload #52
    //   3247: aload #58
    //   3249: iconst_5
    //   3250: aaload
    //   3251: invokevirtual has : (Ljava/lang/String;)Z
    //   3254: ifeq -> 3265
    //   3257: aload #59
    //   3259: iload #14
    //   3261: invokevirtual lN : (I)Z
    //   3264: pop
    //   3265: aload #52
    //   3267: aload #58
    //   3269: bipush #6
    //   3271: aaload
    //   3272: invokevirtual has : (Ljava/lang/String;)Z
    //   3275: ifeq -> 3294
    //   3278: aload #59
    //   3280: iload #8
    //   3282: invokevirtual lG : (I)Z
    //   3285: pop
    //   3286: aload #59
    //   3288: iload #6
    //   3290: invokevirtual lH : (I)Z
    //   3293: pop
    //   3294: aload #59
    //   3296: iload #42
    //   3298: invokevirtual lM : (I)Z
    //   3301: pop
    //   3302: aload #59
    //   3304: iload #41
    //   3306: invokevirtual lC : (I)Z
    //   3309: pop
    //   3310: aload #59
    //   3312: iload #40
    //   3314: invokevirtual lL : (I)Z
    //   3317: pop
    //   3318: aload_2
    //   3319: new android/content/Intent
    //   3322: dup
    //   3323: invokespecial <init> : ()V
    //   3326: ldc_w 'MainTakeOutBroadReceiver'
    //   3329: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   3332: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   3335: iload #48
    //   3337: ifeq -> 3431
    //   3340: new android/content/Intent
    //   3343: dup
    //   3344: invokespecial <init> : ()V
    //   3347: astore_1
    //   3348: aload_1
    //   3349: ldc_w 'ListTakeOutBroadReceiver'
    //   3352: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   3355: pop
    //   3356: iload #19
    //   3358: iload #20
    //   3360: iadd
    //   3361: iload #18
    //   3363: iadd
    //   3364: iload #17
    //   3366: iadd
    //   3367: ifgt -> 3725
    //   3370: iload #16
    //   3372: ifeq -> 3720
    //   3375: goto -> 3725
    //   3378: aload_1
    //   3379: ldc_w 'bRefereshPending'
    //   3382: iload_3
    //   3383: invokevirtual putExtra : (Ljava/lang/String;Z)Landroid/content/Intent;
    //   3386: pop
    //   3387: iload #44
    //   3389: ifgt -> 3730
    //   3392: iload #49
    //   3394: istore_3
    //   3395: iload #21
    //   3397: ifeq -> 3403
    //   3400: goto -> 3730
    //   3403: aload_1
    //   3404: ldc_w 'bRefereshRefund'
    //   3407: iload_3
    //   3408: invokevirtual putExtra : (Ljava/lang/String;Z)Landroid/content/Intent;
    //   3411: pop
    //   3412: aload_2
    //   3413: aload_1
    //   3414: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   3417: goto -> 3431
    //   3420: astore_1
    //   3421: ldc_w 'TDDException'
    //   3424: aload_1
    //   3425: invokevirtual toString : ()Ljava/lang/String;
    //   3428: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   3431: iload #4
    //   3433: ifeq -> 3451
    //   3436: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   3439: invokevirtual Cf : ()Z
    //   3442: ifeq -> 3451
    //   3445: aload_0
    //   3446: ldc 'meituan'
    //   3448: invokevirtual oO : (Ljava/lang/String;)V
    //   3451: iload #4
    //   3453: ifeq -> 3472
    //   3456: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   3459: invokevirtual Cg : ()Z
    //   3462: ifeq -> 3472
    //   3465: aload_0
    //   3466: ldc_w 'eleme'
    //   3469: invokevirtual oO : (Ljava/lang/String;)V
    //   3472: iload #4
    //   3474: ifeq -> 3498
    //   3477: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   3480: invokevirtual Ch : ()Z
    //   3483: ifeq -> 3498
    //   3486: aload_0
    //   3487: ldc 'weixin_eat_in'
    //   3489: invokevirtual oO : (Ljava/lang/String;)V
    //   3492: aload_0
    //   3493: ldc 'koubei'
    //   3495: invokevirtual oO : (Ljava/lang/String;)V
    //   3498: iload #4
    //   3500: ifeq -> 3518
    //   3503: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   3506: invokevirtual Ci : ()Z
    //   3509: ifeq -> 3518
    //   3512: aload_0
    //   3513: ldc 'weixin'
    //   3515: invokevirtual oO : (Ljava/lang/String;)V
    //   3518: return
    //   3519: astore #54
    //   3521: goto -> 536
    //   3524: astore #54
    //   3526: goto -> 937
    //   3529: astore #54
    //   3531: goto -> 931
    //   3534: astore #55
    //   3536: goto -> 1009
    //   3539: astore #55
    //   3541: goto -> 1003
    //   3544: astore #54
    //   3546: goto -> 1062
    //   3549: astore_1
    //   3550: goto -> 1144
    //   3553: astore #54
    //   3555: goto -> 1141
    //   3558: astore #54
    //   3560: goto -> 1144
    //   3563: iconst_0
    //   3564: istore #38
    //   3566: goto -> 154
    //   3569: iconst_0
    //   3570: istore #43
    //   3572: iconst_0
    //   3573: istore #39
    //   3575: iconst_0
    //   3576: istore #20
    //   3578: iconst_0
    //   3579: istore #44
    //   3581: iconst_0
    //   3582: istore #19
    //   3584: iconst_0
    //   3585: istore #18
    //   3587: iconst_0
    //   3588: istore #17
    //   3590: iconst_0
    //   3591: istore #42
    //   3593: iconst_0
    //   3594: istore #14
    //   3596: iconst_0
    //   3597: istore #13
    //   3599: iconst_0
    //   3600: istore #12
    //   3602: iconst_0
    //   3603: istore #11
    //   3605: iconst_0
    //   3606: istore #10
    //   3608: iconst_0
    //   3609: istore #9
    //   3611: iconst_0
    //   3612: istore #7
    //   3614: iconst_0
    //   3615: istore #8
    //   3617: iconst_0
    //   3618: istore #6
    //   3620: iconst_0
    //   3621: istore #41
    //   3623: iconst_0
    //   3624: istore #40
    //   3626: aconst_null
    //   3627: astore_1
    //   3628: iconst_0
    //   3629: istore #16
    //   3631: iconst_0
    //   3632: istore #21
    //   3634: goto -> 189
    //   3637: goto -> 247
    //   3640: goto -> 311
    //   3643: goto -> 375
    //   3646: goto -> 439
    //   3649: goto -> 503
    //   3652: goto -> 611
    //   3655: iconst_0
    //   3656: istore #49
    //   3658: goto -> 666
    //   3661: goto -> 866
    //   3664: goto -> 780
    //   3667: iconst_1
    //   3668: istore #5
    //   3670: goto -> 2478
    //   3673: iconst_0
    //   3674: istore #5
    //   3676: goto -> 2478
    //   3679: astore #54
    //   3681: goto -> 2433
    //   3684: iconst_1
    //   3685: istore #5
    //   3687: goto -> 2720
    //   3690: iconst_0
    //   3691: istore #5
    //   3693: goto -> 2720
    //   3696: astore #54
    //   3698: goto -> 2675
    //   3701: iload #39
    //   3703: iconst_1
    //   3704: iadd
    //   3705: istore #39
    //   3707: iload #15
    //   3709: istore #21
    //   3711: goto -> 189
    //   3714: goto -> 2962
    //   3717: goto -> 3134
    //   3720: iconst_0
    //   3721: istore_3
    //   3722: goto -> 3378
    //   3725: iconst_1
    //   3726: istore_3
    //   3727: goto -> 3378
    //   3730: iconst_1
    //   3731: istore_3
    //   3732: goto -> 3403
    // Exception table:
    //   from	to	target	type
    //   0	7	3420	java/lang/Exception
    //   52	58	3420	java/lang/Exception
    //   70	124	3420	java/lang/Exception
    //   125	148	3420	java/lang/Exception
    //   157	186	3420	java/lang/Exception
    //   189	229	3420	java/lang/Exception
    //   234	244	3420	java/lang/Exception
    //   247	258	3420	java/lang/Exception
    //   261	293	3420	java/lang/Exception
    //   298	308	3420	java/lang/Exception
    //   311	322	3420	java/lang/Exception
    //   325	357	3420	java/lang/Exception
    //   362	372	3420	java/lang/Exception
    //   375	386	3420	java/lang/Exception
    //   389	421	3420	java/lang/Exception
    //   426	436	3420	java/lang/Exception
    //   439	450	3420	java/lang/Exception
    //   453	485	3420	java/lang/Exception
    //   490	500	3420	java/lang/Exception
    //   503	514	3420	java/lang/Exception
    //   514	533	3519	java/lang/Exception
    //   539	570	3420	java/lang/Exception
    //   578	602	3420	java/lang/Exception
    //   611	647	3420	java/lang/Exception
    //   652	660	3420	java/lang/Exception
    //   666	674	3420	java/lang/Exception
    //   679	730	3420	java/lang/Exception
    //   733	745	3420	java/lang/Exception
    //   756	777	3420	java/lang/Exception
    //   780	791	3420	java/lang/Exception
    //   797	810	3420	java/lang/Exception
    //   813	834	3420	java/lang/Exception
    //   839	849	3420	java/lang/Exception
    //   849	860	3420	java/lang/Exception
    //   871	899	3524	java/lang/Exception
    //   899	928	3529	java/lang/Exception
    //   944	971	3534	java/lang/Exception
    //   971	1000	3539	java/lang/Exception
    //   1023	1028	2902	java/lang/Exception
    //   1040	1059	3544	java/lang/Exception
    //   1070	1098	3553	java/lang/Exception
    //   1098	1138	3558	java/lang/Exception
    //   1153	1162	2894	java/lang/Exception
    //   1198	1207	2857	java/lang/Exception
    //   1243	1252	2857	java/lang/Exception
    //   1288	1296	2857	java/lang/Exception
    //   1332	1344	2857	java/lang/Exception
    //   1380	1389	2857	java/lang/Exception
    //   1425	1434	2857	java/lang/Exception
    //   1470	1478	2857	java/lang/Exception
    //   1514	1526	2857	java/lang/Exception
    //   1562	1571	2857	java/lang/Exception
    //   1607	1616	2857	java/lang/Exception
    //   1652	1660	2857	java/lang/Exception
    //   1696	1708	2857	java/lang/Exception
    //   1749	1756	2857	java/lang/Exception
    //   2047	2054	2112	java/lang/Exception
    //   2349	2356	2374	java/lang/Exception
    //   2393	2406	3679	java/lang/Exception
    //   2418	2425	3679	java/lang/Exception
    //   2469	2474	2857	java/lang/Exception
    //   2635	2648	3696	java/lang/Exception
    //   2660	2667	3696	java/lang/Exception
    //   2711	2716	2857	java/lang/Exception
    //   2912	2923	3420	java/lang/Exception
    //   2935	2940	3420	java/lang/Exception
    //   2954	2959	3420	java/lang/Exception
    //   2986	2991	3420	java/lang/Exception
    //   3011	3016	3420	java/lang/Exception
    //   3036	3041	3420	java/lang/Exception
    //   3048	3053	3420	java/lang/Exception
    //   3060	3065	3420	java/lang/Exception
    //   3065	3117	3420	java/lang/Exception
    //   3122	3131	3420	java/lang/Exception
    //   3137	3157	3420	java/lang/Exception
    //   3157	3177	3420	java/lang/Exception
    //   3177	3197	3420	java/lang/Exception
    //   3197	3217	3420	java/lang/Exception
    //   3217	3245	3420	java/lang/Exception
    //   3245	3265	3420	java/lang/Exception
    //   3265	3294	3420	java/lang/Exception
    //   3294	3335	3420	java/lang/Exception
    //   3340	3356	3420	java/lang/Exception
    //   3378	3387	3420	java/lang/Exception
    //   3403	3417	3420	java/lang/Exception }
  
  public aw abV() {
    an an = new an(this.context);
    aw aw2 = an.Vv();
    aw aw1 = aw2;
    if (aw2 == null) {
      aw2 = new aw();
      aw2.setEnabled(true);
      aw1 = aw2;
      if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
        aw2.eH(1);
        aw1 = aw2;
      } 
    } 
    if (!n.bL(this.context)) {
      aw1.eH(2);
      av av = new av(this.context);
      String str = av.Tx();
      av.close();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootUrlParameter.ckV);
      stringBuilder.append(str);
      stringBuilder.append("?en=1");
      aw1.setUrl(stringBuilder.toString());
    } 
    an.close();
    return aw1;
  }
  
  public String c(Context paramContext, boolean paramBoolean) {
    av = new av(paramContext);
    str1 = av.Ea();
    String str2 = av.atr();
    if ("".equals(str1))
      return null; 
    JSONObject jSONObject = new JSONObject();
    try {
      aw aw = abV();
      if (!paramBoolean) {
        if (aw.Jq()) {
          JSONObject jSONObject2 = new JSONObject();
          jSONObject2.put("sName", str1);
          jSONObject2.put("sPwd", str2);
          jSONObject.put("weixin", jSONObject2);
        } 
        if (av.auW()) {
          JSONObject jSONObject2 = new JSONObject();
          jSONObject2.put("sName", str1);
          jSONObject2.put("sPwd", str2);
          jSONObject.put("koubei", jSONObject2);
        } 
        JSONObject jSONObject1 = new JSONObject();
        jSONObject1.put("sName", str1);
        jSONObject1.put("sPwd", str2);
        jSONObject.put("weixin_eat_in", jSONObject1);
        jSONObject1 = new JSONObject();
        jSONObject1.put("sName", str1);
        jSONObject1.put("sPwd", str2);
        jSONObject.put("meituan", jSONObject1);
        jSONObject1 = new JSONObject();
        jSONObject1.put("sName", str1);
        jSONObject1.put("sPwd", str2);
        jSONObject.put("eleme", jSONObject1);
      } 
    } catch (JSONException str1) {
      a.e(str1);
    } 
    av.close();
    try {
      if (jSONObject.length() > 0)
        return b.encode(jSONObject.toString()); 
    } catch (Exception av) {
      a.e(av);
    } 
    return "";
  }
  
  public void oO(String paramString) {
    if ("eleme".equals(paramString)) {
      str = RootApplication.getLaiqianPreferenceManager().auk();
    } else if ("meituan".equals(paramString)) {
      str = RootApplication.getLaiqianPreferenceManager().auj();
    } else if ("weixin".equals(paramString)) {
      str = RootApplication.getLaiqianPreferenceManager().aug();
    } else if ("koubei".equals(paramString)) {
      str = RootApplication.getLaiqianPreferenceManager().auh();
    } else if ("weixin_eat_in".equals(paramString)) {
      str = RootApplication.getLaiqianPreferenceManager().aui();
    } else {
      str = null;
    } 
    StringBuffer stringBuffer = new StringBuffer();
    if (str != null) {
      try {
        null = new JSONObject(str);
        if ("[]".equals(null.get(paramString).toString()))
          return; 
        JSONArray jSONArray = new JSONArray((new JSONObject(null.get(paramString).toString())).get("pending").toString());
        for (byte b = 0; b < jSONArray.length(); b = b1) {
          byte b1 = b + true;
          if (b1 < jSONArray.length()) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(jSONArray.get(b));
            stringBuilder1.append(",");
            stringBuffer.append(stringBuilder1.toString());
          } else {
            stringBuffer.append(jSONArray.get(b));
          } 
        } 
      } catch (JSONException str) {
        a.e(str);
      } 
      if (TextUtils.isEmpty(stringBuffer.toString()))
        return; 
      HashMap hashMap = new HashMap();
      hashMap.put("c", w(this.context, paramString));
      hashMap.put("ids", stringBuffer.toString());
      hashMap.put("shopid", RootApplication.getLaiqianPreferenceManager().Tx());
      hashMap.put("type", paramString);
      hashMap.put("client_type", this.context.getString(R.string.version_name));
      hashMap.put("language", (this.context.getResources().getConfiguration()).locale.toString());
      ay ay = new ay(hashMap, new ar(this, paramString));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootUrlParameter.clr);
      stringBuilder.append("auto-confirm");
      ay.execute(new String[] { stringBuilder.toString() });
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */