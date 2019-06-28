package com.laiqian.print.util;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.PrintContent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
  static Integer[] cOA;
  
  private static Pattern cOB;
  
  private static Integer[] cOC;
  
  private static Integer[][] cOD;
  
  static Integer[] cOz = { 
      null, null, null, null, null, null, null, null, null, null, 
      null, null, null, null, null, null, null, null, null, null, 
      null, null, null, (new Integer[24][22] = (new Integer[24][21] = (new Integer[24][20] = (new Integer[24][19] = (new Integer[24][18] = (new Integer[24][17] = (new Integer[24][16] = (new Integer[24][15] = (new Integer[24][14] = (new Integer[24][13] = (new Integer[24][12] = (new Integer[24][11] = (new Integer[24][10] = (new Integer[24][9] = (new Integer[24][8] = (new Integer[24][7] = (new Integer[24][6] = (new Integer[24][5] = (new Integer[24][4] = (new Integer[24][3] = (new Integer[24][2] = (new Integer[24][1] = (new Integer[24][0] = Integer.valueOf(1574)).valueOf(1576)).valueOf(1578)).valueOf(1579)).valueOf(1580)).valueOf(1581)).valueOf(1582)).valueOf(1587)).valueOf(1588)).valueOf(1589)).valueOf(1590)).valueOf(1591)).valueOf(1592)).valueOf(1593)).valueOf(1594)).valueOf(1600)).valueOf(1601)).valueOf(1602)).valueOf(1603)).valueOf(1604)).valueOf(1605)).valueOf(1606)).valueOf(1607)).valueOf(1610) };
  
  static  {
    cOA = new Integer[] { 
        null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null, null, (new Integer[36][34] = (new Integer[36][33] = (new Integer[36][32] = (new Integer[36][31] = (new Integer[36][30] = (new Integer[36][29] = (new Integer[36][28] = (new Integer[36][27] = (new Integer[36][26] = (new Integer[36][25] = (new Integer[36][24] = (new Integer[36][23] = (new Integer[36][22] = (new Integer[36][21] = (new Integer[36][20] = (new Integer[36][19] = (new Integer[36][18] = (new Integer[36][17] = (new Integer[36][16] = (new Integer[36][15] = (new Integer[36][14] = (new Integer[36][13] = (new Integer[36][12] = (new Integer[36][11] = (new Integer[36][10] = (new Integer[36][9] = (new Integer[36][8] = (new Integer[36][7] = (new Integer[36][6] = (new Integer[36][5] = (new Integer[36][4] = (new Integer[36][3] = (new Integer[36][2] = (new Integer[36][1] = (new Integer[36][0] = Integer.valueOf(1570)).valueOf(1571)).valueOf(1572)).valueOf(1573)).valueOf(1574)).valueOf(1575)).valueOf(1576)).valueOf(1577)).valueOf(1578)).valueOf(1579)).valueOf(1580)).valueOf(1581)).valueOf(1582)).valueOf(1583)).valueOf(1584)).valueOf(1585)).valueOf(1586)).valueOf(1587)).valueOf(1588)).valueOf(1589)).valueOf(1590)).valueOf(1591)).valueOf(1592)).valueOf(1593)).valueOf(1594)).valueOf(1600)).valueOf(1601)).valueOf(1602)).valueOf(1603)).valueOf(1604)).valueOf(1605)).valueOf(1606)).valueOf(1607)).valueOf(1608)).valueOf(1609)).valueOf(1610) };
    cOB = Pattern.compile("([a-zA-Z0-9!@#$^&*\\(\\)~\\{\\}:\",\\.<>/]+)");
    cOC = new Integer[] { 
        null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null, null, null, null, null, null, null, 
        null, null, null, null, null, null, null, null, null, (new Integer[40][38] = (new Integer[40][37] = (new Integer[40][36] = (new Integer[40][35] = (new Integer[40][34] = (new Integer[40][33] = (new Integer[40][32] = (new Integer[40][31] = (new Integer[40][30] = (new Integer[40][29] = (new Integer[40][28] = (new Integer[40][27] = (new Integer[40][26] = (new Integer[40][25] = (new Integer[40][24] = (new Integer[40][23] = (new Integer[40][22] = (new Integer[40][21] = (new Integer[40][20] = (new Integer[40][19] = (new Integer[40][18] = (new Integer[40][17] = (new Integer[40][16] = (new Integer[40][15] = (new Integer[40][14] = (new Integer[40][13] = (new Integer[40][12] = (new Integer[40][11] = (new Integer[40][10] = (new Integer[40][9] = (new Integer[40][8] = (new Integer[40][7] = (new Integer[40][6] = (new Integer[40][5] = (new Integer[40][4] = (new Integer[40][3] = (new Integer[40][2] = (new Integer[40][1] = (new Integer[40][0] = Integer.valueOf(1569)).valueOf(1570)).valueOf(1571)).valueOf(1572)).valueOf(1573)).valueOf(1574)).valueOf(1575)).valueOf(1576)).valueOf(1577)).valueOf(1578)).valueOf(1579)).valueOf(1580)).valueOf(1581)).valueOf(1582)).valueOf(1583)).valueOf(1584)).valueOf(1585)).valueOf(1586)).valueOf(1587)).valueOf(1588)).valueOf(1589)).valueOf(1590)).valueOf(1591)).valueOf(1592)).valueOf(1593)).valueOf(1594)).valueOf(1601)).valueOf(1602)).valueOf(1603)).valueOf(1604)).valueOf(1605)).valueOf(1606)).valueOf(1607)).valueOf(1608)).valueOf(1609)).valueOf(1610)).valueOf(17442)).valueOf(17443)).valueOf(17445)).valueOf(17447) };
    Integer[] arrayOfInteger1 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65152)).valueOf(65152)).valueOf(65152)).valueOf(65152) };
    Integer[] arrayOfInteger2 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65153)).valueOf(65154)).valueOf(65153)).valueOf(65154) };
    Integer[] arrayOfInteger3 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65155)).valueOf(65156)).valueOf(65155)).valueOf(65156) };
    Integer[] arrayOfInteger4 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65157)).valueOf(65157)).valueOf(65157)).valueOf(65157) };
    Integer[] arrayOfInteger5 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65149)).valueOf(65149)).valueOf(65149)).valueOf(65149) };
    Integer[] arrayOfInteger6 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65163)).valueOf(65163)).valueOf(65163)).valueOf(65163) };
    Integer[] arrayOfInteger7 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65165)).valueOf(65166)).valueOf(65165)).valueOf(65166) };
    Integer[] arrayOfInteger8 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65167)).valueOf(65167)).valueOf(65169)).valueOf(65169) };
    Integer[] arrayOfInteger9 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65171)).valueOf(65171)).valueOf(65171)).valueOf(65171) };
    Integer[] arrayOfInteger10 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65173)).valueOf(65173)).valueOf(65175)).valueOf(65175) };
    Integer[] arrayOfInteger11 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65177)).valueOf(65177)).valueOf(65179)).valueOf(65179) };
    Integer[] arrayOfInteger12 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65181)).valueOf(65181)).valueOf(65183)).valueOf(65183) };
    Integer[] arrayOfInteger13 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65185)).valueOf(65185)).valueOf(65187)).valueOf(65187) };
    Integer[] arrayOfInteger14 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65189)).valueOf(65189)).valueOf(65191)).valueOf(65191) };
    Integer[] arrayOfInteger15 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65195)).valueOf(65195)).valueOf(65195)).valueOf(65195) };
    Integer[] arrayOfInteger16 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65197)).valueOf(65197)).valueOf(65197)).valueOf(65197) };
    Integer[] arrayOfInteger17 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65199)).valueOf(65199)).valueOf(65199)).valueOf(65199) };
    Integer[] arrayOfInteger18 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65201)).valueOf(65201)).valueOf(65203)).valueOf(65203) };
    Integer[] arrayOfInteger19 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65205)).valueOf(65205)).valueOf(65207)).valueOf(65207) };
    Integer[] arrayOfInteger20 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65209)).valueOf(65209)).valueOf(65211)).valueOf(65211) };
    Integer[] arrayOfInteger21 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65213)).valueOf(65213)).valueOf(65215)).valueOf(65215) };
    Integer[] arrayOfInteger22 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65217)).valueOf(65217)).valueOf(65217)).valueOf(65217) };
    Integer[] arrayOfInteger23 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65221)).valueOf(65221)).valueOf(65221)).valueOf(65221) };
    Integer[] arrayOfInteger24 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65225)).valueOf(65226)).valueOf(65227)).valueOf(65228) };
    Integer[] arrayOfInteger25 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65229)).valueOf(65230)).valueOf(65231)).valueOf(65232) };
    Integer[] arrayOfInteger26 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65233)).valueOf(65233)).valueOf(65235)).valueOf(65235) };
    Integer[] arrayOfInteger27 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65237)).valueOf(65237)).valueOf(65239)).valueOf(65239) };
    Integer[] arrayOfInteger28 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65245)).valueOf(65245)).valueOf(65247)).valueOf(65247) };
    Integer[] arrayOfInteger29 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65249)).valueOf(65249)).valueOf(65251)).valueOf(65251) };
    Integer[] arrayOfInteger30 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65253)).valueOf(65253)).valueOf(65255)).valueOf(65255) };
    Integer[] arrayOfInteger31 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65257)).valueOf(65257)).valueOf(65259)).valueOf(65259) };
    Integer[] arrayOfInteger32 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65261)).valueOf(65261)).valueOf(65261)).valueOf(65261) };
    Integer[] arrayOfInteger33 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65263)).valueOf(65264)).valueOf(65263)).valueOf(65264) };
    Integer[] arrayOfInteger34 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65265)).valueOf(65266)).valueOf(65267)).valueOf(65267) };
    Integer[] arrayOfInteger35 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65269)).valueOf(65270)).valueOf(65269)).valueOf(65270) };
    Integer[] arrayOfInteger36 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65271)).valueOf(65272)).valueOf(65271)).valueOf(65272) };
    Integer[] arrayOfInteger37 = { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65275)).valueOf(65276)).valueOf(65275)).valueOf(65276) };
    cOD = new Integer[][] { 
        arrayOfInteger1, arrayOfInteger2, arrayOfInteger3, arrayOfInteger4, arrayOfInteger5, arrayOfInteger6, arrayOfInteger7, arrayOfInteger8, arrayOfInteger9, arrayOfInteger10, 
        arrayOfInteger11, arrayOfInteger12, arrayOfInteger13, arrayOfInteger14, { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65193)).valueOf(65193)).valueOf(65193)).valueOf(65193) }, arrayOfInteger15, arrayOfInteger16, arrayOfInteger17, arrayOfInteger18, arrayOfInteger19, 
        arrayOfInteger20, arrayOfInteger21, arrayOfInteger22, arrayOfInteger23, arrayOfInteger24, arrayOfInteger25, arrayOfInteger26, arrayOfInteger27, { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65241)).valueOf(65241)).valueOf(65243)).valueOf(65243) }, arrayOfInteger28, 
        arrayOfInteger29, arrayOfInteger30, arrayOfInteger31, arrayOfInteger32, arrayOfInteger33, arrayOfInteger34, arrayOfInteger35, arrayOfInteger36, { null, null, null, (new Integer[4][2] = (new Integer[4][1] = (new Integer[4][0] = Integer.valueOf(65273)).valueOf(65274)).valueOf(65273)).valueOf(65274) }, arrayOfInteger37 };
  }
  
  private static List<Integer> G(List<Integer> paramList) {
    for (byte b = 0; b < paramList.size(); b++) {
      if (((Integer)paramList.get(b)).intValue() == 1604) {
        byte b1 = b + 1;
        if (b1 < paramList.size())
          switch (((Integer)paramList.get(b1)).intValue()) {
            case 1575:
              paramList.set(b, Integer.valueOf(17447));
              paramList.remove(b1);
              break;
            case 1573:
              paramList.set(b, Integer.valueOf(17445));
              paramList.remove(b1);
              break;
            case 1571:
              paramList.set(b, Integer.valueOf(17443));
              paramList.remove(b1);
              break;
            case 1570:
              paramList.set(b, Integer.valueOf(17442));
              paramList.remove(b1);
              break;
          }  
      } 
    } 
    return paramList;
  }
  
  private static List<Integer> H(List<Integer> paramList) {
    ArrayList arrayList = new ArrayList();
    HashMap hashMap = new HashMap(40);
    int i;
    for (i = 0; i < 40; i++)
      hashMap.put(cOC[i], cOD[i]); 
    for (byte b = 0; b < paramList.size(); b++) {
      try {
        if (a((Integer)paramList.get(b), 0)) {
          if (b == 0) {
            i = t(false, a((Integer)paramList.get(b + 1), 2));
          } else if (b == paramList.size() - 1) {
            i = t(a((Integer)paramList.get(b - 1), 1), false);
          } else {
            i = t(a((Integer)paramList.get(b - 1), 1), a((Integer)paramList.get(b + 1), 2));
          } 
          arrayList.add((Integer[])hashMap.get(paramList.get(b))[i]);
        } else {
          arrayList.add(paramList.get(b));
        } 
      } catch (Exception exception) {
        a.e(exception);
      } 
    } 
    return arrayList;
  }
  
  public static Bitmap a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setTypeface(Typeface.MONOSPACE);
    float f = paramInt / 58.0F * 24.0F;
    if (paramBoolean2 && paramBoolean1) {
      paint.setTextSize(f * 2.0F);
    } else if (paramBoolean2) {
      paint.setTextSize(f * 2.0F);
      paint.setTextScaleX(0.5F);
    } else if (paramBoolean1) {
      paint.setTextSize(f);
      paint.setTextScaleX(2.0F);
    } else {
      paint.setTextSize(f);
    } 
    paint.setColor(-16777216);
    paint.setTextAlign(Paint.Align.LEFT);
    Paint.FontMetrics fontMetrics = paint.getFontMetrics();
    f = -fontMetrics.top;
    Bitmap bitmap = Bitmap.createBitmap((int)(paint.measureText(paramString) + 0.5F), (int)(fontMetrics.bottom + f + 0.5F), Bitmap.Config.ARGB_4444);
    Canvas canvas = new Canvas(bitmap);
    canvas.drawColor(-1);
    canvas.drawText(paramString, 0.0F, f, paint);
    return bitmap;
  }
  
  private static String a(BluetoothClass paramBluetoothClass) {
    try {
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("class", paramBluetoothClass.hashCode());
      JSONObject jSONObject2 = new JSONObject();
      jSONObject2.put("audio", paramBluetoothClass.hasService(2097152));
      jSONObject2.put("capture", paramBluetoothClass.hasService(524288));
      jSONObject2.put("information", paramBluetoothClass.hasService(8388608));
      jSONObject2.put("limitedDiscoverability", paramBluetoothClass.hasService(8192));
      jSONObject2.put("networking", paramBluetoothClass.hasService(131072));
      jSONObject2.put("objectTransfer", paramBluetoothClass.hasService(1048576));
      jSONObject2.put("positioning", paramBluetoothClass.hasService(65536));
      jSONObject2.put("render", paramBluetoothClass.hasService(262144));
      jSONObject2.put("telephony", paramBluetoothClass.hasService(4194304));
      jSONObject1.put("services", jSONObject2);
      jSONObject1.put("deviceClass", paramBluetoothClass.getDeviceClass());
      jSONObject1.put("majorDeviceClass", paramBluetoothClass.getMajorDeviceClass());
      return jSONObject1.toString();
    } catch (JSONException paramBluetoothClass) {
      a.e(paramBluetoothClass);
      return "";
    } 
  }
  
  public static String a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString) {
    if (paramArrayOfInt1 == null || paramArrayOfString == null || paramArrayOfInt2 == null)
      throw new IllegalArgumentException("null parameters"); 
    int j = paramArrayOfInt1.length;
    if (paramArrayOfInt2.length != j || paramArrayOfString.length != j)
      throw new IllegalArgumentException("array length doesn't match"); 
    StringBuilder stringBuilder = new StringBuilder();
    int i = stringBuilder.length();
    byte b = 0;
    while (b < j) {
      int k = paramArrayOfInt1[b];
      int m = paramArrayOfInt2[b];
      String str = paramArrayOfString[b];
      if (paramArrayOfInt1[b] <= i) {
        stringBuilder.append(paramArrayOfString[b]);
      } else {
        int n = ml(paramArrayOfString[b]);
        k = paramArrayOfInt1[b] - i;
        i = k;
        if (m == 2)
          i = k - n; 
        k = i;
        if (i < 1)
          k = 1; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("%");
        stringBuilder1.append(k);
        stringBuilder1.append("s%s");
        stringBuilder.append(String.format(stringBuilder1.toString(), new Object[] { "", paramArrayOfString[b] }));
      } 
      b++;
      i = ml(stringBuilder.toString());
    } 
    return stringBuilder.toString();
  }
  
  public static String a(@NonNull int[] paramArrayOfInt1, @NonNull int[] paramArrayOfInt2, @NonNull String[] paramArrayOfString, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: istore #5
    //   4: aload_1
    //   5: arraylength
    //   6: iload #5
    //   8: if_icmpne -> 610
    //   11: aload_2
    //   12: arraylength
    //   13: iload #5
    //   15: if_icmpeq -> 21
    //   18: goto -> 610
    //   21: iload_3
    //   22: ifge -> 59
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore_0
    //   33: aload_0
    //   34: ldc_w 'gap must >= 0, but '
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_0
    //   42: iload_3
    //   43: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: new java/lang/IllegalArgumentException
    //   50: dup
    //   51: aload_0
    //   52: invokevirtual toString : ()Ljava/lang/String;
    //   55: invokespecial <init> : (Ljava/lang/String;)V
    //   58: athrow
    //   59: new java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial <init> : ()V
    //   66: astore #11
    //   68: iconst_0
    //   69: istore #4
    //   71: iload #4
    //   73: iload #5
    //   75: if_icmpge -> 604
    //   78: aload_0
    //   79: iload #4
    //   81: iaload
    //   82: istore #7
    //   84: iload #7
    //   86: iload_3
    //   87: isub
    //   88: istore #8
    //   90: aload_1
    //   91: iload #4
    //   93: iaload
    //   94: istore #6
    //   96: aload_2
    //   97: iload #4
    //   99: aaload
    //   100: astore #10
    //   102: aload #10
    //   104: astore #9
    //   106: aload #10
    //   108: invokestatic ml : (Ljava/lang/String;)I
    //   111: iload #8
    //   113: if_icmple -> 132
    //   116: aload #10
    //   118: iconst_0
    //   119: aload #10
    //   121: iload #8
    //   123: invokestatic y : (Ljava/lang/String;I)D
    //   126: d2i
    //   127: invokevirtual substring : (II)Ljava/lang/String;
    //   130: astore #9
    //   132: iload #7
    //   134: aload #9
    //   136: invokestatic ml : (Ljava/lang/String;)I
    //   139: isub
    //   140: istore #7
    //   142: aload #9
    //   144: astore #10
    //   146: aload #9
    //   148: invokestatic mm : (Ljava/lang/String;)Z
    //   151: ifeq -> 257
    //   154: aload #9
    //   156: invokestatic mp : (Ljava/lang/String;)[B
    //   159: astore #10
    //   161: ldc_w 'cp864'
    //   164: invokestatic forName : (Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   167: astore #12
    //   169: aload #12
    //   171: invokevirtual newDecoder : ()Ljava/nio/charset/CharsetDecoder;
    //   174: getstatic java/nio/charset/CodingErrorAction.IGNORE : Ljava/nio/charset/CodingErrorAction;
    //   177: invokevirtual onMalformedInput : (Ljava/nio/charset/CodingErrorAction;)Ljava/nio/charset/CharsetDecoder;
    //   180: getstatic java/nio/charset/CodingErrorAction.IGNORE : Ljava/nio/charset/CodingErrorAction;
    //   183: invokevirtual onUnmappableCharacter : (Ljava/nio/charset/CodingErrorAction;)Ljava/nio/charset/CharsetDecoder;
    //   186: aload #10
    //   188: invokestatic wrap : ([B)Ljava/nio/ByteBuffer;
    //   191: invokevirtual decode : (Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;
    //   194: astore #12
    //   196: aload #12
    //   198: invokevirtual length : ()I
    //   201: istore #8
    //   203: aload #9
    //   205: astore #10
    //   207: iload #8
    //   209: ifle -> 257
    //   212: iload #8
    //   214: newarray char
    //   216: astore #10
    //   218: aload #12
    //   220: invokevirtual array : ()[C
    //   223: iconst_0
    //   224: aload #10
    //   226: iconst_0
    //   227: iload #8
    //   229: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   232: new java/lang/String
    //   235: dup
    //   236: aload #10
    //   238: invokespecial <init> : ([C)V
    //   241: astore #10
    //   243: goto -> 257
    //   246: astore #10
    //   248: aload #10
    //   250: invokestatic e : (Ljava/lang/Throwable;)V
    //   253: aload #9
    //   255: astore #10
    //   257: iload #7
    //   259: ifgt -> 273
    //   262: aload #11
    //   264: aload #10
    //   266: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: goto -> 595
    //   273: iload #6
    //   275: tableswitch default -> 296, 1 -> 430, 2 -> 363
    //   296: new java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial <init> : ()V
    //   303: astore #9
    //   305: aload #9
    //   307: ldc_w '%1$s%2$'
    //   310: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload #9
    //   316: iload #7
    //   318: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload #9
    //   324: ldc_w 's'
    //   327: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload #11
    //   333: aload #9
    //   335: invokevirtual toString : ()Ljava/lang/String;
    //   338: iconst_2
    //   339: anewarray java/lang/Object
    //   342: dup
    //   343: iconst_0
    //   344: aload #10
    //   346: aastore
    //   347: dup
    //   348: iconst_1
    //   349: ldc_w ''
    //   352: aastore
    //   353: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   356: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: goto -> 595
    //   363: new java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial <init> : ()V
    //   370: astore #9
    //   372: aload #9
    //   374: ldc_w '%2$'
    //   377: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload #9
    //   383: iload #7
    //   385: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload #9
    //   391: ldc_w 's%1$s'
    //   394: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload #11
    //   400: aload #9
    //   402: invokevirtual toString : ()Ljava/lang/String;
    //   405: iconst_2
    //   406: anewarray java/lang/Object
    //   409: dup
    //   410: iconst_0
    //   411: aload #10
    //   413: aastore
    //   414: dup
    //   415: iconst_1
    //   416: ldc_w ''
    //   419: aastore
    //   420: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   423: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: goto -> 595
    //   430: iload #7
    //   432: iconst_2
    //   433: idiv
    //   434: istore #6
    //   436: iload #6
    //   438: ifne -> 511
    //   441: new java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial <init> : ()V
    //   448: astore #9
    //   450: aload #9
    //   452: ldc_w '%1$s%2$'
    //   455: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload #9
    //   461: iload #7
    //   463: iload #6
    //   465: isub
    //   466: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload #9
    //   472: ldc_w 's'
    //   475: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload #11
    //   481: aload #9
    //   483: invokevirtual toString : ()Ljava/lang/String;
    //   486: iconst_2
    //   487: anewarray java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: aload #10
    //   494: aastore
    //   495: dup
    //   496: iconst_1
    //   497: ldc_w ''
    //   500: aastore
    //   501: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   504: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: goto -> 595
    //   511: new java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial <init> : ()V
    //   518: astore #9
    //   520: aload #9
    //   522: ldc_w '%2$'
    //   525: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload #9
    //   531: iload #6
    //   533: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload #9
    //   539: ldc_w 's%1$s%2$'
    //   542: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload #9
    //   548: iload #7
    //   550: iload #6
    //   552: isub
    //   553: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload #9
    //   559: ldc_w 's'
    //   562: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload #11
    //   568: aload #9
    //   570: invokevirtual toString : ()Ljava/lang/String;
    //   573: iconst_2
    //   574: anewarray java/lang/Object
    //   577: dup
    //   578: iconst_0
    //   579: aload #10
    //   581: aastore
    //   582: dup
    //   583: iconst_1
    //   584: ldc_w ''
    //   587: aastore
    //   588: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   591: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: iload #4
    //   597: iconst_1
    //   598: iadd
    //   599: istore #4
    //   601: goto -> 71
    //   604: aload #11
    //   606: invokevirtual toString : ()Ljava/lang/String;
    //   609: areturn
    //   610: new java/lang/IllegalArgumentException
    //   613: dup
    //   614: ldc_w 'array length doesn't match'
    //   617: invokespecial <init> : (Ljava/lang/String;)V
    //   620: athrow
    // Exception table:
    //   from	to	target	type
    //   169	203	246	java/nio/charset/CharacterCodingException
    //   212	243	246	java/nio/charset/CharacterCodingException }
  
  public static ArrayList<ArrayList<String>> a(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt1, int paramInt2) {
    int[] arrayOfInt = new int[paramArrayOfString.length];
    ArrayList arrayList = new ArrayList();
    for (paramInt1 = 0; paramInt1 < paramArrayOfString.length; paramInt1++) {
      arrayOfInt[paramInt1] = paramArrayOfInt[paramInt1] - paramInt2;
      if (arrayOfInt[paramInt1] < 0)
        arrayOfInt[paramInt1] = 0; 
      arrayList.add(x(paramArrayOfString[paramInt1], arrayOfInt[paramInt1]));
    } 
    return arrayList;
  }
  
  public static void a(PrintContent.a parama, int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString, int paramInt2) {
    if (parama != null) {
      if (paramArrayOfString == null)
        return; 
      int k = paramArrayOfString.length;
      int[] arrayOfInt1 = new int[k];
      int[] arrayOfInt3 = new int[k];
      int[] arrayOfInt2 = new int[k];
      int j = 0;
      int i;
      for (i = 0; j < k; i = m) {
        arrayOfInt2[j] = 0;
        if (paramArrayOfInt2[j] == 2) {
          if (!j) {
            m = paramArrayOfInt1[j];
          } else {
            m = j - true;
            if (paramArrayOfInt2[m] == 2) {
              m = paramArrayOfInt1[j] - paramArrayOfInt1[m];
            } else {
              m = paramArrayOfInt1[j] - paramArrayOfInt1[m] - arrayOfInt1[m];
            } 
          } 
        } else if (j == k - 1) {
          m = jg(paramInt1) - paramArrayOfInt1[j];
        } else {
          m = j + true;
          if (paramArrayOfInt2[m] == 2) {
            m = (paramArrayOfInt1[m] - paramArrayOfInt1[j]) / 2;
          } else {
            m = paramArrayOfInt1[m] - paramArrayOfInt1[j];
          } 
        } 
        int n = m;
        if (m > 2)
          n = m - 1; 
        int m = n;
        if (n < 1)
          m = 1; 
        arrayOfInt1[j] = m;
        n = ml(paramArrayOfString[j]);
        if (m == 0) {
          arrayOfInt3[j] = 1;
        } else {
          arrayOfInt3[j] = (int)Math.ceil(n / m);
        } 
        m = i;
        if (arrayOfInt3[j] > i)
          m = arrayOfInt3[j]; 
        j++;
      } 
      for (paramInt1 = 0; paramInt1 < i; paramInt1++) {
        String[] arrayOfString = new String[k];
        byte b;
        for (b = 0; b < k; b++) {
          String str = paramArrayOfString[b];
          int n = arrayOfInt1[b];
          j = str.length();
          if (arrayOfInt2[b] == 0) {
            m = 0;
          } else {
            m = ml(str.substring(0, arrayOfInt2[b]));
          } 
          double d1 = y(str, m);
          double d2 = y(str, n + m);
          int m = arrayOfInt2[b];
          arrayOfInt2[b] = arrayOfInt2[b] + (int)(d2 - d1);
          n = arrayOfInt2[b];
          if (m <= j && n > j) {
            arrayOfString[b] = paramArrayOfString[b].substring(m, j);
          } else if (m > j && n > j) {
            arrayOfString[b] = "";
          } else {
            arrayOfString[b] = paramArrayOfString[b].substring(m, n);
          } 
        } 
        parama.r(a(paramArrayOfInt1, paramArrayOfInt2, arrayOfString), paramInt2);
      } 
      return;
    } 
  }
  
  public static void a(@NonNull PrintContent.a parama, @NonNull @Size int[] paramArrayOfInt1, @NonNull @Size int[] paramArrayOfInt2, @NonNull @Size String[] paramArrayOfString, int paramInt) {
    byte b2;
    int i = paramArrayOfString.length;
    byte b1 = 0;
    while (true) {
      b2 = 1;
      if (b1 < i) {
        if (mm(paramArrayOfString[b1])) {
          b1 = 1;
          break;
        } 
        b1++;
        continue;
      } 
      b1 = 0;
      break;
    } 
    if (b1 != 0) {
      b(parama, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString, paramInt);
      return;
    } 
    paramArrayOfInt1 = c(paramArrayOfInt1, paramInt);
    b1 = b2;
    if (i == 1)
      b1 = 0; 
    ArrayList arrayList = a(paramArrayOfString, paramArrayOfInt1, paramInt, b1);
    i = an(arrayList);
    for (b1 = 0; b1 < i; b1++) {
      null = new ArrayList();
      for (b2 = 0; b2 < paramArrayOfString.length; b2++) {
        if (b1 < ((ArrayList)arrayList.get(b2)).size()) {
          null.add(((ArrayList)arrayList.get(b2)).get(b1));
        } else {
          null.add("");
        } 
      } 
      String str = b(paramArrayOfInt1, paramArrayOfInt2, (String[])null.toArray(new String[0]));
      if (mm(str)) {
        parama.q(str, paramInt);
      } else {
        parama.r(str, paramInt);
      } 
    } 
  }
  
  private static void a(char[] paramArrayOfChar, Integer[] paramArrayOfInteger, int paramInt) {
    for (byte b = 0; b < paramInt; b++)
      paramArrayOfInteger[b] = Integer.valueOf(paramArrayOfChar[b]); 
  }
  
  private static void a(@NonNull String[] paramArrayOfString, int paramInt1, int paramInt2, @NonNull ArrayList<String> paramArrayList) { // Byte code:
    //   0: iload_1
    //   1: aload_0
    //   2: arraylength
    //   3: if_icmplt -> 7
    //   6: return
    //   7: aload_0
    //   8: iload_1
    //   9: aaload
    //   10: astore #7
    //   12: aload #7
    //   14: invokestatic ml : (Ljava/lang/String;)I
    //   17: istore #4
    //   19: iconst_1
    //   20: istore #5
    //   22: iload #4
    //   24: iload_2
    //   25: if_icmple -> 116
    //   28: aload #7
    //   30: invokevirtual length : ()I
    //   33: iconst_1
    //   34: isub
    //   35: istore #4
    //   37: iload #4
    //   39: ifle -> 69
    //   42: aload #7
    //   44: iconst_0
    //   45: iload #4
    //   47: invokevirtual substring : (II)Ljava/lang/String;
    //   50: invokestatic ml : (Ljava/lang/String;)I
    //   53: iload_2
    //   54: if_icmpgt -> 60
    //   57: goto -> 72
    //   60: iload #4
    //   62: iconst_1
    //   63: isub
    //   64: istore #4
    //   66: goto -> 37
    //   69: iconst_1
    //   70: istore #4
    //   72: aload #7
    //   74: iconst_0
    //   75: iload #4
    //   77: invokevirtual substring : (II)Ljava/lang/String;
    //   80: astore #8
    //   82: aload #7
    //   84: iload #4
    //   86: aload #7
    //   88: invokevirtual length : ()I
    //   91: invokevirtual substring : (II)Ljava/lang/String;
    //   94: astore #7
    //   96: aload_3
    //   97: aload #8
    //   99: invokevirtual add : (Ljava/lang/Object;)Z
    //   102: pop
    //   103: aload_0
    //   104: iload_1
    //   105: aload #7
    //   107: aastore
    //   108: aload_0
    //   109: iload_1
    //   110: iload_2
    //   111: aload_3
    //   112: invokestatic a : ([Ljava/lang/String;IILjava/util/ArrayList;)V
    //   115: return
    //   116: iload #4
    //   118: iload_2
    //   119: if_icmpne -> 139
    //   122: aload_3
    //   123: aload #7
    //   125: invokevirtual add : (Ljava/lang/Object;)Z
    //   128: pop
    //   129: aload_0
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: iload_2
    //   134: aload_3
    //   135: invokestatic a : ([Ljava/lang/String;IILjava/util/ArrayList;)V
    //   138: return
    //   139: iconst_1
    //   140: istore #4
    //   142: iload_1
    //   143: iload #5
    //   145: iadd
    //   146: istore #6
    //   148: iload #6
    //   150: aload_0
    //   151: arraylength
    //   152: if_icmpge -> 271
    //   155: iload #6
    //   157: aload_0
    //   158: arraylength
    //   159: if_icmplt -> 165
    //   162: goto -> 271
    //   165: aload_0
    //   166: iload #6
    //   168: aaload
    //   169: astore #8
    //   171: new java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial <init> : ()V
    //   178: astore #9
    //   180: aload #9
    //   182: aload #7
    //   184: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload #9
    //   190: ldc_w ' '
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload #9
    //   199: aload #8
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload #9
    //   207: invokevirtual toString : ()Ljava/lang/String;
    //   210: invokestatic ml : (Ljava/lang/String;)I
    //   213: iload_2
    //   214: if_icmpgt -> 271
    //   217: new java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial <init> : ()V
    //   224: astore #9
    //   226: aload #9
    //   228: aload #7
    //   230: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload #9
    //   236: ldc_w ' '
    //   239: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload #9
    //   245: aload #8
    //   247: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload #9
    //   253: invokevirtual toString : ()Ljava/lang/String;
    //   256: astore #7
    //   258: iload #5
    //   260: iconst_1
    //   261: iadd
    //   262: istore #4
    //   264: iload #4
    //   266: istore #5
    //   268: goto -> 142
    //   271: aload_3
    //   272: aload #7
    //   274: invokevirtual add : (Ljava/lang/Object;)Z
    //   277: pop
    //   278: aload_0
    //   279: iload_1
    //   280: iload #4
    //   282: iadd
    //   283: iload_2
    //   284: aload_3
    //   285: invokestatic a : ([Ljava/lang/String;IILjava/util/ArrayList;)V
    //   288: return }
  
  private static boolean a(Integer paramInteger, int paramInt) {
    ArrayList arrayList = new ArrayList(3);
    arrayList.add(cOC);
    arrayList.add(cOz);
    arrayList.add(cOA);
    return a((Integer[])arrayList.get(paramInt), paramInteger.intValue());
  }
  
  private static boolean a(Integer[] paramArrayOfInteger, int paramInt) {
    for (byte b = 0; b < paramArrayOfInteger.length; b++) {
      if (paramArrayOfInteger[b].intValue() == paramInt)
        return true; 
    } 
    return false;
  }
  
  public static int an(ArrayList<ArrayList<String>> paramArrayList) {
    int i = paramArrayList.size();
    byte b = 0;
    if (i == 1)
      return ((ArrayList)paramArrayList.get(0)).size(); 
    i = 0;
    while (b < paramArrayList.size()) {
      i = Math.max(((ArrayList)paramArrayList.get(b)).size(), i);
      b++;
    } 
    return i;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2) {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix matrix = new Matrix();
    matrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, matrix, true);
  }
  
  public static String b(@NonNull int[] paramArrayOfInt1, @NonNull int[] paramArrayOfInt2, @NonNull String[] paramArrayOfString) { return a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString, 0); }
  
  public static void b(@NonNull PrintContent.a parama, @NonNull int[] paramArrayOfInt1, @NonNull int[] paramArrayOfInt2, @NonNull String[] paramArrayOfString, int paramInt) { // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: istore #12
    //   4: iload #12
    //   6: newarray int
    //   8: astore #17
    //   10: iload #12
    //   12: newarray int
    //   14: astore #18
    //   16: iload #12
    //   18: newarray int
    //   20: astore #20
    //   22: iload #12
    //   24: newarray int
    //   26: astore #19
    //   28: iconst_0
    //   29: istore #9
    //   31: iconst_0
    //   32: istore #10
    //   34: iconst_1
    //   35: istore #11
    //   37: iload #9
    //   39: iload #12
    //   41: if_icmpge -> 201
    //   44: aload #19
    //   46: iload #9
    //   48: iconst_0
    //   49: iastore
    //   50: aload_3
    //   51: iload #9
    //   53: aaload
    //   54: invokestatic ml : (Ljava/lang/String;)I
    //   57: istore #11
    //   59: iload #4
    //   61: iconst_3
    //   62: if_icmpeq -> 86
    //   65: iload #4
    //   67: iconst_2
    //   68: if_icmpne -> 74
    //   71: goto -> 86
    //   74: aload #17
    //   76: iload #9
    //   78: aload_1
    //   79: iload #9
    //   81: iaload
    //   82: iastore
    //   83: goto -> 131
    //   86: aload_1
    //   87: iload #9
    //   89: iaload
    //   90: i2d
    //   91: ldc2_w 2.0
    //   94: ddiv
    //   95: dstore #5
    //   97: iload #9
    //   99: iload #12
    //   101: iconst_1
    //   102: isub
    //   103: if_icmpne -> 120
    //   106: aload #17
    //   108: iload #9
    //   110: dload #5
    //   112: invokestatic floor : (D)D
    //   115: d2i
    //   116: iastore
    //   117: goto -> 131
    //   120: aload #17
    //   122: iload #9
    //   124: dload #5
    //   126: invokestatic round : (D)J
    //   129: l2i
    //   130: iastore
    //   131: aload #18
    //   133: iload #9
    //   135: aload #17
    //   137: iload #9
    //   139: iaload
    //   140: iconst_1
    //   141: isub
    //   142: iastore
    //   143: aload #18
    //   145: iload #9
    //   147: iaload
    //   148: istore #13
    //   150: iload #13
    //   152: ifne -> 164
    //   155: aload #20
    //   157: iload #9
    //   159: iconst_1
    //   160: iastore
    //   161: goto -> 180
    //   164: aload #20
    //   166: iload #9
    //   168: iload #11
    //   170: i2d
    //   171: iload #13
    //   173: i2d
    //   174: ddiv
    //   175: invokestatic ceil : (D)D
    //   178: d2i
    //   179: iastore
    //   180: iload #10
    //   182: aload #20
    //   184: iload #9
    //   186: iaload
    //   187: invokestatic max : (II)I
    //   190: istore #10
    //   192: iload #9
    //   194: iconst_1
    //   195: iadd
    //   196: istore #9
    //   198: goto -> 34
    //   201: aload_3
    //   202: arraylength
    //   203: istore #13
    //   205: iconst_0
    //   206: istore #9
    //   208: iload #9
    //   210: iload #13
    //   212: if_icmpge -> 237
    //   215: aload_3
    //   216: iload #9
    //   218: aaload
    //   219: invokestatic mm : (Ljava/lang/String;)Z
    //   222: ifeq -> 228
    //   225: goto -> 240
    //   228: iload #9
    //   230: iconst_1
    //   231: iadd
    //   232: istore #9
    //   234: goto -> 208
    //   237: iconst_0
    //   238: istore #11
    //   240: iconst_0
    //   241: istore #13
    //   243: aload #17
    //   245: astore_1
    //   246: iload #12
    //   248: istore #9
    //   250: iload #13
    //   252: istore #12
    //   254: iload #12
    //   256: iload #10
    //   258: if_icmpge -> 517
    //   261: iload #9
    //   263: anewarray java/lang/String
    //   266: astore #17
    //   268: iconst_0
    //   269: istore #13
    //   271: iload #13
    //   273: iload #9
    //   275: if_icmpge -> 473
    //   278: aload_3
    //   279: iload #13
    //   281: aaload
    //   282: ifnonnull -> 288
    //   285: goto -> 464
    //   288: aload_3
    //   289: iload #13
    //   291: aaload
    //   292: astore #20
    //   294: aload #18
    //   296: iload #13
    //   298: iaload
    //   299: istore #16
    //   301: aload #20
    //   303: invokevirtual length : ()I
    //   306: istore #15
    //   308: aload #19
    //   310: iload #13
    //   312: iaload
    //   313: ifne -> 322
    //   316: iconst_0
    //   317: istore #14
    //   319: goto -> 338
    //   322: aload #20
    //   324: iconst_0
    //   325: aload #19
    //   327: iload #13
    //   329: iaload
    //   330: invokevirtual substring : (II)Ljava/lang/String;
    //   333: invokestatic ml : (Ljava/lang/String;)I
    //   336: istore #14
    //   338: aload #20
    //   340: iload #14
    //   342: invokestatic y : (Ljava/lang/String;I)D
    //   345: dstore #5
    //   347: aload #20
    //   349: iload #16
    //   351: iload #14
    //   353: iadd
    //   354: invokestatic y : (Ljava/lang/String;I)D
    //   357: dstore #7
    //   359: aload #19
    //   361: iload #13
    //   363: iaload
    //   364: istore #14
    //   366: aload #19
    //   368: iload #13
    //   370: aload #19
    //   372: iload #13
    //   374: iaload
    //   375: dload #7
    //   377: dload #5
    //   379: dsub
    //   380: d2i
    //   381: iadd
    //   382: iastore
    //   383: aload #19
    //   385: iload #13
    //   387: iaload
    //   388: istore #16
    //   390: iload #14
    //   392: iload #15
    //   394: if_icmpgt -> 423
    //   397: iload #16
    //   399: iload #15
    //   401: if_icmple -> 423
    //   404: aload #17
    //   406: iload #13
    //   408: aload_3
    //   409: iload #13
    //   411: aaload
    //   412: iload #14
    //   414: iload #15
    //   416: invokevirtual substring : (II)Ljava/lang/String;
    //   419: aastore
    //   420: goto -> 464
    //   423: iload #14
    //   425: iload #15
    //   427: if_icmple -> 448
    //   430: iload #16
    //   432: iload #15
    //   434: if_icmple -> 448
    //   437: aload #17
    //   439: iload #13
    //   441: ldc_w ''
    //   444: aastore
    //   445: goto -> 464
    //   448: aload #17
    //   450: iload #13
    //   452: aload_3
    //   453: iload #13
    //   455: aaload
    //   456: iload #14
    //   458: iload #16
    //   460: invokevirtual substring : (II)Ljava/lang/String;
    //   463: aastore
    //   464: iload #13
    //   466: iconst_1
    //   467: iadd
    //   468: istore #13
    //   470: goto -> 271
    //   473: aload_1
    //   474: aload_2
    //   475: aload #17
    //   477: invokestatic b : ([I[I[Ljava/lang/String;)Ljava/lang/String;
    //   480: astore #17
    //   482: iload #11
    //   484: ifeq -> 499
    //   487: aload_0
    //   488: aload #17
    //   490: iload #4
    //   492: invokevirtual q : (Ljava/lang/String;I)Lcom/laiqian/print/model/PrintContent$a;
    //   495: pop
    //   496: goto -> 508
    //   499: aload_0
    //   500: aload #17
    //   502: iload #4
    //   504: invokevirtual r : (Ljava/lang/String;I)Lcom/laiqian/print/model/PrintContent$a;
    //   507: pop
    //   508: iload #12
    //   510: iconst_1
    //   511: iadd
    //   512: istore #12
    //   514: goto -> 254
    //   517: return }
  
  public static int bw(int paramInt1, int paramInt2) { return (paramInt2 != 2) ? ((paramInt1 != 58) ? ((paramInt1 != 80) ? (int)(paramInt1 * 0.5517241379310345D) : 48) : 32) : ((paramInt1 != 40) ? ((paramInt1 != 60) ? ((paramInt1 != 80) ? (int)(paramInt1 * 0.65D) : 52) : 39) : 26); }
  
  private static char[] c(Integer[] paramArrayOfInteger) {
    char[] arrayOfChar = new char[paramArrayOfInteger.length];
    for (byte b = 0; b < paramArrayOfInteger.length; b++) {
      if (paramArrayOfInteger[b] != null) {
        arrayOfChar[b] = (char)paramArrayOfInteger[b].intValue();
      } else {
        arrayOfChar[b] = ' ';
      } 
    } 
    return arrayOfChar;
  }
  
  public static int[] c(int[] paramArrayOfInt, int paramInt) {
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    byte b;
    for (b = 0; b < paramArrayOfInt.length; b++) {
      if (paramInt == 3 || paramInt == 2) {
        double d = paramArrayOfInt[b] / 2.0D;
        if (b == paramArrayOfInt.length - 1) {
          arrayOfInt[b] = (int)Math.floor(d);
        } else {
          arrayOfInt[b] = (int)Math.round(d);
        } 
      } else {
        arrayOfInt[b] = paramArrayOfInt[b];
      } 
      if (arrayOfInt[b] < 0)
        arrayOfInt[b] = 0; 
    } 
    return arrayOfInt;
  }
  
  @TargetApi(18)
  public static String d(BluetoothDevice paramBluetoothDevice) {
    try {
      String str;
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("name", paramBluetoothDevice.getName());
      jSONObject.put("address", paramBluetoothDevice.getAddress());
      if (paramBluetoothDevice.getUuids() == null) {
        str = null;
      } else {
        str = Arrays.toString(paramBluetoothDevice.getUuids());
      } 
      jSONObject.put("uuid", str);
      if (Build.VERSION.SDK_INT >= 18)
        jSONObject.put("type", paramBluetoothDevice.getType()); 
      jSONObject.put("class", a(paramBluetoothDevice.getBluetoothClass()));
      return jSONObject.toString();
    } catch (JSONException paramBluetoothDevice) {
      a.e(paramBluetoothDevice);
      return "";
    } 
  }
  
  public static byte[] getBytes(String paramString1, String paramString2) {
    if (paramString1 == null)
      return null; 
    if (paramString2 == null)
      return null; 
    try {
      return paramString1.getBytes(paramString2);
    } catch (UnsupportedEncodingException paramString1) {
      return null;
    } 
  }
  
  public static void i(Runnable paramRunnable) { (new Handler(Looper.getMainLooper())).post(paramRunnable); }
  
  private static int jf(int paramInt) {
    if (paramInt == 183)
      return 2; 
    if (Character.getType(paramInt) == 6)
      return 0; 
    if (Build.VERSION.SDK_INT >= 19) {
      String str = Character.getName(paramInt);
      if (str != null && str.startsWith("FULLWIDTH"))
        return 2; 
    } 
    return (Integer.toHexString(paramInt).length() >= 4) ? 2 : 1;
  }
  
  public static int jg(int paramInt) { return bw(paramInt, 0); }
  
  public static int jh(int paramInt) { return (paramInt != 58) ? ((paramInt != 80) ? (int)Math.round(paramInt * 0.0393701D * 203.0D) : 576) : 384; }
  
  private static String[] mk(String paramString) { return paramString.split("\\s+"); }
  
  public static int ml(String paramString) {
    byte b = 0;
    if (paramString == null)
      return 0; 
    int i = 0;
    while (b < paramString.length()) {
      i += jf(paramString.codePointAt(b));
      b++;
    } 
    return i;
  }
  
  public static boolean mm(@Nullable String paramString) {
    if (paramString == null)
      return false; 
    for (int i = 0; i < paramString.length(); i += Character.charCount(j)) {
      int j = paramString.codePointAt(i);
      Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(j);
      if (unicodeBlock != null && (unicodeBlock.equals(Character.UnicodeBlock.ARABIC) || unicodeBlock.equals(Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_A) || unicodeBlock.equals(Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_B)))
        return true; 
    } 
    return false;
  }
  
  public static boolean mn(@Nullable String paramString) {
    if (paramString == null)
      return false; 
    for (int i = 0; i < paramString.length(); i += Character.charCount(j)) {
      int j = paramString.codePointAt(i);
      Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(j);
      if (unicodeBlock != null && unicodeBlock.equals(Character.UnicodeBlock.THAI))
        return true; 
    } 
    return false;
  }
  
  public static boolean mo(@Nullable String paramString) {
    if (paramString == null)
      return false; 
    for (int i = 0; i < paramString.length(); i += Character.charCount(j)) {
      int j = paramString.codePointAt(i);
      Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(j);
      if (unicodeBlock != null && unicodeBlock.equals(Character.UnicodeBlock.MYANMAR))
        return true; 
    } 
    return false;
  }
  
  public static byte[] mp(String paramString) {
    String[] arrayOfString = mq(paramString).split("\\n");
    int i = arrayOfString.length;
    b b1 = new b(false);
    for (byte b = 0; b < i; b++) {
      byte[] arrayOfByte = mr(arrayOfString[b]);
      for (byte b2 = 0; b2 < arrayOfByte.length; b2++) {
        if (arrayOfByte[b2] == -16) {
          b1.s(new byte[] { 27, 116, 29, -124, 27, 116, 22 });
        } else if (arrayOfByte[b2] == Byte.MAX_VALUE) {
          b1.append(-41);
        } else {
          b1.append(arrayOfByte[b2]);
        } 
      } 
    } 
    return b1.toByteArray();
  }
  
  private static String mq(String paramString) {
    StringBuilder stringBuilder = new StringBuilder(paramString);
    Matcher matcher = cOB.matcher(paramString);
    while (matcher.find()) {
      String str = matcher.group();
      stringBuilder.replace(matcher.start(), matcher.end(), (new StringBuilder(str)).reverse().toString());
    } 
    return stringBuilder.toString();
  }
  
  private static byte[] mr(String paramString) {
    Integer[] arrayOfInteger2 = new Integer[paramString.length()];
    Integer[] arrayOfInteger1 = new Integer[paramString.length()];
    Integer[] arrayOfInteger3 = new Integer[arrayOfInteger2.length];
    a(paramString.toCharArray(), arrayOfInteger2, paramString.length());
    null = H(G(new ArrayList(Arrays.asList(arrayOfInteger2))));
    Collections.reverse(null);
    null.toArray(arrayOfInteger1);
    arrayOfChar = c(arrayOfInteger1);
    try {
      return (new String(arrayOfChar)).getBytes("cp864");
    } catch (UnsupportedEncodingException arrayOfChar) {
      a.e(arrayOfChar);
      return new byte[0];
    } 
  }
  
  public static Bitmap s(Bitmap paramBitmap) {
    int i = paramBitmap.getHeight();
    Bitmap bitmap = Bitmap.createBitmap(paramBitmap.getWidth(), i, Bitmap.Config.RGB_565);
    Canvas canvas = new Canvas(bitmap);
    canvas.drawColor(-1);
    Paint paint = new Paint();
    ColorMatrix colorMatrix = new ColorMatrix();
    colorMatrix.setSaturation(0.0F);
    paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    canvas.drawBitmap(paramBitmap, 0.0F, 0.0F, paint);
    return bitmap;
  }
  
  private static int t(boolean paramBoolean1, boolean paramBoolean2) { return (paramBoolean1 && paramBoolean2) ? 3 : ((!paramBoolean1 && paramBoolean2) ? 2 : ((paramBoolean1 && !paramBoolean2) ? 1 : 0)); }
  
  public static ArrayList<String> x(String paramString, int paramInt) {
    if (paramInt < 0) {
      StringBuilder stringBuilder;
      stringBuilder = new StringBuilder();
      stringBuilder.append("space should >= 0, but ");
      stringBuilder.append(paramInt);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    ArrayList arrayList = new ArrayList();
    String str = stringBuilder.trim();
    int j = ml(str);
    int i = paramInt;
    if (paramInt == 0)
      i = Integer.MAX_VALUE; 
    if (j < i) {
      arrayList.add(str);
      return arrayList;
    } 
    a(mk(str), 0, i, arrayList);
    return arrayList;
  }
  
  private static double y(String paramString, int paramInt) {
    if (paramString == null)
      return 0.0D; 
    if (paramInt == 0)
      return 0.0D; 
    byte b = 0;
    int i = 0;
    while (b < paramString.length()) {
      i += jf(paramString.codePointAt(b));
      if (i == paramInt)
        return (b + 1); 
      if (i > paramInt)
        return b + 0.5D; 
      b++;
    } 
    return paramString.length();
  }
  
  public static int z(String paramString, int paramInt) {
    int i = ml(paramString);
    return (paramInt == 3 || paramInt == 2) ? (i * 2) : i;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */