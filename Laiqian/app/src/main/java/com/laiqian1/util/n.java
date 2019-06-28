package com.laiqian.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.StringRes;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.an;
import com.laiqian.infrastructure.R;
import com.laiqian.models.bh;
import com.laiqian.print.usage.receipt.model.c;
import com.laiqian.util.logger.a;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import org.jetbrains.annotations.NotNull;

public class n {
  private static final Object dEZ = new Object();
  
  private static ThreadLocal<StringBuilder> dFa = new o();
  
  private static InputMethodManager imm;
  
  public static String B(String paramString, boolean paramBoolean) {
    if (paramString.contains(".")) {
      String[] arrayOfString = paramString.split("\\.");
      if (arrayOfString != null && arrayOfString[true] != null) {
        String str = arrayOfString[1];
        if (str.length() == 1) {
          if (Integer.parseInt(str) == 0)
            return !paramBoolean ? String.valueOf(Integer.parseInt(arrayOfString[0])) : f(Integer.valueOf(Integer.parseInt(arrayOfString[0]))); 
        } else if (str.length() == 2) {
          str = str.substring(0, 1);
          if (!TextUtils.isEmpty(str) && Integer.parseInt(str) == 0)
            return !paramBoolean ? String.valueOf(Integer.parseInt(arrayOfString[0])) : f(Integer.valueOf(Integer.parseInt(arrayOfString[0]))); 
        } else {
          str = str.substring(0, 1);
          if (!TextUtils.isEmpty(str))
            return (Integer.parseInt(str) == 0) ? (!paramBoolean ? String.valueOf(Integer.parseInt(arrayOfString[0])) : f(Integer.valueOf(Integer.parseInt(arrayOfString[0])))) : (!paramBoolean ? a(Double.valueOf(Double.parseDouble(paramString)), "###.##") : a(Double.valueOf(Double.parseDouble(paramString)), ",###.##")); 
        } 
      } 
      return paramString;
    } 
    return paramString;
  }
  
  public static void C(Context paramContext, String paramString) {
    CookieSyncManager.createInstance(paramContext);
    CookieManager cookieManager = CookieManager.getInstance();
    cookieManager.setAcceptCookie(true);
    cookieManager.removeAllCookie();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("language=");
    stringBuilder.append(bM(paramContext));
    stringBuilder.append(";");
    cookieManager.setCookie(paramString, stringBuilder.toString());
    CookieSyncManager.getInstance().sync();
  }
  
  @Size
  public static int[] C(long paramLong1, long paramLong2) {
    paramLong1 = paramLong2 - paramLong1;
    int i = (int)(paramLong1 / 3600000L);
    paramLong1 -= (3600000 * i);
    int j = (int)paramLong1 / 60000;
    return new int[] { i, j, (int)((paramLong1 - (60000 * j)) / 1000L) };
  }
  
  public static boolean D(Context paramContext, String paramString) {
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString))
        return false; 
      List list = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      return (list != null && list.size() > 0 && paramString.equals(((ActivityManager.RunningTaskInfo)list.get(0)).topActivity.getClassName()));
    } 
    return false;
  }
  
  public static void R(Activity paramActivity) { a(paramActivity, paramActivity.getCurrentFocus()); }
  
  public static boolean S(Activity paramActivity) {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 17) {
      bool = paramActivity.isDestroyed();
    } else {
      bool = false;
    } 
    return (bool || paramActivity.isFinishing());
  }
  
  public static void T(Activity paramActivity) {
    WindowManager windowManager = paramActivity.getWindowManager();
    Point point = new Point();
    windowManager.getDefaultDisplay().getSize(point);
    a a = new a("屏幕尺寸");
    a.b("屏幕宽度 %s ", new Object[] { String.valueOf(point.x) });
    a.b("屏幕高度 %s ", new Object[] { String.valueOf(point.y) });
  }
  
  public static <T> ArrayList<T> V(List<T> paramList) {
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      (new ObjectOutputStream(byteArrayOutputStream)).writeObject(paramList);
      return (ArrayList)(new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()))).readObject();
    } catch (IOException|ClassNotFoundException paramList) {
      a.e(paramList);
      return null;
    } 
  }
  
  public static Time a(Time paramTime, String paramString) {
    if (paramTime == null) {
      paramTime = new Time();
    } else {
      paramTime.clear(paramTime.timezone);
    } 
    char[] arrayOfChar = paramString.toCharArray();
    byte b = 0;
    char c = Character.MIN_VALUE;
    while (b < 6) {
      char c1 = c;
      while (true) {
        c = c1;
        if (c1 < arrayOfChar.length) {
          c = arrayOfChar[c1] - '0';
          if (c >= '\000' && c <= '\t') {
            switch (b) {
              default:
                c = c1;
                break;
              case true:
                paramTime.second = c * '\n' + arrayOfChar[c1 + '\001'] - '0';
                c = c1 + '\002';
                break;
              case true:
                paramTime.minute = c * '\n' + arrayOfChar[c1 + '\001'] - '0';
                c = c1 + '\002';
                break;
              case true:
                paramTime.hour = c * '\n' + arrayOfChar[c1 + '\001'] - '0';
                c = c1 + '\002';
                break;
              case true:
                paramTime.monthDay = c * '\n' + arrayOfChar[c1 + '\001'] - '0';
                c = c1 + '\002';
                break;
              case true:
                paramTime.month = c * '\n' + arrayOfChar[c1 + '\001'] - '0' - '\001';
                c = c1 + '\002';
                break;
              case false:
                break;
            } 
            paramTime.year = c * 'Ϩ' + (arrayOfChar[c1 + '\001'] - '0') * 'd' + (arrayOfChar[c1 + '\002'] - '0') * '\n' + arrayOfChar[c1 + '\003'] - '0';
            c = c1 + '\004';
            break;
          } 
          c1++;
          continue;
        } 
        break;
      } 
      b++;
    } 
    return paramTime;
  }
  
  public static String a(Context paramContext, Object paramObject, boolean paramBoolean) { // Byte code:
    //   0: aload_1
    //   1: instanceof java/lang/Double
    //   4: ifeq -> 18
    //   7: aload_1
    //   8: checkcast java/lang/Double
    //   11: invokevirtual doubleValue : ()D
    //   14: dstore_3
    //   15: goto -> 48
    //   18: new java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore_0
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_0
    //   33: ldc_w ''
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_0
    //   41: invokevirtual toString : ()Ljava/lang/String;
    //   44: invokestatic parseDouble : (Ljava/lang/String;)D
    //   47: dstore_3
    //   48: iload_2
    //   49: ifne -> 92
    //   52: dload_3
    //   53: d2i
    //   54: istore #5
    //   56: iload #5
    //   58: i2d
    //   59: dload_3
    //   60: dcmpl
    //   61: ifne -> 92
    //   64: new java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: astore_0
    //   72: aload_0
    //   73: iload #5
    //   75: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_0
    //   80: ldc_w ''
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_0
    //   88: invokevirtual toString : ()Ljava/lang/String;
    //   91: areturn
    //   92: getstatic com/laiqian/basic/RootApplication.aIQ : I
    //   95: istore #6
    //   97: iload #6
    //   99: ifne -> 116
    //   102: new java/text/DecimalFormat
    //   105: dup
    //   106: ldc_w '0'
    //   109: invokespecial <init> : (Ljava/lang/String;)V
    //   112: astore_0
    //   113: goto -> 166
    //   116: new java/lang/StringBuffer
    //   119: dup
    //   120: ldc_w '0.'
    //   123: invokespecial <init> : (Ljava/lang/String;)V
    //   126: astore_0
    //   127: iconst_0
    //   128: istore #5
    //   130: iload #5
    //   132: iload #6
    //   134: if_icmpge -> 154
    //   137: aload_0
    //   138: ldc_w '0'
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   144: pop
    //   145: iload #5
    //   147: iconst_1
    //   148: iadd
    //   149: istore #5
    //   151: goto -> 130
    //   154: new java/text/DecimalFormat
    //   157: dup
    //   158: aload_0
    //   159: invokevirtual toString : ()Ljava/lang/String;
    //   162: invokespecial <init> : (Ljava/lang/String;)V
    //   165: astore_0
    //   166: aload_0
    //   167: new java/math/BigDecimal
    //   170: dup
    //   171: dload_3
    //   172: invokespecial <init> : (D)V
    //   175: invokevirtual format : (Ljava/lang/Object;)Ljava/lang/String;
    //   178: invokestatic kF : (Ljava/lang/String;)Ljava/lang/String;
    //   181: areturn
    //   182: astore_0
    //   183: aload_0
    //   184: invokestatic e : (Ljava/lang/Throwable;)V
    //   187: ldc_w '0'
    //   190: areturn
    // Exception table:
    //   from	to	target	type
    //   18	48	182	java/lang/NumberFormatException }
  
  public static String a(Context paramContext, Object paramObject, boolean paramBoolean1, boolean paramBoolean2) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramObject);
    stringBuilder2.append("");
    if (stringBuilder2.toString().indexOf(",") != -1) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramObject);
      stringBuilder1.append("");
      return stringBuilder1.toString();
    } 
    return a(stringBuilder1, paramObject, paramBoolean1, true, paramBoolean2);
  }
  
  public static String a(Context paramContext, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) { return a(paramObject, paramBoolean1, paramBoolean2, RootApplication.aIQ, paramBoolean3); }
  
  public static String a(Number paramNumber, String paramString) { return (new DecimalFormat(paramString)).format(paramNumber); }
  
  public static String a(Number paramNumber, boolean paramBoolean) { return paramBoolean ? d(paramNumber) : a(paramNumber, "###.##"); }
  
  public static String a(Object paramObject, boolean paramBoolean1, boolean paramBoolean2) { return a(paramObject, paramBoolean1, paramBoolean2, RootApplication.aIQ); }
  
  public static String a(Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
    double d = aU(paramObject);
    int j = 3;
    if (paramBoolean1) {
      paramObject = e(d, paramInt);
    } else {
      String str = e(d, 3);
      paramObject = str;
      if (str.matches(".*\\.0*"))
        paramObject = str.substring(0, str.indexOf(".")); 
    } 
    if (!paramBoolean2)
      return paramObject; 
    paramObject = new StringBuilder(paramObject);
    int i = paramObject.indexOf(".");
    paramInt = i;
    if (i == -1)
      paramInt = paramObject.length(); 
    if (paramObject.indexOf("-") != -1) {
      i = paramInt - 1;
    } else {
      i = paramInt;
    } 
    while (j < i) {
      paramObject.insert(paramInt - j, ",");
      j += 3;
    } 
    return paramObject.toString();
  }
  
  public static String a(Object paramObject, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3) {
    paramObject = ph(String.valueOf(paramObject));
    double d = aU(paramObject);
    int j = 3;
    if (paramBoolean1) {
      if (paramBoolean3) {
        paramObject = B(String.valueOf(paramObject), false);
      } else {
        paramObject = e(d, paramInt);
      } 
    } else {
      String str = e(d, 3);
      paramObject = str;
      if (str.matches(".*\\.0*"))
        paramObject = str.substring(0, str.indexOf(".")); 
    } 
    if (!paramBoolean2)
      return paramObject; 
    paramObject = new StringBuilder(paramObject);
    int i = paramObject.indexOf(".");
    paramInt = i;
    if (i == -1)
      paramInt = paramObject.length(); 
    if (paramObject.indexOf("-") != -1) {
      i = paramInt - 1;
    } else {
      i = paramInt;
    } 
    while (j < i) {
      paramObject.insert(paramInt - j, ",");
      j += 3;
    } 
    return paramObject.toString();
  }
  
  public static String a(String paramString, Date paramDate) {
    String str2 = pn(RootApplication.getLaiqianPreferenceManager().Ea());
    String str1 = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(paramDate);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("-");
    stringBuilder.append(str2);
    stringBuilder.append("-");
    stringBuilder.append(str1);
    return stringBuilder.toString();
  }
  
  public static String a(boolean paramBoolean, Date paramDate) {
    String str2;
    if (paramBoolean) {
      str2 = "XS";
    } else {
      str2 = "XSTH";
    } 
    String str3 = pn(RootApplication.getLaiqianPreferenceManager().Ea());
    String str1 = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(paramDate);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append("-");
    stringBuilder.append(str3);
    stringBuilder.append("-");
    stringBuilder.append(str1);
    return stringBuilder.toString();
  }
  
  public static String a(@NotNull String[] paramArrayOfString, @NotNull int paramInt) { return (paramArrayOfString != null && paramInt >= 0 && paramInt < paramArrayOfString.length) ? paramArrayOfString[paramInt] : ""; }
  
  @Deprecated
  public static ArrayList<String> a(Activity paramActivity, boolean paramBoolean) {
    ArrayList arrayList = new ArrayList();
    if (paramActivity != null) {
      String str = e(paramActivity, paramBoolean);
      if (!TextUtils.isEmpty(str))
        arrayList.add(str); 
    } 
    return arrayList;
  }
  
  public static List<String> a(@NotNull Context paramContext, @NotNull int[] paramArrayOfInt) {
    ArrayList arrayList = new ArrayList();
    if (paramArrayOfInt != null && paramArrayOfInt.length > 0)
      for (byte b = 0; b < paramArrayOfInt.length; b++)
        arrayList.add(paramContext.getString(paramArrayOfInt[b]));  
    return arrayList;
  }
  
  public static void a(Context paramContext, View paramView) {
    if (paramView != null)
      bI(paramContext).hideSoftInputFromWindow(paramView.getWindowToken(), 2); 
  }
  
  public static void a(Context paramContext, CharSequence paramCharSequence) { b(paramContext, paramCharSequence).show(); }
  
  public static void a(Context paramContext, Class paramClass, Bundle paramBundle) {
    Intent intent = new Intent(paramContext, paramClass);
    intent.putExtras(paramBundle);
    paramContext.startActivity(intent);
  }
  
  public static void a(EditText paramEditText, int paramInt1, int paramInt2) {
    paramEditText.setFilters(new android.text.InputFilter[0]);
    paramEditText.setFilters(ar.bE(paramInt1, paramInt2));
  }
  
  public static boolean a(Object paramObject, Object[] paramArrayOfObject) {
    if (paramObject != null) {
      if (paramArrayOfObject == null)
        return false; 
      int i = paramArrayOfObject.length;
      for (byte b = 0; b < i; b++) {
        Object object = paramArrayOfObject[b];
        if (paramObject instanceof Number) {
          if (((Number)paramObject).doubleValue() == ((Number)object).doubleValue())
            return true; 
        } else if (paramObject.equals(object)) {
          return true;
        } 
      } 
      return false;
    } 
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2) {
    if (!TextUtils.isEmpty(paramString1) && paramString1.contains(":") && !TextUtils.isEmpty(paramString2) && paramString2.contains(":")) {
      String[] arrayOfString1 = paramString1.split(":");
      int i = Integer.parseInt(arrayOfString1[0]);
      int j = Integer.parseInt(arrayOfString1[1]);
      String[] arrayOfString2 = paramString2.split(":");
      Integer.parseInt(arrayOfString1[0]);
      int k = Integer.parseInt(arrayOfString2[0]);
      int m = Integer.parseInt(arrayOfString2[1]);
      Calendar calendar = Calendar.getInstance();
      calendar.setTimeInMillis(paramLong1);
      int i1 = calendar.get(11);
      int i2 = calendar.get(12);
      int i3 = calendar.get(2);
      int i4 = calendar.get(5);
      calendar.clear();
      calendar.setTimeInMillis(paramLong2);
      int i5 = calendar.get(2);
      int i6 = calendar.get(5);
      return (i == k) ? ((j > m) ? ((i2 > m && i2 < j) ? false : ((i5 == i3 && i6 == i4))) : ((i2 >= j && i2 <= m) ? ((i5 == i3 && i6 == i4)) : false)) : ((i < k) ? ((i1 >= i && i1 <= k) ? ((i5 == i3 && i6 == i4)) : false) : ((i > k) ? ((i1 > k && i1 < i) ? false : ((i5 == i3 && i6 == i4))) : ((i5 == i3 && i6 == i4))));
    } 
    return false;
  }
  
  public static boolean a(String[] paramArrayOfString1, String paramString1, String paramString2, String[] paramArrayOfString2) { return a(paramArrayOfString1, paramString1, paramString2, paramArrayOfString2, null); }
  
  public static boolean a(String[] paramArrayOfString1, String paramString1, String paramString2, String[] paramArrayOfString2, String[] paramArrayOfString3) {
    StringBuilder stringBuilder2;
    StringBuilder stringBuilder3 = new StringBuilder();
    if (paramArrayOfString2 == null) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramArrayOfString1);
      stringBuilder2.append("\n");
      stringBuilder3.append(stringBuilder2.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString1);
      stringBuilder1.append("\n");
      stringBuilder3.append(stringBuilder1.toString());
      h.a(new d(paramString1, stringBuilder3.toString()), h.a.dHw, h.b.dHB);
      return true;
    } 
    try {
      an an = an.Ii();
      null = an.aVk;
      String str1 = an.password;
      String str3 = an.protocol;
      String str2 = an.host;
      String str4 = an.aVl;
      String str5 = an.aVm;
      Properties properties = new Properties();
      properties.put("mail.smtp.host", str2);
      properties.put("mail.smtp.port", str4);
      properties.put("mail.smtp.auth", str5);
      if (an.aVn != null) {
        Iterator iterator = an.aVn.keys();
        while (iterator.hasNext()) {
          str5 = (String)iterator.next();
          properties.put(str5, an.aVn.optString(str5));
        } 
      } 
      Session session = Session.getDefaultInstance(properties, null);
      MimeMessage mimeMessage = new MimeMessage(session);
      Transport transport = session.getTransport(str3);
      transport.connect(str2, null, str1);
      mimeMessage.setSentDate(new Date());
      mimeMessage.setFrom(new InternetAddress(null));
      int i = stringBuilder1.length;
      InternetAddress[] arrayOfInternetAddress = new InternetAddress[i];
      byte b2 = 0;
      byte b1;
      for (b1 = 0; b1 < i; b1++)
        arrayOfInternetAddress[b1] = new InternetAddress(stringBuilder1[b1]); 
      mimeMessage.setRecipients(Message.RecipientType.TO, arrayOfInternetAddress);
      mimeMessage.setSubject(paramString1, "UTF-8");
      MimeMultipart mimeMultipart = new MimeMultipart();
      MimeBodyPart mimeBodyPart = new MimeBodyPart();
      mimeBodyPart.setContent(stringBuilder2, "text/html; charset=utf-8");
      mimeMultipart.addBodyPart(mimeBodyPart);
      if (paramArrayOfString2 != null)
        for (b1 = b2; b1 < paramArrayOfString2.length; b1++) {
          String str = new FileDataSource(paramArrayOfString2[b1]);
          MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
          mimeBodyPart1.setDataHandler(new DataHandler(str));
          if (paramArrayOfString3 == null) {
            String str6 = MimeUtility.encodeText(str.getName(), "utf-8", null);
          } else {
            str = MimeUtility.encodeText(paramArrayOfString3[b1], "utf-8", null);
          } 
          mimeBodyPart1.setFileName(str);
          mimeMultipart.addBodyPart(mimeBodyPart1);
        }  
      mimeMessage.setContent(mimeMultipart);
      mimeMessage.saveChanges();
      transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
      transport.close();
      return true;
    } catch (Exception stringBuilder1) {
      a.e(stringBuilder1);
      return true;
    } 
  }
  
  public static void aL(Context paramContext) {
    float f;
    DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
    if (RootApplication.getLaiqianPreferenceManager().avL() == 2) {
      f = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) / 360.0F;
    } else {
      f = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels) / 1024.0F;
    } 
    displayMetrics.density = f;
    displayMetrics.scaledDensity = f;
  }
  
  @Deprecated
  public static double aU(Object paramObject) {
    try {
      return (paramObject instanceof Number) ? ((Number)paramObject).doubleValue() : Double.parseDouble(paramObject.toString().replace(",", ""));
    } catch (Exception paramObject) {
      return 0.0D;
    } 
  }
  
  public static String aY(double paramDouble) {
    String str = aw.kF((new DecimalFormat("0.000")).format(paramDouble));
    int i;
    for (i = str.length() - 1; str.charAt(i) == '0'; i--);
    int j = i;
    if (str.charAt(i) == '.')
      j = i - 1; 
    return aw.kF(str.substring(0, j + 1));
  }
  
  public static double aZ(double paramDouble) { return (paramDouble > 0.0D) ? (paramDouble + 1.0E-5D) : ((paramDouble < 0.0D) ? (paramDouble - 1.0E-5D) : paramDouble); }
  
  private static StringBuilder asA() {
    StringBuilder stringBuilder = (StringBuilder)dFa.get();
    stringBuilder.setLength(0);
    return stringBuilder;
  }
  
  public static int asB() {
    int i = c.bp(RootApplication.zv()).aiL().getWidth();
    byte b = 32;
    if (i == 58)
      return 32; 
    if (i == 80)
      b = 48; 
    return b;
  }
  
  @NonNull
  public static SpannableStringBuilder b(Context paramContext, int paramInt, String paramString) {
    String str = paramContext.getString(paramInt);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(paramString);
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
    spannableStringBuilder.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(R.color.red_color_10500)), str.length(), str.length() + paramString.length(), 33);
    return spannableStringBuilder;
  }
  
  @NonNull
  public static BaseAdapter b(AdapterView<?> paramAdapterView) {
    Adapter adapter = paramAdapterView.getAdapter();
    if (adapter instanceof HeaderViewListAdapter)
      return (BaseAdapter)((HeaderViewListAdapter)adapter).getWrappedAdapter(); 
    if (adapter instanceof BaseAdapter)
      return (BaseAdapter)adapter; 
    throw new RuntimeException("传入的Adapter有误，不能获取BaseAdapter");
  }
  
  private static Toast b(Context paramContext, CharSequence paramCharSequence) {
    RootApplication rootApplication = paramContext;
    if (paramContext == null)
      rootApplication = RootApplication.zv(); 
    return Toast.makeText(rootApplication, paramCharSequence, 0);
  }
  
  public static String b(Context paramContext, Object paramObject, boolean paramBoolean) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramObject);
    stringBuilder2.append("");
    if (stringBuilder2.toString().indexOf(",") != -1) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramObject);
      stringBuilder1.append("");
      return stringBuilder1.toString();
    } 
    return b(stringBuilder1, paramObject, paramBoolean, true);
  }
  
  public static String b(Context paramContext, Object paramObject, boolean paramBoolean1, boolean paramBoolean2) { return a(paramObject, paramBoolean1, paramBoolean2, RootApplication.aIQ); }
  
  public static void b(Context paramContext, View paramView) {
    if (paramView != null)
      bI(paramContext).showSoftInput(paramView, 1); 
  }
  
  public static String bD(int paramInt1, int paramInt2) { return String.valueOf((new Random()).nextInt(paramInt2) % (paramInt2 - paramInt1 + 1) + paramInt1); }
  
  private static InputMethodManager bI(Context paramContext) {
    if (imm == null)
      imm = (InputMethodManager)paramContext.getSystemService("input_method"); 
    return imm;
  }
  
  public static void bJ(Context paramContext) {
    float f = Math.max((paramContext.getResources().getDisplayMetrics()).widthPixels, (paramContext.getResources().getDisplayMetrics()).heightPixels) / 1024.0F;
    (paramContext.getResources().getDisplayMetrics()).density = f;
    (paramContext.getResources().getDisplayMetrics()).scaledDensity = f;
  }
  
  public static void bK(Context paramContext) {
    float f = Math.min((paramContext.getResources().getDisplayMetrics()).widthPixels, (paramContext.getResources().getDisplayMetrics()).heightPixels) / 360.0F;
    (paramContext.getResources().getDisplayMetrics()).density = f;
    (paramContext.getResources().getDisplayMetrics()).scaledDensity = f;
  }
  
  public static boolean bL(Context paramContext) { return Locale.SIMPLIFIED_CHINESE.equals((paramContext.getResources().getConfiguration()).locale); }
  
  public static String bM(Context paramContext) { return (paramContext.getResources().getConfiguration()).locale.toString().replace("_", "-"); }
  
  public static File bN(Context paramContext) {
    File[] arrayOfFile = (new File(Environment.getExternalStorageDirectory(), paramContext.getString(R.string.backup_menu_file_directory))).listFiles();
    Context context = null;
    paramContext = null;
    if (arrayOfFile != null) {
      byte b = 0;
      long l = 0L;
      while (true) {
        context = paramContext;
        if (b < arrayOfFile.length) {
          long l2 = arrayOfFile[b].lastModified();
          long l1 = l;
          if (l2 > l) {
            File file = arrayOfFile[b];
            l1 = l2;
          } 
          b++;
          l = l1;
          continue;
        } 
        break;
      } 
    } 
    return context;
  }
  
  public static String ba(double paramDouble) { return e(paramDouble, RootApplication.aIQ); }
  
  public static double bb(double paramDouble) {
    if (paramDouble > 1000000.0D || paramDouble < -1000000.0D)
      return aU(ba(paramDouble)); 
    byte b1 = 0;
    byte b2 = 1;
    while (b1 < RootApplication.aIQ) {
      b2 *= 10;
      b1++;
    } 
    double d = b2;
    paramDouble *= d;
    if (paramDouble >= 0.0D) {
      paramDouble += 0.500001D;
    } else {
      paramDouble -= 0.500001D;
    } 
    return (int)paramDouble * 1.0D / d;
  }
  
  public static boolean bc(double paramDouble) { return (paramDouble > -1.0E-6D && paramDouble < 1.0E-6D); }
  
  public static boolean bd(double paramDouble) {
    if (bc(paramDouble))
      return true; 
    if (paramDouble < 1.0D) {
      if (paramDouble <= -1.0D)
        return false; 
      for (byte b = 0; b < RootApplication.aIQ; b++)
        paramDouble *= 10.0D; 
      if (paramDouble >= 0.0D) {
        paramDouble += 0.500001D;
      } else {
        paramDouble -= 0.500001D;
      } 
      return ((int)paramDouble == 0);
    } 
    return false;
  }
  
  public static int be(String paramString1, String paramString2) {
    int i = 0;
    byte b = 0;
    while (true) {
      i = paramString1.indexOf(paramString2, i) + 1;
      if (i > 0) {
        b++;
        continue;
      } 
      break;
    } 
    return b;
  }
  
  public static ArrayList<Integer> be(double paramDouble) {
    ArrayList arrayList = new ArrayList();
    if (paramDouble > 0.0D) {
      if (paramDouble > 2.147483547E9D)
        return arrayList; 
      int i = bf(paramDouble);
      if (paramDouble != i)
        arrayList.add(Integer.valueOf(i)); 
      int j = i % 10;
      if (j != 0) {
        if (j > 0 && j < 5)
          arrayList.add(Integer.valueOf(i / 5 * 5 + 5)); 
        arrayList.add(Integer.valueOf(i / 10 * 10 + 10));
      } 
      j = bf(paramDouble / 100.0D) * 100 - 100;
      int k = bf((paramDouble - j) / 10.0D) - 1;
      int m = arrayList.size();
      int[][] arrayOfInt = new int[10][];
      i = 0;
      new int[3][0] = 20;
      new int[3][1] = 50;
      new int[3][2] = 100;
      arrayOfInt[0] = new int[3];
      new int[2][0] = 50;
      new int[2][1] = 100;
      arrayOfInt[1] = new int[2];
      new int[3][0] = 40;
      new int[3][1] = 50;
      new int[3][2] = 100;
      arrayOfInt[2] = new int[3];
      new int[2][0] = 50;
      new int[2][1] = 100;
      arrayOfInt[3] = new int[2];
      new int[2][0] = 60;
      new int[2][1] = 100;
      arrayOfInt[4] = new int[2];
      new int[2][0] = 70;
      new int[2][1] = 100;
      arrayOfInt[5] = new int[2];
      new int[2][0] = 80;
      new int[2][1] = 100;
      arrayOfInt[6] = new int[2];
      new int[2][0] = 90;
      new int[2][1] = 100;
      arrayOfInt[7] = new int[2];
      new int[1][0] = 100;
      arrayOfInt[8] = new int[1];
      arrayOfInt[9] = new int[0];
      while (i < 4 - m && i < arrayOfInt[k].length) {
        arrayList.add(Integer.valueOf(arrayOfInt[k][i] + j));
        i++;
      } 
      return arrayList;
    } 
    return arrayList;
  }
  
  public static int bf(double paramDouble) {
    int j = (int)paramDouble;
    int i = j;
    if (j != paramDouble) {
      i = j;
      if (paramDouble > 0.0D)
        i = j + 1; 
    } 
    return i;
  }
  
  public static boolean bf(String paramString1, String paramString2) { return (paramString2 == null || paramString2.trim().equals("")) ? false : Pattern.compile(paramString1).matcher(paramString2).matches(); }
  
  public static void c(ListView paramListView) {
    ListAdapter listAdapter = paramListView.getAdapter();
    if (listAdapter == null)
      return; 
    int j = listAdapter.getCount();
    byte b = 0;
    int i = 0;
    while (b < j) {
      View view = listAdapter.getView(b, null, paramListView);
      view.measure(0, 0);
      i += view.getMeasuredHeight();
      b++;
    } 
    ViewGroup.LayoutParams layoutParams = paramListView.getLayoutParams();
    layoutParams.height = i + paramListView.getDividerHeight() * (listAdapter.getCount() - 1);
    paramListView.setLayoutParams(layoutParams);
  }
  
  public static boolean c(Context paramContext, Intent paramIntent) { return (paramIntent.resolveActivity(paramContext.getPackageManager()) != null); }
  
  public static double d(double paramDouble, int paramInt) {
    String str = String.valueOf(paramDouble);
    if (str.contains(".")) {
      int i = str.indexOf(".");
      if (i >= 0) {
        str = str.substring(i, str.length());
        if (!TextUtils.isEmpty(str) && str.length() > paramInt) {
          String str1;
          if (paramInt == 0) {
            str = "#";
          } else {
            null = new StringBuilder();
            null.append("#.");
            for (i = 0; i < paramInt; i++)
              null.append("#"); 
            str1 = null.toString();
          } 
          return Double.parseDouble((new DecimalFormat(str1)).format(paramDouble));
        } 
        return paramDouble;
      } 
      return paramDouble;
    } 
    return paramDouble;
  }
  
  @NonNull
  public static SpannableStringBuilder d(Context paramContext, String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(paramString2);
    stringBuilder.append(paramString3);
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
    spannableStringBuilder.setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(R.color.red_color_10500)), paramString1.length(), paramString1.length() + paramString2.length(), 33);
    return spannableStringBuilder;
  }
  
  public static String d(Number paramNumber) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramNumber);
    stringBuilder.append("");
    return a(Double.valueOf(Double.parseDouble(stringBuilder.toString())), ",###.##");
  }
  
  public static String d(String paramString, Context paramContext) {
    if (!TextUtils.isEmpty(paramString)) {
      bh bh = new bh(paramContext);
      paramString = bh.iD(paramString);
      bh.close();
      return paramString;
    } 
    return "";
  }
  
  public static void d(EditText paramEditText) {
    int j = paramEditText.getSelectionStart();
    int i = paramEditText.getSelectionEnd();
    Editable editable = paramEditText.getEditableText();
    if (j != i) {
      editable.delete(j, i);
      paramEditText.setSelection(j);
      return;
    } 
    paramEditText.setSelection(i);
    if (j == 0) {
      i = 0;
    } else {
      i = j - 1;
    } 
    editable.delete(i, j);
  }
  
  public static boolean d(File paramFile1, File paramFile2) {
    file1 = null;
    fileOutputStream2 = null;
    try {
    
    } catch (Exception null) {
      file2 = null;
    } finally {
      paramFile1 = null;
      object = null;
      file2 = object;
    } 
    try {
    
    } finally {
      fileOutputStream2 = null;
      file1 = file2;
      file2 = paramFile1;
    } 
    try {
      file2.close();
      file1.close();
      object.getFD().sync();
      object.close();
      paramFile2.close();
    } catch (Exception paramFile2) {
      a.e(paramFile2);
    } 
    throw fileOutputStream1;
  }
  
  public static double e(Object... paramVarArgs) {
    BigDecimal bigDecimal = BigDecimal.valueOf(aU(paramVarArgs[0]));
    for (byte b = 1; b < paramVarArgs.length; b++)
      bigDecimal = bigDecimal.subtract(BigDecimal.valueOf(aU(paramVarArgs[b]))); 
    return bigDecimal.doubleValue();
  }
  
  public static String e(double paramDouble, int paramInt) { // Byte code:
    //   0: dload_0
    //   1: invokestatic bc : (D)Z
    //   4: ifeq -> 17
    //   7: ldc_w '0.000000'
    //   10: astore #7
    //   12: dload_0
    //   13: dstore_3
    //   14: goto -> 183
    //   17: ldc2_w 0.500001
    //   20: dstore_3
    //   21: iconst_0
    //   22: istore #5
    //   24: iload #5
    //   26: iload_2
    //   27: if_icmpge -> 45
    //   30: dload_3
    //   31: ldc2_w 10.0
    //   34: ddiv
    //   35: dstore_3
    //   36: iload #5
    //   38: iconst_1
    //   39: iadd
    //   40: istore #5
    //   42: goto -> 24
    //   45: dload_0
    //   46: dconst_0
    //   47: dcmpl
    //   48: iflt -> 58
    //   51: dload_0
    //   52: dload_3
    //   53: dadd
    //   54: dstore_0
    //   55: goto -> 62
    //   58: dload_0
    //   59: dload_3
    //   60: dsub
    //   61: dstore_0
    //   62: dload_0
    //   63: ldc2_w 99999.0
    //   66: dcmpl
    //   67: ifgt -> 118
    //   70: dload_0
    //   71: ldc2_w -9999.0
    //   74: dcmpg
    //   75: ifge -> 81
    //   78: goto -> 118
    //   81: new java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial <init> : ()V
    //   88: astore #7
    //   90: aload #7
    //   92: dload_0
    //   93: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload #7
    //   99: ldc_w ''
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload #7
    //   108: invokevirtual toString : ()Ljava/lang/String;
    //   111: astore #7
    //   113: dload_0
    //   114: dstore_3
    //   115: goto -> 183
    //   118: getstatic java/util/Locale.ENGLISH : Ljava/util/Locale;
    //   121: ldc_w '%f'
    //   124: iconst_1
    //   125: anewarray java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: dload_0
    //   131: invokestatic valueOf : (D)Ljava/lang/Double;
    //   134: aastore
    //   135: invokestatic format : (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   138: astore #8
    //   140: aload #8
    //   142: ldc_w 'E'
    //   145: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   148: ifne -> 168
    //   151: aload #8
    //   153: astore #7
    //   155: dload_0
    //   156: dstore_3
    //   157: aload #8
    //   159: ldc_w 'e'
    //   162: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   165: ifeq -> 183
    //   168: new java/math/BigDecimal
    //   171: dup
    //   172: dload_0
    //   173: invokespecial <init> : (D)V
    //   176: invokevirtual toPlainString : ()Ljava/lang/String;
    //   179: astore #7
    //   181: dload_0
    //   182: dstore_3
    //   183: aload #7
    //   185: ldc '.'
    //   187: invokevirtual indexOf : (Ljava/lang/String;)I
    //   190: iload_2
    //   191: iadd
    //   192: istore #6
    //   194: aload #7
    //   196: astore #8
    //   198: iload #6
    //   200: istore #5
    //   202: iload_2
    //   203: ifle -> 216
    //   206: iload #6
    //   208: iconst_1
    //   209: iadd
    //   210: istore #5
    //   212: aload #7
    //   214: astore #8
    //   216: aload #8
    //   218: invokevirtual length : ()I
    //   221: iload #5
    //   223: if_icmpge -> 262
    //   226: new java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial <init> : ()V
    //   233: astore #7
    //   235: aload #7
    //   237: aload #8
    //   239: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload #7
    //   245: ldc_w '0'
    //   248: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload #7
    //   254: invokevirtual toString : ()Ljava/lang/String;
    //   257: astore #8
    //   259: goto -> 216
    //   262: aload #8
    //   264: iconst_0
    //   265: iload #5
    //   267: invokevirtual substring : (II)Ljava/lang/String;
    //   270: astore #7
    //   272: aload #7
    //   274: ldc_w '-0*\.?0*'
    //   277: invokevirtual matches : (Ljava/lang/String;)Z
    //   280: ifeq -> 295
    //   283: aload #7
    //   285: iconst_1
    //   286: aload #7
    //   288: invokevirtual length : ()I
    //   291: invokevirtual substring : (II)Ljava/lang/String;
    //   294: areturn
    //   295: aload #7
    //   297: areturn
    //   298: astore #7
    //   300: aload #7
    //   302: invokestatic e : (Ljava/lang/Throwable;)V
    //   305: new com/laiqian/util/logger/d
    //   308: dup
    //   309: ldc com/laiqian/util/n
    //   311: invokevirtual getName : ()Ljava/lang/String;
    //   314: ldc_w 'formatDoubleSimple'
    //   317: ldc_w '0'
    //   320: ldc_w '格式化double失败'
    //   323: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   326: getstatic com/laiqian/util/logger/h$a.dHx : Lcom/laiqian/util/logger/h$a;
    //   329: getstatic com/laiqian/util/logger/h$b.dHB : Lcom/laiqian/util/logger/h$b;
    //   332: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   335: dload_3
    //   336: invokestatic valueOf : (D)Ljava/lang/String;
    //   339: areturn
    // Exception table:
    //   from	to	target	type
    //   262	272	298	java/lang/Exception }
  
  @Deprecated
  private static String e(Context paramContext, boolean paramBoolean) {
    StorageManager storageManager = (StorageManager)paramContext.getSystemService("storage");
    try {
      null = Class.forName("android.os.storage.StorageVolume");
      Method method3 = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
      Method method1 = null.getMethod("getPath", new Class[0]);
      Method method2 = null.getMethod("isRemovable", new Class[0]);
      Object object = method3.invoke(storageManager, new Object[0]);
      int i = Array.getLength(object);
      for (byte b = 0; b < i; b++) {
        Object object1 = Array.get(object, b);
        String str = (String)method1.invoke(object1, new Object[0]);
        if (paramBoolean == ((Boolean)method2.invoke(object1, new Object[0])).booleanValue()) {
          object1 = new StatFs(str);
          int j = object1.getBlockCount();
          int k = object1.getBlockSize();
          if (j * k != 0)
            return str; 
        } 
      } 
    } catch (ClassNotFoundException paramContext) {
      a.e(paramContext);
    } catch (InvocationTargetException paramContext) {
      a.e(paramContext);
    } catch (NoSuchMethodException paramContext) {
      a.e(paramContext);
    } catch (IllegalAccessException paramContext) {
      a.e(paramContext);
    } catch (IllegalArgumentException paramContext) {
      a.e(paramContext);
    } 
    return null;
  }
  
  public static String e(Number paramNumber) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramNumber);
    stringBuilder.append("");
    String str2 = a(Double.valueOf(Double.parseDouble(stringBuilder.toString()) + 1.0E-9D), getPattern());
    double d = Double.parseDouble(str2);
    String str1 = a(paramNumber, "###");
    return (Math.abs(d - Double.parseDouble(str1)) <= 0.05D) ? str1 : str2;
  }
  
  public static void eP(@StringRes int paramInt) { w(null, paramInt); }
  
  public static double f(double paramDouble, int paramInt) {
    if (paramDouble > 1000000.0D || paramDouble < -1000000.0D)
      return aU(ba(paramDouble)); 
    byte b1 = 0;
    byte b2 = 1;
    while (b1 < paramInt) {
      b2 *= 10;
      b1++;
    } 
    double d = b2;
    paramDouble *= d;
    if (paramDouble >= 0.0D) {
      paramDouble += 0.500001D;
    } else {
      paramDouble -= 0.500001D;
    } 
    return (int)paramDouble * 1.0D / d;
  }
  
  public static double f(Object... paramVarArgs) {
    BigDecimal bigDecimal = BigDecimal.valueOf(1L);
    for (byte b = 0; b < paramVarArgs.length; b++) {
      if (!"".equals(paramVarArgs[b])) {
        double d = aU(paramVarArgs[b]);
        if (d == 0.0D)
          return 0.0D; 
        bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(d));
      } 
    } 
    return bigDecimal.doubleValue();
  }
  
  private static String f(Number paramNumber) { return (new DecimalFormat(",###")).format(paramNumber); }
  
  public static double g(Number paramNumber) { return (paramNumber == null) ? 0.0D : paramNumber.doubleValue(); }
  
  public static double g(Object... paramVarArgs) {
    BigDecimal bigDecimal = BigDecimal.valueOf(aU(paramVarArgs[0]));
    for (byte b = 1; b < paramVarArgs.length; b++) {
      double d = aU(paramVarArgs[b]);
      if (d == 0.0D)
        return 0.0D; 
      bigDecimal = bigDecimal.divide(BigDecimal.valueOf(d), 8, 6);
    } 
    return bigDecimal.doubleValue();
  }
  
  public static void g(String paramString, Object paramObject) {
    if (LQKVersion.zg()) {
      if (paramObject == null) {
        paramObject = "null";
      } else {
        paramObject = paramObject.toString();
      } 
      Log.e(paramString, paramObject);
    } 
  }
  
  private static String getPattern() {
    String str = "###.";
    for (byte b = 0; b < RootApplication.aIQ; b++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("#");
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  public static String h(Object... paramVarArgs) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      stringBuilder.append(paramVarArgs[b]); 
    return stringBuilder.toString();
  }
  
  public static boolean isKeycodeDelete(int paramInt) { return (paramInt == 67 || paramInt == 112); }
  
  public static String j(Date paramDate) {
    String str2 = pn(RootApplication.getLaiqianPreferenceManager().Ea());
    String str1 = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(paramDate);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RC");
    stringBuilder.append("-");
    stringBuilder.append(str2);
    stringBuilder.append("-");
    stringBuilder.append(str1);
    return stringBuilder.toString();
  }
  
  public static void j(EditText paramEditText) {
    if (paramEditText.isFocused())
      paramEditText.clearFocus(); 
    paramEditText.requestFocus();
    Selection.selectAll(paramEditText.getText());
  }
  
  public static String ls(int paramInt) {
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0; b < paramInt; b++)
      stringBuffer.append("-"); 
    return stringBuffer.toString();
  }
  
  public static boolean lt(int paramInt) { return (paramInt == 160 || paramInt == 66); }
  
  public static String m(File paramFile) {
    try {
      FileInputStream fileInputStream = new FileInputStream(paramFile);
      byte[] arrayOfByte = new byte[(int)paramFile.length()];
      fileInputStream.read(arrayOfByte);
      fileInputStream.close();
      return new String(arrayOfByte);
    } catch (Throwable paramFile) {
      a.e(paramFile);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("读取文件失败了，信息：");
      stringBuilder.append(paramFile.getMessage());
      return stringBuilder.toString();
    } 
  }
  
  public static void o(CharSequence paramCharSequence) { a(null, paramCharSequence); }
  
  public static int parseInt(String paramString) { return parseInt(paramString, 0); }
  
  public static int parseInt(String paramString, int paramInt) {
    if (paramString != null) {
      if (paramString.length() == 0)
        return paramInt; 
      try {
        return Integer.parseInt(paramString);
      } catch (NumberFormatException paramString) {
        a.e(paramString);
        return paramInt;
      } 
    } 
    return paramInt;
  }
  
  public static long parseLong(String paramString) {
    if (paramString != null) {
      if (paramString.length() == 0)
        return 0L; 
      try {
        return Long.parseLong(paramString);
      } catch (NumberFormatException paramString) {
        a.e(paramString);
        return 0L;
      } 
    } 
    return 0L;
  }
  
  public static void performClick(View paramView) {
    if (paramView == null)
      return; 
    if (Build.VERSION.SDK_INT >= 15) {
      paramView.callOnClick();
      return;
    } 
    paramView.performClick();
  }
  
  public static String ph(String paramString) {
    try {
      return (new BigDecimal(paramString)).toPlainString();
    } catch (NumberFormatException paramString) {
      return "0";
    } 
  }
  
  public static String pi(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("");
    return a(Double.valueOf(Double.parseDouble(stringBuilder.toString())), ",###.##");
  }
  
  public static String pj(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("");
    return a(Double.valueOf(Double.parseDouble(stringBuilder.toString())), getPattern());
  }
  
  public static String pk(String paramString) {
    if (paramString.indexOf(",") != -1)
      return paramString; 
    StringBuffer stringBuffer = new StringBuffer(paramString);
    int j = stringBuffer.indexOf(".");
    int i = j;
    if (j == -1)
      i = stringBuffer.length(); 
    if (stringBuffer.indexOf("-") != -1) {
      j = i - 1;
    } else {
      j = i;
    } 
    for (int k = 3; k < j; k += 3)
      stringBuffer.insert(i - k, ","); 
    return stringBuffer.toString();
  }
  
  public static boolean pl(String paramString) { return (paramString == null || paramString.length() == 0 || paramString.matches("\\D*0*\\.?0*")); }
  
  public static String pm(String paramString) { return paramString.replace(RootApplication.zA(), "").replace(",", ""); }
  
  public static String pn(String paramString) {
    String str = paramString;
    if (paramString.length() > 4)
      str = paramString.substring(paramString.length() - 4); 
    return str;
  }
  
  public static CharSequence po(String paramString) {
    StringBuilder stringBuilder;
    if (paramString != null && paramString.length() != 0) {
      if (pl(paramString))
        return paramString; 
      stringBuilder = new StringBuilder(paramString);
      for (byte b = 0; b < stringBuilder.length(); b++) {
        char c = stringBuilder.charAt(b);
        if ((c >= '0' && c <= '9') || c == '.') {
          stringBuilder.insert(b, '-');
          return stringBuilder;
        } 
        if (c == '-') {
          stringBuilder.deleteCharAt(b);
          return stringBuilder;
        } 
        if (c == '+') {
          stringBuilder.setCharAt(b, '-');
          return stringBuilder;
        } 
      } 
      return stringBuilder;
    } 
    return stringBuilder;
  }
  
  public static boolean pp(String paramString) {
    boolean bool = false;
    if (paramString == null || paramString.length() == 0 || paramString.charAt(0) < '㐀')
      bool = true; 
    return bool;
  }
  
  public static boolean pq(String paramString) { return bf("^\\+{0,1}[1-9]\\d*", paramString); }
  
  public static void println(Object paramObject) { Log.i("Log_smj", paramObject.toString()); }
  
  public static boolean ps(String paramString) { return bf("^-[1-9]\\d*", paramString); }
  
  public static boolean pt(String paramString) { return (bf("[+-]{0,1}0", paramString) || pq(paramString) || ps(paramString)); }
  
  public static boolean pu(String paramString) { return bf("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", paramString); }
  
  public static boolean pv(String paramString) { return (pt(paramString) || pu(paramString)); }
  
  public static boolean pw(String paramString) { return TextUtils.isEmpty(paramString) ? false : (!!Pattern.compile("[0-9]*").matcher(paramString).matches()); }
  
  public static boolean px(String paramString) { return Pattern.compile(".*[a-zA-Z]+.*").matcher(paramString).matches(); }
  
  public static double u(CharSequence paramCharSequence) {
    if (paramCharSequence != null) {
      if (paramCharSequence.length() == 0)
        return 0.0D; 
      paramCharSequence = paramCharSequence.toString();
      if (paramCharSequence.matches("-?[0-9]+\\.?[0-9]*"))
        try {
          return Double.parseDouble(paramCharSequence);
        } catch (Exception paramCharSequence) {
          return 0.0D;
        }  
      StringBuilder stringBuilder = asA();
      byte b;
      for (b = 0; b < paramCharSequence.length(); b++) {
        char c = paramCharSequence.charAt(b);
        if ((c >= '0' && c <= '9') || c == 'e' || c == 'E' || c == '.' || c == '-' || c == '+')
          stringBuilder.append(c); 
      } 
      if (stringBuilder.length() == 0)
        return 0.0D; 
      try {
        return Double.parseDouble(stringBuilder.toString());
      } catch (Exception paramCharSequence) {
        return 0.0D;
      } 
    } 
    return 0.0D;
  }
  
  public static void w(Context paramContext, @StringRes int paramInt) {
    RootApplication rootApplication = paramContext;
    if (paramContext == null)
      rootApplication = RootApplication.zv(); 
    a(rootApplication, rootApplication.getResources().getText(paramInt));
  }
  
  public static String x(Context paramContext, int paramInt) {
    Resources resources2 = paramContext.getResources();
    Configuration configuration = resources2.getConfiguration();
    Locale locale = configuration.locale;
    if (Locale.SIMPLIFIED_CHINESE.equals(locale))
      return paramContext.getString(paramInt); 
    configuration.locale = Locale.SIMPLIFIED_CHINESE;
    Resources resources1 = new Resources(resources2.getAssets(), resources2.getDisplayMetrics(), configuration);
    String str = resources1.getString(paramInt);
    configuration.locale = locale;
    new Resources(resources1.getAssets(), resources1.getDisplayMetrics(), configuration);
    println("强制获取了简体中文");
    return str;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\util\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */