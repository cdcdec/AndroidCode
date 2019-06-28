package com.laiqian.meituan;

import android.text.TextUtils;
import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;

class v implements View.OnClickListener {
  v(t paramt) {}
  
  public void onClick(View paramView) {
    String str = RootApplication.getLaiqianPreferenceManager().awg();
    if (!"[]".equals(str) && !TextUtils.isEmpty(str)) {
      t.a(this.bqb, str);
      return;
    } 
    n.eP(R.string.no_phone_number_error);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */