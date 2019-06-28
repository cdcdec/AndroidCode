package com.laiqian.member.create;

import android.text.Editable;
import com.laiqian.ui.r;

class c extends r {
  c(VipCreateDialog paramVipCreateDialog) {}
  
  public void afterTextChanged(Editable paramEditable) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual toString : ()Ljava/lang/String;
    //   4: invokestatic u : (Ljava/lang/CharSequence;)D
    //   7: dstore #6
    //   9: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   12: invokevirtual avW : ()I
    //   15: ifne -> 113
    //   18: aload_0
    //   19: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   22: invokestatic l : (Lcom/laiqian/member/create/VipCreateDialog;)D
    //   25: ldc2_w -1.0
    //   28: dcmpl
    //   29: ifeq -> 376
    //   32: aload_0
    //   33: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   36: invokestatic m : (Lcom/laiqian/member/create/VipCreateDialog;)D
    //   39: ldc2_w -1.0
    //   42: dcmpl
    //   43: ifeq -> 376
    //   46: dload #6
    //   48: aload_0
    //   49: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   52: invokestatic l : (Lcom/laiqian/member/create/VipCreateDialog;)D
    //   55: dcmpl
    //   56: iflt -> 100
    //   59: dload #6
    //   61: aload_0
    //   62: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   65: invokestatic m : (Lcom/laiqian/member/create/VipCreateDialog;)D
    //   68: dmul
    //   69: ldc2_w 100.0
    //   72: ddiv
    //   73: dstore_2
    //   74: aload_0
    //   75: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   78: getfield bww : Landroid/widget/EditText;
    //   81: aload_0
    //   82: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   85: invokevirtual getContext : ()Landroid/content/Context;
    //   88: dload_2
    //   89: invokestatic valueOf : (D)Ljava/lang/Double;
    //   92: iconst_0
    //   93: invokestatic a : (Landroid/content/Context;Ljava/lang/Object;Z)Ljava/lang/String;
    //   96: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   99: return
    //   100: aload_0
    //   101: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   104: getfield bww : Landroid/widget/EditText;
    //   107: ldc '0'
    //   109: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   112: return
    //   113: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   116: invokevirtual avW : ()I
    //   119: iconst_1
    //   120: if_icmpne -> 376
    //   123: dconst_0
    //   124: dstore #4
    //   126: aload_0
    //   127: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   130: invokestatic n : (Lcom/laiqian/member/create/VipCreateDialog;)Ljava/lang/String;
    //   133: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   136: ifne -> 346
    //   139: aload_0
    //   140: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   143: invokestatic n : (Lcom/laiqian/member/create/VipCreateDialog;)Ljava/lang/String;
    //   146: invokestatic aW : (Ljava/lang/Object;)Ljava/util/ArrayList;
    //   149: astore_1
    //   150: iconst_0
    //   151: istore #10
    //   153: dload #4
    //   155: dstore_2
    //   156: iload #10
    //   158: aload_1
    //   159: invokevirtual size : ()I
    //   162: if_icmpge -> 320
    //   165: aload_1
    //   166: iload #10
    //   168: invokevirtual get : (I)Ljava/lang/Object;
    //   171: checkcast java/util/Map
    //   174: ldc 'fChargeAmount'
    //   176: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   181: checkcast java/lang/CharSequence
    //   184: invokestatic u : (Ljava/lang/CharSequence;)D
    //   187: dstore_2
    //   188: iload #10
    //   190: aload_1
    //   191: invokevirtual size : ()I
    //   194: iconst_1
    //   195: isub
    //   196: if_icmpne -> 219
    //   199: dload #6
    //   201: dload_2
    //   202: dcmpl
    //   203: iflt -> 219
    //   206: aload_0
    //   207: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   210: dload #6
    //   212: invokevirtual ah : (D)D
    //   215: dstore_2
    //   216: goto -> 320
    //   219: iload #10
    //   221: aload_1
    //   222: invokevirtual size : ()I
    //   225: iconst_1
    //   226: isub
    //   227: if_icmpge -> 377
    //   230: aload_1
    //   231: iload #10
    //   233: invokevirtual get : (I)Ljava/lang/Object;
    //   236: checkcast java/util/Map
    //   239: ldc 'fChargeAmount'
    //   241: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   246: checkcast java/lang/CharSequence
    //   249: invokestatic u : (Ljava/lang/CharSequence;)D
    //   252: dstore_2
    //   253: aload_1
    //   254: iload #10
    //   256: iconst_1
    //   257: iadd
    //   258: invokevirtual get : (I)Ljava/lang/Object;
    //   261: checkcast java/util/Map
    //   264: ldc 'fChargeAmount'
    //   266: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   271: checkcast java/lang/CharSequence
    //   274: invokestatic u : (Ljava/lang/CharSequence;)D
    //   277: dstore #8
    //   279: dload #6
    //   281: dload_2
    //   282: dcmpl
    //   283: iflt -> 377
    //   286: dload #6
    //   288: dload #8
    //   290: dcmpg
    //   291: ifge -> 377
    //   294: aload_1
    //   295: iload #10
    //   297: invokevirtual get : (I)Ljava/lang/Object;
    //   300: checkcast java/util/Map
    //   303: ldc 'fBonusAmount'
    //   305: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   310: checkcast java/lang/CharSequence
    //   313: invokestatic u : (Ljava/lang/CharSequence;)D
    //   316: dstore_2
    //   317: goto -> 320
    //   320: aload_0
    //   321: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   324: getfield bww : Landroid/widget/EditText;
    //   327: aload_0
    //   328: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   331: invokevirtual getContext : ()Landroid/content/Context;
    //   334: dload_2
    //   335: invokestatic valueOf : (D)Ljava/lang/Double;
    //   338: iconst_0
    //   339: invokestatic a : (Landroid/content/Context;Ljava/lang/Object;Z)Ljava/lang/String;
    //   342: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   345: return
    //   346: aload_0
    //   347: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   350: getfield bww : Landroid/widget/EditText;
    //   353: ldc '0'
    //   355: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   358: return
    //   359: astore_1
    //   360: aload_1
    //   361: invokestatic e : (Ljava/lang/Throwable;)V
    //   364: aload_0
    //   365: getfield bxz : Lcom/laiqian/member/create/VipCreateDialog;
    //   368: getfield bww : Landroid/widget/EditText;
    //   371: ldc '0'
    //   373: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   376: return
    //   377: iload #10
    //   379: iconst_1
    //   380: iadd
    //   381: istore #10
    //   383: goto -> 153
    // Exception table:
    //   from	to	target	type
    //   0	99	359	java/lang/NumberFormatException
    //   100	112	359	java/lang/NumberFormatException
    //   113	123	359	java/lang/NumberFormatException
    //   126	150	359	java/lang/NumberFormatException
    //   156	199	359	java/lang/NumberFormatException
    //   206	216	359	java/lang/NumberFormatException
    //   219	279	359	java/lang/NumberFormatException
    //   294	317	359	java/lang/NumberFormatException
    //   320	345	359	java/lang/NumberFormatException
    //   346	358	359	java/lang/NumberFormatException }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */