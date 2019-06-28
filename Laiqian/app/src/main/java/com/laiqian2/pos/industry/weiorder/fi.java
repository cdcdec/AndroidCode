package com.laiqian.pos.industry.weiorder;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class fi implements w.a {
  fi(WeshopInfoFragment.b paramb) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) { // Byte code:
    //   0: aload_0
    //   1: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   4: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
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
    //   24: aload_0
    //   25: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   28: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   31: invokevirtual getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   34: invokevirtual Tx : ()Ljava/lang/String;
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: ldc '/cover_figure.png'
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: aload_3
    //   50: invokevirtual toString : ()Ljava/lang/String;
    //   53: putfield chv : Ljava/lang/String;
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
    //   82: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   85: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   88: getfield chv : Ljava/lang/String;
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
    //   116: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_3
    //   121: ldc '/laiqian/ImageCache/'
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: new java/io/File
    //   130: dup
    //   131: aload_3
    //   132: invokevirtual toString : ()Ljava/lang/String;
    //   135: aload_2
    //   136: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   139: astore_2
    //   140: aload_0
    //   141: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   144: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   147: invokestatic a : (Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;)Ljava/util/HashMap;
    //   150: ifnonnull -> 171
    //   153: aload_0
    //   154: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   157: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   160: new java/util/HashMap
    //   163: dup
    //   164: invokespecial <init> : ()V
    //   167: invokestatic a : (Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;Ljava/util/HashMap;)Ljava/util/HashMap;
    //   170: pop
    //   171: aload_0
    //   172: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   175: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   178: invokestatic a : (Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;)Ljava/util/HashMap;
    //   181: aload_0
    //   182: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   185: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   188: getfield cwb : Ljava/lang/String;
    //   191: aload_2
    //   192: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   195: pop
    //   196: aload_2
    //   197: ifnull -> 212
    //   200: aload_2
    //   201: invokevirtual exists : ()Z
    //   204: ifeq -> 212
    //   207: aload_2
    //   208: invokevirtual delete : ()Z
    //   211: pop
    //   212: iload_1
    //   213: tableswitch default -> 244, 0 -> 422, 1 -> 307, 2 -> 256, 3 -> 245
    //   244: return
    //   245: aload_0
    //   246: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   249: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   252: invokevirtual abS : ()V
    //   255: return
    //   256: new android/content/Intent
    //   259: dup
    //   260: invokespecial <init> : ()V
    //   263: astore_2
    //   264: aload_2
    //   265: aload_0
    //   266: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   269: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   272: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   275: ldc com/laiqian/pos/WeChatProductPreview
    //   277: invokevirtual setClass : (Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   280: pop
    //   281: aload_2
    //   282: ldc 'sImageExtraName'
    //   284: aload_0
    //   285: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   288: getfield chZ : Ljava/lang/String;
    //   291: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   294: pop
    //   295: aload_0
    //   296: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   299: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   302: aload_2
    //   303: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   306: return
    //   307: aload_0
    //   308: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   311: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   314: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   317: invokestatic bH : (Landroid/content/Context;)Z
    //   320: ifne -> 337
    //   323: aload_0
    //   324: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   327: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   330: getfield cvS : Lcom/laiqian/pos/industry/weiorder/fj;
    //   333: invokevirtual Jx : ()V
    //   336: return
    //   337: aload_0
    //   338: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   341: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   344: getfield chl : Z
    //   347: ifeq -> 388
    //   350: new android/content/Intent
    //   353: dup
    //   354: ldc 'android.intent.action.GET_CONTENT'
    //   356: invokespecial <init> : (Ljava/lang/String;)V
    //   359: astore_2
    //   360: aload_2
    //   361: ldc 'android.intent.category.OPENABLE'
    //   363: invokevirtual addCategory : (Ljava/lang/String;)Landroid/content/Intent;
    //   366: pop
    //   367: aload_2
    //   368: ldc 'image/*'
    //   370: invokevirtual setType : (Ljava/lang/String;)Landroid/content/Intent;
    //   373: pop
    //   374: aload_0
    //   375: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   378: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   381: aload_2
    //   382: bipush #11
    //   384: invokevirtual startActivityForResult : (Landroid/content/Intent;I)V
    //   387: return
    //   388: new android/content/Intent
    //   391: dup
    //   392: ldc 'android.intent.action.PICK'
    //   394: invokespecial <init> : (Ljava/lang/String;)V
    //   397: astore_2
    //   398: aload_2
    //   399: getstatic android/provider/MediaStore$Images$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
    //   402: ldc 'image/*'
    //   404: invokevirtual setDataAndType : (Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;
    //   407: pop
    //   408: aload_0
    //   409: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   412: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   415: aload_2
    //   416: bipush #11
    //   418: invokevirtual startActivityForResult : (Landroid/content/Intent;I)V
    //   421: return
    //   422: aload_0
    //   423: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   426: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   429: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   432: invokestatic bH : (Landroid/content/Context;)Z
    //   435: ifne -> 452
    //   438: aload_0
    //   439: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   442: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   445: getfield cvS : Lcom/laiqian/pos/industry/weiorder/fj;
    //   448: invokevirtual Jx : ()V
    //   451: return
    //   452: new android/content/Intent
    //   455: dup
    //   456: ldc 'android.media.action.IMAGE_CAPTURE'
    //   458: invokespecial <init> : (Ljava/lang/String;)V
    //   461: astore_2
    //   462: aload_2
    //   463: ldc 'output'
    //   465: aload_0
    //   466: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   469: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   472: invokestatic a : (Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;)Ljava/util/HashMap;
    //   475: aload_0
    //   476: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   479: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   482: getfield cwb : Ljava/lang/String;
    //   485: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   488: checkcast java/io/File
    //   491: invokestatic fromFile : (Ljava/io/File;)Landroid/net/Uri;
    //   494: invokevirtual putExtra : (Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   497: pop
    //   498: aload_0
    //   499: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   502: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   505: invokevirtual getActivity : ()Landroid/support/v4/app/FragmentActivity;
    //   508: aload_2
    //   509: invokestatic c : (Landroid/content/Context;Landroid/content/Intent;)Z
    //   512: ifeq -> 529
    //   515: aload_0
    //   516: getfield cwn : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment$b;
    //   519: getfield cwf : Lcom/laiqian/pos/industry/weiorder/WeshopInfoFragment;
    //   522: aload_2
    //   523: bipush #12
    //   525: invokevirtual startActivityForResult : (Landroid/content/Intent;I)V
    //   528: return
    //   529: ldc 2131627147
    //   531: invokestatic eP : (I)V
    //   534: return
    //   535: astore_2
    //   536: goto -> 212
    //   539: astore_2
    //   540: return
    // Exception table:
    //   from	to	target	type
    //   200	212	535	java/lang/Exception
    //   350	387	539	java/lang/Exception
    //   388	421	539	java/lang/Exception }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\fi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */