package com.laiqian.takeaway;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.entity.aq;
import com.laiqian.member.report.MemberChargeDetailRecord;
import com.laiqian.models.l;
import com.laiqian.print.c.l;
import com.laiqian.print.j;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.takeaway.a.a;
import com.laiqian.takeaway.a.b;
import com.laiqian.util.av;
import com.laiqian.util.ba;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bc {
  ba aNJ = new ba(true);
  
  Context context;
  
  String dtO = "未支付";
  
  String dtP = "已支付";
  
  public bc(Context paramContext) { this.context = paramContext; }
  
  private ArrayList<Long> c(JSONArray paramJSONArray) {
    ArrayList arrayList = new ArrayList();
    byte b = 0;
    try {
      while (b < paramJSONArray.length()) {
        JSONObject jSONObject = paramJSONArray.getJSONObject(b);
        if (jSONObject.has("_id"))
          arrayList.add(Long.valueOf(Long.parseLong(jSONObject.get("_id").toString()))); 
        b++;
      } 
    } catch (JSONException paramJSONArray) {
      a.e(paramJSONArray);
    } 
    return arrayList;
  }
  
  private void k(TakeOrderEntity paramTakeOrderEntity) {
    l l = l.ahn();
    g g = g.cGS;
    try {
      for (e e : j.cCx.a(paramTakeOrderEntity, new String[] { "tag_not_specified" })) {
        e.a(new bk(this, l));
        g.print(e);
      } 
    } catch (Exception paramTakeOrderEntity) {
      a.e(paramTakeOrderEntity);
    } 
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, TakeOrderEntity paramTakeOrderEntity) {
    a a = new a(this, null);
    a.delay = paramInt;
    a.dtZ = paramString1;
    a.dua = paramString2;
    a.dub = paramString3;
    a.takeOrderEntity = paramTakeOrderEntity;
    a.execute(new Void[0]);
  }
  
  @JavascriptInterface
  public String getLanguage() { return n.bL(this.context) ? "" : "en"; }
  
  public void j(TakeOrderEntity paramTakeOrderEntity) { printOrder("1", "1", "1", paramTakeOrderEntity); }
  
  public void oQ(String paramString) {
    String str1 = paramString.substring(0, paramString.indexOf("/"));
    String str2 = paramString.substring(paramString.indexOf("/") + 1, paramString.length());
    Log.e("printCancelOrders", str1);
    Log.e("printCancelOrders", str2);
    null = b.bB(this.context);
    null = null.al(null.ba(str1, str2));
    for (e e : null) {
      e.cx(0L);
      e.a(new be(this, e, paramString));
    } 
    g.cGS.o(null);
    for (s s : a.bA(this.context).getPrinters()) {
      ArrayList arrayList = a.bA(this.context).ba(str1, str2);
      e e = g.cGS.f(s).D(arrayList);
      e.a(new bg(this, e, paramString));
      g.cGS.print(e);
    } 
  }
  
  @JavascriptInterface
  public void payOrder(String paramString) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 'payOrder'
    //   5: aload_1
    //   6: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   9: new org/json/JSONObject
    //   12: dup
    //   13: aload_1
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: astore_1
    //   18: new org/json/JSONArray
    //   21: dup
    //   22: aload_1
    //   23: ldc_w 'productdoc'
    //   26: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   29: invokevirtual toString : ()Ljava/lang/String;
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: astore_2
    //   36: new org/json/JSONArray
    //   39: dup
    //   40: aload_1
    //   41: ldc_w 'accountdoc'
    //   44: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   47: invokevirtual toString : ()Ljava/lang/String;
    //   50: invokespecial <init> : (Ljava/lang/String;)V
    //   53: astore_3
    //   54: new com/laiqian/milestone/h
    //   57: dup
    //   58: aload_0
    //   59: getfield context : Landroid/content/Context;
    //   62: invokespecial <init> : (Landroid/content/Context;)V
    //   65: astore #4
    //   67: aload_1
    //   68: ldc_w 'sRefNo'
    //   71: invokevirtual has : (Ljava/lang/String;)Z
    //   74: ifeq -> 139
    //   77: aload #4
    //   79: aload_1
    //   80: ldc_w 'sRefNo'
    //   83: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   86: invokevirtual toString : ()Ljava/lang/String;
    //   89: invokevirtual gS : (Ljava/lang/String;)I
    //   92: ifle -> 139
    //   95: new java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial <init> : ()V
    //   102: astore_2
    //   103: aload_2
    //   104: aload_1
    //   105: ldc_w 'sRefNo'
    //   108: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   111: invokevirtual toString : ()Ljava/lang/String;
    //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_2
    //   119: ldc_w '订单重复，不能插进去啦'
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: ldc_w 'payOrder'
    //   129: aload_2
    //   130: invokevirtual toString : ()Ljava/lang/String;
    //   133: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   136: aload_0
    //   137: monitorexit
    //   138: return
    //   139: ldc_w 'payOrder'
    //   142: ldc_w '插入成功'
    //   145: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   148: new com/laiqian/util/av
    //   151: dup
    //   152: aload_0
    //   153: getfield context : Landroid/content/Context;
    //   156: invokespecial <init> : (Landroid/content/Context;)V
    //   159: astore #5
    //   161: aload #5
    //   163: invokevirtual atm : ()Ljava/lang/String;
    //   166: astore #6
    //   168: aload #5
    //   170: invokevirtual close : ()V
    //   173: aload #4
    //   175: aload #6
    //   177: aload_2
    //   178: ldc_w 'T_PRODUCTDOC'
    //   181: invokevirtual a : (Ljava/lang/String;Lorg/json/JSONArray;Ljava/lang/String;)Z
    //   184: pop
    //   185: aload #4
    //   187: aload #6
    //   189: aload_3
    //   190: ldc_w 'T_ACCOUNTDOC'
    //   193: invokevirtual a : (Ljava/lang/String;Lorg/json/JSONArray;Ljava/lang/String;)Z
    //   196: pop
    //   197: aload #4
    //   199: aload #6
    //   201: aload_2
    //   202: ldc_w 'T_PRODUCTDOC'
    //   205: invokevirtual b : (Ljava/lang/String;Lorg/json/JSONArray;Ljava/lang/String;)Z
    //   208: pop
    //   209: aload #4
    //   211: invokevirtual close : ()V
    //   214: new com/laiqian/takeaway/bd
    //   217: dup
    //   218: aload_0
    //   219: aload_2
    //   220: aload_3
    //   221: invokespecial <init> : (Lcom/laiqian/takeaway/bc;Lorg/json/JSONArray;Lorg/json/JSONArray;)V
    //   224: astore_2
    //   225: invokestatic aKh : ()Lio/reactivex/m;
    //   228: aload_2
    //   229: invokevirtual r : (Ljava/lang/Runnable;)Lio/reactivex/a/b;
    //   232: pop
    //   233: aload_1
    //   234: ldc_w 'orderinfo'
    //   237: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   240: invokevirtual toString : ()Ljava/lang/String;
    //   243: invokestatic qB : (Ljava/lang/String;)Ljava/util/HashMap;
    //   246: astore_2
    //   247: ldc_w 'waimai'
    //   250: aload_2
    //   251: invokevirtual toString : ()Ljava/lang/String;
    //   254: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   257: ldc_w 'weixin'
    //   260: aload_2
    //   261: ldc_w 'sTakeawayType'
    //   264: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   267: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   270: invokevirtual equals : (Ljava/lang/Object;)Z
    //   273: ifeq -> 393
    //   276: new org/json/JSONObject
    //   279: dup
    //   280: invokespecial <init> : ()V
    //   283: astore_3
    //   284: aload_3
    //   285: ldc_w '交易金额'
    //   288: aload_2
    //   289: ldc_w 'fRecevied'
    //   292: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   295: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   298: pop
    //   299: ldc_w 'COD'
    //   302: aload_2
    //   303: ldc_w 'sPayType'
    //   306: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   309: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   312: invokevirtual equals : (Ljava/lang/Object;)Z
    //   315: ifeq -> 739
    //   318: ldc_w '货到付款'
    //   321: astore_1
    //   322: goto -> 325
    //   325: aload_3
    //   326: ldc_w '支付方式'
    //   329: aload_1
    //   330: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   333: pop
    //   334: ldc '1'
    //   336: aload_2
    //   337: ldc_w 'bIsOurShop'
    //   340: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   343: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   346: invokevirtual equals : (Ljava/lang/Object;)Z
    //   349: ifeq -> 746
    //   352: ldc_w '身边小店'
    //   355: astore_1
    //   356: goto -> 359
    //   359: aload_3
    //   360: ldc_w '公共账号'
    //   363: aload_1
    //   364: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   367: pop
    //   368: goto -> 376
    //   371: astore_1
    //   372: aload_1
    //   373: invokestatic e : (Ljava/lang/Throwable;)V
    //   376: invokestatic aAU : ()Lcom/zhuge/analysis/b/a;
    //   379: aload_0
    //   380: getfield context : Landroid/content/Context;
    //   383: ldc_w '微信外卖'
    //   386: aload_3
    //   387: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   390: goto -> 706
    //   393: ldc_w 'phone_order'
    //   396: aload_2
    //   397: ldc_w 'sTakeawayType'
    //   400: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   403: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   406: invokevirtual equals : (Ljava/lang/Object;)Z
    //   409: ifeq -> 529
    //   412: new org/json/JSONObject
    //   415: dup
    //   416: invokespecial <init> : ()V
    //   419: astore_3
    //   420: aload_3
    //   421: ldc_w '交易金额'
    //   424: aload_2
    //   425: ldc_w 'fRecevied'
    //   428: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   431: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   434: pop
    //   435: ldc_w 'COD'
    //   438: aload_2
    //   439: ldc_w 'sPayType'
    //   442: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   445: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   448: invokevirtual equals : (Ljava/lang/Object;)Z
    //   451: ifeq -> 753
    //   454: ldc_w '货到付款'
    //   457: astore_1
    //   458: goto -> 461
    //   461: aload_3
    //   462: ldc_w '支付方式'
    //   465: aload_1
    //   466: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   469: pop
    //   470: ldc '1'
    //   472: aload_2
    //   473: ldc_w 'bIsOurShop'
    //   476: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   479: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   482: invokevirtual equals : (Ljava/lang/Object;)Z
    //   485: ifeq -> 760
    //   488: ldc_w '身边小店'
    //   491: astore_1
    //   492: goto -> 495
    //   495: aload_3
    //   496: ldc_w '公共账号'
    //   499: aload_1
    //   500: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   503: pop
    //   504: goto -> 512
    //   507: astore_1
    //   508: aload_1
    //   509: invokestatic e : (Ljava/lang/Throwable;)V
    //   512: invokestatic aAU : ()Lcom/zhuge/analysis/b/a;
    //   515: aload_0
    //   516: getfield context : Landroid/content/Context;
    //   519: ldc_w '微信外卖'
    //   522: aload_3
    //   523: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   526: goto -> 706
    //   529: ldc_w 'weixin_eat_in'
    //   532: aload_2
    //   533: ldc_w 'sTakeawayType'
    //   536: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   539: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   542: invokevirtual equals : (Ljava/lang/Object;)Z
    //   545: ifeq -> 607
    //   548: new org/json/JSONObject
    //   551: dup
    //   552: invokespecial <init> : ()V
    //   555: astore_1
    //   556: aload_1
    //   557: ldc_w '交易金额'
    //   560: aload_2
    //   561: ldc_w 'fRecevied'
    //   564: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   567: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   570: pop
    //   571: aload_1
    //   572: ldc_w '支付方式'
    //   575: ldc_w '来钱快账户'
    //   578: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   581: pop
    //   582: goto -> 590
    //   585: astore_2
    //   586: aload_2
    //   587: invokestatic e : (Ljava/lang/Throwable;)V
    //   590: invokestatic aAU : ()Lcom/zhuge/analysis/b/a;
    //   593: aload_0
    //   594: getfield context : Landroid/content/Context;
    //   597: ldc_w '扫码点菜-微信'
    //   600: aload_1
    //   601: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   604: goto -> 706
    //   607: ldc_w 'koubei'
    //   610: aload_2
    //   611: ldc_w 'sTakeawayType'
    //   614: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   617: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   620: invokevirtual equals : (Ljava/lang/Object;)Z
    //   623: ifeq -> 706
    //   626: new org/json/JSONObject
    //   629: dup
    //   630: invokespecial <init> : ()V
    //   633: astore_3
    //   634: aload_3
    //   635: ldc_w '交易金额'
    //   638: aload_2
    //   639: ldc_w 'fRecevied'
    //   642: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   645: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   648: pop
    //   649: ldc_w 'lqkAccount'
    //   652: aload_2
    //   653: ldc_w 'sPayType'
    //   656: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   659: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   662: invokevirtual equals : (Ljava/lang/Object;)Z
    //   665: ifeq -> 767
    //   668: ldc_w '来钱快账户'
    //   671: astore_1
    //   672: goto -> 675
    //   675: aload_3
    //   676: ldc_w '支付方式'
    //   679: aload_1
    //   680: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   683: pop
    //   684: goto -> 692
    //   687: astore_1
    //   688: aload_1
    //   689: invokestatic e : (Ljava/lang/Throwable;)V
    //   692: invokestatic aAU : ()Lcom/zhuge/analysis/b/a;
    //   695: aload_0
    //   696: getfield context : Landroid/content/Context;
    //   699: ldc_w '扫码点菜-支付宝'
    //   702: aload_3
    //   703: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   706: aload_0
    //   707: getfield context : Landroid/content/Context;
    //   710: new android/content/Intent
    //   713: dup
    //   714: ldc_w 'pos_activity_change_data_product'
    //   717: invokespecial <init> : (Ljava/lang/String;)V
    //   720: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   723: goto -> 731
    //   726: astore_1
    //   727: aload_1
    //   728: invokestatic e : (Ljava/lang/Throwable;)V
    //   731: aload_0
    //   732: monitorexit
    //   733: return
    //   734: astore_1
    //   735: aload_0
    //   736: monitorexit
    //   737: aload_1
    //   738: athrow
    //   739: ldc_w '来钱快账户'
    //   742: astore_1
    //   743: goto -> 325
    //   746: ldc_w '自定义'
    //   749: astore_1
    //   750: goto -> 359
    //   753: ldc_w '来钱快账户'
    //   756: astore_1
    //   757: goto -> 461
    //   760: ldc_w '自定义'
    //   763: astore_1
    //   764: goto -> 495
    //   767: ldc_w '商家账户'
    //   770: astore_1
    //   771: goto -> 675
    // Exception table:
    //   from	to	target	type
    //   2	9	734	finally
    //   9	136	726	org/json/JSONException
    //   9	136	734	finally
    //   139	284	726	org/json/JSONException
    //   139	284	734	finally
    //   284	318	371	org/json/JSONException
    //   284	318	734	finally
    //   325	352	371	org/json/JSONException
    //   325	352	734	finally
    //   359	368	371	org/json/JSONException
    //   359	368	734	finally
    //   372	376	726	org/json/JSONException
    //   372	376	734	finally
    //   376	390	726	org/json/JSONException
    //   376	390	734	finally
    //   393	420	726	org/json/JSONException
    //   393	420	734	finally
    //   420	454	507	org/json/JSONException
    //   420	454	734	finally
    //   461	488	507	org/json/JSONException
    //   461	488	734	finally
    //   495	504	507	org/json/JSONException
    //   495	504	734	finally
    //   508	512	726	org/json/JSONException
    //   508	512	734	finally
    //   512	526	726	org/json/JSONException
    //   512	526	734	finally
    //   529	556	726	org/json/JSONException
    //   529	556	734	finally
    //   556	582	585	org/json/JSONException
    //   556	582	734	finally
    //   586	590	726	org/json/JSONException
    //   586	590	734	finally
    //   590	604	726	org/json/JSONException
    //   590	604	734	finally
    //   607	634	726	org/json/JSONException
    //   607	634	734	finally
    //   634	668	687	org/json/JSONException
    //   634	668	734	finally
    //   675	684	687	org/json/JSONException
    //   675	684	734	finally
    //   688	692	726	org/json/JSONException
    //   688	692	734	finally
    //   692	706	726	org/json/JSONException
    //   692	706	734	finally
    //   706	723	726	org/json/JSONException
    //   706	723	734	finally
    //   727	731	734	finally }
  
  @JavascriptInterface
  public void printOrder(String paramString1, String paramString2, String paramString3, TakeOrderEntity paramTakeOrderEntity) { a(paramString1, paramString2, paramString3, 0, paramTakeOrderEntity); }
  
  @JavascriptInterface
  public void updateOrders(String paramString, boolean paramBoolean1, boolean paramBoolean2) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore #4
    //   11: aload #4
    //   13: ldc_w 'updateOrders()'
    //   16: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload #4
    //   22: aload_1
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc_w 'updateOrders()'
    //   30: aload #4
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   38: new com/laiqian/takeaway/aq
    //   41: dup
    //   42: aload_0
    //   43: getfield context : Landroid/content/Context;
    //   46: invokespecial <init> : (Landroid/content/Context;)V
    //   49: astore #4
    //   51: aload #4
    //   53: new org/json/JSONObject
    //   56: dup
    //   57: aload_1
    //   58: invokestatic qA : (Ljava/lang/String;)Ljava/lang/String;
    //   61: invokespecial <init> : (Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield context : Landroid/content/Context;
    //   68: iload_2
    //   69: iload_3
    //   70: invokevirtual a : (Lorg/json/JSONObject;Landroid/content/Context;ZZ)V
    //   73: goto -> 81
    //   76: astore_1
    //   77: aload_1
    //   78: invokestatic e : (Ljava/lang/Throwable;)V
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Exception table:
    //   from	to	target	type
    //   2	51	84	finally
    //   51	73	76	org/json/JSONException
    //   51	73	84	finally
    //   77	81	84	finally }
  
  public void z(String paramString, boolean paramBoolean) throws JSONException {
    b b = b.bB(this.context);
    for (e e : b.al(b.oV(paramString))) {
      e.cx(0L);
      e.a(new bi(this, e, paramBoolean));
      g.cGS.print(e);
    } 
  }
  
  private class a extends AsyncTask<Void, Void, Integer> {
    int delay;
    
    String dtZ;
    
    String dua;
    
    String dub;
    
    TakeOrderEntity takeOrderEntity;
    
    aq vipEntity;
    
    private a(bc this$0) {}
    
    protected Integer e(Void... param1VarArgs) {
      if ((this.takeOrderEntity.getVipEntity()).aSW > 0L) {
        av av = new av(this.dtS.context);
        if (av.Wq()) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append((this.takeOrderEntity.getVipEntity()).aWC);
          stringBuilder1.append("");
          String str = stringBuilder1.toString();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.takeOrderEntity.IO());
          stringBuilder2.append("");
          this.vipEntity = MemberChargeDetailRecord.I(stringBuilder2.toString(), str);
        } else {
          l l = new l(this.dtS.context);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.takeOrderEntity.IO());
          stringBuilder.append("");
          this.vipEntity = l.hq(stringBuilder.toString());
          l.close();
        } 
        av.close();
        this.takeOrderEntity.setVipEntity(this.vipEntity);
      } 
      return null;
    }
    
    protected void e(Integer param1Integer) {
      TakeOrderEntity takeOrderEntity1;
      j j;
      String str;
      boolean bool;
      boolean bool1 = "1".equals(this.dtZ);
      boolean bool2 = "1".equals(this.dua);
      boolean bool3 = "1".equals(this.dub);
      null = this.takeOrderEntity.Ik();
      if (null != null) {
        bool = null.aWg;
      } else {
        bool = false;
      } 
      if (!bool1 && !bool2 && !bool3)
        return; 
      if (this.takeOrderEntity == null)
        return; 
      if (bool1)
        try {
          String str1;
          null = j.cCx;
          j = this.takeOrderEntity;
          if (bool) {
            str1 = "takeout_reprint";
          } else {
            str1 = "takeout";
          } 
          List list = null.a(j, new String[] { str1 });
          str = list.iterator();
          while (str.hasNext())
            ((e)str.next()).cx(this.delay); 
          g.cGS.o(list);
        } catch (Exception null) {
          a.e(null);
        }  
      if (bool3)
        bc.a(this.dtS, this.takeOrderEntity); 
      if (this.takeOrderEntity.getType().equals("weixin") || this.takeOrderEntity.getType().equals("phone_order"))
        try {
          List list = j.cCx.a(this.takeOrderEntity, new String[] { "delivery_not_specified" });
          g.cGS.o(list);
        } catch (Exception null) {
          a.e(null);
        }  
      if (bool2 && (this.takeOrderEntity.getType().equals("koubei") || this.takeOrderEntity.getType().equals("weixin") || this.takeOrderEntity.getType().equals("eleme") || this.takeOrderEntity.getType().equals("weixin_eat_in") || this.takeOrderEntity.getType().equals("tao") || this.takeOrderEntity.getType().equals("meituan"))) {
        try {
          j = j.cCx;
          takeOrderEntity1 = this.takeOrderEntity;
          if (bool) {
            String str1 = "kitchen_total_reprint";
          } else {
            String str1 = "kitchen_total";
          } 
        } catch (Exception null) {
          a.e(null);
          return;
        } 
      } else {
        return;
      } 
      if (bool) {
        str = "kitchen_port_reprint";
      } else {
        str = "kitchen_port";
      } 
      for (e e : j.a(takeOrderEntity1, new String[] { null, str })) {
        e.a(new bm(this, e));
        g.cGS.print(e);
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */