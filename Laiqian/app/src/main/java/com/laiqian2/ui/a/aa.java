package com.laiqian.ui.a;

import android.view.View;
import android.widget.CheckBox;
import com.laiqian.infrastructure.R;

class aa implements View.OnClickListener {
  aa(w.b paramb, CheckBox paramCheckBox, int paramInt) {}
  
  public void onClick(View paramView) {
    if (w.a(this.dAf.dAa) != null) {
      if (w.f(this.dAf.dAa)) {
        this.dAd.setChecked(this.dAd.isChecked() ^ true);
        w.c(this.dAf.dAa).setText(R.string.pos_quit_save_hint_dialog_sure);
      } 
      w.a(this.dAf.dAa).dL(this.dAe);
    } 
    if (!w.f(this.dAf.dAa) && w.i(this.dAf.dAa))
      this.dAf.dAa.dismiss(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */