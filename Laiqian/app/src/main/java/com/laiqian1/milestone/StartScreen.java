package com.laiqian.milestone;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.igexin.sdk.PushManager;
import com.laiqian.db.b;
import com.laiqian.db.multidatabase.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.n;
import com.laiqian.version.s;
import com.umeng.analytics.MobclickAgent;
import io.reactivex.g.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.json.JSONObject;

public class StartScreen extends ActivityRoot {
  private static String bJA = "language";
  
  private static String bJB = "";
  
  private static int bJy = 12345;
  
  public static String bJz = "apk_version";
  
  private final String bJC = "upgrading_database";
  
  private final String bJD = "upgraded_database_success";
  
  private final String bJE = "upgraded_database_failed";
  
  private final String bJF = "updating_apk";
  
  private final String bJG = "login";
  
  private TextView bJH;
  
  private Context bJI = null;
  
  boolean bJJ = false;
  
  private TextView bJK;
  
  Handler bJL = new e(this);
  
  private String bJM = "printer.json";
  
  private int bJw = 3000;
  
  private long bJx = 0L;
  
  static  {
  
  }
  
  private void TF() {
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    float f = displayMetrics.widthPixels / 1024.0F;
    displayMetrics.density = f;
    displayMetrics.scaledDensity = f;
  }
  
  private void TG() {
    this.bJK = (TextView)findViewById(2131299058);
    if (!getResources().getBoolean(2131034123)) {
      ((RelativeLayout)findViewById(2131298761)).setBackgroundResource(2131099897);
      ((ImageView)findViewById(2131297355)).setVisibility(0);
      ((ImageView)findViewById(2131297354)).setVisibility(0);
      ((TextView)findViewById(2131299059)).setTextColor(getResources().getColor(2131100025));
    } 
  }
  
  private void TH() {
    Log.d("GetuiSdkDemo", "initializing sdk...");
    PushManager.getInstance().initialize(getApplicationContext());
  }
  
  private void TI() { startActivity(new Intent(this, com.laiqian.pos.intro.IntroActivity.class)); }
  
  private boolean TJ() { // Byte code:
    //   0: ldc '<---------copyUsbDevicePropertyFileIfHigerVersion--------->'
    //   2: invokestatic ct : (Ljava/lang/String;)V
    //   5: new java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore #7
    //   14: aload #7
    //   16: aload_0
    //   17: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   20: getfield dataDir : Ljava/lang/String;
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload #7
    //   29: ldc '/'
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload #7
    //   37: invokevirtual toString : ()Ljava/lang/String;
    //   40: astore #7
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore #8
    //   51: aload #8
    //   53: aload #7
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #8
    //   61: aload_0
    //   62: getfield bJM : Ljava/lang/String;
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: new java/io/File
    //   72: dup
    //   73: aload #8
    //   75: invokevirtual toString : ()Ljava/lang/String;
    //   78: invokespecial <init> : (Ljava/lang/String;)V
    //   81: astore #8
    //   83: aload_0
    //   84: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   87: astore #7
    //   89: aload #8
    //   91: invokevirtual exists : ()Z
    //   94: ifeq -> 211
    //   97: iconst_0
    //   98: istore #6
    //   100: new com/laiqian/print/util/c
    //   103: dup
    //   104: new java/io/FileInputStream
    //   107: dup
    //   108: aload #8
    //   110: invokespecial <init> : (Ljava/io/File;)V
    //   113: invokespecial <init> : (Ljava/io/InputStream;)V
    //   116: astore #8
    //   118: new com/laiqian/print/util/c
    //   121: dup
    //   122: aload #7
    //   124: aload_0
    //   125: getfield bJM : Ljava/lang/String;
    //   128: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   131: invokespecial <init> : (Ljava/io/InputStream;)V
    //   134: astore #7
    //   136: aload #8
    //   138: invokevirtual ajb : ()Ljava/lang/Double;
    //   141: ifnull -> 189
    //   144: aload #7
    //   146: invokevirtual ajb : ()Ljava/lang/Double;
    //   149: ifnull -> 189
    //   152: aload #7
    //   154: invokevirtual ajb : ()Ljava/lang/Double;
    //   157: invokevirtual doubleValue : ()D
    //   160: dstore_1
    //   161: aload #8
    //   163: invokevirtual ajb : ()Ljava/lang/Double;
    //   166: invokevirtual doubleValue : ()D
    //   169: dstore_3
    //   170: dload_1
    //   171: dload_3
    //   172: dcmpl
    //   173: ifle -> 189
    //   176: iconst_1
    //   177: istore #5
    //   179: goto -> 192
    //   182: astore #7
    //   184: aload #7
    //   186: invokestatic e : (Ljava/lang/Throwable;)V
    //   189: iconst_0
    //   190: istore #5
    //   192: iload #5
    //   194: ifeq -> 217
    //   197: ldc_w 'tag'
    //   200: ldc_w 'overriding printer.json'
    //   203: invokestatic f : (Ljava/lang/String;Ljava/lang/Object;)V
    //   206: aload_0
    //   207: invokespecial TK : ()Z
    //   210: ireturn
    //   211: aload_0
    //   212: invokespecial TK : ()Z
    //   215: istore #6
    //   217: iload #6
    //   219: ireturn
    // Exception table:
    //   from	to	target	type
    //   100	170	182	java/io/IOException }
  
  private boolean TK() {
    assetManager = getAssets();
    null = new StringBuilder();
    null.append((getApplicationInfo()).dataDir);
    null.append("/");
    null = null.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(null);
    stringBuilder.append(this.bJM);
    File file = new File(stringBuilder.toString());
    try {
      InputStream inputStream = assetManager.open(this.bJM);
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int i = inputStream.read(arrayOfByte);
        if (i > 0) {
          fileOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        break;
      } 
      inputStream.close();
      fileOutputStream.close();
      return true;
    } catch (IOException assetManager) {
      a.e(assetManager);
      return false;
    } finally {}
    throw assetManager;
  }
  
  private boolean TL() { return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("callin_isEnable", true); }
  
  private boolean TM() { return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("callout_isEnable", true); }
  
  private void TN() {
    MobclickAgent.setDebugMode(true);
    getSharedPreferences("settings", 0).getString("isShowFeaturePage", "1");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("device=");
    stringBuilder.append(aI(getApplication()));
    bb.ao(stringBuilder.toString());
  }
  
  private void TO() {
    bJB = (getResources().getConfiguration()).locale.getLanguage();
    SharedPreferences.Editor editor = getSharedPreferences("settings", 0).edit();
    if (bJB.equals("zh")) {
      editor.putString(bJA, bJB);
    } else {
      editor.putString(bJA, "");
    } 
    editor.commit();
  }
  
  private void TP() {
    b.ct("<----deleteOldLocalDataAndFiles----->");
    (new b()).Z(this);
    h h = new h(this);
    SharedPreferences sharedPreferences = getSharedPreferences("settings", 0);
    long l = Long.parseLong(sharedPreferences.getString("shop_id", "-1"));
    if (l > 0L) {
      long[] arrayOfLong = h.aS(l);
      long l1 = TR();
      l1 = arrayOfLong[1] - l1 * 864L * 100000L;
      if (l1 > arrayOfLong[0])
        h.a(l, arrayOfLong[0], l1); 
    } 
    String str = h.getVersion();
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString(bJz, str);
    editor.commit();
    h.close();
  }
  
  private void TQ() {
    s s = new s(getApplicationContext());
    if (s.dJO) {
      this.bJJ = true;
      av av = new av(this);
      av.hp(true);
      av.close();
      Log.e("laiqian_upgrade_version", "\t保存是否升级标记--bUpgrade value is true.");
      this.bJL.obtainMessage(1).sendToTarget();
      if (s.axi()) {
        this.bJL.obtainMessage(2).sendToTarget();
      } else {
        this.bJL.obtainMessage(3).sendToTarget();
      } 
      s.axh();
    } else {
      this.bJL.obtainMessage(0).sendToTarget();
    } 
    s.close();
  }
  
  public static String aI(Context paramContext) {
    try {
      JSONObject jSONObject = new JSONObject();
      String str2 = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      String str3 = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      jSONObject.put("mac", str3);
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = str3; 
      str2 = str1;
      if (TextUtils.isEmpty(str1))
        str2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id"); 
      jSONObject.put("device_id", str2);
      return jSONObject.toString();
    } catch (Exception paramContext) {
      a.e(paramContext);
      return null;
    } 
  }
  
  public static String aJ(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException paramContext) {
      a.e(paramContext);
      return "1.89";
    } 
  }
  
  public static boolean n(Context paramContext, String paramString) {
    List list = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(50);
    if (list.size() <= 0)
      return false; 
    for (byte b = 0; b < list.size(); b++) {
      if (((ActivityManager.RunningServiceInfo)list.get(b)).service.getClassName().equals(paramString) == true)
        return true; 
    } 
    return false;
  }
  
  private void wZ() { this.bJH = (TextView)findViewById(2131299059); }
  
  private void xb() {
    TH();
    TextView textView = this.bJH;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getString(2131630365));
    stringBuilder.append(" ");
    stringBuilder.append(aJ(this));
    stringBuilder.append(" ");
    textView.setText(stringBuilder.toString());
    ((NotificationManager)getSystemService("notification")).cancel(bJy);
    this.bJx = System.currentTimeMillis();
    this.bJI = getApplicationContext();
    a.aKh().r(new d(this));
  }
  
  protected long TR() { return Long.parseLong(getSharedPreferences("com.laiqian.milestone_preferences", 0).getString("cf_DataRetentionPeriod", "10000")); }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    c.aYt().cJ(this);
    if ((getIntent().getFlags() & 0x400000) != 0) {
      finish();
      return;
    } 
    TF();
    setContentView(2131428133);
    TG();
    TN();
    wZ();
    TO();
    xb();
    n.T(this);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    c.aYt().cL(this);
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() { super.onResume(); }
  
  @Subscribe(aYx = ThreadMode.MAIN)
  public void updateProgress(a parama) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("进度-->");
    stringBuilder.append(parama.Dj());
    b.ct(stringBuilder.toString());
    String str = parama.Dj();
    Message message = this.bJL.obtainMessage();
    message.obj = str;
    message.what = 4;
    this.bJL.sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\StartScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */