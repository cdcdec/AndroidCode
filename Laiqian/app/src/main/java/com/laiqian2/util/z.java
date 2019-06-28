package com.laiqian.util;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class z {
  public static String B(Class<?> paramClass) { return (paramClass == android.text.format.Time.class) ? RootApplication.zv().getResources().getString(R.string.pos_pos_SimpleDFDay) : RootApplication.zv().getString(R.string.pos_pos_SimpleDateFormatDay); }
  
  public static int J(String paramString1, String paramString2, String paramString3) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(paramString3);
    try {
      Date date = simpleDateFormat.parse(paramString1);
    } catch (ParseException paramString1) {
      a.e(paramString1);
      paramString1 = null;
    } 
    try {
      Date date = simpleDateFormat.parse(paramString2);
    } catch (ParseException paramString2) {
      a.e(paramString2);
      paramString2 = null;
    } 
    int i = 0;
    int j = paramString1.getYear();
    int n = paramString2.getYear();
    paramString2.getMonth();
    paramString2.getMonth();
    int k = paramString1.getDate();
    int m = paramString2.getDate();
    if (paramString1.getTime() < paramString2.getTime()) {
      j = paramString2.getMonth() - paramString1.getMonth() + (n - j) * 12;
      i = j;
      if (m < k)
        i = j - 1; 
    } 
    return i;
  }
  
  public static long a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    return calendar.getTimeInMillis();
  }
  
  public static long a(Date paramDate, String paramString, int paramInt) {
    try {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(paramDate);
      calendar.add(2, paramInt);
      calendar.set(5, 1);
      return calendar.getTime().getTime();
    } catch (Exception paramDate) {
      a.e(paramDate);
      return -1L;
    } 
  }
  
  public static long asN() {
    date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
    try {
      return simpleDateFormat.parse(simpleDateFormat.format(date)).getTime();
    } catch (ParseException date) {
      a.e(date);
      return 0L;
    } 
  }
  
  public static long asO() {
    date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
    try {
      return simpleDateFormat.parse(simpleDateFormat.format(date)).getTime();
    } catch (ParseException date) {
      a.e(date);
      return 0L;
    } 
  }
  
  public static String b(long paramLong, String paramString) { return (new SimpleDateFormat(paramString)).format(new Date(paramLong)); }
  
  public static Date bg(String paramString1, String paramString2) {
    try {
      return (new SimpleDateFormat(paramString2)).parse(paramString1);
    } catch (ParseException paramString1) {
      return null;
    } 
  }
  
  public static String bh(String paramString1, String paramString2) { return bi(paramString1, paramString2); }
  
  public static String bi(String paramString1, String paramString2) { return b(n.parseLong(paramString1), paramString2); }
  
  public static String do(long paramLong) { return b(paramLong, " HH:mm"); }
  
  public static String dp(long paramLong) { return b(paramLong, RootApplication.zv().getResources().getString(R.string.pos_pos_SimpleDateFormatDDMM)); }
  
  public static String e(String paramString, Context paramContext) {
    StringBuilder stringBuilder;
    long l1 = asN();
    long l2 = l1 + 86400000L;
    long l3 = Long.valueOf(paramString).longValue();
    long l4 = l1 - 86400000L;
    long l5 = asO();
    if (l3 >= l1 && l3 < l2) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getString(R.string.pos_today));
      stringBuilder.append(do(l3));
      return stringBuilder.toString();
    } 
    if (l3 >= l2)
      return pA(stringBuilder); 
    if (l3 >= l4 && l3 < l1) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getString(R.string.pos_yesterday));
      stringBuilder.append(do(l3));
      return stringBuilder.toString();
    } 
    return (l3 >= l5 && l3 < l4) ? dp(l3) : ((l3 < l5) ? pA(stringBuilder) : null);
  }
  
  public static long f(String paramString1, String paramString2, int paramInt) {
    try {
      return a((new SimpleDateFormat(paramString2)).parse(paramString1), paramString2, paramInt);
    } catch (ParseException paramString1) {
      a.e(paramString1);
      return -1L;
    } 
  }
  
  public static String pA(String paramString) { return bi(paramString, RootApplication.zv().getResources().getString(R.string.pos_pos_SimpleDateFormat)); }
  
  public static String pB(String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    long l1 = Long.parseLong(paramString);
    long l3 = System.currentTimeMillis() - l1;
    l1 = (long)Math.ceil((l3 / 1000L));
    long l4 = l3 / 60L;
    long l2 = (long)Math.ceil(((float)l4 / 1000.0F));
    l4 = (long)Math.ceil(((float)(l4 / 60L) / 1000.0F));
    l3 = (long)Math.ceil(((float)(l3 / 24L / 60L / 60L) / 1000.0F));
    if (l3 - 1L > 0L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l3);
      stringBuilder.append("天");
      stringBuffer.append(stringBuilder.toString());
    } else if (l4 - 1L > 0L) {
      if (l4 >= 24L) {
        stringBuffer.append("1天");
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l4);
        stringBuilder.append("小时");
        stringBuffer.append(stringBuilder.toString());
      } 
    } else if (l2 - 1L > 0L) {
      if (l2 == 60L) {
        stringBuffer.append("1小时");
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l2);
        stringBuilder.append("分钟");
        stringBuffer.append(stringBuilder.toString());
      } 
    } else if (l1 - 1L > 0L) {
      if (l1 == 60L) {
        stringBuffer.append("1分钟");
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l1);
        stringBuilder.append("秒");
        stringBuffer.append(stringBuilder.toString());
      } 
    } else {
      stringBuffer.append("刚刚");
    } 
    if (!stringBuffer.toString().equals("刚刚"))
      stringBuffer.append("前"); 
    return stringBuffer.toString();
  }
  
  public static String pz(String paramString) {
    Date date = new Date();
    return (new SimpleDateFormat(paramString, Locale.getDefault())).format(date);
  }
  
  public static boolean q(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { return ((paramInt1 * 60 + paramInt2) < (paramInt3 * 60 + paramInt4)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */