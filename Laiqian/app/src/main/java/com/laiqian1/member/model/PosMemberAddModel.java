package com.laiqian.member.model;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.AsyncTaskLoader;
import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aq;
import com.laiqian.entity.as;
import com.laiqian.member.setting.sms.h;
import com.laiqian.member.setting.sms.i;
import com.laiqian.models.j;
import com.laiqian.models.l;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.pos.industry.a;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import com.orhanobut.logger.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PosMemberAddModel extends l {
  public PosMemberAddModel(Context paramContext) { super(paramContext); }
  
  public boolean K(String paramString1, String paramString2) {
    am("sNumber", paramString1);
    am("sContactMobilePhone", paramString2);
    return UA();
  }
  
  public boolean L(String paramString1, String paramString2) {
    HashMap hashMap = new HashMap();
    String str2 = RootApplication.getLaiqianPreferenceManager().Tx();
    hashMap.put("sNumber", paramString1);
    hashMap.put("sContactMobilePhone", paramString2);
    hashMap.put("shop_id", str2);
    hashMap.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
    hashMap.put("password", RootApplication.getLaiqianPreferenceManager().atr());
    if (RootApplication.getLaiqianPreferenceManager().avl()) {
      paramString1 = "0";
    } else {
      paramString1 = "1";
    } 
    hashMap.put("scope", paramString1);
    hashMap.put("auth_type", "0");
    hashMap.put("version", "1");
    null = new StringBuilder();
    null.append(RootApplication.getLaiqianPreferenceManager().avm());
    null.append("");
    hashMap.put("scope", null.toString());
    if (TextUtils.isEmpty(str2)) {
      l(this.mContext.getString(R.string.storenumbernotexist), false);
      return false;
    } 
    String str1 = bh.a(a.cqx, RootApplication.zv().getApplicationContext(), hashMap);
    if (!TextUtils.isEmpty(str1)) {
      HashMap hashMap1 = au.qB(str1);
      if (hashMap1.containsKey("result") && "TRUE".equals(String.valueOf(hashMap1.get("result"))))
        return true; 
      if (hashMap1.containsKey("result") && "FALSE".equals(String.valueOf(hashMap1.get("result")))) {
        l(String.valueOf(hashMap1.get("msg_no")), false);
        return false;
      } 
      l(this.mContext.getString(R.string.pos_create_vip_other_reason), false);
      return false;
    } 
    l(this.mContext.getString(R.string.pos_create_vip_other_reason), false);
    return false;
  }
  
  public boolean QL() { return super.QL(); }
  
  public boolean a(aq paramaq, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    if (!bd.bH(this.mContext)) {
      l(this.mContext.getString(R.string.please_check_network), false);
      return false;
    } 
    null = new HashMap();
    null.put("_id", paramString1);
    null.put("chargedoc_id", paramString2);
    null.put("sNumber", paramaq.aWn);
    null.put("nBPartnerType", k(Long.valueOf(paramaq.aWw)));
    null.put("sBPartnerTypeName", paramaq.aWx);
    null = new StringBuilder();
    null.append(paramaq.discount);
    null.append("");
    null.put("fDiscount", null.toString());
    null.put("sContactPerson", paramaq.name);
    null.put("sName", paramaq.name);
    null.put("sContactMobilePhone", paramaq.aTp);
    null.put("sSpareField1", paramaq.getBirthday());
    null.put("nSpareField2", paramString4);
    null.put("nSpareField3", paramString5);
    null = new StringBuilder();
    null.append(paramaq.aWA + paramaq.aWB + 0.0D);
    null.append("");
    null.put("fAmount", null.toString());
    null = new StringBuilder();
    null.append(paramaq.aWA);
    null.append("");
    null.put("fReceived", null.toString());
    null = new StringBuilder();
    null.append(paramaq.aWB + 0.0D);
    null.append("");
    null.put("fChargeGrantAmount", null.toString());
    null.put("bIsCustomer", "N");
    null.put("bIsVendor", "N");
    null.put("bIsActive", "Y");
    null = new StringBuilder();
    null.append(System.currentTimeMillis());
    null.append("");
    null.put("nDateTime", null.toString());
    null.put("sIsMember", "Y");
    null.put("nUserID", RootApplication.getLaiqianPreferenceManager().atm());
    null.put("shop_id", RootApplication.getLaiqianPreferenceManager().Tx());
    null.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
    null.put("password", RootApplication.getLaiqianPreferenceManager().atr());
    null.put("auth_type", "0");
    null.put("version", "1");
    null = new StringBuilder();
    null.append(RootApplication.getLaiqianPreferenceManager().avm());
    null.append("");
    null.put("scope", null.toString());
    null.put("sField1", paramaq.aJX);
    null.put("fSpareField3", paramaq.aWq);
    boolean bool = paramaq.aWH.isOpen;
    String str2 = paramaq.aWH.password;
    if (bool) {
      as as = new as();
      as.isOpen = bool;
      as.password = str2;
      null.put("sSpareField3", as.IX());
      Log.e("addMember_sSpareField3", as.IX());
    } 
    Log.e("GET_VIP_NEW_URL", a.cqw);
    String str1 = bh.a(a.cqw, RootApplication.zv().getApplicationContext(), null);
    if (!TextUtils.isEmpty(str1)) {
      HashMap hashMap = au.qB(str1);
      if (hashMap.containsKey("result") && "TRUE".equals(String.valueOf(hashMap.get("result"))))
        return a(paramaq, paramString1, null, paramString2, paramString3, paramString4, paramString5); 
      if (hashMap.containsKey("result") && "FALSE".equals(String.valueOf(hashMap.get("result")))) {
        hP(String.valueOf(hashMap.get("msg_no")));
        return false;
      } 
      hP(this.mContext.getString(R.string.save_settings_failed));
      return false;
    } 
    hP(this.mContext.getString(R.string.save_settings_failed));
    return false;
  }
  
  public boolean a(aq paramaq, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) { // Byte code:
    //   0: aload_1
    //   1: astore #24
    //   3: ldc ''
    //   5: aload_2
    //   6: invokevirtual equals : (Ljava/lang/Object;)Z
    //   9: ifne -> 25
    //   12: aload_2
    //   13: astore #23
    //   15: ldc_w 'null'
    //   18: aload_2
    //   19: invokevirtual equals : (Ljava/lang/Object;)Z
    //   22: ifeq -> 28
    //   25: aconst_null
    //   26: astore #23
    //   28: ldc ''
    //   30: aload #4
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifne -> 55
    //   38: ldc_w 'null'
    //   41: aload #4
    //   43: invokevirtual equals : (Ljava/lang/Object;)Z
    //   46: ifeq -> 52
    //   49: goto -> 55
    //   52: goto -> 58
    //   55: aconst_null
    //   56: astore #4
    //   58: aload #23
    //   60: astore_2
    //   61: aload #23
    //   63: ifnonnull -> 94
    //   66: new java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial <init> : ()V
    //   73: astore_2
    //   74: aload_2
    //   75: invokestatic currentTimeMillis : ()J
    //   78: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: ldc ''
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_2
    //   90: invokevirtual toString : ()Ljava/lang/String;
    //   93: astore_2
    //   94: aload_0
    //   95: invokevirtual beginTransaction : ()V
    //   98: aload_0
    //   99: ldc '_id'
    //   101: aload_2
    //   102: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   105: pop
    //   106: aload_0
    //   107: ldc 'sNumber'
    //   109: aload #24
    //   111: getfield aWn : Ljava/lang/String;
    //   114: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   117: pop
    //   118: new java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: astore #23
    //   127: aload #23
    //   129: aload #24
    //   131: getfield aWw : J
    //   134: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload #23
    //   140: ldc ''
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_0
    //   147: ldc 'nBPartnerType'
    //   149: aload #23
    //   151: invokevirtual toString : ()Ljava/lang/String;
    //   154: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   157: pop
    //   158: aload_0
    //   159: ldc 'sBPartnerTypeName'
    //   161: aload #24
    //   163: getfield aWx : Ljava/lang/String;
    //   166: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   169: pop
    //   170: aload_0
    //   171: ldc_w 'fSpareField3'
    //   174: aload #24
    //   176: getfield aWq : Ljava/lang/String;
    //   179: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   182: pop
    //   183: new java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial <init> : ()V
    //   190: astore #23
    //   192: aload #23
    //   194: aload #24
    //   196: getfield discount : D
    //   199: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload #23
    //   205: ldc ''
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_0
    //   212: ldc 'fDiscount'
    //   214: aload #23
    //   216: invokevirtual toString : ()Ljava/lang/String;
    //   219: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   222: pop
    //   223: aload_0
    //   224: ldc 'sContactPerson'
    //   226: aload #24
    //   228: getfield name : Ljava/lang/String;
    //   231: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   234: pop
    //   235: aload_0
    //   236: ldc 'sName'
    //   238: aload #24
    //   240: getfield name : Ljava/lang/String;
    //   243: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   246: pop
    //   247: aload_0
    //   248: ldc 'sContactMobilePhone'
    //   250: aload #24
    //   252: getfield aTp : Ljava/lang/String;
    //   255: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   258: pop
    //   259: aload_0
    //   260: ldc 'sSpareField1'
    //   262: aload_1
    //   263: invokevirtual getBirthday : ()Ljava/lang/String;
    //   266: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   269: pop
    //   270: aload_0
    //   271: ldc_w 'sField1'
    //   274: aload #24
    //   276: getfield aJX : Ljava/lang/String;
    //   279: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   282: pop
    //   283: aload_0
    //   284: ldc 'fAmount'
    //   286: ldc '0'
    //   288: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   291: pop
    //   292: aload_0
    //   293: ldc_w 'bIsCustomer'
    //   296: ldc_w 'N'
    //   299: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   302: pop
    //   303: aload_0
    //   304: ldc_w 'bIsVendor'
    //   307: ldc_w 'N'
    //   310: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   313: pop
    //   314: aload_0
    //   315: ldc_w 'bIsActive'
    //   318: ldc_w 'Y'
    //   321: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   324: pop
    //   325: new java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial <init> : ()V
    //   332: astore #23
    //   334: aload #23
    //   336: aload #24
    //   338: getfield aVq : Ljava/lang/String;
    //   341: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload #23
    //   347: ldc ''
    //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_0
    //   354: ldc_w 'nDateTime'
    //   357: aload #23
    //   359: invokevirtual toString : ()Ljava/lang/String;
    //   362: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   365: pop
    //   366: aload_0
    //   367: ldc_w 'sIsMember'
    //   370: ldc_w 'Y'
    //   373: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   376: pop
    //   377: aload #24
    //   379: getfield aWH : Lcom/laiqian/entity/as;
    //   382: getfield isOpen : Z
    //   385: istore #14
    //   387: aload #24
    //   389: getfield aWH : Lcom/laiqian/entity/as;
    //   392: getfield password : Ljava/lang/String;
    //   395: astore #23
    //   397: iload #14
    //   399: ifeq -> 450
    //   402: new com/laiqian/entity/as
    //   405: dup
    //   406: invokespecial <init> : ()V
    //   409: astore #25
    //   411: aload #25
    //   413: iload #14
    //   415: putfield isOpen : Z
    //   418: aload #25
    //   420: aload #23
    //   422: putfield password : Ljava/lang/String;
    //   425: aload_0
    //   426: ldc_w 'sSpareField3'
    //   429: aload #25
    //   431: invokevirtual IX : ()Ljava/lang/String;
    //   434: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   437: pop
    //   438: ldc_w 'addMember_sSpareField3'
    //   441: aload #25
    //   443: invokevirtual IX : ()Ljava/lang/String;
    //   446: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   449: pop
    //   450: aload_0
    //   451: invokespecial QL : ()Z
    //   454: ifne -> 476
    //   457: aload_0
    //   458: invokevirtual endTransaction : ()V
    //   461: getstatic com/laiqian/member/model/PosMemberAddModel.aNE : Landroid/database/sqlite/SQLiteDatabase;
    //   464: invokevirtual inTransaction : ()Z
    //   467: ifeq -> 474
    //   470: aload_0
    //   471: invokevirtual endTransaction : ()V
    //   474: iconst_0
    //   475: ireturn
    //   476: aload #24
    //   478: getfield aWA : D
    //   481: aload #24
    //   483: getfield aWB : D
    //   486: dadd
    //   487: dstore #10
    //   489: aload #5
    //   491: invokestatic u : (Ljava/lang/CharSequence;)D
    //   494: dstore #8
    //   496: lconst_0
    //   497: lstore #17
    //   499: dload #8
    //   501: dconst_0
    //   502: dcmpl
    //   503: ifeq -> 863
    //   506: new com/laiqian/models/j
    //   509: dup
    //   510: aload_0
    //   511: getfield mContext : Landroid/content/Context;
    //   514: invokespecial <init> : (Landroid/content/Context;)V
    //   517: astore #5
    //   519: aload_2
    //   520: invokestatic parseLong : (Ljava/lang/String;)J
    //   523: lstore #19
    //   525: aload #6
    //   527: invokestatic parseLong : (Ljava/lang/String;)J
    //   530: lstore #21
    //   532: aload #7
    //   534: ldc ''
    //   536: invokevirtual equals : (Ljava/lang/Object;)Z
    //   539: ifeq -> 548
    //   542: lconst_0
    //   543: lstore #15
    //   545: goto -> 558
    //   548: aload #7
    //   550: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   553: invokevirtual longValue : ()J
    //   556: lstore #15
    //   558: aload #5
    //   560: lload #19
    //   562: dload #8
    //   564: ldc2_w 370011
    //   567: dload #8
    //   569: ldc ''
    //   571: aload_3
    //   572: iconst_0
    //   573: lload #21
    //   575: lload #15
    //   577: aload_1
    //   578: invokevirtual a : (JDJDLjava/lang/String;Ljava/lang/String;IJJLcom/laiqian/entity/aq;)Z
    //   581: istore #14
    //   583: aload #5
    //   585: invokevirtual close : ()V
    //   588: iload #14
    //   590: ifne -> 612
    //   593: aload_0
    //   594: invokevirtual endTransaction : ()V
    //   597: getstatic com/laiqian/member/model/PosMemberAddModel.aNE : Landroid/database/sqlite/SQLiteDatabase;
    //   600: invokevirtual inTransaction : ()Z
    //   603: ifeq -> 610
    //   606: aload_0
    //   607: invokevirtual endTransaction : ()V
    //   610: iconst_0
    //   611: ireturn
    //   612: aload_1
    //   613: dload #8
    //   615: putfield aWo : D
    //   618: goto -> 621
    //   621: dload #10
    //   623: dconst_0
    //   624: dcmpl
    //   625: ifle -> 739
    //   628: new com/laiqian/models/j
    //   631: dup
    //   632: aload_0
    //   633: getfield mContext : Landroid/content/Context;
    //   636: invokespecial <init> : (Landroid/content/Context;)V
    //   639: astore_3
    //   640: aload_2
    //   641: invokestatic parseLong : (Ljava/lang/String;)J
    //   644: lstore #19
    //   646: aload_1
    //   647: getfield aWA : D
    //   650: dstore #12
    //   652: aload #6
    //   654: invokestatic parseLong : (Ljava/lang/String;)J
    //   657: lstore #21
    //   659: aload #7
    //   661: ldc ''
    //   663: invokevirtual equals : (Ljava/lang/Object;)Z
    //   666: ifeq -> 676
    //   669: lload #17
    //   671: lstore #15
    //   673: goto -> 686
    //   676: aload #7
    //   678: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   681: invokevirtual longValue : ()J
    //   684: lstore #15
    //   686: aload_3
    //   687: lload #19
    //   689: dload #10
    //   691: ldc2_w 370004
    //   694: dload #12
    //   696: ldc ''
    //   698: aload #4
    //   700: iconst_0
    //   701: lload #21
    //   703: lload #15
    //   705: aload_1
    //   706: invokevirtual a : (JDJDLjava/lang/String;Ljava/lang/String;IJJLcom/laiqian/entity/aq;)Z
    //   709: istore #14
    //   711: aload_3
    //   712: invokevirtual close : ()V
    //   715: iload #14
    //   717: ifne -> 739
    //   720: aload_0
    //   721: invokevirtual endTransaction : ()V
    //   724: getstatic com/laiqian/member/model/PosMemberAddModel.aNE : Landroid/database/sqlite/SQLiteDatabase;
    //   727: invokevirtual inTransaction : ()Z
    //   730: ifeq -> 737
    //   733: aload_0
    //   734: invokevirtual endTransaction : ()V
    //   737: iconst_0
    //   738: ireturn
    //   739: dload #10
    //   741: dload #8
    //   743: dadd
    //   744: dstore #8
    //   746: dload #8
    //   748: dconst_0
    //   749: dcmpl
    //   750: ifeq -> 805
    //   753: new com/laiqian/models/l
    //   756: dup
    //   757: aload_0
    //   758: getfield mContext : Landroid/content/Context;
    //   761: invokespecial <init> : (Landroid/content/Context;)V
    //   764: astore_1
    //   765: aload_1
    //   766: aload_2
    //   767: invokestatic parseLong : (Ljava/lang/String;)J
    //   770: dload #8
    //   772: invokevirtual b : (JD)Z
    //   775: istore #14
    //   777: aload_1
    //   778: invokevirtual close : ()V
    //   781: iload #14
    //   783: ifne -> 805
    //   786: aload_0
    //   787: invokevirtual endTransaction : ()V
    //   790: getstatic com/laiqian/member/model/PosMemberAddModel.aNE : Landroid/database/sqlite/SQLiteDatabase;
    //   793: invokevirtual inTransaction : ()Z
    //   796: ifeq -> 803
    //   799: aload_0
    //   800: invokevirtual endTransaction : ()V
    //   803: iconst_0
    //   804: ireturn
    //   805: aload_0
    //   806: invokevirtual setTransactionSuccessful : ()V
    //   809: getstatic com/laiqian/member/model/PosMemberAddModel.aNE : Landroid/database/sqlite/SQLiteDatabase;
    //   812: invokevirtual inTransaction : ()Z
    //   815: ifeq -> 822
    //   818: aload_0
    //   819: invokevirtual endTransaction : ()V
    //   822: iconst_1
    //   823: ireturn
    //   824: astore_1
    //   825: goto -> 848
    //   828: astore_1
    //   829: aload_1
    //   830: invokestatic e : (Ljava/lang/Throwable;)V
    //   833: getstatic com/laiqian/member/model/PosMemberAddModel.aNE : Landroid/database/sqlite/SQLiteDatabase;
    //   836: invokevirtual inTransaction : ()Z
    //   839: ifeq -> 846
    //   842: aload_0
    //   843: invokevirtual endTransaction : ()V
    //   846: iconst_0
    //   847: ireturn
    //   848: getstatic com/laiqian/member/model/PosMemberAddModel.aNE : Landroid/database/sqlite/SQLiteDatabase;
    //   851: invokevirtual inTransaction : ()Z
    //   854: ifeq -> 861
    //   857: aload_0
    //   858: invokevirtual endTransaction : ()V
    //   861: aload_1
    //   862: athrow
    //   863: goto -> 621
    // Exception table:
    //   from	to	target	type
    //   94	397	828	java/lang/Exception
    //   94	397	824	finally
    //   402	450	828	java/lang/Exception
    //   402	450	824	finally
    //   450	461	828	java/lang/Exception
    //   450	461	824	finally
    //   476	496	828	java/lang/Exception
    //   476	496	824	finally
    //   506	542	828	java/lang/Exception
    //   506	542	824	finally
    //   548	558	828	java/lang/Exception
    //   548	558	824	finally
    //   558	588	828	java/lang/Exception
    //   558	588	824	finally
    //   593	597	828	java/lang/Exception
    //   593	597	824	finally
    //   612	618	828	java/lang/Exception
    //   612	618	824	finally
    //   628	669	828	java/lang/Exception
    //   628	669	824	finally
    //   676	686	828	java/lang/Exception
    //   676	686	824	finally
    //   686	715	828	java/lang/Exception
    //   686	715	824	finally
    //   720	724	828	java/lang/Exception
    //   720	724	824	finally
    //   753	781	828	java/lang/Exception
    //   753	781	824	finally
    //   786	790	828	java/lang/Exception
    //   786	790	824	finally
    //   805	809	828	java/lang/Exception
    //   805	809	824	finally
    //   829	833	824	finally }
  
  public String k(Long paramLong) {
    if (RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
      null = new StringBuilder();
      null.append(VC());
      null.append("2600");
      Long long = Long.valueOf(Long.parseLong(null.toString()));
      if (paramLong.longValue() <= long.longValue()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(long);
        stringBuilder1.append("");
        stringBuilder1.append(paramLong);
        return stringBuilder1.toString();
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    return stringBuilder.toString();
  }
  
  public static class OnlineSyncTask extends AsyncTaskLoader<Boolean> {
    private String btA;
    
    private String btz;
    
    private String bxE;
    
    public boolean bxY;
    
    public OnlineSyncTask(Context param1Context, String param1String1, String param1String2, String param1String3) {
      super(param1Context);
      this.btz = param1String1;
      this.btA = param1String3;
      this.bxE = param1String2;
    }
    
    public Boolean LN() {
      byte b1;
      d.b("Synchronization create member ", new Object[0]);
      OnlineSyncRequest.a a = new OnlineSyncRequest.a();
      j j = null;
      try {
        exception = new l(getContext());
      } catch (Exception exception) {
        a.e(exception);
        exception = null;
      } 
      null = exception.hd(this.btz);
      boolean bool = RootApplication.getLaiqianPreferenceManager().Wq();
      byte b2 = 2;
      if (!bool) {
        b1 = 1;
      } else {
        b1 = 2;
      } 
      a.a(null, b1);
      null = null.iterator();
      while (null.hasNext())
        ((l.a)null.next()).a(l.bPh).setValue(Double.valueOf(0.0D)); 
      try {
        j j1 = new j(getContext());
        j = j1;
      } catch (Exception null) {
        a.e(null);
      } 
      null = j.hd(this.btA);
      if (!RootApplication.getLaiqianPreferenceManager().Wq()) {
        b1 = 1;
      } else {
        b1 = 2;
      } 
      a.a(null, b1);
      if (n.u(this.bxE) != 0.0D) {
        null = j.hd(this.bxE);
        b1 = b2;
        if (!RootApplication.getLaiqianPreferenceManager().Wq())
          b1 = 1; 
        a.a(null, b1);
      } 
      null = new av(getContext());
      a.iM(null.Ea());
      a.iN(null.atr());
      a.bV(Long.parseLong(null.Tx()));
      null.close();
      f = f.bXQ;
      try {
        bool = (f.b(a.Xj())).bXV;
      } catch (Exception f) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请求实时同步失败");
        stringBuilder.append(f.getMessage());
        d.b(stringBuilder.toString(), new Object[0]);
        a.e(f);
        bool = false;
      } 
      if (this.bxY && !bool) {
        exception.bm(by.parseLong(this.btz));
        j.he(this.btA);
      } 
      exception.close();
      j.close();
      return Boolean.valueOf(bool);
    }
  }
  
  public static class SendSmsTask extends AsyncTaskLoader<Boolean> {
    private h bxZ;
    
    private Context context;
    
    public SendSmsTask(Context param1Context, h param1h) {
      super(param1Context);
      this.bxZ = param1h;
      this.context = param1Context;
    }
    
    public Boolean LN() {
      int i;
      if (Double.valueOf(this.bxZ.bGF).doubleValue() + Double.parseDouble(this.bxZ.bGD) != 0.0D) {
        str = (new i(this.context)).a(this.context, this.bxZ);
        if (str != null) {
          try {
            JSONObject jSONObject = new JSONObject(str);
            i = jSONObject.optInt("nSMSQuantityLeft");
            if (!jSONObject.optBoolean("result"))
              return Boolean.valueOf(false); 
          } catch (JSONException str) {
            a.e(str);
            return Boolean.valueOf(false);
          } 
        } else {
          return Boolean.valueOf(false);
        } 
      } else {
        return Boolean.valueOf(true);
      } 
      if (i == 100 || i == 50 || i == 0) {
        Intent intent = new Intent();
        intent.putExtra("SMS_QUANTITY_LEFT", i);
        intent.setAction("SMS_QUANTITY_LEFT_RECEIVER");
        this.context.sendBroadcast(intent);
      } 
      return Boolean.valueOf(true);
    }
    
    public void g(Boolean param1Boolean) { super.deliverResult(param1Boolean); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\model\PosMemberAddModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */