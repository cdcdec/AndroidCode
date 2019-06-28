package com.laiqian.ui.keybord;

import android.app.Activity;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.bs;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class d {
  final f dBB;
  
  public d(Activity paramActivity, EditText[] paramArrayOfEditText, KeyBoardLinearlayout paramKeyBoardLinearlayout, bs parambs) { this(paramActivity, paramArrayOfEditText, paramKeyBoardLinearlayout, parambs, null, null); }
  
  public d(Activity paramActivity, EditText[] paramArrayOfEditText, KeyBoardLinearlayout paramKeyBoardLinearlayout, bs parambs, ViewGroup.LayoutParams paramLayoutParams1, ViewGroup.LayoutParams paramLayoutParams2) {
    this.dBB = new f(paramActivity, paramArrayOfEditText, paramKeyBoardLinearlayout);
    this.dBB.a(parambs);
    this.dBB.i(paramLayoutParams1);
    this.dBB.j(paramLayoutParams2);
    int i = paramArrayOfEditText.length;
    byte b;
    for (b = 0; b < i; b++) {
      EditText editText = paramArrayOfEditText[b];
      int j = editText.getInputType();
      a(paramActivity, editText);
      if (this.dBB.arI() == editText)
        this.dBB.kY(j); 
      editText.setOnFocusChangeListener(new e(this, j));
    } 
  }
  
  public void a(Activity paramActivity, EditText paramEditText) {
    paramActivity.getWindow().setSoftInputMode(3);
    int i = Build.VERSION.SDK_INT;
    if (i >= 16) {
      String str = "setShowSoftInputOnFocus";
    } else if (i >= 14) {
      String str = "setSoftInputShownOnFocus";
    } else {
      paramActivity = null;
    } 
    if (paramActivity == null) {
      paramEditText.setInputType(0);
      return;
    } 
    try {
      Method method = EditText.class.getMethod(paramActivity, new Class[] { boolean.class });
      method.setAccessible(true);
      method.invoke(paramEditText, new Object[] { Boolean.valueOf(false) });
      return;
    } catch (NoSuchMethodException paramActivity) {
      paramEditText.setInputType(0);
      a.e(paramActivity);
      return;
    } catch (IllegalAccessException paramActivity) {
      a.e(paramActivity);
      return;
    } catch (IllegalArgumentException paramActivity) {
      a.e(paramActivity);
      return;
    } catch (InvocationTargetException paramActivity) {
      a.e(paramActivity);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\keybord\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */