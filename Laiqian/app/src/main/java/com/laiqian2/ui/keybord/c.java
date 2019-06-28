package com.laiqian.ui.keybord;

import android.view.View;
import android.widget.EditText;
import com.laiqian.infrastructure.R;

class c implements View.OnClickListener {
  c(a parama) {}
  
  public void onClick(View paramView) {
    EditText editText = a.a(this.dBA);
    if (editText != null) {
      int i = paramView.getId();
      if (i == R.id.one) {
        a.a(this.dBA, editText, "1");
        return;
      } 
      if (i == R.id.two) {
        a.a(this.dBA, editText, "2");
        return;
      } 
      if (i == R.id.three) {
        a.a(this.dBA, editText, "3");
        return;
      } 
      if (i == R.id.four) {
        a.a(this.dBA, editText, "4");
        return;
      } 
      if (i == R.id.five) {
        a.a(this.dBA, editText, "5");
        return;
      } 
      if (i == R.id.six) {
        a.a(this.dBA, editText, "6");
        return;
      } 
      if (i == R.id.seven) {
        a.a(this.dBA, editText, "7");
        return;
      } 
      if (i == R.id.eight) {
        a.a(this.dBA, editText, "8");
        return;
      } 
      if (i == R.id.nine) {
        a.a(this.dBA, editText, "9");
        return;
      } 
      if (i == R.id.zero) {
        a.a(this.dBA, editText, "0");
        return;
      } 
      if (i == R.id.dot) {
        a.a(this.dBA, editText, ".");
        return;
      } 
      if (i == R.id.delete)
        a.a(this.dBA, editText); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\keybord\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */