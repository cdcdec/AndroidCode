package com.laiqian.util;

import android.content.ComponentName;
import eu.chainfire.libsuperuser.b;

public class af {
  public static void a(ComponentName paramComponentName) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dp set-active-admin ");
    stringBuilder.append(paramComponentName.flattenToString());
    b.g.tn(stringBuilder.toString());
  }
  
  public static void b(ComponentName paramComponentName) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dpm set-device-owner ");
    stringBuilder.append(paramComponentName.flattenToString());
    b.g.tn(stringBuilder.toString());
  }
  
  public static void c(ComponentName paramComponentName) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dpm remove-active-admin ");
    stringBuilder.append(paramComponentName.flattenToString());
    b.g.tn(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */