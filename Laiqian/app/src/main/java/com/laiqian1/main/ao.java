package com.laiqian.main;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import com.laiqian.util.l;
import com.laiqian.util.n;

public class ao {
  public static void a(Window.Callback paramCallback, ViewGroup paramViewGroup) {
    a a = new a(paramCallback, null);
    for (byte b = 0; b < paramViewGroup.getChildCount(); b++) {
      ViewGroup viewGroup = (ViewGroup)paramViewGroup.getChildAt(b);
      for (byte b1 = 0; b1 < viewGroup.getChildCount(); b1++) {
        View view = viewGroup.getChildAt(b1);
        if (view.getTag() != null)
          view.setOnClickListener(a); 
      } 
    } 
  }
  
  public static void a(Window paramWindow, EditText... paramVarArgs) {
    if (paramVarArgs == null)
      return; 
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      l.a(paramWindow, paramVarArgs[b]); 
  }
  
  public static void b(Window paramWindow, EditText... paramVarArgs) {
    if (paramVarArgs == null)
      return; 
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++)
      l.b(paramWindow, paramVarArgs[b]); 
  }
  
  private static class a implements View.OnClickListener {
    Window.Callback bbi;
    
    private a(Window.Callback param1Callback) { this.bbi = param1Callback; }
    
    public void onClick(View param1View) {
      KeyEvent keyEvent = new KeyEvent(0L, 0L, false, n.parseInt(param1View.getTag().toString()), false, 2097152);
      this.bbi.dispatchKeyEvent(keyEvent);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */