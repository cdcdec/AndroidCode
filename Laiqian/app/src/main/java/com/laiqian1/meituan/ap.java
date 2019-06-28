package com.laiqian.meituan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.JavascriptInterface;

@SuppressLint({"SetJavaScriptEnabled"})
public class ap {
  private Context context;
  
  public ap(Context paramContext) { this.context = paramContext; }
  
  @JavascriptInterface
  public void UISDKMessageHandler(String paramString1, String paramString2) { // Byte code:
    //   0: ldc 'value'
    //   2: aload_2
    //   3: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   6: pop
    //   7: aload_1
    //   8: invokevirtual hashCode : ()I
    //   11: istore_3
    //   12: iload_3
    //   13: ldc -141231924
    //   15: if_icmpeq -> 81
    //   18: iload_3
    //   19: ldc 121328988
    //   21: if_icmpeq -> 67
    //   24: iload_3
    //   25: ldc 1400459043
    //   27: if_icmpeq -> 53
    //   30: iload_3
    //   31: ldc 1733103789
    //   33: if_icmpeq -> 39
    //   36: goto -> 95
    //   39: aload_1
    //   40: ldc 'msg-token'
    //   42: invokevirtual equals : (Ljava/lang/Object;)Z
    //   45: ifeq -> 95
    //   48: iconst_0
    //   49: istore_3
    //   50: goto -> 97
    //   53: aload_1
    //   54: ldc 'msg-pigeon-refund'
    //   56: invokevirtual equals : (Ljava/lang/Object;)Z
    //   59: ifeq -> 95
    //   62: iconst_3
    //   63: istore_3
    //   64: goto -> 97
    //   67: aload_1
    //   68: ldc 'msg-pigeon-checked'
    //   70: invokevirtual equals : (Ljava/lang/Object;)Z
    //   73: ifeq -> 95
    //   76: iconst_2
    //   77: istore_3
    //   78: goto -> 97
    //   81: aload_1
    //   82: ldc 'msg-coupon-checked'
    //   84: invokevirtual equals : (Ljava/lang/Object;)Z
    //   87: ifeq -> 95
    //   90: iconst_1
    //   91: istore_3
    //   92: goto -> 97
    //   95: iconst_m1
    //   96: istore_3
    //   97: iload_3
    //   98: tableswitch default -> 128, 0 -> 129, 1 -> 163, 2 -> 163, 3 -> 163
    //   128: return
    //   129: ldc 'event'
    //   131: ldc 'msg_token'
    //   133: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   136: pop
    //   137: new android/content/Intent
    //   140: dup
    //   141: ldc 'msg-token'
    //   143: invokespecial <init> : (Ljava/lang/String;)V
    //   146: astore_1
    //   147: aload_1
    //   148: ldc 'value'
    //   150: aload_2
    //   151: invokevirtual putExtra : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   154: pop
    //   155: aload_0
    //   156: getfield context : Landroid/content/Context;
    //   159: aload_1
    //   160: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   163: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */