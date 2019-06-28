package com.laiqian.ui.cropper.a;

import android.content.Context;
import android.util.Pair;
import android.util.TypedValue;
import com.laiqian.ui.cropper.cropwindow.CropOverlayView;
import com.laiqian.ui.cropper.cropwindow.b.c;

public class b {
  public static Pair<Float, Float> a(c paramc, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) { // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: getstatic com/laiqian/ui/cropper/a/c.dzb : [I
    //   9: aload_0
    //   10: invokevirtual ordinal : ()I
    //   13: iaload
    //   14: istore #9
    //   16: fconst_0
    //   17: fstore #7
    //   19: fconst_0
    //   20: fstore #8
    //   22: iload #9
    //   24: tableswitch default -> 76, 1 -> 205, 2 -> 188, 3 -> 172, 4 -> 155, 5 -> 146, 6 -> 135, 7 -> 127, 8 -> 116, 9 -> 84
    //   76: fload #8
    //   78: fstore_2
    //   79: fconst_0
    //   80: fstore_1
    //   81: goto -> 216
    //   84: fload #5
    //   86: fload_3
    //   87: fadd
    //   88: fconst_2
    //   89: fdiv
    //   90: fstore_3
    //   91: fload #4
    //   93: fload #6
    //   95: fadd
    //   96: fconst_2
    //   97: fdiv
    //   98: fstore #4
    //   100: fload_3
    //   101: fload_1
    //   102: fsub
    //   103: fstore_1
    //   104: fload #4
    //   106: fload_2
    //   107: fsub
    //   108: fstore_3
    //   109: fload_1
    //   110: fstore_2
    //   111: fload_3
    //   112: fstore_1
    //   113: goto -> 216
    //   116: fload #6
    //   118: fload_2
    //   119: fsub
    //   120: fstore_1
    //   121: fload #7
    //   123: fstore_2
    //   124: goto -> 216
    //   127: fload #5
    //   129: fload_1
    //   130: fsub
    //   131: fstore_1
    //   132: goto -> 150
    //   135: fload #4
    //   137: fload_2
    //   138: fsub
    //   139: fstore_1
    //   140: fload #7
    //   142: fstore_2
    //   143: goto -> 216
    //   146: fload_3
    //   147: fload_1
    //   148: fsub
    //   149: fstore_1
    //   150: fload_1
    //   151: fstore_2
    //   152: goto -> 79
    //   155: fload #5
    //   157: fload_1
    //   158: fsub
    //   159: fstore_1
    //   160: fload #6
    //   162: fload_2
    //   163: fsub
    //   164: fstore_3
    //   165: fload_1
    //   166: fstore_2
    //   167: fload_3
    //   168: fstore_1
    //   169: goto -> 216
    //   172: fload_3
    //   173: fload_1
    //   174: fsub
    //   175: fstore_1
    //   176: fload #6
    //   178: fload_2
    //   179: fsub
    //   180: fstore_3
    //   181: fload_1
    //   182: fstore_2
    //   183: fload_3
    //   184: fstore_1
    //   185: goto -> 216
    //   188: fload #5
    //   190: fload_1
    //   191: fsub
    //   192: fstore_1
    //   193: fload #4
    //   195: fload_2
    //   196: fsub
    //   197: fstore_3
    //   198: fload_1
    //   199: fstore_2
    //   200: fload_3
    //   201: fstore_1
    //   202: goto -> 216
    //   205: fload_3
    //   206: fload_1
    //   207: fsub
    //   208: fstore_3
    //   209: fload #4
    //   211: fload_2
    //   212: fsub
    //   213: fstore_1
    //   214: fload_3
    //   215: fstore_2
    //   216: new android/util/Pair
    //   219: dup
    //   220: fload_2
    //   221: invokestatic valueOf : (F)Ljava/lang/Float;
    //   224: fload_1
    //   225: invokestatic valueOf : (F)Ljava/lang/Float;
    //   228: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   231: areturn }
  
  public static c a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7) { return a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat7) ? c.dyM : (a(paramFloat1, paramFloat2, paramFloat5, paramFloat4, paramFloat7) ? c.dyN : (a(paramFloat1, paramFloat2, paramFloat3, paramFloat6, paramFloat7) ? c.dyO : (a(paramFloat1, paramFloat2, paramFloat5, paramFloat6, paramFloat7) ? c.dyP : ((c(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6) && arf()) ? c.dyU : (a(paramFloat1, paramFloat2, paramFloat3, paramFloat5, paramFloat4, paramFloat7) ? c.dyR : (a(paramFloat1, paramFloat2, paramFloat3, paramFloat5, paramFloat6, paramFloat7) ? c.dyT : (b(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat6, paramFloat7) ? c.dyQ : (b(paramFloat1, paramFloat2, paramFloat5, paramFloat4, paramFloat6, paramFloat7) ? c.dyS : ((c(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6) && !arf()) ? c.dyU : null))))))))); }
  
  private static boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) { return (Math.abs(paramFloat1 - paramFloat3) <= paramFloat5 && Math.abs(paramFloat2 - paramFloat4) <= paramFloat5); }
  
  private static boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) { return (paramFloat1 > paramFloat3 && paramFloat1 < paramFloat4 && Math.abs(paramFloat2 - paramFloat5) <= paramFloat6); }
  
  private static boolean arf() { return CropOverlayView.arb() ^ true; }
  
  private static boolean b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) { return (Math.abs(paramFloat1 - paramFloat3) <= paramFloat6 && paramFloat2 > paramFloat4 && paramFloat2 < paramFloat5); }
  
  public static float bC(Context paramContext) { return TypedValue.applyDimension(1, 24.0F, paramContext.getResources().getDisplayMetrics()); }
  
  private static boolean c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) { return (paramFloat1 > paramFloat3 && paramFloat1 < paramFloat5 && paramFloat2 > paramFloat4 && paramFloat2 < paramFloat6); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */