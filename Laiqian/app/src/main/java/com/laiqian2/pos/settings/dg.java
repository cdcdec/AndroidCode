package com.laiqian.pos.settings;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import kotlin.Metadata;

@Metadata
final class dg implements w.a {
  dg(ShopMoreInfoSettingsFragment.c paramc) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public final void dL(int paramInt) { // Byte code:
    //   0: aload_0
    //   1: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   4: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   7: astore_2
    //   8: new java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore_3
    //   16: aload_3
    //   17: ldc 'products/'
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_3
    //   24: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   27: invokevirtual Tx : ()Ljava/lang/String;
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_3
    //   35: ldc '/'
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: ldc 'cover_figure.png'
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: aload_3
    //   50: invokevirtual toString : ()Ljava/lang/String;
    //   53: invokestatic a : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;Ljava/lang/String;)V
    //   56: new com/d/a/a/a/b/c
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: astore_2
    //   64: new java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: astore_3
    //   72: aload_3
    //   73: getstatic com/laiqian/pos/hardware/q.cll : Ljava/lang/String;
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_3
    //   81: aload_0
    //   82: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   85: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   88: invokestatic b : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)Ljava/lang/String;
    //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_2
    //   96: aload_3
    //   97: invokevirtual toString : ()Ljava/lang/String;
    //   100: invokevirtual sD : (Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_2
    //   104: new java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial <init> : ()V
    //   111: astore_3
    //   112: aload_3
    //   113: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   116: invokevirtual toString : ()Ljava/lang/String;
    //   119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_3
    //   124: ldc '/laiqian/ImageCache/'
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: new java/io/File
    //   133: dup
    //   134: aload_3
    //   135: invokevirtual toString : ()Ljava/lang/String;
    //   138: aload_2
    //   139: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   142: astore_2
    //   143: aload_0
    //   144: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   147: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   150: invokestatic c : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)Ljava/util/Map;
    //   153: ifnonnull -> 176
    //   156: aload_0
    //   157: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   160: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   163: new java/util/HashMap
    //   166: dup
    //   167: invokespecial <init> : ()V
    //   170: checkcast java/util/Map
    //   173: invokestatic a : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;Ljava/util/Map;)V
    //   176: aload_0
    //   177: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   180: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   183: invokestatic c : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)Ljava/util/Map;
    //   186: aload_0
    //   187: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   190: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   193: invokestatic d : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)Ljava/lang/String;
    //   196: aload_2
    //   197: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   202: pop
    //   203: aload_2
    //   204: invokevirtual exists : ()Z
    //   207: ifeq -> 215
    //   210: aload_2
    //   211: invokevirtual delete : ()Z
    //   214: pop
    //   215: iload_1
    //   216: tableswitch default -> 248, 0 -> 448, 1 -> 314, 2 -> 260, 3 -> 249
    //   248: return
    //   249: aload_0
    //   250: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   253: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   256: invokevirtual abS : ()V
    //   259: return
    //   260: new android/content/Intent
    //   263: dup
    //   264: invokespecial <init> : ()V
    //   267: astore_2
    //   268: aload_2
    //   269: aload_0
    //   270: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   273: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   276: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   279: checkcast android/content/Context
    //   282: ldc com/laiqian/pos/WeChatProductPreview
    //   284: invokevirtual setClass : (Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   287: pop
    //   288: aload_2
    //   289: ldc 'sImageExtraName'
    //   291: aload_0
    //   292: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   295: invokevirtual aec : ()Ljava/lang/String;
    //   298: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   301: pop
    //   302: aload_0
    //   303: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   306: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   309: aload_2
    //   310: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   313: return
    //   314: aload_0
    //   315: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   318: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   321: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   324: checkcast android/content/Context
    //   327: invokestatic bH : (Landroid/content/Context;)Z
    //   330: ifne -> 347
    //   333: aload_0
    //   334: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   337: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   340: invokestatic e : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)Lcom/laiqian/pos/settings/cs;
    //   343: invokevirtual Jx : ()V
    //   346: return
    //   347: aload_0
    //   348: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   351: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   354: invokestatic g : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)Z
    //   357: ifeq -> 406
    //   360: new android/content/Intent
    //   363: dup
    //   364: ldc 'android.intent.action.GET_CONTENT'
    //   366: invokespecial <init> : (Ljava/lang/String;)V
    //   369: astore_2
    //   370: aload_2
    //   371: ldc 'android.intent.category.OPENABLE'
    //   373: invokevirtual addCategory : (Ljava/lang/String;)Landroid/content/Intent;
    //   376: pop
    //   377: aload_2
    //   378: ldc 'image/*'
    //   380: invokevirtual setType : (Ljava/lang/String;)Landroid/content/Intent;
    //   383: pop
    //   384: aload_0
    //   385: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   388: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   391: aload_2
    //   392: aload_0
    //   393: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   396: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   399: invokestatic h : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)I
    //   402: invokevirtual startActivityForResult : (Landroid/content/Intent;I)V
    //   405: return
    //   406: new android/content/Intent
    //   409: dup
    //   410: ldc 'android.intent.action.PICK'
    //   412: invokespecial <init> : (Ljava/lang/String;)V
    //   415: astore_2
    //   416: aload_2
    //   417: getstatic android/provider/MediaStore$Images$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
    //   420: ldc 'image/*'
    //   422: invokevirtual setDataAndType : (Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;
    //   425: pop
    //   426: aload_0
    //   427: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   430: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   433: aload_2
    //   434: aload_0
    //   435: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   438: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   441: invokestatic h : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)I
    //   444: invokevirtual startActivityForResult : (Landroid/content/Intent;I)V
    //   447: return
    //   448: aload_0
    //   449: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   452: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   455: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   458: checkcast android/content/Context
    //   461: invokestatic bH : (Landroid/content/Context;)Z
    //   464: ifne -> 490
    //   467: aload_0
    //   468: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   471: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   474: invokestatic e : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)Lcom/laiqian/pos/settings/cs;
    //   477: astore_2
    //   478: aload_2
    //   479: ifnonnull -> 485
    //   482: invokestatic aQI : ()V
    //   485: aload_2
    //   486: invokevirtual Jx : ()V
    //   489: return
    //   490: new android/content/Intent
    //   493: dup
    //   494: ldc 'android.media.action.IMAGE_CAPTURE'
    //   496: invokespecial <init> : (Ljava/lang/String;)V
    //   499: astore_2
    //   500: aload_2
    //   501: ldc 'output'
    //   503: aload_0
    //   504: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   507: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   510: invokestatic c : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)Ljava/util/Map;
    //   513: aload_0
    //   514: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   517: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   520: invokestatic d : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)Ljava/lang/String;
    //   523: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   528: checkcast java/io/File
    //   531: invokestatic fromFile : (Ljava/io/File;)Landroid/net/Uri;
    //   534: checkcast android/os/Parcelable
    //   537: invokevirtual putExtra : (Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   540: pop
    //   541: aload_0
    //   542: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   545: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   548: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   551: checkcast android/content/Context
    //   554: aload_2
    //   555: invokestatic c : (Landroid/content/Context;Landroid/content/Intent;)Z
    //   558: ifeq -> 583
    //   561: aload_0
    //   562: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   565: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   568: aload_2
    //   569: aload_0
    //   570: getfield cBW : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment$c;
    //   573: getfield cBV : Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;
    //   576: invokestatic f : (Lcom/laiqian/pos/settings/ShopMoreInfoSettingsFragment;)I
    //   579: invokevirtual startActivityForResult : (Landroid/content/Intent;I)V
    //   582: return
    //   583: ldc 2131627147
    //   585: invokestatic eP : (I)V
    //   588: return
    //   589: astore_2
    //   590: goto -> 215
    //   593: astore_2
    //   594: return
    // Exception table:
    //   from	to	target	type
    //   203	215	589	java/lang/Exception
    //   360	405	593	java/lang/Exception
    //   406	447	593	java/lang/Exception }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */