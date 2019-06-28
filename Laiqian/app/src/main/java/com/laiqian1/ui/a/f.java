package com.laiqian.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.view.WindowManager;

public class f extends Dialog {
  public f(Context paramContext) { this(paramContext, 0); }
  
  public f(Context paramContext, int paramInt) {
    super(paramContext, paramInt);
    setDimAmout(0.3F);
  }
  
  public void setDimAmout(float paramFloat) {
    WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
    layoutParams.dimAmount = paramFloat;
    getWindow().setAttributes(layoutParams);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\ui\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */