package com.laiqian.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.google.a.a.a.a.a.a;
import com.laiqian.milestone.h;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l {
  public static String A(String paramString, int paramInt) { // Byte code:
    //   0: aload_0
    //   1: ifnull -> 15
    //   4: aload_0
    //   5: astore_3
    //   6: aload_0
    //   7: ldc ''
    //   9: invokevirtual equals : (Ljava/lang/Object;)Z
    //   12: ifeq -> 18
    //   15: ldc '0'
    //   17: astore_3
    //   18: aload_3
    //   19: invokestatic parseInt : (Ljava/lang/String;)I
    //   22: istore_2
    //   23: goto -> 33
    //   26: astore_0
    //   27: aload_0
    //   28: invokestatic e : (Ljava/lang/Throwable;)V
    //   31: iconst_0
    //   32: istore_2
    //   33: iload_2
    //   34: iconst_1
    //   35: iadd
    //   36: istore_2
    //   37: new java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial <init> : ()V
    //   44: astore_0
    //   45: aload_0
    //   46: iload_2
    //   47: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_0
    //   52: ldc ''
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_0
    //   59: invokevirtual toString : ()Ljava/lang/String;
    //   62: astore_3
    //   63: iload_1
    //   64: iconst_3
    //   65: if_icmpeq -> 70
    //   68: aload_3
    //   69: areturn
    //   70: aload_3
    //   71: invokevirtual length : ()I
    //   74: iconst_1
    //   75: if_icmpne -> 104
    //   78: new java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial <init> : ()V
    //   85: astore_0
    //   86: aload_0
    //   87: ldc '00'
    //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_0
    //   94: iload_2
    //   95: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_0
    //   100: invokevirtual toString : ()Ljava/lang/String;
    //   103: areturn
    //   104: aload_3
    //   105: astore_0
    //   106: aload_3
    //   107: invokevirtual length : ()I
    //   110: iconst_2
    //   111: if_icmpne -> 140
    //   114: new java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial <init> : ()V
    //   121: astore_0
    //   122: aload_0
    //   123: ldc '0'
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_0
    //   130: iload_2
    //   131: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_0
    //   136: invokevirtual toString : ()Ljava/lang/String;
    //   139: astore_0
    //   140: aload_0
    //   141: areturn
    // Exception table:
    //   from	to	target	type
    //   18	23	26	java/lang/NumberFormatException }
  
  public static void Q(Activity paramActivity) {
    InputMethodManager inputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    if (inputMethodManager.isActive()) {
      View view = paramActivity.getCurrentFocus();
      if (view != null)
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2); 
    } 
  }
  
  public static void R(Activity paramActivity) {
    InputMethodManager inputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    View view = paramActivity.getCurrentFocus();
    if (view != null)
      inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2); 
  }
  
  public static void a(Window paramWindow, EditText paramEditText) {
    if (Build.VERSION.SDK_INT <= 10) {
      paramEditText.setInputType(0);
      return;
    } 
    paramWindow.setSoftInputMode(3);
    try {
      Method method = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { boolean.class });
      method.setAccessible(true);
      method.invoke(paramEditText, new Object[] { Boolean.valueOf(false) });
    } catch (Exception paramWindow) {
      a.e(paramWindow);
    } 
    try {
      Method method = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { boolean.class });
      method.setAccessible(true);
      method.invoke(paramEditText, new Object[] { Boolean.valueOf(false) });
      return;
    } catch (Exception paramWindow) {
      a.e(paramWindow);
      return;
    } 
  }
  
  public static void b(Window paramWindow, EditText paramEditText) {
    paramWindow.setSoftInputMode(4);
    try {
      Method method = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { boolean.class });
      method.setAccessible(true);
      method.invoke(paramEditText, new Object[] { Boolean.valueOf(true) });
    } catch (Exception paramWindow) {
      a.e(paramWindow);
    } 
    try {
      Method method = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[] { boolean.class });
      method.setAccessible(true);
      method.invoke(paramEditText, new Object[] { Boolean.valueOf(true) });
      return;
    } catch (Exception paramWindow) {
      a.e(paramWindow);
      return;
    } 
  }
  
  public static boolean[] bG(Context paramContext) {
    boolean[] arrayOfBoolean = new boolean[2];
    try {
      boolean bool;
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences("settings", 0);
      String str1 = sharedPreferences.getString("shop_id", "-1");
      String str2 = sharedPreferences.getString("user_id", "-1");
      String str3 = sharedPreferences.getString("user_password", "");
      String str4 = sharedPreferences.getString("user_phone", "");
      h h = new h(paramContext);
      long[] arrayOfLong = h.Y(str4, str3);
      h.close();
      if (arrayOfLong[0] > 0L && !str1.equals("-1") && !str2.equals("-1")) {
        bool = true;
      } else {
        bool = false;
      } 
      arrayOfBoolean[0] = bool;
    } catch (Exception exception) {}
    av av = new av(paramContext);
    arrayOfBoolean[1] = av.auw();
    av.close();
    return arrayOfBoolean;
  }
  
  public static boolean bH(Context paramContext) {
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (networkInfo != null && networkInfo.isConnected());
  }
  
  public static List<String> bd(String paramString1, String paramString2) {
    String[] arrayOfString = paramString1.split(paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("arrVersions=");
    stringBuilder.append(arrayOfString);
    bb.ao(stringBuilder.toString());
    if (arrayOfString == null || "".equals(arrayOfString[0]))
      return null; 
    List list = Arrays.asList(arrayOfString);
    Collections.sort(list);
    return list;
  }
  
  public static String dj(long paramLong) {
    paramLong = Math.abs(Math.round(Math.tan(paramLong)));
    long l1 = System.currentTimeMillis();
    long l2 = (long)Math.random();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(l1 + l2 * 1000L);
    stringBuilder.append("");
    stringBuilder.append(paramLong);
    return stringBuilder.toString();
  }
  
  public static boolean pg(String paramString) { return (paramString == null || paramString.equals("") || paramString.length() == 0); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */