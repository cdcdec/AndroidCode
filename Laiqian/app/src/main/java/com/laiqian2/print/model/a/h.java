package com.laiqian.print.model.a;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.b;
import com.laiqian.print.model.b.b;
import com.laiqian.print.model.s;
import com.laiqian.print.util.b;
import com.laiqian.print.util.e;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements b {
  private static String encoding = "GB18030";
  
  private int cHr = 1;
  
  private int cHs = 0;
  
  private int height = 30;
  
  private int width = 40;
  
  static  {
  
  }
  
  private int a(PrintContent.b paramb, int paramInt1, b paramb1, int paramInt2, int paramInt3) {
    Bitmap bitmap = paramb.getBitmap();
    if (paramb1 == null)
      return bitmap.getHeight(); 
    int i = e.jh(paramInt3);
    int j = i.cHq[paramb.agj().ordinal()];
    paramInt3 = 10;
    paramInt1 = paramInt3;
    switch (j) {
      default:
        paramInt1 = paramInt3;
        break;
      case 3:
        paramInt1 = i - bitmap.getWidth();
        break;
      case 2:
        paramInt1 = (i - bitmap.getWidth()) / 2;
        break;
      case 1:
        break;
    } 
    paramb1.s(b.a(paramInt1, paramInt2, 0, bitmap));
    return bitmap.getHeight();
  }
  
  private int b(PrintContent.b paramb, int paramInt1, b paramb1, int paramInt2, int paramInt3) {
    int j;
    int i;
    String str = paramb.cGI.toString();
    try {
      String str1;
      JSONObject jSONObject = new JSONObject(str);
      String str2 = jSONObject.getString("barcode");
      String str3 = jSONObject.getString("type");
      int k = jSONObject.optInt("height", 80);
      int m = jSONObject.optInt("narrow", 2);
      int n = jSONObject.optInt("wide", 4);
      i = e.jh(paramInt3);
      j = t(str2, m);
      int i1 = i.cHq[paramb.agj().ordinal()];
      paramInt3 = 10;
      paramInt1 = paramInt3;
      switch (i1) {
        case 2:
          paramInt1 = (i - j) / 2;
        case 1:
          str1 = b.a(paramInt1, paramInt2, str3, k, 0, 0, m, n, str2);
          if (paramb1 != null)
            paramb1.s(e.getBytes(str1, encoding)); 
          return k;
        default:
          paramInt1 = paramInt3;
        case 3:
          break;
      } 
    } catch (JSONException paramb) {
      a.e(paramb);
      return 0;
    } 
    paramInt1 = i - j;
  }
  
  private void b(PrintContent paramPrintContent, s params) { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  private int c(PrintContent.b paramb, int paramInt1, b paramb1, int paramInt2, int paramInt3) {
    byte b1;
    String str2 = paramb.cGI.toString();
    int i = e.jh(paramInt3);
    paramInt3 = e.ml(str2) * 12;
    paramInt1 = paramInt3;
    if (paramb.agh())
      paramInt1 = paramInt3 * 2; 
    switch (i.cHq[paramb.agj().ordinal()]) {
      default:
        paramInt1 = 10;
        break;
      case 3:
        paramInt1 = i - paramInt1;
        break;
      case 2:
        paramInt1 = (i - paramInt1) / 2;
        break;
    } 
    if (paramb.agi()) {
      i = 50;
      paramInt3 = 2;
    } else {
      i = 25;
      paramInt3 = 1;
    } 
    if (paramb.agh()) {
      b1 = 2;
    } else {
      b1 = 1;
    } 
    String str1 = b.a(paramInt1, paramInt2, "TSS24.BF2", 0, b1, paramInt3, str2);
    if (paramb1 != null)
      paramb1.s(e.getBytes(str1, encoding)); 
    return i;
  }
  
  private int t(String paramString, int paramInt) { // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: iconst_0
    //   4: istore #4
    //   6: iconst_0
    //   7: istore #5
    //   9: iconst_0
    //   10: istore_3
    //   11: iload #4
    //   13: aload_1
    //   14: invokevirtual length : ()I
    //   17: if_icmpge -> 92
    //   20: aload_1
    //   21: iload #4
    //   23: invokevirtual charAt : (I)C
    //   26: invokestatic isDigit : (C)Z
    //   29: ifeq -> 44
    //   32: iload #5
    //   34: iconst_1
    //   35: iadd
    //   36: istore #5
    //   38: iconst_0
    //   39: istore #7
    //   41: goto -> 47
    //   44: iconst_1
    //   45: istore #7
    //   47: aload #8
    //   49: ifnull -> 68
    //   52: iload_3
    //   53: istore #6
    //   55: aload #8
    //   57: iload #7
    //   59: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   62: invokevirtual equals : (Ljava/lang/Object;)Z
    //   65: ifne -> 73
    //   68: iload_3
    //   69: iconst_1
    //   70: iadd
    //   71: istore #6
    //   73: iload #7
    //   75: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   78: astore #8
    //   80: iload #4
    //   82: iconst_1
    //   83: iadd
    //   84: istore #4
    //   86: iload #6
    //   88: istore_3
    //   89: goto -> 11
    //   92: aload_1
    //   93: invokevirtual length : ()I
    //   96: iload #5
    //   98: isub
    //   99: bipush #11
    //   101: imul
    //   102: i2d
    //   103: iload #5
    //   105: i2d
    //   106: ldc2_w 5.5
    //   109: dmul
    //   110: dadd
    //   111: ldc2_w 11.0
    //   114: dadd
    //   115: ldc2_w 13.0
    //   118: dadd
    //   119: iload_3
    //   120: bipush #11
    //   122: imul
    //   123: i2d
    //   124: dadd
    //   125: d2i
    //   126: iload_2
    //   127: imul
    //   128: ireturn }
  
  public byte[] a(PrintContent paramPrintContent, s params) {
    int j;
    int i;
    b(paramPrintContent, params);
    b b1 = new b('က');
    try {
      b1.s(b.agP().getBytes(encoding));
      b1.s(e.getBytes(b.bm(this.width, this.height), encoding));
      b1.s(e.getBytes(b.bn(2, 0), encoding));
      b1.s(e.getBytes(b.bo(this.cHr, this.cHs), encoding));
      b1.s(e.getBytes(b.agO(), encoding));
      j = paramPrintContent.Xi().size();
      int k = 0;
      i = 0;
      while (true) {
        if (k < j) {
          PrintContent.b b3 = (PrintContent.b)paramPrintContent.Xi().get(k);
          if (b3.agl()) {
            i += a(b3, k, null, 0, this.width);
          } else if (!b3.agk() && !b3.agp()) {
            if (b3.agm()) {
              i += b(b3, k, null, 0, this.width);
            } else {
              i += c(b3, k, null, 0, this.width);
            } 
          } 
        } else {
          k = this.height * 8;
          if (i < k) {
            i = (k - i) / 2;
            break;
          } 
          i = 0;
          break;
        } 
        k++;
      } 
    } catch (UnsupportedEncodingException paramPrintContent) {
      a.e(paramPrintContent);
      try {
        Log.d("tag", new String(b1.toByteArray(), encoding));
      } catch (UnsupportedEncodingException paramPrintContent) {
        a.e(paramPrintContent);
      } 
    } 
    byte b2 = 0;
    boolean bool = false;
    while (true) {
      if (b2 < j) {
        PrintContent.b b3 = (PrintContent.b)paramPrintContent.Xi().get(b2);
        if (b3.agl()) {
          i += a(b3, b2, b1, i, this.width);
        } else if (b3.agk()) {
          b1.s(b.b((byte)0, (byte)50, (byte)44));
        } else {
          if (b3.agm()) {
            i += b(b3, b2, b1, i, this.width);
          } else {
            i += c(b3, b2, b1, i, this.width);
          } 
          bool = true;
        } 
      } else {
        if (bool)
          b1.s(e.getBytes(b.bp(1, paramPrintContent.getCopies()), encoding)); 
        try {
          Log.d("tag", new String(b1.toByteArray(), encoding));
        } catch (UnsupportedEncodingException paramPrintContent) {
          a.e(paramPrintContent);
        } 
      } 
      b2++;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */