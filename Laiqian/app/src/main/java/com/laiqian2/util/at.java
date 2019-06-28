package com.laiqian.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.laiqian.infrastructure.R;

public class at {
  public static void a(Activity paramActivity, Class<?> paramClass, Bundle paramBundle, int paramInt1, int paramInt2) {
    if (paramClass != null) {
      Intent intent = new Intent();
      intent.putExtras(paramBundle);
      intent.setClass(paramActivity, paramClass);
      paramActivity.startActivity(intent);
    } 
    if (paramActivity != null)
      paramActivity.overridePendingTransition(paramInt1, paramInt2); 
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2) { a(paramActivity, paramString1, paramString2, -1); }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putString("sWebUrlKey", paramString1);
    bundle.putString("sWebTitleKey", paramString2);
    bundle.putInt("sWebWidth", paramInt);
    a(paramActivity, WebViewContainer.class, bundle, R.anim.activity_in_bottom, R.anim.pos_nomove);
  }
  
  public static void c(Activity paramActivity, String paramString) { a(paramActivity, paramString, paramActivity.getString(R.string.pos_taodiandian_shop_Backstage)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */