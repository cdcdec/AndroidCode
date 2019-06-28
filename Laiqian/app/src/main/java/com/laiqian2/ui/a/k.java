package com.laiqian.ui.a;

import android.app.Activity;
import android.view.WindowManager;
import android.widget.PopupWindow;

final class k implements PopupWindow.OnDismissListener {
  public void onDismiss() {
    if (activity != null && !activity.isFinishing()) {
      WindowManager.LayoutParams layoutParams = activity.getWindow().getAttributes();
      layoutParams.alpha = 1.0F;
      activity.getWindow().setAttributes(layoutParams);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */