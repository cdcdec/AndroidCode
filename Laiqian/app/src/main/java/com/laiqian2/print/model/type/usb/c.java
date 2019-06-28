package com.laiqian.print.model.type.usb;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c implements e.a {
  private static ArrayList<b> cIn;
  
  private File cIo;
  
  static  {
  
  }
  
  public c(@NonNull File paramFile) { this.cIo = paramFile; }
  
  private void agV() {
    if (!this.cIo.exists())
      return; 
    try {
      FileInputStream fileInputStream = new FileInputStream(this.cIo);
      byte[] arrayOfByte = new byte[fileInputStream.available()];
      fileInputStream.read(arrayOfByte);
      fileInputStream.close();
      iOException = new String(arrayOfByte);
    } catch (IOException iOException) {
      a.e(iOException);
      iOException = null;
    } 
    if (iOException != null) {
      if (iOException.isEmpty())
        return; 
      cIn = new ArrayList();
      try {
        JSONArray jSONArray = (new JSONObject(iOException)).getJSONArray("printers");
        int i = jSONArray.length();
        byte b = 0;
        while (true) {
          if (b < i) {
            d d = jSONArray.getJSONObject(b);
            String str = d.getString("type");
            if ("printer".equals(str)) {
              d = m(d);
            } else if ("card_reader".equals(str)) {
              a a1 = n(d);
            } else {
              d = null;
            } 
            if (d != null)
              cIn.add(d); 
            b++;
            continue;
          } 
          return;
        } 
      } catch (JSONException iOException) {
        a.e(iOException);
      } 
      return;
    } 
  }
  
  private d m(JSONObject paramJSONObject) { // Byte code:
    //   0: aload_1
    //   1: ldc 'vendor_id'
    //   3: invokevirtual getInt : (Ljava/lang/String;)I
    //   6: istore_2
    //   7: aload_1
    //   8: ldc 'product_id'
    //   10: invokevirtual getInt : (Ljava/lang/String;)I
    //   13: istore_3
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #5
    //   23: aload #5
    //   25: iload_2
    //   26: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload #5
    //   32: ldc ','
    //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload #5
    //   40: iload_3
    //   41: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: new com/laiqian/print/model/type/usb/d
    //   48: dup
    //   49: aload #5
    //   51: invokevirtual toString : ()Ljava/lang/String;
    //   54: aload_1
    //   55: ldc 'name'
    //   57: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   60: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   63: astore #5
    //   65: aload_1
    //   66: ldc 'protocol'
    //   68: invokevirtual has : (Ljava/lang/String;)Z
    //   71: istore #4
    //   73: iconst_2
    //   74: istore_2
    //   75: iload #4
    //   77: ifeq -> 123
    //   80: aload_1
    //   81: ldc 'protocol'
    //   83: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   86: astore #6
    //   88: ldc 'escpos'
    //   90: aload #6
    //   92: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   95: ifeq -> 107
    //   98: aload #5
    //   100: iconst_1
    //   101: invokevirtual ii : (I)V
    //   104: goto -> 123
    //   107: ldc 'tag'
    //   109: aload #6
    //   111: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   114: ifeq -> 123
    //   117: aload #5
    //   119: iconst_2
    //   120: invokevirtual ii : (I)V
    //   123: aload_1
    //   124: ldc 'verify_required'
    //   126: invokevirtual has : (Ljava/lang/String;)Z
    //   129: ifeq -> 143
    //   132: aload #5
    //   134: aload_1
    //   135: ldc 'verify_required'
    //   137: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   140: invokevirtual fR : (Z)V
    //   143: aload_1
    //   144: ldc 'support_raster'
    //   146: invokevirtual has : (Ljava/lang/String;)Z
    //   149: ifeq -> 163
    //   152: aload #5
    //   154: aload_1
    //   155: ldc 'support_raster'
    //   157: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   160: invokevirtual fP : (Z)V
    //   163: aload_1
    //   164: ldc 'size'
    //   166: invokevirtual has : (Ljava/lang/String;)Z
    //   169: ifeq -> 388
    //   172: new java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial <init> : ()V
    //   179: astore #6
    //   181: aload #6
    //   183: ldc 'size is '
    //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload #6
    //   191: aload_1
    //   192: ldc 'size'
    //   194: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   197: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: ldc 'tag'
    //   203: aload #6
    //   205: invokevirtual toString : ()Ljava/lang/String;
    //   208: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   211: pop
    //   212: aload_1
    //   213: ldc 'size'
    //   215: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual hashCode : ()I
    //   223: istore_3
    //   224: iload_3
    //   225: sipush #1699
    //   228: if_icmpeq -> 293
    //   231: iload_3
    //   232: sipush #1784
    //   235: if_icmpeq -> 279
    //   238: iload_3
    //   239: ldc 49496973
    //   241: if_icmpeq -> 267
    //   244: iload_3
    //   245: ldc 51344046
    //   247: if_icmpeq -> 253
    //   250: goto -> 398
    //   253: aload_1
    //   254: ldc '60,40'
    //   256: invokevirtual equals : (Ljava/lang/Object;)Z
    //   259: ifeq -> 398
    //   262: iconst_3
    //   263: istore_2
    //   264: goto -> 400
    //   267: aload_1
    //   268: ldc '40,30'
    //   270: invokevirtual equals : (Ljava/lang/Object;)Z
    //   273: ifeq -> 398
    //   276: goto -> 400
    //   279: aload_1
    //   280: ldc '80'
    //   282: invokevirtual equals : (Ljava/lang/Object;)Z
    //   285: ifeq -> 398
    //   288: iconst_1
    //   289: istore_2
    //   290: goto -> 400
    //   293: aload_1
    //   294: ldc '58'
    //   296: invokevirtual equals : (Ljava/lang/Object;)Z
    //   299: ifeq -> 398
    //   302: iconst_0
    //   303: istore_2
    //   304: goto -> 400
    //   307: aload #5
    //   309: iconst_0
    //   310: invokevirtual setWidth : (I)V
    //   313: goto -> 382
    //   316: aload #5
    //   318: bipush #60
    //   320: invokevirtual setWidth : (I)V
    //   323: aload #5
    //   325: bipush #40
    //   327: invokevirtual setHeight : (I)V
    //   330: aload #5
    //   332: areturn
    //   333: aload #5
    //   335: bipush #40
    //   337: invokevirtual setWidth : (I)V
    //   340: aload #5
    //   342: bipush #30
    //   344: invokevirtual setHeight : (I)V
    //   347: aload #5
    //   349: areturn
    //   350: aload #5
    //   352: bipush #80
    //   354: invokevirtual setWidth : (I)V
    //   357: aload #5
    //   359: iconst_0
    //   360: invokevirtual setHeight : (I)V
    //   363: aload #5
    //   365: areturn
    //   366: aload #5
    //   368: bipush #58
    //   370: invokevirtual setWidth : (I)V
    //   373: aload #5
    //   375: iconst_0
    //   376: invokevirtual setHeight : (I)V
    //   379: aload #5
    //   381: areturn
    //   382: aload #5
    //   384: iconst_0
    //   385: invokevirtual setHeight : (I)V
    //   388: aload #5
    //   390: areturn
    //   391: astore_1
    //   392: aload_1
    //   393: invokestatic e : (Ljava/lang/Throwable;)V
    //   396: aconst_null
    //   397: areturn
    //   398: iconst_m1
    //   399: istore_2
    //   400: iload_2
    //   401: tableswitch default -> 432, 0 -> 366, 1 -> 350, 2 -> 333, 3 -> 316
    //   432: goto -> 307
    // Exception table:
    //   from	to	target	type
    //   0	73	391	org/json/JSONException
    //   80	104	391	org/json/JSONException
    //   107	123	391	org/json/JSONException
    //   123	143	391	org/json/JSONException
    //   143	163	391	org/json/JSONException
    //   163	224	391	org/json/JSONException
    //   253	262	391	org/json/JSONException
    //   267	276	391	org/json/JSONException
    //   279	288	391	org/json/JSONException
    //   293	302	391	org/json/JSONException
    //   307	313	391	org/json/JSONException
    //   316	330	391	org/json/JSONException
    //   333	347	391	org/json/JSONException
    //   350	363	391	org/json/JSONException
    //   366	379	391	org/json/JSONException
    //   382	388	391	org/json/JSONException }
  
  private a n(JSONObject paramJSONObject) {
    try {
      int i = paramJSONObject.getInt("vendor_id");
      int j = paramJSONObject.getInt("product_id");
      null = new StringBuilder();
      null.append(i);
      null.append(",");
      null.append(j);
      a a1 = new a(null.toString(), paramJSONObject.getString("name"));
      if (paramJSONObject.has("protocol")) {
        String str = paramJSONObject.getString("protocol");
        if ("ic".equalsIgnoreCase(str)) {
          a1.im(1);
          return a1;
        } 
        if ("mag".equalsIgnoreCase(str))
          a1.im(2); 
      } 
      return a1;
    } catch (JSONException paramJSONObject) {
      a.e(paramJSONObject);
      return null;
    } 
  }
  
  @Nullable
  public b lv(String paramString) {
    if (cIn == null)
      agV(); 
    if (cIn == null)
      return null; 
    for (b b : cIn) {
      if (paramString.equals(b.getIdentifier()))
        return b; 
    } 
    return null;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */