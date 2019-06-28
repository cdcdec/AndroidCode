package com.laiqian.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class bk {
  public static String a(Bitmap paramBitmap, Context paramContext, float paramFloat) {
    HashMap hashMap = new HashMap();
    hashMap.put(DecodeHintType.CHARACTER_SET, "utf-8");
    binaryBitmap = new BinaryBitmap(new HybridBinarizer(new bl(j.a(paramBitmap, paramFloat))));
    QRCodeReader qRCodeReader = new QRCodeReader();
    try {
      Result result = qRCodeReader.decode(binaryBitmap, hashMap);
    } catch (NotFoundException binaryBitmap) {
      a.e(binaryBitmap);
      binaryBitmap = null;
    } catch (ChecksumException binaryBitmap) {
      a.e(binaryBitmap);
    } catch (FormatException binaryBitmap) {
      a.e(binaryBitmap);
    } 
    return (binaryBitmap != null) ? binaryBitmap.getText() : null;
  }
  
  private static boolean a(Bitmap paramBitmap, String paramString) {
    File file = new File(paramString);
    if (file.exists())
      file.delete(); 
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
      fileOutputStream.flush();
      fileOutputStream.close();
      return true;
    } catch (FileNotFoundException paramBitmap) {
    
    } catch (IOException paramBitmap) {
      a.e(paramBitmap);
    } 
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2) { return a(k(paramString1, paramInt1, paramInt2), paramString2); }
  
  public static final Bitmap k(String paramString, int paramInt1, int paramInt2) { // Byte code:
    //   0: aload_0
    //   1: ifnull -> 169
    //   4: ldc ''
    //   6: aload_0
    //   7: invokevirtual equals : (Ljava/lang/Object;)Z
    //   10: ifne -> 169
    //   13: aload_0
    //   14: invokevirtual length : ()I
    //   17: iconst_1
    //   18: if_icmpge -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: new java/util/Hashtable
    //   26: dup
    //   27: invokespecial <init> : ()V
    //   30: astore #5
    //   32: aload #5
    //   34: getstatic com/google/zxing/EncodeHintType.CHARACTER_SET : Lcom/google/zxing/EncodeHintType;
    //   37: ldc 'utf-8'
    //   39: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: new com/google/zxing/qrcode/QRCodeWriter
    //   46: dup
    //   47: invokespecial <init> : ()V
    //   50: aload_0
    //   51: getstatic com/google/zxing/BarcodeFormat.QR_CODE : Lcom/google/zxing/BarcodeFormat;
    //   54: iload_1
    //   55: iload_2
    //   56: aload #5
    //   58: invokevirtual encode : (Ljava/lang/String;Lcom/google/zxing/BarcodeFormat;IILjava/util/Map;)Lcom/google/zxing/common/BitMatrix;
    //   61: astore #5
    //   63: iload_1
    //   64: iload_2
    //   65: imul
    //   66: newarray int
    //   68: astore_0
    //   69: iconst_0
    //   70: istore_3
    //   71: goto -> 171
    //   74: iload #4
    //   76: iload_1
    //   77: if_icmpge -> 200
    //   80: aload #5
    //   82: iload #4
    //   84: iload_3
    //   85: invokevirtual get : (II)Z
    //   88: ifeq -> 182
    //   91: aload_0
    //   92: iload_3
    //   93: iload_1
    //   94: imul
    //   95: iload #4
    //   97: iadd
    //   98: ldc -16777216
    //   100: iastore
    //   101: goto -> 191
    //   104: iload_1
    //   105: iload_2
    //   106: getstatic android/graphics/Bitmap$Config.ARGB_8888 : Landroid/graphics/Bitmap$Config;
    //   109: invokestatic createBitmap : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   112: astore #5
    //   114: aload #5
    //   116: aload_0
    //   117: iconst_0
    //   118: iload_1
    //   119: iconst_0
    //   120: iconst_0
    //   121: iload_1
    //   122: iload_2
    //   123: invokevirtual setPixels : ([IIIIIII)V
    //   126: aload #5
    //   128: areturn
    //   129: astore_0
    //   130: new java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial <init> : ()V
    //   137: astore #5
    //   139: aload #5
    //   141: ldc '生成二维码错误'
    //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload #5
    //   149: aload_0
    //   150: invokevirtual getMessage : ()Ljava/lang/String;
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 'log'
    //   159: aload #5
    //   161: invokevirtual toString : ()Ljava/lang/String;
    //   164: invokestatic f : (Ljava/lang/String;Ljava/lang/Object;)V
    //   167: aconst_null
    //   168: areturn
    //   169: aconst_null
    //   170: areturn
    //   171: iload_3
    //   172: iload_2
    //   173: if_icmpge -> 104
    //   176: iconst_0
    //   177: istore #4
    //   179: goto -> 74
    //   182: aload_0
    //   183: iload_3
    //   184: iload_1
    //   185: imul
    //   186: iload #4
    //   188: iadd
    //   189: iconst_m1
    //   190: iastore
    //   191: iload #4
    //   193: iconst_1
    //   194: iadd
    //   195: istore #4
    //   197: goto -> 74
    //   200: iload_3
    //   201: iconst_1
    //   202: iadd
    //   203: istore_3
    //   204: goto -> 171
    // Exception table:
    //   from	to	target	type
    //   4	21	129	com/google/zxing/WriterException
    //   23	69	129	com/google/zxing/WriterException
    //   80	91	129	com/google/zxing/WriterException
    //   104	126	129	com/google/zxing/WriterException }
  
  public static String v(Bitmap paramBitmap) {
    null = new int[paramBitmap.getWidth() * paramBitmap.getHeight()];
    paramBitmap.getPixels(null, 0, paramBitmap.getWidth(), 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(paramBitmap.getWidth(), paramBitmap.getHeight(), null)));
    multiFormatReader = new MultiFormatReader();
    try {
      result = multiFormatReader.decode(binaryBitmap);
      String str = result.getText();
      try {
        Log.e("result", result.getText());
        return str;
      } catch (NotFoundException result) {
      
      } catch (ChecksumException result) {
      
      } catch (FormatException result) {}
    } catch (NotFoundException multiFormatReader) {
      binaryBitmap = null;
    } catch (ChecksumException multiFormatReader) {
      binaryBitmap = null;
      a.e(multiFormatReader);
      return binaryBitmap;
    } catch (FormatException multiFormatReader) {
      binaryBitmap = null;
      a.e(multiFormatReader);
      return binaryBitmap;
    } 
    a.e(multiFormatReader);
    return binaryBitmap;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */