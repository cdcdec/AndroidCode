package com.laiqian.login.b;

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
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import c.h;
import c.n;
import com.google.a.a.a.a.a.a;
import com.laiqian.message.m;
import com.laiqian.util.av;
import com.laiqian.util.ca;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d {
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
      return (new File("/sys/devices/system/cpu/")).listFiles(new e()).length;
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
  
  private static String JW() { return ca.get("persist.sys.sn", "unknown"); }
  
  private static String JX() { return ca.get("persist.sys.model", "unknown"); }
  
  private static String JY() { return (Build.VERSION.SDK_INT >= 14) ? Build.getRadioVersion() : Build.RADIO; }
  
  private static boolean a(PackageManager paramPackageManager, String paramString) {
    try {
      PackageInfo packageInfo = paramPackageManager.getPackageInfo(paramString, 128);
      if (packageInfo != null)
        return true; 
    } catch (Throwable paramPackageManager) {}
    return false;
  }
  
  public static b ak(Context paramContext) {
    String str9;
    av av = new av(paramContext);
    String str10 = av.Ea();
    String str11 = av.Tx();
    String str12 = av.getVersion();
    av.close();
    String str13 = m.Tw();
    String str1 = "";
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (telephonyManager != null)
      str1 = telephonyManager.getDeviceId(); 
    String str2 = "";
    try {
      String str = JU();
      str2 = str;
    } catch (IOException iOException) {
      a.e(iOException);
    } 
    String str3 = "";
    try {
      String str = as(paramContext);
      str3 = str;
    } catch (SocketException socketException) {
      a.e(socketException);
    } 
    String str4 = "";
    try {
      String str = al(paramContext);
      str4 = str;
    } catch (Exception exception) {
      a.e(exception);
    } 
    String str5 = "";
    try {
      String str = getSerial();
      str5 = str;
    } catch (Exception exception) {
      a.e(exception);
    } 
    String str6 = "";
    try {
      String str = JW();
      str6 = str;
    } catch (Exception exception) {
      a.e(exception);
    } 
    String str7 = "";
    try {
      String str = JX();
      str7 = str;
    } catch (Exception exception) {
      a.e(exception);
    } 
    String str8 = "";
    try {
      str9 = at(paramContext);
      str8 = str9;
    } catch (Exception null) {
      a.e(str9);
    } 
    try {
      str9 = JY();
    } catch (Exception null) {
      a.e(null);
      str9 = "";
    } 
    return (new c()).dT(str10).dU(str11).dV(str5).eF(str6).eE(str7).dW(str13).dX(str1).dY(Build.MODEL).dZ(Build.BRAND).ea("sabao").ec(Build.DISPLAY).eb(str12).eC(str2).eD(str8).ee(str3).eh(str4).c(Boolean.valueOf(JO())).ek(am(paramContext)).ej(JN()).ed(an(paramContext)).c(Integer.valueOf(ao(paramContext))).ef(ap(paramContext)).eg(aq(paramContext)).ei(Build.FINGERPRINT).el(JS()).em(JR()).d(Integer.valueOf(JP())).en(JQ()).eo(ar(paramContext)).ep(JT()).eq(Build.CPU_ABI).er(Build.CPU_ABI2).es(Build.DEVICE).et(Build.BOARD).eu(Build.HARDWARE).ev(Build.HOST).ew(Build.ID).ex(Build.MANUFACTURER).ey(Build.PRODUCT).ez(str9).eA(Build.TAGS).eB(Build.USER).JM();
  }
  
  @SuppressLint({"HardwareIds"})
  private static String al(Context paramContext) {
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    String str1 = "";
    if (bluetoothAdapter != null)
      str1 = bluetoothAdapter.getAddress(); 
    String str2 = str1;
    if (str1.equalsIgnoreCase("02:00:00:00:00:00"))
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
    //   28: aload_0
    //   29: ldc_w '02:00:00:00:00:00'
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 177
    //   38: invokestatic getNetworkInterfaces : ()Ljava/util/Enumeration;
    //   41: invokestatic list : (Ljava/util/Enumeration;)Ljava/util/ArrayList;
    //   44: invokevirtual iterator : ()Ljava/util/Iterator;
    //   47: astore #4
    //   49: aload_0
    //   50: astore_3
    //   51: aload #4
    //   53: invokeinterface hasNext : ()Z
    //   58: ifeq -> 177
    //   61: aload #4
    //   63: invokeinterface next : ()Ljava/lang/Object;
    //   68: checkcast java/net/NetworkInterface
    //   71: astore_3
    //   72: aload_3
    //   73: invokevirtual getName : ()Ljava/lang/String;
    //   76: ldc_w 'wlan0'
    //   79: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   82: ifne -> 88
    //   85: goto -> 49
    //   88: aload_3
    //   89: invokevirtual getHardwareAddress : ()[B
    //   92: astore_3
    //   93: aload_3
    //   94: ifnonnull -> 99
    //   97: aload_0
    //   98: areturn
    //   99: new java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial <init> : ()V
    //   106: astore #5
    //   108: aload_3
    //   109: arraylength
    //   110: istore_2
    //   111: iconst_0
    //   112: istore_1
    //   113: iload_1
    //   114: iload_2
    //   115: if_icmpge -> 150
    //   118: aload #5
    //   120: ldc_w '%02X:'
    //   123: iconst_1
    //   124: anewarray java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_3
    //   130: iload_1
    //   131: baload
    //   132: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   135: aastore
    //   136: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: iload_1
    //   144: iconst_1
    //   145: iadd
    //   146: istore_1
    //   147: goto -> 113
    //   150: aload #5
    //   152: invokevirtual length : ()I
    //   155: ifle -> 49
    //   158: aload #5
    //   160: aload #5
    //   162: invokevirtual length : ()I
    //   165: iconst_1
    //   166: isub
    //   167: invokevirtual deleteCharAt : (I)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload #5
    //   173: invokevirtual toString : ()Ljava/lang/String;
    //   176: astore_3
    //   177: aload_3
    //   178: areturn }
  
  private static String at(Context paramContext) { return Settings.Secure.getString(paramContext.getContentResolver(), "android_id"); }
  
  @SuppressLint({"HardwareIds"})
  private static String getSerial() { return (Build.VERSION.SDK_INT >= 25) ? Build.getSerial() : Build.SERIAL; }
  
  private static long k(long paramLong1, long paramLong2) { return paramLong1 * paramLong2; }
  
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */