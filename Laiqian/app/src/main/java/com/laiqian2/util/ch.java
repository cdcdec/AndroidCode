package com.laiqian.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.google.a.a.a.a.a.a;
import com.laiqian.backup.ag;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.network.t;
import com.laiqian.pos.industry.a;
import com.orhanobut.logger.d;
import io.reactivex.g.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ch {
  private static final String dGK;
  
  private static final String dGL;
  
  private static final String dGM;
  
  private static final String dGN;
  
  static  {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LQKVersion.zh());
    stringBuilder.append("Apk");
    dGK = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(dGK);
    stringBuilder.append("/patch");
    dGL = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(LQKVersion.zk());
    stringBuilder.append("_");
    stringBuilder.append(LQKVersion.zh());
    stringBuilder.append(".apk");
    dGM = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(LQKVersion.zk());
    stringBuilder.append("_f_");
    stringBuilder.append(LQKVersion.zh());
    stringBuilder.append(".apk");
    dGN = stringBuilder.toString();
  }
  
  @Deprecated
  public static boolean F(Context paramContext, String paramString) {
    double d1 = Double.valueOf(paramString).doubleValue();
    double d2 = cd(paramContext);
    return (d2 == 0.0D) ? true : ((d1 > d2 && d2 > 0.0D) ? true : ((d1 == d2) ? false : false));
  }
  
  public static boolean G(Context paramContext, String paramString) {
    double d1 = Double.valueOf(paramString).doubleValue();
    double d2 = ce(paramContext);
    return (d2 == 0.0D) ? true : ((d1 > d2 && d2 > 0.0D) ? true : ((d1 == d2) ? false : false));
  }
  
  public static String H(Context paramContext, String paramString) {
    new HashMap();
    String str = (new av(paramContext)).rl(by.sc(paramString));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("VersionInfo=");
    stringBuilder.append(str);
    bb.ao(stringBuilder.toString());
    return "0".equals(str) ? null : (String)au.qB((String)au.qB(str).get("sServerJson")).get("sUpgradeDesc");
  }
  
  public static boolean I(Context paramContext, String paramString) {
    if (paramString == null)
      return false; 
    av av = new av(paramContext);
    String str2 = av.auD();
    String str1 = str2;
    if (!str2.contains(paramString)) {
      null = new StringBuilder();
      null.append(str2);
      null.append(paramString);
      null.append(",");
      str1 = null.toString();
    } 
    return av.rk(str1);
  }
  
  public static boolean J(Context paramContext, String paramString) {
    av av = new av(paramContext);
    List list = l.bd(String.valueOf(au.qB(String.valueOf(K(paramContext, paramString).get("sServerJson"))).get("sUpgradeDesc")), "\n");
    ArrayList arrayList = new ArrayList();
    boolean bool = false;
    byte b = 0;
    if (list != null) {
      while (b < list.size()) {
        HashMap hashMap = new HashMap();
        hashMap.put("feature", list.get(b));
        hashMap.put("evaluate", "No");
        arrayList.add(hashMap);
        b++;
      } 
      bool = av.i(paramString, arrayList);
      av.close();
    } 
    return bool;
  }
  
  public static HashMap<String, Object> K(Context paramContext, String paramString) {
    av av = new av(paramContext);
    paramString = av.rl(paramString);
    av.close();
    return !"0".equals(paramString) ? au.qB(paramString) : null;
  }
  
  public static boolean L(Context paramContext, String paramString) {
    ArrayList arrayList = (ArrayList)((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(30);
    for (byte b = 0; b < arrayList.size(); b++) {
      if (((ActivityManager.RunningServiceInfo)arrayList.get(b)).service.getClassName().toString().equals(paramString))
        return true; 
    } 
    return false;
  }
  
  public static void a(Context paramContext, Handler paramHandler) { a.aKh().r(new ci(paramHandler, paramContext)); }
  
  public static void a(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3) { a.aKh().r(new cj(paramContext, paramString2, paramString1, paramString3, paramHandler)); }
  
  public static String ab(HashMap<String, Object> paramHashMap) {
    if (paramHashMap == null)
      return null; 
    String str1 = (String)paramHashMap.get("_id");
    String str2 = z.bh(str1, "yyyyMMdd");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(by.sc(String.valueOf(paramHashMap.get("fVersion"))));
    stringBuilder.append("-");
    stringBuilder.append(str2);
    stringBuilder.append("-");
    stringBuilder.append(str1);
    stringBuilder.append(".apk");
    bb.ao(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(by.sc(String.valueOf(paramHashMap.get("fVersion"))));
    stringBuilder.append("-");
    stringBuilder.append(str2);
    stringBuilder.append("-");
    stringBuilder.append(str1);
    stringBuilder.append(".apk");
    return stringBuilder.toString();
  }
  
  public static boolean awC() {
    System.out.print("--------------------");
    System.out.print(ca.getInt("ro.sw.version", 0));
    System.out.print(RootApplication.getLaiqianPreferenceManager().avv());
    System.out.print("--------------------");
    return (ca.getInt("ro.sw.version", 0) < RootApplication.getLaiqianPreferenceManager().avv());
  }
  
  private static String awD() {
    File file = new File(Environment.getExternalStorageDirectory(), dGK);
    if (!file.exists())
      file.mkdirs(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file.getPath());
    stringBuilder.append("/");
    return stringBuilder.toString();
  }
  
  public static String awE() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(awD());
    stringBuilder.append(dGM);
    return stringBuilder.toString();
  }
  
  public static String awF() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(awD());
    stringBuilder.append(dGN);
    return stringBuilder.toString();
  }
  
  public static String awG() {
    File file = new File(Environment.getExternalStorageDirectory(), dGL);
    if (!file.exists())
      file.mkdirs(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file.getPath());
    stringBuilder.append("/");
    return stringBuilder.toString();
  }
  
  public static String awH() {
    null = Environment.getExternalStorageDirectory();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(null.getPath());
    stringBuilder.append("/");
    String str = stringBuilder.toString();
    File file = new File(str);
    if (file.exists())
      return str; 
    file.mkdirs();
    return str;
  }
  
  public static String awI() {
    packageManager = RootApplication.zv().getPackageManager();
    try {
      return (packageManager.getPackageInfo(RootApplication.zv().getPackageName(), 0)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException packageManager) {
      a.e(packageManager);
      return "";
    } 
  }
  
  public static String awJ() {
    null = Build.MODEL;
    null = Build.VERSION.RELEASE;
    awK();
    jSONObject = new JSONObject();
    try {
      jSONObject.put(t.bUV, Build.VERSION.RELEASE);
      jSONObject.put(t.bUW, Build.MODEL);
      jSONObject.put(t.bUX, awK());
      return jSONObject.toString();
    } catch (JSONException jSONObject) {
      return "";
    } 
  }
  
  public static String awK() {
    try {
      FileInputStream fileInputStream = new FileInputStream("/proc/version");
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), ' ');
      str = "";
      try {
        while (true) {
          String str1 = bufferedReader.readLine();
          if (str1 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str1);
            str1 = stringBuilder.toString();
            str = str1;
            continue;
          } 
          break;
        } 
        try {
          bufferedReader.close();
          fileInputStream.close();
        } catch (IOException iOException) {
          a.e(iOException);
        } 
      } catch (IOException iOException) {
        a.e(iOException);
        bufferedReader.close();
        fileInputStream.close();
      } finally {}
      if (str != "")
        try {
          str = str.substring(str.indexOf("version ") + "version ".length());
          return str.substring(0, str.indexOf(" "));
        } catch (IndexOutOfBoundsException str) {
          a.e(str);
        }  
      return "";
    } catch (FileNotFoundException fileNotFoundException) {
      a.e(fileNotFoundException);
      return "";
    } 
  }
  
  @Deprecated
  public static boolean cb(Context paramContext) {
    if (cf(paramContext) >= cd(paramContext)) {
      av = new av(paramContext);
      av.hC(false);
      av.close();
      return false;
    } 
    av av = new av(av);
    av.hC(true);
    av.close();
    return true;
  }
  
  public static boolean cc(Context paramContext) {
    if (cf(paramContext) >= ce(paramContext)) {
      av = new av(paramContext);
      av.hC(false);
      av.close();
      return false;
    } 
    av av = new av(av);
    av.hC(true);
    av.close();
    return true;
  }
  
  @Deprecated
  public static double cd(Context paramContext) {
    String str = awE();
    if ((new File(str)).exists()) {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageArchiveInfo(str, 1);
      if (packageInfo != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("本地版本号");
        stringBuilder.append(packageInfo.versionName);
        bb.e("versionCode", stringBuilder.toString());
        return n.u(packageInfo.versionName);
      } 
      return 0.0D;
    } 
    return 0.0D;
  }
  
  public static double ce(Context paramContext) {
    String str = awF();
    if ((new File(str)).exists()) {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageArchiveInfo(str, 1);
      if (packageInfo != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("本地版本号");
        stringBuilder.append(packageInfo.versionName);
        bb.e("versionCode", stringBuilder.toString());
        return n.u(packageInfo.versionName);
      } 
      return 0.0D;
    } 
    return 0.0D;
  }
  
  @Deprecated
  public static double cf(Context paramContext) {
    try {
      return Double.valueOf((paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionName).doubleValue();
    } catch (Exception paramContext) {
      a.e(paramContext);
      return 0.0D;
    } 
  }
  
  public static String cg(Context paramContext) {
    String[] arrayOfString = (new av(paramContext)).auD().split(",");
    return arrayOfString[arrayOfString.length - 1];
  }
  
  public static String ch(Context paramContext) {
    null = new StringBuilder();
    null.append(cf(paramContext));
    null.append("");
    String str2 = by.sc(null.toString());
    String str1 = (new av(paramContext)).auD();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append(",");
    return str1.contains(stringBuilder.toString()) ? str2 : null;
  }
  
  public static List<String> ci(Context paramContext) {
    String str3 = ch(paramContext);
    av av = new av(paramContext);
    String str2 = av.auD();
    String str1 = str2;
    if (str3 != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str3);
      stringBuilder.append(",");
      str1 = str2;
      if (str2.contains(stringBuilder.toString())) {
        int i = str3.length();
        null = new StringBuilder();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str3);
        stringBuilder.append(",");
        null.append(str2.substring(0, str2.indexOf(stringBuilder.toString())));
        stringBuilder = new StringBuilder();
        stringBuilder.append(str3);
        stringBuilder.append(",");
        null.append(str2.substring(str2.indexOf(stringBuilder.toString()) + i + 1, str2.length()));
        str1 = null.toString();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("sAllUpgradeVersion=");
        stringBuilder1.append(str1);
        bb.ao(stringBuilder1.toString());
      } 
    } 
    av.close();
    return l.bd(str1, ",");
  }
  
  public static ArrayList<HashMap<String, String>> cj(Context paramContext) {
    ArrayList arrayList = new ArrayList();
    List list = ci(paramContext);
    if (list != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("versionNameList=");
      stringBuilder.append(list.size());
      stringBuilder.append(list.toString());
      bb.ao(stringBuilder.toString());
    } 
    if (list != null && list.size() > 0) {
      for (int i = list.size(); i > 0; i--) {
        HashMap hashMap1 = new HashMap();
        int j = i - 1;
        HashMap hashMap2 = K(paramContext, (String)list.get(j));
        if (hashMap2 != null && "YES".equals(String.valueOf(hashMap2.get("sInstallStatus")))) {
          hashMap2 = au.qB(String.valueOf(hashMap2.get("sServerJson")));
          if (hashMap2 != null) {
            String str = String.valueOf(hashMap2.get("sUpgradeDesc"));
            hashMap1.put("version", list.get(j));
            hashMap1.put("feature", str);
            arrayList.add(hashMap1);
          } 
        } 
      } 
      return arrayList;
    } 
    return null;
  }
  
  public static void ck(Context paramContext) {
    Intent intent = new Intent("android.intent.action.VIEW");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("file://");
    stringBuilder.append(awE());
    intent.setDataAndType(Uri.parse(stringBuilder.toString()), "application/vnd.android.package-archive");
    intent.addFlags(268435456);
    paramContext.startActivity(intent);
    d.b(" install apk", new Object[0]);
  }
  
  public static void cl(Context paramContext) {
    Intent intent = new Intent("android.intent.action.VIEW");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("file://");
    stringBuilder.append(awF());
    intent.setDataAndType(Uri.parse(stringBuilder.toString()), "application/vnd.android.package-archive");
    intent.addFlags(268435456);
    paramContext.startActivity(intent);
    d.b(" install apk", new Object[0]);
  }
  
  public static boolean e(Context paramContext, String paramString1, String paramString2, String paramString3) {
    if (paramString1 == null)
      return false; 
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("sInstallStatus", paramString3);
      jSONObject.put("sServerJson", paramString2);
      return (new av(paramContext)).bm(paramString1, jSONObject.toString());
    } catch (JSONException paramContext) {
      a.e(paramContext);
      return false;
    } 
  }
  
  public static int getVersionCode() {
    packageManager = RootApplication.zv().getPackageManager();
    try {
      return (packageManager.getPackageInfo(RootApplication.zv().getPackageName(), 0)).versionCode;
    } catch (android.content.pm.PackageManager.NameNotFoundException packageManager) {
      a.e(packageManager);
      return 0;
    } 
  }
  
  public static double py(String paramString) {
    double d2 = 0.0D;
    double d1 = d2;
    try {
      StatFs statFs = new StatFs(paramString);
      d1 = d2;
      long l = statFs.getBlockSize();
      d1 = d2;
      d2 = (statFs.getAvailableBlocks() * l / 1024L);
      d1 = d2;
      StringBuilder stringBuilder = new StringBuilder();
      d1 = d2;
      stringBuilder.append(d2);
      d1 = d2;
      stringBuilder.append("K");
      d1 = d2;
      bb.e("存储器剩余大小", stringBuilder.toString());
      return d2;
    } catch (Exception paramString) {
      a.e(paramString);
      return d1;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */