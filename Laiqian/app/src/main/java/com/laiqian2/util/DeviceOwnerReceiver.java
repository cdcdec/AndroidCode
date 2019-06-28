package com.laiqian.util;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class DeviceOwnerReceiver extends DeviceAdminReceiver {
  public static ComponentName bT(Context paramContext) { return new ComponentName(paramContext.getApplicationContext(), DeviceOwnerReceiver.class); }
  
  public void onProfileProvisioningComplete(Context paramContext, Intent paramIntent) { ((DevicePolicyManager)paramContext.getSystemService("device_policy")).setProfileName(bT(paramContext), "Owner"); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\DeviceOwnerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */