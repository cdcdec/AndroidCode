package com.laiqian.basic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDexApplication;
import b.aa;
import com.laiqian.infrastructure.R;
import com.laiqian.message.k;
import com.laiqian.pos.hardware.a.b;
import com.laiqian.util.av;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
public abstract class RootApplication extends MultiDexApplication {
  public static int aIQ = 0;
  
  public static int aIS = 2;
  
  private static RootApplication aIT;
  
  public static final ArrayList<Activity> aIV = new ArrayList();
  
  private av aIP;
  
  private String aIR;
  
  private LQKVersion.a aIU;
  
  protected k aIW;
  
  protected b aIX;
  
  private aa aIY;
  
  private Handler handler;
  
  public static av getLaiqianPreferenceManager() {
    if (aIT.aIP == null)
      aIT.aIP = new av(zv()); 
    return aIT.aIP;
  }
  
  public static void runOnUiThread(Runnable paramRunnable) {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      paramRunnable.run();
      return;
    } 
    (zv()).handler.post(paramRunnable);
  }
  
  public static String zA() {
    if (aIT.aIR == null)
      aIT.aIR = zv().getString(R.string.pos_money_symbol); 
    return aIT.aIR;
  }
  
  private void zu() {
    zD();
    this.aIY = zF();
  }
  
  public static RootApplication zv() { return aIT; }
  
  public static Resources zw() { return zv().getResources(); }
  
  public static void zx() { aIT.aIR = null; }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    this.aIR = null;
  }
  
  public void onCreate() {
    super.onCreate();
    aIT = this;
    this.aIU = zz();
    this.handler = new Handler(getMainLooper());
    zu();
  }
  
  public k zB() { return this.aIW; }
  
  public b zC() { return this.aIX; }
  
  protected abstract void zD();
  
  public aa zE() { return this.aIY; }
  
  protected abstract aa zF();
  
  protected LQKVersion.a zy() { return this.aIU; }
  
  @NonNull
  protected abstract LQKVersion.a zz();
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\basic\RootApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */