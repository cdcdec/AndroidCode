package com.laiqian.ui.keybord;

import android.view.View;
import android.widget.EditText;

class b implements View.OnLongClickListener {
  b(a parama) {}
  
  public boolean onLongClick(View paramView) {
    EditText editText = a.a(this.dBA);
    if (editText != null) {
      editText.getText().clear();
      return true;
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\keybord\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */