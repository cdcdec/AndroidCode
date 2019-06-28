package com.laiqian.scanorder.settings;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.laiqian.scan_order_module.R;
import com.laiqian.util.n;

class g implements View.OnClickListener {
  g(f paramf) {}
  
  public void onClick(View paramView) {
    if (TextUtils.isEmpty(this.diN.aFf.getText().toString().trim())) {
      Toast.makeText(this.diN.getContext(), this.diN.getContext().getString(R.string.name_empty_tip), 0).show();
      return;
    } 
    if (TextUtils.isEmpty(this.diN.diJ.getText())) {
      Toast.makeText(this.diN.getContext(), this.diN.getContext().getString(R.string.amount_empty_tip), 0).show();
      return;
    } 
    try {
      String str = this.diN.aFf.getText().toString().trim();
      double d = Double.parseDouble(this.diN.diJ.getText().toString());
      int i = n.parseInt(String.valueOf(this.diN.diK.getTag()));
      if (this.diN.diE != null)
        this.diN.diE.a(this.diN, str, d, i); 
      return;
    } catch (Exception paramView) {
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */