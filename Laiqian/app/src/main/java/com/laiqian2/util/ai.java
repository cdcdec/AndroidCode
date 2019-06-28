package com.laiqian.util;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import c.h;
import c.n;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ai {
  private static String[] aYP = { 
      "/sys/devices/virtual/misc/qemu_pipe", "/system/lib/egl/libEGL_emulation.so", "/sys/module/vboxsf", "/system/droid4x", "/system/bin/droid4x-vbox-sf", "/system/lib/egl/libEGL_tiantianVM.so", "/system/bin/ttVM-vbox-sf", "/system/lib/libnox.so", "/system/bin/nox-vbox-sf", "/system/bin/androVM-vbox-sf", 
      "/ueventd.vbox86.rc", "/sys/class/misc/qemu_pipe", "/sys/qemu_trace", "/dev/com.bluestacks.superuser.daemon", "/system/framework/libqemu_wl.txt", "/system/lib/libc_malloc_debug_qemu.so-arm", "/data/downloads/qemu_list.txt", "/system/bin/yiwan-prop", "/system/bin/yiwan-sf" };
  
  private static String JN() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("35");
      stringBuilder.append(Build.BOARD.length() % 10);
      stringBuilder.append(Build.BRAND.length() % 10);
      stringBuilder.append(Build.CPU_ABI.length() % 10);
      stringBuilder.append(Build.DEVICE.length() % 10);
      stringBuilder.append(Build.DISPLAY.length() % 10);
      stringBuilder.append(Build.HOST.length() % 10);
      stringBuilder.append(Build.ID.length() % 10);
      stringBuilder.append(Build.MANUFACTURER.length() % 10);
      stringBuilder.append(Build.MODEL.length() % 10);
      stringBuilder.append(Build.PRODUCT.length() % 10);
      stringBuilder.append(Build.TAGS.length() % 10);
      stringBuilder.append(Build.TYPE.length() % 10);
      stringBuilder.append(Build.USER.length() % 10);
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static boolean JO() {
    String[] arrayOfString = new String[8];
    arrayOfString[0] = "/sbin/";
    arrayOfString[1] = "/system/bin/";
    arrayOfString[2] = "/system/xbin/";
    arrayOfString[3] = "/data/local/xbin/";
    arrayOfString[4] = "/data/local/bin/";
    arrayOfString[5] = "/system/sd/xbin/";
    arrayOfString[6] = "/system/bin/failsafe/";
    arrayOfString[7] = "/data/local/";
    int i = arrayOfString.length;
    for (byte b = 0; b < i; b++) {
      String str = arrayOfString[b];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("su");
      if ((new File(stringBuilder.toString())).exists())
        return true; 
    } 
    return false;
  }
  
  private static int JP() {
    try {
      return (new File("/sys/devices/system/cpu/")).listFiles(new aj()).length;
    } catch (Throwable throwable) {
      return 1;
    } 
  }
  
  private static String JQ() {
    try {
      return System.getProperty("os.arch");
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String JR() {
    try {
      File file = new File("/system/build.prop");
      if (!file.exists())
        return ""; 
      long l = file.lastModified();
      return String.valueOf(l);
    } catch (Throwable throwable) {
      return "unknown";
    } 
  }
  
  private static String JS() {
    try {
      File file = Environment.getExternalStorageDirectory();
      if (file == null)
        return "unknown"; 
      StatFs statFs = new StatFs(file.getPath());
      long l1 = k(statFs.getAvailableBlocks(), statFs.getBlockSize());
      long l2 = k(statFs.getBlockCount(), statFs.getBlockSize());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l1);
      stringBuilder.append("@");
      stringBuilder.append(l2);
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String JT() {
    try {
      a a = new a(24);
      for (byte b = 0;; b++) {
        if (b < aYP.length) {
          if ((new File(aYP[b])).exists())
            a.mark(b); 
        } else {
          return Base64.encodeToString(a.a(a), 0);
        } 
      } 
    } catch (Throwable throwable) {
      return "";
    } 
  }
  
  private static String JU() { return (String)JV().get("Serial"); }
  
  private static Map<String, String> JV() throws IOException {
    HashMap hashMap = new HashMap();
    h h = n.c(n.T(new File("/proc", "cpuinfo")));
    while (!h.aUS()) {
      String[] arrayOfString = h.aUZ().split(":");
      if (arrayOfString.length == 2)
        hashMap.put(arrayOfString[0].trim(), arrayOfString[1].trim()); 
    } 
    h.close();
    return hashMap;
  }
  
  private static String JW() { return cb.dGB.get("persist.sys.sn", "unknown"); }
  
  private static String JX() { return cb.dGB.get("persist.sys.model", "unknown"); }
  
  private static String JY() { return (Build.VERSION.SDK_INT >= 14) ? Build.getRadioVersion() : Build.RADIO; }
  
  private static boolean a(PackageManager paramPackageManager, String paramString) {
    try {
      PackageInfo packageInfo = paramPackageManager.getPackageInfo(paramString, 128);
      if (packageInfo != null)
        return true; 
    } catch (Throwable paramPackageManager) {}
    return false;
  }
  
  @SuppressLint({"HardwareIds"})
  private static String al(Context paramContext) {
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    String str1 = "";
    if (bluetoothAdapter != null)
      str1 = bluetoothAdapter.getAddress(); 
    String str2 = str1;
    if ("02:00:00:00:00:00".equals(str1))
      str2 = Settings.Secure.getString(paramContext.getContentResolver(), "bluetooth_address"); 
    return str2;
  }
  
  private static String am(Context paramContext) {
    try {
      PackageManager packageManager = paramContext.getPackageManager();
      a a = new a(8);
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "com.doubee.ig";
      arrayOfString[1] = "com.soft.apk008v";
      arrayOfString[2] = "com.soft.controllers";
      arrayOfString[3] = "de.robv.android.xposed.installer";
      arrayOfString[4] = "biz.bokhorst.xprivacy";
      for (byte b = 0;; b++) {
        if (b < arrayOfString.length) {
          if (a(packageManager, arrayOfString[b]))
            a.mark(b); 
        } else {
          return Base64.encodeToString(a.a(a), 0);
        } 
      } 
    } catch (Exception paramContext) {
      return "";
    } 
  }
  
  private static String an(Context paramContext) {
    try {
      DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(displayMetrics.widthPixels);
      stringBuilder.append(",");
      stringBuilder.append(displayMetrics.heightPixels);
      return stringBuilder.toString();
    } catch (Exception paramContext) {
      return "";
    } 
  }
  
  private static int ao(Context paramContext) {
    try {
      return (paramContext.getResources().getDisplayMetrics()).densityDpi;
    } catch (Exception paramContext) {
      return 0;
    } 
  }
  
  @SuppressLint({"WifiManagerPotentialLeak"})
  private static String ap(Context paramContext) {
    try {
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (wifiManager != null && wifiManager.getWifiState() == 3) {
        int i = wifiManager.getConnectionInfo().getIpAddress();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i & 0xFF);
        stringBuilder.append(".");
        stringBuilder.append(i >> 8 & 0xFF);
        stringBuilder.append(".");
        stringBuilder.append(i >> 16 & 0xFF);
        stringBuilder.append(".");
        stringBuilder.append(i >> 24 & 0xFF);
        return stringBuilder.toString();
      } 
      return "unknown";
    } catch (Exception paramContext) {
      return "unknown";
    } 
  }
  
  private static String aq(Context paramContext) {
    String str;
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager != null) {
        NetworkInfo networkInfo;
        str = connectivityManager.getActiveNetworkInfo();
        if (str == null) {
          String str1 = "";
        } else {
          String str1 = str.getTypeName();
        } 
      } else {
        return "unknown";
      } 
    } catch (Exception paramContext) {
      return "unknown";
    } 
    if (str == null) {
      str = "";
    } else {
      str = str.getSubtypeName();
    } 
    if ("MOBILE".equals(paramContext)) {
      String str1 = str;
      return TextUtils.isEmpty(str) ? paramContext : str1;
    } 
    return paramContext;
  }
  
  private static String ar(Context paramContext) {
    try {
      null = paramContext.getPackageManager().getInstalledApplications(8192);
      ArrayList arrayList = new ArrayList();
      null = new Intent("android.intent.action.MAIN", null);
      null.addCategory("android.intent.category.LAUNCHER");
      null = paramContext.getPackageManager().queryIntentActivities(null, 0);
      HashSet hashSet = new HashSet();
      Iterator iterator = null.iterator();
      while (iterator.hasNext())
        hashSet.add(((ResolveInfo)iterator.next()).activityInfo.packageName); 
      for (ApplicationInfo applicationInfo : null) {
        if (hashSet.contains(applicationInfo.packageName))
          arrayList.add(applicationInfo.packageName); 
      } 
      return arrayList.toString();
    } catch (Exception paramContext) {
      return "";
    } 
  }
  
  @SuppressLint({"HardwareIds"})
  private static String as(Context paramContext) { // Byte code:
    //   0: aload_0
    //   1: ldc_w 'wifi'
    //   4: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   7: checkcast android/net/wifi/WifiManager
    //   10: astore_3
    //   11: ldc ''
    //   13: astore_0
    //   14: aload_3
    //   15: ifnull -> 26
    //   18: aload_3
    //   19: invokevirtual getConnectionInfo : ()Landroid/net/wifi/WifiInfo;
    //   22: invokevirtual getMacAddress : ()Ljava/lang/String;
    //   25: astore_0
    //   26: aload_0
    //   27: astore_3
    //   28: ldc_w '02:00:00:00:00:00'
    //   31: aload_0
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 188
    //   38: invokestatic getNetworkInterfaces : ()Ljava/util/Enumeration;
    //   41: astore #4
    //   43: aload_0
    //   44: astore_3
    //   45: aload #4
    //   47: ifnull -> 188
    //   50: aload #4
    //   52: invokestatic list : (Ljava/util/Enumeration;)Ljava/util/ArrayList;
    //   55: invokevirtual iterator : ()Ljava/util/Iterator;
    //   58: astore #4
    //   60: aload_0
    //   61: astore_3
    //   62: aload #4
    //   64: invokeinterface hasNext : ()Z
    //   69: ifeq -> 188
    //   72: aload #4
    //   74: invokeinterface next : ()Ljava/lang/Object;
    //   79: checkcast java/net/NetworkInterface
    //   82: astore_3
    //   83: aload_3
    //   84: invokevirtual getName : ()Ljava/lang/String;
    //   87: ldc_w 'wlan0'
    //   90: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   93: ifne -> 99
    //   96: goto -> 60
    //   99: aload_3
    //   100: invokevirtual getHardwareAddress : ()[B
    //   103: astore_3
    //   104: aload_3
    //   105: ifnonnull -> 110
    //   108: aload_0
    //   109: areturn
    //   110: new java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: astore #5
    //   119: aload_3
    //   120: arraylength
    //   121: istore_2
    //   122: iconst_0
    //   123: istore_1
    //   124: iload_1
    //   125: iload_2
    //   126: if_icmpge -> 161
    //   129: aload #5
    //   131: ldc_w '%02X:'
    //   134: iconst_1
    //   135: anewarray java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_3
    //   141: iload_1
    //   142: baload
    //   143: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   146: aastore
    //   147: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   150: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: iload_1
    //   155: iconst_1
    //   156: iadd
    //   157: istore_1
    //   158: goto -> 124
    //   161: aload #5
    //   163: invokevirtual length : ()I
    //   166: ifle -> 60
    //   169: aload #5
    //   171: aload #5
    //   173: invokevirtual length : ()I
    //   176: iconst_1
    //   177: isub
    //   178: invokevirtual deleteCharAt : (I)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload #5
    //   184: invokevirtual toString : ()Ljava/lang/String;
    //   187: astore_3
    //   188: aload_3
    //   189: areturn }
  
  private static String at(Context paramContext) { return Settings.Secure.getString(paramContext.getContentResolver(), "android_id"); }
  
  @SuppressLint({"HardwareIds"})
  public static ag bU(Context paramContext) {
    String str8;
    String str9 = LQKVersion.zi();
    String str10 = bW(paramContext);
    String str11 = qp(str10);
    String str1 = "";
    try {
      String str = JU();
      str1 = str;
    } catch (IOException iOException) {
      a.e(iOException);
    } 
    String str2 = "";
    try {
      String str = as(paramContext);
      str2 = str;
    } catch (SocketException socketException) {
      a.e(socketException);
    } 
    String str3 = "";
    try {
      String str = al(paramContext);
      str3 = str;
    } catch (Exception exception) {
      a.e(exception);
    } 
    String str4 = "";
    try {
      String str = bV(paramContext);
      str4 = str;
    } catch (Exception exception) {
      a.e(exception);
    } 
    String str5 = "";
    try {
      String str = JW();
      str5 = str;
    } catch (Exception exception) {
      a.e(exception);
    } 
    String str6 = "";
    try {
      String str = JX();
      str6 = str;
    } catch (Exception exception) {
      a.e(exception);
    } 
    String str7 = "";
    try {
      str8 = at(paramContext);
      str7 = str8;
    } catch (Exception null) {
      a.e(str8);
    } 
    try {
      str8 = JY();
    } catch (Exception null) {
      a.e(null);
      str8 = "";
    } 
    return (new ah()).pC("unknown").pD("unknown").pE(str4).qo(str5).qn(str6).pF(str11).pG(str10).pH(Build.MODEL).pI(Build.BRAND).pJ("sabao").pL(Build.DISPLAY).pK(str9).ql(str1).qm(str7).pN(str2).pQ(str3).M(Boolean.valueOf(JO())).pT(am(paramContext)).pS(JN()).pM(an(paramContext)).w(Integer.valueOf(ao(paramContext))).pO(ap(paramContext)).pP(aq(paramContext)).pR(Build.FINGERPRINT).pU(JS()).pV(JR()).x(Integer.valueOf(JP())).pW(JQ()).pX(ar(paramContext)).pY(JT()).pZ(Build.CPU_ABI).qa(Build.CPU_ABI2).qb(Build.DEVICE).qc(Build.BOARD).qd(Build.HARDWARE).qe(Build.HOST).qf(Build.ID).qg(Build.MANUFACTURER).qh(Build.PRODUCT).qi(str8).qj(Build.TAGS).qk(Build.USER).asQ();
  }
  
  @SuppressLint({"HardwareIds"})
  private static String bV(Context paramContext) { return (Build.VERSION.SDK_INT >= 26) ? ((ActivityCompat.checkSelfPermission(paramContext, "android.permission.READ_PHONE_STATE") != 0) ? "unknown" : Build.getSerial()) : Build.SERIAL; }
  
  public static String bW(Context paramContext) {
    String str = "";
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (telephonyManager != null) {
      if (ActivityCompat.checkSelfPermission(paramContext, "android.permission.READ_PHONE_STATE") != 0)
        return ""; 
      str = telephonyManager.getDeviceId();
    } 
    return str;
  }
  
  private static long k(long paramLong1, long paramLong2) { return paramLong1 * paramLong2; }
  
  public static String qp(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(",");
    stringBuilder.append(Build.SERIAL);
    return stringBuilder.toString();
  }
  
  static class a {
    private byte[] bits;
    
    private int size;
    
    a(int param1Int) {
      this.bits = new byte[(param1Int + 7) / 8];
      this.size = this.bits.length * 8;
    }
    
    void mark(int param1Int) {
      if (param1Int < this.size) {
        if (param1Int < 0)
          return; 
        byte[] arrayOfByte = this.bits;
        int i = param1Int / 8;
        arrayOfByte[i] = (byte)(1 << param1Int % 8 | this.bits[i]);
        return;
      } 
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      for (byte b1 : this.bits) {
        for (byte b = 0; b < 8; b++)
          stringBuilder.append(Integer.toString(b1 >> b & true)); 
      } 
      return stringBuilder.toString();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */