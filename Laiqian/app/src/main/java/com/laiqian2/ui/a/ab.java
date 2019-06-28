package com.laiqian.ui.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.laiqian.infrastructure.R;
import com.laiqian.print.util.e;
import java.util.WeakHashMap;

public class ab extends Dialog {
  private static WeakHashMap<Activity, ab> dAk = new WeakHashMap();
  
  public ab(Context paramContext) {
    super(paramContext);
    getWindow().requestFeature(1);
    setContentView(R.layout.dialog_progress);
    getWindow().setGravity(17);
    getWindow().setBackgroundDrawableResource(17170445);
  }
  
  public static void N(Activity paramActivity) { e.i(new ac(paramActivity)); }
  
  public static void O(Activity paramActivity) { e.i(new ad(paramActivity)); }
  
  public static void P(Activity paramActivity) { e.i(new ae(paramActivity)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */