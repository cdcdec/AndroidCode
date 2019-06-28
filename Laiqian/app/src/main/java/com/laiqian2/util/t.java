package com.laiqian.util;

import com.google.a.a.a.a.a.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class t {
  public static final ThreadLocal<SimpleDateFormat> dFb = new u();
  
  public static final ThreadLocal<SimpleDateFormat> dFc = new v();
  
  public static final ThreadLocal<SimpleDateFormat> dFd = new w();
  
  public static final ThreadLocal<SimpleDateFormat> dFe = new x();
  
  public static final ThreadLocal<SimpleDateFormat> dFf = new y();
  
  public static long a(String paramString, ThreadLocal<SimpleDateFormat> paramThreadLocal) {
    try {
      return ((SimpleDateFormat)paramThreadLocal.get()).parse(paramString).getTime();
    } catch (ParseException paramString) {
      a.e(paramString);
      return 0L;
    } 
  }
  
  public static String a(long paramLong, ThreadLocal<SimpleDateFormat> paramThreadLocal) {
    Date date = new Date(paramLong);
    return ((SimpleDateFormat)paramThreadLocal.get()).format(date);
  }
  
  public static String a(ThreadLocal<SimpleDateFormat> paramThreadLocal) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(System.currentTimeMillis()));
    calendar.add(1, 1);
    return ((SimpleDateFormat)paramThreadLocal.get()).format(calendar.getTime());
  }
  
  public static String a(ThreadLocal<SimpleDateFormat> paramThreadLocal, int paramInt) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(System.currentTimeMillis()));
    calendar.add(1, paramInt);
    return ((SimpleDateFormat)paramThreadLocal.get()).format(calendar.getTime());
  }
  
  public static long asH() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(System.currentTimeMillis()));
    return a(((SimpleDateFormat)dFe.get()).format(calendar.getTime()), dFe);
  }
  
  public static long asI() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(System.currentTimeMillis()));
    calendar.add(1, 1);
    return calendar.getTimeInMillis();
  }
  
  public static String asJ() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(System.currentTimeMillis()));
    return (new SimpleDateFormat("d")).format(calendar.getTime());
  }
  
  public static int asK() {
    Calendar calendar = Calendar.getInstance();
    return (calendar.get(7) == 1) ? 7 : (calendar.get(7) - 1);
  }
  
  public static long asL() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(System.currentTimeMillis()));
    calendar.add(2, 1);
    return calendar.getTimeInMillis();
  }
  
  public static String b(String paramString, ThreadLocal<SimpleDateFormat> paramThreadLocal) {
    Date date = new Date(Long.valueOf(paramString).longValue());
    return ((SimpleDateFormat)paramThreadLocal.get()).format(date);
  }
  
  public static String b(ThreadLocal<SimpleDateFormat> paramThreadLocal) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(System.currentTimeMillis()));
    calendar.add(2, 1);
    return ((SimpleDateFormat)paramThreadLocal.get()).format(calendar.getTime());
  }
  
  public static String k(Date paramDate) { return ((SimpleDateFormat)dFc.get()).format(paramDate); }
  
  public static long lu(int paramInt) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(System.currentTimeMillis()));
    calendar.add(1, paramInt);
    return calendar.getTimeInMillis();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */