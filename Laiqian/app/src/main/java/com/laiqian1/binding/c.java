package com.laiqian.binding;

import android.view.View;
import com.laiqian.util.bd;

class c implements View.OnClickListener {
  c(BindingAlipayHelp paramBindingAlipayHelp) {}
  
  public void onClick(View paramView) {
    if (bd.bH(this.aJc)) {
      if (BindingAlipayHelp.b(this.aJc).getSettings().getCacheMode() != -1)
        BindingAlipayHelp.b(this.aJc).getSettings().setCacheMode(-1); 
    } else if (BindingAlipayHelp.b(this.aJc).getSettings().getCacheMode() != 1) {
      BindingAlipayHelp.b(this.aJc).getSettings().setCacheMode(1);
    } 
    for (View view : BindingAlipayHelp.c(this.aJc)) {
      boolean bool;
      if (view == paramView) {
        bool = true;
      } else {
        bool = false;
      } 
      view.setSelected(bool);
    } 
    String str = (String)paramView.getTag();
    BindingAlipayHelp.b(this.aJc).loadUrl(str);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\binding\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */