package com.laiqian.ui.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.util.ae;
import java.util.WeakHashMap;

public class j extends PopupWindow {
  private static final int aCt = R.layout.popup_message;
  
  private static WeakHashMap<Activity, j> dzp = new WeakHashMap();
  
  TextView bJv;
  
  public j(Context paramContext) {
    super(paramContext);
    View view = LayoutInflater.from(paramContext).inflate(aCt, null);
    setContentView(view);
    this.bJv = (TextView)view.findViewById(R.id.tv_msg);
    setHeight(ae.b(paramContext, 200.0F));
    setWidth(ae.b(paramContext, 400.0F));
    setWindowLayoutMode(-2, -2);
    setFocusable(true);
    setBackgroundDrawable(new ColorDrawable(false));
  }
  
  public static j a(Activity paramActivity, String paramString, View paramView) {
    j j1 = b(paramActivity, paramString);
    if (j1 == null)
      return null; 
    if (j1.isShowing()) {
      j1.dismiss();
      return j1;
    } 
    WindowManager.LayoutParams layoutParams = paramActivity.getWindow().getAttributes();
    layoutParams.alpha = 0.5F;
    paramActivity.getWindow().setAttributes(layoutParams);
    j1.showAsDropDown(paramView);
    return j1;
  }
  
  private static j b(Activity paramActivity, String paramString) {
    if (paramActivity == null || paramActivity.isFinishing())
      return null; 
    j j2 = (j)dzp.get(paramActivity);
    j j1 = j2;
    if (j2 == null) {
      j1 = new j(paramActivity);
      j1.setOnDismissListener(new k(paramActivity));
      dzp.put(paramActivity, j1);
    } 
    j1.setMessage(paramString);
    return j1;
  }
  
  public void setMessage(String paramString) { this.bJv.setText(paramString); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */