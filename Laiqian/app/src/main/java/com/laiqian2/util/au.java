package com.laiqian.util;

import android.content.Context;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class au {
  public static ArrayList<HashMap<String, Object>> aV(Object paramObject) {
    try {
      ArrayList arrayList = new ArrayList();
      paramObject = new JSONArray(paramObject.toString());
      new HashMap();
      for (byte b = 0; b < paramObject.length(); b++)
        arrayList.add(qB((new JSONObject(paramObject.get(b).toString())).toString())); 
      return arrayList;
    } catch (JSONException paramObject) {
      a.e(paramObject);
    } catch (Exception paramObject) {}
    return null;
  }
  
  public static ArrayList<Map<String, String>> aW(Object paramObject) {
    try {
      ArrayList arrayList = new ArrayList();
      paramObject = new JSONArray(paramObject.toString());
      new HashMap();
      for (byte b = 0; b < paramObject.length(); b++)
        arrayList.add(qC((new JSONObject(paramObject.get(b).toString())).toString())); 
      return arrayList;
    } catch (JSONException paramObject) {
      a.e(paramObject);
    } catch (Exception paramObject) {}
    return null;
  }
  
  public static String f(String paramString, Context paramContext) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (jSONObject.getString("result").equals("TRUE"))
        return jSONObject.getString("message"); 
      if (jSONObject.getString("result").equals("FALSE"))
        switch (Integer.parseInt(jSONObject.getString("msg_no"))) {
          case -1:
            Toast.makeText(paramContext, paramContext.getString(R.string.noexist), 0).show();
            break;
          case -2:
            Toast.makeText(paramContext, paramContext.getString(R.string.wrongpassword), 0).show();
            break;
          case -3:
            Toast.makeText(paramContext, paramContext.getString(R.string.storenumbernotexist), 0).show();
            break;
        }  
    } catch (Exception paramString) {}
    return null;
  }
  
  public static String qA(String paramString) {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
      if (paramString.startsWith("﻿"))
        str = paramString.substring(1); 
    } 
    return str;
  }
  
  public static HashMap<String, Object> qB(String paramString) { // Byte code:
    //   0: aload_0
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull -> 23
    //   6: aload_0
    //   7: astore_1
    //   8: aload_0
    //   9: ldc '﻿'
    //   11: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   14: ifeq -> 23
    //   17: aload_0
    //   18: iconst_1
    //   19: invokevirtual substring : (I)Ljava/lang/String;
    //   22: astore_1
    //   23: new org/json/JSONObject
    //   26: dup
    //   27: aload_1
    //   28: invokespecial <init> : (Ljava/lang/String;)V
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual keys : ()Ljava/util/Iterator;
    //   36: astore_1
    //   37: new java/util/HashMap
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore_2
    //   45: aload_1
    //   46: invokeinterface hasNext : ()Z
    //   51: ifeq -> 78
    //   54: aload_1
    //   55: invokeinterface next : ()Ljava/lang/Object;
    //   60: checkcast java/lang/String
    //   63: astore_3
    //   64: aload_2
    //   65: aload_3
    //   66: aload_0
    //   67: aload_3
    //   68: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   71: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: goto -> 45
    //   78: aload_2
    //   79: areturn
    //   80: new java/util/HashMap
    //   83: dup
    //   84: invokespecial <init> : ()V
    //   87: areturn
    //   88: new java/util/HashMap
    //   91: dup
    //   92: invokespecial <init> : ()V
    //   95: areturn
    //   96: astore_0
    //   97: goto -> 88
    //   100: astore_0
    //   101: goto -> 80
    // Exception table:
    //   from	to	target	type
    //   8	23	96	org/json/JSONException
    //   8	23	100	java/lang/Exception
    //   23	45	96	org/json/JSONException
    //   23	45	100	java/lang/Exception
    //   45	75	96	org/json/JSONException
    //   45	75	100	java/lang/Exception }
  
  public static HashMap<String, String> qC(String paramString) { // Byte code:
    //   0: aload_0
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull -> 23
    //   6: aload_0
    //   7: astore_1
    //   8: aload_0
    //   9: ldc '﻿'
    //   11: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   14: ifeq -> 23
    //   17: aload_0
    //   18: iconst_1
    //   19: invokevirtual substring : (I)Ljava/lang/String;
    //   22: astore_1
    //   23: new org/json/JSONObject
    //   26: dup
    //   27: aload_1
    //   28: invokespecial <init> : (Ljava/lang/String;)V
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual keys : ()Ljava/util/Iterator;
    //   36: astore_1
    //   37: new java/util/HashMap
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore_2
    //   45: aload_1
    //   46: invokeinterface hasNext : ()Z
    //   51: ifeq -> 78
    //   54: aload_1
    //   55: invokeinterface next : ()Ljava/lang/Object;
    //   60: checkcast java/lang/String
    //   63: astore_3
    //   64: aload_2
    //   65: aload_3
    //   66: aload_0
    //   67: aload_3
    //   68: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   71: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: goto -> 45
    //   78: aload_2
    //   79: areturn
    //   80: astore_0
    //   81: aconst_null
    //   82: areturn
    //   83: astore_0
    //   84: aconst_null
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   8	23	80	org/json/JSONException
    //   8	23	83	java/lang/Exception
    //   23	45	80	org/json/JSONException
    //   23	45	83	java/lang/Exception
    //   45	75	80	org/json/JSONException
    //   45	75	83	java/lang/Exception }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */