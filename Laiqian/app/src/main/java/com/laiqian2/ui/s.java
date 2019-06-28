package com.laiqian.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class s {
  public static <T extends View> T a(Activity paramActivity, int paramInt) { return (T)paramActivity.findViewById(paramInt); }
  
  public static <T extends View> T a(Window paramWindow, int paramInt) { return (T)paramWindow.findViewById(paramInt); }
  
  public static ViewGroup p(Window paramWindow) { return (ViewGroup)paramWindow.findViewById(16908290); }
  
  public static <T extends View> T z(View paramView, int paramInt) { return (T)paramView.findViewById(paramInt); }
  
  public void dq(View paramView) {
    ViewGroup.LayoutParams layoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams layoutParams1 = layoutParams2;
    if (layoutParams2 == null)
      layoutParams1 = new ViewGroup.LayoutParams(-1, -2); 
    int j = ViewGroup.getChildMeasureSpec(0, 0, layoutParams1.width);
    int i = layoutParams1.height;
    if (i > 0) {
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    } else {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
    } 
    paramView.measure(j, i);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */