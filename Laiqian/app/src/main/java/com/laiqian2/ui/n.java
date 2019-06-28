package com.laiqian.ui;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.util.bd;
import com.laiqian.util.ch;
import java.util.HashMap;

class n implements View.OnClickListener {
  n(m paramm) {}
  
  public void onClick(View paramView) {
    null = m.a(this.dwr).getText().toString().trim();
    if ("".equals(null) || null == null) {
      Toast.makeText(m.b(this.dwr), m.b(this.dwr).getString(R.string.pos_upgrade_please_enter_the_feedback_content), 1000).show();
      return;
    } 
    if (!bd.bH(m.b(this.dwr))) {
      Toast.makeText(m.b(this.dwr), m.b(this.dwr).getString(R.string.pos_upgrade_network_err), 1000).show();
      this.dwr.dismiss();
    } 
    null = (String)((HashMap)m.d(this.dwr).get(m.c(this.dwr))).get("feature");
    String str = m.a(this.dwr).getText().toString().trim();
    ch.a(m.b(this.dwr), this.dwr.handler, null, m.e(this.dwr), str);
    View view = this.dwr.getWindow().peekDecorView();
    if (view != null)
      ((InputMethodManager)m.b(this.dwr).getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0); 
    this.dwr.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */