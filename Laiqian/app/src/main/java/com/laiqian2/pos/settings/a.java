package com.laiqian.pos.settings;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import java.lang.reflect.InvocationTargetException;

public class a {
  private WifiManager czn;
  
  public a(WifiManager paramWifiManager) { this.czn = paramWifiManager; }
  
  private Class<?> acR() {
    for (Class clazz : WifiManager.class.getDeclaredClasses()) {
      if (clazz.getSimpleName().equals("ActionListener"))
        return clazz; 
    } 
    return null;
  }
  
  public void a(WifiConfiguration paramWifiConfiguration) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException { this.czn.getClass().getDeclaredMethod("save", new Class[] { WifiConfiguration.class, acR() }).invoke(this.czn, new Object[] { paramWifiConfiguration, null }); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */