package com.laiqian.ui.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;

public class i {
  public static void a(Context paramContext, Configuration paramConfiguration) {
    if (paramConfiguration.hardKeyboardHidden == 1) {
      Toast.makeText(paramContext, paramContext.getString(R.string.input_keybord_close_msg), 1).show();
      try {
        InputMethodManager inputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
        if (inputMethodManager != null)
          inputMethodManager.showInputMethodPicker(); 
        return;
      } catch (Exception paramConfiguration) {
        a.e(paramConfiguration);
        try {
          Intent intent = new Intent();
          intent.setAction("android.intent.action.MAIN");
          intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.LanguageSettings"));
          paramContext.startActivity(intent);
          return;
        } catch (Exception paramConfiguration) {
          a.e(paramConfiguration);
          try {
            Intent intent = new Intent();
            intent.setAction("android.settings.INPUT_METHOD_SETTINGS");
            paramContext.startActivity(intent);
            return;
          } catch (Exception paramContext) {
            a.e(paramContext);
          } 
        } 
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\ui\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */