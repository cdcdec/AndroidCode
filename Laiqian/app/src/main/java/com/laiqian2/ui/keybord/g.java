package com.laiqian.ui.keybord;

import android.inputmethodservice.KeyboardView;
import android.text.Editable;

class g implements KeyboardView.OnKeyboardActionListener {
  g(f paramf) {}
  
  public void onKey(int paramInt, int[] paramArrayOfInt) {
    f f1 = this.dBO.arI();
    if (f1 == null)
      return; 
    boolean bool = false;
    f1.playSoundEffect(0);
    Editable editable = f1.getText();
    int i = f1.getSelectionStart();
    int j = editable.length();
    if (paramInt == -9) {
      if ((f1 = this.dBO).a(this.dBO).getVisibility() == 8)
        bool = true; 
      f.a(f1, bool);
      return;
    } 
    if (paramInt == -3) {
      this.dBO.arJ();
      return;
    } 
    if (paramInt == -5) {
      if (editable != null && j > 0) {
        if (i > 0) {
          editable.delete(i - 1, i);
          return;
        } 
        if (i == 0 && f1.getSelectionEnd() == j) {
          editable.delete(0, j);
          return;
        } 
      } 
    } else {
      if (paramInt == -1) {
        f.b(this.dBO);
        f.c(this.dBO);
        return;
      } 
      if (i == 0 && j > 0 && f1.getSelectionEnd() == j)
        editable.delete(0, j); 
      editable.insert(i, Character.toString((char)paramInt));
      if (f.a(this.dBO).getVisibility() == 0)
        f.a(this.dBO, false); 
    } 
  }
  
  public void onPress(int paramInt) {}
  
  public void onRelease(int paramInt) {}
  
  public void onText(CharSequence paramCharSequence) {}
  
  public void swipeDown() {}
  
  public void swipeLeft() {}
  
  public void swipeRight() {}
  
  public void swipeUp() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\keybord\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */