package com.laiqian.ui.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.laiqian.infrastructure.R;

class au implements View.OnClickListener {
  au(at paramat) {}
  
  public void onClick(View paramView) {
    String str = at.a(this.dAH).getText().toString();
    if (TextUtils.isEmpty(str)) {
      Toast.makeText(at.b(this.dAH), at.b(this.dAH).getString(R.string.code_could_not_be_empty), 0).show();
      return;
    } 
    if (at.c(this.dAH).b(paramView, str))
      this.dAH.dismiss(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */